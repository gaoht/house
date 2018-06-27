package com.baidu.mapapi.map;

import android.os.Bundle;

public final class Stroke
{
  public final int color;
  public final int strokeWidth;
  
  public Stroke(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 <= 0) {
      i = 5;
    }
    this.strokeWidth = i;
    this.color = paramInt2;
  }
  
  Bundle a(Bundle paramBundle)
  {
    paramBundle.putInt("width", this.strokeWidth);
    Overlay.a(this.color, paramBundle);
    return paramBundle;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/map/Stroke.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */