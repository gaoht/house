package com.baidu.platform.comapi.util;

import android.content.Context;
import android.os.Environment;
import java.io.File;

public final class d
{
  private final boolean a;
  private final String b;
  private final String c;
  private final String d;
  private final String e;
  private final String f;
  
  d(Context paramContext)
  {
    this.a = false;
    this.b = Environment.getExternalStorageDirectory().getAbsolutePath();
    this.c = (this.b + File.separator + "BaiduMapSDKNew");
    this.d = paramContext.getCacheDir().getAbsolutePath();
    this.e = "";
    this.f = "";
  }
  
  d(String paramString1, boolean paramBoolean, String paramString2, Context paramContext)
  {
    this.a = paramBoolean;
    this.b = paramString1;
    this.c = (this.b + File.separator + "BaiduMapSDKNew");
    this.d = (this.c + File.separator + "cache");
    this.e = paramContext.getCacheDir().getAbsolutePath();
    this.f = paramString2;
  }
  
  public String a()
  {
    return this.b;
  }
  
  public String b()
  {
    return this.b + File.separator + "BaiduMapSDKNew";
  }
  
  public String c()
  {
    return this.d;
  }
  
  public String d()
  {
    return this.e;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!d.class.isInstance(paramObject))) {
      return false;
    }
    paramObject = (d)paramObject;
    return this.b.equals(((d)paramObject).b);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/platform/comapi/util/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */