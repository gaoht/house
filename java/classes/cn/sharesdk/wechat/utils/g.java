package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.a.a;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.utils.e;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.HashMap;

public class g
{
  private String a;
  private String b;
  private a c;
  private Platform d;
  private int e;
  
  public g(Platform paramPlatform, int paramInt)
  {
    this.d = paramPlatform;
    this.e = paramInt;
    this.c = a.a();
  }
  
  private void a(String paramString)
  {
    e.b().d("wechat getAuthorizeToken ==>>" + paramString, new Object[0]);
    Object localObject = new Hashon().fromJson(paramString);
    paramString = String.valueOf(((HashMap)localObject).get("access_token"));
    String str1 = String.valueOf(((HashMap)localObject).get("refresh_token"));
    String str2 = String.valueOf(((HashMap)localObject).get("expires_in"));
    localObject = String.valueOf(((HashMap)localObject).get("openid"));
    this.d.getDb().put("openid", (String)localObject);
    this.d.getDb().putExpiresIn(Long.valueOf(str2).longValue());
    this.d.getDb().putToken(paramString);
    this.d.getDb().put("refresh_token", str1);
  }
  
  private void a(final String paramString, final AuthorizeListener paramAuthorizeListener)
    throws Throwable
  {
    e.b().d("getAuthorizeToken ==>> " + paramString, new Object[0]);
    new Thread()
    {
      public void run()
      {
        try
        {
          Object localObject = new ArrayList();
          ((ArrayList)localObject).add(new KVPair("appid", g.d(g.this)));
          ((ArrayList)localObject).add(new KVPair("secret", g.e(g.this)));
          ((ArrayList)localObject).add(new KVPair("code", paramString));
          ((ArrayList)localObject).add(new KVPair("grant_type", "authorization_code"));
          try
          {
            localObject = g.c(g.this).a("https://api.weixin.qq.com/sns/oauth2/access_token", (ArrayList)localObject, "/sns/oauth2/access_token", g.b(g.this));
            if (TextUtils.isEmpty((CharSequence)localObject))
            {
              paramAuthorizeListener.onError(new Throwable("Authorize token is empty"));
              return;
            }
          }
          catch (Throwable localThrowable1)
          {
            paramAuthorizeListener.onError(localThrowable1);
            return;
          }
          if (!localThrowable2.contains("errcode")) {
            break label189;
          }
        }
        catch (Throwable localThrowable2)
        {
          e.b().d(localThrowable2);
          return;
        }
        if (paramAuthorizeListener != null)
        {
          paramAuthorizeListener.onError(new Throwable(localThrowable2));
          return;
          label189:
          g.a(g.this, localThrowable2);
          paramAuthorizeListener.onComplete(null);
        }
      }
    }.start();
  }
  
  public void a(Bundle paramBundle, AuthorizeListener paramAuthorizeListener)
  {
    String str = paramBundle.getString("_wxapi_sendauth_resp_url");
    if (TextUtils.isEmpty(str)) {
      if (paramAuthorizeListener != null) {
        paramAuthorizeListener.onError(null);
      }
    }
    do
    {
      return;
      int i = str.indexOf("://oauth?");
      paramBundle = str;
      if (i >= 0) {
        paramBundle = str.substring(i + 1);
      }
      paramBundle = ResHelper.urlToBundle(paramBundle).getString("code");
      try
      {
        a(paramBundle, paramAuthorizeListener);
        return;
      }
      catch (Throwable paramBundle)
      {
        e.b().d(paramBundle);
      }
    } while (paramAuthorizeListener == null);
    paramAuthorizeListener.onError(paramBundle);
  }
  
  public void a(final PlatformActionListener paramPlatformActionListener)
    throws Throwable
  {
    new Thread()
    {
      public void run()
      {
        try
        {
          Object localObject = new ArrayList();
          ((ArrayList)localObject).add(new KVPair("access_token", g.a(g.this).getDb().getToken()));
          ((ArrayList)localObject).add(new KVPair("openid", g.a(g.this).getDb().get("openid")));
          localObject = g.c(g.this).a("https://api.weixin.qq.com/sns/userinfo", (ArrayList)localObject, "/sns/userinfo", g.b(g.this));
          if (TextUtils.isEmpty((CharSequence)localObject))
          {
            if (paramPlatformActionListener == null) {
              return;
            }
            paramPlatformActionListener.onError(g.a(g.this), 8, new Throwable());
            return;
          }
          e.b().d("getUserInfo ==>>" + (String)localObject, new Object[0]);
          localObject = new Hashon().fromJson((String)localObject);
          if ((((HashMap)localObject).containsKey("errcode")) && (((Integer)((HashMap)localObject).get("errcode")).intValue() != 0))
          {
            if (paramPlatformActionListener == null) {
              return;
            }
            localObject = new Hashon().fromHashMap((HashMap)localObject);
            paramPlatformActionListener.onError(g.a(g.this), 8, new Throwable((String)localObject));
            return;
          }
        }
        catch (Throwable localThrowable1)
        {
          e.b().d(localThrowable1);
          return;
        }
        String str1 = String.valueOf(localThrowable1.get("openid"));
        String str2 = String.valueOf(localThrowable1.get("nickname"));
        try
        {
          i = ResHelper.parseInt(String.valueOf(localThrowable1.get("sex")));
          String str3 = String.valueOf(localThrowable1.get("province"));
          String str4 = String.valueOf(localThrowable1.get("city"));
          String str5 = String.valueOf(localThrowable1.get("country"));
          String str6 = String.valueOf(localThrowable1.get("headimgurl"));
          String str7 = String.valueOf(localThrowable1.get("unionid"));
          g.a(g.this).getDb().put("nickname", str2);
          if (i == 1)
          {
            g.a(g.this).getDb().put("gender", "0");
            g.a(g.this).getDb().putUserId(str1);
            g.a(g.this).getDb().put("icon", str6);
            g.a(g.this).getDb().put("province", str3);
            g.a(g.this).getDb().put("city", str4);
            g.a(g.this).getDb().put("country", str5);
            g.a(g.this).getDb().put("openid", str1);
            g.a(g.this).getDb().put("unionid", str7);
            paramPlatformActionListener.onComplete(g.a(g.this), 8, localThrowable1);
            return;
          }
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            e.b().d(localThrowable2);
            int i = 2;
            continue;
            if (i == 2) {
              g.a(g.this).getDb().put("gender", "1");
            } else {
              g.a(g.this).getDb().put("gender", "2");
            }
          }
        }
      }
    }.start();
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public boolean a()
  {
    String str = this.d.getDb().get("refresh_token");
    if ((TextUtils.isEmpty(this.a)) || (TextUtils.isEmpty(str))) {}
    for (;;)
    {
      return false;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new KVPair("appid", this.a));
      localArrayList.add(new KVPair("refresh_token", str));
      localArrayList.add(new KVPair("grant_type", "refresh_token"));
      try
      {
        str = this.c.a("https://api.weixin.qq.com/sns/oauth2/refresh_token", localArrayList, "/sns/oauth2/refresh_token", this.e);
        if ((!TextUtils.isEmpty(str)) && (!str.contains("errcode")))
        {
          a(str);
          return true;
        }
      }
      catch (Throwable localThrowable)
      {
        e.b().d(localThrowable);
      }
    }
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/wechat/utils/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */