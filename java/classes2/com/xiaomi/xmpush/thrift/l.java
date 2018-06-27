package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.thrift.a;
import org.apache.thrift.meta_data.c;
import org.apache.thrift.protocol.e;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.h;
import org.apache.thrift.protocol.j;

public class l
  implements Serializable, Cloneable, a<l, a>
{
  public static final Map<a, org.apache.thrift.meta_data.b> c;
  private static final j d = new j("Location");
  private static final org.apache.thrift.protocol.b e = new org.apache.thrift.protocol.b("longitude", (byte)4, (short)1);
  private static final org.apache.thrift.protocol.b f = new org.apache.thrift.protocol.b("latitude", (byte)4, (short)2);
  public double a;
  public double b;
  private BitSet g = new BitSet(2);
  
  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.apache.thrift.meta_data.b("longitude", (byte)1, new c((byte)4)));
    localEnumMap.put(a.b, new org.apache.thrift.meta_data.b("latitude", (byte)1, new c((byte)4)));
    c = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(l.class, c);
  }
  
  public double a()
  {
    return this.a;
  }
  
  public l a(double paramDouble)
  {
    this.a = paramDouble;
    a(true);
    return this;
  }
  
  public void a(e parame)
  {
    parame.g();
    org.apache.thrift.protocol.b localb = parame.i();
    if (localb.b == 0)
    {
      parame.h();
      if (!b()) {
        throw new f("Required field 'longitude' was not found in serialized data! Struct: " + toString());
      }
    }
    else
    {
      switch (localb.c)
      {
      default: 
        h.a(parame, localb.b);
      }
      for (;;)
      {
        parame.j();
        break;
        if (localb.b == 4)
        {
          this.a = parame.v();
          a(true);
        }
        else
        {
          h.a(parame, localb.b);
          continue;
          if (localb.b == 4)
          {
            this.b = parame.v();
            b(true);
          }
          else
          {
            h.a(parame, localb.b);
          }
        }
      }
    }
    if (!d()) {
      throw new f("Required field 'latitude' was not found in serialized data! Struct: " + toString());
    }
    e();
  }
  
  public void a(boolean paramBoolean)
  {
    this.g.set(0, paramBoolean);
  }
  
  public boolean a(l paraml)
  {
    if (paraml == null) {}
    while ((this.a != paraml.a) || (this.b != paraml.b)) {
      return false;
    }
    return true;
  }
  
  public int b(l paraml)
  {
    int i;
    if (!getClass().equals(paraml.getClass())) {
      i = getClass().getName().compareTo(paraml.getClass().getName());
    }
    int j;
    do
    {
      do
      {
        do
        {
          do
          {
            return i;
            j = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paraml.b()));
            i = j;
          } while (j != 0);
          if (!b()) {
            break;
          }
          j = org.apache.thrift.b.a(this.a, paraml.a);
          i = j;
        } while (j != 0);
        j = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paraml.d()));
        i = j;
      } while (j != 0);
      if (!d()) {
        break;
      }
      j = org.apache.thrift.b.a(this.b, paraml.b);
      i = j;
    } while (j != 0);
    return 0;
  }
  
  public l b(double paramDouble)
  {
    this.b = paramDouble;
    b(true);
    return this;
  }
  
  public void b(e parame)
  {
    e();
    parame.a(d);
    parame.a(e);
    parame.a(this.a);
    parame.b();
    parame.a(f);
    parame.a(this.b);
    parame.b();
    parame.c();
    parame.a();
  }
  
  public void b(boolean paramBoolean)
  {
    this.g.set(1, paramBoolean);
  }
  
  public boolean b()
  {
    return this.g.get(0);
  }
  
  public double c()
  {
    return this.b;
  }
  
  public boolean d()
  {
    return this.g.get(1);
  }
  
  public void e() {}
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof l)) {
      return false;
    }
    return a((l)paramObject);
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Location(");
    localStringBuilder.append("longitude:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append("latitude:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static enum a
  {
    private static final Map<String, a> c;
    private final short d;
    private final String e;
    
    static
    {
      c = new HashMap();
      Iterator localIterator = EnumSet.allOf(a.class).iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        c.put(locala.a(), locala);
      }
    }
    
    private a(short paramShort, String paramString)
    {
      this.d = paramShort;
      this.e = paramString;
    }
    
    public String a()
    {
      return this.e;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/xmpush/thrift/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */