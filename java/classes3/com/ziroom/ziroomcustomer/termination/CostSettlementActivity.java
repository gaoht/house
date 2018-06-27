package com.ziroom.ziroomcustomer.termination;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.adapter.e;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.e.a;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.termination.a.d;
import com.ziroom.ziroomcustomer.termination.a.m;
import com.ziroom.ziroomcustomer.util.ah;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CostSettlementActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private TextView A;
  private TextView B;
  private TextView C;
  private TextView D;
  private TextView E;
  private TextView F;
  private TextView G;
  private TextView H;
  private TextView I;
  private TextView J;
  private RelativeLayout K;
  private RelativeLayout L;
  private RelativeLayout M;
  private RelativeLayout N;
  private RelativeLayout O;
  private RelativeLayout P;
  private RelativeLayout Q;
  private RelativeLayout R;
  private RelativeLayout S;
  private LinearLayout T;
  private TextView U;
  private TextView V;
  private ImageView W;
  private ImageView X;
  private TextView Y;
  private d Z;
  protected String a;
  private Dialog aA;
  private Dialog aa;
  private View ab;
  private TextView ac;
  private TextView ad;
  private TextView ae;
  private TextView af;
  private String ag;
  private String ah;
  private String ai;
  private String aj;
  private CharSequence ak;
  private String al;
  private String am;
  private String an;
  private TextView ao;
  private ArrayList<String> ap;
  private ListView aq;
  private boolean ar = true;
  private PopupWindow as;
  private View at;
  private int au;
  private View av;
  private TextView aw;
  private TextView ax;
  private TextView ay;
  private TextView az;
  protected String b;
  protected String c;
  public Handler d = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      paramAnonymousMessage = (String)paramAnonymousMessage.obj;
      com.freelxl.baselibrary.f.g.textToast(CostSettlementActivity.c(CostSettlementActivity.this), paramAnonymousMessage + "", 0);
    }
  };
  private Context e;
  private TextView f;
  private TextView g;
  private TextView r;
  private TextView s;
  private TextView t;
  private TextView u;
  private TextView v;
  private TextView w;
  private TextView x;
  private TextView y;
  private TextView z;
  
  private void a()
  {
    this.ac.setText("确认退租？");
    this.ad.setText(this.ak + "");
  }
  
  private void b()
  {
    this.ap = new ArrayList();
    this.ap.add("取消解约");
  }
  
  private void e()
  {
    b();
    View localView1 = View.inflate(this, 2130905075, null);
    this.aq = ((ListView)localView1.findViewById(2131691156));
    final e locale = new e(this.e, this.ap);
    this.aq.setAdapter(locale);
    PopupWindow localPopupWindow;
    View localView2;
    if (this.ar)
    {
      this.as = new PopupWindow(localView1, -1, -1, true);
      this.as.setContentView(localView1);
      this.as.setOutsideTouchable(false);
      this.as.setFocusable(false);
      localPopupWindow = this.as;
      localView2 = this.at;
      if (!(localPopupWindow instanceof PopupWindow)) {
        localPopupWindow.showAsDropDown(localView2);
      }
    }
    for (this.ar = false;; this.ar = true)
    {
      localView1.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          CostSettlementActivity.a(CostSettlementActivity.this).dismiss();
          CostSettlementActivity.a(CostSettlementActivity.this, true);
        }
      });
      this.aq.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        @Instrumented
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          if ("取消解约".equals(locale.getmList().get(paramAnonymousInt))) {
            CostSettlementActivity.this.Dialog();
          }
        }
      });
      return;
      VdsAgent.showAsDropDown((PopupWindow)localPopupWindow, localView2);
      break;
      this.as.dismiss();
    }
  }
  
  public void Dialog()
  {
    this.av = View.inflate(this.e, 2130905165, null);
    this.aw = ((TextView)this.av.findViewById(2131697639));
    this.az = ((TextView)this.av.findViewById(2131697638));
    this.ay = ((TextView)this.av.findViewById(2131697637));
    this.ax = ((TextView)this.av.findViewById(2131697634));
    this.aw.setOnClickListener(this);
    this.az.setOnClickListener(this);
    this.ax.setVisibility(8);
    this.aw.setVisibility(0);
    this.az.setVisibility(0);
    this.ay.setGravity(17);
    this.ay.setText("您确定要取消解约吗？");
    this.aw.setText("是的");
    this.az.setText("我再想想");
    Dialog localDialog;
    if (this.aA == null)
    {
      this.aA = new Dialog(this.e, 2131427781);
      this.aA.setContentView(this.av);
      this.aA.setCanceledOnTouchOutside(false);
      this.aA.setCancelable(false);
      localDialog = this.aA;
      if ((localDialog instanceof Dialog)) {
        break label251;
      }
      localDialog.show();
    }
    for (;;)
    {
      com.ziroom.ziroomcustomer.base.ApplicationEx.g = 2;
      this.aA.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          CostSettlementActivity.a(CostSettlementActivity.this, null);
          CostSettlementActivity.b(CostSettlementActivity.this).dismiss();
          CostSettlementActivity.a(CostSettlementActivity.this, null);
        }
      });
      return;
      label251:
      VdsAgent.showDialog((Dialog)localDialog);
    }
  }
  
  public void initView()
  {
    this.S = ((RelativeLayout)findViewById(2131693417));
    this.F = ((TextView)findViewById(2131693418));
    this.T = ((LinearLayout)findViewById(2131693356));
    this.U = ((TextView)findViewById(2131693364));
    this.V = ((TextView)findViewById(2131693366));
    this.ao = ((TextView)findViewById(2131693373));
    this.G = ((TextView)findViewById(2131693410));
    this.H = ((TextView)findViewById(2131693412));
    this.I = ((TextView)findViewById(2131693414));
    this.J = ((TextView)findViewById(2131693416));
    this.K = ((RelativeLayout)findViewById(2131693402));
    this.L = ((RelativeLayout)findViewById(2131693403));
    this.M = ((RelativeLayout)findViewById(2131693404));
    this.N = ((RelativeLayout)findViewById(2131693406));
    this.O = ((RelativeLayout)findViewById(2131693409));
    this.P = ((RelativeLayout)findViewById(2131693411));
    this.Q = ((RelativeLayout)findViewById(2131693413));
    this.R = ((RelativeLayout)findViewById(2131693415));
    this.E = ((TextView)findViewById(2131693408));
    this.C = ((TextView)findViewById(2131693398));
    this.D = ((TextView)findViewById(2131693400));
    this.B = ((TextView)findViewById(2131693401));
    this.A = ((TextView)findViewById(2131693399));
    this.z = ((TextView)findViewById(2131693397));
    this.at = findViewById(2131693396);
    this.X = ((ImageView)findViewById(2131693342));
    this.Y = ((TextView)findViewById(2131693375));
    this.W = ((ImageView)findViewById(2131689492));
    this.f = ((TextView)findViewById(2131693351));
    this.g = ((TextView)findViewById(2131693355));
    this.r = ((TextView)findViewById(2131693405));
    this.s = ((TextView)findViewById(2131693407));
    this.t = ((TextView)findViewById(2131693419));
    this.u = ((TextView)findViewById(2131693420));
    this.v = ((TextView)findViewById(2131693421));
    this.w = ((TextView)findViewById(2131693422));
    this.x = ((TextView)findViewById(2131693424));
    this.y = ((TextView)findViewById(2131693423));
    this.ab = LayoutInflater.from(this).inflate(2130905019, null);
    this.ac = ((TextView)this.ab.findViewById(2131697230));
    this.ad = ((TextView)this.ab.findViewById(2131690106));
    this.ae = ((TextView)this.ab.findViewById(2131697232));
    this.af = ((TextView)this.ab.findViewById(2131697231));
    this.aa = new Dialog(this.e, 2131427781);
    this.aa.setContentView(this.ab);
    this.X.setVisibility(8);
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
      return;
    case 2131689492: 
      finish();
      return;
    case 2131693375: 
      if ("支付".equals(this.Y.getText().toString()))
      {
        paramView = new Intent(this.e, TerminationPayActivity.class);
        paramView.putExtra("contractCode", this.am);
        paramView.putExtra("backRentOrderCode", this.ah);
        startActivity(paramView);
        return;
      }
      if ("确认办理退租".equals(this.Y.getText().toString()))
      {
        this.aj = (q.s + e.a.j);
        paramView = com.ziroom.ziroomcustomer.e.g.getViewBackRentRemend(this.ah);
        j.getReservationOrderText(this.e, new a(), paramView, true, this.aj);
        return;
      }
      showToast("请重新发起退租！");
      return;
    case 2131697232: 
      this.an = (q.s + e.a.s);
      paramView = com.ziroom.ziroomcustomer.e.g.getRentBackSignInfo(this.am, this.ah);
      j.getReservationOrderText(this.e, new a(), paramView, true, this.an);
      return;
    case 2131697231: 
      this.aa.dismiss();
      return;
    case 2131693342: 
      e();
      return;
    case 2131697639: 
      this.b = (q.s + e.a.n);
      paramView = com.ziroom.ziroomcustomer.e.g.getCancelBackRendOrder(this.ah);
      j.getReservationOrderText(this.e, new a(), paramView, true, this.b);
      return;
    }
    this.aA.dismiss();
    this.as.dismiss();
    this.ar = true;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903700);
    this.e = this;
    this.ag = getIntent().getStringExtra("ToPay");
    this.au = getIntent().getIntExtra("loanState", 0);
    this.am = getIntent().getStringExtra("contractCode");
    this.ah = getIntent().getStringExtra("backRentOrderCode");
    initView();
    if ("ToPay".equals(this.ag))
    {
      this.ao.setVisibility(8);
      this.X.setVisibility(8);
      this.Y.setText("支付");
    }
    this.ai = (q.s + e.a.i);
    paramBundle = com.ziroom.ziroomcustomer.e.g.getFeeDetailUrl(this.ah);
    j.getReservationOrderText(this.e, new a(), paramBundle, true, this.ai);
    initView();
    setOnclick();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    if ((this.as != null) && (this.as.isShowing()))
    {
      this.as.dismiss();
      this.ar = true;
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void setData()
  {
    if (this.Z == null) {
      this.Z = new d();
    }
    if (this.Z.getLoanState() == 0)
    {
      this.T.setVisibility(8);
      this.U.setText(ah.Number(this.Z.getNeedInterest()) + "元");
      this.V.setText(ah.Number(this.Z.getLoanPenalty()) + "元");
      this.C.setText("已产生租金（" + this.Z.getRentNote() + ")");
      this.D.setText("已产生服务费（" + this.Z.getCommissionNote() + ")");
      this.B.setText(ah.Number(this.Z.getCommissionNeed()) + "元");
      this.A.setText(ah.Number(this.Z.getRentNeed()) + "元");
      this.z.setText(ah.Number(this.Z.getContractMoney()) + "元");
      this.E.setText(ah.Number(this.Z.getOther()) + "元");
      if (!isPositiveNumber(this.Z.getRent())) {
        break label925;
      }
      this.K.setVisibility(0);
      this.O.setVisibility(8);
      this.f.setText(ah.Number(this.Z.getRent()) + "元");
      label398:
      if (!isPositiveNumber(this.Z.getDeposit())) {
        break label983;
      }
      this.L.setVisibility(0);
      this.P.setVisibility(8);
      this.g.setText(ah.Number(this.Z.getDeposit()) + "元");
      label465:
      if (!isPositiveNumber(this.Z.getCommission())) {
        break label1041;
      }
      this.M.setVisibility(0);
      this.Q.setVisibility(8);
      this.r.setText(ah.Number(this.Z.getCommission()) + "元");
      label532:
      if (!isPositiveNumber(this.Z.getPenalty())) {
        break label1099;
      }
      this.N.setVisibility(8);
      this.R.setVisibility(0);
      this.J.setText(ah.Number(this.Z.getPenalty()) + "元");
      label599:
      if (this.Z.getPenaltyHistoryPrice() <= 0.0F) {
        break label1157;
      }
      this.F.setText(ah.Number(this.Z.getPenaltyHistoryPrice()) + "元");
      this.S.setVisibility(0);
      label655:
      this.t.setText(ah.Number(this.Z.getGoodsActPay()) + "元");
      this.u.setText(ah.Number(this.Z.getKeysActPay()) + "元");
      this.v.setText(ah.Number(this.Z.getExpensesActPay()) + "元");
      this.w.setText(ah.Number(this.Z.getOtherPay()) + "元");
      if (!isPositiveNumber(this.Z.getNeedPay())) {
        break label1169;
      }
      this.x.setText(ah.Number(this.Z.getNeedPay()) + "元");
      this.y.setText("需付款");
    }
    for (;;)
    {
      if ((!"wfk".equals(this.Z.getPayState())) && (!"qk".equals(this.Z.getPayState())) && ("ToPay".equals(this.ag))) {
        this.Y.setVisibility(8);
      }
      return;
      this.T.setVisibility(0);
      break;
      label925:
      this.K.setVisibility(8);
      this.O.setVisibility(0);
      this.G.setText(ah.Number(0.0F - this.Z.getRent()) + "元");
      break label398;
      label983:
      this.L.setVisibility(8);
      this.P.setVisibility(0);
      this.H.setText(ah.Number(0.0F - this.Z.getDeposit()) + "元");
      break label465;
      label1041:
      this.M.setVisibility(8);
      this.Q.setVisibility(0);
      this.I.setText(ah.Number(0.0F - this.Z.getCommission()) + "元");
      break label532;
      label1099:
      this.N.setVisibility(0);
      this.R.setVisibility(8);
      this.s.setText(ah.Number(0.0F - this.Z.getPenalty()) + "元");
      break label599;
      label1157:
      this.S.setVisibility(8);
      break label655;
      label1169:
      this.x.setText(ah.Number(0.0F - this.Z.getNeedPay()) + "元");
      this.y.setText("需退款");
    }
  }
  
  public void setOnclick()
  {
    this.X.setOnClickListener(this);
    this.W.setOnClickListener(this);
    this.Y.setOnClickListener(this);
    this.ae.setOnClickListener(this);
    this.af.setOnClickListener(this);
  }
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, k paramk)
    {
      paramString = com.alibaba.fastjson.a.parseObject(paramString);
      if (((String)paramString.get("status")).equals("success"))
      {
        if (paramk.getUrl().equals(CostSettlementActivity.d(CostSettlementActivity.this)))
        {
          paramString = (d)com.alibaba.fastjson.a.parseObject(paramString.get("data").toString(), d.class);
          paramk.setSuccess(Boolean.valueOf(true));
          paramk.setObject(paramString);
        }
        do
        {
          return;
          if (paramk.getUrl().equals(CostSettlementActivity.e(CostSettlementActivity.this)))
          {
            paramString = ((m)com.alibaba.fastjson.a.parseObject(paramString.get("data").toString(), m.class)).getContent();
            paramk.setSuccess(Boolean.valueOf(true));
            paramk.setObject(paramString);
            return;
          }
          if (paramk.getUrl().equals(CostSettlementActivity.h(CostSettlementActivity.this)))
          {
            paramk.setSuccess(Boolean.valueOf(true));
            return;
          }
          if (paramk.getUrl().equals(CostSettlementActivity.k(CostSettlementActivity.this)))
          {
            paramk.setSuccess(Boolean.valueOf(true));
            paramk.setObject(paramString.get("data").toString());
            return;
          }
          if (paramk.getUrl().equals(CostSettlementActivity.this.a))
          {
            paramk.setSuccess(Boolean.valueOf(true));
            return;
          }
          if (paramk.getUrl().equals(CostSettlementActivity.this.b))
          {
            paramk.setSuccess(Boolean.valueOf(true));
            return;
          }
        } while (!paramk.getUrl().equals(CostSettlementActivity.this.c));
        paramk.setSuccess(Boolean.valueOf(true));
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage((String)paramString.get("error_message"));
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue()) {
        if (paramk.getUrl().equals(CostSettlementActivity.d(CostSettlementActivity.this)))
        {
          CostSettlementActivity.a(CostSettlementActivity.this, (d)paramk.getObject());
          CostSettlementActivity.this.setData();
          CostSettlementActivity.this.setOnclick();
        }
      }
      for (;;)
      {
        CostSettlementActivity.this.dismissProgress();
        return;
        if (paramk.getUrl().equals(CostSettlementActivity.e(CostSettlementActivity.this)))
        {
          CostSettlementActivity.a(CostSettlementActivity.this, (String)paramk.getObject());
          CostSettlementActivity.f(CostSettlementActivity.this);
          paramk = CostSettlementActivity.g(CostSettlementActivity.this);
          if (!(paramk instanceof Dialog)) {
            paramk.show();
          } else {
            VdsAgent.showDialog((Dialog)paramk);
          }
        }
        else if (paramk.getUrl().equals(CostSettlementActivity.h(CostSettlementActivity.this)))
        {
          CostSettlementActivity.g(CostSettlementActivity.this).dismiss();
          paramk = new Intent(CostSettlementActivity.c(CostSettlementActivity.this), PaymentInformationActivity.class);
          paramk.putExtra("backRentOrderCode", CostSettlementActivity.i(CostSettlementActivity.this));
          paramk.putExtra("contractCode", CostSettlementActivity.j(CostSettlementActivity.this));
          CostSettlementActivity.this.startActivity(paramk);
        }
        else if (paramk.getUrl().equals(CostSettlementActivity.k(CostSettlementActivity.this)))
        {
          a locala = new a(CostSettlementActivity.c(CostSettlementActivity.this), CostSettlementActivity.this, null, new a(CostSettlementActivity.this), CostSettlementActivity.this.d);
          locala.setmPaperless(new a.b()
          {
            public void Attestation(String paramAnonymousString)
            {
              CostSettlementActivity.this.a = (q.s + e.a.t);
              paramAnonymousString = com.ziroom.ziroomcustomer.e.g.getAddRentBackSignInfo(CostSettlementActivity.j(CostSettlementActivity.this), CostSettlementActivity.i(CostSettlementActivity.this), paramAnonymousString);
              j.getReservationOrderText(CostSettlementActivity.c(CostSettlementActivity.this), new CostSettlementActivity.a(CostSettlementActivity.this), paramAnonymousString, true, CostSettlementActivity.this.a);
            }
            
            public void DownloadError() {}
            
            public void DownloadSuccess() {}
          });
          locala.sign((String)paramk.getObject());
        }
        else if (paramk.getUrl().equals(CostSettlementActivity.this.a))
        {
          CostSettlementActivity.a(CostSettlementActivity.this, q.s + e.a.k);
          paramk = com.ziroom.ziroomcustomer.e.g.getConfirmBackRentUrl(CostSettlementActivity.i(CostSettlementActivity.this));
          j.getReservationOrderText(CostSettlementActivity.c(CostSettlementActivity.this), new a(CostSettlementActivity.this), paramk, true, CostSettlementActivity.h(CostSettlementActivity.this));
        }
        else if (paramk.getUrl().equals(CostSettlementActivity.this.b))
        {
          paramk = new Intent(CostSettlementActivity.c(CostSettlementActivity.this), MainActivity.class);
          paramk.putExtra("FRAGMENT_TYPE", 7);
          CostSettlementActivity.this.startActivity(paramk);
          CostSettlementActivity.this.finish();
        }
        else if (paramk.getUrl().equals(CostSettlementActivity.this.c))
        {
          CostSettlementActivity.this.finish();
          continue;
          paramk = paramk.getMessage();
          CostSettlementActivity.this.showToast(paramk);
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/termination/CostSettlementActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */