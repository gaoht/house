package com.baidu.location.d;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.baidu.android.bbalbs.common.util.CommonParam;
import com.baidu.location.f;
import java.util.Locale;

public class b
{
  public static String d = null;
  public static String e = null;
  public static String f = null;
  public static String g = null;
  private static b h = null;
  public String a = null;
  public String b = null;
  public String c = null;
  private boolean i = false;
  
  private b()
  {
    if (f.getServiceContext() != null) {
      a(f.getServiceContext());
    }
  }
  
  public static b a()
  {
    if (h == null) {
      h = new b();
    }
    return h;
  }
  
  public String a(boolean paramBoolean)
  {
    return a(paramBoolean, null);
  }
  
  public String a(boolean paramBoolean, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer(256);
    localStringBuffer.append("&sdk=");
    localStringBuffer.append(7.02F);
    if (paramBoolean)
    {
      if (j.f.equals("all")) {
        localStringBuffer.append("&addr=all");
      }
      if ((j.g) || (j.i) || (j.j) || (j.h))
      {
        localStringBuffer.append("&sema=");
        if (j.g) {
          localStringBuffer.append("aptag|");
        }
        if (j.h) {
          localStringBuffer.append("aptagd|");
        }
        if (j.i) {
          localStringBuffer.append("poiregion|");
        }
        if (j.j) {
          localStringBuffer.append("regular");
        }
      }
    }
    if (paramBoolean)
    {
      if (paramString == null) {
        localStringBuffer.append("&coor=gcj02");
      }
    }
    else
    {
      if (this.b != null) {
        break label427;
      }
      localStringBuffer.append("&im=");
      localStringBuffer.append(this.a);
    }
    for (;;)
    {
      if (this.c != null)
      {
        localStringBuffer.append("&Aid=");
        localStringBuffer.append(this.c);
      }
      localStringBuffer.append("&fw=");
      localStringBuffer.append(f.getFrameVersion());
      localStringBuffer.append("&lt=1");
      localStringBuffer.append("&mb=");
      localStringBuffer.append(Build.MODEL);
      paramString = j.b();
      if (paramString != null)
      {
        localStringBuffer.append("&laip=");
        localStringBuffer.append(paramString);
      }
      float f1 = com.baidu.location.a.j.a().e();
      if (f1 != 0.0F)
      {
        localStringBuffer.append("&altv=");
        localStringBuffer.append(String.format(Locale.US, "%.2f", new Object[] { Float.valueOf(f1) }));
      }
      localStringBuffer.append("&resid=");
      localStringBuffer.append("12");
      localStringBuffer.append("&os=A");
      localStringBuffer.append(Build.VERSION.SDK);
      if (paramBoolean)
      {
        localStringBuffer.append("&sv=");
        String str = Build.VERSION.RELEASE;
        paramString = str;
        if (str != null)
        {
          paramString = str;
          if (str.length() > 6) {
            paramString = str.substring(0, 6);
          }
        }
        localStringBuffer.append(paramString);
      }
      return localStringBuffer.toString();
      localStringBuffer.append("&coor=");
      localStringBuffer.append(paramString);
      break;
      label427:
      localStringBuffer.append("&cu=");
      localStringBuffer.append(this.b);
      if ((this.a != null) && (!this.a.equals("NULL")) && (!this.b.contains(new StringBuffer(this.a).reverse().toString())))
      {
        localStringBuffer.append("&Aim=");
        localStringBuffer.append(this.a);
      }
    }
  }
  
  public void a(Context paramContext)
  {
    if ((paramContext == null) || (this.i)) {
      return;
    }
    try
    {
      this.a = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
    }
    catch (Exception localException3)
    {
      try
      {
        this.b = CommonParam.a(paramContext);
      }
      catch (Exception localException3)
      {
        try
        {
          this.c = com.baidu.android.bbalbs.common.util.b.b(paramContext);
        }
        catch (Exception localException3)
        {
          try
          {
            for (;;)
            {
              d = paramContext.getPackageName();
              this.i = true;
              return;
              localException1 = localException1;
              this.a = "NULL";
              continue;
              localException2 = localException2;
              this.b = null;
              continue;
              localException3 = localException3;
              this.c = null;
            }
          }
          catch (Exception paramContext)
          {
            for (;;)
            {
              d = null;
            }
          }
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    e = paramString1;
    d = paramString2;
  }
  
  public String b()
  {
    if (this.b != null) {
      return "v7.02|" + this.b + "|" + Build.MODEL;
    }
    return "v7.02|" + this.a + "|" + Build.MODEL;
  }
  
  public String c()
  {
    if (d != null) {
      return b() + "|" + d;
    }
    return b();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/location/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */