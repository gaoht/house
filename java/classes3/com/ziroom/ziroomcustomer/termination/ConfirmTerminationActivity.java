package com.ziroom.ziroomcustomer.termination;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.e.a;
import com.ziroom.ziroomcustomer.e.g;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.model.IkeyRaConfig;
import com.ziroom.ziroomcustomer.signed.NewZZItemsActivity;
import com.ziroom.ziroomcustomer.signed.h;
import com.ziroom.ziroomcustomer.signed.h.a;
import com.ziroom.ziroomcustomer.termination.a.l;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfirmTerminationActivity
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
  private TextView K;
  private TextView L;
  private LinearLayout M;
  private TextView N;
  private TextView O;
  private TextView P;
  private TextView Q;
  private TextView R;
  private String S;
  private String T;
  private String U;
  private String V;
  private String W;
  private HashMap<String, String> X;
  private String Y;
  private LinearLayout Z;
  public Handler a = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 1: 
        paramAnonymousMessage = (String)paramAnonymousMessage.obj;
        ConfirmTerminationActivity.this.showToast(paramAnonymousMessage);
        return;
      }
      ConfirmTerminationActivity.d(ConfirmTerminationActivity.this).setEnabled(true);
    }
  };
  private TextView aa;
  private TextView ab;
  private ImageView ac;
  private String ad;
  private View ae;
  private TextView af;
  private TextView ag;
  private TextView ah;
  private TextView ai;
  private Dialog aj;
  private Context b;
  private ImageView c;
  private ListView d;
  private List<String> e;
  private PopupWindow f;
  private boolean g = true;
  private View r;
  private ImageView s;
  private l t;
  private TextView u;
  private TextView v;
  private TextView w;
  private TextView x;
  private TextView y;
  private TextView z;
  
  private void a()
  {
    b();
    View localView1 = View.inflate(this, 2130905075, null);
    this.d = ((ListView)localView1.findViewById(2131691156));
    final com.ziroom.ziroomcustomer.adapter.e locale = new com.ziroom.ziroomcustomer.adapter.e(this.b, this.e);
    this.d.setAdapter(locale);
    PopupWindow localPopupWindow;
    View localView2;
    if (this.g)
    {
      this.f = new PopupWindow(localView1, -1, -1, true);
      this.f.setContentView(localView1);
      this.f.setOutsideTouchable(false);
      this.f.setFocusable(false);
      localPopupWindow = this.f;
      localView2 = this.r;
      if (!(localPopupWindow instanceof PopupWindow)) {
        localPopupWindow.showAsDropDown(localView2);
      }
    }
    for (this.g = false;; this.g = true)
    {
      localView1.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          ConfirmTerminationActivity.a(ConfirmTerminationActivity.this).dismiss();
          ConfirmTerminationActivity.a(ConfirmTerminationActivity.this, true);
        }
      });
      this.d.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        @Instrumented
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          if ("取消解约".equals(locale.getmList().get(paramAnonymousInt))) {
            ConfirmTerminationActivity.this.showDialog(null);
          }
        }
      });
      return;
      VdsAgent.showAsDropDown((PopupWindow)localPopupWindow, localView2);
      break;
      this.f.dismiss();
    }
  }
  
  private void b()
  {
    this.e = new ArrayList();
    this.e.add("取消解约");
  }
  
  public void initView()
  {
    this.Z = ((LinearLayout)findViewById(2131693369));
    this.aa = ((TextView)findViewById(2131693370));
    this.ab = ((TextView)findViewById(2131693372));
    this.ac = ((ImageView)findViewById(2131693371));
    this.M = ((LinearLayout)findViewById(2131693356));
    this.N = ((TextView)findViewById(2131693358));
    this.O = ((TextView)findViewById(2131693360));
    this.P = ((TextView)findViewById(2131693362));
    this.Q = ((TextView)findViewById(2131693364));
    this.R = ((TextView)findViewById(2131693366));
    this.B = ((TextView)findViewById(2131693350));
    this.H = ((TextView)findViewById(2131693367));
    this.F = ((TextView)findViewById(2131693354));
    this.D = ((TextView)findViewById(2131693352));
    this.L = ((TextView)findViewById(2131693374));
    this.s = ((ImageView)findViewById(2131689492));
    this.G = ((TextView)findViewById(2131693368));
    this.E = ((TextView)findViewById(2131693355));
    this.C = ((TextView)findViewById(2131693353));
    this.A = ((TextView)findViewById(2131693351));
    this.z = ((TextView)findViewById(2131693348));
    this.K = ((TextView)findViewById(2131693349));
    this.y = ((TextView)findViewById(2131693347));
    this.x = ((TextView)findViewById(2131693346));
    this.w = ((TextView)findViewById(2131693345));
    this.v = ((TextView)findViewById(2131693344));
    this.u = ((TextView)findViewById(2131693343));
    this.I = ((TextView)findViewById(2131693375));
    this.J = ((TextView)findViewById(2131693376));
    this.r = findViewById(2131691959);
    this.c = ((ImageView)findViewById(2131693342));
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
    case 2131693342: 
    case 2131693375: 
    case 2131689492: 
    case 2131693374: 
    case 2131697639: 
    case 2131697638: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                a();
                return;
                this.I.setEnabled(false);
                this.V = (q.s + e.a.q);
                paramView = g.getRaConfig();
                j.getReservationOrderText(this.b, new a(), paramView, true, this.V);
                return;
                finish();
              } while (this.t == null);
              if ("dbl".equals(this.t.getState()))
              {
                ApplicationEx.c.finishAllActivity();
                return;
              }
            } while ((!"blz".equals(this.t.getState())) || ("dkhqr".equals(this.t.getSubState())));
            ApplicationEx.c.finishAllActivity();
            return;
          } while ((this.t == null) || (TextUtils.isEmpty(this.t.getGjPhone())));
          ah.callPhone(this.b, this.t.getGjPhone());
          return;
        } while (this.t == null);
        this.Y = (q.s + e.a.n);
        paramView = g.getCancelBackRendOrder(this.t.getBackRentOrderCode());
        j.getReservationOrderText(this.b, new a(), paramView, true, this.Y);
        return;
        this.aj.dismiss();
      } while (this.f == null);
      this.f.dismiss();
      this.g = true;
      return;
    }
    showDialog("生活费用");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903694);
    this.b = this;
    this.S = getIntent().getStringExtra("contractCode");
    this.T = getIntent().getStringExtra("mode");
    this.ad = getIntent().getStringExtra("isShowMove");
    this.U = (q.s + e.a.d);
    paramBundle = g.getViewBackRenderContractUrl(this.S, this.T);
    j.getReservationOrderText(this.b, new a(), paramBundle, true, this.U);
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
    if ((this.f != null) && (this.f.isShowing()))
    {
      this.f.dismiss();
      this.g = true;
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void setData()
  {
    if (this.t == null) {}
    label563:
    label581:
    label686:
    label708:
    label876:
    label1003:
    label1013:
    label1030:
    label1050:
    label1071:
    for (;;)
    {
      return;
      if (this.t.getLoanState() == 0)
      {
        this.M.setVisibility(8);
        this.N.setText(this.t.getLoanAccount() + "元");
        this.O.setText(this.t.getPayAccount() + "元");
        this.P.setText(this.t.getPayInterest() + "元");
        this.Q.setText(this.t.getNeedInterest() + "元");
        this.R.setText(this.t.getLoanPenalty() + "元");
        this.z.setText(m.StrToNorDate(this.t.getApplyDate()));
        this.K.setText(m.StrToNorDate(this.t.getRentBackDate()));
        this.y.setText(this.t.getAddress());
        this.x.setText(this.t.getCertNumber());
        this.w.setText(this.t.getCertType());
        this.v.setText(this.t.getUserPhone());
        this.u.setText(this.t.getCustomerName());
        this.G.setText(this.t.getPenalty() + "元");
        this.H.setText(this.t.getPenaltyNote());
        this.E.setText(this.t.getDepositNeedReturn() + "元");
        this.F.setText(this.t.getDepositNote());
        this.C.setText(this.t.getCommissionNeedReturn() + "元");
        this.D.setText(this.t.getCommissionNote());
        this.A.setText(this.t.getRentNeedReturn() + "元");
        this.B.setText(this.t.getRentNote());
        if (ae.notNull(this.t.getGj_tip())) {
          this.J.setText(this.t.getGj_tip());
        }
        if (!"dbl".equals(this.t.getState())) {
          break label876;
        }
        this.I.setVisibility(8);
        this.J.setVisibility(0);
        if (this.t.getLoanState() == 1) {
          this.c.setVisibility(0);
        }
        if (this.X != null) {
          break label1003;
        }
        this.X = new HashMap();
        this.X.put("name", this.t.getCustomerName());
        this.X.put("mCerType2", this.t.getCertType() + "");
        this.X.put("cerNum", this.t.getCertNumber());
        ApplicationEx.c.setUserMap(this.X);
        if (!ae.isNull(this.t.getAmiHistroyLiveFeeNote())) {
          break label1013;
        }
        this.Z.setVisibility(8);
        if (!ae.isNull(this.t.getAmiHistroyLiveFeeTip())) {
          break label1030;
        }
        this.ac.setVisibility(8);
        if (!ae.isNull(this.t.getAmiHistroyLiveFee())) {
          break label1050;
        }
        this.ab.setText("");
      }
      for (;;)
      {
        if ((this.t.getActivityInfo() == null) || (!"1".equals(this.ad)) || (this.t.getActivityInfo().get("imgUrl") == null) || (!ae.notNull(this.t.getActivityInfo().get("imgUrl").toString()))) {
          break label1071;
        }
        h.creatDialog(this.b, this.t.getActivityInfo().get("imgUrl").toString(), false, true, this.t.getActivityInfo().get("skipUrl") + "", this.t.getActivityInfo(), new h.a()
        {
          public void closeDialog() {}
          
          public void toMoveHouseWeb(String paramAnonymousString)
          {
            if (ae.notNull(paramAnonymousString)) {
              JsBridgeWebActivity.start(ConfirmTerminationActivity.c(ConfirmTerminationActivity.this), null, paramAnonymousString);
            }
          }
        });
        return;
        this.M.setVisibility(0);
        break;
        if ("blz".equals(this.t.getState()))
        {
          if ("dkhqr".equals(this.t.getSubState()))
          {
            this.I.setVisibility(0);
            this.J.setVisibility(8);
          }
          for (;;)
          {
            this.c.setVisibility(8);
            break;
            this.I.setVisibility(8);
            this.J.setVisibility(0);
          }
        }
        if (!"ybl".equals(this.t.getState())) {
          break label563;
        }
        this.I.setVisibility(8);
        this.J.setVisibility(8);
        this.c.setVisibility(8);
        break label563;
        this.X.clear();
        break label581;
        this.aa.setText(this.t.getAmiHistroyLiveFeeNote());
        break label686;
        this.ac.setVisibility(8);
        this.ac.setOnClickListener(this);
        break label708;
        this.ab.setText(ah.Number(Float.parseFloat(this.t.getAmiHistroyLiveFee())));
      }
    }
  }
  
  public void setOnclick()
  {
    this.L.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.I.setOnClickListener(this);
  }
  
  public void showDialog(String paramString)
  {
    this.ae = View.inflate(this.b, 2130905165, null);
    this.af = ((TextView)this.ae.findViewById(2131697639));
    this.ai = ((TextView)this.ae.findViewById(2131697638));
    this.ah = ((TextView)this.ae.findViewById(2131697637));
    this.ag = ((TextView)this.ae.findViewById(2131697634));
    this.af.setOnClickListener(this);
    this.ai.setOnClickListener(this);
    this.ag.setVisibility(8);
    this.af.setVisibility(0);
    this.ai.setVisibility(0);
    this.ah.setGravity(17);
    if (ae.isNull(paramString))
    {
      this.ah.setText("取消退租后再次发起转租或者退租，申请日期将重新计算");
      this.ag.setVisibility(0);
      this.ag.setText("确定要取消退租吗？");
      this.af.setText("是的");
      this.ai.setText("我再想想");
      if (this.aj == null)
      {
        this.aj = new Dialog(this.b, 2131427781);
        this.aj.setContentView(this.ae);
        this.aj.setCanceledOnTouchOutside(false);
        this.aj.setCancelable(false);
        paramString = this.aj;
        if ((paramString instanceof Dialog)) {
          break label324;
        }
        paramString.show();
      }
    }
    for (;;)
    {
      ApplicationEx.g = 2;
      this.aj.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          ConfirmTerminationActivity.a(ConfirmTerminationActivity.this, null);
          ConfirmTerminationActivity.b(ConfirmTerminationActivity.this).dismiss();
          ConfirmTerminationActivity.a(ConfirmTerminationActivity.this, null);
        }
      });
      return;
      this.ag.setText("提示");
      this.ag.setVisibility(0);
      this.ah.setText(paramString);
      this.af.setVisibility(8);
      this.ai.setText("我知道了");
      break;
      label324:
      VdsAgent.showDialog((Dialog)paramString);
    }
  }
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, k paramk)
    {
      paramString = com.alibaba.fastjson.a.parseObject(paramString);
      Object localObject = (String)paramString.get("status");
      if (paramk.getUrl().equals(ConfirmTerminationActivity.e(ConfirmTerminationActivity.this)))
      {
        if ("success".equals(localObject))
        {
          paramString = (IkeyRaConfig)com.alibaba.fastjson.a.parseObject(paramString.get("data").toString(), IkeyRaConfig.class);
          if (paramString != null) {
            ApplicationEx.c.setRaConfig(paramString);
          }
          paramk.setSuccess(Boolean.valueOf(true));
          return;
        }
        ConfirmTerminationActivity.a(ConfirmTerminationActivity.this, q.s + e.a.r);
        localObject = g.getAddErrorMsg("获取RA配置信息失败", paramk.getMessage(), ConfirmTerminationActivity.c(ConfirmTerminationActivity.this));
        j.getReservationOrderText(ConfirmTerminationActivity.c(ConfirmTerminationActivity.this), new a(ConfirmTerminationActivity.this), (Map)localObject, true, ConfirmTerminationActivity.k(ConfirmTerminationActivity.this));
        paramk.setSuccess(Boolean.valueOf(false));
        paramk.setMessage((String)paramString.get("error_message"));
        return;
      }
      if (paramk.getUrl().equals(ConfirmTerminationActivity.i(ConfirmTerminationActivity.this)))
      {
        if (((String)localObject).equals("success"))
        {
          paramString = (l)com.alibaba.fastjson.a.parseObject(paramString.get("data").toString(), l.class);
          paramk.setSuccess(Boolean.valueOf(true));
          paramk.setObject(paramString);
          return;
        }
        paramk.setSuccess(Boolean.valueOf(false));
        paramk.setMessage((String)paramString.get("error_message"));
        return;
      }
      if (paramk.getUrl().equals(ConfirmTerminationActivity.j(ConfirmTerminationActivity.this)))
      {
        if (((String)localObject).equals("success"))
        {
          paramk.setSuccess(Boolean.valueOf(true));
          return;
        }
        paramk.setSuccess(Boolean.valueOf(false));
        paramk.setMessage((String)paramString.get("error_message"));
        return;
      }
      if (((String)localObject).equals("success"))
      {
        paramk.setSuccess(Boolean.valueOf(true));
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage((String)paramString.get("error_message"));
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        if (paramk.getUrl().equals(ConfirmTerminationActivity.e(ConfirmTerminationActivity.this)))
        {
          ConfirmTerminationActivity.this.showProgressNoCancel("下证书", 5000L);
          paramk = new a(ConfirmTerminationActivity.c(ConfirmTerminationActivity.this), ConfirmTerminationActivity.this, ConfirmTerminationActivity.f(ConfirmTerminationActivity.this), new a(ConfirmTerminationActivity.this), ConfirmTerminationActivity.this.a);
          paramk.setmPaperless(new a.b()
          {
            public void Attestation(String paramAnonymousString) {}
            
            public void DownloadError()
            {
              ConfirmTerminationActivity.this.a.sendEmptyMessage(9437185);
            }
            
            public void DownloadSuccess()
            {
              Intent localIntent;
              if (("5".equals(ConfirmTerminationActivity.g(ConfirmTerminationActivity.this).getHouseType())) || ("8".equals(ConfirmTerminationActivity.g(ConfirmTerminationActivity.this).getHouseType())))
              {
                localIntent = new Intent(ConfirmTerminationActivity.c(ConfirmTerminationActivity.this), NewZZItemsActivity.class);
                localIntent.putExtra("isTermination", "isTermination");
              }
              for (;;)
              {
                localIntent.putExtra("backRentOrderCode", ConfirmTerminationActivity.g(ConfirmTerminationActivity.this).getBackRentOrderCode());
                localIntent.putExtra("loanState", ConfirmTerminationActivity.g(ConfirmTerminationActivity.this).getLoanState());
                localIntent.putExtra("contractCode", ConfirmTerminationActivity.h(ConfirmTerminationActivity.this));
                if (ConfirmTerminationActivity.g(ConfirmTerminationActivity.this) != null) {
                  break;
                }
                return;
                localIntent = new Intent(ConfirmTerminationActivity.c(ConfirmTerminationActivity.this), TerminationHandleSureActivity.class);
              }
              if (!TextUtils.isEmpty(ConfirmTerminationActivity.g(ConfirmTerminationActivity.this).getGjPhone())) {
                localIntent.putExtra("gjPhone", ConfirmTerminationActivity.g(ConfirmTerminationActivity.this).getGjPhone());
              }
              ConfirmTerminationActivity.this.startActivity(localIntent);
              ConfirmTerminationActivity.this.dismissProgress();
            }
          });
          paramk.initCaManager();
          paramk.iKeyFilter();
        }
        do
        {
          return;
          if (paramk.getUrl().equals(ConfirmTerminationActivity.i(ConfirmTerminationActivity.this)))
          {
            ConfirmTerminationActivity.a(ConfirmTerminationActivity.this, (l)paramk.getObject());
            ConfirmTerminationActivity.this.setData();
            return;
          }
          if (paramk.getUrl().equals(ConfirmTerminationActivity.j(ConfirmTerminationActivity.this)))
          {
            paramk = new Intent(ConfirmTerminationActivity.c(ConfirmTerminationActivity.this), MainActivity.class);
            paramk.putExtra("FRAGMENT_TYPE", 7);
            ConfirmTerminationActivity.this.startActivity(paramk);
            ConfirmTerminationActivity.this.finish();
            return;
          }
        } while (!paramk.getUrl().equals(q.s + e.a.r));
        ConfirmTerminationActivity.this.showToast("无纸化错误");
        return;
      }
      ConfirmTerminationActivity.d(ConfirmTerminationActivity.this).setEnabled(true);
      paramk = paramk.getMessage();
      ConfirmTerminationActivity.this.showToast(paramk);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/termination/ConfirmTerminationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */