package com.megvii.zhimasdk.b.a.i.e;

import com.megvii.zhimasdk.b.a.ab;
import com.megvii.zhimasdk.b.a.ac;
import com.megvii.zhimasdk.b.a.e;
import com.megvii.zhimasdk.b.a.o.a;
import com.megvii.zhimasdk.b.a.p;
import com.megvii.zhimasdk.b.a.v;

public class d
  implements com.megvii.zhimasdk.b.a.g.d
{
  public static final d a = new d();
  private final int b;
  
  public d()
  {
    this(-1);
  }
  
  public d(int paramInt)
  {
    this.b = paramInt;
  }
  
  public long a(p paramp)
  {
    a.a(paramp, "HTTP message");
    Object localObject = paramp.c("Transfer-Encoding");
    long l1;
    if (localObject != null)
    {
      localObject = ((e)localObject).d();
      if ("chunked".equalsIgnoreCase((String)localObject))
      {
        if (paramp.d().c(v.b)) {
          throw new ab("Chunked transfer encoding not allowed for " + paramp.d());
        }
        l1 = -2L;
      }
    }
    for (;;)
    {
      return l1;
      if ("identity".equalsIgnoreCase((String)localObject)) {
        return -1L;
      }
      throw new ab("Unsupported transfer encoding: " + (String)localObject);
      paramp = paramp.c("Content-Length");
      if (paramp != null)
      {
        paramp = paramp.d();
        try
        {
          long l2 = Long.parseLong(paramp);
          l1 = l2;
          if (l2 < 0L) {
            throw new ab("Negative content length: " + paramp);
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          throw new ab("Invalid content length: " + paramp);
        }
      }
    }
    return this.b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/e/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */