package com.ziroom.ziroomcustomer.social.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.g;
import android.support.v7.widget.RecyclerView.r;
import android.view.View;
import com.ziroom.ziroomcustomer.util.ah;

public class b
  extends RecyclerView.g
{
  private int a;
  private Paint b = new Paint();
  
  public b(Context paramContext)
  {
    this.b.setColor(paramContext.getResources().getColor(2131624047));
    this.a = ah.dip2px(paramContext, 0.5F);
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.r paramr)
  {
    super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramr);
    paramRect.bottom = this.a;
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.r paramr)
  {
    int j = paramRecyclerView.getChildCount();
    int k = paramRecyclerView.getPaddingLeft();
    int m = paramRecyclerView.getWidth();
    int n = paramRecyclerView.getPaddingRight();
    int i = 0;
    while (i < j - 1)
    {
      paramr = paramRecyclerView.getChildAt(i);
      float f1 = paramr.getBottom();
      float f2 = paramr.getBottom() + this.a;
      paramCanvas.drawRect(k, f1, m - n, f2, this.b);
      i += 1;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/view/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */