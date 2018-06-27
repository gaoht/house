package com.b.c.c;

import java.util.HashMap;

public class k
  extends b
{
  protected static final HashMap<Integer, String> e = new HashMap();
  private byte[] f;
  
  static
  {
    a(e);
    e.put(Integer.valueOf(513), "Thumbnail Offset");
    e.put(Integer.valueOf(514), "Thumbnail Length");
  }
  
  public k()
  {
    setDescriptor(new j(this));
  }
  
  protected HashMap<Integer, String> a()
  {
    return e;
  }
  
  public String getName()
  {
    return "Exif Thumbnail";
  }
  
  public byte[] getThumbnailData()
  {
    return this.f;
  }
  
  public boolean hasThumbnailData()
  {
    return this.f != null;
  }
  
  public void setThumbnailData(byte[] paramArrayOfByte)
  {
    this.f = paramArrayOfByte;
  }
  
  /* Error */
  public void writeThumbnail(String paramString)
    throws com.b.c.e, java.io.IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 58	com/b/c/c/k:f	[B
    //   4: astore_3
    //   5: aload_3
    //   6: ifnonnull +13 -> 19
    //   9: new 66	com/b/c/e
    //   12: dup
    //   13: ldc 70
    //   15: invokespecial 72	com/b/c/e:<init>	(Ljava/lang/String;)V
    //   18: athrow
    //   19: new 74	java/io/FileOutputStream
    //   22: dup
    //   23: aload_1
    //   24: invokespecial 75	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   27: astore_2
    //   28: aload_2
    //   29: aload_3
    //   30: invokevirtual 78	java/io/FileOutputStream:write	([B)V
    //   33: aload_2
    //   34: ifnull +7 -> 41
    //   37: aload_2
    //   38: invokevirtual 81	java/io/FileOutputStream:close	()V
    //   41: return
    //   42: astore_1
    //   43: aconst_null
    //   44: astore_2
    //   45: aload_2
    //   46: ifnull +7 -> 53
    //   49: aload_2
    //   50: invokevirtual 81	java/io/FileOutputStream:close	()V
    //   53: aload_1
    //   54: athrow
    //   55: astore_1
    //   56: goto -11 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	k
    //   0	59	1	paramString	String
    //   27	23	2	localFileOutputStream	java.io.FileOutputStream
    //   4	26	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   19	28	42	finally
    //   28	33	55	finally
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/c/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */