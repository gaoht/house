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
import org.apache.thrift.protocol.d;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.h;
import org.apache.thrift.protocol.j;

public class r
  implements Serializable, Cloneable, a<r, a>
{
  public static final Map<a, org.apache.thrift.meta_data.b> m;
  private static final j n = new j("PushMetaInfo");
  private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("id", (byte)11, (short)1);
  private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("messageTs", (byte)10, (short)2);
  private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("topic", (byte)11, (short)3);
  private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("title", (byte)11, (short)4);
  private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b("description", (byte)11, (short)5);
  private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b("notifyType", (byte)8, (short)6);
  private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b("url", (byte)11, (short)7);
  private static final org.apache.thrift.protocol.b v = new org.apache.thrift.protocol.b("passThrough", (byte)8, (short)8);
  private static final org.apache.thrift.protocol.b w = new org.apache.thrift.protocol.b("notifyId", (byte)8, (short)9);
  private static final org.apache.thrift.protocol.b x = new org.apache.thrift.protocol.b("extra", (byte)13, (short)10);
  private static final org.apache.thrift.protocol.b y = new org.apache.thrift.protocol.b("internal", (byte)13, (short)11);
  private static final org.apache.thrift.protocol.b z = new org.apache.thrift.protocol.b("ignoreRegInfo", (byte)2, (short)12);
  private BitSet A = new BitSet(5);
  public String a;
  public long b;
  public String c;
  public String d;
  public String e;
  public int f;
  public String g;
  public int h;
  public int i;
  public Map<String, String> j;
  public Map<String, String> k;
  public boolean l;
  
  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.apache.thrift.meta_data.b("id", (byte)1, new c((byte)11)));
    localEnumMap.put(a.b, new org.apache.thrift.meta_data.b("messageTs", (byte)1, new c((byte)10)));
    localEnumMap.put(a.c, new org.apache.thrift.meta_data.b("topic", (byte)2, new c((byte)11)));
    localEnumMap.put(a.d, new org.apache.thrift.meta_data.b("title", (byte)2, new c((byte)11)));
    localEnumMap.put(a.e, new org.apache.thrift.meta_data.b("description", (byte)2, new c((byte)11)));
    localEnumMap.put(a.f, new org.apache.thrift.meta_data.b("notifyType", (byte)2, new c((byte)8)));
    localEnumMap.put(a.g, new org.apache.thrift.meta_data.b("url", (byte)2, new c((byte)11)));
    localEnumMap.put(a.h, new org.apache.thrift.meta_data.b("passThrough", (byte)2, new c((byte)8)));
    localEnumMap.put(a.i, new org.apache.thrift.meta_data.b("notifyId", (byte)2, new c((byte)8)));
    localEnumMap.put(a.j, new org.apache.thrift.meta_data.b("extra", (byte)2, new org.apache.thrift.meta_data.e((byte)13, new c((byte)11), new c((byte)11))));
    localEnumMap.put(a.k, new org.apache.thrift.meta_data.b("internal", (byte)2, new org.apache.thrift.meta_data.e((byte)13, new c((byte)11), new c((byte)11))));
    localEnumMap.put(a.l, new org.apache.thrift.meta_data.b("ignoreRegInfo", (byte)2, new c((byte)2)));
    m = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(r.class, m);
  }
  
  public r()
  {
    this.l = false;
  }
  
  public r(r paramr)
  {
    this.A.clear();
    this.A.or(paramr.A);
    if (paramr.c()) {
      this.a = paramr.a;
    }
    this.b = paramr.b;
    if (paramr.g()) {
      this.c = paramr.c;
    }
    if (paramr.i()) {
      this.d = paramr.d;
    }
    if (paramr.k()) {
      this.e = paramr.e;
    }
    this.f = paramr.f;
    if (paramr.n()) {
      this.g = paramr.g;
    }
    this.h = paramr.h;
    this.i = paramr.i;
    HashMap localHashMap;
    Iterator localIterator;
    Map.Entry localEntry;
    if (paramr.t())
    {
      localHashMap = new HashMap();
      localIterator = paramr.j.entrySet().iterator();
      while (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        localHashMap.put((String)localEntry.getKey(), (String)localEntry.getValue());
      }
      this.j = localHashMap;
    }
    if (paramr.u())
    {
      localHashMap = new HashMap();
      localIterator = paramr.k.entrySet().iterator();
      while (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        localHashMap.put((String)localEntry.getKey(), (String)localEntry.getValue());
      }
      this.k = localHashMap;
    }
    this.l = paramr.l;
  }
  
  public r a()
  {
    return new r(this);
  }
  
  public r a(int paramInt)
  {
    this.f = paramInt;
    b(true);
    return this;
  }
  
  public r a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public r a(Map<String, String> paramMap)
  {
    this.j = paramMap;
    return this;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.j == null) {
      this.j = new HashMap();
    }
    this.j.put(paramString1, paramString2);
  }
  
  public void a(org.apache.thrift.protocol.e parame)
  {
    parame.g();
    Object localObject = parame.i();
    if (((org.apache.thrift.protocol.b)localObject).b == 0)
    {
      parame.h();
      if (!e()) {
        throw new f("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
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
          if (((org.apache.thrift.protocol.b)localObject).b == 10)
          {
            this.b = parame.u();
            a(true);
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
                  if (((org.apache.thrift.protocol.b)localObject).b == 8)
                  {
                    this.f = parame.t();
                    b(true);
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
                      if (((org.apache.thrift.protocol.b)localObject).b == 8)
                      {
                        this.h = parame.t();
                        c(true);
                      }
                      else
                      {
                        h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                        continue;
                        if (((org.apache.thrift.protocol.b)localObject).b == 8)
                        {
                          this.i = parame.t();
                          d(true);
                        }
                        else
                        {
                          h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                          continue;
                          int i1;
                          String str1;
                          String str2;
                          if (((org.apache.thrift.protocol.b)localObject).b == 13)
                          {
                            localObject = parame.k();
                            this.j = new HashMap(((d)localObject).c * 2);
                            i1 = 0;
                            while (i1 < ((d)localObject).c)
                            {
                              str1 = parame.w();
                              str2 = parame.w();
                              this.j.put(str1, str2);
                              i1 += 1;
                            }
                            parame.l();
                          }
                          else
                          {
                            h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                            continue;
                            if (((org.apache.thrift.protocol.b)localObject).b == 13)
                            {
                              localObject = parame.k();
                              this.k = new HashMap(((d)localObject).c * 2);
                              i1 = 0;
                              while (i1 < ((d)localObject).c)
                              {
                                str1 = parame.w();
                                str2 = parame.w();
                                this.k.put(str1, str2);
                                i1 += 1;
                              }
                              parame.l();
                            }
                            else
                            {
                              h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                              continue;
                              if (((org.apache.thrift.protocol.b)localObject).b == 2)
                              {
                                this.l = parame.q();
                                e(true);
                              }
                              else
                              {
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
    x();
  }
  
  public void a(boolean paramBoolean)
  {
    this.A.set(0, paramBoolean);
  }
  
  public boolean a(r paramr)
  {
    if (paramr == null) {}
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
                          return false;
                          bool1 = c();
                          bool2 = paramr.c();
                        } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramr.a)) || (this.b != paramr.b)));
                        bool1 = g();
                        bool2 = paramr.g();
                      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.c.equals(paramr.c))));
                      bool1 = i();
                      bool2 = paramr.i();
                    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.d.equals(paramr.d))));
                    bool1 = k();
                    bool2 = paramr.k();
                  } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.e.equals(paramr.e))));
                  bool1 = m();
                  bool2 = paramr.m();
                } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (this.f != paramr.f)));
                bool1 = n();
                bool2 = paramr.n();
              } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.g.equals(paramr.g))));
              bool1 = p();
              bool2 = paramr.p();
            } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (this.h != paramr.h)));
            bool1 = r();
            bool2 = paramr.r();
          } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (this.i != paramr.i)));
          bool1 = t();
          bool2 = paramr.t();
        } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.j.equals(paramr.j))));
        bool1 = u();
        bool2 = paramr.u();
      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.k.equals(paramr.k))));
      bool1 = w();
      bool2 = paramr.w();
    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (this.l != paramr.l)));
    return true;
  }
  
  public int b(r paramr)
  {
    int i1;
    if (!getClass().equals(paramr.getClass())) {
      i1 = getClass().getName().compareTo(paramr.getClass().getName());
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
                                                    i2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramr.c()));
                                                    i1 = i2;
                                                  } while (i2 != 0);
                                                  if (!c()) {
                                                    break;
                                                  }
                                                  i2 = org.apache.thrift.b.a(this.a, paramr.a);
                                                  i1 = i2;
                                                } while (i2 != 0);
                                                i2 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paramr.e()));
                                                i1 = i2;
                                              } while (i2 != 0);
                                              if (!e()) {
                                                break;
                                              }
                                              i2 = org.apache.thrift.b.a(this.b, paramr.b);
                                              i1 = i2;
                                            } while (i2 != 0);
                                            i2 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(paramr.g()));
                                            i1 = i2;
                                          } while (i2 != 0);
                                          if (!g()) {
                                            break;
                                          }
                                          i2 = org.apache.thrift.b.a(this.c, paramr.c);
                                          i1 = i2;
                                        } while (i2 != 0);
                                        i2 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(paramr.i()));
                                        i1 = i2;
                                      } while (i2 != 0);
                                      if (!i()) {
                                        break;
                                      }
                                      i2 = org.apache.thrift.b.a(this.d, paramr.d);
                                      i1 = i2;
                                    } while (i2 != 0);
                                    i2 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(paramr.k()));
                                    i1 = i2;
                                  } while (i2 != 0);
                                  if (!k()) {
                                    break;
                                  }
                                  i2 = org.apache.thrift.b.a(this.e, paramr.e);
                                  i1 = i2;
                                } while (i2 != 0);
                                i2 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(paramr.m()));
                                i1 = i2;
                              } while (i2 != 0);
                              if (!m()) {
                                break;
                              }
                              i2 = org.apache.thrift.b.a(this.f, paramr.f);
                              i1 = i2;
                            } while (i2 != 0);
                            i2 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(paramr.n()));
                            i1 = i2;
                          } while (i2 != 0);
                          if (!n()) {
                            break;
                          }
                          i2 = org.apache.thrift.b.a(this.g, paramr.g);
                          i1 = i2;
                        } while (i2 != 0);
                        i2 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(paramr.p()));
                        i1 = i2;
                      } while (i2 != 0);
                      if (!p()) {
                        break;
                      }
                      i2 = org.apache.thrift.b.a(this.h, paramr.h);
                      i1 = i2;
                    } while (i2 != 0);
                    i2 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(paramr.r()));
                    i1 = i2;
                  } while (i2 != 0);
                  if (!r()) {
                    break;
                  }
                  i2 = org.apache.thrift.b.a(this.i, paramr.i);
                  i1 = i2;
                } while (i2 != 0);
                i2 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(paramr.t()));
                i1 = i2;
              } while (i2 != 0);
              if (!t()) {
                break;
              }
              i2 = org.apache.thrift.b.a(this.j, paramr.j);
              i1 = i2;
            } while (i2 != 0);
            i2 = Boolean.valueOf(u()).compareTo(Boolean.valueOf(paramr.u()));
            i1 = i2;
          } while (i2 != 0);
          if (!u()) {
            break;
          }
          i2 = org.apache.thrift.b.a(this.k, paramr.k);
          i1 = i2;
        } while (i2 != 0);
        i2 = Boolean.valueOf(w()).compareTo(Boolean.valueOf(paramr.w()));
        i1 = i2;
      } while (i2 != 0);
      if (!w()) {
        break;
      }
      i2 = org.apache.thrift.b.a(this.l, paramr.l);
      i1 = i2;
    } while (i2 != 0);
    return 0;
  }
  
  public r b(int paramInt)
  {
    this.h = paramInt;
    c(true);
    return this;
  }
  
  public r b(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public String b()
  {
    return this.a;
  }
  
  public void b(org.apache.thrift.protocol.e parame)
  {
    x();
    parame.a(n);
    if (this.a != null)
    {
      parame.a(o);
      parame.a(this.a);
      parame.b();
    }
    parame.a(p);
    parame.a(this.b);
    parame.b();
    if ((this.c != null) && (g()))
    {
      parame.a(q);
      parame.a(this.c);
      parame.b();
    }
    if ((this.d != null) && (i()))
    {
      parame.a(r);
      parame.a(this.d);
      parame.b();
    }
    if ((this.e != null) && (k()))
    {
      parame.a(s);
      parame.a(this.e);
      parame.b();
    }
    if (m())
    {
      parame.a(t);
      parame.a(this.f);
      parame.b();
    }
    if ((this.g != null) && (n()))
    {
      parame.a(u);
      parame.a(this.g);
      parame.b();
    }
    if (p())
    {
      parame.a(v);
      parame.a(this.h);
      parame.b();
    }
    if (r())
    {
      parame.a(w);
      parame.a(this.i);
      parame.b();
    }
    Iterator localIterator;
    Map.Entry localEntry;
    if ((this.j != null) && (t()))
    {
      parame.a(x);
      parame.a(new d((byte)11, (byte)11, this.j.size()));
      localIterator = this.j.entrySet().iterator();
      while (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        parame.a((String)localEntry.getKey());
        parame.a((String)localEntry.getValue());
      }
      parame.d();
      parame.b();
    }
    if ((this.k != null) && (u()))
    {
      parame.a(y);
      parame.a(new d((byte)11, (byte)11, this.k.size()));
      localIterator = this.k.entrySet().iterator();
      while (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        parame.a((String)localEntry.getKey());
        parame.a((String)localEntry.getValue());
      }
      parame.d();
      parame.b();
    }
    if (w())
    {
      parame.a(z);
      parame.a(this.l);
      parame.b();
    }
    parame.c();
    parame.a();
  }
  
  public void b(boolean paramBoolean)
  {
    this.A.set(1, paramBoolean);
  }
  
  public r c(int paramInt)
  {
    this.i = paramInt;
    d(true);
    return this;
  }
  
  public r c(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public void c(boolean paramBoolean)
  {
    this.A.set(2, paramBoolean);
  }
  
  public boolean c()
  {
    return this.a != null;
  }
  
  public long d()
  {
    return this.b;
  }
  
  public r d(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public void d(boolean paramBoolean)
  {
    this.A.set(3, paramBoolean);
  }
  
  public void e(boolean paramBoolean)
  {
    this.A.set(4, paramBoolean);
  }
  
  public boolean e()
  {
    return this.A.get(0);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof r)) {
      return false;
    }
    return a((r)paramObject);
  }
  
  public String f()
  {
    return this.c;
  }
  
  public boolean g()
  {
    return this.c != null;
  }
  
  public String h()
  {
    return this.d;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean i()
  {
    return this.d != null;
  }
  
  public String j()
  {
    return this.e;
  }
  
  public boolean k()
  {
    return this.e != null;
  }
  
  public int l()
  {
    return this.f;
  }
  
  public boolean m()
  {
    return this.A.get(1);
  }
  
  public boolean n()
  {
    return this.g != null;
  }
  
  public int o()
  {
    return this.h;
  }
  
  public boolean p()
  {
    return this.A.get(2);
  }
  
  public int q()
  {
    return this.i;
  }
  
  public boolean r()
  {
    return this.A.get(3);
  }
  
  public Map<String, String> s()
  {
    return this.j;
  }
  
  public boolean t()
  {
    return this.j != null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("PushMetaInfo(");
    localStringBuilder.append("id:");
    if (this.a == null)
    {
      localStringBuilder.append("null");
      localStringBuilder.append(", ");
      localStringBuilder.append("messageTs:");
      localStringBuilder.append(this.b);
      if (g())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("topic:");
        if (this.c != null) {
          break label440;
        }
        localStringBuilder.append("null");
      }
      label97:
      if (i())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("title:");
        if (this.d != null) {
          break label452;
        }
        localStringBuilder.append("null");
      }
      label135:
      if (k())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("description:");
        if (this.e != null) {
          break label464;
        }
        localStringBuilder.append("null");
      }
      label173:
      if (m())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("notifyType:");
        localStringBuilder.append(this.f);
      }
      if (n())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("url:");
        if (this.g != null) {
          break label476;
        }
        localStringBuilder.append("null");
      }
      label243:
      if (p())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("passThrough:");
        localStringBuilder.append(this.h);
      }
      if (r())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("notifyId:");
        localStringBuilder.append(this.i);
      }
      if (t())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("extra:");
        if (this.j != null) {
          break label488;
        }
        localStringBuilder.append("null");
      }
      label345:
      if (u())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("internal:");
        if (this.k != null) {
          break label500;
        }
        localStringBuilder.append("null");
      }
    }
    for (;;)
    {
      if (w())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("ignoreRegInfo:");
        localStringBuilder.append(this.l);
      }
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
      break;
      label440:
      localStringBuilder.append(this.c);
      break label97;
      label452:
      localStringBuilder.append(this.d);
      break label135;
      label464:
      localStringBuilder.append(this.e);
      break label173;
      label476:
      localStringBuilder.append(this.g);
      break label243;
      label488:
      localStringBuilder.append(this.j);
      break label345;
      label500:
      localStringBuilder.append(this.k);
    }
  }
  
  public boolean u()
  {
    return this.k != null;
  }
  
  public boolean v()
  {
    return this.l;
  }
  
  public boolean w()
  {
    return this.A.get(4);
  }
  
  public void x()
  {
    if (this.a == null) {
      throw new f("Required field 'id' was not present! Struct: " + toString());
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/xmpush/thrift/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */