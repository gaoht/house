package com.xiaomi.push.protobuf;

import com.google.b.a.a;
import com.google.b.a.c;
import com.google.b.a.e;

public final class b
{
  public static final class a
    extends e
  {
    private boolean a;
    private int b = 0;
    private boolean c;
    private long d = 0L;
    private boolean e;
    private String f = "";
    private boolean g;
    private String h = "";
    private boolean i;
    private String j = "";
    private boolean k;
    private String l = "";
    private boolean m;
    private String n = "";
    private boolean o;
    private int p = 1;
    private boolean q;
    private int r = 0;
    private boolean s;
    private int t = 0;
    private boolean u;
    private String v = "";
    private int w = -1;
    
    public int a()
    {
      if (this.w < 0) {
        b();
      }
      return this.w;
    }
    
    public a a(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public a a(long paramLong)
    {
      this.c = true;
      this.d = paramLong;
      return this;
    }
    
    public a a(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public void a(c paramc)
    {
      if (e()) {
        paramc.a(1, d());
      }
      if (g()) {
        paramc.b(2, f());
      }
      if (i()) {
        paramc.a(3, h());
      }
      if (k()) {
        paramc.a(4, j());
      }
      if (m()) {
        paramc.a(5, l());
      }
      if (o()) {
        paramc.a(6, n());
      }
      if (r()) {
        paramc.a(7, q());
      }
      if (s()) {
        paramc.a(8, t());
      }
      if (v()) {
        paramc.a(9, u());
      }
      if (x()) {
        paramc.a(10, w());
      }
      if (z()) {
        paramc.a(11, y());
      }
    }
    
    public int b()
    {
      int i2 = 0;
      if (e()) {
        i2 = 0 + c.c(1, d());
      }
      int i1 = i2;
      if (g()) {
        i1 = i2 + c.d(2, f());
      }
      i2 = i1;
      if (i()) {
        i2 = i1 + c.b(3, h());
      }
      i1 = i2;
      if (k()) {
        i1 = i2 + c.b(4, j());
      }
      i2 = i1;
      if (m()) {
        i2 = i1 + c.b(5, l());
      }
      i1 = i2;
      if (o()) {
        i1 = i2 + c.b(6, n());
      }
      i2 = i1;
      if (r()) {
        i2 = i1 + c.b(7, q());
      }
      i1 = i2;
      if (s()) {
        i1 = i2 + c.c(8, t());
      }
      i2 = i1;
      if (v()) {
        i2 = i1 + c.c(9, u());
      }
      i1 = i2;
      if (x()) {
        i1 = i2 + c.c(10, w());
      }
      i2 = i1;
      if (z()) {
        i2 = i1 + c.b(11, y());
      }
      this.w = i2;
      return i2;
    }
    
    public a b(int paramInt)
    {
      this.o = true;
      this.p = paramInt;
      return this;
    }
    
    public a b(com.google.b.a.b paramb)
    {
      for (;;)
      {
        int i1 = paramb.a();
        switch (i1)
        {
        default: 
          if (a(paramb, i1)) {}
          break;
        case 0: 
          return this;
        case 8: 
          a(paramb.e());
          break;
        case 16: 
          a(paramb.d());
          break;
        case 26: 
          a(paramb.g());
          break;
        case 34: 
          b(paramb.g());
          break;
        case 42: 
          c(paramb.g());
          break;
        case 50: 
          d(paramb.g());
          break;
        case 58: 
          e(paramb.g());
          break;
        case 64: 
          b(paramb.e());
          break;
        case 72: 
          c(paramb.e());
          break;
        case 80: 
          d(paramb.e());
          break;
        case 90: 
          f(paramb.g());
        }
      }
    }
    
    public a b(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public a c(int paramInt)
    {
      this.q = true;
      this.r = paramInt;
      return this;
    }
    
    public a c(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public int d()
    {
      return this.b;
    }
    
    public a d(int paramInt)
    {
      this.s = true;
      this.t = paramInt;
      return this;
    }
    
    public a d(String paramString)
    {
      this.k = true;
      this.l = paramString;
      return this;
    }
    
    public a e(String paramString)
    {
      this.m = true;
      this.n = paramString;
      return this;
    }
    
    public boolean e()
    {
      return this.a;
    }
    
    public long f()
    {
      return this.d;
    }
    
    public a f(String paramString)
    {
      this.u = true;
      this.v = paramString;
      return this;
    }
    
    public boolean g()
    {
      return this.c;
    }
    
    public String h()
    {
      return this.f;
    }
    
    public boolean i()
    {
      return this.e;
    }
    
    public String j()
    {
      return this.h;
    }
    
    public boolean k()
    {
      return this.g;
    }
    
    public String l()
    {
      return this.j;
    }
    
    public boolean m()
    {
      return this.i;
    }
    
    public String n()
    {
      return this.l;
    }
    
    public boolean o()
    {
      return this.k;
    }
    
    public a p()
    {
      this.k = false;
      this.l = "";
      return this;
    }
    
    public String q()
    {
      return this.n;
    }
    
    public boolean r()
    {
      return this.m;
    }
    
    public boolean s()
    {
      return this.o;
    }
    
    public int t()
    {
      return this.p;
    }
    
    public int u()
    {
      return this.r;
    }
    
    public boolean v()
    {
      return this.q;
    }
    
    public int w()
    {
      return this.t;
    }
    
    public boolean x()
    {
      return this.s;
    }
    
    public String y()
    {
      return this.v;
    }
    
    public boolean z()
    {
      return this.u;
    }
  }
  
  public static final class b
    extends e
  {
    private boolean a;
    private boolean b = false;
    private boolean c;
    private int d = 0;
    private boolean e;
    private int f = 0;
    private boolean g;
    private int h = 0;
    private int i = -1;
    
    public static b b(byte[] paramArrayOfByte)
    {
      return (b)new b().a(paramArrayOfByte);
    }
    
    public int a()
    {
      if (this.i < 0) {
        b();
      }
      return this.i;
    }
    
    public b a(int paramInt)
    {
      this.c = true;
      this.d = paramInt;
      return this;
    }
    
    public b a(boolean paramBoolean)
    {
      this.a = true;
      this.b = paramBoolean;
      return this;
    }
    
    public void a(c paramc)
    {
      if (e()) {
        paramc.a(1, d());
      }
      if (g()) {
        paramc.a(3, f());
      }
      if (i()) {
        paramc.a(4, h());
      }
      if (k()) {
        paramc.a(5, j());
      }
    }
    
    public int b()
    {
      int k = 0;
      if (e()) {
        k = 0 + c.b(1, d());
      }
      int j = k;
      if (g()) {
        j = k + c.c(3, f());
      }
      k = j;
      if (i()) {
        k = j + c.c(4, h());
      }
      j = k;
      if (k()) {
        j = k + c.c(5, j());
      }
      this.i = j;
      return j;
    }
    
    public b b(int paramInt)
    {
      this.e = true;
      this.f = paramInt;
      return this;
    }
    
    public b b(com.google.b.a.b paramb)
    {
      for (;;)
      {
        int j = paramb.a();
        switch (j)
        {
        default: 
          if (a(paramb, j)) {}
          break;
        case 0: 
          return this;
        case 8: 
          a(paramb.f());
          break;
        case 24: 
          a(paramb.e());
          break;
        case 32: 
          b(paramb.e());
          break;
        case 40: 
          c(paramb.e());
        }
      }
    }
    
    public b c(int paramInt)
    {
      this.g = true;
      this.h = paramInt;
      return this;
    }
    
    public boolean d()
    {
      return this.b;
    }
    
    public boolean e()
    {
      return this.a;
    }
    
    public int f()
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
    
    public int j()
    {
      return this.h;
    }
    
    public boolean k()
    {
      return this.g;
    }
  }
  
  public static final class c
    extends e
  {
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private boolean e;
    private String f = "";
    private boolean g;
    private String h = "";
    private boolean i;
    private String j = "";
    private boolean k;
    private String l = "";
    private int m = -1;
    
    public int a()
    {
      if (this.m < 0) {
        b();
      }
      return this.m;
    }
    
    public c a(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public void a(c paramc)
    {
      if (e()) {
        paramc.a(1, d());
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
      if (m()) {
        paramc.a(5, l());
      }
      if (o()) {
        paramc.a(6, n());
      }
    }
    
    public int b()
    {
      int i1 = 0;
      if (e()) {
        i1 = 0 + c.b(1, d());
      }
      int n = i1;
      if (g()) {
        n = i1 + c.b(2, f());
      }
      i1 = n;
      if (i()) {
        i1 = n + c.b(3, h());
      }
      n = i1;
      if (k()) {
        n = i1 + c.b(4, j());
      }
      i1 = n;
      if (m()) {
        i1 = n + c.b(5, l());
      }
      n = i1;
      if (o()) {
        n = i1 + c.b(6, n());
      }
      this.m = n;
      return n;
    }
    
    public c b(com.google.b.a.b paramb)
    {
      for (;;)
      {
        int n = paramb.a();
        switch (n)
        {
        default: 
          if (a(paramb, n)) {}
          break;
        case 0: 
          return this;
        case 10: 
          a(paramb.g());
          break;
        case 18: 
          b(paramb.g());
          break;
        case 26: 
          c(paramb.g());
          break;
        case 34: 
          d(paramb.g());
          break;
        case 42: 
          e(paramb.g());
          break;
        case 50: 
          f(paramb.g());
        }
      }
    }
    
    public c b(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public c c(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public c d(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public String d()
    {
      return this.b;
    }
    
    public c e(String paramString)
    {
      this.i = true;
      this.j = paramString;
      return this;
    }
    
    public boolean e()
    {
      return this.a;
    }
    
    public c f(String paramString)
    {
      this.k = true;
      this.l = paramString;
      return this;
    }
    
    public String f()
    {
      return this.d;
    }
    
    public boolean g()
    {
      return this.c;
    }
    
    public String h()
    {
      return this.f;
    }
    
    public boolean i()
    {
      return this.e;
    }
    
    public String j()
    {
      return this.h;
    }
    
    public boolean k()
    {
      return this.g;
    }
    
    public String l()
    {
      return this.j;
    }
    
    public boolean m()
    {
      return this.i;
    }
    
    public String n()
    {
      return this.l;
    }
    
    public boolean o()
    {
      return this.k;
    }
  }
  
  public static final class d
    extends e
  {
    private boolean a;
    private boolean b = false;
    private boolean c;
    private String d = "";
    private boolean e;
    private String f = "";
    private boolean g;
    private String h = "";
    private int i = -1;
    
    public static d b(byte[] paramArrayOfByte)
    {
      return (d)new d().a(paramArrayOfByte);
    }
    
    public int a()
    {
      if (this.i < 0) {
        b();
      }
      return this.i;
    }
    
    public d a(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public d a(boolean paramBoolean)
    {
      this.a = true;
      this.b = paramBoolean;
      return this;
    }
    
    public void a(c paramc)
    {
      if (e()) {
        paramc.a(1, d());
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
    }
    
    public int b()
    {
      int k = 0;
      if (e()) {
        k = 0 + c.b(1, d());
      }
      int j = k;
      if (g()) {
        j = k + c.b(2, f());
      }
      k = j;
      if (i()) {
        k = j + c.b(3, h());
      }
      j = k;
      if (k()) {
        j = k + c.b(4, j());
      }
      this.i = j;
      return j;
    }
    
    public d b(com.google.b.a.b paramb)
    {
      for (;;)
      {
        int j = paramb.a();
        switch (j)
        {
        default: 
          if (a(paramb, j)) {}
          break;
        case 0: 
          return this;
        case 8: 
          a(paramb.f());
          break;
        case 18: 
          a(paramb.g());
          break;
        case 26: 
          b(paramb.g());
          break;
        case 34: 
          c(paramb.g());
        }
      }
    }
    
    public d b(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public d c(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public boolean d()
    {
      return this.b;
    }
    
    public boolean e()
    {
      return this.a;
    }
    
    public String f()
    {
      return this.d;
    }
    
    public boolean g()
    {
      return this.c;
    }
    
    public String h()
    {
      return this.f;
    }
    
    public boolean i()
    {
      return this.e;
    }
    
    public String j()
    {
      return this.h;
    }
    
    public boolean k()
    {
      return this.g;
    }
  }
  
  public static final class e
    extends e
  {
    private boolean a;
    private int b = 0;
    private boolean c;
    private String d = "";
    private boolean e;
    private String f = "";
    private boolean g;
    private String h = "";
    private boolean i;
    private int j = 0;
    private boolean k;
    private String l = "";
    private boolean m;
    private String n = "";
    private boolean o;
    private String p = "";
    private boolean q;
    private b.b r = null;
    private boolean s;
    private int t = 0;
    private int u = -1;
    
    public int a()
    {
      if (this.u < 0) {
        b();
      }
      return this.u;
    }
    
    public e a(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public e a(b.b paramb)
    {
      if (paramb == null) {
        throw new NullPointerException();
      }
      this.q = true;
      this.r = paramb;
      return this;
    }
    
    public e a(String paramString)
    {
      this.c = true;
      this.d = paramString;
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
      if (m()) {
        paramc.a(5, l());
      }
      if (o()) {
        paramc.a(6, n());
      }
      if (q()) {
        paramc.a(7, p());
      }
      if (s()) {
        paramc.a(8, r());
      }
      if (t()) {
        paramc.a(9, u());
      }
      if (w()) {
        paramc.a(10, v());
      }
    }
    
    public int b()
    {
      int i2 = 0;
      if (e()) {
        i2 = 0 + c.d(1, d());
      }
      int i1 = i2;
      if (g()) {
        i1 = i2 + c.b(2, f());
      }
      i2 = i1;
      if (i()) {
        i2 = i1 + c.b(3, h());
      }
      i1 = i2;
      if (k()) {
        i1 = i2 + c.b(4, j());
      }
      i2 = i1;
      if (m()) {
        i2 = i1 + c.c(5, l());
      }
      i1 = i2;
      if (o()) {
        i1 = i2 + c.b(6, n());
      }
      i2 = i1;
      if (q()) {
        i2 = i1 + c.b(7, p());
      }
      i1 = i2;
      if (s()) {
        i1 = i2 + c.b(8, r());
      }
      i2 = i1;
      if (t()) {
        i2 = i1 + c.b(9, u());
      }
      i1 = i2;
      if (w()) {
        i1 = i2 + c.c(10, v());
      }
      this.u = i1;
      return i1;
    }
    
    public e b(int paramInt)
    {
      this.i = true;
      this.j = paramInt;
      return this;
    }
    
    public e b(com.google.b.a.b paramb)
    {
      for (;;)
      {
        int i1 = paramb.a();
        switch (i1)
        {
        default: 
          if (a(paramb, i1)) {}
          break;
        case 0: 
          return this;
        case 8: 
          a(paramb.i());
          break;
        case 18: 
          a(paramb.g());
          break;
        case 26: 
          b(paramb.g());
          break;
        case 34: 
          c(paramb.g());
          break;
        case 40: 
          b(paramb.e());
          break;
        case 50: 
          d(paramb.g());
          break;
        case 58: 
          e(paramb.g());
          break;
        case 66: 
          f(paramb.g());
          break;
        case 74: 
          b.b localb = new b.b();
          paramb.a(localb);
          a(localb);
          break;
        case 80: 
          c(paramb.e());
        }
      }
    }
    
    public e b(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public e c(int paramInt)
    {
      this.s = true;
      this.t = paramInt;
      return this;
    }
    
    public e c(String paramString)
    {
      this.g = true;
      this.h = paramString;
      return this;
    }
    
    public int d()
    {
      return this.b;
    }
    
    public e d(String paramString)
    {
      this.k = true;
      this.l = paramString;
      return this;
    }
    
    public e e(String paramString)
    {
      this.m = true;
      this.n = paramString;
      return this;
    }
    
    public boolean e()
    {
      return this.a;
    }
    
    public e f(String paramString)
    {
      this.o = true;
      this.p = paramString;
      return this;
    }
    
    public String f()
    {
      return this.d;
    }
    
    public boolean g()
    {
      return this.c;
    }
    
    public String h()
    {
      return this.f;
    }
    
    public boolean i()
    {
      return this.e;
    }
    
    public String j()
    {
      return this.h;
    }
    
    public boolean k()
    {
      return this.g;
    }
    
    public int l()
    {
      return this.j;
    }
    
    public boolean m()
    {
      return this.i;
    }
    
    public String n()
    {
      return this.l;
    }
    
    public boolean o()
    {
      return this.k;
    }
    
    public String p()
    {
      return this.n;
    }
    
    public boolean q()
    {
      return this.m;
    }
    
    public String r()
    {
      return this.p;
    }
    
    public boolean s()
    {
      return this.o;
    }
    
    public boolean t()
    {
      return this.q;
    }
    
    public b.b u()
    {
      return this.r;
    }
    
    public int v()
    {
      return this.t;
    }
    
    public boolean w()
    {
      return this.s;
    }
  }
  
  public static final class f
    extends e
  {
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private boolean e;
    private b.b f = null;
    private int g = -1;
    
    public static f b(byte[] paramArrayOfByte)
    {
      return (f)new f().a(paramArrayOfByte);
    }
    
    public int a()
    {
      if (this.g < 0) {
        b();
      }
      return this.g;
    }
    
    public f a(b.b paramb)
    {
      if (paramb == null) {
        throw new NullPointerException();
      }
      this.e = true;
      this.f = paramb;
      return this;
    }
    
    public f a(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public void a(c paramc)
    {
      if (e()) {
        paramc.a(1, d());
      }
      if (g()) {
        paramc.a(2, f());
      }
      if (h()) {
        paramc.a(3, i());
      }
    }
    
    public int b()
    {
      int j = 0;
      if (e()) {
        j = 0 + c.b(1, d());
      }
      int i = j;
      if (g()) {
        i = j + c.b(2, f());
      }
      j = i;
      if (h()) {
        j = i + c.b(3, i());
      }
      this.g = j;
      return j;
    }
    
    public f b(com.google.b.a.b paramb)
    {
      for (;;)
      {
        int i = paramb.a();
        switch (i)
        {
        default: 
          if (a(paramb, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          a(paramb.g());
          break;
        case 18: 
          b(paramb.g());
          break;
        case 26: 
          b.b localb = new b.b();
          paramb.a(localb);
          a(localb);
        }
      }
    }
    
    public f b(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public String d()
    {
      return this.b;
    }
    
    public boolean e()
    {
      return this.a;
    }
    
    public String f()
    {
      return this.d;
    }
    
    public boolean g()
    {
      return this.c;
    }
    
    public boolean h()
    {
      return this.e;
    }
    
    public b.b i()
    {
      return this.f;
    }
  }
  
  public static final class g
    extends e
  {
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private boolean e;
    private String f = "";
    private int g = -1;
    
    public static g b(byte[] paramArrayOfByte)
    {
      return (g)new g().a(paramArrayOfByte);
    }
    
    public int a()
    {
      if (this.g < 0) {
        b();
      }
      return this.g;
    }
    
    public g a(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public void a(c paramc)
    {
      if (e()) {
        paramc.a(1, d());
      }
      if (g()) {
        paramc.a(2, f());
      }
      if (i()) {
        paramc.a(3, h());
      }
    }
    
    public int b()
    {
      int j = 0;
      if (e()) {
        j = 0 + c.b(1, d());
      }
      int i = j;
      if (g()) {
        i = j + c.b(2, f());
      }
      j = i;
      if (i()) {
        j = i + c.b(3, h());
      }
      this.g = j;
      return j;
    }
    
    public g b(com.google.b.a.b paramb)
    {
      for (;;)
      {
        int i = paramb.a();
        switch (i)
        {
        default: 
          if (a(paramb, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          a(paramb.g());
          break;
        case 18: 
          b(paramb.g());
          break;
        case 26: 
          c(paramb.g());
        }
      }
    }
    
    public g b(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public g c(String paramString)
    {
      this.e = true;
      this.f = paramString;
      return this;
    }
    
    public String d()
    {
      return this.b;
    }
    
    public boolean e()
    {
      return this.a;
    }
    
    public String f()
    {
      return this.d;
    }
    
    public boolean g()
    {
      return this.c;
    }
    
    public String h()
    {
      return this.f;
    }
    
    public boolean i()
    {
      return this.e;
    }
  }
  
  public static final class h
    extends e
  {
    private boolean a;
    private int b = 0;
    private boolean c;
    private String d = "";
    private int e = -1;
    
    public static h b(byte[] paramArrayOfByte)
    {
      return (h)new h().a(paramArrayOfByte);
    }
    
    public int a()
    {
      if (this.e < 0) {
        b();
      }
      return this.e;
    }
    
    public h a(int paramInt)
    {
      this.a = true;
      this.b = paramInt;
      return this;
    }
    
    public h a(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public void a(c paramc)
    {
      if (e()) {
        paramc.a(1, d());
      }
      if (g()) {
        paramc.a(2, f());
      }
    }
    
    public int b()
    {
      int i = 0;
      if (e()) {
        i = 0 + c.c(1, d());
      }
      int j = i;
      if (g()) {
        j = i + c.b(2, f());
      }
      this.e = j;
      return j;
    }
    
    public h b(com.google.b.a.b paramb)
    {
      for (;;)
      {
        int i = paramb.a();
        switch (i)
        {
        default: 
          if (a(paramb, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          a(paramb.e());
          break;
        case 18: 
          a(paramb.g());
        }
      }
    }
    
    public int d()
    {
      return this.b;
    }
    
    public boolean e()
    {
      return this.a;
    }
    
    public String f()
    {
      return this.d;
    }
    
    public boolean g()
    {
      return this.c;
    }
  }
  
  public static final class i
    extends e
  {
    private boolean a;
    private a b = a.a;
    private int c = -1;
    
    public static i b(byte[] paramArrayOfByte)
    {
      return (i)new i().a(paramArrayOfByte);
    }
    
    public int a()
    {
      if (this.c < 0) {
        b();
      }
      return this.c;
    }
    
    public i a(a parama)
    {
      this.a = true;
      this.b = parama;
      return this;
    }
    
    public void a(c paramc)
    {
      if (e()) {
        paramc.a(1, d());
      }
    }
    
    public int b()
    {
      int i = 0;
      if (e()) {
        i = 0 + c.b(1, d());
      }
      this.c = i;
      return i;
    }
    
    public i b(com.google.b.a.b paramb)
    {
      for (;;)
      {
        int i = paramb.a();
        switch (i)
        {
        default: 
          if (a(paramb, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          a(paramb.h());
        }
      }
    }
    
    public a d()
    {
      return this.b;
    }
    
    public boolean e()
    {
      return this.a;
    }
  }
  
  public static final class j
    extends e
  {
    private boolean a;
    private a b = a.a;
    private boolean c;
    private b.b d = null;
    private int e = -1;
    
    public static j b(byte[] paramArrayOfByte)
    {
      return (j)new j().a(paramArrayOfByte);
    }
    
    public int a()
    {
      if (this.e < 0) {
        b();
      }
      return this.e;
    }
    
    public j a(a parama)
    {
      this.a = true;
      this.b = parama;
      return this;
    }
    
    public j a(b.b paramb)
    {
      if (paramb == null) {
        throw new NullPointerException();
      }
      this.c = true;
      this.d = paramb;
      return this;
    }
    
    public void a(c paramc)
    {
      if (e()) {
        paramc.a(1, d());
      }
      if (f()) {
        paramc.a(2, g());
      }
    }
    
    public int b()
    {
      int i = 0;
      if (e()) {
        i = 0 + c.b(1, d());
      }
      int j = i;
      if (f()) {
        j = i + c.b(2, g());
      }
      this.e = j;
      return j;
    }
    
    public j b(com.google.b.a.b paramb)
    {
      for (;;)
      {
        int i = paramb.a();
        switch (i)
        {
        default: 
          if (a(paramb, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          a(paramb.h());
          break;
        case 18: 
          b.b localb = new b.b();
          paramb.a(localb);
          a(localb);
        }
      }
    }
    
    public a d()
    {
      return this.b;
    }
    
    public boolean e()
    {
      return this.a;
    }
    
    public boolean f()
    {
      return this.c;
    }
    
    public b.b g()
    {
      return this.d;
    }
  }
  
  public static final class k
    extends e
  {
    private boolean a;
    private String b = "";
    private boolean c;
    private String d = "";
    private boolean e;
    private long f = 0L;
    private boolean g;
    private long h = 0L;
    private boolean i;
    private boolean j = false;
    private boolean k;
    private int l = 0;
    private int m = -1;
    
    public static k b(byte[] paramArrayOfByte)
    {
      return (k)new k().a(paramArrayOfByte);
    }
    
    public int a()
    {
      if (this.m < 0) {
        b();
      }
      return this.m;
    }
    
    public k a(int paramInt)
    {
      this.k = true;
      this.l = paramInt;
      return this;
    }
    
    public k a(long paramLong)
    {
      this.e = true;
      this.f = paramLong;
      return this;
    }
    
    public k a(String paramString)
    {
      this.a = true;
      this.b = paramString;
      return this;
    }
    
    public k a(boolean paramBoolean)
    {
      this.i = true;
      this.j = paramBoolean;
      return this;
    }
    
    public void a(c paramc)
    {
      if (e()) {
        paramc.a(1, d());
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
      if (m()) {
        paramc.a(5, l());
      }
      if (o()) {
        paramc.a(6, n());
      }
    }
    
    public int b()
    {
      int i1 = 0;
      if (e()) {
        i1 = 0 + c.b(1, d());
      }
      int n = i1;
      if (g()) {
        n = i1 + c.b(2, f());
      }
      i1 = n;
      if (i()) {
        i1 = n + c.c(3, h());
      }
      n = i1;
      if (k()) {
        n = i1 + c.c(4, j());
      }
      i1 = n;
      if (m()) {
        i1 = n + c.b(5, l());
      }
      n = i1;
      if (o()) {
        n = i1 + c.c(6, n());
      }
      this.m = n;
      return n;
    }
    
    public k b(long paramLong)
    {
      this.g = true;
      this.h = paramLong;
      return this;
    }
    
    public k b(com.google.b.a.b paramb)
    {
      for (;;)
      {
        int n = paramb.a();
        switch (n)
        {
        default: 
          if (a(paramb, n)) {}
          break;
        case 0: 
          return this;
        case 10: 
          a(paramb.g());
          break;
        case 18: 
          b(paramb.g());
          break;
        case 24: 
          a(paramb.c());
          break;
        case 32: 
          b(paramb.c());
          break;
        case 40: 
          a(paramb.f());
          break;
        case 48: 
          a(paramb.e());
        }
      }
    }
    
    public k b(String paramString)
    {
      this.c = true;
      this.d = paramString;
      return this;
    }
    
    public String d()
    {
      return this.b;
    }
    
    public boolean e()
    {
      return this.a;
    }
    
    public String f()
    {
      return this.d;
    }
    
    public boolean g()
    {
      return this.c;
    }
    
    public long h()
    {
      return this.f;
    }
    
    public boolean i()
    {
      return this.e;
    }
    
    public long j()
    {
      return this.h;
    }
    
    public boolean k()
    {
      return this.g;
    }
    
    public boolean l()
    {
      return this.j;
    }
    
    public boolean m()
    {
      return this.i;
    }
    
    public int n()
    {
      return this.l;
    }
    
    public boolean o()
    {
      return this.k;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/push/protobuf/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */