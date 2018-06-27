package com.baidu.mapapi.map;

import android.util.Log;
import java.util.HashSet;

class t
  implements Runnable
{
  t(TileOverlay paramTileOverlay, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void run()
  {
    Tile localTile = ((FileTileProvider)TileOverlay.a(this.e)).getTile(this.a, this.b, this.c);
    if (localTile != null) {
      if ((localTile.height == 256) && (localTile.height == 256))
      {
        String str = this.a + "_" + this.b + "_" + this.c;
        TileOverlay.a(this.e, str, localTile);
      }
    }
    for (;;)
    {
      TileOverlay.b(this.e).remove(this.d);
      return;
      Log.e(TileOverlay.c(), "FileTile pic must be 256 * 256");
      continue;
      Log.e(TileOverlay.c(), "FileTile pic is null");
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/map/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */