package com.ziroom.ziroomcustomer.ziroomstation.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.ziroomstation.widget.timessquare.CalendarCellView;
import com.ziroom.ziroomcustomer.ziroomstation.widget.timessquare.CalendarPickerView;
import com.ziroom.ziroomcustomer.ziroomstation.widget.timessquare.a;
import com.ziroom.ziroomcustomer.ziroomstation.widget.timessquare.e.a;
import java.util.Date;
import java.util.List;

public class o
  implements a
{
  private CalendarPickerView a;
  private Context b;
  
  public o(Context paramContext, CalendarPickerView paramCalendarPickerView)
  {
    this.b = paramContext;
    this.a = paramCalendarPickerView;
  }
  
  public void decorate(CalendarCellView paramCalendarCellView, Date paramDate)
  {
    if (((paramCalendarCellView.isToday()) || (paramCalendarCellView.isTomorrow()) || (paramCalendarCellView.isAfterTomorrow())) && (paramCalendarCellView.isCurrentMonth())) {
      if (paramCalendarCellView.isSelected())
      {
        paramCalendarCellView.getDayOfMonthTextView().setTextColor(-1);
        paramCalendarCellView.getDayOfMonthTextView().setBackgroundResource(2130837707);
        if (paramCalendarCellView.isToday()) {
          paramCalendarCellView.getDayOfMonthTextView().setText(2131296750);
        }
        if (paramCalendarCellView.isTomorrow()) {
          paramCalendarCellView.getDayOfMonthTextView().setText(2131296751);
        }
        if (paramCalendarCellView.isAfterTomorrow()) {
          paramCalendarCellView.getDayOfMonthTextView().setText(2131296749);
        }
        label100:
        Object localObject = this.a.getSelectedDates();
        if ((localObject == null) || (((List)localObject).size() != 1)) {
          break label341;
        }
        localObject = (Date)((List)localObject).get(0);
        if ((!paramCalendarCellView.isSelectable()) || (((Date)localObject).getDate() != paramDate.getDate()) || (((Date)localObject).getMonth() != paramDate.getMonth()) || (((Date)localObject).getYear() != paramDate.getYear())) {
          break label328;
        }
        paramCalendarCellView.findViewById(2131693638).setVisibility(0);
        ((TextView)paramCalendarCellView.findViewById(2131693638)).setText("入住");
      }
    }
    for (;;)
    {
      paramCalendarCellView.setBackgroundResource(2131624349);
      return;
      paramCalendarCellView.getDayOfMonthTextView().setTextColor(-15822871);
      paramCalendarCellView.getDayOfMonthTextView().setBackgroundResource(2131624349);
      break;
      if (paramCalendarCellView.isCurrentMonth())
      {
        if (paramCalendarCellView.isSelectable())
        {
          if (paramCalendarCellView.isSelected())
          {
            paramCalendarCellView.getDayOfMonthTextView().setTextColor(-1);
            paramCalendarCellView.getDayOfMonthTextView().setBackgroundResource(2130837707);
            break label100;
          }
          paramCalendarCellView.getDayOfMonthTextView().setTextColor(-15658735);
          paramCalendarCellView.getDayOfMonthTextView().setBackgroundResource(2131624349);
          break label100;
        }
        paramCalendarCellView.getDayOfMonthTextView().setTextColor(-7829368);
        paramCalendarCellView.getDayOfMonthTextView().setBackgroundResource(2131624349);
        break label100;
      }
      paramCalendarCellView.getDayOfMonthTextView().setTextColor(-1);
      paramCalendarCellView.getDayOfMonthTextView().setBackgroundResource(2131624349);
      break label100;
      label328:
      paramCalendarCellView.findViewById(2131693638).setVisibility(4);
      continue;
      label341:
      if (e.a.b == paramCalendarCellView.getRangeState())
      {
        paramCalendarCellView.findViewById(2131693638).setVisibility(0);
        ((TextView)paramCalendarCellView.findViewById(2131693638)).setText("入住");
      }
      else if (e.a.d == paramCalendarCellView.getRangeState())
      {
        paramCalendarCellView.findViewById(2131693638).setVisibility(0);
        ((TextView)paramCalendarCellView.findViewById(2131693638)).setText("离店");
      }
      else
      {
        paramCalendarCellView.findViewById(2131693638).setVisibility(4);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/adapter/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */