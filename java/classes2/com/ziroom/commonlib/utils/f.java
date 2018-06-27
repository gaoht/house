package com.ziroom.commonlib.utils;

import android.app.Activity;
import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.Settings.Secure;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Xml;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

public class f
{
  private static String a;
  
  public static void callPhone(Context paramContext, String paramString)
  {
    if (!r.isEmpty(paramString))
    {
      paramString = paramString.trim();
      paramString = new Intent("android.intent.action.CALL", Uri.parse("tel:" + paramString));
      if (ActivityCompat.checkSelfPermission(paramContext, "android.permission.CALL_PHONE") == 0) {}
    }
    else
    {
      return;
    }
    paramContext.startActivity(paramString);
  }
  
  public static int dp2px(float paramFloat)
  {
    return (int)(d.a.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static List<HashMap<String, String>> getAllContactInfo(Context paramContext)
  {
    SystemClock.sleep(3000L);
    ArrayList localArrayList = new ArrayList();
    paramContext = paramContext.getContentResolver();
    Object localObject1 = Uri.parse("content://com.android.contacts/raw_contacts");
    Uri localUri = Uri.parse("content://com.android.contacts/data");
    localObject1 = paramContext.query((Uri)localObject1, new String[] { "contact_id" }, null, null, null);
    while (((Cursor)localObject1).moveToNext())
    {
      Object localObject2 = ((Cursor)localObject1).getString(0);
      if (!r.isEmpty((String)localObject2))
      {
        localObject2 = paramContext.query(localUri, new String[] { "data1", "mimetype" }, "raw_contact_id=?", new String[] { localObject2 }, null);
        HashMap localHashMap = new HashMap();
        while (((Cursor)localObject2).moveToNext())
        {
          String str1 = ((Cursor)localObject2).getString(0);
          String str2 = ((Cursor)localObject2).getString(1);
          if (str2.equals("vnd.android.cursor.item/phone_v2")) {
            localHashMap.put("phone", str1);
          } else if (str2.equals("vnd.android.cursor.item/name")) {
            localHashMap.put("name", str1);
          }
        }
        localArrayList.add(localHashMap);
        ((Cursor)localObject2).close();
      }
    }
    ((Cursor)localObject1).close();
    return localArrayList;
  }
  
  public static void getAllSMS()
  {
    Cursor localCursor = d.a.getContentResolver().query(Uri.parse("content://sms"), new String[] { "address", "date", "type", "body" }, null, null, null);
    localCursor.getCount();
    XmlSerializer localXmlSerializer = Xml.newSerializer();
    try
    {
      localXmlSerializer.setOutput(new FileOutputStream(new File("/mnt/sdcard/backupsms.xml")), "utf-8");
      localXmlSerializer.startDocument("utf-8", Boolean.valueOf(true));
      localXmlSerializer.startTag(null, "smss");
      while (localCursor.moveToNext())
      {
        SystemClock.sleep(1000L);
        localXmlSerializer.startTag(null, "sms");
        localXmlSerializer.startTag(null, "address");
        String str1 = localCursor.getString(0);
        localXmlSerializer.text(str1);
        localXmlSerializer.endTag(null, "address");
        localXmlSerializer.startTag(null, "date");
        String str2 = localCursor.getString(1);
        localXmlSerializer.text(str2);
        localXmlSerializer.endTag(null, "date");
        localXmlSerializer.startTag(null, "type");
        String str3 = localCursor.getString(2);
        localXmlSerializer.text(str3);
        localXmlSerializer.endTag(null, "type");
        localXmlSerializer.startTag(null, "body");
        String str4 = localCursor.getString(3);
        localXmlSerializer.text(str4);
        localXmlSerializer.endTag(null, "body");
        localXmlSerializer.endTag(null, "sms");
        System.out.println("address:" + str1 + "   date:" + str2 + "  type:" + str3 + "  body:" + str4);
      }
      localXmlSerializer.endTag(null, "smss");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    localXmlSerializer.endDocument();
    localXmlSerializer.flush();
  }
  
  public static String getAndroidId()
  {
    return Settings.Secure.getString(d.a.getContentResolver(), "android_id");
  }
  
  public static String getAppMetaData(String paramString)
  {
    if ((d.a == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return null;
      try
      {
        Object localObject = d.a.getPackageManager();
        if (localObject != null)
        {
          localObject = ((PackageManager)localObject).getApplicationInfo(d.a.getPackageName(), 128);
          if ((localObject != null) && (((ApplicationInfo)localObject).metaData != null))
          {
            paramString = ((ApplicationInfo)localObject).metaData.getString(paramString);
            return paramString;
          }
        }
      }
      catch (PackageManager.NameNotFoundException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public static String getAppVersion()
  {
    Object localObject1 = null;
    Object localObject2 = d.a.getPackageManager();
    try
    {
      localObject2 = ((PackageManager)localObject2).getPackageInfo(d.a.getPackageName(), 0);
      localObject1 = localObject2;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        localNameNotFoundException.printStackTrace();
      }
    }
    return ((PackageInfo)localObject1).versionCode + "";
  }
  
  public static String getDeviceId()
  {
    return ((TelephonyManager)d.a.getSystemService("phone")).getDeviceId();
  }
  
  public static String getDeviceId(Context paramContext)
  {
    return ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
  }
  
  public static String getIMEI()
  {
    if (isPhone()) {
      return getDeviceId();
    }
    return getAndroidId();
  }
  
  public static String getLine1Number()
  {
    return ((TelephonyManager)d.a.getSystemService("phone")).getLine1Number();
  }
  
  public static String getMac()
  {
    if (!TextUtils.isEmpty(a)) {
      return a;
    }
    try
    {
      Enumeration localEnumeration = NetworkInterface.getNetworkInterfaces();
      while (localEnumeration.hasMoreElements())
      {
        NetworkInterface localNetworkInterface = (NetworkInterface)localEnumeration.nextElement();
        Object localObject = localNetworkInterface.getHardwareAddress();
        if ((localObject != null) && (localObject.length != 0))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            localStringBuilder.append(String.format("%02X:", new Object[] { Byte.valueOf(localObject[i]) }));
            i += 1;
          }
          if (localStringBuilder.length() > 0) {
            localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
          }
          localObject = localStringBuilder.toString();
          if (localNetworkInterface.getName().contains("wlan")) {
            a = (String)localObject;
          }
        }
      }
      return a;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static String getMetaData(String paramString)
  {
    try
    {
      paramString = d.a.getPackageManager().getApplicationInfo(d.a.getPackageName(), 128).metaData.get(paramString);
      if (paramString != null)
      {
        paramString = paramString.toString();
        return paramString;
      }
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static String getPackageName()
  {
    try
    {
      String str = d.a.getPackageManager().getPackageInfo(d.a.getPackageName(), 0).packageName;
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  public static String getPhoneInfo()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("Product: " + Build.PRODUCT + ", CPU_ABI: " + Build.CPU_ABI + ", TAGS: " + Build.TAGS + ", VERSION_CODES.BASE: " + 1 + ", MODEL: " + Build.MODEL + ", SDK: " + Build.VERSION.SDK + ", VERSION.RELEASE: " + Build.VERSION.RELEASE + ", DEVICE: " + Build.DEVICE + ", DISPLAY: " + Build.DISPLAY + ", BRAND: " + Build.BRAND + ", BOARD: " + Build.BOARD + ", FINGERPRINT: " + Build.FINGERPRINT + ", ID: " + Build.ID + ", MANUFACTURER: " + Build.MANUFACTURER + ", USER: " + Build.USER);
    return localStringBuffer.toString();
  }
  
  public static int getScreenHeight()
  {
    WindowManager localWindowManager = (WindowManager)d.a.getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics.heightPixels;
  }
  
  public static int getScreenWidth()
  {
    WindowManager localWindowManager = (WindowManager)d.a.getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics.widthPixels;
  }
  
  public static String getSimSerialNumber()
  {
    return ((TelephonyManager)d.a.getSystemService("phone")).getSimSerialNumber();
  }
  
  public static int getStatusHeight()
  {
    try
    {
      Class localClass = Class.forName("com.android.internal.R$dimen");
      Object localObject = localClass.newInstance();
      int i = Integer.parseInt(localClass.getField("status_bar_height").get(localObject).toString());
      i = d.a.getResources().getDimensionPixelSize(i);
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return -1;
  }
  
  public static String getSubscriberId()
  {
    return ((TelephonyManager)d.a.getSystemService("phone")).getSubscriberId();
  }
  
  public static String getUserAgent()
  {
    Object localObject = "";
    if (r.isNull(""))
    {
      String str = q.getOtherString("mUserAgent");
      localObject = str;
      if (r.isNull(str))
      {
        localObject = new WebView(d.a).getSettings().getUserAgentString();
        q.putOtherString("mUserAgent", (String)localObject);
      }
    }
    return (String)localObject;
  }
  
  public static String getVersion()
  {
    try
    {
      String str = d.a.getPackageManager().getPackageInfo(d.a.getPackageName(), 0).versionName;
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  public static void hideKeyboard(Activity paramActivity, View paramView)
  {
    ((InputMethodManager)paramActivity.getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
  }
  
  public static void hideSoftInput(Activity paramActivity)
  {
    View localView = paramActivity.getWindow().peekDecorView();
    if (localView != null) {
      ((InputMethodManager)paramActivity.getSystemService("input_method")).hideSoftInputFromWindow(localView.getWindowToken(), 0);
    }
  }
  
  public static void hideSoftInput(EditText paramEditText)
  {
    paramEditText.clearFocus();
    ((InputMethodManager)d.a.getSystemService("input_method")).hideSoftInputFromWindow(paramEditText.getWindowToken(), 0);
  }
  
  public static boolean isKeyboardShown(View paramView)
  {
    Rect localRect = new Rect();
    paramView.getWindowVisibleDisplayFrame(localRect);
    DisplayMetrics localDisplayMetrics = paramView.getResources().getDisplayMetrics();
    return paramView.getBottom() - localRect.bottom > localDisplayMetrics.density * 100.0F;
  }
  
  public static boolean isLandscape()
  {
    return d.a.getResources().getConfiguration().orientation == 2;
  }
  
  public static boolean isPhone()
  {
    return ((TelephonyManager)d.a.getSystemService("phone")).getPhoneType() != 0;
  }
  
  public static boolean isPortrait()
  {
    return d.a.getResources().getConfiguration().orientation == 1;
  }
  
  public static int px2dp(float paramFloat)
  {
    return (int)(paramFloat / d.a.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public static void sendSms(Context paramContext, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("smsto:");
    Object localObject = paramString1;
    if (r.isEmpty(paramString1)) {
      localObject = "";
    }
    localObject = new Intent("android.intent.action.SENDTO", Uri.parse((String)localObject));
    paramString1 = paramString2;
    if (r.isEmpty(paramString2)) {
      paramString1 = "";
    }
    ((Intent)localObject).putExtra("sms_body", paramString1);
    paramContext.startActivity((Intent)localObject);
  }
  
  public static void setLandscape(Activity paramActivity)
  {
    paramActivity.setRequestedOrientation(0);
  }
  
  public static void setPortrait(Activity paramActivity)
  {
    paramActivity.setRequestedOrientation(1);
  }
  
  public static void showSoftInput(EditText paramEditText)
  {
    paramEditText.setFocusable(true);
    paramEditText.setFocusableInTouchMode(true);
    paramEditText.requestFocus();
    ((InputMethodManager)d.a.getSystemService("input_method")).showSoftInput(paramEditText, 0);
  }
  
  public static Bitmap snapShotWithStatusBar(Activity paramActivity)
  {
    paramActivity = paramActivity.getWindow().getDecorView();
    paramActivity.setDrawingCacheEnabled(true);
    paramActivity.buildDrawingCache();
    Bitmap localBitmap = Bitmap.createBitmap(paramActivity.getDrawingCache(), 0, 0, getScreenWidth(), getScreenHeight());
    paramActivity.destroyDrawingCache();
    return localBitmap;
  }
  
  public static Bitmap snapShotWithoutStatusBar(Activity paramActivity)
  {
    View localView = paramActivity.getWindow().getDecorView();
    localView.setDrawingCacheEnabled(true);
    localView.buildDrawingCache();
    Bitmap localBitmap = localView.getDrawingCache();
    Rect localRect = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    int i = localRect.top;
    paramActivity = Bitmap.createBitmap(localBitmap, 0, i, getScreenWidth(), getScreenHeight() - i);
    localView.destroyDrawingCache();
    return paramActivity;
  }
  
  public static void toggleSoftInput(EditText paramEditText)
  {
    paramEditText.setFocusable(true);
    paramEditText.setFocusableInTouchMode(true);
    paramEditText.requestFocus();
    ((InputMethodManager)d.a.getSystemService("input_method")).toggleSoftInput(2, 0);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlib/utils/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */