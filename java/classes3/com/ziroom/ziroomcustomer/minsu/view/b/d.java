package com.ziroom.ziroomcustomer.minsu.view.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.g;
import android.view.View;

public class d
  extends RecyclerView.g
{
  private static final int[] a = { 16843284 };
  private Drawable b;
  private int c;
  
  public d(Context paramContext, int paramInt)
  {
    this.b = paramContext.getResources().getDrawable(2130838386);
    setOrientation(paramInt);
  }
  
  public d(Context paramContext, int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    }
    for (this.b = paramContext.getResources().getDrawable(2130838386);; this.b = paramContext.getResources().getDrawable(2130838385))
    {
      setOrientation(paramInt1);
      return;
    }
  }
  
  public void drawHorizontal(Canvas paramCanvas, RecyclerView paramRecyclerView)
  {
    int j = paramRecyclerView.getPaddingTop();
    int k = paramRecyclerView.getHeight();
    int m = paramRecyclerView.getPaddingBottom();
    int n = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < n)
    {
      View localView = paramRecyclerView.getChildAt(i);
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
      int i1 = localView.getRight();
      i1 = localLayoutParams.rightMargin + i1;
      int i2 = this.b.getIntrinsicHeight();
      this.b.setBounds(i1, j, i2 + i1, k - m);
      this.b.draw(paramCanvas);
      i += 1;
    }
  }
  
  public void drawVertical(Canvas paramCanvas, RecyclerView paramRecyclerView)
  {
    int j = paramRecyclerView.getPaddingLeft();
    int k = paramRecyclerView.getWidth();
    int m = paramRecyclerView.getPaddingRight();
    int n = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < n)
    {
      View localView = paramRecyclerView.getChildAt(i);
      new RecyclerView(paramRecyclerView.getContext());
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
      int i1 = localView.getBottom();
      i1 = localLayoutParams.bottomMargin + i1;
      int i2 = this.b.getIntrinsicHeight();
      this.b.setBounds(j, i1, k - m, i2 + i1);
      this.b.draw(paramCanvas);
      i += 1;
    }
  }
  
  public void getItemOffsets(Rect paramRect, int paramInt, RecyclerView paramRecyclerView)
  {
    if (this.c == 1)
    {
      paramRect.set(0, 0, 0, this.b.getIntrinsicHeight());
      return;
    }
    paramRect.set(0, 0, this.b.getIntrinsicWidth(), 0);
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView)
  {
    if (this.c == 1)
    {
      drawVertical(paramCanvas, paramRecyclerView);
      return;
    }
    drawHorizontal(paramCanvas, paramRecyclerView);
  }
  
  public void setOrientation(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      throw new IllegalArgumentException("invalid orientation");
    }
    this.c = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */