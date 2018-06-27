package com.superrtc.a;

import android.util.Log;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class e
{
  a a;
  private int[] b = new int[10];
  private int c = 0;
  private int d = 0;
  private long[] e;
  private int f;
  private double g = -1.0D;
  private int h;
  private int i;
  private int j;
  private boolean k = false;
  private String[] l;
  private String[] m;
  
  /* Error */
  private long a(String paramString)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 4
    //   3: lload 4
    //   5: lstore 8
    //   7: lload 4
    //   9: lstore 6
    //   11: new 52	java/io/FileReader
    //   14: dup
    //   15: aload_1
    //   16: invokespecial 55	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   19: astore_1
    //   20: lload 4
    //   22: lstore_2
    //   23: lload 4
    //   25: lstore 6
    //   27: new 57	java/util/Scanner
    //   30: dup
    //   31: new 59	java/io/BufferedReader
    //   34: dup
    //   35: aload_1
    //   36: invokespecial 62	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   39: invokespecial 65	java/util/Scanner:<init>	(Ljava/lang/Readable;)V
    //   42: astore 10
    //   44: lload 4
    //   46: lstore_2
    //   47: lload 4
    //   49: lstore 6
    //   51: aload 10
    //   53: invokevirtual 69	java/util/Scanner:nextLong	()J
    //   56: lstore 4
    //   58: lload 4
    //   60: lstore_2
    //   61: lload 4
    //   63: lstore 6
    //   65: aload 10
    //   67: invokevirtual 72	java/util/Scanner:close	()V
    //   70: lload 4
    //   72: lstore 8
    //   74: lload 4
    //   76: lstore 6
    //   78: aload_1
    //   79: invokevirtual 73	java/io/FileReader:close	()V
    //   82: lload 4
    //   84: lreturn
    //   85: astore 10
    //   87: lload_2
    //   88: lstore 8
    //   90: lload_2
    //   91: lstore 6
    //   93: aload_1
    //   94: invokevirtual 73	java/io/FileReader:close	()V
    //   97: lload_2
    //   98: lreturn
    //   99: astore_1
    //   100: lload 8
    //   102: lreturn
    //   103: astore 10
    //   105: aload_1
    //   106: invokevirtual 73	java/io/FileReader:close	()V
    //   109: aload 10
    //   111: athrow
    //   112: astore_1
    //   113: lload 6
    //   115: lreturn
    //   116: astore_1
    //   117: ldc 75
    //   119: ldc 77
    //   121: invokestatic 82	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   124: pop
    //   125: lload 6
    //   127: lreturn
    //   128: astore_1
    //   129: goto -12 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	e
    //   0	132	1	paramString	String
    //   22	76	2	l1	long
    //   1	82	4	l2	long
    //   9	117	6	l3	long
    //   5	96	8	l4	long
    //   42	24	10	localScanner	Scanner
    //   85	1	10	localException	Exception
    //   103	7	10	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   27	44	85	java/lang/Exception
    //   51	58	85	java/lang/Exception
    //   65	70	85	java/lang/Exception
    //   11	20	99	java/io/FileNotFoundException
    //   78	82	99	java/io/FileNotFoundException
    //   93	97	99	java/io/FileNotFoundException
    //   27	44	103	finally
    //   51	58	103	finally
    //   65	70	103	finally
    //   105	112	112	java/io/FileNotFoundException
    //   11	20	116	java/io/IOException
    //   78	82	116	java/io/IOException
    //   93	97	116	java/io/IOException
    //   105	112	128	java/io/IOException
  }
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: new 52	java/io/FileReader
    //   3: dup
    //   4: ldc 84
    //   6: invokespecial 55	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   9: astore_2
    //   10: new 57	java/util/Scanner
    //   13: dup
    //   14: new 59	java/io/BufferedReader
    //   17: dup
    //   18: aload_2
    //   19: invokespecial 62	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   22: invokespecial 65	java/util/Scanner:<init>	(Ljava/lang/Readable;)V
    //   25: ldc 86
    //   27: invokevirtual 90	java/util/Scanner:useDelimiter	(Ljava/lang/String;)Ljava/util/Scanner;
    //   30: astore_3
    //   31: aload_3
    //   32: invokevirtual 94	java/util/Scanner:nextInt	()I
    //   35: pop
    //   36: aload_0
    //   37: aload_3
    //   38: invokevirtual 94	java/util/Scanner:nextInt	()I
    //   41: iconst_1
    //   42: iadd
    //   43: putfield 96	com/superrtc/a/e:f	I
    //   46: aload_3
    //   47: invokevirtual 72	java/util/Scanner:close	()V
    //   50: aload_2
    //   51: invokevirtual 73	java/io/FileReader:close	()V
    //   54: aload_0
    //   55: aload_0
    //   56: getfield 96	com/superrtc/a/e:f	I
    //   59: newarray <illegal type>
    //   61: putfield 98	com/superrtc/a/e:e	[J
    //   64: aload_0
    //   65: aload_0
    //   66: getfield 96	com/superrtc/a/e:f	I
    //   69: anewarray 100	java/lang/String
    //   72: putfield 102	com/superrtc/a/e:l	[Ljava/lang/String;
    //   75: aload_0
    //   76: aload_0
    //   77: getfield 96	com/superrtc/a/e:f	I
    //   80: anewarray 100	java/lang/String
    //   83: putfield 104	com/superrtc/a/e:m	[Ljava/lang/String;
    //   86: iconst_0
    //   87: istore_1
    //   88: iload_1
    //   89: aload_0
    //   90: getfield 96	com/superrtc/a/e:f	I
    //   93: if_icmpge +124 -> 217
    //   96: aload_0
    //   97: getfield 98	com/superrtc/a/e:e	[J
    //   100: iload_1
    //   101: lconst_0
    //   102: lastore
    //   103: aload_0
    //   104: getfield 102	com/superrtc/a/e:l	[Ljava/lang/String;
    //   107: iload_1
    //   108: new 106	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   115: ldc 109
    //   117: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: iload_1
    //   121: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   124: ldc 118
    //   126: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: aastore
    //   133: aload_0
    //   134: getfield 104	com/superrtc/a/e:m	[Ljava/lang/String;
    //   137: iload_1
    //   138: new 106	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   145: ldc 109
    //   147: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: iload_1
    //   151: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   154: ldc 124
    //   156: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: aastore
    //   163: iload_1
    //   164: iconst_1
    //   165: iadd
    //   166: istore_1
    //   167: goto -79 -> 88
    //   170: astore_3
    //   171: ldc 75
    //   173: ldc 126
    //   175: invokestatic 82	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   178: pop
    //   179: aload_2
    //   180: invokevirtual 73	java/io/FileReader:close	()V
    //   183: goto -129 -> 54
    //   186: astore_2
    //   187: ldc 75
    //   189: ldc -128
    //   191: invokestatic 82	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   194: pop
    //   195: goto -141 -> 54
    //   198: astore_3
    //   199: aload_2
    //   200: invokevirtual 73	java/io/FileReader:close	()V
    //   203: aload_3
    //   204: athrow
    //   205: astore_2
    //   206: ldc 75
    //   208: ldc 77
    //   210: invokestatic 82	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   213: pop
    //   214: goto -160 -> 54
    //   217: aload_0
    //   218: new 6	com/superrtc/a/e$a
    //   221: dup
    //   222: aload_0
    //   223: lconst_0
    //   224: lconst_0
    //   225: invokespecial 131	com/superrtc/a/e$a:<init>	(Lcom/superrtc/a/e;JJ)V
    //   228: putfield 133	com/superrtc/a/e:a	Lcom/superrtc/a/e$a;
    //   231: aload_0
    //   232: iconst_1
    //   233: putfield 42	com/superrtc/a/e:k	Z
    //   236: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	this	e
    //   87	80	1	n	int
    //   9	171	2	localFileReader	FileReader
    //   186	14	2	localFileNotFoundException	FileNotFoundException
    //   205	1	2	localIOException	IOException
    //   30	17	3	localScanner	Scanner
    //   170	1	3	localException	Exception
    //   198	6	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   10	50	170	java/lang/Exception
    //   0	10	186	java/io/FileNotFoundException
    //   50	54	186	java/io/FileNotFoundException
    //   179	183	186	java/io/FileNotFoundException
    //   199	205	186	java/io/FileNotFoundException
    //   10	50	198	finally
    //   171	179	198	finally
    //   0	10	205	java/io/IOException
    //   50	54	205	java/io/IOException
    //   179	183	205	java/io/IOException
    //   199	205	205	java/io/IOException
  }
  
  private a b()
  {
    try
    {
      FileReader localFileReader = new FileReader("/proc/stat");
      Scanner localScanner;
      long l1;
      long l2;
      long l3;
      long l4;
      return null;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      try
      {
        localScanner = new Scanner(new BufferedReader(localFileReader));
        localScanner.next();
        l1 = localScanner.nextLong();
        l2 = localScanner.nextLong();
        l3 = localScanner.nextLong();
        l4 = localScanner.nextLong();
        localScanner.close();
        return new a(l1 + l2 + l3, l4);
      }
      catch (Exception localException)
      {
        Log.e("CpuMonitor", "Problems parsing /proc/stat");
        return null;
        localFileNotFoundException = localFileNotFoundException;
        Log.e("CpuMonitor", "Cannot open /proc/stat for reading");
        return null;
      }
      finally
      {
        localFileNotFoundException.close();
      }
    }
    catch (IOException localIOException)
    {
      Log.e("CpuMonitor", "Problems reading /proc/stat");
    }
  }
  
  public int getCpuAvg3()
  {
    return this.i;
  }
  
  public int getCpuAvgAll()
  {
    return this.j;
  }
  
  public int getCpuCurrent()
  {
    return this.h;
  }
  
  public boolean sampleCpuUtilization()
  {
    if (!this.k) {
      a();
    }
    int n = 0;
    long l2 = 0L;
    long l3 = 0L;
    long l1 = 0L;
    if (n < this.f)
    {
      long l4;
      if (this.e[n] == 0L)
      {
        l4 = a(this.l[n]);
        if (l4 > 0L)
        {
          this.e[n] = l4;
          this.l[n] = null;
        }
      }
      for (l1 = l4;; l1 = this.e[n])
      {
        l3 += a(this.m[n]);
        l2 += l1;
        n += 1;
        break;
      }
    }
    if (l2 == 0L) {
      Log.e("CpuMonitor", "Could not read max frequency for any CPU");
    }
    double d2;
    double d1;
    a locala;
    do
    {
      return false;
      d2 = l3 * 100.0D / l2;
      if (this.g <= 0.0D) {
        break;
      }
      d1 = (this.g + d2) * 0.5D;
      this.g = d2;
      locala = b();
    } while (locala == null);
    l1 = locala.a - this.a.a;
    l2 = locala.b;
    l3 = this.a.b;
    this.a = locala;
    l2 = l2 - l3 + l1;
    if (l2 == 0L) {}
    int i1;
    for (n = 0;; n = (int)Math.round(d1 * l1 / l2))
    {
      i1 = Math.max(0, Math.min(n, 100));
      this.c += i1 - this.b[2];
      this.d += i1 - this.b[9];
      n = 9;
      while (n > 0)
      {
        this.b[n] = this.b[(n - 1)];
        n -= 1;
      }
      d1 = d2;
      break;
    }
    this.b[0] = i1;
    this.h = i1;
    this.i = (this.c / 3);
    this.j = (this.d / 10);
    return true;
  }
  
  private class a
  {
    final long a;
    final long b;
    
    a(long paramLong1, long paramLong2)
    {
      this.a = paramLong1;
      this.b = paramLong2;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */