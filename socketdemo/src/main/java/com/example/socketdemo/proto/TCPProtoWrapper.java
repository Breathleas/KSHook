package com.example.socketdemo.proto;

import android.util.Log;

import com.example.socketdemo.CSEnterRoomOuterClass;
import com.example.socketdemo.CSHorseRacingOuterClass;
import com.example.socketdemo.SendTcpOuterClass;
import com.example.socketdemo.util.Config;
import com.example.socketdemo.util.Utils;
import com.google.protobuf.ByteString;

import static com.example.socketdemo.util.Config.TAG;

public class TCPProtoWrapper {
    //id = 204
    public static String createCSHorseRacing(String mLiveStreamId,int id){
        CSHorseRacingOuterClass.CSHorseRacing csHorseRacing = CSHorseRacingOuterClass.CSHorseRacing.newBuilder()
                .setAndroidId(Config.device_id)
                .setAppVer(Config.app_ver)
                .setClientId(2)
                .setLocale(Config.locale)
                .setLatitude(Config.latitude)
                .setLongitude(Config.longitude)
                .setOperator(Config.operator)
                .setStreamId(mLiveStreamId).build();
        byte[] bytes = csHorseRacing.toByteArray();

        Log.d(TAG, "createCSHorseRacing: 第一次编码数据："+Utils.bytesToHexString(bytes));

        String data = createProto(bytes, id);
        Log.d(TAG, "createCSHorseRacing: 字节："+data);

        return data;
    }

    // id = 200
    public static String createCSEnterRoom(String mLiveStreamId,String mExpTag,String mAttach,String authId,int id){

        CSEnterRoomOuterClass.CSEnterRoom csEnterRoom = CSEnterRoomOuterClass.CSEnterRoom.newBuilder()
                .setAppType(21)
                .setAppVer(Config.app_ver)
                .setAttach(mAttach)
                .setClientId(2)
                .setDeviceId(Config.device_id)
                .setExpTag(mExpTag)
                .setLiveStreamId(mLiveStreamId)
                .setAuthorId(Long.parseLong(authId))
                .setLocale(Config.locale)
                .setOperator(Config.operator)
                .setLocation(Config.latitude + "," + Config.longitude)
                .setSourceType(42)
                .setFirstEnter(true)
                .setIsAuthor(false).build();
        byte[] bytes = csEnterRoom.toByteArray();
        Log.d(TAG, "createCSHorseRacing: 第一次编码数据："+Utils.bytesToHexString(bytes));
        String data = createProto(bytes, id);
        Log.d(TAG, "createCSEnterRoom: 字节："+data);

        return data;
    }

    //id = 1
    public static String createHeartBeat(long time,int id){

        CSHorseRacingOuterClass.SendHeartBeat heartBeat = CSHorseRacingOuterClass.SendHeartBeat.newBuilder()
                .setTime(time).build();
        byte[] bytes = heartBeat.toByteArray();
        String data = createProto(bytes, id);
        Log.d(TAG, "createHeartBeat: 字节："+data);
        return data;
    }

    private static String createProto(byte[] bytes, int id){
        SendTcpOuterClass.SendTcp sendTcp = SendTcpOuterClass.SendTcp.newBuilder()
                .setA(id)
                .setB(1)
                .setC(ByteString.copyFrom(bytes)).build();
        String sendData = createTCPSendData(sendTcp.toByteArray(), id);

        assert sendData!=null;
        return sendData;

    }

    private static String createTCPSendData(byte[] bytes, int id) {
        String start = "011a2b3c0000000000000000000000";
        String nanoStr;
        switch (id){
            case Config.CSHorseRacingID:
                nanoStr = Utils.bytesToHexString(bytes);
                Log.d(TAG, "createTCPSendData: 数据部分："+nanoStr);
                //如果发送数据的 字节数组长度超过三位（一般不会），则需保证魔数+字节长度为32位
                start = start + Integer.toHexString(bytes.length);
                String horseRaceStr = start+nanoStr;
                Log.d(TAG, "createTCPSendData: 最终发送的第一次连接数据："+horseRaceStr);
                return horseRaceStr;
            case Config.CSEnterRoomID:
                start = start + Integer.toHexString(bytes.length);
                nanoStr = Utils.bytesToHexString(bytes);
                String enterRoomStr = start + nanoStr;
                Log.d(TAG, "createTCPSendData: 最终发送的第二次连接数据："+enterRoomStr);
                return enterRoomStr;
            case Config.HeartBeatID:
                String hexlen = Integer.toHexString(bytes.length);
                if (hexlen.equals("d")){
                    start = start + "0" + hexlen;
                }else {
                    start = start + hexlen;
                }
                nanoStr = Utils.bytesToHexString(bytes);
                String heartData = start + nanoStr;
                Log.d(TAG, "createTCPSendData: 最终发送的数据心跳："+heartData);
                return heartData;
            default:
                return null;
        }
    }

}
