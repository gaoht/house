package cn.jiguang.f;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import cn.jiguang.c.a.a;
import cn.jiguang.d.d;
import java.util.List;

final class l
  implements Runnable
{
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[6];
    int j = 0;
    Object localObject2 = ">j\031*M]x\003lK\t+\030yQ\030yW}L\016cW~\\\017}\036n\\\016+\023xV]\030-J\030h\002P\trV";
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
        i = 57;
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
        localObject2 = "\021d\024lU)b\032h\031P+\033lJ\tG\026xW\036c#dT\030+J-";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "*j\034hl\rA\036JL\034e\020";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = ">j\031*M]x\003lK\t+\030yQ\030yW}L\016cW~\\\017}\036n\\\016+\023xV]\030-\\\005h\022}M\024d\0317";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "Q+\033lJ\t+\033lL\023h\037h]]\036`\\G";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "\tb\032h\031\023d\0007";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        return;
        i = 125;
        continue;
        i = 11;
        continue;
        i = 119;
        continue;
        i = 13;
      }
    }
  }
  
  l(long paramLong, Context paramContext) {}
  
  public final void run()
  {
    for (;;)
    {
      try
      {
        long l1 = System.currentTimeMillis() / 1000L;
        long l2 = a.F();
        d.c(z[2], z[5] + l1 + z[4] + l2);
        if ((-1L == l2) || (Math.abs(l1 - l2) > this.a))
        {
          List localList = k.a(this.b);
          a.c(l1);
          if (localList == null) {
            break label251;
          }
          i = localList.size();
          break label253;
          if (j < i)
          {
            Intent localIntent = new Intent();
            localIntent.setComponent((ComponentName)localList.get(j));
            if (Build.VERSION.SDK_INT >= 12) {
              localIntent.setFlags(32);
            }
            this.b.startService(localIntent);
            j += 1;
            continue;
          }
        }
        else
        {
          d.a(z[2], z[1] + (l1 - l2));
        }
        return;
      }
      catch (SecurityException localSecurityException)
      {
        d.h(z[2], z[0]);
        return;
      }
      catch (Throwable localThrowable)
      {
        d.h(z[2], z[3] + localThrowable.getMessage());
        return;
      }
      label251:
      int i = 0;
      label253:
      int j = 0;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/f/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */