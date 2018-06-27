package com.ziroom.ziroomcustomer.newclean.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class RightAnimationView
  extends View
  implements ValueAnimator.AnimatorUpdateListener
{
  private Paint a;
  private Paint b;
  private Paint c;
  private float d = 4.0F;
  private Path e;
  private Path f;
  private PathMeasure g;
  private ValueAnimator h;
  private float i;
  private Boolean j = Boolean.valueOf(false);
  
  public RightAnimationView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public RightAnimationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public RightAnimationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private int a(float paramFloat)
  {
    return (int)(getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private void a()
  {
    this.d = a(this.d);
    this.b = new Paint();
    this.b.setColor(40960);
    this.b.setAlpha(40);
    this.b.setStrokeJoin(Paint.Join.ROUND);
    this.b.setStrokeCap(Paint.Cap.ROUND);
    this.c = new Paint();
    this.c.setColor(40960);
    this.c.setStyle(Paint.Style.STROKE);
    this.c.setAlpha(255);
    this.c.setStrokeWidth(a(0.5F));
    this.c.setStrokeJoin(Paint.Join.ROUND);
    this.c.setStrokeCap(Paint.Cap.ROUND);
    this.a = new Paint();
    this.a.setAntiAlias(true);
    this.a.setStrokeWidth(this.d);
    this.a.setStyle(Paint.Style.STROKE);
    this.a.setColor(40960);
    b();
  }
  
  private void b()
  {
    this.e = new Path();
    this.f = new Path();
    this.g = new PathMeasure();
    this.h = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.h.setDuration(400L);
    this.h.addUpdateListener(this);
    this.h.addListener(new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public void onAnimationEnd(Animator paramAnonymousAnimator) {}
      
      public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        RightAnimationView.a(RightAnimationView.this, Boolean.valueOf(true));
      }
    });
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (!this.j.booleanValue()) {
      return;
    }
    this.i = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (!this.j.booleanValue()) {
      this.h.start();
    }
    paramCanvas.drawCircle(getWidth() / 2, getWidth() / 2, getWidth() / 2 - this.c.getStrokeWidth(), this.b);
    paramCanvas.drawCircle(getWidth() / 2, getWidth() / 2, getWidth() / 2 - this.c.getStrokeWidth(), this.c);
    this.e.moveTo(getWidth() * 0.3409091F, getWidth() * 0.47727272F);
    this.e.lineTo(getWidth() * 0.46969697F, getWidth() * 0.6060606F);
    this.e.lineTo(getWidth() * 0.68939394F, getWidth() * 0.38636363F);
    this.f.reset();
    this.f.lineTo(0.0F, 0.0F);
    this.g.nextContour();
    this.g.setPath(this.e, false);
    this.g.getSegment(0.0F, this.i * this.g.getLength(), this.f, true);
    paramCanvas.drawPath(this.f, this.a);
  }
  
  public void setVisibility(int paramInt)
  {
    this.j = Boolean.valueOf(false);
    super.setVisibility(paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/view/RightAnimationView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */