package edu.hzuapps.androidlabs.homeworks.net1414080903218;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.widget.Toast;

import static edu.hzuapps.androidlabs.homeworks.net1414080903218.ChessView.myContext;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.SocketException;
import java.net.URL;

/**
 * Created by zzh on 2017/4/14.
 */
class LoginService extends AsyncTask<Void,String,Boolean>{
    public Socket loginSocket;
    public BufferedReader in;
    public PrintWriter ou;
    public ChessView view;
    public LoginService(ChessView v){
        view = v;
    }
    @Override
    protected Boolean doInBackground(Void... params) {
        try {
            view.netFirst = false;
            loginSocket = new Socket("119.29.138.122",8824);
            in = new BufferedReader(new InputStreamReader(loginSocket.getInputStream()));
            ou = new PrintWriter(new BufferedWriter(new OutputStreamWriter(loginSocket.getOutputStream())), true);
            view.stats = 1;
            String string = in.readLine();
            if("first".equals(string)){
                view.netFirst = false;
                view.stats = 4;
            }
            if("later".equals(string)){
                view.netFirst = true;
                view.stats = 3;
                String str = in.readLine();
                publishProgress(str);
            }
            while (true){
                if(view.stats == 3) {
                    String str1 = in.readLine();
                    publishProgress(str1);
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
    @Override
    protected void onProgressUpdate(String... value){
        String[] strings = value[0].split(":");
        int r = Integer.valueOf(strings[0]);
        int c = Integer.valueOf(strings[1]);
        if(view.netFirst){
            view.controller.firstPlayer.putPiece(r,c);
        }
        else {
            view.controller.laterPlayer.putPiece(r,c);
        }
        view.stats = 4;
        if(view.controller.board.isGameover()){
            view.timer.cancel();
            if(view.controller.board.isFirstWin()){
                Toast.makeText(myContext,"黑方胜利！", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(myContext,"白方胜利！", Toast.LENGTH_SHORT).show();
            }
        }
        //Toast.makeText(myContext, value[0], Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPostExecute(Boolean result){
        Toast.makeText(myContext, "end", Toast.LENGTH_SHORT).show();
    }
    public void send(int r,int c){
        String str = Integer.valueOf(r)+":"+Integer.valueOf(c)+":"+"0";
        ou.println(str);
    }
}
