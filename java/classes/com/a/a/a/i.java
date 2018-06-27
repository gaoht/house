package com.a.a.a;

import com.a.a.c;

class i
{
  private String a;
  private int b = 0;
  
  public i(String paramString)
  {
    this.a = paramString;
  }
  
  public char ch()
  {
    if (this.b < this.a.length()) {
      return this.a.charAt(this.b);
    }
    return '\000';
  }
  
  public char ch(int paramInt)
  {
    if (paramInt < this.a.length()) {
      return this.a.charAt(paramInt);
    }
    return '\000';
  }
  
  public int gatherInt(String paramString, int paramInt)
    throws c
  {
    int j = ch(this.b);
    int k = 0;
    int i = 0;
    while ((48 <= j) && (j <= 57))
    {
      this.b += 1;
      int m = ch(this.b);
      i = i * 10 + (j - 48);
      k = 1;
      j = m;
    }
    if (k != 0)
    {
      if (i > paramInt) {
        return paramInt;
      }
      if (i < 0) {
        return 0;
      }
      return i;
    }
    throw new c(paramString, 5);
  }
  
  public boolean hasNext()
  {
    return this.b < this.a.length();
  }
  
  public int length()
  {
    return this.a.length();
  }
  
  public int pos()
  {
    return this.b;
  }
  
  public void skip()
  {
    this.b += 1;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/a/a/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */