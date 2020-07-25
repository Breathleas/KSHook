package com.example.socketdemo.module;

import com.google.protobuf.nano.*;

import java.io.IOException;

public class ComboCommentFeed  extends MessageNano {

    public static volatile ComboCommentFeed[] _emptyArray;
    public int comboCount;
    public String content;

    /* renamed from: id */
    public String f47451id;
    public long time;

    public ComboCommentFeed() {
        clear();
    }

    public ComboCommentFeed clear() {
        this.f47451id = "";
        this.content = "";
        this.comboCount = 0;
        this.time = 0;
        this.cachedSize = -1;
        return this;
    }

    public static ComboCommentFeed[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ComboCommentFeed[0];
                }
            }
        }
        return _emptyArray;
    }

    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f47451id.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f47451id);
        }
        if (!this.content.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.content);
        }
        int i = this.comboCount;
        if (i != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i);
        }
        long j = this.time;
        if (j != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(4, j);
        }
        return computeSerializedSize;
    }

    public static ComboCommentFeed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ComboCommentFeed().mergeFrom(codedInputByteBufferNano);
    }

    public static ComboCommentFeed parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ComboCommentFeed) MessageNano.mergeFrom(new ComboCommentFeed(), bArr);
    }

    public ComboCommentFeed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f47451id = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.content = codedInputByteBufferNano.readString();
            } else if (readTag == 24) {
                this.comboCount = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.time = codedInputByteBufferNano.readUInt64();
            } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                return this;
            }
        }
    }

    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f47451id.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f47451id);
        }
        if (!this.content.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.content);
        }
        int i = this.comboCount;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i);
        }
        long j = this.time;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

}
