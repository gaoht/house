package cn.testin.analysis;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;

public class ge
{
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)TypedValue.applyDimension(1, paramFloat, paramContext.getResources().getDisplayMetrics());
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    if (paramBitmap == null) {
      return null;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.setRotate(paramInt, paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
    float f2;
    if (paramInt == 90) {
      f2 = paramBitmap.getHeight();
    }
    for (float f1 = 0.0F;; f1 = paramBitmap.getWidth())
    {
      Object localObject = new float[9];
      localMatrix.getValues((float[])localObject);
      localMatrix.postTranslate(f2 - localObject[2], f1 - localObject[5]);
      localObject = Bitmap.createBitmap(paramBitmap.getHeight(), paramBitmap.getWidth(), Bitmap.Config.ARGB_8888);
      Paint localPaint = new Paint();
      new Canvas((Bitmap)localObject).drawBitmap(paramBitmap, localMatrix, localPaint);
      return (Bitmap)localObject;
      f2 = paramBitmap.getHeight();
    }
  }
  
  public static Point a(Context paramContext)
  {
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    Point localPoint = new Point();
    if (Build.VERSION.SDK_INT >= 13)
    {
      paramContext.getSize(localPoint);
      return localPoint;
    }
    localPoint.set(paramContext.getWidth(), paramContext.getHeight());
    return localPoint;
  }
  
  public static int b(Context paramContext, float paramFloat)
  {
    return (int)TypedValue.applyDimension(2, paramFloat, paramContext.getResources().getDisplayMetrics());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/ge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */