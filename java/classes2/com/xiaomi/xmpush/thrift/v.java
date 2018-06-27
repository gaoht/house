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

public class v
  implements Serializable, Cloneable, a<v, a>
{
  public static final Map<a, org.apache.thrift.meta_data.b> d;
  private static final j e = new j("Wifi");
  private static final org.apache.thrift.protocol.b f = new org.apache.thrift.protocol.b("macAddress", (byte)11, (short)1);
  private static final org.apache.thrift.protocol.b g = new org.apache.thrift.protocol.b("signalStrength", (byte)8, (short)2);
  private static final org.apache.thrift.protocol.b h = new org.apache.thrift.protocol.b("ssid", (byte)11, (short)3);
  public String a;
  public int b;
  public String c;
  private BitSet i = new BitSet(1);
  
  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.apache.thrift.meta_data.b("macAddress", (byte)1, new c((byte)11)));
    localEnumMap.put(a.b, new org.apache.thrift.meta_data.b("signalStrength", (byte)1, new c((byte)8)));
    localEnumMap.put(a.c, new org.apache.thrift.meta_data.b("ssid", (byte)2, new c((byte)11)));
    d = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(v.class, d);
  }
  
  public v a(int paramInt)
  {
    this.b = paramInt;
    a(true);
    return this;
  }
  
  public v a(String paramString)
  {
    this.a = paramString;
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
        throw new f("Required field 'signalStrength' was not found in serialized data! Struct: " + toString());
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
        if (localb.b == 11)
        {
          this.a = parame.w();
        }
        else
        {
          h.a(parame, localb.b);
          continue;
          if (localb.b == 8)
          {
            this.b = parame.t();
            a(true);
          }
          else
          {
            h.a(parame, localb.b);
            continue;
            if (localb.b == 11) {
              this.c = parame.w();
            } else {
              h.a(parame, localb.b);
            }
          }
        }
      }
    }
    d();
  }
  
  public void a(boolean paramBoolean)
  {
    this.i.set(0, paramBoolean);
  }
  
  public boolean a()
  {
    return this.a != null;
  }
  
  public boolean a(v paramv)
  {
    if (paramv == null) {}
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        return false;
        bool1 = a();
        bool2 = paramv.a();
      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramv.a)) || (this.b != paramv.b)));
      bool1 = c();
      bool2 = paramv.c();
    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.c.equals(paramv.c))));
    return true;
  }
  
  public int b(v paramv)
  {
    int j;
    if (!getClass().equals(paramv.getClass())) {
      j = getClass().getName().compareTo(paramv.getClass().getName());
    }
    int k;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return j;
                k = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramv.a()));
                j = k;
              } while (k != 0);
              if (!a()) {
                break;
              }
              k = org.apache.thrift.b.a(this.a, paramv.a);
              j = k;
            } while (k != 0);
            k = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramv.b()));
            j = k;
          } while (k != 0);
          if (!b()) {
            break;
          }
          k = org.apache.thrift.b.a(this.b, paramv.b);
          j = k;
        } while (k != 0);
        k = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramv.c()));
        j = k;
      } while (k != 0);
      if (!c()) {
        break;
      }
      k = org.apache.thrift.b.a(this.c, paramv.c);
      j = k;
    } while (k != 0);
    return 0;
  }
  
  public v b(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public void b(e parame)
  {
    d();
    parame.a(e);
    if (this.a != null)
    {
      parame.a(f);
      parame.a(this.a);
      parame.b();
    }
    parame.a(g);
    parame.a(this.b);
    parame.b();
    if ((this.c != null) && (c()))
    {
      parame.a(h);
      parame.a(this.c);
      parame.b();
    }
    parame.c();
    parame.a();
  }
  
  public boolean b()
  {
    return this.i.get(0);
  }
  
  public boolean c()
  {
    return this.c != null;
  }
  
  public void d()
  {
    if (this.a == null) {
      throw new f("Required field 'macAddress' was not present! Struct: " + toString());
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof v)) {
      return false;
    }
    return a((v)paramObject);
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Wifi(");
    localStringBuilder.append("macAddress:");
    if (this.a == null)
    {
      localStringBuilder.append("null");
      localStringBuilder.append(", ");
      localStringBuilder.append("signalStrength:");
      localStringBuilder.append(this.b);
      if (c())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("ssid:");
        if (this.c != null) {
          break label118;
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
      label118:
      localStringBuilder.append(this.c);
    }
  }
  
  public static enum a
  {
    private static final Map<String, a> d;
    private final short e;
    private final String f;
    
    static
    {
      d = new HashMap();
      Iterator localIterator = EnumSet.allOf(a.class).iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        d.put(locala.a(), locala);
      }
    }
    
    private a(short paramShort, String paramString)
    {
      this.e = paramShort;
      this.f = paramString;
    }
    
    public String a()
    {
      return this.f;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/xmpush/thrift/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */