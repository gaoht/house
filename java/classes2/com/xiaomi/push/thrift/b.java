package com.xiaomi.push.thrift;

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
  public static final Map<a, org.apache.thrift.meta_data.b> k;
  private static final j l = new j("StatsEvent");
  private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("chid", (byte)3, (short)1);
  private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("type", (byte)8, (short)2);
  private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("value", (byte)8, (short)3);
  private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("connpt", (byte)11, (short)4);
  private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("host", (byte)11, (short)5);
  private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("subvalue", (byte)8, (short)6);
  private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b("annotation", (byte)11, (short)7);
  private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b("user", (byte)11, (short)8);
  private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b("time", (byte)8, (short)9);
  private static final org.apache.thrift.protocol.b v = new org.apache.thrift.protocol.b("clientIp", (byte)8, (short)10);
  public byte a;
  public int b;
  public int c;
  public String d;
  public String e;
  public int f;
  public String g;
  public String h;
  public int i;
  public int j;
  private BitSet w = new BitSet(6);
  
  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.apache.thrift.meta_data.b("chid", (byte)1, new c((byte)3)));
    localEnumMap.put(a.b, new org.apache.thrift.meta_data.b("type", (byte)1, new c((byte)8)));
    localEnumMap.put(a.c, new org.apache.thrift.meta_data.b("value", (byte)1, new c((byte)8)));
    localEnumMap.put(a.d, new org.apache.thrift.meta_data.b("connpt", (byte)1, new c((byte)11)));
    localEnumMap.put(a.e, new org.apache.thrift.meta_data.b("host", (byte)2, new c((byte)11)));
    localEnumMap.put(a.f, new org.apache.thrift.meta_data.b("subvalue", (byte)2, new c((byte)8)));
    localEnumMap.put(a.g, new org.apache.thrift.meta_data.b("annotation", (byte)2, new c((byte)11)));
    localEnumMap.put(a.h, new org.apache.thrift.meta_data.b("user", (byte)2, new c((byte)11)));
    localEnumMap.put(a.i, new org.apache.thrift.meta_data.b("time", (byte)2, new c((byte)8)));
    localEnumMap.put(a.j, new org.apache.thrift.meta_data.b("clientIp", (byte)2, new c((byte)8)));
    k = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(b.class, k);
  }
  
  public b a(byte paramByte)
  {
    this.a = paramByte;
    a(true);
    return this;
  }
  
  public b a(int paramInt)
  {
    this.b = paramInt;
    b(true);
    return this;
  }
  
  public b a(String paramString)
  {
    this.d = paramString;
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
        throw new f("Required field 'chid' was not found in serialized data! Struct: " + toString());
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
        if (localb.b == 3)
        {
          this.a = parame.r();
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
            if (localb.b == 8)
            {
              this.c = parame.t();
              c(true);
            }
            else
            {
              h.a(parame, localb.b);
              continue;
              if (localb.b == 11)
              {
                this.d = parame.w();
              }
              else
              {
                h.a(parame, localb.b);
                continue;
                if (localb.b == 11)
                {
                  this.e = parame.w();
                }
                else
                {
                  h.a(parame, localb.b);
                  continue;
                  if (localb.b == 8)
                  {
                    this.f = parame.t();
                    d(true);
                  }
                  else
                  {
                    h.a(parame, localb.b);
                    continue;
                    if (localb.b == 11)
                    {
                      this.g = parame.w();
                    }
                    else
                    {
                      h.a(parame, localb.b);
                      continue;
                      if (localb.b == 11)
                      {
                        this.h = parame.w();
                      }
                      else
                      {
                        h.a(parame, localb.b);
                        continue;
                        if (localb.b == 8)
                        {
                          this.i = parame.t();
                          e(true);
                        }
                        else
                        {
                          h.a(parame, localb.b);
                          continue;
                          if (localb.b == 8)
                          {
                            this.j = parame.t();
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
        }
      }
    }
    if (!b()) {
      throw new f("Required field 'type' was not found in serialized data! Struct: " + toString());
    }
    if (!c()) {
      throw new f("Required field 'value' was not found in serialized data! Struct: " + toString());
    }
    k();
  }
  
  public void a(boolean paramBoolean)
  {
    this.w.set(0, paramBoolean);
  }
  
  public boolean a()
  {
    return this.w.get(0);
  }
  
  public boolean a(b paramb)
  {
    if (paramb == null) {}
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
                  do
                  {
                    return false;
                  } while ((this.a != paramb.a) || (this.b != paramb.b) || (this.c != paramb.c));
                  bool1 = d();
                  bool2 = paramb.d();
                } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.d.equals(paramb.d))));
                bool1 = e();
                bool2 = paramb.e();
              } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.e.equals(paramb.e))));
              bool1 = f();
              bool2 = paramb.f();
            } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (this.f != paramb.f)));
            bool1 = g();
            bool2 = paramb.g();
          } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.g.equals(paramb.g))));
          bool1 = h();
          bool2 = paramb.h();
        } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.h.equals(paramb.h))));
        bool1 = i();
        bool2 = paramb.i();
      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (this.i != paramb.i)));
      bool1 = j();
      bool2 = paramb.j();
    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (this.j != paramb.j)));
    return true;
  }
  
  public int b(b paramb)
  {
    int i1;
    if (!getClass().equals(paramb.getClass())) {
      i1 = getClass().getName().compareTo(paramb.getClass().getName());
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
                                            i2 = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramb.a()));
                                            i1 = i2;
                                          } while (i2 != 0);
                                          if (!a()) {
                                            break;
                                          }
                                          i2 = org.apache.thrift.b.a(this.a, paramb.a);
                                          i1 = i2;
                                        } while (i2 != 0);
                                        i2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramb.b()));
                                        i1 = i2;
                                      } while (i2 != 0);
                                      if (!b()) {
                                        break;
                                      }
                                      i2 = org.apache.thrift.b.a(this.b, paramb.b);
                                      i1 = i2;
                                    } while (i2 != 0);
                                    i2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramb.c()));
                                    i1 = i2;
                                  } while (i2 != 0);
                                  if (!c()) {
                                    break;
                                  }
                                  i2 = org.apache.thrift.b.a(this.c, paramb.c);
                                  i1 = i2;
                                } while (i2 != 0);
                                i2 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paramb.d()));
                                i1 = i2;
                              } while (i2 != 0);
                              if (!d()) {
                                break;
                              }
                              i2 = org.apache.thrift.b.a(this.d, paramb.d);
                              i1 = i2;
                            } while (i2 != 0);
                            i2 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paramb.e()));
                            i1 = i2;
                          } while (i2 != 0);
                          if (!e()) {
                            break;
                          }
                          i2 = org.apache.thrift.b.a(this.e, paramb.e);
                          i1 = i2;
                        } while (i2 != 0);
                        i2 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(paramb.f()));
                        i1 = i2;
                      } while (i2 != 0);
                      if (!f()) {
                        break;
                      }
                      i2 = org.apache.thrift.b.a(this.f, paramb.f);
                      i1 = i2;
                    } while (i2 != 0);
                    i2 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(paramb.g()));
                    i1 = i2;
                  } while (i2 != 0);
                  if (!g()) {
                    break;
                  }
                  i2 = org.apache.thrift.b.a(this.g, paramb.g);
                  i1 = i2;
                } while (i2 != 0);
                i2 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(paramb.h()));
                i1 = i2;
              } while (i2 != 0);
              if (!h()) {
                break;
              }
              i2 = org.apache.thrift.b.a(this.h, paramb.h);
              i1 = i2;
            } while (i2 != 0);
            i2 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(paramb.i()));
            i1 = i2;
          } while (i2 != 0);
          if (!i()) {
            break;
          }
          i2 = org.apache.thrift.b.a(this.i, paramb.i);
          i1 = i2;
        } while (i2 != 0);
        i2 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(paramb.j()));
        i1 = i2;
      } while (i2 != 0);
      if (!j()) {
        break;
      }
      i2 = org.apache.thrift.b.a(this.j, paramb.j);
      i1 = i2;
    } while (i2 != 0);
    return 0;
  }
  
  public b b(int paramInt)
  {
    this.c = paramInt;
    c(true);
    return this;
  }
  
  public b b(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public void b(e parame)
  {
    k();
    parame.a(l);
    parame.a(m);
    parame.a(this.a);
    parame.b();
    parame.a(n);
    parame.a(this.b);
    parame.b();
    parame.a(o);
    parame.a(this.c);
    parame.b();
    if (this.d != null)
    {
      parame.a(p);
      parame.a(this.d);
      parame.b();
    }
    if ((this.e != null) && (e()))
    {
      parame.a(q);
      parame.a(this.e);
      parame.b();
    }
    if (f())
    {
      parame.a(r);
      parame.a(this.f);
      parame.b();
    }
    if ((this.g != null) && (g()))
    {
      parame.a(s);
      parame.a(this.g);
      parame.b();
    }
    if ((this.h != null) && (h()))
    {
      parame.a(t);
      parame.a(this.h);
      parame.b();
    }
    if (i())
    {
      parame.a(u);
      parame.a(this.i);
      parame.b();
    }
    if (j())
    {
      parame.a(v);
      parame.a(this.j);
      parame.b();
    }
    parame.c();
    parame.a();
  }
  
  public void b(boolean paramBoolean)
  {
    this.w.set(1, paramBoolean);
  }
  
  public boolean b()
  {
    return this.w.get(1);
  }
  
  public b c(int paramInt)
  {
    this.f = paramInt;
    d(true);
    return this;
  }
  
  public b c(String paramString)
  {
    this.g = paramString;
    return this;
  }
  
  public void c(boolean paramBoolean)
  {
    this.w.set(2, paramBoolean);
  }
  
  public boolean c()
  {
    return this.w.get(2);
  }
  
  public b d(int paramInt)
  {
    this.i = paramInt;
    e(true);
    return this;
  }
  
  public b d(String paramString)
  {
    this.h = paramString;
    return this;
  }
  
  public void d(boolean paramBoolean)
  {
    this.w.set(3, paramBoolean);
  }
  
  public boolean d()
  {
    return this.d != null;
  }
  
  public b e(int paramInt)
  {
    this.j = paramInt;
    f(true);
    return this;
  }
  
  public void e(boolean paramBoolean)
  {
    this.w.set(4, paramBoolean);
  }
  
  public boolean e()
  {
    return this.e != null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof b)) {
      return false;
    }
    return a((b)paramObject);
  }
  
  public void f(boolean paramBoolean)
  {
    this.w.set(5, paramBoolean);
  }
  
  public boolean f()
  {
    return this.w.get(3);
  }
  
  public boolean g()
  {
    return this.g != null;
  }
  
  public boolean h()
  {
    return this.h != null;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean i()
  {
    return this.w.get(4);
  }
  
  public boolean j()
  {
    return this.w.get(5);
  }
  
  public void k()
  {
    if (this.d == null) {
      throw new f("Required field 'connpt' was not present! Struct: " + toString());
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("StatsEvent(");
    localStringBuilder.append("chid:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append("type:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", ");
    localStringBuilder.append("value:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", ");
    localStringBuilder.append("connpt:");
    if (this.d == null)
    {
      localStringBuilder.append("null");
      if (e())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("host:");
        if (this.e != null) {
          break label344;
        }
        localStringBuilder.append("null");
      }
      label147:
      if (f())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("subvalue:");
        localStringBuilder.append(this.f);
      }
      if (g())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("annotation:");
        if (this.g != null) {
          break label356;
        }
        localStringBuilder.append("null");
      }
      label217:
      if (h())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("user:");
        if (this.h != null) {
          break label368;
        }
        localStringBuilder.append("null");
      }
    }
    for (;;)
    {
      if (i())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("time:");
        localStringBuilder.append(this.i);
      }
      if (j())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("clientIp:");
        localStringBuilder.append(this.j);
      }
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.d);
      break;
      label344:
      localStringBuilder.append(this.e);
      break label147;
      label356:
      localStringBuilder.append(this.g);
      break label217;
      label368:
      localStringBuilder.append(this.h);
    }
  }
  
  public static enum a
  {
    private static final Map<String, a> k;
    private final short l;
    private final String m;
    
    static
    {
      k = new HashMap();
      Iterator localIterator = EnumSet.allOf(a.class).iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        k.put(locala.a(), locala);
      }
    }
    
    private a(short paramShort, String paramString)
    {
      this.l = paramShort;
      this.m = paramString;
    }
    
    public String a()
    {
      return this.m;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/thrift/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */