package com.c.a;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
  implements Closeable
{
  static final Pattern a = Pattern.compile("[a-z0-9_-]{1,64}");
  private static final OutputStream p = new OutputStream()
  {
    public void write(int paramAnonymousInt)
      throws IOException
    {}
  };
  final ThreadPoolExecutor b = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
  private final File c;
  private final File d;
  private final File e;
  private final File f;
  private final int g;
  private long h;
  private final int i;
  private long j = 0L;
  private Writer k;
  private final LinkedHashMap<String, b> l = new LinkedHashMap(0, 0.75F, true);
  private int m;
  private long n = 0L;
  private final Callable<Void> o = new Callable()
  {
    public Void call()
      throws Exception
    {
      synchronized (a.this)
      {
        if (a.a(a.this) == null) {
          return null;
        }
        a.b(a.this);
        if (a.c(a.this))
        {
          a.d(a.this);
          a.a(a.this, 0);
        }
        return null;
      }
    }
  };
  
  private a(File paramFile, int paramInt1, int paramInt2, long paramLong)
  {
    this.c = paramFile;
    this.g = paramInt1;
    this.d = new File(paramFile, "journal");
    this.e = new File(paramFile, "journal.tmp");
    this.f = new File(paramFile, "journal.bkp");
    this.i = paramInt2;
    this.h = paramLong;
  }
  
  private a a(String paramString, long paramLong)
    throws IOException
  {
    for (;;)
    {
      a locala;
      try
      {
        f();
        b(paramString);
        b localb = (b)this.l.get(paramString);
        if (paramLong != -1L) {
          if (localb != null)
          {
            long l1 = b.e(localb);
            if (l1 == paramLong) {}
          }
          else
          {
            paramString = null;
            return paramString;
          }
        }
        if (localb == null)
        {
          localb = new b(paramString, null);
          this.l.put(paramString, localb);
          locala = new a(localb, null);
          b.a(localb, locala);
          this.k.write("DIRTY " + paramString + '\n');
          this.k.flush();
          paramString = locala;
          continue;
        }
        locala = b.a(localb);
      }
      finally {}
      if (locala != null) {
        paramString = null;
      }
    }
  }
  
  private void a(a parama, boolean paramBoolean)
    throws IOException
  {
    int i3 = 0;
    b localb;
    try
    {
      localb = a.a(parama);
      if (b.a(localb) != parama) {
        throw new IllegalStateException();
      }
    }
    finally {}
    int i2 = i3;
    if (paramBoolean)
    {
      i2 = i3;
      if (!b.d(localb))
      {
        int i1 = 0;
        for (;;)
        {
          i2 = i3;
          if (i1 >= this.i) {
            break;
          }
          if (a.b(parama)[i1] == 0)
          {
            parama.abort();
            throw new IllegalStateException("Newly created entry didn't create value for index " + i1);
          }
          if (!localb.getDirtyFile(i1).exists())
          {
            parama.abort();
            return;
          }
          i1 += 1;
        }
      }
    }
    for (;;)
    {
      long l1;
      if (i2 < this.i)
      {
        parama = localb.getDirtyFile(i2);
        if (paramBoolean)
        {
          if (parama.exists())
          {
            File localFile = localb.getCleanFile(i2);
            parama.renameTo(localFile);
            l1 = b.b(localb)[i2];
            long l2 = localFile.length();
            b.b(localb)[i2] = l2;
            this.j = (this.j - l1 + l2);
          }
        }
        else {
          a(parama);
        }
      }
      else
      {
        this.m += 1;
        b.a(localb, null);
        if ((b.d(localb) | paramBoolean))
        {
          b.a(localb, true);
          this.k.write("CLEAN " + b.c(localb) + localb.getLengths() + '\n');
          if (paramBoolean)
          {
            l1 = this.n;
            this.n = (1L + l1);
            b.a(localb, l1);
          }
        }
        for (;;)
        {
          this.k.flush();
          if ((this.j <= this.h) && (!e())) {
            break;
          }
          this.b.submit(this.o);
          break;
          this.l.remove(b.c(localb));
          this.k.write("REMOVE " + b.c(localb) + '\n');
        }
      }
      i2 += 1;
    }
  }
  
  private static void a(File paramFile)
    throws IOException
  {
    if ((paramFile.exists()) && (!paramFile.delete())) {
      throw new IOException();
    }
  }
  
  private static void a(File paramFile1, File paramFile2, boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean) {
      a(paramFile2);
    }
    if (!paramFile1.renameTo(paramFile2)) {
      throw new IOException();
    }
  }
  
  private void a(String paramString)
    throws IOException
  {
    int i1 = paramString.indexOf(' ');
    if (i1 == -1) {
      throw new IOException("unexpected journal line: " + paramString);
    }
    int i2 = i1 + 1;
    int i3 = paramString.indexOf(' ', i2);
    String str;
    if (i3 == -1)
    {
      str = paramString.substring(i2);
      if ((i1 == "REMOVE".length()) && (paramString.startsWith("REMOVE"))) {
        this.l.remove(str);
      }
    }
    else
    {
      str = paramString.substring(i2, i3);
    }
    for (;;)
    {
      b localb2 = (b)this.l.get(str);
      b localb1 = localb2;
      if (localb2 == null)
      {
        localb1 = new b(str, null);
        this.l.put(str, localb1);
      }
      if ((i3 != -1) && (i1 == "CLEAN".length()) && (paramString.startsWith("CLEAN")))
      {
        paramString = paramString.substring(i3 + 1).split(" ");
        b.a(localb1, true);
        b.a(localb1, null);
        b.a(localb1, paramString);
        return;
      }
      if ((i3 == -1) && (i1 == "DIRTY".length()) && (paramString.startsWith("DIRTY")))
      {
        b.a(localb1, new a(localb1, null));
        return;
      }
      if ((i3 == -1) && (i1 == "READ".length()) && (paramString.startsWith("READ"))) {
        break;
      }
      throw new IOException("unexpected journal line: " + paramString);
    }
  }
  
  private static String b(InputStream paramInputStream)
    throws IOException
  {
    return c.a(new InputStreamReader(paramInputStream, c.b));
  }
  
  private void b()
    throws IOException
  {
    b localb = new b(new FileInputStream(this.d), c.a);
    int i1;
    try
    {
      String str1 = localb.readLine();
      String str2 = localb.readLine();
      String str3 = localb.readLine();
      String str4 = localb.readLine();
      String str5 = localb.readLine();
      if ((!"libcore.io.DiskLruCache".equals(str1)) || (!"1".equals(str2)) || (!Integer.toString(this.g).equals(str3)) || (!Integer.toString(this.i).equals(str4)) || (!"".equals(str5))) {
        throw new IOException("unexpected journal header: [" + str1 + ", " + str2 + ", " + str4 + ", " + str5 + "]");
      }
    }
    finally
    {
      c.a(localb);
      throw ((Throwable)localObject);
    }
  }
  
  private void b(String paramString)
  {
    if (!a.matcher(paramString).matches()) {
      throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + paramString + "\"");
    }
  }
  
  private void c()
    throws IOException
  {
    a(this.e);
    Iterator localIterator = this.l.values().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      int i1;
      if (b.a(localb) == null)
      {
        i1 = 0;
        while (i1 < this.i)
        {
          this.j += b.b(localb)[i1];
          i1 += 1;
        }
      }
      else
      {
        b.a(localb, null);
        i1 = 0;
        while (i1 < this.i)
        {
          a(localb.getCleanFile(i1));
          a(localb.getDirtyFile(i1));
          i1 += 1;
        }
        localIterator.remove();
      }
    }
  }
  
  private void d()
    throws IOException
  {
    for (;;)
    {
      try
      {
        if (this.k != null) {
          this.k.close();
        }
        BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.e), c.a));
        b localb;
        try
        {
          localBufferedWriter.write("libcore.io.DiskLruCache");
          localBufferedWriter.write("\n");
          localBufferedWriter.write("1");
          localBufferedWriter.write("\n");
          localBufferedWriter.write(Integer.toString(this.g));
          localBufferedWriter.write("\n");
          localBufferedWriter.write(Integer.toString(this.i));
          localBufferedWriter.write("\n");
          localBufferedWriter.write("\n");
          Iterator localIterator = this.l.values().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          localb = (b)localIterator.next();
          if (b.a(localb) != null)
          {
            localBufferedWriter.write("DIRTY " + b.c(localb) + '\n');
            continue;
            localObject1 = finally;
          }
        }
        finally
        {
          localBufferedWriter.close();
        }
        ((Writer)localObject1).write("CLEAN " + b.c(localb) + localb.getLengths() + '\n');
      }
      finally {}
    }
    ((Writer)localObject1).close();
    if (this.d.exists()) {
      a(this.d, this.f, true);
    }
    a(this.e, this.d, false);
    this.f.delete();
    this.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.d, true), c.a));
  }
  
  private boolean e()
  {
    return (this.m >= 2000) && (this.m >= this.l.size());
  }
  
  private void f()
  {
    if (this.k == null) {
      throw new IllegalStateException("cache is closed");
    }
  }
  
  private void g()
    throws IOException
  {
    while (this.j > this.h) {
      remove((String)((Map.Entry)this.l.entrySet().iterator().next()).getKey());
    }
  }
  
  public static a open(File paramFile, int paramInt1, int paramInt2, long paramLong)
    throws IOException
  {
    if (paramLong <= 0L) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    if (paramInt2 <= 0) {
      throw new IllegalArgumentException("valueCount <= 0");
    }
    Object localObject = new File(paramFile, "journal.bkp");
    File localFile;
    if (((File)localObject).exists())
    {
      localFile = new File(paramFile, "journal");
      if (!localFile.exists()) {
        break label150;
      }
      ((File)localObject).delete();
    }
    for (;;)
    {
      localObject = new a(paramFile, paramInt1, paramInt2, paramLong);
      if (!((a)localObject).d.exists()) {
        break label214;
      }
      try
      {
        ((a)localObject).b();
        ((a)localObject).c();
        ((a)localObject).k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(((a)localObject).d, true), c.a));
        return (a)localObject;
      }
      catch (IOException localIOException)
      {
        label150:
        System.out.println("DiskLruCache " + paramFile + " is corrupt: " + localIOException.getMessage() + ", removing");
        ((a)localObject).delete();
      }
      a((File)localObject, localFile, false);
    }
    label214:
    paramFile.mkdirs();
    paramFile = new a(paramFile, paramInt1, paramInt2, paramLong);
    paramFile.d();
    return paramFile;
  }
  
  public void close()
    throws IOException
  {
    for (;;)
    {
      try
      {
        Object localObject1 = this.k;
        if (localObject1 == null) {
          return;
        }
        localObject1 = new ArrayList(this.l.values()).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          b localb = (b)((Iterator)localObject1).next();
          if (b.a(localb) == null) {
            continue;
          }
          b.a(localb).abort();
          continue;
        }
        g();
      }
      finally {}
      this.k.close();
      this.k = null;
    }
  }
  
  public void delete()
    throws IOException
  {
    close();
    c.a(this.c);
  }
  
  public a edit(String paramString)
    throws IOException
  {
    return a(paramString, -1L);
  }
  
  public void flush()
    throws IOException
  {
    try
    {
      f();
      g();
      this.k.flush();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public c get(String paramString)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: invokespecial 137	com/c/a/a:f	()V
    //   9: aload_0
    //   10: aload_1
    //   11: invokespecial 140	com/c/a/a:b	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 75	com/c/a/a:l	Ljava/util/LinkedHashMap;
    //   18: aload_1
    //   19: invokevirtual 144	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   22: checkcast 17	com/c/a/a$b
    //   25: astore 6
    //   27: aload 6
    //   29: ifnonnull +10 -> 39
    //   32: aload 4
    //   34: astore_3
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_3
    //   38: areturn
    //   39: aload 4
    //   41: astore_3
    //   42: aload 6
    //   44: invokestatic 206	com/c/a/a$b:d	(Lcom/c/a/a$b;)Z
    //   47: ifeq -12 -> 35
    //   50: aload_0
    //   51: getfield 123	com/c/a/a:i	I
    //   54: anewarray 513	java/io/InputStream
    //   57: astore 5
    //   59: iconst_0
    //   60: istore_2
    //   61: iload_2
    //   62: aload_0
    //   63: getfield 123	com/c/a/a:i	I
    //   66: if_icmpge +65 -> 131
    //   69: aload 5
    //   71: iload_2
    //   72: new 339	java/io/FileInputStream
    //   75: dup
    //   76: aload 6
    //   78: iload_2
    //   79: invokevirtual 230	com/c/a/a$b:getCleanFile	(I)Ljava/io/File;
    //   82: invokespecial 341	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   85: aastore
    //   86: iload_2
    //   87: iconst_1
    //   88: iadd
    //   89: istore_2
    //   90: goto -29 -> 61
    //   93: astore_1
    //   94: iconst_0
    //   95: istore_2
    //   96: aload 4
    //   98: astore_3
    //   99: iload_2
    //   100: aload_0
    //   101: getfield 123	com/c/a/a:i	I
    //   104: if_icmpge -69 -> 35
    //   107: aload 4
    //   109: astore_3
    //   110: aload 5
    //   112: iload_2
    //   113: aaload
    //   114: ifnull -79 -> 35
    //   117: aload 5
    //   119: iload_2
    //   120: aaload
    //   121: invokestatic 370	com/c/a/c:a	(Ljava/io/Closeable;)V
    //   124: iload_2
    //   125: iconst_1
    //   126: iadd
    //   127: istore_2
    //   128: goto -32 -> 96
    //   131: aload_0
    //   132: aload_0
    //   133: getfield 128	com/c/a/a:m	I
    //   136: iconst_1
    //   137: iadd
    //   138: putfield 128	com/c/a/a:m	I
    //   141: aload_0
    //   142: getfield 164	com/c/a/a:k	Ljava/io/Writer;
    //   145: new 166	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   152: ldc_w 515
    //   155: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_1
    //   159: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: bipush 10
    //   164: invokevirtual 176	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   167: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokevirtual 518	java/io/Writer:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   173: pop
    //   174: aload_0
    //   175: invokespecial 260	com/c/a/a:e	()Z
    //   178: ifeq +15 -> 193
    //   181: aload_0
    //   182: getfield 95	com/c/a/a:b	Ljava/util/concurrent/ThreadPoolExecutor;
    //   185: aload_0
    //   186: getfield 100	com/c/a/a:o	Ljava/util/concurrent/Callable;
    //   189: invokevirtual 264	java/util/concurrent/ThreadPoolExecutor:submit	(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    //   192: pop
    //   193: new 20	com/c/a/a$c
    //   196: dup
    //   197: aload_0
    //   198: aload_1
    //   199: aload 6
    //   201: invokestatic 149	com/c/a/a$b:e	(Lcom/c/a/a$b;)J
    //   204: aload 5
    //   206: aload 6
    //   208: invokestatic 237	com/c/a/a$b:b	(Lcom/c/a/a$b;)[J
    //   211: aconst_null
    //   212: invokespecial 521	com/c/a/a$c:<init>	(Lcom/c/a/a;Ljava/lang/String;J[Ljava/io/InputStream;[JLcom/c/a/a$1;)V
    //   215: astore_3
    //   216: goto -181 -> 35
    //   219: astore_1
    //   220: aload_0
    //   221: monitorexit
    //   222: aload_1
    //   223: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	a
    //   0	224	1	paramString	String
    //   60	68	2	i1	int
    //   34	182	3	localObject1	Object
    //   1	107	4	localObject2	Object
    //   57	148	5	arrayOfInputStream	InputStream[]
    //   25	182	6	localb	b
    // Exception table:
    //   from	to	target	type
    //   61	86	93	java/io/FileNotFoundException
    //   5	27	219	finally
    //   42	59	219	finally
    //   61	86	219	finally
    //   99	107	219	finally
    //   117	124	219	finally
    //   131	193	219	finally
    //   193	216	219	finally
  }
  
  public File getDirectory()
  {
    return this.c;
  }
  
  public long getMaxSize()
  {
    try
    {
      long l1 = this.h;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public boolean isClosed()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 164	com/c/a/a:k	Ljava/io/Writer;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +9 -> 17
    //   11: iconst_1
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_1
    //   19: goto -6 -> 13
    //   22: astore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	a
    //   12	7	1	bool	boolean
    //   6	2	2	localWriter	Writer
    //   22	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  public boolean remove(String paramString)
    throws IOException
  {
    int i1 = 0;
    for (;;)
    {
      try
      {
        f();
        b(paramString);
        b localb = (b)this.l.get(paramString);
        Object localObject;
        if (localb != null)
        {
          localObject = b.a(localb);
          if (localObject == null) {}
        }
        else
        {
          bool = false;
          return bool;
          this.j -= b.b(localb)[i1];
          b.b(localb)[i1] = 0L;
          i1 += 1;
        }
        if (i1 < this.i)
        {
          localObject = localb.getCleanFile(i1);
          if ((!((File)localObject).exists()) || (((File)localObject).delete())) {
            continue;
          }
          throw new IOException("failed to delete " + localObject);
        }
      }
      finally {}
      this.m += 1;
      this.k.append("REMOVE " + paramString + '\n');
      this.l.remove(paramString);
      if (e()) {
        this.b.submit(this.o);
      }
      boolean bool = true;
    }
  }
  
  public void setMaxSize(long paramLong)
  {
    try
    {
      this.h = paramLong;
      this.b.submit(this.o);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long size()
  {
    try
    {
      long l1 = this.j;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final class a
  {
    private final a.b b;
    private final boolean[] c;
    private boolean d;
    private boolean e;
    
    private a(a.b paramb)
    {
      this.b = paramb;
      if (a.b.d(paramb)) {}
      for (this$1 = null;; this$1 = new boolean[a.e(a.this)])
      {
        this.c = a.this;
        return;
      }
    }
    
    public void abort()
      throws IOException
    {
      a.a(a.this, this, false);
    }
    
    public void abortUnlessCommitted()
    {
      if (!this.e) {}
      try
      {
        abort();
        return;
      }
      catch (IOException localIOException) {}
    }
    
    public void commit()
      throws IOException
    {
      if (this.d)
      {
        a.a(a.this, this, false);
        a.this.remove(a.b.c(this.b));
      }
      for (;;)
      {
        this.e = true;
        return;
        a.a(a.this, this, true);
      }
    }
    
    public String getString(int paramInt)
      throws IOException
    {
      InputStream localInputStream = newInputStream(paramInt);
      if (localInputStream != null) {
        return a.a(localInputStream);
      }
      return null;
    }
    
    public InputStream newInputStream(int paramInt)
      throws IOException
    {
      synchronized (a.this)
      {
        if (a.b.a(this.b) != this) {
          throw new IllegalStateException();
        }
      }
      if (!a.b.d(this.b)) {
        return null;
      }
      try
      {
        FileInputStream localFileInputStream = new FileInputStream(this.b.getCleanFile(paramInt));
        return localFileInputStream;
      }
      catch (FileNotFoundException localFileNotFoundException) {}
      return null;
    }
    
    public OutputStream newOutputStream(int paramInt)
      throws IOException
    {
      synchronized (a.this)
      {
        if (a.b.a(this.b) != this) {
          throw new IllegalStateException();
        }
      }
      if (!a.b.d(this.b)) {
        this.c[paramInt] = true;
      }
      File localFile = this.b.getDirtyFile(paramInt);
      try
      {
        Object localObject2 = new FileOutputStream(localFile);
        localObject2 = new a((OutputStream)localObject2, null);
        return (OutputStream)localObject2;
      }
      catch (FileNotFoundException localFileNotFoundException1)
      {
        for (;;)
        {
          a.f(a.this).mkdirs();
          try
          {
            FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
          }
          catch (FileNotFoundException localFileNotFoundException2)
          {
            OutputStream localOutputStream = a.a();
            return localOutputStream;
          }
        }
      }
    }
    
    public void set(int paramInt, String paramString)
      throws IOException
    {
      try
      {
        OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(newOutputStream(paramInt), c.b);
        c.a(localOutputStreamWriter);
      }
      finally
      {
        try
        {
          localOutputStreamWriter.write(paramString);
          c.a(localOutputStreamWriter);
          return;
        }
        finally {}
        paramString = finally;
        localOutputStreamWriter = null;
      }
      throw paramString;
    }
    
    private class a
      extends FilterOutputStream
    {
      private a(OutputStream paramOutputStream)
      {
        super();
      }
      
      public void close()
      {
        try
        {
          this.out.close();
          return;
        }
        catch (IOException localIOException)
        {
          a.a.a(a.a.this, true);
        }
      }
      
      public void flush()
      {
        try
        {
          this.out.flush();
          return;
        }
        catch (IOException localIOException)
        {
          a.a.a(a.a.this, true);
        }
      }
      
      public void write(int paramInt)
      {
        try
        {
          this.out.write(paramInt);
          return;
        }
        catch (IOException localIOException)
        {
          a.a.a(a.a.this, true);
        }
      }
      
      public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      {
        try
        {
          this.out.write(paramArrayOfByte, paramInt1, paramInt2);
          return;
        }
        catch (IOException paramArrayOfByte)
        {
          a.a.a(a.a.this, true);
        }
      }
    }
  }
  
  private final class b
  {
    private final String b;
    private final long[] c;
    private boolean d;
    private a.a e;
    private long f;
    
    private b(String paramString)
    {
      this.b = paramString;
      this.c = new long[a.e(a.this)];
    }
    
    private void a(String[] paramArrayOfString)
      throws IOException
    {
      if (paramArrayOfString.length != a.e(a.this)) {
        throw b(paramArrayOfString);
      }
      int i = 0;
      try
      {
        while (i < paramArrayOfString.length)
        {
          this.c[i] = Long.parseLong(paramArrayOfString[i]);
          i += 1;
        }
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw b(paramArrayOfString);
      }
    }
    
    private IOException b(String[] paramArrayOfString)
      throws IOException
    {
      throw new IOException("unexpected journal line: " + Arrays.toString(paramArrayOfString));
    }
    
    public File getCleanFile(int paramInt)
    {
      return new File(a.f(a.this), this.b + "." + paramInt);
    }
    
    public File getDirtyFile(int paramInt)
    {
      return new File(a.f(a.this), this.b + "." + paramInt + ".tmp");
    }
    
    public String getLengths()
      throws IOException
    {
      StringBuilder localStringBuilder = new StringBuilder();
      long[] arrayOfLong = this.c;
      int j = arrayOfLong.length;
      int i = 0;
      while (i < j)
      {
        long l = arrayOfLong[i];
        localStringBuilder.append(' ').append(l);
        i += 1;
      }
      return localStringBuilder.toString();
    }
  }
  
  public final class c
    implements Closeable
  {
    private final String b;
    private final long c;
    private final InputStream[] d;
    private final long[] e;
    
    private c(String paramString, long paramLong, InputStream[] paramArrayOfInputStream, long[] paramArrayOfLong)
    {
      this.b = paramString;
      this.c = paramLong;
      this.d = paramArrayOfInputStream;
      this.e = paramArrayOfLong;
    }
    
    public void close()
    {
      InputStream[] arrayOfInputStream = this.d;
      int j = arrayOfInputStream.length;
      int i = 0;
      while (i < j)
      {
        c.a(arrayOfInputStream[i]);
        i += 1;
      }
    }
    
    public a.a edit()
      throws IOException
    {
      return a.a(a.this, this.b, this.c);
    }
    
    public InputStream getInputStream(int paramInt)
    {
      return this.d[paramInt];
    }
    
    public long getLength(int paramInt)
    {
      return this.e[paramInt];
    }
    
    public String getString(int paramInt)
      throws IOException
    {
      return a.a(getInputStream(paramInt));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/c/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */