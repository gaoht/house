package com.ziroom.ziroomcustomer.minsu.f;

import android.util.Log;
import com.freelxl.baselibrary.b.c;
import com.ziroom.ziroomcustomer.util.ae;

public class l
{
  public static final String a = l.class.getSimpleName();
  private static Boolean b = c.getInstance().LogSwitch();
  private static char c = 'v';
  private static int d = 2000;
  
  private static void a(String paramString1, String paramString2, char paramChar)
  {
    if (ae.isNull(paramString2)) {}
    while (!b.booleanValue()) {
      return;
    }
    if (('e' == paramChar) && (('e' == c) || ('v' == c)))
    {
      Log.e(paramString1, a + paramString2);
      return;
    }
    if (('w' == paramChar) && (('w' == c) || ('v' == c)))
    {
      Log.w(paramString1, a + paramString2);
      return;
    }
    if (('d' == paramChar) && (('d' == c) || ('v' == c)))
    {
      Log.d(paramString1, a + paramString2);
      return;
    }
    if (('i' == paramChar) && (('d' == c) || ('v' == c)))
    {
      Log.i(paramString1, a + paramString2);
      return;
    }
    Log.v(paramString1, a + paramString2);
  }
  
  private static void b(String paramString1, String paramString2, char paramChar)
  {
    int k = 0;
    int m = paramString2.length();
    int i = d;
    int j = 0;
    while (m > i)
    {
      a(paramString1 + "__" + j, paramString2.substring(k, i), paramChar);
      int n = d;
      j += 1;
      k = i;
      i = n + i;
    }
    a(paramString1 + "__" + j, paramString2.substring(k), paramChar);
  }
  
  public static void d(String paramString, Object paramObject)
  {
    b(paramString, paramObject.toString(), 'd');
  }
  
  public static void d(String paramString1, String paramString2)
  {
    b(paramString1, paramString2, 'd');
  }
  
  public static void e(String paramString, Object paramObject)
  {
    b(paramString, paramObject.toString(), 'e');
  }
  
  public static void e(String paramString1, String paramString2)
  {
    b(paramString1, paramString2, 'e');
  }
  
  public static void i(String paramString, Object paramObject)
  {
    b(paramString, paramObject.toString(), 'i');
  }
  
  public static void i(String paramString1, String paramString2)
  {
    b(paramString1, paramString2, 'i');
  }
  
  public static void v(String paramString, Object paramObject)
  {
    b(paramString, paramObject.toString(), 'v');
  }
  
  public static void v(String paramString1, String paramString2)
  {
    b(paramString1, paramString2, 'v');
  }
  
  public static void w(String paramString, Object paramObject)
  {
    a(paramString, paramObject.toString(), 'w');
  }
  
  public static void w(String paramString1, String paramString2)
  {
    b(paramString1, paramString2, 'w');
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/f/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */