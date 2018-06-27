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
import org.apache.thrift.protocol.c;
import org.apache.thrift.protocol.e;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.h;
import org.apache.thrift.protocol.j;

public class ac
  implements Serializable, Cloneable, a<ac, a>
{
  public static final Map<a, org.apache.thrift.meta_data.b> b;
  private static final j c = new j("XmPushActionCustomConfig");
  private static final org.apache.thrift.protocol.b d = new org.apache.thrift.protocol.b("customConfigs", (byte)15, (short)1);
  public List<p> a;
  
  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.apache.thrift.meta_data.b("customConfigs", (byte)1, new d((byte)15, new g((byte)12, p.class))));
    b = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(ac.class, b);
  }
  
  public List<p> a()
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
      c();
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
      if (((org.apache.thrift.protocol.b)localObject).b == 15)
      {
        localObject = parame.m();
        this.a = new ArrayList(((c)localObject).b);
        int i = 0;
        while (i < ((c)localObject).b)
        {
          p localp = new p();
          localp.a(parame);
          this.a.add(localp);
          i += 1;
        }
        parame.n();
      }
      else
      {
        h.a(parame, ((org.apache.thrift.protocol.b)localObject).b);
      }
    }
  }
  
  public boolean a(ac paramac)
  {
    if (paramac == null) {}
    boolean bool1;
    boolean bool2;
    do
    {
      return false;
      bool1 = b();
      bool2 = paramac.b();
    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramac.a))));
    return true;
  }
  
  public int b(ac paramac)
  {
    int i;
    if (!getClass().equals(paramac.getClass())) {
      i = getClass().getName().compareTo(paramac.getClass().getName());
    }
    int j;
    do
    {
      do
      {
        return i;
        j = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramac.b()));
        i = j;
      } while (j != 0);
      if (!b()) {
        break;
      }
      j = org.apache.thrift.b.a(this.a, paramac.a);
      i = j;
    } while (j != 0);
    return 0;
  }
  
  public void b(e parame)
  {
    c();
    parame.a(c);
    if (this.a != null)
    {
      parame.a(d);
      parame.a(new c((byte)12, this.a.size()));
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((p)localIterator.next()).b(parame);
      }
      parame.e();
      parame.b();
    }
    parame.c();
    parame.a();
  }
  
  public boolean b()
  {
    return this.a != null;
  }
  
  public void c()
  {
    if (this.a == null) {
      throw new f("Required field 'customConfigs' was not present! Struct: " + toString());
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof ac)) {
      return false;
    }
    return a((ac)paramObject);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("XmPushActionCustomConfig(");
    localStringBuilder.append("customConfigs:");
    if (this.a == null) {
      localStringBuilder.append("null");
    }
    for (;;)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
    }
  }
  
  public static enum a
  {
    private static final Map<String, a> b;
    private final short c;
    private final String d;
    
    static
    {
      b = new HashMap();
      Iterator localIterator = EnumSet.allOf(a.class).iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        b.put(locala.a(), locala);
      }
    }
    
    private a(short paramShort, String paramString)
    {
      this.c = paramShort;
      this.d = paramString;
    }
    
    public String a()
    {
      return this.d;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/xmpush/thrift/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */