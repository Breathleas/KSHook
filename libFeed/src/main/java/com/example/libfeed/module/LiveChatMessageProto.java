package com.example.socketdemo.module;
import com.google.protobuf.nano.*;

import java.io.IOException;
public interface LiveChatMessageProto {

    /* compiled from: kSourceFile */
    public static final class LiveChatUserApplyInfoFeed extends MessageNano {
        public static volatile LiveChatUserApplyInfoFeed[] _emptyArray;

        /* renamed from: id */
        public String f47449id;
        public long sortRank;
        public User user;

        public LiveChatUserApplyInfoFeed() {
            clear();
        }

        public LiveChatUserApplyInfoFeed clear() {
            this.f47449id = "";
            this.user = null;
            this.sortRank = 0;
            this.cachedSize = -1;
            return this;
        }

        public static LiveChatUserApplyInfoFeed[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveChatUserApplyInfoFeed[0];
                    }
                }
            }
            return _emptyArray;
        }

        public int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if (!this.f47449id.equals("")) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f47449id);
            }
            User kVar = this.user;
            if (kVar != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, kVar);
            }
            long j = this.sortRank;
            if (j != 0) {
                return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j);
            }
            return computeSerializedSize;
        }

        public static LiveChatUserApplyInfoFeed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new LiveChatUserApplyInfoFeed().mergeFrom(codedInputByteBufferNano);
        }

        public static LiveChatUserApplyInfoFeed parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (LiveChatUserApplyInfoFeed) MessageNano.mergeFrom(new LiveChatUserApplyInfoFeed(), bArr);
        }

        public LiveChatUserApplyInfoFeed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    this.f47449id = codedInputByteBufferNano.readString();
                } else if (readTag == 18) {
                    if (this.user == null) {
                        this.user = new User();
                    }
                    codedInputByteBufferNano.readMessage(this.user);
                } else if (readTag == 24) {
                    this.sortRank = codedInputByteBufferNano.readUInt64();
                } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if (!this.f47449id.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.f47449id);
            }
            User kVar = this.user;
            if (kVar != null) {
                codedOutputByteBufferNano.writeMessage(2, kVar);
            }
            long j = this.sortRank;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }
}
