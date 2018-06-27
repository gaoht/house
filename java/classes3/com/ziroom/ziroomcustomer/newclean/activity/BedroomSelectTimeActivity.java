package com.ziroom.ziroomcustomer.newclean.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.collection.GrowingIO;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.c;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.commonlibrary.widget.unifiedziroom.e.a;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.utils.i;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newclean.b.ad;
import com.ziroom.ziroomcustomer.newclean.b.b;
import com.ziroom.ziroomcustomer.newclean.cardpay.MyGridView;
import com.ziroom.ziroomcustomer.newclean.d.ay;
import com.ziroom.ziroomcustomer.newclean.d.az;
import com.ziroom.ziroomcustomer.newclean.d.bj;
import com.ziroom.ziroomcustomer.newclean.d.bk;
import com.ziroom.ziroomcustomer.newclean.d.u;
import com.ziroom.ziroomcustomer.newclean.d.x;
import com.ziroom.ziroomcustomer.util.p;
import com.ziroom.ziroomcustomer.widget.HorizontalListView;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class BedroomSelectTimeActivity
  extends BaseActivity
{
  private boolean A = false;
  private List<bj> B = new ArrayList();
  private List<String> C = new ArrayList();
  private String D;
  private String E;
  private List<bk> F = new ArrayList();
  private String G;
  private az H;
  private List<x> I = new ArrayList();
  private String J;
  private double K;
  private String L;
  private String M;
  private boolean N;
  private String O;
  private String P;
  private String Q;
  private String R;
  private boolean S = false;
  private boolean T = false;
  private BedroomSelectTimeActivity a;
  private Unbinder b;
  private List<u> c = new ArrayList();
  private List<ay> d = new ArrayList();
  private List<String> e = new ArrayList();
  private ad f;
  private b g;
  @BindView(2131689961)
  ImageView mIvSwitch;
  @BindView(2131689959)
  LabeledEditText mLetBill;
  @BindView(2131689957)
  LabeledEditText mLetLength;
  @BindView(2131689962)
  View mLineJudge;
  @BindView(2131689968)
  LinearLayout mLlBedroomTime;
  @BindView(2131689958)
  LinearLayout mLlBill;
  @BindView(2131689963)
  LinearLayout mLlJudgeTip;
  @BindView(2131689966)
  LinearLayout mLlWeekTime;
  @BindView(2131689965)
  LinearLayout mPublicTip;
  @BindView(2131689970)
  TextView mTvBedTip;
  @BindView(2131689969)
  TextView mTvBedroomTime;
  @BindView(2131689960)
  TextView mTvBillTip;
  @BindView(2131689964)
  TextView mTvPublicTip;
  @BindView(2131689967)
  TextView mTvWeekTime;
  @BindView(2131689974)
  View mVPoint;
  @BindView(2131689971)
  View mVTip;
  @BindView(2131689972)
  HorizontalListView mZiHlData;
  @BindView(2131689973)
  MyGridView myGvHome;
  private boolean r = false;
  private com.ziroom.ziroomcustomer.newclean.c.f s;
  private String t;
  private String u;
  private String v;
  private Double w;
  private String x;
  private int y;
  private int z;
  
  private void a()
  {
    Object localObject = ApplicationEx.c.getUser();
    if (localObject == null)
    {
      com.freelxl.baselibrary.f.g.textToast(this.a, "请重新登录");
      finish();
      return;
    }
    this.Q = ((UserInfo)localObject).getUid();
    this.P = ((UserInfo)localObject).getRealName();
    j.requestFocus(findViewById(2131689541));
    localObject = getIntent().getStringExtra("bedSelectTimeBean");
    this.E = getIntent().getStringExtra("serviceInfoId");
    this.G = getIntent().getStringExtra("addressId");
    this.D = getIntent().getStringExtra("houseCode");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = (com.ziroom.ziroomcustomer.newclean.d.d)com.alibaba.fastjson.a.parseObject((String)localObject, com.ziroom.ziroomcustomer.newclean.d.d.class);
      this.t = ((com.ziroom.ziroomcustomer.newclean.d.d)localObject).getAppointDate();
      this.u = ((com.ziroom.ziroomcustomer.newclean.d.d)localObject).getAppointTime();
      this.x = ((com.ziroom.ziroomcustomer.newclean.d.d)localObject).getAppointDateTime();
      this.N = ((com.ziroom.ziroomcustomer.newclean.d.d)localObject).isPublicArea();
      this.v = ((com.ziroom.ziroomcustomer.newclean.d.d)localObject).getServicePmId();
      this.w = ((com.ziroom.ziroomcustomer.newclean.d.d)localObject).getServicePrice();
      this.O = ((com.ziroom.ziroomcustomer.newclean.d.d)localObject).getServicePmShowName();
      this.L = ((com.ziroom.ziroomcustomer.newclean.d.d)localObject).getServiePmName();
      if (!this.N)
      {
        this.J = ((com.ziroom.ziroomcustomer.newclean.d.d)localObject).getDispatchId();
        this.K = ((com.ziroom.ziroomcustomer.newclean.d.d)localObject).getDispatchPrice().doubleValue();
        this.M = ((com.ziroom.ziroomcustomer.newclean.d.d)localObject).getDiapatchTips();
      }
      if ((TextUtils.isEmpty(this.t)) || (TextUtils.isEmpty(this.x))) {
        break label410;
      }
      this.mLetLength.setText(this.O);
      this.mLetBill.setText((int)this.K + "元");
      this.mTvBillTip.setText(this.M);
      this.A = true;
      this.r = this.N;
      a(this.r);
      if (!this.N)
      {
        if (this.K <= 0.0D) {
          break label398;
        }
        this.mLlBill.setVisibility(0);
      }
    }
    for (;;)
    {
      f();
      this.f = new ad(this.a, this.B);
      this.mZiHlData.setAdapter(this.f);
      this.g = new b(4, this.d, this.a);
      this.myGvHome.setAdapter(this.g);
      return;
      label398:
      this.mLlBill.setVisibility(8);
      continue;
      label410:
      this.A = false;
    }
  }
  
  private void a(com.ziroom.ziroomcustomer.newclean.d.g paramg, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.r = true;
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject();
        if (!this.r) {
          continue;
        }
        ((JSONObject)localObject1).put("status", "open");
        GrowingIO.getInstance().track("service_bedroom_ispublic", (JSONObject)localObject1);
      }
      catch (Exception localException)
      {
        Object localObject1;
        Intent localIntent;
        com.ziroom.ziroomcustomer.newclean.d.d locald;
        Object localObject2;
        localException.printStackTrace();
        continue;
        locald.setBillId(this.H.getBillId());
        locald.setEmployeeLogicCode(this.H.getEmployeeCode());
        continue;
        paramg = new x();
        paramg.setGoodsId(this.J);
        paramg.setNum(1);
        this.I.add(paramg);
        locald.setGoods(this.I);
        locald.setDispatchId(this.J);
        locald.setDispatchPrice(Double.valueOf(this.K));
        locald.setDiapatchTips(this.M);
        continue;
      }
      localIntent = new Intent();
      locald = new com.ziroom.ziroomcustomer.newclean.d.d();
      locald.setAppointDate(this.t);
      locald.setAppointTime(this.u);
      locald.setAppointDateTime(this.x);
      locald.setServicePmId(this.v);
      locald.setServicePrice(this.w);
      locald.setServicePmShowName(this.O);
      locald.setServiePmName(this.L);
      locald.setSelectTimeIndex(this.z + "");
      locald.setSelectDateIndex(this.y + "");
      locald.setPublicArea(this.r);
      locald.setTimeShowText(paramg.getText());
      locald.setAppointShowTime(this.t + "  " + paramg.getServiceStartTimePoint() + "-" + paramg.getServiceEndTimePoint());
      if (!this.r) {
        continue;
      }
      locald.setDispatchPrice(Double.valueOf(0.0D));
      if (!paramBoolean) {
        continue;
      }
      locald.setBillId(paramg.getBillId());
      locald.setEmployeeLogicCode(paramg.getEmployeeCode());
      localObject2 = "";
      if (!TextUtils.isEmpty(paramg.getEmployeeName())) {
        localObject2 = paramg.getEmployeeName();
      }
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramg.getAge())) {
        localObject1 = (String)localObject2 + " " + paramg.getAge() + "岁";
      }
      localObject2 = localObject1;
      if (!TextUtils.isEmpty(paramg.getOriginPlaceName())) {
        localObject2 = (String)localObject1 + " " + paramg.getOriginPlaceName();
      }
      locald.setEmployeeShowContent((String)localObject2);
      localIntent.putExtra("bedSelectTimeBean", com.alibaba.fastjson.a.toJSONString(locald));
      setResult(-1, localIntent);
      finish();
      return;
      ((JSONObject)localObject1).put("status", "close");
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mIvSwitch.setBackgroundResource(2130840292);
      this.mLlJudgeTip.setVisibility(0);
      this.mLineJudge.setVisibility(8);
      this.mLlBill.setVisibility(8);
      return;
    }
    this.mIvSwitch.setBackgroundResource(2130840291);
    this.mLlJudgeTip.setVisibility(8);
    this.mLineJudge.setVisibility(0);
    this.mLlBill.setVisibility(0);
  }
  
  private void b()
  {
    this.mZiHlData.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        BedroomSelectTimeActivity.a(BedroomSelectTimeActivity.this, false);
        BedroomSelectTimeActivity.a(BedroomSelectTimeActivity.this, "");
        BedroomSelectTimeActivity.a(BedroomSelectTimeActivity.this).setSelectPosition(paramAnonymousInt);
        BedroomSelectTimeActivity.b(BedroomSelectTimeActivity.this, (String)BedroomSelectTimeActivity.b(BedroomSelectTimeActivity.this).get(paramAnonymousInt));
        BedroomSelectTimeActivity.a(BedroomSelectTimeActivity.this, paramAnonymousInt);
        BedroomSelectTimeActivity.c(BedroomSelectTimeActivity.this);
      }
    });
    this.myGvHome.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        if ("0".equals(((ay)BedroomSelectTimeActivity.d(BedroomSelectTimeActivity.this).get(paramAnonymousInt)).getFlag()))
        {
          if (BedroomSelectTimeActivity.e(BedroomSelectTimeActivity.this) != null) {
            BedroomSelectTimeActivity.e(BedroomSelectTimeActivity.this).setSelectPosition(paramAnonymousInt);
          }
          BedroomSelectTimeActivity.c(BedroomSelectTimeActivity.this, ((ay)BedroomSelectTimeActivity.d(BedroomSelectTimeActivity.this).get(paramAnonymousInt)).getDatePlan());
          BedroomSelectTimeActivity.a(BedroomSelectTimeActivity.this, ((ay)BedroomSelectTimeActivity.d(BedroomSelectTimeActivity.this).get(paramAnonymousInt)).getTimePoint());
          BedroomSelectTimeActivity.b(BedroomSelectTimeActivity.this, paramAnonymousInt);
          return;
        }
        com.freelxl.baselibrary.f.g.textToast(BedroomSelectTimeActivity.f(BedroomSelectTimeActivity.this), "已约满，请选择其他时间");
      }
    });
    p.showGuide(this, "clean_bedroom_time_list_01", 2130904680, new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        p.showGuide(BedroomSelectTimeActivity.this, "clean_bedroom_time_list_02", 2130904681, null, null);
      }
    }, null);
  }
  
  private void e()
  {
    if ((this.e == null) && (this.e.size() == 0)) {
      return;
    }
    this.s = new com.ziroom.ziroomcustomer.newclean.c.f(this.a, this.e);
    this.s.show();
    this.s.setmListener(new com.ziroom.ziroomcustomer.newclean.c.f.a()
    {
      public void showHour(String paramAnonymousString, int paramAnonymousInt)
      {
        BedroomSelectTimeActivity.this.mLetLength.setText(paramAnonymousString);
        BedroomSelectTimeActivity.d(BedroomSelectTimeActivity.this, ((bk)BedroomSelectTimeActivity.g(BedroomSelectTimeActivity.this).get(paramAnonymousInt)).getServPmId());
        BedroomSelectTimeActivity.e(BedroomSelectTimeActivity.this, ((bk)BedroomSelectTimeActivity.g(BedroomSelectTimeActivity.this).get(paramAnonymousInt)).getServPmName());
        BedroomSelectTimeActivity.a(BedroomSelectTimeActivity.this, Double.valueOf(((bk)BedroomSelectTimeActivity.g(BedroomSelectTimeActivity.this).get(paramAnonymousInt)).getServPmPrice()));
        BedroomSelectTimeActivity.f(BedroomSelectTimeActivity.this, paramAnonymousString);
        if (!BedroomSelectTimeActivity.h(BedroomSelectTimeActivity.this))
        {
          if (((bk)BedroomSelectTimeActivity.g(BedroomSelectTimeActivity.this).get(paramAnonymousInt)).getDispatchItemCode() == null) {
            break label338;
          }
          BedroomSelectTimeActivity.g(BedroomSelectTimeActivity.this, ((bk)BedroomSelectTimeActivity.g(BedroomSelectTimeActivity.this).get(paramAnonymousInt)).getDispatchItemCode());
          BedroomSelectTimeActivity.a(BedroomSelectTimeActivity.this, ((bk)BedroomSelectTimeActivity.g(BedroomSelectTimeActivity.this).get(paramAnonymousInt)).getDispatchItemPrice().doubleValue());
          BedroomSelectTimeActivity.h(BedroomSelectTimeActivity.this, ((bk)BedroomSelectTimeActivity.g(BedroomSelectTimeActivity.this).get(paramAnonymousInt)).getTips());
          if (BedroomSelectTimeActivity.i(BedroomSelectTimeActivity.this) <= 0.0D) {
            break label323;
          }
          BedroomSelectTimeActivity.this.mLlBill.setVisibility(0);
          BedroomSelectTimeActivity.this.mLetBill.setText((int)BedroomSelectTimeActivity.i(BedroomSelectTimeActivity.this) + "元");
          BedroomSelectTimeActivity.this.mTvBillTip.setText(BedroomSelectTimeActivity.j(BedroomSelectTimeActivity.this));
        }
        for (;;)
        {
          BedroomSelectTimeActivity.a(BedroomSelectTimeActivity.this, false);
          BedroomSelectTimeActivity.a(BedroomSelectTimeActivity.this, "");
          BedroomSelectTimeActivity.c(BedroomSelectTimeActivity.this);
          return;
          label323:
          BedroomSelectTimeActivity.this.mLlBill.setVisibility(8);
          break;
          label338:
          BedroomSelectTimeActivity.this.mLlBill.setVisibility(8);
        }
      }
    });
  }
  
  private void f()
  {
    n.requestJudgePublicArea(this.a, this.Q, this.P, this.D, new com.freelxl.baselibrary.d.c.a(new com.ziroom.ziroomcustomer.e.c.f(az.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        j.showFailureMessage(BedroomSelectTimeActivity.f(BedroomSelectTimeActivity.this), paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, az paramAnonymousaz)
      {
        if (paramAnonymousaz != null) {
          if (!BedroomSelectTimeActivity.k(BedroomSelectTimeActivity.this))
          {
            if (paramAnonymousaz.getPublicArea() != 0) {
              break label55;
            }
            BedroomSelectTimeActivity.b(BedroomSelectTimeActivity.this, false);
            BedroomSelectTimeActivity.c(BedroomSelectTimeActivity.this, false);
          }
        }
        for (;;)
        {
          BedroomSelectTimeActivity.a(BedroomSelectTimeActivity.this, paramAnonymousaz);
          BedroomSelectTimeActivity.l(BedroomSelectTimeActivity.this);
          return;
          label55:
          if (paramAnonymousaz.getPublicArea() == 1)
          {
            BedroomSelectTimeActivity.b(BedroomSelectTimeActivity.this, true);
            BedroomSelectTimeActivity.c(BedroomSelectTimeActivity.this, true);
            if (!TextUtils.isEmpty(paramAnonymousaz.getDoc())) {
              BedroomSelectTimeActivity.this.mTvPublicTip.setText(paramAnonymousaz.getDoc());
            }
          }
        }
      }
    });
  }
  
  private void g()
  {
    if (this.r) {}
    for (int i = 1;; i = 0)
    {
      n.requestServiceItem(this.a, this.E, i, this.Q, new com.freelxl.baselibrary.d.c.a(new com.ziroom.ziroomcustomer.e.c.e(bk.class))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          j.showFailureMessage(BedroomSelectTimeActivity.f(BedroomSelectTimeActivity.this), paramAnonymousThrowable);
        }
        
        public void onSuccess(int paramAnonymousInt, List<bk> paramAnonymousList)
        {
          if (paramAnonymousList != null)
          {
            BedroomSelectTimeActivity.g(BedroomSelectTimeActivity.this).clear();
            BedroomSelectTimeActivity.g(BedroomSelectTimeActivity.this).addAll(paramAnonymousList);
            paramAnonymousList = paramAnonymousList.iterator();
            while (paramAnonymousList.hasNext())
            {
              bk localbk = (bk)paramAnonymousList.next();
              BedroomSelectTimeActivity.m(BedroomSelectTimeActivity.this).add(localbk.getServPmName() + "    " + (int)localbk.getServPmPrice() + "元");
              if ((localbk.getDefaultChoose() != null) && (localbk.getDefaultChoose().intValue() == 1) && (!BedroomSelectTimeActivity.k(BedroomSelectTimeActivity.this)))
              {
                BedroomSelectTimeActivity.f(BedroomSelectTimeActivity.this, localbk.getServPmName() + "    " + (int)localbk.getServPmPrice() + "元");
                BedroomSelectTimeActivity.this.mLetLength.setText(BedroomSelectTimeActivity.n(BedroomSelectTimeActivity.this));
                BedroomSelectTimeActivity.d(BedroomSelectTimeActivity.this, localbk.getServPmId());
                BedroomSelectTimeActivity.a(BedroomSelectTimeActivity.this, Double.valueOf(localbk.getServPmPrice()));
                BedroomSelectTimeActivity.e(BedroomSelectTimeActivity.this, localbk.getServPmName());
                if (!BedroomSelectTimeActivity.h(BedroomSelectTimeActivity.this))
                {
                  if (localbk.getDispatchItemCode() != null)
                  {
                    BedroomSelectTimeActivity.g(BedroomSelectTimeActivity.this, localbk.getDispatchItemCode());
                    BedroomSelectTimeActivity.a(BedroomSelectTimeActivity.this, localbk.getDispatchItemPrice().doubleValue());
                    BedroomSelectTimeActivity.h(BedroomSelectTimeActivity.this, localbk.getTips());
                    if (BedroomSelectTimeActivity.i(BedroomSelectTimeActivity.this) > 0.0D) {
                      BedroomSelectTimeActivity.this.mLlBill.setVisibility(0);
                    }
                    for (;;)
                    {
                      BedroomSelectTimeActivity.this.mLetBill.setText((int)BedroomSelectTimeActivity.i(BedroomSelectTimeActivity.this) + "元");
                      BedroomSelectTimeActivity.this.mTvBillTip.setText(BedroomSelectTimeActivity.j(BedroomSelectTimeActivity.this));
                      break;
                      BedroomSelectTimeActivity.this.mLlBill.setVisibility(8);
                    }
                  }
                  BedroomSelectTimeActivity.this.mLlBill.setVisibility(8);
                }
              }
            }
            BedroomSelectTimeActivity.o(BedroomSelectTimeActivity.this);
          }
        }
      });
      return;
    }
  }
  
  private void h()
  {
    String str2 = "";
    String str1;
    int i;
    if (this.r)
    {
      str1 = str2;
      if (this.H != null)
      {
        str1 = str2;
        if (!TextUtils.isEmpty(this.H.getBillId())) {
          str1 = this.H.getBillId();
        }
      }
      i = 1;
    }
    for (;;)
    {
      n.requestCleanData(this.a, this.E, i, this.Q, this.D, str1, new com.freelxl.baselibrary.d.c.a(new com.ziroom.ziroomcustomer.e.c.e(u.class))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          j.showFailureMessage(BedroomSelectTimeActivity.f(BedroomSelectTimeActivity.this), paramAnonymousThrowable);
        }
        
        public void onSuccess(int paramAnonymousInt, List<u> paramAnonymousList)
        {
          paramAnonymousInt = 0;
          if (paramAnonymousList != null)
          {
            BedroomSelectTimeActivity.p(BedroomSelectTimeActivity.this).clear();
            BedroomSelectTimeActivity.p(BedroomSelectTimeActivity.this).addAll(paramAnonymousList);
            BedroomSelectTimeActivity.b(BedroomSelectTimeActivity.this).clear();
            BedroomSelectTimeActivity.q(BedroomSelectTimeActivity.this).clear();
            if ((BedroomSelectTimeActivity.p(BedroomSelectTimeActivity.this) != null) && (BedroomSelectTimeActivity.p(BedroomSelectTimeActivity.this).size() > 0))
            {
              paramAnonymousList = BedroomSelectTimeActivity.p(BedroomSelectTimeActivity.this).iterator();
              while (paramAnonymousList.hasNext())
              {
                Object localObject = (u)paramAnonymousList.next();
                BedroomSelectTimeActivity.b(BedroomSelectTimeActivity.this).add(((u)localObject).getDate());
                String str = i.getDayTime(((u)localObject).getDateWeek(), ((u)localObject).getDate());
                localObject = i.getCandleTime(((u)localObject).getDate());
                BedroomSelectTimeActivity.q(BedroomSelectTimeActivity.this).add(new bj(str, (String)localObject));
              }
            }
            BedroomSelectTimeActivity.a(BedroomSelectTimeActivity.this).notifyDataSetChanged();
            if (BedroomSelectTimeActivity.k(BedroomSelectTimeActivity.this)) {
              while (paramAnonymousInt < BedroomSelectTimeActivity.p(BedroomSelectTimeActivity.this).size())
              {
                if (BedroomSelectTimeActivity.r(BedroomSelectTimeActivity.this).equals(((u)BedroomSelectTimeActivity.p(BedroomSelectTimeActivity.this).get(paramAnonymousInt)).getDate())) {
                  BedroomSelectTimeActivity.a(BedroomSelectTimeActivity.this).setSelectPosition(paramAnonymousInt);
                }
                paramAnonymousInt += 1;
              }
            }
            BedroomSelectTimeActivity.b(BedroomSelectTimeActivity.this, ((u)BedroomSelectTimeActivity.p(BedroomSelectTimeActivity.this).get(0)).getDate());
            BedroomSelectTimeActivity.a(BedroomSelectTimeActivity.this).setSelectPosition(0);
            BedroomSelectTimeActivity.c(BedroomSelectTimeActivity.this);
          }
        }
      });
      return;
      i = 0;
      str1 = "";
    }
  }
  
  private void i()
  {
    if (TextUtils.isEmpty(this.v))
    {
      com.freelxl.baselibrary.f.g.textToast(this.a, "请先选择时间段");
      return;
    }
    if (TextUtils.isEmpty(this.t))
    {
      com.freelxl.baselibrary.f.g.textToast(this.a, "请先选择日期");
      return;
    }
    if (this.r) {}
    for (int i = 1;; i = 0)
    {
      n.requestCleanTimePoint(this.a, this.Q, this.t, this.E, this.v, this.G, i, this.H, new com.ziroom.ziroomcustomer.e.a.d(this.a, new com.ziroom.ziroomcustomer.e.c.f(com.ziroom.ziroomcustomer.newclean.d.f.class))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
          BedroomSelectTimeActivity.s(BedroomSelectTimeActivity.this);
          BedroomSelectTimeActivity.d(BedroomSelectTimeActivity.this).clear();
          BedroomSelectTimeActivity.e(BedroomSelectTimeActivity.this).notifyDataSetChanged();
          BedroomSelectTimeActivity.a(BedroomSelectTimeActivity.this, "");
          BedroomSelectTimeActivity.this.mLlWeekTime.setVisibility(8);
          BedroomSelectTimeActivity.this.mLlBedroomTime.setVisibility(8);
          BedroomSelectTimeActivity.this.mTvBedTip.setVisibility(8);
          BedroomSelectTimeActivity.this.mVTip.setVisibility(8);
        }
        
        public void onSuccess(int paramAnonymousInt, com.ziroom.ziroomcustomer.newclean.d.f paramAnonymousf)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousf);
          BedroomSelectTimeActivity.s(BedroomSelectTimeActivity.this);
          if (paramAnonymousf != null)
          {
            if (paramAnonymousf.getPublicAreaStatus() != null)
            {
              paramAnonymousInt = paramAnonymousf.getPublicAreaStatus().intValue();
              if ((paramAnonymousInt != 0) && (paramAnonymousInt != 1)) {
                break label278;
              }
              BedroomSelectTimeActivity.this.myGvHome.setVisibility(0);
              BedroomSelectTimeActivity.this.mZiHlData.setVisibility(0);
              BedroomSelectTimeActivity.this.mVPoint.setVisibility(0);
              BedroomSelectTimeActivity.this.mLlWeekTime.setVisibility(8);
              BedroomSelectTimeActivity.this.mLlBedroomTime.setVisibility(8);
              BedroomSelectTimeActivity.this.mTvBedTip.setVisibility(8);
              BedroomSelectTimeActivity.this.mVTip.setVisibility(8);
              BedroomSelectTimeActivity.d(BedroomSelectTimeActivity.this).clear();
              BedroomSelectTimeActivity.d(BedroomSelectTimeActivity.this).addAll(paramAnonymousf.getOptionDateList());
              BedroomSelectTimeActivity.e(BedroomSelectTimeActivity.this).notifyDataSetChanged();
              if (BedroomSelectTimeActivity.k(BedroomSelectTimeActivity.this))
              {
                paramAnonymousInt = 0;
                while (paramAnonymousInt < BedroomSelectTimeActivity.d(BedroomSelectTimeActivity.this).size())
                {
                  if ((BedroomSelectTimeActivity.t(BedroomSelectTimeActivity.this).equals(((ay)BedroomSelectTimeActivity.d(BedroomSelectTimeActivity.this).get(paramAnonymousInt)).getDatePlan())) && ("0".equals(((ay)BedroomSelectTimeActivity.d(BedroomSelectTimeActivity.this).get(paramAnonymousInt)).getFlag()))) {
                    BedroomSelectTimeActivity.e(BedroomSelectTimeActivity.this).setSelectPosition(paramAnonymousInt);
                  }
                  paramAnonymousInt += 1;
                }
              }
              BedroomSelectTimeActivity.e(BedroomSelectTimeActivity.this).setSelectPosition(-1);
            }
            label278:
            do
            {
              do
              {
                return;
                if (paramAnonymousInt == 2)
                {
                  BedroomSelectTimeActivity.this.myGvHome.setVisibility(8);
                  BedroomSelectTimeActivity.this.mZiHlData.setVisibility(8);
                  BedroomSelectTimeActivity.this.mVPoint.setVisibility(8);
                  BedroomSelectTimeActivity.this.mLlWeekTime.setVisibility(0);
                  BedroomSelectTimeActivity.this.mLlBedroomTime.setVisibility(0);
                  BedroomSelectTimeActivity.this.mTvBedTip.setVisibility(0);
                  BedroomSelectTimeActivity.this.mVTip.setVisibility(0);
                  if ((paramAnonymousf.getZrkCleanDateTime() != null) && (!TextUtils.isEmpty(paramAnonymousf.getZrkCleanDateTime().getDate()))) {
                    BedroomSelectTimeActivity.this.mTvWeekTime.setText(paramAnonymousf.getZrkCleanDateTime().getDate() + " (" + paramAnonymousf.getZrkCleanDateTime().getWeek() + ") " + paramAnonymousf.getZrkCleanDateTime().getTime());
                  }
                  if ((paramAnonymousf.getBedroomCleanDateTime() != null) && (!TextUtils.isEmpty(paramAnonymousf.getBedroomCleanDateTime().getDocument()))) {
                    BedroomSelectTimeActivity.this.mTvBedroomTime.setText(paramAnonymousf.getBedroomCleanDateTime().getDocument());
                  }
                  if (!TextUtils.isEmpty(paramAnonymousf.getDocument())) {
                    BedroomSelectTimeActivity.this.mTvBedTip.setText(paramAnonymousf.getDocument());
                  }
                  BedroomSelectTimeActivity.a(BedroomSelectTimeActivity.this, "");
                  BedroomSelectTimeActivity.d(BedroomSelectTimeActivity.this, true);
                  return;
                }
              } while (paramAnonymousInt != 3);
              BedroomSelectTimeActivity.this.myGvHome.setVisibility(8);
              BedroomSelectTimeActivity.this.mZiHlData.setVisibility(8);
              BedroomSelectTimeActivity.this.mVPoint.setVisibility(8);
              BedroomSelectTimeActivity.this.mLlWeekTime.setVisibility(0);
              BedroomSelectTimeActivity.this.mLlBedroomTime.setVisibility(0);
              BedroomSelectTimeActivity.this.mTvBedTip.setVisibility(0);
              BedroomSelectTimeActivity.this.mVTip.setVisibility(0);
              if ((paramAnonymousf.getZrkCleanDateTime() != null) && (!TextUtils.isEmpty(paramAnonymousf.getZrkCleanDateTime().getDate()))) {
                BedroomSelectTimeActivity.this.mTvWeekTime.setText(paramAnonymousf.getZrkCleanDateTime().getDate() + " (" + paramAnonymousf.getZrkCleanDateTime().getWeek() + ") " + paramAnonymousf.getZrkCleanDateTime().getTime());
              }
              if ((paramAnonymousf.getBedroomCleanDateTime() != null) && (!TextUtils.isEmpty(paramAnonymousf.getBedroomCleanDateTime().getDate())))
              {
                BedroomSelectTimeActivity.this.mTvBedroomTime.setText(paramAnonymousf.getBedroomCleanDateTime().getDate() + " (" + paramAnonymousf.getBedroomCleanDateTime().getWeek() + ") " + paramAnonymousf.getBedroomCleanDateTime().getTime());
                BedroomSelectTimeActivity.b(BedroomSelectTimeActivity.this, paramAnonymousf.getBedroomCleanDateTime().getDate());
                BedroomSelectTimeActivity.a(BedroomSelectTimeActivity.this, paramAnonymousf.getBedroomCleanDateTime().getTime());
                BedroomSelectTimeActivity.c(BedroomSelectTimeActivity.this, paramAnonymousf.getBedroomCleanDateTime().getDate() + " " + paramAnonymousf.getBedroomCleanDateTime().getTime());
              }
            } while (TextUtils.isEmpty(paramAnonymousf.getDocument()));
            BedroomSelectTimeActivity.this.mTvBedTip.setText(paramAnonymousf.getDocument());
            return;
          }
          BedroomSelectTimeActivity.d(BedroomSelectTimeActivity.this).clear();
          BedroomSelectTimeActivity.e(BedroomSelectTimeActivity.this).notifyDataSetChanged();
          BedroomSelectTimeActivity.a(BedroomSelectTimeActivity.this, "");
        }
      });
      return;
    }
  }
  
  private void j()
  {
    if (this.S)
    {
      this.S = false;
      com.ziroom.commonlibrary.widget.unifiedziroom.e.newBuilder(this.a).setTitle("提示").setContent(this.R).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
        }
      }).build().show();
    }
  }
  
  private void k()
  {
    if (this.r) {}
    for (int i = 0;; i = 1)
    {
      n.requestPublicAreaChange(this.a, this.Q, this.P, this.D, i, this.L, new com.freelxl.baselibrary.d.c.a(new com.ziroom.ziroomcustomer.e.c.f(az.class))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          j.showFailureMessage(BedroomSelectTimeActivity.f(BedroomSelectTimeActivity.this), paramAnonymousThrowable);
        }
        
        public void onSuccess(int paramAnonymousInt, az paramAnonymousaz)
        {
          if ((paramAnonymousaz != null) && (paramAnonymousaz.getChange() != null))
          {
            if (paramAnonymousaz.getChange().intValue() != 2) {
              break label213;
            }
            BedroomSelectTimeActivity.a(BedroomSelectTimeActivity.this, paramAnonymousaz);
            if (!TextUtils.isEmpty(paramAnonymousaz.getText()))
            {
              BedroomSelectTimeActivity.e(BedroomSelectTimeActivity.this, true);
              BedroomSelectTimeActivity.i(BedroomSelectTimeActivity.this, paramAnonymousaz.getText());
            }
            if (!BedroomSelectTimeActivity.h(BedroomSelectTimeActivity.this)) {
              break label169;
            }
            BedroomSelectTimeActivity.b(BedroomSelectTimeActivity.this, false);
            BedroomSelectTimeActivity.c(BedroomSelectTimeActivity.this, false);
            BedroomSelectTimeActivity.d(BedroomSelectTimeActivity.this, false);
            BedroomSelectTimeActivity.a(BedroomSelectTimeActivity.this, false);
            BedroomSelectTimeActivity.b(BedroomSelectTimeActivity.this, "");
            BedroomSelectTimeActivity.a(BedroomSelectTimeActivity.this, "");
            BedroomSelectTimeActivity.d(BedroomSelectTimeActivity.this, "");
            BedroomSelectTimeActivity.this.mLetLength.setText("");
            BedroomSelectTimeActivity.m(BedroomSelectTimeActivity.this).clear();
            BedroomSelectTimeActivity.l(BedroomSelectTimeActivity.this);
          }
          label169:
          label213:
          while (paramAnonymousaz.getChange().intValue() != 0) {
            for (;;)
            {
              return;
              BedroomSelectTimeActivity.b(BedroomSelectTimeActivity.this, true);
              BedroomSelectTimeActivity.c(BedroomSelectTimeActivity.this, true);
              if (!TextUtils.isEmpty(paramAnonymousaz.getDoc())) {
                BedroomSelectTimeActivity.this.mTvPublicTip.setText(paramAnonymousaz.getDoc());
              }
            }
          }
          com.freelxl.baselibrary.f.g.textToast(BedroomSelectTimeActivity.f(BedroomSelectTimeActivity.this), paramAnonymousaz.getText());
        }
      });
      return;
    }
  }
  
  private void l()
  {
    if (TextUtils.isEmpty(this.v))
    {
      com.freelxl.baselibrary.f.g.textToast(this.a, "请先选择时间段");
      return;
    }
    if (TextUtils.isEmpty(this.t))
    {
      com.freelxl.baselibrary.f.g.textToast(this.a, "请先选择日期");
      return;
    }
    if (this.T)
    {
      com.freelxl.baselibrary.f.g.textToast(this.a, "当前时间已被约满，请选择单独上门");
      return;
    }
    if (TextUtils.isEmpty(this.u))
    {
      com.freelxl.baselibrary.f.g.textToast(this.a, "请先选择时间点");
      return;
    }
    if (this.r) {}
    for (int i = 1;; i = 0)
    {
      String str = this.t + " " + this.u;
      n.requestTimeCompletion(this.a, this.Q, this.P, i, str, this.L, this.H.getServiceTime(), this.H.getEmployeeCode(), this.D, new com.ziroom.ziroomcustomer.e.a.d(this.a, new com.ziroom.ziroomcustomer.e.c.f(com.ziroom.ziroomcustomer.newclean.d.g.class))
      {
        public void onSuccess(int paramAnonymousInt, final com.ziroom.ziroomcustomer.newclean.d.g paramAnonymousg)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousg);
          if ((paramAnonymousg != null) && (paramAnonymousg.getPublicArea() != null))
          {
            if (paramAnonymousg.getPublicArea().intValue() == 1) {
              c.newBuilder(BedroomSelectTimeActivity.f(BedroomSelectTimeActivity.this)).setTitle("提示").setBtnCancelText("单独上门").setBtnConfirmText("一起上门").setContent(paramAnonymousg.getDoc()).setOnConfirmClickListener(new c.b()
              {
                public void onClick(View paramAnonymous2View, boolean paramAnonymous2Boolean)
                {
                  if (paramAnonymous2Boolean)
                  {
                    BedroomSelectTimeActivity.a(BedroomSelectTimeActivity.this, paramAnonymousg, true);
                    return;
                  }
                  BedroomSelectTimeActivity.a(BedroomSelectTimeActivity.this, paramAnonymousg, false);
                }
              }).build().show();
            }
          }
          else {
            return;
          }
          if (BedroomSelectTimeActivity.h(BedroomSelectTimeActivity.this))
          {
            c.newBuilder(BedroomSelectTimeActivity.f(BedroomSelectTimeActivity.this)).setTitle("提示").setContent(paramAnonymousg.getDoc()).setOnConfirmClickListener(new c.b()
            {
              public void onClick(View paramAnonymous2View, boolean paramAnonymous2Boolean)
              {
                if (paramAnonymous2Boolean) {
                  BedroomSelectTimeActivity.a(BedroomSelectTimeActivity.this, paramAnonymousg, false);
                }
              }
            }).build().show();
            return;
          }
          BedroomSelectTimeActivity.a(BedroomSelectTimeActivity.this, paramAnonymousg, false);
        }
      });
      return;
    }
  }
  
  @OnClick({2131689492, 2131689957, 2131689961, 2131689956})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      j.setBedroomGrowingIo(this.r);
      finish();
      return;
    case 2131689957: 
      e();
      return;
    case 2131689961: 
      k();
      return;
    }
    l();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903104);
    this.a = this;
    this.b = ButterKnife.bind(this);
    a();
    b();
  }
  
  protected void onDestroy()
  {
    this.b.unbind();
    super.onDestroy();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      j.setBedroomGrowingIo(this.r);
      finish();
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/activity/BedroomSelectTimeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */