package cn.sharesdk.wechat.favorite;

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
import cn.sharesdk.wechat.utils.WechatTimelineNotSupportedException;
import cn.sharesdk.wechat.utils.g;
import cn.sharesdk.wechat.utils.j;
import cn.sharesdk.wechat.utils.k;
import com.mob.tools.log.NLog;
import java.util.ArrayList;
import java.util.HashMap;

public class WechatFavorite
  extends Platform
{
  public static final String NAME = WechatFavorite.class.getSimpleName();
  private String a;
  private String b;
  
  private boolean c()
  {
    boolean bool = false;
    if (!TextUtils.isEmpty(getDb().get("refresh_token")))
    {
      g localg = new g(this, 37);
      localg.a(this.a, this.b);
      bool = localg.a();
    }
    return bool;
  }
  
  protected boolean checkAuthorize(int paramInt, Object paramObject)
  {
    k localk = k.a();
    localk.c(this.a);
    if (!localk.c()) {
      if (this.listener != null) {
        this.listener.onError(this, paramInt, new WechatClientNotExistException());
      }
    }
    do
    {
      return false;
      if (localk.d()) {
        break;
      }
    } while (this.listener == null);
    this.listener.onError(this, 1, new WechatTimelineNotSupportedException());
    return false;
    if ((paramInt == 9) || (isAuthValid()) || (c())) {
      return true;
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
        if (paramArrayOfString.d()) {
          break;
        }
      } while (this.listener == null);
      this.listener.onError(this, 1, new WechatTimelineNotSupportedException());
      return;
      g localg = new g(this, 37);
      localg.a(this.a, this.b);
      j localj = new j(this);
      localj.a(localg);
      localj.a(new AuthorizeListener()
      {
        public void onCancel()
        {
          if (WechatFavorite.c(WechatFavorite.this) != null) {
            WechatFavorite.d(WechatFavorite.this).onCancel(WechatFavorite.this, 1);
          }
        }
        
        public void onComplete(Bundle paramAnonymousBundle)
        {
          WechatFavorite.a(WechatFavorite.this, 1, null);
        }
        
        public void onError(Throwable paramAnonymousThrowable)
        {
          if (WechatFavorite.a(WechatFavorite.this) != null) {
            WechatFavorite.b(WechatFavorite.this).onError(WechatFavorite.this, 1, paramAnonymousThrowable);
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
    paramShareParams.set("scene", Integer.valueOf(2));
    k localk = k.a();
    localk.c(this.a);
    j localj = new j(this);
    localj.a(paramShareParams, this.listener);
    try
    {
      localk.b(localj);
      return;
    }
    catch (Throwable paramShareParams)
    {
      while (this.listener == null) {}
      this.listener.onError(this, 9, paramShareParams);
    }
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
    return 37;
  }
  
  public int getVersion()
  {
    return 1;
  }
  
  public boolean hasShareCallback()
  {
    return false;
  }
  
  protected void initDevInfo(String paramString)
  {
    this.a = getDevinfo("AppId");
    this.b = getDevinfo("AppSecret");
    if ((this.a == null) || (this.a.length() <= 0))
    {
      this.a = getDevinfo("Wechat", "AppId");
      if ((this.a == null) || (this.a.length() <= 0)) {
        break label100;
      }
      copyDevinfo("Wechat", NAME);
      this.a = getDevinfo("AppId");
      e.b().d("Try to use the dev info of Wechat, this will cause Id and SortId field are always 0.", new Object[0]);
    }
    label100:
    do
    {
      return;
      this.a = getDevinfo("WechatMoments", "AppId");
    } while ((this.a == null) || (this.a.length() <= 0));
    copyDevinfo("WechatMoments", NAME);
    this.a = getDevinfo("AppId");
    e.b().d("Try to use the dev info of WechatMoments, this will cause Id and SortId field are always 0.", new Object[0]);
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
      this.a = getNetworkDevinfo(22, "app_id", "AppId");
      if ((this.a != null) && (this.a.length() > 0))
      {
        copyNetworkDevinfo(22, 37);
        this.a = getNetworkDevinfo("app_id", "AppId");
        e.b().d("Try to use the dev info of Wechat, this will cause Id and SortId field are always 0.", new Object[0]);
      }
    }
    else if ((this.b == null) || (this.b.length() <= 0))
    {
      this.b = getNetworkDevinfo(22, "app_secret", "AppSecret");
      if ((this.b == null) || (this.b.length() <= 0)) {
        break label265;
      }
      copyNetworkDevinfo(22, 37);
      this.b = getNetworkDevinfo("app_secret", "AppSecret");
      e.b().d("Try to use the dev info of Wechat, this will cause Id and SortId field are always 0.", new Object[0]);
    }
    label265:
    do
    {
      return;
      this.a = getNetworkDevinfo(23, "app_id", "AppId");
      if ((this.a == null) || (this.a.length() <= 0)) {
        break;
      }
      copyNetworkDevinfo(23, 37);
      this.a = getNetworkDevinfo("app_id", "AppId");
      e.b().d("Try to use the dev info of WechatMoments, this will cause Id and SortId field are always 0.", new Object[0]);
      break;
      this.b = getNetworkDevinfo(23, "app_secret", "AppSecret");
    } while ((this.b == null) || (this.b.length() <= 0));
    copyNetworkDevinfo(23, 37);
    this.b = getNetworkDevinfo("app_secret", "AppSecret");
    e.b().d("Try to use the dev info of WechatMoments, this will cause Id and SortId field are always 0.", new Object[0]);
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
      paramString = new g(this, 37);
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


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/wechat/favorite/WechatFavorite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */