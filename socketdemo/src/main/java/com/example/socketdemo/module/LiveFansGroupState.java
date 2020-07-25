package com.example.socketdemo.module;

import com.google.protobuf.nano.*;

import java.io.IOException;

public class LiveFansGroupState extends MessageNano {

    public static volatile LiveFansGroupState[] _emptyArray;
    public int enterRoomSpecialEffect;
    public int intimacyLevel;

    public LiveFansGroupState() {
        clear();
    }

    public LiveFansGroupState clear() {
        this.intimacyLevel = 0;
        this.enterRoomSpecialEffect = 0;
        this.cachedSize = -1;
        return this;
    }

    public static LiveFansGroupState[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveFansGroupState[0];
                }
            }
        }
        return _emptyArray;
    }

    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i = this.intimacyLevel;
        if (i != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        int i2 = this.enterRoomSpecialEffect;
        if (i2 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(2, i2);
        }
        return computeSerializedSize;
    }

    public static LiveFansGroupState parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new LiveFansGroupState().mergeFrom(codedInputByteBufferNano);
    }

    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i = this.intimacyLevel;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        int i2 = this.enterRoomSpecialEffect;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static LiveFansGroupState parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (LiveFansGroupState) MessageNano.mergeFrom(new LiveFansGroupState(), bArr);
    }

    public LiveFansGroupState mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.intimacyLevel = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.enterRoomSpecialEffect = codedInputByteBufferNano.readUInt32();
            } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                return this;
            }
        }
    }

}
