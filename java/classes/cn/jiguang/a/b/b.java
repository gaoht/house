package cn.jiguang.a.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class b
{
  private static b c;
  private static final String z;
  private final String a = z;
  private SharedPreferences b = null;
  
  static
  {
    Object localObject1 = "m%3)5t4\031\0312I\023/=".toCharArray();
    int j = localObject1.length;
    int m = 0;
    int i = 0;
    Object localObject2 = localObject1;
    int k = j;
    label30:
    int n;
    if (j <= 1)
    {
      m = i;
      k = i;
      localObject2 = localObject1;
      n = localObject2[k];
      switch (m % 5)
      {
      default: 
        i = 93;
      }
    }
    for (;;)
    {
      localObject2[k] = ((char)(i ^ n));
      m += 1;
      if (j == 0)
      {
        k = j;
        break label30;
      }
      k = j;
      localObject2 = localObject1;
      localObject1 = localObject2;
      j = k;
      i = m;
      if (k > m) {
        break;
      }
      z = new String((char[])localObject2).intern();
      return;
      i = 39;
      continue;
      i = 117;
      continue;
      i = 70;
      continue;
      i = 90;
    }
  }
  
  private SharedPreferences a(Context paramContext)
  {
    if (this.b == null) {}
    try
    {
      this.b = paramContext.getSharedPreferences(z, 0);
      return this.b;
    }
    finally {}
  }
  
  public static b a()
  {
    if (c == null) {
      c = new b();
    }
    return c;
  }
  
  public final long a(Context paramContext, String paramString, long paramLong)
  {
    return a(paramContext).getLong(paramString, paramLong);
  }
  
  public final String a(Context paramContext, String paramString1, String paramString2)
  {
    return a(paramContext).getString(paramString1, null);
  }
  
  public final void b(Context paramContext, String paramString, long paramLong)
  {
    a(paramContext).edit().putLong(paramString, paramLong).commit();
  }
  
  public final void b(Context paramContext, String paramString1, String paramString2)
  {
    a(paramContext).edit().putString(paramString1, paramString2).commit();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/a/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */