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

public class y
  implements Serializable, Cloneable, a<y, a>
{
  public static final Map<a, org.apache.thrift.meta_data.b> c;
  private static final j d = new j("XmPushActionCheckClientInfo");
  private static final org.apache.thrift.protocol.b e = new org.apache.thrift.protocol.b("miscConfigVersion", (byte)8, (short)1);
  private static final org.apache.thrift.protocol.b f = new org.apache.thrift.protocol.b("pluginConfigVersion", (byte)8, (short)2);
  public int a;
  public int b;
  private BitSet g = new BitSet(2);
  
  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.apache.thrift.meta_data.b("miscConfigVersion", (byte)1, new c((byte)8)));
    localEnumMap.put(a.b, new org.apache.thrift.meta_data.b("pluginConfigVersion", (byte)1, new c((byte)8)));
    c = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(y.class, c);
  }
  
  public y a(int paramInt)
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
        throw new f("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString());
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
      throw new f("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString());
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
  
  public boolean a(y paramy)
  {
    if (paramy == null) {}
    while ((this.a != paramy.a) || (this.b != paramy.b)) {
      return false;
    }
    return true;
  }
  
  public int b(y paramy)
  {
    int i;
    if (!getClass().equals(paramy.getClass())) {
      i = getClass().getName().compareTo(paramy.getClass().getName());
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
            j = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramy.a()));
            i = j;
          } while (j != 0);
          if (!a()) {
            break;
          }
          j = org.apache.thrift.b.a(this.a, paramy.a);
          i = j;
        } while (j != 0);
        j = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramy.b()));
        i = j;
      } while (j != 0);
      if (!b()) {
        break;
      }
      j = org.apache.thrift.b.a(this.b, paramy.b);
      i = j;
    } while (j != 0);
    return 0;
  }
  
  public y b(int paramInt)
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
    while (!(paramObject instanceof y)) {
      return false;
    }
    return a((y)paramObject);
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("XmPushActionCheckClientInfo(");
    localStringBuilder.append("miscConfigVersion:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append("pluginConfigVersion:");
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/xmpush/thrift/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */