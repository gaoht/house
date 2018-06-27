package cn.jiguang.api;

import android.content.Context;
import android.os.RemoteException;
import cn.jiguang.c.a.b;
import cn.jiguang.c.d.i;
import cn.jiguang.d.d;

public class MultiSpHelper
{
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[3];
    Object localObject2 = "g\"G@Z~\025qHG|\031AH\025c\003\002C@f\034\016\rWc\036F~Px\006KNP*\030C^\025d\037V\rWo\025L\rVe\036LHV~\025F";
    int i = -1;
    int j = 0;
    Object localObject1 = arrayOfString;
    localObject2 = ((String)localObject2).toCharArray();
    int k = localObject2.length;
    int m;
    Object localObject3;
    int n;
    int i1;
    label50:
    int i2;
    label99:
    label121:
    Object localObject4;
    int i3;
    if (k <= 1)
    {
      m = 0;
      localObject3 = localObject1;
      n = j;
      localObject1 = localObject2;
      i1 = i;
      j = m;
      for (;;)
      {
        localObject2 = localObject1;
        i2 = localObject2[m];
        switch (j % 5)
        {
        default: 
          i = 53;
          localObject2[m] = ((char)(i ^ i2));
          j += 1;
          if (k != 0) {
            break label121;
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
        break label50;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i2)
      {
      default: 
        localObject4[i3] = localObject1;
        localObject2 = "\036GUEo\023VHQ+PCDQfPJLF*\007PB[mPUDAbPpHXe\004GhMi\025RY\\e\036";
        j = 1;
        i = 0;
        break;
      case 0: 
        localObject4[i3] = localObject1;
        j = 2;
        localObject2 = "G\005NY\\Y\000jHYz\025P";
        i = 1;
        break;
      case 1: 
        localObject4[i3] = localObject1;
        z = arrayOfString;
        return;
        i = 10;
        break label99;
        i = 112;
        break label99;
        i = 34;
        break label99;
        i = 45;
        break label99;
        m = 0;
        i2 = i;
        i3 = j;
        localObject4 = localObject1;
        i = k;
        j = m;
      }
    }
  }
  
  public static void commitBoolean(Context paramContext, String paramString, boolean paramBoolean)
  {
    try
    {
      if (i.a().a(paramContext))
      {
        cn.jiguang.c.a.m.b(paramString, paramBoolean);
        return;
      }
      b.a(paramContext, paramString, paramBoolean);
      return;
    }
    catch (RemoteException paramContext)
    {
      d.g(z[2], z[1]);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      d.a(z[2], z[0]);
      b.a(paramContext, paramString, paramBoolean);
    }
  }
  
  public static void commitInt(Context paramContext, String paramString, int paramInt)
  {
    try
    {
      if (i.a().a(paramContext))
      {
        cn.jiguang.c.a.m.b(paramString, paramInt);
        return;
      }
      b.a(paramContext, paramString, paramInt);
      return;
    }
    catch (RemoteException paramContext)
    {
      d.g(z[2], z[1]);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      d.a(z[2], z[0]);
      b.a(paramContext, paramString, paramInt);
    }
  }
  
  public static void commitLong(Context paramContext, String paramString, long paramLong)
  {
    try
    {
      if (i.a().a(paramContext))
      {
        cn.jiguang.c.a.m.b(paramString, paramLong);
        return;
      }
      b.a(paramContext, paramString, paramLong);
      return;
    }
    catch (RemoteException paramContext)
    {
      d.g(z[2], z[1]);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      d.a(z[2], z[0]);
      b.a(paramContext, paramString, paramLong);
    }
  }
  
  public static void commitString(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      if (i.a().a(paramContext))
      {
        cn.jiguang.c.a.m.b(paramString1, paramString2);
        return;
      }
      b.a(paramContext, paramString1, paramString2);
      return;
    }
    catch (RemoteException paramContext)
    {
      d.g(z[2], z[1]);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      d.a(z[2], z[0]);
      b.a(paramContext, paramString1, paramString2);
    }
  }
  
  public static boolean getBoolean(Context paramContext, String paramString, boolean paramBoolean)
  {
    try
    {
      if (i.a().a(paramContext)) {
        return cn.jiguang.c.a.m.a(paramString, paramBoolean);
      }
      boolean bool = b.b(paramContext, paramString, paramBoolean);
      return bool;
    }
    catch (RemoteException paramContext)
    {
      d.g(z[2], z[1]);
      return paramBoolean;
    }
    catch (NullPointerException localNullPointerException)
    {
      d.a(z[2], z[0]);
    }
    return b.b(paramContext, paramString, paramBoolean);
  }
  
  public static int getInt(Context paramContext, String paramString, int paramInt)
  {
    try
    {
      if (i.a().a(paramContext)) {
        return cn.jiguang.c.a.m.a(paramString, paramInt);
      }
      int i = b.b(paramContext, paramString, paramInt);
      return i;
    }
    catch (RemoteException paramContext)
    {
      d.g(z[2], z[1]);
      return paramInt;
    }
    catch (NullPointerException localNullPointerException)
    {
      d.a(z[2], z[0]);
    }
    return b.b(paramContext, paramString, paramInt);
  }
  
  public static long getLong(Context paramContext, String paramString, long paramLong)
  {
    try
    {
      if (i.a().a(paramContext)) {
        return cn.jiguang.c.a.m.a(paramString, paramLong);
      }
      long l = b.b(paramContext, paramString, paramLong);
      return l;
    }
    catch (RemoteException paramContext)
    {
      d.g(z[2], z[1]);
      return paramLong;
    }
    catch (NullPointerException localNullPointerException)
    {
      d.a(z[2], z[0]);
    }
    return b.b(paramContext, paramString, paramLong);
  }
  
  public static String getString(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      if (i.a().a(paramContext)) {
        return cn.jiguang.c.a.m.a(paramString1, paramString2);
      }
      String str = b.b(paramContext, paramString1, paramString2);
      return str;
    }
    catch (RemoteException paramContext)
    {
      d.g(z[2], z[1]);
      return paramString2;
    }
    catch (NullPointerException localNullPointerException)
    {
      d.a(z[2], z[0]);
    }
    return b.b(paramContext, paramString1, paramString2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/api/MultiSpHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */