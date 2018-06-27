package com.ziroom.ziroomcustomer.home.view.recyclerview2gallery;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class a
{
  public static boolean a = true;
  private static String b = a.class.getName();
  private static ArrayList<String> c = new ArrayList();
  
  static
  {
    Method[] arrayOfMethod = a.class.getDeclaredMethods();
    int j = arrayOfMethod.length;
    int i = 0;
    while (i < j)
    {
      Method localMethod = arrayOfMethod[i];
      c.add(localMethod.getName());
      i += 1;
    }
  }
  
  public static void d(String paramString)
  {
    if (a)
    {
      paramString = getMsgAndTagWithLineNumber(paramString);
      Log.d(paramString[0], paramString[1]);
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if (a) {
      Log.d(paramString1, getMsgWithLineNumber(paramString2));
    }
  }
  
  public static void e(String paramString)
  {
    if (a)
    {
      paramString = getMsgAndTagWithLineNumber(paramString);
      Log.e(paramString[0], paramString[1]);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (a) {
      Log.e(paramString1, getMsgWithLineNumber(paramString2));
    }
  }
  
  public static String[] getMsgAndTagWithLineNumber(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject = new Throwable().getStackTrace();
        int j = localObject.length;
        i = 0;
        if (i < j)
        {
          String str = localObject[i];
          if ((b.equals(str.getClassName())) || (c.contains(str.getMethodName()))) {
            break label165;
          }
          i = str.getClassName().lastIndexOf(".");
          localObject = "LogUtils--" + str.getClassName().substring(i + 1);
          str = str.getMethodName() + "():" + str.getLineNumber() + "->" + paramString;
          return new String[] { localObject, str };
        }
      }
      catch (Exception localException)
      {
        return new String[] { "universal tag", paramString };
      }
      label165:
      i += 1;
    }
  }
  
  public static String getMsgWithLineNumber(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
        int j = arrayOfStackTraceElement.length;
        i = 0;
        Object localObject = paramString;
        if (i < j)
        {
          localObject = arrayOfStackTraceElement[i];
          if ((!b.equals(((StackTraceElement)localObject).getClassName())) && (!c.contains(((StackTraceElement)localObject).getMethodName())))
          {
            i = ((StackTraceElement)localObject).getClassName().lastIndexOf(".");
            localObject = ((StackTraceElement)localObject).getClassName().substring(i + 1) + "->" + ((StackTraceElement)localObject).getMethodName() + "():" + ((StackTraceElement)localObject).getLineNumber() + paramString;
          }
        }
        else
        {
          return (String)localObject;
        }
      }
      catch (Exception localException)
      {
        return paramString;
      }
      i += 1;
    }
  }
  
  public static void i()
  {
    if (a)
    {
      String[] arrayOfString = getMsgAndTagWithLineNumber("");
      Log.i(arrayOfString[0], arrayOfString[1]);
    }
  }
  
  public static void i(String paramString)
  {
    if (a)
    {
      paramString = getMsgAndTagWithLineNumber(paramString);
      Log.i(paramString[0], paramString[1]);
    }
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (a) {
      Log.i(paramString1, getMsgWithLineNumber(paramString2));
    }
  }
  
  public static void init(boolean paramBoolean)
  {
    a = paramBoolean;
  }
  
  public static void v(String paramString)
  {
    if (a)
    {
      paramString = getMsgAndTagWithLineNumber(paramString);
      Log.v(paramString[0], paramString[1]);
    }
  }
  
  public static void v(String paramString1, String paramString2)
  {
    if (a) {
      Log.v(paramString1, getMsgWithLineNumber(paramString2));
    }
  }
  
  public static void w(String paramString)
  {
    if (a)
    {
      paramString = getMsgAndTagWithLineNumber(paramString);
      Log.w(paramString[0], paramString[1]);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (a) {
      Log.w(paramString1, getMsgWithLineNumber(paramString2));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/home/view/recyclerview2gallery/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */