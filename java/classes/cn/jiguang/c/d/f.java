package cn.jiguang.c.d;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import cn.jiguang.a.c.c;
import cn.jiguang.c.a.a;

public final class f
{
  private static boolean a;
  private static Handler b;
  private static f d;
  private static final String[] z;
  private Context c;
  
  static
  {
    String[] arrayOfString = new String[9];
    int j = 0;
    Object localObject2 = "n'\033CyP-\033Cl\n\022RnV";
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
        i = 11;
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
        localObject2 = "M\001\027V+B\016\027Nn@C\035MeP\n\006V+M\034^L~H\003^";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "l\n\037Pf\n\037VCA\003\016Gy";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "\007\032\020GsG\n\016VbK\001^\017+W\033\021R+B\016\027Nn@OD";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "V\033\035}oA\003\037[";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "G\001PH{Q\034\026\fjJ\013\fMb@A\027LA\001\n\fYp,";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "l\016\020FgA\035^QnJ\013^JnE\035\n\002gK\b";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "V\033\035";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "j:2n+g\000\020Vn\\\033";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        a = false;
        return;
        i = 36;
        continue;
        i = 111;
        continue;
        i = 126;
        continue;
        i = 34;
      }
    }
  }
  
  public static f a()
  {
    if (d == null) {
      d = new f();
    }
    return d;
  }
  
  public static void b()
  {
    a = false;
    try
    {
      if (b != null)
      {
        b.removeCallbacksAndMessages(null);
        b.getLooper().quit();
      }
      b = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      cn.jiguang.d.d.g(z[2], z[3] + localThrowable.getMessage());
    }
  }
  
  public final void a(Context paramContext)
  {
    if (a) {
      return;
    }
    if (paramContext == null)
    {
      cn.jiguang.d.d.h(z[2], z[1]);
      return;
    }
    a = true;
    this.c = paramContext;
    HandlerThread localHandlerThread = new HandlerThread(z[0]);
    localHandlerThread.start();
    b = new g(this, localHandlerThread.getLooper());
    b(paramContext);
  }
  
  public final void b(Context paramContext)
  {
    c(paramContext);
    if ((b != null) && (!b.hasMessages(8000))) {
      b.sendEmptyMessageDelayed(8000, a.j() * 1000);
    }
  }
  
  public final void c(Context paramContext)
  {
    if (paramContext == null) {
      cn.jiguang.d.d.g(z[2], z[8]);
    }
    do
    {
      return;
      c.e(paramContext);
    } while (!d.a().i());
    cn.jiguang.d.d.a(z[2], z[6]);
    Bundle localBundle = new Bundle();
    localBundle.putInt(z[4], 0);
    localBundle.putString(z[7], z[7]);
    i.a().b(paramContext, z[5], localBundle);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/d/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */