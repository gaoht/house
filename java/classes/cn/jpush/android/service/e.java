package cn.jpush.android.service;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import cn.jiguang.api.MultiSpHelper;
import cn.jpush.android.a.d;
import cn.jpush.android.a.k;
import cn.jpush.android.b;
import cn.jpush.android.c.f;
import cn.jpush.android.data.JPushLocalNotification;

public final class e
{
  public static b a;
  private static e d;
  private static final String[] z;
  private Context b;
  private cn.jpush.android.a.c c;
  
  static
  {
    String[] arrayOfString = new String[27];
    int j = 0;
    Object localObject2 = "P\002\n<";
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
        i = 25;
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
        localObject2 = "O\013\005,uB'\016;jF\r\016r";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "r\004\0160iB\t\037-}\035J\036&qF\004\017$|CJ\006;~\007GK";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "f\t\037!vIJFhqF\004\017$|j\017\030;x@\017K=wB\022\b-iS\017\017d9E\037\005,uBJ\034)j\007\004\036$u";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "w\037\030 JB\030\035!zB)\004:|";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "D\004E\"iR\031\003fxI\016\031'pCD\002&mB\004\037fXk#*\033Fs+,\033";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "o\013\005,uBJ\n+mN\005\005hH\030K%lK\036\002hm^\032\016h#\007";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "f\t\037!vIJFhqF\004\017$|t\017\031>pD\017*+mN\005\005h4\007\013\b<pH\004Q";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "t\017\031>pD\017K*lI\016\007-9\nJ";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "J\037\007<px\036\0228|";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = "I\005\037!N\t\n<pH\0044!}";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        j = 11;
        localObject2 = "D\004E\"iR\031\003fxI\016\031'pCD\002&mB\004\037fJs%;\030Lt\"";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i4] = localObject1;
        j = 12;
        localObject2 = "D\004E\"iR\031\003fxI\016\031'pCD\002&mB\004\037fTr&?\001Fw8$\013\\t9";
        i = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i4] = localObject1;
        j = 13;
        localObject2 = "T\003\007-wD\01748lT\0024<pJ\017";
        i = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i4] = localObject1;
        j = 14;
        localObject2 = "E\037\005,uBP";
        i = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject3[i4] = localObject1;
        j = 15;
        localObject2 = "B\004\n*uB5\033=jO5\037!tB";
        i = 14;
        localObject1 = arrayOfString;
        break;
      case 14: 
        localObject3[i4] = localObject1;
        j = 16;
        localObject2 = "K\005\b)ux\004\004<pA\003\b)mN\005\005";
        i = 15;
        localObject1 = arrayOfString;
        break;
      case 15: 
        localObject3[i4] = localObject1;
        j = 17;
        localObject2 = "D\004E\"iR\031\003fxI\016\031'pCD\002&mB\004\037fKb9?\007Kb:>\033Q";
        i = 16;
        localObject1 = arrayOfString;
        break;
      case 16: 
        localObject3[i4] = localObject1;
        j = 18;
        localObject2 = "K\005\b)ux\004\004<pA\003\b)mN\005\005\027pC";
        i = 17;
        localObject1 = arrayOfString;
        break;
      case 17: 
        localObject3[i4] = localObject1;
        j = 19;
        localObject2 = "I\005\037!N\t\n<pH\0044%x_\004\036%";
        i = 18;
        localObject1 = arrayOfString;
        break;
      case 18: 
        localObject3[i4] = localObject1;
        j = 20;
        localObject2 = "C\017\b:|F\031\016\006vS\003\r!zF\036\002'w\035";
        i = 19;
        localObject1 = arrayOfString;
        break;
      case 19: 
        localObject3[i4] = localObject1;
        j = 21;
        localObject2 = "F\t\037!vI";
        i = 20;
        localObject1 = arrayOfString;
        break;
      case 20: 
        localObject3[i4] = localObject1;
        j = 22;
        localObject2 = "T\017\031>pD\0174;mH\032\016,";
        i = 21;
        localObject1 = arrayOfString;
        break;
      case 21: 
        localObject3[i4] = localObject1;
        j = 23;
        localObject2 = "r\004\003)wC\006\016,9T\017\031>pD\017K)zS\003\004&9\nJ";
        i = 22;
        localObject1 = arrayOfString;
        break;
      case 22: 
        localObject3[i4] = localObject1;
        j = 24;
        localObject2 = "I\005\037!N\t\n<pH\0044*lN\016\007-kx\003\017";
        i = 23;
        localObject1 = arrayOfString;
        break;
      case 23: 
        localObject3[i4] = localObject1;
        j = 25;
        localObject2 = "H\004*+mN\005\005\032lIJ\t=wC\006\016hpTJ\005=uK";
        i = 24;
        localObject1 = arrayOfString;
        break;
      case 24: 
        localObject3[i4] = localObject1;
        j = 26;
        localObject2 = "I\005\037!N\t\n<pH\0044*lN\016\007-k";
        i = 25;
        localObject1 = arrayOfString;
        break;
      case 25: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        a = null;
        return;
        i = 39;
        continue;
        i = 106;
        continue;
        i = 107;
        continue;
        i = 72;
      }
    }
  }
  
  private e(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public static e a(Context paramContext)
  {
    if (d == null) {
      d = new e(paramContext);
    }
    return d;
  }
  
  public static void a(Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      f.a(z[4], z[3]);
      return;
    }
    f.a(z[4], z[1] + paramBundle.toString());
    paramBundle.getInt(z[0]);
    f.a(z[4], z[2] + paramBundle.toString());
  }
  
  public final void a()
  {
    a.a(this.b).d(this.b);
  }
  
  public final void a(Bundle paramBundle, Handler paramHandler)
  {
    String str = z[4];
    StringBuilder localStringBuilder = new StringBuilder(z[14]);
    int i;
    if (paramBundle != null)
    {
      paramHandler = paramBundle.toString();
      f.d(str, paramHandler);
      if (paramBundle == null) {
        break label243;
      }
      f.a(z[4], z[8] + paramBundle.toString());
      paramHandler = paramBundle.getString(z[21]);
      if ((paramHandler != null) && (paramBundle != null))
      {
        f.d(z[4], z[7] + paramHandler);
        if (!z[12].equals(paramHandler)) {
          break label548;
        }
        i = paramBundle.getInt(z[9]);
        f.a(z[4], z[6] + i);
        switch (i)
        {
        }
      }
    }
    label243:
    do
    {
      do
      {
        return;
        paramHandler = "";
        break;
        f.g(z[4], z[25]);
        return;
        paramHandler = paramBundle.getString(z[24]);
        paramBundle = paramBundle.getString(z[26]);
        cn.jpush.android.e.a(this.b, paramHandler, paramBundle, true);
        return;
        i = paramBundle.getInt(z[19]);
        int j = d.b();
        if (i < j)
        {
          j -= i;
          f.a(z[4], z[20] + j);
          cn.jpush.android.api.c.a(this.b, j);
        }
        cn.jpush.android.e.a(this.b, i, true);
        return;
        paramBundle = paramBundle.getString(z[15]);
        cn.jpush.android.e.b(this.b, paramBundle, true);
        return;
        paramBundle = paramBundle.getString(z[13]);
        cn.jpush.android.e.a(this.b, paramBundle, true);
        return;
        paramBundle = (JPushLocalNotification)paramBundle.getSerializable(z[16]);
        a.a(this.b).a(this.b, paramBundle, true);
        return;
        long l = paramBundle.getLong(z[18]);
        a.a(this.b).a(this.b, l);
        return;
        a.a(this.b).b(this.b);
        return;
        cn.jpush.android.api.c.a(this.b, true);
        return;
        i = paramBundle.getInt(z[10]);
        if (!d.b(i)) {
          d.a(i);
        }
      } while (d.b() <= cn.jpush.android.e.a(this.b));
      i = d.a();
    } while (i == 0);
    cn.jpush.android.api.c.b(this.b, i);
    return;
    label548:
    if (z[11].equals(paramHandler))
    {
      MultiSpHelper.commitInt(this.b, z[22], 1);
      return;
    }
    if (paramHandler.equals(z[17]))
    {
      MultiSpHelper.commitInt(this.b, z[22], 0);
      return;
    }
    if (z[5].equals(paramHandler))
    {
      this.c = cn.jpush.android.a.c.a(this.b);
      k.a(this.b, paramBundle, this.c);
      return;
    }
    f.g(z[4], z[23] + paramHandler);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/service/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */