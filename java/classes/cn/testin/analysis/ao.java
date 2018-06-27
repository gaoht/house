package cn.testin.analysis;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.LruCache;

class ao
  extends LruCache<String, Drawable>
{
  ao(an paraman, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(String paramString, Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable))
    {
      paramString = ((BitmapDrawable)paramDrawable).getBitmap();
      int i = paramString.getRowBytes();
      return paramString.getHeight() * i / 1024;
    }
    return super.sizeOf(paramString, paramDrawable);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */