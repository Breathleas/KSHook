package com.example.socketdemo.module;

import com.google.protobuf.nano.*;

import java.io.IOException;

public class DrawingGiftPoint extends MessageNano {

    public static volatile DrawingGiftPoint[] _emptyArray;
    public int bottom;
    public int giftId;
    public int left;
    public int right;
    public int top;

    public DrawingGiftPoint() {
        clear();
    }

    public DrawingGiftPoint clear() {
        this.giftId = 0;
        this.left = 0;
        this.top = 0;
        this.right = 0;
        this.bottom = 0;
        this.cachedSize = -1;
        return this;
    }

    public static DrawingGiftPoint[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new DrawingGiftPoint[0];
                }
            }
        }
        return _emptyArray;
    }

    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i = this.giftId;
        if (i != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        int i2 = this.left;
        if (i2 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i2);
        }
        int i3 = this.top;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        int i4 = this.right;
        if (i4 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i4);
        }
        int i5 = this.bottom;
        if (i5 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(5, i5);
        }
        return computeSerializedSize;
    }

    public static DrawingGiftPoint parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new DrawingGiftPoint().mergeFrom(codedInputByteBufferNano);
    }

    public static DrawingGiftPoint parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (DrawingGiftPoint) MessageNano.mergeFrom(new DrawingGiftPoint(), bArr);
    }

    public DrawingGiftPoint mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.giftId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.left = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.top = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.right = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 40) {
                this.bottom = codedInputByteBufferNano.readUInt32();
            } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                return this;
            }
        }
    }

    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i = this.giftId;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        int i2 = this.left;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i2);
        }
        int i3 = this.top;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        int i4 = this.right;
        if (i4 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i4);
        }
        int i5 = this.bottom;
        if (i5 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i5);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

}
