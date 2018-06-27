package com.umeng.analytics.pro;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class bp
  implements cg<bp, e>, Serializable, Cloneable
{
  public static final Map<e, cs> d;
  private static final long e = -4549277923241195391L;
  private static final dk f = new dk("Response");
  private static final da g = new da("resp_code", (byte)8, (short)1);
  private static final da h = new da("msg", (byte)11, (short)2);
  private static final da i = new da("imprint", (byte)12, (short)3);
  private static final Map<Class<? extends dn>, do> j = new HashMap();
  private static final int k = 0;
  public int a;
  public String b;
  public bn c;
  private byte l = 0;
  private e[] m = { e.b, e.c };
  
  static
  {
    j.put(dp.class, new b(null));
    j.put(dq.class, new d(null));
    EnumMap localEnumMap = new EnumMap(e.class);
    localEnumMap.put(e.a, new cs("resp_code", (byte)1, new ct((byte)8)));
    localEnumMap.put(e.b, new cs("msg", (byte)2, new ct((byte)11)));
    localEnumMap.put(e.c, new cs("imprint", (byte)2, new cx((byte)12, bn.class)));
    d = Collections.unmodifiableMap(localEnumMap);
    cs.a(bp.class, d);
  }
  
  public bp() {}
  
  public bp(int paramInt)
  {
    this();
    this.a = paramInt;
    a(true);
  }
  
  public bp(bp parambp)
  {
    this.l = parambp.l;
    this.a = parambp.a;
    if (parambp.h()) {
      this.b = parambp.b;
    }
    if (parambp.k()) {
      this.c = new bn(parambp.c);
    }
  }
  
  private void a(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    try
    {
      this.l = 0;
      a(new cz(new dr(paramObjectInputStream)));
      return;
    }
    catch (cm paramObjectInputStream)
    {
      throw new IOException(paramObjectInputStream.getMessage());
    }
  }
  
  private void a(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    try
    {
      b(new cz(new dr(paramObjectOutputStream)));
      return;
    }
    catch (cm paramObjectOutputStream)
    {
      throw new IOException(paramObjectOutputStream.getMessage());
    }
  }
  
  public bp a()
  {
    return new bp(this);
  }
  
  public bp a(int paramInt)
  {
    this.a = paramInt;
    a(true);
    return this;
  }
  
  public bp a(bn parambn)
  {
    this.c = parambn;
    return this;
  }
  
  public bp a(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public void a(df paramdf)
    throws cm
  {
    ((do)j.get(paramdf.D())).b().b(paramdf, this);
  }
  
  public void a(boolean paramBoolean)
  {
    this.l = cd.a(this.l, 0, paramBoolean);
  }
  
  public void b()
  {
    a(false);
    this.a = 0;
    this.b = null;
    this.c = null;
  }
  
  public void b(df paramdf)
    throws cm
  {
    ((do)j.get(paramdf.D())).b().a(paramdf, this);
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.b = null;
    }
  }
  
  public int c()
  {
    return this.a;
  }
  
  public e c(int paramInt)
  {
    return e.a(paramInt);
  }
  
  public void c(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.c = null;
    }
  }
  
  public void d()
  {
    this.l = cd.b(this.l, 0);
  }
  
  public boolean e()
  {
    return cd.a(this.l, 0);
  }
  
  public String f()
  {
    return this.b;
  }
  
  public void g()
  {
    this.b = null;
  }
  
  public boolean h()
  {
    return this.b != null;
  }
  
  public bn i()
  {
    return this.c;
  }
  
  public void j()
  {
    this.c = null;
  }
  
  public boolean k()
  {
    return this.c != null;
  }
  
  public void l()
    throws cm
  {
    if (this.c != null) {
      this.c.m();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Response(");
    localStringBuilder.append("resp_code:");
    localStringBuilder.append(this.a);
    if (h())
    {
      localStringBuilder.append(", ");
      localStringBuilder.append("msg:");
      if (this.b == null) {
        localStringBuilder.append("null");
      }
    }
    else if (k())
    {
      localStringBuilder.append(", ");
      localStringBuilder.append("imprint:");
      if (this.c != null) {
        break label129;
      }
      localStringBuilder.append("null");
    }
    for (;;)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.b);
      break;
      label129:
      localStringBuilder.append(this.c);
    }
  }
  
  private static class a
    extends dp<bp>
  {
    public void a(df paramdf, bp parambp)
      throws cm
    {
      paramdf.j();
      da localda = paramdf.l();
      if (localda.b == 0)
      {
        paramdf.k();
        if (!parambp.e()) {
          throw new dg("Required field 'resp_code' was not found in serialized data! Struct: " + toString());
        }
      }
      else
      {
        switch (localda.c)
        {
        default: 
          di.a(paramdf, localda.b);
        }
        for (;;)
        {
          paramdf.m();
          break;
          if (localda.b == 8)
          {
            parambp.a = paramdf.w();
            parambp.a(true);
          }
          else
          {
            di.a(paramdf, localda.b);
            continue;
            if (localda.b == 11)
            {
              parambp.b = paramdf.z();
              parambp.b(true);
            }
            else
            {
              di.a(paramdf, localda.b);
              continue;
              if (localda.b == 12)
              {
                parambp.c = new bn();
                parambp.c.a(paramdf);
                parambp.c(true);
              }
              else
              {
                di.a(paramdf, localda.b);
              }
            }
          }
        }
      }
      parambp.l();
    }
    
    public void b(df paramdf, bp parambp)
      throws cm
    {
      parambp.l();
      paramdf.a(bp.m());
      paramdf.a(bp.n());
      paramdf.a(parambp.a);
      paramdf.c();
      if ((parambp.b != null) && (parambp.h()))
      {
        paramdf.a(bp.o());
        paramdf.a(parambp.b);
        paramdf.c();
      }
      if ((parambp.c != null) && (parambp.k()))
      {
        paramdf.a(bp.q());
        parambp.c.b(paramdf);
        paramdf.c();
      }
      paramdf.d();
      paramdf.b();
    }
  }
  
  private static class b
    implements do
  {
    public bp.a a()
    {
      return new bp.a(null);
    }
  }
  
  private static class c
    extends dq<bp>
  {
    public void a(df paramdf, bp parambp)
      throws cm
    {
      paramdf = (dl)paramdf;
      paramdf.a(parambp.a);
      BitSet localBitSet = new BitSet();
      if (parambp.h()) {
        localBitSet.set(0);
      }
      if (parambp.k()) {
        localBitSet.set(1);
      }
      paramdf.a(localBitSet, 2);
      if (parambp.h()) {
        paramdf.a(parambp.b);
      }
      if (parambp.k()) {
        parambp.c.b(paramdf);
      }
    }
    
    public void b(df paramdf, bp parambp)
      throws cm
    {
      paramdf = (dl)paramdf;
      parambp.a = paramdf.w();
      parambp.a(true);
      BitSet localBitSet = paramdf.b(2);
      if (localBitSet.get(0))
      {
        parambp.b = paramdf.z();
        parambp.b(true);
      }
      if (localBitSet.get(1))
      {
        parambp.c = new bn();
        parambp.c.a(paramdf);
        parambp.c(true);
      }
    }
  }
  
  private static class d
    implements do
  {
    public bp.c a()
    {
      return new bp.c(null);
    }
  }
  
  public static enum e
    implements cn
  {
    private static final Map<String, e> d;
    private final short e;
    private final String f;
    
    static
    {
      d = new HashMap();
      Iterator localIterator = EnumSet.allOf(e.class).iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        d.put(locale.b(), locale);
      }
    }
    
    private e(short paramShort, String paramString)
    {
      this.e = paramShort;
      this.f = paramString;
    }
    
    public static e a(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return a;
      case 2: 
        return b;
      }
      return c;
    }
    
    public static e a(String paramString)
    {
      return (e)d.get(paramString);
    }
    
    public static e b(int paramInt)
    {
      e locale = a(paramInt);
      if (locale == null) {
        throw new IllegalArgumentException("Field " + paramInt + " doesn't exist!");
      }
      return locale;
    }
    
    public short a()
    {
      return this.e;
    }
    
    public String b()
    {
      return this.f;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */