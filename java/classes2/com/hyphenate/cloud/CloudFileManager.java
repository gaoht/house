package com.hyphenate.cloud;

import android.text.format.Time;
import java.util.Map;
import java.util.Properties;

public abstract class CloudFileManager
{
  protected static final String TAG = "CloudFileManager";
  public static CloudFileManager instance = null;
  protected Properties sessionContext;
  
  public abstract void downloadFile(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap, CloudOperationCallback paramCloudOperationCallback);
  
  public String getRemoteFileName(String paramString1, String paramString2)
  {
    Time localTime = new Time();
    localTime.setToNow();
    paramString2 = paramString2.substring(paramString2.lastIndexOf("."), paramString2.length());
    paramString1 = paramString1 + localTime.toString().substring(0, 15);
    return paramString1 + paramString2;
  }
  
  public abstract void uploadFileInBackground(String paramString1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap, CloudOperationCallback paramCloudOperationCallback);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/cloud/CloudFileManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */