package com.example.socketdemo.module;

import com.google.protobuf.nano.*;

import java.io.IOException;

public class DrawingGiftFeed  extends MessageNano {

    public static volatile DrawingGiftFeed[] _emptyArray;
    public long clientTimestamp;
    public String deviceHash;
    public long displayExtendMillis;
    public long expireDuration;
    public int height;

    /* renamed from: id */
    public String f47453id;
    public boolean isKoi;
    public int liveAssistantType;
    public DrawingGiftPoint[] points;
    public int rank;
    public LiveAudienceState senderState;
    public long slotDisplayDuration;
    public int slotPos;
    public long time;
    public User user;
    public int width;

    public DrawingGiftFeed() {
        clear();
    }

    public static DrawingGiftFeed[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new DrawingGiftFeed[0];
                }
            }
        }
        return _emptyArray;
    }

    public DrawingGiftFeed clear() {
        this.f47453id = "";
        this.user = null;
        this.time = 0;
        this.height = 0;
        this.width = 0;
        this.points = DrawingGiftPoint.emptyArray();
        this.rank = 0;
        this.expireDuration = 0;
        this.clientTimestamp = 0;
        this.slotDisplayDuration = 0;
        this.liveAssistantType = 0;
        this.deviceHash = "";
        this.slotPos = 0;
        this.displayExtendMillis = 0;
        this.isKoi = false;
        this.senderState = null;
        this.cachedSize = -1;
        return this;
    }

    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f47453id.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f47453id);
        }
        User kVar = this.user;
        if (kVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, kVar);
        }
        long j = this.time;
        if (j != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
        }
        int i = this.height;
        if (i != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i);
        }
        int i2 = this.width;
        if (i2 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i2);
        }
        DrawingGiftPoint[] drawingGiftPointArr = this.points;
        if (drawingGiftPointArr != null && drawingGiftPointArr.length > 0) {
            int i3 = 0;
            while (true) {
                DrawingGiftPoint[] drawingGiftPointArr2 = this.points;
                if (i3 >= drawingGiftPointArr2.length) {
                    break;
                }
                DrawingGiftPoint drawingGiftPoint = drawingGiftPointArr2[i3];
                if (drawingGiftPoint != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, drawingGiftPoint);
                }
                i3++;
            }
        }
        int i4 = this.rank;
        if (i4 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i4);
        }
        long j2 = this.expireDuration;
        if (j2 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j2);
        }
        long j3 = this.clientTimestamp;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(9, j3);
        }
        long j4 = this.slotDisplayDuration;
        if (j4 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(10, j4);
        }
        int i5 = this.liveAssistantType;
        if (i5 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(11, i5);
        }
        if (!this.deviceHash.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.deviceHash);
        }
        int i6 = this.slotPos;
        if (i6 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(13, i6);
        }
        long j5 = this.displayExtendMillis;
        if (j5 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(14, j5);
        }
        boolean z = this.isKoi;
        if (z) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(15, z);
        }
        LiveAudienceState liveAudienceState = this.senderState;
        if (liveAudienceState != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(16, liveAudienceState);
        }
        return computeSerializedSize;
    }

    public static DrawingGiftFeed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new DrawingGiftFeed().mergeFrom(codedInputByteBufferNano);
    }

    public static DrawingGiftFeed parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (DrawingGiftFeed) MessageNano.mergeFrom(new DrawingGiftFeed(), bArr);
    }

    public DrawingGiftFeed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int i;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f47453id = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    if (this.user == null) {
                        this.user = new User();
                    }
                    codedInputByteBufferNano.readMessage(this.user);
                    break;
                case 24:
                    this.time = codedInputByteBufferNano.readUInt64();
                    break;
                case 32:
                    this.height = codedInputByteBufferNano.readUInt32();
                    break;
                case 40:
                    this.width = codedInputByteBufferNano.readUInt32();
                    break;
                case 50:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                    DrawingGiftPoint[] drawingGiftPointArr = this.points;
                    if (drawingGiftPointArr == null) {
                        i = 0;
                    } else {
                        i = drawingGiftPointArr.length;
                    }
                    int i2 = repeatedFieldArrayLength + i;
                    DrawingGiftPoint[] drawingGiftPointArr2 = new DrawingGiftPoint[i2];
                    if (i != 0) {
                        System.arraycopy(this.points, 0, drawingGiftPointArr2, 0, i);
                    }
                    while (i < i2 - 1) {
                        drawingGiftPointArr2[i] = new DrawingGiftPoint();
                        codedInputByteBufferNano.readMessage(drawingGiftPointArr2[i]);
                        codedInputByteBufferNano.readTag();
                        i++;
                    }
                    drawingGiftPointArr2[i] = new DrawingGiftPoint();
                    codedInputByteBufferNano.readMessage(drawingGiftPointArr2[i]);
                    this.points = drawingGiftPointArr2;
                    break;
                case 56:
                    this.rank = codedInputByteBufferNano.readUInt32();
                    break;
                case 64:
                    this.expireDuration = codedInputByteBufferNano.readUInt64();
                    break;
                case 72:
                    this.clientTimestamp = codedInputByteBufferNano.readUInt64();
                    break;
                case 80:
                    this.slotDisplayDuration = codedInputByteBufferNano.readUInt64();
                    break;
                case 88:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                        break;
                    } else {
                        this.liveAssistantType = readInt32;
                        break;
                    }
                case 98:
                    this.deviceHash = codedInputByteBufferNano.readString();
                    break;
                case 104:
                    int readInt322 = codedInputByteBufferNano.readInt32();
                    if (readInt322 != 0 && readInt322 != 1 && readInt322 != 2 && readInt322 != 3) {
                        break;
                    } else {
                        this.slotPos = readInt322;
                        break;
                    }
                case 112:
                    this.displayExtendMillis = codedInputByteBufferNano.readUInt64();
                    break;
                case 120:
                    this.isKoi = codedInputByteBufferNano.readBool();
                    break;
                case 130:
                    if (this.senderState == null) {
                        this.senderState = new LiveAudienceState();
                    }
                    codedInputByteBufferNano.readMessage(this.senderState);
                    break;
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
        if (!this.f47453id.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f47453id);
        }
        User kVar = this.user;
        if (kVar != null) {
            codedOutputByteBufferNano.writeMessage(2, kVar);
        }
        long j = this.time;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j);
        }
        int i = this.height;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i);
        }
        int i2 = this.width;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i2);
        }
        DrawingGiftPoint[] drawingGiftPointArr = this.points;
        if (drawingGiftPointArr != null && drawingGiftPointArr.length > 0) {
            int i3 = 0;
            while (true) {
                DrawingGiftPoint[] drawingGiftPointArr2 = this.points;
                if (i3 >= drawingGiftPointArr2.length) {
                    break;
                }
                DrawingGiftPoint drawingGiftPoint = drawingGiftPointArr2[i3];
                if (drawingGiftPoint != null) {
                    codedOutputByteBufferNano.writeMessage(6, drawingGiftPoint);
                }
                i3++;
            }
        }
        int i4 = this.rank;
        if (i4 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i4);
        }
        long j2 = this.expireDuration;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j2);
        }
        long j3 = this.clientTimestamp;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(9, j3);
        }
        long j4 = this.slotDisplayDuration;
        if (j4 != 0) {
            codedOutputByteBufferNano.writeUInt64(10, j4);
        }
        int i5 = this.liveAssistantType;
        if (i5 != 0) {
            codedOutputByteBufferNano.writeInt32(11, i5);
        }
        if (!this.deviceHash.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.deviceHash);
        }
        int i6 = this.slotPos;
        if (i6 != 0) {
            codedOutputByteBufferNano.writeInt32(13, i6);
        }
        long j5 = this.displayExtendMillis;
        if (j5 != 0) {
            codedOutputByteBufferNano.writeUInt64(14, j5);
        }
        boolean z = this.isKoi;
        if (z) {
            codedOutputByteBufferNano.writeBool(15, z);
        }
        LiveAudienceState liveAudienceState = this.senderState;
        if (liveAudienceState != null) {
            codedOutputByteBufferNano.writeMessage(16, liveAudienceState);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

}
