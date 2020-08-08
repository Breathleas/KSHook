package com.example.socketdemo.SCFeed;

import com.google.protobuf.nano.*;

import java.io.IOException;

public class CSEnterRoom extends MessageNano {


    public static volatile CSEnterRoom[] _emptyArray;
    public int appType;
    public String appVer;
    public String attach;
    public long authorId;
    public String broadcastGiftToken;
    public int clientId;
    public String deviceId;
    public String expTag;
    public boolean firstEnter;
    public boolean isAuthor;
    public String kpf;
    public String kpn;
    public int lastErrorCode;
    public String liveStreamId;
    public String locale;
    public String location;
    public String operator;
    public int reconnectCount;
    public String redPackId;
    public String serviceToken;
    public int sourceType;
    public String token;

    public CSEnterRoom() {
        clear();
    }

    public static CSEnterRoom[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new CSEnterRoom[0];
                }
            }
        }
        return _emptyArray;
    }

    public CSEnterRoom clear() {
        this.token = "";
        this.clientId = 0;
        this.deviceId = "";
        this.liveStreamId = "";
        this.isAuthor = false;
        this.reconnectCount = 0;
        this.lastErrorCode = 0;
        this.locale = "";
        this.appVer = "";
        this.location = "";
        this.operator = "";
        this.firstEnter = false;
        this.expTag = "";
        this.attach = "";
        this.appType = 0;
        this.sourceType = 0;
        this.broadcastGiftToken = "";
        this.serviceToken = "";
        this.redPackId = "";
        this.authorId = 0;
        this.kpn = "";
        this.kpf = "";
        this.cachedSize = -1;
        return this;
    }

    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.token.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.token);
        }
        int i = this.clientId;
        if (i != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
        }
        if (!this.deviceId.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.deviceId);
        }
        if (!this.liveStreamId.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.liveStreamId);
        }
        boolean z = this.isAuthor;
        if (z) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z);
        }
        int i2 = this.reconnectCount;
        if (i2 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i2);
        }
        int i3 = this.lastErrorCode;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i3);
        }
        if (!this.locale.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.locale);
        }
        if (!this.appVer.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.appVer);
        }
        if (!this.location.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.location);
        }
        if (!this.operator.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.operator);
        }
        boolean z2 = this.firstEnter;
        if (z2) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(12, z2);
        }
        if (!this.expTag.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.expTag);
        }
        if (!this.attach.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(14, this.attach);
        }
        int i4 = this.appType;
        if (i4 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(15, i4);
        }
        int i5 = this.sourceType;
        if (i5 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(16, i5);
        }
        if (!this.broadcastGiftToken.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(17, this.broadcastGiftToken);
        }
        if (!this.serviceToken.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(18, this.serviceToken);
        }
        if (!this.redPackId.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(19, this.redPackId);
        }
        long j = this.authorId;
        if (j != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(20, j);
        }
        if (!this.kpn.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(21, this.kpn);
        }
        if (!this.kpf.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(22, this.kpf);
        }
        return computeSerializedSize;
    }

    public static CSEnterRoom parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new CSEnterRoom().mergeFrom(codedInputByteBufferNano);
    }

    public static CSEnterRoom parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (CSEnterRoom) MessageNano.mergeFrom(new CSEnterRoom(), bArr);
    }

    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.token.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.token);
        }
        int i = this.clientId;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(2, i);
        }
        if (!this.deviceId.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.deviceId);
        }
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.liveStreamId);
        }
        boolean z = this.isAuthor;
        if (z) {
            codedOutputByteBufferNano.writeBool(5, z);
        }
        int i2 = this.reconnectCount;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i2);
        }
        int i3 = this.lastErrorCode;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i3);
        }
        if (!this.locale.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.locale);
        }
        if (!this.appVer.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.appVer);
        }
        if (!this.location.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.location);
        }
        if (!this.operator.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.operator);
        }
        boolean z2 = this.firstEnter;
        if (z2) {
            codedOutputByteBufferNano.writeBool(12, z2);
        }
        if (!this.expTag.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.expTag);
        }
        if (!this.attach.equals("")) {
            codedOutputByteBufferNano.writeString(14, this.attach);
        }
        int i4 = this.appType;
        if (i4 != 0) {
            codedOutputByteBufferNano.writeInt32(15, i4);
        }
        int i5 = this.sourceType;
        if (i5 != 0) {
            codedOutputByteBufferNano.writeInt32(16, i5);
        }
        if (!this.broadcastGiftToken.equals("")) {
            codedOutputByteBufferNano.writeString(17, this.broadcastGiftToken);
        }
        if (!this.serviceToken.equals("")) {
            codedOutputByteBufferNano.writeString(18, this.serviceToken);
        }
        if (!this.redPackId.equals("")) {
            codedOutputByteBufferNano.writeString(19, this.redPackId);
        }
        long j = this.authorId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(20, j);
        }
        if (!this.kpn.equals("")) {
            codedOutputByteBufferNano.writeString(21, this.kpn);
        }
        if (!this.kpf.equals("")) {
            codedOutputByteBufferNano.writeString(22, this.kpf);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public CSEnterRoom mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.token = codedInputByteBufferNano.readString();
                    break;
                case 16:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2 && readInt32 != 3 && readInt32 != 6 && readInt32 != 13 && readInt32 != 8 && readInt32 != 9 && readInt32 != 22 && readInt32 != 23) {
                        break;
                    } else {
                        this.clientId = readInt32;
                        break;
                    }
                case 26:
                    this.deviceId = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.liveStreamId = codedInputByteBufferNano.readString();
                    break;
                case 40:
                    this.isAuthor = codedInputByteBufferNano.readBool();
                    break;
                case 48:
                    this.reconnectCount = codedInputByteBufferNano.readUInt32();
                    break;
                case 56:
                    this.lastErrorCode = codedInputByteBufferNano.readUInt32();
                    break;
                case 66:
                    this.locale = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.appVer = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.location = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.operator = codedInputByteBufferNano.readString();
                    break;
                case 96:
                    this.firstEnter = codedInputByteBufferNano.readBool();
                    break;
                case 106:
                    this.expTag = codedInputByteBufferNano.readString();
                    break;
                case 114:
                    this.attach = codedInputByteBufferNano.readString();
                    break;
                case 120:
                    int readInt322 = codedInputByteBufferNano.readInt32();
                    if (!(readInt322 == 0 || readInt322 == 1 || readInt322 == 2 || readInt322 == 8 || readInt322 == 9 || readInt322 == 21 || readInt322 == 22)) {
                        switch (readInt322) {
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                                break;
                        }
                    }
                    this.appType = readInt322;
                    break;
                case 128:
                    int readInt323 = codedInputByteBufferNano.readInt32();
                    switch (readInt323) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                            this.sourceType = readInt323;
                            break;
                    }
                case 138:
                    this.broadcastGiftToken = codedInputByteBufferNano.readString();
                    break;
                case 146:
                    this.serviceToken = codedInputByteBufferNano.readString();
                    break;
                case 154:
                    this.redPackId = codedInputByteBufferNano.readString();
                    break;
                case 160:
                    this.authorId = codedInputByteBufferNano.readUInt64();
                    break;
                case 170:
                    this.kpn = codedInputByteBufferNano.readString();
                    break;
                case 178:
                    this.kpf = codedInputByteBufferNano.readString();
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

}
