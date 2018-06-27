package com.mato.sdk.c.a;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.mato.sdk.d.f;
import com.mato.sdk.d.h;
import com.mato.sdk.d.j;
import com.mato.sdk.d.k;
import com.mato.sdk.d.l;
import com.mato.sdk.d.m;
import com.mato.sdk.g.i;
import com.mato.sdk.proxy.Proxy;
import com.mato.sdk.proxy.Proxy.AccesslogListener;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class e
  implements b
{
  private static int c = 0;
  private static int d = 1;
  private static int e = 2;
  private final Proxy.AccesslogListener a;
  private final a b;
  
  public e() {}
  
  public e(Proxy.AccesslogListener paramAccesslogListener, Context paramContext)
  {
    if (paramAccesslogListener == null) {
      throw new IllegalArgumentException("listener can not be null");
    }
    if (paramContext == null) {
      throw new IllegalArgumentException("context can not be null");
    }
    this.a = paramAccesslogListener;
    this.b = new a(i.a(paramContext, "unknown"), Proxy.getVersion(), i.f(paramContext), String.format(Locale.US, "android/%s", new Object[] { Build.VERSION.RELEASE }), String.format(Locale.US, "%s/%s", new Object[] { Build.MODEL, Build.MANUFACTURER }), null);
  }
  
  public static boolean a(com.mato.sdk.d.e parame)
  {
    return (parame != null) && (parame.b() != null);
  }
  
  public static boolean a(f paramf)
  {
    return (paramf != null) && (paramf.c() != 0) && (paramf.a() > 0);
  }
  
  public static boolean a(h paramh)
  {
    if (paramh != null)
    {
      if ((paramh.a != null) || (paramh.b != null)) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(k paramk)
  {
    return (paramk != null) && (paramk.d());
  }
  
  private static boolean a(l paraml)
  {
    return paraml != null;
  }
  
  public static boolean a(m paramm)
  {
    return (paramm != null) && (paramm.c());
  }
  
  public static boolean a(List<j> paramList)
  {
    return paramList != null;
  }
  
  public static boolean b(List<com.mato.sdk.d.b> paramList)
  {
    return (paramList != null) && (!paramList.isEmpty());
  }
  
  public final void a(String paramString)
  {
    try
    {
      paramString = this.b.a(paramString);
      if (paramString != null) {
        this.a.onAccesslog(paramString);
      }
      return;
    }
    catch (Throwable paramString) {}
  }
  
  static final class a
  {
    private static final int A = 26;
    private static final int B = 27;
    private static final int C = 28;
    private static final int D = 29;
    private static final int E = 30;
    private static final int F = 31;
    private static final int a = 0;
    private static final int b = 1;
    private static final int c = 2;
    private static final int d = 3;
    private static final int e = 4;
    private static final int f = 5;
    private static final int g = 6;
    private static final int h = 7;
    private static final int i = 8;
    private static final int j = 9;
    private static final int k = 10;
    private static final int l = 11;
    private static final int m = 12;
    private static final int n = 13;
    private static final int o = 14;
    private static final int p = 15;
    private static final int q = 16;
    private static final int r = 17;
    private static final int s = 18;
    private static final int t = 19;
    private static final int u = 20;
    private static final int v = 21;
    private static final int w = 22;
    private static final int x = 23;
    private static final int y = 24;
    private static final int z = 25;
    private final String G;
    private final String H;
    private final String I;
    private final String J;
    private final String K;
    private final String L;
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    {
      this.G = paramString1;
      this.H = paramString2;
      this.I = paramString3;
      this.J = paramString4;
      this.K = paramString5;
      this.L = null;
    }
    
    private static String b(String paramString)
    {
      return paramString.replace("\"", "");
    }
    
    public final String a(String paramString)
      throws JSONException
    {
      Object localObject = paramString.split("\t");
      if ((localObject == null) || (localObject.length < 32)) {
        return null;
      }
      paramString = b(localObject[3]);
      if ((this.L != null) && (paramString.contains(this.L))) {
        return null;
      }
      long l1 = (Double.valueOf(localObject[0]).doubleValue() * 1000.0D);
      String str1 = b(localObject[1]);
      String str2 = b(localObject[2]);
      String str3 = b(localObject[4]);
      int i1 = Integer.valueOf(localObject[5]).intValue();
      int i2 = Integer.valueOf(localObject[6]).intValue();
      int i3 = Integer.valueOf(localObject[7]).intValue();
      int i4 = Integer.valueOf(localObject[8]).intValue();
      int i5 = Integer.valueOf(localObject[9]).intValue();
      int i6 = Integer.valueOf(localObject[10]).intValue();
      int i7 = Integer.valueOf(localObject[11]).intValue();
      int i8 = Integer.valueOf(localObject[12]).intValue();
      int i9 = Integer.valueOf(localObject[13]).intValue();
      int i10 = Integer.valueOf(localObject[14]).intValue();
      int i11 = Integer.valueOf(localObject[15]).intValue();
      String str4 = b(localObject[16]);
      String str5 = b(localObject[17]);
      String str6 = b(localObject[18]);
      String str7 = b(localObject[19]);
      String str8 = b(localObject[20]);
      String str9 = b(localObject[21]);
      int i12 = Integer.valueOf(localObject[22]).intValue();
      int i13 = Integer.valueOf(localObject[23]).intValue();
      String str10 = b(localObject[24]);
      String str11 = b(localObject[25]);
      String str12 = b(localObject[26]);
      int i14 = Integer.valueOf(localObject[27]).intValue();
      int i15 = Integer.valueOf(localObject[28]).intValue();
      int i16 = Integer.valueOf(localObject[29]).intValue();
      String str13 = b(localObject[30]);
      localObject = b(localObject[31]);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("timestamp", l1);
      localJSONObject.put("ViaProxy", str1);
      localJSONObject.put("method", str2);
      localJSONObject.put("url", paramString);
      localJSONObject.put("contentType", str3);
      localJSONObject.put("returnCode", i1);
      localJSONObject.put("dns", i2);
      localJSONObject.put("connect", i3);
      localJSONObject.put("send", i4);
      localJSONObject.put("waiting", i5);
      localJSONObject.put("recving", i6);
      localJSONObject.put("process", i7);
      localJSONObject.put("block", i8);
      localJSONObject.put("relContentLength", i9);
      localJSONObject.put("original", i10);
      localJSONObject.put("optimized", i11);
      localJSONObject.put("expires", str4);
      localJSONObject.put("lastModified", str5);
      localJSONObject.put("appName", str6);
      localJSONObject.put("destHost", str7);
      localJSONObject.put("bypassReason", str8);
      localJSONObject.put("fetchingTime", str9);
      localJSONObject.put("wspTime", i12);
      localJSONObject.put("signalStrength", i13);
      localJSONObject.put("xErrorFrom", str10);
      localJSONObject.put("maaHost", str11);
      localJSONObject.put("networkType", str12);
      localJSONObject.put("postLength", i14);
      localJSONObject.put("actionEventBypass", i15);
      localJSONObject.put("actionEventProxy", i16);
      localJSONObject.put("genericDomainPrefix", str13);
      localJSONObject.put("hijackCase", localObject);
      localJSONObject.put("deviceId", this.G);
      localJSONObject.put("sdkVersion", this.H);
      localJSONObject.put("appVersion", this.I);
      localJSONObject.put("platform", this.J);
      localJSONObject.put("model", this.K);
      return localJSONObject.toString();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/c/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */