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

public class x
  implements Serializable, Cloneable, a<x, a>
{
  public static final Map<a, org.apache.thrift.meta_data.b> l;
  private static final j m = new j("XmPushActionAckNotification");
  private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("debug", (byte)11, (short)1);
  private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("target", (byte)12, (short)2);
  private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("id", (byte)11, (short)3);
  private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("appId", (byte)11, (short)4);
  private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("type", (byte)11, (short)5);
  private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b("request", (byte)12, (short)6);
  private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b("errorCode", (byte)10, (short)7);
  private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b("reason", (byte)11, (short)8);
  private static final org.apache.thrift.protocol.b v = new org.apache.thrift.protocol.b("extra", (byte)13, (short)9);
  private static final org.apache.thrift.protocol.b w = new org.apache.thrift.protocol.b("packageName", (byte)11, (short)10);
  private static final org.apache.thrift.protocol.b x = new org.apache.thrift.protocol.b("category", (byte)11, (short)11);
  public String a;
  public u b;
  public String c;
  public String d;
  public String e;
  public ae f;
  public long g;
  public String h;
  public Map<String, String> i;
  public String j;
  public String k;
  private BitSet y = new BitSet(1);
  
  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.apache.thrift.meta_data.b("debug", (byte)2, new c((byte)11)));
    localEnumMap.put(a.b, new org.apache.thrift.meta_data.b("target", (byte)2, new g((byte)12, u.class)));
    localEnumMap.put(a.c, new org.apache.thrift.meta_data.b("id", (byte)1, new c((byte)11)));
    localEnumMap.put(a.d, new org.apache.thrift.meta_data.b("appId", (byte)2, new c((byte)11)));
    localEnumMap.put(a.e, new org.apache.thrift.meta_data.b("type", (byte)2, new c((byte)11)));
    localEnumMap.put(a.f, new org.apache.thrift.meta_data.b("request", (byte)2, new g((byte)12, ae.class)));
    localEnumMap.put(a.g, new org.apache.thrift.meta_data.b("errorCode", (byte)1, new c((byte)10)));
    localEnumMap.put(a.h, new org.apache.thrift.meta_data.b("reason", (byte)2, new c((byte)11)));
    localEnumMap.put(a.i, new org.apache.thrift.meta_data.b("extra", (byte)2, new org.apache.thrift.meta_data.e((byte)13, new c((byte)11), new c((byte)11))));
    localEnumMap.put(a.j, new org.apache.thrift.meta_data.b("packageName", (byte)2, new c((byte)11)));
    localEnumMap.put(a.k, new org.apache.thrift.meta_data.b("category", (byte)2, new c((byte)11)));
    l = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(x.class, l);
  }
  
  public void a(org.apache.thrift.protocol.e parame)
  {
    parame.g();
    Object localObject = parame.i();
    if (((org.apache.thrift.protocol.b)localObject).b == 0)
    {
      parame.h();
      if (!h()) {
        throw new f("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
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
                  if (((org.apache.thrift.protocol.b)localObject).b == 12)
                  {
                    this.f = new ae();
                    this.f.a(parame);
                  }
                  else
                  {
                    h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                    continue;
                    if (((org.apache.thrift.protocol.b)localObject).b == 10)
                    {
                      this.g = parame.u();
                      a(true);
                    }
                    else
                    {
                      h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                      continue;
                      if (((org.apache.thrift.protocol.b)localObject).b == 11)
                      {
                        this.h = parame.w();
                      }
                      else
                      {
                        h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                        continue;
                        if (((org.apache.thrift.protocol.b)localObject).b == 13)
                        {
                          localObject = parame.k();
                          this.i = new HashMap(((d)localObject).c * 2);
                          int i1 = 0;
                          while (i1 < ((d)localObject).c)
                          {
                            String str1 = parame.w();
                            String str2 = parame.w();
                            this.i.put(str1, str2);
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
                            this.j = parame.w();
                          }
                          else
                          {
                            h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                            continue;
                            if (((org.apache.thrift.protocol.b)localObject).b == 11) {
                              this.k = parame.w();
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
    m();
  }
  
  public void a(boolean paramBoolean)
  {
    this.y.set(0, paramBoolean);
  }
  
  public boolean a()
  {
    return this.a != null;
  }
  
  public boolean a(x paramx)
  {
    if (paramx == null) {}
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
                        bool2 = paramx.a();
                      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramx.a))));
                      bool1 = b();
                      bool2 = paramx.b();
                    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.b.a(paramx.b))));
                    bool1 = d();
                    bool2 = paramx.d();
                  } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.c.equals(paramx.c))));
                  bool1 = e();
                  bool2 = paramx.e();
                } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.d.equals(paramx.d))));
                bool1 = f();
                bool2 = paramx.f();
              } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.e.equals(paramx.e))));
              bool1 = g();
              bool2 = paramx.g();
            } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.f.a(paramx.f)) || (this.g != paramx.g)));
            bool1 = i();
            bool2 = paramx.i();
          } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.h.equals(paramx.h))));
          bool1 = j();
          bool2 = paramx.j();
        } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.i.equals(paramx.i))));
        bool1 = k();
        bool2 = paramx.k();
      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.j.equals(paramx.j))));
      bool1 = l();
      bool2 = paramx.l();
    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.k.equals(paramx.k))));
    return true;
  }
  
  public int b(x paramx)
  {
    int i1;
    if (!getClass().equals(paramx.getClass())) {
      i1 = getClass().getName().compareTo(paramx.getClass().getName());
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
                                                return i1;
                                                i2 = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramx.a()));
                                                i1 = i2;
                                              } while (i2 != 0);
                                              if (!a()) {
                                                break;
                                              }
                                              i2 = org.apache.thrift.b.a(this.a, paramx.a);
                                              i1 = i2;
                                            } while (i2 != 0);
                                            i2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramx.b()));
                                            i1 = i2;
                                          } while (i2 != 0);
                                          if (!b()) {
                                            break;
                                          }
                                          i2 = org.apache.thrift.b.a(this.b, paramx.b);
                                          i1 = i2;
                                        } while (i2 != 0);
                                        i2 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paramx.d()));
                                        i1 = i2;
                                      } while (i2 != 0);
                                      if (!d()) {
                                        break;
                                      }
                                      i2 = org.apache.thrift.b.a(this.c, paramx.c);
                                      i1 = i2;
                                    } while (i2 != 0);
                                    i2 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paramx.e()));
                                    i1 = i2;
                                  } while (i2 != 0);
                                  if (!e()) {
                                    break;
                                  }
                                  i2 = org.apache.thrift.b.a(this.d, paramx.d);
                                  i1 = i2;
                                } while (i2 != 0);
                                i2 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(paramx.f()));
                                i1 = i2;
                              } while (i2 != 0);
                              if (!f()) {
                                break;
                              }
                              i2 = org.apache.thrift.b.a(this.e, paramx.e);
                              i1 = i2;
                            } while (i2 != 0);
                            i2 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(paramx.g()));
                            i1 = i2;
                          } while (i2 != 0);
                          if (!g()) {
                            break;
                          }
                          i2 = org.apache.thrift.b.a(this.f, paramx.f);
                          i1 = i2;
                        } while (i2 != 0);
                        i2 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(paramx.h()));
                        i1 = i2;
                      } while (i2 != 0);
                      if (!h()) {
                        break;
                      }
                      i2 = org.apache.thrift.b.a(this.g, paramx.g);
                      i1 = i2;
                    } while (i2 != 0);
                    i2 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(paramx.i()));
                    i1 = i2;
                  } while (i2 != 0);
                  if (!i()) {
                    break;
                  }
                  i2 = org.apache.thrift.b.a(this.h, paramx.h);
                  i1 = i2;
                } while (i2 != 0);
                i2 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(paramx.j()));
                i1 = i2;
              } while (i2 != 0);
              if (!j()) {
                break;
              }
              i2 = org.apache.thrift.b.a(this.i, paramx.i);
              i1 = i2;
            } while (i2 != 0);
            i2 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(paramx.k()));
            i1 = i2;
          } while (i2 != 0);
          if (!k()) {
            break;
          }
          i2 = org.apache.thrift.b.a(this.j, paramx.j);
          i1 = i2;
        } while (i2 != 0);
        i2 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(paramx.l()));
        i1 = i2;
      } while (i2 != 0);
      if (!l()) {
        break;
      }
      i2 = org.apache.thrift.b.a(this.k, paramx.k);
      i1 = i2;
    } while (i2 != 0);
    return 0;
  }
  
  public void b(org.apache.thrift.protocol.e parame)
  {
    m();
    parame.a(m);
    if ((this.a != null) && (a()))
    {
      parame.a(n);
      parame.a(this.a);
      parame.b();
    }
    if ((this.b != null) && (b()))
    {
      parame.a(o);
      this.b.b(parame);
      parame.b();
    }
    if (this.c != null)
    {
      parame.a(p);
      parame.a(this.c);
      parame.b();
    }
    if ((this.d != null) && (e()))
    {
      parame.a(q);
      parame.a(this.d);
      parame.b();
    }
    if ((this.e != null) && (f()))
    {
      parame.a(r);
      parame.a(this.e);
      parame.b();
    }
    if ((this.f != null) && (g()))
    {
      parame.a(s);
      this.f.b(parame);
      parame.b();
    }
    parame.a(t);
    parame.a(this.g);
    parame.b();
    if ((this.h != null) && (i()))
    {
      parame.a(u);
      parame.a(this.h);
      parame.b();
    }
    if ((this.i != null) && (j()))
    {
      parame.a(v);
      parame.a(new d((byte)11, (byte)11, this.i.size()));
      Iterator localIterator = this.i.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        parame.a((String)localEntry.getKey());
        parame.a((String)localEntry.getValue());
      }
      parame.d();
      parame.b();
    }
    if ((this.j != null) && (k()))
    {
      parame.a(w);
      parame.a(this.j);
      parame.b();
    }
    if ((this.k != null) && (l()))
    {
      parame.a(x);
      parame.a(this.k);
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
  
  public boolean e()
  {
    return this.d != null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof x)) {
      return false;
    }
    return a((x)paramObject);
  }
  
  public boolean f()
  {
    return this.e != null;
  }
  
  public boolean g()
  {
    return this.f != null;
  }
  
  public boolean h()
  {
    return this.y.get(0);
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
  
  public boolean k()
  {
    return this.j != null;
  }
  
  public boolean l()
  {
    return this.k != null;
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
    StringBuilder localStringBuilder = new StringBuilder("XmPushActionAckNotification(");
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
        break label552;
      }
      if (i1 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("target:");
      if (this.b != null) {
        break label442;
      }
      localStringBuilder.append("null");
      i1 = i2;
    }
    label91:
    label126:
    label164:
    label202:
    label240:
    label303:
    label341:
    label379:
    label442:
    label468:
    label480:
    label492:
    label504:
    label516:
    label528:
    label540:
    label552:
    for (;;)
    {
      if (i1 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("id:");
      if (this.c == null)
      {
        localStringBuilder.append("null");
        if (e())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("appId:");
          if (this.d != null) {
            break label468;
          }
          localStringBuilder.append("null");
        }
        if (f())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("type:");
          if (this.e != null) {
            break label480;
          }
          localStringBuilder.append("null");
        }
        if (g())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("request:");
          if (this.f != null) {
            break label492;
          }
          localStringBuilder.append("null");
        }
        localStringBuilder.append(", ");
        localStringBuilder.append("errorCode:");
        localStringBuilder.append(this.g);
        if (i())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("reason:");
          if (this.h != null) {
            break label504;
          }
          localStringBuilder.append("null");
        }
        if (j())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("extra:");
          if (this.i != null) {
            break label516;
          }
          localStringBuilder.append("null");
        }
        if (k())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("packageName:");
          if (this.j != null) {
            break label528;
          }
          localStringBuilder.append("null");
        }
        if (l())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("category:");
          if (this.k != null) {
            break label540;
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
        localStringBuilder.append(this.f);
        break label240;
        localStringBuilder.append(this.h);
        break label303;
        localStringBuilder.append(this.i);
        break label341;
        localStringBuilder.append(this.j);
        break label379;
        localStringBuilder.append(this.k);
      }
    }
  }
  
  public static enum a
  {
    private static final Map<String, a> l;
    private final short m;
    private final String n;
    
    static
    {
      l = new HashMap();
      Iterator localIterator = EnumSet.allOf(a.class).iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        l.put(locala.a(), locala);
      }
    }
    
    private a(short paramShort, String paramString)
    {
      this.m = paramShort;
      this.n = paramString;
    }
    
    public String a()
    {
      return this.n;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/xmpush/thrift/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */