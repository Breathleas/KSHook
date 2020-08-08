package com.example.socketdemo.util;

import com.example.socketdemo.module.C5383j;
import com.google.protobuf.nano.CodedInputByteBufferNano;

import java.io.IOException;

public class C5914a {
    public static int m17876a(CodedInputByteBufferNano codedInputByteBufferNano, C5383j jVar, int i, int i2) throws IOException {
        codedInputByteBufferNano.readMessage(jVar);
        codedInputByteBufferNano.readTag();
        return i + i2;
    }

}
