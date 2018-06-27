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

public class bk
  implements cg<bk, e>, Serializable, Cloneable
{
  public static final Map<e, cs> e;
  private static final long f = 9132678615281394583L;
  private static final dk g = new dk("IdJournal");
  private static final da h = new da("domain", (byte)11, (short)1);
  private static final da i = new da("old_id", (byte)11, (short)2);
  private static final da j = new da("new_id", (byte)11, (short)3);
  private static final da k = new da("ts", (byte)10, (short)4);
  private static final Map<Class<? extends dn>, do> l = new HashMap();
  private static final int m = 0;
  public String a;
  public String b;
  public String c;
  public long d;
  private byte n = 0;
  private e[] o = { e.b };
  
  static
  {
    l.put(dp.class, new b(null));
    l.put(dq.class, new d(null));
    EnumMap localEnumMap = new EnumMap(e.class);
    localEnumMap.put(e.a, new cs("domain", (byte)1, new ct((byte)11)));
    localEnumMap.put(e.b, new cs("old_id", (byte)2, new ct((byte)11)));
    localEnumMap.put(e.c, new cs("new_id", (byte)1, new ct((byte)11)));
    localEnumMap.put(e.d, new cs("ts", (byte)1, new ct((byte)10)));
    e = Collections.unmodifiableMap(localEnumMap);
    cs.a(bk.class, e);
  }
  
  public bk() {}
  
  public bk(bk parambk)
  {
    this.n = parambk.n;
    if (parambk.e()) {
      this.a = parambk.a;
    }
    if (parambk.h()) {
      this.b = parambk.b;
    }
    if (parambk.k()) {
      this.c = parambk.c;
    }
    this.d = parambk.d;
  }
  
  public bk(String paramString1, String paramString2, long paramLong)
  {
    this();
    this.a = paramString1;
    this.c = paramString2;
    this.d = paramLong;
    d(true);
  }
  
  private void a(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    try
    {
      this.n = 0;
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
  
  public bk a()
  {
    return new bk(this);
  }
  
  public bk a(long paramLong)
  {
    this.d = paramLong;
    d(true);
    return this;
  }
  
  public bk a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public void a(df paramdf)
    throws cm
  {
    ((do)l.get(paramdf.D())).b().b(paramdf, this);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.a = null;
    }
  }
  
  public bk b(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public void b()
  {
    this.a = null;
    this.b = null;
    this.c = null;
    d(false);
    this.d = 0L;
  }
  
  public void b(df paramdf)
    throws cm
  {
    ((do)l.get(paramdf.D())).b().a(paramdf, this);
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.b = null;
    }
  }
  
  public bk c(String paramString)
  {
    this.c = paramString;
    return this;
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
  
  public void d(boolean paramBoolean)
  {
    this.n = cd.a(this.n, 0, paramBoolean);
  }
  
  public boolean e()
  {
    return this.a != null;
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
  
  public long l()
  {
    return this.d;
  }
  
  public void m()
  {
    this.n = cd.b(this.n, 0);
  }
  
  public boolean n()
  {
    return cd.a(this.n, 0);
  }
  
  public void o()
    throws cm
  {
    if (this.a == null) {
      throw new dg("Required field 'domain' was not present! Struct: " + toString());
    }
    if (this.c == null) {
      throw new dg("Required field 'new_id' was not present! Struct: " + toString());
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("IdJournal(");
    localStringBuilder.append("domain:");
    if (this.a == null)
    {
      localStringBuilder.append("null");
      if (h())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("old_id:");
        if (this.b != null) {
          break label153;
        }
        localStringBuilder.append("null");
      }
      label72:
      localStringBuilder.append(", ");
      localStringBuilder.append("new_id:");
      if (this.c != null) {
        break label165;
      }
      localStringBuilder.append("null");
    }
    for (;;)
    {
      localStringBuilder.append(", ");
      localStringBuilder.append("ts:");
      localStringBuilder.append(this.d);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
      break;
      label153:
      localStringBuilder.append(this.b);
      break label72;
      label165:
      localStringBuilder.append(this.c);
    }
  }
  
  private static class a
    extends dp<bk>
  {
    public void a(df paramdf, bk parambk)
      throws cm
    {
      paramdf.j();
      da localda = paramdf.l();
      if (localda.b == 0)
      {
        paramdf.k();
        if (!parambk.n()) {
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
            parambk.a = paramdf.z();
            parambk.a(true);
          }
          else
          {
            di.a(paramdf, localda.b);
            continue;
            if (localda.b == 11)
            {
              parambk.b = paramdf.z();
              parambk.b(true);
            }
            else
            {
              di.a(paramdf, localda.b);
              continue;
              if (localda.b == 11)
              {
                parambk.c = paramdf.z();
                parambk.c(true);
              }
              else
              {
                di.a(paramdf, localda.b);
                continue;
                if (localda.b == 10)
                {
                  parambk.d = paramdf.x();
                  parambk.d(true);
                }
                else
                {
                  di.a(paramdf, localda.b);
                }
              }
            }
          }
        }
      }
      parambk.o();
    }
    
    public void b(df paramdf, bk parambk)
      throws cm
    {
      parambk.o();
      paramdf.a(bk.q());
      if (parambk.a != null)
      {
        paramdf.a(bk.r());
        paramdf.a(parambk.a);
        paramdf.c();
      }
      if ((parambk.b != null) && (parambk.h()))
      {
        paramdf.a(bk.s());
        paramdf.a(parambk.b);
        paramdf.c();
      }
      if (parambk.c != null)
      {
        paramdf.a(bk.t());
        paramdf.a(parambk.c);
        paramdf.c();
      }
      paramdf.a(bk.u());
      paramdf.a(parambk.d);
      paramdf.c();
      paramdf.d();
      paramdf.b();
    }
  }
  
  private static class b
    implements do
  {
    public bk.a a()
    {
      return new bk.a(null);
    }
  }
  
  private static class c
    extends dq<bk>
  {
    public void a(df paramdf, bk parambk)
      throws cm
    {
      paramdf = (dl)paramdf;
      paramdf.a(parambk.a);
      paramdf.a(parambk.c);
      paramdf.a(parambk.d);
      BitSet localBitSet = new BitSet();
      if (parambk.h()) {
        localBitSet.set(0);
      }
      paramdf.a(localBitSet, 1);
      if (parambk.h()) {
        paramdf.a(parambk.b);
      }
    }
    
    public void b(df paramdf, bk parambk)
      throws cm
    {
      paramdf = (dl)paramdf;
      parambk.a = paramdf.z();
      parambk.a(true);
      parambk.c = paramdf.z();
      parambk.c(true);
      parambk.d = paramdf.x();
      parambk.d(true);
      if (paramdf.b(1).get(0))
      {
        parambk.b = paramdf.z();
        parambk.b(true);
      }
    }
  }
  
  private static class d
    implements do
  {
    public bk.c a()
    {
      return new bk.c(null);
    }
  }
  
  public static enum e
    implements cn
  {
    private static final Map<String, e> e;
    private final short f;
    private final String g;
    
    static
    {
      e = new HashMap();
      Iterator localIterator = EnumSet.allOf(e.class).iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        e.put(locale.b(), locale);
      }
    }
    
    private e(short paramShort, String paramString)
    {
      this.f = paramShort;
      this.g = paramString;
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
      case 3: 
        return c;
      }
      return d;
    }
    
    public static e a(String paramString)
    {
      return (e)e.get(paramString);
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
      return this.f;
    }
    
    public String b()
    {
      return this.g;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */