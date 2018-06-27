package com.ziroom.ziroomcustomer.sublet.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.fastjson.e;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.dialog.c.a;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.c.o;
import com.ziroom.ziroomcustomer.e.e.q;
import com.ziroom.ziroomcustomer.e.g;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.minsu.adapter.r;
import com.ziroom.ziroomcustomer.minsu.f.ac;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarCellView;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarPickerView;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarPickerView.c;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarPickerView.e;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarPickerView.h;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarPickerView.i;
import com.ziroom.ziroomcustomer.minsu.view.timessquare.CalendarPickerView.j;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class LeaseSubletSelectTimeActivity
  extends BaseActivity
{
  private String A = "因自如房租价格会随市场进行调整，转租发起后的房屋价格可能与您签约时的价格不同";
  private String B;
  private String C;
  private String D;
  private boolean E = true;
  private Context a;
  private String b;
  @BindView(2131691560)
  Button btnNext;
  @BindView(2131689787)
  BasicZiroomToolBar bztb;
  private int c;
  @BindView(2131696704)
  CalendarPickerView cpvCalendarSublet;
  private Unbinder d;
  private e e;
  private com.alibaba.fastjson.b f;
  private String g = "http://zhuanti.ziroom.com/zhuanti/2017/zrk/zhuanzu/index.html";
  @BindView(2131696700)
  LinearLayout llSubletTimeAndTipContainer;
  private String r;
  private String s;
  private String t;
  @BindView(2131696702)
  TextView tvLiveInTime;
  @BindView(2131696699)
  TextView tvSelectDateTip;
  @BindView(2131696703)
  TextView tvSubletPrice;
  @BindView(2131696436)
  TextView tvSubletTime;
  @BindView(2131696701)
  TextView tvSubletTip;
  private String u;
  private String v;
  private String w;
  private String x = "入住日期 说明";
  private String y = "在您办理退租后，自如将对该房源进行退租配置和保洁服务，因此新用户的可入住日期，将在您的退租日期的几天后";
  private String z = "转租价格说明";
  
  private void a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", com.ziroom.commonlibrary.login.a.getToken(getApplicationContext()));
    localHashMap.put("contract_code", this.b);
    com.freelxl.baselibrary.d.a.get(q.Q + e.q.g + "?" + ah.encodeGetParams(g.getCommonHouseSign(localHashMap))).tag(this).enqueue(new f(this, new o())
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        u.d("OKHttp", "===" + paramAnonymouse.toString());
        LeaseSubletSelectTimeActivity.a(LeaseSubletSelectTimeActivity.this, com.alibaba.fastjson.a.parseObject(paramAnonymouse.toString()));
        if (LeaseSubletSelectTimeActivity.b(LeaseSubletSelectTimeActivity.this) != null)
        {
          LeaseSubletSelectTimeActivity.b(LeaseSubletSelectTimeActivity.this, LeaseSubletSelectTimeActivity.b(LeaseSubletSelectTimeActivity.this));
          return;
        }
        LeaseSubletSelectTimeActivity.this.showToast("");
      }
    });
  }
  
  private void a(TextView paramTextView, String paramString)
  {
    if (ae.notNull(paramString))
    {
      paramTextView.setVisibility(0);
      paramTextView.setText(paramString);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  private void a(e parame)
  {
    this.s = parame.getString("begin_date");
    this.t = parame.getString("end_date");
    this.f = parame.getJSONArray("lease_date");
    this.r = parame.getString("checkin_date");
    this.u = parame.getString("penalty_type_text");
    this.v = parame.getString("renter_checkin_date");
    this.w = parame.getString("estimate_price");
    a(this.r, this.u, this.v, this.w);
    this.g = parame.getString("turn_rule_url");
    if (ae.notNull(this.g)) {
      this.bztb.addButton(this.bztb.newButton("转租规则", new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          JsBridgeWebActivity.start(LeaseSubletSelectTimeActivity.c(LeaseSubletSelectTimeActivity.this), "转租规则", LeaseSubletSelectTimeActivity.d(LeaseSubletSelectTimeActivity.this));
        }
      }));
    }
    e locale = parame.getJSONObject("renter_checkin_date_desc");
    this.x = locale.getString("prompt_title");
    this.y = locale.getString("prompt_text");
    locale = parame.getJSONObject("price_prompt");
    this.z = locale.getString("prompt_title");
    this.A = locale.getString("prompt_text");
    parame = parame.getJSONObject("confirm_prompt");
    this.B = parame.getString("prompt_title");
    this.C = parame.getString("prompt_text");
    b();
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (ae.notNull(this.r))
    {
      this.tvSelectDateTip.setVisibility(8);
      this.llSubletTimeAndTipContainer.setVisibility(0);
      this.tvSubletTime.setText(paramString1);
      this.tvSubletTip.setText(paramString2);
      this.tvSubletTip.getPaint().setFlags(8);
      return;
    }
    this.tvSelectDateTip.setVisibility(0);
    this.llSubletTimeAndTipContainer.setVisibility(8);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    a(paramString1, paramString2);
    a(this.tvLiveInTime, paramString3);
    a(this.tvSubletPrice, paramString4);
  }
  
  private void b()
  {
    this.cpvCalendarSublet.setVisibility(0);
    this.cpvCalendarSublet.init(m.strToDate(this.s, m.b), m.getDateAfter(m.strToDate(this.t, m.b), 1)).inMode(CalendarPickerView.j.a);
    this.cpvCalendarSublet.setDecorators(Arrays.asList(new com.ziroom.ziroomcustomer.minsu.view.timessquare.a[] { new a(this.a, this.cpvCalendarSublet) }));
    this.cpvCalendarSublet.setCustomDayView(new r());
    this.cpvCalendarSublet.setDateSelectableFilter(new CalendarPickerView.c()
    {
      public boolean isDateSelectable(Date paramAnonymousDate)
      {
        return (!ae.notNull(LeaseSubletSelectTimeActivity.a(LeaseSubletSelectTimeActivity.this))) || (!m.getFormatDate(paramAnonymousDate, m.b).equals(LeaseSubletSelectTimeActivity.a(LeaseSubletSelectTimeActivity.this)));
      }
    });
    this.cpvCalendarSublet.setOnInvalidDateSelectedListener(new CalendarPickerView.i()
    {
      public void onInvalidDateSelected(Date paramAnonymousDate) {}
    });
    this.cpvCalendarSublet.setOnDateSelectedListener(new CalendarPickerView.h()
    {
      public void onDateSelected(Date paramAnonymousDate)
      {
        if ((ae.notNull(LeaseSubletSelectTimeActivity.a(LeaseSubletSelectTimeActivity.this))) && (paramAnonymousDate.before(m.strToDate(LeaseSubletSelectTimeActivity.a(LeaseSubletSelectTimeActivity.this), m.b)))) {
          LeaseSubletSelectTimeActivity.a(LeaseSubletSelectTimeActivity.this, "");
        }
        LeaseSubletSelectTimeActivity.a(LeaseSubletSelectTimeActivity.this, m.getFormatDate(paramAnonymousDate, m.b));
        LeaseSubletSelectTimeActivity.b(LeaseSubletSelectTimeActivity.this, LeaseSubletSelectTimeActivity.a(LeaseSubletSelectTimeActivity.this));
      }
      
      public void onDateUnselected(Date paramAnonymousDate) {}
    });
  }
  
  private void d(String paramString)
  {
    if (ae.notNull(paramString))
    {
      com.freelxl.baselibrary.d.a.isLog(true);
      HashMap localHashMap = new HashMap();
      localHashMap.put("token", com.ziroom.commonlibrary.login.a.getToken(getApplicationContext()));
      localHashMap.put("checkin_date", paramString + "");
      localHashMap.put("contract_code", this.b);
      com.freelxl.baselibrary.d.a.get(q.Q + e.q.f + "?" + ah.encodeGetParams(g.getCommonHouseSign(localHashMap))).tag(this).enqueue(new f(this, new o())
      {
        public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          u.d("OKHttp", "===" + paramAnonymouse.toString());
          Object localObject = com.alibaba.fastjson.a.parseObject(paramAnonymouse.toString());
          if (localObject != null)
          {
            paramAnonymouse = ((e)localObject).getString("renter_checkin_date");
            String str = ((e)localObject).getString("penalty_type_text");
            localObject = ((e)localObject).getString("estimate_price");
            LeaseSubletSelectTimeActivity.a(LeaseSubletSelectTimeActivity.this, LeaseSubletSelectTimeActivity.a(LeaseSubletSelectTimeActivity.this), str, paramAnonymouse, (String)localObject);
            return;
          }
          LeaseSubletSelectTimeActivity.this.showToast("服务器出现异常，请稍后再试");
        }
      });
      return;
    }
    showToast("时间为空");
  }
  
  private void e()
  {
    this.bztb.setTitle("转租申请");
    if (this.E)
    {
      this.D = "确认并提交";
      this.btnNext.setText("下一步");
      return;
    }
    this.btnNext.setText("修改时间");
    this.D = "确认并提交";
  }
  
  private void f()
  {
    com.freelxl.baselibrary.d.a.isLog(true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", com.ziroom.commonlibrary.login.a.getToken(getApplicationContext()));
    localHashMap.put("contract_code", this.b);
    localHashMap.put("checkin_date", this.r);
    com.freelxl.baselibrary.d.a.post(q.Q + e.q.i).tag(this).params(g.getCommonHouseSign(localHashMap)).enqueue(new f(this, new o())
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        af.showToast(LeaseSubletSelectTimeActivity.this, "修改时间成功");
        LeaseSubletSelectTimeActivity.this.finish();
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904841);
    this.a = this;
    this.d = ButterKnife.bind(this);
    this.b = getIntent().getStringExtra("lease");
    this.c = getIntent().getIntExtra("version", 2);
    this.E = getIntent().getBooleanExtra("isNewSublet", true);
    e();
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.d.unbind();
  }
  
  @OnClick({2131696702, 2131696703, 2131691560})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((!ae.notNull(this.x)) && (!ae.notNull(this.y)));
        com.ziroom.ziroomcustomer.dialog.c.newBuilder(this.a).setButtonText("我知道了").setTitle(this.x).setContent(this.y).build().show();
        return;
      } while ((!ae.notNull(this.z)) && (!ae.notNull(this.A)));
      com.ziroom.ziroomcustomer.dialog.c.newBuilder(this.a).setButtonText("我知道了").setTitle(this.z).setContent(this.A).build().show();
      return;
      if (!ae.notNull(this.r)) {
        break;
      }
    } while ((!ae.notNull(this.B)) && (!ae.notNull(this.C)));
    com.ziroom.ziroomcustomer.dialog.c.newBuilder(this.a).setTitle(this.B).setContent(this.C).setButtonText("再想想").setSecondButtonText(this.D).setOnSecondClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (LeaseSubletSelectTimeActivity.f(LeaseSubletSelectTimeActivity.this))
        {
          paramAnonymousView = new Intent(LeaseSubletSelectTimeActivity.c(LeaseSubletSelectTimeActivity.this), LeaseSubletInfomationActivity.class);
          paramAnonymousView.putExtra("lease", LeaseSubletSelectTimeActivity.g(LeaseSubletSelectTimeActivity.this));
          paramAnonymousView.putExtra("subletTime", LeaseSubletSelectTimeActivity.a(LeaseSubletSelectTimeActivity.this));
          LeaseSubletSelectTimeActivity.this.startActivity(paramAnonymousView);
          return;
        }
        LeaseSubletSelectTimeActivity.h(LeaseSubletSelectTimeActivity.this);
      }
    }).build().show();
    return;
    showToast("请先选择预计退租日期");
  }
  
  public class a
    implements com.ziroom.ziroomcustomer.minsu.view.timessquare.a
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
      if (paramCalendarCellView.isCurrentMonth())
      {
        if (paramCalendarCellView.isSelectable()) {
          if (paramCalendarCellView.isSelected())
          {
            ac.absSizeColor(paramCalendarCellView.getDayOfMonthTextView(), a(paramDate), 14, Color.parseColor("#ffffff"));
            paramCalendarCellView.getDayOfMonthTextView().setBackgroundResource(2130837707);
          }
        }
        for (;;)
        {
          if ((ae.notNull(LeaseSubletSelectTimeActivity.a(LeaseSubletSelectTimeActivity.this))) && (m.getFormatDate(paramDate, m.b).equals(LeaseSubletSelectTimeActivity.a(LeaseSubletSelectTimeActivity.this))))
          {
            ac.absSizeColor(paramCalendarCellView.getDayOfMonthTextView(), a(paramDate), 14, Color.parseColor("#ffffff"));
            paramCalendarCellView.getDayOfMonthTextView().setBackgroundResource(2130837707);
          }
          return;
          ac.absSizeColor(paramCalendarCellView.getDayOfMonthTextView(), a(paramDate), 14, Color.parseColor("#444444"));
          if (paramCalendarCellView.isToday())
          {
            paramCalendarCellView.getDayOfMonthTextView().setBackgroundResource(2130837696);
          }
          else
          {
            paramCalendarCellView.getDayOfMonthTextView().setBackgroundResource(2131624349);
            continue;
            ac.absSizeColor(paramCalendarCellView.getDayOfMonthTextView(), a(paramDate), 14, Color.parseColor("#cccccc"));
            if (paramCalendarCellView.isToday()) {
              paramCalendarCellView.getDayOfMonthTextView().setBackgroundResource(2130837696);
            } else {
              paramCalendarCellView.getDayOfMonthTextView().setBackgroundResource(2131624349);
            }
          }
        }
      }
      ac.absSizeColor(paramCalendarCellView.getDayOfMonthTextView(), a(paramDate), 14, Color.parseColor("#ffffff"));
      paramCalendarCellView.getDayOfMonthTextView().setBackgroundResource(2131624349);
    }
    
    public void decorate(CalendarCellView paramCalendarCellView, Date paramDate)
    {
      String str;
      int i;
      if (paramCalendarCellView.isSelectable())
      {
        str = m.getFormatDate(paramDate, m.b);
        i = 0;
      }
      for (;;)
      {
        if (i < LeaseSubletSelectTimeActivity.e(LeaseSubletSelectTimeActivity.this).size())
        {
          if (!str.equals(LeaseSubletSelectTimeActivity.e(LeaseSubletSelectTimeActivity.this).getJSONObject(i).getString("date"))) {
            break label98;
          }
          if (LeaseSubletSelectTimeActivity.e(LeaseSubletSelectTimeActivity.this).getJSONObject(i).getIntValue("status") == 0)
          {
            paramCalendarCellView.setSelectable(false);
            paramCalendarCellView.setEnabled(false);
          }
        }
        a(paramCalendarCellView, paramDate);
        paramCalendarCellView.setBackgroundResource(2131624349);
        return;
        label98:
        i += 1;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sublet/activity/LeaseSubletSelectTimeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */