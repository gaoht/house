package com.xiaomi.xmpush.thrift;

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
import org.apache.thrift.a;
import org.apache.thrift.meta_data.d;
import org.apache.thrift.meta_data.g;
import org.apache.thrift.protocol.e;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.h;
import org.apache.thrift.protocol.j;

public class ad
  implements Serializable, Cloneable, a<ad, a>
{
  public static final Map<a, org.apache.thrift.meta_data.b> d;
  private static final j e = new j("XmPushActionNormalConfig");
  private static final org.apache.thrift.protocol.b f = new org.apache.thrift.protocol.b("normalConfigs", (byte)15, (short)1);
  private static final org.apache.thrift.protocol.b g = new org.apache.thrift.protocol.b("appId", (byte)10, (short)4);
  private static final org.apache.thrift.protocol.b h = new org.apache.thrift.protocol.b("packageName", (byte)11, (short)5);
  public List<n> a;
  public long b;
  public String c;
  private BitSet i = new BitSet(1);
  
  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.apache.thrift.meta_data.b("normalConfigs", (byte)1, new d((byte)15, new g((byte)12, n.class))));
    localEnumMap.put(a.b, new org.apache.thrift.meta_data.b("appId", (byte)2, new org.apache.thrift.meta_data.c((byte)10)));
    localEnumMap.put(a.c, new org.apache.thrift.meta_data.b("packageName", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    d = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(ad.class, d);
  }
  
  public List<n> a()
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
      e();
      return;
    }
    switch (((org.apache.thrift.protocol.b)localObject).c)
    {
    case 2: 
    case 3: 
    default: 
      h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
    }
    for (;;)
    {
      parame.j();
      break;
      if (((org.apache.thrift.protocol.b)localObject).b == 15)
      {
        localObject = parame.m();
        this.a = new ArrayList(((org.apache.thrift.protocol.c)localObject).b);
        int j = 0;
        while (j < ((org.apache.thrift.protocol.c)localObject).b)
        {
          n localn = new n();
          localn.a(parame);
          this.a.add(localn);
          j += 1;
        }
        parame.n();
      }
      else
      {
        h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
        continue;
        if (((org.apache.thrift.protocol.b)localObject).b == 10)
        {
          this.b = parame.u();
          a(true);
        }
        else
        {
          h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
          continue;
          if (((org.apache.thrift.protocol.b)localObject).b == 11) {
            this.c = parame.w();
          } else {
            h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.i.set(0, paramBoolean);
  }
  
  public boolean a(ad paramad)
  {
    if (paramad == null) {}
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        do
        {
          return false;
          bool1 = b();
          bool2 = paramad.b();
        } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramad.a))));
        bool1 = c();
        bool2 = paramad.c();
      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (this.b != paramad.b)));
      bool1 = d();
      bool2 = paramad.d();
    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.c.equals(paramad.c))));
    return true;
  }
  
  public int b(ad paramad)
  {
    int j;
    if (!getClass().equals(paramad.getClass())) {
      j = getClass().getName().compareTo(paramad.getClass().getName());
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
                k = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramad.b()));
                j = k;
              } while (k != 0);
              if (!b()) {
                break;
              }
              k = org.apache.thrift.b.a(this.a, paramad.a);
              j = k;
            } while (k != 0);
            k = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramad.c()));
            j = k;
          } while (k != 0);
          if (!c()) {
            break;
          }
          k = org.apache.thrift.b.a(this.b, paramad.b);
          j = k;
        } while (k != 0);
        k = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paramad.d()));
        j = k;
      } while (k != 0);
      if (!d()) {
        break;
      }
      k = org.apache.thrift.b.a(this.c, paramad.c);
      j = k;
    } while (k != 0);
    return 0;
  }
  
  public void b(e parame)
  {
    e();
    parame.a(e);
    if (this.a != null)
    {
      parame.a(f);
      parame.a(new org.apache.thrift.protocol.c((byte)12, this.a.size()));
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((n)localIterator.next()).b(parame);
      }
      parame.e();
      parame.b();
    }
    if (c())
    {
      parame.a(g);
      parame.a(this.b);
      parame.b();
    }
    if ((this.c != null) && (d()))
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
    return this.a != null;
  }
  
  public boolean c()
  {
    return this.i.get(0);
  }
  
  public boolean d()
  {
    return this.c != null;
  }
  
  public void e()
  {
    if (this.a == null) {
      throw new f("Required field 'normalConfigs' was not present! Struct: " + toString());
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof ad)) {
      return false;
    }
    return a((ad)paramObject);
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("XmPushActionNormalConfig(");
    localStringBuilder.append("normalConfigs:");
    if (this.a == null)
    {
      localStringBuilder.append("null");
      if (c())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("appId:");
        localStringBuilder.append(this.b);
      }
      if (d())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("packageName:");
        if (this.c != null) {
          break label129;
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
      label129:
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/xmpush/thrift/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */