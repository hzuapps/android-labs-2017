package edu.hzuapps.androidlabs.homeworks.net1414080903120.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Properties;

/**
 * Created by hzu on 2017/4/21.
 */

public class ChatUtil {
    public static boolean sendToServer(String text) {
        return false;
    }
}

interface Message {
    boolean send(OutputStream os);
}

class TextMessage implements Message{
    private String text;

    public TextMessage(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean send(OutputStream out) {
        PrintWriter pw = new PrintWriter(out);
        pw.println();
        return false;
    }
}

class Sender {
    private   String serverIP;
    private   int serverPort;
    private  Socket socket;

    public Sender() {
        Properties properties = new Properties();
        InputStream is = null;
        try {
            is = Object.class.getResourceAsStream("server.properties");
            properties.load(is);
            serverIP = properties.getProperty("server.ip");
            serverPort = Integer.parseInt(properties.getProperty("server.port"));
            socket =  new Socket(serverIP, serverPort);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static boolean send(TextMessage msg) {

        return true;
    }
}

