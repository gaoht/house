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
import org.apache.thrift.meta_data.d;
import org.apache.thrift.meta_data.g;
import org.apache.thrift.protocol.e;
import org.apache.thrift.protocol.h;
import org.apache.thrift.protocol.j;

public class n
  implements Serializable, Cloneable, org.apache.thrift.a<n, a>
{
  public static final Map<a, org.apache.thrift.meta_data.b> d;
  private static final j e = new j("NormalConfig");
  private static final org.apache.thrift.protocol.b f = new org.apache.thrift.protocol.b("version", (byte)8, (short)1);
  private static final org.apache.thrift.protocol.b g = new org.apache.thrift.protocol.b("configItems", (byte)15, (short)2);
  private static final org.apache.thrift.protocol.b h = new org.apache.thrift.protocol.b("type", (byte)8, (short)3);
  public int a;
  public List<p> b;
  public f c;
  private BitSet i = new BitSet(1);
  
  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.apache.thrift.meta_data.b("version", (byte)1, new org.apache.thrift.meta_data.c((byte)8)));
    localEnumMap.put(a.b, new org.apache.thrift.meta_data.b("configItems", (byte)1, new d((byte)15, new g((byte)12, p.class))));
    localEnumMap.put(a.c, new org.apache.thrift.meta_data.b("type", (byte)1, new org.apache.thrift.meta_data.a((byte)16, f.class)));
    d = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(n.class, d);
  }
  
  public int a()
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
      if (!b()) {
        throw new org.apache.thrift.protocol.f("Required field 'version' was not found in serialized data! Struct: " + toString());
      }
    }
    else
    {
      switch (((org.apache.thrift.protocol.b)localObject).c)
      {
      default: 
        h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
      }
      for (;;)
      {
        parame.j();
        break;
        if (((org.apache.thrift.protocol.b)localObject).b == 8)
        {
          this.a = parame.t();
          a(true);
        }
        else
        {
          h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
          continue;
          if (((org.apache.thrift.protocol.b)localObject).b == 15)
          {
            localObject = parame.m();
            this.b = new ArrayList(((org.apache.thrift.protocol.c)localObject).b);
            int j = 0;
            while (j < ((org.apache.thrift.protocol.c)localObject).b)
            {
              p localp = new p();
              localp.a(parame);
              this.b.add(localp);
              j += 1;
            }
            parame.n();
          }
          else
          {
            h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
            continue;
            if (((org.apache.thrift.protocol.b)localObject).b == 8) {
              this.c = f.a(parame.t());
            } else {
              h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
            }
          }
        }
      }
    }
    f();
  }
  
  public void a(boolean paramBoolean)
  {
    this.i.set(0, paramBoolean);
  }
  
  public boolean a(n paramn)
  {
    if (paramn == null) {}
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        do
        {
          return false;
        } while (this.a != paramn.a);
        bool1 = c();
        bool2 = paramn.c();
      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.b.equals(paramn.b))));
      bool1 = e();
      bool2 = paramn.e();
    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.c.equals(paramn.c))));
    return true;
  }
  
  public int b(n paramn)
  {
    int j;
    if (!getClass().equals(paramn.getClass())) {
      j = getClass().getName().compareTo(paramn.getClass().getName());
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
                k = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramn.b()));
                j = k;
              } while (k != 0);
              if (!b()) {
                break;
              }
              k = org.apache.thrift.b.a(this.a, paramn.a);
              j = k;
            } while (k != 0);
            k = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramn.c()));
            j = k;
          } while (k != 0);
          if (!c()) {
            break;
          }
          k = org.apache.thrift.b.a(this.b, paramn.b);
          j = k;
        } while (k != 0);
        k = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paramn.e()));
        j = k;
      } while (k != 0);
      if (!e()) {
        break;
      }
      k = org.apache.thrift.b.a(this.c, paramn.c);
      j = k;
    } while (k != 0);
    return 0;
  }
  
  public void b(e parame)
  {
    f();
    parame.a(e);
    parame.a(f);
    parame.a(this.a);
    parame.b();
    if (this.b != null)
    {
      parame.a(g);
      parame.a(new org.apache.thrift.protocol.c((byte)12, this.b.size()));
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((p)localIterator.next()).b(parame);
      }
      parame.e();
      parame.b();
    }
    if (this.c != null)
    {
      parame.a(h);
      parame.a(this.c.a());
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
    return this.b != null;
  }
  
  public f d()
  {
    return this.c;
  }
  
  public boolean e()
  {
    return this.c != null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof n)) {
      return false;
    }
    return a((n)paramObject);
  }
  
  public void f()
  {
    if (this.b == null) {
      throw new org.apache.thrift.protocol.f("Required field 'configItems' was not present! Struct: " + toString());
    }
    if (this.c == null) {
      throw new org.apache.thrift.protocol.f("Required field 'type' was not present! Struct: " + toString());
    }
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("NormalConfig(");
    localStringBuilder.append("version:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append("configItems:");
    if (this.b == null)
    {
      localStringBuilder.append("null");
      localStringBuilder.append(", ");
      localStringBuilder.append("type:");
      if (this.c != null) {
        break label115;
      }
      localStringBuilder.append("null");
    }
    for (;;)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.b);
      break;
      label115:
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/xmpush/thrift/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */