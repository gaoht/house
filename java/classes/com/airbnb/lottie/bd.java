package com.airbnb.lottie;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.List;

class bd
{
  static double a(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    return (paramDouble2 - paramDouble1) * paramDouble3 + paramDouble1;
  }
  
  static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat2 - paramFloat1) * paramFloat3 + paramFloat1;
  }
  
  static int a(float paramFloat1, float paramFloat2)
  {
    return a((int)paramFloat1, (int)paramFloat2);
  }
  
  static int a(int paramInt1, int paramInt2)
  {
    return paramInt1 - b(paramInt1, paramInt2) * paramInt2;
  }
  
  static int a(int paramInt1, int paramInt2, float paramFloat)
  {
    return (int)(paramInt1 + (paramInt2 - paramInt1) * paramFloat);
  }
  
  static PointF a(PointF paramPointF1, PointF paramPointF2)
  {
    return new PointF(paramPointF1.x + paramPointF2.x, paramPointF1.y + paramPointF2.y);
  }
  
  static void a(bs parambs, Path paramPath)
  {
    paramPath.reset();
    PointF localPointF1 = parambs.a();
    paramPath.moveTo(localPointF1.x, localPointF1.y);
    localPointF1 = new PointF(localPointF1.x, localPointF1.y);
    int i = 0;
    if (i < parambs.c().size())
    {
      Object localObject = (z)parambs.c().get(i);
      PointF localPointF2 = ((z)localObject).a();
      PointF localPointF3 = ((z)localObject).b();
      localObject = ((z)localObject).c();
      if ((localPointF2.equals(localPointF1)) && (localPointF3.equals(localObject))) {
        paramPath.lineTo(((PointF)localObject).x, ((PointF)localObject).y);
      }
      for (;;)
      {
        localPointF1.set(((PointF)localObject).x, ((PointF)localObject).y);
        i += 1;
        break;
        paramPath.cubicTo(localPointF2.x, localPointF2.y, localPointF3.x, localPointF3.y, ((PointF)localObject).x, ((PointF)localObject).y);
      }
    }
    if (parambs.b()) {
      paramPath.close();
    }
  }
  
  static float b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.max(paramFloat2, Math.min(paramFloat3, paramFloat1));
  }
  
  private static int b(int paramInt1, int paramInt2)
  {
    int j = paramInt1 / paramInt2;
    int i = j;
    if ((paramInt1 ^ paramInt2) < 0)
    {
      i = j;
      if (j * paramInt2 != paramInt1) {
        i = j - 1;
      }
    }
    return i;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/airbnb/lottie/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */