package com.example.socketdemo.module;
import com.google.protobuf.nano.*;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


public final class ToAudienceGiftFeed extends MessageNano {
    public static volatile ToAudienceGiftFeed[] _emptyArray;
    public int batchSize;
    public long clientTimestamp;
    public int comboCount;
    public String deviceHash;
    public long displayExtendMillis;
    public long expireDuration;
    public User fromUser;
    public int giftId;

    /* renamed from: id */
    public String f47467id;
    public long magicFaceId;
    public String mergeKey;
    public int rank;
    public LiveAudienceState senderState;
    public long slotDisplayDuration;
    public int slotPos;
    public long sortRank;
    public int starLevel;
    public int styleType;
    public long time;
    public User toUser;

    public ToAudienceGiftFeed() {
        clear();
    }

    public static ToAudienceGiftFeed[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ToAudienceGiftFeed[0];
                }
            }
        }
        return _emptyArray;
    }

    public ToAudienceGiftFeed clear() {
        this.f47467id = "";
        this.fromUser = null;
        this.toUser = null;
        this.time = 0;
        this.giftId = 0;
        this.batchSize = 0;
        this.sortRank = 0;
        this.deviceHash = "";
        this.senderState = null;
        this.rank = 0;
        this.mergeKey = "";
        this.comboCount = 0;
        this.expireDuration = 0;
        this.clientTimestamp = 0;
        this.magicFaceId = 0;
        this.slotDisplayDuration = 0;
        this.styleType = 0;
        this.displayExtendMillis = 0;
        this.starLevel = 0;
        this.slotPos = 0;
        this.cachedSize = -1;
        return this;
    }

    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f47467id.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f47467id);
        }
        User kVar = this.fromUser;
        if (kVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, kVar);
        }
        User kVar2 = this.toUser;
        if (kVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, kVar2);
        }
        long j = this.time;
        if (j != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
        }
        int i = this.giftId;
        if (i != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i);
        }
        int i2 = this.batchSize;
        if (i2 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i2);
        }
        long j2 = this.sortRank;
        if (j2 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j2);
        }
        if (!this.deviceHash.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.deviceHash);
        }
        LiveAudienceState liveAudienceState = this.senderState;
        if (liveAudienceState != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, liveAudienceState);
        }
        int i3 = this.rank;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i3);
        }
        if (!this.mergeKey.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.mergeKey);
        }
        int i4 = this.comboCount;
        if (i4 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(12, i4);
        }
        long j3 = this.expireDuration;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(13, j3);
        }
        long j4 = this.clientTimestamp;
        if (j4 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(14, j4);
        }
        long j5 = this.magicFaceId;
        if (j5 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(15, j5);
        }
        long j6 = this.slotDisplayDuration;
        if (j6 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(16, j6);
        }
        int i5 = this.styleType;
        if (i5 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(17, i5);
        }
        long j7 = this.displayExtendMillis;
        if (j7 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(18, j7);
        }
        int i6 = this.starLevel;
        if (i6 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(19, i6);
        }
        int i7 = this.slotPos;
        if (i7 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(20, i7);
        }
        return computeSerializedSize;
    }

    public static ToAudienceGiftFeed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ToAudienceGiftFeed().mergeFrom(codedInputByteBufferNano);
    }

    public static ToAudienceGiftFeed parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ToAudienceGiftFeed) MessageNano.mergeFrom(new ToAudienceGiftFeed(), bArr);
    }

    public ToAudienceGiftFeed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f47467id = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    if (this.fromUser == null) {
                        this.fromUser = new User();
                    }
                    codedInputByteBufferNano.readMessage(this.fromUser);
                    break;
                case 26:
                    if (this.toUser == null) {
                        this.toUser = new User();
                    }
                    codedInputByteBufferNano.readMessage(this.toUser);
                    break;
                case 32:
                    this.time = codedInputByteBufferNano.readUInt64();
                    break;
                case 40:
                    this.giftId = codedInputByteBufferNano.readUInt32();
                    break;
                case 48:
                    this.batchSize = codedInputByteBufferNano.readUInt32();
                    break;
                case 56:
                    this.sortRank = codedInputByteBufferNano.readUInt64();
                    break;
                case 66:
                    this.deviceHash = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    if (this.senderState == null) {
                        this.senderState = new LiveAudienceState();
                    }
                    codedInputByteBufferNano.readMessage(this.senderState);
                    break;
                case 80:
                    this.rank = codedInputByteBufferNano.readUInt32();
                    break;
                case 90:
                    this.mergeKey = codedInputByteBufferNano.readString();
                    break;
                case 96:
                    this.comboCount = codedInputByteBufferNano.readUInt32();
                    break;
                case 104:
                    this.expireDuration = codedInputByteBufferNano.readUInt64();
                    break;
                case 112:
                    this.clientTimestamp = codedInputByteBufferNano.readUInt64();
                    break;
                case 120:
                    this.magicFaceId = codedInputByteBufferNano.readUInt64();
                    break;
                case 128:
                    this.slotDisplayDuration = codedInputByteBufferNano.readUInt64();
                    break;
                case 136:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    switch (readInt32) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                            this.styleType = readInt32;
                            break;
                    }
                case 144:
                    this.displayExtendMillis = codedInputByteBufferNano.readUInt64();
                    break;
                case 152:
                    this.starLevel = codedInputByteBufferNano.readUInt32();
                    break;
                case 160:
                    int readInt322 = codedInputByteBufferNano.readInt32();
                    if (readInt322 != 0 && readInt322 != 1 && readInt322 != 2 && readInt322 != 3) {
                        break;
                    } else {
                        this.slotPos = readInt322;
                        break;
                    }
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
        if (!this.f47467id.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f47467id);
        }
        User kVar = this.fromUser;
        if (kVar != null) {
            codedOutputByteBufferNano.writeMessage(2, kVar);
        }
        User kVar2 = this.toUser;
        if (kVar2 != null) {
            codedOutputByteBufferNano.writeMessage(3, kVar2);
        }
        long j = this.time;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j);
        }
        int i = this.giftId;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i);
        }
        int i2 = this.batchSize;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i2);
        }
        long j2 = this.sortRank;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j2);
        }
        if (!this.deviceHash.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.deviceHash);
        }
        LiveAudienceState liveAudienceState = this.senderState;
        if (liveAudienceState != null) {
            codedOutputByteBufferNano.writeMessage(9, liveAudienceState);
        }
        int i3 = this.rank;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i3);
        }
        if (!this.mergeKey.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.mergeKey);
        }
        int i4 = this.comboCount;
        if (i4 != 0) {
            codedOutputByteBufferNano.writeUInt32(12, i4);
        }
        long j3 = this.expireDuration;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(13, j3);
        }
        long j4 = this.clientTimestamp;
        if (j4 != 0) {
            codedOutputByteBufferNano.writeUInt64(14, j4);
        }
        long j5 = this.magicFaceId;
        if (j5 != 0) {
            codedOutputByteBufferNano.writeUInt64(15, j5);
        }
        long j6 = this.slotDisplayDuration;
        if (j6 != 0) {
            codedOutputByteBufferNano.writeUInt64(16, j6);
        }
        int i5 = this.styleType;
        if (i5 != 0) {
            codedOutputByteBufferNano.writeInt32(17, i5);
        }
        long j7 = this.displayExtendMillis;
        if (j7 != 0) {
            codedOutputByteBufferNano.writeUInt64(18, j7);
        }
        int i6 = this.starLevel;
        if (i6 != 0) {
            codedOutputByteBufferNano.writeUInt32(19, i6);
        }
        int i7 = this.slotPos;
        if (i7 != 0) {
            codedOutputByteBufferNano.writeInt32(20, i7);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}

