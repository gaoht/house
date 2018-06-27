package com.airbnb.lottie;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.io.Closeable;

final class ch
{
  private static final PathMeasure a = new PathMeasure();
  private static final Path b = new Path();
  private static final Path c = new Path();
  private static DisplayMetrics d;
  private static final float[] e = new float[4];
  private static final float f = (float)Math.sqrt(2.0D);
  
  static float a(Matrix paramMatrix)
  {
    e[0] = 0.0F;
    e[1] = 0.0F;
    e[2] = f;
    e[3] = f;
    paramMatrix.mapPoints(e);
    float f1 = e[2];
    float f2 = e[0];
    float f3 = e[3];
    float f4 = e[1];
    return (float)Math.hypot(f1 - f2, f3 - f4) / 2.0F;
  }
  
  static int a(Context paramContext)
  {
    if (d == null) {
      d = new DisplayMetrics();
    }
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(d);
    return d.widthPixels;
  }
  
  static Path a(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3, PointF paramPointF4)
  {
    Path localPath = new Path();
    localPath.moveTo(paramPointF1.x, paramPointF1.y);
    if ((paramPointF3 != null) && (paramPointF4 != null) && ((paramPointF3.length() != 0.0F) || (paramPointF4.length() != 0.0F)))
    {
      localPath.cubicTo(paramPointF1.x + paramPointF3.x, paramPointF1.y + paramPointF3.y, paramPointF2.x + paramPointF4.x, paramPointF2.y + paramPointF4.y, paramPointF2.x, paramPointF2.y);
      return localPath;
    }
    localPath.lineTo(paramPointF2.x, paramPointF2.y);
    return localPath;
  }
  
  static void a(Path paramPath, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    a.setPath(paramPath, false);
    float f2 = a.getLength();
    if ((paramFloat1 == 1.0F) && (paramFloat2 == 0.0F)) {}
    while ((f2 == 0.0F) || (Math.abs(paramFloat2 - paramFloat1 - 1.0F) < 0.01D)) {
      return;
    }
    float f1 = f2 * paramFloat1;
    paramFloat2 = f2 * paramFloat2;
    paramFloat1 = Math.min(f1, paramFloat2);
    f1 = Math.max(f1, paramFloat2);
    paramFloat3 *= f2;
    paramFloat2 = paramFloat1 + paramFloat3;
    f1 += paramFloat3;
    paramFloat3 = paramFloat2;
    paramFloat1 = f1;
    if (paramFloat2 >= f2)
    {
      paramFloat3 = paramFloat2;
      paramFloat1 = f1;
      if (f1 >= f2)
      {
        paramFloat3 = bd.a(paramFloat2, f2);
        paramFloat1 = bd.a(f1, f2);
      }
    }
    paramFloat2 = paramFloat3;
    if (paramFloat3 < 0.0F) {
      paramFloat2 = bd.a(paramFloat3, f2);
    }
    paramFloat3 = paramFloat1;
    if (paramFloat1 < 0.0F) {
      paramFloat3 = bd.a(paramFloat1, f2);
    }
    if (paramFloat2 == paramFloat3)
    {
      paramPath.reset();
      return;
    }
    paramFloat1 = paramFloat2;
    if (paramFloat2 >= paramFloat3) {
      paramFloat1 = paramFloat2 - f2;
    }
    b.reset();
    a.getSegment(paramFloat1, paramFloat3, b, true);
    if (paramFloat3 > f2)
    {
      c.reset();
      a.getSegment(0.0F, paramFloat3 % f2, c, true);
      b.addPath(c);
    }
    for (;;)
    {
      paramPath.set(b);
      return;
      if (paramFloat1 < 0.0F)
      {
        c.reset();
        a.getSegment(paramFloat1 + f2, f2, c, true);
        b.addPath(c);
      }
    }
  }
  
  static void a(Path paramPath, cg paramcg)
  {
    if (paramcg == null) {
      return;
    }
    a(paramPath, ((Float)paramcg.getStart().getValue()).floatValue() / 100.0F, ((Float)paramcg.getEnd().getValue()).floatValue() / 100.0F, ((Float)paramcg.getOffset().getValue()).floatValue() / 360.0F);
  }
  
  static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (RuntimeException paramCloseable)
    {
      throw paramCloseable;
    }
    catch (Exception paramCloseable) {}
  }
  
  static int b(Context paramContext)
  {
    if (d == null) {
      d = new DisplayMetrics();
    }
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(d);
    return d.heightPixels;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/ch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */