package com.baidu.platform.comapi.search;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.mapapi.MessageCenter;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.MapBound;
import com.baidu.mapapi.model.inner.Point;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class d
{
  private static final String a = d.class.getSimpleName();
  private com.baidu.platform.comjni.map.search.a b = null;
  private long c = this.b.a();
  private c d = null;
  private Handler e = null;
  private int f = 10;
  private Bundle g = null;
  
  public d()
  {
    MessageCenter.registMessage(2000, this.e);
    this.d.a(this);
  }
  
  private Bundle a(a parama)
  {
    if (parama == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", parama.a);
    localBundle.putString("uid", parama.e);
    if (parama.b != null)
    {
      localBundle.putInt("x", parama.b.getmPtx());
      localBundle.putInt("y", parama.b.getmPty());
    }
    localBundle.putString("keyword", parama.d);
    return localBundle;
  }
  
  private Bundle c()
  {
    if (this.g == null) {
      this.g = new Bundle();
    }
    for (;;)
    {
      return this.g;
      this.g.clear();
    }
  }
  
  public void a()
  {
    MessageCenter.unregistMessage(2000, this.e);
    this.b.b();
    this.d.a();
    this.e = null;
    this.b = null;
    this.g = null;
    this.d = null;
    this.c = 0L;
  }
  
  public void a(int paramInt)
  {
    if ((paramInt > 0) && (paramInt <= 50)) {
      this.f = paramInt;
    }
  }
  
  public void a(b paramb)
  {
    this.d.a(paramb);
  }
  
  public boolean a(Point paramPoint)
  {
    if (paramPoint == null) {
      return false;
    }
    int i = paramPoint.getmPty();
    int j = paramPoint.getmPtx();
    return this.b.a(j, i);
  }
  
  public boolean a(Point paramPoint1, Point paramPoint2, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.b == null) {
      return false;
    }
    Bundle localBundle = c();
    if (paramInt3 == 3)
    {
      localBundle.putInt("cityCode", paramInt4);
      localBundle.putInt("pn", paramInt5);
    }
    for (;;)
    {
      localBundle.putInt("tn", paramInt3);
      if (paramPoint1 != null)
      {
        localBundle.putInt("startX", paramPoint1.getmPtx());
        localBundle.putInt("startY", paramPoint1.getmPty());
      }
      if (paramPoint2 != null)
      {
        localBundle.putInt("endX", paramPoint2.getmPtx());
        localBundle.putInt("endY", paramPoint2.getmPty());
      }
      localBundle.putString("strName", paramString1);
      localBundle.putString("endName", paramString2);
      return this.b.i(localBundle);
      if (paramInt1 >= 0) {
        localBundle.putInt("startCode", paramInt1);
      }
      if (paramInt1 >= 0) {
        localBundle.putInt("endCode", paramInt2);
      }
    }
  }
  
  public boolean a(Point paramPoint, String paramString1, String paramString2)
  {
    if ((paramPoint == null) || (paramString1 == null) || (paramString2 == null)) {
      return false;
    }
    return this.b.a(paramPoint.getmPtx(), paramPoint.getmPty(), paramString1, paramString2);
  }
  
  public boolean a(a parama1, a parama2, String paramString, MapBound paramMapBound, int paramInt1, int paramInt2, Map<String, Object> paramMap)
  {
    if ((paramString == null) || (paramString.equals(""))) {}
    Bundle localBundle;
    do
    {
      do
      {
        return false;
        localBundle = c();
        parama1 = a(parama1);
        parama2 = a(parama2);
      } while ((parama1 == null) || (parama2 == null));
      localBundle.putBundle("start", parama1);
      localBundle.putBundle("end", parama2);
    } while ((paramInt2 < 3) || (paramInt2 > 6));
    localBundle.putInt("strategy", paramInt2);
    localBundle.putString("cityid", paramString);
    if ((paramMapBound != null) && (paramMapBound.ptLB != null) && (paramMapBound.ptRT != null))
    {
      parama1 = new Bundle();
      parama1.putInt("level", paramInt1);
      parama1.putInt("ll_x", paramMapBound.ptLB.getmPtx());
      parama1.putInt("ll_y", paramMapBound.ptLB.getmPty());
      parama1.putInt("ru_x", paramMapBound.ptRT.getmPtx());
      parama1.putInt("ru_y", paramMapBound.ptRT.getmPty());
      localBundle.putBundle("mapbound", parama1);
    }
    if (paramMap != null)
    {
      parama1 = new Bundle();
      parama2 = paramMap.keySet().iterator();
      while (parama2.hasNext())
      {
        paramString = (String)parama2.next();
        paramMapBound = paramMap.get(paramString);
        parama1.putString(paramString.toString(), paramMapBound.toString());
      }
      localBundle.putBundle("extparams", parama1);
    }
    return this.b.d(localBundle);
  }
  
  public boolean a(a parama1, a parama2, String paramString1, String paramString2)
  {
    if ((parama1 == null) || (parama2 == null)) {}
    while (((parama1.c == null) && ((parama1.d == null) || (parama1.d.equals("")))) || ((parama2.c == null) && ((parama2.d == null) || (parama2.d.equals(""))))) {
      return false;
    }
    Bundle localBundle = c();
    localBundle.putInt("starttype", parama1.a);
    if (parama1.c != null)
    {
      localBundle.putDouble("startptx", parama1.c.longitude);
      localBundle.putDouble("startpty", parama1.c.latitude);
    }
    localBundle.putString("startkeyword", parama1.d);
    localBundle.putString("startcity", paramString1);
    localBundle.putInt("endtype", parama2.a);
    if (parama2.c != null)
    {
      localBundle.putDouble("endptx", parama2.c.longitude);
      localBundle.putDouble("endpty", parama2.c.latitude);
    }
    localBundle.putString("endkeyword", parama2.d);
    localBundle.putString("endcity", paramString2);
    return this.b.g(localBundle);
  }
  
  /* Error */
  public boolean a(a parama1, a parama2, String paramString1, String paramString2, String paramString3, MapBound paramMapBound, int paramInt1, int paramInt2, int paramInt3, java.util.ArrayList<f> paramArrayList, Map<String, Object> paramMap)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +7 -> 8
    //   4: aload_2
    //   5: ifnonnull +5 -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: aload_1
    //   11: getfield 92	com/baidu/platform/comapi/search/a:b	Lcom/baidu/mapapi/model/inner/Point;
    //   14: ifnonnull +20 -> 34
    //   17: aload 4
    //   19: ifnull +13 -> 32
    //   22: aload 4
    //   24: ldc -91
    //   26: invokevirtual 171	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   29: ifeq +5 -> 34
    //   32: iconst_0
    //   33: ireturn
    //   34: aload_2
    //   35: getfield 92	com/baidu/platform/comapi/search/a:b	Lcom/baidu/mapapi/model/inner/Point;
    //   38: ifnonnull +20 -> 58
    //   41: aload 5
    //   43: ifnull +13 -> 56
    //   46: aload 5
    //   48: ldc -91
    //   50: invokevirtual 171	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   53: ifeq +5 -> 58
    //   56: iconst_0
    //   57: ireturn
    //   58: aload_0
    //   59: invokespecial 132	com/baidu/platform/comapi/search/d:c	()Landroid/os/Bundle;
    //   62: astore 12
    //   64: aload 12
    //   66: ldc -10
    //   68: aload_1
    //   69: getfield 77	com/baidu/platform/comapi/search/a:a	I
    //   72: invokevirtual 81	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   75: aload_1
    //   76: getfield 92	com/baidu/platform/comapi/search/a:b	Lcom/baidu/mapapi/model/inner/Point;
    //   79: ifnull +32 -> 111
    //   82: aload 12
    //   84: ldc -8
    //   86: aload_1
    //   87: getfield 92	com/baidu/platform/comapi/search/a:b	Lcom/baidu/mapapi/model/inner/Point;
    //   90: invokevirtual 100	com/baidu/mapapi/model/inner/Point:getmPtx	()I
    //   93: invokevirtual 81	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   96: aload 12
    //   98: ldc_w 260
    //   101: aload_1
    //   102: getfield 92	com/baidu/platform/comapi/search/a:b	Lcom/baidu/mapapi/model/inner/Point;
    //   105: invokevirtual 105	com/baidu/mapapi/model/inner/Point:getmPty	()I
    //   108: invokevirtual 81	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   111: aload 12
    //   113: ldc_w 265
    //   116: aload_1
    //   117: getfield 109	com/baidu/platform/comapi/search/a:d	Ljava/lang/String;
    //   120: invokevirtual 89	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: aload 12
    //   125: ldc_w 284
    //   128: aload_1
    //   129: getfield 85	com/baidu/platform/comapi/search/a:e	Ljava/lang/String;
    //   132: invokevirtual 89	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload 12
    //   137: ldc_w 269
    //   140: aload_2
    //   141: getfield 77	com/baidu/platform/comapi/search/a:a	I
    //   144: invokevirtual 81	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   147: aload_2
    //   148: getfield 92	com/baidu/platform/comapi/search/a:b	Lcom/baidu/mapapi/model/inner/Point;
    //   151: ifnull +33 -> 184
    //   154: aload 12
    //   156: ldc_w 271
    //   159: aload_2
    //   160: getfield 92	com/baidu/platform/comapi/search/a:b	Lcom/baidu/mapapi/model/inner/Point;
    //   163: invokevirtual 100	com/baidu/mapapi/model/inner/Point:getmPtx	()I
    //   166: invokevirtual 81	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   169: aload 12
    //   171: ldc_w 273
    //   174: aload_2
    //   175: getfield 92	com/baidu/platform/comapi/search/a:b	Lcom/baidu/mapapi/model/inner/Point;
    //   178: invokevirtual 105	com/baidu/mapapi/model/inner/Point:getmPty	()I
    //   181: invokevirtual 81	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   184: aload 12
    //   186: ldc_w 275
    //   189: aload_2
    //   190: getfield 109	com/baidu/platform/comapi/search/a:d	Ljava/lang/String;
    //   193: invokevirtual 89	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   196: aload 12
    //   198: ldc_w 286
    //   201: aload_2
    //   202: getfield 85	com/baidu/platform/comapi/search/a:e	Ljava/lang/String;
    //   205: invokevirtual 89	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   208: aload 12
    //   210: ldc -61
    //   212: iload 7
    //   214: invokevirtual 81	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   217: aload 6
    //   219: ifnull +79 -> 298
    //   222: aload 6
    //   224: getfield 190	com/baidu/mapapi/model/inner/MapBound:ptLB	Lcom/baidu/mapapi/model/inner/Point;
    //   227: ifnull +71 -> 298
    //   230: aload 6
    //   232: getfield 193	com/baidu/mapapi/model/inner/MapBound:ptRT	Lcom/baidu/mapapi/model/inner/Point;
    //   235: ifnull +63 -> 298
    //   238: aload 12
    //   240: ldc -59
    //   242: aload 6
    //   244: getfield 190	com/baidu/mapapi/model/inner/MapBound:ptLB	Lcom/baidu/mapapi/model/inner/Point;
    //   247: invokevirtual 100	com/baidu/mapapi/model/inner/Point:getmPtx	()I
    //   250: invokevirtual 81	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   253: aload 12
    //   255: ldc -57
    //   257: aload 6
    //   259: getfield 190	com/baidu/mapapi/model/inner/MapBound:ptLB	Lcom/baidu/mapapi/model/inner/Point;
    //   262: invokevirtual 105	com/baidu/mapapi/model/inner/Point:getmPty	()I
    //   265: invokevirtual 81	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   268: aload 12
    //   270: ldc -55
    //   272: aload 6
    //   274: getfield 193	com/baidu/mapapi/model/inner/MapBound:ptRT	Lcom/baidu/mapapi/model/inner/Point;
    //   277: invokevirtual 100	com/baidu/mapapi/model/inner/Point:getmPtx	()I
    //   280: invokevirtual 81	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   283: aload 12
    //   285: ldc -53
    //   287: aload 6
    //   289: getfield 193	com/baidu/mapapi/model/inner/MapBound:ptRT	Lcom/baidu/mapapi/model/inner/Point;
    //   292: invokevirtual 105	com/baidu/mapapi/model/inner/Point:getmPty	()I
    //   295: invokevirtual 81	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   298: aload 12
    //   300: ldc -73
    //   302: iload 8
    //   304: invokevirtual 81	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   307: aload 12
    //   309: ldc -71
    //   311: aload_3
    //   312: invokevirtual 89	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   315: aload 12
    //   317: ldc_w 288
    //   320: aload 4
    //   322: invokevirtual 89	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   325: aload 12
    //   327: ldc_w 290
    //   330: aload 5
    //   332: invokevirtual 89	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   335: aload 12
    //   337: ldc_w 292
    //   340: iload 9
    //   342: invokevirtual 81	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   345: aload 10
    //   347: ifnull +350 -> 697
    //   350: aload 10
    //   352: invokevirtual 297	java/util/ArrayList:size	()I
    //   355: istore 9
    //   357: iconst_0
    //   358: istore 8
    //   360: ldc -91
    //   362: astore_1
    //   363: ldc -91
    //   365: astore_2
    //   366: iconst_0
    //   367: istore 7
    //   369: iload 7
    //   371: iload 9
    //   373: if_icmpge +306 -> 679
    //   376: new 299	org/json/JSONObject
    //   379: dup
    //   380: invokespecial 300	org/json/JSONObject:<init>	()V
    //   383: astore 4
    //   385: aload 10
    //   387: iload 7
    //   389: invokevirtual 303	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   392: checkcast 305	com/baidu/platform/comapi/search/f
    //   395: getfield 307	com/baidu/platform/comapi/search/f:a	Lcom/baidu/mapapi/model/inner/Point;
    //   398: ifnull +258 -> 656
    //   401: aload 4
    //   403: ldc 73
    //   405: iconst_1
    //   406: invokevirtual 311	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   409: pop
    //   410: aload 4
    //   412: ldc 107
    //   414: aload 10
    //   416: iload 7
    //   418: invokevirtual 303	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   421: checkcast 305	com/baidu/platform/comapi/search/f
    //   424: getfield 313	com/baidu/platform/comapi/search/f:b	Ljava/lang/String;
    //   427: invokevirtual 316	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   430: pop
    //   431: aload 10
    //   433: iload 7
    //   435: invokevirtual 303	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   438: checkcast 305	com/baidu/platform/comapi/search/f
    //   441: getfield 307	com/baidu/platform/comapi/search/f:a	Lcom/baidu/mapapi/model/inner/Point;
    //   444: ifnull +72 -> 516
    //   447: aload 4
    //   449: ldc_w 318
    //   452: new 320	java/lang/StringBuilder
    //   455: dup
    //   456: invokespecial 321	java/lang/StringBuilder:<init>	()V
    //   459: aload 10
    //   461: iload 7
    //   463: invokevirtual 303	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   466: checkcast 305	com/baidu/platform/comapi/search/f
    //   469: getfield 307	com/baidu/platform/comapi/search/f:a	Lcom/baidu/mapapi/model/inner/Point;
    //   472: getfield 323	com/baidu/mapapi/model/inner/Point:x	I
    //   475: invokestatic 327	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   478: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: ldc_w 333
    //   484: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: aload 10
    //   489: iload 7
    //   491: invokevirtual 303	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   494: checkcast 305	com/baidu/platform/comapi/search/f
    //   497: getfield 307	com/baidu/platform/comapi/search/f:a	Lcom/baidu/mapapi/model/inner/Point;
    //   500: getfield 335	com/baidu/mapapi/model/inner/Point:y	I
    //   503: invokestatic 327	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   506: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: invokevirtual 336	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   512: invokevirtual 316	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   515: pop
    //   516: new 320	java/lang/StringBuilder
    //   519: dup
    //   520: invokespecial 321	java/lang/StringBuilder:<init>	()V
    //   523: aload_2
    //   524: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: aload 10
    //   529: iload 7
    //   531: invokevirtual 303	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   534: checkcast 305	com/baidu/platform/comapi/search/f
    //   537: getfield 338	com/baidu/platform/comapi/search/f:c	Ljava/lang/String;
    //   540: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: invokevirtual 336	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   546: astore_3
    //   547: aload_3
    //   548: astore_2
    //   549: new 320	java/lang/StringBuilder
    //   552: dup
    //   553: invokespecial 321	java/lang/StringBuilder:<init>	()V
    //   556: aload_1
    //   557: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: aload 4
    //   562: invokevirtual 339	org/json/JSONObject:toString	()Ljava/lang/String;
    //   565: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: invokevirtual 336	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   571: astore_3
    //   572: aload_2
    //   573: astore_1
    //   574: aload_3
    //   575: astore 4
    //   577: iload 8
    //   579: iload 9
    //   581: iconst_1
    //   582: isub
    //   583: if_icmpeq +53 -> 636
    //   586: aload_3
    //   587: astore_1
    //   588: new 320	java/lang/StringBuilder
    //   591: dup
    //   592: invokespecial 321	java/lang/StringBuilder:<init>	()V
    //   595: aload_3
    //   596: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: ldc_w 341
    //   602: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: invokevirtual 336	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   608: astore 4
    //   610: aload 4
    //   612: astore_1
    //   613: new 320	java/lang/StringBuilder
    //   616: dup
    //   617: invokespecial 321	java/lang/StringBuilder:<init>	()V
    //   620: aload_2
    //   621: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: ldc_w 341
    //   627: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: invokevirtual 336	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   633: astore_3
    //   634: aload_3
    //   635: astore_1
    //   636: iload 8
    //   638: iconst_1
    //   639: iadd
    //   640: istore 8
    //   642: aload_1
    //   643: astore_2
    //   644: iload 7
    //   646: iconst_1
    //   647: iadd
    //   648: istore 7
    //   650: aload 4
    //   652: astore_1
    //   653: goto -284 -> 369
    //   656: aload 4
    //   658: ldc 73
    //   660: iconst_2
    //   661: invokevirtual 311	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   664: pop
    //   665: goto -255 -> 410
    //   668: astore_3
    //   669: aload_3
    //   670: invokevirtual 344	org/json/JSONException:printStackTrace	()V
    //   673: aload_1
    //   674: astore 4
    //   676: goto -32 -> 644
    //   679: aload 12
    //   681: ldc_w 346
    //   684: aload_1
    //   685: invokevirtual 89	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   688: aload 12
    //   690: ldc_w 348
    //   693: aload_2
    //   694: invokevirtual 89	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   697: aload 11
    //   699: ifnull +77 -> 776
    //   702: new 70	android/os/Bundle
    //   705: dup
    //   706: invokespecial 71	android/os/Bundle:<init>	()V
    //   709: astore_1
    //   710: aload 11
    //   712: invokeinterface 211 1 0
    //   717: invokeinterface 217 1 0
    //   722: astore_2
    //   723: aload_2
    //   724: invokeinterface 223 1 0
    //   729: ifeq +39 -> 768
    //   732: aload_2
    //   733: invokeinterface 227 1 0
    //   738: checkcast 167	java/lang/String
    //   741: astore_3
    //   742: aload 11
    //   744: aload_3
    //   745: invokeinterface 231 2 0
    //   750: astore 4
    //   752: aload_1
    //   753: aload_3
    //   754: invokevirtual 234	java/lang/Object:toString	()Ljava/lang/String;
    //   757: aload 4
    //   759: invokevirtual 234	java/lang/Object:toString	()Ljava/lang/String;
    //   762: invokevirtual 89	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   765: goto -42 -> 723
    //   768: aload 12
    //   770: ldc -20
    //   772: aload_1
    //   773: invokevirtual 179	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   776: aload_0
    //   777: getfield 34	com/baidu/platform/comapi/search/d:b	Lcom/baidu/platform/comjni/map/search/a;
    //   780: aload 12
    //   782: invokevirtual 350	com/baidu/platform/comjni/map/search/a:e	(Landroid/os/Bundle;)Z
    //   785: ireturn
    //   786: astore_3
    //   787: goto -118 -> 669
    //   790: astore_3
    //   791: goto -122 -> 669
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	794	0	this	d
    //   0	794	1	parama1	a
    //   0	794	2	parama2	a
    //   0	794	3	paramString1	String
    //   0	794	4	paramString2	String
    //   0	794	5	paramString3	String
    //   0	794	6	paramMapBound	MapBound
    //   0	794	7	paramInt1	int
    //   0	794	8	paramInt2	int
    //   0	794	9	paramInt3	int
    //   0	794	10	paramArrayList	java.util.ArrayList<f>
    //   0	794	11	paramMap	Map<String, Object>
    //   62	719	12	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   376	410	668	org/json/JSONException
    //   410	516	668	org/json/JSONException
    //   516	547	668	org/json/JSONException
    //   656	665	668	org/json/JSONException
    //   588	610	786	org/json/JSONException
    //   613	634	786	org/json/JSONException
    //   549	572	790	org/json/JSONException
  }
  
  public boolean a(a parama1, a parama2, String paramString1, String paramString2, String paramString3, MapBound paramMapBound, int paramInt, Map<String, Object> paramMap)
  {
    if ((parama1 == null) || (parama2 == null)) {}
    while (((parama1.b == null) && ((paramString2 == null) || (paramString2.equals("")))) || ((parama2.b == null) && ((paramString3 == null) || (paramString3.equals(""))))) {
      return false;
    }
    Bundle localBundle = c();
    localBundle.putInt("starttype", parama1.a);
    if (parama1.b != null)
    {
      localBundle.putInt("startptx", parama1.b.getmPtx());
      localBundle.putInt("startpty", parama1.b.getmPty());
    }
    localBundle.putString("startkeyword", parama1.d);
    localBundle.putString("startuid", parama1.e);
    localBundle.putInt("endtype", parama2.a);
    if (parama2.b != null)
    {
      localBundle.putInt("endptx", parama2.b.getmPtx());
      localBundle.putInt("endpty", parama2.b.getmPty());
    }
    localBundle.putString("endkeyword", parama2.d);
    localBundle.putString("enduid", parama2.e);
    localBundle.putInt("level", paramInt);
    if ((paramMapBound != null) && (paramMapBound.ptLB != null) && (paramMapBound.ptRT != null))
    {
      localBundle.putInt("ll_x", paramMapBound.ptLB.getmPtx());
      localBundle.putInt("ll_y", paramMapBound.ptLB.getmPty());
      localBundle.putInt("ru_x", paramMapBound.ptRT.getmPtx());
      localBundle.putInt("ru_y", paramMapBound.ptRT.getmPty());
    }
    localBundle.putString("cityid", paramString1);
    localBundle.putString("st_cityid", paramString2);
    localBundle.putString("en_cityid", paramString3);
    if (paramMap != null)
    {
      parama1 = new Bundle();
      parama2 = paramMap.keySet().iterator();
      while (parama2.hasNext())
      {
        paramString1 = (String)parama2.next();
        paramString2 = paramMap.get(paramString1);
        parama1.putString(paramString1.toString(), paramString2.toString());
      }
      localBundle.putBundle("extparams", parama1);
    }
    return this.b.f(localBundle);
  }
  
  public boolean a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = paramString.trim();
    } while ((paramString.length() == 0) || (paramString.length() > 99));
    return this.b.a(paramString);
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, int paramInt3, MapBound paramMapBound1, MapBound paramMapBound2, Map<String, Object> paramMap, int paramInt4)
  {
    if (paramString == null) {}
    Object localObject1;
    do
    {
      return false;
      localObject1 = paramString.trim();
    } while ((((String)localObject1).length() == 0) || (((String)localObject1).length() > 99));
    paramString = c();
    paramString.putString("keyword", (String)localObject1);
    paramString.putInt("pagenum", paramInt2);
    paramString.putInt("count", this.f);
    paramString.putInt("cityid", paramInt1);
    paramString.putInt("level", paramInt3);
    paramString.putInt("sortType", paramInt4);
    if (paramMapBound2 != null)
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("ll_x", paramMapBound2.ptLB.getmPtx());
      ((Bundle)localObject1).putInt("ll_y", paramMapBound2.ptLB.getmPty());
      ((Bundle)localObject1).putInt("ru_x", paramMapBound2.ptRT.getmPtx());
      ((Bundle)localObject1).putInt("ru_y", paramMapBound2.ptRT.getmPty());
      paramString.putBundle("mapbound", (Bundle)localObject1);
    }
    if (paramMapBound1 != null)
    {
      paramString.putInt("ll_x", paramMapBound1.ptLB.getmPtx());
      paramString.putInt("ll_y", paramMapBound1.ptLB.getmPty());
      paramString.putInt("ru_x", paramMapBound1.ptRT.getmPtx());
      paramString.putInt("ru_y", paramMapBound1.ptRT.getmPty());
      paramString.putInt("loc_x", (paramMapBound1.ptLB.getmPtx() + paramMapBound1.ptRT.getmPtx()) / 2);
      paramString.putInt("loc_y", (paramMapBound1.ptLB.getmPty() + paramMapBound1.ptRT.getmPty()) / 2);
    }
    if (paramMap != null)
    {
      paramMapBound1 = new Bundle();
      paramMapBound2 = paramMap.keySet().iterator();
      while (paramMapBound2.hasNext())
      {
        localObject1 = (String)paramMapBound2.next();
        Object localObject2 = paramMap.get(localObject1);
        paramMapBound1.putString(localObject1.toString(), localObject2.toString());
      }
      paramString.putBundle("extparams", paramMapBound1);
    }
    return this.b.b(paramString);
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, MapBound paramMapBound, int paramInt3, Point paramPoint, Map<String, Object> paramMap)
  {
    if (paramMapBound == null) {}
    String str;
    do
    {
      do
      {
        return false;
      } while (paramString == null);
      str = paramString.trim();
    } while ((str.length() == 0) || (str.length() > 99));
    paramString = c();
    paramString.putString("keyword", str);
    paramString.putInt("pagenum", paramInt2);
    paramString.putInt("count", this.f);
    paramString.putString("cityid", String.valueOf(paramInt1));
    paramString.putInt("level", paramInt3);
    if (paramMapBound != null)
    {
      paramString.putInt("ll_x", paramMapBound.ptLB.getmPtx());
      paramString.putInt("ll_y", paramMapBound.ptLB.getmPty());
      paramString.putInt("ru_x", paramMapBound.ptRT.getmPtx());
      paramString.putInt("ru_y", paramMapBound.ptRT.getmPty());
    }
    if (paramPoint != null)
    {
      paramString.putInt("loc_x", paramPoint.x);
      paramString.putInt("loc_y", paramPoint.y);
    }
    if (paramMap != null)
    {
      paramMapBound = new Bundle();
      paramPoint = paramMap.keySet().iterator();
      while (paramPoint.hasNext())
      {
        str = (String)paramPoint.next();
        Object localObject = paramMap.get(str);
        paramMapBound.putString(str.toString(), localObject.toString());
      }
      paramString.putBundle("extparams", paramMapBound);
    }
    return this.b.j(paramString);
  }
  
  public boolean a(String paramString1, int paramInt1, String paramString2, MapBound paramMapBound, int paramInt2, Point paramPoint)
  {
    if (paramString1 == null) {}
    do
    {
      do
      {
        return false;
      } while ((paramInt1 != 0) && (paramInt1 != 2));
      paramMapBound = paramString1.trim();
    } while ((paramMapBound.length() == 0) || (paramMapBound.length() > 99));
    paramMapBound = c();
    paramMapBound.putString("keyword", paramString1);
    paramMapBound.putInt("type", paramInt1);
    paramMapBound.putString("cityid", paramString2);
    paramString1 = new Bundle();
    paramString1.putInt("level", paramInt2);
    paramMapBound.putBundle("mapbound", paramString1);
    if (paramPoint != null)
    {
      paramMapBound.putInt("loc_x", paramPoint.x);
      paramMapBound.putInt("loc_y", paramPoint.y);
    }
    return this.b.h(paramMapBound);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (paramString2 == null) {}
    do
    {
      do
      {
        return false;
      } while ((paramString1 == null) || (paramString1.equals("")));
      paramString2 = paramString2.trim();
    } while ((paramString2.length() == 0) || (paramString2.length() > 99));
    return this.b.a(paramString1, paramString2);
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("bid", paramString1);
    localBundle.putString("wd", paramString2);
    localBundle.putInt("currentPage", paramInt1);
    localBundle.putInt("pageSize", paramInt2);
    if ((paramString3 != null) && (paramString3.length() > 0)) {
      localBundle.putString("floor", paramString3);
    }
    return this.b.c(localBundle);
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt1, MapBound paramMapBound, int paramInt2, Map<String, Object> paramMap)
  {
    if (paramString1 == null) {}
    String str;
    do
    {
      return false;
      str = paramString1.trim();
    } while ((str.length() == 0) || (str.length() > 99));
    paramString1 = c();
    paramString1.putString("keyword", str);
    paramString1.putInt("pagenum", paramInt1);
    paramString1.putInt("count", this.f);
    paramString1.putString("cityid", paramString2);
    paramString1.putInt("level", paramInt2);
    if (paramMapBound != null)
    {
      paramString1.putInt("ll_x", paramMapBound.ptLB.getmPtx());
      paramString1.putInt("ll_y", paramMapBound.ptLB.getmPty());
      paramString1.putInt("ru_x", paramMapBound.ptRT.getmPtx());
      paramString1.putInt("ru_y", paramMapBound.ptRT.getmPty());
    }
    if (paramMap != null)
    {
      paramString2 = new Bundle();
      paramMapBound = paramMap.keySet().iterator();
      while (paramMapBound.hasNext())
      {
        str = (String)paramMapBound.next();
        Object localObject = paramMap.get(str);
        paramString2.putString(str.toString(), localObject.toString());
      }
      paramString1.putBundle("extparams", paramString2);
    }
    return this.b.a(paramString1);
  }
  
  public int b()
  {
    return this.f;
  }
  
  String b(int paramInt)
  {
    String str2 = this.b.a(paramInt);
    String str1 = str2;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.trim().length() <= 0) {
        str1 = null;
      }
    }
    return str1;
  }
  
  public boolean b(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return this.b.b(paramString);
  }
  
  public boolean b(String paramString1, String paramString2)
  {
    return this.b.b(paramString1, paramString2);
  }
  
  public boolean c(String paramString1, String paramString2)
  {
    if (this.b == null) {}
    while (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    return this.b.c(paramString1, paramString2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/platform/comapi/search/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */