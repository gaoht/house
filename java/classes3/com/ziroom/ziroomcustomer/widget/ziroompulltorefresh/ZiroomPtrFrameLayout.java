package com.ziroom.ziroomcustomer.widget.ziroompulltorefresh;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import in.srain.cube.views.ptr.a.a;

public class ZiroomPtrFrameLayout
  extends PtrFrameLayout
{
  private a e;
  private PtrFrameLayout.a f;
  private Paint g;
  private float h;
  private boolean i = false;
  private boolean j = false;
  private int k = -16777216;
  private float l = -1.0F;
  private a m;
  
  public ZiroomPtrFrameLayout(Context paramContext)
  {
    super(paramContext);
    e();
  }
  
  public ZiroomPtrFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    e();
  }
  
  public ZiroomPtrFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    e();
  }
  
  private void e()
  {
    setWillNotDraw(false);
    this.f = getScrollChecker();
    this.e = getPtrIndicator();
    this.g = new Paint(1);
    this.g.setColor(this.k);
    this.g.setAntiAlias(true);
    this.g.setAlpha(0);
    this.g.setStyle(Paint.Style.FILL);
  }
  
  protected void a(boolean paramBoolean, byte paramByte, a parama)
  {
    super.a(paramBoolean, paramByte, parama);
    if (this.m != null) {
      this.m.onPositionChange(parama.getCurrentPosY(), parama.getHeaderHeight());
    }
    if (this.j)
    {
      this.h = (parama.getCurrentPosY() / parama.getHeaderHeight());
      if (this.h > 0.8D) {
        this.h = 0.8F;
      }
      invalidate();
    }
  }
  
  public void completeRefresh()
  {
    scrollToTop();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    float f1;
    if (getHeaderView() != null)
    {
      f1 = this.e.getCurrentPosY();
      if (paramMotionEvent.getAction() == 1)
      {
        if (!getFixHeader()) {
          break label82;
        }
        if ((!a(paramMotionEvent.getX(paramMotionEvent.getActionIndex()), paramMotionEvent.getY(paramMotionEvent.getActionIndex()), getHeaderView())) || (this.i))
        {
          setFixHeader(false);
          scrollToTop();
        }
      }
    }
    return bool;
    label82:
    if (this.l <= 0.0F) {
      this.l = (getHeaderView().getHeight() / 2);
    }
    if (f1 < this.l)
    {
      setFixHeader(false);
      scrollToTop();
      return bool;
    }
    setFixHeader(true);
    scrollTo(getHeaderView().getHeight());
    this.f.tryToScrollTo(this.e.getHeaderHeight(), (int)getDurationToCloseHeader());
    return bool;
  }
  
  public float getmDividingLine()
  {
    return this.l;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.g.setAlpha((int)(255.0F * this.h));
    paramCanvas.drawRect(0.0F, this.e.getCurrentPosY(), getWidth(), getHeight(), this.g);
    getChildAt(0).setAlpha(1.0F - this.h);
  }
  
  public void scrollTo(int paramInt)
  {
    this.f.tryToScrollTo(paramInt, (int)getDurationToCloseHeader());
  }
  
  public void scrollToTop()
  {
    this.f.tryToScrollTo(0, (int)getDurationToCloseHeader());
  }
  
  public void setmDividingLine(float paramFloat)
  {
    this.l = paramFloat;
  }
  
  public void setmIsAlphaCanChange(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void setmIsAutoToTop(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void setmOnPositionChangeListener(a parama)
  {
    this.m = parama;
  }
  
  public void setmPaintColor(int paramInt)
  {
    this.k = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void onPositionChange(float paramFloat1, float paramFloat2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/ziroompulltorefresh/ZiroomPtrFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */