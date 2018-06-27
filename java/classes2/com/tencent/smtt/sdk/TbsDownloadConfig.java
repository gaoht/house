package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TbsDownloadConfig
{
  public static final int CMD_ID_DOWNLOAD_FILE = 101;
  public static final int CMD_ID_FILE_UPLOAD = 100;
  public static final long DEFAULT_RETRY_INTERVAL_SEC = 86400L;
  public static final int ERROR_DOWNLOAD = 2;
  public static final int ERROR_INSTALL = 5;
  public static final int ERROR_LOAD = 6;
  public static final int ERROR_NONE = 1;
  public static final int ERROR_REPORTED = 0;
  public static final int ERROR_UNZIP = 4;
  public static final int ERROR_VERIFY = 3;
  private static TbsDownloadConfig b;
  Map<String, Object> a = new HashMap();
  private Context c;
  public SharedPreferences mPreferences;
  
  private TbsDownloadConfig(Context paramContext)
  {
    this.mPreferences = paramContext.getSharedPreferences("tbs_download_config", 4);
    this.c = paramContext.getApplicationContext();
  }
  
  public static TbsDownloadConfig getInstance()
  {
    try
    {
      TbsDownloadConfig localTbsDownloadConfig = b;
      return localTbsDownloadConfig;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static TbsDownloadConfig getInstance(Context paramContext)
  {
    try
    {
      if (b == null) {
        b = new TbsDownloadConfig(paramContext);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  public void clear()
  {
    try
    {
      this.a.clear();
      SharedPreferences.Editor localEditor = this.mPreferences.edit();
      localEditor.clear();
      localEditor.commit();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void commit()
  {
    for (;;)
    {
      String str;
      Object localObject2;
      try
      {
        SharedPreferences.Editor localEditor = this.mPreferences.edit();
        Iterator localIterator = this.a.keySet().iterator();
        if (!localIterator.hasNext()) {
          break label203;
        }
        str = (String)localIterator.next();
        localObject2 = this.a.get(str);
        if ((localObject2 instanceof String))
        {
          localEditor.putString(str, (String)localObject2);
          continue;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
        if ((localObject2 instanceof Boolean))
        {
          localException.putBoolean(str, ((Boolean)localObject2).booleanValue());
          continue;
        }
      }
      finally {}
      if ((localObject2 instanceof Long))
      {
        ((SharedPreferences.Editor)localObject1).putLong(str, ((Long)localObject2).longValue());
      }
      else if ((localObject2 instanceof Integer))
      {
        ((SharedPreferences.Editor)localObject1).putInt(str, ((Integer)localObject2).intValue());
      }
      else if ((localObject2 instanceof Float))
      {
        ((SharedPreferences.Editor)localObject1).putFloat(str, ((Float)localObject2).floatValue());
        continue;
        label203:
        ((SharedPreferences.Editor)localObject1).commit();
        this.a.clear();
      }
    }
  }
  
  public int getDownloadFailedMaxRetrytimes()
  {
    try
    {
      int i = this.mPreferences.getInt("tbs_download_failed_max_retrytimes", 0);
      int j = i;
      if (i == 0) {
        j = 100;
      }
      return j;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public int getDownloadInterruptCode()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 59	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   6: ldc -79
    //   8: invokeinterface 181 2 0
    //   13: istore_3
    //   14: iload_3
    //   15: ifne +124 -> 139
    //   18: new 183	java/io/File
    //   21: dup
    //   22: new 183	java/io/File
    //   25: dup
    //   26: aload_0
    //   27: getfield 65	com/tencent/smtt/sdk/TbsDownloadConfig:c	Landroid/content/Context;
    //   30: invokevirtual 187	android/content/Context:getFilesDir	()Ljava/io/File;
    //   33: ldc -67
    //   35: invokespecial 192	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   38: ldc 51
    //   40: invokespecial 192	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   43: invokevirtual 195	java/io/File:exists	()Z
    //   46: istore_3
    //   47: iload_3
    //   48: ifne +55 -> 103
    //   51: bipush -97
    //   53: istore_1
    //   54: aload_0
    //   55: getfield 65	com/tencent/smtt/sdk/TbsDownloadConfig:c	Landroid/content/Context;
    //   58: ifnull +156 -> 214
    //   61: ldc -59
    //   63: aload_0
    //   64: getfield 65	com/tencent/smtt/sdk/TbsDownloadConfig:c	Landroid/content/Context;
    //   67: invokevirtual 201	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   70: getfield 207	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   73: invokevirtual 211	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   76: ifeq +138 -> 214
    //   79: ldc -43
    //   81: invokestatic 219	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   84: invokevirtual 223	java/util/Locale:getCountry	()Ljava/lang/String;
    //   87: invokevirtual 211	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   90: istore_3
    //   91: iload_3
    //   92: ifne +122 -> 214
    //   95: sipush 65216
    //   98: istore_1
    //   99: aload_0
    //   100: monitorexit
    //   101: iload_1
    //   102: ireturn
    //   103: aload_0
    //   104: getfield 59	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   107: ldc -31
    //   109: invokeinterface 181 2 0
    //   114: istore_3
    //   115: iload_3
    //   116: ifne +9 -> 125
    //   119: bipush -96
    //   121: istore_1
    //   122: goto -68 -> 54
    //   125: bipush -101
    //   127: istore_1
    //   128: goto -74 -> 54
    //   131: astore 4
    //   133: bipush -95
    //   135: istore_1
    //   136: goto -82 -> 54
    //   139: aload_0
    //   140: getfield 59	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   143: ldc -79
    //   145: bipush -99
    //   147: invokeinterface 172 3 0
    //   152: istore_1
    //   153: iload_1
    //   154: bipush -119
    //   156: if_icmpeq +11 -> 167
    //   159: iload_1
    //   160: istore_2
    //   161: iload_1
    //   162: bipush -121
    //   164: if_icmpne +17 -> 181
    //   167: aload_0
    //   168: getfield 59	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   171: ldc -29
    //   173: bipush -119
    //   175: invokeinterface 172 3 0
    //   180: istore_2
    //   181: iload_2
    //   182: istore_1
    //   183: invokestatic 232	java/lang/System:currentTimeMillis	()J
    //   186: aload_0
    //   187: getfield 59	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   190: ldc -22
    //   192: lconst_0
    //   193: invokeinterface 238 4 0
    //   198: lsub
    //   199: ldc2_w 239
    //   202: lcmp
    //   203: ifle -149 -> 54
    //   206: iload_2
    //   207: ldc -15
    //   209: isub
    //   210: istore_1
    //   211: goto -157 -> 54
    //   214: aload_0
    //   215: getfield 59	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   218: ldc -13
    //   220: iconst_m1
    //   221: invokeinterface 172 3 0
    //   226: istore_2
    //   227: iload_1
    //   228: sipush 1000
    //   231: imul
    //   232: iload_2
    //   233: iadd
    //   234: istore_1
    //   235: goto -136 -> 99
    //   238: astore 4
    //   240: aload_0
    //   241: monitorexit
    //   242: aload 4
    //   244: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	this	TbsDownloadConfig
    //   53	182	1	i	int
    //   160	74	2	j	int
    //   13	103	3	bool	boolean
    //   131	1	4	localThrowable	Throwable
    //   238	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   18	47	131	java/lang/Throwable
    //   103	115	131	java/lang/Throwable
    //   2	14	238	finally
    //   18	47	238	finally
    //   54	91	238	finally
    //   103	115	238	finally
    //   139	153	238	finally
    //   167	181	238	finally
    //   183	206	238	finally
    //   214	227	238	finally
  }
  
  public long getDownloadMaxflow()
  {
    try
    {
      int i = this.mPreferences.getInt("tbs_download_maxflow", 0);
      int j = i;
      if (i == 0) {
        j = 20;
      }
      long l = j * 1024;
      return l * 1024L;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public long getDownloadMinFreeSpace()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 59	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   8: ldc -5
    //   10: iconst_0
    //   11: invokeinterface 172 3 0
    //   16: istore_2
    //   17: iload_2
    //   18: ifne +18 -> 36
    //   21: iload_1
    //   22: sipush 1024
    //   25: imul
    //   26: i2l
    //   27: lstore_3
    //   28: aload_0
    //   29: monitorexit
    //   30: lload_3
    //   31: ldc2_w 247
    //   34: lmul
    //   35: lreturn
    //   36: iload_2
    //   37: istore_1
    //   38: goto -17 -> 21
    //   41: astore 5
    //   43: aload_0
    //   44: monitorexit
    //   45: aload 5
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	TbsDownloadConfig
    //   1	37	1	i	int
    //   16	21	2	j	int
    //   27	4	3	l	long
    //   41	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	17	41	finally
  }
  
  public long getDownloadSingleTimeout()
  {
    try
    {
      long l1 = this.mPreferences.getLong("tbs_single_timeout", 0L);
      long l2 = l1;
      if (l1 == 0L) {
        l2 = 1200000L;
      }
      return l2;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getDownloadSuccessMaxRetrytimes()
  {
    try
    {
      int i = this.mPreferences.getInt("tbs_download_success_max_retrytimes", 0);
      int j = i;
      if (i == 0) {
        j = 3;
      }
      return j;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long getRetryInterval()
  {
    try
    {
      long l = this.mPreferences.getLong("retry_interval", 86400L);
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isOverSea()
  {
    try
    {
      boolean bool = this.mPreferences.getBoolean("is_oversea", false);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public void setDownloadInterruptCode(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 59	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   6: invokeinterface 86 1 0
    //   11: astore_2
    //   12: aload_2
    //   13: ldc -79
    //   15: iload_1
    //   16: invokeinterface 155 3 0
    //   21: pop
    //   22: aload_2
    //   23: ldc -22
    //   25: invokestatic 232	java/lang/System:currentTimeMillis	()J
    //   28: invokeinterface 145 4 0
    //   33: pop
    //   34: aload_2
    //   35: invokeinterface 94 1 0
    //   40: pop
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: astore_2
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_2
    //   48: athrow
    //   49: astore_2
    //   50: goto -9 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	TbsDownloadConfig
    //   0	53	1	paramInt	int
    //   11	24	2	localEditor	SharedPreferences.Editor
    //   44	4	2	localObject	Object
    //   49	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	41	44	finally
    //   2	41	49	java/lang/Exception
  }
  
  public void setInstallInterruptCode(int paramInt)
  {
    try
    {
      SharedPreferences.Editor localEditor = this.mPreferences.edit();
      localEditor.putInt("tbs_install_interrupt_code", paramInt);
      localEditor.commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static abstract interface TbsConfigKey
  {
    public static final String KEY_APP_METADATA = "app_metadata";
    public static final String KEY_APP_VERSIONCODE = "app_versioncode";
    public static final String KEY_APP_VERSIONCODE_FOR_SWITCH = "app_versioncode_for_switch";
    public static final String KEY_APP_VERSIONNAME = "app_versionname";
    public static final String KEY_BACKUPCORE_DELFILELIST = "backupcore_delfilelist";
    public static final String KEY_DESkEY_TOKEN = "tbs_deskey_token";
    public static final String KEY_DEVICE_CPUABI = "device_cpuabi";
    public static final String KEY_DOWNLOADURL_LIST = "tbs_downloadurl_list";
    public static final String KEY_DOWNLOAD_FAILED_MAX_RETRYTIMES = "tbs_download_failed_max_retrytimes";
    public static final String KEY_DOWNLOAD_FAILED_RETRYTIMES = "tbs_download_failed_retrytimes";
    public static final String KEY_DOWNLOAD_INTERRUPT_CODE = "tbs_download_interrupt_code";
    public static final String KEY_DOWNLOAD_INTERRUPT_CODE_REASON = "tbs_download_interrupt_code_reason";
    public static final String KEY_DOWNLOAD_INTERRUPT_TIME = "tbs_download_interrupt_time";
    public static final String KEY_DOWNLOAD_MAXFLOW = "tbs_download_maxflow";
    public static final String KEY_DOWNLOAD_MIN_FREE_SPACE = "tbs_download_min_free_space";
    public static final String KEY_DOWNLOAD_SINGLE_TIMEOUT = "tbs_single_timeout";
    public static final String KEY_DOWNLOAD_SUCCESS_MAX_RETRYTIMES = "tbs_download_success_max_retrytimes";
    public static final String KEY_DOWNLOAD_SUCCESS_RETRYTIMES = "tbs_download_success_retrytimes";
    public static final String KEY_FULL_PACKAGE = "request_full_package";
    public static final String KEY_INSTALL_INTERRUPT_CODE = "tbs_install_interrupt_code";
    public static final String KEY_IS_OVERSEA = "is_oversea";
    public static final String KEY_LAST_CHECK = "last_check";
    public static final String KEY_LAST_THIRDAPP_SENDREQUEST_COREVERSION = "last_thirdapp_sendrequest_coreversion";
    public static final String KEY_NEEDDOWNLOAD = "tbs_needdownload";
    public static final String KEY_RESPONSECODE = "tbs_responsecode";
    public static final String KEY_RETRY_INTERVAL = "retry_interval";
    public static final String KEY_SWITCH_BACKUPCORE_ENABLE = "switch_backupcore_enable";
    public static final String KEY_TBSAPKFILESIZE = "tbs_apkfilesize";
    public static final String KEY_TBSAPK_MD5 = "tbs_apk_md5";
    public static final String KEY_TBSDOWNLOADURL = "tbs_downloadurl";
    public static final String KEY_TBSDOWNLOAD_FLOW = "tbs_downloadflow";
    public static final String KEY_TBSDOWNLOAD_STARTTIME = "tbs_downloadstarttime";
    public static final String KEY_TBS_DOWNLOAD_V = "tbs_download_version";
    public static final String KEY_USE_BACKUP_VERSION = "use_backup_version";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/sdk/TbsDownloadConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */