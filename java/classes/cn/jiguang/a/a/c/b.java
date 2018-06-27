package cn.jiguang.a.a.c;

import android.app.Application;
import android.content.Context;
import cn.jiguang.c.d.l;
import cn.jiguang.f.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  public static boolean a;
  public static boolean b;
  private static b c;
  private static final String[] z;
  private ExecutorService d = Executors.newSingleThreadExecutor();
  private String e = null;
  private String f = null;
  private ArrayList<a> g = new ArrayList();
  private long h = 30L;
  private long i = 0L;
  private long j = 0L;
  private boolean k = false;
  private boolean l = true;
  private boolean m = true;
  private boolean n = false;
  private boolean o = true;
  private long p = 0L;
  private WeakReference<JSONObject> q = null;
  private JSONObject r = null;
  private Object s = new Object();
  
  static
  {
    String[] arrayOfString = new String[30];
    int i2 = 0;
    Object localObject2 = "\025Z\003y\f\026d\002o\0269k\025oJ0d$o\027*g\023\"Mg\003y\020h\023*\007>f\032o\000k\020~\001-*\025k\b3o\022*.\017\005b-1~\023x\002>i\023$\0131Z\027\027:\"_*\r1*\032k\027+*7i\0206|\037~\035e\004*\"-k\021g\0011~";
    int i1 = -1;
    Object localObject1 = arrayOfString;
    char[] arrayOfChar = ((String)localObject2).toCharArray();
    int i3 = arrayOfChar.length;
    int i6 = 0;
    int i4 = 0;
    int i8 = i1;
    localObject2 = arrayOfChar;
    int i9 = i2;
    Object localObject3 = localObject1;
    int i5 = i3;
    Object localObject4;
    int i7;
    if (i3 <= 1)
    {
      localObject4 = localObject1;
      localObject1 = arrayOfChar;
      i7 = i1;
      label68:
      i5 = i4;
      label71:
      localObject2 = localObject1;
      i6 = localObject2[i4];
      switch (i5 % 5)
      {
      default: 
        i1 = 100;
      }
    }
    for (;;)
    {
      localObject2[i4] = ((char)(i1 ^ i6));
      i5 += 1;
      if (i3 == 0)
      {
        i4 = i3;
        break label71;
      }
      i6 = i5;
      i5 = i3;
      localObject3 = localObject4;
      i9 = i2;
      localObject2 = localObject1;
      i8 = i7;
      i7 = i8;
      localObject1 = localObject2;
      i2 = i9;
      localObject4 = localObject3;
      i3 = i5;
      i4 = i6;
      if (i5 > i6) {
        break label68;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i8)
      {
      default: 
        localObject3[i9] = localObject1;
        i2 = 1;
        localObject2 = "\025Z\003y\f\fK";
        i1 = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i9] = localObject1;
        i2 = 2;
        localObject2 = "+c\033o";
        i1 = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i9] = localObject1;
        i2 = 3;
        localObject2 = ";k\002o";
        i1 = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i9] = localObject1;
        i2 = 4;
        localObject2 = "<\004U\027:y\005c\0131U\005~\005-~";
        i1 = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i9] = localObject1;
        i2 = 5;
        localObject2 = ">i\002c\022:U\032k\0211i\036";
        i1 = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i9] = localObject1;
        i2 = 6;
        localObject2 = ",o\005y\r0d)c\000";
        i1 = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i9] = localObject1;
        i2 = 7;
        localObject2 = "6d\000k\b6nVx\0018c\005~\001-o\022*\000:|\037i\001e*\025k\n1e\002*\026:z\031x\020k\025~\r)o)f\005*d\025b";
        i1 = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i9] = localObject1;
        i2 = 8;
        localObject2 = "+s\006o";
        i1 = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i9] = localObject1;
        i2 = 9;
        localObject2 = "6~\037g\001";
        i1 = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i9] = localObject1;
        i2 = 10;
        localObject2 = "/k\021oD1k\033oD;c\022dC+*\033k\020<bV~\f:*\032k\027+*\031d\001z\027y\027:nVh\035e\030X\001,\033o";
        i1 = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i9] = localObject1;
        i2 = 11;
        localObject2 = "\025Z\003y\f\026d\002o\0269k\025oJ0d&k\021,o^#D2\005~D=oVi\0053f\023nD>l\002o\026i\027f\b:nV@4*y\036C\n+o\004l\005<oXe\n\ro\005\t:\"_*\r1*\002b\r,*7i\0206|\037~\035e\004*\"-k\021g\0011~";
        i1 = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i9] = localObject1;
        i2 = 12;
        localObject2 = "\025Z\003y\f\026d\002o\0269k\025oJ0d$o\027*g\023\"Mg\003y\020h\023*\007>f\032o\000k\020~\001-*\025k\b3o\022*.\017\005b-1~\023x\002>i\023$\0131Z\027\027:\"_*\0051nV@4*y\036C\n+o\004l\005<oXe\n\ro\005\t:*\005b\013*f\022*\n0~Vh\001i\027f\b:nVg\013-oV~\r2oVc\nf\027y\020K\025~\r)c\002sD0xVL\026>m\033o\n+*V";
        i1 = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i9] = localObject1;
        i2 = 13;
        localObject2 = "0d$o\027*g\023";
        i1 = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i9] = localObject1;
        i2 = 14;
        localObject2 = "5z\003y\f\000y\002k\020\000i\027i\f:$\034y\0131";
        i1 = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject3[i9] = localObject1;
        i2 = 15;
        localObject2 = "*~\020'\\";
        i1 = 14;
        localObject1 = arrayOfString;
        break;
      case 14: 
        localObject3[i9] = localObject1;
        i2 = 16;
        localObject2 = "<\004U\027:o\005c\0131U\023d\000";
        i1 = 15;
        localObject1 = arrayOfString;
        break;
      case 15: 
        localObject3[i9] = localObject1;
        i2 = 17;
        localObject2 = ";\004k\0206e\030";
        i1 = 16;
        localObject1 = arrayOfString;
        break;
      case 16: 
        localObject3[i9] = localObject1;
        i2 = 18;
        localObject2 = "3k\005~;/k\003y\001";
        i1 = 17;
        localObject1 = arrayOfString;
        break;
      case 17: 
        localObject3[i9] = localObject1;
        i2 = 19;
        localObject2 = ">i\002c\0226~\037o\027";
        i1 = 18;
        localObject1 = arrayOfString;
        break;
      case 18: 
        localObject3[i9] = localObject1;
        i2 = 20;
        localObject2 = ",~\027~\r,~\037i\027y\002k\026+";
        i1 = 19;
        localObject1 = arrayOfString;
        break;
      case 19: 
        localObject3[i9] = localObject1;
        i2 = 21;
        localObject2 = ">i\002c\022:U\002o\0262c\030k\020:";
        i1 = 20;
        localObject1 = arrayOfString;
        break;
      case 20: 
        localObject3[i9] = localObject1;
        i2 = 22;
        localObject2 = "1o\001*\027+k\002c\027+c\025yD,o\005y\r0d";
        i1 = 21;
        localObject1 = arrayOfString;
        break;
      case 21: 
        localObject3[i9] = localObject1;
        i2 = 23;
        localObject2 = "\nd\023r\024:i\002o\000s*<Z\021,bV\n-o\021c\027+o\004o\000";
        i1 = 22;
        localObject1 = arrayOfString;
        break;
      case 22: 
        localObject3[i9] = localObject1;
        i2 = 24;
        localObject2 = "<e\030~\001'~Vc\027d\003f\b";
        i1 = 23;
        localObject1 = arrayOfString;
        break;
      case 23: 
        localObject3[i9] = localObject1;
        i2 = 25;
        localObject2 = ",~\027~D9\030i\0206e\030*\f>yVh\001:dVn\r,k\024f\001;";
        i1 = 24;
        localObject1 = arrayOfString;
        break;
      case 24: 
        localObject3[i9] = localObject1;
        i2 = 26;
        localObject2 = "\034e\030~\001'~Vy\f0\032nD=oVk\nK\025~\r)c\002sD0dV~\f6yVg\001+b\031nDe*";
        i1 = 25;
        localObject1 = arrayOfString;
        break;
      case 25: 
        localObject3[i9] = localObject1;
        i2 = 27;
        localObject2 = "\025Z\003y\f\026d\002o\0269k\025oJ0d&k\021,o^#D2\005~D=oVi\0053f\023nD>l\002o\026i\027f\b:nV@4*y\036C\n+o\004l\005<oXe\n\ro\005\t:\"_*\0051nV@4*y\036C\n+o\004l\005<oXe\n\017k\003y\001y\036e\0213nVd\013+*\024oD<k\032f\001;*\033e\026:*\002c\t:*\037dD+b\037yD\036i\002c\0226~\017*\013-*0x\0058g\023d\0201V";
        i1 = 26;
        localObject1 = arrayOfString;
        break;
      case 26: 
        localObject3[i9] = localObject1;
        i2 = 28;
        localObject2 = "0d&k\021,o";
        i1 = 27;
        localObject1 = arrayOfString;
        break;
      case 27: 
        localObject3[i9] = localObject1;
        i2 = 29;
        localObject2 = "+b\023*\005<~\037|\r+sVz\005,yVh\035e\030Z\005*y\023*\0006n\030-\020g\027~\0077*\032k\027+*\031d\001z\027y\027:nVh\035e\030X\001,\033o";
        i1 = 28;
        localObject1 = arrayOfString;
        break;
      case 28: 
        localObject3[i9] = localObject1;
        z = arrayOfString;
        c = null;
        a = false;
        b = false;
        return;
        i1 = 95;
        continue;
        i1 = 10;
        continue;
        i1 = 118;
        continue;
        i1 = 10;
      }
    }
  }
  
  public static b a()
  {
    if (c == null) {}
    try
    {
      c = new b();
      return c;
    }
    finally {}
  }
  
  private JSONObject a(Context paramContext, long paramLong)
  {
    cn.jiguang.a.b.b.a().b(paramContext, z[4], this.i);
    StringBuilder localStringBuilder = new StringBuilder();
    String str = cn.jiguang.f.a.k(paramContext);
    if (!h.a(str)) {
      localStringBuilder.append(str);
    }
    str = cn.jiguang.f.a.g(paramContext);
    if (!h.a(str)) {
      localStringBuilder.append(str);
    }
    localStringBuilder.append(paramLong);
    this.f = cn.jiguang.f.a.a(localStringBuilder.toString());
    cn.jiguang.a.b.b.a().b(paramContext, z[6], this.f);
    paramContext = new JSONObject();
    try
    {
      if (!cn.jiguang.c.a.a.s())
      {
        cn.jiguang.d.d.g(z[1], z[7]);
        return null;
      }
      a(paramContext);
      paramContext.put(z[9], cn.jiguang.c.a.a.g());
      paramContext.put(z[6], this.f);
      paramContext.put(z[8], z[5]);
      return paramContext;
    }
    catch (JSONException paramContext) {}
    return null;
  }
  
  private static void a(JSONObject paramJSONObject)
  {
    String str2 = cn.jiguang.c.f.a.a();
    String str1 = str2.split("_")[0];
    str2 = str2.split("_")[1];
    paramJSONObject.put(z[3], str1);
    paramJSONObject.put(z[2], str2);
  }
  
  private boolean c(Context paramContext, String paramString)
  {
    if (!this.o)
    {
      cn.jiguang.d.d.e(z[1], z[25]);
      return false;
    }
    if (paramContext == null)
    {
      cn.jiguang.d.d.e(z[1], z[24]);
      return false;
    }
    if ((paramContext instanceof Application))
    {
      cn.jiguang.d.d.j(z[1], z[26] + paramString);
      return false;
    }
    return true;
  }
  
  private JSONObject d(Context paramContext)
  {
    if (this.r == null) {
      this.r = l.a(paramContext, z[14]);
    }
    return this.r;
  }
  
  public final void a(Context paramContext)
  {
    if (!c(paramContext, z[13])) {
      return;
    }
    a = true;
    try
    {
      this.n = false;
      if (this.n)
      {
        cn.jiguang.d.d.j(z[1], z[12]);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      this.n = true;
      this.i = System.currentTimeMillis();
      this.e = paramContext.getClass().getName();
      try
      {
        this.d.execute(new e(this, paramContext));
        return;
      }
      catch (Exception paramContext) {}
    }
    catch (ClassCastException localClassCastException)
    {
      for (;;) {}
    }
  }
  
  public final void a(Context paramContext, String paramString)
  {
    if (this.n)
    {
      cn.jiguang.d.d.j(z[1], z[0]);
      return;
    }
    this.n = true;
    this.e = paramString;
    this.i = System.currentTimeMillis();
    try
    {
      this.d.execute(new c(this, paramContext));
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public final void b(Context paramContext)
  {
    if (!c(paramContext, z[28])) {
      return;
    }
    b = true;
    try
    {
      this.n = true;
      if (!this.n)
      {
        cn.jiguang.d.d.j(z[1], z[27]);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      this.n = false;
      if ((this.e != null) && (this.e.equals(paramContext.getClass().getName())))
      {
        this.j = System.currentTimeMillis();
        long l1 = (this.j - this.i) / 1000L;
        a locala = new a(this.e, l1);
        this.g.add(locala);
        this.p = this.i;
        try
        {
          this.d.execute(new f(this, paramContext));
          return;
        }
        catch (Exception paramContext)
        {
          return;
        }
      }
      cn.jiguang.d.d.e(z[1], z[29]);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      for (;;) {}
    }
  }
  
  public final void b(Context paramContext, String paramString)
  {
    if (!this.n)
    {
      cn.jiguang.d.d.j(z[1], z[11]);
      return;
    }
    this.n = false;
    if ((this.e != null) && (this.e.equals(paramString)))
    {
      this.j = System.currentTimeMillis();
      long l1 = (this.j - this.i) / 1000L;
      paramString = new a(this.e, l1);
      this.g.add(paramString);
      try
      {
        this.d.execute(new d(this, paramContext));
        return;
      }
      catch (Exception paramContext)
      {
        return;
      }
    }
    cn.jiguang.d.d.j(z[1], z[10]);
  }
  
  public final void c(Context paramContext)
  {
    try
    {
      if ((this.e != null) && (this.n))
      {
        this.j = System.currentTimeMillis();
        long l1 = (this.j - this.i) / 1000L;
        a locala = new a(this.e, l1);
        this.g.add(locala);
      }
      return;
    }
    catch (Exception paramContext)
    {
      try
      {
        this.d.execute(new g(this, paramContext));
        return;
      }
      catch (Exception paramContext) {}
      paramContext = paramContext;
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/a/a/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */