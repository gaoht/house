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
import org.apache.thrift.meta_data.g;
import org.apache.thrift.protocol.e;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.h;
import org.apache.thrift.protocol.j;

public class i
  implements Serializable, Cloneable, a<i, a>
{
  public static final Map<a, org.apache.thrift.meta_data.b> e;
  private static final j f = new j("GPS");
  private static final org.apache.thrift.protocol.b g = new org.apache.thrift.protocol.b("location", (byte)12, (short)1);
  private static final org.apache.thrift.protocol.b h = new org.apache.thrift.protocol.b("provider", (byte)11, (short)2);
  private static final org.apache.thrift.protocol.b i = new org.apache.thrift.protocol.b("period", (byte)10, (short)3);
  private static final org.apache.thrift.protocol.b j = new org.apache.thrift.protocol.b("accuracy", (byte)4, (short)4);
  public l a;
  public String b;
  public long c;
  public double d;
  private BitSet k = new BitSet(2);
  
  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.apache.thrift.meta_data.b("location", (byte)1, new g((byte)12, l.class)));
    localEnumMap.put(a.b, new org.apache.thrift.meta_data.b("provider", (byte)2, new c((byte)11)));
    localEnumMap.put(a.c, new org.apache.thrift.meta_data.b("period", (byte)2, new c((byte)10)));
    localEnumMap.put(a.d, new org.apache.thrift.meta_data.b("accuracy", (byte)2, new c((byte)4)));
    e = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(i.class, e);
  }
  
  public i a(double paramDouble)
  {
    this.d = paramDouble;
    b(true);
    return this;
  }
  
  public i a(long paramLong)
  {
    this.c = paramLong;
    a(true);
    return this;
  }
  
  public i a(l paraml)
  {
    this.a = paraml;
    return this;
  }
  
  public i a(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public void a(e parame)
  {
    parame.g();
    org.apache.thrift.protocol.b localb = parame.i();
    if (localb.b == 0)
    {
      parame.h();
      e();
      return;
    }
    switch (localb.c)
    {
    default: 
      h.a(parame, localb.b);
    }
    for (;;)
    {
      parame.j();
      break;
      if (localb.b == 12)
      {
        this.a = new l();
        this.a.a(parame);
      }
      else
      {
        h.a(parame, localb.b);
        continue;
        if (localb.b == 11)
        {
          this.b = parame.w();
        }
        else
        {
          h.a(parame, localb.b);
          continue;
          if (localb.b == 10)
          {
            this.c = parame.u();
            a(true);
          }
          else
          {
            h.a(parame, localb.b);
            continue;
            if (localb.b == 4)
            {
              this.d = parame.v();
              b(true);
            }
            else
            {
              h.a(parame, localb.b);
            }
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.k.set(0, paramBoolean);
  }
  
  public boolean a()
  {
    return this.a != null;
  }
  
  public boolean a(i parami)
  {
    if (parami == null) {}
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
            bool1 = a();
            bool2 = parami.a();
          } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.a(parami.a))));
          bool1 = b();
          bool2 = parami.b();
        } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.b.equals(parami.b))));
        bool1 = c();
        bool2 = parami.c();
      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (this.c != parami.c)));
      bool1 = d();
      bool2 = parami.d();
    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (this.d != parami.d)));
    return true;
  }
  
  public int b(i parami)
  {
    int m;
    if (!getClass().equals(parami.getClass())) {
      m = getClass().getName().compareTo(parami.getClass().getName());
    }
    int n;
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
                do
                {
                  do
                  {
                    return m;
                    n = Boolean.valueOf(a()).compareTo(Boolean.valueOf(parami.a()));
                    m = n;
                  } while (n != 0);
                  if (!a()) {
                    break;
                  }
                  n = org.apache.thrift.b.a(this.a, parami.a);
                  m = n;
                } while (n != 0);
                n = Boolean.valueOf(b()).compareTo(Boolean.valueOf(parami.b()));
                m = n;
              } while (n != 0);
              if (!b()) {
                break;
              }
              n = org.apache.thrift.b.a(this.b, parami.b);
              m = n;
            } while (n != 0);
            n = Boolean.valueOf(c()).compareTo(Boolean.valueOf(parami.c()));
            m = n;
          } while (n != 0);
          if (!c()) {
            break;
          }
          n = org.apache.thrift.b.a(this.c, parami.c);
          m = n;
        } while (n != 0);
        n = Boolean.valueOf(d()).compareTo(Boolean.valueOf(parami.d()));
        m = n;
      } while (n != 0);
      if (!d()) {
        break;
      }
      n = org.apache.thrift.b.a(this.d, parami.d);
      m = n;
    } while (n != 0);
    return 0;
  }
  
  public void b(e parame)
  {
    e();
    parame.a(f);
    if (this.a != null)
    {
      parame.a(g);
      this.a.b(parame);
      parame.b();
    }
    if ((this.b != null) && (b()))
    {
      parame.a(h);
      parame.a(this.b);
      parame.b();
    }
    if (c())
    {
      parame.a(i);
      parame.a(this.c);
      parame.b();
    }
    if (d())
    {
      parame.a(j);
      parame.a(this.d);
      parame.b();
    }
    parame.c();
    parame.a();
  }
  
  public void b(boolean paramBoolean)
  {
    this.k.set(1, paramBoolean);
  }
  
  public boolean b()
  {
    return this.b != null;
  }
  
  public boolean c()
  {
    return this.k.get(0);
  }
  
  public boolean d()
  {
    return this.k.get(1);
  }
  
  public void e()
  {
    if (this.a == null) {
      throw new f("Required field 'location' was not present! Struct: " + toString());
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof i)) {
      return false;
    }
    return a((i)paramObject);
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("GPS(");
    localStringBuilder.append("location:");
    if (this.a == null)
    {
      localStringBuilder.append("null");
      if (b())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("provider:");
        if (this.b != null) {
          break label161;
        }
        localStringBuilder.append("null");
      }
    }
    for (;;)
    {
      if (c())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("period:");
        localStringBuilder.append(this.c);
      }
      if (d())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("accuracy:");
        localStringBuilder.append(this.d);
      }
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
      break;
      label161:
      localStringBuilder.append(this.b);
    }
  }
  
  public static enum a
  {
    private static final Map<String, a> e;
    private final short f;
    private final String g;
    
    static
    {
      e = new HashMap();
      Iterator localIterator = EnumSet.allOf(a.class).iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        e.put(locala.a(), locala);
      }
    }
    
    private a(short paramShort, String paramString)
    {
      this.f = paramShort;
      this.g = paramString;
    }
    
    public String a()
    {
      return this.g;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/xmpush/thrift/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */