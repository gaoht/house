package com.google.a;

import java.io.IOException;
import java.util.Vector;

public final class i
{
  public static final i a = new i(0, j.e, 0);
  public static final i b;
  public static final i c;
  public static final i d;
  public static final i e;
  public static final i f;
  public static final i g;
  public static final i h;
  public static final i i;
  private final int j;
  private final j k;
  private final int l;
  
  static
  {
    new i(1, j.g, 2);
    new i(2, j.d, 1);
    b = new i(3, j.h, 0);
    new i(4, j.a, 5);
    new i(5, j.b, 1);
    new i(6, j.c, 5);
    c = new i(7, j.i, 3);
    new i(8, j.a, 0);
    new i(9, j.b, 0);
    d = new i(10, j.i, 2);
    e = new i(11, j.a, 5);
    f = new i(12, j.b, 1);
    g = new i(13, j.a, 0);
    h = new i(14, j.b, 0);
    new i(15, j.f, 2);
    i = new i(16, j.a, 0);
    new i(17, j.b, 0);
  }
  
  private i(int paramInt1, j paramj, int paramInt2)
  {
    this.j = paramInt1;
    this.k = paramj;
    this.l = paramInt2;
  }
  
  protected final int a()
  {
    return this.l;
  }
  
  protected final int a(f paramf, Vector paramVector)
  {
    int n = 0;
    int i1;
    if (paramf.e())
    {
      i1 = d.k(paramf.b());
      m = 0;
      n = 0;
      while (m < paramVector.size())
      {
        n += a(false, paramf, paramVector.elementAt(m));
        m += 1;
      }
      i1 = i1 + 0 + n + d.m(n);
      return i1;
    }
    int m = 0;
    for (;;)
    {
      i1 = m;
      if (n >= paramVector.size()) {
        break;
      }
      m += a(true, paramf, paramVector.elementAt(n));
      n += 1;
    }
  }
  
  protected final int a(boolean paramBoolean, f paramf, Object paramObject)
  {
    if (paramBoolean) {}
    for (int m = d.k(paramf.b());; m = 0) {
      switch (this.j)
      {
      case 7: 
      default: 
        throw new RuntimeException("Should never reach this point.");
      }
    }
    ((Boolean)paramObject).booleanValue();
    return m + 1;
    return m + d.b((b)paramObject);
    ((Double)paramObject).doubleValue();
    return m + 8;
    return m + d.m(((e)paramObject).a());
    ((Integer)paramObject).intValue();
    return m + 4;
    ((Long)paramObject).longValue();
    return m + 8;
    ((Float)paramObject).floatValue();
    return m + 4;
    return m + d.g(((Integer)paramObject).intValue());
    return m + d.i(((Long)paramObject).longValue());
    return m + d.b((g)paramObject);
    ((Integer)paramObject).intValue();
    return m + 4;
    ((Long)paramObject).longValue();
    return m + 8;
    return m + d.m(d.n(((Integer)paramObject).intValue()));
    return m + d.i(d.j(((Long)paramObject).longValue()));
    return m + d.b((String)paramObject);
    return m + d.m(((Integer)paramObject).intValue());
    return m + d.i(((Long)paramObject).longValue());
  }
  
  public final Object a(c paramc)
    throws IOException
  {
    switch (this.j)
    {
    default: 
      throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    case 0: 
      return new Boolean(paramc.i());
    case 1: 
      return paramc.k();
    case 2: 
      return new Double(Double.longBitsToDouble(paramc.t()));
    case 3: 
      throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
    case 4: 
      return new Integer(paramc.s());
    case 5: 
      return new Long(paramc.t());
    case 6: 
      return new Float(Float.intBitsToFloat(paramc.s()));
    case 7: 
      throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
    case 8: 
      return new Integer(paramc.f());
    case 9: 
      return new Long(paramc.e());
    case 10: 
      throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
    case 11: 
      return new Integer(paramc.s());
    case 12: 
      return new Long(paramc.t());
    case 13: 
      return new Integer(paramc.p());
    case 14: 
      return new Long(paramc.q());
    case 15: 
      return paramc.j();
    case 16: 
      return new Integer(paramc.l());
    }
    return new Long(paramc.d());
  }
  
  protected final void a(f paramf, Vector paramVector, d paramd)
    throws IOException
  {
    int m = 0;
    if (paramf.e())
    {
      paramd.e(paramf.b(), 2);
      m = 0;
      int n = 0;
      while (m < paramVector.size())
      {
        n += a(false, paramf, paramVector.elementAt(m));
        m += 1;
      }
      paramd.l(n);
      m = 0;
      while (m < paramVector.size())
      {
        a(false, paramf, paramVector.elementAt(m), paramd);
        m += 1;
      }
    }
    while (m < paramVector.size())
    {
      a(true, paramf, paramVector.elementAt(m), paramd);
      m += 1;
    }
  }
  
  protected final void a(boolean paramBoolean, f paramf, Object paramObject, d paramd)
    throws IOException
  {
    if (paramBoolean) {
      paramd.e(paramf.b(), this.l);
    }
    switch (this.j)
    {
    case 7: 
    default: 
      throw new RuntimeException("Should never reach this point.");
    case 0: 
      paramd.a(((Boolean)paramObject).booleanValue());
      return;
    case 1: 
      paramd.a((b)paramObject);
      return;
    case 2: 
      paramd.a(((Double)paramObject).doubleValue());
      return;
    case 3: 
      paramd.d(((e)paramObject).a());
      return;
    case 4: 
      paramd.b(((Integer)paramObject).intValue());
      return;
    case 5: 
      paramd.c(((Long)paramObject).longValue());
      return;
    case 6: 
      paramd.a(((Float)paramObject).floatValue());
      return;
    case 8: 
      paramd.a(((Integer)paramObject).intValue());
      return;
    case 9: 
      paramd.b(((Long)paramObject).longValue());
      return;
    case 10: 
      paramd.a((g)paramObject);
      return;
    case 11: 
      paramd.e(((Integer)paramObject).intValue());
      return;
    case 12: 
      paramd.d(((Long)paramObject).longValue());
      return;
    case 13: 
      paramd.f(((Integer)paramObject).intValue());
      return;
    case 14: 
      paramd.e(((Long)paramObject).longValue());
      return;
    case 15: 
      paramd.a((String)paramObject);
      return;
    case 16: 
      paramd.c(((Integer)paramObject).intValue());
      return;
    }
    paramd.a(((Long)paramObject).longValue());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */