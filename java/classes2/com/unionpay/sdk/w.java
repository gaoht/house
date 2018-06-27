package com.unionpay.sdk;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class w
{
  static final class a
    implements x
  {
    String a = "";
    long b = 0L;
    int c = 0;
    String d = "";
    
    public final void messagePack(z paramz)
    {
      paramz.b(4);
      paramz.a(this.a);
      paramz.a(this.b);
      paramz.a(this.c);
      paramz.a(this.d);
    }
    
    public final String toString()
    {
      return "Activity{name:" + this.a + ",start:" + this.b + ",duration:" + this.c + ",refer:" + this.d;
    }
  }
  
  static final class b
    implements x
  {
    String a = "";
    String b = "";
    int c = 0;
    long d;
    Map e;
    
    public final void messagePack(z paramz)
    {
      paramz.b(5);
      paramz.a(this.a);
      paramz.a(this.b);
      paramz.a(this.c);
      paramz.a(this.d);
      Object localObject1 = this.e;
      if (localObject1 == null) {
        paramz.a();
      }
      for (;;)
      {
        return;
        Object localObject2 = new HashMap();
        Iterator localIterator = ((Map)localObject1).keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          Object localObject3 = ((Map)localObject1).get(str);
          if ((localObject3 instanceof String)) {
            ((Map)localObject2).put(str, localObject3.toString());
          } else if ((localObject3 instanceof Number)) {
            ((Map)localObject2).put(str, Double.valueOf(((Number)localObject3).doubleValue()));
          }
        }
        paramz.d(((Map)localObject2).size());
        localObject1 = ((Map)localObject2).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          paramz.a((String)((Map.Entry)localObject2).getKey());
          localObject2 = ((Map.Entry)localObject2).getValue();
          if ((localObject2 instanceof Number)) {
            paramz.a(((Number)localObject2).doubleValue());
          } else if ((localObject2 instanceof String)) {
            paramz.a(localObject2.toString());
          }
        }
      }
    }
    
    public final String toString()
    {
      return "AppEvent{id:" + this.a + ",label:" + this.b + ",count:" + this.c + ",ts:" + this.d + ",kv:" + this.e + '}';
    }
  }
  
  static final class c
    implements x
  {
    long a = 0L;
    int b = 1;
    String c = "";
    byte[] d = new byte[0];
    String e = "";
    
    public final void messagePack(z paramz)
    {
      paramz.b(5);
      paramz.a(this.a);
      paramz.a(this.b);
      paramz.a(this.c);
      byte[] arrayOfByte = this.d;
      if (arrayOfByte == null) {
        paramz.a();
      }
      for (;;)
      {
        paramz.a(this.e);
        return;
        paramz.e(arrayOfByte.length);
        paramz.a(arrayOfByte);
      }
    }
  }
  
  static final class d
    implements x
  {
    String a = "";
    String b = "";
    String c = "";
    long d = 0L;
    String e = "";
    String f = "";
    boolean g = false;
    long h = 0L;
    long i = 0L;
    
    public final void messagePack(z paramz)
    {
      paramz.b(9);
      paramz.a(this.a);
      paramz.a(this.b);
      paramz.a(this.c);
      paramz.a(this.d);
      paramz.a(this.e);
      paramz.a(this.f);
      paramz.a(this.g);
      paramz.a(this.h);
      paramz.a(this.i);
    }
  }
  
  static final class e
    implements x
  {
    String a = "";
    String b = "";
    w.h c = new w.h();
    String d = "";
    String e = "";
    String f = "";
    String g = "";
    String h = "";
    int i = 8;
    String j = "";
    int k = -1;
    String l = "";
    boolean m = false;
    String n = "";
    String o = "";
    String p = "";
    String q = "";
    long r = 0L;
    String s = "";
    String t = "";
    String u = "";
    int v;
    int w;
    String x = "";
    
    public final void messagePack(z paramz)
    {
      paramz.b(24);
      paramz.a(this.a);
      paramz.a(this.b);
      paramz.a(this.c);
      paramz.a(this.d);
      paramz.a(this.e);
      paramz.a(this.f);
      paramz.a(this.g);
      paramz.a(this.h);
      paramz.a(this.i);
      paramz.a(this.j);
      paramz.a(this.k);
      paramz.a(this.l);
      paramz.a(this.m);
      paramz.a(this.n);
      paramz.a(this.o);
      paramz.a(this.p);
      paramz.a(this.q);
      paramz.a(this.r).a(this.s).a(this.t).a(this.u).a(this.v).a(this.w).a(this.x);
    }
  }
  
  static final class f
    implements x
  {
    String a = "";
    String b = "";
    w.d c = new w.d();
    w.e d = new w.e();
    List e = new ArrayList();
    long f = 0L;
    long g = 0L;
    long h = 0L;
    Long[][] i;
    
    public final void messagePack(z paramz)
    {
      paramz.b(6);
      paramz.a(this.a);
      paramz.a(this.b);
      paramz.a(this.c);
      paramz.a(this.d);
      paramz.b(this.e.size());
      Object localObject1 = this.e.iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramz.a((w.i)((Iterator)localObject1).next());
      }
      if (this.i == null)
      {
        paramz.a();
        return;
      }
      if (ag.a) {
        k.b(new String[] { "app info:", Arrays.toString(this.i) });
      }
      paramz.b(this.i.length);
      localObject1 = this.i;
      int m = localObject1.length;
      int j = 0;
      label160:
      Object localObject2;
      if (j < m)
      {
        localObject2 = localObject1[j];
        if ((localObject2 != null) && (localObject2.length != 0)) {
          break label195;
        }
        paramz.a();
      }
      for (;;)
      {
        j += 1;
        break label160;
        break;
        label195:
        paramz.b(localObject2.length);
        int n = localObject2.length;
        int k = 0;
        while (k < n)
        {
          paramz.a(localObject2[k].longValue());
          k += 1;
        }
      }
    }
  }
  
  static final class g
    implements x
  {
    String A = "";
    String B = "";
    String C = "";
    String a = "";
    int b = 0;
    float c = 0.0F;
    String d = "";
    String e = "";
    String f = "";
    int g = 0;
    int h = 0;
    int i = 0;
    int j = 0;
    int k = 0;
    int l = 0;
    int m = 0;
    float n = 0.0F;
    float o = 0.0F;
    int p = 0;
    String q = "";
    String r = "";
    String s = "";
    String t = "";
    String u = "";
    String v = "";
    String w = "";
    boolean x = false;
    String y = "";
    String z = "";
    
    public final void messagePack(z paramz)
    {
      paramz.b(29);
      paramz.a(this.a);
      paramz.a(this.b);
      paramz.a(this.c);
      paramz.a(this.d);
      paramz.a(this.e);
      paramz.a(this.f);
      paramz.a(this.g);
      paramz.a(this.h);
      paramz.a(this.i);
      paramz.a(this.j);
      paramz.a(this.k);
      paramz.a(this.l);
      paramz.a(this.m);
      paramz.a(this.n);
      paramz.a(this.o);
      paramz.a(this.p);
      paramz.a(this.q);
      paramz.a(this.r);
      paramz.a(this.s);
      paramz.a(this.t);
      paramz.a(this.u);
      paramz.a(this.v);
      paramz.a(this.w);
      paramz.a(this.x);
      paramz.a(this.y);
      paramz.a(this.z);
      paramz.a(this.A);
      paramz.a(this.B);
      paramz.a(this.C);
    }
  }
  
  static final class h
    implements x
  {
    double a = 0.0D;
    double b = 0.0D;
    
    public final void messagePack(z paramz)
    {
      paramz.b(2);
      paramz.a(this.a);
      paramz.a(this.b);
    }
  }
  
  static final class i
    implements x
  {
    int a = -1;
    w.j b;
    w.g c;
    w.c d;
    
    public final void messagePack(z paramz)
    {
      paramz.b(2);
      paramz.a(this.a);
      switch (this.a)
      {
      default: 
        throw new IOException("unknown TMessageType");
      case 1: 
        paramz.a(this.c);
        return;
      case 2: 
        paramz.a(this.b);
        return;
      }
      paramz.a(this.d);
    }
  }
  
  static final class j
    implements x
  {
    String a = "";
    long b = 0L;
    int c = 0;
    int d = 0;
    List e = new ArrayList();
    List f = new ArrayList();
    int g = 0;
    int h = 0;
    long i = 0L;
    
    public final int a()
    {
      int j = z.c(8);
      int k = z.b(this.a);
      int m = z.b(this.b);
      int n = z.c(this.c);
      int i1 = z.c(this.d);
      int i2 = z.c(this.h);
      int i3 = z.c(this.e.size());
      Iterator localIterator = this.e.iterator();
      Object localObject;
      for (j = j + k + m + n + i1 + i2 + i3; localIterator.hasNext(); j = z.b(((w.a)localObject).d) + (k + m + n + i1) + j)
      {
        localObject = (w.a)localIterator.next();
        k = z.c(4);
        m = z.b(((w.a)localObject).a);
        n = z.b(((w.a)localObject).b);
        i1 = z.c(((w.a)localObject).c);
      }
      k = z.c(this.f.size());
      localIterator = this.f.iterator();
      for (j = k + j; localIterator.hasNext(); j = z.c(((w.b)localObject).c) + (k + m + n) + j)
      {
        localObject = (w.b)localIterator.next();
        k = z.c(3);
        m = z.b(((w.b)localObject).a);
        n = z.b(((w.b)localObject).b);
      }
      return z.b(this.i) + j;
    }
    
    public final void messagePack(z paramz)
    {
      paramz.b(8);
      paramz.a(this.a);
      paramz.a(this.b);
      paramz.a(this.c);
      paramz.a(this.d);
      paramz.b(this.e.size());
      Iterator localIterator = this.e.iterator();
      while (localIterator.hasNext()) {
        paramz.a((w.a)localIterator.next());
      }
      paramz.b(this.f.size());
      localIterator = this.f.iterator();
      while (localIterator.hasNext()) {
        paramz.a((w.b)localIterator.next());
      }
      paramz.a(this.h);
      paramz.a(this.i);
    }
    
    public final String toString()
    {
      return "Session{id:" + this.a + ",start:" + this.b + ",status:" + this.c + ",duration:" + this.d + ",connected:" + this.h + ",time_gap:" + this.i + '}';
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */