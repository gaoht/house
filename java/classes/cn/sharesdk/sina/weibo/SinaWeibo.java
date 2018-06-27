package cn.sharesdk.sina.weibo;

import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.b.b.f.a;
import cn.sharesdk.framework.utils.e;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class SinaWeibo
  extends Platform
{
  public static final String NAME = SinaWeibo.class.getSimpleName();
  private String a;
  private String b;
  private String c;
  private boolean d;
  
  private boolean c()
  {
    boolean bool = false;
    if (!TextUtils.isEmpty(getDb().get("refresh_token")))
    {
      f localf = f.a(this);
      localf.a(this.a, this.b);
      localf.a(this.c);
      bool = localf.a();
    }
    return bool;
  }
  
  protected boolean checkAuthorize(int paramInt, Object paramObject)
  {
    f localf = f.a(this);
    localf.c(this.db.getToken());
    localf.a(this.a, this.b);
    localf.a(this.c);
    localf.d();
    if (paramInt == 9) {}
    while ((isAuthValid()) || (c())) {
      return true;
    }
    innerAuthorize(paramInt, paramObject);
    return false;
  }
  
  protected void doAuthorize(String[] paramArrayOfString)
  {
    final f localf = f.a(this);
    localf.a(this.a, this.b);
    localf.a(this.c);
    localf.a(paramArrayOfString);
    localf.a(new AuthorizeListener()
    {
      public void onCancel()
      {
        if (SinaWeibo.i(SinaWeibo.this) != null) {
          SinaWeibo.j(SinaWeibo.this).onCancel(SinaWeibo.this, 1);
        }
      }
      
      public void onComplete(Bundle paramAnonymousBundle)
      {
        String str1 = paramAnonymousBundle.getString("uid");
        String str2 = paramAnonymousBundle.getString("access_token");
        String str4 = paramAnonymousBundle.getString("expires_in");
        String str3 = paramAnonymousBundle.getString("refresh_token");
        if (paramAnonymousBundle.containsKey("username")) {
          SinaWeibo.a(SinaWeibo.this).put("nickname", paramAnonymousBundle.getString("userName"));
        }
        SinaWeibo.b(SinaWeibo.this).put("remind_in", paramAnonymousBundle.getString("remind_in"));
        SinaWeibo.c(SinaWeibo.this).putToken(str2);
        try
        {
          l = ResHelper.parseLong(str4);
          SinaWeibo.d(SinaWeibo.this).putExpiresIn(l);
          SinaWeibo.e(SinaWeibo.this).put("refresh_token", str3);
          SinaWeibo.f(SinaWeibo.this).putUserId(str1);
          localf.c(str2);
          SinaWeibo.a(SinaWeibo.this, 1, null);
          return;
        }
        catch (Throwable paramAnonymousBundle)
        {
          for (;;)
          {
            long l = 0L;
          }
        }
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        if (SinaWeibo.g(SinaWeibo.this) != null) {
          SinaWeibo.h(SinaWeibo.this).onError(SinaWeibo.this, 1, paramAnonymousThrowable);
        }
      }
    }, isSSODisable());
  }
  
  protected void doCustomerProtocol(String paramString1, String paramString2, int paramInt, HashMap<String, Object> paramHashMap, HashMap<String, String> paramHashMap1)
  {
    try
    {
      paramString1 = f.a(this).a(paramString1, paramString2, paramHashMap, paramHashMap1);
      if ((paramString1 == null) || (paramString1.size() <= 0))
      {
        if (this.listener == null) {
          return;
        }
        this.listener.onError(this, paramInt, new Throwable());
        return;
      }
      if ((paramString1.containsKey("error_code")) && (((Integer)paramString1.get("error_code")).intValue() != 0))
      {
        if (this.listener == null) {
          return;
        }
        paramString1 = new Hashon().fromHashMap(paramString1);
        this.listener.onError(this, paramInt, new Throwable(paramString1));
        return;
      }
    }
    catch (Throwable paramString1)
    {
      this.listener.onError(this, paramInt, paramString1);
      return;
    }
    if (this.listener != null) {
      this.listener.onComplete(this, paramInt, paramString1);
    }
  }
  
  protected void doShare(Platform.ShareParams paramShareParams)
  {
    f localf = f.a(this);
    localf.a(this.a, this.b);
    if ((this.d) && (localf.b())) {
      try
      {
        localf.a(paramShareParams, this.listener);
        return;
      }
      catch (Throwable paramShareParams)
      {
        this.listener.onError(this, 9, paramShareParams);
        return;
      }
    }
    try
    {
      localf.b(paramShareParams, this.listener);
      return;
    }
    catch (Throwable paramShareParams)
    {
      this.listener.onError(this, 9, paramShareParams);
    }
  }
  
  protected HashMap<String, Object> filterFriendshipInfo(int paramInt, HashMap<String, Object> paramHashMap)
  {
    HashMap localHashMap1 = new HashMap();
    switch (paramInt)
    {
    default: 
      return null;
    case 2: 
      localHashMap1.put("type", "FOLLOWING");
    }
    int j;
    int i;
    for (;;)
    {
      localHashMap1.put("snsplat", Integer.valueOf(getPlatformId()));
      localHashMap1.put("snsuid", this.db.getUserId());
      j = Integer.parseInt(String.valueOf(paramHashMap.get("current_cursor")));
      i = Integer.parseInt(String.valueOf(paramHashMap.get("total_number")));
      if (i != 0) {
        break;
      }
      return null;
      localHashMap1.put("type", "FOLLOWERS");
      continue;
      localHashMap1.put("type", "FRIENDS");
    }
    Object localObject = paramHashMap.get("users");
    if (localObject == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = (ArrayList)localObject;
    if (((ArrayList)localObject).size() <= 0) {
      return null;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      HashMap localHashMap2 = (HashMap)((Iterator)localObject).next();
      if (localHashMap2 != null)
      {
        HashMap localHashMap3 = new HashMap();
        localHashMap3.put("snsuid", String.valueOf(localHashMap2.get("id")));
        localHashMap3.put("nickname", String.valueOf(localHashMap2.get("screen_name")));
        localHashMap3.put("icon", String.valueOf(localHashMap2.get("avatar_hd")));
        label313:
        String str;
        if (String.valueOf(localHashMap2.get("verified")).equals("true"))
        {
          localHashMap3.put("secretType", "1");
          localHashMap3.put("secret", String.valueOf(localHashMap2.get("verified_reason")));
          str = String.valueOf(localHashMap2.get("gender"));
          if (!str.equals("m")) {
            break label540;
          }
          localHashMap3.put("gender", "0");
        }
        for (;;)
        {
          localHashMap3.put("snsUserUrl", "http://weibo.com/" + String.valueOf(localHashMap2.get("profile_url")));
          localHashMap3.put("resume", String.valueOf(localHashMap2.get("description")));
          localHashMap3.put("followerCount", String.valueOf(localHashMap2.get("followers_count")));
          localHashMap3.put("favouriteCount", String.valueOf(localHashMap2.get("friends_count")));
          localHashMap3.put("shareCount", String.valueOf(localHashMap2.get("statuses_count")));
          localHashMap3.put("snsregat", String.valueOf(ResHelper.dateToLong(String.valueOf(localHashMap2.get("created_at")))));
          localArrayList.add(localHashMap3);
          break;
          localHashMap3.put("secretType", "0");
          break label313;
          label540:
          if (str.equals("f")) {
            localHashMap3.put("gender", "1");
          } else {
            localHashMap3.put("gender", "2");
          }
        }
      }
    }
    if ((localArrayList == null) || (localArrayList.size() <= 0)) {
      return null;
    }
    if (10 == paramInt)
    {
      if (((Integer)paramHashMap.get("page_count")).intValue() * (j + 1) >= i) {}
      for (paramHashMap = j + "_true";; paramHashMap = j + 1 + "_false")
      {
        localHashMap1.put("nextCursor", paramHashMap);
        localHashMap1.put("list", localArrayList);
        return localHashMap1;
      }
    }
    paramInt = localArrayList.size() + j;
    if (paramInt >= i) {}
    for (paramHashMap = i + "_true";; paramHashMap = paramInt + "_false")
    {
      localHashMap1.put("nextCursor", paramHashMap);
      break;
    }
  }
  
  protected f.a filterShareContent(Platform.ShareParams paramShareParams, HashMap<String, Object> paramHashMap)
  {
    f.a locala = new f.a();
    locala.b = paramShareParams.getText();
    if (paramHashMap != null)
    {
      locala.a = String.valueOf(paramHashMap.get("id"));
      locala.d.add(String.valueOf(paramHashMap.get("original_pic")));
      locala.g = paramHashMap;
    }
    return locala;
  }
  
  protected void follow(String paramString)
  {
    f localf = f.a(this);
    try
    {
      paramString = localf.e(paramString);
      if (paramString == null)
      {
        if (this.listener == null) {
          return;
        }
        this.listener.onError(this, 6, new Throwable());
        return;
      }
      if ((paramString.containsKey("error_code")) && (((Integer)paramString.get("error_code")).intValue() != 0))
      {
        if (this.listener == null) {
          return;
        }
        paramString = new Hashon().fromHashMap(paramString);
        this.listener.onError(this, 6, new Throwable(paramString));
        return;
      }
    }
    catch (Throwable paramString)
    {
      this.listener.onError(this, 6, paramString);
      return;
    }
    if (this.listener != null) {
      this.listener.onComplete(this, 6, paramString);
    }
  }
  
  protected HashMap<String, Object> getBilaterals(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject = this.db.getUserId();
    }
    paramString = (String)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramString = this.db.get("nickname");
    }
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      localObject = f.a(this);
      try
      {
        paramString = ((f)localObject).c(paramInt1, paramInt2, paramString);
        if ((paramString != null) && (!paramString.containsKey("error_code")))
        {
          paramString.put("page_count", Integer.valueOf(paramInt1));
          paramString.put("current_cursor", Integer.valueOf(paramInt2));
          paramString = filterFriendshipInfo(10, paramString);
          return paramString;
        }
      }
      catch (Throwable paramString)
      {
        e.b().d(paramString);
      }
    }
    return null;
  }
  
  protected HashMap<String, Object> getFollowers(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject = this.db.getUserId();
    }
    paramString = (String)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramString = this.db.get("nickname");
    }
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      localObject = f.a(this);
      try
      {
        paramString = ((f)localObject).d(paramInt1, paramInt2, paramString);
        if ((paramString != null) && (!paramString.containsKey("error_code")))
        {
          paramString.put("current_cursor", Integer.valueOf(paramInt2));
          paramString = filterFriendshipInfo(11, paramString);
          return paramString;
        }
      }
      catch (Throwable paramString)
      {
        e.b().d(paramString);
      }
    }
    return null;
  }
  
  protected HashMap<String, Object> getFollowings(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject = this.db.getUserId();
    }
    paramString = (String)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramString = this.db.get("nickname");
    }
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      localObject = f.a(this);
      try
      {
        paramString = ((f)localObject).b(paramInt1, paramInt2, paramString);
        if ((paramString != null) && (!paramString.containsKey("error_code")))
        {
          paramString.put("current_cursor", Integer.valueOf(paramInt2));
          paramString = filterFriendshipInfo(2, paramString);
          return paramString;
        }
      }
      catch (Throwable paramString)
      {
        e.b().d(paramString);
      }
    }
    return null;
  }
  
  protected void getFriendList(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject = this.db.getUserId();
    }
    paramString = (String)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramString = this.db.get("nickname");
    }
    if (TextUtils.isEmpty(paramString)) {
      if (this.listener != null) {
        this.listener.onError(this, 2, new RuntimeException("Both weibo id and screen_name are null"));
      }
    }
    do
    {
      do
      {
        for (;;)
        {
          return;
          localObject = f.a(this);
          try
          {
            paramString = ((f)localObject).b(paramInt1, paramInt2, paramString);
            if (paramString == null)
            {
              if (this.listener == null) {
                continue;
              }
              this.listener.onError(this, 2, new Throwable());
            }
          }
          catch (Throwable paramString)
          {
            this.listener.onError(this, 2, paramString);
            return;
          }
        }
        if ((!paramString.containsKey("error_code")) || (((Integer)paramString.get("error_code")).intValue() == 0)) {
          break;
        }
      } while (this.listener == null);
      paramString = new Hashon().fromHashMap(paramString);
      this.listener.onError(this, 2, new Throwable(paramString));
      return;
    } while (this.listener == null);
    this.listener.onComplete(this, 2, paramString);
  }
  
  public String getName()
  {
    return NAME;
  }
  
  protected int getPlatformId()
  {
    return 1;
  }
  
  public int getVersion()
  {
    return 1;
  }
  
  public boolean hasShareCallback()
  {
    return true;
  }
  
  protected void initDevInfo(String paramString)
  {
    this.a = getDevinfo("AppKey");
    this.b = getDevinfo("AppSecret");
    this.c = getDevinfo("RedirectUrl");
    this.d = "true".equals(getDevinfo("ShareByAppClient"));
  }
  
  public boolean isClientValid()
  {
    return f.a(this).b();
  }
  
  protected void setNetworkDevinfo()
  {
    this.a = getNetworkDevinfo("app_key", "AppKey");
    this.b = getNetworkDevinfo("app_secret", "AppSecret");
    this.c = getNetworkDevinfo("redirect_uri", "RedirectUrl");
  }
  
  protected void timeline(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject = this.db.getUserId();
    }
    paramString = (String)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramString = this.db.get("nickname");
    }
    if (TextUtils.isEmpty(paramString)) {
      if (this.listener != null) {
        this.listener.onError(this, 7, new RuntimeException("Both weibo id and screen_name are null"));
      }
    }
    do
    {
      do
      {
        for (;;)
        {
          return;
          localObject = f.a(this);
          try
          {
            paramString = ((f)localObject).a(paramInt1, paramInt2, paramString);
            if (paramString == null)
            {
              if (this.listener == null) {
                continue;
              }
              this.listener.onError(this, 7, new Throwable());
            }
          }
          catch (Throwable paramString)
          {
            this.listener.onError(this, 7, paramString);
            return;
          }
        }
        if ((!paramString.containsKey("error_code")) || (((Integer)paramString.get("error_code")).intValue() == 0)) {
          break;
        }
      } while (this.listener == null);
      paramString = new Hashon().fromHashMap(paramString);
      this.listener.onError(this, 7, new Throwable(paramString));
      return;
    } while (this.listener == null);
    this.listener.onComplete(this, 7, paramString);
  }
  
  protected void userInfor(String paramString)
  {
    int j = 1;
    int i = 0;
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      str = this.db.getUserId();
      i = 1;
    }
    if (TextUtils.isEmpty(str))
    {
      str = this.db.get("nickname");
      i = j;
    }
    for (;;)
    {
      if (TextUtils.isEmpty(str)) {
        if (this.listener != null) {
          this.listener.onError(this, 8, new RuntimeException("Both weibo id and screen_name are null"));
        }
      }
      do
      {
        for (;;)
        {
          return;
          paramString = f.a(this);
          try
          {
            paramString = paramString.d(str);
            if (paramString == null)
            {
              if (this.listener == null) {
                continue;
              }
              this.listener.onError(this, 8, new Throwable());
            }
          }
          catch (Throwable paramString)
          {
            this.listener.onError(this, 8, paramString);
            return;
          }
        }
        if ((!paramString.containsKey("error_code")) || (((Integer)paramString.get("error_code")).intValue() == 0)) {
          break;
        }
      } while (this.listener == null);
      paramString = new Hashon().fromHashMap(paramString);
      this.listener.onError(this, 8, new Throwable(paramString));
      return;
      if (i != 0)
      {
        this.db.putUserId(String.valueOf(paramString.get("id")));
        this.db.put("nickname", String.valueOf(paramString.get("screen_name")));
        this.db.put("icon", String.valueOf(paramString.get("avatar_hd")));
        if (!String.valueOf(paramString.get("verified")).equals("true")) {
          break label518;
        }
        this.db.put("secretType", "1");
        label292:
        this.db.put("secret", String.valueOf(paramString.get("verified_reason")));
        str = String.valueOf(paramString.get("gender"));
        if (!str.equals("m")) {
          break label534;
        }
        this.db.put("gender", "0");
      }
      for (;;)
      {
        this.db.put("snsUserUrl", "http://weibo.com/" + String.valueOf(paramString.get("profile_url")));
        this.db.put("resume", String.valueOf(paramString.get("description")));
        this.db.put("followerCount", String.valueOf(paramString.get("followers_count")));
        this.db.put("favouriteCount", String.valueOf(paramString.get("friends_count")));
        this.db.put("shareCount", String.valueOf(paramString.get("statuses_count")));
        long l = ResHelper.dateToLong(String.valueOf(paramString.get("created_at")));
        this.db.put("snsregat", String.valueOf(l));
        if (this.listener == null) {
          break;
        }
        this.listener.onComplete(this, 8, paramString);
        return;
        label518:
        this.db.put("secretType", "0");
        break label292;
        label534:
        if (str.equals("f")) {
          this.db.put("gender", "1");
        } else {
          this.db.put("gender", "2");
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/sina/weibo/SinaWeibo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */