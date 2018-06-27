package com.megvii.zhimasdk.b;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.util.Log;

public class l
  implements m
{
  boolean a = true;
  int b = 2;
  
  @TargetApi(8)
  private void c(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.wtf(paramString1, paramString2, paramThrowable);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    a(paramInt, paramString1, paramString2, null);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((a()) && (a(paramInt))) {}
    switch (paramInt)
    {
    case 7: 
    default: 
      return;
    case 2: 
      Log.v(paramString1, paramString2, paramThrowable);
      return;
    case 5: 
      Log.w(paramString1, paramString2, paramThrowable);
      return;
    case 6: 
      Log.e(paramString1, paramString2, paramThrowable);
      return;
    case 3: 
      Log.d(paramString1, paramString2, paramThrowable);
      return;
    case 8: 
      if (Integer.valueOf(Build.VERSION.SDK).intValue() > 8)
      {
        c(paramString1, paramString2, paramThrowable);
        return;
      }
      Log.e(paramString1, paramString2, paramThrowable);
      return;
    }
    Log.i(paramString1, paramString2, paramThrowable);
  }
  
  public void a(String paramString1, String paramString2)
  {
    a(2, paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(5, paramString1, paramString2, paramThrowable);
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public boolean a(int paramInt)
  {
    return paramInt >= this.b;
  }
  
  public void b(String paramString1, String paramString2)
  {
    a(2, paramString1, paramString2);
  }
  
  public void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(6, paramString1, paramString2, paramThrowable);
  }
  
  public void c(String paramString1, String paramString2)
  {
    a(4, paramString1, paramString2);
  }
  
  public void d(String paramString1, String paramString2)
  {
    a(5, paramString1, paramString2);
  }
  
  public void e(String paramString1, String paramString2)
  {
    a(6, paramString1, paramString2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */