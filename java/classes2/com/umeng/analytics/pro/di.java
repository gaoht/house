package com.umeng.analytics.pro;

public class di
{
  private static int a = Integer.MAX_VALUE;
  
  public static dh a(byte[] paramArrayOfByte, dh paramdh)
  {
    Object localObject;
    if (paramArrayOfByte[0] > 16) {
      localObject = new cz.a();
    }
    do
    {
      do
      {
        return (dh)localObject;
        localObject = paramdh;
      } while (paramArrayOfByte.length <= 1);
      localObject = paramdh;
    } while ((paramArrayOfByte[1] & 0x80) == 0);
    return new cz.a();
  }
  
  public static void a(int paramInt)
  {
    a = paramInt;
  }
  
  public static void a(df paramdf, byte paramByte)
    throws cm
  {
    a(paramdf, paramByte, a);
  }
  
  public static void a(df paramdf, byte paramByte, int paramInt)
    throws cm
  {
    byte b2 = 0;
    byte b3 = 0;
    byte b1 = 0;
    if (paramInt <= 0) {
      throw new cm("Maximum skip depth exceeded");
    }
    switch (paramByte)
    {
    case 5: 
    case 7: 
    case 9: 
    default: 
      return;
    case 2: 
      paramdf.t();
      return;
    case 3: 
      paramdf.u();
      return;
    case 6: 
      paramdf.v();
      return;
    case 8: 
      paramdf.w();
      return;
    case 10: 
      paramdf.x();
      return;
    case 4: 
      paramdf.y();
      return;
    case 11: 
      paramdf.A();
      return;
    case 12: 
      paramdf.j();
      for (;;)
      {
        localObject = paramdf.l();
        if (((da)localObject).b == 0)
        {
          paramdf.k();
          return;
        }
        a(paramdf, ((da)localObject).b, paramInt - 1);
        paramdf.m();
      }
    case 13: 
      localObject = paramdf.n();
      paramByte = b1;
      while (paramByte < ((dc)localObject).c)
      {
        a(paramdf, ((dc)localObject).a, paramInt - 1);
        a(paramdf, ((dc)localObject).b, paramInt - 1);
        paramByte += 1;
      }
      paramdf.o();
      return;
    case 14: 
      localObject = paramdf.r();
      paramByte = b2;
      while (paramByte < ((dj)localObject).b)
      {
        a(paramdf, ((dj)localObject).a, paramInt - 1);
        paramByte += 1;
      }
      paramdf.s();
      return;
    }
    Object localObject = paramdf.p();
    paramByte = b3;
    while (paramByte < ((db)localObject).b)
    {
      a(paramdf, ((db)localObject).a, paramInt - 1);
      paramByte += 1;
    }
    paramdf.q();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/di.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */