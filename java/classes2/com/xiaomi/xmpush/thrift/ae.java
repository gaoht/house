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
import java.util.Map.Entry;
import java.util.Set;
import org.apache.thrift.a;
import org.apache.thrift.meta_data.c;
import org.apache.thrift.meta_data.g;
import org.apache.thrift.protocol.d;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.h;
import org.apache.thrift.protocol.j;

public class ae
  implements Serializable, Cloneable, a<ae, a>
{
  public static final Map<a, org.apache.thrift.meta_data.b> l;
  private static final j m = new j("XmPushActionNotification");
  private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("debug", (byte)11, (short)1);
  private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("target", (byte)12, (short)2);
  private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("id", (byte)11, (short)3);
  private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("appId", (byte)11, (short)4);
  private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("type", (byte)11, (short)5);
  private static final org.apache.thrift.protocol.b s = new org.apache.thrift.protocol.b("requireAck", (byte)2, (short)6);
  private static final org.apache.thrift.protocol.b t = new org.apache.thrift.protocol.b("payload", (byte)11, (short)7);
  private static final org.apache.thrift.protocol.b u = new org.apache.thrift.protocol.b("extra", (byte)13, (short)8);
  private static final org.apache.thrift.protocol.b v = new org.apache.thrift.protocol.b("packageName", (byte)11, (short)9);
  private static final org.apache.thrift.protocol.b w = new org.apache.thrift.protocol.b("category", (byte)11, (short)10);
  private static final org.apache.thrift.protocol.b x = new org.apache.thrift.protocol.b("binaryExtra", (byte)11, (short)14);
  public String a;
  public u b;
  public String c;
  public String d;
  public String e;
  public boolean f = true;
  public String g;
  public Map<String, String> h;
  public String i;
  public String j;
  public ByteBuffer k;
  private BitSet y = new BitSet(1);
  
  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.apache.thrift.meta_data.b("debug", (byte)2, new c((byte)11)));
    localEnumMap.put(a.b, new org.apache.thrift.meta_data.b("target", (byte)2, new g((byte)12, u.class)));
    localEnumMap.put(a.c, new org.apache.thrift.meta_data.b("id", (byte)1, new c((byte)11)));
    localEnumMap.put(a.d, new org.apache.thrift.meta_data.b("appId", (byte)2, new c((byte)11)));
    localEnumMap.put(a.e, new org.apache.thrift.meta_data.b("type", (byte)2, new c((byte)11)));
    localEnumMap.put(a.f, new org.apache.thrift.meta_data.b("requireAck", (byte)1, new c((byte)2)));
    localEnumMap.put(a.g, new org.apache.thrift.meta_data.b("payload", (byte)2, new c((byte)11)));
    localEnumMap.put(a.h, new org.apache.thrift.meta_data.b("extra", (byte)2, new org.apache.thrift.meta_data.e((byte)13, new c((byte)11), new c((byte)11))));
    localEnumMap.put(a.i, new org.apache.thrift.meta_data.b("packageName", (byte)2, new c((byte)11)));
    localEnumMap.put(a.j, new org.apache.thrift.meta_data.b("category", (byte)2, new c((byte)11)));
    localEnumMap.put(a.k, new org.apache.thrift.meta_data.b("binaryExtra", (byte)2, new c((byte)11)));
    l = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(ae.class, l);
  }
  
  public ae() {}
  
  public ae(String paramString, boolean paramBoolean)
  {
    this();
    this.c = paramString;
    this.f = paramBoolean;
    b(true);
  }
  
  public ae a(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public ae a(ByteBuffer paramByteBuffer)
  {
    this.k = paramByteBuffer;
    return this;
  }
  
  public ae a(Map<String, String> paramMap)
  {
    this.h = paramMap;
    return this;
  }
  
  public ae a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    b(true);
    return this;
  }
  
  public ae a(byte[] paramArrayOfByte)
  {
    a(ByteBuffer.wrap(paramArrayOfByte));
    return this;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.h == null) {
      this.h = new HashMap();
    }
    this.h.put(paramString1, paramString2);
  }
  
  public void a(org.apache.thrift.protocol.e parame)
  {
    parame.g();
    Object localObject = parame.i();
    if (((org.apache.thrift.protocol.b)localObject).b == 0)
    {
      parame.h();
      if (!g()) {
        throw new f("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
      }
    }
    else
    {
      switch (((org.apache.thrift.protocol.b)localObject).c)
      {
      case 11: 
      case 12: 
      case 13: 
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
                  if (((org.apache.thrift.protocol.b)localObject).b == 2)
                  {
                    this.f = parame.q();
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
                      if (((org.apache.thrift.protocol.b)localObject).b == 13)
                      {
                        localObject = parame.k();
                        this.h = new HashMap(((d)localObject).c * 2);
                        int i1 = 0;
                        while (i1 < ((d)localObject).c)
                        {
                          String str1 = parame.w();
                          String str2 = parame.w();
                          this.h.put(str1, str2);
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
                          this.i = parame.w();
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
                              this.k = parame.x();
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
  
  public boolean a()
  {
    return this.a != null;
  }
  
  public boolean a(ae paramae)
  {
    if (paramae == null) {}
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
                        bool2 = paramae.a();
                      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramae.a))));
                      bool1 = b();
                      bool2 = paramae.b();
                    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.b.a(paramae.b))));
                    bool1 = d();
                    bool2 = paramae.d();
                  } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.c.equals(paramae.c))));
                  bool1 = e();
                  bool2 = paramae.e();
                } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.d.equals(paramae.d))));
                bool1 = f();
                bool2 = paramae.f();
              } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.e.equals(paramae.e)) || (this.f != paramae.f)));
              bool1 = h();
              bool2 = paramae.h();
            } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.g.equals(paramae.g))));
            bool1 = j();
            bool2 = paramae.j();
          } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.h.equals(paramae.h))));
          bool1 = k();
          bool2 = paramae.k();
        } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.i.equals(paramae.i))));
        bool1 = l();
        bool2 = paramae.l();
      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.j.equals(paramae.j))));
      bool1 = n();
      bool2 = paramae.n();
    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.k.equals(paramae.k))));
    return true;
  }
  
  public int b(ae paramae)
  {
    int i1;
    if (!getClass().equals(paramae.getClass())) {
      i1 = getClass().getName().compareTo(paramae.getClass().getName());
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
                                                i2 = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramae.a()));
                                                i1 = i2;
                                              } while (i2 != 0);
                                              if (!a()) {
                                                break;
                                              }
                                              i2 = org.apache.thrift.b.a(this.a, paramae.a);
                                              i1 = i2;
                                            } while (i2 != 0);
                                            i2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramae.b()));
                                            i1 = i2;
                                          } while (i2 != 0);
                                          if (!b()) {
                                            break;
                                          }
                                          i2 = org.apache.thrift.b.a(this.b, paramae.b);
                                          i1 = i2;
                                        } while (i2 != 0);
                                        i2 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paramae.d()));
                                        i1 = i2;
                                      } while (i2 != 0);
                                      if (!d()) {
                                        break;
                                      }
                                      i2 = org.apache.thrift.b.a(this.c, paramae.c);
                                      i1 = i2;
                                    } while (i2 != 0);
                                    i2 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paramae.e()));
                                    i1 = i2;
                                  } while (i2 != 0);
                                  if (!e()) {
                                    break;
                                  }
                                  i2 = org.apache.thrift.b.a(this.d, paramae.d);
                                  i1 = i2;
                                } while (i2 != 0);
                                i2 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(paramae.f()));
                                i1 = i2;
                              } while (i2 != 0);
                              if (!f()) {
                                break;
                              }
                              i2 = org.apache.thrift.b.a(this.e, paramae.e);
                              i1 = i2;
                            } while (i2 != 0);
                            i2 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(paramae.g()));
                            i1 = i2;
                          } while (i2 != 0);
                          if (!g()) {
                            break;
                          }
                          i2 = org.apache.thrift.b.a(this.f, paramae.f);
                          i1 = i2;
                        } while (i2 != 0);
                        i2 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(paramae.h()));
                        i1 = i2;
                      } while (i2 != 0);
                      if (!h()) {
                        break;
                      }
                      i2 = org.apache.thrift.b.a(this.g, paramae.g);
                      i1 = i2;
                    } while (i2 != 0);
                    i2 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(paramae.j()));
                    i1 = i2;
                  } while (i2 != 0);
                  if (!j()) {
                    break;
                  }
                  i2 = org.apache.thrift.b.a(this.h, paramae.h);
                  i1 = i2;
                } while (i2 != 0);
                i2 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(paramae.k()));
                i1 = i2;
              } while (i2 != 0);
              if (!k()) {
                break;
              }
              i2 = org.apache.thrift.b.a(this.i, paramae.i);
              i1 = i2;
            } while (i2 != 0);
            i2 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(paramae.l()));
            i1 = i2;
          } while (i2 != 0);
          if (!l()) {
            break;
          }
          i2 = org.apache.thrift.b.a(this.j, paramae.j);
          i1 = i2;
        } while (i2 != 0);
        i2 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(paramae.n()));
        i1 = i2;
      } while (i2 != 0);
      if (!n()) {
        break;
      }
      i2 = org.apache.thrift.b.a(this.k, paramae.k);
      i1 = i2;
    } while (i2 != 0);
    return 0;
  }
  
  public ae b(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public void b(org.apache.thrift.protocol.e parame)
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
    parame.a(s);
    parame.a(this.f);
    parame.b();
    if ((this.g != null) && (h()))
    {
      parame.a(t);
      parame.a(this.g);
      parame.b();
    }
    if ((this.h != null) && (j()))
    {
      parame.a(u);
      parame.a(new d((byte)11, (byte)11, this.h.size()));
      Iterator localIterator = this.h.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        parame.a((String)localEntry.getKey());
        parame.a((String)localEntry.getValue());
      }
      parame.d();
      parame.b();
    }
    if ((this.i != null) && (k()))
    {
      parame.a(v);
      parame.a(this.i);
      parame.b();
    }
    if ((this.j != null) && (l()))
    {
      parame.a(w);
      parame.a(this.j);
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
  
  public void b(boolean paramBoolean)
  {
    this.y.set(0, paramBoolean);
  }
  
  public boolean b()
  {
    return this.b != null;
  }
  
  public ae c(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public ae d(String paramString)
  {
    this.i = paramString;
    return this;
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
    while (!(paramObject instanceof ae)) {
      return false;
    }
    return a((ae)paramObject);
  }
  
  public boolean f()
  {
    return this.e != null;
  }
  
  public boolean g()
  {
    return this.y.get(0);
  }
  
  public boolean h()
  {
    return this.g != null;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public Map<String, String> i()
  {
    return this.h;
  }
  
  public boolean j()
  {
    return this.h != null;
  }
  
  public boolean k()
  {
    return this.i != null;
  }
  
  public boolean l()
  {
    return this.j != null;
  }
  
  public byte[] m()
  {
    a(org.apache.thrift.b.c(this.k));
    return this.k.array();
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
  }
  
  public String toString()
  {
    int i2 = 0;
    StringBuilder localStringBuilder = new StringBuilder("XmPushActionNotification(");
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
        break label551;
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
    label265:
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
    label551:
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
        localStringBuilder.append(", ");
        localStringBuilder.append("requireAck:");
        localStringBuilder.append(this.f);
        if (h())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("payload:");
          if (this.g != null) {
            break label492;
          }
          localStringBuilder.append("null");
        }
        if (j())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("extra:");
          if (this.h != null) {
            break label504;
          }
          localStringBuilder.append("null");
        }
        if (k())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("packageName:");
          if (this.i != null) {
            break label516;
          }
          localStringBuilder.append("null");
        }
        if (l())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("category:");
          if (this.j != null) {
            break label528;
          }
          localStringBuilder.append("null");
        }
        if (n())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("binaryExtra:");
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
        localStringBuilder.append(this.g);
        break label265;
        localStringBuilder.append(this.h);
        break label303;
        localStringBuilder.append(this.i);
        break label341;
        localStringBuilder.append(this.j);
        break label379;
        org.apache.thrift.b.a(this.k, localStringBuilder);
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/xmpush/thrift/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */