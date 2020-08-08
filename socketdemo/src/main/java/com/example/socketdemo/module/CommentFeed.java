package com.example.socketdemo.module;

import android.util.Log;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

import java.io.IOException;

public class CommentFeed extends MessageNano {

    public static volatile CommentFeed[] _emptyArray;
    public String content;
    public String deviceHash;

    /* renamed from: id */
    public String id;
    public boolean isKoi;
    public String landscapeFontColor;
    public int liveAssistantType;
    public CommentFeedEmotion[] lockedEmotion;
    public LiveAudienceState senderState;
    public long sortRank;
    public long time;
    public User user;

    public CommentFeed() {
        clear();
    }
    public CommentFeed clear() {
        this.id = "";
        this.user = null;
        this.time = 0;
        this.content = "";
        this.sortRank = 0;
        this.liveAssistantType = 0;
        this.deviceHash = "";
        this.landscapeFontColor = "";
        this.isKoi = false;
        this.senderState = null;
        this.lockedEmotion = CommentFeedEmotion.emptyArray();
        this.cachedSize = -1;
        return this;
    }


    public static CommentFeed[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new CommentFeed[0];
                }
            }
        }
        return _emptyArray;
    }

    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.id.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.id);
        }
        User kVar = this.user;
        if (kVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, kVar);
        }
        long j = this.time;
        if (j != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
        }
        if (!this.content.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.content);
        }
        long j2 = this.sortRank;
        if (j2 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j2);
        }
        int i = this.liveAssistantType;
        if (i != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i);
        }
        if (!this.deviceHash.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.deviceHash);
        }
        if (!this.landscapeFontColor.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.landscapeFontColor);
        }
        boolean z = this.isKoi;
        if (z) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(9, z);
        }
        LiveAudienceState liveAudienceState = this.senderState;
        if (liveAudienceState != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, liveAudienceState);
        }
        CommentFeedEmotion[] commentFeedEmotionArr = this.lockedEmotion;
        if (commentFeedEmotionArr != null && commentFeedEmotionArr.length > 0) {
            int i2 = 0;
            while (true) {
                CommentFeedEmotion[] commentFeedEmotionArr2 = this.lockedEmotion;
                if (i2 >= commentFeedEmotionArr2.length) {
                    break;
                }
                CommentFeedEmotion commentFeedEmotion = commentFeedEmotionArr2[i2];
                if (commentFeedEmotion != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, commentFeedEmotion);
                }
                i2++;
            }
        }
        return computeSerializedSize;
    }


    public static CommentFeed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return (CommentFeed) new CommentFeed().mergeFrom(codedInputByteBufferNano);
    }


    public static CommentFeed parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (CommentFeed) MessageNano.mergeFrom(new CommentFeed(), bArr);
    }

    @Override
    public MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int i;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.id = codedInputByteBufferNano.readString();
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
                case 34:
                    this.content = codedInputByteBufferNano.readString();
                    break;
                case 40:
                    this.sortRank = codedInputByteBufferNano.readUInt64();
                    break;
                case 48:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                        break;
                    } else {
                        this.liveAssistantType = readInt32;
                        break;
                    }
                case 58:
                    this.deviceHash = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    this.landscapeFontColor = codedInputByteBufferNano.readString();
                    break;
                case 72:
                    this.isKoi = codedInputByteBufferNano.readBool();
                    break;
                case 82:
                    if (this.senderState == null) {
                        this.senderState = new LiveAudienceState();
                    }
                    codedInputByteBufferNano.readMessage(this.senderState);
                    break;
                case 90:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                    CommentFeedEmotion[] commentFeedEmotionArr = this.lockedEmotion;
                    if (commentFeedEmotionArr == null) {
                        i = 0;
                    } else {
                        i = commentFeedEmotionArr.length;
                    }
                    int i2 = repeatedFieldArrayLength + i;
                    CommentFeedEmotion[] commentFeedEmotionArr2 = new CommentFeedEmotion[i2];
                    if (i != 0) {
                        System.arraycopy(this.lockedEmotion, 0, commentFeedEmotionArr2, 0, i);
                    }
                    while (i < i2 - 1) {
                        commentFeedEmotionArr2[i] = new CommentFeedEmotion();
                        codedInputByteBufferNano.readMessage(commentFeedEmotionArr2[i]);
                        codedInputByteBufferNano.readTag();
                        i++;
                    }
                    try{
                        commentFeedEmotionArr2[i] = new CommentFeedEmotion();
                        codedInputByteBufferNano.readMessage(commentFeedEmotionArr2[i]);
                    }catch (Exception e){
                        Log.d("MainActivity", "mergeFrom: readMessage error");
                    }

                    this.lockedEmotion = commentFeedEmotionArr2;
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

    @Override
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.id.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.id);
        }
        User kVar = this.user;
        if (kVar != null) {
            codedOutputByteBufferNano.writeMessage(2, kVar);
        }
        long j = this.time;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j);
        }
        if (!this.content.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.content);
        }
        long j2 = this.sortRank;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j2);
        }
        int i = this.liveAssistantType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(6, i);
        }
        if (!this.deviceHash.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.deviceHash);
        }
        if (!this.landscapeFontColor.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.landscapeFontColor);
        }
        boolean z = this.isKoi;
        if (z) {
            codedOutputByteBufferNano.writeBool(9, z);
        }
        LiveAudienceState liveAudienceState = this.senderState;
        if (liveAudienceState != null) {
            codedOutputByteBufferNano.writeMessage(10, liveAudienceState);
        }
        CommentFeedEmotion[] commentFeedEmotionArr = this.lockedEmotion;
        if (commentFeedEmotionArr != null && commentFeedEmotionArr.length > 0) {
            int i2 = 0;
            while (true) {
                CommentFeedEmotion[] commentFeedEmotionArr2 = this.lockedEmotion;
                if (i2 >= commentFeedEmotionArr2.length) {
                    break;
                }
                CommentFeedEmotion commentFeedEmotion = commentFeedEmotionArr2[i2];
                if (commentFeedEmotion != null) {
                    codedOutputByteBufferNano.writeMessage(11, commentFeedEmotion);
                }
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

}
