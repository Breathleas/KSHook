package com.example.socketdemo.SCFeed;
import com.google.protobuf.nano.*;

import java.io.IOException;

public class C19507b extends MessageNano {
    /* renamed from: a */
    public long f56310a = 0;

    public C19507b() {
        this.cachedSize = -1;
    }

    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j = this.f56310a;
        if (j != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        return computeSerializedSize;
    }

    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j = this.f56310a;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 8) {
                this.f56310a = codedInputByteBufferNano.readUInt64();
            } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                break;
            }
        }
        return this;
    }

}
