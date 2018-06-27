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

public class q
  implements Serializable, Cloneable, a<q, a>
{
  public static final Map<a, org.apache.thrift.meta_data.b> i;
  private static final j j = new j("PushMessage");
  private static final org.apache.thrift.protocol.b k = new org.apache.thrift.protocol.b("to", (byte)12, (short)1);
  private static final org.apache.thrift.protocol.b l = new org.apache.thrift.protocol.b("id", (byte)11, (short)2);
  private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("appId", (byte)11, (short)3);
  private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("payload", (byte)11, (short)4);
  private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("createAt", (byte)10, (short)5);
  private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("ttl", (byte)10, (short)6);
  private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("collapseKey", (byte)11, (short)7);
  private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("packageName", (byte)11, (short)8);
  public u a;
  public String b;
  public String c;
  public String d;
  public long e;
  public long f;
  public String g;
  public String h;
  private BitSet s = new BitSet(2);
  
  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.apache.thrift.meta_data.b("to", (byte)2, new g((byte)12, u.class)));
    localEnumMap.put(a.b, new org.apache.thrift.meta_data.b("id", (byte)1, new c((byte)11)));
    localEnumMap.put(a.c, new org.apache.thrift.meta_data.b("appId", (byte)1, new c((byte)11)));
    localEnumMap.put(a.d, new org.apache.thrift.meta_data.b("payload", (byte)1, new c((byte)11)));
    localEnumMap.put(a.e, new org.apache.thrift.meta_data.b("createAt", (byte)2, new c((byte)10)));
    localEnumMap.put(a.f, new org.apache.thrift.meta_data.b("ttl", (byte)2, new c((byte)10)));
    localEnumMap.put(a.g, new org.apache.thrift.meta_data.b("collapseKey", (byte)2, new c((byte)11)));
    localEnumMap.put(a.h, new org.apache.thrift.meta_data.b("packageName", (byte)2, new c((byte)11)));
    i = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(q.class, i);
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
      if (localb.b == 12)
      {
        this.a = new u();
        this.a.a(parame);
      }
      else
      {
        h.a(parame, localb.b);
        continue;
        if (localb.b == 11)
        {
          this.b = parame.w();
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
              if (localb.b == 10)
              {
                this.e = parame.u();
                a(true);
              }
              else
              {
                h.a(parame, localb.b);
                continue;
                if (localb.b == 10)
                {
                  this.f = parame.u();
                  b(true);
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
                    if (localb.b == 11) {
                      this.h = parame.w();
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
  
  public void a(boolean paramBoolean)
  {
    this.s.set(0, paramBoolean);
  }
  
  public boolean a()
  {
    return this.a != null;
  }
  
  public boolean a(q paramq)
  {
    if (paramq == null) {}
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
                    bool2 = paramq.a();
                  } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.a(paramq.a))));
                  bool1 = c();
                  bool2 = paramq.c();
                } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.b.equals(paramq.b))));
                bool1 = e();
                bool2 = paramq.e();
              } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.c.equals(paramq.c))));
              bool1 = g();
              bool2 = paramq.g();
            } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.d.equals(paramq.d))));
            bool1 = i();
            bool2 = paramq.i();
          } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (this.e != paramq.e)));
          bool1 = j();
          bool2 = paramq.j();
        } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (this.f != paramq.f)));
        bool1 = k();
        bool2 = paramq.k();
      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.g.equals(paramq.g))));
      bool1 = l();
      bool2 = paramq.l();
    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.h.equals(paramq.h))));
    return true;
  }
  
  public int b(q paramq)
  {
    int i1;
    if (!getClass().equals(paramq.getClass())) {
      i1 = getClass().getName().compareTo(paramq.getClass().getName());
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
                                    i2 = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramq.a()));
                                    i1 = i2;
                                  } while (i2 != 0);
                                  if (!a()) {
                                    break;
                                  }
                                  i2 = org.apache.thrift.b.a(this.a, paramq.a);
                                  i1 = i2;
                                } while (i2 != 0);
                                i2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramq.c()));
                                i1 = i2;
                              } while (i2 != 0);
                              if (!c()) {
                                break;
                              }
                              i2 = org.apache.thrift.b.a(this.b, paramq.b);
                              i1 = i2;
                            } while (i2 != 0);
                            i2 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paramq.e()));
                            i1 = i2;
                          } while (i2 != 0);
                          if (!e()) {
                            break;
                          }
                          i2 = org.apache.thrift.b.a(this.c, paramq.c);
                          i1 = i2;
                        } while (i2 != 0);
                        i2 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(paramq.g()));
                        i1 = i2;
                      } while (i2 != 0);
                      if (!g()) {
                        break;
                      }
                      i2 = org.apache.thrift.b.a(this.d, paramq.d);
                      i1 = i2;
                    } while (i2 != 0);
                    i2 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(paramq.i()));
                    i1 = i2;
                  } while (i2 != 0);
                  if (!i()) {
                    break;
                  }
                  i2 = org.apache.thrift.b.a(this.e, paramq.e);
                  i1 = i2;
                } while (i2 != 0);
                i2 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(paramq.j()));
                i1 = i2;
              } while (i2 != 0);
              if (!j()) {
                break;
              }
              i2 = org.apache.thrift.b.a(this.f, paramq.f);
              i1 = i2;
            } while (i2 != 0);
            i2 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(paramq.k()));
            i1 = i2;
          } while (i2 != 0);
          if (!k()) {
            break;
          }
          i2 = org.apache.thrift.b.a(this.g, paramq.g);
          i1 = i2;
        } while (i2 != 0);
        i2 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(paramq.l()));
        i1 = i2;
      } while (i2 != 0);
      if (!l()) {
        break;
      }
      i2 = org.apache.thrift.b.a(this.h, paramq.h);
      i1 = i2;
    } while (i2 != 0);
    return 0;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(e parame)
  {
    m();
    parame.a(j);
    if ((this.a != null) && (a()))
    {
      parame.a(k);
      this.a.b(parame);
      parame.b();
    }
    if (this.b != null)
    {
      parame.a(l);
      parame.a(this.b);
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
    if (i())
    {
      parame.a(o);
      parame.a(this.e);
      parame.b();
    }
    if (j())
    {
      parame.a(p);
      parame.a(this.f);
      parame.b();
    }
    if ((this.g != null) && (k()))
    {
      parame.a(q);
      parame.a(this.g);
      parame.b();
    }
    if ((this.h != null) && (l()))
    {
      parame.a(r);
      parame.a(this.h);
      parame.b();
    }
    parame.c();
    parame.a();
  }
  
  public void b(boolean paramBoolean)
  {
    this.s.set(1, paramBoolean);
  }
  
  public boolean c()
  {
    return this.b != null;
  }
  
  public String d()
  {
    return this.c;
  }
  
  public boolean e()
  {
    return this.c != null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof q)) {
      return false;
    }
    return a((q)paramObject);
  }
  
  public String f()
  {
    return this.d;
  }
  
  public boolean g()
  {
    return this.d != null;
  }
  
  public long h()
  {
    return this.e;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean i()
  {
    return this.s.get(0);
  }
  
  public boolean j()
  {
    return this.s.get(1);
  }
  
  public boolean k()
  {
    return this.g != null;
  }
  
  public boolean l()
  {
    return this.h != null;
  }
  
  public void m()
  {
    if (this.b == null) {
      throw new f("Required field 'id' was not present! Struct: " + toString());
    }
    if (this.c == null) {
      throw new f("Required field 'appId' was not present! Struct: " + toString());
    }
    if (this.d == null) {
      throw new f("Required field 'payload' was not present! Struct: " + toString());
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("PushMessage(");
    int i1 = 1;
    if (a())
    {
      localStringBuilder.append("to:");
      if (this.a == null)
      {
        localStringBuilder.append("null");
        i1 = 0;
      }
    }
    else
    {
      if (i1 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("id:");
      if (this.b != null) {
        break label307;
      }
      localStringBuilder.append("null");
      label80:
      localStringBuilder.append(", ");
      localStringBuilder.append("appId:");
      if (this.c != null) {
        break label319;
      }
      localStringBuilder.append("null");
      label111:
      localStringBuilder.append(", ");
      localStringBuilder.append("payload:");
      if (this.d != null) {
        break label331;
      }
      localStringBuilder.append("null");
      label142:
      if (i())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("createAt:");
        localStringBuilder.append(this.e);
      }
      if (j())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("ttl:");
        localStringBuilder.append(this.f);
      }
      if (k())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("collapseKey:");
        if (this.g != null) {
          break label343;
        }
        localStringBuilder.append("null");
      }
      label244:
      if (l())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("packageName:");
        if (this.h != null) {
          break label355;
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
      label307:
      localStringBuilder.append(this.b);
      break label80;
      label319:
      localStringBuilder.append(this.c);
      break label111;
      label331:
      localStringBuilder.append(this.d);
      break label142;
      label343:
      localStringBuilder.append(this.g);
      break label244;
      label355:
      localStringBuilder.append(this.h);
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/xmpush/thrift/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */