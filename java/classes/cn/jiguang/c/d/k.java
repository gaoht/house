package cn.jiguang.c.d;

import android.content.Context;
import android.os.IBinder;
import cn.jiguang.c.b.g;
import cn.jiguang.d.d;
import java.util.concurrent.atomic.AtomicLong;

public final class k
  extends cn.jiguang.b.b
{
  private static final String[] z;
  private Context a;
  
  static
  {
    String[] arrayOfString = new String[11];
    int j = 0;
    Object localObject2 = "Enia_Z|sg3Fo{}fF;xp3Tr~e)Szvzv";
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
        i = 19;
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
        localObject2 = "xnv}zfook[Pwjla";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "\031;lh@~ ";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "R~n)Zu})qL;{`wY7:bvL!";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "R~n)z[onvG;xp3Tr~e?\025pp)";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "R~n)qZtvlr[;xp3Tr~e?\025pp)";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "R~n)@Aisgt\030{}r\025yc)r\\v%3^~c3";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "VtwdzA;I}a\\u})qL;{`wY7:bvL!";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "VtwdzA;vf}R;xp3Tr~e?\025pp)";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "VtwdzA;xf|Y~{g3Wb:hzQw6)xPb ";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = "VtwdzA;sggP|{3Wb:hzQw6)xPb ";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        return;
        i = 53;
        continue;
        i = 27;
        continue;
        i = 26;
        continue;
        i = 9;
      }
    }
  }
  
  public k(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public final int a(String paramString, int paramInt)
  {
    paramInt = cn.jiguang.c.a.b.b(this.a, paramString, paramInt);
    d.a(z[1], z[4] + paramString + z[2] + paramInt);
    return paramInt;
  }
  
  public final long a(String paramString, long paramLong)
  {
    paramLong = cn.jiguang.c.a.b.b(this.a, paramString, paramLong);
    d.a(z[1], z[3] + paramString + z[2] + paramLong);
    return paramLong;
  }
  
  public final String a(String paramString1, String paramString2)
  {
    paramString2 = cn.jiguang.c.a.b.b(this.a, paramString1, paramString2);
    d.a(z[1], z[6] + paramString1 + z[2] + paramString2);
    return paramString2;
  }
  
  public final void a(int paramInt, long paramLong, boolean paramBoolean, float paramFloat, double paramDouble, String paramString) {}
  
  public final boolean a()
  {
    d.a(z[1], z[0]);
    return g.a.get() != 0L;
  }
  
  public final boolean a(String paramString, boolean paramBoolean)
  {
    paramBoolean = cn.jiguang.c.a.b.b(this.a, paramString, paramBoolean);
    d.a(z[1], z[5] + paramString + z[2] + paramBoolean);
    return paramBoolean;
  }
  
  public final void b(String paramString, int paramInt)
  {
    d.a(z[1], z[10] + paramString + z[2] + paramInt);
    cn.jiguang.c.a.b.a(this.a, paramString, paramInt);
  }
  
  public final void b(String paramString, long paramLong)
  {
    d.a(z[1], z[8] + paramString + z[2] + paramLong);
    cn.jiguang.c.a.b.a(this.a, paramString, paramLong);
  }
  
  public final void b(String paramString1, String paramString2)
  {
    d.a(z[1], z[7] + paramString1 + z[2] + paramString2);
    cn.jiguang.c.a.b.a(this.a, paramString1, paramString2);
  }
  
  public final void b(String paramString, boolean paramBoolean)
  {
    d.a(z[1], z[9] + paramString + z[2] + paramBoolean);
    cn.jiguang.c.a.b.a(this.a, paramString, paramBoolean);
  }
  
  public final IBinder c(String paramString1, String paramString2)
  {
    a.a();
    return a.b(paramString1, paramString2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/d/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */