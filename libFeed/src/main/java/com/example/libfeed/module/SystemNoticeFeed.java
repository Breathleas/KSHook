package com.example.socketdemo.module;
import com.google.protobuf.nano.*;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class SystemNoticeFeed extends MessageNano {
    public static volatile SystemNoticeFeed[] _emptyArray;
    public String content;
    public long displayDuration;
    public int displayType;

    /* renamed from: id */
    public String f47465id;
    public long sortRank;
    public long time;
    public User user;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: kSourceFile */
    public @interface DisplayType {
    }

    public SystemNoticeFeed() {
        clear();
    }

    public static SystemNoticeFeed[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SystemNoticeFeed[0];
                }
            }
        }
        return _emptyArray;
    }

    public SystemNoticeFeed clear() {
        this.f47465id = "";
        this.user = null;
        this.time = 0;
        this.content = "";
        this.displayDuration = 0;
        this.sortRank = 0;
        this.displayType = 0;
        this.cachedSize = -1;
        return this;
    }

    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f47465id.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f47465id);
        }
        User kVar = this.user;
        if (kVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, kVar);
        }
        long j = this.time;
        if (j != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
        }
        if (!this.content.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.content);
        }
        long j2 = this.displayDuration;
        if (j2 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j2);
        }
        long j3 = this.sortRank;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j3);
        }
        int i = this.displayType;
        if (i != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(7, i);
        }
        return computeSerializedSize;
    }

    public static SystemNoticeFeed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SystemNoticeFeed().mergeFrom(codedInputByteBufferNano);
    }

    public static SystemNoticeFeed parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SystemNoticeFeed) MessageNano.mergeFrom(new SystemNoticeFeed(), bArr);
    }

    public SystemNoticeFeed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f47465id = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                if (this.user == null) {
                    this.user = new User();
                }
                codedInputByteBufferNano.readMessage(this.user);
            } else if (readTag == 24) {
                this.time = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 34) {
                this.content = codedInputByteBufferNano.readString();
            } else if (readTag == 40) {
                this.displayDuration = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 48) {
                this.sortRank = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 56) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                    this.displayType = readInt32;
                }
            } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                return this;
            }
        }
    }

    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f47465id.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f47465id);
        }
        User kVar = this.user;
        if (kVar != null) {
            codedOutputByteBufferNano.writeMessage(2, kVar);
        }
        long j = this.time;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j);
        }
        if (!this.content.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.content);
        }
        long j2 = this.displayDuration;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j2);
        }
        long j3 = this.sortRank;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j3);
        }
        int i = this.displayType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(7, i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}


