package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.thrift.meta_data.d;
import org.apache.thrift.meta_data.g;
import org.apache.thrift.protocol.e;
import org.apache.thrift.protocol.f;

public class j
  implements Serializable, Cloneable, org.apache.thrift.a<j, a>
{
  public static final Map<a, org.apache.thrift.meta_data.b> k;
  private static final org.apache.thrift.protocol.j l = new org.apache.thrift.protocol.j("GeoFencing");
  private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("id", (byte)11, (short)1);
  private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("name", (byte)11, (short)2);
  private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("appId", (byte)10, (short)3);
  private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("packageName", (byte)11, (short)4);
  private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("createTime", (byte)10, (short)5);
  private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("type", (byte)8, (short)6);
  private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b("circleCenter", (byte)12, (short)7);
  private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b("circleRadius", (byte)4, (short)9);
  private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b("polygonPoints", (byte)15, (short)10);
  private static final org.apache.thrift.protocol.b v = new org.apache.thrift.protocol.b("coordinateProvider", (byte)8, (short)11);
  public String a;
  public String b;
  public long c;
  public String d;
  public long e;
  public k f;
  public l g;
  public double h;
  public List<l> i;
  public h j;
  private BitSet w = new BitSet(3);
  
  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.apache.thrift.meta_data.b("id", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(a.b, new org.apache.thrift.meta_data.b("name", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(a.c, new org.apache.thrift.meta_data.b("appId", (byte)1, new org.apache.thrift.meta_data.c((byte)10)));
    localEnumMap.put(a.d, new org.apache.thrift.meta_data.b("packageName", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(a.e, new org.apache.thrift.meta_data.b("createTime", (byte)1, new org.apache.thrift.meta_data.c((byte)10)));
    localEnumMap.put(a.f, new org.apache.thrift.meta_data.b("type", (byte)1, new org.apache.thrift.meta_data.a((byte)16, k.class)));
    localEnumMap.put(a.g, new org.apache.thrift.meta_data.b("circleCenter", (byte)2, new g((byte)12, l.class)));
    localEnumMap.put(a.h, new org.apache.thrift.meta_data.b("circleRadius", (byte)2, new org.apache.thrift.meta_data.c((byte)4)));
    localEnumMap.put(a.i, new org.apache.thrift.meta_data.b("polygonPoints", (byte)2, new d((byte)15, new g((byte)12, l.class))));
    localEnumMap.put(a.j, new org.apache.thrift.meta_data.b("coordinateProvider", (byte)1, new org.apache.thrift.meta_data.a((byte)16, h.class)));
    k = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(j.class, k);
  }
  
  public j a(double paramDouble)
  {
    this.h = paramDouble;
    c(true);
    return this;
  }
  
  public j a(long paramLong)
  {
    this.c = paramLong;
    a(true);
    return this;
  }
  
  public j a(h paramh)
  {
    this.j = paramh;
    return this;
  }
  
  public j a(k paramk)
  {
    this.f = paramk;
    return this;
  }
  
  public j a(l paraml)
  {
    this.g = paraml;
    return this;
  }
  
  public j a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public j a(List<l> paramList)
  {
    this.i = paramList;
    return this;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(e parame)
  {
    parame.g();
    Object localObject = parame.i();
    if (((org.apache.thrift.protocol.b)localObject).b == 0)
    {
      parame.h();
      if (!f()) {
        throw new f("Required field 'appId' was not found in serialized data! Struct: " + toString());
      }
    }
    else
    {
      switch (((org.apache.thrift.protocol.b)localObject).c)
      {
      case 8: 
      default: 
        org.apache.thrift.protocol.h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
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
          org.apache.thrift.protocol.h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
          continue;
          if (((org.apache.thrift.protocol.b)localObject).b == 11)
          {
            this.b = parame.w();
          }
          else
          {
            org.apache.thrift.protocol.h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
            continue;
            if (((org.apache.thrift.protocol.b)localObject).b == 10)
            {
              this.c = parame.u();
              a(true);
            }
            else
            {
              org.apache.thrift.protocol.h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
              continue;
              if (((org.apache.thrift.protocol.b)localObject).b == 11)
              {
                this.d = parame.w();
              }
              else
              {
                org.apache.thrift.protocol.h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                continue;
                if (((org.apache.thrift.protocol.b)localObject).b == 10)
                {
                  this.e = parame.u();
                  b(true);
                }
                else
                {
                  org.apache.thrift.protocol.h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                  continue;
                  if (((org.apache.thrift.protocol.b)localObject).b == 8)
                  {
                    this.f = k.a(parame.t());
                  }
                  else
                  {
                    org.apache.thrift.protocol.h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                    continue;
                    if (((org.apache.thrift.protocol.b)localObject).b == 12)
                    {
                      this.g = new l();
                      this.g.a(parame);
                    }
                    else
                    {
                      org.apache.thrift.protocol.h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                      continue;
                      if (((org.apache.thrift.protocol.b)localObject).b == 4)
                      {
                        this.h = parame.v();
                        c(true);
                      }
                      else
                      {
                        org.apache.thrift.protocol.h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                        continue;
                        if (((org.apache.thrift.protocol.b)localObject).b == 15)
                        {
                          localObject = parame.m();
                          this.i = new ArrayList(((org.apache.thrift.protocol.c)localObject).b);
                          int i1 = 0;
                          while (i1 < ((org.apache.thrift.protocol.c)localObject).b)
                          {
                            l locall = new l();
                            locall.a(parame);
                            this.i.add(locall);
                            i1 += 1;
                          }
                          parame.n();
                        }
                        else
                        {
                          org.apache.thrift.protocol.h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                          continue;
                          if (((org.apache.thrift.protocol.b)localObject).b == 8) {
                            this.j = h.a(parame.t());
                          } else {
                            org.apache.thrift.protocol.h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
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
    if (!j()) {
      throw new f("Required field 'createTime' was not found in serialized data! Struct: " + toString());
    }
    u();
  }
  
  public void a(boolean paramBoolean)
  {
    this.w.set(0, paramBoolean);
  }
  
  public boolean a(j paramj)
  {
    if (paramj == null) {}
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
                    bool1 = b();
                    bool2 = paramj.b();
                  } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramj.a))));
                  bool1 = d();
                  bool2 = paramj.d();
                } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.b.equals(paramj.b)) || (this.c != paramj.c)));
                bool1 = h();
                bool2 = paramj.h();
              } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.d.equals(paramj.d)) || (this.e != paramj.e)));
              bool1 = l();
              bool2 = paramj.l();
            } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.f.equals(paramj.f))));
            bool1 = n();
            bool2 = paramj.n();
          } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.g.a(paramj.g))));
          bool1 = p();
          bool2 = paramj.p();
        } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (this.h != paramj.h)));
        bool1 = r();
        bool2 = paramj.r();
      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.i.equals(paramj.i))));
      bool1 = t();
      bool2 = paramj.t();
    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.j.equals(paramj.j))));
    return true;
  }
  
  public int b(j paramj)
  {
    int i1;
    if (!getClass().equals(paramj.getClass())) {
      i1 = getClass().getName().compareTo(paramj.getClass().getName());
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
                                            i2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramj.b()));
                                            i1 = i2;
                                          } while (i2 != 0);
                                          if (!b()) {
                                            break;
                                          }
                                          i2 = org.apache.thrift.b.a(this.a, paramj.a);
                                          i1 = i2;
                                        } while (i2 != 0);
                                        i2 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paramj.d()));
                                        i1 = i2;
                                      } while (i2 != 0);
                                      if (!d()) {
                                        break;
                                      }
                                      i2 = org.apache.thrift.b.a(this.b, paramj.b);
                                      i1 = i2;
                                    } while (i2 != 0);
                                    i2 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(paramj.f()));
                                    i1 = i2;
                                  } while (i2 != 0);
                                  if (!f()) {
                                    break;
                                  }
                                  i2 = org.apache.thrift.b.a(this.c, paramj.c);
                                  i1 = i2;
                                } while (i2 != 0);
                                i2 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(paramj.h()));
                                i1 = i2;
                              } while (i2 != 0);
                              if (!h()) {
                                break;
                              }
                              i2 = org.apache.thrift.b.a(this.d, paramj.d);
                              i1 = i2;
                            } while (i2 != 0);
                            i2 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(paramj.j()));
                            i1 = i2;
                          } while (i2 != 0);
                          if (!j()) {
                            break;
                          }
                          i2 = org.apache.thrift.b.a(this.e, paramj.e);
                          i1 = i2;
                        } while (i2 != 0);
                        i2 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(paramj.l()));
                        i1 = i2;
                      } while (i2 != 0);
                      if (!l()) {
                        break;
                      }
                      i2 = org.apache.thrift.b.a(this.f, paramj.f);
                      i1 = i2;
                    } while (i2 != 0);
                    i2 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(paramj.n()));
                    i1 = i2;
                  } while (i2 != 0);
                  if (!n()) {
                    break;
                  }
                  i2 = org.apache.thrift.b.a(this.g, paramj.g);
                  i1 = i2;
                } while (i2 != 0);
                i2 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(paramj.p()));
                i1 = i2;
              } while (i2 != 0);
              if (!p()) {
                break;
              }
              i2 = org.apache.thrift.b.a(this.h, paramj.h);
              i1 = i2;
            } while (i2 != 0);
            i2 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(paramj.r()));
            i1 = i2;
          } while (i2 != 0);
          if (!r()) {
            break;
          }
          i2 = org.apache.thrift.b.a(this.i, paramj.i);
          i1 = i2;
        } while (i2 != 0);
        i2 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(paramj.t()));
        i1 = i2;
      } while (i2 != 0);
      if (!t()) {
        break;
      }
      i2 = org.apache.thrift.b.a(this.j, paramj.j);
      i1 = i2;
    } while (i2 != 0);
    return 0;
  }
  
  public j b(long paramLong)
  {
    this.e = paramLong;
    b(true);
    return this;
  }
  
  public j b(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public void b(e parame)
  {
    u();
    parame.a(l);
    if (this.a != null)
    {
      parame.a(m);
      parame.a(this.a);
      parame.b();
    }
    if (this.b != null)
    {
      parame.a(n);
      parame.a(this.b);
      parame.b();
    }
    parame.a(o);
    parame.a(this.c);
    parame.b();
    if (this.d != null)
    {
      parame.a(p);
      parame.a(this.d);
      parame.b();
    }
    parame.a(q);
    parame.a(this.e);
    parame.b();
    if (this.f != null)
    {
      parame.a(r);
      parame.a(this.f.a());
      parame.b();
    }
    if ((this.g != null) && (n()))
    {
      parame.a(s);
      this.g.b(parame);
      parame.b();
    }
    if (p())
    {
      parame.a(t);
      parame.a(this.h);
      parame.b();
    }
    if ((this.i != null) && (r()))
    {
      parame.a(u);
      parame.a(new org.apache.thrift.protocol.c((byte)12, this.i.size()));
      Iterator localIterator = this.i.iterator();
      while (localIterator.hasNext()) {
        ((l)localIterator.next()).b(parame);
      }
      parame.e();
      parame.b();
    }
    if (this.j != null)
    {
      parame.a(v);
      parame.a(this.j.a());
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
    return this.a != null;
  }
  
  public j c(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public String c()
  {
    return this.b;
  }
  
  public void c(boolean paramBoolean)
  {
    this.w.set(2, paramBoolean);
  }
  
  public boolean d()
  {
    return this.b != null;
  }
  
  public long e()
  {
    return this.c;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof j)) {
      return false;
    }
    return a((j)paramObject);
  }
  
  public boolean f()
  {
    return this.w.get(0);
  }
  
  public String g()
  {
    return this.d;
  }
  
  public boolean h()
  {
    return this.d != null;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public long i()
  {
    return this.e;
  }
  
  public boolean j()
  {
    return this.w.get(1);
  }
  
  public k k()
  {
    return this.f;
  }
  
  public boolean l()
  {
    return this.f != null;
  }
  
  public l m()
  {
    return this.g;
  }
  
  public boolean n()
  {
    return this.g != null;
  }
  
  public double o()
  {
    return this.h;
  }
  
  public boolean p()
  {
    return this.w.get(2);
  }
  
  public List<l> q()
  {
    return this.i;
  }
  
  public boolean r()
  {
    return this.i != null;
  }
  
  public h s()
  {
    return this.j;
  }
  
  public boolean t()
  {
    return this.j != null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("GeoFencing(");
    localStringBuilder.append("id:");
    if (this.a == null)
    {
      localStringBuilder.append("null");
      localStringBuilder.append(", ");
      localStringBuilder.append("name:");
      if (this.b != null) {
        break label341;
      }
      localStringBuilder.append("null");
      label65:
      localStringBuilder.append(", ");
      localStringBuilder.append("appId:");
      localStringBuilder.append(this.c);
      localStringBuilder.append(", ");
      localStringBuilder.append("packageName:");
      if (this.d != null) {
        break label353;
      }
      localStringBuilder.append("null");
      label121:
      localStringBuilder.append(", ");
      localStringBuilder.append("createTime:");
      localStringBuilder.append(this.e);
      localStringBuilder.append(", ");
      localStringBuilder.append("type:");
      if (this.f != null) {
        break label365;
      }
      localStringBuilder.append("null");
      label177:
      if (n())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("circleCenter:");
        if (this.g != null) {
          break label377;
        }
        localStringBuilder.append("null");
      }
      label215:
      if (p())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("circleRadius:");
        localStringBuilder.append(this.h);
      }
      if (r())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("polygonPoints:");
        if (this.i != null) {
          break label389;
        }
        localStringBuilder.append("null");
      }
      label285:
      localStringBuilder.append(", ");
      localStringBuilder.append("coordinateProvider:");
      if (this.j != null) {
        break label401;
      }
      localStringBuilder.append("null");
    }
    for (;;)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
      break;
      label341:
      localStringBuilder.append(this.b);
      break label65;
      label353:
      localStringBuilder.append(this.d);
      break label121;
      label365:
      localStringBuilder.append(this.f);
      break label177;
      label377:
      localStringBuilder.append(this.g);
      break label215;
      label389:
      localStringBuilder.append(this.i);
      break label285;
      label401:
      localStringBuilder.append(this.j);
    }
  }
  
  public void u()
  {
    if (this.a == null) {
      throw new f("Required field 'id' was not present! Struct: " + toString());
    }
    if (this.b == null) {
      throw new f("Required field 'name' was not present! Struct: " + toString());
    }
    if (this.d == null) {
      throw new f("Required field 'packageName' was not present! Struct: " + toString());
    }
    if (this.f == null) {
      throw new f("Required field 'type' was not present! Struct: " + toString());
    }
    if (this.j == null) {
      throw new f("Required field 'coordinateProvider' was not present! Struct: " + toString());
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/xmpush/thrift/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */