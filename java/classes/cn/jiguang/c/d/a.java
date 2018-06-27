package cn.jiguang.c.d;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import cn.jiguang.api.JAction;
import cn.jiguang.api.SdkType;
import cn.jiguang.c.b.g;
import cn.jiguang.c.e.a.a.c;
import cn.jiguang.d.d;
import cn.jiguang.f.h;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public static HashMap<String, JAction> a;
  private static a b;
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[13];
    int j = 0;
    Object localObject2 = "\0077\020\002U\f<'GO\021)&]";
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
        i = 59;
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
        localObject2 = "):7\016T\006\024\"\tZ\017<1";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "\t='&X\0340,\t\033\034 3\002\001";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "EtnJ\026E8 \023R\0077y";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "\00080GH\t4&GO\021)&GZ\013-*\bU";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "H*'\f\033\t:7\016T\006y*\024\033\006,/\013";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        j = 6;
        localObject2 = "H*'\f\033\001*c\tN\0045";
        i = 5;
        localObject1 = arrayOfString;
        break;
      case 5: 
        localObject3[i4] = localObject1;
        j = 7;
        localObject2 = "H*'\f\033\t:7\016T\006y0\003P\036<1\024R\0077y";
        i = 6;
        localObject1 = arrayOfString;
        break;
      case 6: 
        localObject3[i4] = localObject1;
        j = 8;
        localObject2 = "\037+\"\027h\f2\025\002I\0330,\tr\006?,G]\t0/\002_Hu \bU\0348*\t^\032y*\024\033\006,/\013";
        i = 7;
        localObject1 = arrayOfString;
        break;
      case 7: 
        localObject3[i4] = localObject1;
        j = 9;
        localObject2 = "\01361\002d\033=(8M\r+";
        i = 8;
        localObject1 = arrayOfString;
        break;
      case 8: 
        localObject3[i4] = localObject1;
        j = 10;
        localObject2 = "\033=(8M\r+";
        i = 9;
        localObject1 = arrayOfString;
        break;
      case 9: 
        localObject3[i4] = localObject1;
        j = 11;
        localObject2 = "\033-\"\023R\033-*\004H7*'\fd\036<1";
        i = 10;
        localObject1 = arrayOfString;
        break;
      case 10: 
        localObject3[i4] = localObject1;
        j = 12;
        localObject2 = "\0331\"\025^7*'\fd\036<1";
        i = 11;
        localObject1 = arrayOfString;
        break;
      case 11: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        a = new HashMap();
        a(cn.jiguang.c.a.a, e.class.getName());
        return;
        i = 104;
        continue;
        i = 89;
        continue;
        i = 67;
        continue;
        i = 103;
      }
    }
  }
  
  public static a a()
  {
    if (b == null) {
      b = new a();
    }
    return b;
  }
  
  public static void a(Context paramContext, long paramLong, int paramInt)
  {
    Iterator localIterator = a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      JAction localJAction = (JAction)((Map.Entry)localIterator.next()).getValue();
      if (localJAction != null) {
        localJAction.onEvent(paramContext, paramLong, paramInt);
      }
    }
  }
  
  public static void a(Context paramContext, c paramc, ByteBuffer paramByteBuffer)
  {
    Iterator localIterator = a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      JAction localJAction = (JAction)localEntry.getValue();
      if ((localJAction != null) && (localJAction.isSupportedCMD(paramc.a())))
      {
        paramc.a(Long.valueOf(localJAction.dispatchMessage(paramContext, g.a.get(), paramc.a(), paramc, paramByteBuffer)));
        cn.jiguang.c.b.e.a();
        cn.jiguang.c.b.e.a((String)localEntry.getKey(), paramc);
      }
    }
  }
  
  public static void a(Context paramContext, String paramString, long paramLong, Bundle paramBundle, Handler paramHandler)
  {
    paramString = (JAction)a.get(paramString);
    if (paramString != null) {
      paramString.onActionRun(paramContext, paramLong, paramBundle, paramHandler);
    }
  }
  
  public static void a(Context paramContext, String paramString, Object paramObject)
  {
    d.a(z[1], z[0] + paramString);
    if (h.a(paramString))
    {
      paramString = a.entrySet().iterator();
      while (paramString.hasNext())
      {
        JAction localJAction = (JAction)((Map.Entry)paramString.next()).getValue();
        cn.jiguang.c.b.e.a();
        localJAction.handleMessage(paramContext, cn.jiguang.c.b.e.h(), paramObject);
      }
    }
    paramString = (JAction)a.get(paramString);
    if (paramString != null)
    {
      cn.jiguang.c.b.e.a();
      paramString.handleMessage(paramContext, cn.jiguang.c.b.e.h(), paramObject);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    d.a(z[1], z[2] + paramString1 + z[3] + paramString2);
    if (!a.containsKey(paramString1)) {
      try
      {
        paramString2 = Class.forName(paramString2).newInstance();
        if ((paramString2 instanceof JAction)) {
          a.put(paramString1, (JAction)paramString2);
        }
        return;
      }
      catch (ClassNotFoundException paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      catch (InstantiationException paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      catch (IllegalAccessException paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
    }
    d.c(z[1], z[4]);
  }
  
  public static IBinder b(String paramString1, String paramString2)
  {
    paramString1 = (JAction)a.get(paramString1);
    if (paramString1 != null) {
      return paramString1.getBinderByType(paramString2);
    }
    return null;
  }
  
  public static void b(Context paramContext, long paramLong, int paramInt)
  {
    Iterator localIterator = a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      JAction localJAction = (JAction)((Map.Entry)localIterator.next()).getValue();
      if (localJAction != null) {
        localJAction.dispatchTimeOutMessage(paramContext, g.a.get(), paramLong, paramInt);
      }
    }
  }
  
  public static String c(String paramString1, String paramString2)
  {
    if (a.containsKey(paramString1))
    {
      JAction localJAction = (JAction)a.get(paramString1);
      if (localJAction != null)
      {
        if (!TextUtils.isEmpty(localJAction.getSdkVersion())) {
          return localJAction.getSdkVersion();
        }
        d.a(z[1], paramString1 + z[7] + localJAction.getSdkVersion());
        return paramString2;
      }
      d.a(z[1], paramString1 + z[5]);
      return paramString2;
    }
    d.a(z[1], paramString1 + z[6]);
    return paramString2;
  }
  
  public final boolean a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      d.g(z[1], z[8]);
      return false;
    }
    try
    {
      paramJSONObject.put(z[10], c(SdkType.JPUSH.name(), ""));
      paramJSONObject.put(z[9], c(SdkType.JCORE.name(), ""));
      paramJSONObject.put(z[12], c(SdkType.JSHARE.name(), ""));
      paramJSONObject.put(z[11], c(SdkType.JANALYTICS.name(), ""));
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */