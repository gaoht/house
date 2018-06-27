package com.baidu.mapapi.map;

import android.os.Bundle;

public class Tile
{
  public final byte[] data;
  public final int height;
  public final int width;
  
  public Tile(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.data = paramArrayOfByte;
  }
  
  public Bundle toBundle()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("image_width", this.width);
    localBundle.putInt("image_height", this.height);
    localBundle.putByteArray("image_data", this.data);
    return localBundle;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/map/Tile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */