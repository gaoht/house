package cn.jpush.android.service;

import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.api.MultiSpHelper;
import cn.jpush.android.api.DefaultPushNotificationBuilder;
import cn.jpush.android.api.c;
import cn.jpush.android.c.f;
import cn.jpush.android.d;
import cn.jpush.android.e;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class ServiceInterface
{
  private static boolean a;
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[25];
    int j = 0;
    Object localObject2 = "\004cDL.";
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
        i = 93;
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
        localObject2 = "\026j\\r4\001";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "\004lYD2\013";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "\006a\003G-\020|E\003<\013k_B4\001!DC)\000aY\003\034)Fl~\0021Nj~";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "\021nJ^";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "\026j_[4\006j\rD.E}XC3\faJ\r<\t}HL9\034";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "\026j_[4\006jr^)\nHI";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "\006a\003G-\020|E\003<\013k_B4\001!DC)\000aY\003\017 \\yb\017 _x~\025";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "\004]";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "6j_[4\006jdC)\000}KL>\000";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = "\026{L_)-`X_";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        j = 11;
        localObject2 = "\000aIY\020\fa^";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i4] = localObject1;
        j = 12;
        localObject2 = "\000aIe2\020}";
        i = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i4] = localObject1;
        j = 13;
        localObject2 = "\026{L_)(fC^";
        i = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i4] = localObject1;
        j = 14;
        localObject2 = "\006a\003G-\020|E\003<\013k_B4\001!DC)\000aY\003\0161@}}\b6G";
        i = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject3[i4] = localObject1;
        j = 15;
        localObject2 = "\026j_[4\006j\rL1\027jLI$E|YB-";
        i = 14;
        localObject1 = arrayOfString;
        break;
      case 14: 
        localObject3[i4] = localObject1;
        j = 16;
        localObject2 = "\026jYc2\021fKD>\004{DB3+z@O8\027/\000\r>\naYH%\021/D^}\013zAA|";
        i = 15;
        localObject1 = arrayOfString;
        break;
      case 15: 
        localObject3[i4] = localObject1;
        j = 17;
        localObject2 = "\026jY\r3\n{DK4\006nYD2\013/@L%EaX@}_/";
        i = 16;
        localObject1 = arrayOfString;
        break;
      case 16: 
        localObject3[i4] = localObject1;
        j = 18;
        localObject2 = "\006cHL/$cAc2\021fKD>\004{DB3E\"\rN2\013{HU)Ef^\r3\020cA\f";
        i = 17;
        localObject1 = arrayOfString;
        break;
      case 17: 
        localObject3[i4] = localObject1;
        j = 19;
        localObject2 = "H/^H)+`YD;\flLY4\naoX4\tkH_}H/";
        i = 18;
        localObject1 = arrayOfString;
        break;
      case 18: 
        localObject3[i4] = localObject1;
        j = 20;
        localObject2 = "+zAA}\006`CY8\035{\001\r-\tjL^8EfCD)EE}X.\r.";
        i = 19;
        localObject1 = arrayOfString;
        break;
      case 19: 
        localObject3[i4] = localObject1;
        j = 21;
        localObject2 = "I/^Y2\025[T]8_";
        i = 20;
        localObject1 = arrayOfString;
        break;
      case 20: 
        localObject3[i4] = localObject1;
        j = 22;
        localObject2 = "\025fI\027";
        i = 21;
        localObject1 = arrayOfString;
        break;
      case 21: 
        localObject3[i4] = localObject1;
        j = 23;
        localObject2 = "V!\035\003l";
        i = 22;
        localObject1 = arrayOfString;
        break;
      case 22: 
        localObject3[i4] = localObject1;
        j = 24;
        localObject2 = "1gH\r.\000}[D>\000/D^}\026{B]-\000k\001\r4\021/ZD1\t/JD+\000/X]}\004cA\r)\rj\rL>\021fBC.EzCY4\t/TB(ElLA1E}H^(\bj}X.\r/@H)\r`I\r)\n/_H.\020bH\r)\rj\r^8\027yDN8K";
        i = 23;
        localObject1 = arrayOfString;
        break;
      case 23: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        a = false;
        return;
        i = 101;
        continue;
        i = 15;
        continue;
        i = 45;
        continue;
        i = 45;
      }
    }
  }
  
  public static String a()
  {
    return z[23];
  }
  
  public static void a(Context paramContext)
  {
    if (d(paramContext)) {
      return;
    }
    JCoreInterface.restart(paramContext, d.a, new Bundle(), false);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    if (1 == e(paramContext))
    {
      f.d(z[9], z[15]);
      return;
    }
    MultiSpHelper.commitInt(paramContext, z[6], 1);
    Bundle localBundle = new Bundle();
    localBundle.putString(z[2], z[14]);
    localBundle.putString(z[8], paramContext.getPackageName());
    JCoreInterface.stop(paramContext, d.a, localBundle);
  }
  
  public static void a(Context paramContext, Integer paramInteger, DefaultPushNotificationBuilder paramDefaultPushNotificationBuilder)
  {
    if (paramContext == null)
    {
      f.j(z[9], z[20]);
      return;
    }
    f.e(z[9], z[19] + paramDefaultPushNotificationBuilder.toString());
    e.a(paramContext, paramInteger, paramDefaultPushNotificationBuilder.toString(), false);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (d(paramContext))) {
      return;
    }
    e.a(paramContext, paramString, false);
  }
  
  public static void a(Context paramContext, String paramString, ArrayList<String> paramArrayList, long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString(z[2], z[3]);
    localBundle.putString(z[0], paramString);
    localBundle.putStringArrayList(z[4], paramArrayList);
    localBundle.putLong(z[1], paramLong);
    JCoreInterface.sendAction(paramContext, d.a, localBundle);
  }
  
  public static boolean a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put(z[10], paramInt1);
      localJSONObject.put(z[13], paramInt2);
      localJSONObject.put(z[12], paramInt3);
      localJSONObject.put(z[11], paramInt4);
      a(paramContext, localJSONObject.toString());
      return true;
    }
    catch (JSONException paramContext) {}
    return false;
  }
  
  public static void b(Context paramContext)
  {
    if (paramContext == null)
    {
      f.h(z[9], z[18]);
      return;
    }
    c.a(paramContext.getApplicationContext(), false);
  }
  
  public static void b(Context paramContext, int paramInt)
  {
    if (e(paramContext) == 0)
    {
      f.d(z[9], z[5]);
      return;
    }
    MultiSpHelper.commitInt(paramContext, z[6], 0);
    Bundle localBundle = new Bundle();
    localBundle.putString(z[2], z[7]);
    localBundle.putString(z[8], paramContext.getPackageName());
    JCoreInterface.restart(paramContext, d.a, localBundle, true);
  }
  
  public static void c(Context paramContext, int paramInt)
  {
    if (paramContext == null)
    {
      f.h(z[9], z[16]);
      return;
    }
    f.a(z[9], z[17] + paramInt);
    e.a(paramContext, paramInt, false);
  }
  
  public static boolean c(Context paramContext)
  {
    return e(paramContext) > 0;
  }
  
  public static boolean d(Context paramContext)
  {
    boolean bool = c(paramContext);
    if (bool) {
      f.d(z[9], z[24]);
    }
    return bool;
  }
  
  private static int e(Context paramContext)
  {
    int i = MultiSpHelper.getInt(paramContext, z[6], 0);
    f.c(z[9], z[22] + Process.myPid() + z[21] + i);
    return i;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/service/ServiceInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */