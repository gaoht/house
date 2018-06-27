package com.ziroom.ziroomcustomer.ziroomstation.widget.timessquare;

import android.view.ContextThemeWrapper;
import android.widget.TextView;

public class c
  implements b
{
  public void makeCellView(CalendarCellView paramCalendarCellView)
  {
    TextView localTextView = new TextView(new ContextThemeWrapper(paramCalendarCellView.getContext(), 2131427569));
    localTextView.setDuplicateParentStateEnabled(true);
    paramCalendarCellView.addView(localTextView);
    paramCalendarCellView.setDayOfMonthTextView(localTextView);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/widget/timessquare/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */