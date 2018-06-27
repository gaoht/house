package cn.sharesdk.tencent.qzone;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.SSOListener;
import com.mob.MobSDK;
import com.mob.tools.RxMob;
import com.mob.tools.RxMob.OnSubscribe;
import com.mob.tools.RxMob.Subscribable;
import com.mob.tools.RxMob.Subscriber;
import com.mob.tools.RxMob.Thread;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.network.NetworkHelper.NetworkTimeOut;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class b
  extends cn.sharesdk.framework.b
{
  private static final String[] b = { "get_user_info", "get_simple_userinfo", "get_user_profile", "get_app_friends", "add_share", "list_album", "upload_pic", "add_album", "set_user_face", "get_vip_info", "get_vip_rich_info", "get_intimate_friends_weibo", "match_nick_tips_weibo", "add_t", "add_pic_t" };
  private static b c;
  private String d;
  private String e;
  private String f;
  private String g;
  private cn.sharesdk.framework.a.a h = cn.sharesdk.framework.a.a.a();
  private String[] i;
  
  private b(Platform paramPlatform)
  {
    super(paramPlatform);
  }
  
  public static b a(Platform paramPlatform)
  {
    if (c == null) {
      c = new b(paramPlatform);
    }
    return c;
  }
  
  private String e()
  {
    int j = 0;
    if (this.i == null) {}
    StringBuilder localStringBuilder;
    for (String[] arrayOfString = b;; arrayOfString = this.i)
    {
      localStringBuilder = new StringBuilder();
      int m = arrayOfString.length;
      int k = 0;
      while (j < m)
      {
        String str = arrayOfString[j];
        if (k > 0) {
          localStringBuilder.append(',');
        }
        localStringBuilder.append(str);
        k += 1;
        j += 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  private String f(String paramString)
  {
    if (Build.VERSION.SDK_INT > 10) {
      try
      {
        Class localClass = ReflectHelper.getClass("android.media.MediaMetadataRetriever");
        Object localObject = localClass.newInstance();
        localClass.getMethod("setDataSource", new Class[] { String.class }).invoke(localObject, new Object[] { paramString });
        paramString = (String)ReflectHelper.invokeInstanceMethod(localObject, "extractMetadata", new Object[] { Integer.valueOf(9) });
        return paramString;
      }
      catch (Throwable paramString)
      {
        return "";
      }
    }
    return "";
  }
  
  public HashMap<String, Object> a(String paramString1, String paramString2)
    throws Throwable
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new KVPair("access_token", this.f));
    localArrayList.add(new KVPair("oauth_consumer_key", this.d));
    localArrayList.add(new KVPair("openid", this.e));
    localArrayList.add(new KVPair("format", "json"));
    if (!TextUtils.isEmpty(paramString2))
    {
      String str = paramString2;
      if (paramString2.length() > 200) {
        str = paramString2.substring(0, 199) + MobSDK.getContext().getString(ResHelper.getStringRes(MobSDK.getContext(), "ssdk_symbol_ellipsis"));
      }
      localArrayList.add(new KVPair("photodesc", str));
    }
    localArrayList.add(new KVPair("mobile", "1"));
    paramString1 = new KVPair("picture", paramString1);
    paramString2 = new ArrayList();
    paramString2.add(new KVPair("User-Agent", System.getProperties().getProperty("http.agent") + " ArzenAndroidSDK"));
    paramString1 = this.h.a("https://graph.qq.com/photo/upload_pic", localArrayList, paramString1, paramString2, "/photo/upload_pic", c());
    if ((paramString1 != null) && (paramString1.length() > 0)) {
      return new Hashon().fromJson(paramString1);
    }
    return null;
  }
  
  public HashMap<String, Object> a(String paramString1, String paramString2, HashMap<String, Object> paramHashMap, HashMap<String, String> paramHashMap1)
  {
    if (paramString2 == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if ((paramHashMap != null) && (paramHashMap.size() > 0))
    {
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramHashMap.next();
        localArrayList.add(new KVPair((String)localEntry.getKey(), String.valueOf(localEntry.getValue())));
      }
    }
    localArrayList.add(new KVPair("access_token", this.f));
    localArrayList.add(new KVPair("oauth_consumer_key", this.d));
    localArrayList.add(new KVPair("openid", this.e));
    localArrayList.add(new KVPair("format", "json"));
    if ((paramHashMap1 != null) && (paramHashMap1.size() > 0))
    {
      paramHashMap1 = paramHashMap1.entrySet().iterator();
      for (paramHashMap = null; paramHashMap1.hasNext(); paramHashMap = new KVPair((String)paramHashMap.getKey(), paramHashMap.getValue())) {
        paramHashMap = (Map.Entry)paramHashMap1.next();
      }
    }
    for (;;)
    {
      paramHashMap1 = new ArrayList();
      paramHashMap1.add(new KVPair("User-Agent", System.getProperties().getProperty("http.agent") + " ArzenAndroidSDK"));
      try
      {
        if ("GET".equals(paramString2.toUpperCase())) {}
        for (paramString1 = new NetworkHelper().httpGet(paramString1, localArrayList, paramHashMap1, null); (paramString1 != null) && (paramString1.length() > 0); paramString1 = new NetworkHelper().httpPost(paramString1, localArrayList, paramHashMap, paramHashMap1, null))
        {
          return new Hashon().fromJson(paramString1);
          if (!"POST".equals(paramString2.toUpperCase())) {
            break label386;
          }
        }
      }
      catch (Throwable paramString1)
      {
        for (;;)
        {
          cn.sharesdk.framework.utils.e.b().d(paramString1);
          label386:
          paramString1 = null;
        }
      }
      paramHashMap = null;
    }
  }
  
  public void a()
  {
    RxMob.Subscribable localSubscribable = RxMob.create(new RxMob.OnSubscribe()
    {
      public void call(RxMob.Subscriber paramAnonymousSubscriber)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new KVPair("access_token", b.a(b.this)));
        localArrayList.add(new KVPair("unionid", "1"));
        NetworkHelper.NetworkTimeOut localNetworkTimeOut = new NetworkHelper.NetworkTimeOut();
        localNetworkTimeOut.readTimout = 10000;
        localNetworkTimeOut.connectionTimeout = 10000;
        cn.sharesdk.framework.a.a locala = cn.sharesdk.framework.a.a.a();
        try
        {
          b.a(b.this, locala.httpPost("https://graph.qq.com/oauth2.0/me", localArrayList, null, null, localNetworkTimeOut));
          paramAnonymousSubscriber.onCompleted();
          return;
        }
        catch (Throwable paramAnonymousSubscriber)
        {
          b.b(b.this).getDb().put("unionid", "");
          cn.sharesdk.framework.utils.e.b().d("qq auth, get unionId fail", new Object[0]);
        }
      }
    });
    localSubscribable.subscribeOn(RxMob.Thread.NEW_THREAD);
    localSubscribable.observeOn(RxMob.Thread.IMMEDIATE);
    localSubscribable.subscribe(new RxMob.Subscriber()
    {
      public void onCompleted()
      {
        if ((b.c(b.this) != null) && (b.c(b.this).length() > 0))
        {
          b.a(b.this, b.c(b.this).replace("callback( ", ""));
          b.a(b.this, b.c(b.this).replace(" );", ""));
          Object localObject = new Hashon().fromJson(b.c(b.this));
          if (((HashMap)localObject).containsKey("unionid"))
          {
            localObject = (String)((HashMap)localObject).get("unionid");
            b.d(b.this).getDb().put("unionid", (String)localObject);
          }
        }
        else
        {
          return;
        }
        b.e(b.this).getDb().put("unionid", "");
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        b.f(b.this).getDb().put("unionid", "");
        cn.sharesdk.framework.utils.e.b().d("qq auth, get unionId fail", new Object[0]);
      }
    });
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, PlatformActionListener paramPlatformActionListener)
    throws Throwable
  {
    String str = paramString5;
    if (TextUtils.isEmpty(paramString5)) {
      str = DeviceHelper.getInstance(MobSDK.getContext()).getAppName();
    }
    if (str.length() > 20) {}
    for (paramString5 = str.substring(0, 20) + "...";; paramString5 = str)
    {
      if ((!TextUtils.isEmpty(paramString1)) && (paramString1.length() > 200)) {
        paramString1 = paramString1.substring(0, 200);
      }
      for (;;)
      {
        b(paramInt, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramPlatformActionListener);
        return;
      }
    }
  }
  
  public void a(final AuthorizeListener paramAuthorizeListener, boolean paramBoolean)
  {
    a(new SSOListener()
    {
      public void onCancel()
      {
        paramAuthorizeListener.onCancel();
      }
      
      public void onComplete(Bundle paramAnonymousBundle)
      {
        paramAuthorizeListener.onComplete(paramAnonymousBundle);
      }
      
      public void onFailed(Throwable paramAnonymousThrowable)
      {
        if (paramAnonymousThrowable != null)
        {
          paramAuthorizeListener.onError(paramAnonymousThrowable);
          return;
        }
        paramAuthorizeListener.onError(new Throwable("Unknown Throwable!"));
      }
    });
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public void a(String[] paramArrayOfString)
  {
    this.i = paramArrayOfString;
  }
  
  public HashMap<String, Object> b(String paramString1, String paramString2)
    throws Throwable
  {
    int j;
    String str1;
    label18:
    String str2;
    ArrayList localArrayList;
    if (!TextUtils.isEmpty(paramString1))
    {
      j = 1;
      if (j == 0) {
        break label229;
      }
      str1 = "/t/add_pic_t";
      str2 = "https://graph.qq.com" + str1;
      localArrayList = new ArrayList();
      localArrayList.add(new KVPair("oauth_consumer_key", this.d));
      localArrayList.add(new KVPair("access_token", this.f));
      localArrayList.add(new KVPair("openid", this.e));
      localArrayList.add(new KVPair("format", "json"));
      localArrayList.add(new KVPair("content", paramString2));
      if (j == 0) {
        break label237;
      }
      paramString1 = new KVPair("pic", paramString1);
      paramString1 = this.h.a(str2, localArrayList, paramString1, str1, c());
    }
    for (;;)
    {
      if ((paramString1 != null) && (paramString1.length() > 0))
      {
        paramString2 = new Hashon().fromJson(paramString1);
        if (((Integer)paramString2.get("ret")).intValue() != 0)
        {
          throw new Throwable(paramString1);
          j = 0;
          break;
          label229:
          str1 = "/t/add_t";
          break label18;
          label237:
          paramString1 = this.h.b(str2, localArrayList, str1, c());
          continue;
        }
        return paramString2;
      }
    }
    return null;
  }
  
  public void b(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, PlatformActionListener paramPlatformActionListener)
    throws Throwable
  {
    String str1 = "1";
    String str2;
    if (!TextUtils.isEmpty(paramString6))
    {
      str1 = "4";
      str2 = paramString4;
      Object localObject;
      if (!TextUtils.isEmpty(paramString4))
      {
        localObject = new File(paramString4);
        str2 = paramString4;
        if (((File)localObject).exists())
        {
          str2 = paramString4;
          if (paramString4.startsWith("/data/"))
          {
            str2 = new File(ResHelper.getCachePath(MobSDK.getContext(), "images"), System.currentTimeMillis() + ((File)localObject).getName()).getAbsolutePath();
            if (!ResHelper.copyFile(paramString4, str2)) {
              break label698;
            }
          }
        }
      }
      label122:
      paramString4 = paramString3;
      if (!TextUtils.isEmpty(paramString3))
      {
        paramString4 = paramString3;
        if (paramString3.length() > 600) {
          paramString4 = paramString3.substring(0, 600);
        }
      }
      paramString3 = new StringBuilder();
      if ((str1 != "3") && (str1 != "4")) {
        break label704;
      }
      paramString3.append("mqqapi://qzone/publish?src_type=app&version=1&file_type=news");
      label194:
      if (!TextUtils.isEmpty(str2)) {
        paramString3.append("&image_url=").append(Base64.encodeToString(str2.getBytes("utf-8"), 2));
      }
      if ((!TextUtils.isEmpty(paramString6)) && (str1.equals("4")))
      {
        ResHelper.getFileSize(paramString6);
        str2 = String.valueOf(paramString5);
        localObject = f(paramString6);
        paramString3.append("&videoPath=").append(Base64.encodeToString(paramString6.getBytes("utf-8"), 2));
        paramString3.append("&videoSize=").append(Base64.encodeToString(str2.getBytes("utf-8"), 2));
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramString3.append("&videoDuration=").append(Base64.encodeToString(((String)localObject).getBytes("utf-8"), 2));
        }
      }
      if (!TextUtils.isEmpty(paramString1)) {
        paramString3.append("&title=").append(Base64.encodeToString(paramString1.getBytes("utf-8"), 2));
      }
      if (!TextUtils.isEmpty(paramString4)) {
        paramString3.append("&description=").append(Base64.encodeToString(paramString4.getBytes("utf-8"), 2));
      }
      paramString3.append("&share_id=").append(this.d);
      if (!TextUtils.isEmpty(paramString2)) {
        paramString3.append("&url=").append(Base64.encodeToString(paramString2.getBytes("utf-8"), 2));
      }
      paramString3.append("&app_name=").append(Base64.encodeToString(paramString5.getBytes("utf-8"), 2));
      if (!TextUtils.isEmpty(paramString4)) {
        paramString3.append("&share_qq_ext_str=").append(Base64.encodeToString(paramString4.getBytes(), 2));
      }
      paramString3.append("&req_type=").append(Base64.encodeToString(str1.getBytes("utf-8"), 2));
      if (!d()) {
        break label716;
      }
    }
    label698:
    label704:
    label716:
    for (paramString1 = "1";; paramString1 = "0")
    {
      paramString3.append("&cflag=").append(Base64.encodeToString(paramString1.getBytes("utf-8"), 2));
      paramString1 = new Intent("android.intent.action.VIEW");
      paramString1.setData(Uri.parse(paramString3.toString()));
      if (MobSDK.getContext().getPackageManager().resolveActivity(paramString1, 1) != null)
      {
        paramString1 = new d();
        paramString1.a(paramString3.toString(), true);
        paramString1.a(paramPlatformActionListener);
        paramString1.a(this.d);
        paramString1.show(MobSDK.getContext(), null);
      }
      do
      {
        return;
        if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)))
        {
          str1 = "3";
          break;
        }
        if (!TextUtils.isEmpty(paramString2)) {
          break;
        }
      } while (paramPlatformActionListener == null);
      paramPlatformActionListener.onError(null, 9, new Throwable("The param of title or titleUrl is null !"));
      return;
      str2 = null;
      break label122;
      paramString3.append("mqqapi://share/to_qzone?src_type=app&version=1&file_type=news");
      break label194;
    }
  }
  
  public void b(String paramString)
  {
    this.e = paramString;
  }
  
  public boolean b()
  {
    int[] arrayOfInt;
    do
    {
      try
      {
        PackageInfo localPackageInfo = MobSDK.getContext().getPackageManager().getPackageInfo("com.qzone", 0);
        if (localPackageInfo == null) {
          return false;
        }
      }
      catch (Throwable localThrowable1)
      {
        cn.sharesdk.framework.utils.e.b().d(localThrowable1);
        return false;
      }
      String[] arrayOfString = localThrowable1.versionName.split("\\.");
      arrayOfInt = new int[arrayOfString.length];
      int j = 0;
      for (;;)
      {
        if (j < arrayOfInt.length) {
          try
          {
            arrayOfInt[j] = ResHelper.parseInt(arrayOfString[j]);
            j += 1;
          }
          catch (Throwable localThrowable2)
          {
            for (;;)
            {
              cn.sharesdk.framework.utils.e.b().d(localThrowable2);
              arrayOfInt[j] = 0;
            }
          }
        }
      }
    } while ((arrayOfInt.length <= 1) || ((arrayOfInt[0] < 4) && (arrayOfInt[1] < 1)));
    return true;
  }
  
  public void c(String paramString)
  {
    this.f = paramString;
  }
  
  public HashMap<String, Object> d(String paramString)
    throws Throwable
  {
    Object localObject1 = null;
    paramString = new ArrayList();
    paramString.add(new KVPair("access_token", this.f));
    paramString.add(new KVPair("oauth_consumer_key", this.d));
    paramString.add(new KVPair("openid", this.e));
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(new KVPair("User-Agent", System.getProperties().getProperty("http.agent") + " ArzenAndroidSDK"));
    localObject2 = this.h.a("https://graph.qq.com/user/get_simple_userinfo", paramString, (ArrayList)localObject2, null, "/user/get_simple_userinfo", c());
    paramString = (String)localObject1;
    if (localObject2 != null)
    {
      paramString = (String)localObject1;
      if (((String)localObject2).length() > 0) {
        paramString = new Hashon().fromJson((String)localObject2);
      }
    }
    return paramString;
  }
  
  public boolean d()
  {
    try
    {
      str1 = MobSDK.getContext().getPackageManager().getPackageInfo("com.tencent.mobileqq", 0).versionName;
      if (TextUtils.isEmpty(str1)) {
        return false;
      }
    }
    catch (Throwable localThrowable4)
    {
      for (;;)
      {
        try
        {
          String str1 = MobSDK.getContext().getPackageManager().getPackageInfo("com.tencent.qqlite", 0).versionName;
        }
        catch (Throwable localThrowable1)
        {
          try
          {
            String str2 = MobSDK.getContext().getPackageManager().getPackageInfo("com.tencent.minihd.qq", 0).versionName;
          }
          catch (Throwable localThrowable2)
          {
            try
            {
              String str3 = MobSDK.getContext().getPackageManager().getPackageInfo("com.tencent.tim", 0).versionName;
            }
            catch (Throwable localThrowable3)
            {
              cn.sharesdk.framework.utils.e.b().d(localThrowable4);
              Object localObject = null;
            }
          }
        }
      }
    }
    return true;
  }
  
  public HashMap<String, Object> e(String paramString)
    throws Throwable
  {
    Object localObject2 = null;
    Object localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(new KVPair("access_token", paramString));
    paramString = new ArrayList();
    paramString.add(new KVPair("User-Agent", System.getProperties().getProperty("http.agent") + " ArzenAndroidSDK"));
    paramString = this.h.a("https://graph.qq.com/oauth2.0/me", (ArrayList)localObject1, paramString, null, "/oauth2.0/me", c());
    localObject1 = paramString;
    if (paramString.startsWith("callback"))
    {
      for (localObject1 = paramString;; localObject1 = ((String)localObject1).substring(1))
      {
        paramString = (String)localObject1;
        if (((String)localObject1).startsWith("{")) {
          break;
        }
        paramString = (String)localObject1;
        if (((String)localObject1).length() <= 0) {
          break;
        }
      }
      for (;;)
      {
        localObject1 = paramString;
        if (paramString.endsWith("}")) {
          break;
        }
        localObject1 = paramString;
        if (paramString.length() <= 0) {
          break;
        }
        paramString = paramString.substring(0, paramString.length() - 1);
      }
    }
    paramString = (String)localObject2;
    if (localObject1 != null)
    {
      paramString = (String)localObject2;
      if (((String)localObject1).length() > 0) {
        paramString = new Hashon().fromJson((String)localObject1);
      }
    }
    return paramString;
  }
  
  public String getAuthorizeUrl()
  {
    ShareSDK.logApiEvent("/oauth2.0/authorize", c());
    String str3 = e();
    String str1 = getRedirectUri();
    try
    {
      str1 = Data.urlEncode(str1, "utf-8");
      return "https://graph.qq.com/oauth2.0/m_authorize?response_type=token&client_id=" + this.d + "&redirect_uri=" + str1 + "&display=mobile&scope=" + str3;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        cn.sharesdk.framework.utils.e.b().d(localThrowable);
        String str2 = getRedirectUri();
      }
    }
  }
  
  public cn.sharesdk.framework.authorize.b getAuthorizeWebviewClient(cn.sharesdk.framework.authorize.e parame)
  {
    return new a(parame);
  }
  
  public String getRedirectUri()
  {
    return "auth://tauth.qq.com/";
  }
  
  public cn.sharesdk.framework.authorize.d getSSOProcessor(cn.sharesdk.framework.authorize.c paramc)
  {
    paramc = new c(paramc);
    paramc.a(5656);
    paramc.a(this.d, e());
    return paramc;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/tencent/qzone/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */