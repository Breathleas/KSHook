package com.example.socketdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.socketdemo.util.Config.TAG;

import com.example.socketdemo.proto.TCPProtoWrapper;
import com.example.socketdemo.util.Config;
import com.example.socketdemo.util.GlobleParam;
import com.example.socketdemo.util.Utils;
import com.example.socketdemo.wrap.TcpWrapper;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    public Button connBtn;
    public Button heartBtn;
    public TextView textView;


    final String host = "103.107.218.157";
    final int port = 80;
    public Socket socket = null;


    String time = "1596097677204";
    String streamID = "EYgdQn0TU6U";
    String authId = "1126852867";
    String extag = "1_a/2000098216452560050_slv0";
    String attach = "F5igmZy3fnyYkB/KIc5BnR+11gK6EzH2mjdQWsQSbptvCI1kRq904im/DjesGnmLajmlFYZc2TKCM7f4wGggkQ==";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connBtn = findViewById(R.id.connect);
        heartBtn = findViewById(R.id.heartbeat);
        textView = findViewById(R.id.tv);
        GlobleParam.getInstance().setActivity(this);
        GlobleParam.getInstance().setTextView(textView);


//        String heartBeat = TcpWrapper.createHeartBeat(Long.parseLong(time));
////
//        String heartBeat1 = TCPProtoWrapper.createHeartBeat(Long.parseLong(time), 1);
//        if (heartBeat.equals(heartBeat1)){
//            Log.d(TAG, "相等test : "+heartBeat);
//        }else {
//            Log.d(TAG, "不相等 test : "+heartBeat+" proto heart: "+heartBeat1);
//        }

        test();

        connBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Log.i(TAG, "启动客户端");
                            socket = new Socket(host,port);
                            socket.setKeepAlive(true);
                            socket.setTcpNoDelay(true);
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
//        heartBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                sendHeart();
//            }
//        });


    }

//    private void sendHeart() {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                OutputStream outputStream = null;
//                try {
//                    long millis = System.currentTimeMillis();
//                    Log.d(TAG, "socket: 当前时间戳："+millis);
//                    String heartbeat = TcpWrapper.createHeartBeat(millis);
//                    byte[] hearts = Utils.toBytes(heartbeat);
//                    Log.d(TAG, "socket: 发送tcp heartbeat: "+Utils.bytesToHexString(hearts));
////                    Log.d(TAG, "socket: tcp heartbeat连接请求字节"+ Arrays.toString(hearts));
//                    if (socket.isClosed()){
//                        Log.d(TAG, "发送心跳 socket关闭连接");
//                        return;
//                    }
//
//                    outputStream = socket.getOutputStream();
//                    outputStream.write(hearts);
//                    outputStream.flush();
//                    Log.i(TAG, " socket: 发送心跳");
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }).start();
//    }

    private void socket() {

//        testSocket();

        testProtoSocket();

    }

    private void testProtoSocket() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                readResponse();

            }
        }).start();

        try {
            //发送第一次连接   id = 204
            String csHorseRacing = TCPProtoWrapper.createCSHorseRacing(streamID, Config.CSHorseRacingID);

            Log.d(TAG, "socket: 发送tcp第一次连接请求: "+csHorseRacing);
            byte[] bytes1 = Utils.toBytes(csHorseRacing);
            Log.i(TAG, "发送第一次数据--写字节"+Arrays.toString(bytes1));
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(bytes1);
            outputStream.flush();
            Log.i(TAG, "完成");

            Thread.sleep(2000);

            //发送第二次连接   id = 200
            String csEnterRoom = TCPProtoWrapper.createCSEnterRoom(streamID, extag, attach, authId, Config.CSEnterRoomID);

            byte[] bytes2 = Utils.toBytes(csEnterRoom);
            Log.d(TAG, "socket: 发送tcp第二次连接请求: "+Utils.bytesToHexString(bytes2));
            Log.d(TAG, "socket: tcp第二次连接请求字节"+ Arrays.toString(bytes2));

            Log.i(TAG, "发送第二次数据--写字节");
            outputStream = socket.getOutputStream();
            outputStream.write(bytes2);
            outputStream.flush();
            Log.i(TAG, "完成");

            while (true){
                Thread.sleep(3000);

                long millis = System.currentTimeMillis();
                Log.d(TAG, "socket: 当前时间戳："+millis);
//                String heartbeat = TcpWrapper.createHeartBeat(millis);
                String heartBeat = TCPProtoWrapper.createHeartBeat(millis,Config.HeartBeatID);;
                byte[] hearts = Utils.toBytes(heartBeat);
                Log.d(TAG, "socket: 发送tcp heartbeat: "+Utils.bytesToHexString(hearts));
                Log.d(TAG, "socket: tcp heartbeat连接请求字节"+ Arrays.toString(hearts));
                outputStream = socket.getOutputStream();
                outputStream.write(hearts);
                outputStream.flush();
                Log.i(TAG, "完成");
            }



        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            Log.i(TAG, "客户端无法连接服务器: " + e);
        }

    }

    private void testSocket() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                readResponse();

            }
        }).start();

        try {
            //发送第一次连接
            String csHorseRacing = TcpWrapper.createCSHorseRacing(streamID);

            Log.d(TAG, "socket: 发送tcp第一次连接请求: "+csHorseRacing);
            byte[] bytes1 = Utils.toBytes(csHorseRacing);
            Log.i(TAG, "发送第一次数据--写字节"+Arrays.toString(bytes1));
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(bytes1);
            outputStream.flush();
            Log.i(TAG, "完成");

            Thread.sleep(2000);

            String csEnterRoom = TcpWrapper.createCSEnterRoom(streamID, extag, attach, authId);

            byte[] bytes2 = Utils.toBytes(csEnterRoom);
            Log.d(TAG, "socket: 发送tcp第二次连接请求: "+Utils.bytesToHexString(bytes2));
            Log.d(TAG, "socket: tcp第二次连接请求字节"+ Arrays.toString(bytes2));

            Log.i(TAG, "发送第二次数据--写字节");
            outputStream = socket.getOutputStream();
            outputStream.write(bytes2);
            outputStream.flush();
            Log.i(TAG, "完成");

            while (true){
                Thread.sleep(3000);

                long millis = System.currentTimeMillis();
                Log.d(TAG, "socket: 当前时间戳："+millis);
                String heartbeat = TcpWrapper.createHeartBeat(millis);
                byte[] hearts = Utils.toBytes(heartbeat);
                Log.d(TAG, "socket: 发送tcp heartbeat: "+Utils.bytesToHexString(hearts));
                Log.d(TAG, "socket: tcp heartbeat连接请求字节"+ Arrays.toString(hearts));
                outputStream = socket.getOutputStream();
                outputStream.write(hearts);
                outputStream.flush();
                Log.i(TAG, "完成");
            }



        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            Log.i(TAG, "客户端无法连接服务器");
        }

    }


    private void readResponse() {
            Log.d(TAG, "等待服务器响应: ");
        InputStream in = null;
        try {
            in = socket.getInputStream();


        while (true){
                Thread.sleep(500);
                int length = in.available();

                byte[] buffer = new byte[length];
                int n;
                Log.d(TAG, "readResponse: in.available(): "+length);
                while ((n = in.read(buffer)) > 0) {

                    String info = Utils.bytesToHexString(buffer);

//                    HandleRespData.handleStr(info);
                    HandleRespData.parseInfo(info);

                    Log.i(TAG, "收到服务器的数据---:" + info);
                    break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            Log.d(TAG, "IOException: " + e.getMessage());
        }
    }

    private void test(){


        String info = "0a5c0a2439326433613563392d636332332d343866372d393766382d303835616665663566613461121508ebb4e0ee05120ae985b1e985b15e4f5e691a014d1887baaf9cba2e2203e593872887baaf9cba2e3a087a734a3065673d3d52000a730a2435383833386132632d376231652d343435642d616563612d39306130663965396530356312170885d385cb07120ce6ada6e6b189e58aa0e6b2b91a014d18fcc8af9cba2e2218e69893e7838ae58d83e78eba51203131323738393737353428fcc8af9cba2e3a087871567971413d3d52000a640a2432366636623934632d393461612d346664622d393064352d323035613536333136643234121408ada294a2031209e99d993333363935381a014618a9d4af9cba2e220ce68891e5969ce6aca2e4bda028a9d4af9cba2e3a086a71583934413d3d52000a81010a2432643531666536642d333937622d343365302d616136312d613836303934666538376665122b08befbc7d3041212e6a4b0e6b181e7b3afe7b1b3e9a5ade380821a01464a0c47434834383233313630383118dfe8af9cba2e2212e8bf99e8b081e9a1b6e5be97e4bd8fe5958a28dfe8af9cba2e3a082b475a614c513d3d52000a710a2465653632373538352d343933612d343365392d383536342d343662646662376636323232121c0886c2e6b0051211e781abe5bdb1e5bf8de8808532323138381a014d18caecaf9cba2e2211e4b8bbe692ade4bda0e9a398e4ba867e7e28caecaf9cba2e3a08764b306c64513d3d520028ca0230e6943238025a03333330620538322e3277e801b196b09cba2e";
        //解压前字符串
        String str = "011a2b3c00000000000000000000023208b60210021aa3041f8b080000000000000025d0cf6b1341140770d3185c975c3a2886e24124878532657776667726d0830856aa22f52052a430bb3b23162fa1e0af43692c693550455b6b0b156afc01a2a1592ba291b4e045a9c77a5730bb4950fc07f4e06617e630cc7bbccff78d7a51cd33e4999cb80cba2e3221a6d286cc9614ea94702924911c737050f9f5f6c79f0c50bb653f3a1367272e0fa4cee4e61b1b6b8da1a3e960715e4bee05e5e6d4a82e2e0d0f9fdba34ea97942a9493972a1ed1802624c3cc885cb21d3b92e996042272e38a49477cb5ff7816c587b11fa7782ca7af8e6436ffebf2ff1fc5cb8b2d89ead040bb3edbb8db12386816cca6c9b602d692828d78be76f148fc5a8a7e691252d87611732cc39c4d27322cf2310e98413cb342c0f617040a95597aa69b0bffb78d5342d46e840ea44eee5b758cc86b7ef07cb6be1eb6aabb9ae258f0565b27881e14429a522c623861496074d663b109b42879c5b06e4d4d2199682da52804165ebefe7ddbd0084cfeaa15f6a6f6eb4fdcdeef3dacf995b91379a1d397e12531465d2a991fbde8975d0d95eedd44bdd27ef82ad47ade6bde061454b4a056570649c9f1e8b3314d5bc1016b20925103393f7223048898521b61c4f3ab6b41042e0b032f729ac67407fbbf42a68fac1f64267a68c904169ef8f777ec7667febfdc7f0412d5ab7fb74a5d5989b9ed6924a41b97a4abfe2c5a4b6d3a7874b88f68da74d537732140da16b9d94bf5c8f1aff039e9701884d02000020b196b09cba2e";

        String shortData = "011a2b3c00000000000000000000008d08b60210011a7f0a60122f08b8fea9f50412125446424f5953e9a5ade59ba2e5ae98e58d9a1a014d4a105446424f59537466626f79733132303518b096b09cba2e221ce587afe6ba90e78eba4d562be79bb4e692ad2be5b08fe9bb91e5b18b3a084e68303841773d3d28ca0230e6943238025a03333330620538322e3277e801b096b09cba2e20b096b09cba2e";
//        String zipToProto = HandleRespData.splitGZipToProto(str);
//        byte[] bytes = Utils.toBytes(zipToProto);
        String pk = "2802300e4a82010a2436333130346431622d303365342d343630362d386234622d366566616136626532393232122508b9bf051212e5bfabe6898be5ae98e696b9e5b890e58fb71a01464a086b75616973686f7518e0fca892bb2e2227e4b8bbe692ade58db3e5b086e4b88ee4ba91e8889fe8a385e4bfaee8bf9be8a18ce5afb9e6889828882738015a013262023134e801e0fca892bb2e";

//        HandleRespData.parseInfo(str);
        try {
            HandleRespData.printProtoFeed(Utils.toBytes(pk));
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }


/**author_id: 0
 comment_feeds <
 content: "\u54c7"
 device_hash: "zsJ0eg=="
 id: "92d3a5c9-cc23-48f7-97f8-085afef5fa4a"
 is_koi: false
 landscape_font_color: ""
 live_assistant_type: 0
 sender_state <
 assistant_type: 0
 fans_group_intimacy_level: 0
 is_from_fans_top: false
 is_koi: false
 wealth_grade: 0
 >
 sort_rank: 1596176719111
 time: 1596176719111
 user <
 a: 1574443627
 b: "\u9171\u9171^O^i"
 c: "M"
 d: ""
 f: false
 g: ""
 i: ""
 >
 >
 comment_feeds <
 content: "\u6613\u70ca\u5343\u73baQ 1127897754"
 device_hash: "xqVyqA=="
 id: "58838a2c-7b1e-445d-aeca-90a0f9e9e05c"
 is_koi: false
 landscape_font_color: ""
 live_assistant_type: 0
 sender_state <
 assistant_type: 0
 fans_group_intimacy_level: 0
 is_from_fans_top: false
 is_koi: false
 wealth_grade: 0
 >
 sort_rank: 1596176721020
 time: 1596176721020
 user <
 a: 2036427141
 b: "\u6b66\u6c49\u52a0\u6cb9"
 c: "M"
 d: ""
 f: false
 g: ""
 i: ""
 >
 >
 comment_feeds <
 content: "\u6211\u559c\u6b22\u4f60"
 device_hash: "jqX94A=="
 id: "26f6b94c-94aa-4fdb-90d5-205a56316d24"
 is_koi: false
 landscape_font_color: ""
 live_assistant_type: 0
 sender_state <
 assistant_type: 0
 fans_group_intimacy_level: 0
 is_from_fans_top: false
 is_koi: false
 wealth_grade: 0
 >
 sort_rank: 1596176722473
 time: 1596176722473
 user <
 a: 876941613
 b: "\u9759336958"
 c: "F"
 d: ""
 f: false
 g: ""
 i: ""
 >
 >
 comment_feeds <
 content: "\u8fd9\u8c01\u9876\u5f97\u4f4f\u554a"
 device_hash: "+GZaLQ=="
 id: "2d51fe6d-397b-43e0-aa61-a86094fe87fe"
 is_koi: false
 landscape_font_color: ""
 live_assistant_type: 0
 sender_state <
 assistant_type: 0
 fans_group_intimacy_level: 0
 is_from_fans_top: false
 is_koi: false
 wealth_grade: 0
 >
 sort_rank: 1596176725087
 time: 1596176725087
 user <
 a: 1248984510
 b: "\u6930\u6c41\u7cef\u7c73\u996d\u3002"
 c: "F"
 d: ""
 f: false
 g: ""
 i: "GCH482316081"
 >
 >
 comment_feeds <
 content: "\u4e3b\u64ad\u4f60\u98d8\u4e86~~"
 device_hash: "vK0ldQ=="
 id: "ee627585-493a-43e9-8564-46bdfb7f6222"
 is_koi: false
 landscape_font_color: ""
 live_assistant_type: 0
 sender_state <
 assistant_type: 0
 fans_group_intimacy_level: 0
 is_from_fans_top: false
 is_koi: false
 wealth_grade: 0
 >
 sort_rank: 1596176725578
 time: 1596176725578
 user <
 a: 1444520198
 b: "\u706b\u5f71\u5fcd\u800522188"
 c: "M"
 d: ""
 f: false
 g: ""
 i: ""
 >
 >
 display_like_count: "82.2w"
 display_watching_count: "330"
 like_count: 821862
 pending_like_count: 2
 push_interval: 0
 time: 1596176730929
 watching_count: 330*/

// printProtoFeed:弹幕 User:  name: 酱酱^O^i
// printProtoFeed:弹幕 content: 哇
// printProtoFeed:弹幕 User:  name: 武汉加油
// printProtoFeed:弹幕 content: 易烊千玺Q 1127897754
// printProtoFeed:弹幕 User:  name: 静336958
// printProtoFeed:弹幕 content: 我喜欢你
// printProtoFeed:弹幕 User:  name: 椰汁糯米饭。
// printProtoFeed:弹幕 content: 这谁顶得住啊
// printProtoFeed:弹幕 User:  name: 火影忍者22188
// printProtoFeed:弹幕 content: 主播你飘了~~
// printProtoFeed: authorId: 0
//                 displayLikeCount: 82.2w
//                 displayWatchingCount: 330
//                 watchingCount: 330
//                 pendingLikeCount: 2


    }


}
