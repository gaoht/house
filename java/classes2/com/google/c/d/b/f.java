package com.google.c.d.b;

import com.google.c.d.a.a;

public final class f
{
  private com.google.c.d.a.b a = null;
  private a b = null;
  private int c = -1;
  private int d = -1;
  private int e = -1;
  private int f = -1;
  private int g = -1;
  private int h = -1;
  private int i = -1;
  private b j = null;
  
  public static boolean isValidMaskPattern(int paramInt)
  {
    return (paramInt >= 0) && (paramInt < 8);
  }
  
  public int at(int paramInt1, int paramInt2)
  {
    paramInt1 = this.j.get(paramInt1, paramInt2);
    if ((paramInt1 != 0) && (paramInt1 != 1)) {
      throw new IllegalStateException("Bad value");
    }
    return paramInt1;
  }
  
  public a getECLevel()
  {
    return this.b;
  }
  
  public int getMaskPattern()
  {
    return this.e;
  }
  
  public b getMatrix()
  {
    return this.j;
  }
  
  public int getMatrixWidth()
  {
    return this.d;
  }
  
  public com.google.c.d.a.b getMode()
  {
    return this.a;
  }
  
  public int getNumDataBytes()
  {
    return this.g;
  }
  
  public int getNumECBytes()
  {
    return this.h;
  }
  
  public int getNumRSBlocks()
  {
    return this.i;
  }
  
  public int getNumTotalBytes()
  {
    return this.f;
  }
  
  public int getVersion()
  {
    return this.c;
  }
  
  public boolean isValid()
  {
    return (this.a != null) && (this.b != null) && (this.c != -1) && (this.d != -1) && (this.e != -1) && (this.f != -1) && (this.g != -1) && (this.h != -1) && (this.i != -1) && (isValidMaskPattern(this.e)) && (this.f == this.g + this.h) && (this.j != null) && (this.d == this.j.getWidth()) && (this.j.getWidth() == this.j.getHeight());
  }
  
  public void setECLevel(a parama)
  {
    this.b = parama;
  }
  
  public void setMaskPattern(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setMatrix(b paramb)
  {
    this.j = paramb;
  }
  
  public void setMatrixWidth(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setMode(com.google.c.d.a.b paramb)
  {
    this.a = paramb;
  }
  
  public void setNumDataBytes(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setNumECBytes(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void setNumRSBlocks(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void setNumTotalBytes(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setVersion(int paramInt)
  {
    this.c = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(200);
    localStringBuilder.append("<<\n");
    localStringBuilder.append(" mode: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\n ecLevel: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("\n version: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("\n matrixWidth: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append("\n maskPattern: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append("\n numTotalBytes: ");
    localStringBuilder.append(this.f);
    localStringBuilder.append("\n numDataBytes: ");
    localStringBuilder.append(this.g);
    localStringBuilder.append("\n numECBytes: ");
    localStringBuilder.append(this.h);
    localStringBuilder.append("\n numRSBlocks: ");
    localStringBuilder.append(this.i);
    if (this.j == null) {
      localStringBuilder.append("\n matrix: null\n");
    }
    for (;;)
    {
      localStringBuilder.append(">>\n");
      return localStringBuilder.toString();
      localStringBuilder.append("\n matrix:\n");
      localStringBuilder.append(this.j.toString());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/c/d/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */