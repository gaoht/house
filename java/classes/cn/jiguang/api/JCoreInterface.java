package cn.jiguang.api;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import cn.jiguang.a.a.c.a.a.c;
import cn.jiguang.c.d.i;
import cn.jiguang.c.d.l;
import cn.jiguang.net.HttpResponse;
import cn.jiguang.net.HttpUtils;
import java.lang.reflect.Method;
import org.json.JSONArray;
import org.json.JSONObject;

public class JCoreInterface
{
  private static boolean a;
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[28];
    int j = 0;
    Object localObject2 = "b<O2Pa=";
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
        i = 41;
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
        localObject2 = "c-JhHr,M)G";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "u9P'Z";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "b=J\"[t)Q#Ze<E2H?9G2@~6";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "e1I#Fd,";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "r5@";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "b=J\"Mp,EhHr,M)G";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "[\033K4LX6P#[w9G#";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "P;P/Fx\tfZt,p#Ze\033K(GX\bt)[exM6\023";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "1(K4]+";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = "r6\n,Yd+LhH<V)@uvM(]t6PhzE\027t\026|B\020";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        j = 11;
        localObject2 = "r6\n,Yd+LhH<V)@uvM(]t6Ph`_\021p";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i4] = localObject1;
        j = 12;
        localObject2 = "P;P/Fx\tf@1Pf[t?M5]t*k(Ehb";
        i = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i4] = localObject1;
        j = 13;
        localObject2 = "r6\n,Yd+LhH<V)@uvM(]t6Ph{T\013p\t{T\bq\025a";
        i = 12;
        localObject1 = arrayOfString;
        break;
      case 12: 
        localObject3[i4] = localObject1;
        j = 14;
        localObject2 = "p6@4Fx<\n'Yave%]x.M2P";
        i = 13;
        localObject1 = arrayOfString;
        break;
      case 13: 
        localObject3[i4] = localObject1;
        j = 15;
        localObject2 = "p6@4Fx<\n6Lc5M5Zx7Jh{T\031`\031lI\fa\024gP\024{\025}^\ne\001l";
        i = 14;
        localObject1 = arrayOfString;
        break;
      case 14: 
        localObject3[i4] = localObject1;
        j = 16;
        localObject2 = "p6@4Fx<\n6Lc5M5Zx7Jh{T\031`\031yY\027j\003vB\fe\022l";
        i = 15;
        localObject1 = arrayOfString;
        break;
      case 15: 
        localObject3[i4] = localObject1;
        j = 17;
        localObject2 = "p6@4Fx<\n6Lc5M5Zx7Jh~C\021p\003vT\000p\003{_\031h\031zE\027v\007nT";
        i = 16;
        localObject1 = arrayOfString;
        break;
      case 16: 
        localObject3[i4] = localObject1;
        j = 18;
        localObject2 = "p6@4Fx<\n6Lc5M5Zx7JhhR\033a\025zN\036m\blN\024k\005hE\021k\b";
        i = 17;
        localObject1 = arrayOfString;
        break;
      case 17: 
        localObject3[i4] = localObject1;
        j = 19;
        localObject2 = "c=U3Lb,t#[|1W5@~6W";
        i = 18;
        localObject1 = arrayOfString;
        break;
      case 18: 
        localObject3[i4] = localObject1;
        j = 20;
        localObject2 = "J*A7\\t+P\026Lc5M5Zx7J\033\tr7J2Li,\0041HbxJ3E}";
        i = 19;
        localObject1 = arrayOfString;
        break;
      case 19: 
        localObject3[i4] = localObject1;
        j = 21;
        localObject2 = "a=V+@b+M)Gb\024M5]+";
        i = 20;
        localObject1 = arrayOfString;
        break;
      case 20: 
        localObject3[i4] = localObject1;
        j = 22;
        localObject2 = "2-J#Qr=T2Lux\tf[t)Q#Ze\bA4Dx+W/FxA|";
        i = 21;
        localObject1 = arrayOfString;
        break;
      case 21: 
        localObject3[i4] = localObject1;
        j = 23;
        localObject2 = "J*A7\\t+P\026Lc5M5Zx7J\033\tr7J2Li,\004+\\b,\004/Gb,E(Jt7Bfhr,M0@e!";
        i = 22;
        localObject1 = arrayOfString;
        break;
      case 22: 
        localObject3[i4] = localObject1;
        j = 24;
        localObject2 = "[\033K4L11J/]1>E/Et<";
        i = 23;
        localObject1 = arrayOfString;
        break;
      case 23: 
        localObject3[i4] = localObject1;
        j = 25;
        localObject2 = "d6A>Jt(P#M1u\004%F,A>]1/E5\t-H*";
        i = 24;
        localObject1 = arrayOfString;
        break;
      case 24: 
        localObject3[i4] = localObject1;
        j = 26;
        localObject2 = "}:W\031[t(K4]N=J'K}=";
        i = 25;
        localObject1 = arrayOfString;
        break;
      case 25: 
        localObject3[i4] = localObject1;
        j = 27;
        localObject2 = "p;P/Fx\tfZt,m+eS\013a(Hs4AkJ~6P4F}";
        i = 26;
        localObject1 = arrayOfString;
        break;
      case 26: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        a = false;
        return;
        i = 17;
        continue;
        i = 88;
        continue;
        i = 36;
        continue;
        i = 70;
      }
    }
  }
  
  public static boolean canCallDirect()
  {
    return (cn.jiguang.c.a.m != null) || (!cn.jiguang.c.a.k);
  }
  
  public static boolean getAesConfig()
  {
    return true;
  }
  
  public static String getAppKey()
  {
    return cn.jiguang.c.a.f;
  }
  
  public static IBinder getBinderByType(String paramString1, String paramString2)
  {
    if (cn.jiguang.c.a.m == null) {
      return null;
    }
    try
    {
      paramString1 = cn.jiguang.c.a.m.c(paramString1, paramString2);
      return paramString1;
    }
    catch (RemoteException paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public static String getChannel()
  {
    if (!a) {
      return null;
    }
    return cn.jiguang.c.a.a.z();
  }
  
  public static String getCommonConfigAppkey()
  {
    if (!a) {
      return "";
    }
    return cn.jiguang.c.a.a.y();
  }
  
  public static boolean getConnectionState(Context paramContext)
  {
    if (!init(paramContext, false)) {}
    do
    {
      return false;
      paramContext = cn.jiguang.c.a.a.c(paramContext);
    } while (cn.jiguang.c.b.a.a != paramContext);
    return true;
  }
  
  public static boolean getDebugMode()
  {
    return cn.jiguang.c.a.b;
  }
  
  public static String getDeviceId(Context paramContext)
  {
    if (!cn.jiguang.c.a.a(paramContext)) {
      return "";
    }
    return cn.jiguang.f.a.g(paramContext);
  }
  
  public static String getHttpConfig(Context paramContext, String paramString)
  {
    Object localObject = null;
    if (!cn.jiguang.c.a.a(paramContext)) {
      paramContext = "";
    }
    do
    {
      do
      {
        return paramContext;
        paramString = HttpUtils.httpGet(null, l.c(paramString));
        paramContext = (Context)localObject;
      } while (paramString == null);
      paramContext = (Context)localObject;
    } while (paramString.getResponseCode() != 200);
    return paramString.getResponseBody();
  }
  
  public static int getJCoreSDKVersionInt()
  {
    return 110;
  }
  
  public static long getNextRid()
  {
    if (!a) {
      return 0L;
    }
    return cn.jiguang.c.a.a.i();
  }
  
  public static String getRegistrationID(Context paramContext)
  {
    if (!init(paramContext, false)) {
      return "";
    }
    return cn.jiguang.c.a.a.v();
  }
  
  public static long getReportTime()
  {
    if (!a) {
      return System.currentTimeMillis() / 1000L;
    }
    return cn.jiguang.c.a.a.g();
  }
  
  public static boolean getRuningFlag()
  {
    return cn.jiguang.c.b.b.a();
  }
  
  public static int getSid()
  {
    if (!a) {
      return 0;
    }
    return cn.jiguang.c.a.a.D();
  }
  
  public static boolean getTestConn()
  {
    return cn.jiguang.c.a.a.c;
  }
  
  public static long getUid()
  {
    if (!a) {
      return 0L;
    }
    return cn.jiguang.c.a.a.r();
  }
  
  public static boolean init(Context paramContext, boolean paramBoolean)
  {
    if (a) {
      return true;
    }
    if (paramContext == null)
    {
      cn.jiguang.d.d.h(z[7], z[25]);
      return false;
    }
    if (!cn.jiguang.c.a.a(paramContext))
    {
      cn.jiguang.d.d.h(z[7], z[24]);
      return false;
    }
    a = true;
    return true;
  }
  
  public static void initAction(String paramString, Class<? extends JAction> paramClass)
  {
    cn.jiguang.c.d.a.a(paramString, paramClass.getName());
  }
  
  public static void initCrashHandler(Context paramContext)
  {
    if (!cn.jiguang.c.a.a(paramContext)) {
      return;
    }
    cn.jiguang.a.a.b.d.a().b(paramContext);
  }
  
  public static boolean isTcpConnected()
  {
    return cn.jiguang.c.a.a.E();
  }
  
  public static boolean isValidRegistered()
  {
    if (!a) {
      return false;
    }
    return cn.jiguang.c.a.a.s();
  }
  
  public static void onFragmentPause(Context paramContext, String paramString)
  {
    if (!cn.jiguang.c.a.a(paramContext)) {
      return;
    }
    cn.jiguang.a.a.c.b.a().b(paramContext, paramString);
  }
  
  public static void onFragmentResume(Context paramContext, String paramString)
  {
    if (!cn.jiguang.c.a.a(paramContext)) {
      return;
    }
    cn.jiguang.a.a.c.b.a().a(paramContext, paramString);
  }
  
  public static void onKillProcess(Context paramContext)
  {
    if (!cn.jiguang.c.a.a(paramContext)) {
      return;
    }
    cn.jiguang.a.a.c.b.a().c(paramContext);
  }
  
  public static void onPause(Context paramContext)
  {
    if (!cn.jiguang.c.a.a(paramContext)) {}
    while (!c.a) {
      return;
    }
    cn.jiguang.a.a.c.b.a().b(paramContext);
  }
  
  public static void onResume(Context paramContext)
  {
    if (!cn.jiguang.c.a.a(paramContext)) {}
    while (!c.a) {
      return;
    }
    cn.jiguang.a.a.c.b.a().a(paramContext);
  }
  
  public static void processCtrlReport(int paramInt)
  {
    cn.jiguang.a.c.a.a(paramInt);
  }
  
  public static void register(Context paramContext)
  {
    if (!init(paramContext, true)) {
      return;
    }
    cn.jiguang.d.d.c(z[7], z[12]);
    Bundle localBundle = new Bundle();
    i.a().b(paramContext, z[11], localBundle);
  }
  
  public static boolean reportHttpData(Context paramContext, Object paramObject, String paramString)
  {
    if (!cn.jiguang.c.a.a(paramContext)) {
      return false;
    }
    if (paramObject != null)
    {
      if (!(paramObject instanceof JSONObject)) {
        break label31;
      }
      l.a(paramContext, (JSONObject)paramObject, paramString);
    }
    for (;;)
    {
      return true;
      label31:
      if ((paramObject instanceof JSONArray)) {
        l.a(paramContext, (JSONArray)paramObject, paramString);
      }
    }
  }
  
  public static void requestPermission(Context paramContext)
  {
    if (paramContext == null) {
      cn.jiguang.d.d.h(z[7], z[20]);
    }
    do
    {
      return;
      if (!(paramContext instanceof Activity))
      {
        cn.jiguang.d.d.h(z[7], z[23]);
        return;
      }
    } while (Build.VERSION.SDK_INT < 23);
    String[] arrayOfString = new String[4];
    arrayOfString[0] = z[17];
    arrayOfString[1] = z[15];
    arrayOfString[2] = z[18];
    arrayOfString[3] = z[16];
    cn.jiguang.d.d.a(z[7], z[21] + arrayOfString);
    try
    {
      Class.forName(z[14]).getDeclaredMethod(z[19], new Class[] { String[].class, Integer.TYPE }).invoke(paramContext, new Object[] { arrayOfString, Integer.valueOf(1) });
      return;
    }
    catch (Exception paramContext)
    {
      cn.jiguang.d.d.h(z[7], z[22] + paramContext.getMessage());
    }
  }
  
  public static void restart(Context paramContext, String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    if (!init(paramContext, false)) {
      return;
    }
    paramBundle.putString(z[0], paramString);
    if (paramBoolean) {}
    for (paramString = z[13];; paramString = z[11])
    {
      i.a().b(paramContext, paramString, paramBundle);
      return;
    }
  }
  
  public static void sendAction(Context paramContext, String paramString, Bundle paramBundle)
  {
    if (!cn.jiguang.c.a.a(paramContext)) {
      return;
    }
    paramBundle.putString(z[0], paramString);
    i.a().b(paramContext, z[1], paramBundle);
  }
  
  public static void sendData(Context paramContext, String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    if (!init(paramContext, false)) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString(z[0], paramString);
    localBundle.putByteArray(z[2], paramArrayOfByte);
    localBundle.putInt(z[5], paramInt);
    i.a().b(paramContext, z[6], localBundle);
  }
  
  public static void sendRequestData(Context paramContext, String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    if (!init(paramContext, false)) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString(z[0], paramString);
    localBundle.putByteArray(z[2], paramArrayOfByte);
    localBundle.putInt(z[4], paramInt);
    i.a().b(paramContext, z[3], localBundle);
  }
  
  public static void setAnalysisAction(JAnalyticsAction paramJAnalyticsAction)
  {
    if (paramJAnalyticsAction != null) {
      cn.jiguang.a.a.a = paramJAnalyticsAction;
    }
  }
  
  public static void setCanLaunchedStoppedService(boolean paramBoolean)
  {
    cn.jiguang.c.a.l = paramBoolean;
  }
  
  public static void setDebugMode(boolean paramBoolean)
  {
    cn.jiguang.c.a.b = paramBoolean;
  }
  
  public static void setImLBSEnable(Context paramContext, boolean paramBoolean)
  {
    cn.jiguang.d.d.c(z[7], z[27]);
    if (!cn.jiguang.c.a.a(paramContext)) {
      return;
    }
    MultiSpHelper.commitBoolean(paramContext, z[26], paramBoolean);
  }
  
  public static void setTestConn(boolean paramBoolean)
  {
    cn.jiguang.c.a.a.c = paramBoolean;
  }
  
  public static void setTestConnIPPort(String paramString, int paramInt)
  {
    cn.jiguang.d.d.c(z[7], z[8] + paramString + z[9] + paramInt);
    cn.jiguang.c.a.a.a = paramString;
    cn.jiguang.c.a.a.b = paramInt;
  }
  
  public static void stop(Context paramContext, String paramString, Bundle paramBundle)
  {
    if (!init(paramContext, false)) {
      return;
    }
    paramBundle.putString(z[0], paramString);
    i.a().b(paramContext, z[10], paramBundle);
  }
  
  public static void stopCrashHandler(Context paramContext)
  {
    if (!cn.jiguang.c.a.a(paramContext)) {
      return;
    }
    cn.jiguang.a.a.b.d.a().c(paramContext);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/api/JCoreInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */