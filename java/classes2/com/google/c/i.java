package com.google.c;

import com.google.c.b.d;
import com.google.c.b.h;
import com.google.c.b.l;
import com.google.c.b.o;
import com.google.c.c.a.g;
import java.util.Map;

public final class i
  implements p
{
  public com.google.c.a.b encode(String paramString, a parama, int paramInt1, int paramInt2)
    throws q
  {
    return encode(paramString, parama, paramInt1, paramInt2, null);
  }
  
  public com.google.c.a.b encode(String paramString, a parama, int paramInt1, int paramInt2, Map<f, ?> paramMap)
    throws q
  {
    Object localObject;
    switch (1.a[parama.ordinal()])
    {
    default: 
      throw new IllegalArgumentException("No encoder available for format " + parama);
    case 1: 
      localObject = new com.google.c.b.i();
    }
    for (;;)
    {
      return ((p)localObject).encode(paramString, parama, paramInt1, paramInt2, paramMap);
      localObject = new h();
      continue;
      localObject = new o();
      continue;
      localObject = new com.google.c.d.a();
      continue;
      localObject = new com.google.c.b.f();
      continue;
      localObject = new d();
      continue;
      localObject = new l();
      continue;
      localObject = new g();
      continue;
      localObject = new com.google.c.b.b();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/c/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */