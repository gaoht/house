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
import java.util.Map.Entry;
import java.util.Set;

public class bn
  implements cg<bn, e>, Serializable, Cloneable
{
  public static final Map<e, cs> d;
  private static final long e = 2846460275012375038L;
  private static final dk f = new dk("Imprint");
  private static final da g = new da("property", (byte)13, (short)1);
  private static final da h = new da("version", (byte)8, (short)2);
  private static final da i = new da("checksum", (byte)11, (short)3);
  private static final Map<Class<? extends dn>, do> j = new HashMap();
  private static final int k = 0;
  public Map<String, bo> a;
  public int b;
  public String c;
  private byte l = 0;
  
  static
  {
    j.put(dp.class, new b(null));
    j.put(dq.class, new d(null));
    EnumMap localEnumMap = new EnumMap(e.class);
    localEnumMap.put(e.a, new cs("property", (byte)1, new cv((byte)13, new ct((byte)11), new cx((byte)12, bo.class))));
    localEnumMap.put(e.b, new cs("version", (byte)1, new ct((byte)8)));
    localEnumMap.put(e.c, new cs("checksum", (byte)1, new ct((byte)11)));
    d = Collections.unmodifiableMap(localEnumMap);
    cs.a(bn.class, d);
  }
  
  public bn() {}
  
  public bn(bn parambn)
  {
    this.l = parambn.l;
    if (parambn.f())
    {
      HashMap localHashMap = new HashMap();
      Iterator localIterator = parambn.a.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localHashMap.put((String)localEntry.getKey(), new bo((bo)localEntry.getValue()));
      }
      this.a = localHashMap;
    }
    this.b = parambn.b;
    if (parambn.l()) {
      this.c = parambn.c;
    }
  }
  
  public bn(Map<String, bo> paramMap, int paramInt, String paramString)
  {
    this();
    this.a = paramMap;
    this.b = paramInt;
    b(true);
    this.c = paramString;
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
  
  public bn a()
  {
    return new bn(this);
  }
  
  public bn a(int paramInt)
  {
    this.b = paramInt;
    b(true);
    return this;
  }
  
  public bn a(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public bn a(Map<String, bo> paramMap)
  {
    this.a = paramMap;
    return this;
  }
  
  public void a(df paramdf)
    throws cm
  {
    ((do)j.get(paramdf.D())).b().b(paramdf, this);
  }
  
  public void a(String paramString, bo parambo)
  {
    if (this.a == null) {
      this.a = new HashMap();
    }
    this.a.put(paramString, parambo);
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
    this.b = 0;
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
  
  public int c()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.size();
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
  
  public Map<String, bo> d()
  {
    return this.a;
  }
  
  public void e()
  {
    this.a = null;
  }
  
  public boolean f()
  {
    return this.a != null;
  }
  
  public int g()
  {
    return this.b;
  }
  
  public void h()
  {
    this.l = cd.b(this.l, 0);
  }
  
  public boolean i()
  {
    return cd.a(this.l, 0);
  }
  
  public String j()
  {
    return this.c;
  }
  
  public void k()
  {
    this.c = null;
  }
  
  public boolean l()
  {
    return this.c != null;
  }
  
  public void m()
    throws cm
  {
    if (this.a == null) {
      throw new dg("Required field 'property' was not present! Struct: " + toString());
    }
    if (this.c == null) {
      throw new dg("Required field 'checksum' was not present! Struct: " + toString());
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Imprint(");
    localStringBuilder.append("property:");
    if (this.a == null)
    {
      localStringBuilder.append("null");
      localStringBuilder.append(", ");
      localStringBuilder.append("version:");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", ");
      localStringBuilder.append("checksum:");
      if (this.c != null) {
        break label115;
      }
      localStringBuilder.append("null");
    }
    for (;;)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
      break;
      label115:
      localStringBuilder.append(this.c);
    }
  }
  
  private static class a
    extends dp<bn>
  {
    public void a(df paramdf, bn parambn)
      throws cm
    {
      paramdf.j();
      Object localObject = paramdf.l();
      if (((da)localObject).b == 0)
      {
        paramdf.k();
        if (!parambn.i()) {
          throw new dg("Required field 'version' was not found in serialized data! Struct: " + toString());
        }
      }
      else
      {
        switch (((da)localObject).c)
        {
        default: 
          di.a(paramdf, ((da)localObject).b);
        }
        for (;;)
        {
          paramdf.m();
          break;
          if (((da)localObject).b == 13)
          {
            localObject = paramdf.n();
            parambn.a = new HashMap(((dc)localObject).c * 2);
            int i = 0;
            while (i < ((dc)localObject).c)
            {
              String str = paramdf.z();
              bo localbo = new bo();
              localbo.a(paramdf);
              parambn.a.put(str, localbo);
              i += 1;
            }
            paramdf.o();
            parambn.a(true);
          }
          else
          {
            di.a(paramdf, ((da)localObject).b);
            continue;
            if (((da)localObject).b == 8)
            {
              parambn.b = paramdf.w();
              parambn.b(true);
            }
            else
            {
              di.a(paramdf, ((da)localObject).b);
              continue;
              if (((da)localObject).b == 11)
              {
                parambn.c = paramdf.z();
                parambn.c(true);
              }
              else
              {
                di.a(paramdf, ((da)localObject).b);
              }
            }
          }
        }
      }
      parambn.m();
    }
    
    public void b(df paramdf, bn parambn)
      throws cm
    {
      parambn.m();
      paramdf.a(bn.n());
      if (parambn.a != null)
      {
        paramdf.a(bn.o());
        paramdf.a(new dc((byte)11, (byte)12, parambn.a.size()));
        Iterator localIterator = parambn.a.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          paramdf.a((String)localEntry.getKey());
          ((bo)localEntry.getValue()).b(paramdf);
        }
        paramdf.e();
        paramdf.c();
      }
      paramdf.a(bn.q());
      paramdf.a(parambn.b);
      paramdf.c();
      if (parambn.c != null)
      {
        paramdf.a(bn.r());
        paramdf.a(parambn.c);
        paramdf.c();
      }
      paramdf.d();
      paramdf.b();
    }
  }
  
  private static class b
    implements do
  {
    public bn.a a()
    {
      return new bn.a(null);
    }
  }
  
  private static class c
    extends dq<bn>
  {
    public void a(df paramdf, bn parambn)
      throws cm
    {
      paramdf = (dl)paramdf;
      paramdf.a(parambn.a.size());
      Iterator localIterator = parambn.a.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramdf.a((String)localEntry.getKey());
        ((bo)localEntry.getValue()).b(paramdf);
      }
      paramdf.a(parambn.b);
      paramdf.a(parambn.c);
    }
    
    public void b(df paramdf, bn parambn)
      throws cm
    {
      paramdf = (dl)paramdf;
      dc localdc = new dc((byte)11, (byte)12, paramdf.w());
      parambn.a = new HashMap(localdc.c * 2);
      int i = 0;
      while (i < localdc.c)
      {
        String str = paramdf.z();
        bo localbo = new bo();
        localbo.a(paramdf);
        parambn.a.put(str, localbo);
        i += 1;
      }
      parambn.a(true);
      parambn.b = paramdf.w();
      parambn.b(true);
      parambn.c = paramdf.z();
      parambn.c(true);
    }
  }
  
  private static class d
    implements do
  {
    public bn.c a()
    {
      return new bn.c(null);
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */