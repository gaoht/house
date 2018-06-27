package com.freelxl.baselibrary.f;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
{
  public static final List<String> a = new ArrayList();
  
  static
  {
    a.add("ISO-8859-1");
    a.add("GB2312");
    a.add("GBK");
    a.add("GB18030");
    a.add("US-ASCII");
    a.add("ASCII");
    a.add("ISO-2022-KR");
    a.add("ISO-8859-2");
    a.add("ISO-2022-JP");
    a.add("ISO-2022-JP-2");
    a.add("UTF-8");
  }
  
  public static String getEncoding(String paramString, int paramInt)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (isCharset(paramString, str, paramInt)) {
        return str;
      }
    }
    return "ISO-8859-1";
  }
  
  public static boolean isCharset(String paramString1, String paramString2, int paramInt)
  {
    String str = paramString1;
    try
    {
      if (paramString1.length() > paramInt) {
        str = paramString1.substring(0, paramInt);
      }
      boolean bool = str.equals(new String(str.getBytes(paramString2), paramString2));
      return bool;
    }
    catch (Throwable paramString1) {}
    return false;
  }
  
  public static String toCharset(String paramString1, String paramString2, int paramInt)
  {
    try
    {
      paramString2 = new String(paramString1.getBytes(getEncoding(paramString1, paramInt)), paramString2);
      return paramString2;
    }
    catch (Throwable paramString2)
    {
      com.freelxl.baselibrary.c.a.w(paramString2);
    }
    return paramString1;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */