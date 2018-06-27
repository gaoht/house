package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;

public class ai
  extends y
{
  private static final String a = "oldumid";
  private Context b;
  private String c = null;
  private String d = null;
  
  public ai(Context paramContext)
  {
    super("oldumid");
    this.b = paramContext;
  }
  
  private void b(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
  }
  
  private void j()
  {
    try
    {
      b("/data/local/tmp/.um");
      bw.a(new File("/data/local/tmp/.um/sysid.dat"), this.d);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private void k()
  {
    try
    {
      b("/sdcard/Android/obj/.um");
      bw.a(new File("/sdcard/Android/obj/.um/sysid.dat"), this.d);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private void l()
  {
    try
    {
      b("/sdcard/Android/data/.um");
      bw.a(new File("/sdcard/Android/data/.um/sysid.dat"), this.d);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public String f()
  {
    return this.c;
  }
  
  public boolean g()
  {
    return h();
  }
  
  public boolean h()
  {
    this.d = af.a(this.b).b().g(null);
    String str1;
    String str2;
    String str3;
    if (!TextUtils.isEmpty(this.d))
    {
      this.d = bt.c(this.d);
      str1 = bw.b(new File("/sdcard/Android/data/.um/sysid.dat"));
      str2 = bw.b(new File("/sdcard/Android/obj/.um/sysid.dat"));
      str3 = bw.b(new File("/data/local/tmp/.um/sysid.dat"));
      if (!TextUtils.isEmpty(str1)) {
        break label113;
      }
      l();
      if (!TextUtils.isEmpty(str2)) {
        break label131;
      }
      k();
      label100:
      if (!TextUtils.isEmpty(str3)) {
        break label149;
      }
      j();
    }
    label113:
    label131:
    label149:
    while (this.d.equals(str3))
    {
      return false;
      if (this.d.equals(str1)) {
        break;
      }
      this.c = str1;
      return true;
      if (this.d.equals(str2)) {
        break label100;
      }
      this.c = str2;
      return true;
    }
    this.c = str3;
    return true;
  }
  
  public void i()
  {
    try
    {
      l();
      k();
      j();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */