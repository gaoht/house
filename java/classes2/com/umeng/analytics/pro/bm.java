package com.umeng.analytics.pro;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class bm
  implements cg<bm, e>, Serializable, Cloneable
{
  public static final Map<e, cs> d;
  private static final long e = -5764118265293965743L;
  private static final dk f = new dk("IdTracking");
  private static final da g = new da("snapshots", (byte)13, (short)1);
  private static final da h = new da("journals", (byte)15, (short)2);
  private static final da i = new da("checksum", (byte)11, (short)3);
  private static final Map<Class<? extends dn>, do> j = new HashMap();
  public Map<String, bl> a;
  public List<bk> b;
  public String c;
  private e[] k = { e.b, e.c };
  
  static
  {
    j.put(dp.class, new b(null));
    j.put(dq.class, new d(null));
    EnumMap localEnumMap = new EnumMap(e.class);
    localEnumMap.put(e.a, new cs("snapshots", (byte)1, new cv((byte)13, new ct((byte)11), new cx((byte)12, bl.class))));
    localEnumMap.put(e.b, new cs("journals", (byte)2, new cu((byte)15, new cx((byte)12, bk.class))));
    localEnumMap.put(e.c, new cs("checksum", (byte)2, new ct((byte)11)));
    d = Collections.unmodifiableMap(localEnumMap);
    cs.a(bm.class, d);
  }
  
  public bm() {}
  
  public bm(bm parambm)
  {
    Object localObject;
    Iterator localIterator;
    if (parambm.f())
    {
      localObject = new HashMap();
      localIterator = parambm.a.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        ((Map)localObject).put((String)localEntry.getKey(), new bl((bl)localEntry.getValue()));
      }
      this.a = ((Map)localObject);
    }
    if (parambm.k())
    {
      localObject = new ArrayList();
      localIterator = parambm.b.iterator();
      while (localIterator.hasNext()) {
        ((List)localObject).add(new bk((bk)localIterator.next()));
      }
      this.b = ((List)localObject);
    }
    if (parambm.n()) {
      this.c = parambm.c;
    }
  }
  
  public bm(Map<String, bl> paramMap)
  {
    this();
    this.a = paramMap;
  }
  
  private void a(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    try
    {
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
  
  public bm a()
  {
    return new bm(this);
  }
  
  public bm a(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public bm a(List<bk> paramList)
  {
    this.b = paramList;
    return this;
  }
  
  public bm a(Map<String, bl> paramMap)
  {
    this.a = paramMap;
    return this;
  }
  
  public void a(bk parambk)
  {
    if (this.b == null) {
      this.b = new ArrayList();
    }
    this.b.add(parambk);
  }
  
  public void a(df paramdf)
    throws cm
  {
    ((do)j.get(paramdf.D())).b().b(paramdf, this);
  }
  
  public void a(String paramString, bl parambl)
  {
    if (this.a == null) {
      this.a = new HashMap();
    }
    this.a.put(paramString, parambl);
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
    if (this.a == null) {
      return 0;
    }
    return this.a.size();
  }
  
  public void c(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.c = null;
    }
  }
  
  public Map<String, bl> d()
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
    if (this.b == null) {
      return 0;
    }
    return this.b.size();
  }
  
  public Iterator<bk> h()
  {
    if (this.b == null) {
      return null;
    }
    return this.b.iterator();
  }
  
  public List<bk> i()
  {
    return this.b;
  }
  
  public void j()
  {
    this.b = null;
  }
  
  public boolean k()
  {
    return this.b != null;
  }
  
  public String l()
  {
    return this.c;
  }
  
  public void m()
  {
    this.c = null;
  }
  
  public boolean n()
  {
    return this.c != null;
  }
  
  public void o()
    throws cm
  {
    if (this.a == null) {
      throw new dg("Required field 'snapshots' was not present! Struct: " + toString());
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("IdTracking(");
    localStringBuilder.append("snapshots:");
    if (this.a == null)
    {
      localStringBuilder.append("null");
      if (k())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("journals:");
        if (this.b != null) {
          break label135;
        }
        localStringBuilder.append("null");
      }
      label72:
      if (n())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("checksum:");
        if (this.c != null) {
          break label147;
        }
        localStringBuilder.append("null");
      }
    }
    for (;;)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
      break;
      label135:
      localStringBuilder.append(this.b);
      break label72;
      label147:
      localStringBuilder.append(this.c);
    }
  }
  
  private static class a
    extends dp<bm>
  {
    public void a(df paramdf, bm parambm)
      throws cm
    {
      paramdf.j();
      Object localObject1 = paramdf.l();
      if (((da)localObject1).b == 0)
      {
        paramdf.k();
        parambm.o();
        return;
      }
      switch (((da)localObject1).c)
      {
      default: 
        di.a(paramdf, ((da)localObject1).b);
      }
      for (;;)
      {
        paramdf.m();
        break;
        int i;
        Object localObject2;
        if (((da)localObject1).b == 13)
        {
          localObject1 = paramdf.n();
          parambm.a = new HashMap(((dc)localObject1).c * 2);
          i = 0;
          while (i < ((dc)localObject1).c)
          {
            localObject2 = paramdf.z();
            bl localbl = new bl();
            localbl.a(paramdf);
            parambm.a.put(localObject2, localbl);
            i += 1;
          }
          paramdf.o();
          parambm.a(true);
        }
        else
        {
          di.a(paramdf, ((da)localObject1).b);
          continue;
          if (((da)localObject1).b == 15)
          {
            localObject1 = paramdf.p();
            parambm.b = new ArrayList(((db)localObject1).b);
            i = 0;
            while (i < ((db)localObject1).b)
            {
              localObject2 = new bk();
              ((bk)localObject2).a(paramdf);
              parambm.b.add(localObject2);
              i += 1;
            }
            paramdf.q();
            parambm.b(true);
          }
          else
          {
            di.a(paramdf, ((da)localObject1).b);
            continue;
            if (((da)localObject1).b == 11)
            {
              parambm.c = paramdf.z();
              parambm.c(true);
            }
            else
            {
              di.a(paramdf, ((da)localObject1).b);
            }
          }
        }
      }
    }
    
    public void b(df paramdf, bm parambm)
      throws cm
    {
      parambm.o();
      paramdf.a(bm.q());
      Iterator localIterator;
      if (parambm.a != null)
      {
        paramdf.a(bm.r());
        paramdf.a(new dc((byte)11, (byte)12, parambm.a.size()));
        localIterator = parambm.a.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          paramdf.a((String)localEntry.getKey());
          ((bl)localEntry.getValue()).b(paramdf);
        }
        paramdf.e();
        paramdf.c();
      }
      if ((parambm.b != null) && (parambm.k()))
      {
        paramdf.a(bm.s());
        paramdf.a(new db((byte)12, parambm.b.size()));
        localIterator = parambm.b.iterator();
        while (localIterator.hasNext()) {
          ((bk)localIterator.next()).b(paramdf);
        }
        paramdf.f();
        paramdf.c();
      }
      if ((parambm.c != null) && (parambm.n()))
      {
        paramdf.a(bm.t());
        paramdf.a(parambm.c);
        paramdf.c();
      }
      paramdf.d();
      paramdf.b();
    }
  }
  
  private static class b
    implements do
  {
    public bm.a a()
    {
      return new bm.a(null);
    }
  }
  
  private static class c
    extends dq<bm>
  {
    public void a(df paramdf, bm parambm)
      throws cm
    {
      paramdf = (dl)paramdf;
      paramdf.a(parambm.a.size());
      Object localObject = parambm.a.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        paramdf.a((String)localEntry.getKey());
        ((bl)localEntry.getValue()).b(paramdf);
      }
      localObject = new BitSet();
      if (parambm.k()) {
        ((BitSet)localObject).set(0);
      }
      if (parambm.n()) {
        ((BitSet)localObject).set(1);
      }
      paramdf.a((BitSet)localObject, 2);
      if (parambm.k())
      {
        paramdf.a(parambm.b.size());
        localObject = parambm.b.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((bk)((Iterator)localObject).next()).b(paramdf);
        }
      }
      if (parambm.n()) {
        paramdf.a(parambm.c);
      }
    }
    
    public void b(df paramdf, bm parambm)
      throws cm
    {
      int j = 0;
      paramdf = (dl)paramdf;
      Object localObject1 = new dc((byte)11, (byte)12, paramdf.w());
      parambm.a = new HashMap(((dc)localObject1).c * 2);
      int i = 0;
      Object localObject2;
      Object localObject3;
      while (i < ((dc)localObject1).c)
      {
        localObject2 = paramdf.z();
        localObject3 = new bl();
        ((bl)localObject3).a(paramdf);
        parambm.a.put(localObject2, localObject3);
        i += 1;
      }
      parambm.a(true);
      localObject1 = paramdf.b(2);
      if (((BitSet)localObject1).get(0))
      {
        localObject2 = new db((byte)12, paramdf.w());
        parambm.b = new ArrayList(((db)localObject2).b);
        i = j;
        while (i < ((db)localObject2).b)
        {
          localObject3 = new bk();
          ((bk)localObject3).a(paramdf);
          parambm.b.add(localObject3);
          i += 1;
        }
        parambm.b(true);
      }
      if (((BitSet)localObject1).get(1))
      {
        parambm.c = paramdf.z();
        parambm.c(true);
      }
    }
  }
  
  private static class d
    implements do
  {
    public bm.c a()
    {
      return new bm.c(null);
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */