package com.google.c;

public abstract class h
{
  private final int a;
  private final int b;
  
  public h crop(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    throw new UnsupportedOperationException("This luminance source does not support cropping.");
  }
  
  public final int getHeight()
  {
    return this.b;
  }
  
  public abstract byte[] getMatrix();
  
  public abstract byte[] getRow(int paramInt, byte[] paramArrayOfByte);
  
  public final int getWidth()
  {
    return this.a;
  }
  
  public boolean isCropSupported()
  {
    return false;
  }
  
  public boolean isRotateSupported()
  {
    return false;
  }
  
  public h rotateCounterClockwise()
  {
    throw new UnsupportedOperationException("This luminance source does not support rotation.");
  }
  
  public String toString()
  {
    byte[] arrayOfByte = new byte[this.a];
    StringBuilder localStringBuilder = new StringBuilder(this.b * (this.a + 1));
    int i = 0;
    while (i < this.b)
    {
      arrayOfByte = getRow(i, arrayOfByte);
      int j = 0;
      if (j < this.a)
      {
        int k = arrayOfByte[j] & 0xFF;
        char c;
        if (k < 64) {
          c = '#';
        }
        for (;;)
        {
          localStringBuilder.append(c);
          j += 1;
          break;
          if (k < 128) {
            c = '+';
          } else if (k < 192) {
            c = '.';
          } else {
            c = ' ';
          }
        }
      }
      localStringBuilder.append('\n');
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/c/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */