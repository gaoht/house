package com.ziroom.ziroomcustomer.minsu.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.f.d;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.adapter.r;
import com.ziroom.ziroomcustomer.minsu.adapter.u;
import com.ziroom.ziroomcustomer.minsu.bean.LeaseCalendarBean;
import com.ziroom.ziroomcustomer.minsu.bean.LeaseCalendarBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.LeaseCalendarBean.DataBean.MonthListBean;
import com.ziroom.ziroomcustomer.minsu.bean.LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.c;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarPickerView;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarPickerView.c;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarPickerView.e;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarPickerView.h;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarPickerView.i;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarPickerView.j;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarRowView;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MinsuTimesSelectingActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static final String a = MinsuTimesSelectingActivity.class.getSimpleName();
  public static final char[] b = "日一二三四五六".toCharArray();
  private TextView A;
  private TextView B;
  private String C;
  private int D;
  private int E;
  private u F;
  private long G = 0L;
  private List<String> H = new ArrayList();
  private long I = 0L;
  private List<String> J = new ArrayList();
  private List<String> K = new ArrayList();
  public CalendarPickerView.c c;
  private CalendarPickerView d;
  private String e;
  private String f;
  private Map<String, LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean> g = new HashMap();
  private Map<String, LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean> r = new HashMap();
  private Map<String, LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean> s = new HashMap();
  private Calendar t;
  private Calendar u;
  private CommonTitle v;
  private Intent w;
  private List<Date> x = new ArrayList();
  private TextView y;
  private TextView z;
  
  private List<String> a(Date paramDate)
  {
    Object localObject1 = m.getFormatDate(paramDate, m.b);
    if (this.K.contains(localObject1)) {
      return this.K;
    }
    this.K.clear();
    if ((paramDate == null) || (paramDate.getTime() == 0L)) {
      return this.K;
    }
    this.K.add(localObject1);
    localObject1 = GregorianCalendar.getInstance();
    ((Calendar)localObject1).setTime(paramDate);
    ((Calendar)localObject1).add(5, 1);
    Object localObject2 = ((Calendar)localObject1).getTime();
    Object localObject3 = m.getFormatDate((Date)localObject2, m.b);
    if (c.isNull(localObject3))
    {
      label101:
      ((Calendar)localObject1).setTime(paramDate);
      label106:
      ((Calendar)localObject1).add(5, -1);
      paramDate = ((Calendar)localObject1).getTime();
      if (!m.isLessThanToday(paramDate)) {
        break label224;
      }
    }
    for (;;)
    {
      return this.K;
      LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean localCalendarListBean = (LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean)this.g.get(localObject3);
      if ((localCalendarListBean == null) || (localCalendarListBean.status == 1) || (localCalendarListBean.status == 2) || (localCalendarListBean.status == 4)) {
        break label101;
      }
      this.K.add(localObject3);
      if (((Date)localObject2).equals(this.t.getTime())) {
        break label101;
      }
      if (((Date)localObject2).getTime() < this.t.getTime().getTime()) {
        break;
      }
      break label101;
      label224:
      localObject2 = m.getFormatDate(paramDate, m.b);
      localObject3 = (LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean)this.g.get(localObject2);
      if ((localObject3 != null) && (((LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean)localObject3).status != 1) && (((LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean)localObject3).status != 2) && (((LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean)localObject3).status != 3))
      {
        this.K.add(localObject2);
        if (!paramDate.equals(this.u)) {
          if (paramDate.getTime() >= this.u.getTime().getTime()) {
            break label106;
          }
        }
      }
    }
  }
  
  private void a()
  {
    this.d = ((CalendarPickerView)findViewById(2131691033));
    this.y = ((TextView)findViewById(2131691675));
    this.z = ((TextView)findViewById(2131691676));
    this.A = ((TextView)findViewById(2131690953));
    this.B = ((TextView)findViewById(2131691677));
    this.A.setOnClickListener(this);
    CalendarRowView localCalendarRowView = (CalendarRowView)findViewById(2131691032);
    localCalendarRowView.setCellTextColor(getResources().getColor(2131624039));
    int i = 0;
    while (i < 7)
    {
      ((TextView)localCalendarRowView.getChildAt(i)).setText(b[i] + "");
      i += 1;
    }
    j();
  }
  
  private void b()
  {
    f();
    ArrayList localArrayList = new ArrayList();
    this.x.clear();
    if (ae.notNull(this.e))
    {
      localArrayList.add(m.strToDate(this.e, m.b));
      this.x.add(m.strToDate(this.e, m.b));
    }
    if (ae.notNull(this.f))
    {
      localArrayList.add(m.strToDate(this.f, m.b));
      this.x.add(m.strToDate(this.f, m.b));
    }
    this.d.init(this.u.getTime(), this.t.getTime()).inMode(CalendarPickerView.j.c).withSelectedDates(localArrayList);
    this.F = new u(this, this.g, this.d);
    this.d.setDecorators(Arrays.asList(new com.ziroom.ziroomcustomer.minsu.view.timessquare.a[] { this.F }));
    this.d.setCustomDayView(new r());
    this.d.setDateSelectableFilter(this.c);
    this.d.setMinDay(this.E);
    this.d.setOnInvalidDateSelectedListener(new CalendarPickerView.i()
    {
      public void onInvalidDateSelected(Date paramAnonymousDate) {}
    });
    this.d.setOnDateSelectedListener(new CalendarPickerView.h()
    {
      public void onDateSelected(Date paramAnonymousDate)
      {
        MinsuTimesSelectingActivity.b(MinsuTimesSelectingActivity.this).add(paramAnonymousDate);
        String str;
        if ((MinsuTimesSelectingActivity.b(MinsuTimesSelectingActivity.this) != null) && (MinsuTimesSelectingActivity.b(MinsuTimesSelectingActivity.this).size() > 0))
        {
          if (MinsuTimesSelectingActivity.b(MinsuTimesSelectingActivity.this).size() != 1) {
            break label107;
          }
          str = m.getFormatDate(paramAnonymousDate, m.b);
          MinsuTimesSelectingActivity.a(MinsuTimesSelectingActivity.this, str);
          MinsuTimesSelectingActivity.c(MinsuTimesSelectingActivity.this).setCurrentDateRange(MinsuTimesSelectingActivity.a(MinsuTimesSelectingActivity.this, paramAnonymousDate));
        }
        for (;;)
        {
          MinsuTimesSelectingActivity.d(MinsuTimesSelectingActivity.this);
          MinsuTimesSelectingActivity.a(MinsuTimesSelectingActivity.this, paramAnonymousDate);
          return;
          label107:
          str = m.getFormatDate(paramAnonymousDate, m.b);
          MinsuTimesSelectingActivity.b(MinsuTimesSelectingActivity.this, str);
        }
      }
      
      public void onDateUnselected(Date paramAnonymousDate)
      {
        MinsuTimesSelectingActivity.b(MinsuTimesSelectingActivity.this).remove(paramAnonymousDate);
        paramAnonymousDate = m.getFormatDate(paramAnonymousDate, m.b);
        if (paramAnonymousDate.equals(MinsuTimesSelectingActivity.e(MinsuTimesSelectingActivity.this))) {
          MinsuTimesSelectingActivity.a(MinsuTimesSelectingActivity.this, "");
        }
        for (;;)
        {
          MinsuTimesSelectingActivity.d(MinsuTimesSelectingActivity.this);
          return;
          if (paramAnonymousDate.equals(MinsuTimesSelectingActivity.f(MinsuTimesSelectingActivity.this))) {
            MinsuTimesSelectingActivity.b(MinsuTimesSelectingActivity.this, "");
          }
        }
      }
    });
  }
  
  private String d(String paramString)
  {
    String str = ad.getWeekFromDate(paramString);
    paramString = m.getFormatDate(m.strToDate(paramString, m.b), "M月d日");
    return paramString + "\n" + str;
  }
  
  private void e()
  {
    Object localObject = getIntent();
    this.e = ((Intent)localObject).getStringExtra("startDate");
    this.f = ((Intent)localObject).getStringExtra("endDate");
    this.C = ((Intent)localObject).getStringExtra("fid");
    this.D = ((Intent)localObject).getIntExtra("rentWay", 0);
    this.E = ((Intent)localObject).getIntExtra("minDay", -1);
    this.t = Calendar.getInstance();
    this.u = Calendar.getInstance();
    this.u.set(5, 1);
    this.t.set(5, 1);
    this.t.add(2, 6);
    localObject = m.getFormatDate(this.u.getTime(), m.b);
    String str = m.getFormatDate(this.t.getTime(), m.b);
    com.ziroom.ziroomcustomer.minsu.e.a.leaseCalendar(this, this.C, this.D, (String)localObject, str, new i.a()
    {
      public void onParse(String paramAnonymousString, com.freelxl.baselibrary.e.k paramAnonymousk) {}
      
      public void onSuccess(com.freelxl.baselibrary.e.k paramAnonymousk)
      {
        Object localObject = (LeaseCalendarBean)paramAnonymousk.getObject();
        if ((paramAnonymousk.getSuccess().booleanValue()) && (localObject != null) && (((LeaseCalendarBean)localObject).checkSuccess(MinsuTimesSelectingActivity.this)))
        {
          d.e("lanzhihong", "ro======" + ((LeaseCalendarBean)localObject).toString());
          MinsuTimesSelectingActivity.a(MinsuTimesSelectingActivity.this, new HashMap());
          MinsuTimesSelectingActivity.b(MinsuTimesSelectingActivity.this, new HashMap());
          MinsuTimesSelectingActivity.c(MinsuTimesSelectingActivity.this, new HashMap());
          paramAnonymousk = ((LeaseCalendarBean)localObject).data.monthList.iterator();
          while (paramAnonymousk.hasNext())
          {
            localObject = ((LeaseCalendarBean.DataBean.MonthListBean)paramAnonymousk.next()).calendarList.iterator();
            while (((Iterator)localObject).hasNext())
            {
              LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean localCalendarListBean = (LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean)((Iterator)localObject).next();
              MinsuTimesSelectingActivity.g(MinsuTimesSelectingActivity.this).put(localCalendarListBean.date, localCalendarListBean);
              if (localCalendarListBean.status == 4) {
                MinsuTimesSelectingActivity.h(MinsuTimesSelectingActivity.this).put(localCalendarListBean.date, localCalendarListBean);
              } else if (localCalendarListBean.status == 3) {
                MinsuTimesSelectingActivity.i(MinsuTimesSelectingActivity.this).put(localCalendarListBean.date, localCalendarListBean);
              }
            }
          }
          MinsuTimesSelectingActivity.j(MinsuTimesSelectingActivity.this);
          MinsuTimesSelectingActivity.k(MinsuTimesSelectingActivity.this);
          return;
        }
        if (localObject == null) {}
        for (paramAnonymousk = null;; paramAnonymousk = ((LeaseCalendarBean)localObject).message)
        {
          ad.shouErrorMessage(paramAnonymousk);
          return;
        }
      }
    });
  }
  
  private void f()
  {
    this.c = new CalendarPickerView.c()
    {
      public boolean isDateSelectable(Date paramAnonymousDate)
      {
        String str = m.getFormatDate(paramAnonymousDate, m.b);
        MinsuTimesSelectingActivity.a locala = MinsuTimesSelectingActivity.this.getCurrentSelectType();
        if (MinsuTimesSelectingActivity.g(MinsuTimesSelectingActivity.this) == null) {
          return true;
        }
        if (m.isLessThanToday(paramAnonymousDate)) {
          return false;
        }
        if (MinsuTimesSelectingActivity.g(MinsuTimesSelectingActivity.this) != null)
        {
          LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean localCalendarListBean = (LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean)MinsuTimesSelectingActivity.g(MinsuTimesSelectingActivity.this).get(str);
          if ((localCalendarListBean != null) && (localCalendarListBean.status == 0)) {
            return true;
          }
        }
        if ((MinsuTimesSelectingActivity.g(MinsuTimesSelectingActivity.this) != null) && (MinsuTimesSelectingActivity.g(MinsuTimesSelectingActivity.this).get(str) != null) && ((((LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean)MinsuTimesSelectingActivity.g(MinsuTimesSelectingActivity.this).get(str)).status == 1) || (((LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean)MinsuTimesSelectingActivity.g(MinsuTimesSelectingActivity.this).get(str)).status == 2))) {
          return false;
        }
        if (locala == MinsuTimesSelectingActivity.a.a) {
          return MinsuTimesSelectingActivity.this.checkLeftDate(paramAnonymousDate);
        }
        str = m.getFormatDate(paramAnonymousDate, m.b);
        if (MinsuTimesSelectingActivity.a(MinsuTimesSelectingActivity.this, m.strToDate(MinsuTimesSelectingActivity.e(MinsuTimesSelectingActivity.this), m.b)).contains(str)) {
          return true;
        }
        return MinsuTimesSelectingActivity.this.checkLeftDate(paramAnonymousDate);
      }
    };
  }
  
  private void g()
  {
    if ((ae.isNull(this.e)) && (ae.isNull(this.f))) {
      return;
    }
    Object localObject3 = m.strToDate(this.e, m.b);
    Object localObject1 = m.strToDate(this.f, m.b);
    Object localObject2 = Calendar.getInstance();
    ((Calendar)localObject2).setTime((Date)localObject3);
    localObject3 = Calendar.getInstance();
    ((Calendar)localObject3).setTime((Date)localObject1);
    localObject1 = m.getDateFromStartAndEnd((Calendar)localObject2, (Calendar)localObject3).iterator();
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject2 = m.getFormatDate((Date)((Iterator)localObject1).next(), m.b);
    } while ((this.g == null) || (this.g.get(localObject2) == null) || (((LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean)this.g.get(localObject2)).status == 0));
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).add(m.strToDate(this.e, m.b));
        ((ArrayList)localObject1).add(m.strToDate(this.f, m.b));
        this.d.setDecorators(null);
        this.d.setDateSelectableFilter(null);
        this.d.init(this.u.getTime(), this.t.getTime()).inMode(CalendarPickerView.j.c).withSelectedDates((Collection)localObject1);
        return;
      }
      this.d.init(this.u.getTime(), this.t.getTime()).inMode(CalendarPickerView.j.a);
      showToast("日期冲突,已自动清除");
      this.e = "";
      this.f = "";
      return;
    }
  }
  
  private long h()
  {
    long l = 0L;
    if (this.G != 0L) {
      l = this.G;
    }
    while (ae.isNull(this.f)) {
      return l;
    }
    Date localDate = m.strToDate(this.f, m.b);
    Calendar localCalendar = GregorianCalendar.getInstance();
    localCalendar.setTime(localDate);
    localCalendar.add(5, -1);
    localDate = localCalendar.getTime();
    String str = m.getFormatDate(localDate, m.b);
    LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean localCalendarListBean = (LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean)this.g.get(str);
    if ((localCalendarListBean != null) && (localCalendarListBean.status != 0) && (localCalendarListBean.status != 4)) {}
    for (;;)
    {
      this.G = localDate.getTime();
      return this.G;
      this.H.add(str);
      if (!localDate.equals(this.u)) {
        if (localDate.getTime() >= this.u.getTime().getTime()) {
          break;
        }
      }
    }
  }
  
  private long i()
  {
    long l = 0L;
    if (this.I != 0L) {
      l = this.I;
    }
    while (ae.isNull(this.e)) {
      return l;
    }
    Date localDate = m.strToDate(this.e, m.b);
    Calendar localCalendar = GregorianCalendar.getInstance();
    localCalendar.setTime(localDate);
    localCalendar.add(5, 1);
    localDate = localCalendar.getTime();
    String str = m.getFormatDate(localDate, m.b);
    LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean localCalendarListBean = (LeaseCalendarBean.DataBean.MonthListBean.CalendarListBean)this.g.get(str);
    if ((localCalendarListBean != null) && (localCalendarListBean.status != 0) && (localCalendarListBean.status != 3)) {}
    for (;;)
    {
      this.I = localDate.getTime();
      return this.I;
      this.J.add(str);
      if (!localDate.equals(this.t)) {
        if (localDate.getTime() <= this.t.getTime().getTime()) {
          break;
        }
      }
    }
  }
  
  private void j()
  {
    String str2;
    String str1;
    if (this.y != null)
    {
      str2 = this.e;
      str1 = str2;
      if (ae.notNull(str2)) {
        str1 = d(str2);
      }
      this.y.setText(str1);
    }
    if (this.z != null)
    {
      str2 = this.f;
      str1 = str2;
      if (ae.notNull(str2)) {
        str1 = d(str2);
      }
      this.z.setText(str1);
    }
    if (this.A != null)
    {
      if ((ae.notNull(this.e)) && (ae.notNull(this.f)))
      {
        this.B.setVisibility(0);
        this.B.setText("共 " + m.differentDaysByMillisecond(this.e, this.f) + " 晚");
        this.A.setBackgroundColor(getResources().getColor(2131624475));
        this.A.setEnabled(true);
      }
    }
    else {
      return;
    }
    this.B.setVisibility(8);
    this.A.setBackgroundColor(getResources().getColor(2131624046));
    this.A.setEnabled(false);
  }
  
  private void k()
  {
    this.w = new Intent();
    setResult(0, this.w);
    finish();
  }
  
  private void l()
  {
    this.w = new Intent();
    this.w.putExtra("startDate", this.e);
    this.w.putExtra("endDate", this.f);
    this.w.putExtra("isToNext", getIntent().getBooleanExtra("isToNext", false));
    setResult(-1, this.w);
    finish();
  }
  
  public boolean checkLeftDate(Date paramDate)
  {
    if (paramDate == null) {}
    do
    {
      return false;
      h();
      paramDate = m.getFormatDate(paramDate, m.b);
    } while ((this.r != null) && (!this.r.containsKey(paramDate)));
    return true;
  }
  
  public boolean checkRightDate(Date paramDate)
  {
    if (paramDate == null) {}
    do
    {
      return false;
      i();
      paramDate = m.getFormatDate(paramDate, m.b);
    } while ((this.J != null) && (!this.J.contains(paramDate)));
    return true;
  }
  
  public void finish()
  {
    super.finish();
    com.ziroom.ziroomcustomer.minsu.f.k.animFinishAlpha(this);
  }
  
  public a getCurrentSelectType()
  {
    if ((ae.isNull(this.e)) || ((ae.notNull(this.e)) && (ae.notNull(this.f)))) {
      return a.a;
    }
    if ((ae.notNull(this.e)) && (ae.isNull(this.f))) {
      return a.b;
    }
    return a.a;
  }
  
  public List<Date> getSelectDates()
  {
    return this.x;
  }
  
  public void initTitle()
  {
    this.v = ((CommonTitle)findViewById(2131691272));
    this.v.setLeftButtonType(4);
    this.v.setBottomLineVisible(false);
    this.v.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuTimesSelectingActivity.a(MinsuTimesSelectingActivity.this);
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
      k();
      return;
    }
    if ((this.x == null) || (this.x.size() < 1))
    {
      g.textToast(ApplicationEx.c, "请选择入住日期");
      return;
    }
    if (this.x.size() < 2)
    {
      g.textToast(ApplicationEx.c, "请选择离开日期");
      return;
    }
    l();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903534);
    e();
    a();
    initTitle();
    b();
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuTimesSelectingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */