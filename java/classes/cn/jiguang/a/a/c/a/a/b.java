package cn.jiguang.a.a.c.a.a;

final class b
  implements Runnable
{
  private static final String z;
  
  static
  {
    Object localObject1 = "HQ{5\\EPH$MBR`3@L{\"XO".toCharArray();
    int j = localObject1.length;
    int m = 0;
    int i = 0;
    Object localObject2 = localObject1;
    int k = j;
    label30:
    int n;
    if (j <= 1)
    {
      m = i;
      k = i;
      localObject2 = localObject1;
      n = localObject2[k];
      switch (m % 5)
      {
      default: 
        i = 57;
      }
    }
    for (;;)
    {
      localObject2[k] = ((char)(i ^ n));
      m += 1;
      if (j == 0)
      {
        k = j;
        break label30;
      }
      k = j;
      localObject2 = localObject1;
      localObject1 = localObject2;
      j = k;
      i = m;
      if (k > m) {
        break;
      }
      z = new String((char[])localObject2).intern();
      return;
      i = 43;
      continue;
      i = 36;
      continue;
      i = 9;
      continue;
      i = 71;
    }
  }
  
  b(Object paramObject) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: invokestatic 45	cn/jiguang/a/a/c/a/a/a:b	()Ljava/lang/Class;
    //   3: getstatic 30	cn/jiguang/a/a/c/a/a/b:z	Ljava/lang/String;
    //   6: iconst_0
    //   7: anewarray 4	java/lang/Object
    //   10: invokestatic 50	cn/jiguang/e/c:a	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   13: invokestatic 53	cn/jiguang/a/a/c/a/a/a:a	(Ljava/lang/Object;)Ljava/lang/Object;
    //   16: pop
    //   17: aload_0
    //   18: getfield 34	cn/jiguang/a/a/c/a/a/b:a	Ljava/lang/Object;
    //   21: astore_1
    //   22: aload_1
    //   23: monitorenter
    //   24: aload_0
    //   25: getfield 34	cn/jiguang/a/a/c/a/a/b:a	Ljava/lang/Object;
    //   28: invokevirtual 56	java/lang/Object:notify	()V
    //   31: aload_1
    //   32: monitorexit
    //   33: return
    //   34: astore_2
    //   35: aload_1
    //   36: monitorexit
    //   37: aload_2
    //   38: athrow
    //   39: astore_1
    //   40: aload_1
    //   41: invokevirtual 59	java/lang/Exception:printStackTrace	()V
    //   44: aload_0
    //   45: getfield 34	cn/jiguang/a/a/c/a/a/b:a	Ljava/lang/Object;
    //   48: astore_1
    //   49: aload_1
    //   50: monitorenter
    //   51: aload_0
    //   52: getfield 34	cn/jiguang/a/a/c/a/a/b:a	Ljava/lang/Object;
    //   55: invokevirtual 56	java/lang/Object:notify	()V
    //   58: aload_1
    //   59: monitorexit
    //   60: return
    //   61: astore_2
    //   62: aload_1
    //   63: monitorexit
    //   64: aload_2
    //   65: athrow
    //   66: astore_2
    //   67: aload_0
    //   68: getfield 34	cn/jiguang/a/a/c/a/a/b:a	Ljava/lang/Object;
    //   71: astore_1
    //   72: aload_1
    //   73: monitorenter
    //   74: aload_0
    //   75: getfield 34	cn/jiguang/a/a/c/a/a/b:a	Ljava/lang/Object;
    //   78: invokevirtual 56	java/lang/Object:notify	()V
    //   81: aload_1
    //   82: monitorexit
    //   83: aload_2
    //   84: athrow
    //   85: astore_2
    //   86: aload_1
    //   87: monitorexit
    //   88: aload_2
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	b
    //   39	2	1	localException	Exception
    //   34	4	2	localObject3	Object
    //   61	4	2	localObject4	Object
    //   66	18	2	localObject5	Object
    //   85	4	2	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   24	33	34	finally
    //   35	37	34	finally
    //   0	17	39	java/lang/Exception
    //   51	60	61	finally
    //   62	64	61	finally
    //   0	17	66	finally
    //   40	44	66	finally
    //   74	83	85	finally
    //   86	88	85	finally
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/a/a/c/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */