package com.ziroom.ziroomcustomer.ziroomstation.projectdetail.view;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v4.util.ArrayMap;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.minsu.view.MinsuDelTextView;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarCellView;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.ziroomstation.projectdetail.b.a.a.a.a;
import java.util.Date;
import java.util.Map;

public class a
  implements com.ziroom.ziroomcustomer.minsu.view.timessquare.a
{
  private Map<String, a.a.a.a> a = new ArrayMap();
  private final int b = 14;
  private final int c = 11;
  private final int d = ApplicationEx.c.getResources().getColor(2131624042);
  private final int e = ApplicationEx.c.getResources().getColor(2131624039);
  private final int f = ApplicationEx.c.getResources().getColor(2131624046);
  private final int g = ApplicationEx.c.getResources().getColor(2131624046);
  private final int h = ApplicationEx.c.getResources().getColor(2131624583);
  
  public a(Activity paramActivity, Map<String, a.a.a.a> paramMap, InventoryCalendarPickerView paramInventoryCalendarPickerView)
  {
    if (paramMap != null)
    {
      this.a.clear();
      this.a.putAll(paramMap);
    }
  }
  
  private SpannableString a(a.a.a.a parama, Date paramDate)
  {
    return a(parama, paramDate, this.f, this.g, 14, 11);
  }
  
  private SpannableString a(a.a.a.a parama, Date paramDate, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    String str2 = a(paramDate);
    String str1 = "";
    paramDate = str1;
    if (parama != null)
    {
      paramDate = str1;
      if (parama.getStatus() == 2) {
        paramDate = "满房";
      }
    }
    parama = new SpannableString(str2 + "\n" + paramDate);
    parama.setSpan(new AbsoluteSizeSpan(paramInt3, true), 0, str2.length(), 17);
    parama.setSpan(new ForegroundColorSpan(paramInt1), 0, str2.length(), 33);
    parama.setSpan(new AbsoluteSizeSpan(paramInt4, true), str2.length(), parama.toString().length(), 17);
    parama.setSpan(new ForegroundColorSpan(paramInt2), str2.length(), parama.toString().length(), 33);
    return parama;
  }
  
  private String a(Date paramDate)
  {
    return Integer.toString(paramDate.getDate());
  }
  
  private void a(CalendarCellView paramCalendarCellView, Date paramDate)
  {
    if (this.a == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = m.getFormatDate(paramDate, m.b);
        localObject = (a.a.a.a)this.a.get(localObject);
        if (!paramCalendarCellView.isCurrentMonth()) {
          break;
        }
      } while (localObject == null);
      if (paramCalendarCellView.isToday())
      {
        a(paramCalendarCellView, paramDate, (a.a.a.a)localObject);
        return;
      }
      if (((a.a.a.a)localObject).getStatus() == 0)
      {
        d(paramCalendarCellView, paramDate, (a.a.a.a)localObject);
        return;
      }
      if (((a.a.a.a)localObject).getStatus() == 1)
      {
        c(paramCalendarCellView, paramDate, (a.a.a.a)localObject);
        return;
      }
    } while (((a.a.a.a)localObject).getStatus() != 2);
    b(paramCalendarCellView, paramDate, (a.a.a.a)localObject);
    return;
    paramCalendarCellView.getDayOfMonthTextView().setBackgroundColor(this.h);
    paramCalendarCellView.getDayOfMonthTextView().setText("");
    a(paramCalendarCellView, false);
  }
  
  private void a(CalendarCellView paramCalendarCellView, Date paramDate, a.a.a.a parama)
  {
    if ((parama != null) && (parama.getStatus() == 2)) {
      a(paramCalendarCellView, true);
    }
    for (paramDate = a(parama, paramDate);; paramDate = b(parama, paramDate))
    {
      paramCalendarCellView.getDayOfMonthTextView().setBackgroundResource(2130837812);
      paramCalendarCellView.getDayOfMonthTextView().setText(paramDate);
      return;
      a(paramCalendarCellView, false);
    }
  }
  
  private void a(CalendarCellView paramCalendarCellView, boolean paramBoolean)
  {
    if ((paramCalendarCellView == null) || (paramCalendarCellView.getDayOfMonthTextView() == null) || (!(paramCalendarCellView.getDayOfMonthTextView() instanceof MinsuDelTextView))) {
      return;
    }
    ((MinsuDelTextView)paramCalendarCellView.getDayOfMonthTextView()).setmIsShowDel(paramBoolean);
  }
  
  private SpannableString b(a.a.a.a parama, Date paramDate)
  {
    return a(parama, paramDate, this.e, this.d, 14, 11);
  }
  
  private void b(CalendarCellView paramCalendarCellView, Date paramDate, a.a.a.a parama)
  {
    paramDate = a(parama, paramDate);
    a(paramCalendarCellView, true);
    paramCalendarCellView.getDayOfMonthTextView().setBackgroundColor(this.h);
    paramCalendarCellView.getDayOfMonthTextView().setText(paramDate);
  }
  
  private void c(CalendarCellView paramCalendarCellView, Date paramDate, a.a.a.a parama)
  {
    paramDate = b(parama, paramDate);
    a(paramCalendarCellView, false);
    paramCalendarCellView.getDayOfMonthTextView().setBackgroundColor(this.h);
    paramCalendarCellView.getDayOfMonthTextView().setText(paramDate);
  }
  
  private void d(CalendarCellView paramCalendarCellView, Date paramDate, a.a.a.a parama)
  {
    paramDate = a(parama, paramDate);
    a(paramCalendarCellView, false);
    paramCalendarCellView.getDayOfMonthTextView().setBackgroundColor(this.h);
    paramCalendarCellView.getDayOfMonthTextView().setText(paramDate);
  }
  
  public void decorate(CalendarCellView paramCalendarCellView, Date paramDate)
  {
    a(paramCalendarCellView, paramDate);
    paramCalendarCellView.setBackgroundResource(2131624349);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/projectdetail/view/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */