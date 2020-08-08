package com.example.socketdemo.SCFeed;

import com.google.protobuf.nano.*;

import java.io.IOException;

public final class CSHorseRacing extends MessageNano {
    public static volatile CSHorseRacing[] _emptyArray;
    public String appVer;
    public int clientId;
    public long clientVisitorId;
    public String deviceId;
    public String horseTag;
    public boolean isAuthor;
    public double latitude;
    public String liveStreamId;
    public String locale;
    public double longitude;
    public String operator;
    public String sClientVisitorId;

    public CSHorseRacing() {
        clear();
    }

    public static CSHorseRacing[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new CSHorseRacing[0];
                }
            }
        }
        return _emptyArray;
    }

    public CSHorseRacing clear() {
        this.liveStreamId = "";
        this.horseTag = "";
        this.clientVisitorId = 0;
        this.isAuthor = false;
        this.clientId = 0;
        this.deviceId = "";
        this.locale = "";
        this.appVer = "";
        this.latitude = 0.0d;
        this.longitude = 0.0d;
        this.operator = "";
        this.sClientVisitorId = "";
        this.cachedSize = -1;
        return this;
    }

    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.liveStreamId.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
        }
        if (!this.horseTag.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.horseTag);
        }
        long j = this.clientVisitorId;
        if (j != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
        }
        boolean z = this.isAuthor;
        if (z) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z);
        }
        int i = this.clientId;
        if (i != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(10, i);
        }
        if (!this.deviceId.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.deviceId);
        }
        if (!this.locale.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.locale);
        }
        if (!this.appVer.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.appVer);
        }
        if (Double.doubleToLongBits(this.latitude) != Double.doubleToLongBits(0.0d)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(14, this.latitude);
        }
        if (Double.doubleToLongBits(this.longitude) != Double.doubleToLongBits(0.0d)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(15, this.longitude);
        }
        if (!this.operator.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(16, this.operator);
        }
        if (!this.sClientVisitorId.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(17, this.sClientVisitorId);
        }
        return computeSerializedSize;
    }

    public static CSHorseRacing parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new CSHorseRacing().mergeFrom(codedInputByteBufferNano);
    }

    public static CSHorseRacing parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (CSHorseRacing) MessageNano.mergeFrom(new CSHorseRacing(), bArr);
    }

    public CSHorseRacing mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.liveStreamId = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.horseTag = codedInputByteBufferNano.readString();
                    break;
                case 24:
                    this.clientVisitorId = codedInputByteBufferNano.readUInt64();
                    break;
                case 32:
                    this.isAuthor = codedInputByteBufferNano.readBool();
                    break;
                case 80:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2 && readInt32 != 3 && readInt32 != 6 && readInt32 != 13 && readInt32 != 8 && readInt32 != 9 && readInt32 != 22 && readInt32 != 23) {
                        break;
                    } else {
                        this.clientId = readInt32;
                        break;
                    }
                case 90:
                    this.deviceId = codedInputByteBufferNano.readString();
                    break;
                case 98:
                    this.locale = codedInputByteBufferNano.readString();
                    break;
                case 106:
                    this.appVer = codedInputByteBufferNano.readString();
                    break;
                case 113:
                    this.latitude = codedInputByteBufferNano.readDouble();
                    break;
                case 121:
                    this.longitude = codedInputByteBufferNano.readDouble();
                    break;
                case 130:
                    this.operator = codedInputByteBufferNano.readString();
                    break;
                case 138:
                    this.sClientVisitorId = codedInputByteBufferNano.readString();
                    break;
                default:
                    if (WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                        break;
                    } else {
                        return this;
                    }
            }
        }
    }

    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.liveStreamId);
        }
        if (!this.horseTag.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.horseTag);
        }
        long j = this.clientVisitorId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j);
        }
        boolean z = this.isAuthor;
        if (z) {
            codedOutputByteBufferNano.writeBool(4, z);
        }
        int i = this.clientId;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(10, i);
        }
        if (!this.deviceId.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.deviceId);
        }
        if (!this.locale.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.locale);
        }
        if (!this.appVer.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.appVer);
        }
        if (Double.doubleToLongBits(this.latitude) != Double.doubleToLongBits(0.0d)) {
            codedOutputByteBufferNano.writeDouble(14, this.latitude);
        }
        if (Double.doubleToLongBits(this.longitude) != Double.doubleToLongBits(0.0d)) {
            codedOutputByteBufferNano.writeDouble(15, this.longitude);
        }
        if (!this.operator.equals("")) {
            codedOutputByteBufferNano.writeString(16, this.operator);
        }
        if (!this.sClientVisitorId.equals("")) {
            codedOutputByteBufferNano.writeString(17, this.sClientVisitorId);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
