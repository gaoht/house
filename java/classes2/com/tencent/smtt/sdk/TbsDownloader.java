package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.j;
import com.tencent.smtt.utils.m;
import com.tencent.smtt.utils.o;
import com.tencent.smtt.utils.w;
import java.io.File;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class TbsDownloader
{
  public static final boolean DEBUG_DISABLE_DOWNLOAD = false;
  public static boolean DOWNLOAD_OVERSEA_TBS = false;
  public static final String LOGTAG = "TbsDownload";
  static boolean a;
  private static String b;
  private static Context c;
  private static Handler d;
  private static String e;
  private static Object f = new byte[0];
  private static ab g;
  private static HandlerThread h;
  private static boolean i = false;
  private static boolean j = false;
  private static boolean k = false;
  
  protected static File a(int paramInt)
  {
    String[] arrayOfString = TbsShareManager.getCoreProviderAppList();
    Object localObject1 = null;
    int n = arrayOfString.length;
    int m = 0;
    Object localObject2 = localObject1;
    if (m < n)
    {
      localObject2 = arrayOfString[m];
      if (!((String)localObject2).equals(c.getApplicationInfo().packageName)) {}
    }
    for (;;)
    {
      m += 1;
      break;
      localObject2 = j.a(c, (String)localObject2, 4, false);
      if (getOverSea(c)) {}
      for (localObject1 = "x5.oversea.tbs.org";; localObject1 = "x5.tbs.org")
      {
        localObject1 = new File((String)localObject2, (String)localObject1);
        if ((localObject1 == null) || (!((File)localObject1).exists())) {
          break label157;
        }
        if (a.a(c, (File)localObject1) != paramInt) {
          break;
        }
        TbsLog.i("TbsDownload", "local tbs version fond,path = " + ((File)localObject1).getAbsolutePath());
        localObject2 = localObject1;
        return (File)localObject2;
      }
      TbsLog.i("TbsDownload", "version is not match");
      continue;
      label157:
      TbsLog.i("TbsDownload", "can not find local backup core file");
    }
  }
  
  static String a(Context paramContext)
  {
    if (!TextUtils.isEmpty(b)) {
      return b;
    }
    Locale localLocale = Locale.getDefault();
    localStringBuffer = new StringBuffer();
    paramContext = Build.VERSION.RELEASE;
    try
    {
      str = new String(paramContext.getBytes("UTF-8"), "ISO8859-1");
      paramContext = str;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        String str;
        continue;
        localStringBuffer.append("1.0");
        continue;
        localStringBuffer.append("en");
      }
    }
    if (paramContext.length() > 0)
    {
      localStringBuffer.append(paramContext);
      localStringBuffer.append("; ");
      paramContext = localLocale.getLanguage();
      if (paramContext == null) {
        break label228;
      }
      localStringBuffer.append(paramContext.toLowerCase());
      paramContext = localLocale.getCountry();
      if (paramContext != null)
      {
        localStringBuffer.append("-");
        localStringBuffer.append(paramContext.toLowerCase());
      }
      if ("REL".equals(Build.VERSION.CODENAME)) {
        paramContext = Build.MODEL;
      }
    }
    try
    {
      str = new String(paramContext.getBytes("UTF-8"), "ISO8859-1");
      paramContext = str;
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
    if (paramContext.length() > 0)
    {
      localStringBuffer.append("; ");
      localStringBuffer.append(paramContext);
    }
    paramContext = Build.ID.replaceAll("[一-龥]", "");
    if (paramContext.length() > 0)
    {
      localStringBuffer.append(" Build/");
      localStringBuffer.append(paramContext);
    }
    paramContext = String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 Mobile Safari/533.1", new Object[] { localStringBuffer });
    b = paramContext;
    return paramContext;
  }
  
  private static String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private static void a(boolean paramBoolean, TbsDownloaderCallback paramTbsDownloaderCallback)
  {
    int m = 0;
    TbsLog.i("TbsDownload", "[TbsDownloader.queryConfig]");
    d.removeMessages(100);
    Message localMessage = Message.obtain(d, 100);
    if (paramTbsDownloaderCallback != null) {
      localMessage.obj = paramTbsDownloaderCallback;
    }
    localMessage.arg1 = 0;
    if (paramBoolean) {
      m = 1;
    }
    localMessage.arg1 = m;
    localMessage.sendToTarget();
  }
  
  private static boolean a(Context paramContext, boolean paramBoolean, TbsDownloaderCallback paramTbsDownloaderCallback)
  {
    Object localObject = null;
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(paramContext);
    if (Build.VERSION.SDK_INT < 8) {
      localTbsDownloadConfig.setDownloadInterruptCode(-102);
    }
    do
    {
      return false;
      if ((QbSdk.c) || (!TbsShareManager.isThirdPartyApp(c)) || (c())) {
        break;
      }
    } while (paramTbsDownloaderCallback == null);
    paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
    return false;
    if (!localTbsDownloadConfig.mPreferences.contains("is_oversea"))
    {
      boolean bool = paramBoolean;
      if (paramBoolean)
      {
        bool = paramBoolean;
        if (!"com.tencent.mm".equals(paramContext.getApplicationInfo().packageName))
        {
          TbsLog.i("TbsDownload", "needDownload-oversea is true, but not WX");
          bool = false;
        }
      }
      localTbsDownloadConfig.a.put("is_oversea", Boolean.valueOf(bool));
      localTbsDownloadConfig.commit();
      j = bool;
      TbsLog.i("TbsDownload", "needDownload-first-called--isoversea = " + bool);
    }
    if ((getOverSea(paramContext)) && (Build.VERSION.SDK_INT != 16) && (Build.VERSION.SDK_INT != 17) && (Build.VERSION.SDK_INT != 18))
    {
      TbsLog.i("TbsDownload", "needDownload- return false,  because of  version is " + Build.VERSION.SDK_INT + ", and overea");
      if (paramTbsDownloaderCallback != null) {
        paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
      }
      localTbsDownloadConfig.setDownloadInterruptCode(-103);
      return false;
    }
    e = localTbsDownloadConfig.mPreferences.getString("device_cpuabi", null);
    if (!TextUtils.isEmpty(e)) {}
    try
    {
      paramContext = Pattern.compile("i686|mips|x86_64").matcher(e);
      if ((paramContext != null) && (paramContext.find()))
      {
        if (paramTbsDownloaderCallback != null) {
          paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
        }
        localTbsDownloadConfig.setDownloadInterruptCode(-104);
        return false;
      }
      return true;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = (Context)localObject;
      }
    }
  }
  
  private static boolean a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramContext = TbsDownloadConfig.getInstance(paramContext);
    if (!paramBoolean1)
    {
      String str1 = paramContext.mPreferences.getString("app_versionname", null);
      int m = paramContext.mPreferences.getInt("app_versioncode", 0);
      String str2 = paramContext.mPreferences.getString("app_metadata", null);
      String str3 = b.a(c);
      int n = b.b(c);
      String str4 = b.a(c, "com.tencent.mm.BuildInfo.CLIENT_VERSION");
      TbsLog.i("TbsDownload", "[TbsDownloader.needSendQueryRequest] appVersionName=" + str3 + " oldAppVersionName=" + str1 + " appVersionCode=" + n + " oldAppVersionCode=" + m + " appMetadata=" + str4 + " oldAppVersionMetadata=" + str2);
      long l2 = System.currentTimeMillis();
      long l3 = paramContext.mPreferences.getLong("last_check", 0L);
      TbsLog.i("TbsDownload", "[TbsDownloader.needSendQueryRequest] timeLastCheck=" + l3 + " timeNow=" + l2);
      long l1 = l3;
      if (paramBoolean2)
      {
        paramBoolean1 = paramContext.mPreferences.contains("last_check");
        TbsLog.i("TbsDownload", "[TbsDownloader.needSendQueryRequest] hasLaskCheckKey=" + paramBoolean1);
        l1 = l3;
        if (paramBoolean1)
        {
          l1 = l3;
          if (l3 == 0L) {
            l1 = l2;
          }
        }
      }
      l3 = paramContext.getRetryInterval();
      TbsLog.i("TbsDownload", "retryInterval = " + l3 + " s");
      if (l2 - l1 > 1000L * l3) {
        return true;
      }
      if ((TbsShareManager.isThirdPartyApp(c)) && (TbsShareManager.findCoreForThirdPartyApp(c) == 0) && (!e()))
      {
        j.b(c.getDir("tbs", 0));
        ai.a.set(Integer.valueOf(0));
        return true;
      }
      if ((str3 != null) && (n != 0) && (str4 != null) && ((!str3.equals(str1)) || (n != m) || (!str4.equals(str2)))) {
        return true;
      }
    }
    else
    {
      return true;
    }
    return false;
  }
  
  @TargetApi(11)
  private static boolean a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    TbsLog.i("TbsDownload", "[TbsDownloader.readResponse] response=" + paramString);
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(c);
    if (TextUtils.isEmpty(paramString))
    {
      if (paramBoolean1) {
        localTbsDownloadConfig.setDownloadInterruptCode(-108);
      }
      for (;;)
      {
        return false;
        localTbsDownloadConfig.setDownloadInterruptCode(65328);
      }
    }
    paramString = new JSONObject(paramString);
    if (paramString.getInt("RET") != 0)
    {
      if (paramBoolean1) {
        localTbsDownloadConfig.setDownloadInterruptCode(-109);
      }
      for (;;)
      {
        return false;
        localTbsDownloadConfig.setDownloadInterruptCode(65327);
      }
    }
    int i7 = paramString.getInt("RESPONSECODE");
    String str3 = paramString.getString("DOWNLOADURL");
    String str4 = paramString.optString("URLLIST", "");
    int i6 = paramString.getInt("TBSAPKSERVERVERSION");
    int i8 = paramString.getInt("DOWNLOADMAXFLOW");
    int i9 = paramString.getInt("DOWNLOAD_MIN_FREE_SPACE");
    int i10 = paramString.getInt("DOWNLOAD_SUCCESS_MAX_RETRYTIMES");
    int i11 = paramString.getInt("DOWNLOAD_FAILED_MAX_RETRYTIMES");
    long l2 = paramString.getLong("DOWNLOAD_SINGLE_TIMEOUT");
    long l3 = paramString.getLong("TBSAPKFILESIZE");
    l1 = paramString.optLong("RETRY_INTERVAL", 0L);
    int i12 = paramString.optInt("FLOWCTR", -1);
    m = 0;
    try
    {
      n = paramString.getInt("USEBBACKUPVER");
      m = n;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int n;
        int i1;
        int i4;
        int i5;
        int i2;
        continue;
        l1 = 86400L;
        continue;
        continue;
        paramString = "";
      }
    }
    localTbsDownloadConfig.a.put("use_backup_version", Integer.valueOf(m));
    i1 = 0;
    i4 = 0;
    i5 = 0;
    m = 0;
    for (;;)
    {
      try
      {
        str1 = paramString.getString("PKGMD5");
        i2 = i5;
        n = i4;
      }
      catch (Exception paramString)
      {
        int i3;
        i1 = 0;
        n = 0;
        m = 0;
        paramString = null;
        String str2 = "";
        i2 = m;
        String str1 = paramString;
        continue;
      }
      try
      {
        i3 = paramString.getInt("RESETX5");
        i2 = i5;
        n = i4;
        i1 = i3;
        i4 = paramString.getInt("UPLOADLOG");
        i2 = i5;
        n = i4;
        i1 = i3;
        if (paramString.has("RESETTOKEN"))
        {
          i2 = i5;
          n = i4;
          i1 = i3;
          if (paramString.getInt("RESETTOKEN") != 0)
          {
            m = 1;
            break label1676;
          }
        }
        else
        {
          i2 = m;
          n = i4;
          i1 = i3;
          if (!paramString.has("SETTOKEN")) {
            break label1670;
          }
          i2 = m;
          n = i4;
          i1 = i3;
          paramString = paramString.getString("SETTOKEN");
          i2 = i3;
          n = i4;
          i1 = m;
          str2 = paramString;
          paramString = f;
          if (i1 == 0) {}
        }
      }
      catch (Exception paramString)
      {
        m = i1;
        paramString = (String)localObject;
        i1 = i2;
        continue;
      }
      try
      {
        localTbsDownloadConfig.a.put("tbs_deskey_token", "");
        if ((!TextUtils.isEmpty(str2)) && (str2.length() == 96))
        {
          str2 = str2 + "&" + o.c();
          localTbsDownloadConfig.a.put("tbs_deskey_token", str2);
        }
        if (i2 != 1) {
          break;
        }
        if (!paramBoolean1) {
          break label576;
        }
        localTbsDownloadConfig.setDownloadInterruptCode(-110);
        QbSdk.reset(c);
        return false;
      }
      finally {}
      m = 0;
      break label1676;
      label576:
      localTbsDownloadConfig.setDownloadInterruptCode(65326);
    }
    if (n == 1)
    {
      d.removeMessages(104);
      Message.obtain(d, 104).sendToTarget();
    }
    if (i12 == 1)
    {
      if (l1 <= 604800L) {
        break label1667;
      }
      l1 = 604800L;
      if (l1 > 0L)
      {
        localTbsDownloadConfig.a.put("retry_interval", Long.valueOf(l1));
        if ((TextUtils.isEmpty(str3)) && (TbsShareManager.isThirdPartyApp(c)))
        {
          localTbsDownloadConfig.a.put("tbs_needdownload", Boolean.valueOf(false));
          localTbsDownloadConfig.commit();
          if (paramBoolean1) {
            TbsShareManager.writeCoreInfoForThirdPartyApp(c, i6, false);
          }
          return false;
        }
        if (i7 == 0)
        {
          localTbsDownloadConfig.a.put("tbs_needdownload", Boolean.valueOf(false));
          if (paramBoolean1) {
            localTbsDownloadConfig.a.put("tbs_download_interrupt_code_reason", Integer.valueOf(-111));
          }
          for (;;)
          {
            localTbsDownloadConfig.commit();
            return false;
            localTbsDownloadConfig.a.put("tbs_download_interrupt_code_reason", Integer.valueOf(65325));
            localTbsDownloadConfig.setDownloadInterruptCode(65325);
          }
        }
        n = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0);
        if (n > i6)
        {
          g.c();
          ai.a().f(c);
        }
        if ((paramInt >= i6) || (TextUtils.isEmpty(str3)))
        {
          localTbsDownloadConfig.a.put("tbs_needdownload", Boolean.valueOf(false));
          if (paramBoolean1)
          {
            if (TextUtils.isEmpty(str3)) {
              localTbsDownloadConfig.a.put("tbs_download_interrupt_code_reason", Integer.valueOf(-124));
            }
            for (;;)
            {
              localTbsDownloadConfig.commit();
              TbsLog.i("TbsDownload", "version error or downloadUrl empty ,return ahead tbsLocalVersion=" + paramInt + " tbsDownloadVersion=" + i6 + " tbsLastDownloadVersion=" + n + " downloadUrl=" + str3);
              return false;
              if (i6 <= 0) {
                localTbsDownloadConfig.a.put("tbs_download_interrupt_code_reason", Integer.valueOf(-125));
              } else if (paramInt >= i6) {
                localTbsDownloadConfig.a.put("tbs_download_interrupt_code_reason", Integer.valueOf(-127));
              } else {
                localTbsDownloadConfig.a.put("tbs_download_interrupt_code_reason", Integer.valueOf(-112));
              }
            }
          }
          m = 65324;
          if (TextUtils.isEmpty(str3)) {
            m = 65319;
          }
          for (;;)
          {
            localTbsDownloadConfig.a.put("tbs_download_interrupt_code_reason", Integer.valueOf(m));
            localTbsDownloadConfig.setDownloadInterruptCode(m);
            break;
            if (i6 <= 0) {
              m = 65318;
            } else if (paramInt >= i6) {
              m = 65317;
            }
          }
        }
        if (!str3.equals(localTbsDownloadConfig.mPreferences.getString("tbs_downloadurl", null)))
        {
          g.c();
          localTbsDownloadConfig.a.put("tbs_download_failed_retrytimes", Integer.valueOf(0));
          localTbsDownloadConfig.a.put("tbs_download_success_retrytimes", Integer.valueOf(0));
        }
        localTbsDownloadConfig.a.put("tbs_download_version", Integer.valueOf(i6));
        localTbsDownloadConfig.a.put("tbs_downloadurl", str3);
        localTbsDownloadConfig.a.put("tbs_downloadurl_list", str4);
        localTbsDownloadConfig.a.put("tbs_responsecode", Integer.valueOf(i7));
        localTbsDownloadConfig.a.put("tbs_download_maxflow", Integer.valueOf(i8));
        localTbsDownloadConfig.a.put("tbs_download_min_free_space", Integer.valueOf(i9));
        localTbsDownloadConfig.a.put("tbs_download_success_max_retrytimes", Integer.valueOf(i10));
        localTbsDownloadConfig.a.put("tbs_download_failed_max_retrytimes", Integer.valueOf(i11));
        localTbsDownloadConfig.a.put("tbs_single_timeout", Long.valueOf(l2));
        localTbsDownloadConfig.a.put("tbs_apkfilesize", Long.valueOf(l3));
        localTbsDownloadConfig.commit();
        if (localObject != null) {
          localTbsDownloadConfig.a.put("tbs_apk_md5", localObject);
        }
        if ((!paramBoolean2) && (ai.a().a(c, i6))) {
          if (paramBoolean1)
          {
            localTbsDownloadConfig.a.put("tbs_download_interrupt_code_reason", Integer.valueOf(-113));
            localTbsDownloadConfig.a.put("tbs_needdownload", Boolean.valueOf(false));
          }
        }
        for (;;)
        {
          localTbsDownloadConfig.commit();
          return true;
          localTbsDownloadConfig.a.put("tbs_download_interrupt_code_reason", Integer.valueOf(65323));
          localTbsDownloadConfig.setDownloadInterruptCode(65323);
          break;
          if (!paramBoolean2)
          {
            paramString = g;
            if ((i7 == 1) || (i7 == 2)) {}
            for (boolean bool = true;; bool = false)
            {
              if (!paramString.a(paramBoolean2, bool)) {
                break label1606;
              }
              localTbsDownloadConfig.a.put("tbs_needdownload", Boolean.valueOf(false));
              TbsLogReport.a(c).h(100);
              TbsLogReport.a(c).e("use local backup apk in needDownload" + g.a);
              TbsLogReport.a(c).a(TbsLogReport.EventType.TYPE_DOWNLOAD);
              break;
            }
          }
          label1606:
          if (!paramBoolean1) {
            localTbsDownloadConfig.setDownloadInterruptCode(65320);
          }
          localTbsDownloadConfig.a.put("tbs_needdownload", Boolean.valueOf(true));
        }
      }
    }
  }
  
  private static JSONObject b(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = 0;
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(c);
    String str1 = a(c);
    String str2 = b.d(c);
    String str3 = b.c(c);
    String str4 = b.f(c);
    Object localObject1 = TimeZone.getDefault().getID();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      try
      {
        localObject3 = (TelephonyManager)c.getSystemService("phone");
        if (localObject3 == null) {
          break label615;
        }
        localObject3 = ((TelephonyManager)localObject3).getSimCountryIso();
        localObject1 = localObject3;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject3;
          label98:
          localException2.printStackTrace();
          continue;
          m = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0);
        }
        n = ai.a().e(c);
        m = n;
        if (paramBoolean1) {
          break label678;
        }
        m = n;
        if (n != 0) {
          break label678;
        }
        m = n;
        if (!ai.a().d(c)) {
          break label678;
        }
        m = -1;
        TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData] tbsLocalVersion=" + m + " isDownloadForeground=" + paramBoolean2);
        if (!paramBoolean2) {
          break label808;
        }
      }
      if (localObject1 != null) {
        localObject3 = new JSONObject();
      }
    }
    try
    {
      ((JSONObject)localObject3).put("TIMEZONEID", localObject2);
      ((JSONObject)localObject3).put("COUNTRYISO", localObject1);
      ((JSONObject)localObject3).put("PROTOCOLVERSION", 1);
      if (!TbsShareManager.isThirdPartyApp(c)) {
        break label640;
      }
      if (!QbSdk.c) {
        break label618;
      }
      m = TbsShareManager.a(c, false);
      label162:
      if (!paramBoolean1) {
        break label853;
      }
      ((JSONObject)localObject3).put("FUNCTION", 2);
      label176:
      if (!TbsShareManager.isThirdPartyApp(c)) {
        break label745;
      }
      localObject1 = f();
      ((JSONObject)localObject3).put("TBSVLARR", localObject1);
      localTbsDownloadConfig.a.put("last_thirdapp_sendrequest_coreversion", ((JSONArray)localObject1).toString());
      localTbsDownloadConfig.commit();
      if (QbSdk.c) {
        ((JSONObject)localObject3).put("THIRDREQ", 1);
      }
      label241:
      ((JSONObject)localObject3).put("APPN", c.getPackageName());
      ((JSONObject)localObject3).put("APPVN", a(localTbsDownloadConfig.mPreferences.getString("app_versionname", null)));
      ((JSONObject)localObject3).put("APPVC", localTbsDownloadConfig.mPreferences.getInt("app_versioncode", 0));
      ((JSONObject)localObject3).put("APPMETA", a(localTbsDownloadConfig.mPreferences.getString("app_metadata", null)));
      ((JSONObject)localObject3).put("TBSSDKV", 43000);
      ((JSONObject)localObject3).put("TBSV", m);
      if (m != 0) {
        ((JSONObject)localObject3).put("TBSBACKUPV", g.a());
      }
      ((JSONObject)localObject3).put("CPU", e);
      ((JSONObject)localObject3).put("UA", str1);
      ((JSONObject)localObject3).put("IMSI", a(str2));
      ((JSONObject)localObject3).put("IMEI", a(str3));
      ((JSONObject)localObject3).put("ANDROID_ID", a(str4));
      if (TbsShareManager.isThirdPartyApp(c)) {
        break label472;
      }
      if (m == 0) {
        break label790;
      }
      if (!QbSdk.a(c, m)) {
        break label872;
      }
      m = 0;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        boolean bool;
        continue;
        int n = 1;
        continue;
        int m = 1;
      }
    }
    ((JSONObject)localObject3).put("STATUS", m);
    label472:
    bool = TbsDownloadConfig.getInstance(c).mPreferences.getBoolean("request_full_package", false);
    localObject1 = QbSdk.a(c, "can_unlzma", null);
    if ((localObject1 != null) && ((localObject1 instanceof Boolean)))
    {
      paramBoolean1 = ((Boolean)localObject1).booleanValue();
      break label825;
      label529:
      if (m != 0) {
        ((JSONObject)localObject3).put("REQUEST_LZMA", 1);
      }
      if (getOverSea(c)) {
        ((JSONObject)localObject3).put("OVERSEA", 1);
      }
      if (paramBoolean2) {
        ((JSONObject)localObject3).put("DOWNLOAD_FOREGROUND", 1);
      }
      TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData] jsonData=" + ((JSONObject)localObject3).toString());
      return (JSONObject)localObject3;
      label615:
      label618:
      label640:
      label678:
      if (!ai.a().d(c)) {
        break label848;
      }
      break label845;
    }
    for (;;)
    {
      localException2.put("FUNCTION", n);
      break label176;
      label745:
      localObject1 = h();
      if ((Apn.getApnType(c) == 3) || (((JSONArray)localObject1).length() == 0) || (m != 0) || (!paramBoolean1)) {
        break label241;
      }
      localException2.put("TBSBACKUPARR", localObject1);
      break label241;
      label790:
      localException2.put("STATUS", 0);
      break label472;
      paramBoolean1 = false;
      break label825;
      label808:
      break label162;
      localObject1 = "";
      break label98;
      localObject2 = "";
      break;
      label825:
      m = i1;
      if (!paramBoolean1) {
        break label529;
      }
      m = i1;
      if (bool) {
        break label529;
      }
      m = 1;
      break label529;
      for (;;)
      {
        label845:
        break;
        label848:
        m = 0;
      }
      label853:
      if (m != 0) {
        break label867;
      }
      n = 0;
    }
  }
  
  @TargetApi(11)
  static void b(Context paramContext)
  {
    TbsDownloadConfig.getInstance(paramContext).clear();
    TbsLogReport.a(paramContext).d();
    ab.c(paramContext);
    SharedPreferences localSharedPreferences;
    if (Build.VERSION.SDK_INT >= 11)
    {
      localSharedPreferences = paramContext.getSharedPreferences("tbs_extension_config", 4);
      localSharedPreferences.edit().clear().commit();
      if (Build.VERSION.SDK_INT < 11) {
        break label99;
      }
    }
    label99:
    for (paramContext = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);; paramContext = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0))
    {
      paramContext.edit().clear().commit();
      return;
      localSharedPreferences = paramContext.getSharedPreferences("tbs_extension_config", 0);
      break;
    }
  }
  
  private static boolean c()
  {
    boolean bool2 = false;
    try
    {
      String[] arrayOfString = TbsShareManager.getCoreProviderAppList();
      int n = arrayOfString.length;
      int m = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (m < n)
        {
          String str = arrayOfString[m];
          int i1 = TbsShareManager.getSharedTbsCoreVersion(c, str);
          if (i1 > 0) {
            bool1 = true;
          }
        }
        else
        {
          return bool1;
        }
        m += 1;
      }
      return false;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private static boolean c(boolean paramBoolean1, boolean paramBoolean2)
  {
    TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest]isQuery: " + paramBoolean1);
    if (ai.a().a(c))
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] -- isTbsLocalInstalled!");
      return false;
    }
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(c);
    Object localObject2 = j.a(c, 1);
    Object localObject3;
    if (getOverSea(c))
    {
      localObject1 = "x5.oversea.tbs.org";
      localObject2 = new File((String)localObject2, (String)localObject1);
      localObject3 = j.a(c, 2);
      if (!getOverSea(c)) {
        break label409;
      }
      localObject1 = "x5.oversea.tbs.org";
      label112:
      localObject3 = new File((String)localObject3, (String)localObject1);
      Object localObject4 = j.a(c, 3);
      if (!getOverSea(c)) {
        break label416;
      }
      localObject1 = "x5.oversea.tbs.org";
      label147:
      localObject4 = new File((String)localObject4, (String)localObject1);
      String str = j.a(c, 4);
      if (!getOverSea(c)) {
        break label423;
      }
      localObject1 = "x5.oversea.tbs.org";
      label182:
      localObject1 = new File(str, (String)localObject1);
      if (!((File)localObject1).exists())
      {
        if (!((File)localObject4).exists()) {
          break label430;
        }
        ((File)localObject4).renameTo((File)localObject1);
      }
    }
    for (;;)
    {
      long l = System.currentTimeMillis();
      localTbsDownloadConfig.a.put("last_check", Long.valueOf(l));
      localTbsDownloadConfig.a.put("app_versionname", b.a(c));
      localTbsDownloadConfig.a.put("app_versioncode", Integer.valueOf(b.b(c)));
      localTbsDownloadConfig.a.put("app_metadata", b.a(c, "com.tencent.mm.BuildInfo.CLIENT_VERSION"));
      localTbsDownloadConfig.commit();
      if (e == null)
      {
        e = b.a();
        localTbsDownloadConfig.a.put("device_cpuabi", e);
        localTbsDownloadConfig.commit();
      }
      if (TextUtils.isEmpty(e)) {
        break label478;
      }
      localObject1 = null;
      try
      {
        localObject2 = Pattern.compile("i686|mips|x86_64").matcher(e);
        localObject1 = localObject2;
      }
      catch (Exception localException2)
      {
        int m;
        for (;;) {}
      }
      if ((localObject1 == null) || (!((Matcher)localObject1).find())) {
        break label478;
      }
      if (!paramBoolean1) {
        break label468;
      }
      localTbsDownloadConfig.setDownloadInterruptCode(-104);
      return false;
      localObject1 = "x5.tbs.org";
      break;
      label409:
      localObject1 = "x5.tbs.org";
      break label112;
      label416:
      localObject1 = "x5.tbs.org";
      break label147;
      label423:
      localObject1 = "x5.tbs.org";
      break label182;
      label430:
      if (((File)localObject3).exists()) {
        ((File)localObject3).renameTo((File)localObject1);
      } else if (((File)localObject2).exists()) {
        ((File)localObject2).renameTo((File)localObject1);
      }
    }
    label468:
    localTbsDownloadConfig.setDownloadInterruptCode(65331);
    return false;
    label478:
    Object localObject1 = b(paramBoolean1, paramBoolean2);
    try
    {
      m = ((JSONObject)localObject1).getInt("TBSV");
      if (m != -1)
      {
        try
        {
          localObject2 = w.a(c).d();
          TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] postUrl=" + (String)localObject2);
          paramBoolean2 = a(m.a((String)localObject2, ((JSONObject)localObject1).toString().getBytes("utf-8"), new af(paramBoolean1, localTbsDownloadConfig), false), m, paramBoolean1, paramBoolean2);
          paramBoolean1 = paramBoolean2;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            localThrowable.printStackTrace();
            if (!paramBoolean1) {
              break;
            }
            localTbsDownloadConfig.setDownloadInterruptCode(-106);
            paramBoolean1 = false;
          }
          localTbsDownloadConfig.setDownloadInterruptCode(65330);
        }
        return paramBoolean1;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        m = -1;
        continue;
        paramBoolean1 = false;
      }
    }
  }
  
  private static void d()
  {
    try
    {
      if (h == null) {
        h = ag.a();
      }
      try
      {
        g = new ab(c);
        d = new ae(h.getLooper());
      }
      catch (Exception localException)
      {
        for (;;)
        {
          i = true;
          TbsLog.e("TbsDownload", "TbsApkDownloader init has Exception");
        }
      }
      return;
    }
    finally {}
  }
  
  private static boolean e()
  {
    try
    {
      JSONArray localJSONArray = f();
      boolean bool = TbsDownloadConfig.getInstance(c).mPreferences.getString("last_thirdapp_sendrequest_coreversion", "").equals(localJSONArray.toString());
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  private static JSONArray f()
  {
    JSONArray localJSONArray;
    Object localObject1;
    Object localObject2;
    int m;
    String[] arrayOfString;
    if (TbsShareManager.isThirdPartyApp(c))
    {
      localJSONArray = new JSONArray();
      localObject1 = TbsShareManager.getCoreProviderAppList();
      localObject2 = c.getApplicationContext().getPackageName();
      if (!((String)localObject2).equals(TbsShareManager.e(c))) {
        break label223;
      }
      m = localObject1.length;
      arrayOfString = new String[m + 1];
      System.arraycopy(localObject1, 0, arrayOfString, 0, m);
      arrayOfString[m] = localObject2;
      localObject1 = arrayOfString;
    }
    label169:
    label171:
    label221:
    label223:
    for (;;)
    {
      int i1 = localObject1.length;
      m = 0;
      int i2;
      if (m < i1)
      {
        arrayOfString = localObject1[m];
        i2 = TbsShareManager.getSharedTbsCoreVersion(c, arrayOfString);
        if (i2 > 0)
        {
          localObject2 = TbsShareManager.a(c, arrayOfString);
          if ((localObject2 == null) || (ai.a().b((Context)localObject2))) {
            break label169;
          }
          TbsLog.e("TbsDownload", "host check failed,packageName = " + arrayOfString);
        }
      }
      for (;;)
      {
        m += 1;
        break;
        int n = 0;
        if (n < localJSONArray.length()) {
          if (localJSONArray.optInt(n) != i2) {}
        }
        for (n = 1;; n = 0)
        {
          if (n != 0) {
            break label221;
          }
          localJSONArray.put(i2);
          break;
          n += 1;
          break label171;
          return localJSONArray;
          return null;
        }
      }
    }
  }
  
  private static boolean g()
  {
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(c);
    if (localTbsDownloadConfig.mPreferences.getInt("tbs_download_success_retrytimes", 0) >= localTbsDownloadConfig.getDownloadSuccessMaxRetrytimes())
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] out of success retrytimes", true);
      localTbsDownloadConfig.setDownloadInterruptCode(-115);
      return false;
    }
    if (localTbsDownloadConfig.mPreferences.getInt("tbs_download_failed_retrytimes", 0) >= localTbsDownloadConfig.getDownloadFailedMaxRetrytimes())
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] out of failed retrytimes", true);
      localTbsDownloadConfig.setDownloadInterruptCode(-116);
      return false;
    }
    if (!j.b(c))
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] local rom freespace limit", true);
      localTbsDownloadConfig.setDownloadInterruptCode(-117);
      return false;
    }
    if (System.currentTimeMillis() - localTbsDownloadConfig.mPreferences.getLong("tbs_downloadstarttime", 0L) <= 86400000L)
    {
      long l = localTbsDownloadConfig.mPreferences.getLong("tbs_downloadflow", 0L);
      TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] downloadFlow=" + l);
      if (l >= localTbsDownloadConfig.getDownloadMaxflow())
      {
        TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] failed because you exceeded max flow!", true);
        localTbsDownloadConfig.setDownloadInterruptCode(-120);
        return false;
      }
    }
    return true;
  }
  
  public static boolean getOverSea(Context paramContext)
  {
    try
    {
      if (!k)
      {
        k = true;
        paramContext = TbsDownloadConfig.getInstance(paramContext);
        if (paramContext.mPreferences.contains("is_oversea"))
        {
          j = paramContext.mPreferences.getBoolean("is_oversea", false);
          TbsLog.i("TbsDownload", "[TbsDownloader.getOverSea]  first called. sOverSea = " + j);
        }
        TbsLog.i("TbsDownload", "[TbsDownloader.getOverSea]  sOverSea = " + j);
      }
      boolean bool = j;
      return bool;
    }
    finally {}
  }
  
  public static HandlerThread getsTbsHandlerThread()
  {
    return h;
  }
  
  private static JSONArray h()
  {
    JSONArray localJSONArray = new JSONArray();
    String[] arrayOfString = TbsShareManager.getCoreProviderAppList();
    int i1 = arrayOfString.length;
    int m = 0;
    Object localObject;
    label56:
    long l;
    if (m < i1)
    {
      localObject = arrayOfString[m];
      String str = j.a(c, (String)localObject, 4, false);
      if (getOverSea(c))
      {
        localObject = "x5.oversea.tbs.org";
        localObject = new File(str, (String)localObject);
        if ((localObject != null) && (((File)localObject).exists()))
        {
          l = a.a(c, (File)localObject);
          if (l > 0L)
          {
            n = 0;
            label100:
            if (n >= localJSONArray.length()) {
              break label158;
            }
            if (localJSONArray.optInt(n) != l) {
              break label148;
            }
          }
        }
      }
    }
    label148:
    label158:
    for (int n = 1;; n = 0)
    {
      if (n == 0) {
        localJSONArray.put(l);
      }
      m += 1;
      break;
      localObject = "x5.tbs.org";
      break label56;
      n += 1;
      break label100;
      return localJSONArray;
    }
  }
  
  public static boolean isDownloadForeground()
  {
    return (g != null) && (g.d());
  }
  
  public static boolean isDownloading()
  {
    try
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.isDownloading]");
      boolean bool = a;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static boolean needDownload(Context paramContext, boolean paramBoolean)
  {
    return needDownload(paramContext, paramBoolean, false, null);
  }
  
  public static boolean needDownload(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, TbsDownloaderCallback paramTbsDownloaderCallback)
  {
    TbsLog.initIfNeed(paramContext);
    if (ai.b) {
      if (paramTbsDownloaderCallback != null) {
        paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
      }
    }
    TbsDownloadConfig localTbsDownloadConfig;
    do
    {
      return false;
      TbsLog.app_extra("TbsDownload", paramContext);
      c = paramContext.getApplicationContext();
      localTbsDownloadConfig = TbsDownloadConfig.getInstance(c);
      localTbsDownloadConfig.setDownloadInterruptCode(-100);
    } while (!a(c, paramBoolean1, paramTbsDownloaderCallback));
    d();
    if (i)
    {
      if (paramTbsDownloaderCallback != null) {
        paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
      }
      localTbsDownloadConfig.setDownloadInterruptCode(-105);
      return false;
    }
    boolean bool = a(c, paramBoolean2, false);
    if (bool)
    {
      a(paramBoolean2, paramTbsDownloaderCallback);
      localTbsDownloadConfig.setDownloadInterruptCode(-114);
    }
    d.removeMessages(102);
    Message.obtain(d, 102).sendToTarget();
    if ((QbSdk.c) || (!TbsShareManager.isThirdPartyApp(paramContext)))
    {
      paramBoolean1 = localTbsDownloadConfig.mPreferences.contains("tbs_needdownload");
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload] hasNeedDownloadKey=" + paramBoolean1);
      if ((!paramBoolean1) && (!TbsShareManager.isThirdPartyApp(paramContext))) {
        paramBoolean1 = true;
      }
    }
    for (;;)
    {
      if (paramBoolean1) {
        if (!g()) {
          paramBoolean1 = false;
        }
      }
      for (;;)
      {
        if ((!bool) && (paramTbsDownloaderCallback != null)) {
          paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
        }
        TbsLog.i("TbsDownload", "[TbsDownloader.needDownload] needDownload=" + paramBoolean1);
        return paramBoolean1;
        paramBoolean1 = localTbsDownloadConfig.mPreferences.getBoolean("tbs_needdownload", false);
        break;
        localTbsDownloadConfig.setDownloadInterruptCode(-118);
        continue;
        int m = ai.a().e(c);
        if ((bool) || (m <= 0))
        {
          d.removeMessages(103);
          if ((m <= 0) && (!bool)) {
            Message.obtain(d, 103, 0, 0, c).sendToTarget();
          }
          for (;;)
          {
            localTbsDownloadConfig.setDownloadInterruptCode(-121);
            break;
            Message.obtain(d, 103, 1, 0, c).sendToTarget();
          }
        }
        localTbsDownloadConfig.setDownloadInterruptCode(-119);
      }
      paramBoolean1 = false;
    }
  }
  
  public static boolean needSendRequest(Context paramContext, boolean paramBoolean)
  {
    boolean bool = true;
    c = paramContext.getApplicationContext();
    TbsLog.initIfNeed(paramContext);
    if (!a(c, paramBoolean, null)) {}
    int m;
    do
    {
      return false;
      m = ai.a().e(paramContext);
      TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] localTbsVersion=" + m);
    } while (m > 0);
    if (a(c, false, true)) {
      return true;
    }
    paramContext = TbsDownloadConfig.getInstance(c);
    paramBoolean = paramContext.mPreferences.contains("tbs_needdownload");
    TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] hasNeedDownloadKey=" + paramBoolean);
    if (!paramBoolean)
    {
      paramBoolean = true;
      TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] needDownload=" + paramBoolean);
      if ((!paramBoolean) || (!g())) {
        break label208;
      }
    }
    label208:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] ret=" + paramBoolean);
      return paramBoolean;
      paramBoolean = paramContext.mPreferences.getBoolean("tbs_needdownload", false);
      break;
    }
  }
  
  public static void startDownload(Context paramContext)
  {
    startDownload(paramContext, false);
  }
  
  public static void startDownload(Context paramContext, boolean paramBoolean)
  {
    int m = 1;
    for (;;)
    {
      try
      {
        TbsLog.i("TbsDownload", "[TbsDownloader.startDownload] sAppContext=" + c);
        boolean bool = ai.b;
        if (bool) {
          return;
        }
        a = true;
        c = paramContext.getApplicationContext();
        TbsDownloadConfig.getInstance(c).setDownloadInterruptCode(65336);
        if (Build.VERSION.SDK_INT < 8)
        {
          QbSdk.j.onDownloadFinish(110);
          TbsDownloadConfig.getInstance(c).setDownloadInterruptCode(65335);
          continue;
        }
        d();
      }
      finally {}
      if (!i) {
        break;
      }
      QbSdk.j.onDownloadFinish(121);
      TbsDownloadConfig.getInstance(c).setDownloadInterruptCode(65334);
    }
    if (paramBoolean) {
      stopDownload();
    }
    d.removeMessages(101);
    d.removeMessages(100);
    paramContext = Message.obtain(d, 101, QbSdk.j);
    if (paramBoolean) {}
    for (;;)
    {
      paramContext.arg1 = m;
      paramContext.sendToTarget();
      break;
      m = 0;
    }
  }
  
  public static void stopDownload()
  {
    if (i) {}
    do
    {
      return;
      TbsLog.i("TbsDownload", "[TbsDownloader.stopDownload]");
      if (g != null) {
        g.b();
      }
    } while (d == null);
    d.removeMessages(100);
    d.removeMessages(101);
  }
  
  public static abstract interface TbsDownloaderCallback
  {
    public abstract void onNeedDownloadFinish(boolean paramBoolean, int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/sdk/TbsDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */