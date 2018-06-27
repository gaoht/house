package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.thrift.a;
import org.apache.thrift.meta_data.c;
import org.apache.thrift.meta_data.g;
import org.apache.thrift.protocol.d;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.h;
import org.apache.thrift.protocol.j;

public class aj
  implements Serializable, Cloneable, a<aj, a>
{
  public static final Map<a, org.apache.thrift.meta_data.b> m;
  private static final j n = new j("XmPushActionSendMessage");
  private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("debug", (byte)11, (short)1);
  private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("target", (byte)12, (short)2);
  private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("id", (byte)11, (short)3);
  private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("appId", (byte)11, (short)4);
  private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b("packageName", (byte)11, (short)5);
  private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b("topic", (byte)11, (short)6);
  private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b("aliasName", (byte)11, (short)7);
  private static final org.apache.thrift.protocol.b v = new org.apache.thrift.protocol.b("message", (byte)12, (short)8);
  private static final org.apache.thrift.protocol.b w = new org.apache.thrift.protocol.b("needAck", (byte)2, (short)9);
  private static final org.apache.thrift.protocol.b x = new org.apache.thrift.protocol.b("params", (byte)13, (short)10);
  private static final org.apache.thrift.protocol.b y = new org.apache.thrift.protocol.b("category", (byte)11, (short)11);
  private static final org.apache.thrift.protocol.b z = new org.apache.thrift.protocol.b("userAccount", (byte)11, (short)12);
  private BitSet A = new BitSet(1);
  public String a;
  public u b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public q h;
  public boolean i = true;
  public Map<String, String> j;
  public String k;
  public String l;
  
  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.apache.thrift.meta_data.b("debug", (byte)2, new c((byte)11)));
    localEnumMap.put(a.b, new org.apache.thrift.meta_data.b("target", (byte)2, new g((byte)12, u.class)));
    localEnumMap.put(a.c, new org.apache.thrift.meta_data.b("id", (byte)1, new c((byte)11)));
    localEnumMap.put(a.d, new org.apache.thrift.meta_data.b("appId", (byte)1, new c((byte)11)));
    localEnumMap.put(a.e, new org.apache.thrift.meta_data.b("packageName", (byte)2, new c((byte)11)));
    localEnumMap.put(a.f, new org.apache.thrift.meta_data.b("topic", (byte)2, new c((byte)11)));
    localEnumMap.put(a.g, new org.apache.thrift.meta_data.b("aliasName", (byte)2, new c((byte)11)));
    localEnumMap.put(a.h, new org.apache.thrift.meta_data.b("message", (byte)2, new g((byte)12, q.class)));
    localEnumMap.put(a.i, new org.apache.thrift.meta_data.b("needAck", (byte)2, new c((byte)2)));
    localEnumMap.put(a.j, new org.apache.thrift.meta_data.b("params", (byte)2, new org.apache.thrift.meta_data.e((byte)13, new c((byte)11), new c((byte)11))));
    localEnumMap.put(a.k, new org.apache.thrift.meta_data.b("category", (byte)2, new c((byte)11)));
    localEnumMap.put(a.l, new org.apache.thrift.meta_data.b("userAccount", (byte)2, new c((byte)11)));
    m = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(aj.class, m);
  }
  
  public void a(org.apache.thrift.protocol.e parame)
  {
    parame.g();
    Object localObject = parame.i();
    if (((org.apache.thrift.protocol.b)localObject).b == 0)
    {
      parame.h();
      t();
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
        if (((org.apache.thrift.protocol.b)localObject).b == 12)
        {
          this.b = new u();
          this.b.a(parame);
        }
        else
        {
          h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
          continue;
          if (((org.apache.thrift.protocol.b)localObject).b == 11)
          {
            this.c = parame.w();
          }
          else
          {
            h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
            continue;
            if (((org.apache.thrift.protocol.b)localObject).b == 11)
            {
              this.d = parame.w();
            }
            else
            {
              h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
              continue;
              if (((org.apache.thrift.protocol.b)localObject).b == 11)
              {
                this.e = parame.w();
              }
              else
              {
                h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                continue;
                if (((org.apache.thrift.protocol.b)localObject).b == 11)
                {
                  this.f = parame.w();
                }
                else
                {
                  h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                  continue;
                  if (((org.apache.thrift.protocol.b)localObject).b == 11)
                  {
                    this.g = parame.w();
                  }
                  else
                  {
                    h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                    continue;
                    if (((org.apache.thrift.protocol.b)localObject).b == 12)
                    {
                      this.h = new q();
                      this.h.a(parame);
                    }
                    else
                    {
                      h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                      continue;
                      if (((org.apache.thrift.protocol.b)localObject).b == 2)
                      {
                        this.i = parame.q();
                        a(true);
                      }
                      else
                      {
                        h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                        continue;
                        if (((org.apache.thrift.protocol.b)localObject).b == 13)
                        {
                          localObject = parame.k();
                          this.j = new HashMap(((d)localObject).c * 2);
                          int i1 = 0;
                          while (i1 < ((d)localObject).c)
                          {
                            String str1 = parame.w();
                            String str2 = parame.w();
                            this.j.put(str1, str2);
                            i1 += 1;
                          }
                          parame.l();
                        }
                        else
                        {
                          h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                          continue;
                          if (((org.apache.thrift.protocol.b)localObject).b == 11)
                          {
                            this.k = parame.w();
                          }
                          else
                          {
                            h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                            continue;
                            if (((org.apache.thrift.protocol.b)localObject).b == 11) {
                              this.l = parame.w();
                            } else {
                              h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
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
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.A.set(0, paramBoolean);
  }
  
  public boolean a()
  {
    return this.a != null;
  }
  
  public boolean a(aj paramaj)
  {
    if (paramaj == null) {}
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
                            bool2 = paramaj.a();
                          } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramaj.a))));
                          bool1 = b();
                          bool2 = paramaj.b();
                        } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.b.a(paramaj.b))));
                        bool1 = d();
                        bool2 = paramaj.d();
                      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.c.equals(paramaj.c))));
                      bool1 = f();
                      bool2 = paramaj.f();
                    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.d.equals(paramaj.d))));
                    bool1 = g();
                    bool2 = paramaj.g();
                  } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.e.equals(paramaj.e))));
                  bool1 = i();
                  bool2 = paramaj.i();
                } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.f.equals(paramaj.f))));
                bool1 = k();
                bool2 = paramaj.k();
              } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.g.equals(paramaj.g))));
              bool1 = m();
              bool2 = paramaj.m();
            } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.h.a(paramaj.h))));
            bool1 = n();
            bool2 = paramaj.n();
          } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (this.i != paramaj.i)));
          bool1 = o();
          bool2 = paramaj.o();
        } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.j.equals(paramaj.j))));
        bool1 = q();
        bool2 = paramaj.q();
      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.k.equals(paramaj.k))));
      bool1 = s();
      bool2 = paramaj.s();
    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.l.equals(paramaj.l))));
    return true;
  }
  
  public int b(aj paramaj)
  {
    int i1;
    if (!getClass().equals(paramaj.getClass())) {
      i1 = getClass().getName().compareTo(paramaj.getClass().getName());
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
                                            do
                                            {
                                              do
                                              {
                                                do
                                                {
                                                  do
                                                  {
                                                    return i1;
                                                    i2 = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramaj.a()));
                                                    i1 = i2;
                                                  } while (i2 != 0);
                                                  if (!a()) {
                                                    break;
                                                  }
                                                  i2 = org.apache.thrift.b.a(this.a, paramaj.a);
                                                  i1 = i2;
                                                } while (i2 != 0);
                                                i2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramaj.b()));
                                                i1 = i2;
                                              } while (i2 != 0);
                                              if (!b()) {
                                                break;
                                              }
                                              i2 = org.apache.thrift.b.a(this.b, paramaj.b);
                                              i1 = i2;
                                            } while (i2 != 0);
                                            i2 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paramaj.d()));
                                            i1 = i2;
                                          } while (i2 != 0);
                                          if (!d()) {
                                            break;
                                          }
                                          i2 = org.apache.thrift.b.a(this.c, paramaj.c);
                                          i1 = i2;
                                        } while (i2 != 0);
                                        i2 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(paramaj.f()));
                                        i1 = i2;
                                      } while (i2 != 0);
                                      if (!f()) {
                                        break;
                                      }
                                      i2 = org.apache.thrift.b.a(this.d, paramaj.d);
                                      i1 = i2;
                                    } while (i2 != 0);
                                    i2 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(paramaj.g()));
                                    i1 = i2;
                                  } while (i2 != 0);
                                  if (!g()) {
                                    break;
                                  }
                                  i2 = org.apache.thrift.b.a(this.e, paramaj.e);
                                  i1 = i2;
                                } while (i2 != 0);
                                i2 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(paramaj.i()));
                                i1 = i2;
                              } while (i2 != 0);
                              if (!i()) {
                                break;
                              }
                              i2 = org.apache.thrift.b.a(this.f, paramaj.f);
                              i1 = i2;
                            } while (i2 != 0);
                            i2 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(paramaj.k()));
                            i1 = i2;
                          } while (i2 != 0);
                          if (!k()) {
                            break;
                          }
                          i2 = org.apache.thrift.b.a(this.g, paramaj.g);
                          i1 = i2;
                        } while (i2 != 0);
                        i2 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(paramaj.m()));
                        i1 = i2;
                      } while (i2 != 0);
                      if (!m()) {
                        break;
                      }
                      i2 = org.apache.thrift.b.a(this.h, paramaj.h);
                      i1 = i2;
                    } while (i2 != 0);
                    i2 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(paramaj.n()));
                    i1 = i2;
                  } while (i2 != 0);
                  if (!n()) {
                    break;
                  }
                  i2 = org.apache.thrift.b.a(this.i, paramaj.i);
                  i1 = i2;
                } while (i2 != 0);
                i2 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(paramaj.o()));
                i1 = i2;
              } while (i2 != 0);
              if (!o()) {
                break;
              }
              i2 = org.apache.thrift.b.a(this.j, paramaj.j);
              i1 = i2;
            } while (i2 != 0);
            i2 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(paramaj.q()));
            i1 = i2;
          } while (i2 != 0);
          if (!q()) {
            break;
          }
          i2 = org.apache.thrift.b.a(this.k, paramaj.k);
          i1 = i2;
        } while (i2 != 0);
        i2 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(paramaj.s()));
        i1 = i2;
      } while (i2 != 0);
      if (!s()) {
        break;
      }
      i2 = org.apache.thrift.b.a(this.l, paramaj.l);
      i1 = i2;
    } while (i2 != 0);
    return 0;
  }
  
  public void b(org.apache.thrift.protocol.e parame)
  {
    t();
    parame.a(n);
    if ((this.a != null) && (a()))
    {
      parame.a(o);
      parame.a(this.a);
      parame.b();
    }
    if ((this.b != null) && (b()))
    {
      parame.a(p);
      this.b.b(parame);
      parame.b();
    }
    if (this.c != null)
    {
      parame.a(q);
      parame.a(this.c);
      parame.b();
    }
    if (this.d != null)
    {
      parame.a(r);
      parame.a(this.d);
      parame.b();
    }
    if ((this.e != null) && (g()))
    {
      parame.a(s);
      parame.a(this.e);
      parame.b();
    }
    if ((this.f != null) && (i()))
    {
      parame.a(t);
      parame.a(this.f);
      parame.b();
    }
    if ((this.g != null) && (k()))
    {
      parame.a(u);
      parame.a(this.g);
      parame.b();
    }
    if ((this.h != null) && (m()))
    {
      parame.a(v);
      this.h.b(parame);
      parame.b();
    }
    if (n())
    {
      parame.a(w);
      parame.a(this.i);
      parame.b();
    }
    if ((this.j != null) && (o()))
    {
      parame.a(x);
      parame.a(new d((byte)11, (byte)11, this.j.size()));
      Iterator localIterator = this.j.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        parame.a((String)localEntry.getKey());
        parame.a((String)localEntry.getValue());
      }
      parame.d();
      parame.b();
    }
    if ((this.k != null) && (q()))
    {
      parame.a(y);
      parame.a(this.k);
      parame.b();
    }
    if ((this.l != null) && (s()))
    {
      parame.a(z);
      parame.a(this.l);
      parame.b();
    }
    parame.c();
    parame.a();
  }
  
  public boolean b()
  {
    return this.b != null;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public boolean d()
  {
    return this.c != null;
  }
  
  public String e()
  {
    return this.d;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof aj)) {
      return false;
    }
    return a((aj)paramObject);
  }
  
  public boolean f()
  {
    return this.d != null;
  }
  
  public boolean g()
  {
    return this.e != null;
  }
  
  public String h()
  {
    return this.f;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean i()
  {
    return this.f != null;
  }
  
  public String j()
  {
    return this.g;
  }
  
  public boolean k()
  {
    return this.g != null;
  }
  
  public q l()
  {
    return this.h;
  }
  
  public boolean m()
  {
    return this.h != null;
  }
  
  public boolean n()
  {
    return this.A.get(0);
  }
  
  public boolean o()
  {
    return this.j != null;
  }
  
  public String p()
  {
    return this.k;
  }
  
  public boolean q()
  {
    return this.k != null;
  }
  
  public String r()
  {
    return this.l;
  }
  
  public boolean s()
  {
    return this.l != null;
  }
  
  public void t()
  {
    if (this.c == null) {
      throw new f("Required field 'id' was not present! Struct: " + toString());
    }
    if (this.d == null) {
      throw new f("Required field 'appId' was not present! Struct: " + toString());
    }
  }
  
  public String toString()
  {
    int i2 = 0;
    StringBuilder localStringBuilder = new StringBuilder("XmPushActionSendMessage(");
    int i1 = 1;
    if (a())
    {
      localStringBuilder.append("debug:");
      if (this.a == null)
      {
        localStringBuilder.append("null");
        i1 = 0;
      }
    }
    else
    {
      if (!b()) {
        break label602;
      }
      if (i1 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("target:");
      if (this.b != null) {
        break label480;
      }
      localStringBuilder.append("null");
      i1 = i2;
    }
    label91:
    label126:
    label157:
    label195:
    label233:
    label271:
    label309:
    label379:
    label417:
    label480:
    label506:
    label518:
    label530:
    label542:
    label554:
    label566:
    label578:
    label590:
    label602:
    for (;;)
    {
      if (i1 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("id:");
      if (this.c == null)
      {
        localStringBuilder.append("null");
        localStringBuilder.append(", ");
        localStringBuilder.append("appId:");
        if (this.d != null) {
          break label506;
        }
        localStringBuilder.append("null");
        if (g())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("packageName:");
          if (this.e != null) {
            break label518;
          }
          localStringBuilder.append("null");
        }
        if (i())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("topic:");
          if (this.f != null) {
            break label530;
          }
          localStringBuilder.append("null");
        }
        if (k())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("aliasName:");
          if (this.g != null) {
            break label542;
          }
          localStringBuilder.append("null");
        }
        if (m())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("message:");
          if (this.h != null) {
            break label554;
          }
          localStringBuilder.append("null");
        }
        if (n())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("needAck:");
          localStringBuilder.append(this.i);
        }
        if (o())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("params:");
          if (this.j != null) {
            break label566;
          }
          localStringBuilder.append("null");
        }
        if (q())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("category:");
          if (this.k != null) {
            break label578;
          }
          localStringBuilder.append("null");
        }
        if (s())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("userAccount:");
          if (this.l != null) {
            break label590;
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
        localStringBuilder.append(this.b);
        i1 = i2;
        break label91;
        localStringBuilder.append(this.c);
        break label126;
        localStringBuilder.append(this.d);
        break label157;
        localStringBuilder.append(this.e);
        break label195;
        localStringBuilder.append(this.f);
        break label233;
        localStringBuilder.append(this.g);
        break label271;
        localStringBuilder.append(this.h);
        break label309;
        localStringBuilder.append(this.j);
        break label379;
        localStringBuilder.append(this.k);
        break label417;
        localStringBuilder.append(this.l);
      }
    }
  }
  
  public static enum a
  {
    private static final Map<String, a> m;
    private final short n;
    private final String o;
    
    static
    {
      m = new HashMap();
      Iterator localIterator = EnumSet.allOf(a.class).iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        m.put(locala.a(), locala);
      }
    }
    
    private a(short paramShort, String paramString)
    {
      this.n = paramShort;
      this.o = paramString;
    }
    
    public String a()
    {
      return this.o;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/xmpush/thrift/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */