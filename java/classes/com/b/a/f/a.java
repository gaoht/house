package com.b.a.f;

import com.b.b.m;
import java.io.IOException;

public class a
{
  private final int a;
  private final int b;
  private final int c;
  private final int d;
  private final int e;
  private final int f;
  private final int g;
  private final int h;
  
  public a(byte[] paramArrayOfByte)
    throws h
  {
    if (paramArrayOfByte.length != 32) {
      throw new h("Invalid number of bytes");
    }
    paramArrayOfByte = new m(paramArrayOfByte);
    try
    {
      this.a = paramArrayOfByte.getInt32();
      this.b = paramArrayOfByte.getInt32();
      this.c = paramArrayOfByte.getInt32();
      this.d = paramArrayOfByte.getInt32();
      this.e = paramArrayOfByte.getInt32();
      this.f = paramArrayOfByte.getInt32();
      this.g = paramArrayOfByte.getInt32();
      this.h = paramArrayOfByte.getInt32();
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new h(paramArrayOfByte);
    }
  }
  
  public int getBlueX()
  {
    return this.g;
  }
  
  public int getBlueY()
  {
    return this.h;
  }
  
  public int getGreenX()
  {
    return this.e;
  }
  
  public int getGreenY()
  {
    return this.f;
  }
  
  public int getRedX()
  {
    return this.c;
  }
  
  public int getRedY()
  {
    return this.d;
  }
  
  public int getWhitePointX()
  {
    return this.a;
  }
  
  public int getWhitePointY()
  {
    return this.b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/a/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */