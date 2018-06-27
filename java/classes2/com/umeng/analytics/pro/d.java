package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public class d
{
  public static final String a = "/data/data/";
  public static final String b = "/databases/cc/";
  public static final String c = "cc.db";
  public static final int d = 1;
  public static final String e = "Id";
  public static final String f = "INTEGER";
  
  public static String a(Context paramContext)
  {
    return "/data/data/" + paramContext.getPackageName() + "/databases/cc/";
  }
  
  public static String a(List<String> paramList)
  {
    return TextUtils.join("!", paramList);
  }
  
  public static JSONArray a(String paramString)
  {
    paramString = paramString.split("!");
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    while (i < paramString.length)
    {
      localJSONArray.put(paramString[i]);
      i += 1;
    }
    return localJSONArray;
  }
  
  public static List<String> b(String paramString)
  {
    return new ArrayList(Arrays.asList(paramString.split("!")));
  }
  
  public static List<String> b(List<String> paramList)
  {
    localArrayList = new ArrayList();
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (Collections.frequency(localArrayList, str) < 1) {
          localArrayList.add(str);
        }
      }
      return localArrayList;
    }
    catch (Exception paramList)
    {
      paramList.printStackTrace();
    }
  }
  
  public static class a
  {
    public static final String a = "aggregated";
    public static final String b = "aggregated_cache";
    
    public static class a
    {
      public static final String a = "key";
      public static final String b = "totalTimestamp";
      public static final String c = "value";
      public static final String d = "count";
      public static final String e = "label";
      public static final String f = "timeWindowNum";
    }
    
    public static class b
    {
      public static final String a = "TEXT";
      public static final String b = "TEXT";
      public static final String c = "INTEGER";
      public static final String d = "INTEGER";
      public static final String e = "TEXT";
      public static final String f = "TEXT";
    }
  }
  
  public static class b
  {
    public static final String a = "limitedck";
    
    public static class a
    {
      public static final String a = "ck";
    }
    
    public static class b
    {
      public static final String a = "TEXT";
    }
  }
  
  public static class c
  {
    public static final String a = "system";
    
    public static class a
    {
      public static final String a = "key";
      public static final String b = "timeStamp";
      public static final String c = "count";
      public static final String d = "label";
    }
    
    public static class b
    {
      public static final String a = "TEXT";
      public static final String b = "INTEGER";
      public static final String c = "INTEGER";
      public static final String d = "TEXT";
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */