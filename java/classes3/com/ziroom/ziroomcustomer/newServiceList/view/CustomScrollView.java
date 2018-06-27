package com.ziroom.ziroomcustomer.newServiceList.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class CustomScrollView
  extends ScrollView
{
  private long a = 10L;
  private long b = -1L;
  private boolean c = true;
  private a d;
  private Runnable e = new Runnable()
  {
    public void run()
    {
      if (System.currentTimeMillis() - CustomScrollView.a(CustomScrollView.this) > 10L)
      {
        CustomScrollView.a(CustomScrollView.this, -1L);
        CustomScrollView.b(CustomScrollView.this);
        return;
      }
      CustomScrollView.this.postDelayed(this, CustomScrollView.c(CustomScrollView.this));
    }
  };
  private MotionEvent f;
  
  public CustomScrollView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CustomScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CustomScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    if (this.d != null) {
      this.d.scrollEnd();
    }
  }
  
  protected float getBottomFadingEdgeStrength()
  {
    if ((this.c) && (Build.VERSION.SDK_INT < 11)) {
      return 0.0F;
    }
    return super.getBottomFadingEdgeStrength();
  }
  
  public MotionEvent getEvent()
  {
    return this.f;
  }
  
  protected float getTopFadingEdgeStrength()
  {
    if ((this.c) && (Build.VERSION.SDK_INT < 11)) {
      return 0.0F;
    }
    return super.getTopFadingEdgeStrength();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    this.f = paramMotionEvent;
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.b == -1L)
    {
      if (this.d != null) {
        this.d.scrollStart();
      }
      postDelayed(this.e, this.a);
    }
    this.b = System.currentTimeMillis();
    if (this.d != null) {
      this.d.onScroll(paramInt1, paramInt2);
    }
  }
  
  public void setOnScrollChangedCallback(a parama)
  {
    this.d = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onScroll(int paramInt1, int paramInt2);
    
    public abstract void scrollEnd();
    
    public abstract void scrollStart();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/view/CustomScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */