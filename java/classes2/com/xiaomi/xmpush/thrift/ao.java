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

public class ao
  implements Serializable, Cloneable, a<ao, a>
{
  public static final Map<a, org.apache.thrift.meta_data.b> h;
  private static final j i = new j("XmPushActionUnSubscription");
  private static final org.apache.thrift.protocol.b j = new org.apache.thrift.protocol.b("debug", (byte)11, (short)1);
  private static final org.apache.thrift.protocol.b k = new org.apache.thrift.protocol.b("target", (byte)12, (short)2);
  private static final org.apache.thrift.protocol.b l = new org.apache.thrift.protocol.b("id", (byte)11, (short)3);
  private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("appId", (byte)11, (short)4);
  private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("topic", (byte)11, (short)5);
  private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("packageName", (byte)11, (short)6);
  private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("category", (byte)11, (short)7);
  public String a;
  public u b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  
  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.apache.thrift.meta_data.b("debug", (byte)2, new c((byte)11)));
    localEnumMap.put(a.b, new org.apache.thrift.meta_data.b("target", (byte)2, new g((byte)12, u.class)));
    localEnumMap.put(a.c, new org.apache.thrift.meta_data.b("id", (byte)1, new c((byte)11)));
    localEnumMap.put(a.d, new org.apache.thrift.meta_data.b("appId", (byte)1, new c((byte)11)));
    localEnumMap.put(a.e, new org.apache.thrift.meta_data.b("topic", (byte)1, new c((byte)11)));
    localEnumMap.put(a.f, new org.apache.thrift.meta_data.b("packageName", (byte)2, new c((byte)11)));
    localEnumMap.put(a.g, new org.apache.thrift.meta_data.b("category", (byte)2, new c((byte)11)));
    h = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(ao.class, h);
  }
  
  public ao a(String paramString)
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
  
  public boolean a()
  {
    return this.a != null;
  }
  
  public boolean a(ao paramao)
  {
    if (paramao == null) {}
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
                  bool2 = paramao.a();
                } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramao.a))));
                bool1 = b();
                bool2 = paramao.b();
              } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.b.a(paramao.b))));
              bool1 = c();
              bool2 = paramao.c();
            } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.c.equals(paramao.c))));
            bool1 = d();
            bool2 = paramao.d();
          } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.d.equals(paramao.d))));
          bool1 = e();
          bool2 = paramao.e();
        } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.e.equals(paramao.e))));
        bool1 = f();
        bool2 = paramao.f();
      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.f.equals(paramao.f))));
      bool1 = g();
      bool2 = paramao.g();
    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.g.equals(paramao.g))));
    return true;
  }
  
  public int b(ao paramao)
  {
    int i1;
    if (!getClass().equals(paramao.getClass())) {
      i1 = getClass().getName().compareTo(paramao.getClass().getName());
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
                                i2 = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramao.a()));
                                i1 = i2;
                              } while (i2 != 0);
                              if (!a()) {
                                break;
                              }
                              i2 = org.apache.thrift.b.a(this.a, paramao.a);
                              i1 = i2;
                            } while (i2 != 0);
                            i2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramao.b()));
                            i1 = i2;
                          } while (i2 != 0);
                          if (!b()) {
                            break;
                          }
                          i2 = org.apache.thrift.b.a(this.b, paramao.b);
                          i1 = i2;
                        } while (i2 != 0);
                        i2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramao.c()));
                        i1 = i2;
                      } while (i2 != 0);
                      if (!c()) {
                        break;
                      }
                      i2 = org.apache.thrift.b.a(this.c, paramao.c);
                      i1 = i2;
                    } while (i2 != 0);
                    i2 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paramao.d()));
                    i1 = i2;
                  } while (i2 != 0);
                  if (!d()) {
                    break;
                  }
                  i2 = org.apache.thrift.b.a(this.d, paramao.d);
                  i1 = i2;
                } while (i2 != 0);
                i2 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paramao.e()));
                i1 = i2;
              } while (i2 != 0);
              if (!e()) {
                break;
              }
              i2 = org.apache.thrift.b.a(this.e, paramao.e);
              i1 = i2;
            } while (i2 != 0);
            i2 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(paramao.f()));
            i1 = i2;
          } while (i2 != 0);
          if (!f()) {
            break;
          }
          i2 = org.apache.thrift.b.a(this.f, paramao.f);
          i1 = i2;
        } while (i2 != 0);
        i2 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(paramao.g()));
        i1 = i2;
      } while (i2 != 0);
      if (!g()) {
        break;
      }
      i2 = org.apache.thrift.b.a(this.g, paramao.g);
      i1 = i2;
    } while (i2 != 0);
    return 0;
  }
  
  public ao b(String paramString)
  {
    this.d = paramString;
    return this;
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
      this.b.b(parame);
      parame.b();
    }
    if (this.c != null)
    {
      parame.a(l);
      parame.a(this.c);
      parame.b();
    }
    if (this.d != null)
    {
      parame.a(m);
      parame.a(this.d);
      parame.b();
    }
    if (this.e != null)
    {
      parame.a(n);
      parame.a(this.e);
      parame.b();
    }
    if ((this.f != null) && (f()))
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
  
  public boolean b()
  {
    return this.b != null;
  }
  
  public ao c(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public boolean c()
  {
    return this.c != null;
  }
  
  public ao d(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public boolean d()
  {
    return this.d != null;
  }
  
  public ao e(String paramString)
  {
    this.g = paramString;
    return this;
  }
  
  public boolean e()
  {
    return this.e != null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof ao)) {
      return false;
    }
    return a((ao)paramObject);
  }
  
  public boolean f()
  {
    return this.f != null;
  }
  
  public boolean g()
  {
    return this.g != null;
  }
  
  public void h()
  {
    if (this.c == null) {
      throw new f("Required field 'id' was not present! Struct: " + toString());
    }
    if (this.d == null) {
      throw new f("Required field 'appId' was not present! Struct: " + toString());
    }
    if (this.e == null) {
      throw new f("Required field 'topic' was not present! Struct: " + toString());
    }
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toString()
  {
    int i2 = 0;
    StringBuilder localStringBuilder = new StringBuilder("XmPushActionUnSubscription(");
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
        break label363;
      }
      if (i1 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("target:");
      if (this.b != null) {
        break label289;
      }
      localStringBuilder.append("null");
      i1 = i2;
    }
    label91:
    label126:
    label157:
    label188:
    label226:
    label289:
    label315:
    label327:
    label339:
    label351:
    label363:
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
          break label315;
        }
        localStringBuilder.append("null");
        localStringBuilder.append(", ");
        localStringBuilder.append("topic:");
        if (this.e != null) {
          break label327;
        }
        localStringBuilder.append("null");
        if (f())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("packageName:");
          if (this.f != null) {
            break label339;
          }
          localStringBuilder.append("null");
        }
        if (g())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("category:");
          if (this.g != null) {
            break label351;
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
        break label188;
        localStringBuilder.append(this.f);
        break label226;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/xmpush/thrift/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */