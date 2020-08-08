package com.example.socketdemo.module;
import com.google.protobuf.nano.*;
import java.io.IOException;

public final class MicSeatsApplyInfoFeed extends MessageNano {
    public static volatile MicSeatsApplyInfoFeed[] _emptyArray;

    /* renamed from: id */
    public String f47459id;
    public long time;
    public User user;
    public String voicePartyId;

    public MicSeatsApplyInfoFeed() {
        clear();
    }

    public MicSeatsApplyInfoFeed clear() {
        this.f47459id = "";
        this.voicePartyId = "";
        this.user = null;
        this.time = 0;
        this.cachedSize = -1;
        return this;
    }

    public static MicSeatsApplyInfoFeed[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new MicSeatsApplyInfoFeed[0];
                }
            }
        }
        return _emptyArray;
    }

    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f47459id.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f47459id);
        }
        if (!this.voicePartyId.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.voicePartyId);
        }
        User kVar = this.user;
        if (kVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, kVar);
        }
        long j = this.time;
        if (j != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(4, j);
        }
        return computeSerializedSize;
    }

    public static MicSeatsApplyInfoFeed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new MicSeatsApplyInfoFeed().mergeFrom(codedInputByteBufferNano);
    }

    public static MicSeatsApplyInfoFeed parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (MicSeatsApplyInfoFeed) MessageNano.mergeFrom(new MicSeatsApplyInfoFeed(), bArr);
    }

    public MicSeatsApplyInfoFeed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f47459id = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.voicePartyId = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                if (this.user == null) {
                    this.user = new User();
                }
                codedInputByteBufferNano.readMessage(this.user);
            } else if (readTag == 32) {
                this.time = codedInputByteBufferNano.readUInt64();
            } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                return this;
            }
        }
    }

    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f47459id.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f47459id);
        }
        if (!this.voicePartyId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.voicePartyId);
        }
        User kVar = this.user;
        if (kVar != null) {
            codedOutputByteBufferNano.writeMessage(3, kVar);
        }
        long j = this.time;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
