package com.example.socketdemo.module;

import com.google.protobuf.nano.*;

import java.io.IOException;

public final class GrabRedPackFeed extends MessageNano {
    public static volatile GrabRedPackFeed[] _emptyArray;
    public User fromUser;
    public int getKsCoin;

    /* renamed from: id */
    public String f47457id;
    public int liveAssistantType;
    public int redPackType;
    public LiveAudienceState senderState;
    public long sortRank;
    public long time;
    public User user;

    public GrabRedPackFeed() {
        clear();
    }

    public static GrabRedPackFeed[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GrabRedPackFeed[0];
                }
            }
        }
        return _emptyArray;
    }

    public GrabRedPackFeed clear() {
        this.f47457id = "";
        this.user = null;
        this.time = 0;
        this.sortRank = 0;
        this.liveAssistantType = 0;
        this.redPackType = 0;
        this.fromUser = null;
        this.getKsCoin = 0;
        this.senderState = null;
        this.cachedSize = -1;
        return this;
    }

    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f47457id.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f47457id);
        }
        User kVar = this.user;
        if (kVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, kVar);
        }
        long j = this.time;
        if (j != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
        }
        long j2 = this.sortRank;
        if (j2 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j2);
        }
        int i = this.liveAssistantType;
        if (i != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i);
        }
        int i2 = this.redPackType;
        if (i2 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i2);
        }
        User kVar2 = this.fromUser;
        if (kVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, kVar2);
        }
        int i3 = this.getKsCoin;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i3);
        }
        LiveAudienceState liveAudienceState = this.senderState;
        if (liveAudienceState != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(9, liveAudienceState);
        }
        return computeSerializedSize;
    }

    public static GrabRedPackFeed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GrabRedPackFeed().mergeFrom(codedInputByteBufferNano);
    }

    public static GrabRedPackFeed parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GrabRedPackFeed) MessageNano.mergeFrom(new GrabRedPackFeed(), bArr);
    }

    public GrabRedPackFeed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f47457id = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                if (this.user == null) {
                    this.user = new User();
                }
                codedInputByteBufferNano.readMessage(this.user);
            } else if (readTag == 24) {
                this.time = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 32) {
                this.sortRank = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 40) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                    this.liveAssistantType = readInt32;
                }
            } else if (readTag == 48) {
                int readInt322 = codedInputByteBufferNano.readInt32();
                if (readInt322 == 0 || readInt322 == 1 || readInt322 == 2 || readInt322 == 11) {
                    this.redPackType = readInt322;
                }
            } else if (readTag == 58) {
                if (this.fromUser == null) {
                    this.fromUser = new User();
                }
                codedInputByteBufferNano.readMessage(this.fromUser);
            } else if (readTag == 64) {
                this.getKsCoin = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 74) {
                if (this.senderState == null) {
                    this.senderState = new LiveAudienceState();
                }
                codedInputByteBufferNano.readMessage(this.senderState);
            } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                return this;
            }
        }
    }

    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f47457id.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f47457id);
        }
        User kVar = this.user;
        if (kVar != null) {
            codedOutputByteBufferNano.writeMessage(2, kVar);
        }
        long j = this.time;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j);
        }
        long j2 = this.sortRank;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j2);
        }
        int i = this.liveAssistantType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(5, i);
        }
        int i2 = this.redPackType;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i2);
        }
        User kVar2 = this.fromUser;
        if (kVar2 != null) {
            codedOutputByteBufferNano.writeMessage(7, kVar2);
        }
        int i3 = this.getKsCoin;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i3);
        }
        LiveAudienceState liveAudienceState = this.senderState;
        if (liveAudienceState != null) {
            codedOutputByteBufferNano.writeMessage(9, liveAudienceState);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}