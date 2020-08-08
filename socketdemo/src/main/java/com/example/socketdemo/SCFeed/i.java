package com.example.socketdemo.SCFeed;


import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

import java.io.IOException;
import java.util.Arrays;

public final class i extends MessageNano {
    /* renamed from: a */
    public int a = 0;

    /* renamed from: b */
    public int b = 0;

    /* renamed from: c */
    public byte[] c = WireFormatNano.EMPTY_BYTES;

    /* renamed from: d */
    public long d = 0;

    /* renamed from: e */
    public String e = "";

    public i() {
        this.cachedSize = -1;
    }

    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i = this.a;
        if (i != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        int i2 = this.b;
        if (i2 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i2);
        }
        if (!Arrays.equals(this.c, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.c);
        }
        long j = this.d;
        if (j != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
        }
        if (!this.e.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.e);
        }
        return computeSerializedSize;
    }

    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i = this.a;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        int i2 = this.b;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i2);
        }
        if (!Arrays.equals(this.c, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(3, this.c);
        }
        long j = this.d;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j);
        }
        if (!this.e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.e);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 8) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (!(readInt32 == 0 || readInt32 == 1 || readInt32 == 3 || readInt32 == 4 || readInt32 == 370 || readInt32 == 371 || readInt32 == 390 || readInt32 == 391)) {
                    switch (readInt32) {
                        case 51:
                        case 340:
                        case 414:
                        case 415:
                        case 416:
                        case 417:
                        case 418:
                        case 419:
                        case 420:
                        case 421:
                        case 422:
                        case 423:
                        case 424:
                        case 425:
                        case 426:
                        case 427:
                        case 480:
                        case 481:
                        case 482:
                        case 483:
                        case 490:
                        case 491:
                        case 500:
                        case 501:
                        case 510:
                        case 511:
                        case 521:
                        case 522:
                        case 531:
                        case 541:
                        case 542:
                        case 550:
                        case 551:
                        case 552:
                        case 553:
                        case 560:
                        case 561:
                        case 562:
                        case 565:
                        case 570:
                        case 571:
                        case 581:
                        case 582:
                        case 583:
                        case 584:
                        case 585:
                        case 586:
                        case 587:
                        case 588:
                        case 590:
                        case 591:
                        case 592:
                        case 593:
                        case 594:
                        case 595:
                        case 596:
                        case 600:
                        case 601:
                        case 602:
                        case 603:
                        case 604:
                        case 605:
                        case 606:
                        case 607:
                        case 608:
                        case 610:
                        case 611:
                        case 612:
                        case 613:
                        case 614:
                        case 615:
                        case 620:
                        case 621:
                        case 622:
                        case 623:
                        case 630:
                        case 631:
                        case 632:
                        case 633:
                        case 634:
                        case 641:
                        case 642:
                        case 643:
                        case 644:
                        case 645:
                        case 646:
                        case 647:
                        case 648:
                        case 649:
                        case 650:
                        case 651:
                            break;
                        default:
                            switch (readInt32) {
                                case 320:
                                case 321:
                                case 322:
                                case 323:
                                case 324:
                                case 325:
                                case 326:
                                case 327:
                                case 328:
                                case 329:
                                case 330:
                                case 331:
                                    break;
                                default:
                                    switch (readInt32) {
                                        case 380:
                                        case 381:
                                        case 382:
                                        case 383:
                                        case 384:
                                        case 385:
                                        case 386:
                                        case 387:
                                            break;
                                        default:
                                            switch (readInt32) {
                                                case 399:
                                                case 400:
                                                case 401:
                                                case 402:
                                                case 403:
                                                    break;
                                                default:
                                                    switch (readInt32) {
                                                        case 410:
                                                        case 411:
                                                        case 412:
                                                            break;
                                                        default:
                                                            switch (readInt32) {
                                                                case 430:
                                                                case 431:
                                                                case 432:
                                                                case 433:
                                                                case 434:
                                                                case 435:
                                                                case 436:
                                                                case 437:
                                                                case 438:
                                                                case 439:
                                                                case 440:
                                                                case 441:
                                                                case 442:
                                                                    break;
                                                                default:
                                                                    switch (readInt32) {
                                                                        case 460:
                                                                        case 461:
                                                                        case 462:
                                                                        case 463:
                                                                            break;
                                                                        default:
                                                                            switch (readInt32) {
                                                                                case 470:
                                                                                case 471:
                                                                                case 472:
                                                                                    break;
                                                                                default:
                                                                                    switch (readInt32) {
                                                                                        case 474:
                                                                                        case 475:
                                                                                        case 476:
                                                                                        case 477:
                                                                                        case 478:
                                                                                            break;
                                                                                        default:
                                                                                            switch (readInt32) {
                                                                                                case 101:
                                                                                                case 102:
                                                                                                case 103:
                                                                                                case 104:
                                                                                                case 105:
                                                                                                    break;
                                                                                                default:
                                                                                                    switch (readInt32) {
                                                                                                        case 200:
                                                                                                        case 201:
                                                                                                        case 202:
                                                                                                        case 203:
                                                                                                        case 204:
                                                                                                        case 205:
                                                                                                        case 206:
                                                                                                            break;
                                                                                                        default:
                                                                                                            switch (readInt32) {
                                                                                                                case 300:
                                                                                                                case 301:
                                                                                                                case 302:
                                                                                                                case 303:
                                                                                                                case 304:
                                                                                                                case 305:
                                                                                                                case 306:
                                                                                                                case 307:
                                                                                                                case 308:
                                                                                                                    break;
                                                                                                                default:
                                                                                                                    switch (readInt32) {
                                                                                                                        case 310:
                                                                                                                        case 311:
                                                                                                                        case 312:
                                                                                                                            break;
                                                                                                                        default:
                                                                                                                            switch (readInt32) {
                                                                                                                                case 350:
                                                                                                                                case 351:
                                                                                                                                case 352:
                                                                                                                                case 353:
                                                                                                                                case 354:
                                                                                                                                case 355:
                                                                                                                                case 356:
                                                                                                                                case 357:
                                                                                                                                    break;
                                                                                                                                default:
                                                                                                                                    switch (readInt32) {
                                                                                                                                        case 360:
                                                                                                                                        case 361:
                                                                                                                                        case 362:
                                                                                                                                        case 363:
                                                                                                                                            break;
                                                                                                                                        default:
                                                                                                                                            continue;
                                                                                                                                    }
                                                                                                                            }
                                                                                                                    }
                                                                                                            }
                                                                                                    }
                                                                                            }
                                                                                    }
                                                                            }
                                                                    }
                                                            }
                                                    }
                                            }
                                    }
                            }
                    }
                }
                this.a = readInt32;
            } else if (readTag == 16) {
                int readInt322 = codedInputByteBufferNano.readInt32();
                if (readInt322 == 0 || readInt322 == 1 || readInt322 == 2 || readInt322 == 3) {
                    this.b = readInt322;
                }
            } else if (readTag == 26) {
                this.c = codedInputByteBufferNano.readBytes();
            } else if (readTag == 32) {
                this.d = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 42) {
                this.e = codedInputByteBufferNano.readString();
            } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                break;
            }
        }
        return this;
    }

}
