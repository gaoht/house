package com.google.c.d.a;

public enum a
{
  private static final a[] e = { b, a, d, c };
  private final int f;
  
  private a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public static a forBits(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= e.length)) {
      throw new IllegalArgumentException();
    }
    return e[paramInt];
  }
  
  public int getBits()
  {
    return this.f;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/c/d/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */