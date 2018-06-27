package cn.sharesdk.tencent.qq;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.b.b.f.a;
import cn.sharesdk.framework.utils.e;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.HashMap;

public class QQ
  extends Platform
{
  public static final String NAME = QQ.class.getSimpleName();
  private String a;
  private boolean b;
  private boolean c = true;
  private boolean d;
  
  protected boolean checkAuthorize(int paramInt, Object paramObject)
  {
    b localb = b.a(this);
    if ((localb.b()) && (this.d) && (paramInt == 9)) {
      return true;
    }
    if ((isAuthValid()) || ((paramInt == 9) && (paramObject != null) && ((paramObject instanceof Platform.ShareParams)) && (!((Platform.ShareParams)paramObject).isShareTencentWeibo())))
    {
      localb.a(this.a);
      localb.b(this.db.getUserId());
      localb.d(this.db.getToken());
      return true;
    }
    innerAuthorize(paramInt, paramObject);
    return false;
  }
  
  protected void doAuthorize(String[] paramArrayOfString)
  {
    final b localb = b.a(this);
    localb.a(this.a);
    localb.a(paramArrayOfString);
    localb.a(new AuthorizeListener()
    {
      public void onCancel()
      {
        if (QQ.j(QQ.this) != null) {
          QQ.k(QQ.this).onCancel(QQ.this, 1);
        }
      }
      
      public void onComplete(Bundle paramAnonymousBundle)
      {
        String str1 = paramAnonymousBundle.getString("open_id");
        String str2 = paramAnonymousBundle.getString("access_token");
        String str3 = paramAnonymousBundle.getString("expires_in");
        QQ.c(QQ.this).putToken(str2);
        QQ.d(QQ.this).putTokenSecret("");
        try
        {
          QQ.e(QQ.this).putExpiresIn(ResHelper.parseLong(str3));
          QQ.f(QQ.this).putUserId(str1);
          str3 = paramAnonymousBundle.getString("pf");
          String str4 = paramAnonymousBundle.getString("pfkey");
          paramAnonymousBundle = paramAnonymousBundle.getString("pay_token");
          QQ.g(QQ.this).put("pf", str3);
          QQ.h(QQ.this).put("pfkey", str4);
          QQ.i(QQ.this).put("pay_token", paramAnonymousBundle);
          localb.b(str1);
          localb.d(str2);
          localb.a();
          QQ.a(QQ.this, 1, null);
          return;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            e.b().w(localThrowable);
          }
        }
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        if (QQ.a(QQ.this) != null) {
          QQ.b(QQ.this).onError(QQ.this, 1, paramAnonymousThrowable);
        }
      }
    }, isSSODisable());
  }
  
  protected void doCustomerProtocol(String paramString1, String paramString2, int paramInt, HashMap<String, Object> paramHashMap, HashMap<String, String> paramHashMap1)
  {
    if (this.listener != null) {
      this.listener.onCancel(this, paramInt);
    }
  }
  
  protected void doShare(final Platform.ShareParams paramShareParams)
  {
    b localb = b.a(this);
    if ((this.d) && (localb.b())) {}
    String str4;
    String str3;
    String str5;
    String str6;
    String str7;
    boolean bool;
    int i;
    do
    {
      try
      {
        localb.a(this, paramShareParams, this.listener);
        return;
      }
      catch (Throwable paramShareParams)
      {
        while (this.listener == null) {}
        this.listener.onError(this, 9, paramShareParams);
        return;
      }
      str4 = paramShareParams.getTitle();
      str3 = paramShareParams.getText();
      str5 = paramShareParams.getImagePath();
      str6 = paramShareParams.getImageUrl();
      str7 = paramShareParams.getMusicUrl();
      str2 = paramShareParams.getTitleUrl();
      bool = paramShareParams.isShareTencentWeibo();
      i = paramShareParams.getHidden();
      if ((!TextUtils.isEmpty(str4)) || (!TextUtils.isEmpty(str3)) || (!TextUtils.isEmpty(str5)) || (!TextUtils.isEmpty(str6)) || (!TextUtils.isEmpty(str7))) {
        break;
      }
    } while (this.listener == null);
    this.listener.onError(this, 9, new Throwable("qq share must have one param at least"));
    return;
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = getShortLintk(str2, false);
      paramShareParams.setTitleUrl(str1);
    }
    String str2 = str3;
    if (!TextUtils.isEmpty(str3))
    {
      str2 = getShortLintk(str3, false);
      paramShareParams.setText(str2);
    }
    paramShareParams = new PlatformActionListener()
    {
      public void onCancel(Platform paramAnonymousPlatform, int paramAnonymousInt)
      {
        if (QQ.p(QQ.this) != null) {
          QQ.q(QQ.this).onCancel(QQ.this, 9);
        }
      }
      
      public void onComplete(Platform paramAnonymousPlatform, int paramAnonymousInt, HashMap<String, Object> paramAnonymousHashMap)
      {
        paramAnonymousPlatform = new HashMap();
        if (paramAnonymousHashMap != null) {
          paramAnonymousPlatform.putAll(paramAnonymousHashMap);
        }
        paramAnonymousPlatform.put("ShareParams", paramShareParams);
        if (QQ.n(QQ.this) != null) {
          QQ.o(QQ.this).onComplete(QQ.this, 9, paramAnonymousPlatform);
        }
      }
      
      public void onError(Platform paramAnonymousPlatform, int paramAnonymousInt, Throwable paramAnonymousThrowable)
      {
        if (QQ.l(QQ.this) != null) {
          QQ.m(QQ.this).onError(QQ.this, 9, paramAnonymousThrowable);
        }
      }
    };
    localb.a(str4, str1, str2, str5, str6, str7, this.b, paramShareParams, bool, i);
  }
  
  protected HashMap<String, Object> filterFriendshipInfo(int paramInt, HashMap<String, Object> paramHashMap)
  {
    return null;
  }
  
  protected f.a filterShareContent(Platform.ShareParams paramShareParams, HashMap<String, Object> paramHashMap)
  {
    paramHashMap = new f.a();
    String str1 = paramShareParams.getTitleUrl();
    paramHashMap.c.add(str1);
    paramHashMap.a = this.a;
    String str2 = paramShareParams.getText();
    if (!TextUtils.isEmpty(str2)) {
      paramHashMap.b = str2;
    }
    Object localObject = paramShareParams.getImageUrl();
    String str3 = paramShareParams.getImagePath();
    if (!TextUtils.isEmpty(str3)) {
      paramHashMap.e.add(str3);
    }
    for (;;)
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("title", paramShareParams.getTitle());
      ((HashMap)localObject).put("url", str1);
      ((HashMap)localObject).put("imageLocalUrl", str3);
      ((HashMap)localObject).put("summary", str2);
      ((HashMap)localObject).put("appName", DeviceHelper.getInstance(MobSDK.getContext()).getAppName());
      paramHashMap.g = ((HashMap)localObject);
      return paramHashMap;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramHashMap.d.add(localObject);
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
    return 24;
  }
  
  public int getVersion()
  {
    return 2;
  }
  
  public boolean hasShareCallback()
  {
    return this.c;
  }
  
  protected void initDevInfo(String paramString)
  {
    this.a = getDevinfo("AppId");
    this.b = "true".equals(getDevinfo("ShareByAppClient"));
    this.d = "true".equals(getDevinfo("BypassApproval"));
    if ((this.a == null) || (this.a.length() <= 0))
    {
      this.a = getDevinfo("QZone", "AppId");
      if ((this.a != null) && (this.a.length() > 0))
      {
        copyDevinfo("QZone", NAME);
        this.a = getDevinfo("AppId");
        this.b = "true".equals(getDevinfo("ShareByAppClient"));
        e.b().d("Try to use the dev info of QZone, this will cause Id and SortId field are always 0.", new Object[0]);
      }
    }
  }
  
  public boolean isClientValid()
  {
    b localb = b.a(this);
    localb.a(this.a);
    return localb.b();
  }
  
  protected void setNetworkDevinfo()
  {
    this.a = getNetworkDevinfo("app_id", "AppId");
    if ((this.a == null) || (this.a.length() <= 0))
    {
      this.a = getNetworkDevinfo(6, "app_id", "AppId");
      if ((this.a != null) && (this.a.length() > 0))
      {
        copyNetworkDevinfo(6, 24);
        this.a = getNetworkDevinfo("app_id", "AppId");
        e.b().d("Try to use the dev info of QZone, this will cause Id and SortId field are always 0.", new Object[0]);
      }
    }
  }
  
  protected void timeline(int paramInt1, int paramInt2, String paramString)
  {
    if (this.listener != null) {
      this.listener.onCancel(this, 7);
    }
  }
  
  protected String uploadImageToFileServer(String paramString)
  {
    return super.uploadImageToFileServer(paramString);
  }
  
  protected void userInfor(String paramString)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() >= 0) {}
    }
    else
    {
      str = this.db.getUserId();
    }
    if ((str == null) || (str.length() < 0)) {
      if (this.listener != null) {
        this.listener.onError(this, 8, new RuntimeException("qq account is null"));
      }
    }
    label138:
    label323:
    label463:
    label496:
    label562:
    label607:
    for (;;)
    {
      return;
      paramString = b.a(this);
      try
      {
        paramString = paramString.e(str);
        if ((paramString != null) && (paramString.size() > 0)) {
          break label138;
        }
        if (this.listener == null) {
          continue;
        }
        this.listener.onError(this, 8, new Throwable());
        return;
      }
      catch (Throwable paramString) {}
      if (this.listener != null)
      {
        this.listener.onError(this, 8, paramString);
        return;
        if (!paramString.containsKey("ret"))
        {
          if (this.listener != null) {
            this.listener.onError(this, 8, new Throwable());
          }
        }
        else if (((Integer)paramString.get("ret")).intValue() != 0)
        {
          if (this.listener != null)
          {
            paramString = new Hashon().fromHashMap(paramString);
            this.listener.onError(this, 8, new Throwable(paramString));
          }
        }
        else
        {
          int j;
          if (str == this.db.getUserId())
          {
            this.db.put("nickname", String.valueOf(paramString.get("nickname")));
            if (!paramString.containsKey("figureurl_qq_2")) {
              break label463;
            }
            this.db.put("icon", String.valueOf(paramString.get("figureurl_qq_2")));
            if (!paramString.containsKey("figureurl_2")) {
              break label496;
            }
            this.db.put("iconQzone", String.valueOf(paramString.get("figureurl_2")));
            this.db.put("secretType", String.valueOf(paramString.get("is_yellow_vip")));
            if (String.valueOf(paramString.get("is_yellow_vip")).equals("1")) {
              this.db.put("snsUserLevel", String.valueOf(paramString.get("level")));
            }
            str = String.valueOf(paramString.get("gender"));
            int i = ResHelper.getStringRes(MobSDK.getContext(), "ssdk_gender_male");
            j = ResHelper.getStringRes(MobSDK.getContext(), "ssdk_gender_female");
            if (!str.equals(MobSDK.getContext().getString(i))) {
              break label562;
            }
            this.db.put("gender", "0");
          }
          for (;;)
          {
            if (this.listener == null) {
              break label607;
            }
            this.listener.onComplete(this, 8, paramString);
            return;
            if (!paramString.containsKey("figureurl_qq_1")) {
              break;
            }
            this.db.put("icon", String.valueOf(paramString.get("figureurl_qq_1")));
            break;
            if (paramString.containsKey("figureurl_1"))
            {
              this.db.put("iconQzone", String.valueOf(paramString.get("figureurl_1")));
              break label323;
            }
            if (!paramString.containsKey("figureurl")) {
              break label323;
            }
            this.db.put("iconQzone", String.valueOf(paramString.get("figureurl")));
            break label323;
            if (str.equals(MobSDK.getContext().getString(j))) {
              this.db.put("gender", "1");
            } else {
              this.db.put("gender", "2");
            }
          }
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/tencent/qq/QQ.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */