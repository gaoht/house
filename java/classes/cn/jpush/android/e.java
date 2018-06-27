package cn.jpush.android;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.api.MultiSpHelper;
import cn.jpush.android.api.c;
import cn.jpush.android.c.f;

public final class e
{
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[16];
    int j = 0;
    Object localObject2 = "5_\016)_7J\037oX;_\002`^6\004";
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
        i = 49;
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
        localObject2 = "\022n\003zY\033Q\033d^6";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "6Q\002`W1]\027}X7P)gD5";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = ";PXcA-M\036'P6Z\004fX<\020\037gE=P\002'|\rr\"@n\bl9Jt\013m";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "9]\002`^6";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "2N\003zY\007M\027T\007]\003zE7S)kD1R\022lC";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "6Q\002`W1]\027}X7P)kD1Z\032lC\007W\022";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "5K\032}X\007J\017yT";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "6Q\002`W1]\027}X7P)kD1Z\032lC";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "+[\002}X6Y)yD+V)}X5[";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = "=P\027k]=a\006|B0a\002`\\=";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        j = 11;
        localObject2 = "+[\002}X6Y)zX4[\030jT\007N\003zY\007J\037dT";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i4] = localObject1;
        j = 12;
        localObject2 = "+W\032l_;[)yD+V)}X5[";
        i = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i4] = localObject1;
        j = 13;
        localObject2 = "6K\033kT*\036\037g\021)K\023|Tb\036";
        i = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i4] = localObject1;
        j = 14;
        localObject2 = "<[\025{T9M\023G^,W\020`R9J\037f_b";
        i = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject3[i4] = localObject1;
        j = 15;
        localObject2 = "6Q\002`W1]\027}X7P)dP P\003d";
        i = 14;
        localObject1 = arrayOfString;
        break;
      case 14: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        return;
        i = 88;
        continue;
        i = 62;
        continue;
        i = 118;
        continue;
        i = 9;
      }
    }
  }
  
  public static int a(Context paramContext)
  {
    int i = MultiSpHelper.getInt(paramContext, z[2], 5);
    f.a(z[1], z[0] + i);
    return i;
  }
  
  public static void a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) || (JCoreInterface.canCallDirect()))
    {
      int i = cn.jpush.android.a.d.b();
      f.a(z[1], z[13] + i);
      if (paramInt < i)
      {
        i -= paramInt;
        f.a(z[1], z[14] + i);
        c.a(paramContext, i);
      }
      MultiSpHelper.commitInt(paramContext, z[2], paramInt);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString(z[4], z[3]);
    localBundle.putInt(z[7], 2);
    localBundle.putInt(z[15], paramInt);
    JCoreInterface.sendAction(paramContext, d.a, localBundle);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramBoolean) || (JCoreInterface.canCallDirect()))
    {
      MultiSpHelper.commitString(paramContext, z[5] + paramString1, paramString2);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString(z[4], z[3]);
    localBundle.putInt(z[7], 1);
    localBundle.putString(z[6], paramString1);
    localBundle.putString(z[8], paramString2);
    JCoreInterface.sendAction(paramContext, d.a, localBundle);
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) || (JCoreInterface.canCallDirect()))
    {
      MultiSpHelper.commitString(paramContext, z[11], paramString);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString(z[4], z[3]);
    localBundle.putInt(z[7], 4);
    localBundle.putString(z[12], paramString);
    JCoreInterface.sendAction(paramContext, d.a, localBundle);
  }
  
  public static String b(Context paramContext)
  {
    return MultiSpHelper.getString(paramContext, z[9], "");
  }
  
  public static void b(Context paramContext, String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) || (JCoreInterface.canCallDirect()))
    {
      MultiSpHelper.commitString(paramContext, z[9], paramString);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString(z[4], z[3]);
    localBundle.putInt(z[7], 3);
    localBundle.putString(z[10], paramString);
    JCoreInterface.sendAction(paramContext, d.a, localBundle);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */