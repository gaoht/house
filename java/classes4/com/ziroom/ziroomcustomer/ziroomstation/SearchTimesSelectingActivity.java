package com.ziroom.ziroomcustomer.ziroomstation;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.adapter.r;
import com.ziroom.ziroomcustomer.minsu.f.ac;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarCellView;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarRowView;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.a;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.ziroomstation.widget.CustomCalendarPickerView;
import com.ziroom.ziroomcustomer.ziroomstation.widget.CustomCalendarPickerView.e;
import com.ziroom.ziroomcustomer.ziroomstation.widget.CustomCalendarPickerView.h;
import com.ziroom.ziroomcustomer.ziroomstation.widget.CustomCalendarPickerView.i;
import com.ziroom.ziroomcustomer.ziroomstation.widget.CustomCalendarPickerView.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class SearchTimesSelectingActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static final String a = SearchTimesSelectingActivity.class.getSimpleName();
  public static final char[] b = "日一二三四五六".toCharArray();
  private CustomCalendarPickerView c;
  private String d;
  private String e;
  private Calendar f;
  private Calendar g;
  private CommonTitle r;
  private Intent s;
  private List<Date> t = new ArrayList();
  private TextView u;
  private TextView v;
  private TextView w;
  private TextView x;
  private Date y;
  
  private void a()
  {
    this.c = ((CustomCalendarPickerView)findViewById(2131691033));
    this.u = ((TextView)findViewById(2131691675));
    this.v = ((TextView)findViewById(2131691676));
    this.w = ((TextView)findViewById(2131690953));
    this.x = ((TextView)findViewById(2131691677));
    this.w.setOnClickListener(this);
    CalendarRowView localCalendarRowView = (CalendarRowView)findViewById(2131691032);
    localCalendarRowView.setCellTextColor(getResources().getColor(2131624039));
    int i = 0;
    while (i < 7)
    {
      ((TextView)localCalendarRowView.getChildAt(i)).setText(b[i] + "");
      i += 1;
    }
  }
  
  private void b()
  {
    this.g = ((Calendar)getIntent().getSerializableExtra("lastDate"));
    this.f = ((Calendar)getIntent().getSerializableExtra("nextDate"));
    this.d = getIntent().getStringExtra("startDate");
    this.e = getIntent().getStringExtra("endDate");
    this.y = ((Date)getIntent().getSerializableExtra("canSelectDate"));
    f();
  }
  
  private String d(String paramString)
  {
    String str = ad.getWeekFromDate(paramString);
    paramString = m.getFormatDate(m.strToDate(paramString, m.b), "M月d日");
    return paramString + "\n" + str;
  }
  
  private void e()
  {
    ArrayList localArrayList = new ArrayList();
    if (ae.notNull(this.d))
    {
      localArrayList.add(m.strToDate(this.d, m.b));
      this.t.add(m.strToDate(this.d, m.b));
    }
    if (ae.notNull(this.e))
    {
      localArrayList.add(m.strToDate(this.e, m.b));
      this.t.add(m.strToDate(this.e, m.b));
    }
    this.c.init(this.g.getTime(), this.f.getTime(), this.y, Locale.getDefault()).inMode(CustomCalendarPickerView.j.c).withSelectedDates(localArrayList);
    this.c.setDecorators(Arrays.asList(new a[] { new a() }));
    this.c.setCustomDayView(new r());
    this.c.setOnInvalidDateSelectedListener(new CustomCalendarPickerView.i()
    {
      public void onInvalidDateSelected(Date paramAnonymousDate) {}
    });
    this.c.setOnDateSelectedListener(new CustomCalendarPickerView.h()
    {
      public void onDateSelected(Date paramAnonymousDate)
      {
        u.d("lanzhihong", "onDateSelected===" + m.getFormatDate(paramAnonymousDate, m.b));
        SearchTimesSelectingActivity.b(SearchTimesSelectingActivity.this).add(paramAnonymousDate);
        if ((SearchTimesSelectingActivity.b(SearchTimesSelectingActivity.this) != null) && (SearchTimesSelectingActivity.b(SearchTimesSelectingActivity.this).size() > 0))
        {
          if (SearchTimesSelectingActivity.b(SearchTimesSelectingActivity.this).size() != 1) {
            break label110;
          }
          paramAnonymousDate = m.getFormatDate(paramAnonymousDate, m.b);
          SearchTimesSelectingActivity.a(SearchTimesSelectingActivity.this, paramAnonymousDate);
        }
        for (;;)
        {
          SearchTimesSelectingActivity.c(SearchTimesSelectingActivity.this);
          return;
          label110:
          paramAnonymousDate = m.getFormatDate(paramAnonymousDate, m.b);
          SearchTimesSelectingActivity.b(SearchTimesSelectingActivity.this, paramAnonymousDate);
        }
      }
      
      public void onDateUnselected(Date paramAnonymousDate)
      {
        u.d("lanzhihong", "onDateUnselected===" + m.getFormatDate(paramAnonymousDate, m.b));
        SearchTimesSelectingActivity.b(SearchTimesSelectingActivity.this).clear();
        SearchTimesSelectingActivity.a(SearchTimesSelectingActivity.this, "");
        SearchTimesSelectingActivity.b(SearchTimesSelectingActivity.this, "");
        SearchTimesSelectingActivity.c(SearchTimesSelectingActivity.this);
      }
    });
  }
  
  private void f()
  {
    String str2;
    String str1;
    if (this.u != null)
    {
      str2 = this.d;
      str1 = str2;
      if (ae.notNull(str2)) {
        str1 = d(str2);
      }
      this.u.setText(str1);
    }
    if (this.v != null)
    {
      str2 = this.e;
      str1 = str2;
      if (ae.notNull(str2)) {
        str1 = d(str2);
      }
      this.v.setText(str1);
    }
    if (this.w != null)
    {
      if ((ae.notNull(this.d)) && (ae.notNull(this.e)))
      {
        this.x.setVisibility(0);
        this.x.setText("共 " + m.differentDaysByMillisecond(this.d, this.e) + " 晚");
        this.w.setBackgroundColor(getResources().getColor(2131624475));
        this.w.setEnabled(true);
      }
    }
    else {
      return;
    }
    this.x.setVisibility(8);
    this.w.setBackgroundColor(getResources().getColor(2131624046));
    this.w.setEnabled(false);
  }
  
  private void g()
  {
    this.s = new Intent();
    setResult(0, this.s);
    finish();
  }
  
  private void h()
  {
    this.s = new Intent();
    this.s.putExtra("startDate", this.d);
    this.s.putExtra("endDate", this.e);
    setResult(-1, this.s);
    finish();
  }
  
  public void finish()
  {
    super.finish();
    k.animFinishAlpha(this);
  }
  
  public List<Date> getSelectDates()
  {
    return this.t;
  }
  
  public void initTitle()
  {
    this.r = ((CommonTitle)findViewById(2131691272));
    this.r.setLeftButtonType(4);
    this.r.setBottomLineVisible(false);
    this.r.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        SearchTimesSelectingActivity.a(SearchTimesSelectingActivity.this);
      }
    });
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690549: 
      g();
      return;
    }
    if (this.t.size() < 1)
    {
      g.textToast(ApplicationEx.c, "请选择入住日期");
      return;
    }
    if (this.t.size() < 2)
    {
      g.textToast(ApplicationEx.c, "请选择离开日期");
      return;
    }
    h();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903330);
    a();
    b();
    initTitle();
    e();
  }
  
  public class a
    implements a
  {
    public a() {}
    
    private String a(Date paramDate)
    {
      return Integer.toString(paramDate.getDate());
    }
    
    private void a(CalendarCellView paramCalendarCellView, Date paramDate)
    {
      if (paramCalendarCellView.isCurrentMonth())
      {
        if (paramCalendarCellView.isSelectable())
        {
          if (paramCalendarCellView.isSelected())
          {
            ac.absSizeColor(paramCalendarCellView.getDayOfMonthTextView(), a(paramDate), 14, Color.parseColor("#ffffff"));
            Object localObject = SearchTimesSelectingActivity.this.getSelectDates();
            if (localObject != null)
            {
              if (((List)localObject).size() == 2)
              {
                Date localDate = (Date)((List)localObject).get(0);
                localObject = (Date)((List)localObject).get(1);
                if ((localDate != null) && (m.equalsIngoreHMS(localDate, paramDate)))
                {
                  paramCalendarCellView.getDayOfMonthTextView().setBackgroundDrawable(ApplicationEx.c.getResources().getDrawable(2130837708));
                  return;
                }
                if ((localObject != null) && (m.equalsIngoreHMS((Date)localObject, paramDate)))
                {
                  paramCalendarCellView.getDayOfMonthTextView().setBackgroundDrawable(ApplicationEx.c.getResources().getDrawable(2130837717));
                  return;
                }
                paramCalendarCellView.getDayOfMonthTextView().setBackground(ApplicationEx.c.getResources().getDrawable(2130837714));
                return;
              }
              paramCalendarCellView.getDayOfMonthTextView().setBackgroundDrawable(ApplicationEx.c.getResources().getDrawable(2130837707));
              return;
            }
            paramCalendarCellView.getDayOfMonthTextView().setBackground(null);
            paramCalendarCellView.getDayOfMonthTextView().setBackgroundDrawable(ApplicationEx.c.getResources().getDrawable(2130837707));
            return;
          }
          if (paramCalendarCellView.isToday())
          {
            ac.absSizeColor(paramCalendarCellView.getDayOfMonthTextView(), a(paramDate), 14, Color.parseColor("#444444"));
            paramCalendarCellView.getDayOfMonthTextView().setBackgroundResource(2130837812);
            return;
          }
          ac.absSizeColor(paramCalendarCellView.getDayOfMonthTextView(), a(paramDate), 14, Color.parseColor("#444444"));
          paramCalendarCellView.getDayOfMonthTextView().setBackgroundResource(2131624349);
          return;
        }
        ac.absSizeColor(paramCalendarCellView.getDayOfMonthTextView(), a(paramDate), 14, Color.parseColor("#999999"));
        paramCalendarCellView.getDayOfMonthTextView().setBackgroundResource(2131624349);
        return;
      }
      ac.absSizeColor(paramCalendarCellView.getDayOfMonthTextView(), a(paramDate), 14, Color.parseColor("#ffffff"));
      paramCalendarCellView.getDayOfMonthTextView().setBackgroundResource(2131624349);
    }
    
    public void decorate(CalendarCellView paramCalendarCellView, Date paramDate)
    {
      a(paramCalendarCellView, paramDate);
      paramCalendarCellView.setBackgroundResource(2131624349);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/SearchTimesSelectingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */