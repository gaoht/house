package com.ziroom.ziroomcustomer.util;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.umeng.analytics.MobclickAgent;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.model.UserInfo;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class w
{
  public static void onDuration(String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    try
    {
      if ((ApplicationEx.c.getUser() != null) && (!TextUtils.isEmpty(ApplicationEx.c.getUser().getUid()))) {
        localHashMap.put("uid", ApplicationEx.c.getUser().getUid());
      }
      while ((!TextUtils.isEmpty(paramString)) && (paramInt > 0))
      {
        MobclickAgent.onEventValue(ApplicationEx.c, paramString, localHashMap, paramInt);
        return;
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        localHashMap.put("uid", "Guest-" + localSimpleDateFormat.format(new Date()));
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static void onEvent(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    MobclickAgent.onEvent(paramContext, paramString);
  }
  
  public static void onEvent(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      MobclickAgent.onEvent(ApplicationEx.c, paramString);
    }
  }
  
  public static void onEventToZiroomAndUmeng(String paramString)
  {
    onEvent(paramString);
  }
  
  public static void onEventValue(Context paramContext, String paramString, Map<String, String> paramMap, int paramInt)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)) || (paramMap == null) || (paramInt < 0)) {
      return;
    }
    MobclickAgent.onEventValue(paramContext, paramString, paramMap, paramInt);
  }
  
  public static void onEventValueToZiroomAndUmeng(String paramString, Map<String, String> paramMap)
  {
    onEventValue(ApplicationEx.c, paramString, paramMap, 0);
    paramString = new StringBuilder();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      paramString.append((String)localEntry.getKey()).append("=").append((String)localEntry.getValue());
      if (paramMap.hasNext()) {
        paramString.append("#");
      }
    }
  }
  
  public static void onFragmentPause(FragmentActivity paramFragmentActivity, String paramString)
  {
    if ((paramFragmentActivity == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    MobclickAgent.onPageEnd(paramString);
    MobclickAgent.onPause(paramFragmentActivity);
  }
  
  public static void onFragmentResume(FragmentActivity paramFragmentActivity, String paramString)
  {
    if ((paramFragmentActivity == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    MobclickAgent.onPageStart(paramString);
    MobclickAgent.onResume(paramFragmentActivity);
  }
  
  public static void onPause(Activity paramActivity)
  {
    if (paramActivity != null) {
      MobclickAgent.onPause(paramActivity);
    }
  }
  
  public static void onResume(Activity paramActivity)
  {
    if (paramActivity != null) {
      MobclickAgent.onResume(paramActivity);
    }
  }
  
  public static void setDebugMode(boolean paramBoolean)
  {
    MobclickAgent.setDebugMode(paramBoolean);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/util/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */