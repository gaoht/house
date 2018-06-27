package com.megvii.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.security.InvalidParameterException;

public final class e
{
  private String a = "";
  private SharedPreferences b;
  
  public e(Context paramContext)
  {
    this(paramContext, "MegviiSDKPreference", "");
  }
  
  private e(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {
      throw new InvalidParameterException();
    }
    this.a = paramString2;
    this.b = paramContext.getApplicationContext().getSharedPreferences(paramString1, 0);
  }
  
  public final String a(String paramString)
  {
    try
    {
      paramString = this.b.getString(paramString + this.a, null);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    try
    {
      this.b.edit().putString(paramString1 + this.a, paramString2).apply();
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public final String b(String paramString)
  {
    try
    {
      String str = this.b.getString(paramString + this.a, null);
      this.b.edit().remove(paramString + this.a).apply();
      return str;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */