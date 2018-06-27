package cn.sharesdk.wechat.friends;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.b.b.f.a;
import cn.sharesdk.framework.utils.e;
import cn.sharesdk.wechat.utils.WechatClientNotExistException;
import cn.sharesdk.wechat.utils.g;
import cn.sharesdk.wechat.utils.j;
import cn.sharesdk.wechat.utils.k;
import com.mob.tools.log.NLog;
import java.util.ArrayList;
import java.util.HashMap;

public class Wechat
  extends Platform
{
  public static final String NAME = Wechat.class.getSimpleName();
  private String a;
  private String b;
  private boolean c;
  private String d;
  private String e;
  private boolean f;
  private int g;
  
  private boolean c()
  {
    boolean bool = false;
    if (!TextUtils.isEmpty(getDb().get("refresh_token")))
    {
      g localg = new g(this, 22);
      localg.a(this.a, this.b);
      bool = localg.a();
    }
    return bool;
  }
  
  protected boolean checkAuthorize(int paramInt, Object paramObject)
  {
    if (!isClientValid())
    {
      if (this.listener != null) {
        this.listener.onError(this, paramInt, new WechatClientNotExistException());
      }
      return false;
    }
    if ((paramInt == 9) || (isAuthValid()) || (c())) {
      return true;
    }
    if (!TextUtils.isEmpty(getDb().get("refresh_token"))) {
      try
      {
        g localg = new g(this, 22);
        localg.a(this.a, this.b);
        boolean bool = localg.a();
        if (bool) {
          return true;
        }
      }
      catch (Exception localException)
      {
        e.b().d(localException);
      }
    }
    innerAuthorize(paramInt, paramObject);
    return false;
  }
  
  protected void doAuthorize(String[] paramArrayOfString)
  {
    if ((TextUtils.isEmpty(this.a)) || (TextUtils.isEmpty(this.b))) {
      if (this.listener != null) {
        this.listener.onError(this, 8, new Throwable("The params of appID or appSecret is missing !"));
      }
    }
    do
    {
      do
      {
        return;
        paramArrayOfString = k.a();
        paramArrayOfString.c(this.a);
        if (paramArrayOfString.c()) {
          break;
        }
      } while (this.listener == null);
      this.listener.onError(this, 1, new WechatClientNotExistException());
      return;
      g localg = new g(this, 22);
      localg.a(this.a, this.b);
      j localj = new j(this);
      localj.a(localg);
      localj.a(new AuthorizeListener()
      {
        public void onCancel()
        {
          if (Wechat.c(Wechat.this) != null) {
            Wechat.d(Wechat.this).onCancel(Wechat.this, 1);
          }
        }
        
        public void onComplete(Bundle paramAnonymousBundle)
        {
          Wechat.a(Wechat.this, 1, null);
        }
        
        public void onError(Throwable paramAnonymousThrowable)
        {
          if (Wechat.a(Wechat.this) != null) {
            Wechat.b(Wechat.this).onError(Wechat.this, 1, paramAnonymousThrowable);
          }
        }
      });
      try
      {
        paramArrayOfString.a(localj);
        return;
      }
      catch (Throwable paramArrayOfString) {}
    } while (this.listener == null);
    this.listener.onError(this, 1, paramArrayOfString);
  }
  
  protected void doCustomerProtocol(String paramString1, String paramString2, int paramInt, HashMap<String, Object> paramHashMap, HashMap<String, String> paramHashMap1)
  {
    if (this.listener != null) {
      this.listener.onCancel(this, paramInt);
    }
  }
  
  protected void doShare(Platform.ShareParams paramShareParams)
  {
    paramShareParams.set("scene", Integer.valueOf(0));
    k localk = k.a();
    Object localObject;
    label53:
    boolean bool;
    label76:
    int i;
    if (TextUtils.isEmpty(paramShareParams.getWxPath()))
    {
      localObject = this.e;
      this.e = ((String)localObject);
      if (!TextUtils.isEmpty(paramShareParams.getWxUserName())) {
        break label188;
      }
      localObject = this.d;
      this.d = ((String)localObject);
      if (paramShareParams.toMap().containsKey("wxWithShareTicket")) {
        break label197;
      }
      bool = this.f;
      this.f = bool;
      if (paramShareParams.toMap().containsKey("wxMiniProgramType")) {
        break label205;
      }
      i = this.g;
      this.g = i;
      localk.a(this.e);
      localk.b(this.d);
      localk.a(this.f);
      localk.a(this.g);
      localk.c(this.a);
      localObject = new j(this);
      if (!this.c) {
        break label235;
      }
    }
    label188:
    label197:
    label205:
    label235:
    do
    {
      try
      {
        localk.a((j)localObject, paramShareParams, this.listener);
        return;
        localObject = paramShareParams.getWxPath();
        break;
        localObject = paramShareParams.getWxUserName();
        break label53;
        bool = paramShareParams.getWxWithShareTicket();
        break label76;
        i = paramShareParams.getWxMiniProgramType();
      }
      catch (Throwable paramShareParams)
      {
        while (this.listener == null) {}
        this.listener.onError(this, 9, paramShareParams);
        return;
      }
      ((j)localObject).a(paramShareParams, this.listener);
      try
      {
        localk.b((j)localObject);
        return;
      }
      catch (Throwable paramShareParams) {}
    } while (this.listener == null);
    this.listener.onError(this, 9, paramShareParams);
  }
  
  protected HashMap<String, Object> filterFriendshipInfo(int paramInt, HashMap<String, Object> paramHashMap)
  {
    return null;
  }
  
  protected f.a filterShareContent(Platform.ShareParams paramShareParams, HashMap<String, Object> paramHashMap)
  {
    paramHashMap = new f.a();
    String str1 = paramShareParams.getText();
    paramHashMap.b = str1;
    String str2 = paramShareParams.getImageUrl();
    Object localObject = paramShareParams.getImagePath();
    Bitmap localBitmap = paramShareParams.getImageData();
    if (!TextUtils.isEmpty(str2)) {
      paramHashMap.d.add(str2);
    }
    for (;;)
    {
      str2 = paramShareParams.getUrl();
      if (str2 != null) {
        paramHashMap.c.add(str2);
      }
      localObject = new HashMap();
      ((HashMap)localObject).put("title", paramShareParams.getTitle());
      ((HashMap)localObject).put("url", str2);
      ((HashMap)localObject).put("extInfo", null);
      ((HashMap)localObject).put("content", str1);
      ((HashMap)localObject).put("image", paramHashMap.d);
      ((HashMap)localObject).put("musicFileUrl", str2);
      paramHashMap.g = ((HashMap)localObject);
      return paramHashMap;
      if (localObject != null) {
        paramHashMap.e.add(localObject);
      } else if (localBitmap != null) {
        paramHashMap.f.add(localBitmap);
      }
    }
  }
  
  protected void follow(String paramString)
  {
    if (this.listener != null) {
      this.listener.onCancel(this, 6);
    }
  }
  
  protected HashMap<String, Object> getBilaterals(int paramInt1, int paramInt2, String paramString)
  {
    return null;
  }
  
  protected HashMap<String, Object> getFollowers(int paramInt1, int paramInt2, String paramString)
  {
    return null;
  }
  
  protected HashMap<String, Object> getFollowings(int paramInt1, int paramInt2, String paramString)
  {
    return null;
  }
  
  protected void getFriendList(int paramInt1, int paramInt2, String paramString)
  {
    if (this.listener != null) {
      this.listener.onCancel(this, 2);
    }
  }
  
  public String getName()
  {
    return NAME;
  }
  
  public int getPlatformId()
  {
    return 22;
  }
  
  public int getVersion()
  {
    return 1;
  }
  
  public boolean hasShareCallback()
  {
    return !this.c;
  }
  
  protected void initDevInfo(String paramString)
  {
    this.a = getDevinfo("AppId");
    this.b = getDevinfo("AppSecret");
    this.c = "true".equals(getDevinfo("BypassApproval"));
    if (TextUtils.isEmpty(getDevinfo("UserName"))) {
      paramString = getDevinfo("userName");
    }
    for (;;)
    {
      this.d = paramString;
      if (TextUtils.isEmpty(getDevinfo("Path")))
      {
        paramString = getDevinfo("path");
        this.e = paramString;
        this.f = "true".equals(getDevinfo("WithShareTicket"));
      }
      try
      {
        this.g = Integer.valueOf(getDevinfo("MiniprogramType")).intValue();
        if ((this.a == null) || (this.a.length() <= 0))
        {
          this.a = getDevinfo("WechatMoments", "AppId");
          this.c = "true".equals(getDevinfo("WechatMoments", "BypassApproval"));
          if ((this.a != null) && (this.a.length() > 0))
          {
            copyDevinfo("WechatMoments", NAME);
            this.a = getDevinfo("AppId");
            this.c = "true".equals(getDevinfo("BypassApproval"));
            e.b().d("Try to use the dev info of WechatMoments, this will cause Id and SortId field are always 0.", new Object[0]);
          }
        }
        else
        {
          return;
          paramString = getDevinfo("UserName");
          continue;
          paramString = getDevinfo("Path");
        }
      }
      catch (Throwable paramString)
      {
        do
        {
          for (;;)
          {
            this.g = 0;
          }
          this.a = getDevinfo("WechatFavorite", "AppId");
        } while ((this.a == null) || (this.a.length() <= 0));
        copyDevinfo("WechatFavorite", NAME);
        this.a = getDevinfo("AppId");
        e.b().d("Try to use the dev info of WechatFavorite, this will cause Id and SortId field are always 0.", new Object[0]);
      }
    }
  }
  
  public boolean isClientValid()
  {
    k localk = k.a();
    localk.c(this.a);
    return localk.c();
  }
  
  protected void setNetworkDevinfo()
  {
    this.a = getNetworkDevinfo("app_id", "AppId");
    this.b = getNetworkDevinfo("app_secret", "AppSecret");
    if ((this.a == null) || (this.a.length() <= 0))
    {
      this.a = getNetworkDevinfo(23, "app_id", "AppId");
      if ((this.a != null) && (this.a.length() > 0))
      {
        copyNetworkDevinfo(23, 22);
        this.a = getNetworkDevinfo("app_id", "AppId");
        e.b().d("Try to use the dev info of WechatMoments, this will cause Id and SortId field are always 0.", new Object[0]);
      }
    }
    else if ((this.b == null) || (this.b.length() <= 0))
    {
      this.b = getNetworkDevinfo(23, "app_secret", "AppSecret");
      if ((this.b == null) || (this.b.length() <= 0)) {
        break label273;
      }
      copyNetworkDevinfo(23, 22);
      this.b = getNetworkDevinfo("app_secret", "AppSecret");
      e.b().d("Try to use the dev info of WechatMoments, this will cause Id and SortId field are always 0.", new Object[0]);
    }
    label273:
    do
    {
      return;
      this.a = getNetworkDevinfo(37, "app_id", "AppId");
      if ((this.a == null) || (this.a.length() <= 0)) {
        break;
      }
      copyNetworkDevinfo(37, 22);
      this.a = getNetworkDevinfo("app_id", "AppId");
      e.b().d("Try to use the dev info of WechatFavorite, this will cause Id and SortId field are always 0.", new Object[0]);
      break;
      this.b = getNetworkDevinfo(37, "app_secret", "AppSecret");
    } while ((this.b == null) || (this.b.length() <= 0));
    copyNetworkDevinfo(37, 22);
    this.b = getNetworkDevinfo("app_secret", "AppSecret");
    e.b().d("Try to use the dev info of WechatFavorite, this will cause Id and SortId field are always 0.", new Object[0]);
  }
  
  protected void timeline(int paramInt1, int paramInt2, String paramString)
  {
    if (this.listener != null) {
      this.listener.onCancel(this, 7);
    }
  }
  
  protected void userInfor(String paramString)
  {
    if ((TextUtils.isEmpty(this.a)) || (TextUtils.isEmpty(this.b))) {
      if (this.listener != null) {
        this.listener.onError(this, 8, new Throwable("The params of appID or appSecret is missing !"));
      }
    }
    do
    {
      return;
      paramString = new g(this, 22);
      paramString.a(this.a, this.b);
      try
      {
        paramString.a(this.listener);
        return;
      }
      catch (Throwable paramString)
      {
        e.b().d(paramString);
      }
    } while (this.listener == null);
    this.listener.onError(this, 8, paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/wechat/friends/Wechat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */