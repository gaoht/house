package com.ziroom.ziroomcustomer.minsu.f;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class c
{
  public static <T> T checkNotNull(T paramT)
  {
    if (paramT == null) {
      throw new NullPointerException();
    }
    return paramT;
  }
  
  public static <T> T checkNotNull(T paramT, Object paramObject)
  {
    if (paramT == null) {
      throw new NullPointerException(String.valueOf(paramObject));
    }
    return paramT;
  }
  
  public static int getLength(String paramString)
  {
    int j = 0;
    int i = 0;
    if (j < paramString.length())
    {
      if (paramString.substring(j, j + 1).matches("[一-龥]")) {
        i += 2;
      }
      for (;;)
      {
        j += 1;
        break;
        i += 1;
      }
    }
    return i;
  }
  
  public static boolean isIdcard(String paramString)
  {
    return Pattern.compile("^\\d{17}[\\d|x]|\\d{15}$").matcher(paramString).matches();
  }
  
  public static boolean isMobile(String paramString)
  {
    return Pattern.compile("^1\\d{10}$").matcher(paramString).matches();
  }
  
  public static boolean isNull(Object paramObject)
  {
    return (paramObject == null) || ("".equals(paramObject.toString())) || ("null".equalsIgnoreCase(paramObject.toString()));
  }
  
  public static boolean isNullList(List paramList)
  {
    return (paramList == null) || (paramList.isEmpty());
  }
  
  public static boolean isNullMap(Map paramMap)
  {
    return (paramMap == null) || (paramMap.isEmpty());
  }
  
  public static boolean isNumber(String paramString)
  {
    return Pattern.compile("^\\d+$").matcher(paramString).matches();
  }
  
  public static boolean isNumeric(String paramString)
  {
    return Pattern.compile("[0-9]*").matcher(paramString).matches();
  }
  
  public static boolean isTaiwanCard(String paramString)
  {
    Matcher localMatcher = Pattern.compile("^\\d{8}$").matcher(paramString);
    paramString = Pattern.compile("^\\d{10}$").matcher(paramString);
    return (localMatcher.matches()) || (paramString.matches());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/f/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */