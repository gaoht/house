package cn.sharesdk.framework;

import android.graphics.Bitmap;
import android.text.TextUtils;
import cn.sharesdk.framework.utils.e;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.ResHelper;
import java.lang.reflect.Field;
import java.util.HashMap;

public class c
{
  private Platform a;
  private PlatformDb b;
  private a c;
  private int d;
  private int e;
  private boolean f;
  private boolean g = true;
  private boolean h;
  
  public c(Platform paramPlatform)
  {
    this.a = paramPlatform;
    String str = paramPlatform.getName();
    this.b = new PlatformDb(str, paramPlatform.getVersion());
    a(str);
    this.c = new a();
  }
  
  private boolean j()
  {
    boolean bool = false;
    String str;
    if (ShareSDK.a())
    {
      str = a(this.a.getPlatformId(), "covert_url", null);
      if (str != null) {
        str.trim();
      }
      if (!"false".equals(str)) {
        bool = true;
      }
      this.g = bool;
      this.a.setNetworkDevinfo();
      return true;
    }
    for (;;)
    {
      try
      {
        if (!ShareSDK.b()) {
          return false;
        }
        str = a(this.a.getPlatformId(), "covert_url", null);
        if (str != null) {
          str.trim();
        }
        if (!"false".equals(str))
        {
          bool = true;
          this.g = bool;
          this.a.setNetworkDevinfo();
          return true;
        }
      }
      catch (Throwable localThrowable)
      {
        e.b().w(localThrowable);
        return false;
      }
      bool = false;
    }
  }
  
  private String k()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      try
      {
        if (!"TencentWeibo".equals(this.a.getName())) {
          continue;
        }
        e.b().i("user id %s ==>>", new Object[] { g().getUserName() });
        localStringBuilder.append(Data.urlEncode(g().getUserName(), "utf-8"));
        localStringBuilder.append("|").append(Data.urlEncode(g().get("secretType"), "utf-8"));
        localStringBuilder.append("|").append(Data.urlEncode(g().get("gender"), "utf-8"));
        localStringBuilder.append("|").append(Data.urlEncode(g().get("birthday"), "utf-8"));
        localStringBuilder.append("|").append(Data.urlEncode(g().get("educationJSONArrayStr"), "utf-8"));
        localStringBuilder.append("|").append(Data.urlEncode(g().get("workJSONArrayStr"), "utf-8"));
      }
      catch (Throwable localThrowable)
      {
        e.b().w(localThrowable);
        continue;
      }
      return localStringBuilder.toString();
      localStringBuilder.append(Data.urlEncode(g().getUserId(), "utf-8"));
    }
  }
  
  public int a()
  {
    return this.d;
  }
  
  public String a(int paramInt, String paramString1, String paramString2)
  {
    String str = ShareSDK.a(paramInt, paramString1);
    if (!TextUtils.isEmpty(str))
    {
      paramString1 = str;
      if (!"null".equals(str)) {}
    }
    else
    {
      paramString1 = this.a.getDevinfo(this.a.getName(), paramString2);
    }
    return paramString1;
  }
  
  public String a(Bitmap paramBitmap)
  {
    return ShareSDK.a(paramBitmap);
  }
  
  public String a(String paramString, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    if (!this.g)
    {
      e.b().i("getShortLintk use time: " + (System.currentTimeMillis() - l), new Object[0]);
      return paramString;
    }
    if (TextUtils.isEmpty(paramString))
    {
      e.b().i("getShortLintk use time: " + (System.currentTimeMillis() - l), new Object[0]);
      return paramString;
    }
    paramString = ShareSDK.a(paramString, paramBoolean, this.a.getPlatformId(), k());
    e.b().i("getShortLintk use time: " + (System.currentTimeMillis() - l), new Object[0]);
    return paramString;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    c(2, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
  }
  
  public void a(int paramInt, Object paramObject)
  {
    this.c.a(this.a, paramInt, paramObject);
  }
  
  public void a(Platform.ShareParams paramShareParams)
  {
    if (paramShareParams == null)
    {
      if (this.c != null) {
        this.c.onError(this.a, 9, new NullPointerException());
      }
      return;
    }
    c(9, paramShareParams);
  }
  
  public void a(PlatformActionListener paramPlatformActionListener)
  {
    this.c.a(paramPlatformActionListener);
  }
  
  public void a(String paramString)
  {
    String str = ShareSDK.b(paramString, "Id");
    try
    {
      this.d = ResHelper.parseInt(String.valueOf(str).trim());
      str = ShareSDK.b(paramString, "SortId");
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        do
        {
          this.e = ResHelper.parseInt(String.valueOf(str).trim());
          str = ShareSDK.b(paramString, "Enable");
          if (str != null) {
            break;
          }
          this.h = true;
          if (!(this.a instanceof CustomPlatform)) {
            e.b().d(this.a.getName() + " failed to parse Enable, this will cause platform always be enable", new Object[0]);
          }
          this.a.initDevInfo(paramString);
          return;
          localThrowable1 = localThrowable1;
        } while ((this.a instanceof CustomPlatform));
        e.b().d(this.a.getName() + " failed to parse Id, this will cause method getId() always returens 0", new Object[0]);
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          if (!(this.a instanceof CustomPlatform))
          {
            e.b().d(this.a.getName() + " failed to parse SortId, this won't cause any problem, don't worry", new Object[0]);
            continue;
            this.h = "true".equals(localThrowable2.trim());
          }
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    c(7, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
  }
  
  public void a(String paramString1, String paramString2, short paramShort, HashMap<String, Object> paramHashMap, HashMap<String, String> paramHashMap1)
  {
    c(0xA0000 | paramShort, new Object[] { paramString1, paramString2, paramHashMap, paramHashMap1 });
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void a(final String[] paramArrayOfString)
  {
    new Thread()
    {
      public void run()
      {
        try
        {
          c.a(c.this);
          c.b(c.this).doAuthorize(paramArrayOfString);
          return;
        }
        catch (Throwable localThrowable)
        {
          e.b().w(localThrowable);
        }
      }
    }.start();
  }
  
  public int b()
  {
    return this.e;
  }
  
  protected void b(int paramInt, Object paramObject)
  {
    Object localObject2;
    Object localObject1;
    HashMap localHashMap;
    switch (paramInt)
    {
    case 3: 
    case 4: 
    case 5: 
    default: 
      localObject2 = (Object[])paramObject;
      paramObject = String.valueOf(localObject2[0]);
      localObject1 = String.valueOf(localObject2[1]);
      localHashMap = (HashMap)localObject2[2];
      localObject2 = (HashMap)localObject2[3];
      this.a.doCustomerProtocol((String)paramObject, (String)localObject1, paramInt, localHashMap, (HashMap)localObject2);
    case 1: 
      do
      {
        return;
      } while (this.c == null);
      this.c.onComplete(this.a, 1, null);
      return;
    case 6: 
      this.a.follow((String)paramObject);
      return;
    case 7: 
      paramObject = (Object[])paramObject;
      this.a.timeline(((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
      return;
    case 8: 
      localObject1 = this.a;
      if (paramObject == null) {}
      for (paramObject = null;; paramObject = (String)paramObject)
      {
        ((Platform)localObject1).userInfor((String)paramObject);
        return;
      }
    case 9: 
      localObject1 = (Platform.ShareParams)paramObject;
      localHashMap = ((Platform.ShareParams)localObject1).toMap();
      localObject2 = localObject1.getClass().getFields();
      int i = localObject2.length;
      paramInt = 0;
      for (;;)
      {
        if (paramInt < i)
        {
          Object localObject3 = localObject2[paramInt];
          if (localHashMap.get(((Field)localObject3).getName()) == null) {
            ((Field)localObject3).setAccessible(true);
          }
          try
          {
            paramObject = ((Field)localObject3).get(localObject1);
            if (paramObject != null) {
              localHashMap.put(((Field)localObject3).getName(), paramObject);
            }
            paramInt += 1;
          }
          catch (Throwable paramObject)
          {
            for (;;)
            {
              e.b().w((Throwable)paramObject);
              paramObject = null;
            }
          }
        }
      }
      if ((this.c instanceof a)) {
        this.c.a(this.a, (Platform.ShareParams)localObject1);
      }
      this.a.doShare((Platform.ShareParams)localObject1);
      return;
    }
    paramObject = (Object[])paramObject;
    this.a.getFriendList(((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
  }
  
  public void b(String paramString)
  {
    c(6, paramString);
  }
  
  public PlatformActionListener c()
  {
    return this.c.a();
  }
  
  protected void c(final int paramInt, final Object paramObject)
  {
    new Thread()
    {
      public void run()
      {
        try
        {
          c.a(c.this);
          if (c.b(c.this).checkAuthorize(paramInt, paramObject)) {
            c.this.b(paramInt, paramObject);
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          e.b().w(localThrowable);
        }
      }
    }.start();
  }
  
  public void c(String paramString)
  {
    c(8, paramString);
  }
  
  public String d(String paramString)
  {
    return ShareSDK.a(paramString);
  }
  
  public boolean d()
  {
    return this.b.isValid();
  }
  
  public boolean e()
  {
    return this.f;
  }
  
  public boolean f()
  {
    return this.h;
  }
  
  public PlatformDb g()
  {
    return this.b;
  }
  
  public void h()
  {
    this.b.removeAccount();
  }
  
  protected PlatformActionListener i()
  {
    return this.c;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/framework/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */