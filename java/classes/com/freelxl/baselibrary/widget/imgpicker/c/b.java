package com.freelxl.baselibrary.widget.imgpicker.c;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.support.v4.util.LruCache;

public class b
{
  private LruCache<String, Integer> a = new LruCache(20);
  
  public static b getInstance()
  {
    return a.a();
  }
  
  public int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = 1;
    if ((paramInt1 == 0) || (paramInt2 == 0)) {}
    int j;
    int k;
    do
    {
      return 1;
      j = paramOptions.outHeight;
      k = paramOptions.outWidth;
      paramOptions = paramInt1 + "#" + paramInt2 + "#" + k + "#" + j;
    } while ((j <= paramInt2) && (k <= paramInt1));
    if (this.a.get(paramOptions) != null) {
      return ((Integer)this.a.get(paramOptions)).intValue();
    }
    j /= 2;
    k /= 2;
    while ((j / i >= paramInt2) || (k / i >= paramInt1)) {
      i *= 2;
    }
    this.a.put(paramOptions, Integer.valueOf(i));
    return i;
  }
  
  public Bitmap decodeSampleBitmapFromFile(String paramString, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    localOptions.inSampleSize = calculateInSampleSize(localOptions, paramInt1, paramInt2);
    localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
    localOptions.inJustDecodeBounds = false;
    return BitmapFactory.decodeFile(paramString, localOptions);
  }
  
  private static class a
  {
    private static b a = new b(null);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/widget/imgpicker/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */