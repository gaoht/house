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

public class d
  implements Serializable, Cloneable, a<d, a>
{
  public static final Map<a, org.apache.thrift.meta_data.b> h;
  private static final j i = new j("ClientUploadDataItem");
  private static final org.apache.thrift.protocol.b j = new org.apache.thrift.protocol.b("channel", (byte)11, (short)1);
  private static final org.apache.thrift.protocol.b k = new org.apache.thrift.protocol.b("data", (byte)11, (short)2);
  private static final org.apache.thrift.protocol.b l = new org.apache.thrift.protocol.b("name", (byte)11, (short)3);
  private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("counter", (byte)10, (short)4);
  private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("timestamp", (byte)10, (short)5);
  private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("fromSdk", (byte)2, (short)6);
  private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("category", (byte)11, (short)7);
  public String a;
  public String b;
  public String c;
  public long d;
  public long e;
  public boolean f;
  public String g;
  private BitSet q = new BitSet(3);
  
  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.apache.thrift.meta_data.b("channel", (byte)2, new c((byte)11)));
    localEnumMap.put(a.b, new org.apache.thrift.meta_data.b("data", (byte)2, new c((byte)11)));
    localEnumMap.put(a.c, new org.apache.thrift.meta_data.b("name", (byte)2, new c((byte)11)));
    localEnumMap.put(a.d, new org.apache.thrift.meta_data.b("counter", (byte)2, new c((byte)10)));
    localEnumMap.put(a.e, new org.apache.thrift.meta_data.b("timestamp", (byte)2, new c((byte)10)));
    localEnumMap.put(a.f, new org.apache.thrift.meta_data.b("fromSdk", (byte)2, new c((byte)2)));
    localEnumMap.put(a.g, new org.apache.thrift.meta_data.b("category", (byte)2, new c((byte)11)));
    h = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(d.class, h);
  }
  
  public void a(e parame)
  {
    parame.g();
    org.apache.thrift.protocol.b localb = parame.i();
    if (localb.b == 0)
    {
      parame.h();
      h();
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
      if (localb.b == 11)
      {
        this.a = parame.w();
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
          if (localb.b == 11)
          {
            this.c = parame.w();
          }
          else
          {
            h.a(parame, localb.b);
            continue;
            if (localb.b == 10)
            {
              this.d = parame.u();
              a(true);
            }
            else
            {
              h.a(parame, localb.b);
              continue;
              if (localb.b == 10)
              {
                this.e = parame.u();
                b(true);
              }
              else
              {
                h.a(parame, localb.b);
                continue;
                if (localb.b == 2)
                {
                  this.f = parame.q();
                  c(true);
                }
                else
                {
                  h.a(parame, localb.b);
                  continue;
                  if (localb.b == 11) {
                    this.g = parame.w();
                  } else {
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
  
  public boolean a()
  {
    return this.a != null;
  }
  
  public boolean a(d paramd)
  {
    if (paramd == null) {}
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
                  bool1 = a();
                  bool2 = paramd.a();
                } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramd.a))));
                bool1 = b();
                bool2 = paramd.b();
              } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.b.equals(paramd.b))));
              bool1 = c();
              bool2 = paramd.c();
            } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.c.equals(paramd.c))));
            bool1 = d();
            bool2 = paramd.d();
          } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (this.d != paramd.d)));
          bool1 = e();
          bool2 = paramd.e();
        } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (this.e != paramd.e)));
        bool1 = f();
        bool2 = paramd.f();
      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (this.f != paramd.f)));
      bool1 = g();
      bool2 = paramd.g();
    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.g.equals(paramd.g))));
    return true;
  }
  
  public int b(d paramd)
  {
    int i1;
    if (!getClass().equals(paramd.getClass())) {
      i1 = getClass().getName().compareTo(paramd.getClass().getName());
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
                                i2 = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramd.a()));
                                i1 = i2;
                              } while (i2 != 0);
                              if (!a()) {
                                break;
                              }
                              i2 = org.apache.thrift.b.a(this.a, paramd.a);
                              i1 = i2;
                            } while (i2 != 0);
                            i2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramd.b()));
                            i1 = i2;
                          } while (i2 != 0);
                          if (!b()) {
                            break;
                          }
                          i2 = org.apache.thrift.b.a(this.b, paramd.b);
                          i1 = i2;
                        } while (i2 != 0);
                        i2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramd.c()));
                        i1 = i2;
                      } while (i2 != 0);
                      if (!c()) {
                        break;
                      }
                      i2 = org.apache.thrift.b.a(this.c, paramd.c);
                      i1 = i2;
                    } while (i2 != 0);
                    i2 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paramd.d()));
                    i1 = i2;
                  } while (i2 != 0);
                  if (!d()) {
                    break;
                  }
                  i2 = org.apache.thrift.b.a(this.d, paramd.d);
                  i1 = i2;
                } while (i2 != 0);
                i2 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paramd.e()));
                i1 = i2;
              } while (i2 != 0);
              if (!e()) {
                break;
              }
              i2 = org.apache.thrift.b.a(this.e, paramd.e);
              i1 = i2;
            } while (i2 != 0);
            i2 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(paramd.f()));
            i1 = i2;
          } while (i2 != 0);
          if (!f()) {
            break;
          }
          i2 = org.apache.thrift.b.a(this.f, paramd.f);
          i1 = i2;
        } while (i2 != 0);
        i2 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(paramd.g()));
        i1 = i2;
      } while (i2 != 0);
      if (!g()) {
        break;
      }
      i2 = org.apache.thrift.b.a(this.g, paramd.g);
      i1 = i2;
    } while (i2 != 0);
    return 0;
  }
  
  public void b(e parame)
  {
    h();
    parame.a(i);
    if ((this.a != null) && (a()))
    {
      parame.a(j);
      parame.a(this.a);
      parame.b();
    }
    if ((this.b != null) && (b()))
    {
      parame.a(k);
      parame.a(this.b);
      parame.b();
    }
    if ((this.c != null) && (c()))
    {
      parame.a(l);
      parame.a(this.c);
      parame.b();
    }
    if (d())
    {
      parame.a(m);
      parame.a(this.d);
      parame.b();
    }
    if (e())
    {
      parame.a(n);
      parame.a(this.e);
      parame.b();
    }
    if (f())
    {
      parame.a(o);
      parame.a(this.f);
      parame.b();
    }
    if ((this.g != null) && (g()))
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
    return this.b != null;
  }
  
  public void c(boolean paramBoolean)
  {
    this.q.set(2, paramBoolean);
  }
  
  public boolean c()
  {
    return this.c != null;
  }
  
  public boolean d()
  {
    return this.q.get(0);
  }
  
  public boolean e()
  {
    return this.q.get(1);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof d)) {
      return false;
    }
    return a((d)paramObject);
  }
  
  public boolean f()
  {
    return this.q.get(2);
  }
  
  public boolean g()
  {
    return this.g != null;
  }
  
  public void h() {}
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toString()
  {
    int i3 = 0;
    StringBuilder localStringBuilder = new StringBuilder("ClientUploadDataItem(");
    int i2 = 1;
    if (a())
    {
      localStringBuilder.append("channel:");
      if (this.a == null)
      {
        localStringBuilder.append("null");
        i2 = 0;
      }
    }
    else
    {
      i1 = i2;
      if (b())
      {
        if (i2 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("data:");
        if (this.b != null) {
          break label348;
        }
        localStringBuilder.append("null");
        label97:
        i1 = 0;
      }
      i2 = i1;
      if (c())
      {
        if (i1 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("name:");
        if (this.c != null) {
          break label361;
        }
        localStringBuilder.append("null");
        label146:
        i2 = 0;
      }
      i1 = i2;
      if (d())
      {
        if (i2 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("counter:");
        localStringBuilder.append(this.d);
        i1 = 0;
      }
      i2 = i1;
      if (e())
      {
        if (i1 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("timestamp:");
        localStringBuilder.append(this.e);
        i2 = 0;
      }
      if (!f()) {
        break label387;
      }
      if (i2 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("fromSdk:");
      localStringBuilder.append(this.f);
    }
    label348:
    label361:
    label374:
    label387:
    for (int i1 = i3;; i1 = i2)
    {
      if (g())
      {
        if (i1 == 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append("category:");
        if (this.g != null) {
          break label374;
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
        break label97;
        localStringBuilder.append(this.c);
        break label146;
        localStringBuilder.append(this.g);
      }
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/xmpush/thrift/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */