package com.ziroom.ziroomcustomer.minsu.landlordrelease;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.f.t;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.b.e;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LLCalendarDayInfoBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LLCalendarEditData;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LLCalendarInfoBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LLCalendarInfoBean.ListBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LLCalendarOrderBean;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarPickerView;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarPickerView.c;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarPickerView.e;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarPickerView.h;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarPickerView.i;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarPickerView.j;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarRowView;
import com.ziroom.ziroomcustomer.util.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.c;

public class MinsuLLCanlendarActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static final String a = MinsuLLCanlendarActivity.class.getSimpleName();
  public static final char[] b = "日一二三四五六".toCharArray();
  private View A;
  private ArrayList<Date> B = new ArrayList();
  private ArrayList<String> C = new ArrayList();
  private HashMap<String, LLCalendarDayInfoBean> D = new HashMap();
  private CalendarPickerView E;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.view.a F;
  public CalendarPickerView.c c;
  private String d;
  private String e;
  private String f;
  private String g;
  private int r;
  private Map<String, LLCalendarDayInfoBean> s = new HashMap();
  private Date t;
  private Date u;
  private Date v;
  private HashMap<Integer, String> w = new HashMap(9);
  private CommonTitle x;
  private TextView y;
  private TextView z;
  
  private void a()
  {
    Date localDate = new Date();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(localDate);
    localCalendar.add(2, -1);
    localCalendar.set(5, 1);
    localDate = localCalendar.getTime();
    localCalendar.add(2, 3);
    localCalendar.add(5, -1);
    a(localDate, localCalendar.getTime());
  }
  
  private void a(Date paramDate1, Date paramDate2)
  {
    if ((this.t == null) || (this.u == null)) {
      com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("日历初始化 出错");
    }
    this.B.clear();
    this.E.init(paramDate1, paramDate2).inMode(CalendarPickerView.j.b).withSelectedDates(this.B);
    f();
    this.C.clear();
    this.F = new com.ziroom.ziroomcustomer.minsu.landlordrelease.view.a(this, this.s, this.v, this.E);
    this.E.setDecorators(Arrays.asList(new com.ziroom.ziroomcustomer.minsu.view.timessquare.a[] { this.F }));
    this.E.setCustomDayView(new e());
    this.E.setDateSelectableFilter(this.c);
    this.E.setOnInvalidDateSelectedListener(new CalendarPickerView.i()
    {
      public void onInvalidDateSelected(Date paramAnonymousDate)
      {
        paramAnonymousDate = m.getFormatDate(paramAnonymousDate, m.b);
        if (MinsuLLCanlendarActivity.e(MinsuLLCanlendarActivity.this) != null)
        {
          paramAnonymousDate = (LLCalendarDayInfoBean)MinsuLLCanlendarActivity.e(MinsuLLCanlendarActivity.this).get(paramAnonymousDate);
          if (paramAnonymousDate != null)
          {
            if (paramAnonymousDate.getStatus() != 1) {
              break label99;
            }
            if ((paramAnonymousDate.getLandCalenderOrder() == null) || (TextUtils.isEmpty(paramAnonymousDate.getLandCalenderOrder().getOrderSn()))) {
              break label82;
            }
            k.toLLOrderDetail(MinsuLLCanlendarActivity.this, paramAnonymousDate.getLandCalenderOrder().getOrderSn());
          }
        }
        label82:
        label99:
        do
        {
          return;
          g.textToast(MinsuLLCanlendarActivity.this, MinsuLLCanlendarActivity.this.getString(2131296770));
          return;
          if (paramAnonymousDate.getStatus() == 3)
          {
            g.textToast(MinsuLLCanlendarActivity.this, MinsuLLCanlendarActivity.this.getString(2131297500));
            return;
          }
        } while ((paramAnonymousDate.getStatus() == 0) || (paramAnonymousDate.getStatus() != 2));
      }
    });
    this.E.setOnDateSelectedListener(new CalendarPickerView.h()
    {
      public void onDateSelected(Date paramAnonymousDate)
      {
        MinsuLLCanlendarActivity.f(MinsuLLCanlendarActivity.this).add(paramAnonymousDate);
        paramAnonymousDate = m.getFormatDate(paramAnonymousDate, m.b);
        MinsuLLCanlendarActivity.g(MinsuLLCanlendarActivity.this).add(paramAnonymousDate);
        MinsuLLCanlendarActivity.h(MinsuLLCanlendarActivity.this).put(paramAnonymousDate, MinsuLLCanlendarActivity.e(MinsuLLCanlendarActivity.this).get(paramAnonymousDate));
        MinsuLLCanlendarActivity.i(MinsuLLCanlendarActivity.this);
      }
      
      public void onDateUnselected(Date paramAnonymousDate)
      {
        MinsuLLCanlendarActivity.f(MinsuLLCanlendarActivity.this).remove(paramAnonymousDate);
        paramAnonymousDate = m.getFormatDate(paramAnonymousDate, m.b);
        MinsuLLCanlendarActivity.g(MinsuLLCanlendarActivity.this).remove(paramAnonymousDate);
        MinsuLLCanlendarActivity.h(MinsuLLCanlendarActivity.this).remove(paramAnonymousDate);
        MinsuLLCanlendarActivity.i(MinsuLLCanlendarActivity.this);
      }
    });
    paramDate2 = Calendar.getInstance();
    paramDate2.setTime(paramDate1);
    paramDate2.add(2, 1);
    this.E.scrollToDate(paramDate2.getTime());
  }
  
  private void b()
  {
    this.E = ((CalendarPickerView)findViewById(2131691033));
    this.y = ((TextView)findViewById(2131690169));
    this.z = ((TextView)findViewById(2131691563));
    this.y.setOnClickListener(this);
    this.z.setOnClickListener(this);
    CalendarRowView localCalendarRowView = (CalendarRowView)findViewById(2131691032);
    int i = 0;
    while (i < 7)
    {
      ((TextView)localCalendarRowView.getChildAt(i)).setText(b[i] + "");
      i += 1;
    }
    this.A = findViewById(2131691099);
  }
  
  private void b(final int paramInt)
  {
    if ((paramInt == 1) && (com.freelxl.baselibrary.widget.a.getDialog() != null) && (com.freelxl.baselibrary.widget.a.isShowing())) {
      com.freelxl.baselibrary.widget.a.dismiss();
    }
    com.freelxl.baselibrary.widget.a.show(this, null, false, true);
    com.ziroom.ziroomcustomer.minsu.e.a.getLLHouseCalendar(this, this.e, this.f, this.g, this.r, paramInt, new t(this, new com.ziroom.ziroomcustomer.minsu.landlord.d.b(LLCalendarInfoBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("LLHouseCalendar", " err = " + paramAnonymousThrowable.getMessage() + " requstNum = " + paramInt);
        ad.shouErrorMessage(null);
        com.freelxl.baselibrary.widget.a.dismiss();
        new Handler().postDelayed(new Runnable()
        {
          public void run()
          {
            MinsuLLCanlendarActivity.this.finish();
          }
        }, 50L);
      }
      
      public void onSuccess(int paramAnonymousInt, LLCalendarInfoBean paramAnonymousLLCalendarInfoBean)
      {
        com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("LLHouseCalendar", " code = " + paramAnonymousInt + " requstNum = " + paramInt);
        if (paramAnonymousLLCalendarInfoBean != null)
        {
          Object localObject1 = paramAnonymousLLCalendarInfoBean.getNowDate();
          MinsuLLCanlendarActivity.a(MinsuLLCanlendarActivity.this, m.strToDate((String)localObject1, m.b));
          if (paramInt == 1)
          {
            MinsuLLCanlendarActivity.e(MinsuLLCanlendarActivity.this).clear();
            MinsuLLCanlendarActivity.j(MinsuLLCanlendarActivity.this).clear();
            com.ziroom.ziroomcustomer.minsu.c.b.getInstance().initData(MinsuLLCanlendarActivity.j(MinsuLLCanlendarActivity.this));
          }
          int k = paramAnonymousLLCalendarInfoBean.getList().size();
          int i = 0;
          while (i < k) {
            try
            {
              Object localObject2 = (LLCalendarInfoBean.ListBean)paramAnonymousLLCalendarInfoBean.getList().get(i);
              localObject1 = ((LLCalendarInfoBean.ListBean)localObject2).getMonthStr();
              localObject2 = ((LLCalendarInfoBean.ListBean)localObject2).getMonthSpecialStr();
              int j = Integer.parseInt(((String)localObject1).substring(((String)localObject1).lastIndexOf("-") + 1));
              MinsuLLCanlendarActivity.j(MinsuLLCanlendarActivity.this).put(Integer.valueOf(j), localObject2);
              localObject1 = ((LLCalendarInfoBean.ListBean)paramAnonymousLLCalendarInfoBean.getList().get(i)).getCalendarList();
              int m = ((List)localObject1).size();
              if ((paramInt == 1) && (i == 0))
              {
                localObject2 = ((LLCalendarDayInfoBean)((List)localObject1).get(0)).getDate();
                MinsuLLCanlendarActivity.b(MinsuLLCanlendarActivity.this, m.strToDate((String)localObject2, m.b));
              }
              if (i == k - 1)
              {
                localObject2 = ((LLCalendarDayInfoBean)((List)localObject1).get(m - 1)).getDate();
                MinsuLLCanlendarActivity.c(MinsuLLCanlendarActivity.this, m.strToDate((String)localObject2, m.b));
              }
              j = 0;
              while (j < m)
              {
                MinsuLLCanlendarActivity.e(MinsuLLCanlendarActivity.this).put(((LLCalendarDayInfoBean)((List)localObject1).get(j)).getDate(), ((List)localObject1).get(j));
                j += 1;
              }
            }
            catch (NumberFormatException localNumberFormatException)
            {
              for (;;)
              {
                localNumberFormatException.printStackTrace();
              }
              i += 1;
            }
          }
          if (paramInt == 1) {
            MinsuLLCanlendarActivity.a(MinsuLLCanlendarActivity.this, 2);
          }
          while (paramInt != 2) {
            return;
          }
          com.freelxl.baselibrary.widget.a.dismiss();
          if (MinsuLLCanlendarActivity.l(MinsuLLCanlendarActivity.this).before(MinsuLLCanlendarActivity.k(MinsuLLCanlendarActivity.this)))
          {
            com.ziroom.ziroomcustomer.minsu.c.b.getInstance().initData(MinsuLLCanlendarActivity.j(MinsuLLCanlendarActivity.this));
            MinsuLLCanlendarActivity.a(MinsuLLCanlendarActivity.this, MinsuLLCanlendarActivity.l(MinsuLLCanlendarActivity.this), MinsuLLCanlendarActivity.k(MinsuLLCanlendarActivity.this));
            return;
          }
          com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("LLHouseCalendar", " code = " + paramAnonymousInt + " requstNum = " + paramInt);
          ad.shouErrorMessage(null);
          MinsuLLCanlendarActivity.this.finish();
          return;
        }
        com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a.i("LLHouseCalendar", " code = " + paramAnonymousInt + " requstNum = " + paramInt);
        ad.shouErrorMessage(null);
        com.freelxl.baselibrary.widget.a.dismiss();
        MinsuLLCanlendarActivity.this.finish();
      }
    });
  }
  
  private void e()
  {
    this.d = getIntent().getStringExtra("houseName");
    this.e = getIntent().getStringExtra("houseBaseFid");
    this.f = getIntent().getStringExtra("houseRoomFid");
    this.g = getIntent().getStringExtra("bedFid");
    this.r = getIntent().getIntExtra("rentWay", 0);
  }
  
  private void f()
  {
    this.c = new CalendarPickerView.c()
    {
      public boolean isDateSelectable(Date paramAnonymousDate)
      {
        String str = m.getFormatDate(paramAnonymousDate, m.b);
        if (MinsuLLCanlendarActivity.e(MinsuLLCanlendarActivity.this) == null) {
          return false;
        }
        if (paramAnonymousDate.before(MinsuLLCanlendarActivity.m(MinsuLLCanlendarActivity.this))) {
          return false;
        }
        if (MinsuLLCanlendarActivity.e(MinsuLLCanlendarActivity.this) != null)
        {
          paramAnonymousDate = (LLCalendarDayInfoBean)MinsuLLCanlendarActivity.e(MinsuLLCanlendarActivity.this).get(str);
          if (paramAnonymousDate != null)
          {
            if (paramAnonymousDate.getStatus() == 1) {
              return false;
            }
            if (paramAnonymousDate.getStatus() == 3) {
              return false;
            }
            if ((paramAnonymousDate.getStatus() == 0) || (paramAnonymousDate.getStatus() == 2)) {
              return true;
            }
          }
        }
        return false;
      }
    };
  }
  
  private void g()
  {
    if (this.C.size() > 0)
    {
      this.A.setVisibility(0);
      return;
    }
    this.A.setVisibility(8);
  }
  
  private void h()
  {
    setResult(0, getIntent());
    finish();
  }
  
  private void i()
  {
    this.D.clear();
    this.B.clear();
    this.C.clear();
    this.E.clearSelectedDates();
    g();
  }
  
  public void finish()
  {
    super.finish();
    k.animFinishAlpha(this);
  }
  
  public void initTitle()
  {
    this.x = ((CommonTitle)findViewById(2131691272));
    this.x.setLeftButtonType(0);
    this.x.setBottomLineVisible(false);
    this.x.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuLLCanlendarActivity.a(MinsuLLCanlendarActivity.this);
      }
    });
    this.x.setMiddleText(this.d);
    this.x.showRightText(true, getString(2131297343));
    this.x.setOnRightButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        k.toSetPrice2(MinsuLLCanlendarActivity.this, MinsuLLCanlendarActivity.b(MinsuLLCanlendarActivity.this), MinsuLLCanlendarActivity.c(MinsuLLCanlendarActivity.this), MinsuLLCanlendarActivity.d(MinsuLLCanlendarActivity.this), "from_manager_release", 135);
      }
    });
    this.x.updateTitleWidth2();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      return;
      if (paramInt2 == -1) {
        i();
      }
      for (;;)
      {
        b(1);
        return;
        if (paramInt2 != 0) {}
      }
    } while (paramInt2 != -1);
    b(1);
    i();
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
      h();
      return;
    case 2131690169: 
      i();
      this.A.setVisibility(8);
      return;
    }
    c.getDefault().postSticky(new LLCalendarEditData(this.C, this.D));
    k.toLLCalendarDaysEdit(this, this.d, this.e, this.f, this.g, this.r, null, null, 111);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903309);
    e();
    b();
    initTitle();
    b(1);
    a();
  }
  
  protected void onDestroy()
  {
    c.getDefault().removeStickyEvent(LLCalendarEditData.class);
    super.onDestroy();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/MinsuLLCanlendarActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */