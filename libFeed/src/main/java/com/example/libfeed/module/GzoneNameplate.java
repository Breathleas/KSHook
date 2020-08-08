package com.example.socketdemo.module;

import com.google.protobuf.nano.*;

import java.io.IOException;

public class GzoneNameplate extends MessageNano {

    public static volatile GzoneNameplate[] _emptyArray;

    /* renamed from: id */
    public long f55634id;
    public String name;
    public C5383j[] urls;

    public GzoneNameplate clear() {
        this.f55634id = 0;
        this.name = "";
        this.urls = C5383j.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    public GzoneNameplate() {
        clear();
    }

    public static GzoneNameplate[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GzoneNameplate[0];
                }
            }
        }
        return _emptyArray;
    }

    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j = this.f55634id;
        if (j != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j);
        }
        if (!this.name.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.name);
        }
        C5383j[] jVarArr = this.urls;
        if (jVarArr != null && jVarArr.length > 0) {
            int i = 0;
            while (true) {
                C5383j[] jVarArr2 = this.urls;
                if (i >= jVarArr2.length) {
                    break;
                }
                C5383j jVar = jVarArr2[i];
                if (jVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, jVar);
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    public static GzoneNameplate parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GzoneNameplate().mergeFrom(codedInputByteBufferNano);
    }

    public static GzoneNameplate parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GzoneNameplate) MessageNano.mergeFrom(new GzoneNameplate(), bArr);
    }

    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j = this.f55634id;
        if (j != 0) {
            codedOutputByteBufferNano.writeInt64(1, j);
        }
        if (!this.name.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.name);
        }
        C5383j[] jVarArr = this.urls;
        if (jVarArr != null && jVarArr.length > 0) {
            int i = 0;
            while (true) {
                C5383j[] jVarArr2 = this.urls;
                if (i >= jVarArr2.length) {
                    break;
                }
                C5383j jVar = jVarArr2[i];
                if (jVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, jVar);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public GzoneNameplate mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int i;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f55634id = codedInputByteBufferNano.readInt64();
            } else if (readTag == 18) {
                this.name = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                C5383j[] jVarArr = this.urls;
                if (jVarArr == null) {
                    i = 0;
                } else {
                    i = jVarArr.length;
                }
                int i2 = repeatedFieldArrayLength + i;
                C5383j[] jVarArr2 = new C5383j[i2];
                if (i != 0) {
                    System.arraycopy(this.urls, 0, jVarArr2, 0, i);
                }
                while (i < i2 - 1) {
                    jVarArr2[i] = new C5383j();
                    i = m17876a(codedInputByteBufferNano, jVarArr2[i], i, 1);
                }
                jVarArr2[i] = new C5383j();
                codedInputByteBufferNano.readMessage(jVarArr2[i]);
                this.urls = jVarArr2;
            } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                return this;
            }
        }
    }

    public static int m17876a(CodedInputByteBufferNano codedInputByteBufferNano, C5383j jVar, int i, int i2) throws IOException {
        codedInputByteBufferNano.readMessage(jVar);
        codedInputByteBufferNano.readTag();
        return i + i2;
    }


}
