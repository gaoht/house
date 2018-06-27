package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.thrift.a;
import org.apache.thrift.meta_data.d;
import org.apache.thrift.meta_data.g;
import org.apache.thrift.protocol.e;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.h;
import org.apache.thrift.protocol.j;

public class z
  implements Serializable, Cloneable, a<z, a>
{
  public static final Map<a, org.apache.thrift.meta_data.b> i;
  private static final j j = new j("XmPushActionCommand");
  private static final org.apache.thrift.protocol.b k = new org.apache.thrift.protocol.b("debug", (byte)11, (short)1);
  private static final org.apache.thrift.protocol.b l = new org.apache.thrift.protocol.b("target", (byte)12, (short)2);
  private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("id", (byte)11, (short)3);
  private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("appId", (byte)11, (short)4);
  private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("cmdName", (byte)11, (short)5);
  private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("cmdArgs", (byte)15, (short)6);
  private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("packageName", (byte)11, (short)7);
  private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("category", (byte)11, (short)9);
  public String a;
  public u b;
  public String c;
  public String d;
  public String e;
  public List<String> f;
  public String g;
  public String h;
  
  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.apache.thrift.meta_data.b("debug", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(a.b, new org.apache.thrift.meta_data.b("target", (byte)2, new g((byte)12, u.class)));
    localEnumMap.put(a.c, new org.apache.thrift.meta_data.b("id", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(a.d, new org.apache.thrift.meta_data.b("appId", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(a.e, new org.apache.thrift.meta_data.b("cmdName", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(a.f, new org.apache.thrift.meta_data.b("cmdArgs", (byte)2, new d((byte)15, new org.apache.thrift.meta_data.c((byte)11))));
    localEnumMap.put(a.g, new org.apache.thrift.meta_data.b("packageName", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(a.h, new org.apache.thrift.meta_data.b("category", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    i = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(z.class, i);
  }
  
  public z a(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public void a(e parame)
  {
    parame.g();
    Object localObject = parame.i();
    if (((org.apache.thrift.protocol.b)localObject).b == 0)
    {
      parame.h();
      i();
      return;
    }
    switch (((org.apache.thrift.protocol.b)localObject).c)
    {
    case 8: 
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
                if (((org.apache.thrift.protocol.b)localObject).b == 15)
                {
                  localObject = parame.m();
                  this.f = new ArrayList(((org.apache.thrift.protocol.c)localObject).b);
                  int i1 = 0;
                  while (i1 < ((org.apache.thrift.protocol.c)localObject).b)
                  {
                    String str = parame.w();
                    this.f.add(str);
                    i1 += 1;
                  }
                  parame.n();
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
                    if (((org.apache.thrift.protocol.b)localObject).b == 11) {
                      this.h = parame.w();
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
  
  public boolean a()
  {
    return this.a != null;
  }
  
  public boolean a(z paramz)
  {
    if (paramz == null) {}
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
                    bool1 = a();
                    bool2 = paramz.a();
                  } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramz.a))));
                  bool1 = b();
                  bool2 = paramz.b();
                } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.b.a(paramz.b))));
                bool1 = c();
                bool2 = paramz.c();
              } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.c.equals(paramz.c))));
              bool1 = d();
              bool2 = paramz.d();
            } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.d.equals(paramz.d))));
            bool1 = e();
            bool2 = paramz.e();
          } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.e.equals(paramz.e))));
          bool1 = f();
          bool2 = paramz.f();
        } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.f.equals(paramz.f))));
        bool1 = g();
        bool2 = paramz.g();
      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.g.equals(paramz.g))));
      bool1 = h();
      bool2 = paramz.h();
    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.h.equals(paramz.h))));
    return true;
  }
  
  public int b(z paramz)
  {
    int i1;
    if (!getClass().equals(paramz.getClass())) {
      i1 = getClass().getName().compareTo(paramz.getClass().getName());
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
                                    return i1;
                                    i2 = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramz.a()));
                                    i1 = i2;
                                  } while (i2 != 0);
                                  if (!a()) {
                                    break;
                                  }
                                  i2 = org.apache.thrift.b.a(this.a, paramz.a);
                                  i1 = i2;
                                } while (i2 != 0);
                                i2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramz.b()));
                                i1 = i2;
                              } while (i2 != 0);
                              if (!b()) {
                                break;
                              }
                              i2 = org.apache.thrift.b.a(this.b, paramz.b);
                              i1 = i2;
                            } while (i2 != 0);
                            i2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramz.c()));
                            i1 = i2;
                          } while (i2 != 0);
                          if (!c()) {
                            break;
                          }
                          i2 = org.apache.thrift.b.a(this.c, paramz.c);
                          i1 = i2;
                        } while (i2 != 0);
                        i2 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paramz.d()));
                        i1 = i2;
                      } while (i2 != 0);
                      if (!d()) {
                        break;
                      }
                      i2 = org.apache.thrift.b.a(this.d, paramz.d);
                      i1 = i2;
                    } while (i2 != 0);
                    i2 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paramz.e()));
                    i1 = i2;
                  } while (i2 != 0);
                  if (!e()) {
                    break;
                  }
                  i2 = org.apache.thrift.b.a(this.e, paramz.e);
                  i1 = i2;
                } while (i2 != 0);
                i2 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(paramz.f()));
                i1 = i2;
              } while (i2 != 0);
              if (!f()) {
                break;
              }
              i2 = org.apache.thrift.b.a(this.f, paramz.f);
              i1 = i2;
            } while (i2 != 0);
            i2 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(paramz.g()));
            i1 = i2;
          } while (i2 != 0);
          if (!g()) {
            break;
          }
          i2 = org.apache.thrift.b.a(this.g, paramz.g);
          i1 = i2;
        } while (i2 != 0);
        i2 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(paramz.h()));
        i1 = i2;
      } while (i2 != 0);
      if (!h()) {
        break;
      }
      i2 = org.apache.thrift.b.a(this.h, paramz.h);
      i1 = i2;
    } while (i2 != 0);
    return 0;
  }
  
  public z b(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public void b(e parame)
  {
    i();
    parame.a(j);
    if ((this.a != null) && (a()))
    {
      parame.a(k);
      parame.a(this.a);
      parame.b();
    }
    if ((this.b != null) && (b()))
    {
      parame.a(l);
      this.b.b(parame);
      parame.b();
    }
    if (this.c != null)
    {
      parame.a(m);
      parame.a(this.c);
      parame.b();
    }
    if (this.d != null)
    {
      parame.a(n);
      parame.a(this.d);
      parame.b();
    }
    if (this.e != null)
    {
      parame.a(o);
      parame.a(this.e);
      parame.b();
    }
    if ((this.f != null) && (f()))
    {
      parame.a(p);
      parame.a(new org.apache.thrift.protocol.c((byte)11, this.f.size()));
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext()) {
        parame.a((String)localIterator.next());
      }
      parame.e();
      parame.b();
    }
    if ((this.g != null) && (g()))
    {
      parame.a(q);
      parame.a(this.g);
      parame.b();
    }
    if ((this.h != null) && (h()))
    {
      parame.a(r);
      parame.a(this.h);
      parame.b();
    }
    parame.c();
    parame.a();
  }
  
  public boolean b()
  {
    return this.b != null;
  }
  
  public z c(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public boolean c()
  {
    return this.c != null;
  }
  
  public void d(String paramString)
  {
    if (this.f == null) {
      this.f = new ArrayList();
    }
    this.f.add(paramString);
  }
  
  public boolean d()
  {
    return this.d != null;
  }
  
  public z e(String paramString)
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
    while (!(paramObject instanceof z)) {
      return false;
    }
    return a((z)paramObject);
  }
  
  public z f(String paramString)
  {
    this.h = paramString;
    return this;
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
  
  public void i()
  {
    if (this.c == null) {
      throw new f("Required field 'id' was not present! Struct: " + toString());
    }
    if (this.d == null) {
      throw new f("Required field 'appId' was not present! Struct: " + toString());
    }
    if (this.e == null) {
      throw new f("Required field 'cmdName' was not present! Struct: " + toString());
    }
  }
  
  public String toString()
  {
    int i2 = 0;
    StringBuilder localStringBuilder = new StringBuilder("XmPushActionCommand(");
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
        break label413;
      }
      if (i1 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("target:");
      if (this.b != null) {
        break label327;
      }
      localStringBuilder.append("null");
      i1 = i2;
    }
    label91:
    label126:
    label157:
    label188:
    label226:
    label264:
    label327:
    label353:
    label365:
    label377:
    label389:
    label401:
    label413:
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
          break label353;
        }
        localStringBuilder.append("null");
        localStringBuilder.append(", ");
        localStringBuilder.append("cmdName:");
        if (this.e != null) {
          break label365;
        }
        localStringBuilder.append("null");
        if (f())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("cmdArgs:");
          if (this.f != null) {
            break label377;
          }
          localStringBuilder.append("null");
        }
        if (g())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("packageName:");
          if (this.g != null) {
            break label389;
          }
          localStringBuilder.append("null");
        }
        if (h())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("category:");
          if (this.h != null) {
            break label401;
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
        break label264;
        localStringBuilder.append(this.h);
      }
    }
  }
  
  public static enum a
  {
    private static final Map<String, a> i;
    private final short j;
    private final String k;
    
    static
    {
      i = new HashMap();
      Iterator localIterator = EnumSet.allOf(a.class).iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        i.put(locala.a(), locala);
      }
    }
    
    private a(short paramShort, String paramString)
    {
      this.j = paramShort;
      this.k = paramString;
    }
    
    public String a()
    {
      return this.k;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/xmpush/thrift/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */