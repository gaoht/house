package com.xiaomi.channel.commonutils.file;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import java.io.File;

public class c
{
  public static boolean a()
  {
    try
    {
      boolean bool = Environment.getExternalStorageState().equals("removed");
      return bool;
    }
    catch (Exception localException)
    {
      b.a(localException);
    }
    return true;
  }
  
  public static boolean b()
  {
    try
    {
      boolean bool = Environment.getExternalStorageState().equals("mounted");
      return !bool;
    }
    catch (Exception localException)
    {
      b.a(localException);
    }
    return true;
  }
  
  public static boolean c()
  {
    return e() <= 102400L;
  }
  
  public static boolean d()
  {
    return (!b()) && (!c()) && (!a());
  }
  
  public static long e()
  {
    if (b()) {}
    Object localObject;
    do
    {
      return 0L;
      localObject = Environment.getExternalStorageDirectory();
    } while ((localObject == null) || (TextUtils.isEmpty(((File)localObject).getPath())));
    try
    {
      localObject = new StatFs(((File)localObject).getPath());
      long l = ((StatFs)localObject).getBlockSize();
      int i = ((StatFs)localObject).getAvailableBlocks();
      return (i - 4L) * l;
    }
    catch (Throwable localThrowable) {}
    return 0L;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/channel/commonutils/file/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */