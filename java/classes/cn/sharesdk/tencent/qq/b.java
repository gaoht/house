package cn.sharesdk.tencent.qq;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.SSOListener;
import cn.sharesdk.framework.utils.f;
import com.mob.MobSDK;
import com.mob.tools.RxMob;
import com.mob.tools.RxMob.OnSubscribe;
import com.mob.tools.RxMob.Subscribable;
import com.mob.tools.RxMob.Subscriber;
import com.mob.tools.RxMob.Thread;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper.NetworkTimeOut;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

public class b
  extends cn.sharesdk.framework.b
{
  private static final String[] b = { "get_user_info", "get_simple_userinfo", "get_user_profile", "get_app_friends", "add_share", "list_album", "upload_pic", "add_album", "set_user_face", "get_vip_info", "get_vip_rich_info", "get_intimate_friends_weibo", "match_nick_tips_weibo", "add_t", "add_pic_t" };
  private static b c;
  private String d;
  private String[] e;
  private String f;
  private String g;
  private String h;
  private String i;
  
  private b(Platform paramPlatform)
  {
    super(paramPlatform);
    b();
  }
  
  public static b a(Platform paramPlatform)
  {
    if (c == null) {
      c = new b(paramPlatform);
    }
    return c;
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, PlatformActionListener paramPlatformActionListener)
  {
    paramString6 = paramString5;
    if (paramString5 == null)
    {
      paramString6 = paramString5;
      if (paramString4 != null)
      {
        paramString6 = paramString5;
        if (new File(paramString4).exists()) {
          paramString6 = ((QQ)this.a).uploadImageToFileServer(paramString4);
        }
      }
    }
    for (;;)
    {
      try
      {
        paramString5 = new StringBuilder();
        paramString5.append("http://openmobile.qq.com/api/check?");
        paramString5.append("page=shareindex.html&");
        paramString5.append("style=9&");
        paramString5.append("action=shareToQQ&");
        paramString5.append("sdkv=2.2.1&");
        paramString5.append("sdkp=a&");
        paramString5.append("appId=").append(this.d).append("&");
        paramString4 = DeviceHelper.getInstance(MobSDK.getContext());
        paramString5.append("status_os=").append(Data.urlEncode(paramString4.getOSVersionName(), "utf-8")).append("&");
        paramString5.append("status_machine=").append(Data.urlEncode(paramString4.getModel(), "utf-8")).append("&");
        paramString5.append("status_version=").append(Data.urlEncode(String.valueOf(paramString4.getOSVersionInt()), "utf-8")).append("&");
        paramString4 = paramString4.getAppName();
        if (!TextUtils.isEmpty(paramString4)) {
          paramString5.append("site=").append(Data.urlEncode(paramString4, "utf-8")).append("&");
        }
        if (!TextUtils.isEmpty(paramString1))
        {
          if (paramString1.length() > 40)
          {
            paramString1 = paramString1.substring(40) + "...";
            paramString4 = paramString1;
            if (paramString1.length() > 80) {
              paramString4 = paramString1.substring(80) + "...";
            }
            paramString5.append("title=").append(Data.urlEncode(paramString4, "utf-8")).append("&");
          }
        }
        else
        {
          if (!TextUtils.isEmpty(paramString3)) {
            paramString5.append("summary=").append(Data.urlEncode(paramString3, "utf-8")).append("&");
          }
          if (!TextUtils.isEmpty(paramString2)) {
            paramString5.append("targeturl=").append(Data.urlEncode(paramString2, "utf-8")).append("&");
          }
          if (!TextUtils.isEmpty(paramString6)) {
            paramString5.append("imageUrl=").append(Data.urlEncode(paramString6, "utf-8")).append("&");
          }
          paramString5.append("type=1");
          paramString1 = new e();
          paramString1.a(paramString5.toString());
          paramString1.a(paramPlatformActionListener);
          paramString1.b(this.d);
          paramString1.show(MobSDK.getContext(), null);
          return;
        }
      }
      catch (Throwable paramString1)
      {
        if (paramPlatformActionListener != null)
        {
          paramPlatformActionListener.onError(this.a, 9, paramString1);
          return;
        }
      }
    }
  }
  
  private void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, PlatformActionListener paramPlatformActionListener)
  {
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString4)) {
          continue;
        }
        if (TextUtils.isEmpty(paramString5)) {
          break label329;
        }
      }
      catch (Throwable paramString1)
      {
        ArrayList localArrayList;
        if (paramPlatformActionListener == null) {
          break label328;
        }
        paramPlatformActionListener.onError(this.a, 9, paramString1);
        return;
        j = 1;
        if (j != 0) {
          break label335;
        }
        paramString1 = "/t/add_t";
        continue;
      }
      paramString6 = "https://graph.qq.com" + paramString1;
      localArrayList = new ArrayList();
      localArrayList.add(new KVPair("oauth_consumer_key", this.d));
      localArrayList.add(new KVPair("access_token", this.h));
      localArrayList.add(new KVPair("openid", this.f));
      localArrayList.add(new KVPair("format", "json"));
      localArrayList.add(new KVPair("content", paramString3));
      if (j != 0)
      {
        paramString2 = paramString4;
        if (TextUtils.isEmpty(paramString4)) {
          paramString2 = BitmapHelper.downloadBitmap(MobSDK.getContext(), paramString5);
        }
        paramString2 = new KVPair("pic", paramString2);
        paramString1 = cn.sharesdk.framework.a.a.a().a(paramString6, localArrayList, paramString2, paramString1, c());
        if ((paramString1 == null) || (paramString1.length() <= 0) || (paramPlatformActionListener == null)) {
          break label328;
        }
        paramString2 = new Hashon().fromJson(paramString1);
        if (((Integer)paramString2.get("ret")).intValue() != 0) {
          paramPlatformActionListener.onError(this.a, 9, new Exception(paramString1));
        }
      }
      else
      {
        paramString1 = cn.sharesdk.framework.a.a.a().b(paramString6, localArrayList, paramString1, c());
        continue;
      }
      paramPlatformActionListener.onComplete(this.a, 9, paramString2);
      return;
      label328:
      return;
      label329:
      int j = 0;
      continue;
      label335:
      paramString1 = "/t/add_pic_t";
    }
  }
  
  private String d()
  {
    int j = 0;
    if (this.e == null) {}
    StringBuilder localStringBuilder;
    for (String[] arrayOfString = b;; arrayOfString = this.e)
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
          paramAnonymousSubscriber.printStackTrace();
          b.b(b.this).getDb().put("unionid", "");
          cn.sharesdk.framework.utils.e.b().d("qq auth,get unionId fail", new Object[0]);
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
        cn.sharesdk.framework.utils.e.b().d("qq auth,get unionId fail", new Object[0]);
      }
    });
  }
  
  public void a(Platform paramPlatform, Platform.ShareParams paramShareParams, PlatformActionListener paramPlatformActionListener)
    throws Throwable
  {
    Object localObject = new f();
    ((f)localObject).a(this.i, "com.tencent.mobileqq.activity.JumpActivity");
    ((f)localObject).a(paramShareParams, paramPlatform);
    localObject = new HashMap();
    ((HashMap)localObject).put("ShareParams", paramShareParams);
    paramPlatformActionListener.onComplete(paramPlatform, 9, (HashMap)localObject);
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
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean1, PlatformActionListener paramPlatformActionListener, boolean paramBoolean2, int paramInt)
  {
    if (paramBoolean2)
    {
      b(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramPlatformActionListener);
      return;
    }
    if ((paramBoolean1) && (b()))
    {
      String str = paramString4;
      if (!TextUtils.isEmpty(paramString4))
      {
        File localFile = new File(paramString4);
        str = paramString4;
        if (localFile.exists())
        {
          str = paramString4;
          if (paramString4.startsWith("/data/"))
          {
            str = new File(ResHelper.getCachePath(MobSDK.getContext(), "images"), System.currentTimeMillis() + localFile.getName()).getAbsolutePath();
            if (!ResHelper.copyFile(paramString4, str)) {
              break label270;
            }
          }
        }
      }
      for (;;)
      {
        paramString4 = new Intent();
        paramString4.putExtra("title", paramString1);
        paramString4.putExtra("titleUrl", paramString2);
        paramString4.putExtra("summary", paramString3);
        paramString4.putExtra("imagePath", str);
        paramString4.putExtra("imageUrl", paramString5);
        paramString4.putExtra("musicUrl", paramString6);
        paramString4.putExtra("appId", this.d);
        paramString4.putExtra("hidden", paramInt);
        paramString1 = new d();
        paramString1.a(this.a, paramPlatformActionListener);
        paramString1.a(this.d);
        paramString1.show(MobSDK.getContext(), paramString4);
        return;
        label270:
        str = null;
      }
    }
    a(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramPlatformActionListener);
  }
  
  public void a(String[] paramArrayOfString)
  {
    this.e = paramArrayOfString;
  }
  
  public void b(String paramString)
  {
    this.f = paramString;
  }
  
  public boolean b()
  {
    try
    {
      PackageInfo localPackageInfo1 = MobSDK.getContext().getPackageManager().getPackageInfo("com.tencent.mobileqq", 0);
      str1 = localPackageInfo1.versionName;
      this.i = localPackageInfo1.packageName;
      if (TextUtils.isEmpty(str1)) {
        return false;
      }
    }
    catch (Throwable localThrowable5)
    {
      for (;;)
      {
        try
        {
          localPackageInfo2 = MobSDK.getContext().getPackageManager().getPackageInfo("com.tencent.tim", 0);
          String str1 = localPackageInfo2.versionName;
          this.i = localPackageInfo2.packageName;
        }
        catch (Throwable localThrowable1)
        {
          try
          {
            localPackageInfo2 = MobSDK.getContext().getPackageManager().getPackageInfo("com.tencent.minihd.qq", 0);
            String str2 = localPackageInfo2.versionName;
            this.i = localPackageInfo2.packageName;
          }
          catch (Throwable localThrowable2)
          {
            try
            {
              localPackageInfo2 = MobSDK.getContext().getPackageManager().getPackageInfo("com.tencent.mobileqqi", 0);
              String str3 = localPackageInfo2.versionName;
              this.i = localPackageInfo2.packageName;
            }
            catch (Throwable localThrowable3)
            {
              try
              {
                PackageInfo localPackageInfo2 = MobSDK.getContext().getPackageManager().getPackageInfo("com.tencent.qqlite", 0);
                String str4 = localPackageInfo2.versionName;
                this.i = localPackageInfo2.packageName;
              }
              catch (Throwable localThrowable4)
              {
                Object localObject = null;
                cn.sharesdk.framework.utils.e.b().d(localThrowable5);
              }
            }
          }
        }
      }
    }
    return true;
  }
  
  public HashMap<String, Object> c(String paramString)
    throws Throwable
  {
    Object localObject2 = null;
    Object localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(new KVPair("access_token", paramString));
    paramString = new ArrayList();
    paramString.add(new KVPair("User-Agent", System.getProperties().getProperty("http.agent") + " ArzenAndroidSDK"));
    paramString = cn.sharesdk.framework.a.a.a().a("https://graph.qq.com/oauth2.0/me", (ArrayList)localObject1, paramString, null, "/oauth2.0/me", c());
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
  
  public void d(String paramString)
  {
    this.h = paramString;
  }
  
  public HashMap<String, Object> e(String paramString)
    throws Throwable
  {
    Object localObject1 = null;
    paramString = new ArrayList();
    paramString.add(new KVPair("access_token", this.h));
    paramString.add(new KVPair("oauth_consumer_key", this.d));
    paramString.add(new KVPair("openid", this.f));
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(new KVPair("User-Agent", System.getProperties().getProperty("http.agent") + " ArzenAndroidSDK"));
    localObject2 = cn.sharesdk.framework.a.a.a().a("https://graph.qq.com/user/get_simple_userinfo", paramString, (ArrayList)localObject2, null, "/user/get_simple_userinfo", c());
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
  
  public String getAuthorizeUrl()
  {
    ShareSDK.logApiEvent("/oauth2.0/authorize", c());
    String str3 = d();
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
    paramc.a(this.d, d(), this.i);
    return paramc;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/tencent/qq/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */