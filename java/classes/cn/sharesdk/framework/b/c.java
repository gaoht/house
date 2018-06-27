package cn.sharesdk.framework.b;

import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.b.a.d;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.network.NetworkHelper.NetworkTimeOut;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.HashMap;

public class c
{
  private cn.sharesdk.framework.b.a.e a = cn.sharesdk.framework.b.a.e.a();
  private DeviceHelper b = DeviceHelper.getInstance(MobSDK.getContext());
  private NetworkHelper c = new NetworkHelper();
  private Hashon d = new Hashon();
  private String e;
  private String f;
  private boolean g;
  private HashMap<String, String> h;
  
  public c()
  {
    try
    {
      this.h = ((HashMap)this.a.h("buffered_server_paths"));
      g();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        this.h = new HashMap();
      }
    }
  }
  
  private String e(String paramString)
    throws Throwable
  {
    boolean bool1 = this.a.c();
    boolean bool2 = this.a.d();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Data.urlEncode(this.b.getPackageName(), "utf-8")).append("|");
    localStringBuilder.append(Data.urlEncode(this.b.getAppVersionName(), "utf-8")).append("|");
    localStringBuilder.append(Data.urlEncode(String.valueOf(ShareSDK.SDK_VERSION_CODE), "utf-8")).append("|");
    localStringBuilder.append(Data.urlEncode(String.valueOf(this.b.getPlatformCode()), "utf-8")).append("|");
    localStringBuilder.append(Data.urlEncode(this.b.getDetailNetworkTypeForStatic(), "utf-8")).append("|");
    if (bool1)
    {
      localStringBuilder.append(Data.urlEncode(String.valueOf(this.b.getOSVersionInt()), "utf-8")).append("|");
      localStringBuilder.append(Data.urlEncode(this.b.getScreenSize(), "utf-8")).append("|");
      localStringBuilder.append(Data.urlEncode(this.b.getManufacturer(), "utf-8")).append("|");
      localStringBuilder.append(Data.urlEncode(this.b.getModel(), "utf-8")).append("|");
      localStringBuilder.append(Data.urlEncode(this.b.getCarrier(), "utf-8")).append("|");
      if (!bool2) {
        break label346;
      }
      localStringBuilder.append(paramString);
    }
    for (;;)
    {
      paramString = localStringBuilder.toString();
      cn.sharesdk.framework.utils.e.b().i("shorLinkMsg ===>>>>", new Object[] { paramString });
      return Base64.encodeToString(Data.AES128Encode(Data.rawMD5(String.format("%s:%s", new Object[] { this.b.getDeviceKey(), MobSDK.getAppkey() })), paramString), 2);
      localStringBuilder.append("|||||");
      break;
      label346:
      localStringBuilder.append(paramString.split("\\|")[0]);
      localStringBuilder.append("|||||");
    }
  }
  
  private void g()
  {
    String str1 = this.b.getPackageName() + "/" + this.b.getAppVersionName();
    String str2 = "Android/" + this.b.getOSVersionInt();
    this.e = (str1 + " " + "ShareSDK/3.1.4" + " " + str2);
    this.f = "http://api.share.mob.com:80";
    this.g = true;
  }
  
  private String h()
  {
    return this.f + "/conn";
  }
  
  private String i()
  {
    if ((this.h != null) && (this.h.containsKey("/date"))) {
      return (String)this.h.get("/date") + "/date";
    }
    return this.f + "/date";
  }
  
  private String j()
  {
    return this.f + "/conf5";
  }
  
  private String k()
  {
    return "http://up.sharesdk.cn/upload/image";
  }
  
  private String l()
  {
    if ((this.h != null) && (this.h.containsKey("/log4"))) {
      return (String)this.h.get("/log4") + "/log4";
    }
    return this.f + "/log4";
  }
  
  private String m()
  {
    return "http://l.mob.com/url/ShareSdkMapping.do";
  }
  
  private String n()
  {
    if ((this.h != null) && (this.h.containsKey("/snsconf"))) {
      return (String)this.h.get("/snsconf") + "/snsconf";
    }
    return this.f + "/snsconf";
  }
  
  public HashMap<String, Object> a()
    throws Throwable
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(new KVPair("appkey", MobSDK.getAppkey()));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new KVPair("User-Agent", this.e));
    NetworkHelper.NetworkTimeOut localNetworkTimeOut = new NetworkHelper.NetworkTimeOut();
    localNetworkTimeOut.readTimout = 30000;
    localNetworkTimeOut.connectionTimeout = 30000;
    localObject = this.c.httpPost(h(), (ArrayList)localObject, null, localArrayList, localNetworkTimeOut);
    cn.sharesdk.framework.utils.e.b().i(" isConnectToServer response == %s", new Object[] { localObject });
    return this.d.fromJson((String)localObject);
  }
  
  public HashMap<String, Object> a(String paramString1, ArrayList<String> paramArrayList, int paramInt, String paramString2)
    throws Throwable
  {
    if (!this.g) {}
    do
    {
      do
      {
        return null;
        paramString1 = new ArrayList();
        paramString1.add(new KVPair("key", MobSDK.getAppkey()));
        int i = 0;
        while (i < paramArrayList.size())
        {
          paramString1.add(new KVPair("urls", ((String)paramArrayList.get(i)).toString()));
          i += 1;
        }
        paramString1.add(new KVPair("deviceid", this.b.getDeviceKey()));
        paramString1.add(new KVPair("snsplat", String.valueOf(paramInt)));
        paramArrayList = e(paramString2);
      } while (TextUtils.isEmpty(paramArrayList));
      paramString1.add(new KVPair("m", paramArrayList));
      paramArrayList = new ArrayList();
      paramArrayList.add(new KVPair("User-Agent", this.e));
      paramString2 = new NetworkHelper.NetworkTimeOut();
      paramString2.readTimout = 5000;
      paramString2.connectionTimeout = 5000;
      paramString1 = this.c.httpPost(m(), paramString1, null, paramArrayList, paramString2);
      cn.sharesdk.framework.utils.e.b().i("> SERVER_SHORT_LINK_URL  resp: %s", new Object[] { paramString1 });
      if (TextUtils.isEmpty(paramString1))
      {
        this.g = false;
        return null;
      }
      paramString1 = this.d.fromJson(paramString1);
    } while (((Integer)paramString1.get("status")).intValue() != 200);
    return paramString1;
  }
  
  public void a(cn.sharesdk.framework.b.b.c paramc)
    throws Throwable
  {
    d.a(paramc.toString(), paramc.e);
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      cn.sharesdk.framework.utils.e.b().d("duid === " + paramString, new Object[0]);
      this.e = (this.e + " " + paramString);
    }
  }
  
  public void a(ArrayList<String> paramArrayList)
    throws Throwable
  {
    d.a(paramArrayList);
  }
  
  public void a(HashMap<String, String> paramHashMap)
  {
    this.h = paramHashMap;
    this.a.a("buffered_server_paths", this.h);
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    try
    {
      if ("none".equals(this.b.getDetailNetworkTypeForStatic())) {
        throw new IllegalStateException("network is disconnected!");
      }
    }
    catch (Throwable paramString)
    {
      cn.sharesdk.framework.utils.e.b().d(paramString);
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new KVPair("m", paramString));
    if (paramBoolean) {}
    for (paramString = "1";; paramString = "0")
    {
      localArrayList.add(new KVPair("t", paramString));
      paramString = new ArrayList();
      paramString.add(new KVPair("User-Agent", this.e));
      NetworkHelper.NetworkTimeOut localNetworkTimeOut = new NetworkHelper.NetworkTimeOut();
      localNetworkTimeOut.readTimout = 30000;
      localNetworkTimeOut.connectionTimeout = 30000;
      paramString = this.c.httpPost(l(), localArrayList, null, paramString, localNetworkTimeOut);
      cn.sharesdk.framework.utils.e.b().i("> Upload All Log  resp: %s", new Object[] { paramString });
      if ((TextUtils.isEmpty(paramString)) || (((Integer)this.d.fromJson(paramString).get("status")).intValue() == 200)) {
        break;
      }
      return false;
    }
    return true;
  }
  
  public long b()
    throws Throwable
  {
    if (!this.a.i()) {
      return 0L;
    }
    Object localObject = "{}";
    try
    {
      String str = this.c.httpGet(i(), null, null, null);
      localObject = str;
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        cn.sharesdk.framework.utils.e.b().d(localThrowable2);
      }
    }
    localObject = this.d.fromJson((String)localObject);
    if (((HashMap)localObject).containsKey("timestamp")) {
      try
      {
        long l = ResHelper.parseLong(String.valueOf(((HashMap)localObject).get("timestamp")));
        l = System.currentTimeMillis() - l;
        this.a.a("service_time", Long.valueOf(l));
        return l;
      }
      catch (Throwable localThrowable1)
      {
        cn.sharesdk.framework.utils.e.b().d(localThrowable1);
        return this.a.b();
      }
    }
    return this.a.b();
  }
  
  public void b(String paramString)
  {
    this.f = paramString;
  }
  
  public void b(HashMap<String, Object> paramHashMap)
    throws Throwable
  {
    paramHashMap = this.d.fromHashMap(paramHashMap);
    this.a.e(paramHashMap);
  }
  
  public HashMap<String, Object> c()
    throws Throwable
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(new KVPair("appkey", MobSDK.getAppkey()));
    ((ArrayList)localObject).add(new KVPair("device", this.b.getDeviceKey()));
    ((ArrayList)localObject).add(new KVPair("plat", String.valueOf(this.b.getPlatformCode())));
    ((ArrayList)localObject).add(new KVPair("apppkg", this.b.getPackageName()));
    ((ArrayList)localObject).add(new KVPair("appver", String.valueOf(this.b.getAppVersion())));
    ((ArrayList)localObject).add(new KVPair("sdkver", String.valueOf(ShareSDK.SDK_VERSION_CODE)));
    ((ArrayList)localObject).add(new KVPair("networktype", this.b.getDetailNetworkTypeForStatic()));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new KVPair("User-Agent", this.e));
    NetworkHelper.NetworkTimeOut localNetworkTimeOut = new NetworkHelper.NetworkTimeOut();
    localNetworkTimeOut.readTimout = 10000;
    localNetworkTimeOut.connectionTimeout = 10000;
    localObject = this.c.httpPost(j(), (ArrayList)localObject, null, localArrayList, localNetworkTimeOut);
    cn.sharesdk.framework.utils.e.b().i(" get server config response == %s", new Object[] { localObject });
    return this.d.fromJson((String)localObject);
  }
  
  public HashMap<String, Object> c(String paramString)
    throws Throwable
  {
    paramString = new KVPair("file", paramString);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new KVPair("User-Agent", this.e));
    paramString = this.c.httpPost(k(), null, paramString, localArrayList, null);
    cn.sharesdk.framework.utils.e.b().i("upload file response == %s", new Object[] { paramString });
    return this.d.fromJson(paramString);
  }
  
  public HashMap<String, Object> d()
    throws Throwable
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(new KVPair("appkey", MobSDK.getAppkey()));
    ((ArrayList)localObject).add(new KVPair("device", this.b.getDeviceKey()));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new KVPair("User-Agent", this.e));
    NetworkHelper.NetworkTimeOut localNetworkTimeOut = new NetworkHelper.NetworkTimeOut();
    localNetworkTimeOut.readTimout = 10000;
    localNetworkTimeOut.connectionTimeout = 10000;
    localObject = this.c.httpPost(n(), (ArrayList)localObject, null, localArrayList, localNetworkTimeOut);
    return this.d.fromJson((String)localObject);
  }
  
  public HashMap<String, Object> d(String paramString)
    throws Throwable
  {
    paramString = Base64.decode(paramString, 2);
    String str = this.b.getDeviceKey();
    paramString = new String(Data.AES128Decode(Data.rawMD5(MobSDK.getAppkey() + ":" + str), paramString), "UTF-8").trim();
    return this.d.fromJson(paramString);
  }
  
  public ArrayList<cn.sharesdk.framework.b.a.c> e()
    throws Throwable
  {
    ArrayList localArrayList2 = d.a();
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null) {
      localArrayList1 = new ArrayList();
    }
    return localArrayList1;
  }
  
  public HashMap<String, Object> f()
    throws Throwable
  {
    String str = this.a.g();
    return this.d.fromJson(str);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/framework/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */