package com.ziroom.router.activityrouter;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class RouterSchemeBuilder
{
  private static Map<String, String> mSchemeMap = new LinkedHashMap();
  private static ArrayList<Map<String, String>> schemePara = new ArrayList();
  private String mHost;
  private String mPath;
  
  public static final RouterSchemeBuilder getInstace()
  {
    if (!mSchemeMap.isEmpty())
    {
      mSchemeMap.clear();
      schemePara.clear();
    }
    return RouterSchemeHolder.INSTANCE;
  }
  
  public String buildSchemeUrl()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.mHost);
    localStringBuffer.append("://");
    localStringBuffer.append(this.mPath);
    localStringBuffer.append("?");
    Iterator localIterator = mSchemeMap.entrySet().iterator();
    for (int i = 1; localIterator.hasNext(); i = 0)
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (i == 0) {
        localStringBuffer.append("&");
      }
      localStringBuffer.append((String)localEntry.getKey());
      localStringBuffer.append("=");
      localStringBuffer.append((String)localEntry.getValue());
    }
    return localStringBuffer.toString();
  }
  
  public void setHost(String paramString)
  {
    this.mHost = paramString;
  }
  
  public void setParameter(String paramString, Object paramObject)
  {
    mSchemeMap.put(paramString, String.valueOf(paramObject));
  }
  
  public void setParameter(String paramString, Object paramObject, boolean paramBoolean)
  {
    try
    {
      String str = String.valueOf(paramObject);
      paramObject = str;
      if (paramBoolean) {
        paramObject = URLEncoder.encode(str, "UTF-8");
      }
      mSchemeMap.put(paramString, paramObject);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void setPath(String paramString)
  {
    this.mPath = paramString;
  }
  
  private static class RouterSchemeHolder
  {
    private static final RouterSchemeBuilder INSTANCE = new RouterSchemeBuilder(null);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/router/activityrouter/RouterSchemeBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */