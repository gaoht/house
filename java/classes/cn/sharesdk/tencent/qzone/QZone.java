package cn.sharesdk.tencent.qzone;

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
import cn.sharesdk.framework.utils.f;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class QZone
  extends Platform
{
  public static final String NAME = QZone.class.getSimpleName();
  private String a;
  private boolean b;
  
  private void a(Platform.ShareParams paramShareParams)
    throws Throwable
  {
    Object localObject = new f();
    ((f)localObject).a("com.qzone", "com.qzonex.module.operation.ui.QZonePublishMoodActivity");
    ((f)localObject).a(paramShareParams, this);
    localObject = new HashMap();
    ((HashMap)localObject).put("ShareParams", paramShareParams);
    this.listener.onComplete(this, 9, (HashMap)localObject);
  }
  
  private void b(final Platform.ShareParams paramShareParams)
  {
    String str = paramShareParams.getImageUrl();
    Object localObject = paramShareParams.getImagePath();
    boolean bool = paramShareParams.isShareTencentWeibo();
    try
    {
      if ((TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str)))
      {
        paramShareParams.setImagePath(BitmapHelper.downloadBitmap(MobSDK.getContext(), str));
        doShare(paramShareParams);
        return;
      }
      if (!isAuthValid())
      {
        setPlatformActionListener(new PlatformActionListener()
        {
          public void onCancel(Platform paramAnonymousPlatform, int paramAnonymousInt)
          {
            if (this.a != null) {
              this.a.onCancel(paramAnonymousPlatform, 9);
            }
          }
          
          public void onComplete(Platform paramAnonymousPlatform, int paramAnonymousInt, HashMap<String, Object> paramAnonymousHashMap)
          {
            QZone.this.setPlatformActionListener(this.a);
            QZone.this.doShare(paramShareParams);
          }
          
          public void onError(Platform paramAnonymousPlatform, int paramAnonymousInt, Throwable paramAnonymousThrowable)
          {
            if (this.a != null) {
              this.a.onError(paramAnonymousPlatform, 9, paramAnonymousThrowable);
            }
          }
        });
        authorize();
        return;
      }
    }
    catch (Throwable paramShareParams)
    {
      if (this.listener != null)
      {
        this.listener.onError(this, 9, paramShareParams);
        return;
        str = paramShareParams.getText();
        if (TextUtils.isEmpty(str))
        {
          if (this.listener != null) {
            this.listener.onError(this, 9, new Throwable("share params' value of text is empty!"));
          }
        }
        else
        {
          str = getShortLintk(str, false);
          paramShareParams.setText(str);
          b localb = b.a(this);
          if (bool) {}
          for (localObject = localb.b((String)localObject, str);; localObject = localb.a((String)localObject, str))
          {
            if ((localObject == null) && (this.listener != null)) {
              this.listener.onError(this, 9, new Throwable("response is empty"));
            }
            ((HashMap)localObject).put("ShareParams", paramShareParams);
            if (this.listener == null) {
              break;
            }
            this.listener.onComplete(this, 9, (HashMap)localObject);
            return;
          }
        }
      }
    }
  }
  
  private void c(final Platform.ShareParams paramShareParams)
  {
    try
    {
      localObject1 = paramShareParams.getImageUrl();
      localObject2 = paramShareParams.getImagePath();
      if (!isClientValid()) {
        break label162;
      }
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!new File((String)localObject2).exists())) {
        break label211;
      }
      localObject1 = localObject2;
    }
    catch (Throwable paramShareParams)
    {
      Object localObject1;
      Object localObject2;
      String str3;
      String str2;
      String str4;
      String str1;
      String str5;
      int i;
      label162:
      label211:
      while (this.listener != null)
      {
        this.listener.onError(this, 9, paramShareParams);
        return;
      }
    }
    str3 = paramShareParams.getTitle();
    str2 = paramShareParams.getTitleUrl();
    str4 = paramShareParams.getSite();
    str1 = paramShareParams.getText();
    str5 = paramShareParams.getFilePath();
    i = paramShareParams.getShareType();
    localObject2 = str1;
    if (!TextUtils.isEmpty(str1))
    {
      localObject2 = getShortLintk(str1, false);
      paramShareParams.setText((String)localObject2);
    }
    str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = getShortLintk(str2, false);
      paramShareParams.setTitleUrl(str1);
    }
    b.a(this).a(i, str3, str1, (String)localObject2, (String)localObject1, str4, str5, new PlatformActionListener()
    {
      public void onCancel(Platform paramAnonymousPlatform, int paramAnonymousInt)
      {
        if (QZone.p(QZone.this) != null) {
          QZone.q(QZone.this).onCancel(QZone.this, 9);
        }
      }
      
      public void onComplete(Platform paramAnonymousPlatform, int paramAnonymousInt, HashMap<String, Object> paramAnonymousHashMap)
      {
        if (QZone.n(QZone.this) != null)
        {
          paramAnonymousHashMap.put("ShareParams", paramShareParams);
          QZone.o(QZone.this).onComplete(QZone.this, 9, paramAnonymousHashMap);
        }
      }
      
      public void onError(Platform paramAnonymousPlatform, int paramAnonymousInt, Throwable paramAnonymousThrowable)
      {
        if (QZone.l(QZone.this) != null) {
          QZone.m(QZone.this).onError(QZone.this, 9, paramAnonymousThrowable);
        }
      }
    });
    return;
    if (this.listener != null)
    {
      this.listener.onError(this, 9, new QQClientNotExistException());
      return;
    }
  }
  
  protected boolean checkAuthorize(int paramInt, Object paramObject)
  {
    b localb = b.a(this);
    if ((localb.b()) && (this.b) && (paramInt == 9)) {
      return true;
    }
    if ((isAuthValid()) || (paramInt == 9))
    {
      localb.a(this.a);
      localb.b(this.db.getUserId());
      localb.c(this.db.getToken());
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
        if (QZone.j(QZone.this) != null) {
          QZone.k(QZone.this).onCancel(QZone.this, 1);
        }
      }
      
      public void onComplete(Bundle paramAnonymousBundle)
      {
        String str1 = paramAnonymousBundle.getString("open_id");
        String str2 = paramAnonymousBundle.getString("access_token");
        String str3 = paramAnonymousBundle.getString("expires_in");
        QZone.c(QZone.this).putToken(str2);
        QZone.d(QZone.this).putTokenSecret("");
        try
        {
          QZone.e(QZone.this).putExpiresIn(ResHelper.parseLong(str3));
          QZone.f(QZone.this).putUserId(str1);
          str3 = paramAnonymousBundle.getString("pf");
          String str4 = paramAnonymousBundle.getString("pfkey");
          paramAnonymousBundle = paramAnonymousBundle.getString("pay_token");
          QZone.g(QZone.this).put("pf", str3);
          QZone.h(QZone.this).put("pfkey", str4);
          QZone.i(QZone.this).put("pay_token", paramAnonymousBundle);
          localb.b(str1);
          localb.c(str2);
          localb.a();
          QZone.a(QZone.this, 1, null);
          return;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            e.b().d(localThrowable);
          }
        }
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        if (QZone.a(QZone.this) != null) {
          QZone.b(QZone.this).onError(QZone.this, 1, paramAnonymousThrowable);
        }
      }
    }, isSSODisable());
  }
  
  protected void doCustomerProtocol(String paramString1, String paramString2, int paramInt, HashMap<String, Object> paramHashMap, HashMap<String, String> paramHashMap1)
  {
    paramString1 = b.a(this).a(paramString1, paramString2, paramHashMap, paramHashMap1);
    if ((paramString1 == null) || (paramString1.size() <= 0)) {
      if (this.listener != null) {
        this.listener.onError(this, paramInt, new Throwable());
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramString1.containsKey("ret")) {
            break;
          }
        } while (this.listener == null);
        this.listener.onError(this, paramInt, new Throwable());
        return;
        if (((Integer)paramString1.get("ret")).intValue() == 0) {
          break;
        }
      } while (this.listener == null);
      paramString1 = new Hashon().fromHashMap(paramString1);
      this.listener.onError(this, paramInt, new Throwable(paramString1));
      return;
    } while (this.listener == null);
    this.listener.onComplete(this, paramInt, paramString1);
  }
  
  protected void doShare(Platform.ShareParams paramShareParams)
  {
    if ((b.a(this).b()) && (this.b)) {
      try
      {
        a(paramShareParams);
        return;
      }
      catch (Throwable paramShareParams)
      {
        while (this.listener == null) {}
        this.listener.onError(this, 9, paramShareParams);
        return;
      }
    }
    if (paramShareParams.isShareTencentWeibo())
    {
      b(paramShareParams);
      return;
    }
    c(paramShareParams);
  }
  
  protected HashMap<String, Object> filterFriendshipInfo(int paramInt, HashMap<String, Object> paramHashMap)
  {
    return null;
  }
  
  protected f.a filterShareContent(Platform.ShareParams paramShareParams, HashMap<String, Object> paramHashMap)
  {
    f.a locala = new f.a();
    locala.b = paramShareParams.getText();
    String str1 = paramShareParams.getImageUrl();
    String str2 = paramShareParams.getImagePath();
    if (str2 != null) {
      locala.e.add(str2);
    }
    for (;;)
    {
      paramHashMap = paramShareParams.getTitleUrl();
      if (paramHashMap != null) {
        locala.c.add(paramHashMap);
      }
      paramHashMap = new HashMap();
      paramHashMap.put("title", paramShareParams.getTitle());
      paramHashMap.put("titleUrl", paramShareParams.getTitleUrl());
      paramHashMap.put("site", paramShareParams.getSite());
      locala.g = paramHashMap;
      return locala;
      if (paramHashMap.get("large_url") != null) {
        locala.d.add(String.valueOf(paramHashMap.get("large_url")));
      } else if (paramHashMap.get("small_url") != null) {
        locala.d.add(String.valueOf(paramHashMap.get("small_url")));
      } else if (str1 != null) {
        locala.d.add(str1);
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
    return 6;
  }
  
  public int getVersion()
  {
    return 2;
  }
  
  public boolean hasShareCallback()
  {
    return true;
  }
  
  protected void initDevInfo(String paramString)
  {
    this.a = getDevinfo("AppId");
    this.b = "true".equals(getDevinfo("BypassApproval"));
    if ((this.a == null) || (this.a.length() <= 0))
    {
      this.a = getDevinfo("QQ", "AppId");
      if ((this.a != null) && (this.a.length() > 0))
      {
        copyDevinfo("QQ", NAME);
        this.a = getDevinfo("AppId");
        e.b().d("Try to use the dev info of QQ, this will cause Id and SortId field are always 0.", new Object[0]);
      }
    }
  }
  
  public boolean isClientValid()
  {
    b localb = b.a(this);
    localb.a(this.a);
    return localb.d();
  }
  
  protected void setNetworkDevinfo()
  {
    this.a = getNetworkDevinfo("app_id", "AppId");
    if ((this.a == null) || (this.a.length() <= 0))
    {
      this.a = getNetworkDevinfo(24, "app_id", "AppId");
      if ((this.a != null) && (this.a.length() > 0))
      {
        copyNetworkDevinfo(24, 6);
        this.a = getNetworkDevinfo("app_id", "AppId");
        e.b().d("Try to use the dev info of QQ, this will cause Id and SortId field are always 0.", new Object[0]);
      }
    }
  }
  
  protected void timeline(int paramInt1, int paramInt2, String paramString)
  {
    if (this.listener != null) {
      this.listener.onCancel(this, 7);
    }
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
        paramString = paramString.d(str);
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
            this.db.put("iconQQ", String.valueOf(paramString.get("figureurl_qq_2")));
            if (!paramString.containsKey("figureurl_2")) {
              break label496;
            }
            this.db.put("icon", String.valueOf(paramString.get("figureurl_2")));
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
            this.db.put("iconQQ", String.valueOf(paramString.get("figureurl_qq_1")));
            break;
            if (paramString.containsKey("figureurl_1"))
            {
              this.db.put("icon", String.valueOf(paramString.get("figureurl_1")));
              break label323;
            }
            if (!paramString.containsKey("figureurl")) {
              break label323;
            }
            this.db.put("icon", String.valueOf(paramString.get("figureurl")));
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


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/tencent/qzone/QZone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */