package com.ziroom.ziroomcustomer.minsu.adapter;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v4.util.ArrayMap;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuTimesSelectingActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuTimesSelectingActivity.a;
import com.ziroom.ziroomcustomer.minsu.bean.LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.view.MinsuDelTextView;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarCellView;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarPickerView;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarPickerView.c;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.a;
import com.ziroom.ziroomcustomer.util.m;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

public class u
  implements a
{
  private CalendarPickerView a;
  private Map<String, LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean> b = new ArrayMap();
  private List<String> c;
  private Activity d;
  private final int e = 14;
  private final int f = 11;
  private final int g = ApplicationEx.c.getResources().getColor(2131624042);
  private final int h = ApplicationEx.c.getResources().getColor(2131624583);
  private final int i = ApplicationEx.c.getResources().getColor(2131624039);
  private final int j = ApplicationEx.c.getResources().getColor(2131624583);
  private final int k = ApplicationEx.c.getResources().getColor(2131624046);
  private final int l = ApplicationEx.c.getResources().getColor(2131624046);
  private final int m = ApplicationEx.c.getResources().getColor(2131624475);
  private final int n = ApplicationEx.c.getResources().getColor(2131624583);
  
  public u(Activity paramActivity, Map<String, LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean> paramMap, CalendarPickerView paramCalendarPickerView)
  {
    this.a = paramCalendarPickerView;
    if (paramMap != null)
    {
      this.b.clear();
      this.b.putAll(paramMap);
    }
    this.d = paramActivity;
  }
  
  private SpannableString a(LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean paramCalendarListBean, Date paramDate)
  {
    return a(paramCalendarListBean, paramDate, this.k, this.l, 14, 11);
  }
  
  private SpannableString a(LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean paramCalendarListBean, Date paramDate, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    String str3 = b(paramDate);
    String str2 = "";
    String str1 = str2;
    if (paramCalendarListBean != null)
    {
      str1 = str2;
      if (paramCalendarListBean.status != 1)
      {
        str1 = str2;
        if (paramCalendarListBean.status != 2)
        {
          str1 = str2;
          if (paramCalendarListBean.status != 3)
          {
            str1 = str2;
            if (!m.isLessThanToday(paramDate)) {
              str1 = "¥" + ad.getPriceInt(paramCalendarListBean.price);
            }
          }
        }
      }
    }
    paramCalendarListBean = new SpannableString(str3 + "\n" + str1);
    paramCalendarListBean.setSpan(new AbsoluteSizeSpan(paramInt3, true), 0, str3.length(), 17);
    paramCalendarListBean.setSpan(new ForegroundColorSpan(paramInt1), 0, str3.length(), 33);
    paramCalendarListBean.setSpan(new AbsoluteSizeSpan(paramInt4, true), str3.length(), paramCalendarListBean.toString().length(), 17);
    paramCalendarListBean.setSpan(new ForegroundColorSpan(paramInt2), str3.length(), paramCalendarListBean.toString().length(), 33);
    return paramCalendarListBean;
  }
  
  private List<Date> a()
  {
    return ((MinsuTimesSelectingActivity)this.d).getSelectDates();
  }
  
  private void a(CalendarCellView paramCalendarCellView, Date paramDate)
  {
    if (this.b == null) {
      return;
    }
    Object localObject = m.getFormatDate(paramDate, m.b);
    localObject = (LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean)this.b.get(localObject);
    if (paramCalendarCellView.isCurrentMonth())
    {
      if (paramCalendarCellView.isToday())
      {
        a(paramCalendarCellView, paramDate, (LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean)localObject);
        return;
      }
      if (m.isLessThanToday(paramDate))
      {
        c(paramCalendarCellView, paramDate, (LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean)localObject);
        return;
      }
      if (a(paramDate))
      {
        if (paramCalendarCellView.isSelected())
        {
          d(paramCalendarCellView, paramDate, (LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean)localObject);
          return;
        }
        if ((localObject != null) && (!getUnable((LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean)localObject)))
        {
          b(paramCalendarCellView, paramDate, (LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean)localObject);
          return;
        }
        e(paramCalendarCellView, paramDate, (LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean)localObject);
        return;
      }
      if (paramCalendarCellView.isSelected())
      {
        d(paramCalendarCellView, paramDate, (LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean)localObject);
        return;
      }
      if ((localObject != null) && (!getUnable((LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean)localObject)) && (!m.isLessThanToday(paramDate)))
      {
        b(paramCalendarCellView, paramDate, (LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean)localObject);
        return;
      }
      b(paramCalendarCellView, paramDate, (LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean)localObject);
      return;
    }
    paramCalendarCellView.getDayOfMonthTextView().setBackgroundColor(this.n);
    paramCalendarCellView.getDayOfMonthTextView().setText("");
    a(paramCalendarCellView, false);
  }
  
  private void a(CalendarCellView paramCalendarCellView, Date paramDate, LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean paramCalendarListBean)
  {
    if (paramCalendarCellView.isSelected())
    {
      d(paramCalendarCellView, paramDate, paramCalendarListBean);
      return;
    }
    if ((paramCalendarListBean != null) && (!getUnable(paramCalendarListBean)))
    {
      paramDate = a(paramCalendarListBean, paramDate);
      a(paramCalendarCellView, true);
    }
    for (;;)
    {
      paramCalendarCellView.getDayOfMonthTextView().setBackgroundResource(2130837812);
      paramCalendarCellView.getDayOfMonthTextView().setText(paramDate);
      return;
      paramDate = b(paramCalendarListBean, paramDate);
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
  
  private boolean a(LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean paramCalendarListBean)
  {
    if (this.c == null) {
      return false;
    }
    return this.c.contains(paramCalendarListBean.date);
  }
  
  private boolean a(Date paramDate)
  {
    return ((MinsuTimesSelectingActivity)this.d).c.isDateSelectable(paramDate);
  }
  
  private SpannableString b(LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean paramCalendarListBean, Date paramDate)
  {
    return a(paramCalendarListBean, paramDate, this.i, this.g, 14, 11);
  }
  
  private MinsuTimesSelectingActivity.a b()
  {
    return ((MinsuTimesSelectingActivity)this.d).getCurrentSelectType();
  }
  
  private String b(Date paramDate)
  {
    return Integer.toString(paramDate.getDate());
  }
  
  private void b(CalendarCellView paramCalendarCellView, Date paramDate, LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean paramCalendarListBean)
  {
    paramDate = a(paramCalendarListBean, paramDate);
    a(paramCalendarCellView, true);
    paramCalendarCellView.getDayOfMonthTextView().setBackgroundColor(this.n);
    paramCalendarCellView.getDayOfMonthTextView().setText(paramDate);
  }
  
  private SpannableString c(LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean paramCalendarListBean, Date paramDate)
  {
    return a(paramCalendarListBean, paramDate, this.j, this.h, 14, 11);
  }
  
  private void c(CalendarCellView paramCalendarCellView, Date paramDate, LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean paramCalendarListBean)
  {
    paramDate = a(paramCalendarListBean, paramDate);
    a(paramCalendarCellView, false);
    paramCalendarCellView.getDayOfMonthTextView().setBackgroundColor(this.n);
    paramCalendarCellView.getDayOfMonthTextView().setText(paramDate);
  }
  
  private void d(CalendarCellView paramCalendarCellView, Date paramDate, LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean paramCalendarListBean)
  {
    paramCalendarListBean = c(paramCalendarListBean, paramDate);
    a(paramCalendarCellView, false);
    Object localObject = a();
    if (localObject != null) {
      if (((List)localObject).size() == 2)
      {
        Date localDate = (Date)((List)localObject).get(0);
        localObject = (Date)((List)localObject).get(1);
        if ((localDate != null) && (m.equalsIngoreHMS(localDate, paramDate))) {
          paramCalendarCellView.getDayOfMonthTextView().setBackgroundDrawable(ApplicationEx.c.getResources().getDrawable(2130837708));
        }
      }
    }
    for (;;)
    {
      paramCalendarCellView.getDayOfMonthTextView().setText(paramCalendarListBean);
      return;
      if ((localObject != null) && (m.equalsIngoreHMS((Date)localObject, paramDate)))
      {
        paramCalendarCellView.getDayOfMonthTextView().setBackgroundDrawable(ApplicationEx.c.getResources().getDrawable(2130837717));
      }
      else
      {
        paramCalendarCellView.getDayOfMonthTextView().setBackground(ApplicationEx.c.getResources().getDrawable(2130837714));
        continue;
        paramCalendarCellView.getDayOfMonthTextView().setBackgroundDrawable(ApplicationEx.c.getResources().getDrawable(2130837707));
        continue;
        paramCalendarCellView.getDayOfMonthTextView().setBackground(null);
        paramCalendarCellView.getDayOfMonthTextView().setBackgroundDrawable(ApplicationEx.c.getResources().getDrawable(2130837707));
      }
    }
  }
  
  private void e(CalendarCellView paramCalendarCellView, Date paramDate, LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean paramCalendarListBean)
  {
    paramDate = b(paramCalendarListBean, paramDate);
    a(paramCalendarCellView, false);
    paramCalendarCellView.getDayOfMonthTextView().setBackgroundColor(this.n);
    paramCalendarCellView.getDayOfMonthTextView().setText(paramDate);
  }
  
  public void decorate(CalendarCellView paramCalendarCellView, Date paramDate)
  {
    a(paramCalendarCellView, paramDate);
    paramCalendarCellView.setBackgroundResource(2131624349);
  }
  
  public List<String> getCurrentDateRange()
  {
    return this.c;
  }
  
  public Map<String, LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean> getDataMap()
  {
    return this.b;
  }
  
  public boolean getUnable(LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean paramCalendarListBean)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramCalendarListBean.status == 0) {
      bool1 = true;
    }
    label247:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return bool1;
                if (b() != MinsuTimesSelectingActivity.a.a) {
                  break;
                }
                bool1 = bool2;
              } while (paramCalendarListBean.status == 3);
              if (paramCalendarListBean.status == 4) {
                return true;
              }
              bool1 = bool2;
            } while (paramCalendarListBean.status == 1);
            bool1 = bool2;
          } while (paramCalendarListBean.status != 2);
          return false;
          if (paramCalendarListBean.status == 3)
          {
            paramCalendarListBean = m.strToDate(paramCalendarListBean.date, m.b);
            localObject = (Date)a().get(0);
            Calendar localCalendar = GregorianCalendar.getInstance();
            localCalendar.setTime((Date)localObject);
            localCalendar.set(11, 0);
            localCalendar.set(12, 0);
            localCalendar.set(13, 0);
            localCalendar.set(14, 0);
            if (paramCalendarListBean.getTime() >= localCalendar.getTime().getTime()) {}
            for (bool1 = true;; bool1 = false) {
              return bool1;
            }
          }
          if (paramCalendarListBean.status != 4) {
            break label247;
          }
          paramCalendarListBean = m.strToDate(paramCalendarListBean.date, m.b);
          Object localObject = GregorianCalendar.getInstance();
          ((Calendar)localObject).setTime(paramCalendarListBean);
          ((Calendar)localObject).add(5, -1);
          paramCalendarListBean = m.getFormatDate(((Calendar)localObject).getTime(), m.b);
          paramCalendarListBean = (LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean)this.b.get(paramCalendarListBean);
          if (paramCalendarListBean == null) {
            break;
          }
          bool1 = bool2;
        } while (a(paramCalendarListBean));
        return true;
        bool1 = bool2;
      } while (paramCalendarListBean.status == 1);
      bool1 = bool2;
    } while (paramCalendarListBean.status != 2);
    return false;
  }
  
  public void setCurrentDateRange(List<String> paramList)
  {
    this.c = paramList;
  }
  
  public void setDataMap(Map<String, LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean> paramMap)
  {
    if (paramMap != null)
    {
      this.b.clear();
      this.b.putAll(paramMap);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/adapter/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */