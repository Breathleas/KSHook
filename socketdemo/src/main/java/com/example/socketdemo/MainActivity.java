package com.example.socketdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.socketdemo.util.Utils;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    public Button connBtn;
    public Button heartBtn;


    public static String send1_head = "011a2b3c00000000000000000000005d08cc0110011a560a0b";
    public static String send1_tail = "50025a18414e44524f49445f3665633637323166353164633532396262057a685f434e6a0b372e322e342e313332303271db6fed4449403f40799e7de5417a605e4082010457494649";
    public static String heartBeat = "011a2b3c00000000000000000000000d080110011a0708ef8ae1fbb72e";

    public static String send2_1 = "011a2b3c0000000000000000000000"    +   "ce08c80110011ac6";
    public static String send2_id = "0110021a18414e44524f49445f36656336373231663531646335323962220b";
    public static String send2_ver = "42057a685f434e4a0b372e322e342e3133323032521433312e3235313037322c3132312e3530373433335a045749464960016a1c";
    public static String send2_exp_tag = "1_a/2000081094925786657_scn0";
    public static String send2_exp_2 = "7240";
    public static String send2_attach = "Zzq4IzVrmKEBabf59ZNTceX1grvZzRxxnrc4xuCtwjZ5wcHzywDo/Z4DrKhXPlIDRUsXbbP2GcK3gdq9guj2BA==";
    public static String send2_other = "781580012aa001a4ce874e";



    String streamId = "vIAB5fzuHSE";
    final String host = "103.102.201.11";
    final int port = 80;
    public Socket socket = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connBtn = findViewById(R.id.connect);
        heartBtn = findViewById(R.id.heartbeat);




        connBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Log.i(TAG, "启动客户端");
                            socket = new Socket(host,port);
//                            socket.setKeepAlive(true);
//                            socket.setTcpNoDelay(true);
                            Log.i(TAG, "客户端连接成功");
                            boolean connected = socket.isConnected();
                            Log.i(TAG,"isConnected: "+ connected);

                        } catch (IOException e) {
                            e.printStackTrace();
                            Log.i(TAG, "客户端连接失败");
                        }
                        socket();
                    }
                }).start();


            }
        });
        heartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendHeart();
            }
        });
//
//            try {
//                test();
//            } catch (InvalidProtocolBufferNanoException e) {
//                e.printStackTrace();
//            }




    }

    private void sendHeart() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                OutputStream outputStream = null;
                try {
                    byte[] bytes = heartBeat.getBytes();
                    if (socket.isClosed()){
                        Log.d(TAG, "发送心跳 socket关闭连接");
                        return;
                    }

                    outputStream = socket.getOutputStream();
                    outputStream.write(bytes);
                    outputStream.flush();
                    Log.i(TAG, " socket: 发送心跳");

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

    private void socket() {

        String hexString = Utils.stringToHexString(streamId);
        String sendInit = send1_head +hexString+ send1_tail;


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    readResponse();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();


        try {


//            final byte[] send1Byte = Utils.toBytes(sendInit);
            final byte[] send1Byte = Utils.toBytes("011a2b3c00000000000000000000005d08cc0110011a560a0b7649414235667a7548534550025a18414e44524f49445f3665633637323166353164633532396262057a685f434e6a0b372e322e342e313332303271faf02c4146403f407951fa42c879605e4082010457494649");
//            final byte[] send1Byte = Utils.toBytes("011a2b3c00000000000000000000005d08cc0110011a560a0b7164586d53413957456b5550025a18414e44524f49445f3665633637323166353164633532396262057a685f434e6a0b372e322e342e313332303271faf02c4146403f407951fa42c879605e4082010457494649");
            Log.d(TAG, "socket: 发送tcp第一次连接请求: "+Utils.bytesToHexString(send1Byte));
            Log.d(TAG, "socket: tcp第一次连接请求字节"+ Arrays.toString(send1Byte));

            Log.i(TAG, "发送第一次数据--写字节");
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(send1Byte);
            outputStream.flush();
            Log.i(TAG, "完成");

            Thread.sleep(2000);

            String send2 = send2_1 +send2_id + hexString + send2_ver + Utils.stringToHexString(send2_exp_tag)+send2_exp_2 + Utils.stringToHexString(send2_attach) + send2_other;

//            final byte[] send2Byte = Utils.toBytes(send2);
            final byte[] send2Byte = Utils.toBytes("011a2b3c0000000000000000000000e708c80110011adf0110021a18414e44524f49445f36656336373231663531646335323962220b7649414235667a7548534542057a685f434e4a0b372e322e342e3133323032521433312e3235313037322c3132312e3530373433335a045749464960016a1c315f612f323030303038313039343932353738363635375f73636e3072585a7a7134497a56726d4b454261626635395a4e54636558316772765a7a5278786e72633478754374776a5a357763487a7977446f2f5a3444724b6858506c4944525573586262503247634b336764713967756a3242413d3d781580012aa001f7d79daf05");
//            final byte[] send2Byte = Utils.toBytes("011a2b3c0000000000000000000000e508c80110011add0110021a18414e44524f49445f36656336373231663531646335323962220b7164586d53413957456b5542057a685f434e4a0b372e322e342e3133323032521433312e3235313037322c3132312e3530373433335a045749464960016a1c315f612f323030303038303939323637303436333837335f73636e307258684c514d735a3861325244504235707731304869396e33716d6364646b347334424c4f76434541763563485333682f7152667470573452753447656a5568396f6c6c61546e48757a6854413048736e6d56496f5776773d3d781580012aa001bbf37d");
            Log.d(TAG, "socket: 发送tcp第二次连接请求: "+Utils.bytesToHexString(send2Byte));
            Log.d(TAG, "socket: tcp第二次连接请求字节"+ Arrays.toString(send2Byte));

            Log.i(TAG, "发送第二次数据--写字节");
            outputStream = socket.getOutputStream();
            outputStream.write(send2Byte);
            outputStream.flush();
            Log.i(TAG, "完成");

            Thread.sleep(2000);

            byte[] bytes = heartBeat.getBytes();
            Log.i(TAG, "发送心跳");
            outputStream = socket.getOutputStream();
            outputStream.write(bytes);
            outputStream.flush();
            Log.i(TAG, "完成");

//            PrintWriter pw = new PrintWriter(socket.getOutputStream());
//            InputStream inputStream = socket.getInputStream();
//            byte[] buffer = new byte[1024];
//            int len = -1;
//            while ((len = inputStream.read(buffer)) != -1) {
////                        String data = new String(buffer, 0, len);
//                Log.i(TAG, "收到服务器的数据---:" + Utils.bytesToHexString(buffer));
//                Log.i(TAG, "收到服务器的数据 byte---:" + Arrays.toString(buffer));
//            }
//            Log.i(TAG, "客户端断开连接");
////                    pw.close();


        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            Log.i(TAG, "客户端无法连接服务器");
        }
    }


    private void readResponse() {
        try {
            Log.d(TAG, "等待服务器响应: ");
            InputStream in = socket.getInputStream();
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

    private void test() throws InvalidProtocolBufferNanoException {
//        byte[] bytes = { 10, 79, 18, 34, 8, -118, -87, -31, -119, 4, 18, 12, -27, -89, -102, -27, -89, -102, -26, -67, -82, -23, -90, -122, 26, 1, 70, 74, 9, 89, 89, 72, 45, 45, 45, 45, 45, 45, 24, -124, -21, -14, -73, -75, 46, 34, 24, -26, -106, -80, -26, -84, -66, -27, -92, -102, -27, -92, -102, -17, -68, -116, -25, -101, -76, -26, -110, -83, -28, -72, -83, 58, 8, 78,
//                104, 48, 56, 65, 119, 61, 61, 40, 4, 48, 2, 90, 1, 52, 98, 1, 50, -24, 1, -124, -21, -14, -73, -75, 46};

        byte[] bytes ={40, 11, 48, 5, 90, 2, 49, 50, 98, 1, 53, -56, 1, -92, -50, -121, 78, -30, 1, 88, 10, 36, 101, 52, 57, 102, 54, 99, 56, 55, 45, 55, 52, 98, 102, 45, 52, 48, 56, 101, 45, 97, 50, 49, 57, 45, 48, 102, 53, 48, 98, 100, 52, 53, 57, 53, 48, 52, 18, 20, 8, -50, -55, -86, 108, 18, 10, -25, -121, -107, -27, -124, -65, 53, 52, 54, 57, 26, 1, 70, 24, -110, -19, -45, -45, -73, 46, 32, 3, 40, -109, -19, -45, -45, -73, 46, 58, 8, 81, 48, 69, 101, 98, 119, 61, 61, 74, 0, -24, 1, -79, -5, -45, -45, -73, 46};
//        String str = "0a1f8b0800000000000000ad966f6c13651cc7f3ac91340791718989ee85e185af88f6eeb9ebf58f09895daee8963cd78c5cc9e69ba6b9d1ebae03a61bb63d8414e90426ffe6601b7f268a40183886b2a5a38c14634c8c8417c6a0d1c4843fbb6ba731bc21be30c6f87bbab6c3806ec9f6a2bda7bd379fdfeff7fd7dbf0f3389982f9073f0c3db130ef659eb83825518b6f7f563bfcf2d35a00deb0611b326dad921b8a2ae74aa638bdeedd2b66d613328ded3d3f52ac73df18adb1edf1c6de7028d9cc0631fc7bb39decf61816b2446201592033c9113297a56d4f658480d62c5684a13b54d68359b63d1d75bdc2179534c313577a4db6574e9aff19b23fcb608df1991f8387c92119ff496abfb6d8d39899861e4fce6c6f7771d2c53ea1b2fe6f70a92c74d993373ccaf74e1c79913f3c8ff7ef338b2c073bcc4612f877119394de40026aa96226a182b6a3c46d44012ca481219feebf4a55b857882182db8d5d444455fbf7e0e9bf90a31379173f7addf5476b57deaa895fba894d96d9dbf66650bcbd15589e3058ef7d6ba8a89dc9454cc1649911540d4c490da642a7258ac74d554d4e61869a9e2fd67579b57c5b747531d5bfd222f0a7e2657c74cd4397ffaf5c7813ab6be347578f6e4456bfcba7da657943cb85c47ddd3ead8b5a832bcb4005046551c8a191089da44c5e126ea8698a26a6edaf590dc86abe22046734c9175fe7f8b6858641f970f60477c673cb223b9735e9dd388b9869c5f8e8e5f75b0cfcd4c1d9c99cad81fe78a27b2335383c563073c6e7ec932f073bc8fc33c07873919a8149b3ec312311be97299442602e0a62af8a222c763a1c08232600a082a70f61d397b07b1cfdb53bd205b2c62f7ddcf2e3e9cdeb7f6d6f0bdc963b78697a302e8bec809b856015801814f002bd406e41691183a2646d85da980279b7cf05e5bb082397bb0fbec630e76f5ecc058e9f29599fc21abb0c7eb2bfbdabb4fb3087d311641f7cfc70912ed7d75ff4017e114eca0448c4db1904ccf4189a8c164155b9137c68899302bf6308498a3c8f9c7d0f54f1ceccae2c4a552dff1d2c07e415822999ffa2d96e6fd5605bf5581c6089bc4e804320d1aabd306a75bcd0d940c2bf02426912a643711730339ff7eef974f1dec0bbbaccb23a5a1c3d6b9abd6d8284cbe7868d03eb5efe1f4fee518bd9713dc74fa555218754b8a98415151690ff5243108789a9eaef45008a96f82b705f142a3cf216602397f3f3b9675b0f5d660b6b47f9c2e5e3eef16f0b2641aa63b27cc4f1fc221418302c837027910a64d8056336bae61d2e9eb0b66da08624e20e70f5ffff56805bb0a0ba23576daca5d00bf6d40e1a5a61aac19408bb554034100b41986e8806850754837f86d2492d55453644d6a351358a9c506730a31c791f3e6f1db8f105b3f3bd66bf59d046d4067fd921b2f4dbb14d1c3093e7a5da8220ab0fcc9b23220781535980ea96d12245b75abd2141d5cbaa208662bd3e9bc3374f9f40af645ebe0ee99fc81e2d1eba0dabbd7faef67ceac75ad856f3897e54bd6059835dd3dd19e0eed71d4972ba84fbce1ba31d7c1b56f8e711439b2c5d5b55567ae20660c397f9eb00f3dc3be649f189cc9bf6f9d1d2d8ee64b032370b627730f324766f7f6db67ce17cf9d7b90e9a7635cda7a7ba8fa78beb63402180ddc45827047e984291291984d70b5020fad4e11fb78c54854277809311740617f7e3754c7b2f69e5e3bf7f9fd91ecc3a9c3c5e9617bb277e933f4528d556e26e59d98db627ac76b8759e910473445837cc57f40728d60f45a720eb079a5ae4b5eaf207824bf001ec9f4236776e4db7b08eea6853d76b6b08da4cc375a13094afaced348a38b6aa5b7bc101e0e7b6ad90f0bd196528c20906ea444109e1a0667acfa8f48ef4f94b1bebea10e7bfe01b815f85f390b0000";
//        byte[] bytes = Utils.toBytes(str);
//        Log.d(TAG, "test bytes: "+Arrays.toString(bytes));
//
        String s = Utils.bytesToHexString(bytes);
//
//        SCFeedPush scFeedPush = SCFeedPush.parseFrom(bytes);
        Log.d(TAG, "test: "+s);

    }
}
