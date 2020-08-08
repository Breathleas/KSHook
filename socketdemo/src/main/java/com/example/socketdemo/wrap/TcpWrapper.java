package com.example.socketdemo.wrap;

import android.util.Log;

import com.example.socketdemo.SCFeed.C19507b;
import com.example.socketdemo.SCFeed.CSEnterRoom;
import com.example.socketdemo.SCFeed.CSRaceLose;
import com.example.socketdemo.SCFeed.i;
import com.example.socketdemo.SCFeed.CSHorseRacing;
import com.example.socketdemo.util.Config;
import com.example.socketdemo.util.Utils;
import com.google.protobuf.nano.MessageNano;

import static com.example.socketdemo.util.Config.TAG;

public class TcpWrapper {
    //204
    public static String createCSHorseRacing(String mLiveStreamId){
        CSHorseRacing cSHorseRacing = new CSHorseRacing();
        cSHorseRacing.clientId = 2;
        cSHorseRacing.deviceId = Config.device_id;
        cSHorseRacing.isAuthor = Config.is_author;
        cSHorseRacing.locale = Config.locale;
        cSHorseRacing.operator = Config.operator;
        cSHorseRacing.liveStreamId = mLiveStreamId;
        cSHorseRacing.appVer = Config.app_ver;
        cSHorseRacing.horseTag = Config.horse_tag;
        cSHorseRacing.clientVisitorId = Config.client_visitor_id;
        cSHorseRacing.latitude = Config.latitude;
        cSHorseRacing.longitude = Config.longitude;


        i a = Utils.createNanoWrapper((MessageNano) cSHorseRacing,Config.CSHorseRacing);

//        Log.d(TAG, "createCSHorseRacing: a: {"+a+"}");

        String str = Utils.createNanoHex(a,Config.CSHorseRacing);

        return str;
    }

    //205 时间戳
    public static String createCSRaceLose(String time){
        CSRaceLose csRaceLose = new CSRaceLose();
//        long millis = System.currentTimeMillis();
        long l = Long.parseLong(time);
//        Log.d(TAG, "createCSRaceLose: 时间："+ l);
        csRaceLose.time = l;

        i a = Utils.createNanoWrapper(csRaceLose,Config.CSRaceLose);
//        Log.d(TAG, "createCSRaceLose: a: {"+a+"}");
        return Utils.createNanoHex(a,Config.CSRaceLose);

    }

    public static String createHeartBeat(long time){
        C19507b bVar2 = new C19507b();
        bVar2.f56310a = time;
        i a = Utils.createNanoWrapper(bVar2,Config.C19507b);
        return Utils.createNanoHex(a,Config.C19507b);
    }

    //200
    public static String createCSEnterRoom(String mLiveStreamId,String mExpTag,String mAttach,String authId){
        CSEnterRoom cSEnterRoom = new CSEnterRoom();
        cSEnterRoom.token = "";
        cSEnterRoom.clientId = 2;
        cSEnterRoom.deviceId = Config.device_id;
        cSEnterRoom.isAuthor = Config.is_author;
        cSEnterRoom.reconnectCount = 0;
        cSEnterRoom.lastErrorCode = 0;
        cSEnterRoom.locale = Config.locale;
        cSEnterRoom.location = Config.latitude + "," + Config.longitude;
        cSEnterRoom.operator = Config.operator;
        cSEnterRoom.liveStreamId = mLiveStreamId;
        cSEnterRoom.firstEnter = true;
        cSEnterRoom.appVer = Config.app_ver;
        cSEnterRoom.expTag = mExpTag;
        cSEnterRoom.attach = mAttach;
        cSEnterRoom.appType = 21;
        cSEnterRoom.sourceType = 42;
        cSEnterRoom.broadcastGiftToken = "";
        cSEnterRoom.redPackId = "";
        cSEnterRoom.serviceToken = "";
        cSEnterRoom.authorId = Long.parseLong(authId);

        i a = Utils.createNanoWrapper((MessageNano) cSEnterRoom,Config.CSEnterRoom);

//        Log.d(TAG, "createCSEnterRoom: a: {"+a+"}");

        String str = Utils.createNanoHex(a,Config.CSEnterRoom);

        return str;
    }
}
