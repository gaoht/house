package com.ziroom.ziroomcustomer.minsu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarCellView;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.c;
import com.ziroom.ziroomcustomer.util.ac;

public class r
  extends c
{
  public void makeCellView(CalendarCellView paramCalendarCellView)
  {
    View localView = ((LayoutInflater)paramCalendarCellView.getContext().getSystemService("layout_inflater")).inflate(2130904287, paramCalendarCellView);
    FrameLayout localFrameLayout = (FrameLayout)localView.findViewById(2131695218);
    int i = ac.getScreenWidth(ApplicationEx.c);
    localFrameLayout.getLayoutParams().height = (i / 7);
    paramCalendarCellView.setDayOfMonthTextView((TextView)localView.findViewById(2131692246));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/adapter/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */