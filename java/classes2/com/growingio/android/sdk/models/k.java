package com.growingio.android.sdk.models;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.growingio.android.sdk.circle.c;
import com.growingio.android.sdk.collection.AppState;
import com.growingio.android.sdk.collection.GConfig;
import com.growingio.android.sdk.utils.LogUtil;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class k
  extends g
{
  private static JSONObject b;
  private String a;
  private boolean c = false;
  
  private k(String paramString)
  {
    this.a = paramString;
  }
  
  public static k a(String paramString)
  {
    return new k(paramString);
  }
  
  private static boolean a(Context paramContext)
  {
    return ((TelephonyManager)paramContext.getSystemService("phone")).getPhoneType() != 0;
  }
  
  public static k d()
  {
    if (b == null) {
      return null;
    }
    k localk = new k(null);
    localk.c = true;
    return localk;
  }
  
  public String a()
  {
    return "vst";
  }
  
  public String a_()
  {
    return "visit";
  }
  
  public JSONObject c()
  {
    if ((this.c) && (b != null))
    {
      a(b);
      return b;
    }
    b = l();
    for (;;)
    {
      try
      {
        b.put("t", "vst");
        g(b);
        a(b);
        b(b);
        d(b);
        e(b);
        c(b);
        f(b);
        b.put("b", "native");
        b.put("l", Locale.getDefault().toString());
        b.put("ch", k().p());
        localContext = j().k();
        localObject1 = new DisplayMetrics();
        localObject2 = ((WindowManager)localContext.getSystemService("window")).getDefaultDisplay();
        if (Build.VERSION.SDK_INT < 17) {
          continue;
        }
        ((Display)localObject2).getRealMetrics((DisplayMetrics)localObject1);
        b.put("sh", ((DisplayMetrics)localObject1).heightPixels);
        b.put("sw", ((DisplayMetrics)localObject1).widthPixels);
        localObject2 = b;
        if (Build.BRAND != null) {
          continue;
        }
        localObject1 = "UNKNOWN";
      }
      catch (JSONException localJSONException)
      {
        Context localContext;
        Object localObject1;
        Object localObject2;
        JSONObject localJSONObject;
        LogUtil.d("GIO.VPAEvent", "generation the Visit Event error", localJSONException);
        continue;
        String str = Build.BRAND;
        continue;
        str = Build.MODEL;
        continue;
        str = Build.VERSION.RELEASE;
        continue;
        str = str.versionName;
        continue;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        LogUtil.d("GIO.VPAEvent", "get PackageInfo error", localNameNotFoundException);
        continue;
        int i = 0;
        continue;
      }
      ((JSONObject)localObject2).put("db", localObject1);
      localObject2 = b;
      if (Build.MODEL != null) {
        continue;
      }
      localObject1 = "UNKNOWN";
      ((JSONObject)localObject2).put("dm", localObject1);
      localObject1 = b;
      if (!a(localContext)) {
        continue;
      }
      i = 1;
      ((JSONObject)localObject1).put("ph", i);
      b.put("os", "Android");
      localObject2 = b;
      if (Build.VERSION.RELEASE != null) {
        continue;
      }
      localObject1 = "UNKNOWN";
      ((JSONObject)localObject2).put("osv", localObject1);
      localObject1 = ((TelephonyManager)localContext.getSystemService("phone")).getSimOperator();
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).length() > 3)) {
        b.put("ca", new StringBuffer((String)localObject1).insert(3, '-').toString());
      }
      localObject2 = localContext.getPackageManager();
      localObject1 = ((PackageManager)localObject2).getPackageInfo(j().b(), 0);
      localJSONObject = b;
      if (!c.e().a()) {
        continue;
      }
      localObject1 = "1.1.2_dcb91e54";
      localJSONObject.put("cv", localObject1);
      b.put("av", "1.1.2_dcb91e54");
      b.put("sn", ((PackageManager)localObject2).getApplicationLabel(localContext.getApplicationInfo()));
      b.put("v", GConfig.sGrowingScheme);
      b.put("p", this.a);
      return b;
      ((Display)localObject2).getMetrics((DisplayMetrics)localObject1);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/models/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */