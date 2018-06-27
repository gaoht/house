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
import org.apache.thrift.a;
import org.apache.thrift.meta_data.d;
import org.apache.thrift.meta_data.g;
import org.apache.thrift.protocol.e;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.h;
import org.apache.thrift.protocol.j;

public class aa
  implements Serializable, Cloneable, a<aa, a>
{
  public static final Map<a, org.apache.thrift.meta_data.b> l;
  private static final j m = new j("XmPushActionCommandResult");
  private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("debug", (byte)11, (short)1);
  private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("target", (byte)12, (short)2);
  private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("id", (byte)11, (short)3);
  private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("appId", (byte)11, (short)4);
  private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("cmdName", (byte)11, (short)5);
  private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b("request", (byte)12, (short)6);
  private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b("errorCode", (byte)10, (short)7);
  private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b("reason", (byte)11, (short)8);
  private static final org.apache.thrift.protocol.b v = new org.apache.thrift.protocol.b("packageName", (byte)11, (short)9);
  private static final org.apache.thrift.protocol.b w = new org.apache.thrift.protocol.b("cmdArgs", (byte)15, (short)10);
  private static final org.apache.thrift.protocol.b x = new org.apache.thrift.protocol.b("category", (byte)11, (short)12);
  public String a;
  public u b;
  public String c;
  public String d;
  public String e;
  public z f;
  public long g;
  public String h;
  public String i;
  public List<String> j;
  public String k;
  private BitSet y = new BitSet(1);
  
  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.apache.thrift.meta_data.b("debug", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(a.b, new org.apache.thrift.meta_data.b("target", (byte)2, new g((byte)12, u.class)));
    localEnumMap.put(a.c, new org.apache.thrift.meta_data.b("id", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(a.d, new org.apache.thrift.meta_data.b("appId", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(a.e, new org.apache.thrift.meta_data.b("cmdName", (byte)1, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(a.f, new org.apache.thrift.meta_data.b("request", (byte)2, new g((byte)12, z.class)));
    localEnumMap.put(a.g, new org.apache.thrift.meta_data.b("errorCode", (byte)1, new org.apache.thrift.meta_data.c((byte)10)));
    localEnumMap.put(a.h, new org.apache.thrift.meta_data.b("reason", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(a.i, new org.apache.thrift.meta_data.b("packageName", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    localEnumMap.put(a.j, new org.apache.thrift.meta_data.b("cmdArgs", (byte)2, new d((byte)15, new org.apache.thrift.meta_data.c((byte)11))));
    localEnumMap.put(a.k, new org.apache.thrift.meta_data.b("category", (byte)2, new org.apache.thrift.meta_data.c((byte)11)));
    l = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(aa.class, l);
  }
  
  public void a(e parame)
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
      case 11: 
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
                    this.f = new z();
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
                        if (((org.apache.thrift.protocol.b)localObject).b == 11)
                        {
                          this.i = parame.w();
                        }
                        else
                        {
                          h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                          continue;
                          if (((org.apache.thrift.protocol.b)localObject).b == 15)
                          {
                            localObject = parame.m();
                            this.j = new ArrayList(((org.apache.thrift.protocol.c)localObject).b);
                            int i1 = 0;
                            while (i1 < ((org.apache.thrift.protocol.c)localObject).b)
                            {
                              String str = parame.w();
                              this.j.add(str);
                              i1 += 1;
                            }
                            parame.n();
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
    o();
  }
  
  public void a(boolean paramBoolean)
  {
    this.y.set(0, paramBoolean);
  }
  
  public boolean a()
  {
    return this.a != null;
  }
  
  public boolean a(aa paramaa)
  {
    if (paramaa == null) {}
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
                        bool2 = paramaa.a();
                      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramaa.a))));
                      bool1 = b();
                      bool2 = paramaa.b();
                    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.b.a(paramaa.b))));
                    bool1 = c();
                    bool2 = paramaa.c();
                  } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.c.equals(paramaa.c))));
                  bool1 = d();
                  bool2 = paramaa.d();
                } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.d.equals(paramaa.d))));
                bool1 = f();
                bool2 = paramaa.f();
              } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.e.equals(paramaa.e))));
              bool1 = g();
              bool2 = paramaa.g();
            } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.f.a(paramaa.f)) || (this.g != paramaa.g)));
            bool1 = i();
            bool2 = paramaa.i();
          } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.h.equals(paramaa.h))));
          bool1 = j();
          bool2 = paramaa.j();
        } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.i.equals(paramaa.i))));
        bool1 = l();
        bool2 = paramaa.l();
      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.j.equals(paramaa.j))));
      bool1 = n();
      bool2 = paramaa.n();
    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.k.equals(paramaa.k))));
    return true;
  }
  
  public int b(aa paramaa)
  {
    int i1;
    if (!getClass().equals(paramaa.getClass())) {
      i1 = getClass().getName().compareTo(paramaa.getClass().getName());
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
                                                i2 = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramaa.a()));
                                                i1 = i2;
                                              } while (i2 != 0);
                                              if (!a()) {
                                                break;
                                              }
                                              i2 = org.apache.thrift.b.a(this.a, paramaa.a);
                                              i1 = i2;
                                            } while (i2 != 0);
                                            i2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramaa.b()));
                                            i1 = i2;
                                          } while (i2 != 0);
                                          if (!b()) {
                                            break;
                                          }
                                          i2 = org.apache.thrift.b.a(this.b, paramaa.b);
                                          i1 = i2;
                                        } while (i2 != 0);
                                        i2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramaa.c()));
                                        i1 = i2;
                                      } while (i2 != 0);
                                      if (!c()) {
                                        break;
                                      }
                                      i2 = org.apache.thrift.b.a(this.c, paramaa.c);
                                      i1 = i2;
                                    } while (i2 != 0);
                                    i2 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paramaa.d()));
                                    i1 = i2;
                                  } while (i2 != 0);
                                  if (!d()) {
                                    break;
                                  }
                                  i2 = org.apache.thrift.b.a(this.d, paramaa.d);
                                  i1 = i2;
                                } while (i2 != 0);
                                i2 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(paramaa.f()));
                                i1 = i2;
                              } while (i2 != 0);
                              if (!f()) {
                                break;
                              }
                              i2 = org.apache.thrift.b.a(this.e, paramaa.e);
                              i1 = i2;
                            } while (i2 != 0);
                            i2 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(paramaa.g()));
                            i1 = i2;
                          } while (i2 != 0);
                          if (!g()) {
                            break;
                          }
                          i2 = org.apache.thrift.b.a(this.f, paramaa.f);
                          i1 = i2;
                        } while (i2 != 0);
                        i2 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(paramaa.h()));
                        i1 = i2;
                      } while (i2 != 0);
                      if (!h()) {
                        break;
                      }
                      i2 = org.apache.thrift.b.a(this.g, paramaa.g);
                      i1 = i2;
                    } while (i2 != 0);
                    i2 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(paramaa.i()));
                    i1 = i2;
                  } while (i2 != 0);
                  if (!i()) {
                    break;
                  }
                  i2 = org.apache.thrift.b.a(this.h, paramaa.h);
                  i1 = i2;
                } while (i2 != 0);
                i2 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(paramaa.j()));
                i1 = i2;
              } while (i2 != 0);
              if (!j()) {
                break;
              }
              i2 = org.apache.thrift.b.a(this.i, paramaa.i);
              i1 = i2;
            } while (i2 != 0);
            i2 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(paramaa.l()));
            i1 = i2;
          } while (i2 != 0);
          if (!l()) {
            break;
          }
          i2 = org.apache.thrift.b.a(this.j, paramaa.j);
          i1 = i2;
        } while (i2 != 0);
        i2 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(paramaa.n()));
        i1 = i2;
      } while (i2 != 0);
      if (!n()) {
        break;
      }
      i2 = org.apache.thrift.b.a(this.k, paramaa.k);
      i1 = i2;
    } while (i2 != 0);
    return 0;
  }
  
  public void b(e parame)
  {
    o();
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
    if (this.d != null)
    {
      parame.a(q);
      parame.a(this.d);
      parame.b();
    }
    if (this.e != null)
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
      parame.a(this.i);
      parame.b();
    }
    if ((this.j != null) && (l()))
    {
      parame.a(w);
      parame.a(new org.apache.thrift.protocol.c((byte)11, this.j.size()));
      Iterator localIterator = this.j.iterator();
      while (localIterator.hasNext()) {
        parame.a((String)localIterator.next());
      }
      parame.e();
      parame.b();
    }
    if ((this.k != null) && (n()))
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
  
  public boolean c()
  {
    return this.c != null;
  }
  
  public boolean d()
  {
    return this.d != null;
  }
  
  public String e()
  {
    return this.e;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof aa)) {
      return false;
    }
    return a((aa)paramObject);
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
  
  public List<String> k()
  {
    return this.j;
  }
  
  public boolean l()
  {
    return this.j != null;
  }
  
  public String m()
  {
    return this.k;
  }
  
  public boolean n()
  {
    return this.k != null;
  }
  
  public void o()
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
    StringBuilder localStringBuilder = new StringBuilder("XmPushActionCommandResult(");
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
        break label538;
      }
      if (i1 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("target:");
      if (this.b != null) {
        break label428;
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
    label327:
    label365:
    label428:
    label454:
    label466:
    label478:
    label490:
    label502:
    label514:
    label526:
    label538:
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
          break label454;
        }
        localStringBuilder.append("null");
        localStringBuilder.append(", ");
        localStringBuilder.append("cmdName:");
        if (this.e != null) {
          break label466;
        }
        localStringBuilder.append("null");
        if (g())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("request:");
          if (this.f != null) {
            break label478;
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
            break label490;
          }
          localStringBuilder.append("null");
        }
        if (j())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("packageName:");
          if (this.i != null) {
            break label502;
          }
          localStringBuilder.append("null");
        }
        if (l())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("cmdArgs:");
          if (this.j != null) {
            break label514;
          }
          localStringBuilder.append("null");
        }
        if (n())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("category:");
          if (this.k != null) {
            break label526;
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
        localStringBuilder.append(this.h);
        break label289;
        localStringBuilder.append(this.i);
        break label327;
        localStringBuilder.append(this.j);
        break label365;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/xmpush/thrift/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */