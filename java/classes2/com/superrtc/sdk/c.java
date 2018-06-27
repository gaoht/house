package com.superrtc.sdk;

public class c
{
  private int[] a = { 0, 0, 0, 0, 0 };
  private int[] b = { 0, 0, 0, 0, 0 };
  private int[] c = { 0, 0, 0, 0, 0 };
  private int[] d = { 0, 0, 0, 0, 0 };
  
  public void addaudiopackslost(int paramInt1, int paramInt2)
  {
    int i = 2;
    while (i != 0)
    {
      this.c[i] = this.c[(i - 1)];
      this.d[i] = this.d[(i - 1)];
      i -= 1;
    }
    this.d[0] = paramInt1;
    this.c[0] = paramInt2;
  }
  
  public void addvideopackslost(int paramInt1, int paramInt2)
  {
    int i = 2;
    while (i != 0)
    {
      this.a[i] = this.a[(i - 1)];
      this.b[i] = this.b[(i - 1)];
      i -= 1;
    }
    this.b[0] = paramInt1;
    this.a[0] = paramInt2;
  }
  
  public int getaudiopackslostrate()
  {
    float f = 0.0F;
    int i = 0;
    if (i < 3)
    {
      if (this.d[i] == 0) {}
      for (;;)
      {
        i += 1;
        break;
        f += this.c[i] * 100 / this.d[i];
      }
    }
    return (int)f / 3;
  }
  
  public int getvideopackslostrate()
  {
    float f = 0.0F;
    int i = 0;
    if (i < 3)
    {
      if (this.b[i] == 0) {}
      for (;;)
      {
        i += 1;
        break;
        f += this.a[i] * 100 / this.b[i];
      }
    }
    return (int)f / 3;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/sdk/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */