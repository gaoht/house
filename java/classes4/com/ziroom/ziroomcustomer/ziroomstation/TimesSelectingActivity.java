package com.ziroom.ziroomcustomer.ziroomstation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.ziroomstation.adapter.n;
import com.ziroom.ziroomcustomer.ziroomstation.adapter.o;
import com.ziroom.ziroomcustomer.ziroomstation.widget.timessquare.CalendarPickerView;
import com.ziroom.ziroomcustomer.ziroomstation.widget.timessquare.CalendarPickerView.e;
import com.ziroom.ziroomcustomer.ziroomstation.widget.timessquare.CalendarPickerView.h;
import com.ziroom.ziroomcustomer.ziroomstation.widget.timessquare.CalendarPickerView.i;
import com.ziroom.ziroomcustomer.ziroomstation.widget.timessquare.CalendarPickerView.j;
import com.ziroom.ziroomcustomer.ziroomstation.widget.timessquare.a;
import com.ziroom.ziroomcustomer.ziroomstation.widget.timessquare.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TimesSelectingActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static final String c = TimesSelectingActivity.class.getSimpleName();
  Calendar a = Calendar.getInstance();
  Calendar b = Calendar.getInstance();
  private CalendarPickerView d;
  private TextView e;
  private ImageView f;
  private String g;
  private String r;
  private Calendar s;
  
  private void a()
  {
    this.d = ((CalendarPickerView)findViewById(2131691033));
    this.e = ((TextView)findViewById(2131692608));
    this.f = ((ImageView)findViewById(2131690549));
    this.f.setOnClickListener(this);
  }
  
  private void b()
  {
    this.g = getIntent().getStringExtra("startTime");
    this.r = getIntent().getStringExtra("endTime");
    this.s = ((Calendar)getIntent().getSerializableExtra("openTime"));
  }
  
  private void e()
  {
    this.d.setCustomDayView(new n());
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(m.strToDate(this.g, m.k));
    localArrayList.add(m.strToDate(this.r, m.k));
    this.d.setDecorators(Arrays.asList(new a[] { new o(this, this.d) }));
    Date localDate = new Date();
    if (new Date().getTime() < this.s.getTimeInMillis()) {
      localDate.setTime(this.s.getTimeInMillis());
    }
    this.b.add(2, 3);
    this.d.init(localDate, this.b.getTime()).inMode(CalendarPickerView.j.c).withSelectedDates(localArrayList);
    this.d.setOnInvalidDateSelectedListener(new CalendarPickerView.i()
    {
      public void onInvalidDateSelected(Date paramAnonymousDate) {}
    });
    this.d.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        TimesSelectingActivity.b(TimesSelectingActivity.this).setText(((f)TimesSelectingActivity.a(TimesSelectingActivity.this).getMonths().get(paramAnonymousInt1)).getLabel());
      }
      
      public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    this.d.setOnDateSelectedListener(new CalendarPickerView.h()
    {
      public void onDateSelected(Date paramAnonymousDate)
      {
        paramAnonymousDate = TimesSelectingActivity.a(TimesSelectingActivity.this).getSelectedDates();
        if (paramAnonymousDate.size() > 1)
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("startTime", m.getFormatDate((Date)paramAnonymousDate.get(0), m.k));
          localIntent.putExtra("endTime", m.getFormatDate((Date)paramAnonymousDate.get(paramAnonymousDate.size() - 1), m.k));
          TimesSelectingActivity.this.setResult(10001, localIntent);
          TimesSelectingActivity.this.finish();
        }
      }
      
      public void onDateUnselected(Date paramAnonymousDate) {}
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
    setContentView(2130903535);
    a();
    b();
    e();
  }
  
  protected void onResume()
  {
    a("zinn_detail_cal_duration");
    super.onResume();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/TimesSelectingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */