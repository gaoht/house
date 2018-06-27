package com.baidu.trace.api.bos;

public class ImageWatermarkCommand
{
  private String a;
  private int b = 9;
  private int c = 10;
  private int d = 10;
  private int e = 0;
  private int f = 100;
  
  public ImageWatermarkCommand() {}
  
  public ImageWatermarkCommand(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.a = paramString;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
    this.f = paramInt5;
  }
  
  public int getAngle()
  {
    return this.e;
  }
  
  public int getGravity()
  {
    return this.b;
  }
  
  public int getGravityX()
  {
    return this.c;
  }
  
  public int getGravityY()
  {
    return this.d;
  }
  
  public String getObjectKey()
  {
    return this.a;
  }
  
  public int getOpacity()
  {
    return this.f;
  }
  
  public void setAngle(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setGravity(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setGravityX(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setGravityY(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setObjectKey(String paramString)
  {
    this.a = paramString;
  }
  
  public void setOpacity(int paramInt)
  {
    this.f = paramInt;
  }
  
  public String toString()
  {
    return "ImageWatermarkCommand [objectKey=" + this.a + ", gravity=" + this.b + ", gravityX=" + this.c + ", gravityY=" + this.d + ", angle=" + this.e + ", opacity=" + this.f + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/bos/ImageWatermarkCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */