package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.ArrayList;
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
import org.apache.thrift.protocol.c;
import org.apache.thrift.protocol.e;
import org.apache.thrift.protocol.h;
import org.apache.thrift.protocol.j;

public class m
  implements Serializable, Cloneable, a<m, a>
{
  public static final Map<a, org.apache.thrift.meta_data.b> d;
  private static final j e = new j("LocationInfo");
  private static final org.apache.thrift.protocol.b f = new org.apache.thrift.protocol.b("wifiList", (byte)15, (short)1);
  private static final org.apache.thrift.protocol.b g = new org.apache.thrift.protocol.b("cellList", (byte)15, (short)2);
  private static final org.apache.thrift.protocol.b h = new org.apache.thrift.protocol.b("gps", (byte)12, (short)3);
  public List<v> a;
  public List<b> b;
  public i c;
  
  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.apache.thrift.meta_data.b("wifiList", (byte)2, new d((byte)15, new g((byte)12, v.class))));
    localEnumMap.put(a.b, new org.apache.thrift.meta_data.b("cellList", (byte)2, new d((byte)15, new g((byte)12, b.class))));
    localEnumMap.put(a.c, new org.apache.thrift.meta_data.b("gps", (byte)2, new g((byte)12, i.class)));
    d = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(m.class, d);
  }
  
  public m a(i parami)
  {
    this.c = parami;
    return this;
  }
  
  public m a(List<v> paramList)
  {
    this.a = paramList;
    return this;
  }
  
  public void a(e parame)
  {
    parame.g();
    Object localObject1 = parame.i();
    if (((org.apache.thrift.protocol.b)localObject1).b == 0)
    {
      parame.h();
      d();
      return;
    }
    switch (((org.apache.thrift.protocol.b)localObject1).c)
    {
    default: 
      h.a(parame, ((org.apache.thrift.protocol.b)localObject1).b);
    }
    for (;;)
    {
      parame.j();
      break;
      int i;
      Object localObject2;
      if (((org.apache.thrift.protocol.b)localObject1).b == 15)
      {
        localObject1 = parame.m();
        this.a = new ArrayList(((c)localObject1).b);
        i = 0;
        while (i < ((c)localObject1).b)
        {
          localObject2 = new v();
          ((v)localObject2).a(parame);
          this.a.add(localObject2);
          i += 1;
        }
        parame.n();
      }
      else
      {
        h.a(parame, ((org.apache.thrift.protocol.b)localObject1).b);
        continue;
        if (((org.apache.thrift.protocol.b)localObject1).b == 15)
        {
          localObject1 = parame.m();
          this.b = new ArrayList(((c)localObject1).b);
          i = 0;
          while (i < ((c)localObject1).b)
          {
            localObject2 = new b();
            ((b)localObject2).a(parame);
            this.b.add(localObject2);
            i += 1;
          }
          parame.n();
        }
        else
        {
          h.a(parame, ((org.apache.thrift.protocol.b)localObject1).b);
          continue;
          if (((org.apache.thrift.protocol.b)localObject1).b == 12)
          {
            this.c = new i();
            this.c.a(parame);
          }
          else
          {
            h.a(parame, ((org.apache.thrift.protocol.b)localObject1).b);
          }
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.a != null;
  }
  
  public boolean a(m paramm)
  {
    if (paramm == null) {}
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        do
        {
          return false;
          bool1 = a();
          bool2 = paramm.a();
        } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramm.a))));
        bool1 = b();
        bool2 = paramm.b();
      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.b.equals(paramm.b))));
      bool1 = c();
      bool2 = paramm.c();
    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.c.a(paramm.c))));
    return true;
  }
  
  public int b(m paramm)
  {
    int i;
    if (!getClass().equals(paramm.getClass())) {
      i = getClass().getName().compareTo(paramm.getClass().getName());
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
            do
            {
              do
              {
                return i;
                j = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramm.a()));
                i = j;
              } while (j != 0);
              if (!a()) {
                break;
              }
              j = org.apache.thrift.b.a(this.a, paramm.a);
              i = j;
            } while (j != 0);
            j = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramm.b()));
            i = j;
          } while (j != 0);
          if (!b()) {
            break;
          }
          j = org.apache.thrift.b.a(this.b, paramm.b);
          i = j;
        } while (j != 0);
        j = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramm.c()));
        i = j;
      } while (j != 0);
      if (!c()) {
        break;
      }
      j = org.apache.thrift.b.a(this.c, paramm.c);
      i = j;
    } while (j != 0);
    return 0;
  }
  
  public m b(List<b> paramList)
  {
    this.b = paramList;
    return this;
  }
  
  public void b(e parame)
  {
    d();
    parame.a(e);
    Iterator localIterator;
    if ((this.a != null) && (a()))
    {
      parame.a(f);
      parame.a(new c((byte)12, this.a.size()));
      localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((v)localIterator.next()).b(parame);
      }
      parame.e();
      parame.b();
    }
    if ((this.b != null) && (b()))
    {
      parame.a(g);
      parame.a(new c((byte)12, this.b.size()));
      localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((b)localIterator.next()).b(parame);
      }
      parame.e();
      parame.b();
    }
    if ((this.c != null) && (c()))
    {
      parame.a(h);
      this.c.b(parame);
      parame.b();
    }
    parame.c();
    parame.a();
  }
  
  public boolean b()
  {
    return this.b != null;
  }
  
  public boolean c()
  {
    return this.c != null;
  }
  
  public void d() {}
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof m)) {
      return false;
    }
    return a((m)paramObject);
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toString()
  {
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder("LocationInfo(");
    int i = 1;
    if (a())
    {
      localStringBuilder.append("wifiList:");
      if (this.a == null)
      {
        localStringBuilder.append("null");
        i = 0;
      }
    }
    else
    {
      if (!b()) {
        break label184;
      }
      if (i == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("cellList:");
      if (this.b != null) {
        break label158;
      }
      localStringBuilder.append("null");
      i = j;
    }
    label91:
    label158:
    label172:
    label184:
    for (;;)
    {
      if (c())
      {
        if (i == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("gps:");
        if (this.c != null) {
          break label172;
        }
        localStringBuilder.append("null");
      }
      for (;;)
      {
        localStringBuilder.append(")");
        return localStringBuilder.toString();
        localStringBuilder.append(this.a);
        break;
        localStringBuilder.append(this.b);
        i = j;
        break label91;
        localStringBuilder.append(this.c);
      }
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/xmpush/thrift/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */