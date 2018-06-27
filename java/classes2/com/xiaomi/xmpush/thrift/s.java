package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.thrift.a;
import org.apache.thrift.meta_data.g;
import org.apache.thrift.protocol.e;
import org.apache.thrift.protocol.h;
import org.apache.thrift.protocol.i;

public class s
  implements Serializable, Cloneable, a<s, a>
{
  public static final Map<a, org.apache.thrift.meta_data.b> b;
  private static final org.apache.thrift.protocol.j c = new org.apache.thrift.protocol.j("RegisteredGeoFencing");
  private static final org.apache.thrift.protocol.b d = new org.apache.thrift.protocol.b("geoFencings", (byte)14, (short)1);
  public Set<j> a;
  
  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.apache.thrift.meta_data.b("geoFencings", (byte)1, new org.apache.thrift.meta_data.f((byte)14, new g((byte)12, j.class))));
    b = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(s.class, b);
  }
  
  public s a(Set<j> paramSet)
  {
    this.a = paramSet;
    return this;
  }
  
  public Set<j> a()
  {
    return this.a;
  }
  
  public void a(e parame)
  {
    parame.g();
    Object localObject = parame.i();
    if (((org.apache.thrift.protocol.b)localObject).b == 0)
    {
      parame.h();
      c();
      return;
    }
    switch (((org.apache.thrift.protocol.b)localObject).c)
    {
    default: 
      h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
    }
    for (;;)
    {
      parame.j();
      break;
      if (((org.apache.thrift.protocol.b)localObject).b == 14)
      {
        localObject = parame.o();
        this.a = new HashSet(((i)localObject).b * 2);
        int i = 0;
        while (i < ((i)localObject).b)
        {
          j localj = new j();
          localj.a(parame);
          this.a.add(localj);
          i += 1;
        }
        parame.p();
      }
      else
      {
        h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
      }
    }
  }
  
  public boolean a(s params)
  {
    if (params == null) {}
    boolean bool1;
    boolean bool2;
    do
    {
      return false;
      bool1 = b();
      bool2 = params.b();
    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(params.a))));
    return true;
  }
  
  public int b(s params)
  {
    int i;
    if (!getClass().equals(params.getClass())) {
      i = getClass().getName().compareTo(params.getClass().getName());
    }
    int j;
    do
    {
      do
      {
        return i;
        j = Boolean.valueOf(b()).compareTo(Boolean.valueOf(params.b()));
        i = j;
      } while (j != 0);
      if (!b()) {
        break;
      }
      j = org.apache.thrift.b.a(this.a, params.a);
      i = j;
    } while (j != 0);
    return 0;
  }
  
  public void b(e parame)
  {
    c();
    parame.a(c);
    if (this.a != null)
    {
      parame.a(d);
      parame.a(new i((byte)12, this.a.size()));
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((j)localIterator.next()).b(parame);
      }
      parame.f();
      parame.b();
    }
    parame.c();
    parame.a();
  }
  
  public boolean b()
  {
    return this.a != null;
  }
  
  public void c()
  {
    if (this.a == null) {
      throw new org.apache.thrift.protocol.f("Required field 'geoFencings' was not present! Struct: " + toString());
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof s)) {
      return false;
    }
    return a((s)paramObject);
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("RegisteredGeoFencing(");
    localStringBuilder.append("geoFencings:");
    if (this.a == null) {
      localStringBuilder.append("null");
    }
    for (;;)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
    }
  }
  
  public static enum a
  {
    private static final Map<String, a> b;
    private final short c;
    private final String d;
    
    static
    {
      b = new HashMap();
      Iterator localIterator = EnumSet.allOf(a.class).iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        b.put(locala.a(), locala);
      }
    }
    
    private a(short paramShort, String paramString)
    {
      this.c = paramShort;
      this.d = paramString;
    }
    
    public String a()
    {
      return this.d;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/xmpush/thrift/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */