package com.example.socketdemo.module;
import com.google.protobuf.nano.*;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;



public final class ToAudienceDrawingGiftFeed extends MessageNano {
    public static volatile ToAudienceDrawingGiftFeed[] _emptyArray;
    public long clientTimestamp;
    public String deviceHash;
    public long displayExtendMillis;
    public long expireDuration;
    public User fromUser;
    public int height;

    /* renamed from: id */
    public String f47466id;
    public DrawingGiftPoint[] point;
    public int rank;
    public LiveAudienceState senderState;
    public int showStrategy;
    public long slotDisplayDuration;
    public int slotPos;
    public long time;
    public User toUser;
    public int width;

    public ToAudienceDrawingGiftFeed() {
        clear();
    }

    public static ToAudienceDrawingGiftFeed[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ToAudienceDrawingGiftFeed[0];
                }
            }
        }
        return _emptyArray;
    }

    public ToAudienceDrawingGiftFeed clear() {
        this.f47466id = "";
        this.fromUser = null;
        this.toUser = null;
        this.time = 0;
        this.height = 0;
        this.width = 0;
        this.point = DrawingGiftPoint.emptyArray();
        this.rank = 0;
        this.expireDuration = 0;
        this.clientTimestamp = 0;
        this.slotDisplayDuration = 0;
        this.deviceHash = "";
        this.slotPos = 0;
        this.displayExtendMillis = 0;
        this.senderState = null;
        this.showStrategy = 0;
        this.cachedSize = -1;
        return this;
    }

    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f47466id.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f47466id);
        }
        User kVar = this.fromUser;
        if (kVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, kVar);
        }
        User kVar2 = this.toUser;
        if (kVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, kVar2);
        }
        long j = this.time;
        if (j != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
        }
        int i = this.height;
        if (i != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i);
        }
        int i2 = this.width;
        if (i2 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i2);
        }
        DrawingGiftPoint[] drawingGiftPointArr = this.point;
        if (drawingGiftPointArr != null && drawingGiftPointArr.length > 0) {
            int i3 = 0;
            while (true) {
                DrawingGiftPoint[] drawingGiftPointArr2 = this.point;
                if (i3 >= drawingGiftPointArr2.length) {
                    break;
                }
                DrawingGiftPoint drawingGiftPoint = drawingGiftPointArr2[i3];
                if (drawingGiftPoint != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, drawingGiftPoint);
                }
                i3++;
            }
        }
        int i4 = this.rank;
        if (i4 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i4);
        }
        long j2 = this.expireDuration;
        if (j2 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(9, j2);
        }
        long j3 = this.clientTimestamp;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(10, j3);
        }
        long j4 = this.slotDisplayDuration;
        if (j4 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(11, j4);
        }
        if (!this.deviceHash.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.deviceHash);
        }
        int i5 = this.slotPos;
        if (i5 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(13, i5);
        }
        long j5 = this.displayExtendMillis;
        if (j5 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(14, j5);
        }
        LiveAudienceState liveAudienceState = this.senderState;
        if (liveAudienceState != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(15, liveAudienceState);
        }
        int i6 = this.showStrategy;
        if (i6 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(16, i6);
        }
        return computeSerializedSize;
    }

    public static ToAudienceDrawingGiftFeed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ToAudienceDrawingGiftFeed().mergeFrom(codedInputByteBufferNano);
    }

    public static ToAudienceDrawingGiftFeed parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ToAudienceDrawingGiftFeed) MessageNano.mergeFrom(new ToAudienceDrawingGiftFeed(), bArr);
    }

    public ToAudienceDrawingGiftFeed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int i;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f47466id = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    if (this.fromUser == null) {
                        this.fromUser = new User();
                    }
                    codedInputByteBufferNano.readMessage(this.fromUser);
                    break;
                case 26:
                    if (this.toUser == null) {
                        this.toUser = new User();
                    }
                    codedInputByteBufferNano.readMessage(this.toUser);
                    break;
                case 32:
                    this.time = codedInputByteBufferNano.readUInt64();
                    break;
                case 40:
                    this.height = codedInputByteBufferNano.readUInt32();
                    break;
                case 48:
                    this.width = codedInputByteBufferNano.readUInt32();
                    break;
                case 58:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                    DrawingGiftPoint[] drawingGiftPointArr = this.point;
                    if (drawingGiftPointArr == null) {
                        i = 0;
                    } else {
                        i = drawingGiftPointArr.length;
                    }
                    int i2 = repeatedFieldArrayLength + i;
                    DrawingGiftPoint[] drawingGiftPointArr2 = new DrawingGiftPoint[i2];
                    if (i != 0) {
                        System.arraycopy(this.point, 0, drawingGiftPointArr2, 0, i);
                    }
                    while (i < i2 - 1) {
                        drawingGiftPointArr2[i] = new DrawingGiftPoint();
                        codedInputByteBufferNano.readMessage(drawingGiftPointArr2[i]);
                        codedInputByteBufferNano.readTag();
                        i++;
                    }
                    drawingGiftPointArr2[i] = new DrawingGiftPoint();
                    codedInputByteBufferNano.readMessage(drawingGiftPointArr2[i]);
                    this.point = drawingGiftPointArr2;
                    break;
                case 64:
                    this.rank = codedInputByteBufferNano.readUInt32();
                    break;
                case 72:
                    this.expireDuration = codedInputByteBufferNano.readUInt64();
                    break;
                case 80:
                    this.clientTimestamp = codedInputByteBufferNano.readUInt64();
                    break;
                case 88:
                    this.slotDisplayDuration = codedInputByteBufferNano.readUInt64();
                    break;
                case 98:
                    this.deviceHash = codedInputByteBufferNano.readString();
                    break;
                case 104:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2 && readInt32 != 3) {
                        break;
                    } else {
                        this.slotPos = readInt32;
                        break;
                    }
                case 112:
                    this.displayExtendMillis = codedInputByteBufferNano.readUInt64();
                    break;
                case 122:
                    if (this.senderState == null) {
                        this.senderState = new LiveAudienceState();
                    }
                    codedInputByteBufferNano.readMessage(this.senderState);
                    break;
                case 128:
                    int readInt322 = codedInputByteBufferNano.readInt32();
                    if (readInt322 != 0 && readInt322 != 1 && readInt322 != 2) {
                        break;
                    } else {
                        this.showStrategy = readInt322;
                        break;
                    }
                default:
                    if (WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                        break;
                    } else {
                        return this;
                    }
            }
        }
    }

    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f47466id.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f47466id);
        }
        User kVar = this.fromUser;
        if (kVar != null) {
            codedOutputByteBufferNano.writeMessage(2, kVar);
        }
        User kVar2 = this.toUser;
        if (kVar2 != null) {
            codedOutputByteBufferNano.writeMessage(3, kVar2);
        }
        long j = this.time;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j);
        }
        int i = this.height;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i);
        }
        int i2 = this.width;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i2);
        }
        DrawingGiftPoint[] drawingGiftPointArr = this.point;
        if (drawingGiftPointArr != null && drawingGiftPointArr.length > 0) {
            int i3 = 0;
            while (true) {
                DrawingGiftPoint[] drawingGiftPointArr2 = this.point;
                if (i3 >= drawingGiftPointArr2.length) {
                    break;
                }
                DrawingGiftPoint drawingGiftPoint = drawingGiftPointArr2[i3];
                if (drawingGiftPoint != null) {
                    codedOutputByteBufferNano.writeMessage(7, drawingGiftPoint);
                }
                i3++;
            }
        }
        int i4 = this.rank;
        if (i4 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i4);
        }
        long j2 = this.expireDuration;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(9, j2);
        }
        long j3 = this.clientTimestamp;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(10, j3);
        }
        long j4 = this.slotDisplayDuration;
        if (j4 != 0) {
            codedOutputByteBufferNano.writeUInt64(11, j4);
        }
        if (!this.deviceHash.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.deviceHash);
        }
        int i5 = this.slotPos;
        if (i5 != 0) {
            codedOutputByteBufferNano.writeInt32(13, i5);
        }
        long j5 = this.displayExtendMillis;
        if (j5 != 0) {
            codedOutputByteBufferNano.writeUInt64(14, j5);
        }
        LiveAudienceState liveAudienceState = this.senderState;
        if (liveAudienceState != null) {
            codedOutputByteBufferNano.writeMessage(15, liveAudienceState);
        }
        int i6 = this.showStrategy;
        if (i6 != 0) {
            codedOutputByteBufferNano.writeInt32(16, i6);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}

