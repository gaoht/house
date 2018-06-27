package com.ziroom.ziroomcustomer.termination;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.format.Time;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.fastjson.a;
import com.freelxl.baselibrary.e.i.a;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.activity.LeaseUpdataActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.e.a;
import com.ziroom.ziroomcustomer.e.g;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.my.CreditWebActivity;
import com.ziroom.ziroomcustomer.termination.view.CalendarCard;
import com.ziroom.ziroomcustomer.termination.view.CalendarCard.b;
import com.ziroom.ziroomcustomer.termination.view.b;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.util.w;
import java.util.Calendar;
import java.util.Map;

public class InitiateTerminationActivity
  extends BaseActivity
  implements View.OnClickListener, CalendarCard.b
{
  private TextView A;
  private TextView B;
  private TextView C;
  private TextView D;
  private ImageButton E;
  private View F;
  private ImageView G;
  private LinearLayout H;
  private LinearLayout I;
  private TextView J;
  private TextView K;
  private TextView L;
  private TextView M;
  private TextView N;
  private TextView O;
  private TextView P;
  private TextView Q;
  private TextView R;
  private TextView S;
  private TextView T;
  private TextView U;
  private TextView V;
  private TextView W;
  private TextView X;
  private TextView Y;
  private TextView Z;
  private ViewPager a;
  private TextView aa;
  private TextView ab;
  private TextView ac;
  private TextView ad;
  private com.ziroom.ziroomcustomer.termination.a.k ae;
  private LinearLayout af;
  private com.ziroom.ziroomcustomer.termination.a.c ag;
  private String ah;
  private String ai;
  private String aj;
  private String ak;
  private com.ziroom.ziroomcustomer.termination.view.c al;
  private LinearLayout am;
  private TextView an;
  private TextView ao;
  private ImageView ap;
  private View aq;
  private TextView ar;
  private TextView as;
  private TextView at;
  private TextView au;
  private Dialog av;
  private int b = 498;
  private CalendarCard[] c;
  private b<CalendarCard> d;
  private a e = a.c;
  private Dialog f;
  private Context g;
  private String r;
  private ImageButton s;
  private ImageButton t;
  private TextView u;
  private TextView v;
  private TextView w;
  private TextView x;
  private TextView y;
  private TextView z;
  
  private void a()
  {
    this.F = View.inflate(this.g, 2130903663, null);
    this.f = new Dialog(this.g, 2131427834);
    this.f.setContentView(this.F);
  }
  
  private void a(TextView paramTextView, String paramString, int paramInt1, int paramInt2)
  {
    paramString = new SpannableStringBuilder(paramString);
    paramString.setSpan(new ForegroundColorSpan(Color.parseColor("#55aadd")), paramInt1, paramInt1 + paramInt2, 33);
    paramTextView.setText(paramString);
  }
  
  private void b()
  {
    this.a.setAdapter(this.d);
    this.a.setCurrentItem(498);
    this.a.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public void onPageScrollStateChanged(int paramAnonymousInt) {}
      
      public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
      
      public void onPageSelected(int paramAnonymousInt)
      {
        InitiateTerminationActivity.a(InitiateTerminationActivity.this, paramAnonymousInt);
        InitiateTerminationActivity.b(InitiateTerminationActivity.this, paramAnonymousInt);
      }
    });
  }
  
  private void b(int paramInt)
  {
    if (paramInt > this.b) {
      this.e = a.a;
    }
    for (;;)
    {
      this.b = paramInt;
      return;
      if (paramInt < this.b) {
        this.e = a.b;
      }
    }
  }
  
  private void c(int paramInt)
  {
    this.c = ((CalendarCard[])this.d.getAllItems());
    if (this.e == a.a) {
      this.c[(paramInt % this.c.length)].rightSlide();
    }
    for (;;)
    {
      this.e = a.c;
      return;
      if (this.e == a.b) {
        this.c[(paramInt % this.c.length)].leftSlide();
      }
    }
  }
  
  public void changeDate(com.ziroom.ziroomcustomer.termination.view.c paramc)
  {
    this.u.setText(paramc.a + "年" + paramc.b + "月");
  }
  
  public void checkDatta()
  {
    if (ae.isNull(this.O.getText().toString())) {
      showToast("证件信息不全，请联系管家");
    }
    if (ae.isNull(this.N.getText().toString())) {
      showToast("证件信息不全，请联系管家");
    }
    if (ae.isNull(this.M.getText().toString())) {
      showToast("证件信息不全，请联系管家");
    }
    if (ae.isNull(this.L.getText().toString())) {
      showToast("证件信息不全，请联系管家");
    }
    if (ae.isNull(this.K.getText().toString())) {
      showToast("证件信息不全，请联系管家");
    }
    if (ae.isNull(this.J.getText().toString())) {
      showToast("证件信息不全，请联系管家");
    }
  }
  
  public void clickDate(com.ziroom.ziroomcustomer.termination.view.c paramc)
  {
    if (paramc.getState() != 0)
    {
      this.v.setText(paramc.getXingqi());
      this.x.setText(paramc.a + "年" + paramc.b + "月" + paramc.c + "日");
      this.y.setText(paramc.c + "");
      this.w.setText(m.StrToNorDate(paramc.toString()));
      this.z.setText("试算解约金额");
      if (paramc.getState() != 1) {
        break label187;
      }
      this.X.setText("三天不满意");
      this.X.setBackgroundResource(2130837961);
      this.X.setVisibility(0);
      this.X.setTextColor(33792);
    }
    for (;;)
    {
      this.al = paramc;
      this.f.dismiss();
      return;
      label187:
      if (paramc.getState() == 2)
      {
        this.X.setText("合同到期日");
        this.X.setBackgroundResource(2130837960);
        this.X.setVisibility(0);
        this.X.setTextColor(-11162915);
      }
      else if (paramc.getState() == 3)
      {
        this.X.setVisibility(8);
      }
      else
      {
        this.X.setVisibility(8);
      }
    }
  }
  
  public void initView()
  {
    this.am = ((LinearLayout)findViewById(2131693369));
    this.an = ((TextView)findViewById(2131693370));
    this.ao = ((TextView)findViewById(2131693372));
    this.ap = ((ImageView)findViewById(2131693371));
    this.af = ((LinearLayout)findViewById(2131694797));
    this.I = ((LinearLayout)findViewById(2131693356));
    this.Z = ((TextView)findViewById(2131694788));
    this.aa = ((TextView)findViewById(2131694790));
    this.ab = ((TextView)findViewById(2131694792));
    this.ac = ((TextView)findViewById(2131694794));
    this.ad = ((TextView)findViewById(2131694796));
    this.Q = ((TextView)findViewById(2131693350));
    this.W = ((TextView)findViewById(2131693367));
    this.U = ((TextView)findViewById(2131693354));
    this.S = ((TextView)findViewById(2131693352));
    this.V = ((TextView)findViewById(2131693368));
    this.T = ((TextView)findViewById(2131693355));
    this.R = ((TextView)findViewById(2131693353));
    this.P = ((TextView)findViewById(2131693351));
    this.O = ((TextView)findViewById(2131693348));
    this.w = ((TextView)findViewById(2131693349));
    this.N = ((TextView)findViewById(2131693347));
    this.M = ((TextView)findViewById(2131693346));
    this.L = ((TextView)findViewById(2131693345));
    this.K = ((TextView)findViewById(2131693344));
    this.J = ((TextView)findViewById(2131693343));
    this.H = ((LinearLayout)findViewById(2131694786));
    this.A = ((TextView)findViewById(2131693374));
    this.B = ((TextView)findViewById(2131693373));
    this.z = ((TextView)findViewById(2131693375));
    a();
    this.X = ((TextView)this.F.findViewById(2131693213));
    this.Y = ((TextView)this.F.findViewById(2131693209));
    this.C = ((TextView)this.F.findViewById(2131693219));
    this.D = ((TextView)this.F.findViewById(2131693220));
    this.y = ((TextView)this.F.findViewById(2131693211));
    this.x = ((TextView)this.F.findViewById(2131693212));
    this.v = ((TextView)this.F.findViewById(2131693210));
    this.a = ((ViewPager)this.F.findViewById(2131693218));
    this.s = ((ImageButton)this.F.findViewById(2131693214));
    this.t = ((ImageButton)this.F.findViewById(2131693216));
    this.u = ((TextView)this.F.findViewById(2131693215));
    this.E = ((ImageButton)this.F.findViewById(2131693217));
    this.Y.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.t.setOnClickListener(this);
    this.E.setOnClickListener(this);
    this.z.setOnClickListener(this);
    this.w.setOnClickListener(this);
    this.A.setOnClickListener(this);
    this.B.setOnClickListener(this);
    this.af.setOnClickListener(this);
    a(this.B, "试一试转租？转租成功只收取合同月租金的50%作为手续费(三天不满意及月租房不可转租)", 0, 6);
  }
  
  public boolean isPositiveNumber(float paramFloat)
  {
    return paramFloat >= 0.0F;
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
    case 2131693214: 
    case 2131693374: 
    case 2131693373: 
    case 2131694797: 
    case 2131693216: 
    case 2131693217: 
    case 2131693349: 
    case 2131693209: 
    case 2131689492: 
    case 2131693375: 
      do
      {
        do
        {
          return;
          this.a.setCurrentItem(this.a.getCurrentItem() - 1);
          return;
        } while ((this.ag == null) || (TextUtils.isEmpty(this.ag.getGjPhone())));
        ah.callPhone(this.g, this.ag.getGjPhone());
        return;
        paramView = new Intent(this.g, LeaseUpdataActivity.class);
        paramView.putExtra("lease", this.ak);
        startActivity(paramView);
        return;
        paramView = new Intent(this.g, CreditWebActivity.class);
        paramView.putExtra("title", "退租规则说明");
        paramView.putExtra("url", "http://www.ziroom.com/zhuanti/2016/zzbcwa/throwLease.html");
        startActivity(paramView);
        w.onEvent(this.g, "lease_off_rule");
        return;
        this.a.setCurrentItem(this.a.getCurrentItem() + 1);
        return;
        finish();
        return;
        paramView = this.f;
        if (!(paramView instanceof Dialog))
        {
          paramView.show();
          return;
        }
        VdsAgent.showDialog((Dialog)paramView);
        return;
        this.f.dismiss();
        return;
        finish();
        return;
        if ("我要解约".equals(this.z.getText()))
        {
          showToast("请重新选择退租日期");
          return;
        }
        if ("试算解约金额".equals(this.z.getText()))
        {
          if (this.al == null)
          {
            showToast("请选择退租日期");
            return;
          }
          this.ai = (q.s + e.a.b);
          paramView = g.getEstimatedBackRentFee(this.ak, this.al.toString());
          j.getEstimatedBackRentFee(this.g, new b(), paramView, true, this.ai);
          return;
        }
      } while (!"提交退租申请".equals(this.z.getText()));
      this.aj = (q.s + e.a.c);
      paramView = g.getAddBackRentOrder(this.ak, this.al.toString(), this.r);
      j.getAddBackRentOrder(this.g, new b(), paramView, true, this.aj);
      return;
    case 2131697638: 
      this.av.dismiss();
      return;
    }
    showDialog(this.ag.getAmiHistroyLiveFeeTip());
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904111);
    this.g = this;
    this.ak = getIntent().getStringExtra("contractCode");
    this.r = getIntent().getStringExtra("from");
    if (ae.isNull(this.r)) {
      this.r = "0";
    }
    this.ah = (q.s + e.a.a);
    paramBundle = g.getToBackRent(this.ak);
    j.getToBackRent(this.g, new b(), paramBundle, true, this.ah);
    this.G = ((ImageView)findViewById(2131689492));
    this.G.setOnClickListener(this);
    initView();
  }
  
  public void setData()
  {
    if (this.ae == null) {
      this.ae = new com.ziroom.ziroomcustomer.termination.a.k();
    }
    this.O.setText(m.StrToNorDate(this.ae.getApplyDate()));
    this.N.setText(this.ae.getAddress());
    this.M.setText(this.ae.getCertNumber());
    this.L.setText(this.ae.getCertType());
    this.K.setText(this.ae.getUserPhone());
    this.J.setText(this.ae.getCustomerName());
    Object localObject = Calendar.getInstance();
    Time localTime = new Time();
    localTime.setToNow();
    int i = localTime.year;
    int j = localTime.month;
    int k = localTime.monthDay;
    this.v.setText(m.getWeekOfDate(((Calendar)localObject).get(7)));
    this.y.setText(k + "");
    this.x.setText(i + "年" + (j + 1) + "月" + k + "日");
    this.X.setVisibility(8);
    localObject = new CalendarCard[3];
    i = 0;
    while (i < 3)
    {
      localObject[i] = new CalendarCard(this, this, this.ae.getDateList());
      i += 1;
    }
    this.d = new b((View[])localObject);
    b();
    if (("5".equals(this.ae.getHouseType())) || ("8".equals(this.ae.getHouseType())))
    {
      this.C.setVisibility(8);
      this.D.setVisibility(8);
      this.af.setVisibility(8);
      this.B.setVisibility(8);
    }
  }
  
  public void setTimeData()
  {
    if (this.ag == null) {
      return;
    }
    if (this.ag.getLoanState() == 0)
    {
      this.I.setVisibility(8);
      this.Z.setText(this.ag.getLoanAccount() + "元");
      this.aa.setText(this.ag.getPayAccount() + "元");
      this.ab.setText(this.ag.getPayInterest() + "元");
      this.ac.setText(this.ag.getNeedInterest() + "元");
      this.ad.setText(this.ag.getLoanPenalty() + "元");
      this.V.setText(this.ag.getPenalty() + "元");
      this.W.setText(this.ag.getPenaltyNote());
      this.T.setText(this.ag.getDepositNeedReturn() + "元");
      this.U.setText(this.ag.getDepositNote());
      this.R.setText(this.ag.getCommissionNeedReturn() + "元");
      this.S.setText(this.ag.getCommissionNote());
      this.P.setText(this.ag.getRentNeedReturn() + "元");
      this.Q.setText(this.ag.getRentNote());
      if (!ae.isNull(this.ag.getAmiHistroyLiveFeeNote())) {
        break label459;
      }
      this.am.setVisibility(8);
      label402:
      if (!ae.isNull(this.ag.getAmiHistroyLiveFeeTip())) {
        break label476;
      }
      this.ap.setVisibility(8);
    }
    for (;;)
    {
      if (!ae.isNull(this.ag.getAmiHistroyLiveFee())) {
        break label495;
      }
      this.ao.setText("");
      return;
      this.I.setVisibility(0);
      break;
      label459:
      this.an.setText(this.ag.getAmiHistroyLiveFeeNote());
      break label402;
      label476:
      this.ap.setVisibility(0);
      this.ap.setOnClickListener(this);
    }
    label495:
    this.ao.setText(ah.Number(Float.parseFloat(this.ag.getAmiHistroyLiveFee())));
  }
  
  public void showDialog(String paramString)
  {
    this.aq = View.inflate(this.g, 2130905165, null);
    this.ar = ((TextView)this.aq.findViewById(2131697639));
    this.au = ((TextView)this.aq.findViewById(2131697638));
    this.at = ((TextView)this.aq.findViewById(2131697637));
    this.as = ((TextView)this.aq.findViewById(2131697634));
    this.ar.setOnClickListener(this);
    this.au.setOnClickListener(this);
    this.as.setVisibility(8);
    this.ar.setVisibility(0);
    this.au.setVisibility(0);
    this.at.setGravity(17);
    if (ae.notNull(paramString))
    {
      this.as.setText("提示");
      this.as.setVisibility(0);
      this.at.setText(paramString);
      this.ar.setVisibility(8);
      this.au.setText("我知道了");
    }
    if (this.av == null)
    {
      this.av = new Dialog(this.g, 2131427781);
      this.av.setContentView(this.aq);
      this.av.setCanceledOnTouchOutside(false);
      this.av.setCancelable(false);
      paramString = this.av;
      if ((paramString instanceof Dialog)) {
        break label273;
      }
      paramString.show();
    }
    for (;;)
    {
      ApplicationEx.g = 2;
      this.av.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          InitiateTerminationActivity.a(InitiateTerminationActivity.this, null);
          InitiateTerminationActivity.a(InitiateTerminationActivity.this).dismiss();
          InitiateTerminationActivity.a(InitiateTerminationActivity.this, null);
        }
      });
      return;
      label273:
      VdsAgent.showDialog((Dialog)paramString);
    }
  }
  
  static enum a
  {
    private a() {}
  }
  
  class b
    implements i.a<String>
  {
    b() {}
    
    public void onParse(String paramString, com.freelxl.baselibrary.e.k paramk)
    {
      paramString = a.parseObject(paramString);
      if (((String)paramString.get("status")).equals("success"))
      {
        if (InitiateTerminationActivity.b(InitiateTerminationActivity.this).equals(paramk.getUrl()))
        {
          paramString = (com.ziroom.ziroomcustomer.termination.a.k)a.parseObject(paramString.get("data").toString(), com.ziroom.ziroomcustomer.termination.a.k.class);
          paramk.setSuccess(Boolean.valueOf(true));
          paramk.setObject(paramString);
        }
        do
        {
          return;
          if (InitiateTerminationActivity.f(InitiateTerminationActivity.this).equals(paramk.getUrl()))
          {
            paramString = (com.ziroom.ziroomcustomer.termination.a.c)a.parseObject(paramString.get("data").toString(), com.ziroom.ziroomcustomer.termination.a.c.class);
            paramk.setSuccess(Boolean.valueOf(true));
            paramk.setObject(paramString);
            return;
          }
        } while (!InitiateTerminationActivity.j(InitiateTerminationActivity.this).equals(paramk.getUrl()));
        paramk.setSuccess(Boolean.valueOf(true));
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage((String)paramString.get("error_message"));
    }
    
    public void onSuccess(com.freelxl.baselibrary.e.k paramk)
    {
      if (paramk.getSuccess().booleanValue()) {
        if (InitiateTerminationActivity.b(InitiateTerminationActivity.this).equals(paramk.getUrl()))
        {
          InitiateTerminationActivity.a(InitiateTerminationActivity.this, (com.ziroom.ziroomcustomer.termination.a.k)paramk.getObject());
          InitiateTerminationActivity.this.initView();
          if (InitiateTerminationActivity.c(InitiateTerminationActivity.this) != null)
          {
            if (ae.notNull(InitiateTerminationActivity.c(InitiateTerminationActivity.this).getExpectDate()))
            {
              InitiateTerminationActivity.d(InitiateTerminationActivity.this).setText("试算解约金额");
              paramk = InitiateTerminationActivity.c(InitiateTerminationActivity.this).getExpectDate().split("-");
              InitiateTerminationActivity.e(InitiateTerminationActivity.this).setText(paramk[0] + "年" + paramk[1] + "月" + paramk[2] + "日");
              InitiateTerminationActivity.a(InitiateTerminationActivity.this, new com.ziroom.ziroomcustomer.termination.view.c(Integer.parseInt(paramk[0]), Integer.parseInt(paramk[1]), Integer.parseInt(paramk[2])));
            }
            InitiateTerminationActivity.this.setData();
          }
        }
      }
      for (;;)
      {
        InitiateTerminationActivity.this.dismissProgress();
        return;
        if (InitiateTerminationActivity.f(InitiateTerminationActivity.this).equals(paramk.getUrl()))
        {
          InitiateTerminationActivity.a(InitiateTerminationActivity.this, (com.ziroom.ziroomcustomer.termination.a.c)paramk.getObject());
          InitiateTerminationActivity.this.setTimeData();
          InitiateTerminationActivity.g(InitiateTerminationActivity.this).setVisibility(0);
          if (("5".equals(InitiateTerminationActivity.c(InitiateTerminationActivity.this).getHouseType())) || ("8".equals(InitiateTerminationActivity.c(InitiateTerminationActivity.this).getHouseType()))) {
            InitiateTerminationActivity.h(InitiateTerminationActivity.this).setVisibility(8);
          }
          for (;;)
          {
            InitiateTerminationActivity.i(InitiateTerminationActivity.this).setVisibility(0);
            InitiateTerminationActivity.d(InitiateTerminationActivity.this).setText("提交退租申请");
            break;
            InitiateTerminationActivity.h(InitiateTerminationActivity.this).setVisibility(0);
          }
        }
        if (InitiateTerminationActivity.j(InitiateTerminationActivity.this).equals(paramk.getUrl()))
        {
          paramk = new Intent(InitiateTerminationActivity.k(InitiateTerminationActivity.this), ConfirmTerminationActivity.class);
          paramk.putExtra("contractCode", InitiateTerminationActivity.l(InitiateTerminationActivity.this));
          paramk.putExtra("mode", "0");
          paramk.putExtra("isShowMove", "1");
          InitiateTerminationActivity.this.startActivity(paramk);
          ApplicationEx.c.addActivity(InitiateTerminationActivity.this);
          continue;
          paramk = paramk.getMessage();
          InitiateTerminationActivity.this.showToast(paramk);
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/termination/InitiateTerminationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */