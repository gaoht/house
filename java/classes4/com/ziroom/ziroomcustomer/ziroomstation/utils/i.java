package com.ziroom.ziroomcustomer.ziroomstation.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import com.ziroom.commonlibrary.widget.unifiedziroom.c;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.util.m;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class i
{
  public static boolean TextisEmpty(CharSequence paramCharSequence)
  {
    return (paramCharSequence == null) || (paramCharSequence.length() == 0) || ("null".equals(paramCharSequence));
  }
  
  public static boolean checkEmail(String paramString)
  {
    return paramString.matches("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+");
  }
  
  public static boolean checkMobilePhone(String paramString)
  {
    return Pattern.compile("^(1[3-9][0-9])\\d{8}").matcher(paramString).matches();
  }
  
  public static String checkString(String paramString)
  {
    String str;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (!"null".equals(paramString)) {}
    }
    else
    {
      str = "";
    }
    return str;
  }
  
  public static void commonOkDialog(Context paramContext, String paramString, a parama)
  {
    c.newBuilder(paramContext).setTitle("提示").setContent(paramString).setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          this.a.okCallback();
        }
      }
    }).build().show();
  }
  
  public static String getAppVersion(Context paramContext)
  {
    Object localObject = null;
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      paramContext = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0);
      return paramContext.versionCode + "";
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = (Context)localObject;
      }
    }
  }
  
  public static String getIMEI(Context paramContext)
  {
    return ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
  }
  
  public static String getLanguage()
  {
    return Locale.getDefault().getLanguage();
  }
  
  public static String getPhoneBrand()
  {
    return Build.BRAND;
  }
  
  public static String getPhoneModel()
  {
    return Build.MODEL;
  }
  
  public static String getSysVersion()
  {
    return Build.VERSION.RELEASE;
  }
  
  public static String getTimeStamp()
  {
    return String.valueOf(m.TimeS2L(m.GetNowDateTime(), m.c));
  }
  
  public static String getTimeStampMilli()
  {
    return String.valueOf(Calendar.getInstance().getTimeInMillis());
  }
  
  public static boolean isLegal(List<?> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    while (paramList.size() <= 0) {
      return false;
    }
    return true;
  }
  
  public static String listToString(List<String> paramList)
  {
    if (isLegal(paramList))
    {
      Iterator localIterator = paramList.iterator();
      StringBuilder localStringBuilder;
      for (paramList = "";; paramList = paramList)
      {
        localObject = paramList;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (String)localIterator.next();
        localStringBuilder = new StringBuilder().append(paramList);
        paramList = (List<String>)localObject;
        if (TextisEmpty((CharSequence)localObject)) {
          paramList = "";
        }
      }
    }
    Object localObject = "";
    return (String)localObject;
  }
  
  public static abstract interface a
  {
    public abstract void okCallback();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/utils/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */