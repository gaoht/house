package com.xiaomi.push.protobuf;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class a
{
  public static final class a
    extends e
  {
    private boolean a;
    private int b = 0;
    private boolean c;
    private boolean d = false;
    private boolean e;
    private int f = 0;
    private boolean g;
    private boolean h = false;
    private List<String> i = Collections.emptyList();
    private int j = -1;
    
    public static a b(byte[] paramArrayOfByte)
    {
      return (a)new a().a(paramArrayOfByte);
    }
    
    public static a c(b paramb)
    {
      return new a().b(paramb);
    }
    
    public int a()
    {
      if (this.j < 0) {
        b();
      }
      return this.j;
    }
    
    public a a(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public a a(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      if (this.i.isEmpty()) {
        this.i = new ArrayList();
      }
      this.i.add(paramString);
      return this;
    }
    
    public a a(boolean paramBoolean)
    {
      this.c = true;
      this.d = paramBoolean;
      return this;
    }
    
    public void a(c paramc)
    {
      if (e()) {
        paramc.b(1, d());
      }
      if (g()) {
        paramc.a(2, f());
      }
      if (i()) {
        paramc.a(3, h());
      }
      if (k()) {
        paramc.a(4, j());
      }
      Iterator localIterator = l().iterator();
      while (localIterator.hasNext()) {
        paramc.a(5, (String)localIterator.next());
      }
    }
    
    public int b()
    {
      int n = 0;
      if (e()) {}
      for (int m = c.d(1, d()) + 0;; m = 0)
      {
        int k = m;
        if (g()) {
          k = m + c.b(2, f());
        }
        m = k;
        if (i()) {
          m = k + c.c(3, h());
        }
        if (k()) {}
        for (k = m + c.b(4, j());; k = m)
        {
          Iterator localIterator = l().iterator();
          m = n;
          while (localIterator.hasNext()) {
            m += c.b((String)localIterator.next());
          }
          k = k + m + l().size() * 1;
          this.j = k;
          return k;
        }
      }
    }
    
    public a b(int paramInt)
    {
      this.e = true;
      this.f = paramInt;
      return this;
    }
    
    public a b(b paramb)
    {
      for (;;)
      {
        int k = paramb.a();
        switch (k)
        {
        default: 
          if (a(paramb, k)) {}
          break;
        case 0: 
          return this;
        case 8: 
          a(paramb.i());
          break;
        case 16: 
          a(paramb.f());
          break;
        case 24: 
          b(paramb.e());
          break;
        case 32: 
          b(paramb.f());
          break;
        case 42: 
          a(paramb.g());
        }
      }
    }
    
    public a b(boolean paramBoolean)
    {
      this.g = true;
      this.h = paramBoolean;
      return this;
    }
    
    public int d()
    {
      return this.b;
    }
    
    public boolean e()
    {
      return this.a;
    }
    
    public boolean f()
    {
      return this.d;
    }
    
    public boolean g()
    {
      return this.c;
    }
    
    public int h()
    {
      return this.f;
    }
    
    public boolean i()
    {
      return this.e;
    }
    
    public boolean j()
    {
      return this.h;
    }
    
    public boolean k()
    {
      return this.g;
    }
    
    public List<String> l()
    {
      return this.i;
    }
    
    public int m()
    {
      return this.i.size();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/protobuf/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */