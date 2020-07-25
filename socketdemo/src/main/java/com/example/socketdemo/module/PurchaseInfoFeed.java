package com.example.socketdemo.module;
import com.google.protobuf.nano.*;
import java.io.IOException;

public final class PurchaseInfoFeed extends MessageNano {
    public static volatile PurchaseInfoFeed[] _emptyArray;
    public String commodityId;
    public String commodityName;

    /* renamed from: id */
    public String f47461id;
    public String jumpToken;
    public int liveAssistantType;
    public String orderId;
    public int purchaseCount;
    public LiveAudienceState senderState;
    public long sortRank;
    public long time;
    public User user;

    public PurchaseInfoFeed() {
        clear();
    }

    public static PurchaseInfoFeed[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new PurchaseInfoFeed[0];
                }
            }
        }
        return _emptyArray;
    }

    public PurchaseInfoFeed clear() {
        this.f47461id = "";
        this.user = null;
        this.time = 0;
        this.commodityId = "";
        this.commodityName = "";
        this.purchaseCount = 0;
        this.orderId = "";
        this.sortRank = 0;
        this.liveAssistantType = 0;
        this.jumpToken = "";
        this.senderState = null;
        this.cachedSize = -1;
        return this;
    }

    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f47461id.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f47461id);
        }
        User kVar = this.user;
        if (kVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, kVar);
        }
        long j = this.time;
        if (j != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
        }
        if (!this.commodityId.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.commodityId);
        }
        if (!this.commodityName.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.commodityName);
        }
        int i = this.purchaseCount;
        if (i != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i);
        }
        if (!this.orderId.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.orderId);
        }
        long j2 = this.sortRank;
        if (j2 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j2);
        }
        int i2 = this.liveAssistantType;
        if (i2 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, i2);
        }
        if (!this.jumpToken.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.jumpToken);
        }
        LiveAudienceState liveAudienceState = this.senderState;
        if (liveAudienceState != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(11, liveAudienceState);
        }
        return computeSerializedSize;
    }

    public static PurchaseInfoFeed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new PurchaseInfoFeed().mergeFrom(codedInputByteBufferNano);
    }

    public static PurchaseInfoFeed parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (PurchaseInfoFeed) MessageNano.mergeFrom(new PurchaseInfoFeed(), bArr);
    }

    public PurchaseInfoFeed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f47461id = codedInputByteBufferNano.readString();
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
                case 34:
                    this.commodityId = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.commodityName = codedInputByteBufferNano.readString();
                    break;
                case 48:
                    this.purchaseCount = codedInputByteBufferNano.readUInt32();
                    break;
                case 58:
                    this.orderId = codedInputByteBufferNano.readString();
                    break;
                case 64:
                    this.sortRank = codedInputByteBufferNano.readUInt64();
                    break;
                case 72:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                        break;
                    } else {
                        this.liveAssistantType = readInt32;
                        break;
                    }
                case 82:
                    this.jumpToken = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    if (this.senderState == null) {
                        this.senderState = new LiveAudienceState();
                    }
                    codedInputByteBufferNano.readMessage(this.senderState);
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
        if (!this.f47461id.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f47461id);
        }
        User kVar = this.user;
        if (kVar != null) {
            codedOutputByteBufferNano.writeMessage(2, kVar);
        }
        long j = this.time;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j);
        }
        if (!this.commodityId.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.commodityId);
        }
        if (!this.commodityName.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.commodityName);
        }
        int i = this.purchaseCount;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i);
        }
        if (!this.orderId.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.orderId);
        }
        long j2 = this.sortRank;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j2);
        }
        int i2 = this.liveAssistantType;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(9, i2);
        }
        if (!this.jumpToken.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.jumpToken);
        }
        LiveAudienceState liveAudienceState = this.senderState;
        if (liveAudienceState != null) {
            codedOutputByteBufferNano.writeMessage(11, liveAudienceState);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}

