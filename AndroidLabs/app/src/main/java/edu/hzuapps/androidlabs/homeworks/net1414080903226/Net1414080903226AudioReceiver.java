package edu.hzuapps.androidlabs.homeworks.net1414080903226;

import android.util.Log;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Net1414080903226AudioReceiver implements Runnable {
    public static final String TAG = "AudioReceiver";
    int port = 5656;// 接收的端口
    DatagramSocket socket;
    DatagramPacket packet;
    boolean isRunning = false;

    private byte[] packetBuf = new byte[1024];
    private int packetSize = 1024;

    public void startRecieving() {
        if (socket == null) {
            try {
                socket = new DatagramSocket(port);
                packet = new DatagramPacket(packetBuf, packetSize);
            } catch (Exception e) {
            }
        }
        new Thread(this).start();
    }

    public void stopRecieving() {
        isRunning = false;
    }

    private void release() {
        if (packet != null) {
            packet = null;
        }
        if (socket != null) {
            socket.close();
            socket = null;
        }
    }

    public void run() {
        AudioPlayer player = AudioPlayer.getInstance();
        player.startPlaying();

        isRunning = true;
        try {
            while (isRunning) {
                socket.receive(packet);
                player.addData(packet.getData(), packet.getLength());
            }

        } catch (Exception e) {
            Log.i(TAG, "run: receive error");
        }
        player.stopPlaying();
        release();
        Log.i(TAG, "run: stop receiving");
    }
}
