package cn.jiguang.api;

import cn.jiguang.d.b;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public abstract class BaseLogger
{
  private static b b;
  private static final SimpleDateFormat c;
  private static ArrayList<String> d;
  private static boolean e;
  private static boolean f;
  private static final String[] z;
  private String a = "";
  
  static
  {
    String[] arrayOfString = new String[3];
    Object localObject2 = "\nV";
    int i = -1;
    int j = 0;
    Object localObject1 = arrayOfString;
    localObject2 = ((String)localObject2).toCharArray();
    int k = localObject2.length;
    int m;
    Object localObject3;
    int n;
    int i1;
    label50:
    int i2;
    label99:
    label121:
    Object localObject4;
    int i3;
    if (k <= 1)
    {
      m = 0;
      localObject3 = localObject1;
      n = j;
      localObject1 = localObject2;
      i1 = i;
      j = m;
      for (;;)
      {
        localObject2 = localObject1;
        i2 = localObject2[m];
        switch (j % 5)
        {
        default: 
          i = 33;
          localObject2[m] = ((char)(i ^ i2));
          j += 1;
          if (k != 0) {
            break label121;
          }
          m = k;
        }
      }
      i = k;
      localObject4 = localObject3;
      i3 = n;
      localObject2 = localObject1;
      i2 = i1;
    }
    for (;;)
    {
      i1 = i2;
      localObject1 = localObject2;
      n = i3;
      localObject3 = localObject4;
      k = i;
      m = j;
      if (i > j) {
        break label50;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i2)
      {
      default: 
        localObject4[i3] = localObject1;
        localObject2 = "\035?`w`\0311\n";
        j = 1;
        i = 0;
        break;
      case 0: 
        localObject4[i3] = localObject1;
        localObject2 = "\032;\tFE\b>o\030L:LTQ~\004%t";
        j = 2;
        i = 1;
        break;
      case 1: 
        localObject4[i3] = localObject1;
        z = arrayOfString;
        b = new cn.jiguang.d.a();
        c = new SimpleDateFormat(z[2]);
        d = new ArrayList();
        e = false;
        f = false;
        return;
        i = 87;
        break label99;
        i = 118;
        break label99;
        i = 39;
        break label99;
        i = 34;
        break label99;
        m = 0;
        i2 = i;
        i3 = j;
        localObject4 = localObject1;
        i = k;
        j = m;
      }
    }
  }
  
  private static boolean a(int paramInt)
  {
    return paramInt >= 3;
  }
  
  public static void flushCached2File() {}
  
  public static void setDelegate(b paramb)
  {
    b = paramb;
  }
  
  public void _d(String paramString1, String paramString2, Object... paramVarArgs) {}
  
  public void d(String paramString1, String paramString2) {}
  
  public void d(String paramString1, String paramString2, Throwable paramThrowable) {}
  
  public void dd(String paramString1, String paramString2)
  {
    if ((cn.jiguang.c.a.b) && (a(3))) {
      b.b(this.a, "[" + paramString1 + z[0] + paramString2);
    }
  }
  
  public void dd(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((cn.jiguang.c.a.b) && (a(3))) {
      b.b(this.a, "[" + paramString1 + z[0] + paramString2, paramThrowable);
    }
  }
  
  public void e(String paramString1, String paramString2) {}
  
  public void e(String paramString1, String paramString2, Throwable paramThrowable) {}
  
  public void ee(String paramString1, String paramString2)
  {
    if (a(6)) {
      b.e(this.a, "[" + paramString1 + z[0] + paramString2);
    }
  }
  
  public void ee(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a(6)) {
      b.e(this.a, "[" + paramString1 + z[0] + paramString2, paramThrowable);
    }
  }
  
  public abstract String getCommonTag();
  
  public void i(String paramString1, String paramString2) {}
  
  public void i(String paramString1, String paramString2, Throwable paramThrowable) {}
  
  public void ii(String paramString1, String paramString2)
  {
    if ((cn.jiguang.c.a.b) && (a(4))) {
      b.c(this.a, "[" + paramString1 + z[0] + paramString2);
    }
  }
  
  public void ii(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((cn.jiguang.c.a.b) && (a(4))) {
      b.c(this.a, "[" + paramString1 + z[0] + paramString2, paramThrowable);
    }
  }
  
  public void v(String paramString1, String paramString2) {}
  
  public void v(String paramString1, String paramString2, Throwable paramThrowable) {}
  
  public void vv(String paramString1, String paramString2)
  {
    if ((cn.jiguang.c.a.b) && (a(2))) {
      b.a(this.a, "[" + paramString1 + z[0] + paramString2);
    }
  }
  
  public void vv(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((cn.jiguang.c.a.b) && (a(2))) {
      b.a(this.a, "[" + paramString1 + z[0] + paramString2, paramThrowable);
    }
  }
  
  public void w(String paramString1, String paramString2) {}
  
  public void w(String paramString1, String paramString2, Throwable paramThrowable) {}
  
  public void ww(String paramString1, String paramString2)
  {
    if (a(5)) {
      b.d(this.a, "[" + paramString1 + z[0] + paramString2);
    }
  }
  
  public void ww(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((cn.jiguang.c.a.b) && (a(5))) {
      b.d(this.a, "[" + paramString1 + z[0] + paramString2, paramThrowable);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/api/BaseLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */