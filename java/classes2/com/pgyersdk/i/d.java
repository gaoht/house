package com.pgyersdk.i;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class d
{
  private static final String f = d.class.getName();
  private static d j = null;
  public final String a = ".jpg";
  public final String b = ".log";
  public final String c = ".txt";
  public final String d = ".zip";
  public final String e = "bug.properties";
  private String g = null;
  private String h = "pgySdk";
  private String i = "feedback";
  
  public static d a()
  {
    if (j == null) {
      j = new d();
    }
    return j;
  }
  
  public String a(Context paramContext)
  {
    return a(paramContext, ".jpg");
  }
  
  public String a(Context paramContext, String paramString)
  {
    paramString = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).format(new Date()) + paramString;
    return b(paramContext) + File.separator + paramString;
  }
  
  public void a(File paramFile)
  {
    if ((paramFile != null) && (paramFile.exists()))
    {
      if (paramFile.isDirectory())
      {
        File[] arrayOfFile = paramFile.listFiles();
        int k = 0;
        while (k < arrayOfFile.length)
        {
          a(arrayOfFile[k]);
          k += 1;
        }
      }
      paramFile.delete();
    }
  }
  
  public void a(String paramString)
  {
    paramString = new File(paramString);
    if ((paramString != null) && (paramString.exists()) && (paramString.isDirectory()))
    {
      paramString = paramString.listFiles();
      int k = 0;
      while (k < paramString.length)
      {
        a(paramString[k]);
        k += 1;
      }
    }
  }
  
  public String b(Context paramContext)
  {
    paramContext = c(paramContext) + File.separator + this.i;
    File localFile = new File(paramContext);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return paramContext;
  }
  
  public void b()
  {
    j = null;
  }
  
  public String c(Context paramContext)
  {
    int k = 0;
    if (this.g != null) {
      return this.g;
    }
    this.g = (paramContext.getFilesDir().getPath() + File.separator + this.h);
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      paramContext = new String[8];
      paramContext[0] = Environment.getExternalStorageDirectory().getAbsolutePath();
      paramContext[1] = "/sdcard";
      paramContext[2] = "/mnt/sdcard";
      paramContext[3] = "/mnt/sdcard2";
      paramContext[4] = "/mnt/ext_sdcard";
      paramContext[5] = "/storage/sdcard0";
      paramContext[6] = "/storage/sdcard1";
      paramContext[7] = "/mnt/sdcard/tencent";
      if (k < paramContext.length)
      {
        String str = paramContext[k] + File.separator + this.h;
        File localFile = new File(str);
        localFile.mkdirs();
        if (!localFile.exists()) {
          break label184;
        }
        this.g = str;
      }
    }
    for (;;)
    {
      return this.g;
      label184:
      k += 1;
      break;
      paramContext = new File(this.g);
      if (!paramContext.exists()) {
        paramContext.mkdirs();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/i/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */