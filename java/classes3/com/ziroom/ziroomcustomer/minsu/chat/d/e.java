package com.ziroom.ziroomcustomer.minsu.chat.d;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

public class e
{
  private static e a = null;
  private LruCache<String, Bitmap> b = null;
  
  public static e getInstance()
  {
    try
    {
      if (a == null) {
        a = new e();
      }
      e locale = a;
      return locale;
    }
    finally {}
  }
  
  public Bitmap get(String paramString)
  {
    return (Bitmap)this.b.get(paramString);
  }
  
  public Bitmap put(String paramString, Bitmap paramBitmap)
  {
    return (Bitmap)this.b.put(paramString, paramBitmap);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/d/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */