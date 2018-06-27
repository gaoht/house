package com.xiaomi.channel.commonutils.string;

import android.net.Uri;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.security.InvalidParameterException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class b
{
  public static String a(String paramString)
  {
    try
    {
      paramString = String.valueOf(a.a(MessageDigest.getInstance("SHA1").digest(paramString.getBytes("UTF-8"))));
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      com.xiaomi.channel.commonutils.logger.b.a("CloudCoder.hash4SHA1 ", paramString);
      throw new IllegalStateException("failed to SHA1");
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        com.xiaomi.channel.commonutils.logger.b.a("CloudCoder.hash4SHA1 ", paramString);
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        com.xiaomi.channel.commonutils.logger.b.a("CloudCoder.hash4SHA1 ", paramString);
      }
    }
  }
  
  public static String a(String paramString1, String paramString2, Map<String, String> paramMap, String paramString3)
  {
    int i = 1;
    if (TextUtils.isEmpty(paramString3)) {
      throw new InvalidParameterException("security is not nullable");
    }
    ArrayList localArrayList = new ArrayList();
    if (paramString1 != null) {
      localArrayList.add(paramString1.toUpperCase());
    }
    if (paramString2 != null) {
      localArrayList.add(Uri.parse(paramString2).getEncodedPath());
    }
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      paramString1 = new TreeMap(paramMap).entrySet().iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (Map.Entry)paramString1.next();
        localArrayList.add(String.format("%s=%s", new Object[] { paramString2.getKey(), paramString2.getValue() }));
      }
    }
    localArrayList.add(paramString3);
    paramString1 = new StringBuilder();
    paramString2 = localArrayList.iterator();
    while (paramString2.hasNext())
    {
      paramMap = (String)paramString2.next();
      if (i == 0) {
        paramString1.append('&');
      }
      paramString1.append(paramMap);
      i = 0;
    }
    return a(paramString1.toString());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/channel/commonutils/string/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */