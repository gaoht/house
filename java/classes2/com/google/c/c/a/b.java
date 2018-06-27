package com.google.c.c.a;

final class b
{
  private final byte[] a;
  private int b;
  
  b(int paramInt)
  {
    this.a = new byte[paramInt];
    this.b = 0;
  }
  
  void a(int paramInt, boolean paramBoolean)
  {
    byte[] arrayOfByte = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      arrayOfByte[paramInt] = ((byte)i);
      return;
    }
  }
  
  void a(boolean paramBoolean, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      int j = this.b;
      this.b = (j + 1);
      a(j, paramBoolean);
      i += 1;
    }
  }
  
  byte[] a(int paramInt)
  {
    byte[] arrayOfByte = new byte[this.a.length * paramInt];
    int i = 0;
    while (i < arrayOfByte.length)
    {
      arrayOfByte[i] = this.a[(i / paramInt)];
      i += 1;
    }
    return arrayOfByte;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/c/c/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */