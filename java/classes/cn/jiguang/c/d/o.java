package cn.jiguang.c.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import cn.jiguang.d.d;

public final class o
{
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[6];
    int j = 0;
    Object localObject2 = "/a>:v'kt8|<b3;j'`4fK\013N\036\027I\006@\024\rF\035[\033\034\\";
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
        localObject2 = ">g5&|";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "j+";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "\035j(>p-j\022-u>j(";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "\033a1&v9a";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "\032g?ho+})!v A;%|nf)hw!{z>x\"f>d9\036c?)j+/9 |-dz1v;}z\tw*}5!}\003n4!+|.fa#c";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        return;
        i = 78;
        continue;
        i = 15;
        continue;
        i = 90;
        continue;
        i = 72;
      }
    }
  }
  
  public static String a(Context paramContext)
  {
    Object localObject1 = (TelephonyManager)paramContext.getSystemService(z[1]);
    String str = cn.jiguang.f.a.e(paramContext);
    if (cn.jiguang.f.a.b(paramContext, z[0])) {}
    label123:
    for (;;)
    {
      try
      {
        localObject1 = ((TelephonyManager)localObject1).getSubscriberId();
        if (!TextUtils.isEmpty(str)) {
          break label123;
        }
        str = " ";
        Object localObject3 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject3 = " ";
        }
        return str + z[2] + (String)localObject3 + z[2] + paramContext.getPackageName() + z[2] + cn.jiguang.c.a.f;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      Object localObject2 = null;
    }
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      String str = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      paramContext = str;
      if (str.length() > 30)
      {
        d.j(z[3], z[5]);
        paramContext = str.substring(0, 30);
      }
      return paramContext;
    }
    catch (Exception paramContext) {}
    return z[4];
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/d/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */