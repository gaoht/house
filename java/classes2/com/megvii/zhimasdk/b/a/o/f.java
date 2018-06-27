package com.megvii.zhimasdk.b.a.o;

import com.megvii.zhimasdk.b.a.k;
import java.io.InputStream;

public final class f
{
  public static void a(k paramk)
  {
    if (paramk == null) {}
    do
    {
      do
      {
        return;
      } while (!paramk.f());
      paramk = paramk.a();
    } while (paramk == null);
    paramk.close();
  }
  
  public static byte[] b(k paramk)
  {
    int i = 4096;
    boolean bool = false;
    a.a(paramk, "Entity");
    InputStream localInputStream = paramk.a();
    if (localInputStream == null) {
      return null;
    }
    for (;;)
    {
      int j;
      try
      {
        if (paramk.b() <= 2147483647L) {
          bool = true;
        }
        a.a(bool, "HTTP entity too large to be buffered in memory");
        j = (int)paramk.b();
        if (j >= 0) {
          break label121;
        }
        paramk = new c(i);
        byte[] arrayOfByte = new byte['က'];
        i = localInputStream.read(arrayOfByte);
        if (i != -1)
        {
          paramk.a(arrayOfByte, 0, i);
          continue;
        }
        paramk = paramk.b();
      }
      finally
      {
        localInputStream.close();
      }
      localInputStream.close();
      return paramk;
      label121:
      i = j;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/o/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */