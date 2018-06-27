package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
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

public class am
  implements Serializable, Cloneable, a<am, a>
{
  public static final Map<a, org.apache.thrift.meta_data.b> k;
  private static final j l = new j("XmPushActionUnRegistration");
  private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("debug", (byte)11, (short)1);
  private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("target", (byte)12, (short)2);
  private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("id", (byte)11, (short)3);
  private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("appId", (byte)11, (short)4);
  private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("regId", (byte)11, (short)5);
  private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("appVersion", (byte)11, (short)6);
  private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b("packageName", (byte)11, (short)7);
  private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b("token", (byte)11, (short)8);
  private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b("deviceId", (byte)11, (short)9);
  private static final org.apache.thrift.protocol.b v = new org.apache.thrift.protocol.b("aliasName", (byte)11, (short)10);
  public String a;
  public u b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  
  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.apache.thrift.meta_data.b("debug", (byte)2, new c((byte)11)));
    localEnumMap.put(a.b, new org.apache.thrift.meta_data.b("target", (byte)2, new g((byte)12, u.class)));
    localEnumMap.put(a.c, new org.apache.thrift.meta_data.b("id", (byte)1, new c((byte)11)));
    localEnumMap.put(a.d, new org.apache.thrift.meta_data.b("appId", (byte)1, new c((byte)11)));
    localEnumMap.put(a.e, new org.apache.thrift.meta_data.b("regId", (byte)2, new c((byte)11)));
    localEnumMap.put(a.f, new org.apache.thrift.meta_data.b("appVersion", (byte)2, new c((byte)11)));
    localEnumMap.put(a.g, new org.apache.thrift.meta_data.b("packageName", (byte)2, new c((byte)11)));
    localEnumMap.put(a.h, new org.apache.thrift.meta_data.b("token", (byte)2, new c((byte)11)));
    localEnumMap.put(a.i, new org.apache.thrift.meta_data.b("deviceId", (byte)2, new c((byte)11)));
    localEnumMap.put(a.j, new org.apache.thrift.meta_data.b("aliasName", (byte)2, new c((byte)11)));
    k = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(am.class, k);
  }
  
  public am a(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public void a(e parame)
  {
    parame.g();
    org.apache.thrift.protocol.b localb = parame.i();
    if (localb.b == 0)
    {
      parame.h();
      k();
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
              if (localb.b == 11)
              {
                this.e = parame.w();
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
  
  public boolean a()
  {
    return this.a != null;
  }
  
  public boolean a(am paramam)
  {
    if (paramam == null) {}
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
                        bool2 = paramam.a();
                      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramam.a))));
                      bool1 = b();
                      bool2 = paramam.b();
                    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.b.a(paramam.b))));
                    bool1 = c();
                    bool2 = paramam.c();
                  } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.c.equals(paramam.c))));
                  bool1 = d();
                  bool2 = paramam.d();
                } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.d.equals(paramam.d))));
                bool1 = e();
                bool2 = paramam.e();
              } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.e.equals(paramam.e))));
              bool1 = f();
              bool2 = paramam.f();
            } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.f.equals(paramam.f))));
            bool1 = g();
            bool2 = paramam.g();
          } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.g.equals(paramam.g))));
          bool1 = h();
          bool2 = paramam.h();
        } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.h.equals(paramam.h))));
        bool1 = i();
        bool2 = paramam.i();
      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.i.equals(paramam.i))));
      bool1 = j();
      bool2 = paramam.j();
    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.j.equals(paramam.j))));
    return true;
  }
  
  public int b(am paramam)
  {
    int i1;
    if (!getClass().equals(paramam.getClass())) {
      i1 = getClass().getName().compareTo(paramam.getClass().getName());
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
                                            i2 = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramam.a()));
                                            i1 = i2;
                                          } while (i2 != 0);
                                          if (!a()) {
                                            break;
                                          }
                                          i2 = org.apache.thrift.b.a(this.a, paramam.a);
                                          i1 = i2;
                                        } while (i2 != 0);
                                        i2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramam.b()));
                                        i1 = i2;
                                      } while (i2 != 0);
                                      if (!b()) {
                                        break;
                                      }
                                      i2 = org.apache.thrift.b.a(this.b, paramam.b);
                                      i1 = i2;
                                    } while (i2 != 0);
                                    i2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramam.c()));
                                    i1 = i2;
                                  } while (i2 != 0);
                                  if (!c()) {
                                    break;
                                  }
                                  i2 = org.apache.thrift.b.a(this.c, paramam.c);
                                  i1 = i2;
                                } while (i2 != 0);
                                i2 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paramam.d()));
                                i1 = i2;
                              } while (i2 != 0);
                              if (!d()) {
                                break;
                              }
                              i2 = org.apache.thrift.b.a(this.d, paramam.d);
                              i1 = i2;
                            } while (i2 != 0);
                            i2 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paramam.e()));
                            i1 = i2;
                          } while (i2 != 0);
                          if (!e()) {
                            break;
                          }
                          i2 = org.apache.thrift.b.a(this.e, paramam.e);
                          i1 = i2;
                        } while (i2 != 0);
                        i2 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(paramam.f()));
                        i1 = i2;
                      } while (i2 != 0);
                      if (!f()) {
                        break;
                      }
                      i2 = org.apache.thrift.b.a(this.f, paramam.f);
                      i1 = i2;
                    } while (i2 != 0);
                    i2 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(paramam.g()));
                    i1 = i2;
                  } while (i2 != 0);
                  if (!g()) {
                    break;
                  }
                  i2 = org.apache.thrift.b.a(this.g, paramam.g);
                  i1 = i2;
                } while (i2 != 0);
                i2 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(paramam.h()));
                i1 = i2;
              } while (i2 != 0);
              if (!h()) {
                break;
              }
              i2 = org.apache.thrift.b.a(this.h, paramam.h);
              i1 = i2;
            } while (i2 != 0);
            i2 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(paramam.i()));
            i1 = i2;
          } while (i2 != 0);
          if (!i()) {
            break;
          }
          i2 = org.apache.thrift.b.a(this.i, paramam.i);
          i1 = i2;
        } while (i2 != 0);
        i2 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(paramam.j()));
        i1 = i2;
      } while (i2 != 0);
      if (!j()) {
        break;
      }
      i2 = org.apache.thrift.b.a(this.j, paramam.j);
      i1 = i2;
    } while (i2 != 0);
    return 0;
  }
  
  public am b(String paramString)
  {
    this.d = paramString;
    return this;
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
      parame.a(this.e);
      parame.b();
    }
    if ((this.f != null) && (f()))
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
  
  public am c(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public boolean c()
  {
    return this.c != null;
  }
  
  public am d(String paramString)
  {
    this.g = paramString;
    return this;
  }
  
  public boolean d()
  {
    return this.d != null;
  }
  
  public am e(String paramString)
  {
    this.h = paramString;
    return this;
  }
  
  public boolean e()
  {
    return this.e != null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof am)) {
      return false;
    }
    return a((am)paramObject);
  }
  
  public boolean f()
  {
    return this.f != null;
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
    StringBuilder localStringBuilder = new StringBuilder("XmPushActionUnRegistration(");
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
        break label520;
      }
      if (i1 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("target:");
      if (this.b != null) {
        break label410;
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
    label347:
    label410:
    label436:
    label448:
    label460:
    label472:
    label484:
    label496:
    label508:
    label520:
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
          break label436;
        }
        localStringBuilder.append("null");
        if (e())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("regId:");
          if (this.e != null) {
            break label448;
          }
          localStringBuilder.append("null");
        }
        if (f())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("appVersion:");
          if (this.f != null) {
            break label460;
          }
          localStringBuilder.append("null");
        }
        if (g())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("packageName:");
          if (this.g != null) {
            break label472;
          }
          localStringBuilder.append("null");
        }
        if (h())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("token:");
          if (this.h != null) {
            break label484;
          }
          localStringBuilder.append("null");
        }
        if (i())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("deviceId:");
          if (this.i != null) {
            break label496;
          }
          localStringBuilder.append("null");
        }
        if (j())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("aliasName:");
          if (this.j != null) {
            break label508;
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
        localStringBuilder.append(this.i);
        break label347;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/xmpush/thrift/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */