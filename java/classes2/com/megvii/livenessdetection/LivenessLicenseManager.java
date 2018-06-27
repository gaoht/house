package com.megvii.livenessdetection;

import android.content.Context;
import com.megvii.a.a.b;
import com.megvii.a.a.c;
import com.megvii.a.a.e;
import com.megvii.licensemanager.ILicenseManager;
import java.security.InvalidParameterException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LivenessLicenseManager
  implements ILicenseManager
{
  private Context a;
  private e b;
  
  static
  {
    try
    {
      System.loadLibrary("livenessdetection_v2.4.4");
      return;
    }
    catch (Exception localException) {}
  }
  
  public LivenessLicenseManager(Context paramContext)
  {
    if (paramContext == null) {
      throw new InvalidParameterException("mContext cannot be null");
    }
    this.a = paramContext.getApplicationContext();
    c.a(this.a).a("livenessdetection", "v2.4.4");
    this.b = new e(this.a);
  }
  
  private String a(Context paramContext)
  {
    JSONArray localJSONArray = new JSONArray();
    if (paramContext == null) {
      return localJSONArray.toString();
    }
    if (!"false".equals(this.b.a("49668163590f816aaf863df014568115")))
    {
      paramContext = this.b.b("8cd0604ba33e2ba7f38a56f0aec08a54");
      if (paramContext == null) {}
    }
    for (;;)
    {
      try
      {
        paramContext = new JSONArray(paramContext);
        return paramContext.toString();
      }
      catch (Exception paramContext) {}
      paramContext = localJSONArray;
    }
  }
  
  private native String nativeCheckLicense(Context paramContext, String paramString);
  
  private native String nativeGenAuthMsg(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6);
  
  public long checkCachedLicense()
  {
    String str = this.b.a("a01625815f3428cb69100cc5d613fa7d");
    if ((str == null) || (!Detector.getVersion().equals(this.b.a("bc8f6a70d138545889109d126886bd98")))) {}
    for (;;)
    {
      return 0L;
      try
      {
        long l1 = Long.parseLong(str);
        long l2 = System.currentTimeMillis() / 1000L;
        if (l2 <= l1) {
          return l1;
        }
      }
      catch (Exception localException) {}
    }
    return 0L;
  }
  
  public String getContext(String paramString)
  {
    Object localObject1 = b.a();
    String str = System.currentTimeMillis();
    this.b.a("809bd36cf78612fd1f11b739c382bfac", b.a(this.a.getPackageName().getBytes()));
    this.b.a("37dbd151eb3ca24477bc27cf0febcbe3", str);
    str = this.b.a("cb072839e1e240a23baae123ca6cf165");
    paramString = nativeGenAuthMsg(this.a, this.a.getPackageName(), paramString, ((JSONObject)localObject1).toString(), System.currentTimeMillis() / 1000L, a(this.a), str);
    try
    {
      Object localObject2 = new JSONObject(paramString);
      paramString = ((JSONObject)localObject2).getString("auth");
      localObject1 = ((JSONObject)localObject2).getString("seed");
      localObject2 = ((JSONObject)localObject2).getString("key");
      try
      {
        i = Integer.parseInt(this.b.a("5f389fef5fd41c84a33a91c6574cbf51"));
        this.b.a("5f389fef5fd41c84a33a91c6574cbf51", i + 1);
        this.b.a("b62f7aea9613b98976498a9ecabe537b", (String)localObject2);
        if (!((String)localObject1).equals(str)) {
          this.b.a("cb072839e1e240a23baae123ca6cf165", (String)localObject1);
        }
        return paramString;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i = 0;
        }
      }
      return null;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public String getVersion()
  {
    return Detector.getVersion();
  }
  
  public long setLicense(String paramString)
  {
    long l2;
    if ((this.a == null) || (paramString == null) || (paramString.length() == 0)) {
      l2 = 0L;
    }
    for (;;)
    {
      return l2;
      this.a = this.a.getApplicationContext();
      if ((this.b.a("b62f7aea9613b98976498a9ecabe537b") == null) || (this.b.a("cb072839e1e240a23baae123ca6cf165") == null)) {
        return 0L;
      }
      Object localObject = this.b.a("cb072839e1e240a23baae123ca6cf165") + ":" + this.b.a("b62f7aea9613b98976498a9ecabe537b") + ":" + paramString;
      localObject = nativeCheckLicense(this.a, (String)localObject);
      try
      {
        localObject = new JSONObject((String)localObject);
        l1 = ((JSONObject)localObject).getLong("expire_time");
      }
      catch (Exception localException1)
      {
        try
        {
          long l1;
          int i = new JSONObject(((JSONObject)localObject).getString("extra")).getInt("max_saved_log");
          this.b.a("889109d126886bd98bc8f6a70d138545", i);
          for (;;)
          {
            l2 = l1;
            if (l1 == 0L) {
              break;
            }
            this.b.a("a01625815f3428cb69100cc5d613fa7d", l1);
            this.b.a("e2380b201325a8f252636350338aeae8", this.b.a("b62f7aea9613b98976498a9ecabe537b") + ":" + paramString);
            this.b.a("bc8f6a70d138545889109d126886bd98", Detector.getVersion());
            return l1;
            localException1 = localException1;
            l1 = 0L;
          }
        }
        catch (Exception localException2)
        {
          for (;;) {}
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/livenessdetection/LivenessLicenseManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */