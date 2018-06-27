package com.mato.sdk.c.d;

import com.mato.sdk.b.g;
import com.mato.sdk.g.b;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public final class d
{
  private static final String a = g.b("");
  private final File b;
  
  public d(File paramFile)
  {
    this.b = paramFile;
  }
  
  /* Error */
  private static void a(File paramFile)
    throws java.lang.Exception
  {
    // Byte code:
    //   0: new 32	java/io/RandomAccessFile
    //   3: dup
    //   4: aload_0
    //   5: ldc 34
    //   7: invokespecial 37	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   10: astore_1
    //   11: new 39	java/util/ArrayList
    //   14: dup
    //   15: bipush 10
    //   17: invokespecial 42	java/util/ArrayList:<init>	(I)V
    //   20: astore_0
    //   21: aload_1
    //   22: invokevirtual 46	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   25: astore_2
    //   26: aload_2
    //   27: ifnull +72 -> 99
    //   30: new 48	com/mato/sdk/c/d/a$a
    //   33: dup
    //   34: aload_2
    //   35: invokespecial 51	com/mato/sdk/c/d/a$a:<init>	(Ljava/lang/String;)V
    //   38: invokevirtual 54	com/mato/sdk/c/d/a$a:a	()Lcom/mato/sdk/c/d/a;
    //   41: astore_2
    //   42: aload_2
    //   43: ifnull -22 -> 21
    //   46: aload_0
    //   47: aload_2
    //   48: invokestatic 57	com/mato/sdk/c/d/d:b	(Ljava/util/ArrayList;Lcom/mato/sdk/c/d/a;)Lcom/mato/sdk/c/d/a;
    //   51: astore_3
    //   52: aload_3
    //   53: ifnull +37 -> 90
    //   56: aload_3
    //   57: aload_2
    //   58: invokevirtual 62	com/mato/sdk/c/d/a:b	(Lcom/mato/sdk/c/d/a;)Z
    //   61: ifeq -40 -> 21
    //   64: aload_0
    //   65: aload_3
    //   66: invokevirtual 66	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   69: pop
    //   70: aload_0
    //   71: aload_2
    //   72: invokevirtual 69	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   75: pop
    //   76: goto -55 -> 21
    //   79: astore_0
    //   80: aload_1
    //   81: ifnull +7 -> 88
    //   84: aload_1
    //   85: invokevirtual 72	java/io/RandomAccessFile:close	()V
    //   88: aload_0
    //   89: athrow
    //   90: aload_0
    //   91: aload_2
    //   92: invokevirtual 69	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   95: pop
    //   96: goto -75 -> 21
    //   99: aload_1
    //   100: lconst_0
    //   101: invokevirtual 76	java/io/RandomAccessFile:setLength	(J)V
    //   104: aload_0
    //   105: invokevirtual 80	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   108: astore_0
    //   109: aload_0
    //   110: invokeinterface 86 1 0
    //   115: ifeq +34 -> 149
    //   118: aload_1
    //   119: aload_0
    //   120: invokeinterface 90 1 0
    //   125: checkcast 59	com/mato/sdk/c/d/a
    //   128: invokevirtual 92	com/mato/sdk/c/d/a:a	()Ljava/lang/String;
    //   131: invokevirtual 98	java/lang/String:getBytes	()[B
    //   134: invokevirtual 102	java/io/RandomAccessFile:write	([B)V
    //   137: aload_1
    //   138: ldc 104
    //   140: invokevirtual 98	java/lang/String:getBytes	()[B
    //   143: invokevirtual 102	java/io/RandomAccessFile:write	([B)V
    //   146: goto -37 -> 109
    //   149: aload_1
    //   150: invokevirtual 72	java/io/RandomAccessFile:close	()V
    //   153: return
    //   154: astore_0
    //   155: return
    //   156: astore_1
    //   157: goto -69 -> 88
    //   160: astore_0
    //   161: aconst_null
    //   162: astore_1
    //   163: goto -83 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	paramFile	File
    //   10	140	1	localRandomAccessFile	java.io.RandomAccessFile
    //   156	1	1	localIOException	java.io.IOException
    //   162	1	1	localObject1	Object
    //   25	67	2	localObject2	Object
    //   51	15	3	locala	a
    // Exception table:
    //   from	to	target	type
    //   11	21	79	finally
    //   21	26	79	finally
    //   30	42	79	finally
    //   46	52	79	finally
    //   56	76	79	finally
    //   90	96	79	finally
    //   99	109	79	finally
    //   109	146	79	finally
    //   149	153	154	java/io/IOException
    //   84	88	156	java/io/IOException
    //   0	11	160	finally
  }
  
  private static void a(ArrayList<a> paramArrayList, a parama)
  {
    Iterator localIterator = paramArrayList.iterator();
    a locala;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      locala = (a)localIterator.next();
    } while (!locala.a(parama));
    while (locala != null)
    {
      if (locala.b(parama))
      {
        paramArrayList.remove(locala);
        paramArrayList.add(parama);
      }
      return;
      locala = null;
    }
    paramArrayList.add(parama);
  }
  
  private static a b(ArrayList<a> paramArrayList, a parama)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      a locala = (a)paramArrayList.next();
      if (locala.a(parama)) {
        return locala;
      }
    }
    return null;
  }
  
  /* Error */
  public final void a(a parama)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 92	com/mato/sdk/c/d/a:a	()Ljava/lang/String;
    //   4: astore_3
    //   5: aconst_null
    //   6: astore_2
    //   7: new 114	java/io/FileOutputStream
    //   10: dup
    //   11: aload_0
    //   12: getfield 26	com/mato/sdk/c/d/d:b	Ljava/io/File;
    //   15: iconst_1
    //   16: invokespecial 117	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   19: astore_1
    //   20: aload_1
    //   21: ldc 104
    //   23: invokevirtual 98	java/lang/String:getBytes	()[B
    //   26: invokevirtual 118	java/io/FileOutputStream:write	([B)V
    //   29: aload_1
    //   30: aload_3
    //   31: invokevirtual 98	java/lang/String:getBytes	()[B
    //   34: invokevirtual 118	java/io/FileOutputStream:write	([B)V
    //   37: aload_1
    //   38: invokevirtual 121	java/io/FileOutputStream:flush	()V
    //   41: aload_1
    //   42: invokevirtual 122	java/io/FileOutputStream:close	()V
    //   45: return
    //   46: astore_1
    //   47: aconst_null
    //   48: astore_1
    //   49: aload_1
    //   50: ifnull -5 -> 45
    //   53: aload_1
    //   54: invokevirtual 122	java/io/FileOutputStream:close	()V
    //   57: return
    //   58: astore_1
    //   59: return
    //   60: astore_1
    //   61: aload_2
    //   62: ifnull +7 -> 69
    //   65: aload_2
    //   66: invokevirtual 122	java/io/FileOutputStream:close	()V
    //   69: aload_1
    //   70: athrow
    //   71: astore_1
    //   72: return
    //   73: astore_2
    //   74: goto -5 -> 69
    //   77: astore_3
    //   78: aload_1
    //   79: astore_2
    //   80: aload_3
    //   81: astore_1
    //   82: goto -21 -> 61
    //   85: astore_2
    //   86: goto -37 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	d
    //   0	89	1	parama	a
    //   6	60	2	localObject1	Object
    //   73	1	2	localIOException	java.io.IOException
    //   79	1	2	locala	a
    //   85	1	2	localException	Exception
    //   4	27	3	str	String
    //   77	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   7	20	46	java/lang/Exception
    //   53	57	58	java/io/IOException
    //   7	20	60	finally
    //   41	45	71	java/io/IOException
    //   65	69	73	java/io/IOException
    //   20	41	77	finally
    //   20	41	85	java/lang/Exception
  }
  
  /* Error */
  public final void a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 114	java/io/FileOutputStream
    //   5: dup
    //   6: aload_0
    //   7: getfield 26	com/mato/sdk/c/d/d:b	Ljava/io/File;
    //   10: iconst_1
    //   11: invokespecial 117	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   14: astore_2
    //   15: aload_2
    //   16: ldc 104
    //   18: invokevirtual 98	java/lang/String:getBytes	()[B
    //   21: invokevirtual 118	java/io/FileOutputStream:write	([B)V
    //   24: aload_2
    //   25: aload_1
    //   26: invokevirtual 98	java/lang/String:getBytes	()[B
    //   29: invokevirtual 118	java/io/FileOutputStream:write	([B)V
    //   32: aload_2
    //   33: invokevirtual 121	java/io/FileOutputStream:flush	()V
    //   36: aload_2
    //   37: invokevirtual 122	java/io/FileOutputStream:close	()V
    //   40: return
    //   41: astore_1
    //   42: aconst_null
    //   43: astore_2
    //   44: aload_2
    //   45: ifnull -5 -> 40
    //   48: aload_2
    //   49: invokevirtual 122	java/io/FileOutputStream:close	()V
    //   52: return
    //   53: astore_1
    //   54: return
    //   55: astore_1
    //   56: aload_3
    //   57: astore_2
    //   58: aload_2
    //   59: ifnull +7 -> 66
    //   62: aload_2
    //   63: invokevirtual 122	java/io/FileOutputStream:close	()V
    //   66: aload_1
    //   67: athrow
    //   68: astore_1
    //   69: return
    //   70: astore_2
    //   71: goto -5 -> 66
    //   74: astore_1
    //   75: goto -17 -> 58
    //   78: astore_1
    //   79: goto -35 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	d
    //   0	82	1	paramString	String
    //   14	49	2	localObject1	Object
    //   70	1	2	localIOException	java.io.IOException
    //   1	56	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	15	41	java/lang/Exception
    //   48	52	53	java/io/IOException
    //   2	15	55	finally
    //   36	40	68	java/io/IOException
    //   62	66	70	java/io/IOException
    //   15	36	74	finally
    //   15	36	78	java/lang/Exception
  }
  
  /* Error */
  public final byte[] a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 26	com/mato/sdk/c/d/d:b	Ljava/io/File;
    //   4: astore_1
    //   5: new 32	java/io/RandomAccessFile
    //   8: dup
    //   9: aload_1
    //   10: ldc 34
    //   12: invokespecial 37	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   15: astore_2
    //   16: new 39	java/util/ArrayList
    //   19: dup
    //   20: bipush 10
    //   22: invokespecial 42	java/util/ArrayList:<init>	(I)V
    //   25: astore_1
    //   26: aload_2
    //   27: invokevirtual 46	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   30: astore_3
    //   31: aload_3
    //   32: ifnull +79 -> 111
    //   35: new 48	com/mato/sdk/c/d/a$a
    //   38: dup
    //   39: aload_3
    //   40: invokespecial 51	com/mato/sdk/c/d/a$a:<init>	(Ljava/lang/String;)V
    //   43: invokevirtual 54	com/mato/sdk/c/d/a$a:a	()Lcom/mato/sdk/c/d/a;
    //   46: astore_3
    //   47: aload_3
    //   48: ifnull -22 -> 26
    //   51: aload_1
    //   52: aload_3
    //   53: invokestatic 57	com/mato/sdk/c/d/d:b	(Ljava/util/ArrayList;Lcom/mato/sdk/c/d/a;)Lcom/mato/sdk/c/d/a;
    //   56: astore 4
    //   58: aload 4
    //   60: ifnull +42 -> 102
    //   63: aload 4
    //   65: aload_3
    //   66: invokevirtual 62	com/mato/sdk/c/d/a:b	(Lcom/mato/sdk/c/d/a;)Z
    //   69: ifeq -43 -> 26
    //   72: aload_1
    //   73: aload 4
    //   75: invokevirtual 66	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   78: pop
    //   79: aload_1
    //   80: aload_3
    //   81: invokevirtual 69	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   84: pop
    //   85: goto -59 -> 26
    //   88: astore_1
    //   89: aload_2
    //   90: ifnull +7 -> 97
    //   93: aload_2
    //   94: invokevirtual 72	java/io/RandomAccessFile:close	()V
    //   97: aload_1
    //   98: athrow
    //   99: astore_1
    //   100: aconst_null
    //   101: areturn
    //   102: aload_1
    //   103: aload_3
    //   104: invokevirtual 69	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   107: pop
    //   108: goto -82 -> 26
    //   111: aload_2
    //   112: lconst_0
    //   113: invokevirtual 76	java/io/RandomAccessFile:setLength	(J)V
    //   116: aload_1
    //   117: invokevirtual 80	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   120: astore_1
    //   121: aload_1
    //   122: invokeinterface 86 1 0
    //   127: ifeq +34 -> 161
    //   130: aload_2
    //   131: aload_1
    //   132: invokeinterface 90 1 0
    //   137: checkcast 59	com/mato/sdk/c/d/a
    //   140: invokevirtual 92	com/mato/sdk/c/d/a:a	()Ljava/lang/String;
    //   143: invokevirtual 98	java/lang/String:getBytes	()[B
    //   146: invokevirtual 102	java/io/RandomAccessFile:write	([B)V
    //   149: aload_2
    //   150: ldc 104
    //   152: invokevirtual 98	java/lang/String:getBytes	()[B
    //   155: invokevirtual 102	java/io/RandomAccessFile:write	([B)V
    //   158: goto -37 -> 121
    //   161: aload_2
    //   162: invokevirtual 72	java/io/RandomAccessFile:close	()V
    //   165: aload_0
    //   166: getfield 26	com/mato/sdk/c/d/d:b	Ljava/io/File;
    //   169: invokestatic 127	com/mato/sdk/g/b:b	(Ljava/io/File;)[B
    //   172: astore_1
    //   173: aload_1
    //   174: areturn
    //   175: astore_1
    //   176: goto -11 -> 165
    //   179: astore_2
    //   180: goto -83 -> 97
    //   183: astore_1
    //   184: aconst_null
    //   185: astore_2
    //   186: goto -97 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	d
    //   4	76	1	localObject1	Object
    //   88	10	1	localObject2	Object
    //   99	18	1	localException	Exception
    //   120	54	1	localObject3	Object
    //   175	1	1	localIOException1	java.io.IOException
    //   183	1	1	localObject4	Object
    //   15	147	2	localRandomAccessFile	java.io.RandomAccessFile
    //   179	1	2	localIOException2	java.io.IOException
    //   185	1	2	localObject5	Object
    //   30	74	3	localObject6	Object
    //   56	18	4	locala	a
    // Exception table:
    //   from	to	target	type
    //   16	26	88	finally
    //   26	31	88	finally
    //   35	47	88	finally
    //   51	58	88	finally
    //   63	85	88	finally
    //   102	108	88	finally
    //   111	121	88	finally
    //   121	158	88	finally
    //   0	5	99	java/lang/Exception
    //   93	97	99	java/lang/Exception
    //   97	99	99	java/lang/Exception
    //   161	165	99	java/lang/Exception
    //   165	173	99	java/lang/Exception
    //   161	165	175	java/io/IOException
    //   93	97	179	java/io/IOException
    //   5	16	183	finally
  }
  
  public final boolean b()
  {
    return b.a(this.b);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/c/d/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */