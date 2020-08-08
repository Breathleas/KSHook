package com.example.socketdemo.SCFeed;

import com.example.socketdemo.module.*;
import com.example.socketdemo.module.ComboCommentFeed;
import com.example.socketdemo.module.CommentFeed;
import com.example.socketdemo.module.DrawingGiftFeed;
import com.google.protobuf.nano.*;

import java.io.IOException;

public class SCFeedPush extends MessageNano {

    public static volatile SCFeedPush[] _emptyArray;
    public long authorId;
    public BroadcastGiftFeed[] broadcastGiftFeed;
    public ComboCommentFeed[] comboCommentFeed;
    public CommentFeed[] commentFeeds;
    public String displayLikeCount;
    public String displayWatchingCount;
    public DrawingGiftFeed[] drawingGiftFeeds;
    public EnterRoomFeed[] enterRoomFeed;
    public FollowAuthorFeed[] followAuthorFeed;
    public GiftFeed[] giftFeeds;
    public GrabRedPackFeed[] grabRedPackFeed;
    public long likeCount;
    public LikeFeed[] likeFeeds;
    public LiveChatMessageProto.LiveChatUserApplyInfoFeed[] liveChatUserApplyInfoFeed;
    public MicSeatsApplyInfoFeed[] micSeatsApplyInfoFeed;
    public NormalNoticeFeed[] noticeFeed;
    public long pendingLikeCount;
    public PurchaseInfoFeed[] purchaseInfoFeed;
    public long pushInterval;
    public LiveStreamRichTextFeed.RichTextFeed[] richTextFeeds;
    public ShareFeed[] shareFeeds;
    public SystemNoticeFeed[] systemNoticeFeeds;
    public long time;
    public ToAudienceDrawingGiftFeed[] toAudienceDrawingGiftFeed;
    public ToAudienceGiftFeed[] toAudienceGiftFeed;
    public VoiceCommentFeed[] voiceCommentFeed;
    public long watchingCount;
    public WatchingFeed[] watchingFeeds;

    public SCFeedPush() {
        clear();
    }

    public static SCFeedPush[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCFeedPush[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCFeedPush clear() {
        this.commentFeeds = CommentFeed.emptyArray();
        this.likeFeeds = LikeFeed.emptyArray();
        this.watchingFeeds = WatchingFeed.emptyArray();
        this.giftFeeds = GiftFeed.emptyArray();
        this.watchingCount = 0;
        this.likeCount = 0;
        this.pendingLikeCount = 0;
        this.pushInterval = 0;
        this.systemNoticeFeeds = SystemNoticeFeed.emptyArray();
        this.drawingGiftFeeds = DrawingGiftFeed.emptyArray();
        this.displayWatchingCount = "";
        this.displayLikeCount = "";
        this.grabRedPackFeed = GrabRedPackFeed.emptyArray();
        this.broadcastGiftFeed = BroadcastGiftFeed.emptyArray();
        this.shareFeeds = ShareFeed.emptyArray();
        this.comboCommentFeed = ComboCommentFeed.emptyArray();
        this.richTextFeeds = LiveStreamRichTextFeed.RichTextFeed.emptyArray();
        this.authorId = 0;
        this.voiceCommentFeed = VoiceCommentFeed.emptyArray();
        this.followAuthorFeed = FollowAuthorFeed.emptyArray();
        this.enterRoomFeed = EnterRoomFeed.emptyArray();
        this.time = 0;
        this.purchaseInfoFeed = PurchaseInfoFeed.emptyArray();
        this.micSeatsApplyInfoFeed = MicSeatsApplyInfoFeed.emptyArray();
        this.noticeFeed = NormalNoticeFeed.emptyArray();
        this.toAudienceGiftFeed = ToAudienceGiftFeed.emptyArray();
        this.liveChatUserApplyInfoFeed = LiveChatMessageProto.LiveChatUserApplyInfoFeed.emptyArray();
        this.toAudienceDrawingGiftFeed = ToAudienceDrawingGiftFeed.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        CommentFeed[] commentFeedArr = this.commentFeeds;
        int i = 0;
        if (commentFeedArr != null && commentFeedArr.length > 0) {
            int i2 = 0;
            while (true) {
                CommentFeed[] commentFeedArr2 = this.commentFeeds;
                if (i2 >= commentFeedArr2.length) {
                    break;
                }
                CommentFeed commentFeed = commentFeedArr2[i2];
                if (commentFeed != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, commentFeed) + computeSerializedSize;
                }
                i2++;
            }
        }
        LikeFeed[] likeFeedArr = this.likeFeeds;
        if (likeFeedArr != null && likeFeedArr.length > 0) {
            int i3 = 0;
            while (true) {
                LikeFeed[] likeFeedArr2 = this.likeFeeds;
                if (i3 >= likeFeedArr2.length) {
                    break;
                }
                LikeFeed likeFeed = likeFeedArr2[i3];
                if (likeFeed != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(2, likeFeed) + computeSerializedSize;
                }
                i3++;
            }
        }
        WatchingFeed[] watchingFeedArr = this.watchingFeeds;
        if (watchingFeedArr != null && watchingFeedArr.length > 0) {
            int i4 = 0;
            while (true) {
                WatchingFeed[] watchingFeedArr2 = this.watchingFeeds;
                if (i4 >= watchingFeedArr2.length) {
                    break;
                }
                WatchingFeed watchingFeed = watchingFeedArr2[i4];
                if (watchingFeed != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, watchingFeed);
                }
                i4++;
            }
        }
        GiftFeed[] giftFeedArr = this.giftFeeds;
        if (giftFeedArr != null && giftFeedArr.length > 0) {
            int i5 = 0;
            while (true) {
                GiftFeed[] giftFeedArr2 = this.giftFeeds;
                if (i5 >= giftFeedArr2.length) {
                    break;
                }
                GiftFeed giftFeed = giftFeedArr2[i5];
                if (giftFeed != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, giftFeed);
                }
                i5++;
            }
        }
        long j = this.watchingCount;
        if (j != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j);
        }
        long j2 = this.likeCount;
        if (j2 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j2);
        }
        long j3 = this.pendingLikeCount;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j3);
        }
        long j4 = this.pushInterval;
        if (j4 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j4);
        }
        SystemNoticeFeed[] systemNoticeFeedArr = this.systemNoticeFeeds;
        if (systemNoticeFeedArr != null && systemNoticeFeedArr.length > 0) {
            int i6 = 0;
            while (true) {
                SystemNoticeFeed[] systemNoticeFeedArr2 = this.systemNoticeFeeds;
                if (i6 >= systemNoticeFeedArr2.length) {
                    break;
                }
                SystemNoticeFeed systemNoticeFeed = systemNoticeFeedArr2[i6];
                if (systemNoticeFeed != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, systemNoticeFeed);
                }
                i6++;
            }
        }
        DrawingGiftFeed[] drawingGiftFeedArr = this.drawingGiftFeeds;
        if (drawingGiftFeedArr != null && drawingGiftFeedArr.length > 0) {
            int i7 = 0;
            while (true) {
                DrawingGiftFeed[] drawingGiftFeedArr2 = this.drawingGiftFeeds;
                if (i7 >= drawingGiftFeedArr2.length) {
                    break;
                }
                DrawingGiftFeed drawingGiftFeed = drawingGiftFeedArr2[i7];
                if (drawingGiftFeed != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, drawingGiftFeed);
                }
                i7++;
            }
        }
        if (!this.displayWatchingCount.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.displayWatchingCount);
        }
        if (!this.displayLikeCount.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.displayLikeCount);
        }
        GrabRedPackFeed[] grabRedPackFeedArr = this.grabRedPackFeed;
        if (grabRedPackFeedArr != null && grabRedPackFeedArr.length > 0) {
            int i8 = 0;
            while (true) {
                GrabRedPackFeed[] grabRedPackFeedArr2 = this.grabRedPackFeed;
                if (i8 >= grabRedPackFeedArr2.length) {
                    break;
                }
                GrabRedPackFeed grabRedPackFeed2 = grabRedPackFeedArr2[i8];
                if (grabRedPackFeed2 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(20, grabRedPackFeed2) + computeSerializedSize;
                }
                i8++;
            }
        }
        BroadcastGiftFeed[] broadcastGiftFeedArr = this.broadcastGiftFeed;
        if (broadcastGiftFeedArr != null && broadcastGiftFeedArr.length > 0) {
            int i9 = 0;
            while (true) {
                BroadcastGiftFeed[] broadcastGiftFeedArr2 = this.broadcastGiftFeed;
                if (i9 >= broadcastGiftFeedArr2.length) {
                    break;
                }
                BroadcastGiftFeed broadcastGiftFeed2 = broadcastGiftFeedArr2[i9];
                if (broadcastGiftFeed2 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(21, broadcastGiftFeed2) + computeSerializedSize;
                }
                i9++;
            }
        }
        ShareFeed[] shareFeedArr = this.shareFeeds;
        if (shareFeedArr != null && shareFeedArr.length > 0) {
            int i10 = 0;
            while (true) {
                ShareFeed[] shareFeedArr2 = this.shareFeeds;
                if (i10 >= shareFeedArr2.length) {
                    break;
                }
                ShareFeed shareFeed = shareFeedArr2[i10];
                if (shareFeed != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(22, shareFeed) + computeSerializedSize;
                }
                i10++;
            }
        }
        ComboCommentFeed[] comboCommentFeedArr = this.comboCommentFeed;
        if (comboCommentFeedArr != null && comboCommentFeedArr.length > 0) {
            int i11 = 0;
            while (true) {
                ComboCommentFeed[] comboCommentFeedArr2 = this.comboCommentFeed;
                if (i11 >= comboCommentFeedArr2.length) {
                    break;
                }
                ComboCommentFeed comboCommentFeed2 = comboCommentFeedArr2[i11];
                if (comboCommentFeed2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(23, comboCommentFeed2);
                }
                i11++;
            }
        }
        LiveStreamRichTextFeed.RichTextFeed[] richTextFeedArr = this.richTextFeeds;
        if (richTextFeedArr != null && richTextFeedArr.length > 0) {
            int i12 = 0;
            while (true) {
                LiveStreamRichTextFeed.RichTextFeed[] richTextFeedArr2 = this.richTextFeeds;
                if (i12 >= richTextFeedArr2.length) {
                    break;
                }
                LiveStreamRichTextFeed.RichTextFeed richTextFeed = richTextFeedArr2[i12];
                if (richTextFeed != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(24, richTextFeed);
                }
                i12++;
            }
        }
        long j5 = this.authorId;
        if (j5 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(25, j5);
        }
        VoiceCommentFeed[] voiceCommentFeedArr = this.voiceCommentFeed;
        if (voiceCommentFeedArr != null && voiceCommentFeedArr.length > 0) {
            int i13 = 0;
            while (true) {
                VoiceCommentFeed[] voiceCommentFeedArr2 = this.voiceCommentFeed;
                if (i13 >= voiceCommentFeedArr2.length) {
                    break;
                }
                VoiceCommentFeed voiceCommentFeed2 = voiceCommentFeedArr2[i13];
                if (voiceCommentFeed2 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(26, voiceCommentFeed2) + computeSerializedSize;
                }
                i13++;
            }
        }
        FollowAuthorFeed[] followAuthorFeedArr = this.followAuthorFeed;
        if (followAuthorFeedArr != null && followAuthorFeedArr.length > 0) {
            int i14 = 0;
            while (true) {
                FollowAuthorFeed[] followAuthorFeedArr2 = this.followAuthorFeed;
                if (i14 >= followAuthorFeedArr2.length) {
                    break;
                }
                FollowAuthorFeed followAuthorFeed2 = followAuthorFeedArr2[i14];
                if (followAuthorFeed2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(27, followAuthorFeed2);
                }
                i14++;
            }
        }
        EnterRoomFeed[] enterRoomFeedArr = this.enterRoomFeed;
        if (enterRoomFeedArr != null && enterRoomFeedArr.length > 0) {
            int i15 = 0;
            while (true) {
                EnterRoomFeed[] enterRoomFeedArr2 = this.enterRoomFeed;
                if (i15 >= enterRoomFeedArr2.length) {
                    break;
                }
                EnterRoomFeed enterRoomFeed2 = enterRoomFeedArr2[i15];
                if (enterRoomFeed2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(28, enterRoomFeed2);
                }
                i15++;
            }
        }
        long j6 = this.time;
        if (j6 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(29, j6);
        }
        PurchaseInfoFeed[] purchaseInfoFeedArr = this.purchaseInfoFeed;
        if (purchaseInfoFeedArr != null && purchaseInfoFeedArr.length > 0) {
            int i16 = 0;
            while (true) {
                PurchaseInfoFeed[] purchaseInfoFeedArr2 = this.purchaseInfoFeed;
                if (i16 >= purchaseInfoFeedArr2.length) {
                    break;
                }
                PurchaseInfoFeed purchaseInfoFeed2 = purchaseInfoFeedArr2[i16];
                if (purchaseInfoFeed2 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(30, purchaseInfoFeed2) + computeSerializedSize;
                }
                i16++;
            }
        }
        MicSeatsApplyInfoFeed[] micSeatsApplyInfoFeedArr = this.micSeatsApplyInfoFeed;
        if (micSeatsApplyInfoFeedArr != null && micSeatsApplyInfoFeedArr.length > 0) {
            int i17 = 0;
            while (true) {
                MicSeatsApplyInfoFeed[] micSeatsApplyInfoFeedArr2 = this.micSeatsApplyInfoFeed;
                if (i17 >= micSeatsApplyInfoFeedArr2.length) {
                    break;
                }
                MicSeatsApplyInfoFeed micSeatsApplyInfoFeed2 = micSeatsApplyInfoFeedArr2[i17];
                if (micSeatsApplyInfoFeed2 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(31, micSeatsApplyInfoFeed2) + computeSerializedSize;
                }
                i17++;
            }
        }
        NormalNoticeFeed[] normalNoticeFeedArr = this.noticeFeed;
        if (normalNoticeFeedArr != null && normalNoticeFeedArr.length > 0) {
            int i18 = 0;
            while (true) {
                NormalNoticeFeed[] normalNoticeFeedArr2 = this.noticeFeed;
                if (i18 >= normalNoticeFeedArr2.length) {
                    break;
                }
                NormalNoticeFeed normalNoticeFeed = normalNoticeFeedArr2[i18];
                if (normalNoticeFeed != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(32, normalNoticeFeed) + computeSerializedSize;
                }
                i18++;
            }
        }
        ToAudienceGiftFeed[] toAudienceGiftFeedArr = this.toAudienceGiftFeed;
        if (toAudienceGiftFeedArr != null && toAudienceGiftFeedArr.length > 0) {
            int i19 = 0;
            while (true) {
                ToAudienceGiftFeed[] toAudienceGiftFeedArr2 = this.toAudienceGiftFeed;
                if (i19 >= toAudienceGiftFeedArr2.length) {
                    break;
                }
                ToAudienceGiftFeed toAudienceGiftFeed2 = toAudienceGiftFeedArr2[i19];
                if (toAudienceGiftFeed2 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(33, toAudienceGiftFeed2) + computeSerializedSize;
                }
                i19++;
            }
        }
        LiveChatMessageProto.LiveChatUserApplyInfoFeed[] liveChatUserApplyInfoFeedArr = this.liveChatUserApplyInfoFeed;
        if (liveChatUserApplyInfoFeedArr != null && liveChatUserApplyInfoFeedArr.length > 0) {
            int i20 = 0;
            while (true) {
                LiveChatMessageProto.LiveChatUserApplyInfoFeed[] liveChatUserApplyInfoFeedArr2 = this.liveChatUserApplyInfoFeed;
                if (i20 >= liveChatUserApplyInfoFeedArr2.length) {
                    break;
                }
                LiveChatMessageProto.LiveChatUserApplyInfoFeed liveChatUserApplyInfoFeed2 = liveChatUserApplyInfoFeedArr2[i20];
                if (liveChatUserApplyInfoFeed2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(34, liveChatUserApplyInfoFeed2);
                }
                i20++;
            }
        }
        ToAudienceDrawingGiftFeed[] toAudienceDrawingGiftFeedArr = this.toAudienceDrawingGiftFeed;
        if (toAudienceDrawingGiftFeedArr != null && toAudienceDrawingGiftFeedArr.length > 0) {
            while (true) {
                ToAudienceDrawingGiftFeed[] toAudienceDrawingGiftFeedArr2 = this.toAudienceDrawingGiftFeed;
                if (i >= toAudienceDrawingGiftFeedArr2.length) {
                    break;
                }
                ToAudienceDrawingGiftFeed toAudienceDrawingGiftFeed2 = toAudienceDrawingGiftFeedArr2[i];
                if (toAudienceDrawingGiftFeed2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(35, toAudienceDrawingGiftFeed2);
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    public static SCFeedPush parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SCFeedPush().mergeFrom(codedInputByteBufferNano);
    }

    public static SCFeedPush parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SCFeedPush) MessageNano.mergeFrom(new SCFeedPush(), bArr);
    }

    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        CommentFeed[] commentFeedArr = this.commentFeeds;
        int i = 0;
        if (commentFeedArr != null && commentFeedArr.length > 0) {
            int i2 = 0;
            while (true) {
                CommentFeed[] commentFeedArr2 = this.commentFeeds;
                if (i2 >= commentFeedArr2.length) {
                    break;
                }
                CommentFeed commentFeed = commentFeedArr2[i2];
                if (commentFeed != null) {
                    codedOutputByteBufferNano.writeMessage(1, commentFeed);
                }
                i2++;
            }
        }
        LikeFeed[] likeFeedArr = this.likeFeeds;
        if (likeFeedArr != null && likeFeedArr.length > 0) {
            int i3 = 0;
            while (true) {
                LikeFeed[] likeFeedArr2 = this.likeFeeds;
                if (i3 >= likeFeedArr2.length) {
                    break;
                }
                LikeFeed likeFeed = likeFeedArr2[i3];
                if (likeFeed != null) {
                    codedOutputByteBufferNano.writeMessage(2, likeFeed);
                }
                i3++;
            }
        }
        WatchingFeed[] watchingFeedArr = this.watchingFeeds;
        if (watchingFeedArr != null && watchingFeedArr.length > 0) {
            int i4 = 0;
            while (true) {
                WatchingFeed[] watchingFeedArr2 = this.watchingFeeds;
                if (i4 >= watchingFeedArr2.length) {
                    break;
                }
                WatchingFeed watchingFeed = watchingFeedArr2[i4];
                if (watchingFeed != null) {
                    codedOutputByteBufferNano.writeMessage(3, watchingFeed);
                }
                i4++;
            }
        }
        GiftFeed[] giftFeedArr = this.giftFeeds;
        if (giftFeedArr != null && giftFeedArr.length > 0) {
            int i5 = 0;
            while (true) {
                GiftFeed[] giftFeedArr2 = this.giftFeeds;
                if (i5 >= giftFeedArr2.length) {
                    break;
                }
                GiftFeed giftFeed = giftFeedArr2[i5];
                if (giftFeed != null) {
                    codedOutputByteBufferNano.writeMessage(4, giftFeed);
                }
                i5++;
            }
        }
        long j = this.watchingCount;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j);
        }
        long j2 = this.likeCount;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j2);
        }
        long j3 = this.pendingLikeCount;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j3);
        }
        long j4 = this.pushInterval;
        if (j4 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j4);
        }
        SystemNoticeFeed[] systemNoticeFeedArr = this.systemNoticeFeeds;
        if (systemNoticeFeedArr != null && systemNoticeFeedArr.length > 0) {
            int i6 = 0;
            while (true) {
                SystemNoticeFeed[] systemNoticeFeedArr2 = this.systemNoticeFeeds;
                if (i6 >= systemNoticeFeedArr2.length) {
                    break;
                }
                SystemNoticeFeed systemNoticeFeed = systemNoticeFeedArr2[i6];
                if (systemNoticeFeed != null) {
                    codedOutputByteBufferNano.writeMessage(9, systemNoticeFeed);
                }
                i6++;
            }
        }
        DrawingGiftFeed[] drawingGiftFeedArr = this.drawingGiftFeeds;
        if (drawingGiftFeedArr != null && drawingGiftFeedArr.length > 0) {
            int i7 = 0;
            while (true) {
                DrawingGiftFeed[] drawingGiftFeedArr2 = this.drawingGiftFeeds;
                if (i7 >= drawingGiftFeedArr2.length) {
                    break;
                }
                DrawingGiftFeed drawingGiftFeed = drawingGiftFeedArr2[i7];
                if (drawingGiftFeed != null) {
                    codedOutputByteBufferNano.writeMessage(10, drawingGiftFeed);
                }
                i7++;
            }
        }
        if (!this.displayWatchingCount.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.displayWatchingCount);
        }
        if (!this.displayLikeCount.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.displayLikeCount);
        }
        GrabRedPackFeed[] grabRedPackFeedArr = this.grabRedPackFeed;
        if (grabRedPackFeedArr != null && grabRedPackFeedArr.length > 0) {
            int i8 = 0;
            while (true) {
                GrabRedPackFeed[] grabRedPackFeedArr2 = this.grabRedPackFeed;
                if (i8 >= grabRedPackFeedArr2.length) {
                    break;
                }
                GrabRedPackFeed grabRedPackFeed2 = grabRedPackFeedArr2[i8];
                if (grabRedPackFeed2 != null) {
                    codedOutputByteBufferNano.writeMessage(20, grabRedPackFeed2);
                }
                i8++;
            }
        }
        BroadcastGiftFeed[] broadcastGiftFeedArr = this.broadcastGiftFeed;
        if (broadcastGiftFeedArr != null && broadcastGiftFeedArr.length > 0) {
            int i9 = 0;
            while (true) {
                BroadcastGiftFeed[] broadcastGiftFeedArr2 = this.broadcastGiftFeed;
                if (i9 >= broadcastGiftFeedArr2.length) {
                    break;
                }
                BroadcastGiftFeed broadcastGiftFeed2 = broadcastGiftFeedArr2[i9];
                if (broadcastGiftFeed2 != null) {
                    codedOutputByteBufferNano.writeMessage(21, broadcastGiftFeed2);
                }
                i9++;
            }
        }
        ShareFeed[] shareFeedArr = this.shareFeeds;
        if (shareFeedArr != null && shareFeedArr.length > 0) {
            int i10 = 0;
            while (true) {
                ShareFeed[] shareFeedArr2 = this.shareFeeds;
                if (i10 >= shareFeedArr2.length) {
                    break;
                }
                ShareFeed shareFeed = shareFeedArr2[i10];
                if (shareFeed != null) {
                    codedOutputByteBufferNano.writeMessage(22, shareFeed);
                }
                i10++;
            }
        }
        ComboCommentFeed[] comboCommentFeedArr = this.comboCommentFeed;
        if (comboCommentFeedArr != null && comboCommentFeedArr.length > 0) {
            int i11 = 0;
            while (true) {
                ComboCommentFeed[] comboCommentFeedArr2 = this.comboCommentFeed;
                if (i11 >= comboCommentFeedArr2.length) {
                    break;
                }
                ComboCommentFeed comboCommentFeed2 = comboCommentFeedArr2[i11];
                if (comboCommentFeed2 != null) {
                    codedOutputByteBufferNano.writeMessage(23, comboCommentFeed2);
                }
                i11++;
            }
        }
        LiveStreamRichTextFeed.RichTextFeed[] richTextFeedArr = this.richTextFeeds;
        if (richTextFeedArr != null && richTextFeedArr.length > 0) {
            int i12 = 0;
            while (true) {
                LiveStreamRichTextFeed.RichTextFeed[] richTextFeedArr2 = this.richTextFeeds;
                if (i12 >= richTextFeedArr2.length) {
                    break;
                }
                LiveStreamRichTextFeed.RichTextFeed richTextFeed = richTextFeedArr2[i12];
                if (richTextFeed != null) {
                    codedOutputByteBufferNano.writeMessage(24, richTextFeed);
                }
                i12++;
            }
        }
        long j5 = this.authorId;
        if (j5 != 0) {
            codedOutputByteBufferNano.writeUInt64(25, j5);
        }
        VoiceCommentFeed[] voiceCommentFeedArr = this.voiceCommentFeed;
        if (voiceCommentFeedArr != null && voiceCommentFeedArr.length > 0) {
            int i13 = 0;
            while (true) {
                VoiceCommentFeed[] voiceCommentFeedArr2 = this.voiceCommentFeed;
                if (i13 >= voiceCommentFeedArr2.length) {
                    break;
                }
                VoiceCommentFeed voiceCommentFeed2 = voiceCommentFeedArr2[i13];
                if (voiceCommentFeed2 != null) {
                    codedOutputByteBufferNano.writeMessage(26, voiceCommentFeed2);
                }
                i13++;
            }
        }
        FollowAuthorFeed[] followAuthorFeedArr = this.followAuthorFeed;
        if (followAuthorFeedArr != null && followAuthorFeedArr.length > 0) {
            int i14 = 0;
            while (true) {
                FollowAuthorFeed[] followAuthorFeedArr2 = this.followAuthorFeed;
                if (i14 >= followAuthorFeedArr2.length) {
                    break;
                }
                FollowAuthorFeed followAuthorFeed2 = followAuthorFeedArr2[i14];
                if (followAuthorFeed2 != null) {
                    codedOutputByteBufferNano.writeMessage(27, followAuthorFeed2);
                }
                i14++;
            }
        }
        EnterRoomFeed[] enterRoomFeedArr = this.enterRoomFeed;
        if (enterRoomFeedArr != null && enterRoomFeedArr.length > 0) {
            int i15 = 0;
            while (true) {
                EnterRoomFeed[] enterRoomFeedArr2 = this.enterRoomFeed;
                if (i15 >= enterRoomFeedArr2.length) {
                    break;
                }
                EnterRoomFeed enterRoomFeed2 = enterRoomFeedArr2[i15];
                if (enterRoomFeed2 != null) {
                    codedOutputByteBufferNano.writeMessage(28, enterRoomFeed2);
                }
                i15++;
            }
        }
        long j6 = this.time;
        if (j6 != 0) {
            codedOutputByteBufferNano.writeUInt64(29, j6);
        }
        PurchaseInfoFeed[] purchaseInfoFeedArr = this.purchaseInfoFeed;
        if (purchaseInfoFeedArr != null && purchaseInfoFeedArr.length > 0) {
            int i16 = 0;
            while (true) {
                PurchaseInfoFeed[] purchaseInfoFeedArr2 = this.purchaseInfoFeed;
                if (i16 >= purchaseInfoFeedArr2.length) {
                    break;
                }
                PurchaseInfoFeed purchaseInfoFeed2 = purchaseInfoFeedArr2[i16];
                if (purchaseInfoFeed2 != null) {
                    codedOutputByteBufferNano.writeMessage(30, purchaseInfoFeed2);
                }
                i16++;
            }
        }
        MicSeatsApplyInfoFeed[] micSeatsApplyInfoFeedArr = this.micSeatsApplyInfoFeed;
        if (micSeatsApplyInfoFeedArr != null && micSeatsApplyInfoFeedArr.length > 0) {
            int i17 = 0;
            while (true) {
                MicSeatsApplyInfoFeed[] micSeatsApplyInfoFeedArr2 = this.micSeatsApplyInfoFeed;
                if (i17 >= micSeatsApplyInfoFeedArr2.length) {
                    break;
                }
                MicSeatsApplyInfoFeed micSeatsApplyInfoFeed2 = micSeatsApplyInfoFeedArr2[i17];
                if (micSeatsApplyInfoFeed2 != null) {
                    codedOutputByteBufferNano.writeMessage(31, micSeatsApplyInfoFeed2);
                }
                i17++;
            }
        }
        NormalNoticeFeed[] normalNoticeFeedArr = this.noticeFeed;
        if (normalNoticeFeedArr != null && normalNoticeFeedArr.length > 0) {
            int i18 = 0;
            while (true) {
                NormalNoticeFeed[] normalNoticeFeedArr2 = this.noticeFeed;
                if (i18 >= normalNoticeFeedArr2.length) {
                    break;
                }
                NormalNoticeFeed normalNoticeFeed = normalNoticeFeedArr2[i18];
                if (normalNoticeFeed != null) {
                    codedOutputByteBufferNano.writeMessage(32, normalNoticeFeed);
                }
                i18++;
            }
        }
        ToAudienceGiftFeed[] toAudienceGiftFeedArr = this.toAudienceGiftFeed;
        if (toAudienceGiftFeedArr != null && toAudienceGiftFeedArr.length > 0) {
            int i19 = 0;
            while (true) {
                ToAudienceGiftFeed[] toAudienceGiftFeedArr2 = this.toAudienceGiftFeed;
                if (i19 >= toAudienceGiftFeedArr2.length) {
                    break;
                }
                ToAudienceGiftFeed toAudienceGiftFeed2 = toAudienceGiftFeedArr2[i19];
                if (toAudienceGiftFeed2 != null) {
                    codedOutputByteBufferNano.writeMessage(33, toAudienceGiftFeed2);
                }
                i19++;
            }
        }
        LiveChatMessageProto.LiveChatUserApplyInfoFeed[] liveChatUserApplyInfoFeedArr = this.liveChatUserApplyInfoFeed;
        if (liveChatUserApplyInfoFeedArr != null && liveChatUserApplyInfoFeedArr.length > 0) {
            int i20 = 0;
            while (true) {
                LiveChatMessageProto.LiveChatUserApplyInfoFeed[] liveChatUserApplyInfoFeedArr2 = this.liveChatUserApplyInfoFeed;
                if (i20 >= liveChatUserApplyInfoFeedArr2.length) {
                    break;
                }
                LiveChatMessageProto.LiveChatUserApplyInfoFeed liveChatUserApplyInfoFeed2 = liveChatUserApplyInfoFeedArr2[i20];
                if (liveChatUserApplyInfoFeed2 != null) {
                    codedOutputByteBufferNano.writeMessage(34, liveChatUserApplyInfoFeed2);
                }
                i20++;
            }
        }
        ToAudienceDrawingGiftFeed[] toAudienceDrawingGiftFeedArr = this.toAudienceDrawingGiftFeed;
        if (toAudienceDrawingGiftFeedArr != null && toAudienceDrawingGiftFeedArr.length > 0) {
            while (true) {
                ToAudienceDrawingGiftFeed[] toAudienceDrawingGiftFeedArr2 = this.toAudienceDrawingGiftFeed;
                if (i >= toAudienceDrawingGiftFeedArr2.length) {
                    break;
                }
                ToAudienceDrawingGiftFeed toAudienceDrawingGiftFeed2 = toAudienceDrawingGiftFeedArr2[i];
                if (toAudienceDrawingGiftFeed2 != null) {
                    codedOutputByteBufferNano.writeMessage(35, toAudienceDrawingGiftFeed2);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public SCFeedPush mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    CommentFeed[] commentFeedArr = this.commentFeeds;
                    if (commentFeedArr == null) {
                        i = 0;
                    } else {
                        i = commentFeedArr.length;
                    }
                    int i21 = repeatedFieldArrayLength + i;
                    CommentFeed[] commentFeedArr2 = new CommentFeed[i21];
                    if (i != 0) {
                        System.arraycopy(this.commentFeeds, 0, commentFeedArr2, 0, i);
                    }
                    while (i < i21 - 1) {
                        commentFeedArr2[i] = new CommentFeed();
                        codedInputByteBufferNano.readMessage(commentFeedArr2[i]);
                        codedInputByteBufferNano.readTag();
                        i++;
                    }
                    commentFeedArr2[i] = new CommentFeed();
                    codedInputByteBufferNano.readMessage(commentFeedArr2[i]);
                    this.commentFeeds = commentFeedArr2;
                    break;
                case 18:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    LikeFeed[] likeFeedArr = this.likeFeeds;
                    if (likeFeedArr == null) {
                        i2 = 0;
                    } else {
                        i2 = likeFeedArr.length;
                    }
                    int i22 = repeatedFieldArrayLength2 + i2;
                    LikeFeed[] likeFeedArr2 = new LikeFeed[i22];
                    if (i2 != 0) {
                        System.arraycopy(this.likeFeeds, 0, likeFeedArr2, 0, i2);
                    }
                    while (i2 < i22 - 1) {
                        likeFeedArr2[i2] = new LikeFeed();
                        codedInputByteBufferNano.readMessage(likeFeedArr2[i2]);
                        codedInputByteBufferNano.readTag();
                        i2++;
                    }
                    likeFeedArr2[i2] = new LikeFeed();
                    codedInputByteBufferNano.readMessage(likeFeedArr2[i2]);
                    this.likeFeeds = likeFeedArr2;
                    break;
                case 26:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    WatchingFeed[] watchingFeedArr = this.watchingFeeds;
                    if (watchingFeedArr == null) {
                        i3 = 0;
                    } else {
                        i3 = watchingFeedArr.length;
                    }
                    int i23 = repeatedFieldArrayLength3 + i3;
                    WatchingFeed[] watchingFeedArr2 = new WatchingFeed[i23];
                    if (i3 != 0) {
                        System.arraycopy(this.watchingFeeds, 0, watchingFeedArr2, 0, i3);
                    }
                    while (i3 < i23 - 1) {
                        watchingFeedArr2[i3] = new WatchingFeed();
                        codedInputByteBufferNano.readMessage(watchingFeedArr2[i3]);
                        codedInputByteBufferNano.readTag();
                        i3++;
                    }
                    watchingFeedArr2[i3] = new WatchingFeed();
                    codedInputByteBufferNano.readMessage(watchingFeedArr2[i3]);
                    this.watchingFeeds = watchingFeedArr2;
                    break;
                case 34:
                    int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    GiftFeed[] giftFeedArr = this.giftFeeds;
                    if (giftFeedArr == null) {
                        i4 = 0;
                    } else {
                        i4 = giftFeedArr.length;
                    }
                    int i24 = repeatedFieldArrayLength4 + i4;
                    GiftFeed[] giftFeedArr2 = new GiftFeed[i24];
                    if (i4 != 0) {
                        System.arraycopy(this.giftFeeds, 0, giftFeedArr2, 0, i4);
                    }
                    while (i4 < i24 - 1) {
                        giftFeedArr2[i4] = new GiftFeed();
                        codedInputByteBufferNano.readMessage(giftFeedArr2[i4]);
                        codedInputByteBufferNano.readTag();
                        i4++;
                    }
                    giftFeedArr2[i4] = new GiftFeed();
                    codedInputByteBufferNano.readMessage(giftFeedArr2[i4]);
                    this.giftFeeds = giftFeedArr2;
                    break;
                case 40:
                    this.watchingCount = codedInputByteBufferNano.readUInt64();
                    break;
                case 48:
                    this.likeCount = codedInputByteBufferNano.readUInt64();
                    break;
                case 56:
                    this.pendingLikeCount = codedInputByteBufferNano.readUInt64();
                    break;
                case 64:
                    this.pushInterval = codedInputByteBufferNano.readUInt64();
                    break;
                case 74:
                    int repeatedFieldArrayLength5 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 74);
                    SystemNoticeFeed[] systemNoticeFeedArr = this.systemNoticeFeeds;
                    if (systemNoticeFeedArr == null) {
                        i5 = 0;
                    } else {
                        i5 = systemNoticeFeedArr.length;
                    }
                    int i25 = repeatedFieldArrayLength5 + i5;
                    SystemNoticeFeed[] systemNoticeFeedArr2 = new SystemNoticeFeed[i25];
                    if (i5 != 0) {
                        System.arraycopy(this.systemNoticeFeeds, 0, systemNoticeFeedArr2, 0, i5);
                    }
                    while (i5 < i25 - 1) {
                        systemNoticeFeedArr2[i5] = new SystemNoticeFeed();
                        codedInputByteBufferNano.readMessage(systemNoticeFeedArr2[i5]);
                        codedInputByteBufferNano.readTag();
                        i5++;
                    }
                    systemNoticeFeedArr2[i5] = new SystemNoticeFeed();
                    codedInputByteBufferNano.readMessage(systemNoticeFeedArr2[i5]);
                    this.systemNoticeFeeds = systemNoticeFeedArr2;
                    break;
                case 82:
                    int repeatedFieldArrayLength6 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                    DrawingGiftFeed[] drawingGiftFeedArr = this.drawingGiftFeeds;
                    if (drawingGiftFeedArr == null) {
                        i6 = 0;
                    } else {
                        i6 = drawingGiftFeedArr.length;
                    }
                    int i26 = repeatedFieldArrayLength6 + i6;
                    DrawingGiftFeed[] drawingGiftFeedArr2 = new DrawingGiftFeed[i26];
                    if (i6 != 0) {
                        System.arraycopy(this.drawingGiftFeeds, 0, drawingGiftFeedArr2, 0, i6);
                    }
                    while (i6 < i26 - 1) {
                        drawingGiftFeedArr2[i6] = new DrawingGiftFeed();
                        codedInputByteBufferNano.readMessage(drawingGiftFeedArr2[i6]);
                        codedInputByteBufferNano.readTag();
                        i6++;
                    }
                    drawingGiftFeedArr2[i6] = new DrawingGiftFeed();
                    codedInputByteBufferNano.readMessage(drawingGiftFeedArr2[i6]);
                    this.drawingGiftFeeds = drawingGiftFeedArr2;
                    break;
                case 90:
                    this.displayWatchingCount = codedInputByteBufferNano.readString();
                    break;
                case 98:
                    this.displayLikeCount = codedInputByteBufferNano.readString();
                    break;
                case 162:
                    int repeatedFieldArrayLength7 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 162);
                    GrabRedPackFeed[] grabRedPackFeedArr = this.grabRedPackFeed;
                    if (grabRedPackFeedArr == null) {
                        i7 = 0;
                    } else {
                        i7 = grabRedPackFeedArr.length;
                    }
                    int i27 = repeatedFieldArrayLength7 + i7;
                    GrabRedPackFeed[] grabRedPackFeedArr2 = new GrabRedPackFeed[i27];
                    if (i7 != 0) {
                        System.arraycopy(this.grabRedPackFeed, 0, grabRedPackFeedArr2, 0, i7);
                    }
                    while (i7 < i27 - 1) {
                        grabRedPackFeedArr2[i7] = new GrabRedPackFeed();
                        codedInputByteBufferNano.readMessage(grabRedPackFeedArr2[i7]);
                        codedInputByteBufferNano.readTag();
                        i7++;
                    }
                    grabRedPackFeedArr2[i7] = new GrabRedPackFeed();
                    codedInputByteBufferNano.readMessage(grabRedPackFeedArr2[i7]);
                    this.grabRedPackFeed = grabRedPackFeedArr2;
                    break;
                case 170:
                    int repeatedFieldArrayLength8 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 170);
                    BroadcastGiftFeed[] broadcastGiftFeedArr = this.broadcastGiftFeed;
                    if (broadcastGiftFeedArr == null) {
                        i8 = 0;
                    } else {
                        i8 = broadcastGiftFeedArr.length;
                    }
                    int i28 = repeatedFieldArrayLength8 + i8;
                    BroadcastGiftFeed[] broadcastGiftFeedArr2 = new BroadcastGiftFeed[i28];
                    if (i8 != 0) {
                        System.arraycopy(this.broadcastGiftFeed, 0, broadcastGiftFeedArr2, 0, i8);
                    }
                    while (i8 < i28 - 1) {
                        broadcastGiftFeedArr2[i8] = new BroadcastGiftFeed();
                        codedInputByteBufferNano.readMessage(broadcastGiftFeedArr2[i8]);
                        codedInputByteBufferNano.readTag();
                        i8++;
                    }
                    broadcastGiftFeedArr2[i8] = new BroadcastGiftFeed();
                    codedInputByteBufferNano.readMessage(broadcastGiftFeedArr2[i8]);
                    this.broadcastGiftFeed = broadcastGiftFeedArr2;
                    break;
                case 178:
                    int repeatedFieldArrayLength9 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 178);
                    ShareFeed[] shareFeedArr = this.shareFeeds;
                    if (shareFeedArr == null) {
                        i9 = 0;
                    } else {
                        i9 = shareFeedArr.length;
                    }
                    int i29 = repeatedFieldArrayLength9 + i9;
                    ShareFeed[] shareFeedArr2 = new ShareFeed[i29];
                    if (i9 != 0) {
                        System.arraycopy(this.shareFeeds, 0, shareFeedArr2, 0, i9);
                    }
                    while (i9 < i29 - 1) {
                        shareFeedArr2[i9] = new ShareFeed();
                        codedInputByteBufferNano.readMessage(shareFeedArr2[i9]);
                        codedInputByteBufferNano.readTag();
                        i9++;
                    }
                    shareFeedArr2[i9] = new ShareFeed();
                    codedInputByteBufferNano.readMessage(shareFeedArr2[i9]);
                    this.shareFeeds = shareFeedArr2;
                    break;
                case 186:
                    int repeatedFieldArrayLength10 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 186);
                    ComboCommentFeed[] comboCommentFeedArr = this.comboCommentFeed;
                    if (comboCommentFeedArr == null) {
                        i10 = 0;
                    } else {
                        i10 = comboCommentFeedArr.length;
                    }
                    int i30 = repeatedFieldArrayLength10 + i10;
                    ComboCommentFeed[] comboCommentFeedArr2 = new ComboCommentFeed[i30];
                    if (i10 != 0) {
                        System.arraycopy(this.comboCommentFeed, 0, comboCommentFeedArr2, 0, i10);
                    }
                    while (i10 < i30 - 1) {
                        comboCommentFeedArr2[i10] = new ComboCommentFeed();
                        codedInputByteBufferNano.readMessage(comboCommentFeedArr2[i10]);
                        codedInputByteBufferNano.readTag();
                        i10++;
                    }
                    comboCommentFeedArr2[i10] = new ComboCommentFeed();
                    codedInputByteBufferNano.readMessage(comboCommentFeedArr2[i10]);
                    this.comboCommentFeed = comboCommentFeedArr2;
                    break;
                case 194:
                    int repeatedFieldArrayLength11 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 194);
                    LiveStreamRichTextFeed.RichTextFeed[] richTextFeedArr = this.richTextFeeds;
                    if (richTextFeedArr == null) {
                        i11 = 0;
                    } else {
                        i11 = richTextFeedArr.length;
                    }
                    int i31 = repeatedFieldArrayLength11 + i11;
                    LiveStreamRichTextFeed.RichTextFeed[] richTextFeedArr2 = new LiveStreamRichTextFeed.RichTextFeed[i31];
                    if (i11 != 0) {
                        System.arraycopy(this.richTextFeeds, 0, richTextFeedArr2, 0, i11);
                    }
                    while (i11 < i31 - 1) {
                        richTextFeedArr2[i11] = new LiveStreamRichTextFeed.RichTextFeed();
                        codedInputByteBufferNano.readMessage(richTextFeedArr2[i11]);
                        codedInputByteBufferNano.readTag();
                        i11++;
                    }
                    richTextFeedArr2[i11] = new LiveStreamRichTextFeed.RichTextFeed();
                    codedInputByteBufferNano.readMessage(richTextFeedArr2[i11]);
                    this.richTextFeeds = richTextFeedArr2;
                    break;
                case 200:
                    this.authorId = codedInputByteBufferNano.readUInt64();
                    break;
                case 210:
                    int repeatedFieldArrayLength12 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 210);
                    VoiceCommentFeed[] voiceCommentFeedArr = this.voiceCommentFeed;
                    if (voiceCommentFeedArr == null) {
                        i12 = 0;
                    } else {
                        i12 = voiceCommentFeedArr.length;
                    }
                    int i32 = repeatedFieldArrayLength12 + i12;
                    VoiceCommentFeed[] voiceCommentFeedArr2 = new VoiceCommentFeed[i32];
                    if (i12 != 0) {
                        System.arraycopy(this.voiceCommentFeed, 0, voiceCommentFeedArr2, 0, i12);
                    }
                    while (i12 < i32 - 1) {
                        voiceCommentFeedArr2[i12] = new VoiceCommentFeed();
                        codedInputByteBufferNano.readMessage(voiceCommentFeedArr2[i12]);
                        codedInputByteBufferNano.readTag();
                        i12++;
                    }
                    voiceCommentFeedArr2[i12] = new VoiceCommentFeed();
                    codedInputByteBufferNano.readMessage(voiceCommentFeedArr2[i12]);
                    this.voiceCommentFeed = voiceCommentFeedArr2;
                    break;
                case 218:
                    int repeatedFieldArrayLength13 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 218);
                    FollowAuthorFeed[] followAuthorFeedArr = this.followAuthorFeed;
                    if (followAuthorFeedArr == null) {
                        i13 = 0;
                    } else {
                        i13 = followAuthorFeedArr.length;
                    }
                    int i33 = repeatedFieldArrayLength13 + i13;
                    FollowAuthorFeed[] followAuthorFeedArr2 = new FollowAuthorFeed[i33];
                    if (i13 != 0) {
                        System.arraycopy(this.followAuthorFeed, 0, followAuthorFeedArr2, 0, i13);
                    }
                    while (i13 < i33 - 1) {
                        followAuthorFeedArr2[i13] = new FollowAuthorFeed();
                        codedInputByteBufferNano.readMessage(followAuthorFeedArr2[i13]);
                        codedInputByteBufferNano.readTag();
                        i13++;
                    }
                    followAuthorFeedArr2[i13] = new FollowAuthorFeed();
                    codedInputByteBufferNano.readMessage(followAuthorFeedArr2[i13]);
                    this.followAuthorFeed = followAuthorFeedArr2;
                    break;
                case 226:
                    int repeatedFieldArrayLength14 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 226);
                    EnterRoomFeed[] enterRoomFeedArr = this.enterRoomFeed;
                    if (enterRoomFeedArr == null) {
                        i14 = 0;
                    } else {
                        i14 = enterRoomFeedArr.length;
                    }
                    int i34 = repeatedFieldArrayLength14 + i14;
                    EnterRoomFeed[] enterRoomFeedArr2 = new EnterRoomFeed[i34];
                    if (i14 != 0) {
                        System.arraycopy(this.enterRoomFeed, 0, enterRoomFeedArr2, 0, i14);
                    }
                    while (i14 < i34 - 1) {
                        enterRoomFeedArr2[i14] = new EnterRoomFeed();
                        codedInputByteBufferNano.readMessage(enterRoomFeedArr2[i14]);
                        codedInputByteBufferNano.readTag();
                        i14++;
                    }
                    enterRoomFeedArr2[i14] = new EnterRoomFeed();
                    codedInputByteBufferNano.readMessage(enterRoomFeedArr2[i14]);
                    this.enterRoomFeed = enterRoomFeedArr2;
                    break;
                case 232:
                    this.time = codedInputByteBufferNano.readUInt64();
                    break;
                case 242:
                    int repeatedFieldArrayLength15 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 242);
                    PurchaseInfoFeed[] purchaseInfoFeedArr = this.purchaseInfoFeed;
                    if (purchaseInfoFeedArr == null) {
                        i15 = 0;
                    } else {
                        i15 = purchaseInfoFeedArr.length;
                    }
                    int i35 = repeatedFieldArrayLength15 + i15;
                    PurchaseInfoFeed[] purchaseInfoFeedArr2 = new PurchaseInfoFeed[i35];
                    if (i15 != 0) {
                        System.arraycopy(this.purchaseInfoFeed, 0, purchaseInfoFeedArr2, 0, i15);
                    }
                    while (i15 < i35 - 1) {
                        purchaseInfoFeedArr2[i15] = new PurchaseInfoFeed();
                        codedInputByteBufferNano.readMessage(purchaseInfoFeedArr2[i15]);
                        codedInputByteBufferNano.readTag();
                        i15++;
                    }
                    purchaseInfoFeedArr2[i15] = new PurchaseInfoFeed();
                    codedInputByteBufferNano.readMessage(purchaseInfoFeedArr2[i15]);
                    this.purchaseInfoFeed = purchaseInfoFeedArr2;
                    break;
                case 250:
                    int repeatedFieldArrayLength16 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 250);
                    MicSeatsApplyInfoFeed[] micSeatsApplyInfoFeedArr = this.micSeatsApplyInfoFeed;
                    if (micSeatsApplyInfoFeedArr == null) {
                        i16 = 0;
                    } else {
                        i16 = micSeatsApplyInfoFeedArr.length;
                    }
                    int i36 = repeatedFieldArrayLength16 + i16;
                    MicSeatsApplyInfoFeed[] micSeatsApplyInfoFeedArr2 = new MicSeatsApplyInfoFeed[i36];
                    if (i16 != 0) {
                        System.arraycopy(this.micSeatsApplyInfoFeed, 0, micSeatsApplyInfoFeedArr2, 0, i16);
                    }
                    while (i16 < i36 - 1) {
                        micSeatsApplyInfoFeedArr2[i16] = new MicSeatsApplyInfoFeed();
                        codedInputByteBufferNano.readMessage(micSeatsApplyInfoFeedArr2[i16]);
                        codedInputByteBufferNano.readTag();
                        i16++;
                    }
                    micSeatsApplyInfoFeedArr2[i16] = new MicSeatsApplyInfoFeed();
                    codedInputByteBufferNano.readMessage(micSeatsApplyInfoFeedArr2[i16]);
                    this.micSeatsApplyInfoFeed = micSeatsApplyInfoFeedArr2;
                    break;
                case 258:
                    int repeatedFieldArrayLength17 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 258);
                    NormalNoticeFeed[] normalNoticeFeedArr = this.noticeFeed;
                    if (normalNoticeFeedArr == null) {
                        i17 = 0;
                    } else {
                        i17 = normalNoticeFeedArr.length;
                    }
                    int i37 = repeatedFieldArrayLength17 + i17;
                    NormalNoticeFeed[] normalNoticeFeedArr2 = new NormalNoticeFeed[i37];
                    if (i17 != 0) {
                        System.arraycopy(this.noticeFeed, 0, normalNoticeFeedArr2, 0, i17);
                    }
                    while (i17 < i37 - 1) {
                        normalNoticeFeedArr2[i17] = new NormalNoticeFeed();
                        codedInputByteBufferNano.readMessage(normalNoticeFeedArr2[i17]);
                        codedInputByteBufferNano.readTag();
                        i17++;
                    }
                    normalNoticeFeedArr2[i17] = new NormalNoticeFeed();
                    codedInputByteBufferNano.readMessage(normalNoticeFeedArr2[i17]);
                    this.noticeFeed = normalNoticeFeedArr2;
                    break;
                case 266:
                        int repeatedFieldArrayLength18 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 266);
                    ToAudienceGiftFeed[] toAudienceGiftFeedArr = this.toAudienceGiftFeed;
                    if (toAudienceGiftFeedArr == null) {
                        i18 = 0;
                    } else {
                        i18 = toAudienceGiftFeedArr.length;
                    }
                    int i38 = repeatedFieldArrayLength18 + i18;
                    ToAudienceGiftFeed[] toAudienceGiftFeedArr2 = new ToAudienceGiftFeed[i38];
                    if (i18 != 0) {
                        System.arraycopy(this.toAudienceGiftFeed, 0, toAudienceGiftFeedArr2, 0, i18);
                    }
                    while (i18 < i38 - 1) {
                        toAudienceGiftFeedArr2[i18] = new ToAudienceGiftFeed();
                        codedInputByteBufferNano.readMessage(toAudienceGiftFeedArr2[i18]);
                        codedInputByteBufferNano.readTag();
                        i18++;
                    }
                    toAudienceGiftFeedArr2[i18] = new ToAudienceGiftFeed();
                    codedInputByteBufferNano.readMessage(toAudienceGiftFeedArr2[i18]);
                    this.toAudienceGiftFeed = toAudienceGiftFeedArr2;
                    break;
                case 274:
                    int repeatedFieldArrayLength19 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 274);
                    LiveChatMessageProto.LiveChatUserApplyInfoFeed[] liveChatUserApplyInfoFeedArr = this.liveChatUserApplyInfoFeed;
                    if (liveChatUserApplyInfoFeedArr == null) {
                        i19 = 0;
                    } else {
                        i19 = liveChatUserApplyInfoFeedArr.length;
                    }
                    int i39 = repeatedFieldArrayLength19 + i19;
                    LiveChatMessageProto.LiveChatUserApplyInfoFeed[] liveChatUserApplyInfoFeedArr2 = new LiveChatMessageProto.LiveChatUserApplyInfoFeed[i39];
                    if (i19 != 0) {
                        System.arraycopy(this.liveChatUserApplyInfoFeed, 0, liveChatUserApplyInfoFeedArr2, 0, i19);
                    }
                    while (i19 < i39 - 1) {
                        liveChatUserApplyInfoFeedArr2[i19] = new LiveChatMessageProto.LiveChatUserApplyInfoFeed();
                        codedInputByteBufferNano.readMessage(liveChatUserApplyInfoFeedArr2[i19]);
                        codedInputByteBufferNano.readTag();
                        i19++;
                    }
                    liveChatUserApplyInfoFeedArr2[i19] = new LiveChatMessageProto.LiveChatUserApplyInfoFeed();
                    codedInputByteBufferNano.readMessage(liveChatUserApplyInfoFeedArr2[i19]);
                    this.liveChatUserApplyInfoFeed = liveChatUserApplyInfoFeedArr2;
                    break;
                case 282:
                    int repeatedFieldArrayLength20 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 282);
                    ToAudienceDrawingGiftFeed[] toAudienceDrawingGiftFeedArr = this.toAudienceDrawingGiftFeed;
                    if (toAudienceDrawingGiftFeedArr == null) {
                        i20 = 0;
                    } else {
                        i20 = toAudienceDrawingGiftFeedArr.length;
                    }
                    int i40 = repeatedFieldArrayLength20 + i20;
                    ToAudienceDrawingGiftFeed[] toAudienceDrawingGiftFeedArr2 = new ToAudienceDrawingGiftFeed[i40];
                    if (i20 != 0) {
                        System.arraycopy(this.toAudienceDrawingGiftFeed, 0, toAudienceDrawingGiftFeedArr2, 0, i20);
                    }
                    while (i20 < i40 - 1) {
                        toAudienceDrawingGiftFeedArr2[i20] = new ToAudienceDrawingGiftFeed();
                        codedInputByteBufferNano.readMessage(toAudienceDrawingGiftFeedArr2[i20]);
                        codedInputByteBufferNano.readTag();
                        i20++;
                    }
                    toAudienceDrawingGiftFeedArr2[i20] = new ToAudienceDrawingGiftFeed();
                    codedInputByteBufferNano.readMessage(toAudienceDrawingGiftFeedArr2[i20]);
                    this.toAudienceDrawingGiftFeed = toAudienceDrawingGiftFeedArr2;
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



}
