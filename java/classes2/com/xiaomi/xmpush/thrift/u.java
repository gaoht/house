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
import org.apache.thrift.protocol.e;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.h;
import org.apache.thrift.protocol.j;

public class u
  implements Serializable, Cloneable, a<u, a>
{
  public static final Map<a, org.apache.thrift.meta_data.b> f;
  private static final j g = new j("Target");
  private static final org.apache.thrift.protocol.b h = new org.apache.thrift.protocol.b("channelId", (byte)10, (short)1);
  private static final org.apache.thrift.protocol.b i = new org.apache.thrift.protocol.b("userId", (byte)11, (short)2);
  private static final org.apache.thrift.protocol.b j = new org.apache.thrift.protocol.b("server", (byte)11, (short)3);
  private static final org.apache.thrift.protocol.b k = new org.apache.thrift.protocol.b("resource", (byte)11, (short)4);
  private static final org.apache.thrift.protocol.b l = new org.apache.thrift.protocol.b("isPreview", (byte)2, (short)5);
  public long a = 5L;
  public String b;
  public String c = "xiaomi.com";
  public String d = "";
  public boolean e = false;
  private BitSet m = new BitSet(2);
  
  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.apache.thrift.meta_data.b("channelId", (byte)1, new c((byte)10)));
    localEnumMap.put(a.b, new org.apache.thrift.meta_data.b("userId", (byte)1, new c((byte)11)));
    localEnumMap.put(a.c, new org.apache.thrift.meta_data.b("server", (byte)2, new c((byte)11)));
    localEnumMap.put(a.d, new org.apache.thrift.meta_data.b("resource", (byte)2, new c((byte)11)));
    localEnumMap.put(a.e, new org.apache.thrift.meta_data.b("isPreview", (byte)2, new c((byte)2)));
    f = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(u.class, f);
  }
  
  public void a(e parame)
  {
    parame.g();
    org.apache.thrift.protocol.b localb = parame.i();
    if (localb.b == 0)
    {
      parame.h();
      if (!a()) {
        throw new f("Required field 'channelId' was not found in serialized data! Struct: " + toString());
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
        if (localb.b == 10)
        {
          this.a = parame.u();
          a(true);
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
                if (localb.b == 2)
                {
                  this.e = parame.q();
                  b(true);
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
    f();
  }
  
  public void a(boolean paramBoolean)
  {
    this.m.set(0, paramBoolean);
  }
  
  public boolean a()
  {
    return this.m.get(0);
  }
  
  public boolean a(u paramu)
  {
    if (paramu == null) {}
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
              return false;
            } while (this.a != paramu.a);
            bool1 = b();
            bool2 = paramu.b();
          } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.b.equals(paramu.b))));
          bool1 = c();
          bool2 = paramu.c();
        } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.c.equals(paramu.c))));
        bool1 = d();
        bool2 = paramu.d();
      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.d.equals(paramu.d))));
      bool1 = e();
      bool2 = paramu.e();
    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (this.e != paramu.e)));
    return true;
  }
  
  public int b(u paramu)
  {
    int n;
    if (!getClass().equals(paramu.getClass())) {
      n = getClass().getName().compareTo(paramu.getClass().getName());
    }
    int i1;
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
                        return n;
                        i1 = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramu.a()));
                        n = i1;
                      } while (i1 != 0);
                      if (!a()) {
                        break;
                      }
                      i1 = org.apache.thrift.b.a(this.a, paramu.a);
                      n = i1;
                    } while (i1 != 0);
                    i1 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramu.b()));
                    n = i1;
                  } while (i1 != 0);
                  if (!b()) {
                    break;
                  }
                  i1 = org.apache.thrift.b.a(this.b, paramu.b);
                  n = i1;
                } while (i1 != 0);
                i1 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramu.c()));
                n = i1;
              } while (i1 != 0);
              if (!c()) {
                break;
              }
              i1 = org.apache.thrift.b.a(this.c, paramu.c);
              n = i1;
            } while (i1 != 0);
            i1 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paramu.d()));
            n = i1;
          } while (i1 != 0);
          if (!d()) {
            break;
          }
          i1 = org.apache.thrift.b.a(this.d, paramu.d);
          n = i1;
        } while (i1 != 0);
        i1 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paramu.e()));
        n = i1;
      } while (i1 != 0);
      if (!e()) {
        break;
      }
      i1 = org.apache.thrift.b.a(this.e, paramu.e);
      n = i1;
    } while (i1 != 0);
    return 0;
  }
  
  public void b(e parame)
  {
    f();
    parame.a(g);
    parame.a(h);
    parame.a(this.a);
    parame.b();
    if (this.b != null)
    {
      parame.a(i);
      parame.a(this.b);
      parame.b();
    }
    if ((this.c != null) && (c()))
    {
      parame.a(j);
      parame.a(this.c);
      parame.b();
    }
    if ((this.d != null) && (d()))
    {
      parame.a(k);
      parame.a(this.d);
      parame.b();
    }
    if (e())
    {
      parame.a(l);
      parame.a(this.e);
      parame.b();
    }
    parame.c();
    parame.a();
  }
  
  public void b(boolean paramBoolean)
  {
    this.m.set(1, paramBoolean);
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
    return this.m.get(1);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof u)) {
      return false;
    }
    return a((u)paramObject);
  }
  
  public void f()
  {
    if (this.b == null) {
      throw new f("Required field 'userId' was not present! Struct: " + toString());
    }
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Target(");
    localStringBuilder.append("channelId:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append("userId:");
    if (this.b == null)
    {
      localStringBuilder.append("null");
      if (c())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("server:");
        if (this.c != null) {
          break label192;
        }
        localStringBuilder.append("null");
      }
      label97:
      if (d())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("resource:");
        if (this.d != null) {
          break label204;
        }
        localStringBuilder.append("null");
      }
    }
    for (;;)
    {
      if (e())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("isPreview:");
        localStringBuilder.append(this.e);
      }
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.b);
      break;
      label192:
      localStringBuilder.append(this.c);
      break label97;
      label204:
      localStringBuilder.append(this.d);
    }
  }
  
  public static enum a
  {
    private static final Map<String, a> f;
    private final short g;
    private final String h;
    
    static
    {
      f = new HashMap();
      Iterator localIterator = EnumSet.allOf(a.class).iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        f.put(locala.a(), locala);
      }
    }
    
    private a(short paramShort, String paramString)
    {
      this.g = paramShort;
      this.h = paramString;
    }
    
    public String a()
    {
      return this.h;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/xmpush/thrift/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */