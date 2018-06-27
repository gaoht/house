package com.ziroom.ziroomcustomer.ziroomstation.projectdetail;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.freelxl.baselibrary.d.b.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.minsu.adapter.r;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarRowView;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.util.s;
import com.ziroom.ziroomcustomer.ziroomstation.b.b;
import com.ziroom.ziroomcustomer.ziroomstation.projectdetail.b.a.a;
import com.ziroom.ziroomcustomer.ziroomstation.projectdetail.b.a.a.a;
import com.ziroom.ziroomcustomer.ziroomstation.projectdetail.b.a.a.a.a;
import com.ziroom.ziroomcustomer.ziroomstation.projectdetail.view.InventoryCalendarPickerView;
import com.ziroom.ziroomcustomer.ziroomstation.projectdetail.view.InventoryCalendarPickerView.e;
import com.ziroom.ziroomcustomer.ziroomstation.projectdetail.view.InventoryCalendarPickerView.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class InventoryCalendarActivity
  extends BaseActivity
{
  public static final char[] a = "日一二三四五六".toCharArray();
  private InventoryCalendarPickerView b;
  private String c;
  private String d;
  private String e;
  private String f;
  private Map<String, a.a.a.a> g = new HashMap();
  private Calendar r;
  private Calendar s;
  private CommonTitle t;
  private List<Date> u = new ArrayList();
  private com.ziroom.ziroomcustomer.ziroomstation.projectdetail.view.a v;
  private Date w;
  private Date x;
  private TextView y;
  
  private void a()
  {
    this.b = ((InventoryCalendarPickerView)findViewById(2131691033));
    this.y = ((TextView)findViewById(2131691030));
    this.y.setText(this.f);
    CalendarRowView localCalendarRowView = (CalendarRowView)findViewById(2131691032);
    localCalendarRowView.setCellTextColor(getResources().getColor(2131624042));
    int i = 0;
    while (i < 7)
    {
      ((TextView)localCalendarRowView.getChildAt(i)).setText(a[i] + "");
      i += 1;
    }
  }
  
  private void b()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(m.strToDate(this.c, m.b));
    localArrayList.add(m.strToDate(this.d, m.b));
    this.b.init(this.w, this.x).inMode(InventoryCalendarPickerView.j.c).withSelectedDates(localArrayList);
    this.v = new com.ziroom.ziroomcustomer.ziroomstation.projectdetail.view.a(this, this.g, this.b);
    this.b.setDecorators(Arrays.asList(new com.ziroom.ziroomcustomer.minsu.view.timessquare.a[] { this.v }));
    this.b.setCustomDayView(new r());
  }
  
  private void e()
  {
    this.c = getIntent().getStringExtra("originalStartDate");
    this.d = getIntent().getStringExtra("endDate");
    this.e = getIntent().getStringExtra("houseTypeBid");
    this.f = getIntent().getStringExtra("houseName");
    this.r = Calendar.getInstance();
    this.s = Calendar.getInstance();
    this.s.set(5, 1);
    this.r.set(5, 1);
    this.r.add(2, 7);
    this.w = this.s.getTime();
    this.x = this.r.getTime();
    Map localMap = b.buildCalander(this, this.c, this.e);
    com.freelxl.baselibrary.d.a.post(q.B + com.ziroom.ziroomcustomer.ziroomstation.b.d.L).params(localMap).enqueue(new com.ziroom.commonlibrary.a.a(this, new com.freelxl.baselibrary.d.f.d(com.ziroom.ziroomcustomer.ziroomstation.projectdetail.b.a.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.ziroomcustomer.ziroomstation.projectdetail.b.a paramAnonymousa)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousa);
        if ((paramAnonymousa != null) && (paramAnonymousa.getData() != null) && (!s.isEmpty(paramAnonymousa.getData().getListCalendarMonth())))
        {
          InventoryCalendarActivity.a(InventoryCalendarActivity.this, new HashMap());
          Iterator localIterator1 = paramAnonymousa.getData().getListCalendarMonth().iterator();
          while (localIterator1.hasNext())
          {
            Iterator localIterator2 = ((a.a.a)localIterator1.next()).getCalendarList().iterator();
            while (localIterator2.hasNext())
            {
              a.a.a.a locala = (a.a.a.a)localIterator2.next();
              InventoryCalendarActivity.a(InventoryCalendarActivity.this).put(m.changeFormatDate(locala.getDayTime(), m.a, m.b), locala);
            }
          }
          InventoryCalendarActivity.a(InventoryCalendarActivity.this, m.getMonthFirstDay(((a.a.a)paramAnonymousa.getData().getListCalendarMonth().get(0)).getMonthStr()));
          InventoryCalendarActivity.b(InventoryCalendarActivity.this, m.getNextMonthFirstDay(((a.a.a)paramAnonymousa.getData().getListCalendarMonth().get(paramAnonymousa.getData().getListCalendarMonth().size() - 1)).getMonthStr()));
          InventoryCalendarActivity.b(InventoryCalendarActivity.this);
        }
      }
    });
  }
  
  public void finish()
  {
    super.finish();
    k.animFinishAlpha(this);
  }
  
  public void initTitle()
  {
    this.t = ((CommonTitle)findViewById(2131691272));
    this.t.setLeftButtonType(4);
    this.t.setBottomLineVisible(false);
    this.t.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        InventoryCalendarActivity.this.finish();
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903233);
    e();
    a();
    initTitle();
    b();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/projectdetail/InventoryCalendarActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */