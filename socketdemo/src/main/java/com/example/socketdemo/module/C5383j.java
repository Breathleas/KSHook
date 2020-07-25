package com.example.socketdemo.module;

import com.google.protobuf.nano.*;

import java.io.IOException;

public class C5383j extends MessageNano {

    /* renamed from: e */
    public static volatile C5383j[] f21842e;

    /* renamed from: a */
    public String f21843a = "";

    /* renamed from: b */
    public String f21844b = "";

    /* renamed from: c */
    public String f21845c = "";

    /* renamed from: d */
    public String f21846d = "";

    public C5383j() {
        this.cachedSize = -1;
    }

    public static C5383j[] emptyArray() {
        if (f21842e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f21842e == null) {
                    f21842e = new C5383j[0];
                }
            }
        }
        return f21842e;
    }

    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f21843a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f21843a);
        }
        if (!this.f21844b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f21844b);
        }
        if (!this.f21845c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f21845c);
        }
        if (!this.f21846d.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.f21846d);
        }
        return computeSerializedSize;
    }

    public MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f21843a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f21844b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f21845c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f21846d = codedInputByteBufferNano.readString();
            } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                break;
            }
        }
        return this;
    }

    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f21843a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f21843a);
        }
        if (!this.f21844b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f21844b);
        }
        if (!this.f21845c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f21845c);
        }
        if (!this.f21846d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f21846d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

}
