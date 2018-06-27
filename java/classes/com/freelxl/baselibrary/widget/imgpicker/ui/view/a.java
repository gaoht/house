package com.freelxl.baselibrary.widget.imgpicker.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.g;
import android.support.v7.widget.RecyclerView.r;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import com.freelxl.baselibrary.R.drawable;

public class a
  extends RecyclerView.g
{
  private Drawable a;
  
  public a(Context paramContext)
  {
    this.a = paramContext.getResources().getDrawable(R.drawable.recycle_divider);
  }
  
  private int a(RecyclerView paramRecyclerView)
  {
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if ((paramRecyclerView instanceof GridLayoutManager)) {
      return ((GridLayoutManager)paramRecyclerView).getSpanCount();
    }
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager)) {
      return ((StaggeredGridLayoutManager)paramRecyclerView).getSpanCount();
    }
    return -1;
  }
  
  private boolean a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if ((paramRecyclerView instanceof GridLayoutManager))
    {
      if ((paramInt1 + 1) % paramInt2 == 0) {
        return true;
      }
    }
    else if ((paramRecyclerView instanceof StaggeredGridLayoutManager)) {
      if (((StaggeredGridLayoutManager)paramRecyclerView).getOrientation() == 1)
      {
        if ((paramInt1 + 1) % paramInt2 == 0) {
          return true;
        }
      }
      else if (paramInt1 >= paramInt3 - paramInt3 % paramInt2) {
        return true;
      }
    }
    return false;
  }
  
  private boolean b(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if ((paramRecyclerView instanceof GridLayoutManager))
    {
      if (paramInt1 >= paramInt3 - paramInt3 % paramInt2) {
        return true;
      }
    }
    else if ((paramRecyclerView instanceof StaggeredGridLayoutManager)) {
      if (((StaggeredGridLayoutManager)paramRecyclerView).getOrientation() == 1)
      {
        if (paramInt1 >= paramInt3 - paramInt3 % paramInt2) {
          return true;
        }
      }
      else if ((paramInt1 + 1) % paramInt2 == 0) {
        return true;
      }
    }
    return false;
  }
  
  public void drawHorizontal(Canvas paramCanvas, RecyclerView paramRecyclerView)
  {
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = paramRecyclerView.getChildAt(i);
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
      int k = localView.getLeft();
      int m = localLayoutParams.leftMargin;
      int n = localView.getRight();
      int i1 = localLayoutParams.rightMargin;
      int i2 = this.a.getIntrinsicWidth();
      int i3 = localView.getBottom();
      i3 = localLayoutParams.bottomMargin + i3;
      int i4 = this.a.getIntrinsicHeight();
      this.a.setBounds(k - m, i3, n + i1 + i2, i4 + i3);
      this.a.draw(paramCanvas);
      i += 1;
    }
  }
  
  public void drawVertical(Canvas paramCanvas, RecyclerView paramRecyclerView)
  {
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = paramRecyclerView.getChildAt(i);
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
      int k = localView.getTop();
      int m = localLayoutParams.topMargin;
      int n = localView.getBottom();
      int i1 = localLayoutParams.bottomMargin;
      int i2 = localView.getRight();
      i2 = localLayoutParams.rightMargin + i2;
      int i3 = this.a.getIntrinsicWidth();
      this.a.setBounds(i2, k - m, i3 + i2, n + i1);
      this.a.draw(paramCanvas);
      i += 1;
    }
  }
  
  public void getItemOffsets(Rect paramRect, int paramInt, RecyclerView paramRecyclerView)
  {
    int i = a(paramRecyclerView);
    int j = paramRecyclerView.getAdapter().getItemCount();
    if (b(paramRecyclerView, paramInt, i, j))
    {
      paramRect.set(0, 0, this.a.getIntrinsicWidth(), 0);
      return;
    }
    if (a(paramRecyclerView, paramInt, i, j))
    {
      paramRect.set(0, 0, 0, this.a.getIntrinsicHeight());
      return;
    }
    paramRect.set(0, 0, this.a.getIntrinsicWidth(), this.a.getIntrinsicHeight());
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.r paramr)
  {
    drawHorizontal(paramCanvas, paramRecyclerView);
    drawVertical(paramCanvas, paramRecyclerView);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/widget/imgpicker/ui/view/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */