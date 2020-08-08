package com.example.socketdemo.module;

import com.google.protobuf.nano.*;

import java.io.IOException;

public final class LikeFeed extends MessageNano {
    public static volatile LikeFeed[] _emptyArray;
    public String deviceHash;

    /* renamed from: id */
    public String f47458id;
    public boolean isKoi;
    public int liveAssistantType;
    public LiveAudienceState senderState;
    public long sortRank;
    public long time;
    public User user;

    public LikeFeed() {
        clear();
    }

    public static LikeFeed[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LikeFeed[0];
                }
            }
        }
        return _emptyArray;
    }

    public LikeFeed clear() {
        this.f47458id = "";
        this.user = null;
        this.time = 0;
        this.sortRank = 0;
        this.liveAssistantType = 0;
        this.deviceHash = "";
        this.isKoi = false;
        this.senderState = null;
        this.cachedSize = -1;
        return this;
    }

    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f47458id.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f47458id);
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
        if (!this.deviceHash.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.deviceHash);
        }
        boolean z = this.isKoi;
        if (z) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(7, z);
        }
        LiveAudienceState liveAudienceState = this.senderState;
        if (liveAudienceState != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(8, liveAudienceState);
        }
        return computeSerializedSize;
    }

    public static LikeFeed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new LikeFeed().mergeFrom(codedInputByteBufferNano);
    }

    public static LikeFeed parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (LikeFeed) MessageNano.mergeFrom(new LikeFeed(), bArr);
    }

    public LikeFeed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f47458id = codedInputByteBufferNano.readString();
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
            } else if (readTag == 50) {
                this.deviceHash = codedInputByteBufferNano.readString();
            } else if (readTag == 56) {
                this.isKoi = codedInputByteBufferNano.readBool();
            } else if (readTag == 66) {
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
        if (!this.f47458id.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f47458id);
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
        if (!this.deviceHash.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.deviceHash);
        }
        boolean z = this.isKoi;
        if (z) {
            codedOutputByteBufferNano.writeBool(7, z);
        }
        LiveAudienceState liveAudienceState = this.senderState;
        if (liveAudienceState != null) {
            codedOutputByteBufferNano.writeMessage(8, liveAudienceState);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}

