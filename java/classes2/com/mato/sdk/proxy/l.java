package com.mato.sdk.proxy;

import android.text.TextUtils;
import com.mato.android.matoid.service.mtunnel.a.a;
import com.mato.android.matoid.service.mtunnel.a.c;
import com.mato.android.matoid.service.mtunnel.a.e;
import com.mato.android.matoid.service.mtunnel.a.i;
import com.mato.android.matoid.service.mtunnel.a.j;
import com.mato.android.matoid.service.mtunnel.a.k;
import com.mato.sdk.d.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class l
{
  private static String a = "WSPX_SETTING";
  
  protected static int a(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 100;
    }
    paramInt1 = Math.max(paramInt1, paramInt2);
    paramInt1 = new b(paramString).a(paramInt1);
    return paramInt1;
  }
  
  protected static a.a a(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    default: 
      return a.a.a;
    case 0: 
      return a.a.b;
    case 1: 
      if (paramBoolean) {
        return a.a.f;
      }
      return a.a.c;
    case 2: 
      if (paramBoolean) {
        return a.a.g;
      }
      return a.a.d;
    }
    if (paramBoolean) {
      return a.a.h;
    }
    return a.a.e;
  }
  
  public static a.c a(i parami)
  {
    if (parami.i() == 3) {
      return a.c.a;
    }
    switch (parami.e())
    {
    default: 
      return a.c.b;
    case 1: 
      return a.c.b;
    case 2: 
      return a.c.c;
    case 3: 
      return a.c.d;
    }
    return a.c.e;
  }
  
  protected static void a(a.j paramj, i parami, int paramInt)
  {
    if (-1 == paramInt) {
      return;
    }
    a.k localk = a.k.a;
    if (!parami.c()) {
      localk = e(paramInt);
    }
    switch (parami.i())
    {
    default: 
      paramj.c(false);
      return;
    case 0: 
      if (localk == a.k.c)
      {
        paramj.c(true);
        paramj.a(localk);
        return;
      }
      if (parami.l() == 2)
      {
        paramj.c(true);
        paramj.a(localk);
        return;
      }
      paramj.c(false);
      paramj.a(a.c.a);
      return;
    }
    paramj.c(true);
    paramj.a(localk);
  }
  
  protected static void a(a.j paramj, a parama)
  {
    paramj.m(parama.a);
    paramj.a(parama.b);
    paramj.l(parama.c);
    paramj.e(parama.e);
    paramj.a(parama.g);
    paramj.k(parama.f);
    paramj.n(parama.d);
    paramj.g(parama.h);
    paramj.a(parama.i);
    paramj.h(parama.j);
    paramj.b(parama.k);
    paramj.i((int)parama.l);
    paramj.i(parama.m);
    paramj.j(parama.n);
    paramj.b(parama.o);
  }
  
  private static void a(a.k paramk, a.j paramj, i parami)
  {
    if (paramk == a.k.c)
    {
      paramj.c(true);
      paramj.a(paramk);
      return;
    }
    if (parami.l() == 2)
    {
      paramj.c(true);
      paramj.a(paramk);
      return;
    }
    paramj.c(false);
    paramj.a(a.c.a);
  }
  
  private static void a(String paramString1, String paramString2)
  {
    if (paramString2 == null)
    {
      new StringBuilder().append(paramString1).append("is null");
      return;
    }
  }
  
  protected static a.a b(int paramInt)
  {
    switch (paramInt)
    {
    case 8: 
    default: 
      return a.a.a;
    case 1: 
      return a.a.b;
    case 2: 
      return a.a.c;
    case 3: 
      return a.a.d;
    case 4: 
      return a.a.e;
    case 5: 
      return a.a.f;
    case 6: 
      return a.a.g;
    case 7: 
      return a.a.h;
    case 10: 
      return a.a.j;
    case 9: 
      return a.a.i;
    }
    return a.a.k;
  }
  
  protected static void b() {}
  
  protected static a.i c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return a.i.c;
    case 0: 
      return a.i.a;
    case 1: 
      return a.i.b;
    }
    return a.i.c;
  }
  
  protected static void c() {}
  
  protected static a.e d(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return a.e.a;
    case 0: 
      return a.e.a;
    case 1: 
      return a.e.b;
    case 2: 
      return a.e.c;
    }
    return a.e.d;
  }
  
  public static a.k e(int paramInt)
  {
    a.k localk = a.k.a;
    switch (paramInt)
    {
    default: 
      return localk;
    case 0: 
      return a.k.a;
    case 1: 
      return a.k.b;
    }
    return a.k.c;
  }
  
  public abstract byte[] a(int paramInt);
  
  public abstract String[] a();
  
  public static final class a
  {
    public String a;
    public a.e b;
    public String c;
    public String d;
    public int e;
    public String f;
    public a.a g;
    public boolean h = false;
    public a.i i = a.i.c;
    public int j = 0;
    public a.c k;
    public long l;
    public boolean m;
    public boolean n;
    public a.k o;
    
    public static a a(String paramString, a.i parami, a.c paramc, long paramLong, boolean paramBoolean1, boolean paramBoolean2, a.k paramk)
    {
      a locala = new a();
      locala.f = paramString;
      locala.a = "";
      locala.c = "";
      locala.d = "";
      locala.e = 0;
      locala.g = a.a.a;
      locala.b = a.e.a;
      locala.i = parami;
      locala.k = paramc;
      locala.l = 0L;
      locala.m = paramBoolean1;
      locala.n = paramBoolean2;
      locala.o = paramk;
      return locala;
    }
    
    public static a a(String paramString, boolean paramBoolean1, a.i parami, a.c paramc, long paramLong, boolean paramBoolean2, boolean paramBoolean3, a.k paramk)
    {
      a locala = new a();
      locala.f = paramString;
      locala.h = paramBoolean1;
      locala.a = "";
      locala.c = "";
      locala.d = "";
      locala.e = 0;
      locala.g = a.a.j;
      locala.b = a.e.a;
      locala.i = parami;
      locala.k = paramc;
      locala.l = 0L;
      locala.m = paramBoolean2;
      locala.n = paramBoolean3;
      locala.o = paramk;
      return locala;
    }
  }
  
  public static final class b
  {
    private final List<a> a = new ArrayList();
    
    public b(String paramString)
    {
      paramString = paramString.split(";");
      int i = 0;
      while (i < paramString.length)
      {
        String[] arrayOfString = paramString[i].split(",");
        a locala = new a((byte)0);
        locala.a = Integer.valueOf(arrayOfString[0]).intValue();
        locala.b = Integer.valueOf(arrayOfString[1]).intValue();
        this.a.add(locala);
        i += 1;
      }
      Collections.sort(this.a);
    }
    
    public final int a(int paramInt)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (paramInt >= locala.a) {
          return locala.b;
        }
      }
      return 100;
    }
    
    static final class a
      implements Comparable<a>
    {
      public int a;
      public int b;
      
      private int a(a parama)
      {
        if (this.a > parama.a) {
          return -1;
        }
        if (this.a < parama.a) {
          return 1;
        }
        return 0;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/proxy/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */