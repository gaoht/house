package com.xiaomi.smack.util;

import com.xiaomi.smack.packet.b.a;
import com.xiaomi.smack.packet.f;
import com.xiaomi.smack.packet.f.a;
import com.xiaomi.smack.packet.f.b;
import com.xiaomi.smack.packet.g;
import com.xiaomi.smack.packet.h;
import com.xiaomi.smack.packet.h.a;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class a
{
  private static XmlPullParser a = null;
  
  public static com.xiaomi.smack.packet.a a(String paramString1, String paramString2, XmlPullParser paramXmlPullParser)
  {
    paramString1 = com.xiaomi.smack.provider.c.a().a("all", "xm:chat");
    if ((paramString1 != null) && ((paramString1 instanceof com.xiaomi.push.service.c))) {
      return ((com.xiaomi.push.service.c)paramString1).b(paramXmlPullParser);
    }
    return null;
  }
  
  public static com.xiaomi.smack.packet.b a(XmlPullParser paramXmlPullParser, com.xiaomi.smack.a parama)
  {
    String str1 = paramXmlPullParser.getAttributeValue("", "id");
    String str2 = paramXmlPullParser.getAttributeValue("", "to");
    String str3 = paramXmlPullParser.getAttributeValue("", "from");
    String str4 = paramXmlPullParser.getAttributeValue("", "chid");
    b.a locala = b.a.a(paramXmlPullParser.getAttributeValue("", "type"));
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramXmlPullParser.getAttributeCount())
    {
      localObject1 = paramXmlPullParser.getAttributeName(i);
      localHashMap.put(localObject1, paramXmlPullParser.getAttributeValue("", (String)localObject1));
      i += 1;
    }
    i = 0;
    Object localObject2 = null;
    Object localObject1 = null;
    int j;
    Object localObject3;
    String str5;
    if (i == 0)
    {
      j = paramXmlPullParser.next();
      if (j == 2)
      {
        localObject3 = paramXmlPullParser.getName();
        str5 = paramXmlPullParser.getNamespace();
        if (((String)localObject3).equals("error"))
        {
          localObject2 = d(paramXmlPullParser);
          label174:
          localObject3 = localObject2;
          localObject2 = localObject1;
          localObject1 = localObject3;
        }
      }
    }
    for (;;)
    {
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
      break;
      localObject1 = new com.xiaomi.smack.packet.b();
      ((com.xiaomi.smack.packet.b)localObject1).a(a((String)localObject3, str5, paramXmlPullParser));
      break label174;
      if ((j == 3) && (paramXmlPullParser.getName().equals("iq")))
      {
        localObject3 = localObject1;
        localObject1 = localObject2;
        i = 1;
        localObject2 = localObject3;
        continue;
        paramXmlPullParser = (XmlPullParser)localObject1;
        if (localObject1 == null)
        {
          if ((b.a.a == locala) || (b.a.b == locala))
          {
            paramXmlPullParser = new b();
            paramXmlPullParser.k(str1);
            paramXmlPullParser.m(str3);
            paramXmlPullParser.n(str2);
            paramXmlPullParser.a(b.a.d);
            paramXmlPullParser.l(str4);
            paramXmlPullParser.a(new h(h.a.e));
            parama.a(paramXmlPullParser);
            com.xiaomi.channel.commonutils.logger.b.d("iq usage error. send packet in packet parser.");
            return null;
          }
          paramXmlPullParser = new c();
        }
        paramXmlPullParser.k(str1);
        paramXmlPullParser.m(str2);
        paramXmlPullParser.l(str4);
        paramXmlPullParser.n(str3);
        paramXmlPullParser.a(locala);
        paramXmlPullParser.a((h)localObject2);
        paramXmlPullParser.a(localHashMap);
        return paramXmlPullParser;
      }
      else
      {
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
    }
  }
  
  /* Error */
  public static com.xiaomi.smack.packet.d a(XmlPullParser paramXmlPullParser)
  {
    // Byte code:
    //   0: ldc -91
    //   2: aload_0
    //   3: ldc 33
    //   5: ldc -89
    //   7: invokeinterface 41 3 0
    //   12: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15: ifeq +358 -> 373
    //   18: aload_0
    //   19: ldc 33
    //   21: ldc 47
    //   23: invokeinterface 41 3 0
    //   28: astore 6
    //   30: aload_0
    //   31: ldc 33
    //   33: ldc 35
    //   35: invokeinterface 41 3 0
    //   40: astore 7
    //   42: aload_0
    //   43: ldc 33
    //   45: ldc 45
    //   47: invokeinterface 41 3 0
    //   52: astore 8
    //   54: aload_0
    //   55: ldc 33
    //   57: ldc 43
    //   59: invokeinterface 41 3 0
    //   64: astore 9
    //   66: aload_0
    //   67: ldc 33
    //   69: ldc 49
    //   71: invokeinterface 41 3 0
    //   76: astore 10
    //   78: invokestatic 172	com/xiaomi/push/service/ak:a	()Lcom/xiaomi/push/service/ak;
    //   81: aload 6
    //   83: aload 9
    //   85: invokevirtual 175	com/xiaomi/push/service/ak:b	(Ljava/lang/String;Ljava/lang/String;)Lcom/xiaomi/push/service/ak$b;
    //   88: astore 5
    //   90: aload 5
    //   92: ifnonnull +860 -> 952
    //   95: invokestatic 172	com/xiaomi/push/service/ak:a	()Lcom/xiaomi/push/service/ak;
    //   98: aload 6
    //   100: aload 8
    //   102: invokevirtual 175	com/xiaomi/push/service/ak:b	(Ljava/lang/String;Ljava/lang/String;)Lcom/xiaomi/push/service/ak$b;
    //   105: astore 5
    //   107: aload 5
    //   109: ifnonnull +13 -> 122
    //   112: new 177	com/xiaomi/smack/l
    //   115: dup
    //   116: ldc -77
    //   118: invokespecial 181	com/xiaomi/smack/l:<init>	(Ljava/lang/String;)V
    //   121: athrow
    //   122: iconst_0
    //   123: istore_1
    //   124: aconst_null
    //   125: astore 4
    //   127: iload_1
    //   128: ifne +227 -> 355
    //   131: aload_0
    //   132: invokeinterface 74 1 0
    //   137: istore_2
    //   138: iload_2
    //   139: iconst_2
    //   140: if_icmpne +191 -> 331
    //   143: ldc -89
    //   145: aload_0
    //   146: invokeinterface 78 1 0
    //   151: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   154: ifne +13 -> 167
    //   157: new 177	com/xiaomi/smack/l
    //   160: dup
    //   161: ldc -73
    //   163: invokespecial 181	com/xiaomi/smack/l:<init>	(Ljava/lang/String;)V
    //   166: athrow
    //   167: aload_0
    //   168: invokeinterface 74 1 0
    //   173: iconst_4
    //   174: if_icmpeq +13 -> 187
    //   177: new 177	com/xiaomi/smack/l
    //   180: dup
    //   181: ldc -73
    //   183: invokespecial 181	com/xiaomi/smack/l:<init>	(Ljava/lang/String;)V
    //   186: athrow
    //   187: aload_0
    //   188: invokeinterface 186 1 0
    //   193: astore 4
    //   195: ldc -68
    //   197: aload 6
    //   199: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   202: ifne +13 -> 215
    //   205: ldc -66
    //   207: aload 6
    //   209: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   212: ifeq +81 -> 293
    //   215: new 192	com/xiaomi/smack/packet/c
    //   218: dup
    //   219: invokespecial 193	com/xiaomi/smack/packet/c:<init>	()V
    //   222: astore_0
    //   223: aload_0
    //   224: aload 6
    //   226: invokevirtual 194	com/xiaomi/smack/packet/c:l	(Ljava/lang/String;)V
    //   229: aload_0
    //   230: iconst_1
    //   231: invokevirtual 197	com/xiaomi/smack/packet/c:b	(Z)V
    //   234: aload_0
    //   235: aload 8
    //   237: invokevirtual 198	com/xiaomi/smack/packet/c:n	(Ljava/lang/String;)V
    //   240: aload_0
    //   241: aload 9
    //   243: invokevirtual 199	com/xiaomi/smack/packet/c:m	(Ljava/lang/String;)V
    //   246: aload_0
    //   247: aload 7
    //   249: invokevirtual 200	com/xiaomi/smack/packet/c:k	(Ljava/lang/String;)V
    //   252: aload_0
    //   253: aload 10
    //   255: invokevirtual 203	com/xiaomi/smack/packet/c:f	(Ljava/lang/String;)V
    //   258: new 205	com/xiaomi/smack/packet/a
    //   261: dup
    //   262: ldc -89
    //   264: aconst_null
    //   265: aconst_null
    //   266: checkcast 207	[Ljava/lang/String;
    //   269: aconst_null
    //   270: checkcast 207	[Ljava/lang/String;
    //   273: invokespecial 210	com/xiaomi/smack/packet/a:<init>	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;)V
    //   276: astore 5
    //   278: aload 5
    //   280: aload 4
    //   282: invokevirtual 212	com/xiaomi/smack/packet/a:b	(Ljava/lang/String;)V
    //   285: aload_0
    //   286: aload 5
    //   288: invokevirtual 213	com/xiaomi/smack/packet/c:a	(Lcom/xiaomi/smack/packet/a;)V
    //   291: aload_0
    //   292: areturn
    //   293: aload 5
    //   295: getfield 219	com/xiaomi/push/service/ak$b:i	Ljava/lang/String;
    //   298: aload 7
    //   300: invokestatic 224	com/xiaomi/push/service/aq:a	(Ljava/lang/String;Ljava/lang/String;)[B
    //   303: aload 4
    //   305: invokestatic 227	com/xiaomi/push/service/aq:b	([BLjava/lang/String;)[B
    //   308: invokestatic 230	com/xiaomi/smack/util/a:a	([B)V
    //   311: getstatic 10	com/xiaomi/smack/util/a:a	Lorg/xmlpull/v1/XmlPullParser;
    //   314: invokeinterface 74 1 0
    //   319: pop
    //   320: getstatic 10	com/xiaomi/smack/util/a:a	Lorg/xmlpull/v1/XmlPullParser;
    //   323: invokestatic 232	com/xiaomi/smack/util/a:a	(Lorg/xmlpull/v1/XmlPullParser;)Lcom/xiaomi/smack/packet/d;
    //   326: astore 4
    //   328: goto -201 -> 127
    //   331: iload_2
    //   332: iconst_3
    //   333: if_icmpne -206 -> 127
    //   336: aload_0
    //   337: invokeinterface 78 1 0
    //   342: ldc -22
    //   344: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   347: ifeq -220 -> 127
    //   350: iconst_1
    //   351: istore_1
    //   352: goto -225 -> 127
    //   355: aload 4
    //   357: astore_0
    //   358: aload 4
    //   360: ifnonnull -69 -> 291
    //   363: new 177	com/xiaomi/smack/l
    //   366: dup
    //   367: ldc -73
    //   369: invokespecial 181	com/xiaomi/smack/l:<init>	(Ljava/lang/String;)V
    //   372: athrow
    //   373: new 192	com/xiaomi/smack/packet/c
    //   376: dup
    //   377: invokespecial 193	com/xiaomi/smack/packet/c:<init>	()V
    //   380: astore 7
    //   382: aload_0
    //   383: ldc 33
    //   385: ldc 35
    //   387: invokeinterface 41 3 0
    //   392: astore 5
    //   394: aload 5
    //   396: astore 4
    //   398: aload 5
    //   400: ifnonnull +7 -> 407
    //   403: ldc -20
    //   405: astore 4
    //   407: aload 7
    //   409: aload 4
    //   411: invokevirtual 200	com/xiaomi/smack/packet/c:k	(Ljava/lang/String;)V
    //   414: aload 7
    //   416: aload_0
    //   417: ldc 33
    //   419: ldc 43
    //   421: invokeinterface 41 3 0
    //   426: invokevirtual 199	com/xiaomi/smack/packet/c:m	(Ljava/lang/String;)V
    //   429: aload 7
    //   431: aload_0
    //   432: ldc 33
    //   434: ldc 45
    //   436: invokeinterface 41 3 0
    //   441: invokevirtual 198	com/xiaomi/smack/packet/c:n	(Ljava/lang/String;)V
    //   444: aload 7
    //   446: aload_0
    //   447: ldc 33
    //   449: ldc 47
    //   451: invokeinterface 41 3 0
    //   456: invokevirtual 194	com/xiaomi/smack/packet/c:l	(Ljava/lang/String;)V
    //   459: aload 7
    //   461: aload_0
    //   462: ldc 33
    //   464: ldc -18
    //   466: invokeinterface 41 3 0
    //   471: invokevirtual 240	com/xiaomi/smack/packet/c:a	(Ljava/lang/String;)V
    //   474: aload_0
    //   475: ldc 33
    //   477: ldc -14
    //   479: invokeinterface 41 3 0
    //   484: astore 4
    //   486: aload_0
    //   487: ldc 33
    //   489: ldc -12
    //   491: invokeinterface 41 3 0
    //   496: astore 5
    //   498: aload 5
    //   500: invokestatic 250	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   503: ifne +10 -> 513
    //   506: aload 7
    //   508: aload 5
    //   510: invokevirtual 251	com/xiaomi/smack/packet/c:b	(Ljava/lang/String;)V
    //   513: aload_0
    //   514: ldc 33
    //   516: ldc -3
    //   518: invokeinterface 41 3 0
    //   523: astore 5
    //   525: aload 5
    //   527: invokestatic 250	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   530: ifne +10 -> 540
    //   533: aload 7
    //   535: aload 5
    //   537: invokevirtual 256	com/xiaomi/smack/packet/c:c	(Ljava/lang/String;)V
    //   540: aload_0
    //   541: ldc 33
    //   543: ldc_w 258
    //   546: invokeinterface 41 3 0
    //   551: astore 5
    //   553: aload 5
    //   555: invokestatic 250	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   558: ifne +10 -> 568
    //   561: aload 7
    //   563: aload 5
    //   565: invokevirtual 259	com/xiaomi/smack/packet/c:d	(Ljava/lang/String;)V
    //   568: aload_0
    //   569: ldc 33
    //   571: ldc_w 261
    //   574: invokeinterface 41 3 0
    //   579: astore 5
    //   581: aload 5
    //   583: invokestatic 250	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   586: ifne +10 -> 596
    //   589: aload 7
    //   591: aload 5
    //   593: invokevirtual 263	com/xiaomi/smack/packet/c:e	(Ljava/lang/String;)V
    //   596: aload 4
    //   598: invokestatic 250	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   601: ifne +160 -> 761
    //   604: aload 4
    //   606: ldc_w 265
    //   609: invokevirtual 269	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   612: ifeq +149 -> 761
    //   615: iconst_1
    //   616: istore_3
    //   617: aload 7
    //   619: iload_3
    //   620: invokevirtual 271	com/xiaomi/smack/packet/c:a	(Z)V
    //   623: aload 7
    //   625: aload_0
    //   626: ldc 33
    //   628: ldc 49
    //   630: invokeinterface 41 3 0
    //   635: invokevirtual 203	com/xiaomi/smack/packet/c:f	(Ljava/lang/String;)V
    //   638: aload_0
    //   639: invokestatic 274	com/xiaomi/smack/util/a:f	(Lorg/xmlpull/v1/XmlPullParser;)Ljava/lang/String;
    //   642: astore 4
    //   644: aload 4
    //   646: ifnull +120 -> 766
    //   649: ldc 33
    //   651: aload 4
    //   653: invokevirtual 277	java/lang/String:trim	()Ljava/lang/String;
    //   656: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   659: ifne +107 -> 766
    //   662: aload 7
    //   664: aload 4
    //   666: invokevirtual 280	com/xiaomi/smack/packet/c:j	(Ljava/lang/String;)V
    //   669: aconst_null
    //   670: astore 4
    //   672: iconst_0
    //   673: istore_1
    //   674: iload_1
    //   675: ifne +247 -> 922
    //   678: aload_0
    //   679: invokeinterface 74 1 0
    //   684: istore_2
    //   685: iload_2
    //   686: iconst_2
    //   687: if_icmpne +211 -> 898
    //   690: aload_0
    //   691: invokeinterface 78 1 0
    //   696: astore 8
    //   698: aload_0
    //   699: invokeinterface 81 1 0
    //   704: astore 6
    //   706: aload 6
    //   708: astore 5
    //   710: aload 6
    //   712: invokestatic 250	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   715: ifeq +8 -> 723
    //   718: ldc_w 282
    //   721: astore 5
    //   723: aload 8
    //   725: ldc_w 284
    //   728: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   731: ifeq +42 -> 773
    //   734: aload_0
    //   735: invokestatic 274	com/xiaomi/smack/util/a:f	(Lorg/xmlpull/v1/XmlPullParser;)Ljava/lang/String;
    //   738: ifnonnull +3 -> 741
    //   741: aload 7
    //   743: aload_0
    //   744: invokestatic 286	com/xiaomi/smack/util/a:e	(Lorg/xmlpull/v1/XmlPullParser;)Ljava/lang/String;
    //   747: invokevirtual 289	com/xiaomi/smack/packet/c:g	(Ljava/lang/String;)V
    //   750: goto -76 -> 674
    //   753: astore 4
    //   755: aconst_null
    //   756: astore 4
    //   758: goto -272 -> 486
    //   761: iconst_0
    //   762: istore_3
    //   763: goto -146 -> 617
    //   766: invokestatic 294	com/xiaomi/smack/packet/d:u	()Ljava/lang/String;
    //   769: pop
    //   770: goto -101 -> 669
    //   773: aload 8
    //   775: ldc_w 296
    //   778: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   781: ifeq +52 -> 833
    //   784: aload_0
    //   785: ldc 33
    //   787: ldc_w 298
    //   790: invokeinterface 41 3 0
    //   795: astore 5
    //   797: aload_0
    //   798: invokestatic 286	com/xiaomi/smack/util/a:e	(Lorg/xmlpull/v1/XmlPullParser;)Ljava/lang/String;
    //   801: astore 6
    //   803: aload 5
    //   805: invokestatic 250	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   808: ifne +15 -> 823
    //   811: aload 7
    //   813: aload 6
    //   815: aload 5
    //   817: invokevirtual 301	com/xiaomi/smack/packet/c:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   820: goto -146 -> 674
    //   823: aload 7
    //   825: aload 6
    //   827: invokevirtual 304	com/xiaomi/smack/packet/c:h	(Ljava/lang/String;)V
    //   830: goto -156 -> 674
    //   833: aload 8
    //   835: ldc_w 306
    //   838: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   841: ifeq +19 -> 860
    //   844: aload 4
    //   846: ifnonnull -172 -> 674
    //   849: aload_0
    //   850: invokeinterface 309 1 0
    //   855: astore 4
    //   857: goto -183 -> 674
    //   860: aload 8
    //   862: ldc 83
    //   864: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   867: ifeq +15 -> 882
    //   870: aload 7
    //   872: aload_0
    //   873: invokestatic 93	com/xiaomi/smack/util/a:d	(Lorg/xmlpull/v1/XmlPullParser;)Lcom/xiaomi/smack/packet/h;
    //   876: invokevirtual 310	com/xiaomi/smack/packet/c:a	(Lcom/xiaomi/smack/packet/h;)V
    //   879: goto -205 -> 674
    //   882: aload 7
    //   884: aload 8
    //   886: aload 5
    //   888: aload_0
    //   889: invokestatic 98	com/xiaomi/smack/util/a:a	(Ljava/lang/String;Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;)Lcom/xiaomi/smack/packet/a;
    //   892: invokevirtual 213	com/xiaomi/smack/packet/c:a	(Lcom/xiaomi/smack/packet/a;)V
    //   895: goto -221 -> 674
    //   898: iload_2
    //   899: iconst_3
    //   900: if_icmpne -226 -> 674
    //   903: aload_0
    //   904: invokeinterface 78 1 0
    //   909: ldc -22
    //   911: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   914: ifeq -240 -> 674
    //   917: iconst_1
    //   918: istore_1
    //   919: goto -245 -> 674
    //   922: aload 7
    //   924: aload 4
    //   926: invokevirtual 312	com/xiaomi/smack/packet/c:i	(Ljava/lang/String;)V
    //   929: aload 7
    //   931: areturn
    //   932: astore 5
    //   934: goto -338 -> 596
    //   937: astore 5
    //   939: goto -371 -> 568
    //   942: astore 5
    //   944: goto -404 -> 540
    //   947: astore 5
    //   949: goto -436 -> 513
    //   952: goto -845 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	955	0	paramXmlPullParser	XmlPullParser
    //   123	796	1	i	int
    //   137	764	2	j	int
    //   616	147	3	bool	boolean
    //   125	546	4	localObject1	Object
    //   753	1	4	localException1	Exception
    //   756	169	4	str1	String
    //   88	799	5	localObject2	Object
    //   932	1	5	localException2	Exception
    //   937	1	5	localException3	Exception
    //   942	1	5	localException4	Exception
    //   947	1	5	localException5	Exception
    //   28	798	6	str2	String
    //   40	890	7	localObject3	Object
    //   52	833	8	str3	String
    //   64	178	9	str4	String
    //   76	178	10	str5	String
    // Exception table:
    //   from	to	target	type
    //   474	486	753	java/lang/Exception
    //   568	596	932	java/lang/Exception
    //   540	568	937	java/lang/Exception
    //   513	540	942	java/lang/Exception
    //   486	513	947	java/lang/Exception
  }
  
  private static void a(byte[] paramArrayOfByte)
  {
    if (a == null) {}
    try
    {
      a = XmlPullParserFactory.newInstance().newPullParser();
      a.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
      a.setInput(new InputStreamReader(new ByteArrayInputStream(paramArrayOfByte)));
      return;
    }
    catch (XmlPullParserException localXmlPullParserException)
    {
      for (;;)
      {
        localXmlPullParserException.printStackTrace();
      }
    }
  }
  
  public static f b(XmlPullParser paramXmlPullParser)
  {
    Object localObject3 = f.b.a;
    Object localObject4 = paramXmlPullParser.getAttributeValue("", "type");
    Object localObject1 = localObject3;
    if (localObject4 != null)
    {
      localObject1 = localObject3;
      if (((String)localObject4).equals("")) {}
    }
    try
    {
      localObject1 = f.b.valueOf((String)localObject4);
      localObject4 = new f((f.b)localObject1);
      ((f)localObject4).m(paramXmlPullParser.getAttributeValue("", "to"));
      ((f)localObject4).n(paramXmlPullParser.getAttributeValue("", "from"));
      ((f)localObject4).l(paramXmlPullParser.getAttributeValue("", "chid"));
      localObject3 = paramXmlPullParser.getAttributeValue("", "id");
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = "ID_NOT_AVAILABLE";
      }
      ((f)localObject4).k((String)localObject1);
      i = 0;
      for (;;)
      {
        if (i != 0) {
          break label381;
        }
        j = paramXmlPullParser.next();
        if (j != 2) {
          break label356;
        }
        localObject1 = paramXmlPullParser.getName();
        localObject3 = paramXmlPullParser.getNamespace();
        if (!((String)localObject1).equals("status")) {
          break;
        }
        ((f)localObject4).a(paramXmlPullParser.nextText());
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException1)
    {
      for (;;)
      {
        int i;
        int j;
        System.err.println("Found invalid presence type " + (String)localObject4);
        Object localObject2 = localObject3;
        continue;
        if (((String)localObject2).equals("priority"))
        {
          try
          {
            ((f)localObject4).a(Integer.parseInt(paramXmlPullParser.nextText()));
          }
          catch (NumberFormatException localNumberFormatException) {}catch (IllegalArgumentException localIllegalArgumentException2)
          {
            ((f)localObject4).a(0);
          }
        }
        else
        {
          String str;
          if (localIllegalArgumentException2.equals("show"))
          {
            str = paramXmlPullParser.nextText();
            try
            {
              ((f)localObject4).a(f.a.valueOf(str));
            }
            catch (IllegalArgumentException localIllegalArgumentException3)
            {
              System.err.println("Found invalid presence mode " + str);
            }
          }
          else if (str.equals("error"))
          {
            ((f)localObject4).a(d(paramXmlPullParser));
          }
          else
          {
            ((f)localObject4).a(a(str, localIllegalArgumentException3, paramXmlPullParser));
            continue;
            label356:
            if ((j == 3) && (paramXmlPullParser.getName().equals("presence"))) {
              i = 1;
            }
          }
        }
      }
    }
    label381:
    return (f)localObject4;
  }
  
  public static g c(XmlPullParser paramXmlPullParser)
  {
    g localg = null;
    int i = 0;
    while (i == 0)
    {
      int j = paramXmlPullParser.next();
      if (j == 2) {
        localg = new g(paramXmlPullParser.getName());
      } else if ((j == 3) && (paramXmlPullParser.getName().equals("error"))) {
        i = 1;
      }
    }
    return localg;
  }
  
  public static h d(XmlPullParser paramXmlPullParser)
  {
    ArrayList localArrayList = new ArrayList();
    String str4 = null;
    String str1 = null;
    String str2 = "-1";
    int i = 0;
    if (i < paramXmlPullParser.getAttributeCount())
    {
      if (!paramXmlPullParser.getAttributeName(i).equals("code")) {
        break label303;
      }
      str2 = paramXmlPullParser.getAttributeValue("", "code");
    }
    label303:
    for (;;)
    {
      if (paramXmlPullParser.getAttributeName(i).equals("type")) {
        str1 = paramXmlPullParser.getAttributeValue("", "type");
      }
      for (;;)
      {
        if (paramXmlPullParser.getAttributeName(i).equals("reason")) {
          str4 = paramXmlPullParser.getAttributeValue("", "reason");
        }
        i += 1;
        break;
        i = 0;
        Object localObject = null;
        String str3 = null;
        while (i == 0)
        {
          int j = paramXmlPullParser.next();
          if (j == 2)
          {
            if (paramXmlPullParser.getName().equals("text"))
            {
              str3 = paramXmlPullParser.nextText();
            }
            else
            {
              String str5 = paramXmlPullParser.getName();
              String str6 = paramXmlPullParser.getNamespace();
              if ("urn:ietf:params:xml:ns:xmpp-stanzas".equals(str6)) {
                localObject = str5;
              } else {
                localArrayList.add(a(str5, str6, paramXmlPullParser));
              }
            }
          }
          else if (j == 3)
          {
            if (paramXmlPullParser.getName().equals("error")) {
              i = 1;
            }
          }
          else if (j == 4) {
            str3 = paramXmlPullParser.getText();
          }
        }
        if (str1 == null) {}
        for (paramXmlPullParser = "cancel";; paramXmlPullParser = str1) {
          return new h(Integer.parseInt(str2), paramXmlPullParser, str4, (String)localObject, str3, localArrayList);
        }
      }
    }
  }
  
  private static String e(XmlPullParser paramXmlPullParser)
  {
    String str = "";
    int i = paramXmlPullParser.getDepth();
    while ((paramXmlPullParser.next() != 3) || (paramXmlPullParser.getDepth() != i)) {
      str = str + paramXmlPullParser.getText();
    }
    return str;
  }
  
  private static String f(XmlPullParser paramXmlPullParser)
  {
    int i = 0;
    while (i < paramXmlPullParser.getAttributeCount())
    {
      String str = paramXmlPullParser.getAttributeName(i);
      if (("xml:lang".equals(str)) || (("lang".equals(str)) && ("xml".equals(paramXmlPullParser.getAttributePrefix(i))))) {
        return paramXmlPullParser.getAttributeValue(i);
      }
      i += 1;
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/smack/util/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */