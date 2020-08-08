package com.example.socketdemo.module;
import com.google.protobuf.nano.*;
import java.io.IOException;

public final class ShareFeed extends MessageNano {
    public static volatile ShareFeed[] _emptyArray;
    public String deviceHash;

    /* renamed from: id */
    public String f47464id;
    public boolean isKoi;
    public int liveAssistantType;
    public LiveAudienceState senderState;
    public long sortRank;
    public int thirdPartyPlatform;
    public long time;
    public User user;

    public ShareFeed() {
        clear();
    }

    public static ShareFeed[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ShareFeed[0];
                }
            }
        }
        return _emptyArray;
    }

    public ShareFeed clear() {
        this.f47464id = "";
        this.user = null;
        this.time = 0;
        this.thirdPartyPlatform = 0;
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
        if (!this.f47464id.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f47464id);
        }
        User kVar = this.user;
        if (kVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, kVar);
        }
        long j = this.time;
        if (j != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
        }
        int i = this.thirdPartyPlatform;
        if (i != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i);
        }
        long j2 = this.sortRank;
        if (j2 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j2);
        }
        int i2 = this.liveAssistantType;
        if (i2 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i2);
        }
        if (!this.deviceHash.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.deviceHash);
        }
        boolean z = this.isKoi;
        if (z) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(8, z);
        }
        LiveAudienceState liveAudienceState = this.senderState;
        if (liveAudienceState != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(9, liveAudienceState);
        }
        return computeSerializedSize;
    }

    public static ShareFeed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ShareFeed().mergeFrom(codedInputByteBufferNano);
    }

    public static ShareFeed parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ShareFeed) MessageNano.mergeFrom(new ShareFeed(), bArr);
    }

    public ShareFeed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f47464id = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                if (this.user == null) {
                    this.user = new User();
                }
                codedInputByteBufferNano.readMessage(this.user);
            } else if (readTag == 24) {
                this.time = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 32) {
                this.thirdPartyPlatform = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 40) {
                this.sortRank = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 48) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                    this.liveAssistantType = readInt32;
                }
            } else if (readTag == 58) {
                this.deviceHash = codedInputByteBufferNano.readString();
            } else if (readTag == 64) {
                this.isKoi = codedInputByteBufferNano.readBool();
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
        if (!this.f47464id.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f47464id);
        }
        User kVar = this.user;
        if (kVar != null) {
            codedOutputByteBufferNano.writeMessage(2, kVar);
        }
        long j = this.time;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j);
        }
        int i = this.thirdPartyPlatform;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i);
        }
        long j2 = this.sortRank;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j2);
        }
        int i2 = this.liveAssistantType;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i2);
        }
        if (!this.deviceHash.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.deviceHash);
        }
        boolean z = this.isKoi;
        if (z) {
            codedOutputByteBufferNano.writeBool(8, z);
        }
        LiveAudienceState liveAudienceState = this.senderState;
        if (liveAudienceState != null) {
            codedOutputByteBufferNano.writeMessage(9, liveAudienceState);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}

