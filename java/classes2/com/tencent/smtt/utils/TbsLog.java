package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import android.widget.TextView;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class TbsLog
{
  public static final int TBSLOG_CODE_SDK_BASE = 1000;
  public static final int TBSLOG_CODE_SDK_CONFLICT_X5CORE = 993;
  public static final int TBSLOG_CODE_SDK_INIT = 999;
  public static final int TBSLOG_CODE_SDK_INVOKE_ERROR = 997;
  public static final int TBSLOG_CODE_SDK_LOAD_ERROR = 998;
  public static final int TBSLOG_CODE_SDK_NO_SHARE_X5CORE = 994;
  public static final int TBSLOG_CODE_SDK_SELF_MODE = 996;
  public static final int TBSLOG_CODE_SDK_THIRD_MODE = 995;
  public static final int TBSLOG_CODE_SDK_UNAVAIL_X5CORE = 992;
  private static boolean a = false;
  private static TbsLogClient b = null;
  public static int sLogMaxCount = 10;
  public static List<String> sTbsLogList = new LinkedList();
  
  /* Error */
  public static void addLog(int paramInt, String paramString, Object... paramVarArgs)
  {
    // Byte code:
    //   0: getstatic 44	com/tencent/smtt/utils/TbsLog:sTbsLogList	Ljava/util/List;
    //   3: astore 6
    //   5: aload 6
    //   7: monitorenter
    //   8: getstatic 44	com/tencent/smtt/utils/TbsLog:sTbsLogList	Ljava/util/List;
    //   11: invokeinterface 58 1 0
    //   16: getstatic 46	com/tencent/smtt/utils/TbsLog:sLogMaxCount	I
    //   19: if_icmple +48 -> 67
    //   22: getstatic 44	com/tencent/smtt/utils/TbsLog:sTbsLogList	Ljava/util/List;
    //   25: invokeinterface 58 1 0
    //   30: getstatic 46	com/tencent/smtt/utils/TbsLog:sLogMaxCount	I
    //   33: isub
    //   34: istore_3
    //   35: iload_3
    //   36: ifle +31 -> 67
    //   39: getstatic 44	com/tencent/smtt/utils/TbsLog:sTbsLogList	Ljava/util/List;
    //   42: invokeinterface 58 1 0
    //   47: ifle +20 -> 67
    //   50: getstatic 44	com/tencent/smtt/utils/TbsLog:sTbsLogList	Ljava/util/List;
    //   53: iconst_0
    //   54: invokeinterface 62 2 0
    //   59: pop
    //   60: iload_3
    //   61: iconst_1
    //   62: isub
    //   63: istore_3
    //   64: goto -29 -> 35
    //   67: aconst_null
    //   68: astore 5
    //   70: aload 5
    //   72: astore 4
    //   74: aload_1
    //   75: ifnull +10 -> 85
    //   78: aload_1
    //   79: aload_2
    //   80: invokestatic 68	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   83: astore 4
    //   85: aload 4
    //   87: astore_1
    //   88: aload 4
    //   90: ifnonnull +6 -> 96
    //   93: ldc 70
    //   95: astore_1
    //   96: ldc 72
    //   98: iconst_5
    //   99: anewarray 4	java/lang/Object
    //   102: dup
    //   103: iconst_0
    //   104: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   107: invokestatic 84	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   110: aastore
    //   111: dup
    //   112: iconst_1
    //   113: iconst_1
    //   114: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   117: aastore
    //   118: dup
    //   119: iconst_2
    //   120: bipush 48
    //   122: invokestatic 94	java/lang/Character:valueOf	(C)Ljava/lang/Character;
    //   125: aastore
    //   126: dup
    //   127: iconst_3
    //   128: iload_0
    //   129: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   132: aastore
    //   133: dup
    //   134: iconst_4
    //   135: aload_1
    //   136: aastore
    //   137: invokestatic 68	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   140: astore_1
    //   141: getstatic 44	com/tencent/smtt/utils/TbsLog:sTbsLogList	Ljava/util/List;
    //   144: aload_1
    //   145: invokeinterface 98 2 0
    //   150: pop
    //   151: aload 6
    //   153: monitorexit
    //   154: return
    //   155: astore_1
    //   156: aload_1
    //   157: invokevirtual 101	java/lang/Exception:printStackTrace	()V
    //   160: goto -9 -> 151
    //   163: astore_1
    //   164: aload 6
    //   166: monitorexit
    //   167: aload_1
    //   168: athrow
    //   169: astore_1
    //   170: aload 5
    //   172: astore 4
    //   174: goto -89 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	paramInt	int
    //   0	177	1	paramString	String
    //   0	177	2	paramVarArgs	Object[]
    //   34	30	3	i	int
    //   72	101	4	localObject1	Object
    //   68	103	5	localObject2	Object
    //   3	162	6	localList	List
    // Exception table:
    //   from	to	target	type
    //   8	35	155	java/lang/Exception
    //   39	60	155	java/lang/Exception
    //   96	151	155	java/lang/Exception
    //   8	35	163	finally
    //   39	60	163	finally
    //   78	85	163	finally
    //   96	151	163	finally
    //   151	154	163	finally
    //   156	160	163	finally
    //   164	167	163	finally
    //   78	85	169	java/lang/Exception
  }
  
  public static void app_extra(String paramString, Context paramContext)
  {
    int i = 0;
    try
    {
      paramContext = paramContext.getApplicationContext();
      String[] arrayOfString = new String[6];
      arrayOfString[0] = "com.tencent.x5sdk.demo";
      arrayOfString[1] = "com.tencent.mtt";
      arrayOfString[2] = "com.tencent.mm";
      arrayOfString[3] = "com.tencent.mobileqq";
      arrayOfString[4] = "com.tencent.mtt.sdk.test";
      arrayOfString[5] = "com.qzone";
      for (;;)
      {
        if (i < arrayOfString.length)
        {
          if (paramContext.getPackageName().contains(arrayOfString[i])) {
            i(paramString, "app_extra pid:" + Process.myPid() + "; APP_TAG:" + new String[] { "DEMO", "QB", "WX", "QQ", "TEST", "QZ" }[i] + "!");
          }
        }
        else
        {
          if (i == arrayOfString.length) {
            i(paramString, "app_extra pid:" + Process.myPid() + "; APP_TAG:OTHER!");
          }
          return;
        }
        i += 1;
      }
      return;
    }
    catch (Throwable paramContext)
    {
      w(paramString, "app_extra exception:" + Log.getStackTraceString(paramContext));
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if (b == null) {
      return;
    }
    b.d(paramString1, "TBS:" + paramString2);
  }
  
  public static void d(String paramString1, String paramString2, boolean paramBoolean)
  {
    d(paramString1, paramString2);
    if ((b != null) && (a) && (paramBoolean)) {
      b.showLog(paramString1 + ": " + paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (b == null) {
      return;
    }
    b.e(paramString1, "TBS:" + paramString2);
    b.writeLog("(E)-" + paramString1 + "-TBS:" + paramString2);
  }
  
  public static void e(String paramString1, String paramString2, boolean paramBoolean)
  {
    e(paramString1, paramString2);
    if ((b != null) && (a) && (paramBoolean)) {
      b.showLog(paramString1 + ": " + paramString2);
    }
  }
  
  public static String getTbsLogFilePath()
  {
    if (TbsLogClient.c != null) {
      return TbsLogClient.c.getAbsolutePath();
    }
    return null;
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (b == null) {
      return;
    }
    b.i(paramString1, "TBS:" + paramString2);
    b.writeLog("(I)-" + paramString1 + "-TBS:" + paramString2);
  }
  
  public static void i(String paramString1, String paramString2, boolean paramBoolean)
  {
    i(paramString1, paramString2);
    if ((b != null) && (a) && (paramBoolean)) {
      b.showLog(paramString1 + ": " + paramString2);
    }
  }
  
  public static void initIfNeed(Context paramContext)
  {
    try
    {
      if (b == null) {
        setTbsLogClient(new TbsLogClient(paramContext));
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void setLogView(TextView paramTextView)
  {
    if ((paramTextView == null) || (b == null)) {
      return;
    }
    b.setLogView(paramTextView);
  }
  
  public static boolean setTbsLogClient(TbsLogClient paramTbsLogClient)
  {
    if (paramTbsLogClient == null) {
      return false;
    }
    b = paramTbsLogClient;
    return true;
  }
  
  public static void v(String paramString1, String paramString2)
  {
    if (b == null) {
      return;
    }
    b.v(paramString1, "TBS:" + paramString2);
  }
  
  public static void v(String paramString1, String paramString2, boolean paramBoolean)
  {
    v(paramString1, paramString2);
    if ((b != null) && (a) && (paramBoolean)) {
      b.showLog(paramString1 + ": " + paramString2);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (b == null) {
      return;
    }
    b.w(paramString1, "TBS:" + paramString2);
    b.writeLog("(W)-" + paramString1 + "-TBS:" + paramString2);
  }
  
  public static void w(String paramString1, String paramString2, boolean paramBoolean)
  {
    w(paramString1, paramString2);
    if ((b != null) && (a) && (paramBoolean)) {
      b.showLog(paramString1 + ": " + paramString2);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/utils/TbsLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */