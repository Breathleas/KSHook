package com.example.socketdemo;
import android.util.Log;

import com.example.socketdemo.util.Utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Arrays;


public class SocketClient {
    private final Socket mSocket;

    public static String connByteStart = "011a2b3c00000000000000000000005d08cc0110011a560a0b";
    public static String connByteEnd = "50025a18414e44524f49445f3665633637323166353164633532396262057a685f434e6a0b372e322e342e313332303271db6fed4449403f40799e7de5417a605e4082010457494649";
    public static String heartBeat = "011a2b3c00000000000000000000000d080110011a0708cea3dca1b72e";
    public static final String TAG = "SocketClient";


    public static void main(String[] args) throws IOException {
        SocketClient socket = new SocketClient("103.107.218.213",14000);
        socket.run();
    }


    public SocketClient(String host, int port) throws IOException {
        // 创建 socket 并连接服务器
        mSocket = new Socket(host, port);
    }

    public void run() throws IOException {
        Thread readerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                readResponse();
            }
        });
        readerThread.start();


        String streamId = "-P3F5GHeEa4";
        String hexString = Utils.stringToHexString(streamId);

        String sendInit = connByteStart+hexString+connByteEnd;

        Log.d(TAG, "socket: 发送tcp连接请求: "+sendInit);

        final byte[] bytes = Utils.toBytes(sendInit);

        Log.d(TAG, "socket: tcp连接请求字节"+ Arrays.toString(bytes));


        OutputStream out = mSocket.getOutputStream();
        out.write(bytes);

    }

    private void readResponse() {
        try {
            InputStream in = mSocket.getInputStream();
            byte[] buffer = new byte[1024];
            int n;
            while ((n = in.read(buffer)) > 0) {
                Log.i(TAG, "收到服务器的数据---:" + Utils.bytesToHexString(buffer));
                Log.i(TAG, "收到服务器的数据 byte---:" + Arrays.toString(buffer));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
