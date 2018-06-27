package android.support.v4.graphics;

import android.graphics.Paint;
import android.os.Build.VERSION;

public final class PaintCompat
{
  public static boolean hasGlyph(Paint paramPaint, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramPaint.hasGlyph(paramString);
    }
    return PaintCompatApi14.hasGlyph(paramPaint, paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v4/graphics/PaintCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */