package com.b.c.m;

public class h
{
  static
  {
    if (!h.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  /* Error */
  public void extract(com.b.b.n paramn, com.b.c.d paramd)
  {
    // Byte code:
    //   0: new 26	com/b/c/m/g
    //   3: dup
    //   4: invokespecial 27	com/b/c/m/g:<init>	()V
    //   7: astore 6
    //   9: aload_2
    //   10: aload 6
    //   12: invokevirtual 33	com/b/c/d:addDirectory	(Lcom/b/c/b;)V
    //   15: aload_1
    //   16: invokevirtual 39	com/b/b/n:getInt32	()I
    //   19: ldc 40
    //   21: if_icmpeq +11 -> 32
    //   24: aload 6
    //   26: ldc 42
    //   28: invokevirtual 46	com/b/c/m/g:addError	(Ljava/lang/String;)V
    //   31: return
    //   32: aload_1
    //   33: invokevirtual 49	com/b/b/n:getUInt16	()I
    //   36: istore_3
    //   37: iload_3
    //   38: iconst_1
    //   39: if_icmpeq +25 -> 64
    //   42: iload_3
    //   43: iconst_2
    //   44: if_icmpeq +20 -> 64
    //   47: aload 6
    //   49: ldc 51
    //   51: invokevirtual 46	com/b/c/m/g:addError	(Ljava/lang/String;)V
    //   54: return
    //   55: astore_1
    //   56: aload 6
    //   58: ldc 53
    //   60: invokevirtual 46	com/b/c/m/g:addError	(Ljava/lang/String;)V
    //   63: return
    //   64: aload_1
    //   65: ldc2_w 54
    //   68: invokevirtual 59	com/b/b/n:skip	(J)V
    //   71: aload 6
    //   73: iconst_1
    //   74: aload_1
    //   75: invokevirtual 49	com/b/b/n:getUInt16	()I
    //   78: invokevirtual 63	com/b/c/m/g:setInt	(II)V
    //   81: aload 6
    //   83: iconst_2
    //   84: aload_1
    //   85: invokevirtual 39	com/b/b/n:getInt32	()I
    //   88: invokevirtual 63	com/b/c/m/g:setInt	(II)V
    //   91: aload 6
    //   93: iconst_3
    //   94: aload_1
    //   95: invokevirtual 39	com/b/b/n:getInt32	()I
    //   98: invokevirtual 63	com/b/c/m/g:setInt	(II)V
    //   101: aload 6
    //   103: iconst_4
    //   104: aload_1
    //   105: invokevirtual 49	com/b/b/n:getUInt16	()I
    //   108: invokevirtual 63	com/b/c/m/g:setInt	(II)V
    //   111: aload 6
    //   113: iconst_5
    //   114: aload_1
    //   115: invokevirtual 49	com/b/b/n:getUInt16	()I
    //   118: invokevirtual 63	com/b/c/m/g:setInt	(II)V
    //   121: aload_1
    //   122: aload_1
    //   123: invokevirtual 67	com/b/b/n:getUInt32	()J
    //   126: invokevirtual 59	com/b/b/n:skip	(J)V
    //   129: aload_1
    //   130: invokevirtual 67	com/b/b/n:getUInt32	()J
    //   133: lstore 4
    //   135: getstatic 16	com/b/c/m/h:a	Z
    //   138: ifne +20 -> 158
    //   141: lload 4
    //   143: ldc2_w 68
    //   146: lcmp
    //   147: ifle +11 -> 158
    //   150: new 71	java/lang/AssertionError
    //   153: dup
    //   154: invokespecial 72	java/lang/AssertionError:<init>	()V
    //   157: athrow
    //   158: new 74	com/b/c/m/e
    //   161: dup
    //   162: invokespecial 75	com/b/c/m/e:<init>	()V
    //   165: aload_1
    //   166: lload 4
    //   168: l2i
    //   169: aload_2
    //   170: invokevirtual 78	com/b/c/m/e:extract	(Lcom/b/b/n;ILcom/b/c/d;)V
    //   173: return
    //   174: astore_1
    //   175: return
    //   176: astore_1
    //   177: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	this	h
    //   0	178	1	paramn	com.b.b.n
    //   0	178	2	paramd	com.b.c.d
    //   36	9	3	i	int
    //   133	34	4	l	long
    //   7	105	6	localg	g
    // Exception table:
    //   from	to	target	type
    //   15	31	55	java/io/IOException
    //   32	37	55	java/io/IOException
    //   47	54	55	java/io/IOException
    //   64	121	55	java/io/IOException
    //   121	129	174	java/io/IOException
    //   129	141	176	java/io/IOException
    //   150	158	176	java/io/IOException
    //   158	173	176	java/io/IOException
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/m/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */