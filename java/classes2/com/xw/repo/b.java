package com.xw.repo;

import android.content.res.Resources;
import android.os.Environment;
import android.util.TypedValue;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

class b
{
  private static final File a = new File(Environment.getRootDirectory(), "build.prop");
  private static Properties b;
  private static final Object c = new Object();
  
  static int a(int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, Resources.getSystem().getDisplayMetrics());
  }
  
  static boolean a()
  {
    return b().containsKey("ro.miui.ui.version.name");
  }
  
  static int b(int paramInt)
  {
    return (int)TypedValue.applyDimension(2, paramInt, Resources.getSystem().getDisplayMetrics());
  }
  
  private static Properties b()
  {
    synchronized (c)
    {
      if (b == null) {
        b = new Properties();
      }
      try
      {
        b.load(new FileInputStream(a));
        return b;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xw/repo/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */