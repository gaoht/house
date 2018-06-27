package com.megvii.zhimasdk.b.a.i;

import com.megvii.zhimasdk.b.a.af;
import com.megvii.zhimasdk.b.a.ag;
import com.megvii.zhimasdk.b.a.h;
import com.megvii.zhimasdk.b.a.k.o;
import com.megvii.zhimasdk.b.a.s;

public class b
  implements com.megvii.zhimasdk.b.a.b
{
  public static final b a = new b();
  
  private boolean a(s params)
  {
    int i = params.a().b();
    return (i >= 200) && (i != 204) && (i != 304) && (i != 205);
  }
  
  protected ag a(h paramh)
  {
    return new o(paramh);
  }
  
  /* Error */
  public boolean a(s params, com.megvii.zhimasdk.b.a.n.e parame)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: aload_1
    //   4: ldc 42
    //   6: invokestatic 47	com/megvii/zhimasdk/b/a/o/a:a	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   9: pop
    //   10: aload_2
    //   11: ldc 49
    //   13: invokestatic 47	com/megvii/zhimasdk/b/a/o/a:a	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   16: pop
    //   17: aload_1
    //   18: invokeinterface 23 1 0
    //   23: invokeinterface 52 1 0
    //   28: astore 7
    //   30: aload_1
    //   31: ldc 54
    //   33: invokeinterface 58 2 0
    //   38: astore_2
    //   39: aload_2
    //   40: ifnull +19 -> 59
    //   43: ldc 60
    //   45: aload_2
    //   46: invokeinterface 66 1 0
    //   51: invokevirtual 72	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   54: ifne +46 -> 100
    //   57: iconst_0
    //   58: ireturn
    //   59: aload_0
    //   60: aload_1
    //   61: invokespecial 74	com/megvii/zhimasdk/b/a/i/b:a	(Lcom/megvii/zhimasdk/b/a/s;)Z
    //   64: ifeq +36 -> 100
    //   67: aload_1
    //   68: ldc 76
    //   70: invokeinterface 79 2 0
    //   75: astore_2
    //   76: aload_2
    //   77: arraylength
    //   78: iconst_1
    //   79: if_icmpne -22 -> 57
    //   82: aload_2
    //   83: iconst_0
    //   84: aaload
    //   85: astore_2
    //   86: aload_2
    //   87: invokeinterface 66 1 0
    //   92: invokestatic 85	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   95: istore_3
    //   96: iload_3
    //   97: iflt -40 -> 57
    //   100: aload_1
    //   101: ldc 87
    //   103: invokeinterface 91 2 0
    //   108: astore 6
    //   110: aload 6
    //   112: astore_2
    //   113: aload 6
    //   115: invokeinterface 97 1 0
    //   120: ifne +12 -> 132
    //   123: aload_1
    //   124: ldc 99
    //   126: invokeinterface 91 2 0
    //   131: astore_2
    //   132: aload_2
    //   133: invokeinterface 97 1 0
    //   138: ifeq +60 -> 198
    //   141: aload_0
    //   142: aload_2
    //   143: invokevirtual 101	com/megvii/zhimasdk/b/a/i/b:a	(Lcom/megvii/zhimasdk/b/a/h;)Lcom/megvii/zhimasdk/b/a/ag;
    //   146: astore_1
    //   147: iconst_0
    //   148: istore_3
    //   149: aload_1
    //   150: invokeinterface 104 1 0
    //   155: ifeq +37 -> 192
    //   158: aload_1
    //   159: invokeinterface 106 1 0
    //   164: astore_2
    //   165: ldc 108
    //   167: aload_2
    //   168: invokevirtual 72	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   171: ifne -114 -> 57
    //   174: ldc 110
    //   176: aload_2
    //   177: invokevirtual 72	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   180: istore 5
    //   182: iload 5
    //   184: ifeq -35 -> 149
    //   187: iconst_1
    //   188: istore_3
    //   189: goto -40 -> 149
    //   192: iload_3
    //   193: ifeq +5 -> 198
    //   196: iconst_1
    //   197: ireturn
    //   198: aload 7
    //   200: getstatic 115	com/megvii/zhimasdk/b/a/v:b	Lcom/megvii/zhimasdk/b/a/v;
    //   203: invokevirtual 120	com/megvii/zhimasdk/b/a/ac:c	(Lcom/megvii/zhimasdk/b/a/ac;)Z
    //   206: ifne +6 -> 212
    //   209: iload 4
    //   211: ireturn
    //   212: iconst_0
    //   213: istore 4
    //   215: goto -6 -> 209
    //   218: astore_1
    //   219: iconst_0
    //   220: ireturn
    //   221: astore_1
    //   222: iconst_0
    //   223: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	b
    //   0	224	1	params	s
    //   0	224	2	parame	com.megvii.zhimasdk.b.a.n.e
    //   95	98	3	i	int
    //   1	213	4	bool1	boolean
    //   180	3	5	bool2	boolean
    //   108	6	6	localh	h
    //   28	171	7	localac	com.megvii.zhimasdk.b.a.ac
    // Exception table:
    //   from	to	target	type
    //   141	147	218	com/megvii/zhimasdk/b/a/aa
    //   149	182	218	com/megvii/zhimasdk/b/a/aa
    //   86	96	221	java/lang/NumberFormatException
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */