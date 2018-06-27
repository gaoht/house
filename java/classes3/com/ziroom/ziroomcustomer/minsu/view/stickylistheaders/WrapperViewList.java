package com.ziroom.ziroomcustomer.minsu.view.stickylistheaders;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

class WrapperViewList
  extends ListView
{
  private a a;
  private List<View> b;
  private int c;
  private Rect d = new Rect();
  private Field e;
  private boolean f = true;
  private boolean g = false;
  
  public WrapperViewList(Context paramContext)
  {
    super(paramContext);
    try
    {
      paramContext = AbsListView.class.getDeclaredField("mSelectorRect");
      paramContext.setAccessible(true);
      this.d = ((Rect)paramContext.get(this));
      if (Build.VERSION.SDK_INT >= 14)
      {
        this.e = AbsListView.class.getDeclaredField("mSelectorPosition");
        this.e.setAccessible(true);
      }
      return;
    }
    catch (NoSuchFieldException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    catch (IllegalArgumentException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    catch (IllegalAccessException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private void b()
  {
    if (!this.d.isEmpty())
    {
      int i = c();
      if (i >= 0)
      {
        Object localObject = getChildAt(i - a());
        if ((localObject instanceof WrapperView))
        {
          localObject = (WrapperView)localObject;
          Rect localRect = this.d;
          i = ((WrapperView)localObject).getTop();
          localRect.top = (((WrapperView)localObject).e + i);
        }
      }
    }
  }
  
  private void b(View paramView)
  {
    if (this.b == null) {
      this.b = new ArrayList();
    }
    this.b.add(paramView);
  }
  
  private int c()
  {
    int i;
    if (this.e == null)
    {
      i = 0;
      while (i < getChildCount())
      {
        if (getChildAt(i).getBottom() == this.d.bottom) {
          return i + a();
        }
        i += 1;
      }
    }
    try
    {
      i = this.e.getInt(this);
      return i;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localIllegalArgumentException.printStackTrace();
      return -1;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        localIllegalAccessException.printStackTrace();
      }
    }
  }
  
  int a()
  {
    int j = getFirstVisiblePosition();
    if (Build.VERSION.SDK_INT >= 11) {
      return j;
    }
    int i = 0;
    if (i < getChildCount()) {
      if (getChildAt(i).getBottom() >= 0) {
        i += j;
      }
    }
    for (;;)
    {
      j = i;
      if (!this.f)
      {
        j = i;
        if (getPaddingTop() > 0)
        {
          j = i;
          if (i > 0)
          {
            j = i;
            if (getChildAt(0).getTop() > 0) {
              j = i - 1;
            }
          }
        }
      }
      return j;
      i += 1;
      break;
      i = j;
    }
  }
  
  void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  void a(a parama)
  {
    this.a = parama;
  }
  
  boolean a(View paramView)
  {
    if (this.b == null) {
      return false;
    }
    return this.b.contains(paramView);
  }
  
  public void addFooterView(View paramView)
  {
    super.addFooterView(paramView);
    b(paramView);
  }
  
  public void addFooterView(View paramView, Object paramObject, boolean paramBoolean)
  {
    super.addFooterView(paramView, paramObject, paramBoolean);
    b(paramView);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    b();
    if (this.c != 0)
    {
      paramCanvas.save();
      Rect localRect = paramCanvas.getClipBounds();
      localRect.top = this.c;
      paramCanvas.clipRect(localRect);
      super.dispatchDraw(paramCanvas);
      paramCanvas.restore();
    }
    for (;;)
    {
      this.a.onDispatchDrawOccurred(paramCanvas);
      return;
      super.dispatchDraw(paramCanvas);
    }
  }
  
  protected void layoutChildren()
  {
    if (!this.g) {
      super.layoutChildren();
    }
  }
  
  public boolean performItemClick(View paramView, int paramInt, long paramLong)
  {
    View localView = paramView;
    if ((paramView instanceof WrapperView)) {
      localView = ((WrapperView)paramView).a;
    }
    return super.performItemClick(localView, paramInt, paramLong);
  }
  
  public boolean removeFooterView(View paramView)
  {
    if (super.removeFooterView(paramView))
    {
      this.b.remove(paramView);
      return true;
    }
    return false;
  }
  
  public void setBlockLayoutChildren(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void setClipToPadding(boolean paramBoolean)
  {
    this.f = paramBoolean;
    super.setClipToPadding(paramBoolean);
  }
  
  static abstract interface a
  {
    public abstract void onDispatchDrawOccurred(Canvas paramCanvas);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/stickylistheaders/WrapperViewList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */