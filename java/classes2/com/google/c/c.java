package com.google.c;

import com.google.c.a.a;

public final class c
{
  private final b a;
  private com.google.c.a.b b;
  
  public c(b paramb)
  {
    if (paramb == null) {
      throw new IllegalArgumentException("Binarizer must be non-null.");
    }
    this.a = paramb;
  }
  
  public c crop(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    h localh = this.a.getLuminanceSource().crop(paramInt1, paramInt2, paramInt3, paramInt4);
    return new c(this.a.createBinarizer(localh));
  }
  
  public com.google.c.a.b getBlackMatrix()
    throws j
  {
    if (this.b == null) {
      this.b = this.a.getBlackMatrix();
    }
    return this.b;
  }
  
  public a getBlackRow(int paramInt, a parama)
    throws j
  {
    return this.a.getBlackRow(paramInt, parama);
  }
  
  public int getHeight()
  {
    return this.a.getHeight();
  }
  
  public int getWidth()
  {
    return this.a.getWidth();
  }
  
  public boolean isCropSupported()
  {
    return this.a.getLuminanceSource().isCropSupported();
  }
  
  public boolean isRotateSupported()
  {
    return this.a.getLuminanceSource().isRotateSupported();
  }
  
  public c rotateCounterClockwise()
  {
    h localh = this.a.getLuminanceSource().rotateCounterClockwise();
    return new c(this.a.createBinarizer(localh));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */