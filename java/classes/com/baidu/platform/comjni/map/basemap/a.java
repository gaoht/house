package com.baidu.platform.comjni.map.basemap;

import android.os.Bundle;
import android.util.Log;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.VersionInfo;
import com.baidu.mapapi.common.BaiduMapSDKException;
import com.baidu.mapapi.map.MapBaseIndoorMapInfo;
import com.baidu.platform.comapi.NativeLoader;
import com.baidu.platform.comapi.map.M;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private static final String a = a.class.getSimpleName();
  private static List<JNIBaseMap> d = new ArrayList();
  private long b = 0L;
  private JNIBaseMap c = null;
  
  static
  {
    if (!VersionInfo.getApiVersion().equals(M.a())) {
      throw new BaiduMapSDKException("the version of map is not match with base");
    }
    a(BMapManager.getContext());
    NativeLoader.getInstance().loadLibrary(M.b());
  }
  
  public static int a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    return JNIBaseMap.MapProc(paramLong, paramInt1, paramInt2, paramInt3);
  }
  
  /* Error */
  private static void a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: ifnonnull +4 -> 7
    //   6: return
    //   7: new 90	java/io/File
    //   10: dup
    //   11: invokestatic 95	com/baidu/mapapi/common/SysOSUtil:getModuleFileName	()Ljava/lang/String;
    //   14: invokespecial 96	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 4
    //   19: aload 4
    //   21: invokevirtual 100	java/io/File:exists	()Z
    //   24: ifne +9 -> 33
    //   27: aload 4
    //   29: invokevirtual 103	java/io/File:mkdirs	()Z
    //   32: pop
    //   33: aload_0
    //   34: invokevirtual 109	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   37: pop
    //   38: bipush 16
    //   40: anewarray 41	java/lang/String
    //   43: astore 4
    //   45: aload 4
    //   47: iconst_0
    //   48: ldc 111
    //   50: aastore
    //   51: aload 4
    //   53: iconst_1
    //   54: ldc 113
    //   56: aastore
    //   57: aload 4
    //   59: iconst_2
    //   60: ldc 115
    //   62: aastore
    //   63: aload 4
    //   65: iconst_3
    //   66: ldc 117
    //   68: aastore
    //   69: aload 4
    //   71: iconst_4
    //   72: ldc 119
    //   74: aastore
    //   75: aload 4
    //   77: iconst_5
    //   78: ldc 121
    //   80: aastore
    //   81: aload 4
    //   83: bipush 6
    //   85: ldc 123
    //   87: aastore
    //   88: aload 4
    //   90: bipush 7
    //   92: ldc 125
    //   94: aastore
    //   95: aload 4
    //   97: bipush 8
    //   99: ldc 127
    //   101: aastore
    //   102: aload 4
    //   104: bipush 9
    //   106: ldc -127
    //   108: aastore
    //   109: aload 4
    //   111: bipush 10
    //   113: ldc -125
    //   115: aastore
    //   116: aload 4
    //   118: bipush 11
    //   120: ldc -123
    //   122: aastore
    //   123: aload 4
    //   125: bipush 12
    //   127: ldc -121
    //   129: aastore
    //   130: aload 4
    //   132: bipush 13
    //   134: ldc -119
    //   136: aastore
    //   137: aload 4
    //   139: bipush 14
    //   141: ldc -117
    //   143: aastore
    //   144: aload 4
    //   146: bipush 15
    //   148: ldc -115
    //   150: aastore
    //   151: iconst_1
    //   152: anewarray 41	java/lang/String
    //   155: astore 5
    //   157: aload 5
    //   159: iconst_0
    //   160: ldc -115
    //   162: aastore
    //   163: new 90	java/io/File
    //   166: dup
    //   167: new 143	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   174: invokestatic 95	com/baidu/mapapi/common/SysOSUtil:getModuleFileName	()Ljava/lang/String;
    //   177: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: ldc -106
    //   182: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokespecial 96	java/io/File:<init>	(Ljava/lang/String;)V
    //   191: astore 7
    //   193: bipush 6
    //   195: newarray <illegal type>
    //   197: astore 6
    //   199: aload 6
    //   201: dup
    //   202: iconst_0
    //   203: ldc -102
    //   205: bastore
    //   206: dup
    //   207: iconst_1
    //   208: ldc -101
    //   210: bastore
    //   211: dup
    //   212: iconst_2
    //   213: ldc -101
    //   215: bastore
    //   216: dup
    //   217: iconst_3
    //   218: ldc -101
    //   220: bastore
    //   221: dup
    //   222: iconst_4
    //   223: ldc -101
    //   225: bastore
    //   226: dup
    //   227: iconst_5
    //   228: ldc -101
    //   230: bastore
    //   231: pop
    //   232: aload 7
    //   234: invokevirtual 100	java/io/File:exists	()Z
    //   237: ifeq +491 -> 728
    //   240: new 157	java/io/FileInputStream
    //   243: dup
    //   244: aload 7
    //   246: invokespecial 160	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   249: astore 8
    //   251: aload 8
    //   253: invokevirtual 164	java/io/FileInputStream:available	()I
    //   256: newarray <illegal type>
    //   258: astore 9
    //   260: aload 8
    //   262: aload 9
    //   264: invokevirtual 168	java/io/FileInputStream:read	([B)I
    //   267: pop
    //   268: aload 8
    //   270: invokevirtual 171	java/io/FileInputStream:close	()V
    //   273: aload 9
    //   275: aload 6
    //   277: invokestatic 176	java/util/Arrays:equals	([B[B)Z
    //   280: ifeq +448 -> 728
    //   283: new 90	java/io/File
    //   286: dup
    //   287: new 143	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   294: invokestatic 95	com/baidu/mapapi/common/SysOSUtil:getModuleFileName	()Ljava/lang/String;
    //   297: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: ldc -78
    //   302: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokespecial 96	java/io/File:<init>	(Ljava/lang/String;)V
    //   311: astore 8
    //   313: aload 8
    //   315: invokevirtual 100	java/io/File:exists	()Z
    //   318: ifeq +410 -> 728
    //   321: aload 8
    //   323: invokevirtual 182	java/io/File:length	()J
    //   326: lconst_0
    //   327: lcmp
    //   328: ifle +400 -> 728
    //   331: iconst_0
    //   332: istore_1
    //   333: iload_1
    //   334: ifeq +222 -> 556
    //   337: aload 7
    //   339: invokevirtual 100	java/io/File:exists	()Z
    //   342: ifeq +9 -> 351
    //   345: aload 7
    //   347: invokevirtual 185	java/io/File:delete	()Z
    //   350: pop
    //   351: aload 7
    //   353: invokevirtual 188	java/io/File:createNewFile	()Z
    //   356: pop
    //   357: new 190	java/io/FileOutputStream
    //   360: dup
    //   361: aload 7
    //   363: invokespecial 191	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   366: astore 7
    //   368: aload 7
    //   370: aload 6
    //   372: invokevirtual 195	java/io/FileOutputStream:write	([B)V
    //   375: aload 7
    //   377: invokevirtual 196	java/io/FileOutputStream:close	()V
    //   380: new 90	java/io/File
    //   383: dup
    //   384: new 143	java/lang/StringBuilder
    //   387: dup
    //   388: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   391: invokestatic 95	com/baidu/mapapi/common/SysOSUtil:getModuleFileName	()Ljava/lang/String;
    //   394: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: ldc -58
    //   399: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokespecial 96	java/io/File:<init>	(Ljava/lang/String;)V
    //   408: astore 6
    //   410: aload 6
    //   412: invokevirtual 100	java/io/File:exists	()Z
    //   415: ifne +9 -> 424
    //   418: aload 6
    //   420: invokevirtual 103	java/io/File:mkdirs	()Z
    //   423: pop
    //   424: new 90	java/io/File
    //   427: dup
    //   428: new 143	java/lang/StringBuilder
    //   431: dup
    //   432: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   435: invokestatic 95	com/baidu/mapapi/common/SysOSUtil:getModuleFileName	()Ljava/lang/String;
    //   438: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: ldc -56
    //   443: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   449: invokespecial 96	java/io/File:<init>	(Ljava/lang/String;)V
    //   452: astore 6
    //   454: aload 6
    //   456: invokevirtual 100	java/io/File:exists	()Z
    //   459: ifne +9 -> 468
    //   462: aload 6
    //   464: invokevirtual 103	java/io/File:mkdirs	()Z
    //   467: pop
    //   468: new 90	java/io/File
    //   471: dup
    //   472: new 143	java/lang/StringBuilder
    //   475: dup
    //   476: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   479: invokestatic 95	com/baidu/mapapi/common/SysOSUtil:getModuleFileName	()Ljava/lang/String;
    //   482: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: ldc -54
    //   487: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: invokespecial 96	java/io/File:<init>	(Ljava/lang/String;)V
    //   496: astore 6
    //   498: aload 6
    //   500: invokevirtual 100	java/io/File:exists	()Z
    //   503: ifne +9 -> 512
    //   506: aload 6
    //   508: invokevirtual 103	java/io/File:mkdirs	()Z
    //   511: pop
    //   512: new 90	java/io/File
    //   515: dup
    //   516: new 143	java/lang/StringBuilder
    //   519: dup
    //   520: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   523: invokestatic 95	com/baidu/mapapi/common/SysOSUtil:getModuleFileName	()Ljava/lang/String;
    //   526: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: ldc -52
    //   531: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   537: invokespecial 96	java/io/File:<init>	(Ljava/lang/String;)V
    //   540: astore 6
    //   542: aload 6
    //   544: invokevirtual 100	java/io/File:exists	()Z
    //   547: ifne +9 -> 556
    //   550: aload 6
    //   552: invokevirtual 103	java/io/File:mkdirs	()Z
    //   555: pop
    //   556: iconst_0
    //   557: istore_2
    //   558: iload_2
    //   559: aload 5
    //   561: arraylength
    //   562: if_icmpge +41 -> 603
    //   565: iconst_1
    //   566: anewarray 41	java/lang/String
    //   569: dup
    //   570: iconst_0
    //   571: ldc -115
    //   573: aastore
    //   574: iload_2
    //   575: aaload
    //   576: aload 5
    //   578: iload_2
    //   579: aaload
    //   580: aload_0
    //   581: invokestatic 210	com/baidu/platform/comapi/AssetsLoadUtil:copyFileFromAsset	(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V
    //   584: iload_2
    //   585: iconst_1
    //   586: iadd
    //   587: istore_2
    //   588: goto -30 -> 558
    //   591: astore_0
    //   592: aload_0
    //   593: invokevirtual 213	java/lang/Exception:printStackTrace	()V
    //   596: return
    //   597: astore_0
    //   598: aload_0
    //   599: invokevirtual 213	java/lang/Exception:printStackTrace	()V
    //   602: return
    //   603: iload_1
    //   604: ifeq -598 -> 6
    //   607: iload_3
    //   608: istore_1
    //   609: iload_1
    //   610: aload 4
    //   612: arraylength
    //   613: if_icmpge -607 -> 6
    //   616: bipush 16
    //   618: anewarray 41	java/lang/String
    //   621: dup
    //   622: iconst_0
    //   623: ldc -41
    //   625: aastore
    //   626: dup
    //   627: iconst_1
    //   628: ldc 113
    //   630: aastore
    //   631: dup
    //   632: iconst_2
    //   633: ldc 115
    //   635: aastore
    //   636: dup
    //   637: iconst_3
    //   638: ldc -39
    //   640: aastore
    //   641: dup
    //   642: iconst_4
    //   643: ldc 119
    //   645: aastore
    //   646: dup
    //   647: iconst_5
    //   648: ldc 121
    //   650: aastore
    //   651: dup
    //   652: bipush 6
    //   654: ldc 123
    //   656: aastore
    //   657: dup
    //   658: bipush 7
    //   660: ldc 125
    //   662: aastore
    //   663: dup
    //   664: bipush 8
    //   666: ldc 127
    //   668: aastore
    //   669: dup
    //   670: bipush 9
    //   672: ldc -127
    //   674: aastore
    //   675: dup
    //   676: bipush 10
    //   678: ldc -125
    //   680: aastore
    //   681: dup
    //   682: bipush 11
    //   684: ldc -123
    //   686: aastore
    //   687: dup
    //   688: bipush 12
    //   690: ldc -121
    //   692: aastore
    //   693: dup
    //   694: bipush 13
    //   696: ldc -119
    //   698: aastore
    //   699: dup
    //   700: bipush 14
    //   702: ldc -117
    //   704: aastore
    //   705: dup
    //   706: bipush 15
    //   708: ldc -115
    //   710: aastore
    //   711: iload_1
    //   712: aaload
    //   713: aload 4
    //   715: iload_1
    //   716: aaload
    //   717: aload_0
    //   718: invokestatic 210	com/baidu/platform/comapi/AssetsLoadUtil:copyFileFromAsset	(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V
    //   721: iload_1
    //   722: iconst_1
    //   723: iadd
    //   724: istore_1
    //   725: goto -116 -> 609
    //   728: iconst_1
    //   729: istore_1
    //   730: goto -397 -> 333
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	733	0	paramContext	android.content.Context
    //   332	398	1	i	int
    //   557	31	2	j	int
    //   1	607	3	k	int
    //   17	697	4	localObject1	Object
    //   155	422	5	arrayOfString	String[]
    //   197	354	6	localObject2	Object
    //   191	185	7	localObject3	Object
    //   249	73	8	localObject4	Object
    //   258	16	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   7	33	591	java/lang/Exception
    //   163	331	597	java/lang/Exception
    //   337	351	597	java/lang/Exception
    //   351	424	597	java/lang/Exception
    //   424	468	597	java/lang/Exception
    //   468	512	597	java/lang/Exception
    //   512	556	597	java/lang/Exception
  }
  
  public static void b(long paramLong, boolean paramBoolean)
  {
    JNIBaseMap.SetMapCustomEnable(paramLong, paramBoolean);
  }
  
  public static List<JNIBaseMap> d()
  {
    return d;
  }
  
  public int a(int paramInt)
  {
    return this.c.SetMapControlMode(this.b, paramInt);
  }
  
  public long a(int paramInt1, int paramInt2, String paramString)
  {
    return this.c.AddLayer(this.b, paramInt1, paramInt2, paramString);
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    return this.c.ScrPtToGeoPoint(this.b, paramInt1, paramInt2);
  }
  
  public String a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return this.c.GetNearlyObjID(this.b, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public String a(String paramString)
  {
    return this.c.OnSchcityGet(this.b, paramString);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    this.c.ShowLayers(this.b, paramLong, paramBoolean);
  }
  
  public void a(Bundle paramBundle)
  {
    this.c.SetMapStatus(this.b, paramBundle);
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    this.c.SaveScreenToLocal(this.b, paramString, paramBundle);
  }
  
  public void a(boolean paramBoolean)
  {
    this.c.ShowSatelliteMap(this.b, paramBoolean);
  }
  
  public void a(Bundle[] paramArrayOfBundle)
  {
    this.c.addOverlayItems(this.b, paramArrayOfBundle, paramArrayOfBundle.length);
  }
  
  public boolean a()
  {
    if (d.size() == 0) {}
    for (this.b = this.c.Create();; this.b = this.c.CreateDuplicate(((JNIBaseMap)d.get(0)).a))
    {
      this.c.a = this.b;
      d.add(this.c);
      this.c.SetCallback(this.b, null);
      return true;
    }
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    return this.c.OnRecordReload(this.b, paramInt, paramBoolean);
  }
  
  public boolean a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return this.c.OnRecordStart(this.b, paramInt1, paramBoolean, paramInt2);
  }
  
  public boolean a(long paramLong)
  {
    return this.c.LayersIsShow(this.b, paramLong);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    return this.c.SwitchBaseIndoorMapFloor(this.b, paramString1, paramString2);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    return this.c.Init(this.b, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    return this.c.OnRecordImport(this.b, paramBoolean1, paramBoolean2);
  }
  
  public int[] a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    return this.c.GetScreenBuf(this.b, paramArrayOfInt, paramInt1, paramInt2);
  }
  
  public String b(int paramInt1, int paramInt2)
  {
    return this.c.GeoPtToScrPoint(this.b, paramInt1, paramInt2);
  }
  
  public void b(long paramLong)
  {
    this.c.UpdateLayers(this.b, paramLong);
  }
  
  public void b(Bundle paramBundle)
  {
    this.c.setMapStatusLimits(this.b, paramBundle);
  }
  
  public void b(boolean paramBoolean)
  {
    this.c.ShowHotMap(this.b, paramBoolean);
  }
  
  public boolean b()
  {
    this.c.Release(this.b);
    d.remove(this.c);
    return true;
  }
  
  public boolean b(int paramInt)
  {
    return this.c.OnRecordAdd(this.b, paramInt);
  }
  
  public boolean b(int paramInt, boolean paramBoolean)
  {
    return this.c.OnRecordRemove(this.b, paramInt, paramBoolean);
  }
  
  public boolean b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return this.c.OnRecordSuspend(this.b, paramInt1, paramBoolean, paramInt2);
  }
  
  public float c(Bundle paramBundle)
  {
    return this.c.GetZoomToBound(this.b, paramBundle);
  }
  
  public long c()
  {
    return this.b;
  }
  
  public String c(int paramInt)
  {
    return this.c.OnRecordGetAt(this.b, paramInt);
  }
  
  public void c(boolean paramBoolean)
  {
    this.c.ShowTrafficMap(this.b, paramBoolean);
  }
  
  public boolean c(long paramLong)
  {
    return this.c.cleanSDKTileDataCache(this.b, paramLong);
  }
  
  public void d(long paramLong)
  {
    this.c.ClearLayer(this.b, paramLong);
  }
  
  public void d(boolean paramBoolean)
  {
    this.c.enableDrawHouseHeight(this.b, paramBoolean);
  }
  
  public boolean d(Bundle paramBundle)
  {
    return this.c.updateSDKTile(this.b, paramBundle);
  }
  
  public String e(long paramLong)
  {
    return this.c.getCompassPosition(this.b, paramLong);
  }
  
  public void e()
  {
    this.c.OnPause(this.b);
  }
  
  public void e(boolean paramBoolean)
  {
    this.c.ShowBaseIndoorMap(this.b, paramBoolean);
  }
  
  public boolean e(Bundle paramBundle)
  {
    return this.c.addtileOverlay(this.b, paramBundle);
  }
  
  public void f()
  {
    this.c.OnResume(this.b);
  }
  
  public void f(Bundle paramBundle)
  {
    this.c.addOneOverlayItem(this.b, paramBundle);
  }
  
  public void g()
  {
    this.c.OnBackground(this.b);
  }
  
  public void g(Bundle paramBundle)
  {
    this.c.updateOneOverlayItem(this.b, paramBundle);
  }
  
  public void h()
  {
    this.c.OnForeground(this.b);
  }
  
  public void h(Bundle paramBundle)
  {
    this.c.removeOneOverlayItem(this.b, paramBundle);
  }
  
  public void i()
  {
    this.c.ResetImageRes(this.b);
  }
  
  public Bundle j()
  {
    return this.c.GetMapStatus(this.b);
  }
  
  public Bundle k()
  {
    Bundle localBundle = this.c.getMapStatusLimits(this.b);
    Log.d("test", "GetMapStatusLimits, maddr: " + this.b + "bundle: " + localBundle);
    return localBundle;
  }
  
  public Bundle l()
  {
    return this.c.getDrawingMapStatus(this.b);
  }
  
  public boolean m()
  {
    return this.c.GetBaiduHotMapCityInfo(this.b);
  }
  
  public String n()
  {
    return this.c.OnRecordGetAll(this.b);
  }
  
  public String o()
  {
    return this.c.OnHotcityGet(this.b);
  }
  
  public void p()
  {
    this.c.PostStatInfo(this.b);
  }
  
  public boolean q()
  {
    return this.c.isDrawHouseHeightEnable(this.b);
  }
  
  public void r()
  {
    this.c.clearHeatMapLayerCache(this.b);
  }
  
  public MapBaseIndoorMapInfo s()
  {
    Object localObject4 = this.c.getfocusedBaseIndoorMapInfo(this.b);
    if (localObject4 == null) {
      return null;
    }
    localObject1 = "";
    localObject3 = new String();
    localArrayList = new ArrayList(1);
    localObject2 = localObject1;
    for (;;)
    {
      try
      {
        localObject6 = new JSONObject((String)localObject4);
        localObject2 = localObject1;
        localObject1 = ((JSONObject)localObject6).optString("focusindoorid");
        localObject2 = localObject1;
        localObject4 = ((JSONObject)localObject6).optString("curfloor");
        localObject2 = localObject4;
      }
      catch (JSONException localJSONException1)
      {
        Object localObject6;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localJSONException1.printStackTrace();
        localObject3 = localObject1;
        Object localObject5 = localObject2;
        return new MapBaseIndoorMapInfo((String)localObject3, (String)localObject5, localArrayList);
      }
      try
      {
        localObject6 = ((JSONObject)localObject6).optJSONArray("floorlist");
        if (localObject6 != null) {
          break label173;
        }
        return null;
      }
      catch (JSONException localJSONException2)
      {
        continue;
        i = 0;
        continue;
      }
      localObject4 = localObject2;
      localObject3 = localObject1;
      if (i >= ((JSONArray)localObject6).length()) {
        continue;
      }
      localArrayList.add(((JSONArray)localObject6).get(i).toString());
      i += 1;
    }
  }
  
  public boolean t()
  {
    return this.c.IsBaseIndoorMapMode(this.b);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/platform/comjni/map/basemap/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */