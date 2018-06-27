package com.mato.sdk.c.a;

import android.util.SparseArray;
import com.mato.sdk.b.g;
import com.mato.sdk.g.a.a;
import com.mato.sdk.g.a.b;
import com.mato.sdk.g.a.c;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;

public final class f
  extends c
{
  private static final String a = g.b("");
  private static final int b = 10;
  private static final int c = 2000;
  private b d;
  private final a.1 e;
  private a f;
  private final b g;
  private boolean h;
  
  public f(String paramString, a.1 param1)
  {
    this.e = param1;
    this.g = new b(paramString);
    this.h = false;
  }
  
  /* Error */
  private boolean h()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iconst_0
    //   3: istore_2
    //   4: iload_3
    //   5: istore_1
    //   6: aload_0
    //   7: getfield 56	com/mato/sdk/c/a/f:f	Lcom/mato/sdk/c/a/f$a;
    //   10: invokevirtual 59	com/mato/sdk/c/a/f$a:a	()I
    //   13: iconst_5
    //   14: iadd
    //   15: sipush 2000
    //   18: if_icmple +68 -> 86
    //   21: aload_0
    //   22: getfield 48	com/mato/sdk/c/a/f:g	Lcom/mato/sdk/c/a/f$b;
    //   25: invokevirtual 61	com/mato/sdk/c/a/f$b:d	()Ljava/lang/String;
    //   28: astore 6
    //   30: iload_3
    //   31: istore_1
    //   32: new 63	java/io/File
    //   35: dup
    //   36: aload 6
    //   38: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   41: invokevirtual 67	java/io/File:exists	()Z
    //   44: ifeq +42 -> 86
    //   47: aconst_null
    //   48: astore 7
    //   50: new 69	java/io/RandomAccessFile
    //   53: dup
    //   54: aload 6
    //   56: ldc 71
    //   58: invokespecial 74	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: astore 6
    //   63: aload 6
    //   65: invokevirtual 78	java/io/RandomAccessFile:length	()J
    //   68: lstore 4
    //   70: iload_2
    //   71: istore_1
    //   72: lload 4
    //   74: lconst_0
    //   75: lcmp
    //   76: ifle +5 -> 81
    //   79: iconst_1
    //   80: istore_1
    //   81: aload 6
    //   83: invokevirtual 81	java/io/RandomAccessFile:close	()V
    //   86: iload_1
    //   87: ireturn
    //   88: astore 6
    //   90: aconst_null
    //   91: astore 6
    //   93: iload_3
    //   94: istore_1
    //   95: aload 6
    //   97: ifnull -11 -> 86
    //   100: aload 6
    //   102: invokevirtual 81	java/io/RandomAccessFile:close	()V
    //   105: iconst_0
    //   106: ireturn
    //   107: astore 6
    //   109: iconst_0
    //   110: ireturn
    //   111: astore 6
    //   113: aload 7
    //   115: ifnull +8 -> 123
    //   118: aload 7
    //   120: invokevirtual 81	java/io/RandomAccessFile:close	()V
    //   123: aload 6
    //   125: athrow
    //   126: astore 6
    //   128: iload_1
    //   129: ireturn
    //   130: astore 7
    //   132: goto -9 -> 123
    //   135: astore 8
    //   137: aload 6
    //   139: astore 7
    //   141: aload 8
    //   143: astore 6
    //   145: goto -32 -> 113
    //   148: astore 7
    //   150: goto -57 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	f
    //   5	124	1	bool1	boolean
    //   3	68	2	bool2	boolean
    //   1	93	3	bool3	boolean
    //   68	5	4	l	long
    //   28	54	6	localObject1	Object
    //   88	1	6	localIOException1	java.io.IOException
    //   91	10	6	localObject2	Object
    //   107	1	6	localIOException2	java.io.IOException
    //   111	13	6	localObject3	Object
    //   126	12	6	localIOException3	java.io.IOException
    //   143	1	6	localObject4	Object
    //   48	71	7	localObject5	Object
    //   130	1	7	localIOException4	java.io.IOException
    //   139	1	7	localIOException5	java.io.IOException
    //   148	1	7	localIOException6	java.io.IOException
    //   135	7	8	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   50	63	88	java/io/IOException
    //   100	105	107	java/io/IOException
    //   50	63	111	finally
    //   81	86	126	java/io/IOException
    //   118	123	130	java/io/IOException
    //   63	70	135	finally
    //   63	70	148	java/io/IOException
  }
  
  protected final long a()
  {
    return 2000L;
  }
  
  protected final void b()
  {
    try
    {
      Object localObject = this.f.e();
      if (((ArrayList)localObject).isEmpty())
      {
        if (h())
        {
          this.g.e();
          this.f.d();
          this.f = this.g.c();
        }
      }
      else
      {
        this.f.b();
        this.f.a();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          this.e.a(str);
        }
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  protected final long c()
  {
    return 2000L;
  }
  
  public final void d()
  {
    if (this.h) {
      return;
    }
    this.f = this.g.b();
    this.d = a.b().a(this);
    this.h = true;
  }
  
  public final void e()
  {
    if (!this.h) {
      return;
    }
    this.h = false;
    this.d.b();
    this.f.d();
  }
  
  public final String f()
  {
    return this.g.a();
  }
  
  static final class a
  {
    private static int a = 2000;
    private final File b;
    private final int c;
    private RandomAccessFile d;
    private long e;
    private int f;
    
    public a(String paramString, int paramInt)
    {
      this.b = new File(paramString);
      this.c = paramInt;
      this.f = 0;
      this.e = 0L;
      this.d = null;
    }
    
    private RandomAccessFile f()
    {
      try
      {
        RandomAccessFile localRandomAccessFile = new RandomAccessFile(this.b, "r");
        return localRandomAccessFile;
      }
      catch (Exception localException)
      {
        f.g();
        this.b.getAbsolutePath();
      }
      return null;
    }
    
    private boolean g()
    {
      if (this.d == null) {
        this.d = f();
      }
      return this.d != null;
    }
    
    public final int a()
    {
      return this.f;
    }
    
    public final int b()
    {
      return this.c;
    }
    
    public final boolean c()
    {
      return this.b.delete();
    }
    
    /* Error */
    public final void d()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 37	com/mato/sdk/c/a/f$a:d	Ljava/io/RandomAccessFile;
      //   6: astore_1
      //   7: aload_1
      //   8: ifnonnull +6 -> 14
      //   11: aload_0
      //   12: monitorexit
      //   13: return
      //   14: aload_0
      //   15: getfield 37	com/mato/sdk/c/a/f$a:d	Ljava/io/RandomAccessFile;
      //   18: invokevirtual 67	java/io/RandomAccessFile:close	()V
      //   21: aload_0
      //   22: aconst_null
      //   23: putfield 37	com/mato/sdk/c/a/f$a:d	Ljava/io/RandomAccessFile;
      //   26: goto -15 -> 11
      //   29: astore_1
      //   30: aload_0
      //   31: monitorexit
      //   32: aload_1
      //   33: athrow
      //   34: astore_1
      //   35: aload_0
      //   36: aconst_null
      //   37: putfield 37	com/mato/sdk/c/a/f$a:d	Ljava/io/RandomAccessFile;
      //   40: goto -29 -> 11
      //   43: astore_1
      //   44: aload_0
      //   45: aconst_null
      //   46: putfield 37	com/mato/sdk/c/a/f$a:d	Ljava/io/RandomAccessFile;
      //   49: aload_1
      //   50: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	51	0	this	a
      //   6	2	1	localRandomAccessFile	RandomAccessFile
      //   29	4	1	localObject1	Object
      //   34	1	1	localIOException	java.io.IOException
      //   43	7	1	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   2	7	29	finally
      //   21	26	29	finally
      //   35	40	29	finally
      //   44	51	29	finally
      //   14	21	34	java/io/IOException
      //   14	21	43	finally
    }
    
    /* Error */
    public final ArrayList<String> e()
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_2
      //   2: aload_0
      //   3: monitorenter
      //   4: new 72	java/util/ArrayList
      //   7: dup
      //   8: bipush 10
      //   10: invokespecial 75	java/util/ArrayList:<init>	(I)V
      //   13: astore 5
      //   15: aload_0
      //   16: getfield 37	com/mato/sdk/c/a/f$a:d	Ljava/io/RandomAccessFile;
      //   19: ifnonnull +11 -> 30
      //   22: aload_0
      //   23: aload_0
      //   24: invokespecial 58	com/mato/sdk/c/a/f$a:f	()Ljava/io/RandomAccessFile;
      //   27: putfield 37	com/mato/sdk/c/a/f$a:d	Ljava/io/RandomAccessFile;
      //   30: aload_0
      //   31: getfield 37	com/mato/sdk/c/a/f$a:d	Ljava/io/RandomAccessFile;
      //   34: ifnull +18 -> 52
      //   37: iconst_1
      //   38: istore_1
      //   39: iload_1
      //   40: ifne +17 -> 57
      //   43: invokestatic 52	com/mato/sdk/c/a/f:g	()Ljava/lang/String;
      //   46: pop
      //   47: aload_0
      //   48: monitorexit
      //   49: aload 5
      //   51: areturn
      //   52: iconst_0
      //   53: istore_1
      //   54: goto -15 -> 39
      //   57: aload_0
      //   58: getfield 37	com/mato/sdk/c/a/f$a:d	Ljava/io/RandomAccessFile;
      //   61: aload_0
      //   62: getfield 35	com/mato/sdk/c/a/f$a:e	J
      //   65: invokevirtual 79	java/io/RandomAccessFile:seek	(J)V
      //   68: iload_2
      //   69: istore_1
      //   70: iload_1
      //   71: bipush 10
      //   73: if_icmpge -26 -> 47
      //   76: aload_0
      //   77: getfield 37	com/mato/sdk/c/a/f$a:d	Ljava/io/RandomAccessFile;
      //   80: invokevirtual 82	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
      //   83: astore 6
      //   85: aload 6
      //   87: ifnull -40 -> 47
      //   90: aload 5
      //   92: aload 6
      //   94: invokevirtual 86	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   97: pop
      //   98: aload_0
      //   99: getfield 35	com/mato/sdk/c/a/f$a:e	J
      //   102: lstore_3
      //   103: aload_0
      //   104: aload 6
      //   106: invokevirtual 91	java/lang/String:length	()I
      //   109: iconst_1
      //   110: iadd
      //   111: i2l
      //   112: lload_3
      //   113: ladd
      //   114: putfield 35	com/mato/sdk/c/a/f$a:e	J
      //   117: iload_1
      //   118: iconst_1
      //   119: iadd
      //   120: istore_1
      //   121: aload_0
      //   122: aload_0
      //   123: getfield 33	com/mato/sdk/c/a/f$a:f	I
      //   126: iconst_1
      //   127: iadd
      //   128: putfield 33	com/mato/sdk/c/a/f$a:f	I
      //   131: goto -61 -> 70
      //   134: astore 6
      //   136: invokestatic 52	com/mato/sdk/c/a/f:g	()Ljava/lang/String;
      //   139: pop
      //   140: goto -93 -> 47
      //   143: astore 5
      //   145: aload_0
      //   146: monitorexit
      //   147: aload 5
      //   149: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	150	0	this	a
      //   38	83	1	i	int
      //   1	68	2	j	int
      //   102	11	3	l	long
      //   13	78	5	localArrayList	ArrayList
      //   143	5	5	localObject	Object
      //   83	22	6	str	String
      //   134	1	6	localThrowable	Throwable
      // Exception table:
      //   from	to	target	type
      //   57	68	134	java/lang/Throwable
      //   76	85	134	java/lang/Throwable
      //   90	117	134	java/lang/Throwable
      //   121	131	134	java/lang/Throwable
      //   4	30	143	finally
      //   30	37	143	finally
      //   43	47	143	finally
      //   57	68	143	finally
      //   76	85	143	finally
      //   90	117	143	finally
      //   121	131	143	finally
      //   136	140	143	finally
    }
  }
  
  static final class b
  {
    private final String a;
    private int b;
    private final SparseArray<f.a> c;
    
    public b(String paramString)
    {
      this.a = paramString;
      this.c = new SparseArray();
    }
    
    public final String a()
    {
      return this.a;
    }
    
    public final f.a b()
    {
      this.b = 0;
      this.c.append(this.b, new f.a(this.a, this.b));
      return (f.a)this.c.get(this.b);
    }
    
    public final f.a c()
    {
      String str = d();
      this.b += 1;
      this.c.append(this.b, new f.a(str, this.b));
      return (f.a)this.c.get(this.b);
    }
    
    public final String d()
    {
      return this.a + "_" + (this.b + 1);
    }
    
    public final boolean e()
    {
      int i = this.b - 1;
      if (i > 0)
      {
        boolean bool = ((f.a)this.c.get(i)).c();
        this.c.delete(i);
        return bool;
      }
      return false;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/c/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */