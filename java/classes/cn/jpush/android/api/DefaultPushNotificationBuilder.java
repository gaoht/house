package cn.jpush.android.api;

import android.app.Notification;
import android.app.Notification.Builder;
import android.os.Build.VERSION;
import android.widget.RemoteViews;

public class DefaultPushNotificationBuilder
  implements PushNotificationBuilder
{
  private static final String TAG;
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[24];
    int j = 0;
    Object localObject2 = "mYpu%EHFa#Ary`9OUuu$@SxV%@Prq\"";
    int i = 23;
    Object localObject1 = arrayOfString;
    char[] arrayOfChar = ((String)localObject2).toCharArray();
    int k = arrayOfChar.length;
    int i1 = 0;
    int m = 0;
    int i4 = i;
    localObject2 = arrayOfChar;
    int i3 = j;
    Object localObject3 = localObject1;
    int n = k;
    Object localObject4;
    int i2;
    if (k <= 1)
    {
      localObject4 = localObject1;
      localObject1 = arrayOfChar;
      i2 = i;
      label69:
      n = m;
      label72:
      localObject2 = localObject1;
      i1 = localObject2[m];
      switch (n % 5)
      {
      default: 
        i = 80;
      }
    }
    for (;;)
    {
      localObject2[m] = ((char)(i ^ i1));
      n += 1;
      if (k == 0)
      {
        m = k;
        break label72;
        TAG = (String)localObject1;
        localObject2 = "\t\0276";
        i = -1;
        j = i3;
        localObject1 = localObject3;
        break;
      }
      i1 = n;
      n = k;
      localObject3 = localObject4;
      i3 = j;
      localObject2 = localObject1;
      i4 = i2;
      i2 = i4;
      localObject1 = localObject2;
      j = i3;
      localObject4 = localObject3;
      k = n;
      m = i1;
      if (n > i1) {
        break label69;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i4)
      {
      case 23: 
      default: 
        localObject3[i3] = localObject1;
        j = 1;
        localObject2 = "ZYbW1]Yq{\"P";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i3] = localObject1;
        j = 2;
        localObject2 = "zYb4>FHr9J]b}?G\034TD\003\tK`8\tLw$\\Ns4 HH~.";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i3] = localObject1;
        j = 3;
        localObject2 = "\tRscpDYeg1NYe";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i3] = localObject1;
        j = 4;
        localObject2 = "JR8~ \\O~:1GXd{9M\022_Z\022fd";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i3] = localObject1;
        j = 5;
        localObject2 = "j]x3$\tZz4\tJwx9M\034u{>]Yn`p^TszpKIx4\tRy`9OUuu$@Sx:";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i3] = localObject1;
        j = 6;
        localObject2 = "clcg8\007QFu3B]qq\031G_yz\031M\034+)p\031\034)8pNYb49JSx46[S{41YLz}3HH{>\tUxr?\007";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i3] = localObject1;
        j = 7;
        localObject2 = "jNsu$L\034t}$D]f46HUzq4\t_wa#LX6v)\tsc`\037Oqsy?[ESf\"FN8";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i3] = localObject1;
        j = 8;
        localObject2 = "O]x5M\034b{pNYb41YLz}3HH{>\tUxr?\t]xpp@_yz~";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i3] = localObject1;
        j = 9;
        localObject2 = "CLcg8vRy`9OUuu$@SxK9JSx";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i3] = localObject1;
        j = 10;
        localObject2 = "ZYbX1]Ye`\025_Yx`\031GZy";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i3] = localObject1;
        j = 11;
        localObject2 = "JR8~ \\O~:1GXd{9M\022X[\004`cFF\031fn_@\t";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i3] = localObject1;
        j = 12;
        localObject2 = "JR8~ \\O~:1GXd{9M\022X[\004`cUU\004l{YF\t";
        i = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i3] = localObject1;
        j = 13;
        localObject2 = "HRrf?@X8u Y\022X{$@Zw1]UyztkIx4LN";
        i = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i3] = localObject1;
        j = 14;
        localObject2 = "JR8~ \\O~:1GXd{9M\022T]\027vhSL\004";
        i = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject3[i3] = localObject1;
        j = 15;
        localObject2 = "\tieqpMYpu%EH6z?]Up}3HH{>\tJq'\b\034";
        i = 14;
        localObject1 = arrayOfString;
        break;
      case 14: 
        localObject3[i3] = localObject1;
        j = 16;
        localObject2 = "mY`}3L\034d{=\toR_p\025\034$%|\t_wzpGSb4#LH6z?]Up}3HH{>\t_w`5NSdmq";
        i = 15;
        localObject1 = arrayOfString;
        break;
      case 15: 
        localObject3[i3] = localObject1;
        j = 17;
        localObject2 = "MNwc1KPs";
        i = 16;
        localObject1 = arrayOfString;
        break;
      case 16: 
        localObject3[i3] = localObject1;
        j = 18;
        localObject2 = "JR8~ \\O~:1GXd{9M\022T]\027vl_W\017y}B\\";
        i = 17;
        localObject1 = arrayOfString;
        break;
      case 17: 
        localObject3[i3] = localObject1;
        j = 19;
        localObject2 = "gS6z?]Up}3HH{>\t_yz$LRb4$F\034e|?^\0226S9_Y6a \007";
        i = 18;
        localObject1 = arrayOfString;
        break;
      case 18: 
        localObject3[i3] = localObject1;
        j = 20;
        localObject2 = "HRrf?@X8u Y\022X{$@Zw1]Uyz";
        i = 19;
        localObject1 = arrayOfString;
        break;
      case 19: 
        localObject3[i3] = localObject1;
        j = 21;
        localObject2 = "jNsu$L\034t}7\tLw$\\Ns4#]EzqpO]x5M\022";
        i = 20;
        localObject1 = arrayOfString;
        break;
      case 20: 
        localObject3[i3] = localObject1;
        j = 22;
        localObject2 = "JR8~ \\O~:1GXd{9M\022X[\004`z_W\021}uYZ\017jsX@\025ghI@\031}pS";
        i = 21;
        localObject1 = arrayOfString;
        break;
      case 21: 
        localObject3[i3] = localObject1;
        j = 23;
        localObject2 = "JR8~ \\O~:1GXd{9M\022WX\025{h";
        i = 22;
        localObject1 = arrayOfString;
        break;
      case 22: 
        localObject3[i3] = localObject1;
        z = arrayOfString;
        return;
        i = 41;
        continue;
        i = 60;
        continue;
        i = 22;
        continue;
        i = 20;
      }
    }
  }
  
  RemoteViews buildContentView(String paramString1, String paramString2)
  {
    return null;
  }
  
  /* Error */
  public Notification buildNotification(java.util.Map<String, String> paramMap)
  {
    // Byte code:
    //   0: getstatic 102	cn/jpush/android/d:d	Ljava/lang/String;
    //   3: astore 5
    //   5: ldc 104
    //   7: astore 8
    //   9: ldc 104
    //   11: astore 9
    //   13: iconst_0
    //   14: istore_3
    //   15: ldc 104
    //   17: astore 7
    //   19: ldc 104
    //   21: astore 10
    //   23: aload_1
    //   24: getstatic 80	cn/jpush/android/api/DefaultPushNotificationBuilder:z	[Ljava/lang/String;
    //   27: bipush 23
    //   29: aaload
    //   30: invokeinterface 110 2 0
    //   35: ifeq +1009 -> 1044
    //   38: aload_1
    //   39: getstatic 80	cn/jpush/android/api/DefaultPushNotificationBuilder:z	[Ljava/lang/String;
    //   42: bipush 23
    //   44: aaload
    //   45: invokeinterface 114 2 0
    //   50: checkcast 14	java/lang/String
    //   53: astore 6
    //   55: aload 6
    //   57: invokestatic 120	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   60: ifeq +17 -> 77
    //   63: getstatic 22	cn/jpush/android/api/DefaultPushNotificationBuilder:TAG	Ljava/lang/String;
    //   66: getstatic 80	cn/jpush/android/api/DefaultPushNotificationBuilder:z	[Ljava/lang/String;
    //   69: bipush 19
    //   71: aaload
    //   72: invokestatic 126	cn/jpush/android/c/f:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: aconst_null
    //   76: areturn
    //   77: aload_1
    //   78: getstatic 80	cn/jpush/android/api/DefaultPushNotificationBuilder:z	[Ljava/lang/String;
    //   81: bipush 22
    //   83: aaload
    //   84: invokeinterface 110 2 0
    //   89: ifeq +20 -> 109
    //   92: aload_1
    //   93: getstatic 80	cn/jpush/android/api/DefaultPushNotificationBuilder:z	[Ljava/lang/String;
    //   96: bipush 22
    //   98: aaload
    //   99: invokeinterface 114 2 0
    //   104: checkcast 14	java/lang/String
    //   107: astore 5
    //   109: aload_1
    //   110: getstatic 80	cn/jpush/android/api/DefaultPushNotificationBuilder:z	[Ljava/lang/String;
    //   113: bipush 14
    //   115: aaload
    //   116: invokeinterface 110 2 0
    //   121: ifeq +20 -> 141
    //   124: aload_1
    //   125: getstatic 80	cn/jpush/android/api/DefaultPushNotificationBuilder:z	[Ljava/lang/String;
    //   128: bipush 14
    //   130: aaload
    //   131: invokeinterface 114 2 0
    //   136: checkcast 14	java/lang/String
    //   139: astore 8
    //   141: aload_1
    //   142: getstatic 80	cn/jpush/android/api/DefaultPushNotificationBuilder:z	[Ljava/lang/String;
    //   145: iconst_4
    //   146: aaload
    //   147: invokeinterface 110 2 0
    //   152: ifeq +19 -> 171
    //   155: aload_1
    //   156: getstatic 80	cn/jpush/android/api/DefaultPushNotificationBuilder:z	[Ljava/lang/String;
    //   159: iconst_4
    //   160: aaload
    //   161: invokeinterface 114 2 0
    //   166: checkcast 14	java/lang/String
    //   169: astore 9
    //   171: aload_1
    //   172: getstatic 80	cn/jpush/android/api/DefaultPushNotificationBuilder:z	[Ljava/lang/String;
    //   175: bipush 11
    //   177: aaload
    //   178: invokeinterface 110 2 0
    //   183: ifeq +22 -> 205
    //   186: aload_1
    //   187: getstatic 80	cn/jpush/android/api/DefaultPushNotificationBuilder:z	[Ljava/lang/String;
    //   190: bipush 11
    //   192: aaload
    //   193: invokeinterface 114 2 0
    //   198: checkcast 14	java/lang/String
    //   201: invokestatic 132	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   204: istore_3
    //   205: aload_1
    //   206: getstatic 80	cn/jpush/android/api/DefaultPushNotificationBuilder:z	[Ljava/lang/String;
    //   209: bipush 12
    //   211: aaload
    //   212: invokeinterface 110 2 0
    //   217: ifeq +20 -> 237
    //   220: aload_1
    //   221: getstatic 80	cn/jpush/android/api/DefaultPushNotificationBuilder:z	[Ljava/lang/String;
    //   224: bipush 12
    //   226: aaload
    //   227: invokeinterface 114 2 0
    //   232: checkcast 14	java/lang/String
    //   235: astore 7
    //   237: aload_1
    //   238: getstatic 80	cn/jpush/android/api/DefaultPushNotificationBuilder:z	[Ljava/lang/String;
    //   241: bipush 18
    //   243: aaload
    //   244: invokeinterface 110 2 0
    //   249: ifeq +20 -> 269
    //   252: aload_1
    //   253: getstatic 80	cn/jpush/android/api/DefaultPushNotificationBuilder:z	[Ljava/lang/String;
    //   256: bipush 18
    //   258: aaload
    //   259: invokeinterface 114 2 0
    //   264: checkcast 14	java/lang/String
    //   267: astore 10
    //   269: getstatic 136	cn/jpush/android/d:e	Landroid/content/Context;
    //   272: ifnull +425 -> 697
    //   275: getstatic 136	cn/jpush/android/d:e	Landroid/content/Context;
    //   278: invokevirtual 142	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   281: getstatic 80	cn/jpush/android/api/DefaultPushNotificationBuilder:z	[Ljava/lang/String;
    //   284: bipush 9
    //   286: aaload
    //   287: getstatic 80	cn/jpush/android/api/DefaultPushNotificationBuilder:z	[Ljava/lang/String;
    //   290: bipush 17
    //   292: aaload
    //   293: getstatic 136	cn/jpush/android/d:e	Landroid/content/Context;
    //   296: invokevirtual 145	android/content/Context:getPackageName	()Ljava/lang/String;
    //   299: invokevirtual 151	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   302: istore 4
    //   304: iload 4
    //   306: istore_2
    //   307: iload 4
    //   309: ifne +13 -> 322
    //   312: getstatic 155	cn/jpush/android/d:b	I
    //   315: ifeq +331 -> 646
    //   318: getstatic 155	cn/jpush/android/d:b	I
    //   321: istore_2
    //   322: aload_0
    //   323: aload 6
    //   325: aload 5
    //   327: invokevirtual 157	cn/jpush/android/api/DefaultPushNotificationBuilder:buildContentView	(Ljava/lang/String;Ljava/lang/String;)Landroid/widget/RemoteViews;
    //   330: astore 11
    //   332: getstatic 162	android/os/Build$VERSION:SDK_INT	I
    //   335: bipush 11
    //   337: if_icmplt +570 -> 907
    //   340: new 164	android/app/Notification$Builder
    //   343: dup
    //   344: getstatic 136	cn/jpush/android/d:e	Landroid/content/Context;
    //   347: invokespecial 167	android/app/Notification$Builder:<init>	(Landroid/content/Context;)V
    //   350: aload 5
    //   352: invokevirtual 171	android/app/Notification$Builder:setContentTitle	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   355: aload 6
    //   357: invokevirtual 174	android/app/Notification$Builder:setContentText	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   360: aload 6
    //   362: invokevirtual 177	android/app/Notification$Builder:setTicker	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   365: iload_2
    //   366: invokevirtual 181	android/app/Notification$Builder:setSmallIcon	(I)Landroid/app/Notification$Builder;
    //   369: astore_1
    //   370: getstatic 162	android/os/Build$VERSION:SDK_INT	I
    //   373: bipush 16
    //   375: if_icmplt +253 -> 628
    //   378: aload 8
    //   380: invokestatic 120	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   383: ifne +27 -> 410
    //   386: new 183	android/app/Notification$BigTextStyle
    //   389: dup
    //   390: invokespecial 184	android/app/Notification$BigTextStyle:<init>	()V
    //   393: astore 5
    //   395: aload 5
    //   397: aload 8
    //   399: invokevirtual 188	android/app/Notification$BigTextStyle:bigText	(Ljava/lang/CharSequence;)Landroid/app/Notification$BigTextStyle;
    //   402: pop
    //   403: aload_1
    //   404: aload 5
    //   406: invokevirtual 192	android/app/Notification$Builder:setStyle	(Landroid/app/Notification$Style;)Landroid/app/Notification$Builder;
    //   409: pop
    //   410: aload 9
    //   412: invokestatic 120	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   415: ifne +81 -> 496
    //   418: new 194	android/app/Notification$InboxStyle
    //   421: dup
    //   422: invokespecial 195	android/app/Notification$InboxStyle:<init>	()V
    //   425: astore 5
    //   427: new 197	org/json/JSONObject
    //   430: dup
    //   431: aload 9
    //   433: invokespecial 200	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   436: astore 6
    //   438: aload 6
    //   440: invokevirtual 204	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   443: astore 8
    //   445: aload 8
    //   447: invokeinterface 210 1 0
    //   452: ifeq +258 -> 710
    //   455: aload 5
    //   457: aload 6
    //   459: aload 8
    //   461: invokeinterface 214 1 0
    //   466: checkcast 14	java/lang/String
    //   469: invokevirtual 217	java/lang/String:toString	()Ljava/lang/String;
    //   472: invokevirtual 221	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   475: invokevirtual 225	android/app/Notification$InboxStyle:addLine	(Ljava/lang/CharSequence;)Landroid/app/Notification$InboxStyle;
    //   478: pop
    //   479: goto -34 -> 445
    //   482: astore 6
    //   484: aload 6
    //   486: invokevirtual 228	org/json/JSONException:printStackTrace	()V
    //   489: aload_1
    //   490: aload 5
    //   492: invokevirtual 192	android/app/Notification$Builder:setStyle	(Landroid/app/Notification$Style;)Landroid/app/Notification$Builder;
    //   495: pop
    //   496: aload 10
    //   498: invokestatic 120	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   501: ifne +56 -> 557
    //   504: getstatic 22	cn/jpush/android/api/DefaultPushNotificationBuilder:TAG	Ljava/lang/String;
    //   507: new 230	java/lang/StringBuilder
    //   510: dup
    //   511: getstatic 80	cn/jpush/android/api/DefaultPushNotificationBuilder:z	[Ljava/lang/String;
    //   514: iconst_2
    //   515: aaload
    //   516: invokespecial 231	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   519: aload 10
    //   521: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   527: invokestatic 238	cn/jpush/android/c/f:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   530: new 240	android/app/Notification$BigPictureStyle
    //   533: dup
    //   534: invokespecial 241	android/app/Notification$BigPictureStyle:<init>	()V
    //   537: astore 5
    //   539: aload 5
    //   541: aload 10
    //   543: invokestatic 247	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   546: invokevirtual 251	android/app/Notification$BigPictureStyle:bigPicture	(Landroid/graphics/Bitmap;)Landroid/app/Notification$BigPictureStyle;
    //   549: pop
    //   550: aload_1
    //   551: aload 5
    //   553: invokevirtual 192	android/app/Notification$Builder:setStyle	(Landroid/app/Notification$Style;)Landroid/app/Notification$Builder;
    //   556: pop
    //   557: iload_3
    //   558: ifeq +14 -> 572
    //   561: iload_3
    //   562: iconst_1
    //   563: if_icmpne +231 -> 794
    //   566: aload_1
    //   567: iconst_1
    //   568: invokevirtual 254	android/app/Notification$Builder:setPriority	(I)Landroid/app/Notification$Builder;
    //   571: pop
    //   572: aload 7
    //   574: invokestatic 120	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   577: ifne +51 -> 628
    //   580: getstatic 162	android/os/Build$VERSION:SDK_INT	I
    //   583: bipush 21
    //   585: if_icmplt +292 -> 877
    //   588: getstatic 80	cn/jpush/android/api/DefaultPushNotificationBuilder:z	[Ljava/lang/String;
    //   591: bipush 13
    //   593: aaload
    //   594: invokestatic 260	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   597: getstatic 80	cn/jpush/android/api/DefaultPushNotificationBuilder:z	[Ljava/lang/String;
    //   600: iconst_1
    //   601: aaload
    //   602: iconst_1
    //   603: anewarray 256	java/lang/Class
    //   606: dup
    //   607: iconst_0
    //   608: ldc 14
    //   610: aastore
    //   611: invokevirtual 264	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   614: aload_1
    //   615: iconst_1
    //   616: anewarray 4	java/lang/Object
    //   619: dup
    //   620: iconst_0
    //   621: aload 7
    //   623: aastore
    //   624: invokevirtual 270	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   627: pop
    //   628: aload 11
    //   630: ifnull +262 -> 892
    //   633: aload_1
    //   634: aload 11
    //   636: invokevirtual 274	android/app/Notification$Builder:setContent	(Landroid/widget/RemoteViews;)Landroid/app/Notification$Builder;
    //   639: pop
    //   640: aload_0
    //   641: aload_1
    //   642: invokevirtual 278	cn/jpush/android/api/DefaultPushNotificationBuilder:getNotification	(Landroid/app/Notification$Builder;)Landroid/app/Notification;
    //   645: areturn
    //   646: getstatic 136	cn/jpush/android/d:e	Landroid/content/Context;
    //   649: invokevirtual 282	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   652: getstatic 136	cn/jpush/android/d:e	Landroid/content/Context;
    //   655: invokevirtual 145	android/content/Context:getPackageName	()Ljava/lang/String;
    //   658: iconst_0
    //   659: invokevirtual 288	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   662: getfield 293	android/content/pm/ApplicationInfo:icon	I
    //   665: istore_2
    //   666: getstatic 22	cn/jpush/android/api/DefaultPushNotificationBuilder:TAG	Ljava/lang/String;
    //   669: getstatic 80	cn/jpush/android/api/DefaultPushNotificationBuilder:z	[Ljava/lang/String;
    //   672: bipush 6
    //   674: aaload
    //   675: invokestatic 238	cn/jpush/android/c/f:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   678: goto -356 -> 322
    //   681: astore_1
    //   682: getstatic 22	cn/jpush/android/api/DefaultPushNotificationBuilder:TAG	Ljava/lang/String;
    //   685: getstatic 80	cn/jpush/android/api/DefaultPushNotificationBuilder:z	[Ljava/lang/String;
    //   688: bipush 8
    //   690: aaload
    //   691: aload_1
    //   692: invokestatic 296	cn/jpush/android/c/f:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   695: aconst_null
    //   696: areturn
    //   697: getstatic 22	cn/jpush/android/api/DefaultPushNotificationBuilder:TAG	Ljava/lang/String;
    //   700: getstatic 80	cn/jpush/android/api/DefaultPushNotificationBuilder:z	[Ljava/lang/String;
    //   703: iconst_5
    //   704: aaload
    //   705: invokestatic 299	cn/jpush/android/c/f:g	(Ljava/lang/String;Ljava/lang/String;)V
    //   708: aconst_null
    //   709: areturn
    //   710: aload 5
    //   712: new 230	java/lang/StringBuilder
    //   715: dup
    //   716: getstatic 80	cn/jpush/android/api/DefaultPushNotificationBuilder:z	[Ljava/lang/String;
    //   719: iconst_0
    //   720: aaload
    //   721: invokespecial 231	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   724: aload 6
    //   726: invokevirtual 303	org/json/JSONObject:length	()I
    //   729: invokevirtual 306	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   732: getstatic 80	cn/jpush/android/api/DefaultPushNotificationBuilder:z	[Ljava/lang/String;
    //   735: iconst_3
    //   736: aaload
    //   737: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   743: invokevirtual 309	android/app/Notification$InboxStyle:setSummaryText	(Ljava/lang/CharSequence;)Landroid/app/Notification$InboxStyle;
    //   746: pop
    //   747: goto -258 -> 489
    //   750: astore 5
    //   752: getstatic 22	cn/jpush/android/api/DefaultPushNotificationBuilder:TAG	Ljava/lang/String;
    //   755: getstatic 80	cn/jpush/android/api/DefaultPushNotificationBuilder:z	[Ljava/lang/String;
    //   758: bipush 7
    //   760: aaload
    //   761: invokestatic 126	cn/jpush/android/c/f:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   764: aload 5
    //   766: invokevirtual 310	java/lang/OutOfMemoryError:printStackTrace	()V
    //   769: goto -212 -> 557
    //   772: astore 5
    //   774: getstatic 22	cn/jpush/android/api/DefaultPushNotificationBuilder:TAG	Ljava/lang/String;
    //   777: getstatic 80	cn/jpush/android/api/DefaultPushNotificationBuilder:z	[Ljava/lang/String;
    //   780: bipush 21
    //   782: aaload
    //   783: invokestatic 126	cn/jpush/android/c/f:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   786: aload 5
    //   788: invokevirtual 311	java/lang/Exception:printStackTrace	()V
    //   791: goto -234 -> 557
    //   794: iload_3
    //   795: iconst_2
    //   796: if_icmpne +12 -> 808
    //   799: aload_1
    //   800: iconst_2
    //   801: invokevirtual 254	android/app/Notification$Builder:setPriority	(I)Landroid/app/Notification$Builder;
    //   804: pop
    //   805: goto -233 -> 572
    //   808: iload_3
    //   809: iconst_m1
    //   810: if_icmpne +12 -> 822
    //   813: aload_1
    //   814: iconst_m1
    //   815: invokevirtual 254	android/app/Notification$Builder:setPriority	(I)Landroid/app/Notification$Builder;
    //   818: pop
    //   819: goto -247 -> 572
    //   822: iload_3
    //   823: bipush -2
    //   825: if_icmpne +13 -> 838
    //   828: aload_1
    //   829: bipush -2
    //   831: invokevirtual 254	android/app/Notification$Builder:setPriority	(I)Landroid/app/Notification$Builder;
    //   834: pop
    //   835: goto -263 -> 572
    //   838: aload_1
    //   839: iconst_0
    //   840: invokevirtual 254	android/app/Notification$Builder:setPriority	(I)Landroid/app/Notification$Builder;
    //   843: pop
    //   844: goto -272 -> 572
    //   847: astore 5
    //   849: aload 5
    //   851: invokevirtual 312	java/lang/ClassNotFoundException:printStackTrace	()V
    //   854: goto -226 -> 628
    //   857: astore 5
    //   859: aload 5
    //   861: invokevirtual 313	java/lang/NoSuchMethodException:printStackTrace	()V
    //   864: goto -236 -> 628
    //   867: astore 5
    //   869: aload 5
    //   871: invokevirtual 311	java/lang/Exception:printStackTrace	()V
    //   874: goto -246 -> 628
    //   877: getstatic 22	cn/jpush/android/api/DefaultPushNotificationBuilder:TAG	Ljava/lang/String;
    //   880: getstatic 80	cn/jpush/android/api/DefaultPushNotificationBuilder:z	[Ljava/lang/String;
    //   883: bipush 16
    //   885: aaload
    //   886: invokestatic 126	cn/jpush/android/c/f:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   889: goto -261 -> 628
    //   892: getstatic 22	cn/jpush/android/api/DefaultPushNotificationBuilder:TAG	Ljava/lang/String;
    //   895: getstatic 80	cn/jpush/android/api/DefaultPushNotificationBuilder:z	[Ljava/lang/String;
    //   898: bipush 15
    //   900: aaload
    //   901: invokestatic 238	cn/jpush/android/c/f:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   904: goto -264 -> 640
    //   907: new 315	android/app/Notification
    //   910: dup
    //   911: iload_2
    //   912: aload 6
    //   914: invokestatic 321	java/lang/System:currentTimeMillis	()J
    //   917: invokespecial 324	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   920: astore 7
    //   922: aload_0
    //   923: aload 7
    //   925: invokevirtual 328	cn/jpush/android/api/DefaultPushNotificationBuilder:resetNotificationParams	(Landroid/app/Notification;)V
    //   928: aload 5
    //   930: astore_1
    //   931: aload 5
    //   933: ifnonnull +7 -> 940
    //   936: getstatic 102	cn/jpush/android/d:d	Ljava/lang/String;
    //   939: astore_1
    //   940: aload 11
    //   942: ifnull +13 -> 955
    //   945: aload 7
    //   947: aload 11
    //   949: putfield 332	android/app/Notification:contentView	Landroid/widget/RemoteViews;
    //   952: aload 7
    //   954: areturn
    //   955: getstatic 136	cn/jpush/android/d:e	Landroid/content/Context;
    //   958: astore 5
    //   960: getstatic 80	cn/jpush/android/api/DefaultPushNotificationBuilder:z	[Ljava/lang/String;
    //   963: bipush 20
    //   965: aaload
    //   966: invokestatic 260	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   969: getstatic 80	cn/jpush/android/api/DefaultPushNotificationBuilder:z	[Ljava/lang/String;
    //   972: bipush 10
    //   974: aaload
    //   975: iconst_4
    //   976: anewarray 256	java/lang/Class
    //   979: dup
    //   980: iconst_0
    //   981: ldc -118
    //   983: aastore
    //   984: dup
    //   985: iconst_1
    //   986: ldc_w 334
    //   989: aastore
    //   990: dup
    //   991: iconst_2
    //   992: ldc_w 334
    //   995: aastore
    //   996: dup
    //   997: iconst_3
    //   998: ldc_w 336
    //   1001: aastore
    //   1002: invokevirtual 264	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   1005: aload 7
    //   1007: iconst_4
    //   1008: anewarray 4	java/lang/Object
    //   1011: dup
    //   1012: iconst_0
    //   1013: aload 5
    //   1015: aastore
    //   1016: dup
    //   1017: iconst_1
    //   1018: aload_1
    //   1019: aastore
    //   1020: dup
    //   1021: iconst_2
    //   1022: aload 6
    //   1024: aastore
    //   1025: dup
    //   1026: iconst_3
    //   1027: aconst_null
    //   1028: aastore
    //   1029: invokevirtual 270	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1032: pop
    //   1033: goto -81 -> 952
    //   1036: astore_1
    //   1037: aload_1
    //   1038: invokevirtual 311	java/lang/Exception:printStackTrace	()V
    //   1041: goto -89 -> 952
    //   1044: ldc 104
    //   1046: astore 6
    //   1048: goto -993 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1051	0	this	DefaultPushNotificationBuilder
    //   0	1051	1	paramMap	java.util.Map<String, String>
    //   306	606	2	i	int
    //   14	812	3	j	int
    //   302	6	4	k	int
    //   3	708	5	localObject1	Object
    //   750	15	5	localOutOfMemoryError	OutOfMemoryError
    //   772	15	5	localException1	Exception
    //   847	3	5	localClassNotFoundException	ClassNotFoundException
    //   857	3	5	localNoSuchMethodException	NoSuchMethodException
    //   867	65	5	localException2	Exception
    //   958	56	5	localContext	android.content.Context
    //   53	405	6	localObject2	Object
    //   482	541	6	localJSONException	org.json.JSONException
    //   1046	1	6	str1	String
    //   17	989	7	localObject3	Object
    //   7	453	8	localObject4	Object
    //   11	421	9	str2	String
    //   21	521	10	str3	String
    //   330	618	11	localRemoteViews	RemoteViews
    // Exception table:
    //   from	to	target	type
    //   427	445	482	org/json/JSONException
    //   445	479	482	org/json/JSONException
    //   710	747	482	org/json/JSONException
    //   646	678	681	java/lang/Exception
    //   530	557	750	java/lang/OutOfMemoryError
    //   530	557	772	java/lang/Exception
    //   588	628	847	java/lang/ClassNotFoundException
    //   588	628	857	java/lang/NoSuchMethodException
    //   588	628	867	java/lang/Exception
    //   960	1033	1036	java/lang/Exception
  }
  
  public String getDeveloperArg0()
  {
    return null;
  }
  
  Notification getNotification(Notification.Builder paramBuilder)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramBuilder.build();
    }
    return paramBuilder.getNotification();
  }
  
  void resetNotificationParams(Notification paramNotification) {}
  
  public String toString()
  {
    return "";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/api/DefaultPushNotificationBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */