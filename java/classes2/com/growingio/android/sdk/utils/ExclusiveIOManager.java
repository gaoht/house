package com.growingio.android.sdk.utils;

import android.content.Context;
import android.os.Process;
import java.io.File;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;

public class ExclusiveIOManager
{
  private static ExclusiveIOManager a;
  private FileMMapExclusiveIO b;
  
  private ExclusiveIOManager(Context paramContext)
  {
    this.b = new FileMMapExclusiveIO(paramContext);
    c();
  }
  
  public static ExclusiveIOManager a(Context paramContext)
  {
    if (a == null) {
      a = new ExclusiveIOManager(paramContext);
    }
    return a;
  }
  
  private JSONArray a(JSONArray paramJSONArray, Set<Integer> paramSet)
  {
    JSONArray localJSONArray = new JSONArray();
    int j = paramJSONArray.length();
    if (paramJSONArray != null)
    {
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          if (!paramSet.contains(Integer.valueOf(i))) {}
          try
          {
            localJSONArray.put(paramJSONArray.get(i));
            i += 1;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              localThrowable.printStackTrace();
            }
          }
        }
      }
    }
    return localJSONArray;
  }
  
  public static void a()
  {
    if ((a != null) && (a.b != null))
    {
      a.d();
      a.b.a();
    }
  }
  
  private boolean a(int paramInt)
  {
    return new File(String.format(Locale.CHINESE, "/proc/%d", new Object[] { Integer.valueOf(paramInt) })).isDirectory();
  }
  
  private void c()
  {
    int m = 0;
    JSONArray localJSONArray3 = (JSONArray)this.b.a("pnm", FileMMapExclusiveIO.DATA_TYPE.f);
    int n = Process.myPid();
    if ((localJSONArray3 == null) || (localJSONArray3.length() == 0))
    {
      JSONArray localJSONArray1 = new JSONArray();
      localJSONArray1.put(n);
      this.b.a("pnm", localJSONArray1, FileMMapExclusiveIO.DATA_TYPE.f);
      return;
    }
    HashSet localHashSet = new HashSet();
    int j = 0;
    int k;
    for (int i = 0;; i = k)
    {
      if (j < localJSONArray3.length()) {
        try
        {
          int i1 = localJSONArray3.getInt(j);
          if (i1 == n)
          {
            k = 1;
          }
          else
          {
            k = i;
            if (!a(i1))
            {
              localHashSet.add(Integer.valueOf(j));
              k = i;
            }
          }
        }
        catch (Throwable localThrowable1)
        {
          localThrowable1.printStackTrace();
          k = i;
        }
      }
      JSONArray localJSONArray2 = localJSONArray3;
      j = m;
      if (localHashSet.size() > 0)
      {
        localJSONArray2 = a(localJSONArray3, localHashSet);
        j = m;
      }
      for (;;)
      {
        if (j >= localJSONArray2.length()) {
          break label221;
        }
        try
        {
          k = localJSONArray2.getInt(j);
          if (k == n) {
            break;
          }
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            localThrowable2.printStackTrace();
          }
        }
        j += 1;
      }
      label221:
      if (i != 0) {
        localJSONArray2.put(n);
      }
      this.b.a("pnm", localJSONArray2, FileMMapExclusiveIO.DATA_TYPE.f);
      return;
      j += 1;
    }
  }
  
  private void d()
  {
    JSONArray localJSONArray = (JSONArray)this.b.a("pnm", FileMMapExclusiveIO.DATA_TYPE.f);
    int j = Process.myPid();
    if ((localJSONArray == null) || (localJSONArray.length() == 0)) {
      return;
    }
    LogUtil.i("GIO.ExclusiveIOManager", "decrease() " + localJSONArray.toString());
    HashSet localHashSet = new HashSet();
    int i = 0;
    for (;;)
    {
      if (i < localJSONArray.length()) {
        try
        {
          int k = localJSONArray.getInt(i);
          if (k == j) {
            localHashSet.add(Integer.valueOf(i));
          } else if (!a(k)) {
            localHashSet.add(Integer.valueOf(i));
          }
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
      }
      this.b.a("pnm", a(localJSONArray, localHashSet), FileMMapExclusiveIO.DATA_TYPE.f);
      return;
      i += 1;
    }
  }
  
  public Object a(String paramString, FileMMapExclusiveIO.DATA_TYPE paramDATA_TYPE)
  {
    if (this.b != null) {
      this.b.a(paramString, paramDATA_TYPE);
    }
    return null;
  }
  
  public void a(String paramString, Object paramObject, FileMMapExclusiveIO.DATA_TYPE paramDATA_TYPE)
  {
    if (this.b != null) {
      this.b.a(paramString, paramObject, paramDATA_TYPE);
    }
  }
  
  public int b()
  {
    JSONArray localJSONArray = (JSONArray)this.b.a("pnm", FileMMapExclusiveIO.DATA_TYPE.f);
    if ((localJSONArray == null) || (localJSONArray.length() == 0)) {
      return 0;
    }
    LogUtil.i("GIO.ExclusiveIOManager", "getProcessNum() " + localJSONArray.length());
    return localJSONArray.length();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/utils/ExclusiveIOManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */