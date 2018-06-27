package com.baidu.trace.api.bos;

public class TextWatermarkCommand
{
  private String a;
  private int b = 9;
  private int c = 10;
  private int d = 10;
  private int e = 0;
  private int f = 30;
  private String g = "000000";
  private FontFamily h = FontFamily.SimSun;
  private FontStyle i = FontStyle.normal;
  
  public TextWatermarkCommand() {}
  
  public TextWatermarkCommand(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2, FontFamily paramFontFamily, FontStyle paramFontStyle)
  {
    this.a = paramString1;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
    this.f = paramInt5;
    this.g = paramString2;
    this.h = paramFontFamily;
    this.i = paramFontStyle;
  }
  
  public int getAngle()
  {
    return this.e;
  }
  
  public String getFontColor()
  {
    return this.g;
  }
  
  public FontFamily getFontFamily()
  {
    return this.h;
  }
  
  public int getFontSize()
  {
    return this.f;
  }
  
  public FontStyle getFontStyle()
  {
    return this.i;
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
  
  public String getText()
  {
    return this.a;
  }
  
  public void setAngle(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setFontColor(String paramString)
  {
    this.g = paramString;
  }
  
  public void setFontFamily(FontFamily paramFontFamily)
  {
    this.h = paramFontFamily;
  }
  
  public void setFontSize(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setFontStyle(FontStyle paramFontStyle)
  {
    this.i = paramFontStyle;
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
  
  public void setText(String paramString)
  {
    this.a = paramString;
  }
  
  public String toString()
  {
    return "TextWatermarkCommand [text=" + this.a + ", gravity=" + this.b + ", gravityX=" + this.c + ", gravityY=" + this.d + ", angle=" + this.e + ", fontSize=" + this.f + ", fontColor=" + this.g + ", fontFamily=" + this.h + ", fontStyle=" + this.i + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/bos/TextWatermarkCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */