package edu.hzuapps.androidlabs.homeworks.net1414080903209;

/**
 * Created by Administrator on 2017/4/21.
 */

import java.io.*;
import java.net.*;

/**
 *
 * @author Administrator
 */
public class DownLoadThread extends Thread {

    private String urlLocation;
    private String filePath;
    private long start;
    private long end;
    private int threadID;
    private long currentPosition;
    public DownLoadThread(String UrlLocation,String FilePath,long Start,long End,int i)
    {
        this.urlLocation=UrlLocation;
        this.filePath=FilePath;
        this.start=Start;
        this.end=End;
        this.threadID=i;
        currentPosition = start;
    }
    @Override
    public void run() {
        try {
            if(new File(filePath+threadID).exists())
                start = Position.readPosition(filePath,threadID);
            HttpURLConnection conn = getConn(urlLocation);
            conn.setRequestProperty("Range", "bytes=" + start + "-" + end);
            if (conn.getResponseCode() == 206) {
                RandomAccessFile raf = new RandomAccessFile(filePath + getFileName(urlLocation), "rw");
                raf.seek(start);
                InputStream in = conn.getInputStream();
                int len = -1;
                byte[] buffer = new byte[1024 * 1024 * 3];
                while ((len = in.read(buffer)) != -1) {
                    raf.write(buffer, 0, len);
                    currentPosition += len;
                    Position.writePosition(filePath, threadID, currentPosition);
                }
                Position.delPosition(filePath, threadID);
                raf.close();
            }
        } catch (IOException ex) {
        }
    }

    public static long getContentLength(String urlLocation) throws IOException {
        long contentLength = 0;
        HttpURLConnection conn = getConn(urlLocation);
        if (conn.getResponseCode() == 200) {
            contentLength = conn.getContentLength();
        }
        return contentLength;
    }

    public static HttpURLConnection getConn(String urlLocation) throws IOException {
        URL url = new URL(urlLocation);
        //获取HttpURLConnection对象 打开链接
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");//设置发送get请求
        conn.setConnectTimeout(5000);//设置连接超时时间
        return conn;
    }

    public static String getFileName(String urlLocation) {
        String[] str = urlLocation.split("/");
        return str[str.length - 1];
    }
}
