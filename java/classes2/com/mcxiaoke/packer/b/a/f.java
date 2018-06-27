package com.mcxiaoke.packer.b.a;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class f
{
  /* Error */
  static void a(File paramFile, a parama)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: new 14	java/io/RandomAccessFile
    //   6: dup
    //   7: aload_0
    //   8: ldc 16
    //   10: invokespecial 20	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   13: astore_0
    //   14: aload_0
    //   15: invokevirtual 24	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   18: astore 10
    //   20: aload 10
    //   22: invokestatic 30	com/mcxiaoke/packer/b/a/c:findZipCommentLength	(Ljava/nio/channels/FileChannel;)J
    //   25: lstore_2
    //   26: aload 10
    //   28: lload_2
    //   29: invokestatic 34	com/mcxiaoke/packer/b/a/c:findCentralDirStartOffset	(Ljava/nio/channels/FileChannel;J)J
    //   32: lstore 4
    //   34: aload 10
    //   36: lload 4
    //   38: invokestatic 38	com/mcxiaoke/packer/b/a/c:findApkSigningBlock	(Ljava/nio/channels/FileChannel;J)Lcom/mcxiaoke/packer/b/a/d;
    //   41: astore 11
    //   43: aload 11
    //   45: invokevirtual 44	com/mcxiaoke/packer/b/a/d:getFirst	()Ljava/lang/Object;
    //   48: checkcast 46	java/nio/ByteBuffer
    //   51: astore 12
    //   53: aload 11
    //   55: invokevirtual 49	com/mcxiaoke/packer/b/a/d:getSecond	()Ljava/lang/Object;
    //   58: checkcast 51	java/lang/Long
    //   61: invokevirtual 55	java/lang/Long:longValue	()J
    //   64: lstore 6
    //   66: lload 4
    //   68: lconst_0
    //   69: lcmp
    //   70: ifeq +10 -> 80
    //   73: lload 6
    //   75: lconst_0
    //   76: lcmp
    //   77: ifne +31 -> 108
    //   80: new 12	java/io/IOException
    //   83: dup
    //   84: ldc 57
    //   86: invokespecial 60	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   89: athrow
    //   90: astore 11
    //   92: aload_0
    //   93: astore_1
    //   94: aload 11
    //   96: astore_0
    //   97: aload 10
    //   99: invokestatic 65	com/mcxiaoke/packer/b/a/h:a	(Ljava/io/Closeable;)V
    //   102: aload_1
    //   103: invokestatic 65	com/mcxiaoke/packer/b/a/h:a	(Ljava/io/Closeable;)V
    //   106: aload_0
    //   107: athrow
    //   108: aload 12
    //   110: invokestatic 69	com/mcxiaoke/packer/b/a/c:findIdValues	(Ljava/nio/ByteBuffer;)Ljava/util/Map;
    //   113: astore 11
    //   115: aload 11
    //   117: ldc 70
    //   119: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   122: invokeinterface 82 2 0
    //   127: checkcast 46	java/nio/ByteBuffer
    //   130: ifnonnull +13 -> 143
    //   133: new 12	java/io/IOException
    //   136: dup
    //   137: ldc 57
    //   139: invokespecial 60	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   142: athrow
    //   143: aload_1
    //   144: aload 11
    //   146: invokeinterface 86 2 0
    //   151: astore_1
    //   152: aload_0
    //   153: lload 4
    //   155: invokevirtual 90	java/io/RandomAccessFile:seek	(J)V
    //   158: aload 10
    //   160: invokevirtual 95	java/nio/channels/FileChannel:size	()J
    //   163: lload 4
    //   165: lsub
    //   166: l2i
    //   167: newarray <illegal type>
    //   169: astore 11
    //   171: aload_0
    //   172: aload 11
    //   174: invokevirtual 99	java/io/RandomAccessFile:read	([B)I
    //   177: pop
    //   178: aload 10
    //   180: lload 6
    //   182: invokevirtual 103	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   185: pop
    //   186: aload_1
    //   187: aload_0
    //   188: invokevirtual 109	com/mcxiaoke/packer/b/a/a:writeTo	(Ljava/io/DataOutput;)J
    //   191: lstore 8
    //   193: aload_0
    //   194: aload 11
    //   196: invokevirtual 113	java/io/RandomAccessFile:write	([B)V
    //   199: aload_0
    //   200: aload_0
    //   201: invokevirtual 116	java/io/RandomAccessFile:getFilePointer	()J
    //   204: invokevirtual 119	java/io/RandomAccessFile:setLength	(J)V
    //   207: aload_0
    //   208: aload 10
    //   210: invokevirtual 95	java/nio/channels/FileChannel:size	()J
    //   213: lload_2
    //   214: lsub
    //   215: ldc2_w 120
    //   218: lsub
    //   219: invokevirtual 90	java/io/RandomAccessFile:seek	(J)V
    //   222: iconst_4
    //   223: invokestatic 125	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   226: astore_1
    //   227: aload_1
    //   228: getstatic 131	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   231: invokevirtual 135	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   234: pop
    //   235: aload_1
    //   236: lload 4
    //   238: lload 8
    //   240: ladd
    //   241: ldc2_w 136
    //   244: ladd
    //   245: lload 4
    //   247: lload 6
    //   249: lsub
    //   250: lsub
    //   251: l2i
    //   252: invokevirtual 140	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   255: pop
    //   256: aload_1
    //   257: invokevirtual 144	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   260: pop
    //   261: aload_0
    //   262: aload_1
    //   263: invokevirtual 148	java/nio/ByteBuffer:array	()[B
    //   266: invokevirtual 113	java/io/RandomAccessFile:write	([B)V
    //   269: aload 10
    //   271: invokestatic 65	com/mcxiaoke/packer/b/a/h:a	(Ljava/io/Closeable;)V
    //   274: aload_0
    //   275: invokestatic 65	com/mcxiaoke/packer/b/a/h:a	(Ljava/io/Closeable;)V
    //   278: return
    //   279: astore_0
    //   280: aconst_null
    //   281: astore_1
    //   282: aload 11
    //   284: astore 10
    //   286: goto -189 -> 97
    //   289: astore 10
    //   291: aload_0
    //   292: astore_1
    //   293: aload 10
    //   295: astore_0
    //   296: aload 11
    //   298: astore 10
    //   300: goto -203 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	paramFile	File
    //   0	303	1	parama	a
    //   25	189	2	l1	long
    //   32	214	4	l2	long
    //   64	184	6	l3	long
    //   191	48	8	l4	long
    //   18	267	10	localObject1	Object
    //   289	5	10	localObject2	Object
    //   298	1	10	localObject3	Object
    //   1	53	11	locald	d
    //   90	5	11	localObject4	Object
    //   113	184	11	localObject5	Object
    //   51	58	12	localByteBuffer	ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   20	66	90	finally
    //   80	90	90	finally
    //   108	143	90	finally
    //   143	269	90	finally
    //   3	14	279	finally
    //   14	20	289	finally
  }
  
  private static void a(File paramFile, Map<Integer, ByteBuffer> paramMap)
    throws IOException
  {
    a(paramFile, new a()
    {
      public a handle(Map<Integer, ByteBuffer> paramAnonymousMap)
      {
        if ((this.a != null) && (!this.a.isEmpty())) {
          paramAnonymousMap.putAll(this.a);
        }
        a locala = new a();
        paramAnonymousMap = paramAnonymousMap.entrySet().iterator();
        while (paramAnonymousMap.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramAnonymousMap.next();
          locala.addPayload(new b(((Integer)localEntry.getKey()).intValue(), (ByteBuffer)localEntry.getValue()));
        }
        return locala;
      }
    });
  }
  
  public static void writeBlock(File paramFile, int paramInt, ByteBuffer paramByteBuffer)
    throws IOException
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(paramInt), paramByteBuffer);
    a(paramFile, localHashMap);
  }
  
  public static void writeBlock(File paramFile, int paramInt, byte[] paramArrayOfByte)
    throws IOException
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramArrayOfByte.length);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.put(paramArrayOfByte, 0, paramArrayOfByte.length);
    localByteBuffer.flip();
    writeBlock(paramFile, paramInt, localByteBuffer);
  }
  
  static abstract interface a
  {
    public abstract a handle(Map<Integer, ByteBuffer> paramMap);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mcxiaoke/packer/b/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */