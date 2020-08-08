package com.example.socketdemo.module;


import com.example.socketdemo.util.C5914a;
import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: kSourceFile */
public interface LiveStreamRichTextFeed {

    /* compiled from: kSourceFile */
    public static final class ImageSegment extends MessageNano {
        public static volatile ImageSegment[] _emptyArray;
        public String alternativeColor;
        public String alternativeText;
        public C5383j[] imageUrls;

        public ImageSegment() {
            clear();
        }

        public ImageSegment clear() {
            this.imageUrls = C5383j.emptyArray();
            this.alternativeText = "";
            this.alternativeColor = "";
            this.cachedSize = -1;
            return this;
        }

        public static ImageSegment[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new ImageSegment[0];
                    }
                }
            }
            return _emptyArray;
        }

        public int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            C5383j[] jVarArr = this.imageUrls;
            if (jVarArr != null && jVarArr.length > 0) {
                int i = 0;
                while (true) {
                    C5383j[] jVarArr2 = this.imageUrls;
                    if (i >= jVarArr2.length) {
                        break;
                    }
                    C5383j jVar = jVarArr2[i];
                    if (jVar != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, jVar);
                    }
                    i++;
                }
            }
            if (!this.alternativeText.equals("")) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.alternativeText);
            }
            if (!this.alternativeColor.equals("")) {
                return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.alternativeColor);
            }
            return computeSerializedSize;
        }

        public static ImageSegment parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new ImageSegment().mergeFrom(codedInputByteBufferNano);
        }

        public static ImageSegment parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (ImageSegment) MessageNano.mergeFrom(new ImageSegment(), bArr);
        }

        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            C5383j[] jVarArr = this.imageUrls;
            if (jVarArr != null && jVarArr.length > 0) {
                int i = 0;
                while (true) {
                    C5383j[] jVarArr2 = this.imageUrls;
                    if (i >= jVarArr2.length) {
                        break;
                    }
                    C5383j jVar = jVarArr2[i];
                    if (jVar != null) {
                        codedOutputByteBufferNano.writeMessage(1, jVar);
                    }
                    i++;
                }
            }
            if (!this.alternativeText.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.alternativeText);
            }
            if (!this.alternativeColor.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.alternativeColor);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        public ImageSegment mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            int i;
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    C5383j[] jVarArr = this.imageUrls;
                    if (jVarArr == null) {
                        i = 0;
                    } else {
                        i = jVarArr.length;
                    }
                    int i2 = repeatedFieldArrayLength + i;
                    C5383j[] jVarArr2 = new C5383j[i2];
                    if (i != 0) {
                        System.arraycopy(this.imageUrls, 0, jVarArr2, 0, i);
                    }
                    while (i < i2 - 1) {
                        jVarArr2[i] = new C5383j();
                        i = C5914a.m17876a(codedInputByteBufferNano, jVarArr2[i], i, 1);
                    }
                    jVarArr2[i] = new C5383j();
                    codedInputByteBufferNano.readMessage(jVarArr2[i]);
                    this.imageUrls = jVarArr2;
                } else if (readTag == 18) {
                    this.alternativeText = codedInputByteBufferNano.readString();
                } else if (readTag == 26) {
                    this.alternativeColor = codedInputByteBufferNano.readString();
                } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }
    }

    /* compiled from: kSourceFile */
    public static final class PlainSegment extends MessageNano {
        public static volatile PlainSegment[] _emptyArray;
        public String color;
        public String text;

        public PlainSegment() {
            clear();
        }

        public PlainSegment clear() {
            this.text = "";
            this.color = "";
            this.cachedSize = -1;
            return this;
        }

        public static PlainSegment[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new PlainSegment[0];
                    }
                }
            }
            return _emptyArray;
        }

        public int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if (!this.text.equals("")) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.text);
            }
            if (!this.color.equals("")) {
                return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.color);
            }
            return computeSerializedSize;
        }

        public static PlainSegment parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new PlainSegment().mergeFrom(codedInputByteBufferNano);
        }

        public static PlainSegment parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (PlainSegment) MessageNano.mergeFrom(new PlainSegment(), bArr);
        }

        public PlainSegment mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    this.text = codedInputByteBufferNano.readString();
                } else if (readTag == 18) {
                    this.color = codedInputByteBufferNano.readString();
                } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if (!this.text.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.text);
            }
            if (!this.color.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.color);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* compiled from: kSourceFile */
    public static final class RichTextFeed extends MessageNano {
        public static volatile RichTextFeed[] _emptyArray;

        /* renamed from: id */
        public String f47470id;
        public RichTextSegment[] segments;
        public long sortRank;
        public long time;
        public int type;

        public RichTextFeed() {
            clear();
        }

        public static RichTextFeed[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RichTextFeed[0];
                    }
                }
            }
            return _emptyArray;
        }

        public RichTextFeed clear() {
            this.f47470id = "";
            this.sortRank = 0;
            this.time = 0;
            this.type = 0;
            this.segments = RichTextSegment.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        public int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if (!this.f47470id.equals("")) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f47470id);
            }
            long j = this.sortRank;
            if (j != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            long j2 = this.time;
            if (j2 != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j2);
            }
            int i = this.type;
            if (i != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i);
            }
            RichTextSegment[] richTextSegmentArr = this.segments;
            if (richTextSegmentArr != null && richTextSegmentArr.length > 0) {
                int i2 = 0;
                while (true) {
                    RichTextSegment[] richTextSegmentArr2 = this.segments;
                    if (i2 >= richTextSegmentArr2.length) {
                        break;
                    }
                    RichTextSegment richTextSegment = richTextSegmentArr2[i2];
                    if (richTextSegment != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, richTextSegment);
                    }
                    i2++;
                }
            }
            return computeSerializedSize;
        }

        public static RichTextFeed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new RichTextFeed().mergeFrom(codedInputByteBufferNano);
        }

        public static RichTextFeed parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (RichTextFeed) MessageNano.mergeFrom(new RichTextFeed(), bArr);
        }

        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if (!this.f47470id.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.f47470id);
            }
            long j = this.sortRank;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            long j2 = this.time;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j2);
            }
            int i = this.type;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(4, i);
            }
            RichTextSegment[] richTextSegmentArr = this.segments;
            if (richTextSegmentArr != null && richTextSegmentArr.length > 0) {
                int i2 = 0;
                while (true) {
                    RichTextSegment[] richTextSegmentArr2 = this.segments;
                    if (i2 >= richTextSegmentArr2.length) {
                        break;
                    }
                    RichTextSegment richTextSegment = richTextSegmentArr2[i2];
                    if (richTextSegment != null) {
                        codedOutputByteBufferNano.writeMessage(5, richTextSegment);
                    }
                    i2++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        public RichTextFeed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            int i;
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    this.f47470id = codedInputByteBufferNano.readString();
                } else if (readTag == 16) {
                    this.sortRank = codedInputByteBufferNano.readUInt64();
                } else if (readTag == 24) {
                    this.time = codedInputByteBufferNano.readUInt64();
                } else if (readTag == 32) {
                    this.type = codedInputByteBufferNano.readUInt32();
                } else if (readTag == 42) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                    RichTextSegment[] richTextSegmentArr = this.segments;
                    if (richTextSegmentArr == null) {
                        i = 0;
                    } else {
                        i = richTextSegmentArr.length;
                    }
                    int i2 = repeatedFieldArrayLength + i;
                    RichTextSegment[] richTextSegmentArr2 = new RichTextSegment[i2];
                    if (i != 0) {
                        System.arraycopy(this.segments, 0, richTextSegmentArr2, 0, i);
                    }
                    while (i < i2 - 1) {
                        richTextSegmentArr2[i] = new RichTextSegment();
                        codedInputByteBufferNano.readMessage(richTextSegmentArr2[i]);
                        codedInputByteBufferNano.readTag();
                        i++;
                    }
                    richTextSegmentArr2[i] = new RichTextSegment();
                    codedInputByteBufferNano.readMessage(richTextSegmentArr2[i]);
                    this.segments = richTextSegmentArr2;
                } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }
    }

    /* compiled from: kSourceFile */
    public static final class RichTextSegment extends MessageNano {
        public static volatile RichTextSegment[] _emptyArray;
        public int contentCase_ = 0;
        public Object content_;

        public RichTextSegment() {
            clear();
        }

        public RichTextSegment clear() {
            clearContent();
            this.cachedSize = -1;
            return this;
        }

        public RichTextSegment clearContent() {
            this.contentCase_ = 0;
            this.content_ = null;
            return this;
        }

        public int getContentCase() {
            return this.contentCase_;
        }

        public ImageSegment getImage() {
            if (this.contentCase_ == 3) {
                return (ImageSegment) this.content_;
            }
            return null;
        }

        public PlainSegment getPlain() {
            if (this.contentCase_ == 2) {
                return (PlainSegment) this.content_;
            }
            return null;
        }

        public UserInfoSegment getUserInfo() {
            if (this.contentCase_ == 1) {
                return (UserInfoSegment) this.content_;
            }
            return null;
        }

        public boolean hasImage() {
            if (this.contentCase_ == 3) {
                return true;
            }
            return false;
        }

        public boolean hasPlain() {
            if (this.contentCase_ == 2) {
                return true;
            }
            return false;
        }

        public boolean hasUserInfo() {
            if (this.contentCase_ == 1) {
                return true;
            }
            return false;
        }

        public static RichTextSegment[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RichTextSegment[0];
                    }
                }
            }
            return _emptyArray;
        }

        public int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            if (this.contentCase_ == 1) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, (MessageNano) this.content_);
            }
            if (this.contentCase_ == 2) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, (MessageNano) this.content_);
            }
            if (this.contentCase_ == 3) {
                return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, (MessageNano) this.content_);
            }
            return computeSerializedSize;
        }

        public static RichTextSegment parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new RichTextSegment().mergeFrom(codedInputByteBufferNano);
        }

        public RichTextSegment setImage(ImageSegment imageSegment) {
            if (imageSegment != null) {
                this.contentCase_ = 3;
                this.content_ = imageSegment;
                return this;
            }
            throw null;
        }

        public RichTextSegment setPlain(PlainSegment plainSegment) {
            if (plainSegment != null) {
                this.contentCase_ = 2;
                this.content_ = plainSegment;
                return this;
            }
            throw null;
        }

        public RichTextSegment setUserInfo(UserInfoSegment userInfoSegment) {
            if (userInfoSegment != null) {
                this.contentCase_ = 1;
                this.content_ = userInfoSegment;
                return this;
            }
            throw null;
        }

        public static RichTextSegment parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (RichTextSegment) MessageNano.mergeFrom(new RichTextSegment(), bArr);
        }

        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if (this.contentCase_ == 1) {
                codedOutputByteBufferNano.writeMessage(1, (MessageNano) this.content_);
            }
            if (this.contentCase_ == 2) {
                codedOutputByteBufferNano.writeMessage(2, (MessageNano) this.content_);
            }
            if (this.contentCase_ == 3) {
                codedOutputByteBufferNano.writeMessage(3, (MessageNano) this.content_);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        public RichTextSegment mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    if (this.contentCase_ != 1) {
                        this.content_ = new UserInfoSegment();
                    }
                    codedInputByteBufferNano.readMessage((MessageNano) this.content_);
                    this.contentCase_ = 1;
                } else if (readTag == 18) {
                    if (this.contentCase_ != 2) {
                        this.content_ = new PlainSegment();
                    }
                    codedInputByteBufferNano.readMessage((MessageNano) this.content_);
                    this.contentCase_ = 2;
                } else if (readTag == 26) {
                    if (this.contentCase_ != 3) {
                        this.content_ = new ImageSegment();
                    }
                    codedInputByteBufferNano.readMessage((MessageNano) this.content_);
                    this.contentCase_ = 3;
                } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }
    }

    /* compiled from: kSourceFile */
    public static final class UserInfoSegment extends MessageNano {
        public static volatile UserInfoSegment[] _emptyArray;
        public String color;
        public User user;

        public UserInfoSegment() {
            clear();
        }

        public UserInfoSegment clear() {
            this.user = null;
            this.color = "";
            this.cachedSize = -1;
            return this;
        }

        public static UserInfoSegment[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new UserInfoSegment[0];
                    }
                }
            }
            return _emptyArray;
        }

        public int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            User kVar = this.user;
            if (kVar != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, kVar);
            }
            if (!this.color.equals("")) {
                return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.color);
            }
            return computeSerializedSize;
        }

        public static UserInfoSegment parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new UserInfoSegment().mergeFrom(codedInputByteBufferNano);
        }

        public static UserInfoSegment parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (UserInfoSegment) MessageNano.mergeFrom(new UserInfoSegment(), bArr);
        }

        public UserInfoSegment mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    if (this.user == null) {
                        this.user = new User();
                    }
                    codedInputByteBufferNano.readMessage(this.user);
                } else if (readTag == 18) {
                    this.color = codedInputByteBufferNano.readString();
                } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            }
        }

        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            User kVar = this.user;
            if (kVar != null) {
                codedOutputByteBufferNano.writeMessage(1, kVar);
            }
            if (!this.color.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.color);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }
}
