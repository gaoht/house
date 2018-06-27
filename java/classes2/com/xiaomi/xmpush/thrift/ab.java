package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.thrift.meta_data.c;
import org.apache.thrift.meta_data.g;
import org.apache.thrift.protocol.e;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.h;
import org.apache.thrift.protocol.j;

public class ab
  implements Serializable, Cloneable, org.apache.thrift.a<ab, a>
{
  public static final Map<a, org.apache.thrift.meta_data.b> i;
  private static final j j = new j("XmPushActionContainer");
  private static final org.apache.thrift.protocol.b k = new org.apache.thrift.protocol.b("action", (byte)8, (short)1);
  private static final org.apache.thrift.protocol.b l = new org.apache.thrift.protocol.b("encryptAction", (byte)2, (short)2);
  private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("isRequest", (byte)2, (short)3);
  private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("pushAction", (byte)11, (short)4);
  private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("appid", (byte)11, (short)5);
  private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("packageName", (byte)11, (short)6);
  private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("target", (byte)12, (short)7);
  private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("metaInfo", (byte)12, (short)8);
  public a a;
  public boolean b = true;
  public boolean c = true;
  public ByteBuffer d;
  public String e;
  public String f;
  public u g;
  public r h;
  private BitSet s = new BitSet(2);
  
  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.apache.thrift.meta_data.b("action", (byte)1, new org.apache.thrift.meta_data.a((byte)16, a.class)));
    localEnumMap.put(a.b, new org.apache.thrift.meta_data.b("encryptAction", (byte)1, new c((byte)2)));
    localEnumMap.put(a.c, new org.apache.thrift.meta_data.b("isRequest", (byte)1, new c((byte)2)));
    localEnumMap.put(a.d, new org.apache.thrift.meta_data.b("pushAction", (byte)1, new c((byte)11)));
    localEnumMap.put(a.e, new org.apache.thrift.meta_data.b("appid", (byte)2, new c((byte)11)));
    localEnumMap.put(a.f, new org.apache.thrift.meta_data.b("packageName", (byte)2, new c((byte)11)));
    localEnumMap.put(a.g, new org.apache.thrift.meta_data.b("target", (byte)1, new g((byte)12, u.class)));
    localEnumMap.put(a.h, new org.apache.thrift.meta_data.b("metaInfo", (byte)2, new g((byte)12, r.class)));
    i = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(ab.class, i);
  }
  
  public a a()
  {
    return this.a;
  }
  
  public ab a(a parama)
  {
    this.a = parama;
    return this;
  }
  
  public ab a(r paramr)
  {
    this.h = paramr;
    return this;
  }
  
  public ab a(u paramu)
  {
    this.g = paramu;
    return this;
  }
  
  public ab a(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public ab a(ByteBuffer paramByteBuffer)
  {
    this.d = paramByteBuffer;
    return this;
  }
  
  public ab a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    b(true);
    return this;
  }
  
  public void a(e parame)
  {
    parame.g();
    org.apache.thrift.protocol.b localb = parame.i();
    if (localb.b == 0)
    {
      parame.h();
      if (!d()) {
        throw new f("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
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
        if (localb.b == 8)
        {
          this.a = a.a(parame.t());
        }
        else
        {
          h.a(parame, localb.b);
          continue;
          if (localb.b == 2)
          {
            this.b = parame.q();
            b(true);
          }
          else
          {
            h.a(parame, localb.b);
            continue;
            if (localb.b == 2)
            {
              this.c = parame.q();
              d(true);
            }
            else
            {
              h.a(parame, localb.b);
              continue;
              if (localb.b == 11)
              {
                this.d = parame.x();
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
                    if (localb.b == 12)
                    {
                      this.g = new u();
                      this.g.a(parame);
                    }
                    else
                    {
                      h.a(parame, localb.b);
                      continue;
                      if (localb.b == 12)
                      {
                        this.h = new r();
                        this.h.a(parame);
                      }
                      else
                      {
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
    if (!e()) {
      throw new f("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
    }
    o();
  }
  
  public boolean a(ab paramab)
  {
    if (paramab == null) {}
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
                return false;
                bool1 = b();
                bool2 = paramab.b();
              } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramab.a)) || (this.b != paramab.b) || (this.c != paramab.c)));
              bool1 = g();
              bool2 = paramab.g();
            } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.d.equals(paramab.d))));
            bool1 = i();
            bool2 = paramab.i();
          } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.e.equals(paramab.e))));
          bool1 = k();
          bool2 = paramab.k();
        } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.f.equals(paramab.f))));
        bool1 = l();
        bool2 = paramab.l();
      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.g.a(paramab.g))));
      bool1 = n();
      bool2 = paramab.n();
    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.h.a(paramab.h))));
    return true;
  }
  
  public int b(ab paramab)
  {
    int i1;
    if (!getClass().equals(paramab.getClass())) {
      i1 = getClass().getName().compareTo(paramab.getClass().getName());
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
                                    i2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramab.b()));
                                    i1 = i2;
                                  } while (i2 != 0);
                                  if (!b()) {
                                    break;
                                  }
                                  i2 = org.apache.thrift.b.a(this.a, paramab.a);
                                  i1 = i2;
                                } while (i2 != 0);
                                i2 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paramab.d()));
                                i1 = i2;
                              } while (i2 != 0);
                              if (!d()) {
                                break;
                              }
                              i2 = org.apache.thrift.b.a(this.b, paramab.b);
                              i1 = i2;
                            } while (i2 != 0);
                            i2 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paramab.e()));
                            i1 = i2;
                          } while (i2 != 0);
                          if (!e()) {
                            break;
                          }
                          i2 = org.apache.thrift.b.a(this.c, paramab.c);
                          i1 = i2;
                        } while (i2 != 0);
                        i2 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(paramab.g()));
                        i1 = i2;
                      } while (i2 != 0);
                      if (!g()) {
                        break;
                      }
                      i2 = org.apache.thrift.b.a(this.d, paramab.d);
                      i1 = i2;
                    } while (i2 != 0);
                    i2 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(paramab.i()));
                    i1 = i2;
                  } while (i2 != 0);
                  if (!i()) {
                    break;
                  }
                  i2 = org.apache.thrift.b.a(this.e, paramab.e);
                  i1 = i2;
                } while (i2 != 0);
                i2 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(paramab.k()));
                i1 = i2;
              } while (i2 != 0);
              if (!k()) {
                break;
              }
              i2 = org.apache.thrift.b.a(this.f, paramab.f);
              i1 = i2;
            } while (i2 != 0);
            i2 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(paramab.l()));
            i1 = i2;
          } while (i2 != 0);
          if (!l()) {
            break;
          }
          i2 = org.apache.thrift.b.a(this.g, paramab.g);
          i1 = i2;
        } while (i2 != 0);
        i2 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(paramab.n()));
        i1 = i2;
      } while (i2 != 0);
      if (!n()) {
        break;
      }
      i2 = org.apache.thrift.b.a(this.h, paramab.h);
      i1 = i2;
    } while (i2 != 0);
    return 0;
  }
  
  public ab b(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public void b(e parame)
  {
    o();
    parame.a(j);
    if (this.a != null)
    {
      parame.a(k);
      parame.a(this.a.a());
      parame.b();
    }
    parame.a(l);
    parame.a(this.b);
    parame.b();
    parame.a(m);
    parame.a(this.c);
    parame.b();
    if (this.d != null)
    {
      parame.a(n);
      parame.a(this.d);
      parame.b();
    }
    if ((this.e != null) && (i()))
    {
      parame.a(o);
      parame.a(this.e);
      parame.b();
    }
    if ((this.f != null) && (k()))
    {
      parame.a(p);
      parame.a(this.f);
      parame.b();
    }
    if (this.g != null)
    {
      parame.a(q);
      this.g.b(parame);
      parame.b();
    }
    if ((this.h != null) && (n()))
    {
      parame.a(r);
      this.h.b(parame);
      parame.b();
    }
    parame.c();
    parame.a();
  }
  
  public void b(boolean paramBoolean)
  {
    this.s.set(0, paramBoolean);
  }
  
  public boolean b()
  {
    return this.a != null;
  }
  
  public ab c(boolean paramBoolean)
  {
    this.c = paramBoolean;
    d(true);
    return this;
  }
  
  public boolean c()
  {
    return this.b;
  }
  
  public void d(boolean paramBoolean)
  {
    this.s.set(1, paramBoolean);
  }
  
  public boolean d()
  {
    return this.s.get(0);
  }
  
  public boolean e()
  {
    return this.s.get(1);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof ab)) {
      return false;
    }
    return a((ab)paramObject);
  }
  
  public byte[] f()
  {
    a(org.apache.thrift.b.c(this.d));
    return this.d.array();
  }
  
  public boolean g()
  {
    return this.d != null;
  }
  
  public String h()
  {
    return this.e;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean i()
  {
    return this.e != null;
  }
  
  public String j()
  {
    return this.f;
  }
  
  public boolean k()
  {
    return this.f != null;
  }
  
  public boolean l()
  {
    return this.g != null;
  }
  
  public r m()
  {
    return this.h;
  }
  
  public boolean n()
  {
    return this.h != null;
  }
  
  public void o()
  {
    if (this.a == null) {
      throw new f("Required field 'action' was not present! Struct: " + toString());
    }
    if (this.d == null) {
      throw new f("Required field 'pushAction' was not present! Struct: " + toString());
    }
    if (this.g == null) {
      throw new f("Required field 'target' was not present! Struct: " + toString());
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("XmPushActionContainer(");
    localStringBuilder.append("action:");
    if (this.a == null)
    {
      localStringBuilder.append("null");
      localStringBuilder.append(", ");
      localStringBuilder.append("encryptAction:");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", ");
      localStringBuilder.append("isRequest:");
      localStringBuilder.append(this.c);
      localStringBuilder.append(", ");
      localStringBuilder.append("pushAction:");
      if (this.d != null) {
        break label285;
      }
      localStringBuilder.append("null");
      label115:
      if (i())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("appid:");
        if (this.e != null) {
          break label296;
        }
        localStringBuilder.append("null");
      }
      label153:
      if (k())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("packageName:");
        if (this.f != null) {
          break label308;
        }
        localStringBuilder.append("null");
      }
      label191:
      localStringBuilder.append(", ");
      localStringBuilder.append("target:");
      if (this.g != null) {
        break label320;
      }
      localStringBuilder.append("null");
      label222:
      if (n())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("metaInfo:");
        if (this.h != null) {
          break label332;
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
      label285:
      org.apache.thrift.b.a(this.d, localStringBuilder);
      break label115;
      label296:
      localStringBuilder.append(this.e);
      break label153;
      label308:
      localStringBuilder.append(this.f);
      break label191;
      label320:
      localStringBuilder.append(this.g);
      break label222;
      label332:
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/xmpush/thrift/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */