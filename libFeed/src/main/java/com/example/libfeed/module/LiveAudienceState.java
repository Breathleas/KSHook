package com.example.socketdemo.module;

import com.google.protobuf.nano.*;

import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class LiveAudienceState extends MessageNano {
    public static volatile LiveAudienceState[] _emptyArray;
    public int assistantType;
    public int fansGroupIntimacyLevel;
    public boolean isFromFansTop;
    public boolean isKoi;
    public LiveFansGroupState liveFansGroupState;
    public GzoneNameplate nameplate;
    public int wealthGrade;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: kSourceFile */
    public @interface AssistantType {
    }

    public LiveAudienceState clear() {
        this.isFromFansTop = false;
        this.isKoi = false;
        this.assistantType = 0;
        this.fansGroupIntimacyLevel = 0;
        this.nameplate = null;
        this.liveFansGroupState = null;
        this.wealthGrade = 0;
        this.cachedSize = -1;
        return this;
    }

    public LiveAudienceState() {
        clear();
    }

    public static LiveAudienceState[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveAudienceState[0];
                }
            }
        }
        return _emptyArray;
    }

    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z = this.isFromFansTop;
        if (z) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
        }
        boolean z2 = this.isKoi;
        if (z2) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z2);
        }
        int i = this.assistantType;
        if (i != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i);
        }
        int i2 = this.fansGroupIntimacyLevel;
        if (i2 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i2);
        }
        GzoneNameplate gzoneNameplate = this.nameplate;
        if (gzoneNameplate != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, gzoneNameplate);
        }
        LiveFansGroupState liveFansGroupState2 = this.liveFansGroupState;
        if (liveFansGroupState2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, liveFansGroupState2);
        }
        int i3 = this.wealthGrade;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(7, i3);
        }
        return computeSerializedSize;
    }

    public static LiveAudienceState parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new LiveAudienceState().mergeFrom(codedInputByteBufferNano);
    }

    public static LiveAudienceState parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (LiveAudienceState) MessageNano.mergeFrom(new LiveAudienceState(), bArr);
    }

    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z = this.isFromFansTop;
        if (z) {
            codedOutputByteBufferNano.writeBool(1, z);
        }
        boolean z2 = this.isKoi;
        if (z2) {
            codedOutputByteBufferNano.writeBool(2, z2);
        }
        int i = this.assistantType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(3, i);
        }
        int i2 = this.fansGroupIntimacyLevel;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i2);
        }
        GzoneNameplate gzoneNameplate = this.nameplate;
        if (gzoneNameplate != null) {
            codedOutputByteBufferNano.writeMessage(5, gzoneNameplate);
        }
        LiveFansGroupState liveFansGroupState2 = this.liveFansGroupState;
        if (liveFansGroupState2 != null) {
            codedOutputByteBufferNano.writeMessage(6, liveFansGroupState2);
        }
        int i3 = this.wealthGrade;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public LiveAudienceState mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.isFromFansTop = codedInputByteBufferNano.readBool();
            } else if (readTag == 16) {
                this.isKoi = codedInputByteBufferNano.readBool();
            } else if (readTag == 24) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                    this.assistantType = readInt32;
                }
            } else if (readTag == 32) {
                this.fansGroupIntimacyLevel = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 42) {
                if (this.nameplate == null) {
                    this.nameplate = new GzoneNameplate();
                }
                codedInputByteBufferNano.readMessage(this.nameplate);
            } else if (readTag == 50) {
                if (this.liveFansGroupState == null) {
                    this.liveFansGroupState = new LiveFansGroupState();
                }
                codedInputByteBufferNano.readMessage(this.liveFansGroupState);
            } else if (readTag == 56) {
                this.wealthGrade = codedInputByteBufferNano.readUInt32();
            } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                return this;
            }
        }
    }

}
