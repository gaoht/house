package com.ziroom.ziroomcustomer.sublet.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.adapter.r;
import com.ziroom.ziroomcustomer.minsu.f.ac;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarCellView;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarPickerView;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarPickerView.c;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarPickerView.e;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarPickerView.h;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarPickerView.i;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarPickerView.j;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.a;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class LeaseSubletTimeActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static final String a = LeaseSubletTimeActivity.class.getSimpleName();
  private CalendarPickerView b;
  private String c;
  private String d;
  private String e;
  private CommonTitle f;
  private Intent g;
  private List<Date> r;
  private ImageView s;
  
  private void a()
  {
    this.b = ((CalendarPickerView)findViewById(2131691033));
    this.s = ((ImageView)findViewById(2131691399));
    this.s.setOnClickListener(this);
  }
  
  private void b()
  {
    this.c = getIntent().getStringExtra("subletTime");
    this.d = getIntent().getStringExtra("startTime");
    this.e = getIntent().getStringExtra("endTime");
  }
  
  private void e()
  {
    this.f.setMiddleText("请选择转租日期");
    ArrayList localArrayList = new ArrayList();
    if (ae.notNull(this.c)) {
      localArrayList.add(m.strToDate(this.c, m.b));
    }
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      this.b.init(m.strToDate(this.d, m.b), m.getDateAfter(m.strToDate(this.e, m.b), 1)).inMode(CalendarPickerView.j.a).withSelectedDates(localArrayList);
    }
    for (;;)
    {
      this.b.setDecorators(Arrays.asList(new a[] { new a(this, this.b) }));
      this.b.setCustomDayView(new r());
      this.b.setDateSelectableFilter(new CalendarPickerView.c()
      {
        public boolean isDateSelectable(Date paramAnonymousDate)
        {
          return (!ae.notNull(LeaseSubletTimeActivity.a(LeaseSubletTimeActivity.this))) || (!m.getFormatDate(paramAnonymousDate, m.b).equals(LeaseSubletTimeActivity.a(LeaseSubletTimeActivity.this)));
        }
      });
      this.b.setOnInvalidDateSelectedListener(new CalendarPickerView.i()
      {
        public void onInvalidDateSelected(Date paramAnonymousDate) {}
      });
      this.b.setOnDateSelectedListener(new CalendarPickerView.h()
      {
        public void onDateSelected(Date paramAnonymousDate)
        {
          if ((ae.notNull(LeaseSubletTimeActivity.a(LeaseSubletTimeActivity.this))) && (paramAnonymousDate.before(m.strToDate(LeaseSubletTimeActivity.a(LeaseSubletTimeActivity.this), m.b)))) {
            LeaseSubletTimeActivity.a(LeaseSubletTimeActivity.this, "");
          }
          LeaseSubletTimeActivity.a(LeaseSubletTimeActivity.this, new Intent());
          paramAnonymousDate = m.getFormatDate(paramAnonymousDate, m.b);
          LeaseSubletTimeActivity.a(LeaseSubletTimeActivity.this, paramAnonymousDate);
          LeaseSubletTimeActivity.b(LeaseSubletTimeActivity.this).putExtra("sublet", paramAnonymousDate);
          LeaseSubletTimeActivity.this.setResult(-1, LeaseSubletTimeActivity.b(LeaseSubletTimeActivity.this));
          LeaseSubletTimeActivity.this.finish();
        }
        
        public void onDateUnselected(Date paramAnonymousDate)
        {
          if (LeaseSubletTimeActivity.c(LeaseSubletTimeActivity.this) != null) {
            LeaseSubletTimeActivity.c(LeaseSubletTimeActivity.this).remove(paramAnonymousDate);
          }
        }
      });
      return;
      this.b.init(m.strToDate(this.d, m.b), m.getDateAfter(m.strToDate(this.e, m.b), 1)).inMode(CalendarPickerView.j.a);
    }
  }
  
  public void initTitle()
  {
    this.f = ((CommonTitle)findViewById(2131691272));
    this.f.setLeftButtonType(0);
    this.f.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        LeaseSubletTimeActivity.this.finish();
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
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904843);
    b();
    a();
    initTitle();
    e();
  }
  
  public class a
    implements a
  {
    private CalendarPickerView b;
    private Context c;
    
    public a(Context paramContext, CalendarPickerView paramCalendarPickerView)
    {
      this.c = paramContext;
      this.b = paramCalendarPickerView;
    }
    
    private String a(Date paramDate)
    {
      m.getFormatDate(paramDate, m.b);
      return Integer.toString(paramDate.getDate());
    }
    
    private void a(CalendarCellView paramCalendarCellView, Date paramDate)
    {
      if (paramCalendarCellView.isCurrentMonth()) {
        if (paramCalendarCellView.isSelectable()) {
          if (paramCalendarCellView.isSelected()) {
            if (paramCalendarCellView.isToday())
            {
              ac.absSizeColor(paramCalendarCellView.getDayOfMonthTextView(), this.c.getString(2131296750), 12, Color.parseColor("#ffffff"));
              paramCalendarCellView.getDayOfMonthTextView().setBackgroundResource(2130837707);
              if ((ae.notNull(LeaseSubletTimeActivity.a(LeaseSubletTimeActivity.this))) && (m.getFormatDate(paramDate, m.b).equals(LeaseSubletTimeActivity.a(LeaseSubletTimeActivity.this))))
              {
                ac.absSizeColor(paramCalendarCellView.getDayOfMonthTextView(), "转租", 14, Color.parseColor("#ffffff"));
                paramCalendarCellView.getDayOfMonthTextView().setBackgroundResource(2130837707);
              }
            }
          }
        }
      }
      for (;;)
      {
        Object localObject = this.b.getSelectedDates();
        if ((localObject != null) && (((List)localObject).size() == 1))
        {
          localObject = (Date)((List)localObject).get(0);
          if ((paramCalendarCellView.isSelectable()) && (((Date)localObject).getDate() == paramDate.getDate()) && (((Date)localObject).getMonth() == paramDate.getMonth()) && (((Date)localObject).getYear() == paramDate.getYear()))
          {
            ac.absSizeColor(paramCalendarCellView.getDayOfMonthTextView(), "转租", 14, Color.parseColor("#ffffff"));
            paramCalendarCellView.getDayOfMonthTextView().setBackgroundResource(2130837707);
            paramCalendarCellView.getDayOfMonthTextView().setBackgroundResource(2130837707);
          }
        }
        return;
        ac.absSizeColor(paramCalendarCellView.getDayOfMonthTextView(), a(paramDate), 14, Color.parseColor("#ffffff"));
        paramCalendarCellView.getDayOfMonthTextView().setBackgroundResource(2130837707);
        break;
        if (paramCalendarCellView.isToday())
        {
          ac.absSizeColor(paramCalendarCellView.getDayOfMonthTextView(), this.c.getString(2131296750), 12, this.c.getResources().getColor(2131624017));
          paramCalendarCellView.getDayOfMonthTextView().setBackgroundResource(2131624349);
          break;
        }
        ac.absSizeColor(paramCalendarCellView.getDayOfMonthTextView(), a(paramDate), 14, Color.parseColor("#444444"));
        paramCalendarCellView.getDayOfMonthTextView().setBackgroundResource(2131624349);
        break;
        if (paramCalendarCellView.isToday())
        {
          ac.absSizeColor(paramCalendarCellView.getDayOfMonthTextView(), this.c.getString(2131296750), 12, Color.parseColor("#999999"));
          paramCalendarCellView.getDayOfMonthTextView().setBackgroundResource(2131624349);
          break;
        }
        ac.absSizeColor(paramCalendarCellView.getDayOfMonthTextView(), a(paramDate), 14, Color.parseColor("#999999"));
        paramCalendarCellView.getDayOfMonthTextView().setBackgroundResource(2131624349);
        break;
        ac.absSizeColor(paramCalendarCellView.getDayOfMonthTextView(), a(paramDate), 14, Color.parseColor("#ffffff"));
        paramCalendarCellView.getDayOfMonthTextView().setBackgroundResource(2131624349);
      }
    }
    
    public void decorate(CalendarCellView paramCalendarCellView, Date paramDate)
    {
      a(paramCalendarCellView, paramDate);
      paramCalendarCellView.setBackgroundResource(2131624349);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sublet/activity/LeaseSubletTimeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */