package com.mato.sdk.g;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class h
{
  private static String a(List<String> paramList, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localStringBuilder.append((String)paramList.next()).append(paramString);
    }
    return localStringBuilder.toString();
  }
  
  private static String a(Map<String, String> paramMap, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localStringBuilder.append((String)localEntry.getKey()).append(":").append((String)localEntry.getValue()).append(paramString);
    }
    return localStringBuilder.toString();
  }
  
  private static String b(List<Integer> paramList, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localStringBuilder.append((Integer)paramList.next()).append(paramString);
    }
    return localStringBuilder.toString();
  }
  
  private static String b(Map<String, List<String>> paramMap, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localStringBuilder.append((String)localEntry.getKey()).append(":").append((String)((List)localEntry.getValue()).get(0)).append(paramString);
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/g/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */