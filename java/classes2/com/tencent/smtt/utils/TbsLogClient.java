package com.tencent.smtt.utils;

import android.os.Process;
import android.util.Log;
import android.widget.TextView;
import java.io.File;
import java.text.SimpleDateFormat;

public class TbsLogClient
{
  static TbsLogClient a = null;
  static File c = null;
  static String d = null;
  static byte[] e = null;
  TextView b;
  private SimpleDateFormat f;
  
  /* Error */
  public TbsLogClient(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 39	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: aconst_null
    //   6: putfield 41	com/tencent/smtt/utils/TbsLogClient:f	Ljava/text/SimpleDateFormat;
    //   9: aload_0
    //   10: new 43	java/text/SimpleDateFormat
    //   13: dup
    //   14: ldc 45
    //   16: getstatic 51	java/util/Locale:US	Ljava/util/Locale;
    //   19: invokespecial 54	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   22: putfield 41	com/tencent/smtt/utils/TbsLogClient:f	Ljava/text/SimpleDateFormat;
    //   25: getstatic 24	com/tencent/smtt/utils/TbsLogClient:c	Ljava/io/File;
    //   28: ifnonnull +29 -> 57
    //   31: invokestatic 60	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   34: ldc 62
    //   36: invokevirtual 68	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   39: ifeq +77 -> 116
    //   42: aload_1
    //   43: bipush 6
    //   45: invokestatic 73	com/tencent/smtt/utils/j:a	(Landroid/content/Context;I)Ljava/lang/String;
    //   48: astore_1
    //   49: aload_1
    //   50: ifnonnull +25 -> 75
    //   53: aconst_null
    //   54: putstatic 24	com/tencent/smtt/utils/TbsLogClient:c	Ljava/io/File;
    //   57: return
    //   58: astore_2
    //   59: aload_0
    //   60: new 43	java/text/SimpleDateFormat
    //   63: dup
    //   64: ldc 45
    //   66: invokespecial 76	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   69: putfield 41	com/tencent/smtt/utils/TbsLogClient:f	Ljava/text/SimpleDateFormat;
    //   72: goto -47 -> 25
    //   75: new 78	java/io/File
    //   78: dup
    //   79: aload_1
    //   80: ldc 80
    //   82: invokespecial 83	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: putstatic 24	com/tencent/smtt/utils/TbsLogClient:c	Ljava/io/File;
    //   88: invokestatic 88	com/tencent/smtt/utils/LogFileUtils:createKey	()Ljava/lang/String;
    //   91: putstatic 26	com/tencent/smtt/utils/TbsLogClient:d	Ljava/lang/String;
    //   94: getstatic 24	com/tencent/smtt/utils/TbsLogClient:c	Ljava/io/File;
    //   97: invokevirtual 91	java/io/File:getName	()Ljava/lang/String;
    //   100: getstatic 26	com/tencent/smtt/utils/TbsLogClient:d	Ljava/lang/String;
    //   103: invokestatic 95	com/tencent/smtt/utils/LogFileUtils:createHeaderText	(Ljava/lang/String;Ljava/lang/String;)[B
    //   106: putstatic 28	com/tencent/smtt/utils/TbsLogClient:e	[B
    //   109: return
    //   110: astore_1
    //   111: aload_1
    //   112: invokevirtual 98	java/lang/SecurityException:printStackTrace	()V
    //   115: return
    //   116: aconst_null
    //   117: putstatic 24	com/tencent/smtt/utils/TbsLogClient:c	Ljava/io/File;
    //   120: return
    //   121: astore_1
    //   122: aload_1
    //   123: invokevirtual 99	java/lang/NullPointerException:printStackTrace	()V
    //   126: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	TbsLogClient
    //   0	127	1	paramContext	android.content.Context
    //   58	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   9	25	58	java/lang/Exception
    //   25	49	110	java/lang/SecurityException
    //   53	57	110	java/lang/SecurityException
    //   75	109	110	java/lang/SecurityException
    //   116	120	110	java/lang/SecurityException
    //   25	49	121	java/lang/NullPointerException
    //   53	57	121	java/lang/NullPointerException
    //   75	109	121	java/lang/NullPointerException
    //   116	120	121	java/lang/NullPointerException
  }
  
  public void d(String paramString1, String paramString2) {}
  
  public void e(String paramString1, String paramString2)
  {
    Log.e(paramString1, paramString2);
  }
  
  public void i(String paramString1, String paramString2) {}
  
  public void setLogView(TextView paramTextView)
  {
    this.b = paramTextView;
  }
  
  public void showLog(String paramString)
  {
    if (this.b != null) {
      this.b.post(new a(paramString));
    }
  }
  
  public void v(String paramString1, String paramString2) {}
  
  public void w(String paramString1, String paramString2) {}
  
  public void writeLog(String paramString)
  {
    if (c != null)
    {
      String str = this.f.format(Long.valueOf(System.currentTimeMillis()));
      LogFileUtils.writeDataToStorage(c, d, e, str + " pid=" + Process.myPid() + " tid=" + Process.myTid() + paramString + "\n", true);
    }
  }
  
  private class a
    implements Runnable
  {
    String a = null;
    
    a(String paramString)
    {
      this.a = paramString;
    }
    
    public void run()
    {
      if (TbsLogClient.this.b != null) {
        TbsLogClient.this.b.append(this.a + "\n");
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/utils/TbsLogClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */