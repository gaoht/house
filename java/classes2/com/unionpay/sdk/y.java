package com.unionpay.sdk;

import android.app.Activity;
import android.content.Context;
import java.util.Map;

abstract interface y
{
  public abstract void a(Activity paramActivity);
  
  public abstract void a(Context paramContext);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, Map paramMap);
  
  public abstract void a(Context paramContext, Throwable paramThrowable);
  
  public abstract String b(Context paramContext);
  
  public abstract void b(Activity paramActivity);
  
  public abstract void c(boolean paramBoolean);
  
  public abstract void onPageEnd(Context paramContext, String paramString);
  
  public abstract void onPageStart(Context paramContext, String paramString);
  
  public abstract void onResume(Activity paramActivity, String paramString1, String paramString2);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */