package com.tencent.smtt.utils;

import android.content.Context;
import android.provider.Settings.System;
import android.text.TextUtils;

public class t
{
  private static t a = null;
  private static Context b = null;
  
  public static t a(Context paramContext)
  {
    b = paramContext.getApplicationContext();
    if (a == null) {
      a = new t();
    }
    return a;
  }
  
  /* Error */
  private void b(String paramString)
  {
    // Byte code:
    //   0: invokestatic 36	com/tencent/smtt/utils/j:b	()Z
    //   3: ifne +4 -> 7
    //   6: return
    //   7: aconst_null
    //   8: astore_3
    //   9: aconst_null
    //   10: astore 4
    //   12: aload_3
    //   13: astore_2
    //   14: new 38	java/io/File
    //   17: dup
    //   18: invokestatic 42	com/tencent/smtt/utils/j:c	()Ljava/io/File;
    //   21: ldc 44
    //   23: invokespecial 47	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   26: astore 5
    //   28: aload_3
    //   29: astore_2
    //   30: aload 5
    //   32: invokevirtual 50	java/io/File:exists	()Z
    //   35: ifne +11 -> 46
    //   38: aload_3
    //   39: astore_2
    //   40: aload 5
    //   42: invokevirtual 53	java/io/File:createNewFile	()Z
    //   45: pop
    //   46: aload_3
    //   47: astore_2
    //   48: new 55	java/io/DataOutputStream
    //   51: dup
    //   52: new 57	java/io/BufferedOutputStream
    //   55: dup
    //   56: aload 5
    //   58: invokestatic 61	com/tencent/smtt/utils/j:d	(Ljava/io/File;)Ljava/io/FileOutputStream;
    //   61: invokespecial 64	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   64: invokespecial 65	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   67: astore_3
    //   68: aload_3
    //   69: aload_1
    //   70: invokevirtual 68	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   73: aload_3
    //   74: invokevirtual 71	java/io/DataOutputStream:flush	()V
    //   77: aload_3
    //   78: ifnull -72 -> 6
    //   81: aload_3
    //   82: invokevirtual 74	java/io/DataOutputStream:close	()V
    //   85: return
    //   86: astore_1
    //   87: aload_1
    //   88: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   91: return
    //   92: astore_3
    //   93: aload 4
    //   95: astore_1
    //   96: aload_1
    //   97: astore_2
    //   98: aload_3
    //   99: invokevirtual 78	java/lang/Exception:printStackTrace	()V
    //   102: aload_1
    //   103: ifnull -97 -> 6
    //   106: aload_1
    //   107: invokevirtual 74	java/io/DataOutputStream:close	()V
    //   110: return
    //   111: astore_1
    //   112: goto -25 -> 87
    //   115: astore_1
    //   116: aload_2
    //   117: ifnull +7 -> 124
    //   120: aload_2
    //   121: invokevirtual 74	java/io/DataOutputStream:close	()V
    //   124: aload_1
    //   125: athrow
    //   126: astore_2
    //   127: aload_2
    //   128: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   131: goto -7 -> 124
    //   134: astore_1
    //   135: aload_3
    //   136: astore_2
    //   137: goto -21 -> 116
    //   140: astore_2
    //   141: aload_3
    //   142: astore_1
    //   143: aload_2
    //   144: astore_3
    //   145: goto -49 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	t
    //   0	148	1	paramString	String
    //   13	108	2	localObject1	Object
    //   126	2	2	localIOException	java.io.IOException
    //   136	1	2	localException1	Exception
    //   140	4	2	localException2	Exception
    //   8	74	3	localDataOutputStream	java.io.DataOutputStream
    //   92	50	3	localException3	Exception
    //   144	1	3	localObject2	Object
    //   10	84	4	localObject3	Object
    //   26	31	5	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   81	85	86	java/io/IOException
    //   14	28	92	java/lang/Exception
    //   30	38	92	java/lang/Exception
    //   40	46	92	java/lang/Exception
    //   48	68	92	java/lang/Exception
    //   106	110	111	java/io/IOException
    //   14	28	115	finally
    //   30	38	115	finally
    //   40	46	115	finally
    //   48	68	115	finally
    //   98	102	115	finally
    //   120	124	126	java/io/IOException
    //   68	77	134	finally
    //   68	77	140	java/lang/Exception
  }
  
  private void c(String paramString)
  {
    try
    {
      Settings.System.putString(b.getContentResolver(), "sys_setting_tbs_qb_installer", paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    b(paramString);
    c(paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/utils/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */