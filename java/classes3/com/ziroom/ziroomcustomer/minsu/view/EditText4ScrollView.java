package com.ziroom.ziroomcustomer.minsu.view;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;

public class EditText4ScrollView
  extends AppCompatEditText
{
  private final int a = 20;
  private int b;
  private boolean c = false;
  private boolean d = false;
  private float e = 0.0F;
  
  public EditText4ScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  public EditText4ScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public EditText4ScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.c = false;
      this.d = false;
      this.e = 0.0F;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.b = (getLayout().getHeight() + getTotalPaddingTop() + getTotalPaddingBottom() - getHeight());
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.d = true;
    if ((paramInt2 == this.b) || (paramInt2 == 0))
    {
      getParent().requestDisallowInterceptTouchEvent(false);
      this.c = true;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    if (!this.c) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    if (paramMotionEvent.getAction() == 2)
    {
      if (this.e == 0.0F) {
        this.e = paramMotionEvent.getRawY();
      }
      if ((Math.abs(this.e - paramMotionEvent.getRawY()) > 20.0F) && (!this.d)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
    return bool;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/EditText4ScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */