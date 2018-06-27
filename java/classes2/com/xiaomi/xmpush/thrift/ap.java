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

public class ap
  implements Serializable, Cloneable, a<ap, a>
{
  public static final Map<a, org.apache.thrift.meta_data.b> k;
  private static final j l = new j("XmPushActionUnSubscriptionResult");
  private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("debug", (byte)11, (short)1);
  private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("target", (byte)12, (short)2);
  private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("id", (byte)11, (short)3);
  private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("appId", (byte)11, (short)4);
  private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("request", (byte)12, (short)5);
  private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("errorCode", (byte)10, (short)6);
  private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b("reason", (byte)11, (short)7);
  private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b("topic", (byte)11, (short)8);
  private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b("packageName", (byte)11, (short)9);
  private static final org.apache.thrift.protocol.b v = new org.apache.thrift.protocol.b("category", (byte)11, (short)10);
  public String a;
  public u b;
  public String c;
  public String d;
  public ao e;
  public long f;
  public String g;
  public String h;
  public String i;
  public String j;
  private BitSet w = new BitSet(1);
  
  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.apache.thrift.meta_data.b("debug", (byte)2, new c((byte)11)));
    localEnumMap.put(a.b, new org.apache.thrift.meta_data.b("target", (byte)2, new g((byte)12, u.class)));
    localEnumMap.put(a.c, new org.apache.thrift.meta_data.b("id", (byte)1, new c((byte)11)));
    localEnumMap.put(a.d, new org.apache.thrift.meta_data.b("appId", (byte)2, new c((byte)11)));
    localEnumMap.put(a.e, new org.apache.thrift.meta_data.b("request", (byte)2, new g((byte)12, ao.class)));
    localEnumMap.put(a.f, new org.apache.thrift.meta_data.b("errorCode", (byte)2, new c((byte)10)));
    localEnumMap.put(a.g, new org.apache.thrift.meta_data.b("reason", (byte)2, new c((byte)11)));
    localEnumMap.put(a.h, new org.apache.thrift.meta_data.b("topic", (byte)2, new c((byte)11)));
    localEnumMap.put(a.i, new org.apache.thrift.meta_data.b("packageName", (byte)2, new c((byte)11)));
    localEnumMap.put(a.j, new org.apache.thrift.meta_data.b("category", (byte)2, new c((byte)11)));
    k = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(ap.class, k);
  }
  
  public void a(e parame)
  {
    parame.g();
    org.apache.thrift.protocol.b localb = parame.i();
    if (localb.b == 0)
    {
      parame.h();
      m();
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
        if (localb.b == 12)
        {
          this.b = new u();
          this.b.a(parame);
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
            if (localb.b == 11)
            {
              this.d = parame.w();
            }
            else
            {
              h.a(parame, localb.b);
              continue;
              if (localb.b == 12)
              {
                this.e = new ao();
                this.e.a(parame);
              }
              else
              {
                h.a(parame, localb.b);
                continue;
                if (localb.b == 10)
                {
                  this.f = parame.u();
                  a(true);
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
                      if (localb.b == 11)
                      {
                        this.i = parame.w();
                      }
                      else
                      {
                        h.a(parame, localb.b);
                        continue;
                        if (localb.b == 11) {
                          this.j = parame.w();
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
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.w.set(0, paramBoolean);
  }
  
  public boolean a()
  {
    return this.a != null;
  }
  
  public boolean a(ap paramap)
  {
    if (paramap == null) {}
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
                        return false;
                        bool1 = a();
                        bool2 = paramap.a();
                      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramap.a))));
                      bool1 = b();
                      bool2 = paramap.b();
                    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.b.a(paramap.b))));
                    bool1 = c();
                    bool2 = paramap.c();
                  } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.c.equals(paramap.c))));
                  bool1 = d();
                  bool2 = paramap.d();
                } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.d.equals(paramap.d))));
                bool1 = e();
                bool2 = paramap.e();
              } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.e.a(paramap.e))));
              bool1 = f();
              bool2 = paramap.f();
            } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (this.f != paramap.f)));
            bool1 = g();
            bool2 = paramap.g();
          } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.g.equals(paramap.g))));
          bool1 = i();
          bool2 = paramap.i();
        } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.h.equals(paramap.h))));
        bool1 = j();
        bool2 = paramap.j();
      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.i.equals(paramap.i))));
      bool1 = l();
      bool2 = paramap.l();
    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.j.equals(paramap.j))));
    return true;
  }
  
  public int b(ap paramap)
  {
    int i1;
    if (!getClass().equals(paramap.getClass())) {
      i1 = getClass().getName().compareTo(paramap.getClass().getName());
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
                                            i2 = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramap.a()));
                                            i1 = i2;
                                          } while (i2 != 0);
                                          if (!a()) {
                                            break;
                                          }
                                          i2 = org.apache.thrift.b.a(this.a, paramap.a);
                                          i1 = i2;
                                        } while (i2 != 0);
                                        i2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramap.b()));
                                        i1 = i2;
                                      } while (i2 != 0);
                                      if (!b()) {
                                        break;
                                      }
                                      i2 = org.apache.thrift.b.a(this.b, paramap.b);
                                      i1 = i2;
                                    } while (i2 != 0);
                                    i2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramap.c()));
                                    i1 = i2;
                                  } while (i2 != 0);
                                  if (!c()) {
                                    break;
                                  }
                                  i2 = org.apache.thrift.b.a(this.c, paramap.c);
                                  i1 = i2;
                                } while (i2 != 0);
                                i2 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paramap.d()));
                                i1 = i2;
                              } while (i2 != 0);
                              if (!d()) {
                                break;
                              }
                              i2 = org.apache.thrift.b.a(this.d, paramap.d);
                              i1 = i2;
                            } while (i2 != 0);
                            i2 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paramap.e()));
                            i1 = i2;
                          } while (i2 != 0);
                          if (!e()) {
                            break;
                          }
                          i2 = org.apache.thrift.b.a(this.e, paramap.e);
                          i1 = i2;
                        } while (i2 != 0);
                        i2 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(paramap.f()));
                        i1 = i2;
                      } while (i2 != 0);
                      if (!f()) {
                        break;
                      }
                      i2 = org.apache.thrift.b.a(this.f, paramap.f);
                      i1 = i2;
                    } while (i2 != 0);
                    i2 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(paramap.g()));
                    i1 = i2;
                  } while (i2 != 0);
                  if (!g()) {
                    break;
                  }
                  i2 = org.apache.thrift.b.a(this.g, paramap.g);
                  i1 = i2;
                } while (i2 != 0);
                i2 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(paramap.i()));
                i1 = i2;
              } while (i2 != 0);
              if (!i()) {
                break;
              }
              i2 = org.apache.thrift.b.a(this.h, paramap.h);
              i1 = i2;
            } while (i2 != 0);
            i2 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(paramap.j()));
            i1 = i2;
          } while (i2 != 0);
          if (!j()) {
            break;
          }
          i2 = org.apache.thrift.b.a(this.i, paramap.i);
          i1 = i2;
        } while (i2 != 0);
        i2 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(paramap.l()));
        i1 = i2;
      } while (i2 != 0);
      if (!l()) {
        break;
      }
      i2 = org.apache.thrift.b.a(this.j, paramap.j);
      i1 = i2;
    } while (i2 != 0);
    return 0;
  }
  
  public void b(e parame)
  {
    m();
    parame.a(l);
    if ((this.a != null) && (a()))
    {
      parame.a(m);
      parame.a(this.a);
      parame.b();
    }
    if ((this.b != null) && (b()))
    {
      parame.a(n);
      this.b.b(parame);
      parame.b();
    }
    if (this.c != null)
    {
      parame.a(o);
      parame.a(this.c);
      parame.b();
    }
    if ((this.d != null) && (d()))
    {
      parame.a(p);
      parame.a(this.d);
      parame.b();
    }
    if ((this.e != null) && (e()))
    {
      parame.a(q);
      this.e.b(parame);
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
    if ((this.h != null) && (i()))
    {
      parame.a(t);
      parame.a(this.h);
      parame.b();
    }
    if ((this.i != null) && (j()))
    {
      parame.a(u);
      parame.a(this.i);
      parame.b();
    }
    if ((this.j != null) && (l()))
    {
      parame.a(v);
      parame.a(this.j);
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
  
  public boolean d()
  {
    return this.d != null;
  }
  
  public boolean e()
  {
    return this.e != null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof ap)) {
      return false;
    }
    return a((ap)paramObject);
  }
  
  public boolean f()
  {
    return this.w.get(0);
  }
  
  public boolean g()
  {
    return this.g != null;
  }
  
  public String h()
  {
    return this.h;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean i()
  {
    return this.h != null;
  }
  
  public boolean j()
  {
    return this.i != null;
  }
  
  public String k()
  {
    return this.j;
  }
  
  public boolean l()
  {
    return this.j != null;
  }
  
  public void m()
  {
    if (this.c == null) {
      throw new f("Required field 'id' was not present! Struct: " + toString());
    }
  }
  
  public String toString()
  {
    int i2 = 0;
    StringBuilder localStringBuilder = new StringBuilder("XmPushActionUnSubscriptionResult(");
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
        break label509;
      }
      if (i1 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("target:");
      if (this.b != null) {
        break label411;
      }
      localStringBuilder.append("null");
      i1 = i2;
    }
    label91:
    label126:
    label164:
    label202:
    label272:
    label310:
    label348:
    label411:
    label437:
    label449:
    label461:
    label473:
    label485:
    label497:
    label509:
    for (;;)
    {
      if (i1 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("id:");
      if (this.c == null)
      {
        localStringBuilder.append("null");
        if (d())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("appId:");
          if (this.d != null) {
            break label437;
          }
          localStringBuilder.append("null");
        }
        if (e())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("request:");
          if (this.e != null) {
            break label449;
          }
          localStringBuilder.append("null");
        }
        if (f())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("errorCode:");
          localStringBuilder.append(this.f);
        }
        if (g())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("reason:");
          if (this.g != null) {
            break label461;
          }
          localStringBuilder.append("null");
        }
        if (i())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("topic:");
          if (this.h != null) {
            break label473;
          }
          localStringBuilder.append("null");
        }
        if (j())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("packageName:");
          if (this.i != null) {
            break label485;
          }
          localStringBuilder.append("null");
        }
        if (l())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("category:");
          if (this.j != null) {
            break label497;
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
        break label164;
        localStringBuilder.append(this.e);
        break label202;
        localStringBuilder.append(this.g);
        break label272;
        localStringBuilder.append(this.h);
        break label310;
        localStringBuilder.append(this.i);
        break label348;
        localStringBuilder.append(this.j);
      }
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/xmpush/thrift/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */