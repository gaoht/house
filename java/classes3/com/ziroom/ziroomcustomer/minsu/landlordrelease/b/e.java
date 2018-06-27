package com.ziroom.ziroomcustomer.minsu.landlordrelease.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.minsu.f.ab;
import com.ziroom.ziroomcustomer.minsu.f.d;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarCellView;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.c;

public class e
  extends c
{
  private int a = 0;
  
  public void makeCellView(CalendarCellView paramCalendarCellView)
  {
    View localView = ((LayoutInflater)paramCalendarCellView.getContext().getSystemService("layout_inflater")).inflate(2130904332, paramCalendarCellView);
    FrameLayout localFrameLayout = (FrameLayout)localView.findViewById(2131695218);
    SimpleDraweeView localSimpleDraweeView = (SimpleDraweeView)localView.findViewById(2131695295);
    if (this.a != 0)
    {
      localFrameLayout.getLayoutParams().height = this.a;
      int i = this.a - ab.dp2px(paramCalendarCellView.getContext(), 18.0F);
      localSimpleDraweeView.getLayoutParams().height = i;
      localSimpleDraweeView.getLayoutParams().width = i;
    }
    localSimpleDraweeView.setHierarchy(d.getRoundingHierarchy(paramCalendarCellView.getContext()));
    paramCalendarCellView.setDayOfMonthTextView((TextView)localView.findViewById(2131692246));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */