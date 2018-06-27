package com.growingio.android.sdk.collection;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import com.growingio.android.sdk.circle.c;
import com.growingio.android.sdk.utils.HttpService;
import com.growingio.android.sdk.utils.HttpService.Builder;
import com.growingio.android.sdk.utils.LogUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class DiagnoseLog
{
  static SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd%20HH:mm:ss", Locale.US);
  @SuppressLint({"StaticFieldLeak"})
  private static DiagnoseLog c = null;
  private static SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
  private final String b = "TYPE_UPLOAD_ALL";
  private Context e;
  private HashMap<String, Diagnose> f;
  private UploadDiagnoseLogRunnable g = new UploadDiagnoseLogRunnable(null);
  
  private DiagnoseLog(Context paramContext)
  {
    this.e = paramContext.getApplicationContext();
    c();
  }
  
  static void a()
  {
    if (c != null) {
      UploadDiagnoseLogRunnable.a(c.g);
    }
  }
  
  static void a(Context paramContext)
  {
    if (c == null) {
      c = new DiagnoseLog(paramContext);
    }
  }
  
  private void a(Diagnose paramDiagnose)
  {
    if (paramDiagnose == null) {}
    for (;;)
    {
      return;
      Object localObject2 = AppState.l();
      HashMap localHashMap = new HashMap();
      localHashMap.put("Content-Type", "application/json");
      localHashMap.put("Accept", "application/json");
      localHashMap.put("X-GrowingIO-UID", ((AppState)localObject2).m().a());
      Object localObject1;
      StringBuilder localStringBuilder;
      if (c.e().a())
      {
        localObject1 = AppState.l().d();
        localStringBuilder = new StringBuilder(390);
      }
      try
      {
        localStringBuilder.append(NetworkConfig.a().e()).append("/").append((String)localObject1).append("/android/faults?").append("stm=").append(System.currentTimeMillis()).append('&').append("av=").append(URLEncoder.encode(GConfig.sAppVersion, "UTF-8")).append('&').append("cv=").append("1.1.2_dcb91e54").append('&').append("uid=").append(((AppState)localObject2).m().a()).append('&').append("appid=").append(((AppState)localObject2).b()).append('&').append("os=").append("Android").append('&').append("osv=").append(Build.VERSION.SDK_INT).append('&').append("db=").append(URLEncoder.encode(Build.BRAND, "UTF-8")).append('&').append("dm=").append(URLEncoder.encode(Build.MODEL, "UTF-8")).append('&').append("date=").append(paramDiagnose.b);
        if ((paramDiagnose.c != null) && (!paramDiagnose.c.isEmpty()))
        {
          localObject1 = paramDiagnose.c.keySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            localStringBuilder.append("&").append((String)localObject2).append("=").append(paramDiagnose.c.get(localObject2));
            continue;
            localObject1 = AppState.l().c();
          }
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          localUnsupportedEncodingException.printStackTrace();
        }
        try
        {
          if (((Integer)new HttpService.Builder().a(localStringBuilder.toString()).a(localHashMap).a().b().first).intValue() == 200)
          {
            this.f.remove(paramDiagnose.a);
            b().edit().remove(paramDiagnose.a).commit();
            return;
          }
        }
        catch (Exception paramDiagnose)
        {
          paramDiagnose.printStackTrace();
        }
      }
    }
  }
  
  public static void a(String paramString)
  {
    if ((GConfig.s().k()) && (c != null)) {
      c.b(paramString);
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    if ((GConfig.s().k()) && (c != null)) {
      c.b(paramString, paramInt);
    }
  }
  
  @TargetApi(9)
  private void a(String paramString, Diagnose paramDiagnose)
  {
    try
    {
      b().edit().putString(paramString, paramDiagnose.a()).commit();
      return;
    }
    catch (Throwable paramString)
    {
      LogUtil.d(paramString);
    }
  }
  
  private SharedPreferences b()
  {
    return this.e.getSharedPreferences("growingio_diagnose", 0);
  }
  
  private void b(String paramString)
  {
    b(paramString, 1);
  }
  
  private void b(String paramString, int paramInt)
  {
    if (paramInt == 0) {}
    for (;;)
    {
      return;
      try
      {
        if (Looper.myLooper() == Looper.getMainLooper()) {
          throw new AssertionError();
        }
      }
      finally {}
      if (paramString != "TYPE_UPLOAD_ALL") {
        break;
      }
      d();
    }
    Object localObject1 = new Date();
    String str = d.format((Date)localObject1);
    Object localObject2 = a.format((Date)localObject1);
    localObject1 = (Diagnose)this.f.get(str);
    if (localObject1 == null)
    {
      localObject1 = new Diagnose(str, (String)localObject2);
      this.f.put(str, localObject1);
    }
    for (;;)
    {
      localObject2 = (Integer)((Diagnose)localObject1).c.get(paramString);
      int i = paramInt;
      if (localObject2 != null) {
        i = paramInt + ((Integer)localObject2).intValue();
      }
      ((Diagnose)localObject1).c.put(paramString, Integer.valueOf(i));
      a(str, (Diagnose)localObject1);
      if (this.f.size() <= 0) {
        break;
      }
      UploadDiagnoseLogRunnable.b(this.g);
      break;
    }
  }
  
  private void c()
  {
    this.f = new HashMap();
    Iterator localIterator = b().getAll().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      try
      {
        String str = (String)localEntry.getKey();
        this.f.put(str, new Diagnose(str, new JSONObject(localEntry.getValue().toString())));
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void d()
  {
    Object localObject = this.f.entrySet();
    try
    {
      localObject = ((Set)localObject).toArray();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        a((Diagnose)((Map.Entry)localObject[i]).getValue());
        i += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private class UploadDiagnoseLogRunnable
    implements Runnable
  {
    private boolean b = false;
    
    private UploadDiagnoseLogRunnable() {}
    
    private void a()
    {
      if (!this.b)
      {
        this.b = true;
        MessageProcessor.e().c().postDelayed(this, 300000L);
      }
    }
    
    private void b()
    {
      this.b = true;
      MessageProcessor.e().c().removeCallbacks(this);
      MessageProcessor.e().c().post(this);
    }
    
    public void run()
    {
      DiagnoseLog.a(DiagnoseLog.this, "TYPE_UPLOAD_ALL");
      this.b = false;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/collection/DiagnoseLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */