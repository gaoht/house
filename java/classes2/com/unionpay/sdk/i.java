package com.unionpay.sdk;

import android.content.Context;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.zip.CRC32;

public class i
{
  Context a;
  File b;
  RandomAccessFile c;
  String d;
  CRC32 e = new CRC32();
  Lock f = new ReentrantLock();
  long g = 0L;
  long h = 0L;
  long i = -1L;
  
  public i(Context paramContext, String paramString)
  {
    try
    {
      this.a = paramContext;
      this.d = paramString;
      this.b = paramContext.getDir("td-cache", 0);
      e();
      try
      {
        f();
        if (this.c.length() > 3145728L) {
          d();
        }
        return;
      }
      catch (IOException paramContext)
      {
        for (;;) {}
      }
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  /* Error */
  private boolean a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 39	com/unionpay/sdk/i:f	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 86 1 0
    //   9: aload_0
    //   10: getfield 67	com/unionpay/sdk/i:c	Ljava/io/RandomAccessFile;
    //   13: lload_1
    //   14: invokevirtual 90	java/io/RandomAccessFile:seek	(J)V
    //   17: aload_0
    //   18: getfield 67	com/unionpay/sdk/i:c	Ljava/io/RandomAccessFile;
    //   21: invokevirtual 94	java/io/RandomAccessFile:readByte	()B
    //   24: istore_3
    //   25: iload_3
    //   26: bipush 31
    //   28: if_icmpne +131 -> 159
    //   31: aload_0
    //   32: getfield 67	com/unionpay/sdk/i:c	Ljava/io/RandomAccessFile;
    //   35: invokevirtual 98	java/io/RandomAccessFile:readInt	()I
    //   38: istore 4
    //   40: aload_0
    //   41: getfield 67	com/unionpay/sdk/i:c	Ljava/io/RandomAccessFile;
    //   44: invokevirtual 102	java/io/RandomAccessFile:readShort	()S
    //   47: istore 5
    //   49: iload 5
    //   51: iflt +185 -> 236
    //   54: aload_0
    //   55: getfield 67	com/unionpay/sdk/i:c	Ljava/io/RandomAccessFile;
    //   58: invokevirtual 105	java/io/RandomAccessFile:getFilePointer	()J
    //   61: iload 5
    //   63: i2l
    //   64: ladd
    //   65: aload_0
    //   66: getfield 67	com/unionpay/sdk/i:c	Ljava/io/RandomAccessFile;
    //   69: invokevirtual 73	java/io/RandomAccessFile:length	()J
    //   72: lcmp
    //   73: ifgt +163 -> 236
    //   76: aload_0
    //   77: getfield 34	com/unionpay/sdk/i:e	Ljava/util/zip/CRC32;
    //   80: invokevirtual 108	java/util/zip/CRC32:reset	()V
    //   83: iconst_0
    //   84: istore_3
    //   85: iload_3
    //   86: iload 5
    //   88: if_icmpge +24 -> 112
    //   91: aload_0
    //   92: getfield 34	com/unionpay/sdk/i:e	Ljava/util/zip/CRC32;
    //   95: aload_0
    //   96: getfield 67	com/unionpay/sdk/i:c	Ljava/io/RandomAccessFile;
    //   99: invokevirtual 111	java/io/RandomAccessFile:read	()I
    //   102: invokevirtual 115	java/util/zip/CRC32:update	(I)V
    //   105: iload_3
    //   106: iconst_1
    //   107: iadd
    //   108: istore_3
    //   109: goto -24 -> 85
    //   112: aload_0
    //   113: getfield 67	com/unionpay/sdk/i:c	Ljava/io/RandomAccessFile;
    //   116: invokevirtual 94	java/io/RandomAccessFile:readByte	()B
    //   119: bipush 31
    //   121: if_icmpne +115 -> 236
    //   124: iload 4
    //   126: aload_0
    //   127: getfield 34	com/unionpay/sdk/i:e	Ljava/util/zip/CRC32;
    //   130: invokevirtual 118	java/util/zip/CRC32:getValue	()J
    //   133: l2i
    //   134: if_icmpne +102 -> 236
    //   137: aload_0
    //   138: aload_0
    //   139: getfield 67	com/unionpay/sdk/i:c	Ljava/io/RandomAccessFile;
    //   142: invokevirtual 105	java/io/RandomAccessFile:getFilePointer	()J
    //   145: putfield 43	com/unionpay/sdk/i:h	J
    //   148: aload_0
    //   149: getfield 39	com/unionpay/sdk/i:f	Ljava/util/concurrent/locks/Lock;
    //   152: invokeinterface 121 1 0
    //   157: iconst_1
    //   158: ireturn
    //   159: iload_3
    //   160: bipush 46
    //   162: if_icmpne +74 -> 236
    //   165: aload_0
    //   166: getfield 67	com/unionpay/sdk/i:c	Ljava/io/RandomAccessFile;
    //   169: invokevirtual 98	java/io/RandomAccessFile:readInt	()I
    //   172: istore_3
    //   173: aload_0
    //   174: getfield 67	com/unionpay/sdk/i:c	Ljava/io/RandomAccessFile;
    //   177: invokevirtual 94	java/io/RandomAccessFile:readByte	()B
    //   180: istore 4
    //   182: iload_3
    //   183: iflt +53 -> 236
    //   186: iload_3
    //   187: i2l
    //   188: aload_0
    //   189: getfield 67	com/unionpay/sdk/i:c	Ljava/io/RandomAccessFile;
    //   192: invokevirtual 73	java/io/RandomAccessFile:length	()J
    //   195: lcmp
    //   196: ifge +40 -> 236
    //   199: iload 4
    //   201: bipush 46
    //   203: if_icmpne +33 -> 236
    //   206: aload_0
    //   207: aload_0
    //   208: getfield 67	com/unionpay/sdk/i:c	Ljava/io/RandomAccessFile;
    //   211: invokevirtual 105	java/io/RandomAccessFile:getFilePointer	()J
    //   214: putfield 43	com/unionpay/sdk/i:h	J
    //   217: aload_0
    //   218: iload_3
    //   219: i2l
    //   220: putfield 41	com/unionpay/sdk/i:g	J
    //   223: aload_0
    //   224: getfield 39	com/unionpay/sdk/i:f	Ljava/util/concurrent/locks/Lock;
    //   227: invokeinterface 121 1 0
    //   232: iconst_0
    //   233: ireturn
    //   234: astore 6
    //   236: aload_0
    //   237: lconst_1
    //   238: lload_1
    //   239: ladd
    //   240: putfield 43	com/unionpay/sdk/i:h	J
    //   243: aload_0
    //   244: getfield 39	com/unionpay/sdk/i:f	Ljava/util/concurrent/locks/Lock;
    //   247: invokeinterface 121 1 0
    //   252: iconst_0
    //   253: ireturn
    //   254: astore 6
    //   256: aload_0
    //   257: getfield 39	com/unionpay/sdk/i:f	Ljava/util/concurrent/locks/Lock;
    //   260: invokeinterface 121 1 0
    //   265: aload 6
    //   267: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	this	i
    //   0	268	1	paramLong	long
    //   24	195	3	j	int
    //   38	166	4	k	int
    //   47	42	5	m	int
    //   234	1	6	localException	Exception
    //   254	12	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	25	234	java/lang/Exception
    //   31	49	234	java/lang/Exception
    //   54	83	234	java/lang/Exception
    //   91	105	234	java/lang/Exception
    //   112	148	234	java/lang/Exception
    //   165	182	234	java/lang/Exception
    //   186	199	234	java/lang/Exception
    //   206	223	234	java/lang/Exception
    //   0	9	254	finally
    //   9	25	254	finally
    //   31	49	254	finally
    //   54	83	254	finally
    //   91	105	254	finally
    //   112	148	254	finally
    //   165	182	254	finally
    //   186	199	254	finally
    //   206	223	254	finally
    //   236	243	254	finally
  }
  
  /* Error */
  private byte[] b(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 39	com/unionpay/sdk/i:f	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 86 1 0
    //   9: aload_0
    //   10: getfield 67	com/unionpay/sdk/i:c	Ljava/io/RandomAccessFile;
    //   13: lload_1
    //   14: invokevirtual 90	java/io/RandomAccessFile:seek	(J)V
    //   17: aload_0
    //   18: getfield 67	com/unionpay/sdk/i:c	Ljava/io/RandomAccessFile;
    //   21: invokevirtual 94	java/io/RandomAccessFile:readByte	()B
    //   24: istore_3
    //   25: iload_3
    //   26: bipush 31
    //   28: if_icmpne +125 -> 153
    //   31: aload_0
    //   32: getfield 67	com/unionpay/sdk/i:c	Ljava/io/RandomAccessFile;
    //   35: invokevirtual 98	java/io/RandomAccessFile:readInt	()I
    //   38: istore_3
    //   39: aload_0
    //   40: getfield 67	com/unionpay/sdk/i:c	Ljava/io/RandomAccessFile;
    //   43: invokevirtual 102	java/io/RandomAccessFile:readShort	()S
    //   46: istore 4
    //   48: iload 4
    //   50: iflt +174 -> 224
    //   53: aload_0
    //   54: getfield 67	com/unionpay/sdk/i:c	Ljava/io/RandomAccessFile;
    //   57: invokevirtual 105	java/io/RandomAccessFile:getFilePointer	()J
    //   60: iload 4
    //   62: i2l
    //   63: ladd
    //   64: aload_0
    //   65: getfield 67	com/unionpay/sdk/i:c	Ljava/io/RandomAccessFile;
    //   68: invokevirtual 73	java/io/RandomAccessFile:length	()J
    //   71: lcmp
    //   72: ifgt +152 -> 224
    //   75: iload 4
    //   77: newarray <illegal type>
    //   79: astore 5
    //   81: aload_0
    //   82: getfield 67	com/unionpay/sdk/i:c	Ljava/io/RandomAccessFile;
    //   85: aload 5
    //   87: invokevirtual 126	java/io/RandomAccessFile:readFully	([B)V
    //   90: aload_0
    //   91: getfield 67	com/unionpay/sdk/i:c	Ljava/io/RandomAccessFile;
    //   94: invokevirtual 94	java/io/RandomAccessFile:readByte	()B
    //   97: bipush 31
    //   99: if_icmpne +125 -> 224
    //   102: aload_0
    //   103: getfield 34	com/unionpay/sdk/i:e	Ljava/util/zip/CRC32;
    //   106: invokevirtual 108	java/util/zip/CRC32:reset	()V
    //   109: aload_0
    //   110: getfield 34	com/unionpay/sdk/i:e	Ljava/util/zip/CRC32;
    //   113: aload 5
    //   115: invokevirtual 128	java/util/zip/CRC32:update	([B)V
    //   118: iload_3
    //   119: aload_0
    //   120: getfield 34	com/unionpay/sdk/i:e	Ljava/util/zip/CRC32;
    //   123: invokevirtual 118	java/util/zip/CRC32:getValue	()J
    //   126: l2i
    //   127: if_icmpne +97 -> 224
    //   130: aload_0
    //   131: aload_0
    //   132: getfield 67	com/unionpay/sdk/i:c	Ljava/io/RandomAccessFile;
    //   135: invokevirtual 105	java/io/RandomAccessFile:getFilePointer	()J
    //   138: putfield 43	com/unionpay/sdk/i:h	J
    //   141: aload_0
    //   142: getfield 39	com/unionpay/sdk/i:f	Ljava/util/concurrent/locks/Lock;
    //   145: invokeinterface 121 1 0
    //   150: aload 5
    //   152: areturn
    //   153: iload_3
    //   154: bipush 46
    //   156: if_icmpne +68 -> 224
    //   159: aload_0
    //   160: getfield 67	com/unionpay/sdk/i:c	Ljava/io/RandomAccessFile;
    //   163: invokevirtual 98	java/io/RandomAccessFile:readInt	()I
    //   166: istore_3
    //   167: aload_0
    //   168: getfield 67	com/unionpay/sdk/i:c	Ljava/io/RandomAccessFile;
    //   171: invokevirtual 94	java/io/RandomAccessFile:readByte	()B
    //   174: istore 4
    //   176: iload_3
    //   177: iflt +47 -> 224
    //   180: iload_3
    //   181: i2l
    //   182: aload_0
    //   183: getfield 67	com/unionpay/sdk/i:c	Ljava/io/RandomAccessFile;
    //   186: invokevirtual 73	java/io/RandomAccessFile:length	()J
    //   189: lcmp
    //   190: ifge +34 -> 224
    //   193: iload 4
    //   195: bipush 46
    //   197: if_icmpne +27 -> 224
    //   200: aload_0
    //   201: aload_0
    //   202: getfield 67	com/unionpay/sdk/i:c	Ljava/io/RandomAccessFile;
    //   205: invokevirtual 105	java/io/RandomAccessFile:getFilePointer	()J
    //   208: putfield 43	com/unionpay/sdk/i:h	J
    //   211: aload_0
    //   212: getfield 39	com/unionpay/sdk/i:f	Ljava/util/concurrent/locks/Lock;
    //   215: invokeinterface 121 1 0
    //   220: aconst_null
    //   221: areturn
    //   222: astore 5
    //   224: aload_0
    //   225: lconst_1
    //   226: lload_1
    //   227: ladd
    //   228: putfield 43	com/unionpay/sdk/i:h	J
    //   231: aload_0
    //   232: getfield 39	com/unionpay/sdk/i:f	Ljava/util/concurrent/locks/Lock;
    //   235: invokeinterface 121 1 0
    //   240: aconst_null
    //   241: areturn
    //   242: astore 5
    //   244: aload_0
    //   245: getfield 39	com/unionpay/sdk/i:f	Ljava/util/concurrent/locks/Lock;
    //   248: invokeinterface 121 1 0
    //   253: aload 5
    //   255: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	this	i
    //   0	256	1	paramLong	long
    //   24	157	3	j	int
    //   46	152	4	k	int
    //   79	72	5	arrayOfByte	byte[]
    //   222	1	5	localException	Exception
    //   242	12	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	25	222	java/lang/Exception
    //   31	48	222	java/lang/Exception
    //   53	141	222	java/lang/Exception
    //   159	176	222	java/lang/Exception
    //   180	193	222	java/lang/Exception
    //   200	211	222	java/lang/Exception
    //   0	9	242	finally
    //   9	25	242	finally
    //   31	48	242	finally
    //   53	141	242	finally
    //   159	176	242	finally
    //   180	193	242	finally
    //   200	211	242	finally
    //   224	231	242	finally
  }
  
  private void d()
  {
    long l;
    if (this.g < this.i) {
      l = this.i;
    }
    for (;;)
    {
      this.h = l;
      File localFile = new File(this.b, this.d + ".tmp");
      localObject2 = new FileOutputStream(localFile);
      try
      {
        while (this.h < this.c.length())
        {
          byte[] arrayOfByte = b(this.h);
          if (arrayOfByte != null) {
            ((FileOutputStream)localObject2).write(arrayOfByte);
          }
        }
        l = this.g;
      }
      finally
      {
        ((FileOutputStream)localObject2).flush();
        ((FileOutputStream)localObject2).close();
        this.c.close();
      }
    }
    ((FileOutputStream)localObject2).flush();
    ((FileOutputStream)localObject2).close();
    this.c.close();
    Object localObject2 = new File(this.b, this.d);
    ((File)localObject2).delete();
    ((File)localObject1).renameTo((File)localObject2);
    e();
    this.g = 0L;
    this.h = 0L;
  }
  
  private void e()
  {
    this.c = new RandomAccessFile(new File(this.b, this.d), "rw");
  }
  
  private void f()
  {
    int j = 0;
    while (this.h < this.c.length())
    {
      if ((this.i == -1L) && (this.c.length() - this.h < 3145728L)) {
        this.i = this.h;
      }
      long l = this.h;
      if ((a(l)) && (j == 0))
      {
        int k = 1;
        j = k;
        if (this.g == 0L)
        {
          this.g = l;
          j = k;
        }
      }
    }
  }
  
  public List a(int paramInt)
  {
    LinkedList localLinkedList = new LinkedList();
    try
    {
      this.h = this.g;
      this.c.seek(this.h);
      int j;
      do
      {
        if (this.h >= this.c.length()) {
          break;
        }
        byte[] arrayOfByte = b(this.h);
        if (arrayOfByte != null) {
          localLinkedList.add(arrayOfByte);
        }
        j = localLinkedList.size();
      } while (j < paramInt);
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    if (localLinkedList.size() == 0) {
      this.g = this.h;
    }
    return localLinkedList;
  }
  
  public void a()
  {
    long l = this.h;
    try
    {
      this.f.lock();
      this.c.seek(this.c.length());
      this.c.writeByte(46);
      this.c.writeInt((int)l);
      this.c.writeByte(46);
      this.f.unlock();
      this.g = this.h;
      return;
    }
    finally
    {
      this.f.unlock();
    }
  }
  
  public void b()
  {
    this.c.getFD().sync();
  }
  
  public void c()
  {
    b();
    this.c.close();
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    try
    {
      this.f.lock();
      this.c.seek(this.c.length());
      this.c.writeByte(31);
      this.e.reset();
      this.e.update(paramArrayOfByte);
      this.c.writeInt((int)this.e.getValue());
      this.c.writeShort(paramArrayOfByte.length);
      this.c.write(paramArrayOfByte);
      this.c.writeByte(31);
      return;
    }
    finally
    {
      this.f.unlock();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */