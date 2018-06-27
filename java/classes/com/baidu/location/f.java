package com.baidu.location;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.baidu.location.c.a;
import com.baidu.location.d.j;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.RandomAccessFile;

public class f
  extends Service
{
  public static boolean isServing = false;
  private static final String jarFileName = "app.jar";
  public static Context mC;
  public static String replaceFileName = "repll.jar";
  LLSInterface lib = null;
  LLSInterface libJar = null;
  LLSInterface libNat = null;
  
  static
  {
    mC = null;
  }
  
  public static float getFrameVersion()
  {
    return 7.02F;
  }
  
  public static String getJarFileName()
  {
    return "app.jar";
  }
  
  public static Context getServiceContext()
  {
    return mC;
  }
  
  private boolean readConf(File paramFile)
  {
    boolean bool1 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    Object localObject1 = j.g() + "/grtcfrsa.dat";
    boolean bool2 = bool4;
    try
    {
      localObject1 = new File((String)localObject1);
      bool2 = bool4;
      if (((File)localObject1).exists())
      {
        bool2 = bool4;
        localObject1 = new RandomAccessFile((File)localObject1, "rw");
        bool2 = bool4;
        ((RandomAccessFile)localObject1).seek(200L);
        bool1 = bool3;
        bool2 = bool4;
        if (((RandomAccessFile)localObject1).readBoolean())
        {
          bool1 = bool3;
          bool2 = bool4;
          if (((RandomAccessFile)localObject1).readBoolean())
          {
            bool2 = bool4;
            int i = ((RandomAccessFile)localObject1).readInt();
            bool1 = bool3;
            if (i != 0)
            {
              bool2 = bool4;
              Object localObject2 = new byte[i];
              bool2 = bool4;
              ((RandomAccessFile)localObject1).read((byte[])localObject2, 0, i);
              bool2 = bool4;
              localObject2 = new String((byte[])localObject2);
              bool2 = bool4;
              paramFile = j.a(paramFile, "SHA-256");
              bool1 = bool3;
              if (localObject2 != null)
              {
                bool1 = bool3;
                if (paramFile != null)
                {
                  bool1 = bool3;
                  bool2 = bool4;
                  if (j.b(paramFile, (String)localObject2, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCiP7BS5IjEOzrKGR9/Ww9oSDhdX1ir26VOsYjT1T6tk2XumRpkHRwZbrucDcNnvSB4QsqiEJnvTSRi7YMbh2H9sLMkcvHlMV5jAErNvnuskWfcvf7T2mq7EUZI/Hf4oVZhHV0hQJRFVdTcjWI6q2uaaKM3VMh+roDesiE7CR2biQIDAQAB")) {
                    bool1 = true;
                  }
                }
              }
            }
          }
        }
        bool2 = bool1;
        ((RandomAccessFile)localObject1).close();
      }
      return bool1;
    }
    catch (Exception paramFile) {}
    return bool2;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.lib.onBind(paramIntent);
  }
  
  @SuppressLint({"NewApi"})
  public void onCreate()
  {
    mC = getApplicationContext();
    System.currentTimeMillis();
    this.libNat = new a();
    try
    {
      File localFile1 = new File(j.g() + File.separator + replaceFileName);
      File localFile2 = new File(j.g() + File.separator + "app.jar");
      if (localFile1.exists())
      {
        if (localFile2.exists()) {
          localFile2.delete();
        }
        localFile1.renameTo(localFile2);
      }
      if ((localFile2.exists()) && (readConf(new File(j.g() + File.separator + "app.jar")))) {
        this.libJar = ((LLSInterface)new DexClassLoader(j.g() + File.separator + "app.jar", j.g(), null, getClassLoader()).loadClass("com.baidu.serverLoc.LocationService").newInstance());
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.libJar = null;
        continue;
        this.lib = this.libNat;
        this.libJar = null;
      }
    }
    if ((this.libJar != null) && (this.libJar.getVersion() >= this.libNat.getVersion()))
    {
      this.lib = this.libJar;
      this.libNat = null;
      isServing = true;
      this.lib.onCreate(this);
      return;
    }
  }
  
  public void onDestroy()
  {
    isServing = false;
    this.lib.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return this.lib.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    return this.lib.onUnBind(paramIntent);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/location/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */