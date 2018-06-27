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

public class ag
  implements Serializable, Cloneable, a<ag, a>
{
  public static final Map<a, org.apache.thrift.meta_data.b> k;
  private static final j l = new j("XmPushActionRegistrationResult");
  private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("debug", (byte)11, (short)1);
  private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("target", (byte)12, (short)2);
  private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("id", (byte)11, (short)3);
  private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("appId", (byte)11, (short)4);
  private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("request", (byte)12, (short)5);
  private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("errorCode", (byte)10, (short)6);
  private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b("reason", (byte)11, (short)7);
  private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b("regId", (byte)11, (short)8);
  private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b("regSecret", (byte)11, (short)9);
  private static final org.apache.thrift.protocol.b v = new org.apache.thrift.protocol.b("packageName", (byte)11, (short)10);
  public String a;
  public u b;
  public String c;
  public String d;
  public af e;
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
    localEnumMap.put(a.d, new org.apache.thrift.meta_data.b("appId", (byte)1, new c((byte)11)));
    localEnumMap.put(a.e, new org.apache.thrift.meta_data.b("request", (byte)2, new g((byte)12, af.class)));
    localEnumMap.put(a.f, new org.apache.thrift.meta_data.b("errorCode", (byte)1, new c((byte)10)));
    localEnumMap.put(a.g, new org.apache.thrift.meta_data.b("reason", (byte)2, new c((byte)11)));
    localEnumMap.put(a.h, new org.apache.thrift.meta_data.b("regId", (byte)2, new c((byte)11)));
    localEnumMap.put(a.i, new org.apache.thrift.meta_data.b("regSecret", (byte)2, new c((byte)11)));
    localEnumMap.put(a.j, new org.apache.thrift.meta_data.b("packageName", (byte)2, new c((byte)11)));
    k = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(ag.class, k);
  }
  
  public void a(e parame)
  {
    parame.g();
    org.apache.thrift.protocol.b localb = parame.i();
    if (localb.b == 0)
    {
      parame.h();
      if (!f()) {
        throw new f("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
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
                  this.e = new af();
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
    k();
  }
  
  public void a(boolean paramBoolean)
  {
    this.w.set(0, paramBoolean);
  }
  
  public boolean a()
  {
    return this.a != null;
  }
  
  public boolean a(ag paramag)
  {
    if (paramag == null) {}
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
                      return false;
                      bool1 = a();
                      bool2 = paramag.a();
                    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramag.a))));
                    bool1 = b();
                    bool2 = paramag.b();
                  } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.b.a(paramag.b))));
                  bool1 = c();
                  bool2 = paramag.c();
                } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.c.equals(paramag.c))));
                bool1 = d();
                bool2 = paramag.d();
              } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.d.equals(paramag.d))));
              bool1 = e();
              bool2 = paramag.e();
            } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.e.a(paramag.e)) || (this.f != paramag.f)));
            bool1 = g();
            bool2 = paramag.g();
          } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.g.equals(paramag.g))));
          bool1 = h();
          bool2 = paramag.h();
        } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.h.equals(paramag.h))));
        bool1 = i();
        bool2 = paramag.i();
      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.i.equals(paramag.i))));
      bool1 = j();
      bool2 = paramag.j();
    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.j.equals(paramag.j))));
    return true;
  }
  
  public int b(ag paramag)
  {
    int i1;
    if (!getClass().equals(paramag.getClass())) {
      i1 = getClass().getName().compareTo(paramag.getClass().getName());
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
                                            i2 = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramag.a()));
                                            i1 = i2;
                                          } while (i2 != 0);
                                          if (!a()) {
                                            break;
                                          }
                                          i2 = org.apache.thrift.b.a(this.a, paramag.a);
                                          i1 = i2;
                                        } while (i2 != 0);
                                        i2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramag.b()));
                                        i1 = i2;
                                      } while (i2 != 0);
                                      if (!b()) {
                                        break;
                                      }
                                      i2 = org.apache.thrift.b.a(this.b, paramag.b);
                                      i1 = i2;
                                    } while (i2 != 0);
                                    i2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramag.c()));
                                    i1 = i2;
                                  } while (i2 != 0);
                                  if (!c()) {
                                    break;
                                  }
                                  i2 = org.apache.thrift.b.a(this.c, paramag.c);
                                  i1 = i2;
                                } while (i2 != 0);
                                i2 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paramag.d()));
                                i1 = i2;
                              } while (i2 != 0);
                              if (!d()) {
                                break;
                              }
                              i2 = org.apache.thrift.b.a(this.d, paramag.d);
                              i1 = i2;
                            } while (i2 != 0);
                            i2 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paramag.e()));
                            i1 = i2;
                          } while (i2 != 0);
                          if (!e()) {
                            break;
                          }
                          i2 = org.apache.thrift.b.a(this.e, paramag.e);
                          i1 = i2;
                        } while (i2 != 0);
                        i2 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(paramag.f()));
                        i1 = i2;
                      } while (i2 != 0);
                      if (!f()) {
                        break;
                      }
                      i2 = org.apache.thrift.b.a(this.f, paramag.f);
                      i1 = i2;
                    } while (i2 != 0);
                    i2 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(paramag.g()));
                    i1 = i2;
                  } while (i2 != 0);
                  if (!g()) {
                    break;
                  }
                  i2 = org.apache.thrift.b.a(this.g, paramag.g);
                  i1 = i2;
                } while (i2 != 0);
                i2 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(paramag.h()));
                i1 = i2;
              } while (i2 != 0);
              if (!h()) {
                break;
              }
              i2 = org.apache.thrift.b.a(this.h, paramag.h);
              i1 = i2;
            } while (i2 != 0);
            i2 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(paramag.i()));
            i1 = i2;
          } while (i2 != 0);
          if (!i()) {
            break;
          }
          i2 = org.apache.thrift.b.a(this.i, paramag.i);
          i1 = i2;
        } while (i2 != 0);
        i2 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(paramag.j()));
        i1 = i2;
      } while (i2 != 0);
      if (!j()) {
        break;
      }
      i2 = org.apache.thrift.b.a(this.j, paramag.j);
      i1 = i2;
    } while (i2 != 0);
    return 0;
  }
  
  public void b(e parame)
  {
    k();
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
    if (this.d != null)
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
    parame.a(r);
    parame.a(this.f);
    parame.b();
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
    if ((this.i != null) && (i()))
    {
      parame.a(u);
      parame.a(this.i);
      parame.b();
    }
    if ((this.j != null) && (j()))
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
    while (!(paramObject instanceof ag)) {
      return false;
    }
    return a((ag)paramObject);
  }
  
  public boolean f()
  {
    return this.w.get(0);
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
    return this.i != null;
  }
  
  public boolean j()
  {
    return this.j != null;
  }
  
  public void k()
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
    StringBuilder localStringBuilder = new StringBuilder("XmPushActionRegistrationResult(");
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
        break label495;
      }
      if (i1 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("target:");
      if (this.b != null) {
        break label397;
      }
      localStringBuilder.append("null");
      i1 = i2;
    }
    label91:
    label126:
    label157:
    label195:
    label258:
    label296:
    label334:
    label397:
    label423:
    label435:
    label447:
    label459:
    label471:
    label483:
    label495:
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
          break label423;
        }
        localStringBuilder.append("null");
        if (e())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("request:");
          if (this.e != null) {
            break label435;
          }
          localStringBuilder.append("null");
        }
        localStringBuilder.append(", ");
        localStringBuilder.append("errorCode:");
        localStringBuilder.append(this.f);
        if (g())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("reason:");
          if (this.g != null) {
            break label447;
          }
          localStringBuilder.append("null");
        }
        if (h())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("regId:");
          if (this.h != null) {
            break label459;
          }
          localStringBuilder.append("null");
        }
        if (i())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("regSecret:");
          if (this.i != null) {
            break label471;
          }
          localStringBuilder.append("null");
        }
        if (j())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("packageName:");
          if (this.j != null) {
            break label483;
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
        localStringBuilder.append(this.g);
        break label258;
        localStringBuilder.append(this.h);
        break label296;
        localStringBuilder.append(this.i);
        break label334;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/xmpush/thrift/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */