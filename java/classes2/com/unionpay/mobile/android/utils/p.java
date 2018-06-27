package com.unionpay.mobile.android.utils;

import android.os.Environment;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class p
{
  public static boolean a(byte[] paramArrayOfByte)
  {
    Object localObject = new File(Environment.getExternalStorageDirectory(), "UPPay");
    ((File)localObject).mkdir();
    localObject = new File((File)localObject, "UPPayPluginEx.apk");
    try
    {
      ((File)localObject).createNewFile();
      localObject = new FileOutputStream((File)localObject);
      ((OutputStream)localObject).write(paramArrayOfByte);
      ((OutputStream)localObject).close();
      return true;
    }
    catch (IOException paramArrayOfByte)
    {
      j.a("uppay", "write2file error!!!!");
      paramArrayOfByte.printStackTrace();
    }
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/utils/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */