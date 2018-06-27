package com.g.a;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class av
{
  private static List a = new ArrayList();
  
  private static final String a(Throwable paramThrowable)
  {
    int i = 50;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramThrowable.toString());
    localStringBuilder.append("\r\n");
    for (;;)
    {
      try
      {
        arrayOfStackTraceElement = paramThrowable.getStackTrace();
        if (arrayOfStackTraceElement.length <= 50) {
          continue;
        }
      }
      catch (Throwable paramThrowable)
      {
        StackTraceElement[] arrayOfStackTraceElement;
        continue;
        int j = 0;
        continue;
      }
      if (j >= i) {
        continue;
      }
      localStringBuilder.append("\t");
      localStringBuilder.append(arrayOfStackTraceElement[j]);
      localStringBuilder.append("\r\n");
      j += 1;
    }
    i = arrayOfStackTraceElement.length;
    break label112;
    paramThrowable = paramThrowable.getCause();
    if (paramThrowable != null) {
      a(localStringBuilder, arrayOfStackTraceElement, paramThrowable, 1);
    }
    return localStringBuilder.toString();
  }
  
  private static final void a(StringBuilder paramStringBuilder, StackTraceElement[] paramArrayOfStackTraceElement, Throwable paramThrowable, int paramInt)
  {
    do
    {
      for (;;)
      {
        int i;
        try
        {
          StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
          i = arrayOfStackTraceElement.length;
          j = paramArrayOfStackTraceElement.length;
          i -= 1;
          j -= 1;
          if ((i >= 0) && (j >= 0) && (arrayOfStackTraceElement[i].equals(paramArrayOfStackTraceElement[j])))
          {
            j -= 1;
            i -= 1;
            continue;
            paramStringBuilder.append("Caused by : ");
            paramStringBuilder.append(paramThrowable);
            paramStringBuilder.append("\r\n");
            i = 0;
            if (i > j) {
              break;
            }
            paramStringBuilder.append("\t");
            paramStringBuilder.append(arrayOfStackTraceElement[i]);
            paramStringBuilder.append("\r\n");
            i += 1;
            continue;
            if (paramThrowable.getCause() == null) {
              return;
            }
            a(paramStringBuilder, arrayOfStackTraceElement, paramThrowable, paramInt + 1);
            return;
          }
        }
        catch (Throwable paramStringBuilder)
        {
          return;
        }
        int j = i;
        if (i > 50) {
          j = 50;
        }
      }
    } while (paramInt < 5);
  }
  
  public static void postSDKError(Throwable paramThrowable)
  {
    try
    {
      String str = z.c(paramThrowable.getMessage());
      if (!a.contains(str))
      {
        be localbe = new be();
        localbe.b = "sdk";
        localbe.c = "error";
        TreeMap localTreeMap = new TreeMap();
        localTreeMap.put("type", paramThrowable.toString());
        localTreeMap.put("error", paramThrowable.getMessage());
        localTreeMap.put("stack", a(paramThrowable));
        localbe.d = localTreeMap;
        localbe.a = a.b;
        ad.a().post(localbe);
        a.add(str);
      }
      return;
    }
    catch (Throwable paramThrowable) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */