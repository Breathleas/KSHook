package com.example.socketdemo.module;

import com.google.protobuf.nano.*;

import java.io.IOException;

public class CommentFeedEmotion extends MessageNano {


    public static volatile CommentFeedEmotion[] _emptyArray;
    public String emotionName;

    public CommentFeedEmotion() {
        clear();
    }

    public CommentFeedEmotion clear() {
        this.emotionName = "";
        this.cachedSize = -1;
        return this;
    }

    public static CommentFeedEmotion[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new CommentFeedEmotion[0];
                }
            }
        }
        return _emptyArray;
    }

    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.emotionName.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.emotionName);
        }
        return computeSerializedSize;
    }

    public static CommentFeedEmotion parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new CommentFeedEmotion().mergeFrom(codedInputByteBufferNano);
    }

    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.emotionName.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.emotionName);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static CommentFeedEmotion parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (CommentFeedEmotion) MessageNano.mergeFrom(new CommentFeedEmotion(), bArr);
    }

    public CommentFeedEmotion mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.emotionName = codedInputByteBufferNano.readString();
            } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                return this;
            }
        }
    }

}
