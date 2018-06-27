package com.baidu.trace;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import java.util.ArrayList;
import java.util.List;

public final class p
  extends PhoneStateListener
{
  public static int a = 0;
  private TelephonyManager b;
  private List<Integer> c = new ArrayList();
  private List<Integer> d = new ArrayList();
  private int e = 0;
  private a f = null;
  private int g = 0;
  private int h;
  private String i = "";
  private int j;
  private int k;
  
  public p(Context paramContext)
  {
    this.b = ((TelephonyManager)paramContext.getSystemService("phone"));
    this.f = new a();
    if (this.b != null) {
      this.b.listen(this.f, 256);
    }
  }
  
  /* Error */
  protected final void a(com.baidu.trace.a.c paramc)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_1
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 61	com/baidu/trace/p:b	Landroid/telephony/TelephonyManager;
    //   12: ifnonnull +9 -> 21
    //   15: aload_1
    //   16: iconst_0
    //   17: putfield 76	com/baidu/trace/a/c:a	Z
    //   20: return
    //   21: aload_0
    //   22: getfield 49	com/baidu/trace/p:i	Ljava/lang/String;
    //   25: invokestatic 82	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifeq +14 -> 42
    //   31: aload_0
    //   32: aload_0
    //   33: getfield 61	com/baidu/trace/p:b	Landroid/telephony/TelephonyManager;
    //   36: invokevirtual 86	android/telephony/TelephonyManager:getNetworkOperator	()Ljava/lang/String;
    //   39: putfield 49	com/baidu/trace/p:i	Ljava/lang/String;
    //   42: aload_0
    //   43: getfield 45	com/baidu/trace/p:g	I
    //   46: ifne +37 -> 83
    //   49: aload_0
    //   50: getfield 49	com/baidu/trace/p:i	Ljava/lang/String;
    //   53: ifnull +365 -> 418
    //   56: aload_0
    //   57: getfield 49	com/baidu/trace/p:i	Ljava/lang/String;
    //   60: invokevirtual 92	java/lang/String:length	()I
    //   63: iconst_3
    //   64: if_icmplt +354 -> 418
    //   67: aload_0
    //   68: aload_0
    //   69: getfield 49	com/baidu/trace/p:i	Ljava/lang/String;
    //   72: iconst_0
    //   73: iconst_3
    //   74: invokevirtual 96	java/lang/String:substring	(II)Ljava/lang/String;
    //   77: invokestatic 102	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   80: putfield 45	com/baidu/trace/p:g	I
    //   83: aload_0
    //   84: getfield 61	com/baidu/trace/p:b	Landroid/telephony/TelephonyManager;
    //   87: invokevirtual 106	android/telephony/TelephonyManager:getCellLocation	()Landroid/telephony/CellLocation;
    //   90: astore 8
    //   92: aload 8
    //   94: instanceof 108
    //   97: ifeq +339 -> 436
    //   100: aload 8
    //   102: checkcast 108	android/telephony/gsm/GsmCellLocation
    //   105: astore 8
    //   107: aload_0
    //   108: getfield 49	com/baidu/trace/p:i	Ljava/lang/String;
    //   111: ifnull +317 -> 428
    //   114: aload_0
    //   115: getfield 49	com/baidu/trace/p:i	Ljava/lang/String;
    //   118: invokevirtual 92	java/lang/String:length	()I
    //   121: iconst_5
    //   122: if_icmplt +306 -> 428
    //   125: aload_0
    //   126: aload_0
    //   127: getfield 49	com/baidu/trace/p:i	Ljava/lang/String;
    //   130: iconst_3
    //   131: invokevirtual 111	java/lang/String:substring	(I)Ljava/lang/String;
    //   134: invokestatic 102	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   137: putfield 113	com/baidu/trace/p:h	I
    //   140: aload_0
    //   141: iconst_1
    //   142: putfield 41	com/baidu/trace/p:e	I
    //   145: aload_0
    //   146: aload 8
    //   148: invokevirtual 116	android/telephony/gsm/GsmCellLocation:getLac	()I
    //   151: putfield 118	com/baidu/trace/p:j	I
    //   154: aload_0
    //   155: aload 8
    //   157: invokevirtual 121	android/telephony/gsm/GsmCellLocation:getCid	()I
    //   160: putfield 123	com/baidu/trace/p:k	I
    //   163: aload_0
    //   164: getfield 39	com/baidu/trace/p:d	Ljava/util/List;
    //   167: ifnull +376 -> 543
    //   170: aload_0
    //   171: getfield 39	com/baidu/trace/p:d	Ljava/util/List;
    //   174: invokeinterface 128 1 0
    //   179: aload_0
    //   180: getfield 37	com/baidu/trace/p:c	Ljava/util/List;
    //   183: ifnull +374 -> 557
    //   186: aload_0
    //   187: getfield 37	com/baidu/trace/p:c	Ljava/util/List;
    //   190: invokeinterface 128 1 0
    //   195: aload_0
    //   196: getfield 61	com/baidu/trace/p:b	Landroid/telephony/TelephonyManager;
    //   199: invokevirtual 132	android/telephony/TelephonyManager:getNeighboringCellInfo	()Ljava/util/List;
    //   202: astore 8
    //   204: aload 8
    //   206: ifnull +13 -> 219
    //   209: aload 8
    //   211: invokeinterface 135 1 0
    //   216: ifeq +355 -> 571
    //   219: aload_1
    //   220: aload_0
    //   221: getfield 41	com/baidu/trace/p:e	I
    //   224: invokestatic 139	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   227: invokevirtual 143	java/lang/Integer:byteValue	()B
    //   230: putfield 146	com/baidu/trace/a/c:b	B
    //   233: aload_1
    //   234: getstatic 27	com/baidu/trace/p:a	I
    //   237: invokestatic 139	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   240: invokevirtual 143	java/lang/Integer:byteValue	()B
    //   243: putfield 148	com/baidu/trace/a/c:c	B
    //   246: aload_1
    //   247: aload_0
    //   248: getfield 45	com/baidu/trace/p:g	I
    //   251: invokestatic 139	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   254: invokevirtual 152	java/lang/Integer:shortValue	()S
    //   257: putfield 155	com/baidu/trace/a/c:d	S
    //   260: aload_1
    //   261: aload_0
    //   262: getfield 113	com/baidu/trace/p:h	I
    //   265: invokestatic 139	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   268: invokevirtual 152	java/lang/Integer:shortValue	()S
    //   271: putfield 157	com/baidu/trace/a/c:e	S
    //   274: aload_1
    //   275: aload_0
    //   276: getfield 118	com/baidu/trace/p:j	I
    //   279: putfield 159	com/baidu/trace/a/c:f	I
    //   282: aload_1
    //   283: aload_0
    //   284: getfield 123	com/baidu/trace/p:k	I
    //   287: putfield 160	com/baidu/trace/a/c:g	I
    //   290: aload_0
    //   291: getfield 37	com/baidu/trace/p:c	Ljava/util/List;
    //   294: ifnull -287 -> 7
    //   297: aload_0
    //   298: getfield 39	com/baidu/trace/p:d	Ljava/util/List;
    //   301: ifnull -294 -> 7
    //   304: aload_0
    //   305: getfield 37	com/baidu/trace/p:c	Ljava/util/List;
    //   308: invokeinterface 163 1 0
    //   313: aload_0
    //   314: getfield 39	com/baidu/trace/p:d	Ljava/util/List;
    //   317: invokeinterface 163 1 0
    //   322: if_icmpgt +357 -> 679
    //   325: aload_0
    //   326: getfield 37	com/baidu/trace/p:c	Ljava/util/List;
    //   329: invokeinterface 163 1 0
    //   334: istore_2
    //   335: aload_1
    //   336: iload_2
    //   337: newarray <illegal type>
    //   339: putfield 166	com/baidu/trace/a/c:h	[I
    //   342: aload_1
    //   343: iload_2
    //   344: newarray <illegal type>
    //   346: putfield 168	com/baidu/trace/a/c:i	[I
    //   349: iload 4
    //   351: istore_3
    //   352: iload_3
    //   353: iload_2
    //   354: if_icmpge +338 -> 692
    //   357: aload_1
    //   358: getfield 166	com/baidu/trace/a/c:h	[I
    //   361: iload_3
    //   362: aload_0
    //   363: getfield 37	com/baidu/trace/p:c	Ljava/util/List;
    //   366: iload_3
    //   367: invokeinterface 172 2 0
    //   372: checkcast 98	java/lang/Integer
    //   375: invokevirtual 175	java/lang/Integer:intValue	()I
    //   378: iastore
    //   379: aload_1
    //   380: getfield 168	com/baidu/trace/a/c:i	[I
    //   383: iload_3
    //   384: aload_0
    //   385: getfield 39	com/baidu/trace/p:d	Ljava/util/List;
    //   388: iload_3
    //   389: invokeinterface 172 2 0
    //   394: checkcast 98	java/lang/Integer
    //   397: invokevirtual 175	java/lang/Integer:intValue	()I
    //   400: iastore
    //   401: iload_3
    //   402: iconst_1
    //   403: iadd
    //   404: istore_3
    //   405: goto -53 -> 352
    //   408: astore 8
    //   410: aload_0
    //   411: iconst_0
    //   412: putfield 45	com/baidu/trace/p:g	I
    //   415: goto -332 -> 83
    //   418: aload_0
    //   419: iconst_0
    //   420: putfield 45	com/baidu/trace/p:g	I
    //   423: goto -340 -> 83
    //   426: astore 9
    //   428: aload_0
    //   429: iconst_0
    //   430: putfield 113	com/baidu/trace/p:h	I
    //   433: goto -293 -> 140
    //   436: aload 8
    //   438: instanceof 177
    //   441: ifeq +75 -> 516
    //   444: aload 8
    //   446: checkcast 177	android/telephony/cdma/CdmaCellLocation
    //   449: astore 8
    //   451: aload_0
    //   452: iconst_2
    //   453: putfield 41	com/baidu/trace/p:e	I
    //   456: aload_0
    //   457: aload 8
    //   459: invokevirtual 180	android/telephony/cdma/CdmaCellLocation:getSystemId	()I
    //   462: putfield 113	com/baidu/trace/p:h	I
    //   465: aload 8
    //   467: invokevirtual 183	android/telephony/cdma/CdmaCellLocation:getNetworkId	()I
    //   470: iflt +36 -> 506
    //   473: aload 8
    //   475: invokevirtual 183	android/telephony/cdma/CdmaCellLocation:getNetworkId	()I
    //   478: istore_2
    //   479: aload_0
    //   480: iload_2
    //   481: putfield 118	com/baidu/trace/p:j	I
    //   484: aload 8
    //   486: invokevirtual 186	android/telephony/cdma/CdmaCellLocation:getBaseStationId	()I
    //   489: iflt +22 -> 511
    //   492: aload 8
    //   494: invokevirtual 186	android/telephony/cdma/CdmaCellLocation:getBaseStationId	()I
    //   497: istore_2
    //   498: aload_0
    //   499: iload_2
    //   500: putfield 123	com/baidu/trace/p:k	I
    //   503: goto -340 -> 163
    //   506: iconst_0
    //   507: istore_2
    //   508: goto -29 -> 479
    //   511: iconst_0
    //   512: istore_2
    //   513: goto -15 -> 498
    //   516: aload_0
    //   517: iconst_0
    //   518: putfield 41	com/baidu/trace/p:e	I
    //   521: aload_0
    //   522: iconst_0
    //   523: putfield 113	com/baidu/trace/p:h	I
    //   526: aload_0
    //   527: iconst_0
    //   528: putfield 118	com/baidu/trace/p:j	I
    //   531: aload_0
    //   532: iconst_0
    //   533: putfield 123	com/baidu/trace/p:k	I
    //   536: iconst_0
    //   537: putstatic 27	com/baidu/trace/p:a	I
    //   540: goto -377 -> 163
    //   543: aload_0
    //   544: new 34	java/util/ArrayList
    //   547: dup
    //   548: invokespecial 35	java/util/ArrayList:<init>	()V
    //   551: putfield 39	com/baidu/trace/p:d	Ljava/util/List;
    //   554: goto -375 -> 179
    //   557: aload_0
    //   558: new 34	java/util/ArrayList
    //   561: dup
    //   562: invokespecial 35	java/util/ArrayList:<init>	()V
    //   565: putfield 37	com/baidu/trace/p:c	Ljava/util/List;
    //   568: goto -373 -> 195
    //   571: aload 8
    //   573: invokeinterface 163 1 0
    //   578: istore 5
    //   580: iconst_0
    //   581: istore_3
    //   582: iconst_0
    //   583: istore_2
    //   584: iload_3
    //   585: iload 5
    //   587: if_icmpge -368 -> 219
    //   590: iload_2
    //   591: bipush 6
    //   593: if_icmpge -374 -> 219
    //   596: aload 8
    //   598: iload_3
    //   599: invokeinterface 172 2 0
    //   604: checkcast 188	android/telephony/NeighboringCellInfo
    //   607: invokevirtual 189	android/telephony/NeighboringCellInfo:getLac	()I
    //   610: istore 6
    //   612: aload 8
    //   614: iload_3
    //   615: invokeinterface 172 2 0
    //   620: checkcast 188	android/telephony/NeighboringCellInfo
    //   623: invokevirtual 190	android/telephony/NeighboringCellInfo:getCid	()I
    //   626: istore 7
    //   628: iload 7
    //   630: ifle +68 -> 698
    //   633: iload 6
    //   635: ifle +63 -> 698
    //   638: aload_0
    //   639: getfield 37	com/baidu/trace/p:c	Ljava/util/List;
    //   642: iload 6
    //   644: invokestatic 139	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   647: invokeinterface 194 2 0
    //   652: pop
    //   653: aload_0
    //   654: getfield 39	com/baidu/trace/p:d	Ljava/util/List;
    //   657: iload 7
    //   659: invokestatic 139	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   662: invokeinterface 194 2 0
    //   667: pop
    //   668: iload_2
    //   669: iconst_1
    //   670: iadd
    //   671: istore_2
    //   672: iload_3
    //   673: iconst_1
    //   674: iadd
    //   675: istore_3
    //   676: goto -92 -> 584
    //   679: aload_0
    //   680: getfield 39	com/baidu/trace/p:d	Ljava/util/List;
    //   683: invokeinterface 163 1 0
    //   688: istore_2
    //   689: goto -354 -> 335
    //   692: aload_1
    //   693: iconst_1
    //   694: putfield 76	com/baidu/trace/a/c:a	Z
    //   697: return
    //   698: goto -26 -> 672
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	701	0	this	p
    //   0	701	1	paramc	com.baidu.trace.a.c
    //   334	355	2	m	int
    //   351	325	3	n	int
    //   1	349	4	i1	int
    //   578	10	5	i2	int
    //   610	33	6	i3	int
    //   626	32	7	i4	int
    //   90	120	8	localObject	Object
    //   408	37	8	localException1	Exception
    //   449	164	8	localCdmaCellLocation	android.telephony.cdma.CdmaCellLocation
    //   426	1	9	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   67	83	408	java/lang/Exception
    //   125	140	426	java/lang/Exception
  }
  
  protected final boolean a()
  {
    return this.b != null;
  }
  
  protected final void b()
  {
    if (this.c != null)
    {
      this.c.clear();
      this.c = null;
    }
    if (this.d != null)
    {
      this.d.clear();
      this.d = null;
    }
  }
  
  public final class a
    extends PhoneStateListener
  {
    public a() {}
    
    public final void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
    {
      super.onSignalStrengthsChanged(paramSignalStrength);
      if (paramSignalStrength.isGsm())
      {
        if (99 != paramSignalStrength.getGsmSignalStrength())
        {
          p.a = (paramSignalStrength.getGsmSignalStrength() << 1) - 113;
          return;
        }
        p.a = 0;
        return;
      }
      p.a = paramSignalStrength.getCdmaDbm();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */