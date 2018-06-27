package com.freelxl.baselibrary.widget.imgpicker.a;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

public class c
  implements a
{
  private static final long b = Runtime.getRuntime().maxMemory() / 1024L;
  private static final int c = (int)b / 8;
  private LruCache<String, Bitmap> a = new LruCache(c)
  {
    protected int a(String paramAnonymousString, Bitmap paramAnonymousBitmap)
    {
      return paramAnonymousBitmap.getRowBytes() * paramAnonymousBitmap.getHeight() / 1024;
    }
  };
  
  public Bitmap get(String paramString)
  {
    return (Bitmap)this.a.get(paramString);
  }
  
  public void put(String paramString, Bitmap paramBitmap)
  {
    if (this.a.get(paramString) == null) {
      this.a.put(paramString, paramBitmap);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/widget/imgpicker/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */