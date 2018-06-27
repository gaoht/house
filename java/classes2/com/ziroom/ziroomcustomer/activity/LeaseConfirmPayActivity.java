package com.ziroom.ziroomcustomer.activity;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.collection.GrowingIO;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.umeng.analytics.MobclickAgent;
import com.ziroom.commonlibrary.e.c.b;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.adapter.h;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.findhouse.view.RentHouseDetailActivity;
import com.ziroom.ziroomcustomer.model.HouseDetail;
import com.ziroom.ziroomcustomer.model.LeaseInfo;
import com.ziroom.ziroomcustomer.model.LeasePayPlan;
import com.ziroom.ziroomcustomer.model.PayOrder;
import com.ziroom.ziroomcustomer.model.PayStateInfo;
import com.ziroom.ziroomcustomer.model.RentCardDetail;
import com.ziroom.ziroomcustomer.model.SignedPayDetails;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.pay.huifu.activity.AddBandCardActivity;
import com.ziroom.ziroomcustomer.pay.huifu.bean.HuiFuIsBandAndBandList;
import com.ziroom.ziroomcustomer.pay.huifu.bean.HuiFuIsBandAndBandList.DataBean;
import com.ziroom.ziroomcustomer.pay.huifu.bean.HuiFuIsBandAndBandList.DataBean.HfInfoBean;
import com.ziroom.ziroomcustomer.pay.huifu.bean.HuiFuIsBandAndBandList.DataBean.HfInfoBean.BindBanksBean;
import com.ziroom.ziroomcustomer.pay.huifu.bean.HuifuBackMessage;
import com.ziroom.ziroomcustomer.pay.huifu.bean.HuifuBankMessage;
import com.ziroom.ziroomcustomer.pay.huifu.bean.HuifuBankMessage.DataBean;
import com.ziroom.ziroomcustomer.pay.huifu.views.a.a.b;
import com.ziroom.ziroomcustomer.pay.uniondk.activity.UnionDKPayNoticeActivity;
import com.ziroom.ziroomcustomer.pay.uniondk.bean.UnionDKBaseJson;
import com.ziroom.ziroomcustomer.pay.uniondk.bean.UnionDKCheckMessage;
import com.ziroom.ziroomcustomer.pay.uniondk.bean.UnionDKPayIsBandCard;
import com.ziroom.ziroomcustomer.pay.uniondk.bean.UnionDKPayIsBandCard.DataBean;
import com.ziroom.ziroomcustomer.pay.uniondk.bean.UnionDKPayIsBandCard.DataBean.CardInfoListBean;
import com.ziroom.ziroomcustomer.signed.EnterprisePaySuccessActivity;
import com.ziroom.ziroomcustomer.signed.PayPartActivity;
import com.ziroom.ziroomcustomer.signed.PaySuccessActivity;
import com.ziroom.ziroomcustomer.signed.SignedJDPayWebActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.util.w;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class LeaseConfirmPayActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static LeaseConfirmPayActivity a = null;
  private LinearLayout A;
  private a B;
  private EditText C;
  private ListView D;
  private Button E;
  private Button F;
  private Button G;
  private Button H;
  private Button I;
  private RelativeLayout J;
  private h K;
  private ArrayList<RentCardDetail> L;
  private String M;
  private String N = "";
  private List<RentCardDetail> O = new ArrayList();
  private boolean P;
  private double Q = 0.0D;
  private double R = 0.0D;
  private float S;
  private int T = 0;
  private SignedPayDetails U;
  private LinearLayout V;
  private Button W;
  private String X;
  private com.ziroom.commonlibrary.e.d Y = new com.ziroom.commonlibrary.e.d();
  private LeasePayPlan Z;
  private String aA = "";
  private HouseDetail aB;
  private String aC = "0";
  private float aD = 0.0F;
  private boolean aE = true;
  private PopupWindow aF;
  private RelativeLayout aG;
  private RelativeLayout aH;
  private int aI;
  private int aJ;
  private float aK;
  private float aL;
  private String aM;
  private RelativeLayout aN;
  private boolean aO;
  private boolean aP;
  private boolean aQ;
  private String aR;
  private ListViewForScrollView aS;
  private List<String> aT;
  private List<String> aU;
  private String aV;
  private TextView aW;
  private LeaseInfo aX;
  private HashMap<String, String> aY;
  private Boolean aZ = Boolean.valueOf(false);
  private String aa;
  private ImageView ab;
  private TextView ac;
  private PayOrder ad;
  private String ae;
  private Dialog af;
  private Button ag;
  private Button ah;
  private TextView ai;
  private TextView aj;
  private TextView ak;
  private CheckBox al;
  private CheckBox am;
  private LinearLayout an;
  private LinearLayout ao;
  private View ap;
  private Context aq;
  private LinearLayout ar;
  private TextView as;
  private TextView at;
  private TextView au;
  private TextView av;
  private TextView aw;
  private TextView ax;
  private EditText ay;
  private Dialog az;
  CompoundButton.OnCheckedChangeListener b = new CompoundButton.OnCheckedChangeListener()
  {
    @Instrumented
    public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
    {
      VdsAgent.onCheckedChanged(this, paramAnonymousCompoundButton, paramAnonymousBoolean);
      switch (paramAnonymousCompoundButton.getId())
      {
      case 2131693316: 
      case 2131693317: 
      default: 
        return;
      case 2131693315: 
        if (paramAnonymousBoolean)
        {
          LeaseConfirmPayActivity.c(LeaseConfirmPayActivity.this, paramAnonymousBoolean);
          return;
        }
        if (new Float(VdsAgent.trackEditTextSilent(LeaseConfirmPayActivity.p(LeaseConfirmPayActivity.this)).toString()).floatValue() > 0.0F) {
          LeaseConfirmPayActivity.this.setPayType();
        }
        LeaseConfirmPayActivity.c(LeaseConfirmPayActivity.this, paramAnonymousBoolean);
        return;
      }
      if (paramAnonymousBoolean)
      {
        if (LeaseConfirmPayActivity.C(LeaseConfirmPayActivity.this) == 0.0F)
        {
          LeaseConfirmPayActivity.B(LeaseConfirmPayActivity.this).setChecked(false);
          LeaseConfirmPayActivity.this.showToast("请先输入代金券");
          return;
        }
        LeaseConfirmPayActivity.d(LeaseConfirmPayActivity.this, LeaseConfirmPayActivity.C(LeaseConfirmPayActivity.this));
        LeaseConfirmPayActivity.d(LeaseConfirmPayActivity.this, false);
        return;
      }
      if (new Float(VdsAgent.trackEditTextSilent(LeaseConfirmPayActivity.p(LeaseConfirmPayActivity.this)).toString()).floatValue() > 0.0F) {
        LeaseConfirmPayActivity.this.setPayType();
      }
      LeaseConfirmPayActivity.d(LeaseConfirmPayActivity.this, true);
    }
  };
  private Boolean ba = Boolean.valueOf(false);
  private Boolean bb = Boolean.valueOf(false);
  private HuiFuIsBandAndBandList.DataBean.HfInfoBean.BindBanksBean bc;
  private UnionDKPayIsBandCard.DataBean.CardInfoListBean bd;
  private String be;
  private String bf;
  private String bg;
  private boolean bh = false;
  private String bi;
  private DecimalFormat bj = new DecimalFormat("#.00");
  private View bk;
  private TextView bl;
  private TextView bm;
  private TextView bn;
  private TextView bo;
  private Dialog bp;
  private com.ziroom.ziroomcustomer.pay.huifu.views.a.a bq;
  private Handler br = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      float f2 = 0.0F;
      if ((paramAnonymousMessage == null) && (paramAnonymousMessage.obj == null)) {}
      label562:
      label632:
      label1105:
      do
      {
        do
        {
          do
          {
            return;
            switch (paramAnonymousMessage.what)
            {
            default: 
              return;
            case 4105: 
              LeaseConfirmPayActivity.i(LeaseConfirmPayActivity.this).setEnabled(true);
              LeaseConfirmPayActivity.this.dismissProgress();
              paramAnonymousMessage = (l)paramAnonymousMessage.obj;
              if (!paramAnonymousMessage.getSuccess().booleanValue()) {
                break label1105;
              }
              if (!LeaseConfirmPayActivity.h(LeaseConfirmPayActivity.this).equals("hf_make_order")) {
                break label632;
              }
              LeaseConfirmPayActivity.a(LeaseConfirmPayActivity.this, (PayOrder)paramAnonymousMessage.getObject());
              if (!"201000".equals(LeaseConfirmPayActivity.n(LeaseConfirmPayActivity.this).getResp_code())) {
                break label562;
              }
              g.textToast(LeaseConfirmPayActivity.this, LeaseConfirmPayActivity.n(LeaseConfirmPayActivity.this).getResp_desc());
              if (LeaseConfirmPayActivity.k(LeaseConfirmPayActivity.this).getPeriods() == 1) {
                break;
              }
              LeaseConfirmPayActivity.o(LeaseConfirmPayActivity.this);
              return;
            case 8947848: 
              paramAnonymousMessage = (HuifuBackMessage)paramAnonymousMessage.obj;
            }
          } while (paramAnonymousMessage == null);
          LeaseConfirmPayActivity.d(LeaseConfirmPayActivity.this, paramAnonymousMessage.huifuBankMessage.data.order_id);
          LeaseConfirmPayActivity.e(LeaseConfirmPayActivity.this, paramAnonymousMessage.mMessageCode);
          LeaseConfirmPayActivity.f(LeaseConfirmPayActivity.this, paramAnonymousMessage.huifuBankMessage.data.order_date);
          LeaseConfirmPayActivity.this.onConfirm();
          return;
          LeaseConfirmPayActivity.this.dismissProgress();
          paramAnonymousMessage = (l)paramAnonymousMessage.obj;
          if (paramAnonymousMessage.getSuccess().booleanValue())
          {
            LeaseConfirmPayActivity.a(LeaseConfirmPayActivity.this, (ArrayList)paramAnonymousMessage.getObject());
            if ((LeaseConfirmPayActivity.r(LeaseConfirmPayActivity.this) != null) && (LeaseConfirmPayActivity.r(LeaseConfirmPayActivity.this).size() > 0))
            {
              LeaseConfirmPayActivity.s(LeaseConfirmPayActivity.this).setText(LeaseConfirmPayActivity.r(LeaseConfirmPayActivity.this).size() + "张可用");
              LeaseConfirmPayActivity.s(LeaseConfirmPayActivity.this).setTextColor(Color.parseColor("#dd660d"));
              return;
            }
            LeaseConfirmPayActivity.g(LeaseConfirmPayActivity.this, "您还没有可用的租金卡哦");
            LeaseConfirmPayActivity.s(LeaseConfirmPayActivity.this).setText("0张可用");
            LeaseConfirmPayActivity.s(LeaseConfirmPayActivity.this).setTextColor(Color.parseColor("#ff7d7d7d"));
            return;
          }
          LeaseConfirmPayActivity.this.showToast("");
          LeaseConfirmPayActivity.g(LeaseConfirmPayActivity.this, paramAnonymousMessage.getMessage());
          return;
          LeaseConfirmPayActivity.this.dismissProgress();
          if (LeaseConfirmPayActivity.t(LeaseConfirmPayActivity.this) != null)
          {
            LeaseConfirmPayActivity.a(LeaseConfirmPayActivity.this, LeaseConfirmPayActivity.t(LeaseConfirmPayActivity.this).getChecked());
            LeaseConfirmPayActivity.t(LeaseConfirmPayActivity.this).notifyDataSetChanged();
          }
          LeaseConfirmPayActivity.this.refreshTip();
          return;
          LeaseConfirmPayActivity.a(LeaseConfirmPayActivity.this, Float.parseFloat(VdsAgent.trackEditTextSilent(LeaseConfirmPayActivity.p(LeaseConfirmPayActivity.this)).toString()));
          LeaseConfirmPayActivity.q(LeaseConfirmPayActivity.this);
          return;
          if ("201002".equals(LeaseConfirmPayActivity.n(LeaseConfirmPayActivity.this).getResp_code()))
          {
            LeaseConfirmPayActivity.this.showProgress("");
            new Handler().postDelayed(new Runnable()
            {
              public void run()
              {
                com.ziroom.ziroomcustomer.e.d.getWYPayState(LeaseConfirmPayActivity.j(LeaseConfirmPayActivity.this), LeaseConfirmPayActivity.n(LeaseConfirmPayActivity.this).getOrderCode());
              }
            }, 7000L);
            return;
          }
          g.textToast(LeaseConfirmPayActivity.this, LeaseConfirmPayActivity.n(LeaseConfirmPayActivity.this).getResp_desc());
          return;
          if (LeaseConfirmPayActivity.h(LeaseConfirmPayActivity.this).equals("yl_dk"))
          {
            LeaseConfirmPayActivity.a(LeaseConfirmPayActivity.this, (PayOrder)paramAnonymousMessage.getObject());
            if (("paying".equals(LeaseConfirmPayActivity.n(LeaseConfirmPayActivity.this).getRespCode())) || ("fail".equals(LeaseConfirmPayActivity.n(LeaseConfirmPayActivity.this).getRespCode())))
            {
              LeaseConfirmPayActivity.this.showProgress("");
              new Handler().postDelayed(new Runnable()
              {
                public void run()
                {
                  com.ziroom.ziroomcustomer.e.d.getWYPayState(LeaseConfirmPayActivity.j(LeaseConfirmPayActivity.this), LeaseConfirmPayActivity.n(LeaseConfirmPayActivity.this).getOrderCode());
                }
              }, 7000L);
              return;
            }
            if ("success".equals(LeaseConfirmPayActivity.n(LeaseConfirmPayActivity.this).getRespCode()))
            {
              g.textToast(LeaseConfirmPayActivity.this, LeaseConfirmPayActivity.n(LeaseConfirmPayActivity.this).getRespMsg());
              if (LeaseConfirmPayActivity.k(LeaseConfirmPayActivity.this).getPeriods() != 1)
              {
                LeaseConfirmPayActivity.o(LeaseConfirmPayActivity.this);
                return;
              }
              LeaseConfirmPayActivity.a(LeaseConfirmPayActivity.this, Float.parseFloat(VdsAgent.trackEditTextSilent(LeaseConfirmPayActivity.p(LeaseConfirmPayActivity.this)).toString()));
              LeaseConfirmPayActivity.q(LeaseConfirmPayActivity.this);
              return;
            }
            g.textToast(LeaseConfirmPayActivity.this, LeaseConfirmPayActivity.n(LeaseConfirmPayActivity.this).getRespMsg());
            return;
          }
          if (LeaseConfirmPayActivity.h(LeaseConfirmPayActivity.this).equals("balance_order")) {
            break;
          }
          LeaseConfirmPayActivity.a(LeaseConfirmPayActivity.this, (PayOrder)paramAnonymousMessage.getObject());
          if (LeaseConfirmPayActivity.k(LeaseConfirmPayActivity.this).getPeriods() == 1)
          {
            LeaseConfirmPayActivity.b(LeaseConfirmPayActivity.this, true);
            if ("2".equals(LeaseConfirmPayActivity.k(LeaseConfirmPayActivity.this).getContractStrategy())) {
              LeaseConfirmPayActivity.u(LeaseConfirmPayActivity.this).setText("请您尽快完成支付！");
            }
            for (;;)
            {
              paramAnonymousMessage = LeaseConfirmPayActivity.v(LeaseConfirmPayActivity.this);
              if ((paramAnonymousMessage instanceof Dialog)) {
                break;
              }
              paramAnonymousMessage.show();
              return;
              LeaseConfirmPayActivity.u(LeaseConfirmPayActivity.this).setText("请在二十分钟内完成支付");
            }
            VdsAgent.showDialog((Dialog)paramAnonymousMessage);
            return;
          }
          if ((LeaseConfirmPayActivity.h(LeaseConfirmPayActivity.this).equals("yl_make_order")) || (LeaseConfirmPayActivity.h(LeaseConfirmPayActivity.this).equals("yl_cashCard_make_order")))
          {
            LeaseConfirmPayActivity.this.onUPPay(LeaseConfirmPayActivity.n(LeaseConfirmPayActivity.this));
            return;
          }
          if (LeaseConfirmPayActivity.h(LeaseConfirmPayActivity.this).equals("wxpay_make_order_v2"))
          {
            LeaseConfirmPayActivity.b(LeaseConfirmPayActivity.this, LeaseConfirmPayActivity.n(LeaseConfirmPayActivity.this));
            return;
          }
        } while ((!LeaseConfirmPayActivity.h(LeaseConfirmPayActivity.this).equals("jd_loan")) && (!LeaseConfirmPayActivity.h(LeaseConfirmPayActivity.this).equals("jd_m_pay")));
        LeaseConfirmPayActivity.c(LeaseConfirmPayActivity.this, LeaseConfirmPayActivity.n(LeaseConfirmPayActivity.this));
        return;
        LeaseConfirmPayActivity.q(LeaseConfirmPayActivity.this);
        return;
        LeaseConfirmPayActivity.b(LeaseConfirmPayActivity.this, false);
        LeaseConfirmPayActivity.h(LeaseConfirmPayActivity.this, paramAnonymousMessage.getCode());
        LeaseConfirmPayActivity.u(LeaseConfirmPayActivity.this).setText(paramAnonymousMessage.getMessage());
        paramAnonymousMessage = LeaseConfirmPayActivity.v(LeaseConfirmPayActivity.this);
        if (!(paramAnonymousMessage instanceof Dialog))
        {
          paramAnonymousMessage.show();
          return;
        }
        VdsAgent.showDialog((Dialog)paramAnonymousMessage);
        return;
        LeaseConfirmPayActivity.this.dismissProgress();
        paramAnonymousMessage = (l)paramAnonymousMessage.obj;
        if (paramAnonymousMessage.getSuccess().booleanValue())
        {
          LeaseConfirmPayActivity.a(LeaseConfirmPayActivity.this, (SignedPayDetails)paramAnonymousMessage.getObject());
          LeaseConfirmPayActivity.b(LeaseConfirmPayActivity.this, LeaseConfirmPayActivity.k(LeaseConfirmPayActivity.this).getPayTypeList());
          LeaseConfirmPayActivity.w(LeaseConfirmPayActivity.this);
          return;
        }
        g.textToast(LeaseConfirmPayActivity.a, paramAnonymousMessage.getMessage(), 0);
        return;
        LeaseConfirmPayActivity.this.dismissProgress();
        paramAnonymousMessage = (l)paramAnonymousMessage.obj;
        if (!paramAnonymousMessage.getSuccess().booleanValue()) {
          break;
        }
      } while (((PayStateInfo)paramAnonymousMessage.getObject()).getIs_pay().intValue() != 1);
      LeaseConfirmPayActivity.a(LeaseConfirmPayActivity.this, Float.parseFloat(VdsAgent.trackEditTextSilent(LeaseConfirmPayActivity.p(LeaseConfirmPayActivity.this)).toString()));
      LeaseConfirmPayActivity.q(LeaseConfirmPayActivity.this);
      return;
      g.textToast(LeaseConfirmPayActivity.a, "sfsdfds" + paramAnonymousMessage.getMessage(), 0);
      return;
      LeaseConfirmPayActivity.this.dismissProgress();
      paramAnonymousMessage = (l)paramAnonymousMessage.obj;
      if (paramAnonymousMessage.getSuccess().booleanValue())
      {
        LeaseConfirmPayActivity.a(LeaseConfirmPayActivity.this, Float.parseFloat(VdsAgent.trackEditTextSilent(LeaseConfirmPayActivity.p(LeaseConfirmPayActivity.this)).toString()));
        LeaseConfirmPayActivity.q(LeaseConfirmPayActivity.this);
        return;
      }
      LeaseConfirmPayActivity.x(LeaseConfirmPayActivity.this).setText("房源锁定失败");
      LeaseConfirmPayActivity.y(LeaseConfirmPayActivity.this).setText("房源锁定失败，请联系客服！");
      Dialog localDialog = new Dialog(LeaseConfirmPayActivity.this, 2131427781);
      localDialog.setContentView(LeaseConfirmPayActivity.z(LeaseConfirmPayActivity.this));
      LeaseConfirmPayActivity.y(LeaseConfirmPayActivity.this).setText(paramAnonymousMessage.getMessage());
      if (!(localDialog instanceof Dialog))
      {
        localDialog.show();
        return;
      }
      VdsAgent.showDialog((Dialog)localDialog);
      return;
      LeaseConfirmPayActivity.this.dismissProgress();
      paramAnonymousMessage = (l)paramAnonymousMessage.obj;
      if (paramAnonymousMessage.getSuccess().booleanValue())
      {
        if (LeaseConfirmPayActivity.k(LeaseConfirmPayActivity.this).getPeriods() != 1)
        {
          LeaseConfirmPayActivity.o(LeaseConfirmPayActivity.this);
          return;
        }
        LeaseConfirmPayActivity.a(LeaseConfirmPayActivity.this, Float.parseFloat(VdsAgent.trackEditTextSilent(LeaseConfirmPayActivity.p(LeaseConfirmPayActivity.this)).toString()));
        LeaseConfirmPayActivity.q(LeaseConfirmPayActivity.this);
        return;
      }
      g.textToast(LeaseConfirmPayActivity.a, paramAnonymousMessage.getMessage(), 0);
      return;
      LeaseConfirmPayActivity.this.dismissProgress();
      paramAnonymousMessage = (l)paramAnonymousMessage.obj;
      float f1;
      float f3;
      if (paramAnonymousMessage.getSuccess().booleanValue())
      {
        if (ae.notNull(VdsAgent.trackEditTextSilent(LeaseConfirmPayActivity.A(LeaseConfirmPayActivity.this)).toString())) {
          LeaseConfirmPayActivity.i(LeaseConfirmPayActivity.this, VdsAgent.trackEditTextSilent(LeaseConfirmPayActivity.A(LeaseConfirmPayActivity.this)).toString());
        }
        LeaseConfirmPayActivity.b(LeaseConfirmPayActivity.this, ((Float)paramAnonymousMessage.getObject()).floatValue());
        if (((Float)paramAnonymousMessage.getObject()).floatValue() >= LeaseConfirmPayActivity.k(LeaseConfirmPayActivity.this).getCommission()) {
          f1 = LeaseConfirmPayActivity.k(LeaseConfirmPayActivity.this).getCommission();
        }
        for (;;)
        {
          if (LeaseConfirmPayActivity.B(LeaseConfirmPayActivity.this).isChecked()) {
            if (LeaseConfirmPayActivity.k(LeaseConfirmPayActivity.this).getIsBlank() != 1)
            {
              if (!"1".equals(LeaseConfirmPayActivity.k(LeaseConfirmPayActivity.this).getIsZWhite()))
              {
                f3 = Float.parseFloat(VdsAgent.trackEditTextSilent(LeaseConfirmPayActivity.p(LeaseConfirmPayActivity.this)).toString()) - f1 + LeaseConfirmPayActivity.C(LeaseConfirmPayActivity.this);
                f2 = f3;
                if (f3 <= 0.0F)
                {
                  LeaseConfirmPayActivity.a(LeaseConfirmPayActivity.this, (int)LeaseConfirmPayActivity.this.setIntger((Float.parseFloat(VdsAgent.trackEditTextSilent(LeaseConfirmPayActivity.p(LeaseConfirmPayActivity.this)).toString()) + LeaseConfirmPayActivity.D(LeaseConfirmPayActivity.this) / 100 - f1) * 100.0F));
                  LeaseConfirmPayActivity.E(LeaseConfirmPayActivity.this).setVisibility(8);
                  LeaseConfirmPayActivity.i(LeaseConfirmPayActivity.this).setText("使用账户余额支付");
                  LeaseConfirmPayActivity.c(LeaseConfirmPayActivity.this, "balance_order");
                  f2 = 0.0F;
                }
                LeaseConfirmPayActivity.p(LeaseConfirmPayActivity.this).setText(ah.Number(Float.parseFloat(LeaseConfirmPayActivity.F(LeaseConfirmPayActivity.this).format(f2))));
                LeaseConfirmPayActivity.c(LeaseConfirmPayActivity.this, f1);
                LeaseConfirmPayActivity.d(LeaseConfirmPayActivity.this, LeaseConfirmPayActivity.C(LeaseConfirmPayActivity.this));
                paramAnonymousMessage = "-" + LeaseConfirmPayActivity.C(LeaseConfirmPayActivity.this) + "元";
                ah.setTextColor(LeaseConfirmPayActivity.G(LeaseConfirmPayActivity.this), paramAnonymousMessage, 0, paramAnonymousMessage.length() - 1);
                LeaseConfirmPayActivity.I(LeaseConfirmPayActivity.this).dismiss();
                LeaseConfirmPayActivity.J(LeaseConfirmPayActivity.this);
                return;
                f1 = ((Float)paramAnonymousMessage.getObject()).floatValue();
                continue;
              }
              f3 = Float.parseFloat(VdsAgent.trackEditTextSilent(LeaseConfirmPayActivity.p(LeaseConfirmPayActivity.this)).toString()) - LeaseConfirmPayActivity.e(LeaseConfirmPayActivity.this, f1) + LeaseConfirmPayActivity.e(LeaseConfirmPayActivity.this, LeaseConfirmPayActivity.C(LeaseConfirmPayActivity.this));
              if (f3 > 0.0F) {
                break label2828;
              }
              LeaseConfirmPayActivity.a(LeaseConfirmPayActivity.this, (int)LeaseConfirmPayActivity.this.setIntger((Float.parseFloat(VdsAgent.trackEditTextSilent(LeaseConfirmPayActivity.p(LeaseConfirmPayActivity.this)).toString()) + LeaseConfirmPayActivity.D(LeaseConfirmPayActivity.this) / 100 - LeaseConfirmPayActivity.e(LeaseConfirmPayActivity.this, f1)) * 100.0F));
              LeaseConfirmPayActivity.E(LeaseConfirmPayActivity.this).setVisibility(8);
              LeaseConfirmPayActivity.i(LeaseConfirmPayActivity.this).setText("使用账户余额支付");
              LeaseConfirmPayActivity.c(LeaseConfirmPayActivity.this, "balance_order");
            }
          }
        }
      }
      for (;;)
      {
        LeaseConfirmPayActivity.p(LeaseConfirmPayActivity.this).setText(ah.Number(Float.parseFloat(LeaseConfirmPayActivity.F(LeaseConfirmPayActivity.this).format(f2))));
        LeaseConfirmPayActivity.c(LeaseConfirmPayActivity.this, f1);
        LeaseConfirmPayActivity.d(LeaseConfirmPayActivity.this, LeaseConfirmPayActivity.C(LeaseConfirmPayActivity.this));
        paramAnonymousMessage = "-" + LeaseConfirmPayActivity.e(LeaseConfirmPayActivity.this, LeaseConfirmPayActivity.C(LeaseConfirmPayActivity.this)) + "元";
        ah.setTextColor(LeaseConfirmPayActivity.G(LeaseConfirmPayActivity.this), paramAnonymousMessage, 0, paramAnonymousMessage.length() - 1);
        paramAnonymousMessage = "剩余代金券的" + ah.Number(LeaseConfirmPayActivity.C(LeaseConfirmPayActivity.this) - LeaseConfirmPayActivity.e(LeaseConfirmPayActivity.this, LeaseConfirmPayActivity.C(LeaseConfirmPayActivity.this))) + "元将从分期总额中扣除";
        ah.setTextColor(LeaseConfirmPayActivity.H(LeaseConfirmPayActivity.this), paramAnonymousMessage, 6, (LeaseConfirmPayActivity.C(LeaseConfirmPayActivity.this) - LeaseConfirmPayActivity.e(LeaseConfirmPayActivity.this, LeaseConfirmPayActivity.C(LeaseConfirmPayActivity.this)) + "").length());
        LeaseConfirmPayActivity.H(LeaseConfirmPayActivity.this).setVisibility(0);
        break;
        LeaseConfirmPayActivity.c(LeaseConfirmPayActivity.this, f1);
        LeaseConfirmPayActivity.d(LeaseConfirmPayActivity.this, LeaseConfirmPayActivity.C(LeaseConfirmPayActivity.this));
        paramAnonymousMessage = "-" + f1 + "元";
        ah.setTextColor(LeaseConfirmPayActivity.G(LeaseConfirmPayActivity.this), paramAnonymousMessage, 0, paramAnonymousMessage.length() - 1);
        LeaseConfirmPayActivity.p(LeaseConfirmPayActivity.this).setText(ah.Number(Float.parseFloat(LeaseConfirmPayActivity.this.blankKims(f1))));
        break;
        LeaseConfirmPayActivity.c(LeaseConfirmPayActivity.this, f1);
        if (!"1".equals(LeaseConfirmPayActivity.k(LeaseConfirmPayActivity.this).getIsZWhite()))
        {
          paramAnonymousMessage = "-" + LeaseConfirmPayActivity.C(LeaseConfirmPayActivity.this) + "元";
          ah.setTextColor(LeaseConfirmPayActivity.G(LeaseConfirmPayActivity.this), paramAnonymousMessage, 0, paramAnonymousMessage.length() - 1);
        }
        for (;;)
        {
          LeaseConfirmPayActivity.B(LeaseConfirmPayActivity.this).performClick();
          break;
          paramAnonymousMessage = "-" + LeaseConfirmPayActivity.e(LeaseConfirmPayActivity.this, LeaseConfirmPayActivity.C(LeaseConfirmPayActivity.this)) + "元";
          ah.setTextColor(LeaseConfirmPayActivity.G(LeaseConfirmPayActivity.this), paramAnonymousMessage, 0, paramAnonymousMessage.length() - 1);
          paramAnonymousMessage = "剩余代金券的" + ah.Number(LeaseConfirmPayActivity.C(LeaseConfirmPayActivity.this) - LeaseConfirmPayActivity.e(LeaseConfirmPayActivity.this, LeaseConfirmPayActivity.C(LeaseConfirmPayActivity.this))) + "元将从分期总额中扣除";
          ah.setTextColor(LeaseConfirmPayActivity.H(LeaseConfirmPayActivity.this), paramAnonymousMessage, 6, (LeaseConfirmPayActivity.C(LeaseConfirmPayActivity.this) - LeaseConfirmPayActivity.e(LeaseConfirmPayActivity.this, LeaseConfirmPayActivity.C(LeaseConfirmPayActivity.this)) + "").length());
          LeaseConfirmPayActivity.H(LeaseConfirmPayActivity.this).setVisibility(0);
        }
        LeaseConfirmPayActivity.K(LeaseConfirmPayActivity.this).setVisibility(0);
        LeaseConfirmPayActivity.L(LeaseConfirmPayActivity.this).setText(paramAnonymousMessage.getMessage());
        return;
        paramAnonymousMessage = (l)paramAnonymousMessage.obj;
        if (paramAnonymousMessage.getSuccess().booleanValue()) {
          LeaseConfirmPayActivity.this.toHousing();
        }
        for (;;)
        {
          LeaseConfirmPayActivity.this.dismissProgress();
          return;
          LeaseConfirmPayActivity.this.showToast(paramAnonymousMessage.getMessage());
        }
        label2828:
        f2 = f3;
      }
    }
  };
  private BroadcastReceiver bs = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      g.textToast(LeaseConfirmPayActivity.this, "error", 0);
      if (LeaseConfirmPayActivity.k(LeaseConfirmPayActivity.this).getPeriods() != 1) {
        LeaseConfirmPayActivity.o(LeaseConfirmPayActivity.this);
      }
    }
  };
  private BroadcastReceiver bt = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      g.textToast(LeaseConfirmPayActivity.this, "ok", 0);
      if (LeaseConfirmPayActivity.k(LeaseConfirmPayActivity.this).getPeriods() != 1)
      {
        LeaseConfirmPayActivity.o(LeaseConfirmPayActivity.this);
        return;
      }
      LeaseConfirmPayActivity.a(LeaseConfirmPayActivity.this, Float.parseFloat(VdsAgent.trackEditTextSilent(LeaseConfirmPayActivity.p(LeaseConfirmPayActivity.this)).toString()));
      LeaseConfirmPayActivity.q(LeaseConfirmPayActivity.this);
    }
  };
  private Dialog bu;
  private TextView bv;
  private View bw;
  private c bx;
  private TextView c;
  private TextView d;
  private TextView e;
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
  
  private float a(float paramFloat)
  {
    return setFloat(paramFloat / 12.0F);
  }
  
  private void a()
  {
    this.ak = ((TextView)findViewById(2131693321));
    this.A = ((LinearLayout)findViewById(2131693304));
    this.w = ((TextView)findViewById(2131693305));
    this.x = ((TextView)findViewById(2131693306));
    this.y = ((TextView)findViewById(2131693307));
    this.z = ((TextView)findViewById(2131693308));
    this.aW = ((TextView)findViewById(2131693333));
    this.aH = ((RelativeLayout)findViewById(2131693314));
    this.aN = ((RelativeLayout)findViewById(2131693317));
    this.aG = ((RelativeLayout)findViewById(2131689533));
    this.ac = ((TextView)findViewById(2131693303));
    this.at = ((TextView)findViewById(2131693320));
    this.ao = ((LinearLayout)findViewById(2131693313));
    this.an = ((LinearLayout)findViewById(2131693322));
    this.aS = ((ListViewForScrollView)findViewById(2131693337));
    this.al = ((CheckBox)findViewById(2131693315));
    this.am = ((CheckBox)findViewById(2131693318));
    this.ag = ((Button)findViewById(2131693323));
    this.ah = ((Button)findViewById(2131693326));
    this.ai = ((TextView)findViewById(2131693324));
    this.aj = ((TextView)findViewById(2131693327));
    this.bw = LayoutInflater.from(this).inflate(2130905019, null);
    this.v = ((TextView)this.bw.findViewById(2131697230));
    this.r = ((TextView)this.bw.findViewById(2131690106));
    this.bv = ((TextView)this.bw.findViewById(2131697232));
    this.I = ((Button)findViewById(2131693338));
    this.V = ((LinearLayout)findViewById(2131693336));
    this.W = ((Button)findViewById(2131693335));
    this.c = ((TextView)findViewById(2131692992));
    this.d = ((TextView)findViewById(2131693310));
    this.e = ((TextView)findViewById(2131693311));
    this.f = ((TextView)findViewById(2131693312));
    this.g = ((TextView)findViewById(2131693309));
    this.ab = ((ImageView)findViewById(2131690105));
    this.s = ((TextView)findViewById(2131693330));
    this.t = ((TextView)findViewById(2131691284));
    this.J = ((RelativeLayout)findViewById(2131693331));
    this.u = ((TextView)findViewById(2131693334));
    this.C = ((EditText)findViewById(2131693269));
    this.D = ((ListView)findViewById(2131693339));
    this.E = ((Button)findViewById(2131693328));
    this.F = ((Button)findViewById(2131693329));
    this.G = ((Button)findViewById(2131693341));
    this.H = ((Button)findViewById(2131690460));
    this.au = ((TextView)findViewById(2131693316));
    this.E.setVisibility(8);
    this.F.setVisibility(8);
    if (this.aa == null) {
      this.ab.setVisibility(0);
    }
    this.ag.setOnClickListener(this);
    this.ah.setOnClickListener(this);
    this.bv.setOnClickListener(this);
    this.E.setOnClickListener(this);
    this.F.setOnClickListener(this);
    this.J.setOnClickListener(this);
    this.W.setOnClickListener(this);
    this.G.setOnClickListener(this);
    this.H.setOnClickListener(this);
    this.ab.setOnClickListener(this);
    this.al.setOnClickListener(this);
    this.I.setOnClickListener(this);
    this.at.setOnClickListener(this);
    this.ac.setOnClickListener(this);
    this.am.setOnClickListener(this);
    this.al.setOnCheckedChangeListener(this.b);
    this.am.setOnCheckedChangeListener(this.b);
    this.C.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.C.setEnabled(false);
    this.c.setText(this.U.getContractCode());
    this.d.setText("第" + this.U.getPeriods() + "期");
    this.e.setText(this.U.getShouldPrice() + "");
    this.f.setText(this.U.getAlreadyPrice() + "");
    this.g.setText(this.U.getAddress());
    this.au.setText(changeF2Y(this.U.getBalance() + ""));
    this.u.setVisibility(0);
    this.D.setVisibility(8);
    this.G.setVisibility(8);
    this.H.setVisibility(8);
    refreshTip();
    double d1 = ah.Number2(ah.Number2(Double.valueOf(this.U.getShouldPrice()).doubleValue() * 100.0D / 100.0D) - ah.Number2(Double.valueOf(this.U.getAlreadyPrice()).doubleValue() * 100.0D / 100.0D));
    this.Q = d1;
    this.R = d1;
    if ((this.X != null) && (this.Z == null))
    {
      this.C.setText(ah.Number(this.U.getCountPrice()) + "");
      this.bi = (this.U.getCountPrice() + "");
      if (this.U.getPeriods() != 1) {
        break label1779;
      }
      if (!ae.isNull(this.ae)) {
        break label1709;
      }
      if (this.U.getIsBlank() != 1) {
        break label1618;
      }
      this.aH.setVisibility(8);
      this.aN.setVisibility(0);
      label1235:
      if ((this.U.getPeriods() != 1) || (this.U.getAlreadyCount().intValue() != 0)) {
        break label1791;
      }
      if (ae.isNull(this.ae)) {
        this.ac.setVisibility(0);
      }
      if (ae.notNull(getIntent().getStringExtra("group"))) {
        this.ac.setVisibility(8);
      }
      if (this.ae != null) {
        this.ah.setText("分次支付");
      }
      if ("2".equals(this.U.getContractStrategy())) {
        this.ac.setVisibility(8);
      }
      label1344:
      if (this.U.getIsBlank() != 1) {
        break label1813;
      }
      this.W.setVisibility(0);
      this.V.setVisibility(8);
      this.an.setVisibility(8);
      label1381:
      if (this.U.getIsCard() != 1) {
        break label1833;
      }
      this.J.setVisibility(0);
      label1400:
      String str = getIntent().getStringExtra("mCityCode");
      if (ae.notNull(str)) {
        this.aR = str;
      }
      if (this.U == null) {
        break label1857;
      }
      if (this.U.getRemainderPayTime() <= 0L) {
        break label1845;
      }
      this.A.setVisibility(0);
      this.B = new a(this.U.getRemainderPayTime() * 1000L, 1000L);
      this.B.start();
      d(m.getTimeString(this.U.getRemainderPayTime()));
    }
    for (;;)
    {
      n();
      h();
      g();
      f();
      e();
      payEnd();
      this.A.setFocusable(true);
      this.A.setFocusableInTouchMode(true);
      this.A.requestFocus();
      return;
      if (this.Z == null) {
        break;
      }
      this.C.setText(ah.Number(Float.parseFloat(this.Q + "")));
      this.bi = (this.Q + "");
      break;
      label1618:
      if ("1".equals(this.U.getIsZWhite()))
      {
        this.aN.setVisibility(8);
        this.aH.setVisibility(0);
        break label1235;
      }
      if ("5".equals(this.U.getHouseType()))
      {
        this.aH.setVisibility(0);
        this.aN.setVisibility(8);
        break label1235;
      }
      this.aH.setVisibility(0);
      this.aN.setVisibility(0);
      break label1235;
      label1709:
      if (this.U.getIsBlank() != 1)
      {
        this.aH.setVisibility(0);
        this.aN.setVisibility(8);
        this.ac.setVisibility(8);
        break label1235;
      }
      this.aH.setVisibility(8);
      this.aN.setVisibility(8);
      this.ac.setVisibility(8);
      break label1235;
      label1779:
      this.ac.setVisibility(8);
      break label1235;
      label1791:
      this.ac.setVisibility(8);
      this.ah.setText("分次支付");
      break label1344;
      label1813:
      this.V.setVisibility(0);
      this.W.setVisibility(8);
      break label1381;
      label1833:
      this.J.setVisibility(8);
      break label1400;
      label1845:
      this.A.setVisibility(8);
      continue;
      label1857:
      this.A.setVisibility(8);
    }
  }
  
  private void a(PayOrder paramPayOrder)
  {
    this.Y.doStartWXPay(this, paramPayOrder.getTrans_id(), paramPayOrder.getMerorder_id(), paramPayOrder.getTimestamp(), paramPayOrder.get_package(), paramPayOrder.getSign(), paramPayOrder.getPartnerid());
  }
  
  private void a(List<String> paramList)
  {
    this.aT = new ArrayList();
    if (paramList == null) {
      return;
    }
    int i = 0;
    label18:
    if (i < paramList.size())
    {
      if (!"yl_make_order".equals(paramList.get(i))) {
        break label84;
      }
      this.aT.add(paramList.get(i));
    }
    for (;;)
    {
      if ("balance_order".equals(paramList.get(i))) {}
      i += 1;
      break label18;
      break;
      label84:
      if ("wxpay_make_order_v2".equals(paramList.get(i))) {
        this.aT.add(paramList.get(i));
      } else if ("jd_m_pay".equals(paramList.get(i))) {
        this.aT.add(paramList.get(i));
      } else if ("yl_cashCard_make_order".equals(paramList.get(i))) {
        this.aT.add(paramList.get(i));
      } else if ("hf_make_order".equals(paramList.get(i))) {
        this.aT.add(paramList.get(i));
      } else if ("yl_dk".equals(paramList.get(i))) {
        this.aT.add(paramList.get(i));
      }
    }
  }
  
  private void a(final boolean paramBoolean)
  {
    if (paramBoolean) {
      showProgress("");
    }
    com.ziroom.ziroomcustomer.pay.common.b.a.getUnionSendSMSResult(a, new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk) {}
      
      public void onSuccess(k paramAnonymousk)
      {
        if (paramBoolean) {
          LeaseConfirmPayActivity.this.dismissProgress();
        }
        paramAnonymousk = (UnionDKBaseJson)paramAnonymousk.getObject();
        if (paramAnonymousk == null) {
          return;
        }
        if (!paramAnonymousk.isSuccess())
        {
          g.textToast(LeaseConfirmPayActivity.a, paramAnonymousk.getError_message());
          return;
        }
        LeaseConfirmPayActivity.c(LeaseConfirmPayActivity.this).show();
        LeaseConfirmPayActivity.c(LeaseConfirmPayActivity.this).setTipMessage("短信验证码已发送到" + LeaseConfirmPayActivity.d(LeaseConfirmPayActivity.this).mobile + "手机上，请注意查收");
        LeaseConfirmPayActivity.c(LeaseConfirmPayActivity.this).startGetMessage();
      }
    });
  }
  
  private void b()
  {
    a(true);
    this.bq = new com.ziroom.ziroomcustomer.pay.huifu.views.a.a(this.aq, "确定", "取消", "", "付款确认");
    this.bq.setUpdateOnClickListener(new a.b()
    {
      public void BtnCancleOnClickListener(View paramAnonymousView)
      {
        LeaseConfirmPayActivity.c(LeaseConfirmPayActivity.this).dismiss();
      }
      
      public void BtnGetMessageOnClickListener(View paramAnonymousView)
      {
        LeaseConfirmPayActivity.a(LeaseConfirmPayActivity.this, false);
      }
      
      public void BtnYesOnClickListener(View paramAnonymousView, String paramAnonymousString)
      {
        if ((paramAnonymousString == null) || (paramAnonymousString.equals("")))
        {
          g.textToast(LeaseConfirmPayActivity.b(LeaseConfirmPayActivity.this), "请输入验证码");
          return;
        }
        if (paramAnonymousString.length() != 6)
        {
          g.textToast(LeaseConfirmPayActivity.b(LeaseConfirmPayActivity.this), "验证码不完整");
          return;
        }
        LeaseConfirmPayActivity.b(LeaseConfirmPayActivity.this, paramAnonymousString);
        LeaseConfirmPayActivity.c(LeaseConfirmPayActivity.this).dismiss();
      }
      
      public void dismiss() {}
    });
  }
  
  private void b(PayOrder paramPayOrder)
  {
    Intent localIntent = new Intent(a, SignedJDPayWebActivity.class);
    localIntent.putExtra("url", paramPayOrder.getUrl());
    if (this.N.equals("jd_m_pay")) {
      localIntent.putExtra("title", "京东支付");
    }
    for (;;)
    {
      startActivityForResult(localIntent, 98);
      return;
      localIntent.putExtra("title", "自如白条");
    }
  }
  
  public static String changeF2Y(String paramString)
  {
    if (!paramString.matches("\\-?[0-9]+")) {
      try
      {
        throw new Exception("金额格式有误");
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return BigDecimal.valueOf(Long.valueOf(paramString).longValue()).divide(new BigDecimal(100)).toString();
  }
  
  private void d(String paramString)
  {
    if (ae.isNull(paramString)) {}
    do
    {
      do
      {
        return;
      } while (paramString.length() < 5);
      if (this.w != null) {
        this.w.setText(paramString.substring(0, 1));
      }
      if (this.x != null) {
        this.x.setText(paramString.substring(1, 2));
      }
      if (this.y != null) {
        this.y.setText(paramString.substring(3, 4));
      }
    } while (this.z == null);
    this.z.setText(paramString.substring(4, 5));
  }
  
  private void e()
  {
    this.aY = new HashMap();
    this.aY.put("yl_make_order", "支付服务有银联提供（不支持交通、招商）");
    this.aY.put("wxpay_make_order_v2", "推荐已安装微信客户端的用户使用");
    this.aY.put("jd_m_pay", "支付服务由京东提供");
    this.aY.put("yl_cashCard_make_order", "支付服务有银联提供");
    if (this.aZ.booleanValue())
    {
      this.aY.put("hf_make_order", this.bc.bankName + "(" + this.bc.bankNo + ")");
      if (!this.ba.booleanValue()) {
        break label284;
      }
      this.aY.put("yl_dk", this.bd.bankName + "(" + this.bd.bankCardNo + ")");
    }
    for (;;)
    {
      if (this.bx != null)
      {
        this.bx.setmListMsg(this.aY);
        if (this.aZ.booleanValue()) {
          this.bx.setmImgHuifuIcon(this.bc.bankIconApp);
        }
        if (this.ba.booleanValue()) {
          this.bx.setmImgYldkIcon(this.bd.appIcon);
        }
      }
      if (this.I != null) {
        break label301;
      }
      return;
      this.aY.put("hf_make_order", "一次性完成绑卡，更便捷支付体验");
      break;
      label284:
      this.aY.put("yl_dk", "支付服务由银联提供，仅支持借记卡");
    }
    label301:
    if ((this.N.equals("hf_make_order")) && (!this.aZ.booleanValue()))
    {
      this.I.setText("去绑卡");
      return;
    }
    this.I.setText("去支付");
  }
  
  private void e(String paramString)
  {
    showProgress("");
    com.ziroom.ziroomcustomer.pay.common.b.a.getUnionCheckSMSResult(a, paramString, new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk) {}
      
      public void onSuccess(k paramAnonymousk)
      {
        LeaseConfirmPayActivity.this.dismissProgress();
        paramAnonymousk = (UnionDKCheckMessage)paramAnonymousk.getObject();
        if (paramAnonymousk == null) {
          return;
        }
        if ((paramAnonymousk.isSuccess()) && (paramAnonymousk.isData()))
        {
          LeaseConfirmPayActivity.this.onConfirm();
          return;
        }
        if ((paramAnonymousk.isSuccess()) && (!paramAnonymousk.isData()))
        {
          g.textToast(LeaseConfirmPayActivity.a, "短信验证码错误!");
          return;
        }
        g.textToast(LeaseConfirmPayActivity.a, paramAnonymousk.getError_message());
      }
    });
  }
  
  private void f()
  {
    if ((this.aT == null) || (!this.aT.contains("yl_dk"))) {
      return;
    }
    String str2 = this.X;
    String str1 = str2;
    if (str2 == null)
    {
      str1 = str2;
      if (this.U != null) {
        str1 = this.U.getContractCode();
      }
    }
    com.ziroom.ziroomcustomer.pay.common.b.a.getUnionPayIsBandCardResult(this, str1, new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk) {}
      
      public void onSuccess(k paramAnonymousk)
      {
        boolean bool2 = true;
        com.freelxl.baselibrary.f.d.e("yangxj--------银联代扣", com.alibaba.fastjson.a.toJSONString(paramAnonymousk));
        if (!paramAnonymousk.getSuccess().booleanValue()) {}
        do
        {
          do
          {
            return;
            paramAnonymousk = (UnionDKPayIsBandCard)paramAnonymousk.getObject();
          } while (paramAnonymousk == null);
          if (!paramAnonymousk.isSuccess())
          {
            g.textToast(LeaseConfirmPayActivity.this, paramAnonymousk.getError_message());
            return;
          }
        } while (paramAnonymousk.data == null);
        LeaseConfirmPayActivity localLeaseConfirmPayActivity = LeaseConfirmPayActivity.this;
        if (paramAnonymousk.data.isBindUid != 0)
        {
          bool1 = true;
          LeaseConfirmPayActivity.a(localLeaseConfirmPayActivity, Boolean.valueOf(bool1));
          localLeaseConfirmPayActivity = LeaseConfirmPayActivity.this;
          if (paramAnonymousk.data.isBindContract == 0) {
            break label166;
          }
        }
        label166:
        for (boolean bool1 = bool2;; bool1 = false)
        {
          LeaseConfirmPayActivity.b(localLeaseConfirmPayActivity, Boolean.valueOf(bool1));
          if (LeaseConfirmPayActivity.e(LeaseConfirmPayActivity.this).booleanValue()) {
            LeaseConfirmPayActivity.a(LeaseConfirmPayActivity.this, (UnionDKPayIsBandCard.DataBean.CardInfoListBean)paramAnonymousk.data.cardInfoList.get(0));
          }
          LeaseConfirmPayActivity.f(LeaseConfirmPayActivity.this);
          return;
          bool1 = false;
          break;
        }
      }
    });
  }
  
  private void g()
  {
    if ((this.aT == null) || (!this.aT.contains("hf_make_order"))) {
      return;
    }
    Object localObject = "yangxj--contract_code" + this.aR;
    if (this.X == null)
    {
      str1 = "null";
      com.freelxl.baselibrary.f.d.e((String)localObject, str1);
      if ((this.U == null) || (this.U.getPeriods() != 1)) {
        break label144;
      }
    }
    label144:
    for (String str1 = "firstPay";; str1 = "unFirstPay")
    {
      String str2 = this.X;
      localObject = str2;
      if (str2 == null)
      {
        localObject = str2;
        if (this.U != null) {
          localObject = this.U.getContractCode();
        }
      }
      com.ziroom.ziroomcustomer.pay.common.b.a.getHuifuPayTypeList(this, this.aR, str1, (String)localObject, "", "", new i.a()
      {
        public void onParse(String paramAnonymousString, k paramAnonymousk) {}
        
        public void onSuccess(k paramAnonymousk)
        {
          com.freelxl.baselibrary.f.d.e("yangxj--------", com.alibaba.fastjson.a.toJSONString(paramAnonymousk));
          if (!paramAnonymousk.getSuccess().booleanValue()) {}
          do
          {
            do
            {
              return;
              paramAnonymousk = (HuiFuIsBandAndBandList)paramAnonymousk.getObject();
            } while (paramAnonymousk == null);
            if (!paramAnonymousk.isSuccess())
            {
              g.textToast(LeaseConfirmPayActivity.this, paramAnonymousk.getError_message());
              return;
            }
          } while ((paramAnonymousk.data == null) || (paramAnonymousk.data.hfInfo == null));
          LeaseConfirmPayActivity localLeaseConfirmPayActivity = LeaseConfirmPayActivity.this;
          if (paramAnonymousk.data.hfInfo.isBind != 0) {}
          for (boolean bool = true;; bool = false)
          {
            LeaseConfirmPayActivity.c(localLeaseConfirmPayActivity, Boolean.valueOf(bool));
            if (LeaseConfirmPayActivity.g(LeaseConfirmPayActivity.this).booleanValue()) {
              LeaseConfirmPayActivity.a(LeaseConfirmPayActivity.this, (HuiFuIsBandAndBandList.DataBean.HfInfoBean.BindBanksBean)paramAnonymousk.data.hfInfo.bindBanks.get(0));
            }
            LeaseConfirmPayActivity.f(LeaseConfirmPayActivity.this);
            return;
          }
        }
      });
      return;
      str1 = this.X;
      break;
    }
  }
  
  private void h()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.aT == null) {}
    for (int i = 0;; i = this.aT.size())
    {
      int j = 0;
      while (j < i)
      {
        localArrayList.add(Integer.valueOf(0));
        j += 1;
      }
    }
    this.bx = new c(this.aT, this.aq, localArrayList, this.U.getGiftList());
    e();
    this.aS.setAdapter(this.bx);
    this.bx.setmPayType(new c.a()
    {
      public void setPayType(String paramAnonymousString)
      {
        LeaseConfirmPayActivity.c(LeaseConfirmPayActivity.this, paramAnonymousString);
        if ((LeaseConfirmPayActivity.h(LeaseConfirmPayActivity.this).equals("hf_make_order")) && (!LeaseConfirmPayActivity.g(LeaseConfirmPayActivity.this).booleanValue()))
        {
          LeaseConfirmPayActivity.i(LeaseConfirmPayActivity.this).setText("去绑卡");
          return;
        }
        LeaseConfirmPayActivity.i(LeaseConfirmPayActivity.this).setText("去支付");
      }
    });
  }
  
  private double i()
  {
    return ah.Number2(this.Q);
  }
  
  private void j()
  {
    int n = 0;
    int m = 0;
    showProgress("");
    int j;
    if (this.U.getPeriods() == 1)
    {
      j = 1;
      if (j != 1) {
        break label66;
      }
    }
    label66:
    for (String str = this.X;; str = this.U.getContractCode())
    {
      if (!ae.isNull(VdsAgent.trackEditTextSilent(this.C).toString())) {
        break label78;
      }
      showToast("金额为空");
      return;
      j = 2;
      break;
    }
    label78:
    int i1 = (int)(ah.Number2(Float.parseFloat(VdsAgent.trackEditTextSilent(this.C).toString())) * 100.0D);
    Object localObject = new ArrayList();
    int i;
    int k;
    if ((this.L != null) && (this.L.size() > 0))
    {
      Iterator localIterator = this.L.iterator();
      i = 0;
      k = i;
      if (!localIterator.hasNext()) {
        break label208;
      }
      RentCardDetail localRentCardDetail = (RentCardDetail)localIterator.next();
      if (localRentCardDetail.getIsCheck() != 1) {
        break label356;
      }
      ((List)localObject).add(localRentCardDetail.getCardCode());
      float f1 = i;
      i = (int)(localRentCardDetail.getCardValue() * 100.0F + f1);
    }
    label208:
    label334:
    label356:
    for (;;)
    {
      break;
      k = 0;
      i = n;
      if (this.U.getPeriods() == 1)
      {
        n = (int)(this.aK * 100.0F);
        i = (int)(this.aL * 100.0F);
        localObject = this.aA;
        this.aJ = this.aI;
        if ((ae.notNull(this.ae)) && (this.am.isChecked())) {
          break label334;
        }
        i = 0;
        n = 0;
      }
      for (;;)
      {
        i = m + (i + i1 + n);
        if (j != 1) {
          i = i1 + k;
        }
        com.ziroom.ziroomcustomer.pay.common.b.a.getIsCanPayResult(this, j, str, this.U.getPeriods(), i, i1, this.N, new i.a()
        {
          public void onParse(String paramAnonymousString, k paramAnonymousk) {}
          
          public void onSuccess(k paramAnonymousk)
          {
            LeaseConfirmPayActivity.this.dismissProgress();
            if (paramAnonymousk.getSuccess().booleanValue())
            {
              LeaseConfirmPayActivity.m(LeaseConfirmPayActivity.this);
              return;
            }
            g.textToast(LeaseConfirmPayActivity.this, paramAnonymousk.getMessage());
          }
        });
        return;
        m = (int)setIntger(a(this.aK) * 100.0F);
      }
    }
  }
  
  private void k()
  {
    String str1;
    String str2;
    if (this.N.equals("hf_make_order")) {
      if (this.aZ.booleanValue())
      {
        if ((this.U == null) || (this.U.getPeriods() != 1)) {
          break label92;
        }
        str1 = "firstPay";
        if (this.X == null) {
          break label99;
        }
        str2 = this.X;
        label57:
        new com.ziroom.ziroomcustomer.pay.huifu.a.a(this, this.br, null, 201, str2, "", "", str1, "确定", "取消", "付款确认").showMessageDialog();
      }
    }
    label92:
    label99:
    do
    {
      return;
      str1 = "unFirstPay";
      break;
      str2 = this.U.getContractCode();
      break label57;
      if (!this.N.equals("yl_dk")) {
        break label138;
      }
    } while (!this.bb.booleanValue());
    b();
    return;
    label138:
    onConfirm();
  }
  
  private void l()
  {
    double d2 = this.aK;
    double d3 = setFloat(this.aJ / 100.0F);
    double d1;
    Object localObject;
    if ("1".equals(this.U.getIsZWhite()))
    {
      d1 = Float.parseFloat(VdsAgent.trackEditTextSilent(this.C).toString()) + d3 + a((float)d2);
      double d4 = setIntger((this.U.getShouldPrice() - this.U.getAlreadyPrice()) * 100.0F) / 100.0D;
      d1 = setFloat((float)d1);
      d4 = setFloat((float)d4);
      if ((!this.bj.format(d4).equals(this.bj.format(d1))) && (this.U.getIsBlank() != 1)) {
        break label586;
      }
      d1 = this.S + d3 + d2;
      if (!"2".equals(this.U.getContractStrategy())) {
        break label320;
      }
      localObject = new Intent(a, EnterprisePaySuccessActivity.class);
      ((Intent)localObject).putExtra("sub_amount", this.bj.format(d1) + "");
      ((Intent)localObject).putExtra("contract_code", this.X);
      ((Intent)localObject).putExtra("is_all", "1");
      startActivity((Intent)localObject);
    }
    for (;;)
    {
      if (this.U.getAlreadyCount().intValue() == 0)
      {
        localObject = GrowingIO.getInstance();
        ((GrowingIO)localObject).setPageGroup(this, "PaySuccessActivity");
        ((GrowingIO)localObject).setPS4(this, "长租首期支付成功");
      }
      finish();
      return;
      d1 = Float.parseFloat(VdsAgent.trackEditTextSilent(this.C).toString()) + d3 + d2;
      break;
      label320:
      localObject = new Intent(a, PaySuccessActivity.class);
      ((Intent)localObject).putExtra("contract_code", this.X);
      ((Intent)localObject).putExtra("className", "LeaseConfirmPayActivity");
      if (this.U.getIsBlank() == 1) {
        ((Intent)localObject).putExtra("sub_amount", VdsAgent.trackEditTextSilent(this.C).toString());
      }
      String str;
      for (;;)
      {
        ((Intent)localObject).putExtra("is_blank", this.U.getIsBlank() + "");
        ((Intent)localObject).putExtra("pay_status", "yzf");
        str = getIntent().getStringExtra("wystate");
        ((Intent)localObject).putExtra("houseType", this.aB.getHouse_type());
        if (str != null) {
          ((Intent)localObject).putExtra("wystate", str);
        }
        if (this.ae != null)
        {
          ((Intent)localObject).putExtra("new_contract_code", this.U.getContractCode());
          ((Intent)localObject).putExtra("old_contract_code", this.ae);
        }
        if (this.ad != null) {
          ((Intent)localObject).putExtra("bizCode", this.ad.getBizCode());
        }
        startActivity((Intent)localObject);
        break;
        ((Intent)localObject).putExtra("sub_amount", this.bj.format(d1) + "");
      }
      label586:
      d1 = this.S + d3 + d2;
      if ("2".equals(this.U.getContractStrategy()))
      {
        localObject = new Intent(a, EnterprisePaySuccessActivity.class);
        ((Intent)localObject).putExtra("sub_amount", this.bj.format(d1));
        ((Intent)localObject).putExtra("contract_code", this.X);
        ((Intent)localObject).putExtra("is_all", "0");
        startActivity((Intent)localObject);
      }
      else
      {
        localObject = new Intent(a, PayPartActivity.class);
        ((Intent)localObject).putExtra("contract_code", this.X);
        ((Intent)localObject).putExtra("mCityCode", this.aR);
        ((Intent)localObject).putExtra("sub_amount", this.bj.format(d1));
        if (this.ae != null) {
          ((Intent)localObject).putExtra("old_contract_code", this.ae);
        }
        str = getIntent().getStringExtra("wystate");
        if (str != null) {
          ((Intent)localObject).putExtra("wystate", str);
        }
        if (this.ad != null) {
          ((Intent)localObject).putExtra("bizCode", this.ad.getBizCode());
        }
        startActivity((Intent)localObject);
      }
    }
  }
  
  private void m()
  {
    Intent localIntent = getIntent();
    if (this.ad != null) {
      localIntent.putExtra("bizCode", this.ad.getBizCode());
    }
    setResult(66, localIntent);
    finish();
  }
  
  private void n()
  {
    this.ap = View.inflate(a, 2130905018, null);
    this.ar = ((LinearLayout)this.ap.findViewById(2131697226));
    this.as = ((TextView)this.ap.findViewById(2131697227));
    this.av = ((TextView)this.ap.findViewById(2131697228));
    this.aw = ((TextView)this.ap.findViewById(2131697229));
    this.ay = ((EditText)this.ap.findViewById(2131697225));
    this.az = new Dialog(this.aq, 2131427781);
    this.az.setContentView(this.ap);
    this.av.setOnClickListener(this);
    this.aw.setOnClickListener(this);
  }
  
  public String blankKims(float paramFloat)
  {
    paramFloat = this.U.getShouldPrice() - paramFloat - this.U.getDeposit();
    paramFloat -= setFloat(paramFloat / 12.0F) * 11.0F;
    if (this.U.getAlreadyPrice() == 0.0F) {
      return ah.Number2(setFloat(paramFloat) + this.U.getDeposit()) + "";
    }
    return ah.Number2(setFloat(paramFloat)) + "";
  }
  
  public double getCardsAmount()
  {
    double d2 = 0.0D;
    double d1 = d2;
    if (this.O != null)
    {
      d1 = d2;
      if (this.O.size() > 0)
      {
        Iterator localIterator = this.O.iterator();
        for (d1 = 0.0D; localIterator.hasNext(); d1 = ah.Number2(((RentCardDetail)localIterator.next()).getCardValue()) + d1) {}
      }
    }
    return ah.Number2(d1);
  }
  
  public double getInputAmount()
  {
    String str = VdsAgent.trackEditTextSilent(this.C).toString();
    if (ae.notNull(str)) {}
    for (double d1 = ah.Number2(Double.parseDouble(str));; d1 = 0.0D) {
      return ah.Number2(d1);
    }
  }
  
  public void isUpdate()
  {
    if (new Float(VdsAgent.trackEditTextSilent(this.C).toString()).floatValue() <= 500.0F)
    {
      this.E.setBackgroundResource(2130838347);
      this.E.setEnabled(false);
    }
    while (new Float(VdsAgent.trackEditTextSilent(this.C).toString()).floatValue() >= this.U.getCountPrice())
    {
      this.F.setBackgroundResource(2130838872);
      this.F.setEnabled(false);
      return;
      this.E.setBackgroundResource(2130838346);
      this.E.setEnabled(true);
    }
    this.F.setBackgroundResource(2130838871);
    this.F.setEnabled(true);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramInt2 == -1)) {
      this.bh = true;
    }
    do
    {
      return;
      if (paramInt2 != 99) {
        break;
      }
      this.L = ((ArrayList)paramIntent.getSerializableExtra("mCardDetail"));
    } while (this.L == null);
    paramIntent = this.L.iterator();
    float f1 = 0.0F;
    label54:
    if (paramIntent.hasNext())
    {
      RentCardDetail localRentCardDetail = (RentCardDetail)paramIntent.next();
      if (localRentCardDetail.getIsCheck() != 1) {
        break label422;
      }
      f1 = localRentCardDetail.getCardValue() + f1;
    }
    label422:
    for (;;)
    {
      break label54;
      if (f1 > 0.0F)
      {
        this.aW.setText("减" + f1 + "元");
        this.aW.setTextColor(Color.parseColor("#dd660d"));
        this.C.setText(ah.Number(setFloat(this.U.getCountPrice()) - f1) + "");
        return;
      }
      this.C.setText(ah.Number(Float.parseFloat(setFloat(this.U.getCountPrice()) + "")));
      if (this.L.size() > 0)
      {
        this.aW.setText(this.L.size() + "张可用");
        this.aW.setTextColor(Color.parseColor("#dd660d"));
        return;
      }
      this.aV = "您还没有可用的租金卡哦";
      this.aW.setText("0张可用");
      this.aW.setTextColor(Color.parseColor("#ff7d7d7d"));
      return;
      if (paramInt2 == 98)
      {
        if (this.U == null) {
          break;
        }
        if (this.U.getPeriods() == 1)
        {
          if ((!this.N.equals("jd_m_pay")) && (this.U.getIsBlank() != 1)) {
            break;
          }
          showProgress("");
          new Handler().postDelayed(new Runnable()
          {
            public void run()
            {
              if (LeaseConfirmPayActivity.n(LeaseConfirmPayActivity.this) == null) {
                SystemClock.sleep(2000L);
              }
              String str1 = "";
              if (LeaseConfirmPayActivity.k(LeaseConfirmPayActivity.this).getIsBlank() == 1) {
                str1 = "jd_loan";
              }
              Handler localHandler = LeaseConfirmPayActivity.j(LeaseConfirmPayActivity.this);
              String str2;
              if (LeaseConfirmPayActivity.n(LeaseConfirmPayActivity.this) == null)
              {
                str2 = "";
                if (!ae.isNull(LeaseConfirmPayActivity.n(LeaseConfirmPayActivity.this).getCompanyCode())) {
                  break label100;
                }
              }
              label100:
              for (String str3 = "";; str3 = LeaseConfirmPayActivity.n(LeaseConfirmPayActivity.this).getCompanyCode())
              {
                com.ziroom.ziroomcustomer.e.d.getWYPayState(localHandler, str2, str1, str3);
                return;
                str2 = LeaseConfirmPayActivity.n(LeaseConfirmPayActivity.this).getStand_num();
                break;
              }
            }
          }, 5000L);
          return;
        }
        m();
        return;
      }
      com.ziroom.commonlibrary.e.c.doUnionPayResult(this, paramInt1, paramInt2, paramIntent, new c.b()
      {
        public void doBack(String paramAnonymousString)
        {
          if ("success".equals(paramAnonymousString)) {
            if (LeaseConfirmPayActivity.k(LeaseConfirmPayActivity.this).getPeriods() != 1) {
              LeaseConfirmPayActivity.o(LeaseConfirmPayActivity.this);
            }
          }
          while (LeaseConfirmPayActivity.k(LeaseConfirmPayActivity.this).getPeriods() == 1)
          {
            return;
            LeaseConfirmPayActivity.a(LeaseConfirmPayActivity.this, Float.parseFloat(VdsAgent.trackEditTextSilent(LeaseConfirmPayActivity.p(LeaseConfirmPayActivity.this)).toString()));
            LeaseConfirmPayActivity.q(LeaseConfirmPayActivity.this);
            return;
          }
          LeaseConfirmPayActivity.o(LeaseConfirmPayActivity.this);
        }
      });
      return;
    }
  }
  
  public void onBackPressed()
  {
    if (this.U != null)
    {
      if (this.aa != null)
      {
        showDialog(null, "倒计时结束之前，您可以在“我的合同”里找到待支付合同进行支付。", "我知道了", "取消");
        return;
      }
      finish();
      return;
    }
    super.onBackPressed();
  }
  
  public void onCancel()
  {
    this.u.setVisibility(0);
    this.D.setVisibility(8);
    this.G.setVisibility(8);
    this.H.setVisibility(8);
    this.O.clear();
    if (this.K != null) {
      this.K.notifyDataSetChanged();
    }
    refreshTip();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    float f1 = 0.0F;
    int k = 1;
    VdsAgent.onClick(this, paramView);
    int i;
    int j;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131693328: 
      onDecrease();
      return;
    case 2131693323: 
      this.ai.setBackgroundColor(Color.parseColor("#f56400"));
      this.aj.setBackgroundColor(Color.parseColor("#ffffff"));
      this.ag.setTextColor(Color.parseColor("#f56400"));
      this.ah.setTextColor(Color.parseColor("#9b9b9b"));
      if ((this.U.getPeriods() == 1) && (this.U.getAlreadyCount().intValue() == 0)) {}
      for (this.T = 3;; this.T = 1)
      {
        setImage(this.T);
        return;
      }
    case 2131693326: 
      if ("1".equals(this.U.getIsZWhite()))
      {
        showToast("自如分期暂不支持分次支付");
        return;
      }
      this.ai.setBackgroundColor(Color.parseColor("#ffffff"));
      this.aj.setBackgroundColor(Color.parseColor("#f56400"));
      this.ag.setTextColor(Color.parseColor("#9b9b9b"));
      this.ah.setTextColor(Color.parseColor("#f56400"));
      if ((this.U.getPeriods() == 1) && (this.U.getAlreadyCount().intValue() == 0)) {}
      for (this.T = 2;; this.T = 0)
      {
        setImage(this.T);
        return;
      }
    case 2131693329: 
      onIncrease();
      return;
    case 2131693331: 
      paramView = new Intent(this, RentCardActivity.class);
      paramView.putExtra("mCardDetail", this.L);
      paramView.putExtra("errorMessage", this.aV);
      paramView.putExtra("money", VdsAgent.trackEditTextSilent(this.C).toString());
      u.e("money  ====", "   ======" + VdsAgent.trackEditTextSilent(this.C).toString());
      startActivityForResult(paramView, 99);
      return;
    case 2131693341: 
      onUse();
      return;
    case 2131690460: 
      onCancel();
      return;
    case 2131693335: 
      this.N = "jd_loan";
      j();
      return;
    case 2131697195: 
      if (this.aO) {
        if ((this.N.equals("yl_make_order")) || (this.N.equals("yl_cashCard_make_order"))) {
          onUPPay(this.ad);
        }
      }
      for (;;)
      {
        this.bu.dismiss();
        return;
        if (this.N.equals("wxpay_make_order_v2"))
        {
          a(this.ad);
        }
        else if ((this.N.equals("jd_loan")) || (this.N.equals("jd_m_pay")))
        {
          b(this.ad);
          continue;
          if (!"502122".equals(this.aM)) {
            if ("502123".equals(this.aM)) {
              toHousing();
            } else if ("502124".equals(this.aM)) {
              toHousing();
            }
          }
        }
      }
    case 2131690105: 
      if (this.aa == null)
      {
        if (this.bh)
        {
          m();
          return;
        }
        finish();
        return;
      }
      showDialog(null, "倒计时结束之前，您可以在“我的合同”里找到待支付合同进行支付。", "我知道了", "取消");
      return;
    case 2131693338: 
      Object localObject;
      if ((this.N.equals("hf_make_order")) && (!this.aZ.booleanValue()))
      {
        Intent localIntent = new Intent(this, AddBandCardActivity.class);
        localObject = this.X;
        paramView = (View)localObject;
        if (localObject == null) {
          paramView = this.U.getContractCode();
        }
        if ((this.U != null) && (this.U.getPeriods() == 1)) {}
        for (localObject = "firstPay";; localObject = "unFirstPay")
        {
          localIntent.putExtra("contractCode", paramView);
          localIntent.putExtra("reserveCode", "");
          localIntent.putExtra("backRentOrderCode", "");
          localIntent.putExtra("bizType", (String)localObject);
          startActivity(localIntent);
          return;
        }
      }
      if ((this.N.equals("yl_dk")) && (!this.bb.booleanValue()))
      {
        localObject = new Intent(this, UnionDKPayNoticeActivity.class);
        if (this.X == null) {}
        for (paramView = this.U.getContractCode();; paramView = this.X)
        {
          ((Intent)localObject).putExtra("contractCode", paramView);
          ((Intent)localObject).putExtra("isBandUnionCard", this.ba);
          ((Intent)localObject).putExtra("isBandUnionDKContract", this.bb);
          startActivityForResult((Intent)localObject, 1);
          return;
        }
      }
      if (this.L != null)
      {
        paramView = this.L.iterator();
        i = 0;
        j = i;
        if (!paramView.hasNext()) {
          break label1034;
        }
        if (((RentCardDetail)paramView.next()).getIsCheck() != 1) {
          break label2580;
        }
        i = 1;
      }
      break;
    }
    label1034:
    label2119:
    label2206:
    label2570:
    label2575:
    label2580:
    for (;;)
    {
      break;
      j = 0;
      if ((!this.am.isChecked()) && (this.aD > 0.0F))
      {
        i = k;
        if (this.aN.getVisibility() != 8) {}
      }
      else
      {
        i = 0;
      }
      if (ae.notNull(this.N))
      {
        if (j != 0)
        {
          showDialog("提示", "一旦您确认支付，租金卡将立即被扣除抵扣房租不返还。", "确认支付", "我在想想");
          return;
        }
        if (i != 0)
        {
          showDialog("提示", "您有已输入的代金券未勾选，若要使用请进行勾选", "去勾选", "不使用");
          return;
        }
        j();
        return;
      }
      showToast("请选择支付方式");
      return;
      if ("房源锁定失败".equals(this.v.getText().toString()))
      {
        paramView = new Intent(a, MainActivity.class);
        paramView.putExtra("MyZiroom", "MyZiroom");
        startActivity(paramView);
        finish();
        return;
      }
      this.af.dismiss();
      return;
      if (ae.notNull(VdsAgent.trackEditTextSilent(this.ay).toString()))
      {
        if (this.aB != null)
        {
          com.ziroom.ziroomcustomer.e.d.getPayKims(this.br, VdsAgent.trackEditTextSilent(this.ay).toString(), this.aB.getHouse_code(), this.aB.getHouse_id(), this.aB.getHouse_type(), this.aC, this.ae, this.X);
          return;
        }
        showToast("房屋信息为空");
        return;
      }
      g.textToast(this.aq, "输入的代金券为空", 0);
      return;
      paramView = this.az;
      if (!(paramView instanceof Dialog))
      {
        paramView.show();
        return;
      }
      VdsAgent.showDialog((Dialog)paramView);
      return;
      this.az.dismiss();
      n();
      return;
      com.ziroom.ziroomcustomer.dialog.c.newBuilder(this).setTitle("").setContent("确定要关闭合同吗？").setButtonText("取消").setSecondButtonText("确定").setCanceledOnTouchOutside(true).setOnSecondClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          LeaseConfirmPayActivity.this.showProgress("");
          com.ziroom.ziroomcustomer.e.d.getModifyContractState(LeaseConfirmPayActivity.j(LeaseConfirmPayActivity.this), LeaseConfirmPayActivity.k(LeaseConfirmPayActivity.this).getContractCode(), LeaseConfirmPayActivity.l(LeaseConfirmPayActivity.this).getHouse_id(), LeaseConfirmPayActivity.l(LeaseConfirmPayActivity.this).getHouse_code(), LeaseConfirmPayActivity.l(LeaseConfirmPayActivity.this).getHouse_type(), "OPT001");
          w.onEvent(LeaseConfirmPayActivity.b(LeaseConfirmPayActivity.this), "signup_pay_closecontract");
        }
      }).build().show();
      w.onEvent(this.aq, "signup_pay_more");
      return;
      float f2;
      float f3;
      if (this.aP)
      {
        f1 = new Float(VdsAgent.trackEditTextSilent(this.C).toString()).floatValue();
        f2 = new Float(this.au.getText().toString()).floatValue();
        f3 = (float)ah.Number2(f1 - f2);
        if (f3 <= 0.0F)
        {
          this.aI = ((int)setIntger(setFloat(f1) * 100.0F));
          this.aS.setVisibility(8);
          this.I.setText("使用账户余额支付");
          this.N = "balance_order";
          this.C.setText(ah.Number(0.0F) + "");
        }
      }
      for (;;)
      {
        isUpdate();
        return;
        this.C.setText(ah.Number(Float.parseFloat(new StringBuilder().append(f3).append("").toString())) + "");
        this.aI = ((int)setIntger(setFloat(f2) * 100.0F));
        setPayType();
        continue;
        f1 = new Float(VdsAgent.trackEditTextSilent(this.C).toString()).floatValue();
        f2 = new Float(this.aI / 100.0F).floatValue();
        u.e("account", "" + f2);
        f1 = (float)ah.Number2(f1 + f2);
        if (f1 <= 0.0F)
        {
          this.aI = 0;
          this.aS.setVisibility(8);
          this.I.setText("使用账户余额支付");
          this.N = "balance_order";
          this.C.setText(ah.Number(0.0F) + "");
        }
        else
        {
          this.C.setText(ah.Number(f1) + "");
          setPayType();
          this.aI = 0;
        }
      }
      if (!this.aQ)
      {
        if (this.aD == 0.0F)
        {
          this.am.setChecked(false);
          showToast("请先输入代金券");
        }
        for (;;)
        {
          isUpdate();
          return;
          if (this.U.getIsBlank() == 1) {
            break label2119;
          }
          if ("1".equals(this.U.getIsZWhite())) {
            break;
          }
          f2 = Float.parseFloat(VdsAgent.trackEditTextSilent(this.C).toString()) - this.aD;
          f1 = f2;
          if (f2 <= 0.0F)
          {
            this.aI = ((int)setIntger((Float.parseFloat(VdsAgent.trackEditTextSilent(this.C).toString()) + this.aI / 100.0F - this.aD) * 100.0F));
            this.aS.setVisibility(8);
            this.I.setText("使用账户余额支付");
            this.N = "balance_order";
            f1 = 0.0F;
          }
          this.C.setText(ah.Number(f1));
          this.az.dismiss();
          n();
          this.aQ = true;
        }
        f2 = Float.parseFloat(VdsAgent.trackEditTextSilent(this.C).toString()) - a(this.aD);
        if (f2 > 0.0F) {
          break label2575;
        }
        this.aI = ((int)setIntger((Float.parseFloat(VdsAgent.trackEditTextSilent(this.C).toString()) + this.aI / 100.0F - a(this.aD)) * 100.0F));
        this.aS.setVisibility(8);
        this.I.setText("使用账户余额支付");
        this.N = "balance_order";
      }
      for (;;)
      {
        this.C.setText(ah.Number(f1));
        this.az.dismiss();
        n();
        this.aQ = true;
        break;
        this.C.setText(ah.Number(Float.parseFloat(blankKims(this.aD))));
        this.az.dismiss();
        n();
        this.aQ = true;
        break;
        this.aK = 0.0F;
        if (this.U.getIsBlank() != 1) {
          if ((this.T == 0) || (this.T == 1) || (this.T == 3)) {
            f1 = this.U.getCountPrice();
          }
        }
        for (;;)
        {
          if (this.aP) {
            if (this.U.getBalance() - f1 * 100.0F >= 0.0F)
            {
              this.aI = ((int)setIntger(setFloat(f1) * 100.0F));
              this.C.setText(ah.Number(Float.parseFloat("0")));
            }
          }
          for (;;)
          {
            this.aQ = false;
            break;
            if (this.T != 2) {
              break label2570;
            }
            f1 = this.U.getDeposit();
            break label2206;
            this.C.setText(ah.Number(Float.parseFloat("" + ah.Number2(f1 - this.U.getBalance() / 100.0F))));
            continue;
            this.C.setText(ah.Number(Float.parseFloat("" + ah.Number2(f1))));
          }
          this.C.setText(ah.Number(this.U.getCountPrice()) + "");
          this.az.dismiss();
          n();
          this.aQ = false;
          break;
          paramView = ((TextView)paramView).getText().toString();
          if ("确认支付".equals(paramView))
          {
            j();
            this.bp.dismiss();
            return;
          }
          if ("去勾选".equals(paramView))
          {
            this.bp.dismiss();
            return;
          }
          w.onEvent(this.aq, "signup_pay_return_know");
          startActivity(new Intent(this.aq, MainActivity.class));
          finish();
          ApplicationEx.c.finishAllActivity();
          return;
          if ("不使用".equals(((TextView)paramView).getText().toString()))
          {
            j();
            this.bp.dismiss();
            return;
          }
          this.bp.dismiss();
          return;
          f1 = 0.0F;
        }
        f1 = f2;
      }
    }
  }
  
  public void onConfirm()
  {
    if (ae.isNull(VdsAgent.trackEditTextSilent(this.C).toString()))
    {
      showToast("金额为空");
      return;
    }
    showProgress("正在请求订单号,请稍候...");
    int j = 0;
    Object localObject1 = new ArrayList();
    int i = j;
    Object localObject2;
    Object localObject3;
    if (this.L != null)
    {
      i = j;
      if (this.L.size() > 0)
      {
        localObject2 = this.L.iterator();
        i = 0;
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (RentCardDetail)((Iterator)localObject2).next();
          if (((RentCardDetail)localObject3).getIsCheck() != 1) {
            break label536;
          }
          ((List)localObject1).add(((RentCardDetail)localObject3).getCardCode());
          float f1 = i;
          i = (int)(((RentCardDetail)localObject3).getCardValue() * 100.0F + f1);
        }
      }
    }
    label536:
    for (;;)
    {
      break;
      int m = (int)ah.setInt(ah.setFloat(Float.parseFloat(VdsAgent.trackEditTextSilent(this.C).toString())) * 100.0F);
      if (this.U.getPeriods() == 1)
      {
        int k = (int)(this.aK * 100.0F);
        j = (int)(this.aL * 100.0F);
        localObject1 = this.aA;
        this.aJ = this.aI;
        i = 0;
        if (ae.notNull(this.ae)) {
          i = 1;
        }
        if (!this.am.isChecked())
        {
          localObject1 = "";
          j = 0;
          localObject2 = "0";
          localObject3 = "0";
          k = 0;
        }
        for (;;)
        {
          this.I.setEnabled(false);
          com.ziroom.ziroomcustomer.e.d.signedMakeOrder(a, this.br, this.X, m, this.N, "android", this.M, ah.getMac(a), ah.getDeviceId(a), this.aI, (String)localObject1, j, i, k + "", this.be, this.bf, this.bg, "" + (int)(ah.Number2(Float.parseFloat(this.bi)) * 100.0D), (String)localObject2, (String)localObject3);
          return;
          localObject2 = "1";
          localObject3 = (int)setIntger(a(this.aK) * 100.0F) + "";
        }
      }
      j = 0;
      if (this.U.getSysContractId() != null) {
        j = Integer.valueOf(this.U.getSysContractId() + "").intValue();
      }
      this.I.setEnabled(false);
      com.ziroom.ziroomcustomer.e.d.makeOrder(this, this.br, j, m + i, this.U.getPeriods(), this.M, (List)localObject1, this.N, i + "", this.be, this.bf, this.bg);
      return;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903693);
    a = this;
    this.aq = this;
    paramBundle = ((ApplicationEx)getApplication()).getUser();
    if (paramBundle != null) {
      this.M = paramBundle.getUid();
    }
    if (!checkNet(getApplicationContext()))
    {
      g.textToast(this, "网络请求失败，请检查您的网络设置", 1);
      return;
    }
    this.aB = ((HouseDetail)getIntent().getSerializableExtra("detail"));
    if (this.aB == null) {
      this.aB = new HouseDetail();
    }
    if (ae.notNull(this.aB.getCityCode())) {
      this.aR = this.aB.getCityCode();
    }
    this.Z = ((LeasePayPlan)getIntent().getSerializableExtra("LeasePayPlan"));
    this.X = getIntent().getStringExtra("contract_code");
    this.aa = getIntent().getStringExtra("signed");
    this.ae = getIntent().getStringExtra("old_contract_code");
    paramBundle = getIntent().getStringExtra("cityCode");
    if (ae.notNull(paramBundle)) {
      this.aR = paramBundle;
    }
    if ((this.X != null) && (this.Z == null))
    {
      com.ziroom.ziroomcustomer.e.d.getPayDetails(this.br, this.X);
      showProgress("");
    }
    for (;;)
    {
      this.Y.initWXAPI(this);
      registerReceiver(this.bt, new IntentFilter("com.ziroom.ziroomcustomer.activity_1"));
      registerReceiver(this.bs, new IntentFilter("com.ziroom.ziroomcustomer.activity_2"));
      return;
      if (this.Z != null)
      {
        this.aX = ((LeaseInfo)getIntent().getSerializableExtra("Lease"));
        this.aU = getIntent().getStringArrayListExtra("payTypeList");
        this.aR = this.Z.getCityCode();
        this.U = new SignedPayDetails(this.Z.getContractCode(), this.Z.getPeriods().intValue(), Float.parseFloat(this.Z.getFee()), Float.parseFloat(this.Z.getPayFee()), 1, 0, this.aX.getAddress(), this.aX.getSysContractId(), this.Z.getPayCount(), this.aX.getGiftList());
        a(this.aU);
        a();
        onSelect();
      }
    }
  }
  
  public void onDecrease()
  {
    double d1 = getInputAmount();
    double d2 = getCardsAmount();
    this.am.setChecked(false);
    this.al.setChecked(false);
    this.aK = 0.0F;
    this.aI = 0;
    if (d2 >= 500.0D)
    {
      d1 = 0.0D;
      this.E.setBackgroundResource(2130838347);
      this.E.setEnabled(false);
    }
    for (;;)
    {
      this.R = (d2 + d1);
      if (this.R < this.Q)
      {
        this.F.setBackgroundResource(2130838871);
        this.F.setEnabled(true);
      }
      setPayType();
      this.C.setText(ah.Number(Float.parseFloat(new StringBuilder().append("").append(ah.Number2(d1)).toString())) + "");
      this.bi = VdsAgent.trackEditTextSilent(this.C).toString();
      return;
      if (d1 + d2 - 500.0D > 500.0D)
      {
        d1 -= 500.0D;
      }
      else
      {
        d1 = 500.0D - d2;
        this.E.setBackgroundResource(2130838347);
        this.E.setEnabled(false);
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.B != null) {
      this.B.cancel();
    }
    unregisterReceiver(this.bt);
    unregisterReceiver(this.bs);
  }
  
  public void onIncrease()
  {
    double d1 = getInputAmount();
    double d2 = getCardsAmount();
    double d3 = i();
    this.am.setChecked(false);
    this.al.setChecked(false);
    this.aK = 0.0F;
    this.aI = 0;
    if (d1 + d2 + 500.0D >= d3)
    {
      d1 = d3 - d2;
      this.F.setBackgroundResource(2130838872);
      this.F.setEnabled(false);
    }
    for (;;)
    {
      this.R = (d2 + d1);
      if (this.R > 500.0D)
      {
        this.E.setBackgroundResource(2130838346);
        this.E.setEnabled(true);
      }
      setPayType();
      this.C.setText(ah.Number(Float.parseFloat(new StringBuilder().append("").append(ah.Number2(d1)).toString())) + "");
      this.bi = VdsAgent.trackEditTextSilent(this.C).toString();
      return;
      d1 += 500.0D;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    if ((this.aF != null) && (this.aF.isShowing()))
    {
      this.aF.dismiss();
      this.aE = true;
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onResume()
  {
    super.onResume();
    g();
    f();
  }
  
  public void onSelect()
  {
    showProgress("");
    com.ziroom.ziroomcustomer.e.d.getRentCards(this, this.br, this.M, 1, Integer.MAX_VALUE, 0);
  }
  
  public void onToggleStateChange(boolean paramBoolean)
  {
    if (this.Q <= 500.0D) {
      return;
    }
    if (paramBoolean)
    {
      this.E.setVisibility(0);
      this.E.setBackgroundResource(2130838346);
      this.E.setEnabled(true);
      this.F.setVisibility(0);
      this.F.setBackgroundResource(2130838872);
      this.F.setEnabled(false);
      this.R = this.Q;
      if (getCardsAmount() >= 500.0D)
      {
        this.E.setBackgroundResource(2130838347);
        this.E.setEnabled(false);
      }
    }
    for (;;)
    {
      this.P = paramBoolean;
      setInputAmount();
      return;
      this.E.setVisibility(8);
      this.F.setVisibility(8);
      this.C.setEnabled(false);
    }
  }
  
  public void onUPPay(PayOrder paramPayOrder)
  {
    if (paramPayOrder == null)
    {
      showToast("获取订单号失败！");
      return;
    }
    if (ae.isNull(paramPayOrder.getTrans_id()))
    {
      showToast("流水号为空");
      return;
    }
    com.ziroom.commonlibrary.e.c.doStartUnionPayPlugin(this, paramPayOrder.getTrans_id());
    MobclickAgent.onEvent(this, "5ZY_zhifubank");
  }
  
  public void onUse()
  {
    this.u.setVisibility(0);
    this.D.setVisibility(8);
    this.G.setVisibility(8);
    this.H.setVisibility(8);
  }
  
  public void payEnd()
  {
    View localView = View.inflate(a, 2130905016, null);
    this.ax = ((TextView)localView.findViewById(2131697194));
    TextView localTextView = (TextView)localView.findViewById(2131697195);
    this.bu = new Dialog(a, 2131427781);
    this.bu.setContentView(localView);
    localTextView.setOnClickListener(this);
  }
  
  public void refreshTip()
  {
    if ((this.O != null) && (this.O.size() > 0))
    {
      Iterator localIterator = this.O.iterator();
      for (double d1 = 0.0D; localIterator.hasNext(); d1 = ah.Number2(((RentCardDetail)localIterator.next()).getCardValue()) + d1) {}
      this.s.setText(Html.fromHtml(String.format(getString(2131296714), new Object[] { Integer.valueOf(this.O.size()), Double.valueOf(d1) })));
      this.u.setText(Html.fromHtml(String.format(getString(2131296715), new Object[] { Integer.valueOf(this.L.size()), Integer.valueOf(this.O.size()), Double.valueOf(d1) })));
    }
    for (;;)
    {
      setInputAmount();
      return;
      this.s.setText("");
      this.u.setText("");
    }
  }
  
  public float setFloat(float paramFloat)
  {
    return new BigDecimal(paramFloat).setScale(2, 4).floatValue();
  }
  
  public void setImage(int paramInt)
  {
    if (paramInt == 0)
    {
      onToggleStateChange(true);
      this.C.setText(ah.Number(this.U.getCountPrice()) + "");
      this.bi = VdsAgent.trackEditTextSilent(this.C).toString();
      this.aK = 0.0F;
      this.aI = 0;
      setPayType();
    }
    for (;;)
    {
      this.am.setChecked(false);
      this.al.setChecked(false);
      this.aP = false;
      this.aQ = false;
      return;
      if (paramInt == 1)
      {
        onToggleStateChange(false);
        this.C.setText(ah.Number(this.U.getCountPrice()) + "");
        this.bi = VdsAgent.trackEditTextSilent(this.C).toString();
        this.aK = 0.0F;
        this.aI = 0;
        setPayType();
      }
      else if (paramInt == 2)
      {
        onToggleStateChange(false);
        this.C.setText(ah.Number(this.U.getDeposit()) + "");
        this.bi = VdsAgent.trackEditTextSilent(this.C).toString();
        this.aK = 0.0F;
        this.aI = 0;
        setPayType();
      }
      else if (paramInt == 3)
      {
        this.aK = 0.0F;
        this.aI = 0;
        onToggleStateChange(false);
        this.C.setText(ah.Number(this.U.getCountPrice()) + "");
        this.bi = VdsAgent.trackEditTextSilent(this.C).toString();
        setPayType();
      }
    }
  }
  
  public void setInputAmount()
  {
    if (this.P)
    {
      d1 = getCardsAmount();
      d2 = getInputAmount();
      if (d2 - d2 >= 500.0D)
      {
        this.E.setBackgroundResource(2130838346);
        this.E.setEnabled(true);
      }
      this.C.setText(ah.Number(Float.parseFloat(new StringBuilder().append("").append(ah.Number2(this.R - d1)).toString())) + "");
      this.bi = VdsAgent.trackEditTextSilent(this.C).toString();
      return;
    }
    double d1 = i();
    double d2 = getCardsAmount();
    this.C.setText(ah.Number(Float.parseFloat(new StringBuilder().append("").append(ah.Number2(d1 - d2)).toString())) + "");
    this.bi = VdsAgent.trackEditTextSilent(this.C).toString();
  }
  
  public float setIntger(float paramFloat)
  {
    return new BigDecimal(paramFloat).setScale(0, 4).floatValue();
  }
  
  public void setPayType()
  {
    this.aS.setVisibility(0);
    this.I.setText("去支付");
    h();
    this.N = "";
  }
  
  public void showDialog(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.bk = View.inflate(this.aq, 2130905165, null);
    this.bl = ((TextView)this.bk.findViewById(2131697639));
    this.bo = ((TextView)this.bk.findViewById(2131697638));
    this.bn = ((TextView)this.bk.findViewById(2131697637));
    this.bm = ((TextView)this.bk.findViewById(2131697634));
    this.bl.setOnClickListener(this);
    this.bo.setOnClickListener(this);
    if (ae.isNull(paramString1))
    {
      this.bm.setVisibility(8);
      this.bl.setVisibility(0);
      this.bo.setVisibility(0);
      this.bn.setGravity(17);
      this.bn.setText("" + paramString2);
      this.bl.setText("" + paramString3);
      this.bo.setText("" + paramString4);
      if (this.bp == null)
      {
        this.bp = new Dialog(this.aq, 2131427781);
        this.bp.setContentView(this.bk);
        this.bp.setCanceledOnTouchOutside(false);
        this.bp.setCancelable(false);
        if (!this.bp.isShowing())
        {
          paramString1 = this.bp;
          if ((paramString1 instanceof Dialog)) {
            break label328;
          }
          paramString1.show();
        }
      }
    }
    for (;;)
    {
      ApplicationEx.g = 2;
      this.bp.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          LeaseConfirmPayActivity.a(LeaseConfirmPayActivity.this, null);
          LeaseConfirmPayActivity.a(LeaseConfirmPayActivity.this).dismiss();
          LeaseConfirmPayActivity.a(LeaseConfirmPayActivity.this, null);
        }
      });
      return;
      this.bm.setText(paramString1);
      break;
      label328:
      VdsAgent.showDialog((Dialog)paramString1);
    }
  }
  
  public void showRentCards()
  {
    if (this.K == null)
    {
      this.K = new h(this, this.br, this.L);
      this.D.setAdapter(this.K);
    }
    for (;;)
    {
      this.u.setVisibility(8);
      this.D.setVisibility(0);
      this.G.setVisibility(0);
      this.H.setVisibility(0);
      return;
      this.K.setData(this.L);
      this.K.notifyDataSetChanged();
    }
  }
  
  public void toHousing()
  {
    Intent localIntent = new Intent(this.aq, RentHouseDetailActivity.class);
    localIntent.putExtra("SIGNBACK", "SIGNBACK");
    localIntent.putExtra("id", this.aB.getHouse_code());
    localIntent.putExtra("house_id", this.aB.getHouse_id());
    startActivity(localIntent);
    finish();
  }
  
  class a
    extends CountDownTimer
  {
    public a(long paramLong1, long paramLong2)
    {
      super(paramLong2);
    }
    
    public void onFinish()
    {
      LeaseConfirmPayActivity.a(LeaseConfirmPayActivity.this, "00:00");
    }
    
    public void onTick(long paramLong)
    {
      LeaseConfirmPayActivity.a(LeaseConfirmPayActivity.this, m.getTimeString(paramLong));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/activity/LeaseConfirmPayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */