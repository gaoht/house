package com.ziroom.ziroomcustomer.util.c;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.util.Log;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.util.ad;
import com.ziroom.ziroomcustomer.util.ae;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class h
{
  public static String a = Environment.getExternalStorageDirectory().getAbsolutePath() + "/ziroom/file/";
  
  private static void b()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.ziroom.ziroomcustomer.main.title");
    ApplicationEx.c.sendBroadcast(localIntent);
  }
  
  private static void b(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        paramString1 = new ZipInputStream(new BufferedInputStream(new FileInputStream(paramString1)));
        localObject2 = paramString1.getNextEntry();
        if (localObject2 == null) {
          break;
        }
        String str;
        try
        {
          Log.i("Unzip: ", "=" + localObject2);
          Object localObject1 = new byte['က'];
          str = ((ZipEntry)localObject2).getName();
          if (!((ZipEntry)localObject2).isDirectory()) {
            break label147;
          }
          localObject1 = str.substring(0, str.length() - 1);
          new File(paramString2 + File.separator + (String)localObject1).mkdirs();
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        continue;
        localObject2 = new File(paramString2 + File.separator + str);
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      label147:
      ((File)localObject2).createNewFile();
      Object localObject2 = new BufferedOutputStream(new FileOutputStream((File)localObject2), 4096);
      for (;;)
      {
        int i = paramString1.read(localException, 0, 4096);
        if (i == -1) {
          break;
        }
        ((BufferedOutputStream)localObject2).write(localException, 0, i);
      }
      ((BufferedOutputStream)localObject2).flush();
      ((BufferedOutputStream)localObject2).close();
    }
    paramString1.close();
  }
  
  public static void deleteDirWihtFile(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isDirectory())) {
      return;
    }
    File[] arrayOfFile = paramFile.listFiles();
    int j = arrayOfFile.length;
    int i = 0;
    if (i < j)
    {
      File localFile = arrayOfFile[i];
      if (localFile.isFile()) {
        localFile.delete();
      }
      for (;;)
      {
        i += 1;
        break;
        if (localFile.isDirectory()) {
          deleteDirWihtFile(localFile);
        }
      }
    }
    paramFile.delete();
    b();
    ad.saveSkinTag(ApplicationEx.c, "");
  }
  
  public static void deleteFile(String paramString)
  {
    deleteDirWihtFile(new File(a + paramString));
  }
  
  public static void downloadPdf(String paramString1, String paramString2, final String paramString3, String paramString4)
  {
    if (!ae.isNull(paramString1))
    {
      deleteFile(paramString2);
      paramString2 = new File(a + paramString3 + "/");
      if (!paramString2.exists()) {
        paramString2.mkdirs();
      }
      paramString2 = new File(paramString2, paramString4);
      if (paramString2.exists()) {}
    }
    try
    {
      paramString2.createNewFile();
      com.freelxl.baselibrary.d.a.get(paramString1).enqueue(new com.ziroom.ziroomcustomer.e.a.b(ApplicationEx.c, new com.freelxl.baselibrary.d.f.b(paramString2))
      {
        public void onFailure(Throwable paramAnonymousThrowable) {}
        
        public void onSuccess(int paramAnonymousInt, final File paramAnonymousFile)
        {
          if ((paramAnonymousFile.exists()) && (paramAnonymousFile.isFile())) {
            new Thread(new Runnable()
            {
              public void run()
              {
                h.a(paramAnonymousFile.getPath(), h.a + h.1.this.b + "/");
                h.a();
              }
            }).start();
          }
        }
      });
      return;
    }
    catch (IOException paramString4)
    {
      for (;;)
      {
        paramString4.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/util/c/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */