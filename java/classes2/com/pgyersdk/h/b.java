package com.pgyersdk.h;

import android.app.Activity;
import com.pgyersdk.c.h;
import com.pgyersdk.i.i;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class b
  extends h
{
  public static com.pgyersdk.f.a getAppBeanFromString(String paramString)
  {
    com.pgyersdk.f.a locala = new com.pgyersdk.f.a();
    try
    {
      paramString = new JSONObject(paramString);
      if ("0".equals(paramString.getString("code")))
      {
        paramString = paramString.getJSONObject("data");
        locala.setDownloadURL(paramString.getString("downloadURL"));
        locala.setVersionName(paramString.getString("versionName"));
        locala.setVersionCode(paramString.getString("versionCode"));
        locala.setReleaseNote(paramString.getString("releaseNote"));
      }
      return locala;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return locala;
  }
  
  public static void startDownloadTask(Activity paramActivity, String paramString)
  {
    com.pgyersdk.g.a.a(paramActivity, paramString);
  }
  
  public static void updateLocalBuildNumber(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      if ("0".equals(paramString.getString("code")))
      {
        paramString = paramString.getJSONObject("data");
        if (paramString.has("lastBuild")) {
          i.a("buildNo", paramString.getString("lastBuild"));
        }
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  public abstract void onNoUpdateAvailable();
  
  public abstract void onUpdateAvailable(String paramString);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/h/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */