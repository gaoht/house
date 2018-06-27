package cn.jiguang.c.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import cn.jiguang.c.a;
import cn.jiguang.d.d;

public final class b
{
  private static SharedPreferences a;
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[4];
    Object localObject1 = "\r5W%\025\0358F8\001Y{Q2\013\f>J)E\021(\0223\020\0247";
    int i = -1;
    int j = 0;
    Object localObject3 = arrayOfString;
    localObject1 = ((String)localObject1).toCharArray();
    int k = localObject1.length;
    int m;
    int n;
    int i1;
    label42:
    Object localObject2;
    int i2;
    label91:
    label113:
    Object localObject4;
    int i3;
    if (k <= 1)
    {
      m = 0;
      n = j;
      i1 = i;
      j = m;
      for (;;)
      {
        localObject2 = localObject1;
        i2 = localObject2[m];
        switch (j % 5)
        {
        default: 
          i = 101;
          localObject2[m] = ((char)(i ^ i2));
          j += 1;
          if (k != 0) {
            break label113;
          }
          m = k;
        }
      }
      i = k;
      localObject4 = localObject3;
      i3 = n;
      localObject2 = localObject1;
      i2 = i1;
    }
    for (;;)
    {
      i1 = i2;
      localObject1 = localObject2;
      n = i3;
      localObject3 = localObject4;
      k = i;
      m = j;
      if (i > j) {
        break label42;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i2)
      {
      default: 
        localObject4[i3] = localObject1;
        localObject1 = "+3S/\000()W;\000\n>\\>\000()]>\000\013(";
        j = 1;
        i = 0;
        break;
      case 0: 
        localObject4[i3] = localObject1;
        localObject1 = "\0335\0347\025\r(Zs\004\026?@2\f\034uG.\000\nuB/\n\0362^8";
        j = 2;
        i = 1;
        break;
      case 1: 
        localObject4[i3] = localObject1;
        j = 3;
        localObject1 = "\0334\\)\000\000/\0224\026X5G1\tT{[3E+3S/\000()W;\000\n>\\>\000()]>\000\013(\0344\013\021/";
        i = 2;
        break;
      case 2: 
        localObject4[i3] = localObject1;
        z = arrayOfString;
        a = null;
        return;
        i = 120;
        break label91;
        i = 91;
        break label91;
        i = 50;
        break label91;
        i = 93;
        break label91;
        m = 0;
        i2 = i;
        localObject2 = localObject1;
        i3 = j;
        localObject4 = localObject3;
        i = k;
        j = m;
      }
    }
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    if (a(paramContext))
    {
      b(paramContext);
      paramContext = a.edit();
      paramContext.putInt(paramString, paramInt);
      paramContext.apply();
      return;
    }
    d.g(z[1], z[0]);
  }
  
  public static void a(Context paramContext, String paramString, long paramLong)
  {
    if (a(paramContext))
    {
      b(paramContext);
      paramContext = a.edit();
      paramContext.putLong(paramString, paramLong);
      paramContext.apply();
      return;
    }
    d.g(z[1], z[0]);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if (a(paramContext))
    {
      b(paramContext);
      paramContext = a.edit();
      paramContext.putString(paramString1, paramString2);
      paramContext.apply();
      return;
    }
    d.g(z[1], z[0]);
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (a(paramContext))
    {
      b(paramContext);
      paramContext = a.edit();
      paramContext.putBoolean(paramString, paramBoolean);
      paramContext.apply();
      return;
    }
    d.g(z[1], z[0]);
  }
  
  private static boolean a(Context paramContext)
  {
    boolean bool = true;
    if (paramContext == null)
    {
      d.h(z[1], z[3]);
      bool = false;
    }
    return bool;
  }
  
  public static int b(Context paramContext, String paramString, int paramInt)
  {
    if (a(paramContext))
    {
      b(paramContext);
      return a.getInt(paramString, paramInt);
    }
    d.g(z[1], z[0]);
    return paramInt;
  }
  
  public static long b(Context paramContext, String paramString, long paramLong)
  {
    if (a(paramContext))
    {
      b(paramContext);
      return a.getLong(paramString, paramLong);
    }
    d.g(z[1], z[0]);
    return paramLong;
  }
  
  public static String b(Context paramContext, String paramString1, String paramString2)
  {
    if (a(paramContext))
    {
      b(paramContext);
      return a.getString(paramString1, paramString2);
    }
    d.g(z[1], z[0]);
    return paramString2;
  }
  
  private static void b(Context paramContext)
  {
    if (a != null)
    {
      if (a.m == null) {
        a = paramContext.getSharedPreferences(z[2], 4);
      }
      return;
    }
    a = paramContext.getSharedPreferences(z[2], 4);
  }
  
  public static boolean b(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (a(paramContext))
    {
      b(paramContext);
      return a.getBoolean(paramString, paramBoolean);
    }
    d.g(z[1], z[0]);
    return paramBoolean;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */