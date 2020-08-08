package com.example.socketdemo.module;
import com.google.protobuf.nano.*;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class WatchingFeed extends MessageNano {
    public static volatile WatchingFeed[] _emptyArray;

    /* renamed from: id */
    public String f47469id;
    public long sortRank;
    public long time;
    public User user;

    public WatchingFeed() {
        clear();
    }

    public WatchingFeed clear() {
        this.f47469id = "";
        this.user = null;
        this.time = 0;
        this.sortRank = 0;
        this.cachedSize = -1;
        return this;
    }

    public static WatchingFeed[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new WatchingFeed[0];
                }
            }
        }
        return _emptyArray;
    }

    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f47469id.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f47469id);
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
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(4, j2);
        }
        return computeSerializedSize;
    }

    public static WatchingFeed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new WatchingFeed().mergeFrom(codedInputByteBufferNano);
    }

    public static WatchingFeed parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (WatchingFeed) MessageNano.mergeFrom(new WatchingFeed(), bArr);
    }

    public WatchingFeed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f47469id = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                if (this.user == null) {
                    this.user = new User();
                }
                codedInputByteBufferNano.readMessage(this.user);
            } else if (readTag == 24) {
                this.time = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 32) {
                this.sortRank = codedInputByteBufferNano.readUInt64();
            } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                return this;
            }
        }
    }

    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f47469id.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f47469id);
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
        super.writeTo(codedOutputByteBufferNano);
    }
}

