package com.superrtc.a;

public class d
{
  public static float getZoomScale(int paramInt1, int paramInt2, int paramInt3)
  {
    float f;
    if ((paramInt1 > paramInt2) && (paramInt1 > paramInt3)) {
      f = paramInt1 / paramInt3;
    }
    for (;;)
    {
      if (f <= 0.0F)
      {
        return 1.0F;
        if ((paramInt1 < paramInt2) && (paramInt2 > paramInt3)) {
          f = paramInt2 / paramInt3;
        }
      }
      else
      {
        return f;
      }
      f = 1.0F;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */