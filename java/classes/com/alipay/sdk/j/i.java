package com.alipay.sdk.j;

import com.alipay.sdk.app.a.a;
import com.alipay.sdk.app.j;
import java.util.HashMap;
import java.util.Map;

public final class i
{
  public static Map<String, String> a(String paramString)
  {
    j localj = j.a(j.c.h);
    HashMap localHashMap = new HashMap();
    localHashMap.put("resultStatus", Integer.toString(localj.h));
    localHashMap.put("memo", localj.i);
    localHashMap.put("result", "");
    try
    {
      paramString = b(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      a.a("biz", "FormatResultEx", paramString);
    }
    return localHashMap;
  }
  
  private static Map<String, String> b(String paramString)
  {
    paramString = paramString.split(";");
    HashMap localHashMap = new HashMap();
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramString[i];
      String str1 = ((String)localObject).substring(0, ((String)localObject).indexOf("={"));
      String str2 = str1 + "={";
      int k = ((String)localObject).indexOf(str2);
      localHashMap.put(str1, ((String)localObject).substring(str2.length() + k, ((String)localObject).lastIndexOf("}")));
      i += 1;
    }
    return localHashMap;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alipay/sdk/j/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */