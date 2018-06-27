package com.mcxiaoke.packer.b.a;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public class g
{
  public static ByteBuffer readBlock(File paramFile, int paramInt)
    throws IOException
  {
    return e.readBlock(paramFile, paramInt);
  }
  
  public static byte[] readBytes(File paramFile, int paramInt)
    throws IOException
  {
    return e.readBytes(paramFile, paramInt);
  }
  
  public static void writeBlock(File paramFile, int paramInt, ByteBuffer paramByteBuffer)
    throws IOException
  {
    f.writeBlock(paramFile, paramInt, paramByteBuffer);
  }
  
  public static void writeBlock(File paramFile, int paramInt, byte[] paramArrayOfByte)
    throws IOException
  {
    f.writeBlock(paramFile, paramInt, paramArrayOfByte);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mcxiaoke/packer/b/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */