package com.example.socketdemo.module;

import com.google.protobuf.nano.*;

import java.io.IOException;

public final class GiftFeed extends MessageNano {
    public static volatile GiftFeed[] _emptyArray;
    public int batchSize;
    public long clientTimestamp;
    public boolean combineStream;
    public int comboCount;
    public String deviceHash;
    public long displayExtendMillis;
    public long expireDuration;
    public int giftId;
    public long giftType;

    /* renamed from: id */
    public String f47456id;
    public boolean isDrawingGift;
    public boolean isFromWheelDecide;
    public boolean isKoi;
    public boolean isOpenArrowRedPack;
    public int liveAssistantType;
    public long magicFaceId;
    public String mergeKey;
    public boolean onlyDisplayInSlot;
    public int rank;
    public LiveAudienceState senderState;
    public long slotDisplayDuration;
    public int slotPos;
    public long sortRank;
    public int starLevel;
    public int styleType;
    public int subStarLevel;
    public long time;
    public User user;

    public GiftFeed() {
        clear();
    }

    public static GiftFeed[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GiftFeed[0];
                }
            }
        }
        return _emptyArray;
    }

    public GiftFeed clear() {
        this.f47456id = "";
        this.user = null;
        this.time = 0;
        this.giftId = 0;
        this.sortRank = 0;
        this.mergeKey = "";
        this.batchSize = 0;
        this.comboCount = 0;
        this.rank = 0;
        this.expireDuration = 0;
        this.clientTimestamp = 0;
        this.isDrawingGift = false;
        this.magicFaceId = 0;
        this.slotDisplayDuration = 0;
        this.starLevel = 0;
        this.liveAssistantType = 0;
        this.subStarLevel = 0;
        this.styleType = 0;
        this.deviceHash = "";
        this.slotPos = 0;
        this.displayExtendMillis = 0;
        this.isOpenArrowRedPack = false;
        this.isKoi = false;
        this.senderState = null;
        this.isFromWheelDecide = false;
        this.giftType = 0;
        this.combineStream = false;
        this.onlyDisplayInSlot = false;
        this.cachedSize = -1;
        return this;
    }

    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f47456id.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f47456id);
        }
        User kVar = this.user;
        if (kVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, kVar);
        }
        long j = this.time;
        if (j != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
        }
        int i = this.giftId;
        if (i != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i);
        }
        long j2 = this.sortRank;
        if (j2 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j2);
        }
        if (!this.mergeKey.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.mergeKey);
        }
        int i2 = this.batchSize;
        if (i2 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i2);
        }
        int i3 = this.comboCount;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i3);
        }
        int i4 = this.rank;
        if (i4 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i4);
        }
        long j3 = this.expireDuration;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(10, j3);
        }
        long j4 = this.clientTimestamp;
        if (j4 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(11, j4);
        }
        boolean z = this.isDrawingGift;
        if (z) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(12, z);
        }
        long j5 = this.magicFaceId;
        if (j5 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(13, j5);
        }
        long j6 = this.slotDisplayDuration;
        if (j6 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(14, j6);
        }
        int i5 = this.starLevel;
        if (i5 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(15, i5);
        }
        int i6 = this.liveAssistantType;
        if (i6 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(16, i6);
        }
        int i7 = this.subStarLevel;
        if (i7 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(17, i7);
        }
        int i8 = this.styleType;
        if (i8 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(18, i8);
        }
        if (!this.deviceHash.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(19, this.deviceHash);
        }
        int i9 = this.slotPos;
        if (i9 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(20, i9);
        }
        long j7 = this.displayExtendMillis;
        if (j7 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(21, j7);
        }
        boolean z2 = this.isOpenArrowRedPack;
        if (z2) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(22, z2);
        }
        boolean z3 = this.isKoi;
        if (z3) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(23, z3);
        }
        LiveAudienceState liveAudienceState = this.senderState;
        if (liveAudienceState != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(24, liveAudienceState);
        }
        boolean z4 = this.isFromWheelDecide;
        if (z4) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(25, z4);
        }
        long j8 = this.giftType;
        if (j8 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(26, j8);
        }
        boolean z5 = this.combineStream;
        if (z5) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(27, z5);
        }
        boolean z6 = this.onlyDisplayInSlot;
        if (z6) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(28, z6);
        }
        return computeSerializedSize;
    }

    public static GiftFeed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GiftFeed().mergeFrom(codedInputByteBufferNano);
    }

    public static GiftFeed parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GiftFeed) MessageNano.mergeFrom(new GiftFeed(), bArr);
    }

    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f47456id.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f47456id);
        }
        User kVar = this.user;
        if (kVar != null) {
            codedOutputByteBufferNano.writeMessage(2, kVar);
        }
        long j = this.time;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j);
        }
        int i = this.giftId;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i);
        }
        long j2 = this.sortRank;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j2);
        }
        if (!this.mergeKey.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.mergeKey);
        }
        int i2 = this.batchSize;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i2);
        }
        int i3 = this.comboCount;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i3);
        }
        int i4 = this.rank;
        if (i4 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i4);
        }
        long j3 = this.expireDuration;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(10, j3);
        }
        long j4 = this.clientTimestamp;
        if (j4 != 0) {
            codedOutputByteBufferNano.writeUInt64(11, j4);
        }
        boolean z = this.isDrawingGift;
        if (z) {
            codedOutputByteBufferNano.writeBool(12, z);
        }
        long j5 = this.magicFaceId;
        if (j5 != 0) {
            codedOutputByteBufferNano.writeUInt64(13, j5);
        }
        long j6 = this.slotDisplayDuration;
        if (j6 != 0) {
            codedOutputByteBufferNano.writeUInt64(14, j6);
        }
        int i5 = this.starLevel;
        if (i5 != 0) {
            codedOutputByteBufferNano.writeUInt32(15, i5);
        }
        int i6 = this.liveAssistantType;
        if (i6 != 0) {
            codedOutputByteBufferNano.writeInt32(16, i6);
        }
        int i7 = this.subStarLevel;
        if (i7 != 0) {
            codedOutputByteBufferNano.writeUInt32(17, i7);
        }
        int i8 = this.styleType;
        if (i8 != 0) {
            codedOutputByteBufferNano.writeInt32(18, i8);
        }
        if (!this.deviceHash.equals("")) {
            codedOutputByteBufferNano.writeString(19, this.deviceHash);
        }
        int i9 = this.slotPos;
        if (i9 != 0) {
            codedOutputByteBufferNano.writeInt32(20, i9);
        }
        long j7 = this.displayExtendMillis;
        if (j7 != 0) {
            codedOutputByteBufferNano.writeUInt64(21, j7);
        }
        boolean z2 = this.isOpenArrowRedPack;
        if (z2) {
            codedOutputByteBufferNano.writeBool(22, z2);
        }
        boolean z3 = this.isKoi;
        if (z3) {
            codedOutputByteBufferNano.writeBool(23, z3);
        }
        LiveAudienceState liveAudienceState = this.senderState;
        if (liveAudienceState != null) {
            codedOutputByteBufferNano.writeMessage(24, liveAudienceState);
        }
        boolean z4 = this.isFromWheelDecide;
        if (z4) {
            codedOutputByteBufferNano.writeBool(25, z4);
        }
        long j8 = this.giftType;
        if (j8 != 0) {
            codedOutputByteBufferNano.writeUInt64(26, j8);
        }
        boolean z5 = this.combineStream;
        if (z5) {
            codedOutputByteBufferNano.writeBool(27, z5);
        }
        boolean z6 = this.onlyDisplayInSlot;
        if (z6) {
            codedOutputByteBufferNano.writeBool(28, z6);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public GiftFeed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f47456id = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    if (this.user == null) {
                        this.user = new User();
                    }
                    codedInputByteBufferNano.readMessage(this.user);
                    break;
                case 24:
                    this.time = codedInputByteBufferNano.readUInt64();
                    break;
                case 32:
                    this.giftId = codedInputByteBufferNano.readUInt32();
                    break;
                case 40:
                    this.sortRank = codedInputByteBufferNano.readUInt64();
                    break;
                case 50:
                    this.mergeKey = codedInputByteBufferNano.readString();
                    break;
                case 56:
                    this.batchSize = codedInputByteBufferNano.readUInt32();
                    break;
                case 64:
                    this.comboCount = codedInputByteBufferNano.readUInt32();
                    break;
                case 72:
                    this.rank = codedInputByteBufferNano.readUInt32();
                    break;
                case 80:
                    this.expireDuration = codedInputByteBufferNano.readUInt64();
                    break;
                case 88:
                    this.clientTimestamp = codedInputByteBufferNano.readUInt64();
                    break;
                case 96:
                    this.isDrawingGift = codedInputByteBufferNano.readBool();
                    break;
                case 104:
                    this.magicFaceId = codedInputByteBufferNano.readUInt64();
                    break;
                case 112:
                    this.slotDisplayDuration = codedInputByteBufferNano.readUInt64();
                    break;
                case 120:
                    this.starLevel = codedInputByteBufferNano.readUInt32();
                    break;
                case 128:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                        break;
                    } else {
                        this.liveAssistantType = readInt32;
                        break;
                    }
                case 136:
                    this.subStarLevel = codedInputByteBufferNano.readUInt32();
                    break;
                case 144:
                    int readInt322 = codedInputByteBufferNano.readInt32();
                    switch (readInt322) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                            this.styleType = readInt322;
                            break;
                    }
                case 154:
                    this.deviceHash = codedInputByteBufferNano.readString();
                    break;
                case 160:
                    int readInt323 = codedInputByteBufferNano.readInt32();
                    if (readInt323 != 0 && readInt323 != 1 && readInt323 != 2 && readInt323 != 3) {
                        break;
                    } else {
                        this.slotPos = readInt323;
                        break;
                    }
                case 168:
                    this.displayExtendMillis = codedInputByteBufferNano.readUInt64();
                    break;
                case 176:
                    this.isOpenArrowRedPack = codedInputByteBufferNano.readBool();
                    break;
                case 184:
                    this.isKoi = codedInputByteBufferNano.readBool();
                    break;
                case 194:
                    if (this.senderState == null) {
                        this.senderState = new LiveAudienceState();
                    }
                    codedInputByteBufferNano.readMessage(this.senderState);
                    break;
                case 200:
                    this.isFromWheelDecide = codedInputByteBufferNano.readBool();
                    break;
                case 208:
                    this.giftType = codedInputByteBufferNano.readUInt64();
                    break;
                case 216:
                    this.combineStream = codedInputByteBufferNano.readBool();
                    break;
                case 224:
                    this.onlyDisplayInSlot = codedInputByteBufferNano.readBool();
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

