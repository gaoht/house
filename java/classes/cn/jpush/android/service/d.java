package cn.jpush.android.service;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import cn.jpush.android.a.b;
import cn.jpush.android.c.a;
import cn.jpush.android.c.f;

public final class d
{
  private static d a;
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[10];
    int j = 0;
    Object localObject2 = "H0;\033\026^-}_\007E:g\036\017Op[>2b\030\\2'\027Z?9\007E4";
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
        i = 102;
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
        localObject2 = "{+f\0314N=p\030\020N,V\036\024N";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "x;{\025FI,z\020\002H?f\005F_15\020\026[d5";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "e150%\027Z?9e\021A8 b\035T%/d\020J>6n\020P5FO;s\030\bN:5\030\b\0133t\037\017M;f\005J\0131e\024\b\013*}\024FO;s\020\023G*5\034\007B05\020\005_7c\030\022R";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "D0[\036\022B8|\022\007_7z\037)[;{Q\025N0q3\024D=t\005FN,g\036\024\021";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "H0;\033\026^-}_\007E:g\036\017OpX\"!t\027Q";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "H0;\033\026^-}_\007E:g\036\017Op|\037\022N0a_(d\n\\7/h\037A8)e\001Z!#e\033Q";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "J.e";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "X*g?2R.pQ[\013";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "\005.p\003\013B-f\030\tEp_!3x\026J<#x\rT6#";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        return;
        i = 43;
        continue;
        i = 94;
        continue;
        i = 21;
        continue;
        i = 113;
      }
    }
  }
  
  public static d a()
  {
    if (a == null) {
      a = new d();
    }
    return a;
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    int j = 0;
    String str = paramIntent.getStringExtra(z[5]);
    Object localObject;
    if (!TextUtils.isEmpty(str))
    {
      localObject = paramIntent.getStringExtra(z[0]);
      f.c(z[1], z[8] + (String)localObject);
      int i = j;
      if (localObject != null)
      {
        i = j;
        if ("1".equals(localObject)) {
          i = 1;
        }
      }
      if (1 != i) {
        b.a(str, 1000, paramContext);
      }
    }
    if (!a.a(paramContext, z[6], true))
    {
      f.d(z[1], z[3]);
      a.b(paramContext);
      return;
    }
    try
    {
      localObject = new Intent(z[6]);
      ((Intent)localObject).putExtras(paramIntent.getExtras());
      str = paramIntent.getStringExtra(z[7]);
      paramIntent = str;
      if (TextUtils.isEmpty(str)) {
        paramIntent = paramContext.getPackageName();
      }
      ((Intent)localObject).addCategory(paramIntent);
      f.e(z[1], z[2] + paramIntent);
      paramContext.sendBroadcast((Intent)localObject, paramIntent + z[9]);
      return;
    }
    catch (Throwable paramContext)
    {
      f.h(z[1], z[4] + paramContext.getMessage());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/service/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */