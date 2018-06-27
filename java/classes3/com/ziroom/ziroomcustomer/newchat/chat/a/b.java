package com.ziroom.ziroomcustomer.newchat.chat.a;

import android.content.Context;
import android.os.Environment;
import java.io.File;

public class b
{
  public static String a;
  private static File b = null;
  private static b c = null;
  private File d = null;
  private File e = null;
  private File f = null;
  private File g = null;
  private File h;
  
  private static File a(Context paramContext)
  {
    if (b == null)
    {
      File localFile = Environment.getExternalStorageDirectory();
      if ((localFile.exists()) && (localFile.canWrite())) {
        return localFile;
      }
      b = paramContext.getFilesDir();
    }
    return b;
  }
  
  private static File a(String paramString1, String paramString2, Context paramContext)
  {
    if (paramString1 == null) {}
    for (paramString1 = a + paramString2 + "/image/";; paramString1 = a + paramString1 + "/" + paramString2 + "/image/") {
      return new File(a(paramContext), paramString1);
    }
  }
  
  private static File b(String paramString1, String paramString2, Context paramContext)
  {
    if (paramString1 == null) {}
    for (paramString1 = a + paramString2 + "/voice/";; paramString1 = a + paramString1 + "/" + paramString2 + "/voice/") {
      return new File(a(paramContext), paramString1);
    }
  }
  
  private static File c(String paramString1, String paramString2, Context paramContext)
  {
    if (paramString1 == null) {}
    for (paramString1 = a + paramString2 + "/file/";; paramString1 = a + paramString1 + "/" + paramString2 + "/file/") {
      return new File(a(paramContext), paramString1);
    }
  }
  
  private static File d(String paramString1, String paramString2, Context paramContext)
  {
    if (paramString1 == null) {}
    for (paramString1 = a + paramString2 + "/video/";; paramString1 = a + paramString1 + "/" + paramString2 + "/video/") {
      return new File(a(paramContext), paramString1);
    }
  }
  
  private static File e(String paramString1, String paramString2, Context paramContext)
  {
    if (paramString1 == null) {}
    for (paramString1 = a + paramString2 + "/chat/";; paramString1 = a + paramString1 + "/" + paramString2 + "/chat/") {
      return new File(a(paramContext), paramString1);
    }
  }
  
  public static b getInstance()
  {
    if (c == null) {
      c = new b();
    }
    return c;
  }
  
  public static File getTempPath(File paramFile)
  {
    return new File(paramFile.getAbsoluteFile() + ".tmp");
  }
  
  public File getFilePath()
  {
    return this.h;
  }
  
  public File getHistoryPath()
  {
    return this.f;
  }
  
  public File getImagePath()
  {
    return this.e;
  }
  
  public File getVideoPath()
  {
    return this.g;
  }
  
  public File getVoicePath()
  {
    return this.d;
  }
  
  public void initDirs(String paramString1, String paramString2, Context paramContext)
  {
    String str = paramContext.getPackageName();
    a = "/Android/data/" + str + "/";
    this.d = b(paramString1, paramString2, paramContext);
    if (!this.d.exists()) {
      this.d.mkdirs();
    }
    this.e = a(paramString1, paramString2, paramContext);
    if (!this.e.exists()) {
      this.e.mkdirs();
    }
    this.f = e(paramString1, paramString2, paramContext);
    if (!this.f.exists()) {
      this.f.mkdirs();
    }
    this.g = d(paramString1, paramString2, paramContext);
    if (!this.g.exists()) {
      this.g.mkdirs();
    }
    this.h = c(paramString1, paramString2, paramContext);
    if (!this.h.exists()) {
      this.h.mkdirs();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/chat/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */