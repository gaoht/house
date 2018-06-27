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

public class bo
  implements cg<bo, e>, Serializable, Cloneable
{
  public static final Map<e, cs> d;
  private static final long e = 7501688097813630241L;
  private static final dk f = new dk("ImprintValue");
  private static final da g = new da("value", (byte)11, (short)1);
  private static final da h = new da("ts", (byte)10, (short)2);
  private static final da i = new da("guid", (byte)11, (short)3);
  private static final Map<Class<? extends dn>, do> j = new HashMap();
  private static final int k = 0;
  public String a;
  public long b;
  public String c;
  private byte l = 0;
  private e[] m = { e.a };
  
  static
  {
    j.put(dp.class, new b(null));
    j.put(dq.class, new d(null));
    EnumMap localEnumMap = new EnumMap(e.class);
    localEnumMap.put(e.a, new cs("value", (byte)2, new ct((byte)11)));
    localEnumMap.put(e.b, new cs("ts", (byte)1, new ct((byte)10)));
    localEnumMap.put(e.c, new cs("guid", (byte)1, new ct((byte)11)));
    d = Collections.unmodifiableMap(localEnumMap);
    cs.a(bo.class, d);
  }
  
  public bo() {}
  
  public bo(long paramLong, String paramString)
  {
    this();
    this.b = paramLong;
    b(true);
    this.c = paramString;
  }
  
  public bo(bo parambo)
  {
    this.l = parambo.l;
    if (parambo.e()) {
      this.a = parambo.a;
    }
    this.b = parambo.b;
    if (parambo.k()) {
      this.c = parambo.c;
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
  
  public e a(int paramInt)
  {
    return e.a(paramInt);
  }
  
  public bo a()
  {
    return new bo(this);
  }
  
  public bo a(long paramLong)
  {
    this.b = paramLong;
    b(true);
    return this;
  }
  
  public bo a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public void a(df paramdf)
    throws cm
  {
    ((do)j.get(paramdf.D())).b().b(paramdf, this);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.a = null;
    }
  }
  
  public bo b(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public void b()
  {
    this.a = null;
    b(false);
    this.b = 0L;
    this.c = null;
  }
  
  public void b(df paramdf)
    throws cm
  {
    ((do)j.get(paramdf.D())).b().a(paramdf, this);
  }
  
  public void b(boolean paramBoolean)
  {
    this.l = cd.a(this.l, 0, paramBoolean);
  }
  
  public String c()
  {
    return this.a;
  }
  
  public void c(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.c = null;
    }
  }
  
  public void d()
  {
    this.a = null;
  }
  
  public boolean e()
  {
    return this.a != null;
  }
  
  public long f()
  {
    return this.b;
  }
  
  public void g()
  {
    this.l = cd.b(this.l, 0);
  }
  
  public boolean h()
  {
    return cd.a(this.l, 0);
  }
  
  public String i()
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
    if (this.c == null) {
      throw new dg("Required field 'guid' was not present! Struct: " + toString());
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ImprintValue(");
    int n = 1;
    if (e())
    {
      localStringBuilder.append("value:");
      if (this.a == null)
      {
        localStringBuilder.append("null");
        n = 0;
      }
    }
    else
    {
      if (n == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("ts:");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", ");
      localStringBuilder.append("guid:");
      if (this.c != null) {
        break label130;
      }
      localStringBuilder.append("null");
    }
    for (;;)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
      break;
      label130:
      localStringBuilder.append(this.c);
    }
  }
  
  private static class a
    extends dp<bo>
  {
    public void a(df paramdf, bo parambo)
      throws cm
    {
      paramdf.j();
      da localda = paramdf.l();
      if (localda.b == 0)
      {
        paramdf.k();
        if (!parambo.h()) {
          throw new dg("Required field 'ts' was not found in serialized data! Struct: " + toString());
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
          if (localda.b == 11)
          {
            parambo.a = paramdf.z();
            parambo.a(true);
          }
          else
          {
            di.a(paramdf, localda.b);
            continue;
            if (localda.b == 10)
            {
              parambo.b = paramdf.x();
              parambo.b(true);
            }
            else
            {
              di.a(paramdf, localda.b);
              continue;
              if (localda.b == 11)
              {
                parambo.c = paramdf.z();
                parambo.c(true);
              }
              else
              {
                di.a(paramdf, localda.b);
              }
            }
          }
        }
      }
      parambo.l();
    }
    
    public void b(df paramdf, bo parambo)
      throws cm
    {
      parambo.l();
      paramdf.a(bo.m());
      if ((parambo.a != null) && (parambo.e()))
      {
        paramdf.a(bo.n());
        paramdf.a(parambo.a);
        paramdf.c();
      }
      paramdf.a(bo.o());
      paramdf.a(parambo.b);
      paramdf.c();
      if (parambo.c != null)
      {
        paramdf.a(bo.q());
        paramdf.a(parambo.c);
        paramdf.c();
      }
      paramdf.d();
      paramdf.b();
    }
  }
  
  private static class b
    implements do
  {
    public bo.a a()
    {
      return new bo.a(null);
    }
  }
  
  private static class c
    extends dq<bo>
  {
    public void a(df paramdf, bo parambo)
      throws cm
    {
      paramdf = (dl)paramdf;
      paramdf.a(parambo.b);
      paramdf.a(parambo.c);
      BitSet localBitSet = new BitSet();
      if (parambo.e()) {
        localBitSet.set(0);
      }
      paramdf.a(localBitSet, 1);
      if (parambo.e()) {
        paramdf.a(parambo.a);
      }
    }
    
    public void b(df paramdf, bo parambo)
      throws cm
    {
      paramdf = (dl)paramdf;
      parambo.b = paramdf.x();
      parambo.b(true);
      parambo.c = paramdf.z();
      parambo.c(true);
      if (paramdf.b(1).get(0))
      {
        parambo.a = paramdf.z();
        parambo.a(true);
      }
    }
  }
  
  private static class d
    implements do
  {
    public bo.c a()
    {
      return new bo.c(null);
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */