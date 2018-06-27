package com.umeng.analytics.pro;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class bl
  implements cg<bl, e>, Serializable, Cloneable
{
  public static final Map<e, cs> d;
  private static final long e = -6496538196005191531L;
  private static final dk f = new dk("IdSnapshot");
  private static final da g = new da("identity", (byte)11, (short)1);
  private static final da h = new da("ts", (byte)10, (short)2);
  private static final da i = new da("version", (byte)8, (short)3);
  private static final Map<Class<? extends dn>, do> j = new HashMap();
  private static final int k = 0;
  private static final int l = 1;
  public String a;
  public long b;
  public int c;
  private byte m = 0;
  
  static
  {
    j.put(dp.class, new b(null));
    j.put(dq.class, new d(null));
    EnumMap localEnumMap = new EnumMap(e.class);
    localEnumMap.put(e.a, new cs("identity", (byte)1, new ct((byte)11)));
    localEnumMap.put(e.b, new cs("ts", (byte)1, new ct((byte)10)));
    localEnumMap.put(e.c, new cs("version", (byte)1, new ct((byte)8)));
    d = Collections.unmodifiableMap(localEnumMap);
    cs.a(bl.class, d);
  }
  
  public bl() {}
  
  public bl(bl parambl)
  {
    this.m = parambl.m;
    if (parambl.e()) {
      this.a = parambl.a;
    }
    this.b = parambl.b;
    this.c = parambl.c;
  }
  
  public bl(String paramString, long paramLong, int paramInt)
  {
    this();
    this.a = paramString;
    this.b = paramLong;
    b(true);
    this.c = paramInt;
    c(true);
  }
  
  private void a(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    try
    {
      this.m = 0;
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
  
  public bl a()
  {
    return new bl(this);
  }
  
  public bl a(int paramInt)
  {
    this.c = paramInt;
    c(true);
    return this;
  }
  
  public bl a(long paramLong)
  {
    this.b = paramLong;
    b(true);
    return this;
  }
  
  public bl a(String paramString)
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
  
  public void b()
  {
    this.a = null;
    b(false);
    this.b = 0L;
    c(false);
    this.c = 0;
  }
  
  public void b(df paramdf)
    throws cm
  {
    ((do)j.get(paramdf.D())).b().a(paramdf, this);
  }
  
  public void b(boolean paramBoolean)
  {
    this.m = cd.a(this.m, 0, paramBoolean);
  }
  
  public e c(int paramInt)
  {
    return e.a(paramInt);
  }
  
  public String c()
  {
    return this.a;
  }
  
  public void c(boolean paramBoolean)
  {
    this.m = cd.a(this.m, 1, paramBoolean);
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
    this.m = cd.b(this.m, 0);
  }
  
  public boolean h()
  {
    return cd.a(this.m, 0);
  }
  
  public int i()
  {
    return this.c;
  }
  
  public void j()
  {
    this.m = cd.b(this.m, 1);
  }
  
  public boolean k()
  {
    return cd.a(this.m, 1);
  }
  
  public void l()
    throws cm
  {
    if (this.a == null) {
      throw new dg("Required field 'identity' was not present! Struct: " + toString());
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("IdSnapshot(");
    localStringBuilder.append("identity:");
    if (this.a == null) {
      localStringBuilder.append("null");
    }
    for (;;)
    {
      localStringBuilder.append(", ");
      localStringBuilder.append("ts:");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", ");
      localStringBuilder.append("version:");
      localStringBuilder.append(this.c);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
    }
  }
  
  private static class a
    extends dp<bl>
  {
    public void a(df paramdf, bl parambl)
      throws cm
    {
      paramdf.j();
      da localda = paramdf.l();
      if (localda.b == 0)
      {
        paramdf.k();
        if (!parambl.h()) {
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
            parambl.a = paramdf.z();
            parambl.a(true);
          }
          else
          {
            di.a(paramdf, localda.b);
            continue;
            if (localda.b == 10)
            {
              parambl.b = paramdf.x();
              parambl.b(true);
            }
            else
            {
              di.a(paramdf, localda.b);
              continue;
              if (localda.b == 8)
              {
                parambl.c = paramdf.w();
                parambl.c(true);
              }
              else
              {
                di.a(paramdf, localda.b);
              }
            }
          }
        }
      }
      if (!parambl.k()) {
        throw new dg("Required field 'version' was not found in serialized data! Struct: " + toString());
      }
      parambl.l();
    }
    
    public void b(df paramdf, bl parambl)
      throws cm
    {
      parambl.l();
      paramdf.a(bl.m());
      if (parambl.a != null)
      {
        paramdf.a(bl.n());
        paramdf.a(parambl.a);
        paramdf.c();
      }
      paramdf.a(bl.o());
      paramdf.a(parambl.b);
      paramdf.c();
      paramdf.a(bl.q());
      paramdf.a(parambl.c);
      paramdf.c();
      paramdf.d();
      paramdf.b();
    }
  }
  
  private static class b
    implements do
  {
    public bl.a a()
    {
      return new bl.a(null);
    }
  }
  
  private static class c
    extends dq<bl>
  {
    public void a(df paramdf, bl parambl)
      throws cm
    {
      paramdf = (dl)paramdf;
      paramdf.a(parambl.a);
      paramdf.a(parambl.b);
      paramdf.a(parambl.c);
    }
    
    public void b(df paramdf, bl parambl)
      throws cm
    {
      paramdf = (dl)paramdf;
      parambl.a = paramdf.z();
      parambl.a(true);
      parambl.b = paramdf.x();
      parambl.b(true);
      parambl.c = paramdf.w();
      parambl.c(true);
    }
  }
  
  private static class d
    implements do
  {
    public bl.c a()
    {
      return new bl.c(null);
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */