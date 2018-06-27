package cn.jiguang.a.a.c.a.a;

import android.app.Instrumentation;
import android.content.Context;
import java.lang.reflect.Field;

public final class c
{
  public static boolean a;
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[6];
    int j = 0;
    Object localObject2 = "\026\017@Ey\t3CSc\017'Z_b\025";
    int i = -1;
    Object localObject1 = arrayOfString;
    char[] arrayOfChar = ((String)localObject2).toCharArray();
    int k = arrayOfChar.length;
    int i1 = 0;
    int m = 0;
    int i3 = i;
    localObject2 = arrayOfChar;
    int i4 = j;
    Object localObject3 = localObject1;
    int n = k;
    Object localObject4;
    int i2;
    if (k <= 1)
    {
      localObject4 = localObject1;
      localObject1 = arrayOfChar;
      i2 = i;
      label68:
      n = m;
      label71:
      localObject2 = localObject1;
      i1 = localObject2[m];
      switch (n % 5)
      {
      default: 
        i = 13;
      }
    }
    for (;;)
    {
      localObject2[m] = ((char)(i ^ i1));
      n += 1;
      if (k == 0)
      {
        m = k;
        break label71;
      }
      i1 = n;
      n = k;
      localObject3 = localObject4;
      i4 = j;
      localObject2 = localObject1;
      i3 = i2;
      i2 = i3;
      localObject1 = localObject2;
      j = i4;
      localObject4 = localObject3;
      k = n;
      m = i1;
      if (n > i1) {
        break label68;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i3)
      {
      default: 
        localObject3[i4] = localObject1;
        j = 1;
        localObject2 = "2(]B\016+KXy\0322GYc3)A]";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "2(]Bl\027*\016c\b2\\C`\036(ZWy\022)@\026E\024)E\026b\027\"\023";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "2(]B\016+KXy\0322GYc3)A]-\035'GZh\037|";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "W(KA0";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "2(]B\016+KXy\0322GYc[.OE-\022(]Bl\027*KR!\b-GF";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        a = true;
        return;
        i = 123;
        continue;
        i = 70;
        continue;
        i = 46;
        continue;
        i = 54;
      }
    }
  }
  
  public static void a(Context paramContext)
  {
    try
    {
      Object localObject = a.a();
      Field localField = cn.jiguang.e.a.a(a.b(), z[0]);
      Instrumentation localInstrumentation = (Instrumentation)cn.jiguang.e.a.a(localField, localObject);
      if (!d.class.isInstance(localInstrumentation))
      {
        paramContext = new d(paramContext, localInstrumentation);
        paramContext.a(true);
        cn.jiguang.e.a.a(localField, localObject, paramContext);
        cn.jiguang.d.d.c(z[1], z[2] + localField + z[4] + paramContext);
        a = false;
        return;
      }
      cn.jiguang.d.d.c(z[1], z[5]);
      a = false;
      return;
    }
    catch (Exception paramContext)
    {
      a = true;
      cn.jiguang.d.d.a(z[1], z[3] + paramContext);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/a/a/c/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */