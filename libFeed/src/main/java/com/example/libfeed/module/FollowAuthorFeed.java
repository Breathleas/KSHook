package com.example.socketdemo.module;

import com.google.protobuf.nano.*;

import java.io.IOException;

public class FollowAuthorFeed extends MessageNano {
    public static volatile FollowAuthorFeed[] _emptyArray;
    public User fans;

    /* renamed from: id */
    public String f47455id;
    public boolean isKoi;
    public int liveAssistantType;
    public LiveAudienceState senderState;
    public long sortRank;
    public long time;

    public FollowAuthorFeed() {
        clear();
    }

    public static FollowAuthorFeed[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new FollowAuthorFeed[0];
                }
            }
        }
        return _emptyArray;
    }

    public FollowAuthorFeed clear() {
        this.f47455id = "";
        this.fans = null;
        this.time = 0;
        this.sortRank = 0;
        this.liveAssistantType = 0;
        this.isKoi = false;
        this.senderState = null;
        this.cachedSize = -1;
        return this;
    }

    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f47455id.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f47455id);
        }
        User kVar = this.fans;
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
        boolean z = this.isKoi;
        if (z) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(6, z);
        }
        LiveAudienceState liveAudienceState = this.senderState;
        if (liveAudienceState != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(7, liveAudienceState);
        }
        return computeSerializedSize;
    }

    public static FollowAuthorFeed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new FollowAuthorFeed().mergeFrom(codedInputByteBufferNano);
    }

    public static FollowAuthorFeed parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (FollowAuthorFeed) MessageNano.mergeFrom(new FollowAuthorFeed(), bArr);
    }

    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f47455id.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f47455id);
        }
        User kVar = this.fans;
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
        boolean z = this.isKoi;
        if (z) {
            codedOutputByteBufferNano.writeBool(6, z);
        }
        LiveAudienceState liveAudienceState = this.senderState;
        if (liveAudienceState != null) {
            codedOutputByteBufferNano.writeMessage(7, liveAudienceState);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public FollowAuthorFeed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f47455id = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                if (this.fans == null) {
                    this.fans = new User();
                }
                codedInputByteBufferNano.readMessage(this.fans);
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
                this.isKoi = codedInputByteBufferNano.readBool();
            } else if (readTag == 58) {
                if (this.senderState == null) {
                    this.senderState = new LiveAudienceState();
                }
                codedInputByteBufferNano.readMessage(this.senderState);
            } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                return this;
            }
        }
    }

}
