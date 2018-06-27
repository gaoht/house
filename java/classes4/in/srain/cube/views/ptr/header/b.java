package in.srain.cube.views.ptr.header;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.util.Random;

public class b
  extends Animation
{
  public PointF a;
  public float b;
  public int c;
  private final Paint d = new Paint();
  private float e = 1.0F;
  private float f = 0.4F;
  private PointF g;
  private PointF h;
  
  public b(int paramInt1, PointF paramPointF1, PointF paramPointF2, int paramInt2, int paramInt3)
  {
    this.c = paramInt1;
    this.a = new PointF((paramPointF1.x + paramPointF2.x) / 2.0F, (paramPointF1.y + paramPointF2.y) / 2.0F);
    this.g = new PointF(paramPointF1.x - this.a.x, paramPointF1.y - this.a.y);
    this.h = new PointF(paramPointF2.x - this.a.x, paramPointF2.y - this.a.y);
    setColor(paramInt2);
    setLineWidth(paramInt3);
    this.d.setAntiAlias(true);
    this.d.setStyle(Paint.Style.STROKE);
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f1 = this.e;
    setAlpha(f1 + (this.f - f1) * paramFloat);
  }
  
  public void draw(Canvas paramCanvas)
  {
    paramCanvas.drawLine(this.g.x, this.g.y, this.h.x, this.h.y, this.d);
  }
  
  public void resetPosition(int paramInt)
  {
    this.b = (-new Random().nextInt(paramInt) + paramInt);
  }
  
  public void setAlpha(float paramFloat)
  {
    this.d.setAlpha((int)(255.0F * paramFloat));
  }
  
  public void setColor(int paramInt)
  {
    this.d.setColor(paramInt);
  }
  
  public void setLineWidth(int paramInt)
  {
    this.d.setStrokeWidth(paramInt);
  }
  
  public void start(float paramFloat1, float paramFloat2)
  {
    this.e = paramFloat1;
    this.f = paramFloat2;
    super.start();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/in/srain/cube/views/ptr/header/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */