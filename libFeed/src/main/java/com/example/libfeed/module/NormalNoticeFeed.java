package com.example.socketdemo.module;
import com.google.protobuf.nano.*;
import java.io.IOException;


public final class NormalNoticeFeed extends MessageNano {
    public static volatile NormalNoticeFeed[] _emptyArray;
    public long displayDuration;

    /* renamed from: id */
    public String f47460id;
    public long nextDisplayGap;
    public boolean onlyAuthorShow;
    public LiveStreamRichTextFeed.RichTextSegment[] segments;

    public NormalNoticeFeed() {
        clear();
    }

    public static NormalNoticeFeed[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new NormalNoticeFeed[0];
                }
            }
        }
        return _emptyArray;
    }

    public NormalNoticeFeed clear() {
        this.f47460id = "";
        this.onlyAuthorShow = false;
        this.segments = LiveStreamRichTextFeed.RichTextSegment.emptyArray();
        this.displayDuration = 0;
        this.nextDisplayGap = 0;
        this.cachedSize = -1;
        return this;
    }

    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f47460id.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f47460id);
        }
        boolean z = this.onlyAuthorShow;
        if (z) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z);
        }
        LiveStreamRichTextFeed.RichTextSegment[] richTextSegmentArr = this.segments;
        if (richTextSegmentArr != null && richTextSegmentArr.length > 0) {
            int i = 0;
            while (true) {
                LiveStreamRichTextFeed.RichTextSegment[] richTextSegmentArr2 = this.segments;
                if (i >= richTextSegmentArr2.length) {
                    break;
                }
                LiveStreamRichTextFeed.RichTextSegment richTextSegment = richTextSegmentArr2[i];
                if (richTextSegment != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, richTextSegment);
                }
                i++;
            }
        }
        long j = this.displayDuration;
        if (j != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
        }
        long j2 = this.nextDisplayGap;
        if (j2 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(5, j2);
        }
        return computeSerializedSize;
    }

    public static NormalNoticeFeed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new NormalNoticeFeed().mergeFrom(codedInputByteBufferNano);
    }

    public static NormalNoticeFeed parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (NormalNoticeFeed) MessageNano.mergeFrom(new NormalNoticeFeed(), bArr);
    }

    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f47460id.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f47460id);
        }
        boolean z = this.onlyAuthorShow;
        if (z) {
            codedOutputByteBufferNano.writeBool(2, z);
        }
        LiveStreamRichTextFeed.RichTextSegment[] richTextSegmentArr = this.segments;
        if (richTextSegmentArr != null && richTextSegmentArr.length > 0) {
            int i = 0;
            while (true) {
                LiveStreamRichTextFeed.RichTextSegment[] richTextSegmentArr2 = this.segments;
                if (i >= richTextSegmentArr2.length) {
                    break;
                }
                LiveStreamRichTextFeed.RichTextSegment richTextSegment = richTextSegmentArr2[i];
                if (richTextSegment != null) {
                    codedOutputByteBufferNano.writeMessage(3, richTextSegment);
                }
                i++;
            }
        }
        long j = this.displayDuration;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j);
        }
        long j2 = this.nextDisplayGap;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public NormalNoticeFeed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int i;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f47460id = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                this.onlyAuthorShow = codedInputByteBufferNano.readBool();
            } else if (readTag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                LiveStreamRichTextFeed.RichTextSegment[] richTextSegmentArr = this.segments;
                if (richTextSegmentArr == null) {
                    i = 0;
                } else {
                    i = richTextSegmentArr.length;
                }
                int i2 = repeatedFieldArrayLength + i;
                LiveStreamRichTextFeed.RichTextSegment[] richTextSegmentArr2 = new LiveStreamRichTextFeed.RichTextSegment[i2];
                if (i != 0) {
                    System.arraycopy(this.segments, 0, richTextSegmentArr2, 0, i);
                }
                while (i < i2 - 1) {
                    richTextSegmentArr2[i] = new LiveStreamRichTextFeed.RichTextSegment();
                    codedInputByteBufferNano.readMessage(richTextSegmentArr2[i]);
                    codedInputByteBufferNano.readTag();
                    i++;
                }
                richTextSegmentArr2[i] = new LiveStreamRichTextFeed.RichTextSegment();
                codedInputByteBufferNano.readMessage(richTextSegmentArr2[i]);
                this.segments = richTextSegmentArr2;
            } else if (readTag == 32) {
                this.displayDuration = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 40) {
                this.nextDisplayGap = codedInputByteBufferNano.readUInt64();
            } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                return this;
            }
        }
    }
}

