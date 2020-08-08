package com.example.socketdemo.module;

import com.google.protobuf.nano.*;

import java.io.IOException;

public class User extends MessageNano {

    public static volatile User[] f56329j;

    /* renamed from: a */
    public long f56330a = 0;

    /* renamed from: b */
    public String f56331b = "";

    /* renamed from: c */
    public String f56332c = "";

    /* renamed from: d */
    public String f56333d = "";

    /* renamed from: e */
    public C5383j[] f56334e = C5383j.emptyArray();

    /* renamed from: f */
    public boolean f56335f = false;

    /* renamed from: g */
    public String f56336g = "";

    /* renamed from: h */
    public C5383j[] f56337h = C5383j.emptyArray();

    /* renamed from: i */
    public String f56338i = "";

    public User() {
        this.cachedSize = -1;
    }

    public static User[] emptyArray() {
        if (f56329j == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f56329j == null) {
                    f56329j = new User[0];
                }
            }
        }
        return f56329j;
    }

    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j = this.f56330a;
        if (j != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        if (!this.f56331b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f56331b);
        }
        if (!this.f56332c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f56332c);
        }
        if (!this.f56333d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f56333d);
        }
        C5383j[] jVarArr = this.f56334e;
        int i = 0;
        if (jVarArr != null && jVarArr.length > 0) {
            int i2 = 0;
            while (true) {
                C5383j[] jVarArr2 = this.f56334e;
                if (i2 >= jVarArr2.length) {
                    break;
                }
                C5383j jVar = jVarArr2[i2];
                if (jVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, jVar);
                }
                i2++;
            }
        }
        boolean z = this.f56335f;
        if (z) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(6, z);
        }
        if (!this.f56336g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f56336g);
        }
        C5383j[] jVarArr3 = this.f56337h;
        if (jVarArr3 != null && jVarArr3.length > 0) {
            while (true) {
                C5383j[] jVarArr4 = this.f56337h;
                if (i >= jVarArr4.length) {
                    break;
                }
                C5383j jVar2 = jVarArr4[i];
                if (jVar2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, jVar2);
                }
                i++;
            }
        }
        if (!this.f56338i.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(9, this.f56338i);
        }
        return computeSerializedSize;
    }

    public MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int i;
        int i2;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 8) {
                this.f56330a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                this.f56331b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f56332c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f56333d = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                C5383j[] jVarArr = this.f56334e;
                if (jVarArr == null) {
                    i = 0;
                } else {
                    i = jVarArr.length;
                }
                int i3 = repeatedFieldArrayLength + i;
                C5383j[] jVarArr2 = new C5383j[i3];
                if (i != 0) {
                    System.arraycopy(this.f56334e, 0, jVarArr2, 0, i);
                }
                while (i < i3 - 1) {
                    jVarArr2[i] = new C5383j();
                    i = m17876a(codedInputByteBufferNano, jVarArr2[i], i, 1);
                }
                jVarArr2[i] = new C5383j();
                codedInputByteBufferNano.readMessage(jVarArr2[i]);
                this.f56334e = jVarArr2;
            } else if (readTag == 48) {
                this.f56335f = codedInputByteBufferNano.readBool();
            } else if (readTag == 58) {
                this.f56336g = codedInputByteBufferNano.readString();
            } else if (readTag == 66) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
                C5383j[] jVarArr3 = this.f56337h;
                if (jVarArr3 == null) {
                    i2 = 0;
                } else {
                    i2 = jVarArr3.length;
                }
                int i4 = repeatedFieldArrayLength2 + i2;
                C5383j[] jVarArr4 = new C5383j[i4];
                if (i2 != 0) {
                    System.arraycopy(this.f56337h, 0, jVarArr4, 0, i2);
                }
                while (i2 < i4 - 1) {
                    jVarArr4[i2] = new C5383j();
                    i2 = m17876a(codedInputByteBufferNano, jVarArr4[i2], i2, 1);
                }
                jVarArr4[i2] = new C5383j();
                codedInputByteBufferNano.readMessage(jVarArr4[i2]);
                this.f56337h = jVarArr4;
            } else if (readTag == 74) {
                this.f56338i = codedInputByteBufferNano.readString();
            } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                break;
            }
        }
        return this;
    }

    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j = this.f56330a;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        if (!this.f56331b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f56331b);
        }
        if (!this.f56332c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f56332c);
        }
        if (!this.f56333d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f56333d);
        }
        C5383j[] jVarArr = this.f56334e;
        int i = 0;
        if (jVarArr != null && jVarArr.length > 0) {
            int i2 = 0;
            while (true) {
                C5383j[] jVarArr2 = this.f56334e;
                if (i2 >= jVarArr2.length) {
                    break;
                }
                C5383j jVar = jVarArr2[i2];
                if (jVar != null) {
                    codedOutputByteBufferNano.writeMessage(5, jVar);
                }
                i2++;
            }
        }
        boolean z = this.f56335f;
        if (z) {
            codedOutputByteBufferNano.writeBool(6, z);
        }
        if (!this.f56336g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f56336g);
        }
        C5383j[] jVarArr3 = this.f56337h;
        if (jVarArr3 != null && jVarArr3.length > 0) {
            while (true) {
                C5383j[] jVarArr4 = this.f56337h;
                if (i >= jVarArr4.length) {
                    break;
                }
                C5383j jVar2 = jVarArr4[i];
                if (jVar2 != null) {
                    codedOutputByteBufferNano.writeMessage(8, jVar2);
                }
                i++;
            }
        }
        if (!this.f56338i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f56338i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static int m17876a(CodedInputByteBufferNano codedInputByteBufferNano, C5383j jVar, int i, int i2) throws IOException {
        codedInputByteBufferNano.readMessage(jVar);
        codedInputByteBufferNano.readTag();
        return i + i2;
    }

}
