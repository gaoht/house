package com.baidu.trace.api.bos;

public class ImageProcessCommand
{
  private int a = 0;
  private int b;
  private int c;
  private int d;
  private ImageFormat e = ImageFormat.jpg;
  private int f = 0;
  private ImageDisplay g = ImageDisplay.baseline;
  private boolean h = false;
  private boolean i = false;
  private int j = 0;
  private int k = 0;
  private int l;
  private int m;
  
  public ImageProcessCommand() {}
  
  public ImageProcessCommand(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ImageFormat paramImageFormat, int paramInt5, ImageDisplay paramImageDisplay, boolean paramBoolean1, boolean paramBoolean2, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramImageFormat;
    this.f = paramInt5;
    this.g = paramImageDisplay;
    this.h = paramBoolean1;
    this.i = paramBoolean2;
    this.j = paramInt6;
    this.k = paramInt7;
    this.l = paramInt8;
    this.m = paramInt9;
  }
  
  public int getAngle()
  {
    return this.f;
  }
  
  public int getCropHeight()
  {
    return this.m;
  }
  
  public int getCropWidth()
  {
    return this.l;
  }
  
  public ImageDisplay getDisplay()
  {
    return this.g;
  }
  
  public ImageFormat getFormat()
  {
    return this.e;
  }
  
  public int getMaxHeight()
  {
    return this.c;
  }
  
  public int getMaxWidth()
  {
    return this.b;
  }
  
  public int getOffsetX()
  {
    return this.j;
  }
  
  public int getOffsetY()
  {
    return this.k;
  }
  
  public int getQuality()
  {
    return this.d;
  }
  
  public int getScale()
  {
    return this.a;
  }
  
  public boolean isCrop()
  {
    return this.i;
  }
  
  public boolean isLimit()
  {
    return this.h;
  }
  
  public void setAngle(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setCrop(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void setCropHeight(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void setCropWidth(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void setDisplay(ImageDisplay paramImageDisplay)
  {
    this.g = paramImageDisplay;
  }
  
  public void setFormat(ImageFormat paramImageFormat)
  {
    this.e = paramImageFormat;
  }
  
  public void setLimit(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setOffsetX(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setOffsetY(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void setQuality(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setScale(int paramInt)
  {
    this.a = paramInt;
  }
  
  public String toString()
  {
    return "ImageProcessCommand [scale=" + this.a + ", maxWidth=" + this.b + ", maxHeight=" + this.c + ", quality=" + this.d + ", format=" + this.e + ", angle=" + this.f + ", display=" + this.g + ", limit=" + this.h + ", crop=" + this.i + ", offsetX=" + this.j + ", offsetY=" + this.k + ", cropWidth=" + this.l + ", cropHeight=" + this.m + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/bos/ImageProcessCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */