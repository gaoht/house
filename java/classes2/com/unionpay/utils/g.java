package com.unionpay.utils;

import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public final class g
{
  private static boolean a = false;
  private static int b = Integer.MAX_VALUE;
  
  private static int a(int paramInt, String paramString1, String paramString2)
  {
    int k = 0;
    int j = 0;
    int i = k;
    if (paramString1 != null)
    {
      i = k;
      if (paramString2 != null) {
        switch (paramInt)
        {
        default: 
          paramInt = j;
        }
      }
    }
    for (;;)
    {
      i = paramInt;
      if (a) {
        paramString1 = "[ ERROR ] " + paramString1 + ":" + paramString2;
      }
      try
      {
        paramString2 = Environment.getExternalStorageDirectory();
        paramString2 = new File(paramString2.getAbsolutePath() + File.separator + "upmp_log.txt");
        if (!paramString2.exists()) {
          paramString2.createNewFile();
        }
        paramString1 = paramString1 + "\n";
        paramString2 = new FileOutputStream(paramString2, true);
        paramString2.write(paramString1.getBytes());
        paramString2.close();
        i = paramInt;
        return i;
      }
      catch (IOException paramString1)
      {
        paramString1.printStackTrace();
      }
      paramInt = Log.d(paramString1, paramString2);
      continue;
      paramInt = Log.e(paramString1, paramString2);
      continue;
      paramInt = Log.i(paramString1, paramString2);
      continue;
      paramInt = Log.v(paramString1, paramString2);
      continue;
      paramInt = Log.w(paramString1, paramString2);
    }
    return paramInt;
  }
  
  public static int a(String paramString1, String paramString2)
  {
    if (b <= 3) {
      a(3, paramString1, paramString2);
    }
    return 0;
  }
  
  public static int b(String paramString1, String paramString2)
  {
    int i = 0;
    if (b <= 6) {
      i = a(6, paramString1, paramString2);
    }
    return i;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/utils/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */