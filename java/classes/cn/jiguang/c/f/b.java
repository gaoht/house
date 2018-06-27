package cn.jiguang.c.f;

import android.content.Context;
import android.os.Build;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import cn.jiguang.api.SdkType;
import cn.jiguang.c.d.o;
import cn.jiguang.d.d;
import cn.jiguang.f.h;
import java.util.concurrent.atomic.AtomicBoolean;

public final class b
{
  private static b h;
  private static final String[] z;
  private transient AtomicBoolean a = new AtomicBoolean(false);
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  
  static
  {
    String[] arrayOfString = new String[5];
    Object localObject1 = "(+nQ7 !UJ<";
    int i = -1;
    int j = 0;
    Object localObject3 = arrayOfString;
    localObject1 = ((String)localObject1).toCharArray();
    int k = localObject1.length;
    int m;
    int n;
    int i1;
    label42:
    Object localObject2;
    int i2;
    label91:
    label113:
    Object localObject4;
    int i3;
    if (k <= 1)
    {
      m = 0;
      n = j;
      i1 = i;
      j = m;
      for (;;)
      {
        localObject2 = localObject1;
        i2 = localObject2[m];
        switch (j % 5)
        {
        default: 
          i = 88;
          localObject2[m] = ((char)(i ^ i2));
          j += 1;
          if (k != 0) {
            break label113;
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
        break label42;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i2)
      {
      default: 
        localObject4[i3] = localObject1;
        localObject1 = "ma";
        j = 1;
        i = 0;
        break;
      case 0: 
        localObject4[i3] = localObject1;
        localObject1 = "**dW=11*J+i+O4";
        j = 2;
        i = 1;
        break;
      case 1: 
        localObject4[i3] = localObject1;
        localObject1 = "<+aM7>+";
        j = 3;
        i = 2;
        break;
      case 2: 
        localObject4[i3] = localObject1;
        j = 4;
        localObject1 = "\r |J;,\fdE7";
        i = 3;
        break;
      case 3: 
        localObject4[i3] = localObject1;
        z = arrayOfString;
        return;
        i = 73;
        break label91;
        i = 69;
        break label91;
        i = 10;
        break label91;
        i = 35;
        break label91;
        m = 0;
        i2 = i;
        localObject2 = localObject1;
        i3 = j;
        localObject4 = localObject3;
        i = k;
        j = m;
      }
    }
  }
  
  public static b e()
  {
    if (h == null) {
      h = new b();
    }
    return h;
  }
  
  public final String a()
  {
    return this.d;
  }
  
  public final void a(Context paramContext)
  {
    if ((this.a.get()) || (paramContext == null)) {
      return;
    }
    b(paramContext);
    this.a.set(true);
  }
  
  public final String b()
  {
    return this.e;
  }
  
  public final void b(Context paramContext)
  {
    if (paramContext == null)
    {
      d.h(z[4], z[2]);
      return;
    }
    this.c = cn.jiguang.f.a.e(paramContext, this.c);
    try
    {
      this.b = Settings.Secure.getString(paramContext.getContentResolver(), z[0]);
      if (TextUtils.isEmpty(this.b)) {
        this.b = "";
      }
      this.d = o.a(paramContext);
      this.g = o.b(paramContext);
      cn.jiguang.c.d.a.a();
      Object localObject1 = "" + cn.jiguang.c.d.a.c(SdkType.JPUSH.name(), " ") + "|";
      localObject1 = (String)localObject1 + cn.jiguang.c.d.a.c(SdkType.JANALYTICS.name(), " ") + "|";
      this.e = cn.jiguang.f.a.a(paramContext, (String)localObject1 + cn.jiguang.c.d.a.c(SdkType.JSHARE.name(), " "));
      localObject1 = cn.jiguang.f.a.g(paramContext);
      Object localObject2 = cn.jiguang.f.a.f(paramContext);
      Object localObject3 = cn.jiguang.f.a.c(paramContext, " ");
      Object localObject4 = cn.jiguang.f.a.e(paramContext, " ");
      String str = Build.SERIAL;
      paramContext = (Context)localObject1;
      if (h.a((String)localObject1)) {
        paramContext = " ";
      }
      localObject1 = localObject2;
      if (h.a((String)localObject2)) {
        localObject1 = " ";
      }
      localObject2 = localObject3;
      if (h.a((String)localObject3)) {
        localObject2 = " ";
      }
      localObject3 = localObject4;
      if (h.a((String)localObject4)) {
        localObject3 = " ";
      }
      if (!h.a(str))
      {
        localObject4 = str;
        if (!z[3].equalsIgnoreCase(str)) {}
      }
      else
      {
        localObject4 = " ";
      }
      cn.jiguang.c.a.a.j((String)localObject3);
      cn.jiguang.c.a.a.k((String)localObject1);
      cn.jiguang.c.a.a.l((String)localObject2);
      this.f = (cn.jiguang.f.a.a + z[1] + paramContext + z[1] + (String)localObject3 + z[1] + (String)localObject1 + z[1] + (String)localObject2 + z[1] + (String)localObject4);
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public final String c()
  {
    return this.f;
  }
  
  public final String d()
  {
    return this.g;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/f/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */