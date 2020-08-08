package com.example.socketdemo.module;
import com.google.protobuf.nano.*;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


public final class VoiceCommentFeed extends MessageNano {
    public static volatile VoiceCommentFeed[] _emptyArray;
    public String deviceHash;
    public long durationMillis;

    /* renamed from: id */
    public String f47468id;
    public boolean isKoi;
    public int liveAssistantType;
    public LiveAudienceState senderState;
    public long sortRank;
    public long time;
    public User user;

    public VoiceCommentFeed() {
        clear();
    }

    public static VoiceCommentFeed[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new VoiceCommentFeed[0];
                }
            }
        }
        return _emptyArray;
    }

    public VoiceCommentFeed clear() {
        this.f47468id = "";
        this.user = null;
        this.time = 0;
        this.sortRank = 0;
        this.liveAssistantType = 0;
        this.deviceHash = "";
        this.durationMillis = 0;
        this.isKoi = false;
        this.senderState = null;
        this.cachedSize = -1;
        return this;
    }

    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f47468id.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f47468id);
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
        long j3 = this.durationMillis;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j3);
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

    public static VoiceCommentFeed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new VoiceCommentFeed().mergeFrom(codedInputByteBufferNano);
    }

    public static VoiceCommentFeed parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (VoiceCommentFeed) MessageNano.mergeFrom(new VoiceCommentFeed(), bArr);
    }

    public VoiceCommentFeed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f47468id = codedInputByteBufferNano.readString();
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
                this.durationMillis = codedInputByteBufferNano.readUInt64();
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
        if (!this.f47468id.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f47468id);
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
        long j3 = this.durationMillis;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j3);
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

