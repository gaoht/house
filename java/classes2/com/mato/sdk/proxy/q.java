package com.mato.sdk.proxy;

import com.mato.android.matoid.service.mtunnel.HttpHandler;
import com.mato.android.matoid.service.mtunnel.b;
import com.mato.sdk.b.g;
import com.mato.sdk.b.j;

public final class q
{
  private static final String a = g.b("");
  private static final int b = 10;
  private static final int c = 50;
  private static final int d = 2000;
  private static final int e = 5000;
  private static int f = 1;
  private static int g = 2;
  private static int h = 3;
  private static int i = 4;
  private static int j;
  private boolean k = false;
  private final HttpHandler l;
  private int m = -1;
  private final l n;
  
  public q(l paraml, b paramb)
  {
    HttpHandler.a(paramb);
    this.l = new HttpHandler();
    this.n = paraml;
  }
  
  private boolean a(int paramInt, boolean paramBoolean)
    throws j
  {
    byte[] arrayOfByte = this.n.a(paramInt);
    if (arrayOfByte != null)
    {
      this.l.a(arrayOfByte, paramInt, paramBoolean);
      return true;
    }
    return false;
  }
  
  private String b(String paramString)
    throws j
  {
    if (paramString == null) {
      return null;
    }
    return this.l.a(paramString);
  }
  
  private void c(String paramString)
    throws j
  {
    this.l.b(paramString);
  }
  
  private boolean c(boolean paramBoolean)
    throws j
  {
    if (!a(0, paramBoolean)) {}
    while ((!a(2, paramBoolean)) || (!a(3, paramBoolean)) || (!a(4, paramBoolean)) || (!a(1, paramBoolean))) {
      return false;
    }
    return true;
  }
  
  private void f()
    throws j
  {
    String[] arrayOfString = this.n.a();
    this.l.a(arrayOfString, arrayOfString.length);
  }
  
  /* Error */
  private int g()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 59	com/mato/sdk/proxy/q:l	Lcom/mato/android/matoid/service/mtunnel/HttpHandler;
    //   4: ldc2_w 91
    //   7: invokevirtual 96	com/mato/android/matoid/service/mtunnel/HttpHandler:join	(J)V
    //   10: iconst_0
    //   11: istore_1
    //   12: iload_1
    //   13: bipush 40
    //   15: if_icmpge +49 -> 64
    //   18: aload_0
    //   19: getfield 59	com/mato/sdk/proxy/q:l	Lcom/mato/android/matoid/service/mtunnel/HttpHandler;
    //   22: invokevirtual 100	com/mato/android/matoid/service/mtunnel/HttpHandler:isAlive	()Z
    //   25: ifne +5 -> 30
    //   28: iconst_2
    //   29: ireturn
    //   30: aload_0
    //   31: iconst_0
    //   32: invokestatic 103	com/mato/android/matoid/service/mtunnel/HttpHandler:c	(Z)I
    //   35: putfield 51	com/mato/sdk/proxy/q:m	I
    //   38: aload_0
    //   39: getfield 51	com/mato/sdk/proxy/q:m	I
    //   42: ifle +5 -> 47
    //   45: iconst_0
    //   46: ireturn
    //   47: aload_0
    //   48: getfield 59	com/mato/sdk/proxy/q:l	Lcom/mato/android/matoid/service/mtunnel/HttpHandler;
    //   51: ldc2_w 104
    //   54: invokevirtual 96	com/mato/android/matoid/service/mtunnel/HttpHandler:join	(J)V
    //   57: iload_1
    //   58: iconst_1
    //   59: iadd
    //   60: istore_1
    //   61: goto -49 -> 12
    //   64: iconst_3
    //   65: ireturn
    //   66: astore_2
    //   67: goto -10 -> 57
    //   70: astore_2
    //   71: iconst_2
    //   72: ireturn
    //   73: astore_2
    //   74: iconst_2
    //   75: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	q
    //   11	50	1	i1	int
    //   66	1	2	localInterruptedException1	InterruptedException
    //   70	1	2	localj	j
    //   73	1	2	localInterruptedException2	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   47	57	66	java/lang/InterruptedException
    //   30	38	70	com/mato/sdk/b/j
    //   0	10	73	java/lang/InterruptedException
  }
  
  private boolean h()
  {
    try
    {
      HttpHandler.c(false);
      return false;
    }
    catch (j localj1)
    {
      try
      {
        this.l.a("http://www.baidu.com/");
        return true;
      }
      catch (j localj2) {}
      localj1 = localj1;
      return false;
    }
  }
  
  public final int a()
  {
    boolean bool1 = true;
    int i1 = 1;
    if (this.k) {
      i1 = 0;
    }
    while (!h()) {
      return i1;
    }
    try
    {
      boolean bool2 = c(false);
      if (!bool2) {
        return 4;
      }
      this.l.start();
      System.currentTimeMillis();
      i1 = g();
      System.currentTimeMillis();
      if (i1 == 0) {}
      for (;;)
      {
        this.k = bool1;
        return i1;
        bool1 = false;
      }
      return 1;
    }
    catch (j localj) {}
  }
  
  public final void a(int paramInt, String paramString)
    throws j
  {
    this.l.a(paramInt, paramString);
  }
  
  public final void a(String paramString)
    throws j
  {
    this.l.c(paramString);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    this.l.a(paramString1, paramString2);
  }
  
  public final void a(boolean paramBoolean)
    throws j
  {
    boolean bool = true;
    HttpHandler localHttpHandler = this.l;
    if (!paramBoolean) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localHttpHandler.a(paramBoolean);
      return;
    }
  }
  
  public final void a(String[] paramArrayOfString)
    throws j
  {
    this.l.b(paramArrayOfString);
  }
  
  public final int b()
  {
    return this.m;
  }
  
  public final void b(boolean paramBoolean)
    throws j
  {
    this.l.b(true);
  }
  
  public final void b(String[] paramArrayOfString)
    throws j
  {
    this.l.a(paramArrayOfString);
  }
  
  public final void c()
  {
    if (!this.k) {}
    for (;;)
    {
      return;
      this.k = false;
      try
      {
        this.l.a();
        this.l.join(5000L);
        if (!this.l.isAlive()) {
          continue;
        }
        this.l.interrupt();
        return;
      }
      catch (j localj)
      {
        for (;;)
        {
          localj.toString();
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;) {}
      }
    }
  }
  
  public final boolean d()
    throws j
  {
    if (c(true))
    {
      this.l.d(true);
      return true;
    }
    return false;
  }
  
  public final void e()
    throws j
  {
    this.l.d(false);
    String[] arrayOfString = this.n.a();
    this.l.a(arrayOfString, arrayOfString.length);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/proxy/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */