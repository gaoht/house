package com.mob.commons;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.mob.MobSDK;
import com.mob.commons.authorize.DeviceAuthorizer;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.network.NetworkHelper.NetworkTimeOut;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class a
{
  private static HashMap<String, Object> a;
  private static long b;
  private static boolean c;
  private static long d = 0L;
  
  public static long A()
  {
    P();
    return ((Long)ResHelper.forceCast(a.get("le"), Long.valueOf(180L))).longValue();
  }
  
  public static long B()
  {
    P();
    return ((Long)ResHelper.forceCast(a.get("legap"), Long.valueOf(86400L))).longValue();
  }
  
  public static long C()
  {
    long l = 0L;
    if (P()) {
      l = ((Long)ResHelper.forceCast(a.get("sd"), Long.valueOf(0L))).longValue();
    }
    return l;
  }
  
  public static boolean D()
  {
    return a(480000L);
  }
  
  public static boolean E()
  {
    return a(480000L);
  }
  
  public static long F()
  {
    P();
    return ((Integer)ResHelper.forceCast(a.get("deup"), Integer.valueOf(2))).intValue() * 1000L;
  }
  
  public static long G()
  {
    P();
    return ((Integer)ResHelper.forceCast(a.get("digap"), Integer.valueOf(2592000))).intValue() * 1000L;
  }
  
  public static long H()
  {
    long l = 0L;
    if (P()) {
      l = ((Long)ResHelper.forceCast(a.get("pe"), Long.valueOf(0L))).longValue();
    }
    return l;
  }
  
  public static long I()
  {
    P();
    return ((Long)ResHelper.forceCast(a.get("pegap"), Long.valueOf(86400L))).longValue();
  }
  
  public static long J()
  {
    long l = 0L;
    if (P()) {
      l = ((Long)ResHelper.forceCast(a.get("ac"), Long.valueOf(0L))).longValue();
    }
    return l;
  }
  
  public static long K()
  {
    P();
    return ((Long)ResHelper.forceCast(a.get("acgap"), Long.valueOf(86400L))).longValue();
  }
  
  private static long O()
  {
    long l3 = SystemClock.elapsedRealtime();
    long l1 = 0L;
    try
    {
      long l2 = Long.valueOf(String.valueOf(a.get("deviceTime"))).longValue();
      l1 = l2;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    return l3 - l1;
  }
  
  private static boolean P()
  {
    for (;;)
    {
      boolean bool;
      try
      {
        long l = SystemClock.elapsedRealtime();
        if ((a == null) || (a.isEmpty()))
        {
          if (Q()) {
            b = l;
          }
          HashMap localHashMap = a;
          if (localHashMap == null)
          {
            bool = false;
            return bool;
          }
        }
        else
        {
          if ((l - b < 60000L) || (!R())) {
            continue;
          }
          b = l;
          continue;
        }
        i = ((Integer)ResHelper.forceCast(a.get("conn"), Integer.valueOf(0))).intValue();
      }
      finally {}
      int i;
      if (1 == i) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  private static boolean Q()
  {
    String str = S();
    if (TextUtils.isEmpty(str))
    {
      T();
      return false;
    }
    b(str);
    if ((a == null) || (a.isEmpty())) {
      T();
    }
    for (;;)
    {
      return true;
      d.d(new Hashon().fromHashMap(a));
    }
  }
  
  private static boolean R()
  {
    int j = 0;
    boolean bool = true;
    String str = d.g();
    if (TextUtils.isEmpty(str)) {
      bool = Q();
    }
    label74:
    label75:
    for (;;)
    {
      return bool;
      b(str);
      int i;
      if ((a == null) || (a.isEmpty()))
      {
        i = 1;
        if (i != 0) {
          break label74;
        }
        i = j;
        if (O() >= 86400000L) {
          i = 1;
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label75;
        }
        U();
        return true;
        i = 0;
        break;
      }
    }
  }
  
  private static String S()
  {
    Object localObject3;
    Object localObject5;
    Object localObject2;
    try
    {
      if (D()) {
        return null;
      }
      localObject3 = DeviceHelper.getInstance(MobSDK.getContext());
      Object localObject1 = new NetworkHelper();
      localObject4 = ((DeviceHelper)localObject3).getPackageName();
      localObject5 = MobSDK.getAppkey();
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(new KVPair("appkey", localObject5));
      ((ArrayList)localObject2).add(new KVPair("plat", String.valueOf(((DeviceHelper)localObject3).getPlatformCode())));
      ((ArrayList)localObject2).add(new KVPair("apppkg", localObject4));
      ((ArrayList)localObject2).add(new KVPair("appver", ((DeviceHelper)localObject3).getAppVersionName()));
      ((ArrayList)localObject2).add(new KVPair("networktype", ((DeviceHelper)localObject3).getDetailNetworkTypeForStatic()));
      localObject3 = DeviceAuthorizer.authorizeForOnce();
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        ((ArrayList)localObject2).add(new KVPair("duid", localObject3));
      }
      localObject3 = new NetworkHelper.NetworkTimeOut();
      ((NetworkHelper.NetworkTimeOut)localObject3).readTimout = 30000;
      ((NetworkHelper.NetworkTimeOut)localObject3).connectionTimeout = 10000;
      localObject6 = new ArrayList();
      ((ArrayList)localObject6).add(new KVPair("User-Identity", MobProductCollector.getUserIdentity()));
      localObject1 = ((NetworkHelper)localObject1).httpGet(V(), (ArrayList)localObject2, (ArrayList)localObject6, (NetworkHelper.NetworkTimeOut)localObject3);
      localObject2 = new Hashon();
      localObject3 = ((Hashon)localObject2).fromJson((String)localObject1);
      if (localObject3 == null) {
        return null;
      }
      if (!"200".equals(String.valueOf(((HashMap)localObject3).get("status"))))
      {
        d.e(null);
        d.f(null);
        throw new Throwable("response is illegal: " + (String)localObject1);
      }
    }
    catch (Throwable localThrowable)
    {
      d.e(null);
      d.f(null);
      MobLog.getInstance().w(localThrowable);
      return null;
    }
    Object localObject6 = (String)ResHelper.forceCast(((HashMap)localObject3).get("sr"));
    Object localObject4 = Data.rawMD5(((String)localObject5 + ":" + (String)localObject4 + ":" + ((HashMap)localObject3).get("timestamp")).getBytes("utf-8"));
    if (localObject6 != null)
    {
      localObject5 = ((Hashon)localObject2).fromJson(new String(Data.AES128Decode((byte[])localObject4, Base64.decode((String)localObject6, 2)), "utf-8"));
      if (localObject5 != null)
      {
        Object localObject7 = (HashMap)ResHelper.forceCast(((HashMap)localObject5).get("cdata"));
        if (localObject7 == null) {
          break label757;
        }
        localObject6 = (String)ResHelper.forceCast(((HashMap)localObject7).get("host"));
        int i = ((Integer)ResHelper.forceCast(((HashMap)localObject7).get("httpport"), Integer.valueOf(0))).intValue();
        localObject7 = (String)ResHelper.forceCast(((HashMap)localObject7).get("path"));
        if ((localObject6 == null) || (i == 0) || (localObject7 == null)) {
          break label750;
        }
        d.e("http://" + (String)localObject6 + ":" + i + (String)localObject7);
        localObject6 = (HashMap)ResHelper.forceCast(((HashMap)localObject5).get("cconf"));
        if (localObject6 == null) {
          break label771;
        }
        localObject5 = (String)ResHelper.forceCast(((HashMap)localObject6).get("host"));
        i = ((Integer)ResHelper.forceCast(((HashMap)localObject6).get("httpport"), Integer.valueOf(0))).intValue();
        localObject6 = (String)ResHelper.forceCast(((HashMap)localObject6).get("path"));
        if ((localObject5 == null) || (i == 0) || (localObject6 == null)) {
          break label764;
        }
        d.f("http://" + (String)localObject5 + ":" + i + (String)localObject6);
      }
    }
    for (;;)
    {
      localObject5 = (String)ResHelper.forceCast(((HashMap)localObject3).get("sc"));
      if (localObject5 != null) {
        break label778;
      }
      throw new Throwable("response is illegal: " + localThrowable);
      label750:
      d.e(null);
      break;
      label757:
      d.e(null);
      break;
      label764:
      d.f(null);
      continue;
      label771:
      d.f(null);
    }
    label778:
    localObject4 = ((Hashon)localObject2).fromJson(new String(Data.AES128Decode((byte[])localObject4, Base64.decode((String)localObject5, 2)), "utf-8"));
    if (localObject4 == null) {
      throw new Throwable("response is illegal: " + localThrowable);
    }
    a(((HashMap)localObject4).get("illegalMacs"));
    long l = ((Long)ResHelper.forceCast(((HashMap)localObject3).get("timestamp"), Long.valueOf(0L))).longValue();
    ((HashMap)localObject4).put("deviceTime", Long.valueOf(SystemClock.elapsedRealtime()));
    ((HashMap)localObject4).put("serverTime", Long.valueOf(l));
    String str = ((Hashon)localObject2).fromHashMap((HashMap)localObject4);
    return str;
  }
  
  private static void T()
  {
    a = new HashMap();
    a.put("conn", Integer.valueOf(0));
    a.put("in", Integer.valueOf(0));
    a.put("all", Integer.valueOf(0));
    a.put("aspa", Long.valueOf(2592000L));
    a.put("un", Integer.valueOf(0));
    a.put("rt", Integer.valueOf(0));
    a.put("rtsr", Integer.valueOf(300000));
    a.put("ext", Integer.valueOf(0));
    a.put("bs", Integer.valueOf(0));
    a.put("bsgap", Integer.valueOf(86400));
    a.put("di", Integer.valueOf(0));
    a.put("l", Integer.valueOf(0));
    a.put("lgap", Integer.valueOf(86400));
    a.put("wi", Integer.valueOf(0));
    a.put("wl", Integer.valueOf(0));
    a.put("wlsr", Integer.valueOf(600));
    a.put("adle", Integer.valueOf(172800));
    a.put("rtgap", Integer.valueOf(86400));
    a.put("p", Integer.valueOf(0));
    a.put("ol", Integer.valueOf(0));
    a.put("xmar", Integer.valueOf(0));
    a.put("bi", Integer.valueOf(0));
    a.put("pl", Integer.valueOf(0));
    a.put("plgap", Long.valueOf(86400L));
    a.put("le", Long.valueOf(180L));
    a.put("legap", Long.valueOf(86400L));
    a.put("sd", Long.valueOf(0L));
    a.put("deup", Integer.valueOf(2));
    a.put("digap", Long.valueOf(2592000L));
    a.put("illegalMacs", null);
    a.put("pe", Long.valueOf(0L));
    a.put("pegap", Long.valueOf(86400L));
    a.put("ac", Long.valueOf(0L));
    a.put("acgap", Long.valueOf(86400L));
  }
  
  private static void U()
  {
    if (!c)
    {
      c = true;
      new Thread()
      {
        public void run()
        {
          String str = a.L();
          if (!TextUtils.isEmpty(str))
          {
            a.a(str);
            if ((a.M() != null) && (!a.M().isEmpty())) {
              break label39;
            }
            a.N();
          }
          for (;;)
          {
            a.a(false);
            return;
            label39:
            d.d(new Hashon().fromHashMap(a.M()));
          }
        }
      }.start();
    }
  }
  
  private static String V()
  {
    Object localObject1 = null;
    try
    {
      localObject2 = d.i();
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject2;
        MobLog.getInstance().w(localThrowable);
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = "http://m.data.mob.com/v4/cconf";
    }
    return (String)localObject2;
  }
  
  public static long a()
  {
    P();
    return ((Long)ResHelper.forceCast(a.get("serverTime"), Long.valueOf(0L))).longValue() + O();
  }
  
  public static void a(long paramLong, boolean paramBoolean)
  {
    d = paramLong;
    boolean bool = paramBoolean;
    if (!paramBoolean)
    {
      bool = paramBoolean;
      if (paramLong == 0L) {
        bool = DeviceHelper.getInstance(MobSDK.getContext()).amIOnForeground();
      }
    }
    if (bool) {
      d.d(paramLong);
    }
  }
  
  private static void a(Object paramObject)
  {
    new Thread()
    {
      public void run()
      {
        try
        {
          Object localObject = new HashMap();
          ((HashMap)localObject).put("list", this.a);
          File localFile = ResHelper.getCacheRootFile(MobSDK.getContext(), ".mcli");
          localObject = Data.AES128Encode("1234567890abcdfi", new Hashon().fromHashMap((HashMap)localObject));
          ResHelper.saveObjectToFile(localFile.getPath(), localObject);
          return;
        }
        catch (Throwable localThrowable)
        {
          MobLog.getInstance().d(localThrowable);
        }
      }
    }.start();
  }
  
  private static boolean a(long paramLong)
  {
    return false;
  }
  
  private static void b(String paramString)
  {
    try
    {
      a = new Hashon().fromJson(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      MobLog.getInstance().w(paramString);
    }
  }
  
  public static boolean b()
  {
    return P();
  }
  
  public static boolean c()
  {
    return (P()) && (1 == ((Integer)ResHelper.forceCast(a.get("rt"), Integer.valueOf(0))).intValue());
  }
  
  public static int d()
  {
    return ((Integer)ResHelper.forceCast(a.get("rtsr"), Integer.valueOf(300))).intValue();
  }
  
  public static boolean e()
  {
    return (P()) && (1 == ((Integer)ResHelper.forceCast(a.get("in"), Integer.valueOf(0))).intValue());
  }
  
  public static boolean f()
  {
    return (P()) && (1 == ((Integer)ResHelper.forceCast(a.get("all"), Integer.valueOf(0))).intValue());
  }
  
  public static boolean g()
  {
    return (P()) && (1 == ((Integer)ResHelper.forceCast(a.get("un"), Integer.valueOf(0))).intValue());
  }
  
  public static long h()
  {
    P();
    return ((Long)ResHelper.forceCast(a.get("aspa"), Long.valueOf(2592000L))).longValue();
  }
  
  public static boolean i()
  {
    return (P()) && (1 == ((Integer)ResHelper.forceCast(a.get("di"), Integer.valueOf(0))).intValue());
  }
  
  public static boolean j()
  {
    return (P()) && (1 == ((Integer)ResHelper.forceCast(a.get("ext"), Integer.valueOf(0))).intValue());
  }
  
  public static boolean k()
  {
    return (P()) && (1 == ((Integer)ResHelper.forceCast(a.get("bs"), Integer.valueOf(0))).intValue());
  }
  
  public static int l()
  {
    P();
    return ((Integer)ResHelper.forceCast(a.get("bsgap"), Integer.valueOf(86400))).intValue();
  }
  
  public static boolean m()
  {
    return (P()) && (1 == ((Integer)ResHelper.forceCast(a.get("l"), Integer.valueOf(0))).intValue());
  }
  
  public static int n()
  {
    P();
    return ((Integer)ResHelper.forceCast(a.get("lgap"), Integer.valueOf(86400))).intValue();
  }
  
  public static boolean o()
  {
    return (P()) && (1 == ((Integer)ResHelper.forceCast(a.get("wi"), Integer.valueOf(0))).intValue());
  }
  
  public static boolean p()
  {
    return (P()) && (1 == ((Integer)ResHelper.forceCast(a.get("wl"), Integer.valueOf(0))).intValue());
  }
  
  public static int q()
  {
    P();
    return ((Integer)ResHelper.forceCast(a.get("wlsr"), Integer.valueOf(600))).intValue();
  }
  
  public static ArrayList<String> r()
  {
    P();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("SSID");
    localArrayList.add("BSSID");
    localArrayList.add("level");
    localArrayList.add("frequency");
    localArrayList.add("___curConn");
    return (ArrayList)ResHelper.forceCast(a.get("wisc"), localArrayList);
  }
  
  public static long s()
  {
    P();
    return ((Integer)ResHelper.forceCast(a.get("adle"), Integer.valueOf(172800))).intValue() * 1000L + a();
  }
  
  public static long t()
  {
    P();
    return ((Integer)ResHelper.forceCast(a.get("rtgap"), Integer.valueOf(86400))).intValue() * 1000L;
  }
  
  public static boolean u()
  {
    return (P()) && (1 == ((Integer)ResHelper.forceCast(a.get("p"), Integer.valueOf(0))).intValue());
  }
  
  public static boolean v()
  {
    return (P()) && (1 == ((Integer)ResHelper.forceCast(a.get("ol"), Integer.valueOf(0))).intValue());
  }
  
  public static long w()
  {
    if (P()) {
      return ((Integer)ResHelper.forceCast(a.get("xmar"), Integer.valueOf(0))).intValue() * 1000L;
    }
    return 0L;
  }
  
  public static boolean x()
  {
    return (P()) && (1 == ((Integer)ResHelper.forceCast(a.get("bi"), Integer.valueOf(0))).intValue());
  }
  
  public static long y()
  {
    long l = 0L;
    if (P()) {
      l = ((Long)ResHelper.forceCast(a.get("pl"), Long.valueOf(0L))).longValue();
    }
    return l;
  }
  
  public static long z()
  {
    P();
    return ((Long)ResHelper.forceCast(a.get("plgap"), Long.valueOf(86400L))).longValue();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/commons/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */