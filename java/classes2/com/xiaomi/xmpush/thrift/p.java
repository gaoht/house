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
import org.apache.thrift.protocol.h;
import org.apache.thrift.protocol.j;

public class p
  implements Serializable, Cloneable, a<p, a>
{
  public static final Map<a, org.apache.thrift.meta_data.b> h;
  private static final j i = new j("OnlineConfigItem");
  private static final org.apache.thrift.protocol.b j = new org.apache.thrift.protocol.b("key", (byte)8, (short)1);
  private static final org.apache.thrift.protocol.b k = new org.apache.thrift.protocol.b("type", (byte)8, (short)2);
  private static final org.apache.thrift.protocol.b l = new org.apache.thrift.protocol.b("clear", (byte)2, (short)3);
  private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("intValue", (byte)8, (short)4);
  private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("longValue", (byte)10, (short)5);
  private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("stringValue", (byte)11, (short)6);
  private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("boolValue", (byte)2, (short)7);
  public int a;
  public int b;
  public boolean c;
  public int d;
  public long e;
  public String f;
  public boolean g;
  private BitSet q = new BitSet(6);
  
  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.apache.thrift.meta_data.b("key", (byte)2, new c((byte)8)));
    localEnumMap.put(a.b, new org.apache.thrift.meta_data.b("type", (byte)2, new c((byte)8)));
    localEnumMap.put(a.c, new org.apache.thrift.meta_data.b("clear", (byte)2, new c((byte)2)));
    localEnumMap.put(a.d, new org.apache.thrift.meta_data.b("intValue", (byte)2, new c((byte)8)));
    localEnumMap.put(a.e, new org.apache.thrift.meta_data.b("longValue", (byte)2, new c((byte)10)));
    localEnumMap.put(a.f, new org.apache.thrift.meta_data.b("stringValue", (byte)2, new c((byte)11)));
    localEnumMap.put(a.g, new org.apache.thrift.meta_data.b("boolValue", (byte)2, new c((byte)2)));
    h = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(p.class, h);
  }
  
  public int a()
  {
    return this.a;
  }
  
  public void a(e parame)
  {
    parame.g();
    org.apache.thrift.protocol.b localb = parame.i();
    if (localb.b == 0)
    {
      parame.h();
      n();
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
          continue;
          if (localb.b == 2)
          {
            this.c = parame.q();
            c(true);
          }
          else
          {
            h.a(parame, localb.b);
            continue;
            if (localb.b == 8)
            {
              this.d = parame.t();
              d(true);
            }
            else
            {
              h.a(parame, localb.b);
              continue;
              if (localb.b == 10)
              {
                this.e = parame.u();
                e(true);
              }
              else
              {
                h.a(parame, localb.b);
                continue;
                if (localb.b == 11)
                {
                  this.f = parame.w();
                }
                else
                {
                  h.a(parame, localb.b);
                  continue;
                  if (localb.b == 2)
                  {
                    this.g = parame.q();
                    f(true);
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
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.q.set(0, paramBoolean);
  }
  
  public boolean a(p paramp)
  {
    if (paramp == null) {}
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
            do
            {
              do
              {
                do
                {
                  return false;
                  bool1 = b();
                  bool2 = paramp.b();
                } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (this.a != paramp.a)));
                bool1 = d();
                bool2 = paramp.d();
              } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (this.b != paramp.b)));
              bool1 = e();
              bool2 = paramp.e();
            } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (this.c != paramp.c)));
            bool1 = g();
            bool2 = paramp.g();
          } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (this.d != paramp.d)));
          bool1 = i();
          bool2 = paramp.i();
        } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (this.e != paramp.e)));
        bool1 = k();
        bool2 = paramp.k();
      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.f.equals(paramp.f))));
      bool1 = m();
      bool2 = paramp.m();
    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (this.g != paramp.g)));
    return true;
  }
  
  public int b(p paramp)
  {
    int i1;
    if (!getClass().equals(paramp.getClass())) {
      i1 = getClass().getName().compareTo(paramp.getClass().getName());
    }
    int i2;
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
                                return i1;
                                i2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramp.b()));
                                i1 = i2;
                              } while (i2 != 0);
                              if (!b()) {
                                break;
                              }
                              i2 = org.apache.thrift.b.a(this.a, paramp.a);
                              i1 = i2;
                            } while (i2 != 0);
                            i2 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paramp.d()));
                            i1 = i2;
                          } while (i2 != 0);
                          if (!d()) {
                            break;
                          }
                          i2 = org.apache.thrift.b.a(this.b, paramp.b);
                          i1 = i2;
                        } while (i2 != 0);
                        i2 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paramp.e()));
                        i1 = i2;
                      } while (i2 != 0);
                      if (!e()) {
                        break;
                      }
                      i2 = org.apache.thrift.b.a(this.c, paramp.c);
                      i1 = i2;
                    } while (i2 != 0);
                    i2 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(paramp.g()));
                    i1 = i2;
                  } while (i2 != 0);
                  if (!g()) {
                    break;
                  }
                  i2 = org.apache.thrift.b.a(this.d, paramp.d);
                  i1 = i2;
                } while (i2 != 0);
                i2 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(paramp.i()));
                i1 = i2;
              } while (i2 != 0);
              if (!i()) {
                break;
              }
              i2 = org.apache.thrift.b.a(this.e, paramp.e);
              i1 = i2;
            } while (i2 != 0);
            i2 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(paramp.k()));
            i1 = i2;
          } while (i2 != 0);
          if (!k()) {
            break;
          }
          i2 = org.apache.thrift.b.a(this.f, paramp.f);
          i1 = i2;
        } while (i2 != 0);
        i2 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(paramp.m()));
        i1 = i2;
      } while (i2 != 0);
      if (!m()) {
        break;
      }
      i2 = org.apache.thrift.b.a(this.g, paramp.g);
      i1 = i2;
    } while (i2 != 0);
    return 0;
  }
  
  public void b(e parame)
  {
    n();
    parame.a(i);
    if (b())
    {
      parame.a(j);
      parame.a(this.a);
      parame.b();
    }
    if (d())
    {
      parame.a(k);
      parame.a(this.b);
      parame.b();
    }
    if (e())
    {
      parame.a(l);
      parame.a(this.c);
      parame.b();
    }
    if (g())
    {
      parame.a(m);
      parame.a(this.d);
      parame.b();
    }
    if (i())
    {
      parame.a(n);
      parame.a(this.e);
      parame.b();
    }
    if ((this.f != null) && (k()))
    {
      parame.a(o);
      parame.a(this.f);
      parame.b();
    }
    if (m())
    {
      parame.a(p);
      parame.a(this.g);
      parame.b();
    }
    parame.c();
    parame.a();
  }
  
  public void b(boolean paramBoolean)
  {
    this.q.set(1, paramBoolean);
  }
  
  public boolean b()
  {
    return this.q.get(0);
  }
  
  public int c()
  {
    return this.b;
  }
  
  public void c(boolean paramBoolean)
  {
    this.q.set(2, paramBoolean);
  }
  
  public void d(boolean paramBoolean)
  {
    this.q.set(3, paramBoolean);
  }
  
  public boolean d()
  {
    return this.q.get(1);
  }
  
  public void e(boolean paramBoolean)
  {
    this.q.set(4, paramBoolean);
  }
  
  public boolean e()
  {
    return this.q.get(2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof p)) {
      return false;
    }
    return a((p)paramObject);
  }
  
  public int f()
  {
    return this.d;
  }
  
  public void f(boolean paramBoolean)
  {
    this.q.set(5, paramBoolean);
  }
  
  public boolean g()
  {
    return this.q.get(3);
  }
  
  public long h()
  {
    return this.e;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean i()
  {
    return this.q.get(4);
  }
  
  public String j()
  {
    return this.f;
  }
  
  public boolean k()
  {
    return this.f != null;
  }
  
  public boolean l()
  {
    return this.g;
  }
  
  public boolean m()
  {
    return this.q.get(5);
  }
  
  public void n() {}
  
  public String toString()
  {
    int i3 = 0;
    StringBuilder localStringBuilder = new StringBuilder("OnlineConfigItem(");
    int i2 = 1;
    if (b())
    {
      localStringBuilder.append("key:");
      localStringBuilder.append(this.a);
      i2 = 0;
    }
    int i1 = i2;
    if (d())
    {
      if (i2 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("type:");
      localStringBuilder.append(this.b);
      i1 = 0;
    }
    i2 = i1;
    if (e())
    {
      if (i1 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("clear:");
      localStringBuilder.append(this.c);
      i2 = 0;
    }
    i1 = i2;
    if (g())
    {
      if (i2 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("intValue:");
      localStringBuilder.append(this.d);
      i1 = 0;
    }
    i2 = i1;
    if (i())
    {
      if (i1 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("longValue:");
      localStringBuilder.append(this.e);
      i2 = 0;
    }
    if (k())
    {
      if (i2 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("stringValue:");
      if (this.f == null)
      {
        localStringBuilder.append("null");
        i1 = i3;
      }
    }
    for (;;)
    {
      if (m())
      {
        if (i1 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("boolValue:");
        localStringBuilder.append(this.g);
      }
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.f);
      i1 = i3;
      continue;
      i1 = i2;
    }
  }
  
  public static enum a
  {
    private static final Map<String, a> h;
    private final short i;
    private final String j;
    
    static
    {
      h = new HashMap();
      Iterator localIterator = EnumSet.allOf(a.class).iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        h.put(locala.a(), locala);
      }
    }
    
    private a(short paramShort, String paramString)
    {
      this.i = paramShort;
      this.j = paramString;
    }
    
    public String a()
    {
      return this.j;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/xmpush/thrift/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */