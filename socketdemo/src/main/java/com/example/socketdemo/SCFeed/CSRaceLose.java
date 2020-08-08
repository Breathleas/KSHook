package com.example.socketdemo.SCFeed;

import com.google.protobuf.nano.*;

import java.io.IOException;

//205
public class CSRaceLose extends MessageNano {
    public static volatile CSRaceLose[] _emptyArray;
    public long time;

    public CSRaceLose() {
        clear();
    }

    public CSRaceLose clear() {
        this.time = 0;
        this.cachedSize = -1;
        return this;
    }

    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j = this.time;
        if (j != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        return computeSerializedSize;
    }

    public static CSRaceLose[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new CSRaceLose[0];
                }
            }
        }
        return _emptyArray;
    }

    public static CSRaceLose parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new CSRaceLose().mergeFrom(codedInputByteBufferNano);
    }

    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j = this.time;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static CSRaceLose parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (CSRaceLose) MessageNano.mergeFrom(new CSRaceLose(), bArr);
    }

    public CSRaceLose mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.time = codedInputByteBufferNano.readUInt64();
            } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                return this;
            }
        }
    }

}
