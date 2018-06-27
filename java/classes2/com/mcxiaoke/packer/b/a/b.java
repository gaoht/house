package com.mcxiaoke.packer.b.a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

class b
{
  private final int a;
  private final ByteBuffer b;
  
  b(int paramInt, ByteBuffer paramByteBuffer)
  {
    this.a = paramInt;
    if (paramByteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
      throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
    }
    this.b = paramByteBuffer;
  }
  
  public byte[] getByteBuffer()
  {
    byte[] arrayOfByte = this.b.array();
    int i = this.b.arrayOffset();
    return Arrays.copyOfRange(arrayOfByte, this.b.position() + i, i + this.b.limit());
  }
  
  public int getId()
  {
    return this.a;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mcxiaoke/packer/b/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */