package com.ziroom.commonlibrary.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.alibaba.fastjson.a;
import com.baidu.location.BDLocation;
import com.freelxl.baselibrary.f.f;
import java.util.HashMap;
import java.util.Map;

public class c
{
  public static void clearLoginInfo(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("login_info", 0).edit();
    paramContext.remove("token");
    paramContext.remove("uid");
    paramContext.apply();
  }
  
  public static BDLocation getBDLocation(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("login_info", 0).getString("location_info_bd_latitude", "");
    if (f.isNull(paramContext)) {
      return null;
    }
    return (BDLocation)a.parseObject(paramContext, BDLocation.class);
  }
  
  public static int getLastLoginType(Context paramContext)
  {
    return paramContext.getSharedPreferences("login_info", 0).getInt("login_last", 0);
  }
  
  public static Map<String, String> getLocation(Context paramContext)
  {
    Object localObject = paramContext.getSharedPreferences("login_info", 0);
    paramContext = ((SharedPreferences)localObject).getString("location_info_latitude", "");
    localObject = ((SharedPreferences)localObject).getString("location_info_longitude", "");
    if ((!TextUtils.isEmpty(paramContext)) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("latitude", paramContext);
      localHashMap.put("longitude", localObject);
      return localHashMap;
    }
    return null;
  }
  
  public static String getToken(Context paramContext)
  {
    return paramContext.getSharedPreferences("login_info", 0).getString("token", null);
  }
  
  public static String getUid(Context paramContext)
  {
    return paramContext.getSharedPreferences("login_info", 0).getString("uid", null);
  }
  
  public static int getWebType(Context paramContext)
  {
    return paramContext.getSharedPreferences("Web_Type", 0).getInt("webType", 0);
  }
  
  public static void saveBDLocation(Context paramContext, BDLocation paramBDLocation)
  {
    paramContext = paramContext.getSharedPreferences("login_info", 0).edit();
    paramContext.putString("location_info_bd_latitude", a.toJSONString(paramBDLocation));
    paramContext.apply();
  }
  
  public static void saveLastLoginType(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("login_info", 0).edit();
    paramContext.putInt("login_last", paramInt);
    paramContext.apply();
  }
  
  public static void saveLocation(Context paramContext, double paramDouble1, double paramDouble2)
  {
    paramContext = paramContext.getSharedPreferences("login_info", 0).edit();
    paramContext.putString("location_info_latitude", paramDouble1 + "");
    paramContext.putString("location_info_longitude", paramDouble2 + "");
    paramContext.apply();
  }
  
  public static void saveLoginInfo(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences("login_info", 0).edit();
    paramContext.putString("token", paramString1);
    paramContext.putString("uid", paramString2);
    paramContext.apply();
  }
  
  public static void saveWebType(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("Web_Type", 0).edit();
    paramContext.putInt("webType", paramInt);
    paramContext.apply();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlibrary/g/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */