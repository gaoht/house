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

public class an
  implements Serializable, Cloneable, a<an, a>
{
  public static final Map<a, org.apache.thrift.meta_data.b> i;
  private static final j j = new j("XmPushActionUnRegistrationResult");
  private static final org.apache.thrift.protocol.b k = new org.apache.thrift.protocol.b("debug", (byte)11, (short)1);
  private static final org.apache.thrift.protocol.b l = new org.apache.thrift.protocol.b("target", (byte)12, (short)2);
  private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("id", (byte)11, (short)3);
  private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("appId", (byte)11, (short)4);
  private static final org.apache.thrift.protocol.b o = new org.apache.thrift.protocol.b("request", (byte)12, (short)5);
  private static final org.apache.thrift.protocol.b p = new org.apache.thrift.protocol.b("errorCode", (byte)10, (short)6);
  private static final org.apache.thrift.protocol.b q = new org.apache.thrift.protocol.b("reason", (byte)11, (short)7);
  private static final org.apache.thrift.protocol.b r = new org.apache.thrift.protocol.b("packageName", (byte)11, (short)8);
  public String a;
  public u b;
  public String c;
  public String d;
  public am e;
  public long f;
  public String g;
  public String h;
  private BitSet s = new BitSet(1);
  
  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.apache.thrift.meta_data.b("debug", (byte)2, new c((byte)11)));
    localEnumMap.put(a.b, new org.apache.thrift.meta_data.b("target", (byte)2, new g((byte)12, u.class)));
    localEnumMap.put(a.c, new org.apache.thrift.meta_data.b("id", (byte)1, new c((byte)11)));
    localEnumMap.put(a.d, new org.apache.thrift.meta_data.b("appId", (byte)1, new c((byte)11)));
    localEnumMap.put(a.e, new org.apache.thrift.meta_data.b("request", (byte)2, new g((byte)12, am.class)));
    localEnumMap.put(a.f, new org.apache.thrift.meta_data.b("errorCode", (byte)1, new c((byte)10)));
    localEnumMap.put(a.g, new org.apache.thrift.meta_data.b("reason", (byte)2, new c((byte)11)));
    localEnumMap.put(a.h, new org.apache.thrift.meta_data.b("packageName", (byte)2, new c((byte)11)));
    i = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(an.class, i);
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
                  this.e = new am();
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
    i();
  }
  
  public void a(boolean paramBoolean)
  {
    this.s.set(0, paramBoolean);
  }
  
  public boolean a()
  {
    return this.a != null;
  }
  
  public boolean a(an paraman)
  {
    if (paraman == null) {}
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
                  bool2 = paraman.a();
                } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paraman.a))));
                bool1 = b();
                bool2 = paraman.b();
              } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.b.a(paraman.b))));
              bool1 = c();
              bool2 = paraman.c();
            } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.c.equals(paraman.c))));
            bool1 = d();
            bool2 = paraman.d();
          } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.d.equals(paraman.d))));
          bool1 = e();
          bool2 = paraman.e();
        } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.e.a(paraman.e)) || (this.f != paraman.f)));
        bool1 = g();
        bool2 = paraman.g();
      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.g.equals(paraman.g))));
      bool1 = h();
      bool2 = paraman.h();
    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.h.equals(paraman.h))));
    return true;
  }
  
  public int b(an paraman)
  {
    int i1;
    if (!getClass().equals(paraman.getClass())) {
      i1 = getClass().getName().compareTo(paraman.getClass().getName());
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
                                    i2 = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paraman.a()));
                                    i1 = i2;
                                  } while (i2 != 0);
                                  if (!a()) {
                                    break;
                                  }
                                  i2 = org.apache.thrift.b.a(this.a, paraman.a);
                                  i1 = i2;
                                } while (i2 != 0);
                                i2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paraman.b()));
                                i1 = i2;
                              } while (i2 != 0);
                              if (!b()) {
                                break;
                              }
                              i2 = org.apache.thrift.b.a(this.b, paraman.b);
                              i1 = i2;
                            } while (i2 != 0);
                            i2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paraman.c()));
                            i1 = i2;
                          } while (i2 != 0);
                          if (!c()) {
                            break;
                          }
                          i2 = org.apache.thrift.b.a(this.c, paraman.c);
                          i1 = i2;
                        } while (i2 != 0);
                        i2 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paraman.d()));
                        i1 = i2;
                      } while (i2 != 0);
                      if (!d()) {
                        break;
                      }
                      i2 = org.apache.thrift.b.a(this.d, paraman.d);
                      i1 = i2;
                    } while (i2 != 0);
                    i2 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paraman.e()));
                    i1 = i2;
                  } while (i2 != 0);
                  if (!e()) {
                    break;
                  }
                  i2 = org.apache.thrift.b.a(this.e, paraman.e);
                  i1 = i2;
                } while (i2 != 0);
                i2 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(paraman.f()));
                i1 = i2;
              } while (i2 != 0);
              if (!f()) {
                break;
              }
              i2 = org.apache.thrift.b.a(this.f, paraman.f);
              i1 = i2;
            } while (i2 != 0);
            i2 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(paraman.g()));
            i1 = i2;
          } while (i2 != 0);
          if (!g()) {
            break;
          }
          i2 = org.apache.thrift.b.a(this.g, paraman.g);
          i1 = i2;
        } while (i2 != 0);
        i2 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(paraman.h()));
        i1 = i2;
      } while (i2 != 0);
      if (!h()) {
        break;
      }
      i2 = org.apache.thrift.b.a(this.h, paraman.h);
      i1 = i2;
    } while (i2 != 0);
    return 0;
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
    if ((this.e != null) && (e()))
    {
      parame.a(o);
      this.e.b(parame);
      parame.b();
    }
    parame.a(p);
    parame.a(this.f);
    parame.b();
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
    while (!(paramObject instanceof an)) {
      return false;
    }
    return a((an)paramObject);
  }
  
  public boolean f()
  {
    return this.s.get(0);
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
  }
  
  public String toString()
  {
    int i2 = 0;
    StringBuilder localStringBuilder = new StringBuilder("XmPushActionUnRegistrationResult(");
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
        break label395;
      }
      if (i1 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("target:");
      if (this.b != null) {
        break label321;
      }
      localStringBuilder.append("null");
      i1 = i2;
    }
    label91:
    label126:
    label157:
    label195:
    label258:
    label321:
    label347:
    label359:
    label371:
    label383:
    label395:
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
          break label347;
        }
        localStringBuilder.append("null");
        if (e())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("request:");
          if (this.e != null) {
            break label359;
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
            break label371;
          }
          localStringBuilder.append("null");
        }
        if (h())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("packageName:");
          if (this.h != null) {
            break label383;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/xmpush/thrift/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */