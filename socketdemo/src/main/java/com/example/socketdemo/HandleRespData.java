package com.example.socketdemo;

import android.app.Activity;
import android.util.Log;
import android.widget.TextView;

import com.example.socketdemo.SCFeed.SCFeedPush;
import com.example.socketdemo.util.GlobleParam;
import com.example.socketdemo.util.Utils;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;

import java.util.List;

import static com.example.socketdemo.util.Config.TAG;

public class HandleRespData {

    public static void parseInfo(String info){

        String toProto = splitStrToProto(info);
        try {
            printProtoFeed(Utils.toBytes(toProto));
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, "handleStr短字符串失败， 解析压缩字符串 ");
            toProto = splitGZipToProto(info);
            if (toProto == null)
                return;
            Log.d(TAG, "handleStr: 解压缩后字符串："+toProto);
            try {
                printProtoFeed(Utils.toBytes(toProto));
            } catch (Exception ex) {
                ex.printStackTrace();
                Log.d(TAG, "handleStr: 字符串解析失败 "+ex);
            }
        }

    }


    public static void printProtoFeed(byte[] bytes) throws InvalidProtocolBufferException {

            SCFeedOuterClass.SCFeed scFeed = SCFeedOuterClass.SCFeed.parseFrom(bytes);
            Log.d(TAG, "printProtoFeed: "+scFeed);
            //弹幕信息
            List<SCFeedOuterClass.SCFeed.CommentFeed> commentFeedList = scFeed.getCommentFeedList();
            for (SCFeedOuterClass.SCFeed.CommentFeed feedList :commentFeedList) {
                List<SCFeedOuterClass.SCFeed.CommentFeed.User> users = feedList.getUserList();
                for (SCFeedOuterClass.SCFeed.CommentFeed.User user :users) {
                    String name = user.getName();
                    Log.d(TAG, "printProtoFeed:弹幕 User:  name: "+name);
                }
                String content = feedList.getContent();
                Log.d(TAG, "printProtoFeed:弹幕 content: "+content);
            }

            List<SCFeedOuterClass.SCFeed.EnterRoomFeed> enterRoomFeedList = scFeed.getEnterRoomFeedList();
            for (SCFeedOuterClass.SCFeed.EnterRoomFeed enterRoomFeed :enterRoomFeedList) {
                List<SCFeedOuterClass.SCFeed.EnterRoomFeed.User> userList = enterRoomFeed.getUserList();
                for (SCFeedOuterClass.SCFeed.EnterRoomFeed.User user :userList) {
                    String name = user.getName();
                    Log.d(TAG, "printProtoFeed: 进入房间："+name);
                }

            }


            //礼物信息
            List<SCFeedOuterClass.SCFeed.GiftFeed> giftFeedList = scFeed.getGiftFeedList();
            for (SCFeedOuterClass.SCFeed.GiftFeed giftFeed :giftFeedList) {
                int giftId = giftFeed.getGiftId();
                long giftType = giftFeed.getGiftType();
                int rank = giftFeed.getRank();
                List<SCFeedOuterClass.SCFeed.GiftFeed.User> users = giftFeed.getUserList();
                for (SCFeedOuterClass.SCFeed.GiftFeed.User user :users) {
                    String name = user.getName();
                    long id = user.getId();
                    Log.d(TAG, "printProtoFeed:礼物信息 user: name: "+ name+" id: "+id+" giftId -- "+giftId+" giftType -- "+giftType+" rank -- "+rank);
                }
            }

            long watchingCount = scFeed.getWatchingCount();
            String displayLikeCount = scFeed.getDisplayLikeCount();
            String displayWatchingCount = scFeed.getDisplayWatchingCount();
            long authorId = scFeed.getAuthorId();
            long pendingLikeCount = scFeed.getPendingLikeCount();
            Log.d(TAG, "printProtoFeed: authorId: "+authorId+"\n"+
                    "displayLikeCount: "+displayLikeCount+"\n"+
                    "displayWatchingCount: "+displayWatchingCount+"\n"+
                    "watchingCount: "+watchingCount+"\n"+
                    "pendingLikeCount: "+pendingLikeCount+"\n"
            );

        List<SCFeedOuterClass.SCFeed.PurchaseInfoFeed> purchaseInfoFeedList = scFeed.getPurchaseInfoFeedList();

        SCFeedOuterClass.SCFeed.SystemNoticeFeed noticeFeed = scFeed.getNoticeFeed(0);
        String content = noticeFeed.getContent();
        Log.d(TAG, "printProtoFeed: SystemNoticeFeed: "+content);

    }


    public static String handleStr(String str){

        String toProto = splitStrToProto(str);
        try {
            printFeed(Utils.toBytes(toProto));
        } catch (InvalidProtocolBufferNanoException e) {
            e.printStackTrace();
            Log.d(TAG, "handleStr短字符串失败， 解析压缩字符串 ");
            toProto = splitGZipToProto(str);
            Log.d(TAG, "handleStr: 解压缩后字符串："+toProto);
            try {
                printFeed(Utils.toBytes(toProto));
            } catch (Exception ex) {
                ex.printStackTrace();
                Log.d(TAG, "handleStr: 字符串解析失败 "+ex);
            }
        }

        return toProto;
    }


    public static void printFeed(byte[] bytes) throws InvalidProtocolBufferNanoException {
        SCFeedPush scFeedPush = SCFeedPush.parseFrom(bytes);
        if (scFeedPush != null){
            final SCFeedPush finalScFeedPush = scFeedPush;
            Activity activity = GlobleParam.getInstance().getActivity();
            final TextView textView = GlobleParam.getInstance().getTextView();
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    textView.setText(finalScFeedPush.toString());
                }
            });
        }
        Log.d(TAG, "test scFeedPush : "+scFeedPush);
//        Log.d(TAG, "test scFeedPush : "+ Utils.bytesToHexString(MessageNano.toByteArray(scFeedPush)));
    }


    /**
     *  短数据直接解析 去掉前46位，后14位
     * @param str
     * @return
     */
    public static String splitStrToProto(String str){
        if (str == null){
            Log.d(TAG, "spiltStrToProto: 字符串为空");
            return "";
        }
        int length = str.length();
//        String substring = str.substring(46, length);
        String substring = str.substring(46, length - 14);
        Log.d(TAG, "spiltStrToProto: 子字符串： "+substring);
        return substring;
    }

    /**
     *  长数据使用，gzip解压缩，1f8b开头，去掉后14位
     * @param str
     * @return
     */
    public static String splitGZipToProto(String str){
        if (str == null){
            Log.d(TAG, "splitStrToProto: 字符串为空");
            return "";
        }
        int length = str.length();
        int indexOf = str.indexOf("1f8b08");
        String substring = "";
        if (indexOf != -1)
            substring = str.substring(indexOf, length - 14);
        else return "subStr error";
        Log.d(TAG, "Gzip解压前字符串: "+substring);
        byte[] uncompress = Utils.uncompress(Utils.toBytes(substring));
        String protoStr = Utils.bytesToHexString(uncompress);
        Log.d(TAG, "Gzip解压后字符串： "+protoStr);
        return protoStr;

    }

}
