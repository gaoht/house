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

public class b
  implements Serializable, Cloneable, a<b, a>
{
  public static final Map<a, org.apache.thrift.meta_data.b> c;
  private static final j d = new j("Cellular");
  private static final org.apache.thrift.protocol.b e = new org.apache.thrift.protocol.b("id", (byte)8, (short)1);
  private static final org.apache.thrift.protocol.b f = new org.apache.thrift.protocol.b("signalStrength", (byte)8, (short)2);
  public int a;
  public int b;
  private BitSet g = new BitSet(2);
  
  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.apache.thrift.meta_data.b("id", (byte)1, new c((byte)8)));
    localEnumMap.put(a.b, new org.apache.thrift.meta_data.b("signalStrength", (byte)1, new c((byte)8)));
    c = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(b.class, c);
  }
  
  public b a(int paramInt)
  {
    this.a = paramInt;
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
      if (!a()) {
        throw new f("Required field 'id' was not found in serialized data! Struct: " + toString());
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
        if (localb.b == 8)
        {
          this.a = parame.t();
          a(true);
        }
        else
        {
          h.a(parame, localb.b);
          continue;
          if (localb.b == 8)
          {
            this.b = parame.t();
            b(true);
          }
          else
          {
            h.a(parame, localb.b);
          }
        }
      }
    }
    if (!b()) {
      throw new f("Required field 'signalStrength' was not found in serialized data! Struct: " + toString());
    }
    c();
  }
  
  public void a(boolean paramBoolean)
  {
    this.g.set(0, paramBoolean);
  }
  
  public boolean a()
  {
    return this.g.get(0);
  }
  
  public boolean a(b paramb)
  {
    if (paramb == null) {}
    while ((this.a != paramb.a) || (this.b != paramb.b)) {
      return false;
    }
    return true;
  }
  
  public int b(b paramb)
  {
    int i;
    if (!getClass().equals(paramb.getClass())) {
      i = getClass().getName().compareTo(paramb.getClass().getName());
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
            j = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramb.a()));
            i = j;
          } while (j != 0);
          if (!a()) {
            break;
          }
          j = org.apache.thrift.b.a(this.a, paramb.a);
          i = j;
        } while (j != 0);
        j = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramb.b()));
        i = j;
      } while (j != 0);
      if (!b()) {
        break;
      }
      j = org.apache.thrift.b.a(this.b, paramb.b);
      i = j;
    } while (j != 0);
    return 0;
  }
  
  public b b(int paramInt)
  {
    this.b = paramInt;
    b(true);
    return this;
  }
  
  public void b(e parame)
  {
    c();
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
    return this.g.get(1);
  }
  
  public void c() {}
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof b)) {
      return false;
    }
    return a((b)paramObject);
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Cellular(");
    localStringBuilder.append("id:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append("signalStrength:");
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/xmpush/thrift/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */