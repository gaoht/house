package com.ziroom.ziroomcustomer.minsu.view.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class MatrixImageView
  extends ImageView
{
  private GestureDetector a;
  private Matrix b = new Matrix();
  private float c;
  private float d;
  private float e;
  private c f;
  private d g;
  
  public MatrixImageView(Context paramContext)
  {
    super(paramContext, null);
    paramContext = new b();
    setOnTouchListener(paramContext);
    this.a = new GestureDetector(getContext(), new a(paramContext));
    setBackgroundColor(-16777216);
    setScaleType(ImageView.ScaleType.FIT_CENTER);
  }
  
  public MatrixImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = new b();
    setOnTouchListener(paramContext);
    this.a = new GestureDetector(getContext(), new a(paramContext));
    setBackgroundColor(-16777216);
    setScaleType(ImageView.ScaleType.FIT_CENTER);
  }
  
  private void a()
  {
    this.b.set(getImageMatrix());
    float[] arrayOfFloat = new float[9];
    this.b.getValues(arrayOfFloat);
    this.c = (getWidth() / arrayOfFloat[0]);
    this.d = ((getHeight() - arrayOfFloat[5] * 2.0F) / arrayOfFloat[4]);
    this.e = arrayOfFloat[0];
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    if (getWidth() == 0)
    {
      getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public boolean onPreDraw()
        {
          MatrixImageView.a(MatrixImageView.this);
          MatrixImageView.this.getViewTreeObserver().removeOnPreDrawListener(this);
          return true;
        }
      });
      return;
    }
    a();
  }
  
  public void setOnMovingListener(c paramc)
  {
    this.f = paramc;
  }
  
  public void setOnSingleTapListener(d paramd)
  {
    this.g = paramd;
  }
  
  private class a
    extends GestureDetector.SimpleOnGestureListener
  {
    private final MatrixImageView.b b;
    
    public a(MatrixImageView.b paramb)
    {
      this.b = paramb;
    }
    
    public boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      this.b.onDoubleClick();
      return true;
    }
    
    public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
    {
      return super.onDoubleTapEvent(paramMotionEvent);
    }
    
    public boolean onDown(MotionEvent paramMotionEvent)
    {
      return true;
    }
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    
    public void onLongPress(MotionEvent paramMotionEvent)
    {
      super.onLongPress(paramMotionEvent);
    }
    
    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    
    public void onShowPress(MotionEvent paramMotionEvent)
    {
      super.onShowPress(paramMotionEvent);
    }
    
    public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      if (MatrixImageView.h(MatrixImageView.this) != null) {
        MatrixImageView.h(MatrixImageView.this).onSingleTap();
      }
      return super.onSingleTapConfirmed(paramMotionEvent);
    }
    
    public boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      return super.onSingleTapUp(paramMotionEvent);
    }
  }
  
  public class b
    implements View.OnTouchListener
  {
    float a = 6.0F;
    float b = 2.0F;
    boolean c;
    boolean d;
    boolean e = false;
    private int g = 0;
    private float h;
    private Matrix i = new Matrix();
    private PointF j = new PointF();
    
    public b() {}
    
    private float a(float[] paramArrayOfFloat, float paramFloat)
    {
      float f2 = MatrixImageView.this.getHeight();
      float f1;
      if (MatrixImageView.f(MatrixImageView.this) * paramArrayOfFloat[4] < f2) {
        f1 = 0.0F;
      }
      do
      {
        return f1;
        if (paramArrayOfFloat[5] + paramFloat > 0.0F) {
          return -paramArrayOfFloat[5];
        }
        f1 = paramFloat;
      } while (paramArrayOfFloat[5] + paramFloat >= -(MatrixImageView.f(MatrixImageView.this) * paramArrayOfFloat[4] - f2));
      return -(MatrixImageView.f(MatrixImageView.this) * paramArrayOfFloat[4] - f2) - paramArrayOfFloat[5];
    }
    
    private float a(float[] paramArrayOfFloat, float paramFloat1, float paramFloat2)
    {
      float f1 = MatrixImageView.this.getWidth();
      if ((!this.c) && (paramFloat1 < 0.0F))
      {
        if ((Math.abs(paramFloat1) * 0.4F > Math.abs(paramFloat2)) && (this.e)) {
          b();
        }
        paramFloat2 = 0.0F;
      }
      do
      {
        return paramFloat2;
        if ((!this.d) && (paramFloat1 > 0.0F))
        {
          if ((Math.abs(paramFloat1) * 0.4F > Math.abs(paramFloat2)) && (this.e)) {
            b();
          }
          return 0.0F;
        }
        this.c = true;
        this.d = true;
        if (this.e) {
          this.e = false;
        }
        if (MatrixImageView.d(MatrixImageView.this) * paramArrayOfFloat[0] < f1) {
          return 0.0F;
        }
        if (paramArrayOfFloat[2] + paramFloat1 > 0.0F) {
          return -paramArrayOfFloat[2];
        }
        paramFloat2 = paramFloat1;
      } while (paramArrayOfFloat[2] + paramFloat1 >= -(MatrixImageView.d(MatrixImageView.this) * paramArrayOfFloat[0] - f1));
      return -(MatrixImageView.d(MatrixImageView.this) * paramArrayOfFloat[0] - f1) - paramArrayOfFloat[2];
    }
    
    private PointF a(float paramFloat, float[] paramArrayOfFloat)
    {
      if ((paramArrayOfFloat[0] * paramFloat < MatrixImageView.e(MatrixImageView.this)) || (paramFloat >= 1.0F)) {
        return new PointF(MatrixImageView.this.getWidth() / 2, MatrixImageView.this.getHeight() / 2);
      }
      float f1 = MatrixImageView.this.getWidth() / 2;
      float f2 = MatrixImageView.this.getHeight() / 2;
      if ((MatrixImageView.this.getWidth() / 2 - paramArrayOfFloat[2]) * paramFloat < MatrixImageView.this.getWidth() / 2) {
        f1 = 0.0F;
      }
      if ((MatrixImageView.d(MatrixImageView.this) * paramArrayOfFloat[0] + paramArrayOfFloat[2]) * paramFloat < MatrixImageView.this.getWidth()) {
        f1 = MatrixImageView.this.getWidth();
      }
      return new PointF(f1, f2);
    }
    
    private void a()
    {
      if (MatrixImageView.c(MatrixImageView.this) != null) {
        MatrixImageView.c(MatrixImageView.this).startDrag();
      }
    }
    
    private void a(MotionEvent paramMotionEvent)
    {
      if (paramMotionEvent.getPointerCount() < 2) {}
      do
      {
        return;
        f1 = b(paramMotionEvent);
      } while (f1 <= 10.0F);
      float f2 = f1 / this.h;
      this.h = f1;
      this.i.set(MatrixImageView.this.getImageMatrix());
      paramMotionEvent = new float[9];
      this.i.getValues(paramMotionEvent);
      float f1 = b(f2, paramMotionEvent);
      paramMotionEvent = a(f1, paramMotionEvent);
      this.i.postScale(f1, f1, paramMotionEvent.x, paramMotionEvent.y);
      MatrixImageView.this.setImageMatrix(this.i);
    }
    
    private float b(float paramFloat, float[] paramArrayOfFloat)
    {
      float f1 = paramFloat;
      if (paramArrayOfFloat[0] * paramFloat > this.a) {
        f1 = this.a / paramArrayOfFloat[0];
      }
      return f1;
    }
    
    private float b(MotionEvent paramMotionEvent)
    {
      float f1 = paramMotionEvent.getX(1) - paramMotionEvent.getX(0);
      float f2 = paramMotionEvent.getY(1) - paramMotionEvent.getY(0);
      return (float)Math.sqrt(f1 * f1 + f2 * f2);
    }
    
    private void b()
    {
      if (MatrixImageView.c(MatrixImageView.this) != null) {
        MatrixImageView.c(MatrixImageView.this).stopDrag();
      }
    }
    
    private void c()
    {
      this.c = true;
      this.d = true;
      this.e = true;
      float[] arrayOfFloat = new float[9];
      MatrixImageView.this.getImageMatrix().getValues(arrayOfFloat);
      if (arrayOfFloat[2] >= 0.0F) {
        this.d = false;
      }
      float f1 = MatrixImageView.d(MatrixImageView.this);
      float f2 = arrayOfFloat[0];
      if (arrayOfFloat[2] + f1 * f2 <= MatrixImageView.this.getWidth()) {
        this.c = false;
      }
    }
    
    private boolean d()
    {
      boolean bool = false;
      float[] arrayOfFloat = new float[9];
      MatrixImageView.this.getImageMatrix().getValues(arrayOfFloat);
      if (arrayOfFloat[0] != MatrixImageView.e(MatrixImageView.this)) {
        bool = true;
      }
      return bool;
    }
    
    private void e()
    {
      if (f())
      {
        this.i.set(MatrixImageView.g(MatrixImageView.this));
        MatrixImageView.this.setImageMatrix(this.i);
      }
      float[] arrayOfFloat;
      float f1;
      do
      {
        do
        {
          return;
          arrayOfFloat = new float[9];
          MatrixImageView.this.getImageMatrix().getValues(arrayOfFloat);
          f1 = MatrixImageView.f(MatrixImageView.this) * arrayOfFloat[4];
        } while (f1 >= MatrixImageView.this.getHeight());
        f1 = (MatrixImageView.this.getHeight() - f1) / 2.0F;
      } while (f1 == arrayOfFloat[5]);
      this.i.set(MatrixImageView.this.getImageMatrix());
      this.i.postTranslate(0.0F, f1 - arrayOfFloat[5]);
      MatrixImageView.this.setImageMatrix(this.i);
    }
    
    private boolean f()
    {
      boolean bool = false;
      float[] arrayOfFloat = new float[9];
      MatrixImageView.this.getImageMatrix().getValues(arrayOfFloat);
      if (arrayOfFloat[0] < MatrixImageView.e(MatrixImageView.this)) {
        bool = true;
      }
      return bool;
    }
    
    private void g()
    {
      if (MatrixImageView.this.getScaleType() != ImageView.ScaleType.CENTER)
      {
        MatrixImageView.this.setScaleType(ImageView.ScaleType.MATRIX);
        return;
      }
      this.g = 3;
    }
    
    public void onDoubleClick()
    {
      if (d()) {}
      for (float f1 = 1.0F;; f1 = this.b)
      {
        this.i.set(MatrixImageView.g(MatrixImageView.this));
        this.i.postScale(f1, f1, MatrixImageView.this.getWidth() / 2, MatrixImageView.this.getHeight() / 2);
        MatrixImageView.this.setImageMatrix(this.i);
        return;
      }
    }
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      boolean bool = true;
      switch (paramMotionEvent.getActionMasked())
      {
      }
      for (;;)
      {
        bool = MatrixImageView.b(MatrixImageView.this).onTouchEvent(paramMotionEvent);
        do
        {
          return bool;
          this.g = 1;
          this.j.set(paramMotionEvent.getX(), paramMotionEvent.getY());
          g();
          a();
          c();
          break;
          e();
          b();
          break;
          if (this.g == 2)
          {
            a(paramMotionEvent);
            break;
          }
          if (this.g == 1)
          {
            setDragMatrix(paramMotionEvent);
            break;
          }
          b();
          break;
        } while (this.g == 3);
        this.g = 2;
        this.h = b(paramMotionEvent);
      }
    }
    
    public void setDragMatrix(MotionEvent paramMotionEvent)
    {
      if (d())
      {
        float f1 = paramMotionEvent.getX() - this.j.x;
        float f2 = paramMotionEvent.getY() - this.j.y;
        if (Math.sqrt(f1 * f1 + f2 * f2) > 10.0D)
        {
          this.j.set(paramMotionEvent.getX(), paramMotionEvent.getY());
          this.i.set(MatrixImageView.this.getImageMatrix());
          paramMotionEvent = new float[9];
          this.i.getValues(paramMotionEvent);
          f2 = a(paramMotionEvent, f2);
          f1 = a(paramMotionEvent, f1, f2);
          this.i.postTranslate(f1, f2);
          MatrixImageView.this.setImageMatrix(this.i);
        }
        return;
      }
      b();
    }
  }
  
  public static abstract interface c
  {
    public abstract void startDrag();
    
    public abstract void stopDrag();
  }
  
  public static abstract interface d
  {
    public abstract void onSingleTap();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/widget/MatrixImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */