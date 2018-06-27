package com.xiaomi.push.thrift;

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
import org.apache.thrift.protocol.e;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.h;
import org.apache.thrift.protocol.j;

public class c
  implements Serializable, Cloneable, a<c, a>
{
  public static final Map<a, org.apache.thrift.meta_data.b> d;
  private static final j e = new j("StatsEvents");
  private static final org.apache.thrift.protocol.b f = new org.apache.thrift.protocol.b("uuid", (byte)11, (short)1);
  private static final org.apache.thrift.protocol.b g = new org.apache.thrift.protocol.b("operator", (byte)11, (short)2);
  private static final org.apache.thrift.protocol.b h = new org.apache.thrift.protocol.b("events", (byte)15, (short)3);
  public String a;
  public String b;
  public List<b> c;
  
  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.apache.thrift.meta_data.b("uuid", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(a.b, new org.apache.thrift.meta_data.b("operator", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(a.c, new org.apache.thrift.meta_data.b("events", (byte)1, new d((byte)15, new g((byte)12, b.class))));
    d = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(c.class, d);
  }
  
  public c() {}
  
  public c(String paramString, List<b> paramList)
  {
    this();
    this.a = paramString;
    this.c = paramList;
  }
  
  public c a(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public void a(e parame)
  {
    parame.g();
    Object localObject = parame.i();
    if (((org.apache.thrift.protocol.b)localObject).b == 0)
    {
      parame.h();
      d();
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
      if (((org.apache.thrift.protocol.b)localObject).b == 11)
      {
        this.a = parame.w();
      }
      else
      {
        h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
        continue;
        if (((org.apache.thrift.protocol.b)localObject).b == 11)
        {
          this.b = parame.w();
        }
        else
        {
          h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
          continue;
          if (((org.apache.thrift.protocol.b)localObject).b == 15)
          {
            localObject = parame.m();
            this.c = new ArrayList(((org.apache.thrift.protocol.c)localObject).b);
            int i = 0;
            while (i < ((org.apache.thrift.protocol.c)localObject).b)
            {
              b localb = new b();
              localb.a(parame);
              this.c.add(localb);
              i += 1;
            }
            parame.n();
          }
          else
          {
            h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
          }
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.a != null;
  }
  
  public boolean a(c paramc)
  {
    if (paramc == null) {}
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
          bool2 = paramc.a();
        } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramc.a))));
        bool1 = b();
        bool2 = paramc.b();
      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.b.equals(paramc.b))));
      bool1 = c();
      bool2 = paramc.c();
    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.c.equals(paramc.c))));
    return true;
  }
  
  public int b(c paramc)
  {
    int i;
    if (!getClass().equals(paramc.getClass())) {
      i = getClass().getName().compareTo(paramc.getClass().getName());
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
                j = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramc.a()));
                i = j;
              } while (j != 0);
              if (!a()) {
                break;
              }
              j = org.apache.thrift.b.a(this.a, paramc.a);
              i = j;
            } while (j != 0);
            j = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramc.b()));
            i = j;
          } while (j != 0);
          if (!b()) {
            break;
          }
          j = org.apache.thrift.b.a(this.b, paramc.b);
          i = j;
        } while (j != 0);
        j = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramc.c()));
        i = j;
      } while (j != 0);
      if (!c()) {
        break;
      }
      j = org.apache.thrift.b.a(this.c, paramc.c);
      i = j;
    } while (j != 0);
    return 0;
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
    if ((this.b != null) && (b()))
    {
      parame.a(g);
      parame.a(this.b);
      parame.b();
    }
    if (this.c != null)
    {
      parame.a(h);
      parame.a(new org.apache.thrift.protocol.c((byte)12, this.c.size()));
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext()) {
        ((b)localIterator.next()).b(parame);
      }
      parame.e();
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
  
  public void d()
  {
    if (this.a == null) {
      throw new f("Required field 'uuid' was not present! Struct: " + toString());
    }
    if (this.c == null) {
      throw new f("Required field 'events' was not present! Struct: " + toString());
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof c)) {
      return false;
    }
    return a((c)paramObject);
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("StatsEvents(");
    localStringBuilder.append("uuid:");
    if (this.a == null)
    {
      localStringBuilder.append("null");
      if (b())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("operator:");
        if (this.b != null) {
          break label128;
        }
        localStringBuilder.append("null");
      }
      label72:
      localStringBuilder.append(", ");
      localStringBuilder.append("events:");
      if (this.c != null) {
        break label140;
      }
      localStringBuilder.append("null");
    }
    for (;;)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
      break;
      label128:
      localStringBuilder.append(this.b);
      break label72;
      label140:
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/thrift/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */