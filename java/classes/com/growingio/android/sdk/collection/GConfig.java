package com.growingio.android.sdk.collection;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import com.growingio.android.sdk.circle.c;
import com.growingio.android.sdk.models.h;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.PermissionUtil;
import com.growingio.android.sdk.utils.ProcessLock;
import com.growingio.android.sdk.utils.Util;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GConfig
{
  public static final String AGENT_VERSION = "1.1.2";
  public static boolean CIRCLE_USE_ID = USE_ID;
  public static boolean DEBUG = false;
  public static final String GROWING_VERSION = "1.1.2_dcb91e54";
  public static boolean USE_ID;
  private static GConfig b;
  private static final Object c = new Object();
  public static String sAppVersion;
  public static boolean sCanHook = true;
  public static String sGrowingScheme;
  private boolean A = false;
  private SimpleDateFormat a = new SimpleDateFormat("yyyy_MM_dd", Locale.US);
  private Context d;
  private int e;
  private long f;
  private boolean g;
  private boolean h;
  private long i;
  private String j;
  private boolean k;
  private boolean l = DEBUG;
  private boolean m = false;
  private boolean n;
  private long o;
  private int p;
  private boolean q = true;
  private double r = -1.0D;
  private boolean s = true;
  private boolean t = false;
  private boolean u = false;
  private final boolean v;
  private boolean w = false;
  private boolean x = false;
  private HashMap<String, ArrayList<h>> y;
  private ProcessLock z;
  
  static
  {
    DEBUG = false;
    USE_ID = false;
  }
  
  private GConfig(Configuration paramConfiguration)
  {
    this.d = paramConfiguration.a.getApplicationContext();
    this.f = paramConfiguration.v;
    this.e = paramConfiguration.t;
    this.i = paramConfiguration.u;
    boolean bool1;
    label155:
    double d1;
    if (!paramConfiguration.i)
    {
      bool1 = true;
      this.q = bool1;
      this.u = paramConfiguration.s;
      this.o = paramConfiguration.w;
      if (paramConfiguration.j) {
        break label324;
      }
      bool1 = bool2;
      this.s = bool1;
      this.g = paramConfiguration.o;
      this.t = paramConfiguration.k;
      this.l = paramConfiguration.p;
      this.j = paramConfiguration.e;
      this.n = paramConfiguration.r;
      this.v = paramConfiguration.l;
      this.w = paramConfiguration.m;
      USE_ID = paramConfiguration.q;
      CIRCLE_USE_ID = USE_ID;
      sGrowingScheme = paramConfiguration.c;
      this.A = paramConfiguration.y;
      if (Build.VERSION.SDK_INT < 14) {
        sCanHook = false;
      }
      if (this.l)
      {
        paramConfiguration = paramConfiguration.d;
        if (!DEBUG) {
          break label330;
        }
        d1 = 1.0D;
        label277:
        if (!Util.a(paramConfiguration, d1)) {
          break label337;
        }
        DiagnoseLog.a(this.d);
      }
    }
    for (;;)
    {
      F();
      K();
      this.z = new ProcessLock(this.d, "growingio.lock");
      return;
      bool1 = false;
      break;
      label324:
      bool1 = false;
      break label155;
      label330:
      d1 = 0.01D;
      break label277;
      label337:
      this.l = false;
    }
  }
  
  @TargetApi(15)
  private void F()
  {
    Bundle localBundle = Util.a(this.d);
    this.h = localBundle.getBoolean("com.growingio.android.GConfig.LocalMode", false);
    this.k = localBundle.getBoolean("com.growingio.android.GConfig.EnableCellularTransmission", true);
    if (TextUtils.isEmpty(this.j))
    {
      this.j = a(localBundle, "com.growingio.android.GConfig.Channel");
      if (TextUtils.isEmpty(this.j)) {
        this.j = a(localBundle);
      }
      if (this.j.length() > 32) {
        this.j = this.j.substring(0, 32);
      }
    }
    try
    {
      sAppVersion = this.d.getPackageManager().getPackageInfo(this.d.getPackageName(), 0).versionName;
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
  }
  
  private SharedPreferences G()
  {
    return this.d.getSharedPreferences("growing_profile", 0);
  }
  
  private SharedPreferences H()
  {
    return this.d.getSharedPreferences("growing_server_pref", 0);
  }
  
  private boolean I()
  {
    SharedPreferences localSharedPreferences = G();
    String str = this.a.format(new Date(System.currentTimeMillis()));
    if (!TextUtils.equals(str, localSharedPreferences.getString("pref_date", "")))
    {
      localSharedPreferences.edit().putString("pref_date", str).commit();
      return true;
    }
    return false;
  }
  
  private void J()
  {
    if (I())
    {
      this.p = 0;
      G().edit().putInt("pref_cellular_data_size", 0).commit();
      return;
    }
    this.p = G().getInt("pref_cellular_data_size", 0);
  }
  
  private void K()
  {
    boolean bool = true;
    SharedPreferences localSharedPreferences = G();
    if (localSharedPreferences.contains("pref_enable_throttle")) {
      this.t |= localSharedPreferences.getBoolean("pref_enable_throttle", false);
    }
    if (localSharedPreferences.contains("pref_enable_imp")) {
      this.s &= localSharedPreferences.getBoolean("pref_enable_imp", true);
    }
    this.s |= this.t;
    if (localSharedPreferences.contains("pref_disable_cellular_impression")) {
      this.u = localSharedPreferences.getBoolean("pref_disable_cellular_impression", false);
    }
    if (localSharedPreferences.contains("pref_disable_all")) {
      if (localSharedPreferences.getBoolean("pref_disable_all", false)) {
        break label235;
      }
    }
    for (;;)
    {
      this.q = bool;
      if (localSharedPreferences.contains("pref_sampling_rate")) {
        this.r = localSharedPreferences.getFloat("pref_sampling_rate", 1.0F);
      }
      if (localSharedPreferences.contains("pref_server_settings"))
      {
        H().edit().putString("pref_server_settings", localSharedPreferences.getString("pref_server_settings", null)).commit();
        localSharedPreferences.edit().remove("pref_server_settings").commit();
      }
      J();
      return;
      label235:
      bool = false;
    }
  }
  
  private boolean L()
  {
    if (PermissionUtil.c()) {
      return M().exists();
    }
    return false;
  }
  
  private File M()
  {
    LogUtil.d("T_SEND", new Object[] { "file:" + Environment.getExternalStorageDirectory() + File.separator + ".growingio" + File.separator + this.d.getPackageName() + ".activated" });
    return new File(Environment.getExternalStorageDirectory() + File.separator + ".growingio" + File.separator + this.d.getPackageName() + ".activated");
  }
  
  @TargetApi(12)
  private String a(Bundle paramBundle)
  {
    Object localObject = a(paramBundle, "UMENG_CHANNEL");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    do
    {
      String str;
      do
      {
        return (String)localObject;
        str = a(paramBundle, "BaiduMobAd_CHANNEL");
        localObject = str;
      } while (!TextUtils.isEmpty(str));
      paramBundle = a(paramBundle, "TD_CHANNEL_ID");
      localObject = paramBundle;
    } while (!TextUtils.isEmpty(paramBundle));
    return "UNKNOWN";
  }
  
  private String a(Bundle paramBundle, String paramString)
  {
    paramBundle = paramBundle.get(paramString);
    if (paramBundle != null) {
      return String.valueOf(paramBundle);
    }
    return null;
  }
  
  public static void a(Configuration paramConfiguration)
  {
    synchronized (c)
    {
      if (b == null) {
        b = new GConfig(paramConfiguration);
      }
      return;
    }
  }
  
  private void a(JSONArray paramJSONArray)
  {
    this.y = new HashMap();
    int i1 = 0;
    while (i1 < paramJSONArray.length())
    {
      Object localObject1 = paramJSONArray.getJSONObject(i1);
      Object localObject2 = ((JSONObject)localObject1).optString("x");
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        i1 += 1;
      }
      else
      {
        int i2 = ((JSONObject)localObject1).optInt("idx", -1);
        h localh = new h();
        String str = ((JSONObject)localObject1).optString("p", null);
        localh.d = ((JSONObject)localObject1).optString("d");
        localh.i = localh.d.contains("::");
        localh.a = ((String)localObject2);
        localh.c = ((JSONObject)localObject1).optString("v", null);
        if (i2 != -1) {}
        for (localObject1 = String.valueOf(i2);; localObject1 = null)
        {
          localh.e = ((String)localObject1);
          localObject2 = (ArrayList)this.y.get(str);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new ArrayList(1);
            this.y.put(str, localObject1);
          }
          ((ArrayList)localObject1).add(localh);
          break;
        }
      }
    }
  }
  
  private Pair<Integer, Integer> b(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = this.d.getSharedPreferences("growing_ecsid", 0);
    int i1 = localSharedPreferences.getInt(paramString, 0);
    int i2 = localSharedPreferences.getInt("all", 0);
    localSharedPreferences.edit().putInt(paramString, i1 + paramInt).putInt("all", i2 + paramInt).commit();
    return new Pair(Integer.valueOf(i2), Integer.valueOf(i1));
  }
  
  /* Error */
  private Pair<Integer, Integer> c(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 8
    //   6: aload_0
    //   7: getfield 203	com/growingio/android/sdk/collection/GConfig:z	Lcom/growingio/android/sdk/utils/ProcessLock;
    //   10: sipush 1000
    //   13: invokevirtual 533	com/growingio/android/sdk/utils/ProcessLock:a	(I)Z
    //   16: pop
    //   17: new 535	java/io/ObjectInputStream
    //   20: dup
    //   21: aload_0
    //   22: getfield 123	com/growingio/android/sdk/collection/GConfig:d	Landroid/content/Context;
    //   25: ldc_w 510
    //   28: invokevirtual 539	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   31: invokespecial 542	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   34: astore 7
    //   36: aload 7
    //   38: invokevirtual 546	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   41: checkcast 548	com/growingio/android/sdk/models/EventSID
    //   44: astore 6
    //   46: aload 6
    //   48: astore 5
    //   50: aload 6
    //   52: ifnonnull +12 -> 64
    //   55: new 548	com/growingio/android/sdk/models/EventSID
    //   58: dup
    //   59: invokespecial 549	com/growingio/android/sdk/models/EventSID:<init>	()V
    //   62: astore 5
    //   64: aload 5
    //   66: astore 6
    //   68: aload 7
    //   70: ifnull +12 -> 82
    //   73: aload 7
    //   75: invokevirtual 552	java/io/ObjectInputStream:close	()V
    //   78: aload 5
    //   80: astore 6
    //   82: aload 6
    //   84: aload_1
    //   85: invokevirtual 556	com/growingio/android/sdk/models/EventSID:getSid	(Ljava/lang/String;)I
    //   88: istore_3
    //   89: aload 6
    //   91: ldc_w 512
    //   94: invokevirtual 556	com/growingio/android/sdk/models/EventSID:getSid	(Ljava/lang/String;)I
    //   97: istore 4
    //   99: aload 6
    //   101: aload_1
    //   102: iload_3
    //   103: iload_2
    //   104: iadd
    //   105: invokevirtual 560	com/growingio/android/sdk/models/EventSID:setSid	(Ljava/lang/String;I)Lcom/growingio/android/sdk/models/EventSID;
    //   108: ldc_w 512
    //   111: iload 4
    //   113: iload_2
    //   114: iadd
    //   115: invokevirtual 560	com/growingio/android/sdk/models/EventSID:setSid	(Ljava/lang/String;I)Lcom/growingio/android/sdk/models/EventSID;
    //   118: pop
    //   119: aload 9
    //   121: astore_1
    //   122: new 562	java/io/ObjectOutputStream
    //   125: dup
    //   126: aload_0
    //   127: getfield 123	com/growingio/android/sdk/collection/GConfig:d	Landroid/content/Context;
    //   130: ldc_w 510
    //   133: iconst_0
    //   134: invokevirtual 566	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   137: invokespecial 569	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   140: astore 5
    //   142: aload 5
    //   144: aload 6
    //   146: invokevirtual 573	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   149: aload 5
    //   151: ifnull +8 -> 159
    //   154: aload 5
    //   156: invokevirtual 574	java/io/ObjectOutputStream:close	()V
    //   159: aload_0
    //   160: getfield 203	com/growingio/android/sdk/collection/GConfig:z	Lcom/growingio/android/sdk/utils/ProcessLock;
    //   163: invokevirtual 576	com/growingio/android/sdk/utils/ProcessLock:a	()V
    //   166: new 514	android/util/Pair
    //   169: dup
    //   170: iload 4
    //   172: invokestatic 519	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   175: iload_3
    //   176: invokestatic 519	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   179: invokespecial 522	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   182: areturn
    //   183: astore 5
    //   185: aload 5
    //   187: invokevirtual 579	java/lang/ClassNotFoundException:printStackTrace	()V
    //   190: aconst_null
    //   191: astore 6
    //   193: goto -147 -> 46
    //   196: astore 6
    //   198: aload 6
    //   200: invokevirtual 580	java/io/IOException:printStackTrace	()V
    //   203: aload 5
    //   205: astore 6
    //   207: goto -125 -> 82
    //   210: astore 5
    //   212: aconst_null
    //   213: astore 7
    //   215: iconst_0
    //   216: ifne +176 -> 392
    //   219: new 548	com/growingio/android/sdk/models/EventSID
    //   222: dup
    //   223: invokespecial 549	com/growingio/android/sdk/models/EventSID:<init>	()V
    //   226: astore 5
    //   228: aload 5
    //   230: astore 6
    //   232: aload 7
    //   234: ifnull -152 -> 82
    //   237: aload 7
    //   239: invokevirtual 552	java/io/ObjectInputStream:close	()V
    //   242: aload 5
    //   244: astore 6
    //   246: goto -164 -> 82
    //   249: astore 6
    //   251: aload 6
    //   253: invokevirtual 580	java/io/IOException:printStackTrace	()V
    //   256: aload 5
    //   258: astore 6
    //   260: goto -178 -> 82
    //   263: astore_1
    //   264: aconst_null
    //   265: astore 7
    //   267: iconst_0
    //   268: ifne +11 -> 279
    //   271: new 548	com/growingio/android/sdk/models/EventSID
    //   274: dup
    //   275: invokespecial 549	com/growingio/android/sdk/models/EventSID:<init>	()V
    //   278: pop
    //   279: aload 7
    //   281: ifnull +8 -> 289
    //   284: aload 7
    //   286: invokevirtual 552	java/io/ObjectInputStream:close	()V
    //   289: aload_1
    //   290: athrow
    //   291: astore 5
    //   293: aload 5
    //   295: invokevirtual 580	java/io/IOException:printStackTrace	()V
    //   298: goto -9 -> 289
    //   301: astore_1
    //   302: aload_1
    //   303: invokevirtual 580	java/io/IOException:printStackTrace	()V
    //   306: goto -147 -> 159
    //   309: astore 6
    //   311: aload 8
    //   313: astore 5
    //   315: aload 5
    //   317: astore_1
    //   318: aload 6
    //   320: invokevirtual 580	java/io/IOException:printStackTrace	()V
    //   323: aload 5
    //   325: ifnull -166 -> 159
    //   328: aload 5
    //   330: invokevirtual 574	java/io/ObjectOutputStream:close	()V
    //   333: goto -174 -> 159
    //   336: astore_1
    //   337: aload_1
    //   338: invokevirtual 580	java/io/IOException:printStackTrace	()V
    //   341: goto -182 -> 159
    //   344: astore 6
    //   346: aload_1
    //   347: astore 5
    //   349: aload 6
    //   351: astore_1
    //   352: aload 5
    //   354: ifnull +8 -> 362
    //   357: aload 5
    //   359: invokevirtual 574	java/io/ObjectOutputStream:close	()V
    //   362: aload_1
    //   363: athrow
    //   364: astore 5
    //   366: aload 5
    //   368: invokevirtual 580	java/io/IOException:printStackTrace	()V
    //   371: goto -9 -> 362
    //   374: astore_1
    //   375: goto -23 -> 352
    //   378: astore 6
    //   380: goto -65 -> 315
    //   383: astore_1
    //   384: goto -117 -> 267
    //   387: astore 5
    //   389: goto -174 -> 215
    //   392: aconst_null
    //   393: astore 5
    //   395: goto -167 -> 228
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	398	0	this	GConfig
    //   0	398	1	paramString	String
    //   0	398	2	paramInt	int
    //   88	88	3	i1	int
    //   97	74	4	i2	int
    //   48	107	5	localObject1	Object
    //   183	21	5	localClassNotFoundException	ClassNotFoundException
    //   210	1	5	localException1	Exception
    //   226	31	5	localEventSID	com.growingio.android.sdk.models.EventSID
    //   291	3	5	localIOException1	java.io.IOException
    //   313	45	5	localObject2	Object
    //   364	3	5	localIOException2	java.io.IOException
    //   387	1	5	localException2	Exception
    //   393	1	5	localObject3	Object
    //   44	148	6	localObject4	Object
    //   196	3	6	localIOException3	java.io.IOException
    //   205	40	6	localObject5	Object
    //   249	3	6	localIOException4	java.io.IOException
    //   258	1	6	localObject6	Object
    //   309	10	6	localIOException5	java.io.IOException
    //   344	6	6	localObject7	Object
    //   378	1	6	localIOException6	java.io.IOException
    //   34	251	7	localObjectInputStream	java.io.ObjectInputStream
    //   4	308	8	localObject8	Object
    //   1	119	9	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   36	46	183	java/lang/ClassNotFoundException
    //   73	78	196	java/io/IOException
    //   17	36	210	java/lang/Exception
    //   237	242	249	java/io/IOException
    //   17	36	263	finally
    //   284	289	291	java/io/IOException
    //   154	159	301	java/io/IOException
    //   122	142	309	java/io/IOException
    //   328	333	336	java/io/IOException
    //   122	142	344	finally
    //   318	323	344	finally
    //   357	362	364	java/io/IOException
    //   142	149	374	finally
    //   142	149	378	java/io/IOException
    //   36	46	383	finally
    //   185	190	383	finally
    //   36	46	387	java/lang/Exception
    //   185	190	387	java/lang/Exception
  }
  
  private void d(String paramString)
  {
    boolean bool2 = true;
    if (paramString == null) {
      return;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        SharedPreferences.Editor localEditor = G().edit();
        if (paramString.has("disabled"))
        {
          if (!paramString.getBoolean("disabled"))
          {
            bool1 = true;
            this.q = bool1;
            if (this.q) {
              break label270;
            }
            bool1 = true;
            localEditor.putBoolean("pref_disable_all", bool1);
          }
        }
        else
        {
          if (paramString.has("sampling"))
          {
            this.r = paramString.getDouble("sampling");
            localEditor.putFloat("pref_sampling_rate", (float)this.r);
          }
          if (paramString.has("throttle"))
          {
            this.t = paramString.getBoolean("throttle");
            localEditor.putBoolean("pref_enable_throttle", this.t);
          }
          if (paramString.has("imp"))
          {
            this.s = paramString.getBoolean("imp");
            localEditor.putBoolean("pref_enable_imp", this.s);
          }
          this.s |= this.t;
          if (paramString.has("net"))
          {
            if (paramString.getBoolean("net")) {
              break label275;
            }
            bool1 = bool2;
            this.u = bool1;
            localEditor.putBoolean("pref_disable_cellular_impression", this.u);
          }
          localEditor.commit();
          a(paramString.getJSONArray("tags"));
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      boolean bool1 = false;
      continue;
      label270:
      bool1 = false;
      continue;
      label275:
      bool1 = false;
    }
  }
  
  public static String getProjectId()
  {
    return null;
  }
  
  public static String getUrlScheme()
  {
    return null;
  }
  
  public static boolean isInstrumented()
  {
    return true;
  }
  
  public static GConfig s()
  {
    return b;
  }
  
  public void A()
  {
    if (G().contains("pref_disable_all")) {
      return;
    }
    this.q = false;
  }
  
  public void B()
  {
    this.q = true;
  }
  
  public boolean C()
  {
    return this.t;
  }
  
  public boolean D()
  {
    boolean bool = false;
    LogUtil.d("T_SEND", new Object[] { "pref_device_activated:" + G().getBoolean("pref_device_activated", false) });
    LogUtil.d("T_SEND", new Object[] { "haveFlagInSDCard:" + L() });
    if ((G().getBoolean("pref_device_activated", false)) || (L())) {
      bool = true;
    }
    return bool;
  }
  
  public void E()
  {
    G().edit().putBoolean("pref_device_activated", true).commit();
    if (PermissionUtil.c()) {}
    try
    {
      M().mkdirs();
      Util.a(GrowingIO.testHandler, 524289, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public Pair<Integer, Integer> a(String paramString, int paramInt)
  {
    if (s().a()) {
      return c(paramString, paramInt);
    }
    return b(paramString, paramInt);
  }
  
  public void a(int paramInt)
  {
    if (I())
    {
      G().edit().putInt("pref_cellular_data_size", paramInt).commit();
      this.p = paramInt;
      return;
    }
    this.p = (G().getInt("pref_cellular_data_size", 0) + paramInt);
    LogUtil.d("GIO.GConfig", new Object[] { "cellular data usage: ", Integer.valueOf(this.p) });
    G().edit().putInt("pref_cellular_data_size", this.p).commit();
  }
  
  @TargetApi(9)
  public void a(int paramInt1, int paramInt2)
  {
    G().edit().putInt("pref_float_x", paramInt1).putInt("pref_float_y", paramInt2).apply();
  }
  
  @TargetApi(9)
  public void a(long paramLong)
  {
    G().edit().putLong("pref_vds_plugin_last_modified", paramLong).apply();
  }
  
  public void a(String paramString)
  {
    this.j = paramString;
  }
  
  @TargetApi(9)
  public void a(boolean paramBoolean)
  {
    G().edit().putBoolean("pref_show_circle_tip", paramBoolean).apply();
  }
  
  public boolean a()
  {
    return this.A;
  }
  
  public void b(String paramString)
  {
    G().edit().putString("pref_settings_etag", paramString).commit();
  }
  
  public void b(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public boolean b()
  {
    return this.q;
  }
  
  public double c()
  {
    return this.r;
  }
  
  @TargetApi(9)
  public void c(String paramString)
  {
    H().edit().putString("pref_server_settings", paramString).apply();
    d(paramString);
    Util.a(GrowingIO.testHandler, 524288, new Object[] { paramString });
  }
  
  public void c(boolean paramBoolean)
  {
    if (G().contains("pref_enable_throttle")) {
      return;
    }
    this.t = paramBoolean;
  }
  
  public boolean d()
  {
    return this.s;
  }
  
  public boolean e()
  {
    return this.n;
  }
  
  public boolean f()
  {
    return this.w;
  }
  
  public void g()
  {
    if (G().contains("pref_enable_imp")) {
      return;
    }
    this.s = false;
  }
  
  public void h()
  {
    if (G().contains("pref_enable_imp")) {
      return;
    }
    this.s = true;
  }
  
  public boolean i()
  {
    return this.u;
  }
  
  public HashMap<String, ArrayList<h>> j()
  {
    return this.y;
  }
  
  public boolean k()
  {
    return this.l;
  }
  
  boolean l()
  {
    return (this.g) || (c.e().a());
  }
  
  public boolean m()
  {
    return this.h;
  }
  
  int n()
  {
    return this.e;
  }
  
  long o()
  {
    return this.f;
  }
  
  public String p()
  {
    return this.j;
  }
  
  public boolean q()
  {
    return this.v;
  }
  
  long r()
  {
    return this.i;
  }
  
  public boolean t()
  {
    return G().getBoolean("pref_show_circle_tip", true);
  }
  
  public String toString()
  {
    return "DEBUG: " + DEBUG + "\nEnabled: " + this.q + "\nUSE_ID: " + USE_ID + "\nContext: " + this.d + "\nTest Mode: " + this.g + "\nLocal Mode: " + this.h + "\nUpload bulk size: " + this.e + "\nFlush interval: " + this.f + "\nSession interval: " + this.i + "\nChannel: " + this.j + "\nTrack all fragments: " + this.n + "\nEnable WebView: " + this.v + "\nEnable HashTag: " + this.w + "\nCellular data limit: " + this.o + "\nTotal cellular data size: " + this.p + "\nSampling: " + this.r + "\nEnable impression: " + this.s + "\nThrottle: " + this.t + "\nDisable cellular impression: " + this.u + "\nInstant filter initialized: " + this.x;
  }
  
  public boolean u()
  {
    return this.m;
  }
  
  public Point v()
  {
    SharedPreferences localSharedPreferences = G();
    return new Point(localSharedPreferences.getInt("pref_float_x", -1), localSharedPreferences.getInt("pref_float_y", -1));
  }
  
  public String w()
  {
    return G().getString("pref_settings_etag", "");
  }
  
  public boolean x()
  {
    String str;
    if (!this.x)
    {
      this.x = true;
      str = H().getString("pref_server_settings", null);
      if (str == null) {}
    }
    try
    {
      a(new JSONObject(str).getJSONArray("tags"));
      if (this.y != null) {
        return true;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    return false;
  }
  
  public boolean y()
  {
    J();
    return (this.k) && (this.p < this.o);
  }
  
  public long z()
  {
    return G().getLong("pref_vds_plugin_last_modified", 0L);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/growingio/android/sdk/collection/GConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */