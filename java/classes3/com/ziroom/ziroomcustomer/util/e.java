package com.ziroom.ziroomcustomer.util;

import com.baidu.mapapi.map.MapView;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import java.io.File;

public class e
{
  public static void initMapStyle()
  {
    Object localObject = ApplicationEx.c.getFilesDir().getAbsolutePath();
    localObject = new File((String)localObject + "/" + "mapStyleCustomerConfig");
    if (((File)localObject).exists()) {
      return;
    }
    new Thread(new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 5
        //   3: aconst_null
        //   4: astore_3
        //   5: getstatic 29	com/ziroom/ziroomcustomer/base/ApplicationEx:c	Lcom/ziroom/ziroomcustomer/base/ApplicationEx;
        //   8: invokevirtual 33	com/ziroom/ziroomcustomer/base/ApplicationEx:getAssets	()Landroid/content/res/AssetManager;
        //   11: ldc 35
        //   13: invokevirtual 41	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
        //   16: astore_2
        //   17: new 43	java/io/FileOutputStream
        //   20: dup
        //   21: aload_0
        //   22: getfield 17	com/ziroom/ziroomcustomer/util/e$1:a	Ljava/io/File;
        //   25: invokespecial 45	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   28: astore 4
        //   30: sipush 1024
        //   33: newarray <illegal type>
        //   35: astore_3
        //   36: aload_2
        //   37: aload_3
        //   38: invokevirtual 51	java/io/InputStream:read	([B)I
        //   41: istore_1
        //   42: iload_1
        //   43: iconst_m1
        //   44: if_icmpeq +47 -> 91
        //   47: aload 4
        //   49: aload_3
        //   50: iconst_0
        //   51: iload_1
        //   52: invokevirtual 57	java/io/OutputStream:write	([BII)V
        //   55: goto -19 -> 36
        //   58: astore 5
        //   60: aload_2
        //   61: astore_3
        //   62: aload 4
        //   64: astore_2
        //   65: aload 5
        //   67: astore 4
        //   69: aload 4
        //   71: invokevirtual 60	java/io/IOException:printStackTrace	()V
        //   74: aload_3
        //   75: ifnull +7 -> 82
        //   78: aload_3
        //   79: invokevirtual 63	java/io/InputStream:close	()V
        //   82: aload_2
        //   83: ifnull +7 -> 90
        //   86: aload_2
        //   87: invokevirtual 64	java/io/OutputStream:close	()V
        //   90: return
        //   91: aload_2
        //   92: ifnull +7 -> 99
        //   95: aload_2
        //   96: invokevirtual 63	java/io/InputStream:close	()V
        //   99: aload 4
        //   101: ifnull -11 -> 90
        //   104: aload 4
        //   106: invokevirtual 64	java/io/OutputStream:close	()V
        //   109: return
        //   110: astore_2
        //   111: aload_2
        //   112: invokevirtual 60	java/io/IOException:printStackTrace	()V
        //   115: return
        //   116: astore_2
        //   117: aload_2
        //   118: invokevirtual 60	java/io/IOException:printStackTrace	()V
        //   121: return
        //   122: astore_3
        //   123: aconst_null
        //   124: astore_2
        //   125: aload 5
        //   127: astore 4
        //   129: aload_2
        //   130: ifnull +7 -> 137
        //   133: aload_2
        //   134: invokevirtual 63	java/io/InputStream:close	()V
        //   137: aload 4
        //   139: ifnull +8 -> 147
        //   142: aload 4
        //   144: invokevirtual 64	java/io/OutputStream:close	()V
        //   147: aload_3
        //   148: athrow
        //   149: astore_2
        //   150: aload_2
        //   151: invokevirtual 60	java/io/IOException:printStackTrace	()V
        //   154: goto -7 -> 147
        //   157: astore_2
        //   158: goto -59 -> 99
        //   161: astore_3
        //   162: goto -80 -> 82
        //   165: astore_2
        //   166: goto -29 -> 137
        //   169: astore_3
        //   170: aload 5
        //   172: astore 4
        //   174: goto -45 -> 129
        //   177: astore_3
        //   178: goto -49 -> 129
        //   181: astore 4
        //   183: aload_3
        //   184: astore 5
        //   186: aload 4
        //   188: astore_3
        //   189: aload_2
        //   190: astore 4
        //   192: aload 5
        //   194: astore_2
        //   195: goto -66 -> 129
        //   198: astore 4
        //   200: aconst_null
        //   201: astore_2
        //   202: goto -133 -> 69
        //   205: astore 4
        //   207: aconst_null
        //   208: astore 5
        //   210: aload_2
        //   211: astore_3
        //   212: aload 5
        //   214: astore_2
        //   215: goto -146 -> 69
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	218	0	this	1
        //   41	11	1	i	int
        //   16	80	2	localObject1	Object
        //   110	2	2	localIOException1	java.io.IOException
        //   116	2	2	localIOException2	java.io.IOException
        //   124	10	2	localObject2	Object
        //   149	2	2	localIOException3	java.io.IOException
        //   157	1	2	localIOException4	java.io.IOException
        //   165	25	2	localIOException5	java.io.IOException
        //   194	21	2	localObject3	Object
        //   4	75	3	localObject4	Object
        //   122	26	3	localObject5	Object
        //   161	1	3	localIOException6	java.io.IOException
        //   169	1	3	localObject6	Object
        //   177	7	3	localObject7	Object
        //   188	24	3	localObject8	Object
        //   28	145	4	localObject9	Object
        //   181	6	4	localObject10	Object
        //   190	1	4	localIOException7	java.io.IOException
        //   198	1	4	localIOException8	java.io.IOException
        //   205	1	4	localIOException9	java.io.IOException
        //   1	1	5	localObject11	Object
        //   58	113	5	localIOException10	java.io.IOException
        //   184	29	5	localObject12	Object
        // Exception table:
        //   from	to	target	type
        //   30	36	58	java/io/IOException
        //   36	42	58	java/io/IOException
        //   47	55	58	java/io/IOException
        //   104	109	110	java/io/IOException
        //   86	90	116	java/io/IOException
        //   5	17	122	finally
        //   142	147	149	java/io/IOException
        //   95	99	157	java/io/IOException
        //   78	82	161	java/io/IOException
        //   133	137	165	java/io/IOException
        //   17	30	169	finally
        //   30	36	177	finally
        //   36	42	177	finally
        //   47	55	177	finally
        //   69	74	181	finally
        //   5	17	198	java/io/IOException
        //   17	30	205	java/io/IOException
      }
    }).start();
  }
  
  public static void initMapStylePath()
  {
    String str = ApplicationEx.c.getFilesDir().getAbsolutePath();
    if (new File(str + "/" + "mapStyleCustomerConfig").exists()) {
      MapView.setCustomMapStylePath(str + "/" + "mapStyleCustomerConfig");
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/util/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */