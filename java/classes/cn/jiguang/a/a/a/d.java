package cn.jiguang.a.a.a;

import android.content.Context;
import cn.jiguang.f.a;
import org.json.JSONArray;

public abstract class d
{
  private static final String[] z;
  public String a;
  private b b;
  private f c;
  private Context d;
  private k e;
  private JSONArray f = null;
  private boolean g;
  private boolean h = false;
  private JSONArray i;
  private String j;
  
  static
  {
    String[] arrayOfString = new String[8];
    int m = 0;
    Object localObject2 = "*IK";
    int k = -1;
    Object localObject1 = arrayOfString;
    char[] arrayOfChar = ((String)localObject2).toCharArray();
    int n = arrayOfChar.length;
    int i3 = 0;
    int i1 = 0;
    int i5 = k;
    localObject2 = arrayOfChar;
    int i6 = m;
    Object localObject3 = localObject1;
    int i2 = n;
    Object localObject4;
    int i4;
    if (n <= 1)
    {
      localObject4 = localObject1;
      localObject1 = arrayOfChar;
      i4 = k;
      label68:
      i2 = i1;
      label71:
      localObject2 = localObject1;
      i3 = localObject2[i1];
      switch (i2 % 5)
      {
      default: 
        k = 46;
      }
    }
    for (;;)
    {
      localObject2[i1] = ((char)(k ^ i3));
      i2 += 1;
      if (n == 0)
      {
        i1 = n;
        break label71;
      }
      i3 = i2;
      i2 = n;
      localObject3 = localObject4;
      i6 = m;
      localObject2 = localObject1;
      i5 = i4;
      i4 = i5;
      localObject1 = localObject2;
      m = i6;
      localObject4 = localObject3;
      n = i2;
      i1 = i3;
      if (i2 > i3) {
        break label68;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i5)
      {
      default: 
        localObject3[i6] = localObject1;
        m = 1;
        localObject2 = "*KC\035A\"A\t\037K9HN\034]\"JIAo\bfb<}\024fh.|\030`x#a\bds&a\005";
        k = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i6] = localObject1;
        m = 2;
        localObject2 = "\031@V\032G9@\007\033F.\005W\n\\&LT\034G$KF\001J9JN\013\000;@U\002G8VN\000@edd,k\030vx)g\005`x#a\bds&a\005";
        k = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i6] = localObject1;
        m = 3;
        localObject2 = "*KC\035A\"A\t\037K9HN\034]\"JIAo\bfb<}\024cn!k\024ih,o\037lh!";
        k = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i6] = localObject1;
        m = 4;
        localObject2 = "*KC\035A\"A\t\037K9HN\034]\"JIAo\bfb<}\024rn)g\024vs.z\016";
        k = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i6] = localObject1;
        m = 5;
        localObject2 = "\b@K\003b$FF\033G$Kj\016@*BB\035";
        k = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i6] = localObject1;
        m = 6;
        localObject2 = "*KC\035A\"A\t\037K9HN\034]\"JIAm\003di(k\024rn)g\024vs.z\016";
        k = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i6] = localObject1;
        m = 7;
        localObject2 = "\031@V\032G9@\007\033F.\005W\n\\&LT\034G$KF\001J9JN\013\000;@U\002G8VN\000@edd,k\030vx8g\rlx<z\nqb";
        k = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i6] = localObject1;
        z = arrayOfString;
        return;
        k = 75;
        continue;
        k = 37;
        continue;
        k = 39;
        continue;
        k = 111;
      }
    }
  }
  
  private d(Context paramContext)
  {
    this.d = paramContext.getApplicationContext();
    this.b = new b(paramContext);
    this.e = new k(paramContext);
    this.c = new f(paramContext);
    this.c.a(this);
  }
  
  private d(Context paramContext, String paramString)
  {
    this(paramContext);
    if ((paramString == null) || ("".equals(paramString)))
    {
      this.a = z[0];
      return;
    }
    this.a = paramString;
  }
  
  private d(Context paramContext, String paramString, byte paramByte)
  {
    this(paramContext, paramString);
  }
  
  public d(Context paramContext, String paramString, boolean paramBoolean)
  {
    this(paramContext, paramString, (byte)0);
  }
  
  public abstract void a();
  
  public final void a(String paramString)
  {
    this.j = paramString;
  }
  
  public final void a(JSONArray paramJSONArray)
  {
    this.f = paramJSONArray;
  }
  
  public final String b()
  {
    String str2 = this.c.d();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final JSONArray c()
  {
    if (!a.b(this.d, z[1])) {
      return null;
    }
    return this.f;
  }
  
  public final JSONArray d()
  {
    if (this.i != null) {
      return this.i;
    }
    return null;
  }
  
  public final void e()
  {
    int k = 1;
    if (!a.b(this.d, z[4]))
    {
      cn.jiguang.d.d.g(z[5], z[7]);
      this.i = null;
      if (a.b(this.d, z[3])) {
        break label196;
      }
      cn.jiguang.d.d.g(z[5], z[2]);
    }
    label156:
    label196:
    while (!this.c.a())
    {
      this.j = "";
      a();
      return;
      Context localContext = this.d;
      if ((a.b(localContext, z[1])) && (a.b(localContext, z[4])) && (a.b(localContext, z[6])) && (a.b(localContext, z[3]))) {}
      for (;;)
      {
        if ((k != 0) || (a.n(this.d))) {
          break label156;
        }
        this.i = null;
        break;
        k = 0;
      }
      this.g = this.e.a();
      if (!this.g)
      {
        this.i = null;
        break;
      }
      this.i = this.e.b();
      break;
    }
    this.c.b();
  }
  
  public final void f()
  {
    if (this.h) {
      return;
    }
    this.h = true;
    if (a.b(this.d, z[1]))
    {
      e locale = new e(this);
      this.b.a(locale);
      this.b.a(this);
      return;
    }
    this.f = null;
    e();
  }
  
  public final void g()
  {
    this.h = false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/a/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */