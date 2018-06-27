package com.huawei.hms.support.api.push.a.a.a;

import android.text.TextUtils;

public abstract class c
{
  private static String a(char paramChar, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramInt);
    int i = 0;
    while (i < paramInt)
    {
      localStringBuffer.append(paramChar);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String a(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    do
    {
      return str;
      str = paramString;
    } while (paramString.length() < 2);
    try
    {
      int i = (int)Math.ceil(paramString.length() * 25 / 100.0D);
      int j = (int)Math.ceil(paramString.length() * 50 / 100.0D);
      paramString = paramString.substring(0, i) + a('*', j) + paramString.substring(i + j);
      return paramString;
    }
    catch (IndexOutOfBoundsException paramString) {}
    return "";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/huawei/hms/support/api/push/a/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */