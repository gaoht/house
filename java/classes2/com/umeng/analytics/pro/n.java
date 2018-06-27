package com.umeng.analytics.pro;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

public class n
{
  public static n a()
  {
    return a.a();
  }
  
  private boolean a(String paramString, int paramInt)
  {
    int i = 0;
    while (i < paramString.length())
    {
      if (paramString.charAt(i) < paramInt) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public boolean a(String paramString)
  {
    if ("".equals(paramString)) {}
    do
    {
      return true;
      if (paramString == null) {
        return false;
      }
    } while ((paramString.getBytes().length < 160) && (a(paramString, 48)));
    return false;
  }
  
  public boolean a(List<String> paramList)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramList == null) {
      bool1 = false;
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (paramList.size() <= 1);
    int i = 1;
    for (;;)
    {
      bool1 = bool2;
      if (i >= paramList.size()) {
        break;
      }
      if (TextUtils.isEmpty((CharSequence)paramList.get(i))) {
        return false;
      }
      if (!a((String)paramList.get(i), 48)) {
        return false;
      }
      i += 1;
    }
  }
  
  public int b()
  {
    return 8;
  }
  
  public boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((paramString.length() >= 16) || (!a(paramString, 48))) {
      return false;
    }
    return true;
  }
  
  public boolean b(List<String> paramList)
  {
    if (paramList == null) {}
    int i;
    do
    {
      do
      {
        return false;
      } while (paramList.size() <= 0);
      paramList = paramList.iterator();
      for (i = 0; paramList.hasNext(); i = ((String)paramList.next()).getBytes().length + i) {}
    } while (i >= 256);
    return true;
  }
  
  public int c()
  {
    return 128;
  }
  
  public int d()
  {
    return 512;
  }
  
  private static class a
  {
    private static final n a = new n(null);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */