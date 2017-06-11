package edu.hzuapps.androidlabs.homeworks.net1414080903226;

import android.util.Log;

import com.chenyirun.theircraft.audio.AudioData;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Net1414080903226AudioSender implements Runnable {
    private static final String TAG = "AudioSender";
    private boolean isSending = false;
    private List<AudioData> dataList;

    DatagramSocket socket;
    DatagramPacket dataPacket;
    private InetAddress ip;
    private int port;

    public AudioSender(String string_ip) {
        dataList = Collections.synchronizedList(new LinkedList<AudioData>());
        try {
            ip = InetAddress.getByName(string_ip);
            Log.i(TAG, "AudioSender: target ip:"+ip.toString());
            port = 5656;
            socket = new DatagramSocket();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addData(byte[] data, int size) {
        AudioData encodedData = new AudioData();
        encodedData.setSize(size);
        byte[] tempData = new byte[size];
        System.arraycopy(data, 0, tempData, 0, size);
        encodedData.setRealData(tempData);
        dataList.add(encodedData);
    }

    private void sendData(byte[] data, int size) {
        try {
            dataPacket = new DatagramPacket(data, size, ip, port);
            dataPacket.setData(data);
            Log.i(TAG, "sendData: "+data.length);
            socket.send(dataPacket);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startSending() {
        new Thread(this).start();
    }

    public void stopSending() {
        this.isSending = false;
    }

    public void run(){
        this.isSending = true;
        Log.i(TAG, "run: start");
        while (isSending) {
            if (dataList.size() > 0) {
                AudioData encodedData = dataList.remove(0);
                sendData(encodedData.getRealData(), encodedData.getSize());
            }
        }
        Log.i(TAG, "run: stop");
    }
}
