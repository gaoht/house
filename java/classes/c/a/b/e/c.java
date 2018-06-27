package c.a.b.e;

import java.nio.ByteBuffer;

public class c
  extends e
{
  private int a;
  private String b;
  
  public c()
  {
    super(a.a.f);
    a("");
    a(1000);
  }
  
  private void k()
  {
    byte[] arrayOfByte = c.a.b.b.c.a(this.b);
    ByteBuffer localByteBuffer1 = ByteBuffer.allocate(4);
    localByteBuffer1.putInt(this.a);
    localByteBuffer1.position(2);
    ByteBuffer localByteBuffer2 = ByteBuffer.allocate(arrayOfByte.length + 2);
    localByteBuffer2.put(localByteBuffer1);
    localByteBuffer2.put(arrayOfByte);
    localByteBuffer2.rewind();
    super.a(localByteBuffer2);
  }
  
  public int a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
    if (paramInt == 1015)
    {
      this.a = 1005;
      this.b = "";
    }
    k();
  }
  
  public void a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.b = str;
    k();
  }
  
  /* Error */
  public void a(ByteBuffer paramByteBuffer)
  {
    // Byte code:
    //   0: aload_0
    //   1: sipush 1005
    //   4: putfield 44	c/a/b/e/c:a	I
    //   7: aload_0
    //   8: ldc 21
    //   10: putfield 31	c/a/b/e/c:b	Ljava/lang/String;
    //   13: aload_1
    //   14: invokevirtual 75	java/nio/ByteBuffer:mark	()Ljava/nio/Buffer;
    //   17: pop
    //   18: aload_1
    //   19: invokevirtual 78	java/nio/ByteBuffer:remaining	()I
    //   22: ifne +11 -> 33
    //   25: aload_0
    //   26: sipush 1000
    //   29: putfield 44	c/a/b/e/c:a	I
    //   32: return
    //   33: aload_1
    //   34: invokevirtual 78	java/nio/ByteBuffer:remaining	()I
    //   37: iconst_1
    //   38: if_icmpne +11 -> 49
    //   41: aload_0
    //   42: sipush 1002
    //   45: putfield 44	c/a/b/e/c:a	I
    //   48: return
    //   49: aload_1
    //   50: invokevirtual 78	java/nio/ByteBuffer:remaining	()I
    //   53: iconst_2
    //   54: if_icmplt +37 -> 91
    //   57: iconst_4
    //   58: invokestatic 42	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   61: astore_3
    //   62: aload_3
    //   63: iconst_2
    //   64: invokevirtual 51	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   67: pop
    //   68: aload_3
    //   69: aload_1
    //   70: invokevirtual 82	java/nio/ByteBuffer:getShort	()S
    //   73: invokevirtual 86	java/nio/ByteBuffer:putShort	(S)Ljava/nio/ByteBuffer;
    //   76: pop
    //   77: aload_3
    //   78: iconst_0
    //   79: invokevirtual 51	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   82: pop
    //   83: aload_0
    //   84: aload_3
    //   85: invokevirtual 89	java/nio/ByteBuffer:getInt	()I
    //   88: putfield 44	c/a/b/e/c:a	I
    //   91: aload_1
    //   92: invokevirtual 92	java/nio/ByteBuffer:reset	()Ljava/nio/Buffer;
    //   95: pop
    //   96: aload_1
    //   97: invokevirtual 94	java/nio/ByteBuffer:position	()I
    //   100: istore_2
    //   101: aload_1
    //   102: aload_1
    //   103: invokevirtual 94	java/nio/ByteBuffer:position	()I
    //   106: iconst_2
    //   107: iadd
    //   108: invokevirtual 51	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   111: pop
    //   112: aload_0
    //   113: aload_1
    //   114: invokestatic 97	c/a/b/b/c:a	(Ljava/nio/ByteBuffer;)Ljava/lang/String;
    //   117: putfield 31	c/a/b/e/c:b	Ljava/lang/String;
    //   120: aload_1
    //   121: iload_2
    //   122: invokevirtual 51	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   125: pop
    //   126: return
    //   127: astore_1
    //   128: aload_0
    //   129: sipush 1007
    //   132: putfield 44	c/a/b/e/c:a	I
    //   135: aload_0
    //   136: aconst_null
    //   137: putfield 31	c/a/b/e/c:b	Ljava/lang/String;
    //   140: return
    //   141: astore_3
    //   142: new 70	c/a/b/d/b
    //   145: dup
    //   146: sipush 1007
    //   149: invokespecial 99	c/a/b/d/b:<init>	(I)V
    //   152: athrow
    //   153: astore_3
    //   154: aload_1
    //   155: iload_2
    //   156: invokevirtual 51	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   159: pop
    //   160: aload_3
    //   161: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	this	c
    //   0	162	1	paramByteBuffer	ByteBuffer
    //   100	56	2	i	int
    //   61	24	3	localByteBuffer	ByteBuffer
    //   141	1	3	localIllegalArgumentException	IllegalArgumentException
    //   153	8	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   96	101	127	c/a/b/d/b
    //   120	126	127	c/a/b/d/b
    //   154	162	127	c/a/b/d/b
    //   101	120	141	java/lang/IllegalArgumentException
    //   101	120	153	finally
    //   142	153	153	finally
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void c()
    throws c.a.b.d.b
  {
    super.c();
    if ((this.a == 1007) && (this.b == null)) {
      throw new c.a.b.d.b(1007);
    }
    if ((this.a == 1005) && (this.b.length() > 0)) {
      throw new c.a.b.d.b(1002, "A close frame must have a closecode if it has a reason");
    }
    if ((this.a > 1011) && (this.a < 3000) && (this.a != 1015)) {
      throw new c.a.b.d.b(1002, "Trying to send an illegal close code!");
    }
    if ((this.a == 1006) || (this.a == 1015) || (this.a == 1005) || (this.a > 4999) || (this.a < 1000) || (this.a == 1004)) {
      throw new c.a.b.d.c("closecode must not be sent over the wire: " + this.a);
    }
  }
  
  public ByteBuffer d()
  {
    if (this.a == 1005) {
      return c.a.b.b.b.a();
    }
    return super.d();
  }
  
  public String toString()
  {
    return super.toString() + "code: " + this.a;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/c/a/b/e/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */