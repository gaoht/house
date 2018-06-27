package com.freelxl.baselibrary.d.f;

import java.io.File;

public class b
  extends a<File>
{
  protected File a;
  
  public b(File paramFile)
  {
    this.a = paramFile;
  }
  
  /* Error */
  protected File a(okhttp3.Response paramResponse)
    throws java.lang.Exception
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload 6
    //   5: astore 4
    //   7: aload_0
    //   8: getfield 14	com/freelxl/baselibrary/d/f/b:a	Ljava/io/File;
    //   11: ifnull +17 -> 28
    //   14: aload_0
    //   15: getfield 14	com/freelxl/baselibrary/d/f/b:a	Ljava/io/File;
    //   18: invokevirtual 26	java/io/File:isDirectory	()Z
    //   21: ifeq +10 -> 31
    //   24: aload 6
    //   26: astore 4
    //   28: aload 4
    //   30: areturn
    //   31: sipush 2048
    //   34: newarray <illegal type>
    //   36: astore 4
    //   38: aload_1
    //   39: invokevirtual 32	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   42: invokevirtual 38	okhttp3/ResponseBody:byteStream	()Ljava/io/InputStream;
    //   45: astore 5
    //   47: aload_0
    //   48: getfield 14	com/freelxl/baselibrary/d/f/b:a	Ljava/io/File;
    //   51: invokevirtual 41	java/io/File:exists	()Z
    //   54: ifne +44 -> 98
    //   57: aload_0
    //   58: getfield 14	com/freelxl/baselibrary/d/f/b:a	Ljava/io/File;
    //   61: invokevirtual 44	java/io/File:createNewFile	()Z
    //   64: istore_3
    //   65: iload_3
    //   66: ifne +32 -> 98
    //   69: aload 5
    //   71: ifnull +8 -> 79
    //   74: aload 5
    //   76: invokevirtual 49	java/io/InputStream:close	()V
    //   79: aload 6
    //   81: astore 4
    //   83: iconst_0
    //   84: ifeq -56 -> 28
    //   87: new 51	java/lang/NullPointerException
    //   90: dup
    //   91: invokespecial 52	java/lang/NullPointerException:<init>	()V
    //   94: athrow
    //   95: astore_1
    //   96: aconst_null
    //   97: areturn
    //   98: new 54	java/io/FileOutputStream
    //   101: dup
    //   102: aload_0
    //   103: getfield 14	com/freelxl/baselibrary/d/f/b:a	Ljava/io/File;
    //   106: invokespecial 56	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   109: astore_1
    //   110: aload 5
    //   112: aload 4
    //   114: invokevirtual 60	java/io/InputStream:read	([B)I
    //   117: istore_2
    //   118: iload_2
    //   119: iconst_m1
    //   120: if_icmpeq +44 -> 164
    //   123: aload_1
    //   124: aload 4
    //   126: iconst_0
    //   127: iload_2
    //   128: invokevirtual 64	java/io/FileOutputStream:write	([BII)V
    //   131: goto -21 -> 110
    //   134: astore 6
    //   136: aload_1
    //   137: astore 4
    //   139: aload 6
    //   141: astore_1
    //   142: aload 5
    //   144: ifnull +8 -> 152
    //   147: aload 5
    //   149: invokevirtual 49	java/io/InputStream:close	()V
    //   152: aload 4
    //   154: ifnull +8 -> 162
    //   157: aload 4
    //   159: invokevirtual 65	java/io/FileOutputStream:close	()V
    //   162: aload_1
    //   163: athrow
    //   164: aload_1
    //   165: invokevirtual 68	java/io/FileOutputStream:flush	()V
    //   168: aload_0
    //   169: getfield 14	com/freelxl/baselibrary/d/f/b:a	Ljava/io/File;
    //   172: astore 6
    //   174: aload 5
    //   176: ifnull +8 -> 184
    //   179: aload 5
    //   181: invokevirtual 49	java/io/InputStream:close	()V
    //   184: aload 6
    //   186: astore 4
    //   188: aload_1
    //   189: ifnull -161 -> 28
    //   192: aload_1
    //   193: invokevirtual 65	java/io/FileOutputStream:close	()V
    //   196: aload 6
    //   198: areturn
    //   199: astore_1
    //   200: aload 6
    //   202: areturn
    //   203: astore_1
    //   204: goto -125 -> 79
    //   207: astore 4
    //   209: goto -25 -> 184
    //   212: astore 5
    //   214: goto -62 -> 152
    //   217: astore 4
    //   219: goto -57 -> 162
    //   222: astore_1
    //   223: aconst_null
    //   224: astore 5
    //   226: aconst_null
    //   227: astore 4
    //   229: goto -87 -> 142
    //   232: astore_1
    //   233: aconst_null
    //   234: astore 4
    //   236: goto -94 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	239	0	this	b
    //   0	239	1	paramResponse	okhttp3.Response
    //   117	11	2	i	int
    //   64	2	3	bool	boolean
    //   5	182	4	localObject1	Object
    //   207	1	4	localIOException1	java.io.IOException
    //   217	1	4	localIOException2	java.io.IOException
    //   227	8	4	localObject2	Object
    //   45	135	5	localInputStream	java.io.InputStream
    //   212	1	5	localIOException3	java.io.IOException
    //   224	1	5	localObject3	Object
    //   1	79	6	localObject4	Object
    //   134	6	6	localObject5	Object
    //   172	29	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   87	95	95	java/io/IOException
    //   110	118	134	finally
    //   123	131	134	finally
    //   164	174	134	finally
    //   192	196	199	java/io/IOException
    //   74	79	203	java/io/IOException
    //   179	184	207	java/io/IOException
    //   147	152	212	java/io/IOException
    //   157	162	217	java/io/IOException
    //   38	47	222	finally
    //   47	65	232	finally
    //   98	110	232	finally
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/d/f/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */