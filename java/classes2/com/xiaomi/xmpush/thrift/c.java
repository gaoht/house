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
import org.apache.thrift.meta_data.g;
import org.apache.thrift.protocol.e;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.h;
import org.apache.thrift.protocol.j;

public class c
  implements Serializable, Cloneable, a<c, a>
{
  public static final Map<a, org.apache.thrift.meta_data.b> b;
  private static final j c = new j("ClientUploadData");
  private static final org.apache.thrift.protocol.b d = new org.apache.thrift.protocol.b("uploadDataItems", (byte)15, (short)1);
  public List<d> a;
  
  static
  {
    EnumMap localEnumMap = new EnumMap(a.class);
    localEnumMap.put(a.a, new org.apache.thrift.meta_data.b("uploadDataItems", (byte)1, new org.apache.thrift.meta_data.d((byte)15, new g((byte)12, d.class))));
    b = Collections.unmodifiableMap(localEnumMap);
    org.apache.thrift.meta_data.b.a(c.class, b);
  }
  
  public int a()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.size();
  }
  
  public void a(d paramd)
  {
    if (this.a == null) {
      this.a = new ArrayList();
    }
    this.a.add(paramd);
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
        this.a = new ArrayList(((org.apache.thrift.protocol.c)localObject).b);
        int i = 0;
        while (i < ((org.apache.thrift.protocol.c)localObject).b)
        {
          d locald = new d();
          locald.a(parame);
          this.a.add(locald);
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
  
  public boolean a(c paramc)
  {
    if (paramc == null) {}
    boolean bool1;
    boolean bool2;
    do
    {
      return false;
      bool1 = b();
      bool2 = paramc.b();
    } while (((bool1) || (bool2)) && ((!bool1) || (!bool2) || (!this.a.equals(paramc.a))));
    return true;
  }
  
  public int b(c paramc)
  {
    int i;
    if (!getClass().equals(paramc.getClass())) {
      i = getClass().getName().compareTo(paramc.getClass().getName());
    }
    int j;
    do
    {
      do
      {
        return i;
        j = Boolean.valueOf(b()).compareTo(Boolean.valueOf(paramc.b()));
        i = j;
      } while (j != 0);
      if (!b()) {
        break;
      }
      j = org.apache.thrift.b.a(this.a, paramc.a);
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
      parame.a(new org.apache.thrift.protocol.c((byte)12, this.a.size()));
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).b(parame);
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
      throw new f("Required field 'uploadDataItems' was not present! Struct: " + toString());
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof c)) {
      return false;
    }
    return a((c)paramObject);
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ClientUploadData(");
    localStringBuilder.append("uploadDataItems:");
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/xmpush/thrift/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */