package com.ziroom.ziroomcustomer.minsu.chat.d;

import android.content.Context;
import android.os.Environment;
import com.freelxl.baselibrary.f.d;
import com.hyphenate.util.PathUtil;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import java.io.File;
import java.lang.reflect.Method;

public class j
{
  private static File a = null;
  
  public static File getStorageDir1(Context paramContext)
  {
    d.e("huanxin", " 环信升级后可能出错，路径不一致");
    if (a == null)
    {
      File localFile = Environment.getExternalStorageDirectory();
      if (localFile.exists()) {
        return localFile;
      }
      a = paramContext.getFilesDir();
    }
    return a;
  }
  
  public static File getStorageDir2(Context paramContext)
  {
    try
    {
      Object localObject = PathUtil.class.getDeclaredMethod("getStorageDir", new Class[] { Context.class });
      ((Method)localObject).setAccessible(true);
      localObject = (File)((Method)localObject).invoke(null, new Object[] { ApplicationEx.c });
      return (File)localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return getStorageDir1(paramContext);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/d/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */