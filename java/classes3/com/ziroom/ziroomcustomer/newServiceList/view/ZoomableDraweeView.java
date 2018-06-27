package com.ziroom.ziroomcustomer.newServiceList.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import com.facebook.drawee.view.SimpleDraweeView;

public class ZoomableDraweeView
  extends SimpleDraweeView
{
  private ScaleGestureDetector a;
  private GestureDetector b;
  private float c = 1.0F;
  private Matrix d;
  private float e;
  private float f;
  private a g;
  
  public ZoomableDraweeView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ZoomableDraweeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ZoomableDraweeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private RectF a(Matrix paramMatrix)
  {
    RectF localRectF = new RectF(getLeft(), getTop(), getRight(), getBottom());
    paramMatrix.mapRect(localRectF);
    return localRectF;
  }
  
  private void a()
  {
    this.d = new Matrix();
    Object localObject = new ScaleGestureDetector.SimpleOnScaleGestureListener()
    {
      public boolean onScale(ScaleGestureDetector paramAnonymousScaleGestureDetector)
      {
        float f = paramAnonymousScaleGestureDetector.getScaleFactor();
        ZoomableDraweeView.a(ZoomableDraweeView.this, ZoomableDraweeView.a(ZoomableDraweeView.this) * f);
        if (ZoomableDraweeView.b(ZoomableDraweeView.this) == 0.0F) {
          ZoomableDraweeView.b(ZoomableDraweeView.this, ZoomableDraweeView.this.getWidth() / 2.0F);
        }
        if (ZoomableDraweeView.c(ZoomableDraweeView.this) == 0.0F) {
          ZoomableDraweeView.c(ZoomableDraweeView.this, ZoomableDraweeView.this.getHeight() / 2.0F);
        }
        ZoomableDraweeView.d(ZoomableDraweeView.this).postScale(f, f, ZoomableDraweeView.b(ZoomableDraweeView.this), ZoomableDraweeView.c(ZoomableDraweeView.this));
        ZoomableDraweeView.this.invalidate();
        return true;
      }
      
      public void onScaleEnd(ScaleGestureDetector paramAnonymousScaleGestureDetector)
      {
        super.onScaleEnd(paramAnonymousScaleGestureDetector);
        if (ZoomableDraweeView.a(ZoomableDraweeView.this) < 1.0F) {
          ZoomableDraweeView.e(ZoomableDraweeView.this);
        }
        ZoomableDraweeView.f(ZoomableDraweeView.this);
      }
    };
    this.a = new ScaleGestureDetector(getContext(), (ScaleGestureDetector.OnScaleGestureListener)localObject);
    localObject = new GestureDetector.SimpleOnGestureListener()
    {
      public boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        if (ZoomableDraweeView.a(ZoomableDraweeView.this) > 1.0F)
        {
          ZoomableDraweeView.d(ZoomableDraweeView.this).postTranslate(-paramAnonymousFloat1, -paramAnonymousFloat2);
          ZoomableDraweeView.this.invalidate();
          ZoomableDraweeView.f(ZoomableDraweeView.this);
        }
        return true;
      }
      
      public boolean onSingleTapConfirmed(MotionEvent paramAnonymousMotionEvent)
      {
        if (ZoomableDraweeView.g(ZoomableDraweeView.this) != null) {
          ZoomableDraweeView.g(ZoomableDraweeView.this).onClick();
        }
        return true;
      }
    };
    this.b = new GestureDetector(getContext(), (GestureDetector.OnGestureListener)localObject);
  }
  
  private void b()
  {
    int j = 1;
    float f2 = 0.0F;
    RectF localRectF = a(this.d);
    float f1;
    int i;
    if (localRectF.left > 0.0F)
    {
      f1 = getLeft() - localRectF.left;
      i = 1;
    }
    for (;;)
    {
      if (localRectF.top > 0.0F)
      {
        f2 = getTop() - localRectF.top;
        i = 1;
      }
      if (localRectF.right < getRight())
      {
        f1 = getRight() - localRectF.right;
        i = 1;
      }
      if (localRectF.bottom < getHeight())
      {
        f2 = getHeight() - localRectF.bottom;
        i = j;
      }
      for (;;)
      {
        if (i != 0)
        {
          this.d.postTranslate(f1, f2);
          invalidate();
        }
        return;
      }
      i = 0;
      f1 = 0.0F;
    }
  }
  
  private void c()
  {
    this.d.reset();
    this.c = 1.0F;
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = paramCanvas.save();
    paramCanvas.concat(this.d);
    super.onDraw(paramCanvas);
    paramCanvas.restoreToCount(i);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.a.onTouchEvent(paramMotionEvent);
    if (!this.a.isInProgress()) {
      this.b.onTouchEvent(paramMotionEvent);
    }
    return true;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    c();
    super.setImageBitmap(paramBitmap);
  }
  
  public void setImageURI(Uri paramUri)
  {
    c();
    super.setImageURI(paramUri);
  }
  
  public void setOnClickListener(a parama)
  {
    this.g = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onClick();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/view/ZoomableDraweeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */