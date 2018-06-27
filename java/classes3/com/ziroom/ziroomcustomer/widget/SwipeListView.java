package com.ziroom.ziroomcustomer.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ListView;
import com.ziroom.ziroomcustomer.R.styleable;

public class SwipeListView
  extends ListView
{
  private Boolean a;
  private View b;
  private View c;
  private float d;
  private float e;
  private int f;
  private final int g = 100;
  private final int h = 10;
  private boolean i;
  
  public SwipeListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwipeListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SwipeListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.swipelistviewstyle);
    this.f = ((int)paramContext.getDimension(0, 200.0F));
    paramContext.recycle();
  }
  
  private void a()
  {
    if (this.c != null) {
      this.c.setPressed(false);
    }
    setPressed(false);
    refreshDrawableState();
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    Message localMessage = new a().obtainMessage();
    localMessage.obj = paramView;
    localMessage.arg1 = paramView.getScrollX();
    localMessage.arg2 = this.f;
    localMessage.sendToTarget();
    this.i = true;
  }
  
  private boolean a(float paramFloat)
  {
    return paramFloat < getWidth() - this.f;
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    if ((Math.abs(paramFloat1) > 30.0F) && (Math.abs(paramFloat1) > Math.abs(paramFloat2) * 2.0F))
    {
      this.a = Boolean.valueOf(true);
      return true;
    }
    if ((Math.abs(paramFloat2) > 30.0F) && (Math.abs(paramFloat2) > Math.abs(paramFloat1) * 2.0F))
    {
      this.a = Boolean.valueOf(false);
      return true;
    }
    return false;
  }
  
  private void b(View paramView)
  {
    if (this.c == null) {
      return;
    }
    Message localMessage = new a().obtainMessage();
    localMessage.obj = paramView;
    localMessage.arg1 = paramView.getScrollX();
    localMessage.arg2 = 0;
    localMessage.sendToTarget();
    this.i = false;
  }
  
  public void deleteItem(View paramView)
  {
    b(paramView);
  }
  
  public int getRightViewWidth()
  {
    return this.f;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      this.a = null;
      this.d = f1;
      this.e = f2;
      int j = pointToPosition((int)this.d, (int)this.e);
      if (j >= 0)
      {
        View localView = getChildAt(j - getFirstVisiblePosition());
        this.b = this.c;
        this.c = localView;
        continue;
        float f3 = this.d;
        float f4 = this.e;
        if ((Math.abs(f1 - f3) >= 5.0F) && (Math.abs(f2 - f4) >= 5.0F))
        {
          return true;
          if ((this.i) && ((this.b != this.c) || (a(f1)))) {
            b(this.b);
          }
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    float f2 = paramMotionEvent.getX();
    float f1 = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    }
    label194:
    do
    {
      for (;;)
      {
        boolean bool1 = super.onTouchEvent(paramMotionEvent);
        do
        {
          do
          {
            return bool1;
            f2 -= this.d;
            float f3 = this.e;
            if ((this.a == null) && (!a(f2, f1 - f3))) {
              break;
            }
            if (!this.a.booleanValue()) {
              break label194;
            }
            if ((this.i) && (this.b != this.c)) {
              b(this.b);
            }
            f1 = f2;
            if (this.i)
            {
              f1 = f2;
              if (this.b == this.c) {
                f1 = f2 - this.f;
              }
            }
            bool1 = bool2;
          } while (f1 >= 0.0F);
          bool1 = bool2;
        } while (f1 <= -this.f);
        this.c.scrollTo((int)-f1, 0);
        return true;
        if (this.i) {
          b(this.b);
        }
      }
      a();
      if (this.i) {
        b(this.b);
      }
    } while ((this.a == null) || (!this.a.booleanValue()));
    if (this.d - f2 > this.f / 2)
    {
      a(this.c);
      return true;
    }
    b(this.c);
    return true;
  }
  
  public void setRightViewWidth(int paramInt)
  {
    this.f = paramInt;
  }
  
  @SuppressLint({"HandlerLeak"})
  class a
    extends Handler
  {
    int a = 0;
    int b;
    int c;
    View d;
    private boolean f = false;
    
    a() {}
    
    private void a()
    {
      this.f = false;
      this.a = 0;
    }
    
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      if (this.a == 0)
      {
        if (this.f) {
          return;
        }
        this.f = true;
        this.d = ((View)paramMessage.obj);
        this.b = paramMessage.arg1;
        this.c = paramMessage.arg2;
        this.a = ((int)((this.c - this.b) * 10 * 1.0D / 100.0D));
        if ((this.a < 0) && (this.a > -1)) {}
        for (this.a = -1; Math.abs(this.c - this.b) < 10; this.a = 1)
        {
          label96:
          this.d.scrollTo(this.c, 0);
          a();
          return;
          if ((this.a <= 0) || (this.a >= 1)) {
            break label96;
          }
        }
      }
      this.b += this.a;
      if (((this.a > 0) && (this.b > this.c)) || ((this.a < 0) && (this.b < this.c))) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          this.b = this.c;
        }
        this.d.scrollTo(this.b, 0);
        SwipeListView.this.invalidate();
        if (i != 0) {
          break;
        }
        sendEmptyMessageDelayed(0, 10L);
        return;
      }
      a();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/SwipeListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */