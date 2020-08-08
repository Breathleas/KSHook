package com.example.socketdemo.util;

import android.util.Log;

import com.example.socketdemo.SCFeed.i;
import com.google.protobuf.nano.MessageNano;

import static com.example.socketdemo.util.Config.TAG;

public class Utils {


    public static String spiltStrToProto(String str){
        if (str == null){
            Log.d(TAG, "spiltStrToProto: 字符串为空");
            return "";
        }
        int length = str.length();
        String substring = str.substring(46, length - 14);
        Log.d(TAG, "spiltStrToProto: 子字符串： "+substring);
        return substring;

    }


    /**
     * 将byte[]转换为16进制字符串
     * @param src
     * @return
     */
    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }


    /**
     * 字符串转换为16进制字符串
     *
     * @param s
     * @return
     */
    public static String stringToHexString(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i);
            String s4 = Integer.toHexString(ch);
            str = str + s4;
        }
        return str;
    }

    /**
     * 将String转换为byte[]
     * @param s String
     * @return byte[]
     */
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }


    /**
     * 将16进制字符串转换为byte[]
     *
     * @param str
     * @return
     */
    public static byte[] toBytes(String str) {
        if(str == null || str.trim().equals("")) {
            return new byte[0];
        }

        byte[] bytes = new byte[str.length() / 2];
        for(int i = 0; i < str.length() / 2; i++) {
            String subStr = str.substring(i * 2, i * 2 + 2);
            bytes[i] = (byte) Integer.parseInt(subStr, 16);
        }


        return bytes;
    }

    public static String createNanoHex(i a,String name){
        String start = "011a2b3c0000000000000000000000";
        byte[] byteArray;
        String nanoStr;
        switch (name){
            case Config.CSHorseRacing:

                byteArray = MessageNano.toByteArray(a);
                nanoStr = Utils.bytesToHexString(byteArray);
                start = start + Integer.toHexString(byteArray.length);
                String firstStr = nanoStr.substring(28);
//                Log.d(TAG, "firstStr: "+firstStr);
                Log.d(TAG, "byteArray长度: "+Integer.toHexString(byteArray.length)+" byetarray: "+nanoStr);
                GlobleParam.getInstance().setFirstStr(firstStr);
                Log.d(TAG, "createNanoHex nanoStr -> "+nanoStr.length()+" || "+(start+nanoStr));
                return (start+nanoStr);

            case Config.CSRaceLose:
                byteArray = MessageNano.toByteArray(a);
                start = start + Integer.toHexString(byteArray.length);
                nanoStr = Utils.bytesToHexString(byteArray);
                String s = start + nanoStr + GlobleParam.getInstance().getFirstStr();
                assert nanoStr != null;
//                Log.d(TAG, "createNanoHex nanoStr -> "+s);
                return s;
            case Config.CSEnterRoom:
                byteArray = MessageNano.toByteArray(a);
                start = start + Integer.toHexString(byteArray.length);
                nanoStr = Utils.bytesToHexString(byteArray);
                String s1 = start + nanoStr;
//                Log.d(TAG, "createNanoHex nanoStr -> "+s1);
                return s1;
            case Config.C19507b:
                byteArray = MessageNano.toByteArray(a);
                start = start + Integer.toHexString(byteArray.length);
                nanoStr = Utils.bytesToHexString(byteArray);
                String s2 = start + nanoStr;
//                Log.d(TAG, "createNanoHex nanoStr -> "+s2);
                return s2;
        }


        return null;

    }


    public static i createNanoWrapper(MessageNano messageNano, String name) {

        Log.d(TAG, "createNanoWrapper: messageNano ["+messageNano+"]");
        int num = 0;
        switch (name){
            case Config.CSEnterRoom:
                num = 200;
                break;
            case Config.CSHorseRacing:
                num = 204;
                break;
            case Config.C19507b:
                num = 1;
                break;
            case Config.CSRaceLose:
                num = 205;
                break;
            default:
                break;
        }
        if (num != 0) {
            i iVar = new i();
            iVar.a = num;
            iVar.b = 1;
            byte[] bytes = MessageNano.toByteArray(messageNano);
            iVar.c = bytes;
            Log.d(TAG, "createNanoWrapper: 原始messageNano: "+Utils.bytesToHexString(bytes));
            return iVar;
        }
        return null;
    }

}
