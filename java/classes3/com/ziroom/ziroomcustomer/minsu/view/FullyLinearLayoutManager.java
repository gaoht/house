package com.ziroom.ziroomcustomer.minsu.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.r;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

public class FullyLinearLayoutManager
  extends LinearLayoutManager
{
  private static final String a = FullyLinearLayoutManager.class.getSimpleName();
  private int[] b = new int[2];
  
  public FullyLinearLayoutManager(Context paramContext)
  {
    super(paramContext);
  }
  
  public FullyLinearLayoutManager(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramInt, paramBoolean);
  }
  
  private void a(RecyclerView.n paramn, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    try
    {
      View localView = paramn.getViewForPosition(0);
      if (localView != null)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
        localView.measure(ViewGroup.getChildMeasureSpec(paramInt2, getPaddingLeft() + getPaddingRight(), localLayoutParams.width), ViewGroup.getChildMeasureSpec(paramInt3, getPaddingTop() + getPaddingBottom(), localLayoutParams.height));
        paramArrayOfInt[0] = (localView.getMeasuredWidth() + localLayoutParams.leftMargin + localLayoutParams.rightMargin);
        paramInt1 = localView.getMeasuredHeight();
        paramInt2 = localLayoutParams.bottomMargin;
        paramArrayOfInt[1] = (localLayoutParams.topMargin + (paramInt1 + paramInt2));
        paramn.recycleView(localView);
      }
      return;
    }
    catch (Exception paramn)
    {
      paramn = paramn;
      paramn.printStackTrace();
      return;
    }
    finally {}
  }
  
  public void onMeasure(RecyclerView.n paramn, RecyclerView.r paramr, int paramInt1, int paramInt2)
  {
    int n = View.MeasureSpec.getMode(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt2);
    int k = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt2);
    Log.i(a, "onMeasure called. \nwidthMode " + n + " \nheightMode " + paramInt2 + " \nwidthSize " + k + " \nheightSize " + j + " \ngetItemCount() " + getItemCount());
    int i = 0;
    paramInt1 = 0;
    paramInt2 = 0;
    if (i < getItemCount())
    {
      a(paramn, i, View.MeasureSpec.makeMeasureSpec(i, 0), View.MeasureSpec.makeMeasureSpec(i, 0), this.b);
      if (getOrientation() == 0)
      {
        paramInt2 += this.b[0];
        if (i != 0) {
          break label264;
        }
        paramInt1 = this.b[1];
      }
    }
    label264:
    for (;;)
    {
      i += 1;
      break;
      paramInt1 = this.b[1] + paramInt1;
      if (i == 0)
      {
        paramInt2 = this.b[0];
        continue;
        switch (n)
        {
        default: 
          switch (m)
          {
          }
          break;
        }
        for (;;)
        {
          setMeasuredDimension(paramInt2, paramInt1);
          return;
          paramInt2 = k;
          break;
          paramInt1 = j;
        }
      }
      else {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/FullyLinearLayoutManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */