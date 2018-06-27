package cn.jiguang.c.d;

import cn.jiguang.d.d;
import java.net.InetAddress;
import java.net.UnknownHostException;

final class c
  extends Thread
{
  private static final String[] z;
  private String a = null;
  private InetAddress b = null;
  
  static
  {
    String[] arrayOfString = new String[5];
    Object localObject1 = "D-3\f6`-$C\036X\033`\005;$`\005(y%`\0135e<zC";
    int i = -1;
    int j = 0;
    Object localObject3 = arrayOfString;
    localObject1 = ((String)localObject1).toCharArray();
    int k = localObject1.length;
    int m;
    int n;
    int i1;
    label42:
    Object localObject2;
    int i2;
    label91:
    label113:
    Object localObject4;
    int i3;
    if (k <= 1)
    {
      m = 0;
      n = j;
      i1 = i;
      j = m;
      for (;;)
      {
        localObject2 = localObject1;
        i2 = localObject2[m];
        switch (j % 5)
        {
        default: 
          i = 90;
          localObject2[m] = ((char)(i ^ i2));
          j += 1;
          if (k != 0) {
            break label113;
          }
          m = k;
        }
      }
      i = k;
      localObject4 = localObject3;
      i3 = n;
      localObject2 = localObject1;
      i2 = i1;
    }
    for (;;)
    {
      i1 = i2;
      localObject1 = localObject2;
      n = i3;
      localObject3 = localObject4;
      k = i;
      m = j;
      if (i > j) {
        break label42;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i2)
      {
      default: 
        localObject4[i3] = localObject1;
        localObject1 = "U'.\r?u<)\r=^-,\023?d";
        j = 1;
        i = 0;
        break;
      case 0: 
        localObject4[i3] = localObject1;
        localObject1 = "C&+\r5a&`\0135e<`\006\"u-0\0273y&a";
        j = 2;
        i = 1;
        break;
      case 1: 
        localObject4[i3] = localObject1;
        localObject1 = "B %C<w!,\026(sh!\023*s)2\020zb'`\013;`-`\001?s&`\002zz)#\bzy.`*\024B\r\022-\037Bha";
        j = 3;
        i = 2;
        break;
      case 2: 
        localObject4[i3] = localObject1;
        j = 4;
        localObject1 = "d-3\f6`-$C\036X\033`Nz~'3\027`";
        i = 3;
        break;
      case 3: 
        localObject4[i3] = localObject1;
        z = arrayOfString;
        return;
        i = 22;
        break label91;
        i = 72;
        break label91;
        i = 64;
        break label91;
        i = 99;
        break label91;
        m = 0;
        i2 = i;
        localObject2 = localObject1;
        i3 = j;
        localObject4 = localObject3;
        i = k;
        j = m;
      }
    }
  }
  
  public c(String paramString)
  {
    this.a = paramString;
  }
  
  /* Error */
  public final InetAddress a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 46	cn/jiguang/c/d/c:b	Ljava/net/InetAddress;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 46	cn/jiguang/c/d/c:b	Ljava/net/InetAddress;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: getstatic 38	cn/jiguang/c/d/c:z	[Ljava/lang/String;
    //   21: iconst_1
    //   22: aaload
    //   23: new 49	java/lang/StringBuilder
    //   26: dup
    //   27: getstatic 38	cn/jiguang/c/d/c:z	[Ljava/lang/String;
    //   30: iconst_0
    //   31: aaload
    //   32: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   35: aload_0
    //   36: getfield 44	cn/jiguang/c/d/c:a	Ljava/lang/String;
    //   39: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 64	cn/jiguang/d/d:g	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: aconst_null
    //   49: astore_1
    //   50: goto -36 -> 14
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	c
    //   13	37	1	localInetAddress	InetAddress
    //   53	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	53	finally
    //   18	48	53	finally
  }
  
  public final void run()
  {
    try
    {
      d.e(z[1], z[4] + this.a);
      this.b = InetAddress.getByName(this.a);
      return;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      d.d(z[1], z[2], localUnknownHostException);
      return;
    }
    catch (Exception localException)
    {
      d.d(z[1], z[3], localException);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */