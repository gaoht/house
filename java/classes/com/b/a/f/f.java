package com.b.a.f;

import com.b.b.m;
import com.b.b.n;
import java.io.IOException;

public class f
{
  private int a;
  private int b;
  private byte c;
  private e d;
  private byte e;
  private byte f;
  private byte g;
  
  public f(byte[] paramArrayOfByte)
    throws h
  {
    if (paramArrayOfByte.length != 13) {
      throw new h("PNG header chunk must have 13 data bytes");
    }
    paramArrayOfByte = new m(paramArrayOfByte);
    e locale;
    try
    {
      this.a = paramArrayOfByte.getInt32();
      this.b = paramArrayOfByte.getInt32();
      this.c = paramArrayOfByte.getInt8();
      int i = paramArrayOfByte.getInt8();
      locale = e.fromNumericValue(i);
      if (locale == null) {
        throw new h("Unexpected PNG color type: " + i);
      }
    }
    catch (IOException paramArrayOfByte)
    {
      throw new h(paramArrayOfByte);
    }
    this.d = locale;
    this.e = paramArrayOfByte.getInt8();
    this.f = paramArrayOfByte.getInt8();
    this.g = paramArrayOfByte.getInt8();
  }
  
  public byte getBitsPerSample()
  {
    return this.c;
  }
  
  public e getColorType()
  {
    return this.d;
  }
  
  public byte getCompressionType()
  {
    return this.e;
  }
  
  public byte getFilterMethod()
  {
    return this.f;
  }
  
  public int getImageHeight()
  {
    return this.b;
  }
  
  public int getImageWidth()
  {
    return this.a;
  }
  
  public byte getInterlaceMethod()
  {
    return this.g;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/a/f/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */