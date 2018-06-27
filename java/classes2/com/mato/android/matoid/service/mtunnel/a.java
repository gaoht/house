package com.mato.android.matoid.service.mtunnel;

import com.google.a.c;
import com.google.a.d;
import com.google.a.e;
import com.google.a.g;
import java.io.IOException;
import java.io.InputStream;

public final class a
{
  public static void a() {}
  
  public static final class a
    extends e
  {
    public static final a a = new a(0, "BYPASS");
    public static final a b = new a(1, "HTTP");
    public static final a c = new a(2, "WSP_TCP_1");
    public static final a d = new a(3, "WSP_TCP_3");
    public static final a e = new a(4, "WSP_TCP_5");
    public static final a f = new a(5, "WSP_UDP_1");
    public static final a g = new a(6, "WSP_UDP_3");
    public static final a h = new a(7, "WSP_UDP_5");
    public static final a i = new a(8, "DIRECT");
    public static final a j = new a(9, "REJECT");
    public static final a k = new a(10, "DIRECT_WMP");
    private static int l = 0;
    private static int m = 1;
    private static int n = 2;
    private static int o = 3;
    private static int p = 4;
    private static int q = 5;
    private static int r = 6;
    private static int s = 7;
    private static int t = 8;
    private static int u = 9;
    private static int v = 10;
    private static a[] w = { a, b, c, d, e, f, g, h, i, j, k };
    
    private a(int paramInt, String paramString)
    {
      super(paramString);
    }
    
    public static a b(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException(Integer.toString(paramInt));
      case 0: 
        return a;
      case 1: 
        return b;
      case 2: 
        return c;
      case 3: 
        return d;
      case 4: 
        return e;
      case 5: 
        return f;
      case 6: 
        return g;
      case 7: 
        return h;
      case 8: 
        return i;
      case 9: 
        return j;
      }
      return k;
    }
    
    private static a[] b()
    {
      return w;
    }
    
    public final e a(int paramInt)
    {
      return b(paramInt);
    }
  }
  
  public static final class b
    extends e
  {
    private static int a = 0;
    private static b b = new b(0, "NORMAL");
    private static int c = 1;
    private static b d = new b(1, "NET_DETECT_AUTO");
    private static int e = 2;
    private static b f = new b(2, "NET_DETECT_MANUAL");
    private static int g = 100;
    private static b h = new b(100, "THIRD_PARTY_TEST");
    private static int i = 199;
    private static b j = new b(199, "THIRD_PARTY_TEST_MAX");
    private static b[] k = { b, d, f, h, j };
    
    private b(int paramInt, String paramString)
    {
      super(paramString);
    }
    
    private static b b(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException(Integer.toString(paramInt));
      case 0: 
        return b;
      case 1: 
        return d;
      case 2: 
        return f;
      case 100: 
        return h;
      }
      return j;
    }
    
    private static b[] b()
    {
      return k;
    }
    
    public final e a(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException(Integer.toString(paramInt));
      case 0: 
        return b;
      case 1: 
        return d;
      case 2: 
        return f;
      case 100: 
        return h;
      }
      return j;
    }
  }
  
  public static final class c
    extends e
  {
    public static final c a = new c(0, "NONE");
    public static final c b = new c(1, "LOW");
    public static final c c = new c(2, "MEDIUM");
    public static final c d = new c(3, "HIGH");
    public static final c e = new c(4, "LOSSLESS");
    private static int f = 0;
    private static int g = 1;
    private static int h = 2;
    private static int i = 3;
    private static int j = 4;
    private static c[] k = { a, b, c, d, e };
    
    private c(int paramInt, String paramString)
    {
      super(paramString);
    }
    
    public static c b(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException(Integer.toString(paramInt));
      case 0: 
        return a;
      case 1: 
        return b;
      case 2: 
        return c;
      case 3: 
        return d;
      }
      return e;
    }
    
    private static c[] b()
    {
      return k;
    }
    
    public final e a(int paramInt)
    {
      return b(paramInt);
    }
  }
  
  public static final class d
    extends e
  {
    private static int a = 1;
    private static d b = new d(1, "QUERY_A");
    private static int c = 2;
    private static d d = new d(2, "QUERY_4A");
    private static int e = 3;
    private static d f = new d(3, "QUERY_A_4A");
    private static d[] g = { b, d, f };
    
    private d(int paramInt, String paramString)
    {
      super(paramString);
    }
    
    private static d b(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException(Integer.toString(paramInt));
      case 1: 
        return b;
      case 2: 
        return d;
      }
      return f;
    }
    
    private static d[] b()
    {
      return g;
    }
    
    public final e a(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException(Integer.toString(paramInt));
      case 1: 
        return b;
      case 2: 
        return d;
      }
      return f;
    }
  }
  
  public static final class e
    extends e
  {
    public static final e a = new e(0, "PROTO_NONE");
    public static final e b = new e(1, "PROTO_HTTPS");
    public static final e c = new e(2, "PROTO_TCP");
    public static final e d = new e(3, "PROTO_HTTPS_TCP");
    private static int e = 0;
    private static int f = 1;
    private static int g = 2;
    private static int h = 3;
    private static e[] i = { a, b, c, d };
    
    private e(int paramInt, String paramString)
    {
      super(paramString);
    }
    
    public static e b(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException(Integer.toString(paramInt));
      case 0: 
        return a;
      case 1: 
        return b;
      case 2: 
        return c;
      }
      return d;
    }
    
    private static e[] b()
    {
      return i;
    }
    
    public final e a(int paramInt)
    {
      return b(paramInt);
    }
  }
  
  public static final class f
    extends e
  {
    public static final f a;
    public static final f b = new f(3, "LOG_ERROR");
    private static int c = 0;
    private static f d = new f(0, "LOG_DEBUG");
    private static int e = 1;
    private static int f = 2;
    private static f g;
    private static int h = 3;
    private static int i = 4;
    private static f j = new f(4, "LOG_FATAL");
    private static int k = 5;
    private static f l = new f(5, "LOG_NONE");
    private static f[] m = { d, a, g, b, j, l };
    
    static
    {
      a = new f(1, "LOG_INFO");
      g = new f(2, "LOG_WARNING");
    }
    
    private f(int paramInt, String paramString)
    {
      super(paramString);
    }
    
    public static f b(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException(Integer.toString(paramInt));
      case 0: 
        return d;
      case 1: 
        return a;
      case 2: 
        return g;
      case 3: 
        return b;
      case 4: 
        return j;
      }
      return l;
    }
    
    private static f[] b()
    {
      return m;
    }
    
    public final e a(int paramInt)
    {
      return b(paramInt);
    }
  }
  
  public static final class g
    extends e
  {
    private static int a = 0;
    private static g b = new g(0, "NDK_EVENT_NET_DIAGNOSIS");
    private static int c = 1;
    private static g d = new g(1, "NDK_EVENT_GET_MAA_NODE_INFO");
    private static int e = 2;
    private static g f = new g(2, "NDK_EVENT_THIRD_PARTY_TEST");
    private static int g = 3;
    private static g h = new g(3, "NDK_EVENT_GET_DNS_QUERY_TYPE");
    private static g[] i = { b, d, f, h };
    
    private g(int paramInt, String paramString)
    {
      super(paramString);
    }
    
    private static g b(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException(Integer.toString(paramInt));
      case 0: 
        return b;
      case 1: 
        return d;
      case 2: 
        return f;
      }
      return h;
    }
    
    private static g[] b()
    {
      return i;
    }
    
    public final e a(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException(Integer.toString(paramInt));
      case 0: 
        return b;
      case 1: 
        return d;
      case 2: 
        return f;
      }
      return h;
    }
  }
  
  public static final class h
    extends e
  {
    private static int a = 0;
    private static h b = new h(0, "NDK_INFO");
    private static int c = 1;
    private static h d = new h(1, "NDK_WARNING");
    private static int e = 2;
    private static h f = new h(2, "NDK_ERROR");
    private static int g = 3;
    private static h h = new h(3, "NDK_FATAL");
    private static int i = 4;
    private static h j = new h(4, "NDK_NONE");
    private static h[] k = { b, d, f, h, j };
    
    private h(int paramInt, String paramString)
    {
      super(paramString);
    }
    
    private static h b(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException(Integer.toString(paramInt));
      case 0: 
        return b;
      case 1: 
        return d;
      case 2: 
        return f;
      case 3: 
        return h;
      }
      return j;
    }
    
    private static h[] b()
    {
      return k;
    }
    
    public final e a(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException(Integer.toString(paramInt));
      case 0: 
        return b;
      case 1: 
        return d;
      case 2: 
        return f;
      case 3: 
        return h;
      }
      return j;
    }
  }
  
  public static final class i
    extends e
  {
    public static final i a = new i(0, "MATCH_TYPE_HOST");
    public static final i b = new i(1, "MATCH_TYPE_PATH");
    public static final i c = new i(2, "MATCH_TYPE_PARAMETER");
    private static int d = 0;
    private static int e = 1;
    private static int f = 2;
    private static i[] g = { a, b, c };
    
    private i(int paramInt, String paramString)
    {
      super(paramString);
    }
    
    public static i b(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException(Integer.toString(paramInt));
      case 0: 
        return a;
      case 1: 
        return b;
      }
      return c;
    }
    
    private static i[] b()
    {
      return g;
    }
    
    public final e a(int paramInt)
    {
      return b(paramInt);
    }
  }
  
  public static final class j
    extends g
  {
    private static final j c;
    private a.f A;
    private String B = "";
    private String[] C = new String[0];
    private int D;
    private boolean E = false;
    private String F = "";
    private int G = 8081;
    private String H = "";
    private String I = "";
    private String J = "";
    private String[] K = new String[0];
    private int L;
    private String[] M = new String[0];
    private int N;
    private int[] O = new int[0];
    private int P;
    private a.a[] Q = new a.a[0];
    private int R;
    private String[] S = new String[0];
    private int T;
    private a.e[] U = new a.e[0];
    private int V;
    private String[] W = new String[0];
    private int X;
    private boolean[] Y = new boolean[0];
    private int Z;
    private int a;
    private a.i[] aa = new a.i[0];
    private int ab;
    private String[] ac = new String[0];
    private int ad;
    private String[] ae = new String[0];
    private int af;
    private int[] ag = new int[0];
    private int ah;
    private boolean ai = false;
    private int aj = 2000;
    private String ak = "";
    private int[] al = new int[0];
    private int am;
    private a.c[] an = new a.c[0];
    private int ao;
    private int[] ap = new int[0];
    private int aq;
    private boolean[] ar = new boolean[0];
    private int as;
    private boolean[] at = new boolean[0];
    private int au;
    private a.k[] av = new a.k[0];
    private int aw;
    private int b;
    private a.l d;
    private String e = "";
    private int f = 0;
    private String g = "";
    private String h = "";
    private String i = "";
    private String j = "";
    private boolean k = false;
    private int l = 16;
    private boolean m = true;
    private boolean n = false;
    private boolean o = true;
    private a.k p;
    private a.c q;
    private boolean r = false;
    private int s = 100;
    private int t = 0;
    private String[] u = new String[0];
    private int v;
    private int w = 0;
    private boolean x = true;
    private boolean y = false;
    private String z = "";
    
    static
    {
      j localj = new j((byte)0);
      c = localj;
      localj.ch();
    }
    
    public j()
    {
      super();
      ch();
    }
    
    private j(byte paramByte) {}
    
    private void A(int paramInt)
    {
      if (paramInt >= this.U.length)
      {
        a.e[] arrayOfe = new a.e[paramInt];
        System.arraycopy(this.U, 0, arrayOfe, 0, this.V);
        this.U = arrayOfe;
      }
    }
    
    private boolean A()
    {
      return (this.a & 0x20) != 0;
    }
    
    private String B(int paramInt)
    {
      return this.W[paramInt];
    }
    
    private void B()
    {
      a();
      this.a &= 0xFFFFFFDF;
      this.i = "";
    }
    
    private String C()
    {
      return this.j;
    }
    
    private void C(int paramInt)
    {
      if (paramInt >= this.W.length)
      {
        String[] arrayOfString = new String[paramInt];
        System.arraycopy(this.W, 0, arrayOfString, 0, this.X);
        this.W = arrayOfString;
      }
    }
    
    private boolean D()
    {
      return (this.a & 0x40) != 0;
    }
    
    private boolean D(int paramInt)
    {
      return this.Y[paramInt];
    }
    
    private void E()
    {
      a();
      this.a &= 0xFFFFFFBF;
      this.j = "";
    }
    
    private void E(int paramInt)
    {
      if (paramInt >= this.Y.length)
      {
        boolean[] arrayOfBoolean = new boolean[paramInt];
        System.arraycopy(this.Y, 0, arrayOfBoolean, 0, this.Z);
        this.Y = arrayOfBoolean;
      }
    }
    
    private a.i F(int paramInt)
    {
      return this.aa[paramInt];
    }
    
    private boolean F()
    {
      return this.k;
    }
    
    private void G(int paramInt)
    {
      if (paramInt >= this.aa.length)
      {
        a.i[] arrayOfi = new a.i[paramInt];
        System.arraycopy(this.aa, 0, arrayOfi, 0, this.ab);
        this.aa = arrayOfi;
      }
    }
    
    private boolean G()
    {
      return (this.a & 0x80) != 0;
    }
    
    private String H(int paramInt)
    {
      return this.ac[paramInt];
    }
    
    private void H()
    {
      a();
      this.a &= 0xFF7F;
      this.k = false;
    }
    
    private int I()
    {
      return this.l;
    }
    
    private void I(int paramInt)
    {
      if (paramInt >= this.ac.length)
      {
        String[] arrayOfString = new String[paramInt];
        System.arraycopy(this.ac, 0, arrayOfString, 0, this.ad);
        this.ac = arrayOfString;
      }
    }
    
    private String J(int paramInt)
    {
      return this.ae[paramInt];
    }
    
    private boolean J()
    {
      return (this.a & 0x100) != 0;
    }
    
    private void K()
    {
      a();
      this.a &= 0xFEFF;
      this.l = 16;
    }
    
    private void K(int paramInt)
    {
      if (paramInt >= this.ae.length)
      {
        String[] arrayOfString = new String[paramInt];
        System.arraycopy(this.ae, 0, arrayOfString, 0, this.af);
        this.ae = arrayOfString;
      }
    }
    
    private int L(int paramInt)
    {
      return this.ag[paramInt];
    }
    
    private boolean L()
    {
      return this.m;
    }
    
    private void M(int paramInt)
    {
      if (paramInt >= this.ag.length)
      {
        int[] arrayOfInt = new int[paramInt];
        System.arraycopy(this.ag, 0, arrayOfInt, 0, this.ah);
        this.ag = arrayOfInt;
      }
    }
    
    private boolean M()
    {
      return (this.a & 0x200) != 0;
    }
    
    private int N(int paramInt)
    {
      return this.al[paramInt];
    }
    
    private void N()
    {
      a();
      this.a &= 0xFDFF;
      this.m = true;
    }
    
    private void O(int paramInt)
    {
      if (paramInt >= this.al.length)
      {
        int[] arrayOfInt = new int[paramInt];
        System.arraycopy(this.al, 0, arrayOfInt, 0, this.am);
        this.al = arrayOfInt;
      }
    }
    
    private boolean O()
    {
      return this.n;
    }
    
    private a.c P(int paramInt)
    {
      return this.an[paramInt];
    }
    
    private boolean P()
    {
      return (this.a & 0x400) != 0;
    }
    
    private void Q()
    {
      a();
      this.a &= 0xFBFF;
      this.n = false;
    }
    
    private void Q(int paramInt)
    {
      if (paramInt >= this.an.length)
      {
        a.c[] arrayOfc = new a.c[paramInt];
        System.arraycopy(this.an, 0, arrayOfc, 0, this.ao);
        this.an = arrayOfc;
      }
    }
    
    private int R(int paramInt)
    {
      return this.ap[paramInt];
    }
    
    private boolean R()
    {
      return (this.a & 0x800) != 0;
    }
    
    private void S()
    {
      a();
      this.a &= 0xF7FF;
      this.o = true;
    }
    
    private void S(int paramInt)
    {
      if (paramInt >= this.ap.length)
      {
        int[] arrayOfInt = new int[paramInt];
        System.arraycopy(this.ap, 0, arrayOfInt, 0, this.aq);
        this.ap = arrayOfInt;
      }
    }
    
    private boolean T()
    {
      return (this.a & 0x1000) != 0;
    }
    
    private boolean T(int paramInt)
    {
      return this.ar[paramInt];
    }
    
    private void U()
    {
      a();
      this.a &= 0xEFFF;
      this.p = a.k.a;
    }
    
    private void U(int paramInt)
    {
      if (paramInt >= this.ar.length)
      {
        boolean[] arrayOfBoolean = new boolean[paramInt];
        System.arraycopy(this.ar, 0, arrayOfBoolean, 0, this.as);
        this.ar = arrayOfBoolean;
      }
    }
    
    private boolean V()
    {
      return (this.a & 0x2000) != 0;
    }
    
    private boolean V(int paramInt)
    {
      return this.at[paramInt];
    }
    
    private void W()
    {
      a();
      this.a &= 0xDFFF;
      this.q = a.c.c;
    }
    
    private void W(int paramInt)
    {
      if (paramInt >= this.at.length)
      {
        boolean[] arrayOfBoolean = new boolean[paramInt];
        System.arraycopy(this.at, 0, arrayOfBoolean, 0, this.au);
        this.at = arrayOfBoolean;
      }
    }
    
    private a.k X(int paramInt)
    {
      return this.av[paramInt];
    }
    
    private boolean X()
    {
      return this.r;
    }
    
    private void Y(int paramInt)
    {
      if (paramInt >= this.av.length)
      {
        a.k[] arrayOfk = new a.k[paramInt];
        System.arraycopy(this.av, 0, arrayOfk, 0, this.aw);
        this.av = arrayOfk;
      }
    }
    
    private boolean Y()
    {
      return (this.a & 0x4000) != 0;
    }
    
    private void Z()
    {
      a();
      this.a &= 0xBFFF;
      this.r = false;
    }
    
    private static j a(InputStream paramInputStream)
      throws IOException
    {
      paramInputStream = c.a(paramInputStream);
      j localj = new j();
      localj.a(paramInputStream);
      return localj;
    }
    
    private void a(int paramInt1, int paramInt2)
    {
      a();
      String str = this.u[paramInt1];
      this.u[paramInt1] = this.u[paramInt2];
      this.u[paramInt2] = str;
    }
    
    private void a(int paramInt, a.a parama)
    {
      a();
      this.Q[paramInt] = parama;
    }
    
    private void a(int paramInt, a.c paramc)
    {
      a();
      this.an[paramInt] = paramc;
    }
    
    private void a(int paramInt, a.e parame)
    {
      a();
      this.U[paramInt] = parame;
    }
    
    private void a(int paramInt, a.i parami)
    {
      a();
      this.aa[paramInt] = parami;
    }
    
    private void a(int paramInt, a.k paramk)
    {
      a();
      this.av[paramInt] = paramk;
    }
    
    private void a(int paramInt, String paramString)
    {
      a();
      this.u[paramInt] = paramString;
    }
    
    private void a(int paramInt, boolean paramBoolean)
    {
      a();
      this.Y[paramInt] = paramBoolean;
    }
    
    private void aA()
    {
      a();
      this.a &= 0xFF7FFFFF;
      this.B = "";
    }
    
    private int aB()
    {
      return this.D;
    }
    
    private void aC()
    {
      a();
      if (this.D > 0)
      {
        String[] arrayOfString = this.C;
        int i1 = this.D;
        this.D = (i1 - 1);
        arrayOfString[i1] = "";
      }
    }
    
    private void aD()
    {
      a();
      while (this.D > 0)
      {
        String[] arrayOfString = this.C;
        int i1 = this.D;
        this.D = (i1 - 1);
        arrayOfString[i1] = "";
      }
    }
    
    private boolean aE()
    {
      return this.E;
    }
    
    private boolean aF()
    {
      return (this.a & 0x2000000) != 0;
    }
    
    private void aG()
    {
      a();
      this.a &= 0xFDFFFFFF;
      this.E = false;
    }
    
    private String aH()
    {
      return this.F;
    }
    
    private boolean aI()
    {
      return (this.a & 0x4000000) != 0;
    }
    
    private void aJ()
    {
      a();
      this.a &= 0xFBFFFFFF;
      this.F = "";
    }
    
    private int aK()
    {
      return this.G;
    }
    
    private boolean aL()
    {
      return (this.a & 0x8000000) != 0;
    }
    
    private void aM()
    {
      a();
      this.a &= 0xF7FFFFFF;
      this.G = 8081;
    }
    
    private String aN()
    {
      return this.H;
    }
    
    private boolean aO()
    {
      return (this.a & 0x10000000) != 0;
    }
    
    private void aP()
    {
      a();
      this.a &= 0xEFFFFFFF;
      this.H = "";
    }
    
    private String aQ()
    {
      return this.I;
    }
    
    private boolean aR()
    {
      return (this.a & 0x20000000) != 0;
    }
    
    private void aS()
    {
      a();
      this.a &= 0xDFFFFFFF;
      this.I = "";
    }
    
    private String aT()
    {
      return this.J;
    }
    
    private boolean aU()
    {
      return (this.a & 0x40000000) != 0;
    }
    
    private void aV()
    {
      a();
      this.a &= 0xBFFFFFFF;
      this.J = "";
    }
    
    private int aW()
    {
      return this.L;
    }
    
    private void aX()
    {
      a();
      if (this.L > 0)
      {
        String[] arrayOfString = this.K;
        int i1 = this.L;
        this.L = (i1 - 1);
        arrayOfString[i1] = "";
      }
    }
    
    private void aY()
    {
      a();
      while (this.L > 0)
      {
        String[] arrayOfString = this.K;
        int i1 = this.L;
        this.L = (i1 - 1);
        arrayOfString[i1] = "";
      }
    }
    
    private int aZ()
    {
      return this.N;
    }
    
    private int aa()
    {
      return this.s;
    }
    
    private boolean ab()
    {
      return (this.a & 0x8000) != 0;
    }
    
    private void ac()
    {
      a();
      this.a &= 0xFFFF7FFF;
      this.s = 100;
    }
    
    private int ad()
    {
      return this.t;
    }
    
    private boolean ae()
    {
      return (this.a & 0x10000) != 0;
    }
    
    private void af()
    {
      a();
      this.a &= 0xFFFEFFFF;
      this.t = 0;
    }
    
    private int ag()
    {
      return this.v;
    }
    
    private void ah()
    {
      a();
      if (this.v > 0)
      {
        String[] arrayOfString = this.u;
        int i1 = this.v;
        this.v = (i1 - 1);
        arrayOfString[i1] = "";
      }
    }
    
    private void ai()
    {
      a();
      while (this.v > 0)
      {
        String[] arrayOfString = this.u;
        int i1 = this.v;
        this.v = (i1 - 1);
        arrayOfString[i1] = "";
      }
    }
    
    private int aj()
    {
      return this.w;
    }
    
    private boolean ak()
    {
      return (this.a & 0x40000) != 0;
    }
    
    private void al()
    {
      a();
      this.a &= 0xFFFBFFFF;
      this.w = 0;
    }
    
    private boolean am()
    {
      return this.x;
    }
    
    private boolean an()
    {
      return (this.a & 0x80000) != 0;
    }
    
    private void ao()
    {
      a();
      this.a &= 0xFFF7FFFF;
      this.x = true;
    }
    
    private boolean ap()
    {
      return this.y;
    }
    
    private boolean aq()
    {
      return (this.a & 0x100000) != 0;
    }
    
    private void ar()
    {
      a();
      this.a &= 0xFFEFFFFF;
      this.y = false;
    }
    
    private String as()
    {
      return this.z;
    }
    
    private boolean at()
    {
      return (this.a & 0x200000) != 0;
    }
    
    private void au()
    {
      a();
      this.a &= 0xFFDFFFFF;
      this.z = "";
    }
    
    private a.f av()
    {
      return this.A;
    }
    
    private boolean aw()
    {
      return (this.a & 0x400000) != 0;
    }
    
    private void ax()
    {
      a();
      this.a &= 0xFFBFFFFF;
      this.A = a.f.b;
    }
    
    private String ay()
    {
      return this.B;
    }
    
    private boolean az()
    {
      return (this.a & 0x800000) != 0;
    }
    
    private static j b(c paramc)
      throws IOException
    {
      j localj = new j();
      localj.a(paramc);
      return localj;
    }
    
    private void b(int paramInt1, int paramInt2)
    {
      a();
      String str = this.C[paramInt1];
      this.C[paramInt1] = this.C[paramInt2];
      this.C[paramInt2] = str;
    }
    
    private void b(int paramInt, String paramString)
    {
      a();
      this.C[paramInt] = paramString;
    }
    
    private void b(int paramInt, boolean paramBoolean)
    {
      a();
      this.ar[paramInt] = paramBoolean;
    }
    
    private int bA()
    {
      return this.af;
    }
    
    private void bB()
    {
      a();
      if (this.af > 0)
      {
        String[] arrayOfString = this.ae;
        int i1 = this.af;
        this.af = (i1 - 1);
        arrayOfString[i1] = "";
      }
    }
    
    private void bC()
    {
      a();
      while (this.af > 0)
      {
        String[] arrayOfString = this.ae;
        int i1 = this.af;
        this.af = (i1 - 1);
        arrayOfString[i1] = "";
      }
    }
    
    private int bD()
    {
      return this.ah;
    }
    
    private void bE()
    {
      a();
      if (this.ah > 0)
      {
        int[] arrayOfInt = this.ag;
        int i1 = this.ah;
        this.ah = (i1 - 1);
        arrayOfInt[i1] = 0;
      }
    }
    
    private void bF()
    {
      a();
      while (this.ah > 0)
      {
        int[] arrayOfInt = this.ag;
        int i1 = this.ah;
        this.ah = (i1 - 1);
        arrayOfInt[i1] = 0;
      }
    }
    
    private boolean bG()
    {
      return this.ai;
    }
    
    private boolean bH()
    {
      return (this.b & 0x800) != 0;
    }
    
    private void bI()
    {
      a();
      this.b &= 0xF7FF;
      this.ai = false;
    }
    
    private int bJ()
    {
      return this.aj;
    }
    
    private boolean bK()
    {
      return (this.b & 0x1000) != 0;
    }
    
    private void bL()
    {
      a();
      this.b &= 0xEFFF;
      this.aj = 2000;
    }
    
    private String bM()
    {
      return this.ak;
    }
    
    private boolean bN()
    {
      return (this.b & 0x2000) != 0;
    }
    
    private void bO()
    {
      a();
      this.b &= 0xDFFF;
      this.ak = "";
    }
    
    private int bP()
    {
      return this.am;
    }
    
    private void bQ()
    {
      a();
      if (this.am > 0)
      {
        int[] arrayOfInt = this.al;
        int i1 = this.am;
        this.am = (i1 - 1);
        arrayOfInt[i1] = 0;
      }
    }
    
    private void bR()
    {
      a();
      while (this.am > 0)
      {
        int[] arrayOfInt = this.al;
        int i1 = this.am;
        this.am = (i1 - 1);
        arrayOfInt[i1] = 0;
      }
    }
    
    private int bS()
    {
      return this.ao;
    }
    
    private void bT()
    {
      a();
      if (this.ao > 0)
      {
        a.c[] arrayOfc = this.an;
        int i1 = this.ao;
        this.ao = (i1 - 1);
        arrayOfc[i1] = a.c.a;
      }
    }
    
    private void bU()
    {
      a();
      while (this.ao > 0)
      {
        a.c[] arrayOfc = this.an;
        int i1 = this.ao;
        this.ao = (i1 - 1);
        arrayOfc[i1] = a.c.a;
      }
    }
    
    private int bV()
    {
      return this.aq;
    }
    
    private void bW()
    {
      a();
      if (this.aq > 0)
      {
        int[] arrayOfInt = this.ap;
        int i1 = this.aq;
        this.aq = (i1 - 1);
        arrayOfInt[i1] = 0;
      }
    }
    
    private void bX()
    {
      a();
      while (this.aq > 0)
      {
        int[] arrayOfInt = this.ap;
        int i1 = this.aq;
        this.aq = (i1 - 1);
        arrayOfInt[i1] = 0;
      }
    }
    
    private int bY()
    {
      return this.as;
    }
    
    private void bZ()
    {
      a();
      if (this.as > 0)
      {
        boolean[] arrayOfBoolean = this.ar;
        int i1 = this.as;
        this.as = (i1 - 1);
        arrayOfBoolean[i1] = false;
      }
    }
    
    private void ba()
    {
      a();
      if (this.N > 0)
      {
        String[] arrayOfString = this.M;
        int i1 = this.N;
        this.N = (i1 - 1);
        arrayOfString[i1] = "";
      }
    }
    
    private void bb()
    {
      a();
      while (this.N > 0)
      {
        String[] arrayOfString = this.M;
        int i1 = this.N;
        this.N = (i1 - 1);
        arrayOfString[i1] = "";
      }
    }
    
    private int bc()
    {
      return this.P;
    }
    
    private void bd()
    {
      a();
      if (this.P > 0)
      {
        int[] arrayOfInt = this.O;
        int i1 = this.P;
        this.P = (i1 - 1);
        arrayOfInt[i1] = 0;
      }
    }
    
    private void be()
    {
      a();
      while (this.P > 0)
      {
        int[] arrayOfInt = this.O;
        int i1 = this.P;
        this.P = (i1 - 1);
        arrayOfInt[i1] = 0;
      }
    }
    
    private int bf()
    {
      return this.R;
    }
    
    private void bg()
    {
      a();
      if (this.R > 0)
      {
        a.a[] arrayOfa = this.Q;
        int i1 = this.R;
        this.R = (i1 - 1);
        arrayOfa[i1] = a.a.a;
      }
    }
    
    private void bh()
    {
      a();
      while (this.R > 0)
      {
        a.a[] arrayOfa = this.Q;
        int i1 = this.R;
        this.R = (i1 - 1);
        arrayOfa[i1] = a.a.a;
      }
    }
    
    private int bi()
    {
      return this.T;
    }
    
    private void bj()
    {
      a();
      if (this.T > 0)
      {
        String[] arrayOfString = this.S;
        int i1 = this.T;
        this.T = (i1 - 1);
        arrayOfString[i1] = "";
      }
    }
    
    private void bk()
    {
      a();
      while (this.T > 0)
      {
        String[] arrayOfString = this.S;
        int i1 = this.T;
        this.T = (i1 - 1);
        arrayOfString[i1] = "";
      }
    }
    
    private int bl()
    {
      return this.V;
    }
    
    private void bm()
    {
      a();
      if (this.V > 0)
      {
        a.e[] arrayOfe = this.U;
        int i1 = this.V;
        this.V = (i1 - 1);
        arrayOfe[i1] = a.e.a;
      }
    }
    
    private void bn()
    {
      a();
      while (this.V > 0)
      {
        a.e[] arrayOfe = this.U;
        int i1 = this.V;
        this.V = (i1 - 1);
        arrayOfe[i1] = a.e.a;
      }
    }
    
    private int bo()
    {
      return this.X;
    }
    
    private void bp()
    {
      a();
      if (this.X > 0)
      {
        String[] arrayOfString = this.W;
        int i1 = this.X;
        this.X = (i1 - 1);
        arrayOfString[i1] = "";
      }
    }
    
    private void bq()
    {
      a();
      while (this.X > 0)
      {
        String[] arrayOfString = this.W;
        int i1 = this.X;
        this.X = (i1 - 1);
        arrayOfString[i1] = "";
      }
    }
    
    private int br()
    {
      return this.Z;
    }
    
    private void bs()
    {
      a();
      if (this.Z > 0)
      {
        boolean[] arrayOfBoolean = this.Y;
        int i1 = this.Z;
        this.Z = (i1 - 1);
        arrayOfBoolean[i1] = false;
      }
    }
    
    private void bt()
    {
      a();
      while (this.Z > 0)
      {
        boolean[] arrayOfBoolean = this.Y;
        int i1 = this.Z;
        this.Z = (i1 - 1);
        arrayOfBoolean[i1] = false;
      }
    }
    
    private int bu()
    {
      return this.ab;
    }
    
    private void bv()
    {
      a();
      if (this.ab > 0)
      {
        a.i[] arrayOfi = this.aa;
        int i1 = this.ab;
        this.ab = (i1 - 1);
        arrayOfi[i1] = a.i.a;
      }
    }
    
    private void bw()
    {
      a();
      while (this.ab > 0)
      {
        a.i[] arrayOfi = this.aa;
        int i1 = this.ab;
        this.ab = (i1 - 1);
        arrayOfi[i1] = a.i.a;
      }
    }
    
    private int bx()
    {
      return this.ad;
    }
    
    private void by()
    {
      a();
      if (this.ad > 0)
      {
        String[] arrayOfString = this.ac;
        int i1 = this.ad;
        this.ad = (i1 - 1);
        arrayOfString[i1] = "";
      }
    }
    
    private void bz()
    {
      a();
      while (this.ad > 0)
      {
        String[] arrayOfString = this.ac;
        int i1 = this.ad;
        this.ad = (i1 - 1);
        arrayOfString[i1] = "";
      }
    }
    
    private void c(int paramInt1, int paramInt2)
    {
      a();
      String str = this.K[paramInt1];
      this.K[paramInt1] = this.K[paramInt2];
      this.K[paramInt2] = str;
    }
    
    private void c(int paramInt, String paramString)
    {
      a();
      this.K[paramInt] = paramString;
    }
    
    private void c(int paramInt, boolean paramBoolean)
    {
      a();
      this.at[paramInt] = paramBoolean;
    }
    
    private void ca()
    {
      a();
      while (this.as > 0)
      {
        boolean[] arrayOfBoolean = this.ar;
        int i1 = this.as;
        this.as = (i1 - 1);
        arrayOfBoolean[i1] = false;
      }
    }
    
    private int cb()
    {
      return this.au;
    }
    
    private void cc()
    {
      a();
      if (this.au > 0)
      {
        boolean[] arrayOfBoolean = this.at;
        int i1 = this.au;
        this.au = (i1 - 1);
        arrayOfBoolean[i1] = false;
      }
    }
    
    private void cd()
    {
      a();
      while (this.au > 0)
      {
        boolean[] arrayOfBoolean = this.at;
        int i1 = this.au;
        this.au = (i1 - 1);
        arrayOfBoolean[i1] = false;
      }
    }
    
    private int ce()
    {
      return this.aw;
    }
    
    private void cf()
    {
      a();
      if (this.aw > 0)
      {
        a.k[] arrayOfk = this.av;
        int i1 = this.aw;
        this.aw = (i1 - 1);
        arrayOfk[i1] = a.k.a;
      }
    }
    
    private void cg()
    {
      a();
      while (this.aw > 0)
      {
        a.k[] arrayOfk = this.av;
        int i1 = this.aw;
        this.aw = (i1 - 1);
        arrayOfk[i1] = a.k.a;
      }
    }
    
    private void ch()
    {
      this.d = a.l.a;
      this.p = a.k.a;
      this.q = a.c.c;
      this.A = a.f.b;
    }
    
    private void d(int paramInt1, int paramInt2)
    {
      a();
      String str = this.M[paramInt1];
      this.M[paramInt1] = this.M[paramInt2];
      this.M[paramInt2] = str;
    }
    
    private void d(int paramInt, String paramString)
    {
      a();
      this.M[paramInt] = paramString;
    }
    
    private void e(int paramInt1, int paramInt2)
    {
      a();
      this.O[paramInt1] = paramInt2;
    }
    
    private void e(int paramInt, String paramString)
    {
      a();
      this.S[paramInt] = paramString;
    }
    
    private void f(int paramInt1, int paramInt2)
    {
      a();
      int i1 = this.O[paramInt1];
      this.O[paramInt1] = this.O[paramInt2];
      this.O[paramInt2] = i1;
    }
    
    private void f(int paramInt, String paramString)
    {
      a();
      this.W[paramInt] = paramString;
    }
    
    private void g(int paramInt1, int paramInt2)
    {
      a();
      a.a locala = this.Q[paramInt1];
      this.Q[paramInt1] = this.Q[paramInt2];
      this.Q[paramInt2] = locala;
    }
    
    private void g(int paramInt, String paramString)
    {
      a();
      this.ac[paramInt] = paramString;
    }
    
    private void h(int paramInt1, int paramInt2)
    {
      a();
      String str = this.S[paramInt1];
      this.S[paramInt1] = this.S[paramInt2];
      this.S[paramInt2] = str;
    }
    
    private void h(int paramInt, String paramString)
    {
      a();
      this.ae[paramInt] = paramString;
    }
    
    private static j i()
    {
      return c;
    }
    
    private void i(int paramInt1, int paramInt2)
    {
      a();
      a.e locale = this.U[paramInt1];
      this.U[paramInt1] = this.U[paramInt2];
      this.U[paramInt2] = locale;
    }
    
    private static j j()
    {
      return c;
    }
    
    private void j(int paramInt)
    {
      a();
      this.a |= 0x10000;
      this.t = paramInt;
    }
    
    private void j(int paramInt1, int paramInt2)
    {
      a();
      String str = this.W[paramInt1];
      this.W[paramInt1] = this.W[paramInt2];
      this.W[paramInt2] = str;
    }
    
    private a.l k()
    {
      return this.d;
    }
    
    private String k(int paramInt)
    {
      return this.u[paramInt];
    }
    
    private void k(int paramInt1, int paramInt2)
    {
      a();
      int i1 = this.Y[paramInt1];
      this.Y[paramInt1] = this.Y[paramInt2];
      this.Y[paramInt2] = i1;
    }
    
    private void k(boolean paramBoolean)
    {
      a();
      this.a |= 0x200;
      this.m = paramBoolean;
    }
    
    private void l(int paramInt)
    {
      if (paramInt >= this.u.length)
      {
        String[] arrayOfString = new String[paramInt];
        System.arraycopy(this.u, 0, arrayOfString, 0, this.v);
        this.u = arrayOfString;
      }
    }
    
    private void l(int paramInt1, int paramInt2)
    {
      a();
      a.i locali = this.aa[paramInt1];
      this.aa[paramInt1] = this.aa[paramInt2];
      this.aa[paramInt2] = locali;
    }
    
    private void l(boolean paramBoolean)
    {
      a();
      this.a |= 0x80000;
      this.x = paramBoolean;
    }
    
    private boolean l()
    {
      return (this.a & 0x1) != 0;
    }
    
    private String m(int paramInt)
    {
      return this.C[paramInt];
    }
    
    private void m()
    {
      a();
      this.a &= 0xFFFFFFFE;
      this.d = a.l.a;
    }
    
    private void m(int paramInt1, int paramInt2)
    {
      a();
      String str = this.ac[paramInt1];
      this.ac[paramInt1] = this.ac[paramInt2];
      this.ac[paramInt2] = str;
    }
    
    private String n()
    {
      return this.e;
    }
    
    private void n(int paramInt)
    {
      if (paramInt >= this.C.length)
      {
        String[] arrayOfString = new String[paramInt];
        System.arraycopy(this.C, 0, arrayOfString, 0, this.D);
        this.C = arrayOfString;
      }
    }
    
    private void n(int paramInt1, int paramInt2)
    {
      a();
      String str = this.ae[paramInt1];
      this.ae[paramInt1] = this.ae[paramInt2];
      this.ae[paramInt2] = str;
    }
    
    private void o(int paramInt)
    {
      a();
      this.a |= 0x8000000;
      this.G = paramInt;
    }
    
    private void o(int paramInt1, int paramInt2)
    {
      a();
      this.ag[paramInt1] = paramInt2;
    }
    
    private boolean o()
    {
      return (this.a & 0x2) != 0;
    }
    
    private String p(int paramInt)
    {
      return this.K[paramInt];
    }
    
    private void p()
    {
      a();
      this.a &= 0xFFFFFFFD;
      this.e = "";
    }
    
    private void p(int paramInt1, int paramInt2)
    {
      a();
      int i1 = this.ag[paramInt1];
      this.ag[paramInt1] = this.ag[paramInt2];
      this.ag[paramInt2] = i1;
    }
    
    private int q()
    {
      return this.f;
    }
    
    private void q(int paramInt)
    {
      if (paramInt >= this.K.length)
      {
        String[] arrayOfString = new String[paramInt];
        System.arraycopy(this.K, 0, arrayOfString, 0, this.L);
        this.K = arrayOfString;
      }
    }
    
    private void q(int paramInt1, int paramInt2)
    {
      a();
      this.al[paramInt1] = paramInt2;
    }
    
    private String r(int paramInt)
    {
      return this.M[paramInt];
    }
    
    private void r(int paramInt1, int paramInt2)
    {
      a();
      int i1 = this.al[paramInt1];
      this.al[paramInt1] = this.al[paramInt2];
      this.al[paramInt2] = i1;
    }
    
    private void r(String paramString)
    {
      a();
      int i1 = this.v + 1;
      if (i1 >= this.u.length)
      {
        arrayOfString = new String[i1];
        System.arraycopy(this.u, 0, arrayOfString, 0, this.v);
        this.u = arrayOfString;
      }
      String[] arrayOfString = this.u;
      i1 = this.v;
      this.v = (i1 + 1);
      arrayOfString[i1] = paramString;
    }
    
    private boolean r()
    {
      return (this.a & 0x4) != 0;
    }
    
    private void s()
    {
      a();
      this.a &= 0xFFFFFFFB;
      this.f = 0;
    }
    
    private void s(int paramInt)
    {
      if (paramInt >= this.M.length)
      {
        String[] arrayOfString = new String[paramInt];
        System.arraycopy(this.M, 0, arrayOfString, 0, this.N);
        this.M = arrayOfString;
      }
    }
    
    private void s(int paramInt1, int paramInt2)
    {
      a();
      a.c localc = this.an[paramInt1];
      this.an[paramInt1] = this.an[paramInt2];
      this.an[paramInt2] = localc;
    }
    
    private void s(String paramString)
    {
      a();
      this.a |= 0x4000000;
      this.F = paramString;
    }
    
    private int t(int paramInt)
    {
      return this.O[paramInt];
    }
    
    private String t()
    {
      return this.g;
    }
    
    private void t(int paramInt1, int paramInt2)
    {
      a();
      this.ap[paramInt1] = paramInt2;
    }
    
    private void t(String paramString)
    {
      a();
      this.a |= 0x40000000;
      this.J = paramString;
    }
    
    private void u(int paramInt)
    {
      if (paramInt >= this.O.length)
      {
        int[] arrayOfInt = new int[paramInt];
        System.arraycopy(this.O, 0, arrayOfInt, 0, this.P);
        this.O = arrayOfInt;
      }
    }
    
    private void u(int paramInt1, int paramInt2)
    {
      a();
      int i1 = this.ap[paramInt1];
      this.ap[paramInt1] = this.ap[paramInt2];
      this.ap[paramInt2] = i1;
    }
    
    private boolean u()
    {
      return (this.a & 0x8) != 0;
    }
    
    private a.a v(int paramInt)
    {
      return this.Q[paramInt];
    }
    
    private void v()
    {
      a();
      this.a &= 0xFFFFFFF7;
      this.g = "";
    }
    
    private void v(int paramInt1, int paramInt2)
    {
      a();
      int i1 = this.ar[paramInt1];
      this.ar[paramInt1] = this.ar[paramInt2];
      this.ar[paramInt2] = i1;
    }
    
    private String w()
    {
      return this.h;
    }
    
    private void w(int paramInt)
    {
      if (paramInt >= this.Q.length)
      {
        a.a[] arrayOfa = new a.a[paramInt];
        System.arraycopy(this.Q, 0, arrayOfa, 0, this.R);
        this.Q = arrayOfa;
      }
    }
    
    private void w(int paramInt1, int paramInt2)
    {
      a();
      int i1 = this.at[paramInt1];
      this.at[paramInt1] = this.at[paramInt2];
      this.at[paramInt2] = i1;
    }
    
    private String x(int paramInt)
    {
      return this.S[paramInt];
    }
    
    private void x(int paramInt1, int paramInt2)
    {
      a();
      a.k localk = this.av[paramInt1];
      this.av[paramInt1] = this.av[paramInt2];
      this.av[paramInt2] = localk;
    }
    
    private boolean x()
    {
      return (this.a & 0x10) != 0;
    }
    
    private void y()
    {
      a();
      this.a &= 0xFFFFFFEF;
      this.h = "";
    }
    
    private void y(int paramInt)
    {
      if (paramInt >= this.S.length)
      {
        String[] arrayOfString = new String[paramInt];
        System.arraycopy(this.S, 0, arrayOfString, 0, this.T);
        this.S = arrayOfString;
      }
    }
    
    private a.e z(int paramInt)
    {
      return this.U[paramInt];
    }
    
    private String z()
    {
      return this.i;
    }
    
    public final void a(int paramInt)
    {
      a();
      this.a |= 0x4;
      this.f = paramInt;
    }
    
    public final void a(c paramc)
      throws IOException
    {
      a();
      for (;;)
      {
        int i1 = paramc.a();
        Object localObject;
        boolean bool;
        switch (i1)
        {
        default: 
          if (paramc.a(i1)) {}
          break;
        case 0: 
          return;
        case 8: 
          localObject = a.l.b(paramc.m());
          if (localObject != null) {
            a((a.l)localObject);
          }
          break;
        case 18: 
          a(paramc.j());
          break;
        case 24: 
          a(paramc.f());
          break;
        case 34: 
          b(paramc.j());
          break;
        case 42: 
          c(paramc.j());
          break;
        case 50: 
          d(paramc.j());
          break;
        case 58: 
          e(paramc.j());
          break;
        case 72: 
          a(paramc.i());
          break;
        case 80: 
          b(paramc.f());
          break;
        case 88: 
          bool = paramc.i();
          a();
          this.a |= 0x200;
          this.m = bool;
          break;
        case 96: 
          b(paramc.i());
          break;
        case 104: 
          c(paramc.i());
          break;
        case 112: 
          localObject = a.k.b(paramc.m());
          if (localObject != null) {
            a((a.k)localObject);
          }
          break;
        case 120: 
          localObject = a.c.b(paramc.m());
          if (localObject != null) {
            a((a.c)localObject);
          }
          break;
        case 128: 
          d(paramc.i());
          break;
        case 136: 
          c(paramc.f());
          break;
        case 144: 
          i1 = paramc.f();
          a();
          this.a |= 0x10000;
          this.t = i1;
          break;
        case 154: 
          localObject = paramc.j();
          a();
          i1 = this.v + 1;
          if (i1 >= this.u.length)
          {
            arrayOfString = new String[i1];
            System.arraycopy(this.u, 0, arrayOfString, 0, this.v);
            this.u = arrayOfString;
          }
          String[] arrayOfString = this.u;
          i1 = this.v;
          this.v = (i1 + 1);
          arrayOfString[i1] = localObject;
          break;
        case 160: 
          d(paramc.f());
          break;
        case 168: 
          bool = paramc.i();
          a();
          this.a |= 0x80000;
          this.x = bool;
          break;
        case 184: 
          e(paramc.i());
          break;
        case 194: 
          f(paramc.j());
          break;
        case 200: 
          localObject = a.f.b(paramc.m());
          if (localObject != null) {
            a((a.f)localObject);
          }
          break;
        case 210: 
          g(paramc.j());
          break;
        case 218: 
          h(paramc.j());
          break;
        case 224: 
          f(paramc.i());
          break;
        case 242: 
          localObject = paramc.j();
          a();
          this.a |= 0x4000000;
          this.F = ((String)localObject);
          break;
        case 248: 
          i1 = paramc.f();
          a();
          this.a |= 0x8000000;
          this.G = i1;
          break;
        case 330: 
          i(paramc.j());
          break;
        case 338: 
          j(paramc.j());
          break;
        case 346: 
          localObject = paramc.j();
          a();
          this.a |= 0x40000000;
          this.J = ((String)localObject);
          break;
        case 402: 
          k(paramc.j());
          break;
        case 410: 
          l(paramc.j());
          break;
        case 416: 
          e(paramc.f());
          break;
        case 418: 
          i1 = paramc.r();
          u(i1);
          i1 = paramc.b(i1);
          while (paramc.u() > 0) {
            e(paramc.f());
          }
          paramc.c(i1);
          break;
        case 424: 
          localObject = a.a.b(paramc.m());
          if (localObject != null) {
            a((a.a)localObject);
          }
          break;
        case 426: 
          i1 = paramc.b(paramc.r());
          while (paramc.u() > 0)
          {
            localObject = a.a.b(paramc.m());
            if (localObject != null) {
              a((a.a)localObject);
            }
          }
          paramc.c(i1);
          break;
        case 434: 
          m(paramc.j());
          break;
        case 440: 
          localObject = a.e.b(paramc.m());
          if (localObject != null) {
            a((a.e)localObject);
          }
          break;
        case 442: 
          i1 = paramc.b(paramc.r());
          while (paramc.u() > 0)
          {
            localObject = a.e.b(paramc.m());
            if (localObject != null) {
              a((a.e)localObject);
            }
          }
          paramc.c(i1);
          break;
        case 450: 
          n(paramc.j());
          break;
        case 456: 
          g(paramc.i());
          break;
        case 458: 
          i1 = paramc.r();
          E(i1);
          i1 = paramc.b(i1);
          while (paramc.u() > 0) {
            g(paramc.i());
          }
          paramc.c(i1);
          break;
        case 464: 
          localObject = a.i.b(paramc.m());
          if (localObject != null) {
            a((a.i)localObject);
          }
          break;
        case 466: 
          i1 = paramc.b(paramc.r());
          while (paramc.u() > 0)
          {
            localObject = a.i.b(paramc.m());
            if (localObject != null) {
              a((a.i)localObject);
            }
          }
          paramc.c(i1);
          break;
        case 650: 
          o(paramc.j());
          break;
        case 658: 
          p(paramc.j());
          break;
        case 664: 
          f(paramc.f());
          break;
        case 666: 
          i1 = paramc.r();
          M(i1);
          i1 = paramc.b(i1);
          while (paramc.u() > 0) {
            f(paramc.f());
          }
          paramc.c(i1);
          break;
        case 672: 
          h(paramc.i());
          break;
        case 680: 
          g(paramc.f());
          break;
        case 690: 
          q(paramc.j());
          break;
        case 696: 
          h(paramc.f());
          break;
        case 698: 
          i1 = paramc.r();
          O(i1);
          i1 = paramc.b(i1);
          while (paramc.u() > 0) {
            h(paramc.f());
          }
          paramc.c(i1);
          break;
        case 704: 
          localObject = a.c.b(paramc.m());
          if (localObject != null) {
            b((a.c)localObject);
          }
          break;
        case 706: 
          i1 = paramc.b(paramc.r());
          while (paramc.u() > 0)
          {
            localObject = a.c.b(paramc.m());
            if (localObject != null) {
              b((a.c)localObject);
            }
          }
          paramc.c(i1);
          break;
        case 712: 
          i(paramc.f());
          break;
        case 714: 
          i1 = paramc.r();
          S(i1);
          i1 = paramc.b(i1);
          while (paramc.u() > 0) {
            i(paramc.f());
          }
          paramc.c(i1);
          break;
        case 720: 
          i(paramc.i());
          break;
        case 722: 
          i1 = paramc.r();
          U(i1);
          i1 = paramc.b(i1);
          while (paramc.u() > 0) {
            i(paramc.i());
          }
          paramc.c(i1);
          break;
        case 728: 
          j(paramc.i());
          break;
        case 730: 
          i1 = paramc.r();
          W(i1);
          i1 = paramc.b(i1);
          while (paramc.u() > 0) {
            j(paramc.i());
          }
          paramc.c(i1);
          break;
        case 736: 
          localObject = a.k.b(paramc.m());
          if (localObject != null) {
            b((a.k)localObject);
          }
          break;
        case 738: 
          i1 = paramc.b(paramc.r());
          while (paramc.u() > 0)
          {
            localObject = a.k.b(paramc.m());
            if (localObject != null) {
              b((a.k)localObject);
            }
          }
          paramc.c(i1);
        }
      }
    }
    
    public final void a(d paramd)
      throws IOException
    {
      int i3 = 0;
      if (l()) {
        paramd.b(1, this.d.a());
      }
      if (o()) {
        paramd.a(2, this.e);
      }
      if (r()) {
        paramd.a(3, this.f);
      }
      if (u()) {
        paramd.a(4, this.g);
      }
      if (x()) {
        paramd.a(5, this.h);
      }
      if (A()) {
        paramd.a(6, this.i);
      }
      if (D()) {
        paramd.a(7, this.j);
      }
      if (G()) {
        paramd.a(9, this.k);
      }
      if (J()) {
        paramd.a(10, this.l);
      }
      if (M()) {
        paramd.a(11, this.m);
      }
      if (P()) {
        paramd.a(12, this.n);
      }
      if (R()) {
        paramd.a(13, this.o);
      }
      if (T()) {
        paramd.b(14, this.p.a());
      }
      if (V()) {
        paramd.b(15, this.q.a());
      }
      if (Y()) {
        paramd.a(16, this.r);
      }
      if (ab()) {
        paramd.a(17, this.s);
      }
      if (ae()) {
        paramd.a(18, this.t);
      }
      int i1 = 0;
      while (i1 < this.v)
      {
        paramd.a(19, this.u[i1]);
        i1 += 1;
      }
      if (ak()) {
        paramd.a(20, this.w);
      }
      if (an()) {
        paramd.a(21, this.x);
      }
      if (aq()) {
        paramd.a(23, this.y);
      }
      if (at()) {
        paramd.a(24, this.z);
      }
      if (aw()) {
        paramd.b(25, this.A.a());
      }
      if (az()) {
        paramd.a(26, this.B);
      }
      i1 = 0;
      while (i1 < this.D)
      {
        paramd.a(27, this.C[i1]);
        i1 += 1;
      }
      if (aF()) {
        paramd.a(28, this.E);
      }
      if (aI()) {
        paramd.a(30, this.F);
      }
      if (aL()) {
        paramd.a(31, this.G);
      }
      if (aO()) {
        paramd.a(41, this.H);
      }
      if (aR()) {
        paramd.a(42, this.I);
      }
      if (aU()) {
        paramd.a(43, this.J);
      }
      i1 = 0;
      while (i1 < this.L)
      {
        paramd.a(50, this.K[i1]);
        i1 += 1;
      }
      i1 = 0;
      while (i1 < this.N)
      {
        paramd.a(51, this.M[i1]);
        i1 += 1;
      }
      i1 = 0;
      while (i1 < this.P)
      {
        paramd.a(52, this.O[i1]);
        i1 += 1;
      }
      i1 = 0;
      while (i1 < this.R)
      {
        paramd.b(53, this.Q[i1].a());
        i1 += 1;
      }
      i1 = 0;
      while (i1 < this.T)
      {
        paramd.a(54, this.S[i1]);
        i1 += 1;
      }
      i1 = 0;
      while (i1 < this.V)
      {
        paramd.b(55, this.U[i1].a());
        i1 += 1;
      }
      i1 = 0;
      while (i1 < this.X)
      {
        paramd.a(56, this.W[i1]);
        i1 += 1;
      }
      i1 = 0;
      while (i1 < this.Z)
      {
        paramd.a(57, this.Y[i1]);
        i1 += 1;
      }
      i1 = 0;
      while (i1 < this.ab)
      {
        paramd.b(58, this.aa[i1].a());
        i1 += 1;
      }
      i1 = 0;
      while (i1 < this.ad)
      {
        paramd.a(81, this.ac[i1]);
        i1 += 1;
      }
      i1 = 0;
      while (i1 < this.af)
      {
        paramd.a(82, this.ae[i1]);
        i1 += 1;
      }
      i1 = 0;
      while (i1 < this.ah)
      {
        paramd.a(83, this.ag[i1]);
        i1 += 1;
      }
      if (bH()) {
        paramd.a(84, this.ai);
      }
      if (bK()) {
        paramd.a(85, this.aj);
      }
      if (bN()) {
        paramd.a(86, this.ak);
      }
      i1 = 0;
      while (i1 < this.am)
      {
        paramd.a(87, this.al[i1]);
        i1 += 1;
      }
      i1 = 0;
      while (i1 < this.ao)
      {
        paramd.b(88, this.an[i1].a());
        i1 += 1;
      }
      i1 = 0;
      while (i1 < this.aq)
      {
        paramd.a(89, this.ap[i1]);
        i1 += 1;
      }
      i1 = 0;
      while (i1 < this.as)
      {
        paramd.a(90, this.ar[i1]);
        i1 += 1;
      }
      i1 = 0;
      int i2;
      for (;;)
      {
        i2 = i3;
        if (i1 >= this.au) {
          break;
        }
        paramd.a(91, this.at[i1]);
        i1 += 1;
      }
      while (i2 < this.aw)
      {
        paramd.b(92, this.av[i2].a());
        i2 += 1;
      }
    }
    
    public final void a(a.a parama)
    {
      a();
      int i1 = this.R + 1;
      if (i1 >= this.Q.length)
      {
        arrayOfa = new a.a[i1];
        System.arraycopy(this.Q, 0, arrayOfa, 0, this.R);
        this.Q = arrayOfa;
      }
      a.a[] arrayOfa = this.Q;
      i1 = this.R;
      this.R = (i1 + 1);
      arrayOfa[i1] = parama;
    }
    
    public final void a(a.c paramc)
    {
      a();
      if (paramc == null) {
        throw new NullPointerException();
      }
      this.a |= 0x2000;
      this.q = paramc;
    }
    
    public final void a(a.e parame)
    {
      a();
      int i1 = this.V + 1;
      if (i1 >= this.U.length)
      {
        arrayOfe = new a.e[i1];
        System.arraycopy(this.U, 0, arrayOfe, 0, this.V);
        this.U = arrayOfe;
      }
      a.e[] arrayOfe = this.U;
      i1 = this.V;
      this.V = (i1 + 1);
      arrayOfe[i1] = parame;
    }
    
    public final void a(a.f paramf)
    {
      a();
      if (paramf == null) {
        throw new NullPointerException();
      }
      this.a |= 0x400000;
      this.A = paramf;
    }
    
    public final void a(a.i parami)
    {
      a();
      int i1 = this.ab + 1;
      if (i1 >= this.aa.length)
      {
        arrayOfi = new a.i[i1];
        System.arraycopy(this.aa, 0, arrayOfi, 0, this.ab);
        this.aa = arrayOfi;
      }
      a.i[] arrayOfi = this.aa;
      i1 = this.ab;
      this.ab = (i1 + 1);
      arrayOfi[i1] = parami;
    }
    
    public final void a(a.k paramk)
    {
      a();
      if (paramk == null) {
        throw new NullPointerException();
      }
      this.a |= 0x1000;
      this.p = paramk;
    }
    
    public final void a(a.l paraml)
    {
      a();
      if (paraml == null) {
        throw new NullPointerException();
      }
      this.a |= 0x1;
      this.d = paraml;
    }
    
    public final void a(String paramString)
    {
      a();
      this.a |= 0x2;
      this.e = paramString;
    }
    
    public final void a(boolean paramBoolean)
    {
      a();
      this.a |= 0x80;
      this.k = paramBoolean;
    }
    
    public final void b(int paramInt)
    {
      a();
      this.a |= 0x100;
      this.l = paramInt;
    }
    
    public final void b(a.c paramc)
    {
      a();
      int i1 = this.ao + 1;
      if (i1 >= this.an.length)
      {
        arrayOfc = new a.c[i1];
        System.arraycopy(this.an, 0, arrayOfc, 0, this.ao);
        this.an = arrayOfc;
      }
      a.c[] arrayOfc = this.an;
      i1 = this.ao;
      this.ao = (i1 + 1);
      arrayOfc[i1] = paramc;
    }
    
    public final void b(a.k paramk)
    {
      a();
      int i1 = this.aw + 1;
      if (i1 >= this.av.length)
      {
        arrayOfk = new a.k[i1];
        System.arraycopy(this.av, 0, arrayOfk, 0, this.aw);
        this.av = arrayOfk;
      }
      a.k[] arrayOfk = this.av;
      i1 = this.aw;
      this.aw = (i1 + 1);
      arrayOfk[i1] = paramk;
    }
    
    public final void b(String paramString)
    {
      a();
      this.a |= 0x8;
      this.g = paramString;
    }
    
    public final void b(boolean paramBoolean)
    {
      a();
      this.a |= 0x400;
      this.n = paramBoolean;
    }
    
    public final boolean b()
    {
      if (!o()) {}
      while ((!r()) || (!u()) || (!D())) {
        return false;
      }
      return true;
    }
    
    public final int c()
    {
      int i14 = 0;
      if (l()) {}
      for (int i2 = d.d(1, this.d.a()) + 0;; i2 = 0)
      {
        int i1 = i2;
        if (o()) {
          i1 = i2 + d.b(2, this.e);
        }
        i2 = i1;
        if (r()) {
          i2 = i1 + d.c(3, this.f);
        }
        i1 = i2;
        if (u()) {
          i1 = i2 + d.b(4, this.g);
        }
        i2 = i1;
        if (x()) {
          i2 = i1 + d.b(5, this.h);
        }
        i1 = i2;
        if (A()) {
          i1 = i2 + d.b(6, this.i);
        }
        i2 = i1;
        if (D()) {
          i2 = i1 + d.b(7, this.j);
        }
        i1 = i2;
        if (G()) {
          i1 = i2 + d.b(9, this.k);
        }
        i2 = i1;
        if (J()) {
          i2 = i1 + d.c(10, this.l);
        }
        i1 = i2;
        if (M()) {
          i1 = i2 + d.b(11, this.m);
        }
        i2 = i1;
        if (P()) {
          i2 = i1 + d.b(12, this.n);
        }
        i1 = i2;
        if (R()) {
          i1 = i2 + d.b(13, this.o);
        }
        i2 = i1;
        if (T()) {
          i2 = i1 + d.d(14, this.p.a());
        }
        i1 = i2;
        if (V()) {
          i1 = i2 + d.d(15, this.q.a());
        }
        i2 = i1;
        if (Y()) {
          i2 = i1 + d.b(16, this.r);
        }
        i1 = i2;
        if (ab()) {
          i1 = i2 + d.c(17, this.s);
        }
        i2 = i1;
        if (ae()) {
          i2 = i1 + d.c(18, this.t);
        }
        i1 = 0;
        int i3 = 0;
        while (i1 < this.v)
        {
          i3 += d.b(this.u[i1]);
          i1 += 1;
        }
        i2 = i2 + i3 + this.v * 2;
        i1 = i2;
        if (ak()) {
          i1 = i2 + d.c(20, this.w);
        }
        i2 = i1;
        if (an()) {
          i2 = i1 + d.b(21, this.x);
        }
        i1 = i2;
        if (aq()) {
          i1 = i2 + d.b(23, this.y);
        }
        i2 = i1;
        if (at()) {
          i2 = i1 + d.b(24, this.z);
        }
        i1 = i2;
        if (aw()) {
          i1 = i2 + d.d(25, this.A.a());
        }
        i2 = i1;
        if (az()) {
          i2 = i1 + d.b(26, this.B);
        }
        i1 = 0;
        i3 = 0;
        while (i1 < this.D)
        {
          i3 += d.b(this.C[i1]);
          i1 += 1;
        }
        i2 = i2 + i3 + this.D * 2;
        i1 = i2;
        if (aF()) {
          i1 = i2 + d.b(28, this.E);
        }
        i2 = i1;
        if (aI()) {
          i2 = i1 + d.b(30, this.F);
        }
        i1 = i2;
        if (aL()) {
          i1 = i2 + d.c(31, this.G);
        }
        i2 = i1;
        if (aO()) {
          i2 = i1 + d.b(41, this.H);
        }
        i1 = i2;
        if (aR()) {
          i1 = i2 + d.b(42, this.I);
        }
        i2 = i1;
        if (aU()) {
          i2 = i1 + d.b(43, this.J);
        }
        i3 = 0;
        i1 = 0;
        while (i3 < this.L)
        {
          i1 += d.b(this.K[i3]);
          i3 += 1;
        }
        int i15 = this.L;
        int i4 = 0;
        i3 = 0;
        while (i4 < this.N)
        {
          i3 += d.b(this.M[i4]);
          i4 += 1;
        }
        int i16 = this.N;
        int i5 = 0;
        i4 = 0;
        while (i5 < this.P)
        {
          i4 += d.g(this.O[i5]);
          i5 += 1;
        }
        int i17 = this.P;
        int i6 = 0;
        i5 = 0;
        while (i6 < this.R)
        {
          i5 += d.m(this.Q[i6].a());
          i6 += 1;
        }
        int i18 = this.R;
        int i7 = 0;
        i6 = 0;
        while (i7 < this.T)
        {
          i6 += d.b(this.S[i7]);
          i7 += 1;
        }
        int i19 = this.T;
        int i8 = 0;
        i7 = 0;
        while (i8 < this.V)
        {
          i7 += d.m(this.U[i8].a());
          i8 += 1;
        }
        int i20 = this.V;
        int i9 = 0;
        i8 = 0;
        while (i9 < this.X)
        {
          i8 += d.b(this.W[i9]);
          i9 += 1;
        }
        int i21 = this.X;
        int i22 = this.Z;
        int i23 = this.Z;
        int i10 = 0;
        i9 = 0;
        while (i10 < this.ab)
        {
          i9 += d.m(this.aa[i10].a());
          i10 += 1;
        }
        int i24 = this.ab;
        int i11 = 0;
        i10 = 0;
        while (i11 < this.ad)
        {
          i10 += d.b(this.ac[i11]);
          i11 += 1;
        }
        int i25 = this.ad;
        int i12 = 0;
        i11 = 0;
        while (i12 < this.af)
        {
          i11 += d.b(this.ae[i12]);
          i12 += 1;
        }
        int i26 = this.af;
        i12 = 0;
        int i13 = 0;
        while (i12 < this.ah)
        {
          i13 += d.g(this.ag[i12]);
          i12 += 1;
        }
        i2 = i2 + i1 + i15 * 2 + i3 + i16 * 2 + i4 + i17 * 2 + i5 + i18 * 2 + i6 + i19 * 2 + i7 + i20 * 2 + i8 + i21 * 2 + i22 * 1 + i23 * 2 + i9 + i24 * 2 + i10 + i25 * 2 + i11 + i26 * 2 + i13 + this.ah * 2;
        i1 = i2;
        if (bH()) {
          i1 = i2 + d.b(84, this.ai);
        }
        i2 = i1;
        if (bK()) {
          i2 = i1 + d.c(85, this.aj);
        }
        i1 = i2;
        if (bN()) {
          i1 = i2 + d.b(86, this.ak);
        }
        i3 = 0;
        i2 = 0;
        while (i3 < this.am)
        {
          i2 += d.g(this.al[i3]);
          i3 += 1;
        }
        i7 = this.am;
        i4 = 0;
        i3 = 0;
        while (i4 < this.ao)
        {
          i3 += d.m(this.an[i4].a());
          i4 += 1;
        }
        i8 = this.ao;
        i5 = 0;
        i4 = 0;
        while (i5 < this.aq)
        {
          i4 += d.g(this.ap[i5]);
          i5 += 1;
        }
        i9 = this.aq;
        i10 = this.as;
        i11 = this.as;
        i12 = this.au;
        i13 = this.au;
        i6 = 0;
        i5 = i14;
        while (i5 < this.aw)
        {
          i6 += d.m(this.av[i5].a());
          i5 += 1;
        }
        return i6 + (i13 * 2 + (i1 + i2 + i7 * 2 + i3 + i8 * 2 + i4 + i9 * 2 + i10 * 1 + i11 * 2 + i12 * 1)) + this.aw * 2;
      }
    }
    
    public final void c(int paramInt)
    {
      a();
      this.a |= 0x8000;
      this.s = paramInt;
    }
    
    public final void c(String paramString)
    {
      a();
      this.a |= 0x10;
      this.h = paramString;
    }
    
    public final void c(boolean paramBoolean)
    {
      a();
      this.a |= 0x800;
      this.o = paramBoolean;
    }
    
    public final g d()
    {
      return new j();
    }
    
    public final void d(int paramInt)
    {
      a();
      this.a |= 0x40000;
      this.w = paramInt;
    }
    
    public final void d(String paramString)
    {
      a();
      this.a |= 0x20;
      this.i = paramString;
    }
    
    public final void d(boolean paramBoolean)
    {
      a();
      this.a |= 0x4000;
      this.r = paramBoolean;
    }
    
    public final void e(int paramInt)
    {
      a();
      u(this.P + 1);
      int[] arrayOfInt = this.O;
      int i1 = this.P;
      this.P = (i1 + 1);
      arrayOfInt[i1] = paramInt;
    }
    
    public final void e(String paramString)
    {
      a();
      this.a |= 0x40;
      this.j = paramString;
    }
    
    public final void e(boolean paramBoolean)
    {
      a();
      this.a |= 0x100000;
      this.y = paramBoolean;
    }
    
    public final boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (this == paramObject) {
        bool1 = true;
      }
      label335:
      label480:
      label631:
      label686:
      label738:
      label790:
      label845:
      label897:
      label952:
      label1004:
      label1056:
      label1111:
      label1166:
      label1218:
      label1315:
      label1367:
      label1419:
      label1471:
      label1523:
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
                                                                                                                return bool1;
                                                                                                                bool1 = bool2;
                                                                                                              } while (!(paramObject instanceof j));
                                                                                                              paramObject = (j)paramObject;
                                                                                                              bool1 = bool2;
                                                                                                            } while (this.d != ((j)paramObject).d);
                                                                                                            bool1 = bool2;
                                                                                                          } while (!this.e.equals(((j)paramObject).e));
                                                                                                          bool1 = bool2;
                                                                                                        } while (this.f != ((j)paramObject).f);
                                                                                                        bool1 = bool2;
                                                                                                      } while (!this.g.equals(((j)paramObject).g));
                                                                                                      bool1 = bool2;
                                                                                                    } while (!this.h.equals(((j)paramObject).h));
                                                                                                    bool1 = bool2;
                                                                                                  } while (!this.i.equals(((j)paramObject).i));
                                                                                                  bool1 = bool2;
                                                                                                } while (!this.j.equals(((j)paramObject).j));
                                                                                                bool1 = bool2;
                                                                                              } while (this.k != ((j)paramObject).k);
                                                                                              bool1 = bool2;
                                                                                            } while (this.l != ((j)paramObject).l);
                                                                                            bool1 = bool2;
                                                                                          } while (this.m != ((j)paramObject).m);
                                                                                          bool1 = bool2;
                                                                                        } while (this.n != ((j)paramObject).n);
                                                                                        bool1 = bool2;
                                                                                      } while (this.o != ((j)paramObject).o);
                                                                                      bool1 = bool2;
                                                                                    } while (this.p != ((j)paramObject).p);
                                                                                    bool1 = bool2;
                                                                                  } while (this.q != ((j)paramObject).q);
                                                                                  bool1 = bool2;
                                                                                } while (this.r != ((j)paramObject).r);
                                                                                bool1 = bool2;
                                                                              } while (this.s != ((j)paramObject).s);
                                                                              bool1 = bool2;
                                                                            } while (this.t != ((j)paramObject).t);
                                                                            bool1 = bool2;
                                                                          } while (this.u.length != ((j)paramObject).u.length);
                                                                          i1 = 0;
                                                                          for (;;)
                                                                          {
                                                                            if (i1 >= this.u.length) {
                                                                              break label335;
                                                                            }
                                                                            bool1 = bool2;
                                                                            if (!this.u[i1].equals(paramObject.u[i1])) {
                                                                              break;
                                                                            }
                                                                            i1 += 1;
                                                                          }
                                                                          bool1 = bool2;
                                                                        } while (this.w != ((j)paramObject).w);
                                                                        bool1 = bool2;
                                                                      } while (this.x != ((j)paramObject).x);
                                                                      bool1 = bool2;
                                                                    } while (this.y != ((j)paramObject).y);
                                                                    bool1 = bool2;
                                                                  } while (!this.z.equals(((j)paramObject).z));
                                                                  bool1 = bool2;
                                                                } while (this.A != ((j)paramObject).A);
                                                                bool1 = bool2;
                                                              } while (!this.B.equals(((j)paramObject).B));
                                                              bool1 = bool2;
                                                            } while (this.C.length != ((j)paramObject).C.length);
                                                            i1 = 0;
                                                            for (;;)
                                                            {
                                                              if (i1 >= this.C.length) {
                                                                break label480;
                                                              }
                                                              bool1 = bool2;
                                                              if (!this.C[i1].equals(paramObject.C[i1])) {
                                                                break;
                                                              }
                                                              i1 += 1;
                                                            }
                                                            bool1 = bool2;
                                                          } while (this.E != ((j)paramObject).E);
                                                          bool1 = bool2;
                                                        } while (!this.F.equals(((j)paramObject).F));
                                                        bool1 = bool2;
                                                      } while (this.G != ((j)paramObject).G);
                                                      bool1 = bool2;
                                                    } while (!this.H.equals(((j)paramObject).H));
                                                    bool1 = bool2;
                                                  } while (!this.I.equals(((j)paramObject).I));
                                                  bool1 = bool2;
                                                } while (!this.J.equals(((j)paramObject).J));
                                                bool1 = bool2;
                                              } while (this.K.length != ((j)paramObject).K.length);
                                              i1 = 0;
                                              for (;;)
                                              {
                                                if (i1 >= this.K.length) {
                                                  break label631;
                                                }
                                                bool1 = bool2;
                                                if (!this.K[i1].equals(paramObject.K[i1])) {
                                                  break;
                                                }
                                                i1 += 1;
                                              }
                                              bool1 = bool2;
                                            } while (this.M.length != ((j)paramObject).M.length);
                                            i1 = 0;
                                            for (;;)
                                            {
                                              if (i1 >= this.M.length) {
                                                break label686;
                                              }
                                              bool1 = bool2;
                                              if (!this.M[i1].equals(paramObject.M[i1])) {
                                                break;
                                              }
                                              i1 += 1;
                                            }
                                            bool1 = bool2;
                                          } while (this.O.length != ((j)paramObject).O.length);
                                          i1 = 0;
                                          for (;;)
                                          {
                                            if (i1 >= this.O.length) {
                                              break label738;
                                            }
                                            bool1 = bool2;
                                            if (this.O[i1] != paramObject.O[i1]) {
                                              break;
                                            }
                                            i1 += 1;
                                          }
                                          bool1 = bool2;
                                        } while (this.Q.length != ((j)paramObject).Q.length);
                                        i1 = 0;
                                        for (;;)
                                        {
                                          if (i1 >= this.Q.length) {
                                            break label790;
                                          }
                                          bool1 = bool2;
                                          if (this.Q[i1] != paramObject.Q[i1]) {
                                            break;
                                          }
                                          i1 += 1;
                                        }
                                        bool1 = bool2;
                                      } while (this.S.length != ((j)paramObject).S.length);
                                      i1 = 0;
                                      for (;;)
                                      {
                                        if (i1 >= this.S.length) {
                                          break label845;
                                        }
                                        bool1 = bool2;
                                        if (!this.S[i1].equals(paramObject.S[i1])) {
                                          break;
                                        }
                                        i1 += 1;
                                      }
                                      bool1 = bool2;
                                    } while (this.U.length != ((j)paramObject).U.length);
                                    i1 = 0;
                                    for (;;)
                                    {
                                      if (i1 >= this.U.length) {
                                        break label897;
                                      }
                                      bool1 = bool2;
                                      if (this.U[i1] != paramObject.U[i1]) {
                                        break;
                                      }
                                      i1 += 1;
                                    }
                                    bool1 = bool2;
                                  } while (this.W.length != ((j)paramObject).W.length);
                                  i1 = 0;
                                  for (;;)
                                  {
                                    if (i1 >= this.W.length) {
                                      break label952;
                                    }
                                    bool1 = bool2;
                                    if (!this.W[i1].equals(paramObject.W[i1])) {
                                      break;
                                    }
                                    i1 += 1;
                                  }
                                  bool1 = bool2;
                                } while (this.Y.length != ((j)paramObject).Y.length);
                                i1 = 0;
                                for (;;)
                                {
                                  if (i1 >= this.Y.length) {
                                    break label1004;
                                  }
                                  bool1 = bool2;
                                  if (this.Y[i1] != paramObject.Y[i1]) {
                                    break;
                                  }
                                  i1 += 1;
                                }
                                bool1 = bool2;
                              } while (this.aa.length != ((j)paramObject).aa.length);
                              i1 = 0;
                              for (;;)
                              {
                                if (i1 >= this.aa.length) {
                                  break label1056;
                                }
                                bool1 = bool2;
                                if (this.aa[i1] != paramObject.aa[i1]) {
                                  break;
                                }
                                i1 += 1;
                              }
                              bool1 = bool2;
                            } while (this.ac.length != ((j)paramObject).ac.length);
                            i1 = 0;
                            for (;;)
                            {
                              if (i1 >= this.ac.length) {
                                break label1111;
                              }
                              bool1 = bool2;
                              if (!this.ac[i1].equals(paramObject.ac[i1])) {
                                break;
                              }
                              i1 += 1;
                            }
                            bool1 = bool2;
                          } while (this.ae.length != ((j)paramObject).ae.length);
                          i1 = 0;
                          for (;;)
                          {
                            if (i1 >= this.ae.length) {
                              break label1166;
                            }
                            bool1 = bool2;
                            if (!this.ae[i1].equals(paramObject.ae[i1])) {
                              break;
                            }
                            i1 += 1;
                          }
                          bool1 = bool2;
                        } while (this.ag.length != ((j)paramObject).ag.length);
                        i1 = 0;
                        for (;;)
                        {
                          if (i1 >= this.ag.length) {
                            break label1218;
                          }
                          bool1 = bool2;
                          if (this.ag[i1] != paramObject.ag[i1]) {
                            break;
                          }
                          i1 += 1;
                        }
                        bool1 = bool2;
                      } while (this.ai != ((j)paramObject).ai);
                      bool1 = bool2;
                    } while (this.aj != ((j)paramObject).aj);
                    bool1 = bool2;
                  } while (!this.ak.equals(((j)paramObject).ak));
                  bool1 = bool2;
                } while (this.al.length != ((j)paramObject).al.length);
                i1 = 0;
                for (;;)
                {
                  if (i1 >= this.al.length) {
                    break label1315;
                  }
                  bool1 = bool2;
                  if (this.al[i1] != paramObject.al[i1]) {
                    break;
                  }
                  i1 += 1;
                }
                bool1 = bool2;
              } while (this.an.length != ((j)paramObject).an.length);
              i1 = 0;
              for (;;)
              {
                if (i1 >= this.an.length) {
                  break label1367;
                }
                bool1 = bool2;
                if (this.an[i1] != paramObject.an[i1]) {
                  break;
                }
                i1 += 1;
              }
              bool1 = bool2;
            } while (this.ap.length != ((j)paramObject).ap.length);
            i1 = 0;
            for (;;)
            {
              if (i1 >= this.ap.length) {
                break label1419;
              }
              bool1 = bool2;
              if (this.ap[i1] != paramObject.ap[i1]) {
                break;
              }
              i1 += 1;
            }
            bool1 = bool2;
          } while (this.ar.length != ((j)paramObject).ar.length);
          i1 = 0;
          for (;;)
          {
            if (i1 >= this.ar.length) {
              break label1471;
            }
            bool1 = bool2;
            if (this.ar[i1] != paramObject.ar[i1]) {
              break;
            }
            i1 += 1;
          }
          bool1 = bool2;
        } while (this.at.length != ((j)paramObject).at.length);
        i1 = 0;
        for (;;)
        {
          if (i1 >= this.at.length) {
            break label1523;
          }
          bool1 = bool2;
          if (this.at[i1] != paramObject.at[i1]) {
            break;
          }
          i1 += 1;
        }
        bool1 = bool2;
      } while (this.av.length != ((j)paramObject).av.length);
      int i1 = 0;
      for (;;)
      {
        if (i1 >= this.av.length) {
          break label1575;
        }
        bool1 = bool2;
        if (this.av[i1] != paramObject.av[i1]) {
          break;
        }
        i1 += 1;
      }
      label1575:
      return true;
    }
    
    public final void f(int paramInt)
    {
      a();
      M(this.ah + 1);
      int[] arrayOfInt = this.ag;
      int i1 = this.ah;
      this.ah = (i1 + 1);
      arrayOfInt[i1] = paramInt;
    }
    
    public final void f(String paramString)
    {
      a();
      this.a |= 0x200000;
      this.z = paramString;
    }
    
    public final void f(boolean paramBoolean)
    {
      a();
      this.a |= 0x2000000;
      this.E = paramBoolean;
    }
    
    public final boolean f()
    {
      return this.o;
    }
    
    public final a.k g()
    {
      return this.p;
    }
    
    public final void g(int paramInt)
    {
      a();
      this.b |= 0x1000;
      this.aj = paramInt;
    }
    
    public final void g(String paramString)
    {
      a();
      this.a |= 0x800000;
      this.B = paramString;
    }
    
    public final void g(boolean paramBoolean)
    {
      a();
      E(this.Z + 1);
      boolean[] arrayOfBoolean = this.Y;
      int i1 = this.Z;
      this.Z = (i1 + 1);
      arrayOfBoolean[i1] = paramBoolean;
    }
    
    public final a.c h()
    {
      return this.q;
    }
    
    public final void h(int paramInt)
    {
      a();
      O(this.am + 1);
      int[] arrayOfInt = this.al;
      int i1 = this.am;
      this.am = (i1 + 1);
      arrayOfInt[i1] = paramInt;
    }
    
    public final void h(String paramString)
    {
      a();
      int i1 = this.D + 1;
      if (i1 >= this.C.length)
      {
        arrayOfString = new String[i1];
        System.arraycopy(this.C, 0, arrayOfString, 0, this.D);
        this.C = arrayOfString;
      }
      String[] arrayOfString = this.C;
      i1 = this.D;
      this.D = (i1 + 1);
      arrayOfString[i1] = paramString;
    }
    
    public final void h(boolean paramBoolean)
    {
      a();
      this.b |= 0x800;
      this.ai = paramBoolean;
    }
    
    public final int hashCode()
    {
      int i4 = 1;
      int i5 = 0;
      int i2 = getClass().getName().hashCode() * 41;
      int i1 = i2;
      if (l()) {
        i1 = i2 + this.d.hashCode() * 37;
      }
      i2 = i1;
      if (o()) {
        i2 = i1 + this.e.hashCode() * 31;
      }
      i1 = i2;
      if (r()) {
        i1 = i2 + this.f * 33;
      }
      i2 = i1;
      if (u()) {
        i2 = i1 + this.g.hashCode() * 31;
      }
      i1 = i2;
      if (x()) {
        i1 = i2 + this.h.hashCode() * 31;
      }
      i2 = i1;
      if (A()) {
        i2 = i1 + this.i.hashCode() * 31;
      }
      i1 = i2;
      if (D()) {
        i1 = i2 + this.j.hashCode() * 31;
      }
      i2 = i1;
      if (G())
      {
        if (this.k)
        {
          i2 = 1;
          i2 = i1 + i2 * 33;
        }
      }
      else
      {
        i1 = i2;
        if (J()) {
          i1 = i2 + this.l * 33;
        }
        i2 = i1;
        if (M())
        {
          if (!this.m) {
            break label435;
          }
          i2 = 1;
          label233:
          i2 = i1 + i2 * 33;
        }
        i1 = i2;
        if (P())
        {
          if (!this.n) {
            break label440;
          }
          i1 = 1;
          label258:
          i1 = i2 + i1 * 33;
        }
        i2 = i1;
        if (R())
        {
          if (!this.o) {
            break label445;
          }
          i2 = 1;
          label283:
          i2 = i1 + i2 * 33;
        }
        i3 = i2;
        if (T()) {
          i3 = i2 + this.p.hashCode() * 37;
        }
        i1 = i3;
        if (V()) {
          i1 = i3 + this.q.hashCode() * 37;
        }
        i2 = i1;
        if (Y()) {
          if (!this.r) {
            break label450;
          }
        }
      }
      label435:
      label440:
      label445:
      label450:
      for (i2 = 1;; i2 = 0)
      {
        i2 = i1 + i2 * 33;
        i1 = i2;
        if (ab()) {
          i1 = i2 + this.s * 33;
        }
        i2 = i1;
        if (ae()) {
          i2 = i1 + this.t * 33;
        }
        i1 = 0;
        while (i1 < this.u.length)
        {
          i2 += this.u[i1].hashCode() * 19;
          i1 += 1;
        }
        i2 = 0;
        break;
        i2 = 0;
        break label233;
        i1 = 0;
        break label258;
        i2 = 0;
        break label283;
      }
      i1 = i2;
      if (ak()) {
        i1 = i2 + this.w * 33;
      }
      i2 = i1;
      if (an())
      {
        if (this.x)
        {
          i2 = 1;
          i2 = i1 + i2 * 33;
        }
      }
      else
      {
        i1 = i2;
        if (aq()) {
          if (!this.y) {
            break label632;
          }
        }
      }
      label632:
      for (i1 = 1;; i1 = 0)
      {
        i1 = i2 + i1 * 33;
        i2 = i1;
        if (at()) {
          i2 = i1 + this.z.hashCode() * 31;
        }
        i1 = i2;
        if (aw()) {
          i1 = i2 + this.A.hashCode() * 37;
        }
        i2 = i1;
        if (az()) {
          i2 = i1 + this.B.hashCode() * 31;
        }
        i3 = 0;
        i1 = i2;
        i2 = i3;
        while (i2 < this.C.length)
        {
          i1 += this.C[i2].hashCode() * 19;
          i2 += 1;
        }
        i2 = 0;
        break;
      }
      i2 = i1;
      if (aF()) {
        if (!this.E) {
          break label802;
        }
      }
      label802:
      for (i2 = 1;; i2 = 0)
      {
        i2 = i1 + i2 * 33;
        i1 = i2;
        if (aI()) {
          i1 = i2 + this.F.hashCode() * 31;
        }
        i2 = i1;
        if (aL()) {
          i2 = i1 + this.G * 33;
        }
        i1 = i2;
        if (aO()) {
          i1 = i2 + this.H.hashCode() * 31;
        }
        i2 = i1;
        if (aR()) {
          i2 = i1 + this.I.hashCode() * 31;
        }
        i1 = i2;
        if (aU()) {
          i1 = i2 + this.J.hashCode() * 31;
        }
        i2 = 0;
        while (i2 < this.K.length)
        {
          i1 += this.K[i2].hashCode() * 19;
          i2 += 1;
        }
      }
      i2 = 0;
      while (i2 < this.M.length)
      {
        i1 += this.M[i2].hashCode() * 19;
        i2 += 1;
      }
      i2 = 0;
      while (i2 < this.O.length)
      {
        i1 += this.O[i2] * 19;
        i2 += 1;
      }
      i2 = 0;
      while (i2 < this.Q.length)
      {
        i1 += this.Q[i2].a() * 13;
        i2 += 1;
      }
      i2 = 0;
      while (i2 < this.S.length)
      {
        i1 += this.S[i2].hashCode() * 19;
        i2 += 1;
      }
      i2 = 0;
      while (i2 < this.U.length)
      {
        i1 += this.U[i2].a() * 13;
        i2 += 1;
      }
      i2 = 0;
      while (i2 < this.W.length)
      {
        i1 += this.W[i2].hashCode() * 19;
        i2 += 1;
      }
      i2 = 0;
      if (i2 < this.Y.length)
      {
        if (this.Y[i2] != 0) {}
        for (i3 = 19;; i3 = 17)
        {
          i1 += i3;
          i2 += 1;
          break;
        }
      }
      i2 = 0;
      while (i2 < this.aa.length)
      {
        i1 += this.aa[i2].a() * 13;
        i2 += 1;
      }
      i2 = 0;
      while (i2 < this.ac.length)
      {
        i1 += this.ac[i2].hashCode() * 19;
        i2 += 1;
      }
      i2 = 0;
      while (i2 < this.ae.length)
      {
        i1 += this.ae[i2].hashCode() * 19;
        i2 += 1;
      }
      i2 = 0;
      while (i2 < this.ag.length)
      {
        i1 += this.ag[i2] * 19;
        i2 += 1;
      }
      i2 = i1;
      if (bH()) {
        if (!this.ai) {
          break label1272;
        }
      }
      label1272:
      for (i2 = i4;; i2 = 0)
      {
        i2 = i1 + i2 * 33;
        i1 = i2;
        if (bK()) {
          i1 = i2 + this.aj * 33;
        }
        i2 = i1;
        if (bN()) {
          i2 = i1 + this.ak.hashCode() * 31;
        }
        i3 = 0;
        i1 = i2;
        i2 = i3;
        while (i2 < this.al.length)
        {
          i1 += this.al[i2] * 19;
          i2 += 1;
        }
      }
      i2 = 0;
      while (i2 < this.an.length)
      {
        i1 += this.an[i2].a() * 13;
        i2 += 1;
      }
      i2 = 0;
      while (i2 < this.ap.length)
      {
        i1 += this.ap[i2] * 19;
        i2 += 1;
      }
      i2 = 0;
      if (i2 < this.ar.length)
      {
        if (this.ar[i2] != 0) {}
        for (i3 = 19;; i3 = 17)
        {
          i1 += i3;
          i2 += 1;
          break;
        }
      }
      i2 = 0;
      int i3 = i1;
      i4 = i5;
      if (i2 < this.at.length)
      {
        if (this.at[i2] != 0) {}
        for (i3 = 19;; i3 = 17)
        {
          i1 += i3;
          i2 += 1;
          break;
        }
      }
      while (i4 < this.av.length)
      {
        i3 += this.av[i4].a() * 13;
        i4 += 1;
      }
      return i3;
    }
    
    public final void i(int paramInt)
    {
      a();
      S(this.aq + 1);
      int[] arrayOfInt = this.ap;
      int i1 = this.aq;
      this.aq = (i1 + 1);
      arrayOfInt[i1] = paramInt;
    }
    
    public final void i(String paramString)
    {
      a();
      this.a |= 0x10000000;
      this.H = paramString;
    }
    
    public final void i(boolean paramBoolean)
    {
      a();
      U(this.as + 1);
      boolean[] arrayOfBoolean = this.ar;
      int i1 = this.as;
      this.as = (i1 + 1);
      arrayOfBoolean[i1] = paramBoolean;
    }
    
    public final void j(String paramString)
    {
      a();
      this.a |= 0x20000000;
      this.I = paramString;
    }
    
    public final void j(boolean paramBoolean)
    {
      a();
      W(this.au + 1);
      boolean[] arrayOfBoolean = this.at;
      int i1 = this.au;
      this.au = (i1 + 1);
      arrayOfBoolean[i1] = paramBoolean;
    }
    
    public final void k(String paramString)
    {
      a();
      int i1 = this.L + 1;
      if (i1 >= this.K.length)
      {
        arrayOfString = new String[i1];
        System.arraycopy(this.K, 0, arrayOfString, 0, this.L);
        this.K = arrayOfString;
      }
      String[] arrayOfString = this.K;
      i1 = this.L;
      this.L = (i1 + 1);
      arrayOfString[i1] = paramString;
    }
    
    public final void l(String paramString)
    {
      a();
      int i1 = this.N + 1;
      if (i1 >= this.M.length)
      {
        arrayOfString = new String[i1];
        System.arraycopy(this.M, 0, arrayOfString, 0, this.N);
        this.M = arrayOfString;
      }
      String[] arrayOfString = this.M;
      i1 = this.N;
      this.N = (i1 + 1);
      arrayOfString[i1] = paramString;
    }
    
    public final void m(String paramString)
    {
      a();
      int i1 = this.T + 1;
      if (i1 >= this.S.length)
      {
        arrayOfString = new String[i1];
        System.arraycopy(this.S, 0, arrayOfString, 0, this.T);
        this.S = arrayOfString;
      }
      String[] arrayOfString = this.S;
      i1 = this.T;
      this.T = (i1 + 1);
      arrayOfString[i1] = paramString;
    }
    
    public final void n(String paramString)
    {
      a();
      int i1 = this.X + 1;
      if (i1 >= this.W.length)
      {
        arrayOfString = new String[i1];
        System.arraycopy(this.W, 0, arrayOfString, 0, this.X);
        this.W = arrayOfString;
      }
      String[] arrayOfString = this.W;
      i1 = this.X;
      this.X = (i1 + 1);
      arrayOfString[i1] = paramString;
    }
    
    public final void o(String paramString)
    {
      a();
      int i1 = this.ad + 1;
      if (i1 >= this.ac.length)
      {
        arrayOfString = new String[i1];
        System.arraycopy(this.ac, 0, arrayOfString, 0, this.ad);
        this.ac = arrayOfString;
      }
      String[] arrayOfString = this.ac;
      i1 = this.ad;
      this.ad = (i1 + 1);
      arrayOfString[i1] = paramString;
    }
    
    public final void p(String paramString)
    {
      a();
      int i1 = this.af + 1;
      if (i1 >= this.ae.length)
      {
        arrayOfString = new String[i1];
        System.arraycopy(this.ae, 0, arrayOfString, 0, this.af);
        this.ae = arrayOfString;
      }
      String[] arrayOfString = this.ae;
      i1 = this.af;
      this.af = (i1 + 1);
      arrayOfString[i1] = paramString;
    }
    
    public final void q(String paramString)
    {
      a();
      this.b |= 0x2000;
      this.ak = paramString;
    }
  }
  
  public static final class k
    extends e
  {
    public static final k a = new k(0, "WEBP_NONE");
    public static final k b = new k(1, "WEBP_NOALPHA");
    public static final k c = new k(2, "WEBP_ALL");
    private static int d = 0;
    private static int e = 1;
    private static int f = 2;
    private static k[] g = { a, b, c };
    
    private k(int paramInt, String paramString)
    {
      super(paramString);
    }
    
    public static k b(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException(Integer.toString(paramInt));
      case 0: 
        return a;
      case 1: 
        return b;
      }
      return c;
    }
    
    private static k[] b()
    {
      return g;
    }
    
    public final e a(int paramInt)
    {
      return b(paramInt);
    }
  }
  
  public static final class l
    extends e
  {
    public static final l a = new l(0, "SDK");
    private static int b = 0;
    private static int c = 1;
    private static l d = new l(1, "VPN");
    private static l[] e = { a, d };
    
    private l(int paramInt, String paramString)
    {
      super(paramString);
    }
    
    public static l b(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException(Integer.toString(paramInt));
      case 0: 
        return a;
      }
      return d;
    }
    
    private static l[] b()
    {
      return e;
    }
    
    public final e a(int paramInt)
    {
      return b(paramInt);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/android/matoid/service/mtunnel/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */