package com.umeng.analytics.social;

import android.content.Context;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.by;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public abstract class e
{
  private static Map<String, String> a;
  
  private static String a(List<String> paramList)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      localByteArrayOutputStream.write(URLEncoder.encode(paramList.toString()).getBytes());
      paramList = localByteArrayOutputStream.toString();
      return paramList;
    }
    catch (Exception paramList)
    {
      paramList.printStackTrace();
    }
    return null;
  }
  
  private static List<String> a(UMPlatformData... paramVarArgs)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    StringBuilder localStringBuilder3 = new StringBuilder();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      UMPlatformData localUMPlatformData = paramVarArgs[i];
      localStringBuilder1.append(localUMPlatformData.getMeida().toString());
      localStringBuilder1.append(',');
      localStringBuilder2.append(localUMPlatformData.getUsid());
      localStringBuilder2.append(',');
      localStringBuilder3.append(localUMPlatformData.getWeiboId());
      localStringBuilder3.append(',');
      i += 1;
    }
    if (paramVarArgs.length > 0)
    {
      localStringBuilder1.deleteCharAt(localStringBuilder1.length() - 1);
      localStringBuilder2.deleteCharAt(localStringBuilder2.length() - 1);
      localStringBuilder3.deleteCharAt(localStringBuilder3.length() - 1);
    }
    paramVarArgs = new ArrayList();
    paramVarArgs.add("platform=" + localStringBuilder1.toString());
    paramVarArgs.add("usid=" + localStringBuilder2.toString());
    if (localStringBuilder3.length() > 0) {
      paramVarArgs.add("weiboid=" + localStringBuilder3.toString());
    }
    return paramVarArgs;
  }
  
  public static Map<String, String> a(Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = (TelephonyManager)paramContext.getSystemService("phone");
    if (localObject1 == null) {
      by.b("No IMEI.");
    }
    try
    {
      if (bv.a(paramContext, "android.permission.READ_PHONE_STATE"))
      {
        localObject1 = ((TelephonyManager)localObject1).getDeviceId();
        String str = bv.q(paramContext);
        paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
        if (!TextUtils.isEmpty(str)) {
          localHashMap.put("mac", str);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localHashMap.put("imei", localObject1);
        }
        if (!TextUtils.isEmpty(paramContext)) {
          localHashMap.put("android_id", paramContext);
        }
        return localHashMap;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        by.e(localException);
        Object localObject2 = null;
      }
    }
  }
  
  protected static String[] a(Context paramContext, String paramString, UMPlatformData... paramVarArgs)
    throws a
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      throw new a("platform data is null");
    }
    String str = AnalyticsConfig.getAppkey(paramContext);
    if (TextUtils.isEmpty(str)) {
      throw new a("can`t get appkey.");
    }
    ArrayList localArrayList = new ArrayList();
    str = "http://log.umsns.com/share/api/" + str + "/";
    if ((a == null) || (a.isEmpty())) {
      a = b(paramContext);
    }
    if ((a != null) && (!a.isEmpty()))
    {
      paramContext = a.entrySet().iterator();
      while (paramContext.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramContext.next();
        localArrayList.add((String)localEntry.getKey() + "=" + (String)localEntry.getValue());
      }
    }
    localArrayList.add("date=" + String.valueOf(System.currentTimeMillis()));
    localArrayList.add("channel=" + d.d);
    if (!TextUtils.isEmpty(paramString)) {
      localArrayList.add("topic=" + paramString);
    }
    localArrayList.addAll(a(paramVarArgs));
    paramContext = b(paramVarArgs);
    paramVarArgs = paramContext;
    if (paramContext == null) {
      paramVarArgs = "null";
    }
    for (paramString = str + "?" + a(localArrayList);; paramString = paramString.replace("%2C+", "&"))
    {
      paramContext = paramString;
      if (!paramString.contains("%2C+")) {
        break;
      }
    }
    for (;;)
    {
      paramString = paramContext;
      if (!paramContext.contains("%3D")) {
        break;
      }
      paramContext = paramContext.replace("%3D", "=");
    }
    for (;;)
    {
      paramContext = paramString;
      if (!paramString.contains("%5B")) {
        break;
      }
      paramString = paramString.replace("%5B", "");
    }
    while (paramContext.contains("%5D")) {
      paramContext = paramContext.replace("%5D", "");
    }
    by.b("url:" + paramContext + "\nBody:" + paramVarArgs);
    return new String[] { paramContext, paramVarArgs };
  }
  
  private static String b(UMPlatformData... paramVarArgs)
  {
    JSONObject localJSONObject1 = new JSONObject();
    int j = paramVarArgs.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        UMPlatformData localUMPlatformData = paramVarArgs[i];
        Object localObject = localUMPlatformData.getGender();
        String str = localUMPlatformData.getName();
        if (localObject == null) {}
        try
        {
          if (TextUtils.isEmpty(str)) {
            break label163;
          }
          JSONObject localJSONObject2 = new JSONObject();
          if (localObject == null)
          {
            localObject = "";
            localJSONObject2.put("gender", localObject);
            if (str != null) {
              break label125;
            }
          }
          label125:
          for (localObject = "";; localObject = String.valueOf(str))
          {
            localJSONObject2.put("name", localObject);
            localJSONObject1.put(localUMPlatformData.getMeida().toString(), localJSONObject2);
            break label163;
            localObject = String.valueOf(((UMPlatformData.GENDER)localObject).value);
            break;
          }
          if (localJSONObject1.length() != 0) {
            break label157;
          }
        }
        catch (Exception paramVarArgs)
        {
          throw new a("build body exception", paramVarArgs);
        }
      }
      return null;
      label157:
      return localJSONObject1.toString();
      label163:
      i += 1;
    }
  }
  
  private static Map<String, String> b(Context paramContext)
    throws a
  {
    HashMap localHashMap = new HashMap();
    Object localObject = a(paramContext);
    if ((localObject != null) && (!((Map)localObject).isEmpty()))
    {
      paramContext = new StringBuilder();
      StringBuilder localStringBuilder = new StringBuilder();
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if (!TextUtils.isEmpty((CharSequence)localEntry.getValue()))
        {
          localStringBuilder.append((String)localEntry.getKey()).append(",");
          paramContext.append((String)localEntry.getValue()).append(",");
        }
      }
      if (paramContext.length() > 0)
      {
        paramContext.deleteCharAt(paramContext.length() - 1);
        localHashMap.put("deviceid", paramContext.toString());
      }
      if (localStringBuilder.length() > 0)
      {
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
        localHashMap.put("idtype", localStringBuilder.toString());
      }
      return localHashMap;
    }
    throw new a("can`t get device id.");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/social/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */