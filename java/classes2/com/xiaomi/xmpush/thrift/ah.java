package com.xiaomi.xmpush.thrift;

import java.io.Serializable;
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

public class ah
  implements Serializable, Cloneable, a<ah, a>
{
  public static final Map<a, org.apache.thrift.meta_data.b> g;
  private static final j h = new j("XmPushActionSendFeedback");
  private static final org.apache.thrift.protocol.b i = new org.apache.thrift.protocol.b("debug", (byte)11, (short)1);
  private static final org.apache.thrift.protocol.b j = new org.apache.thrift.protocol.b("target", (byte)12, (short)2);
  private static final org.apache.thrift.protocol.b k = new org.apache.thrift.protocol.b("id", (byte)11, (short)3);
  private static final org.apache.thrift.protocol.b l = new org.apache.thrift.protocol.b("appId", (byte)11, (short)4);
  private static final org.apache.thrift.protocol.b m = new org.apache.thrift.protocol.b("feedbacks", (byte)13, (short)5);
  private static final org.apache.thrift.protocol.b n = new org.apache.thrift.protocol.b("category", (byte)11, (short)6);
  public String a;
  public u b;
  public String c;
  public String d;
  public Map<String, String> e;
  public String f;
  
  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.apache.thrift.meta_data.b("debug", (byte)2, new c((byte)11)));
    localEnumMap.put(a.b, new org.apache.thrift.meta_data.b("target", (byte)2, new g((byte)12, u.class)));
    localEnumMap.put(a.c, new org.apache.thrift.meta_data.b("id", (byte)1, new c((byte)11)));
    localEnumMap.put(a.d, new org.apache.thrift.meta_data.b("appId", (byte)1, new c((byte)11)));
    localEnumMap.put(a.e, new org.apache.thrift.meta_data.b("feedbacks", (byte)2, new org.apache.thrift.meta_data.e((byte)13, new c((byte)11), new c((byte)11))));
    localEnumMap.put(a.f, new org.apache.thrift.meta_data.b("category", (byte)2, new c((byte)11)));
    g = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(ah.class, g);
  }
  
  public void a(org.apache.thrift.protocol.e parame)
  {
    parame.g();
    Object localObject = parame.i();
    if (((org.apache.thrift.protocol.b)localObject).b == 0)
    {
      parame.h();
      g();
      return;
    }
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
              if (((org.apache.thrift.protocol.b)localObject).b == 13)
              {
                localObject = parame.k();
                this.e = new HashMap(((d)localObject).c * 2);
                int i1 = 0;
                while (i1 < ((d)localObject).c)
                {
                  String str1 = parame.w();
                  String str2 = parame.w();
                  this.e.put(str1, str2);
                  i1 += 1;
                }
                parame.l();
              }
              else
              {
                h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
                continue;
                if (((org.apache.thrift.protocol.b)localObject).b == 11) {
                  this.f = parame.w();
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
  
  public boolean a()
  {
    return this.a != null;
  }
  
  public boolean a(ah paramah)
  {
    if (paramah == null) {}
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
                bool1 = a();
                bool2 = paramah.a();
              } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramah.a))));
              bool1 = b();
              bool2 = paramah.b();
            } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.b.a(paramah.b))));
            bool1 = c();
            bool2 = paramah.c();
          } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.c.equals(paramah.c))));
          bool1 = d();
          bool2 = paramah.d();
        } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.d.equals(paramah.d))));
        bool1 = e();
        bool2 = paramah.e();
      } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.e.equals(paramah.e))));
      bool1 = f();
      bool2 = paramah.f();
    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.f.equals(paramah.f))));
    return true;
  }
  
  public int b(ah paramah)
  {
    int i1;
    if (!getClass().equals(paramah.getClass())) {
      i1 = getClass().getName().compareTo(paramah.getClass().getName());
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
                            return i1;
                            i2 = Boolean.valueOf(a()).compareTo(Boolean.valueOf(paramah.a()));
                            i1 = i2;
                          } while (i2 != 0);
                          if (!a()) {
                            break;
                          }
                          i2 = org.apache.thrift.b.a(this.a, paramah.a);
                          i1 = i2;
                        } while (i2 != 0);
                        i2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramah.b()));
                        i1 = i2;
                      } while (i2 != 0);
                      if (!b()) {
                        break;
                      }
                      i2 = org.apache.thrift.b.a(this.b, paramah.b);
                      i1 = i2;
                    } while (i2 != 0);
                    i2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(paramah.c()));
                    i1 = i2;
                  } while (i2 != 0);
                  if (!c()) {
                    break;
                  }
                  i2 = org.apache.thrift.b.a(this.c, paramah.c);
                  i1 = i2;
                } while (i2 != 0);
                i2 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(paramah.d()));
                i1 = i2;
              } while (i2 != 0);
              if (!d()) {
                break;
              }
              i2 = org.apache.thrift.b.a(this.d, paramah.d);
              i1 = i2;
            } while (i2 != 0);
            i2 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(paramah.e()));
            i1 = i2;
          } while (i2 != 0);
          if (!e()) {
            break;
          }
          i2 = org.apache.thrift.b.a(this.e, paramah.e);
          i1 = i2;
        } while (i2 != 0);
        i2 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(paramah.f()));
        i1 = i2;
      } while (i2 != 0);
      if (!f()) {
        break;
      }
      i2 = org.apache.thrift.b.a(this.f, paramah.f);
      i1 = i2;
    } while (i2 != 0);
    return 0;
  }
  
  public void b(org.apache.thrift.protocol.e parame)
  {
    g();
    parame.a(h);
    if ((this.a != null) && (a()))
    {
      parame.a(i);
      parame.a(this.a);
      parame.b();
    }
    if ((this.b != null) && (b()))
    {
      parame.a(j);
      this.b.b(parame);
      parame.b();
    }
    if (this.c != null)
    {
      parame.a(k);
      parame.a(this.c);
      parame.b();
    }
    if (this.d != null)
    {
      parame.a(l);
      parame.a(this.d);
      parame.b();
    }
    if ((this.e != null) && (e()))
    {
      parame.a(m);
      parame.a(new d((byte)11, (byte)11, this.e.size()));
      Iterator localIterator = this.e.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        parame.a((String)localEntry.getKey());
        parame.a((String)localEntry.getValue());
      }
      parame.d();
      parame.b();
    }
    if ((this.f != null) && (f()))
    {
      parame.a(n);
      parame.a(this.f);
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
    while (!(paramObject instanceof ah)) {
      return false;
    }
    return a((ah)paramObject);
  }
  
  public boolean f()
  {
    return this.f != null;
  }
  
  public void g()
  {
    if (this.c == null) {
      throw new f("Required field 'id' was not present! Struct: " + toString());
    }
    if (this.d == null) {
      throw new f("Required field 'appId' was not present! Struct: " + toString());
    }
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toString()
  {
    int i2 = 0;
    StringBuilder localStringBuilder = new StringBuilder("XmPushActionSendFeedback(");
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
        break label320;
      }
      if (i1 == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("target:");
      if (this.b != null) {
        break label258;
      }
      localStringBuilder.append("null");
      i1 = i2;
    }
    label91:
    label126:
    label157:
    label195:
    label258:
    label284:
    label296:
    label308:
    label320:
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
          break label284;
        }
        localStringBuilder.append("null");
        if (e())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("feedbacks:");
          if (this.e != null) {
            break label296;
          }
          localStringBuilder.append("null");
        }
        if (f())
        {
          localStringBuilder.append(", ");
          localStringBuilder.append("category:");
          if (this.f != null) {
            break label308;
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
        localStringBuilder.append(this.f);
      }
    }
  }
  
  public static enum a
  {
    private static final Map<String, a> g;
    private final short h;
    private final String i;
    
    static
    {
      g = new HashMap();
      Iterator localIterator = EnumSet.allOf(a.class).iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        g.put(locala.a(), locala);
      }
    }
    
    private a(short paramShort, String paramString)
    {
      this.h = paramShort;
      this.i = paramString;
    }
    
    public String a()
    {
      return this.i;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/xmpush/thrift/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */