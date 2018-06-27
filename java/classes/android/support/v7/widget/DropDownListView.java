package android.support.v7.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.support.v7.appcompat.R.attr;
import android.view.MotionEvent;
import android.view.View;

class DropDownListView
  extends ListViewCompat
{
  private boolean g;
  private boolean h;
  private boolean i;
  private ViewPropertyAnimatorCompat j;
  private ListViewAutoScrollHelper k;
  
  public DropDownListView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, null, R.attr.dropDownListViewStyle);
    this.h = paramBoolean;
    setCacheColorHint(0);
  }
  
  private void a(View paramView, int paramInt)
  {
    performItemClick(paramView, paramInt, getItemIdAtPosition(paramInt));
  }
  
  private void a(View paramView, int paramInt, float paramFloat1, float paramFloat2)
  {
    this.i = true;
    if (Build.VERSION.SDK_INT >= 21) {
      drawableHotspotChanged(paramFloat1, paramFloat2);
    }
    if (!isPressed()) {
      setPressed(true);
    }
    layoutChildren();
    if (this.f != -1)
    {
      View localView = getChildAt(this.f - getFirstVisiblePosition());
      if ((localView != null) && (localView != paramView) && (localView.isPressed())) {
        localView.setPressed(false);
      }
    }
    this.f = paramInt;
    float f1 = paramView.getLeft();
    float f2 = paramView.getTop();
    if (Build.VERSION.SDK_INT >= 21) {
      paramView.drawableHotspotChanged(paramFloat1 - f1, paramFloat2 - f2);
    }
    if (!paramView.isPressed()) {
      paramView.setPressed(true);
    }
    a(paramInt, paramView, paramFloat1, paramFloat2);
    setSelectorEnabled(false);
    refreshDrawableState();
  }
  
  private void d()
  {
    this.i = false;
    setPressed(false);
    drawableStateChanged();
    View localView = getChildAt(this.f - getFirstVisiblePosition());
    if (localView != null) {
      localView.setPressed(false);
    }
    if (this.j != null)
    {
      this.j.cancel();
      this.j = null;
    }
  }
  
  protected boolean a()
  {
    return (this.i) || (super.a());
  }
  
  public boolean hasFocus()
  {
    return (this.h) || (super.hasFocus());
  }
  
  public boolean hasWindowFocus()
  {
    return (this.h) || (super.hasWindowFocus());
  }
  
  public boolean isFocused()
  {
    return (this.h) || (super.isFocused());
  }
  
  public boolean isInTouchMode()
  {
    return ((this.h) && (this.g)) || (super.isInTouchMode());
  }
  
  public boolean onForwardedEvent(MotionEvent paramMotionEvent, int paramInt)
  {
    int m = paramMotionEvent.getActionMasked();
    switch (m)
    {
    default: 
      paramInt = 0;
    case 3: 
      for (bool = true;; bool = false)
      {
        label37:
        if ((!bool) || (paramInt != 0)) {
          d();
        }
        if (!bool) {
          break;
        }
        if (this.k == null) {
          this.k = new ListViewAutoScrollHelper(this);
        }
        this.k.setEnabled(true);
        this.k.onTouch(this, paramMotionEvent);
        label93:
        return bool;
        paramInt = 0;
      }
    }
    for (boolean bool = false;; bool = true)
    {
      int n = paramMotionEvent.findPointerIndex(paramInt);
      if (n < 0)
      {
        paramInt = 0;
        bool = false;
        break label37;
      }
      paramInt = (int)paramMotionEvent.getX(n);
      n = (int)paramMotionEvent.getY(n);
      int i1 = pointToPosition(paramInt, n);
      if (i1 == -1)
      {
        paramInt = 1;
        break label37;
      }
      View localView = getChildAt(i1 - getFirstVisiblePosition());
      a(localView, i1, paramInt, n);
      if (m != 1) {
        break;
      }
      a(localView, i1);
      break;
      if (this.k == null) {
        break label93;
      }
      this.k.setEnabled(false);
      return bool;
    }
  }
  
  void setListSelectionHidden(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/DropDownListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */