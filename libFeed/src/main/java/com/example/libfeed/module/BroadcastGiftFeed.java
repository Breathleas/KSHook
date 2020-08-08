package com.example.socketdemo.module;

import com.google.protobuf.nano.*;

import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class BroadcastGiftFeed extends MessageNano {
    public static volatile BroadcastGiftFeed[] _emptyArray;
    public long animationDisplayTime;
    public int batchSize;
    public String broadcastInfo;
    public long clientTimestamp;
    public boolean containsRedPack;
    public boolean displayAnimation;
    public boolean displayBanner;
    public boolean displayGif;
    public String exptag;
    public String fromLiveStreamId;
    public User fromUser;
    public int gifFramePerSencond;
    public String gifUrl;
    public String[] gifUrlNew;
    public int giftId;

    /* renamed from: id */
    public String f47450id;
    public int liveAssistantType;
    public long magicFaceId;
    public int rank;
    public String serverExpTag;
    public long slotDisplayDuration;
    public long sortRank;
    public int style;
    public long time;
    public String titleV2;
    public User toUser;
    public String token;
    public boolean useStyleV2;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: kSourceFile */
    public @interface Style {
    }

    public BroadcastGiftFeed() {
        clear();
    }

    public static BroadcastGiftFeed[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new BroadcastGiftFeed[0];
                }
            }
        }
        return _emptyArray;
    }

    public BroadcastGiftFeed clear() {
        this.f47450id = "";
        this.fromUser = null;
        this.toUser = null;
        this.time = 0;
        this.giftId = 0;
        this.batchSize = 0;
        this.fromLiveStreamId = "";
        this.sortRank = 0;
        this.clientTimestamp = 0;
        this.slotDisplayDuration = 0;
        this.style = 0;
        this.liveAssistantType = 0;
        this.magicFaceId = 0;
        this.animationDisplayTime = 0;
        this.exptag = "";
        this.broadcastInfo = "";
        this.displayAnimation = false;
        this.displayBanner = false;
        this.displayGif = false;
        this.gifUrl = "";
        this.gifUrlNew = WireFormatNano.EMPTY_STRING_ARRAY;
        this.useStyleV2 = false;
        this.titleV2 = "";
        this.token = "";
        this.containsRedPack = false;
        this.gifFramePerSencond = 0;
        this.serverExpTag = "";
        this.rank = 0;
        this.cachedSize = -1;
        return this;
    }

    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f47450id.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f47450id);
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
        if (!this.fromLiveStreamId.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.fromLiveStreamId);
        }
        long j2 = this.sortRank;
        if (j2 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j2);
        }
        long j3 = this.clientTimestamp;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(9, j3);
        }
        long j4 = this.slotDisplayDuration;
        if (j4 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(10, j4);
        }
        int i3 = this.style;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(11, i3);
        }
        int i4 = this.liveAssistantType;
        if (i4 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(12, i4);
        }
        long j5 = this.magicFaceId;
        if (j5 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(13, j5);
        }
        long j6 = this.animationDisplayTime;
        if (j6 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(14, j6);
        }
        if (!this.exptag.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(15, this.exptag);
        }
        if (!this.broadcastInfo.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(16, this.broadcastInfo);
        }
        boolean z = this.displayAnimation;
        if (z) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(17, z);
        }
        boolean z2 = this.displayBanner;
        if (z2) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(18, z2);
        }
        boolean z3 = this.displayGif;
        if (z3) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(19, z3);
        }
        if (!this.gifUrl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(20, this.gifUrl);
        }
        String[] strArr = this.gifUrlNew;
        if (strArr != null && strArr.length > 0) {
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (true) {
                String[] strArr2 = this.gifUrlNew;
                if (i5 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i5];
                if (str != null) {
                    i7++;
                    i6 = CodedOutputByteBufferNano.computeStringSizeNoTag(str) + i6;
                }
                i5++;
            }
            computeSerializedSize = computeSerializedSize + i6 + (i7 * 2);
        }
        boolean z4 = this.useStyleV2;
        if (z4) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(22, z4);
        }
        if (!this.titleV2.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(23, this.titleV2);
        }
        if (!this.token.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(24, this.token);
        }
        boolean z5 = this.containsRedPack;
        if (z5) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(25, z5);
        }
        int i8 = this.gifFramePerSencond;
        if (i8 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(26, i8);
        }
        if (!this.serverExpTag.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(27, this.serverExpTag);
        }
        int i9 = this.rank;
        if (i9 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(28, i9);
        }
        return computeSerializedSize;
    }

    public static BroadcastGiftFeed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new BroadcastGiftFeed().mergeFrom(codedInputByteBufferNano);
    }

    public static BroadcastGiftFeed parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (BroadcastGiftFeed) MessageNano.mergeFrom(new BroadcastGiftFeed(), bArr);
    }

    public BroadcastGiftFeed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int i;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f47450id = codedInputByteBufferNano.readString();
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
                case 58:
                    this.fromLiveStreamId = codedInputByteBufferNano.readString();
                    break;
                case 64:
                    this.sortRank = codedInputByteBufferNano.readUInt64();
                    break;
                case 72:
                    this.clientTimestamp = codedInputByteBufferNano.readUInt64();
                    break;
                case 80:
                    this.slotDisplayDuration = codedInputByteBufferNano.readUInt64();
                    break;
                case 88:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                        break;
                    } else {
                        this.style = readInt32;
                        break;
                    }
                case 96:
                    int readInt322 = codedInputByteBufferNano.readInt32();
                    if (readInt322 != 0 && readInt322 != 1 && readInt322 != 2) {
                        break;
                    } else {
                        this.liveAssistantType = readInt322;
                        break;
                    }
                case 104:
                    this.magicFaceId = codedInputByteBufferNano.readUInt64();
                    break;
                case 112:
                    this.animationDisplayTime = codedInputByteBufferNano.readUInt64();
                    break;
                case 122:
                    this.exptag = codedInputByteBufferNano.readString();
                    break;
                case 130:
                    this.broadcastInfo = codedInputByteBufferNano.readString();
                    break;
                case 136:
                    this.displayAnimation = codedInputByteBufferNano.readBool();
                    break;
                case 144:
                    this.displayBanner = codedInputByteBufferNano.readBool();
                    break;
                case 152:
                    this.displayGif = codedInputByteBufferNano.readBool();
                    break;
                case 162:
                    this.gifUrl = codedInputByteBufferNano.readString();
                    break;
                case 170:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 170);
                    String[] strArr = this.gifUrlNew;
                    if (strArr == null) {
                        i = 0;
                    } else {
                        i = strArr.length;
                    }
                    int i2 = repeatedFieldArrayLength + i;
                    String[] strArr2 = new String[i2];
                    if (i != 0) {
                        System.arraycopy(this.gifUrlNew, 0, strArr2, 0, i);
                    }
                    while (i < i2 - 1) {
                        strArr2[i] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        i++;
                    }
                    strArr2[i] = codedInputByteBufferNano.readString();
                    this.gifUrlNew = strArr2;
                    break;
                case 176:
                    this.useStyleV2 = codedInputByteBufferNano.readBool();
                    break;
                case 186:
                    this.titleV2 = codedInputByteBufferNano.readString();
                    break;
                case 194:
                    this.token = codedInputByteBufferNano.readString();
                    break;
                case 200:
                    this.containsRedPack = codedInputByteBufferNano.readBool();
                    break;
                case 208:
                    this.gifFramePerSencond = codedInputByteBufferNano.readUInt32();
                    break;
                case 218:
                    this.serverExpTag = codedInputByteBufferNano.readString();
                    break;
                case 224:
                    this.rank = codedInputByteBufferNano.readUInt32();
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
        if (!this.f47450id.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f47450id);
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
        if (!this.fromLiveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.fromLiveStreamId);
        }
        long j2 = this.sortRank;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j2);
        }
        long j3 = this.clientTimestamp;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(9, j3);
        }
        long j4 = this.slotDisplayDuration;
        if (j4 != 0) {
            codedOutputByteBufferNano.writeUInt64(10, j4);
        }
        int i3 = this.style;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(11, i3);
        }
        int i4 = this.liveAssistantType;
        if (i4 != 0) {
            codedOutputByteBufferNano.writeInt32(12, i4);
        }
        long j5 = this.magicFaceId;
        if (j5 != 0) {
            codedOutputByteBufferNano.writeUInt64(13, j5);
        }
        long j6 = this.animationDisplayTime;
        if (j6 != 0) {
            codedOutputByteBufferNano.writeUInt64(14, j6);
        }
        if (!this.exptag.equals("")) {
            codedOutputByteBufferNano.writeString(15, this.exptag);
        }
        if (!this.broadcastInfo.equals("")) {
            codedOutputByteBufferNano.writeString(16, this.broadcastInfo);
        }
        boolean z = this.displayAnimation;
        if (z) {
            codedOutputByteBufferNano.writeBool(17, z);
        }
        boolean z2 = this.displayBanner;
        if (z2) {
            codedOutputByteBufferNano.writeBool(18, z2);
        }
        boolean z3 = this.displayGif;
        if (z3) {
            codedOutputByteBufferNano.writeBool(19, z3);
        }
        if (!this.gifUrl.equals("")) {
            codedOutputByteBufferNano.writeString(20, this.gifUrl);
        }
        String[] strArr = this.gifUrlNew;
        if (strArr != null && strArr.length > 0) {
            int i5 = 0;
            while (true) {
                String[] strArr2 = this.gifUrlNew;
                if (i5 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i5];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(21, str);
                }
                i5++;
            }
        }
        boolean z4 = this.useStyleV2;
        if (z4) {
            codedOutputByteBufferNano.writeBool(22, z4);
        }
        if (!this.titleV2.equals("")) {
            codedOutputByteBufferNano.writeString(23, this.titleV2);
        }
        if (!this.token.equals("")) {
            codedOutputByteBufferNano.writeString(24, this.token);
        }
        boolean z5 = this.containsRedPack;
        if (z5) {
            codedOutputByteBufferNano.writeBool(25, z5);
        }
        int i6 = this.gifFramePerSencond;
        if (i6 != 0) {
            codedOutputByteBufferNano.writeUInt32(26, i6);
        }
        if (!this.serverExpTag.equals("")) {
            codedOutputByteBufferNano.writeString(27, this.serverExpTag);
        }
        int i7 = this.rank;
        if (i7 != 0) {
            codedOutputByteBufferNano.writeUInt32(28, i7);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}


