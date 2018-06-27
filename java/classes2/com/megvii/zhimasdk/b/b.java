package com.megvii.zhimasdk.b;

import com.megvii.zhimasdk.b.a.b.c.c;
import com.megvii.zhimasdk.b.a.b.c.j;
import com.megvii.zhimasdk.b.a.n.e;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.concurrent.atomic.AtomicBoolean;

public class b
  implements Runnable
{
  private final com.megvii.zhimasdk.b.a.i.b.a a;
  private final e b;
  private final j c;
  private final r d;
  private final AtomicBoolean e = new AtomicBoolean();
  private int f;
  private boolean g;
  private volatile boolean h;
  private boolean i;
  
  public b(com.megvii.zhimasdk.b.a.i.b.a parama, e parame, j paramj, r paramr)
  {
    this.a = ((com.megvii.zhimasdk.b.a.i.b.a)v.a(parama, "client"));
    this.b = ((e)v.a(parame, "context"));
    this.c = ((j)v.a(paramj, "request"));
    this.d = ((r)v.a(paramr, "responseHandler"));
  }
  
  private void c()
  {
    if (a()) {}
    c localc;
    do
    {
      do
      {
        do
        {
          return;
          if (this.c.j().getScheme() == null) {
            throw new MalformedURLException("No valid URI scheme was provided");
          }
          if ((this.d instanceof o)) {
            ((o)this.d).a(this.c);
          }
          localc = this.a.a(this.c, this.b);
        } while (a());
        this.d.a(this.d, localc);
      } while (a());
      this.d.a(localc);
    } while (a());
    this.d.b(this.d, localc);
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	com/megvii/zhimasdk/b/b:a	Lcom/megvii/zhimasdk/b/a/i/b/a;
    //   4: invokevirtual 110	com/megvii/zhimasdk/b/a/i/b/a:z	()Lcom/megvii/zhimasdk/b/a/b/j;
    //   7: astore 6
    //   9: aconst_null
    //   10: astore_3
    //   11: iconst_1
    //   12: istore_2
    //   13: aload_3
    //   14: astore 4
    //   16: iload_2
    //   17: ifeq +314 -> 331
    //   20: aload_0
    //   21: invokespecial 112	com/megvii/zhimasdk/b/b:c	()V
    //   24: return
    //   25: astore 7
    //   27: new 104	java/io/IOException
    //   30: dup
    //   31: new 114	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   38: ldc 117
    //   40: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload 7
    //   45: invokevirtual 124	java/net/UnknownHostException:getMessage	()Ljava/lang/String;
    //   48: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: aload 7
    //   56: invokespecial 130	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   59: astore 5
    //   61: aload 5
    //   63: astore 4
    //   65: aload_0
    //   66: getfield 132	com/megvii/zhimasdk/b/b:f	I
    //   69: ifle +72 -> 141
    //   72: aload 5
    //   74: astore 4
    //   76: aload_0
    //   77: getfield 132	com/megvii/zhimasdk/b/b:f	I
    //   80: iconst_1
    //   81: iadd
    //   82: istore_1
    //   83: aload 5
    //   85: astore 4
    //   87: aload_0
    //   88: iload_1
    //   89: putfield 132	com/megvii/zhimasdk/b/b:f	I
    //   92: aload 5
    //   94: astore 4
    //   96: aload 6
    //   98: aload 7
    //   100: iload_1
    //   101: aload_0
    //   102: getfield 49	com/megvii/zhimasdk/b/b:b	Lcom/megvii/zhimasdk/b/a/n/e;
    //   105: invokeinterface 137 4 0
    //   110: ifeq +31 -> 141
    //   113: iconst_1
    //   114: istore_2
    //   115: aload 5
    //   117: astore_3
    //   118: iload_2
    //   119: ifeq +226 -> 345
    //   122: aload_3
    //   123: astore 4
    //   125: aload_0
    //   126: getfield 61	com/megvii/zhimasdk/b/b:d	Lcom/megvii/zhimasdk/b/r;
    //   129: aload_0
    //   130: getfield 132	com/megvii/zhimasdk/b/b:f	I
    //   133: invokeinterface 140 2 0
    //   138: goto -125 -> 13
    //   141: iconst_0
    //   142: istore_2
    //   143: aload 5
    //   145: astore_3
    //   146: goto -28 -> 118
    //   149: astore 4
    //   151: new 104	java/io/IOException
    //   154: dup
    //   155: new 114	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   162: ldc -114
    //   164: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload 4
    //   169: invokevirtual 143	java/lang/NullPointerException:getMessage	()Ljava/lang/String;
    //   172: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokespecial 144	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   181: astore 5
    //   183: aload 5
    //   185: astore 4
    //   187: aload_0
    //   188: getfield 132	com/megvii/zhimasdk/b/b:f	I
    //   191: iconst_1
    //   192: iadd
    //   193: istore_1
    //   194: aload 5
    //   196: astore 4
    //   198: aload_0
    //   199: iload_1
    //   200: putfield 132	com/megvii/zhimasdk/b/b:f	I
    //   203: aload 5
    //   205: astore 4
    //   207: aload 6
    //   209: aload 5
    //   211: iload_1
    //   212: aload_0
    //   213: getfield 49	com/megvii/zhimasdk/b/b:b	Lcom/megvii/zhimasdk/b/a/n/e;
    //   216: invokeinterface 137 4 0
    //   221: istore_2
    //   222: aload 5
    //   224: astore_3
    //   225: goto -107 -> 118
    //   228: astore 5
    //   230: aload_0
    //   231: invokevirtual 65	com/megvii/zhimasdk/b/b:a	()Z
    //   234: istore_2
    //   235: iload_2
    //   236: ifne -212 -> 24
    //   239: aload 5
    //   241: astore 4
    //   243: aload_0
    //   244: getfield 132	com/megvii/zhimasdk/b/b:f	I
    //   247: iconst_1
    //   248: iadd
    //   249: istore_1
    //   250: aload 5
    //   252: astore 4
    //   254: aload_0
    //   255: iload_1
    //   256: putfield 132	com/megvii/zhimasdk/b/b:f	I
    //   259: aload 5
    //   261: astore 4
    //   263: aload 6
    //   265: aload 5
    //   267: iload_1
    //   268: aload_0
    //   269: getfield 49	com/megvii/zhimasdk/b/b:b	Lcom/megvii/zhimasdk/b/a/n/e;
    //   272: invokeinterface 137 4 0
    //   277: istore_2
    //   278: aload 5
    //   280: astore_3
    //   281: goto -163 -> 118
    //   284: astore_3
    //   285: getstatic 149	com/megvii/zhimasdk/b/a:a	Lcom/megvii/zhimasdk/b/m;
    //   288: ldc -105
    //   290: ldc -103
    //   292: aload_3
    //   293: invokeinterface 158 4 0
    //   298: new 104	java/io/IOException
    //   301: dup
    //   302: new 114	java/lang/StringBuilder
    //   305: dup
    //   306: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   309: ldc -96
    //   311: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: aload_3
    //   315: invokevirtual 161	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   318: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: aload 4
    //   326: invokespecial 130	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   329: astore 4
    //   331: aload 4
    //   333: athrow
    //   334: astore 5
    //   336: aload_3
    //   337: astore 4
    //   339: aload 5
    //   341: astore_3
    //   342: goto -57 -> 285
    //   345: goto -332 -> 13
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	348	0	this	b
    //   82	186	1	j	int
    //   12	266	2	bool	boolean
    //   10	271	3	localObject1	Object
    //   284	53	3	localException1	Exception
    //   341	1	3	localObject2	Object
    //   14	110	4	localObject3	Object
    //   149	19	4	localNullPointerException	NullPointerException
    //   185	153	4	localObject4	Object
    //   59	164	5	localIOException1	IOException
    //   228	51	5	localIOException2	IOException
    //   334	6	5	localException2	Exception
    //   7	257	6	localj	com.megvii.zhimasdk.b.a.b.j
    //   25	74	7	localUnknownHostException	java.net.UnknownHostException
    // Exception table:
    //   from	to	target	type
    //   20	24	25	java/net/UnknownHostException
    //   20	24	149	java/lang/NullPointerException
    //   20	24	228	java/io/IOException
    //   65	72	284	java/lang/Exception
    //   76	83	284	java/lang/Exception
    //   87	92	284	java/lang/Exception
    //   96	113	284	java/lang/Exception
    //   125	138	284	java/lang/Exception
    //   187	194	284	java/lang/Exception
    //   198	203	284	java/lang/Exception
    //   207	222	284	java/lang/Exception
    //   243	250	284	java/lang/Exception
    //   254	259	284	java/lang/Exception
    //   263	278	284	java/lang/Exception
    //   20	24	334	java/lang/Exception
    //   27	61	334	java/lang/Exception
    //   151	183	334	java/lang/Exception
    //   230	235	334	java/lang/Exception
  }
  
  private void e()
  {
    try
    {
      if ((!this.h) && (this.e.get()) && (!this.g))
      {
        this.g = true;
        this.d.h();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a(b paramb) {}
  
  public boolean a()
  {
    boolean bool = this.e.get();
    if (bool) {
      e();
    }
    return bool;
  }
  
  public void b(b paramb) {}
  
  public boolean b()
  {
    return (a()) || (this.h);
  }
  
  public void run()
  {
    if (a()) {}
    for (;;)
    {
      return;
      if (!this.i)
      {
        this.i = true;
        a(this);
      }
      if (a()) {
        continue;
      }
      this.d.f();
      if (a()) {
        continue;
      }
      try
      {
        d();
        if (a()) {
          continue;
        }
        this.d.g();
        if (a()) {
          continue;
        }
        b(this);
        this.h = true;
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          if (!a()) {
            this.d.b(0, null, null, localIOException);
          } else {
            a.a.b("AsyncHttpRequest", "makeRequestWithRetries returned error", localIOException);
          }
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */