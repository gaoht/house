package com.ziroom.ziroomcustomer.signed;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.itrus.raapi.implement.ClientForAndroid;
import com.ziroom.ziroomcustomer.activity.HouseBillInfoActivity;
import com.ziroom.ziroomcustomer.activity.ListViewForScrollView;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.d;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.model.HouseDetail;
import com.ziroom.ziroomcustomer.model.SignedOldPayDataEntity;
import com.ziroom.ziroomcustomer.model.SignedPayDataEntity;
import com.ziroom.ziroomcustomer.model.SignedPayServiceDataEntity;
import com.ziroom.ziroomcustomer.model.SignedPayServiceInfoEntity;
import com.ziroom.ziroomcustomer.signed.a.a;
import com.ziroom.ziroomcustomer.signed.a.a.a;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PayInformationActivity
  extends BaseActivity
  implements i.a
{
  private Dialog A;
  private EditText B;
  private EditText C;
  private Button D;
  private TextView E;
  private TextView F;
  private TextView G;
  private TextView H;
  private List<SignedPayServiceDataEntity> I;
  private float J = 0.0F;
  private float K = 0.0F;
  private String L = "0";
  private String M;
  private Dialog N;
  private HouseDetail O;
  private LinearLayout P;
  private TextView Q;
  private TextView R;
  private TextView S;
  private TextView T;
  private TextView U;
  private TextView V;
  private TextView W;
  private TextView X;
  private SimpleDraweeView Y;
  private String Z;
  String a = "";
  private RelativeLayout aa;
  private RelativeLayout ab;
  private String ac = "0";
  private ImageView ad;
  private String ae;
  private Bitmap af;
  private String ag;
  private String ah;
  private SignedPayDataEntity ai;
  private LinearLayout aj;
  private PopupWindow ak;
  private boolean al = true;
  private TextView am;
  private TextView an;
  private TextView ao;
  private TextView ap;
  private RelativeLayout aq;
  private Handler ar = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      SignedPayServiceDataEntity localSignedPayServiceDataEntity;
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 69657: 
        PayInformationActivity.this.dismissProgress();
        paramAnonymousMessage = (l)paramAnonymousMessage.obj;
        if (paramAnonymousMessage.getSuccess().booleanValue())
        {
          if (ae.notNull(PayInformationActivity.a(PayInformationActivity.this).getActivity()))
          {
            if (PayInformationActivity.b(PayInformationActivity.this) != null) {
              PayInformationActivity.b(PayInformationActivity.this).dismiss();
            }
            PayInformationActivity.a(PayInformationActivity.this, true);
            PayInformationActivity.c(PayInformationActivity.this).setText(PayInformationActivity.a(PayInformationActivity.this).getActivity() + "");
          }
          PayInformationActivity.this.c = PayInformationActivity.this.b;
          PayInformationActivity.this.d = PayInformationActivity.a(PayInformationActivity.this).getActivity();
          PayInformationActivity.d(PayInformationActivity.this).setEnabled(true);
          if ((PayInformationActivity.e(PayInformationActivity.this) != null) && (ae.isNull(PayInformationActivity.a(PayInformationActivity.this).getActivity())) && (PayInformationActivity.f(PayInformationActivity.this) == null))
          {
            d.getPayServiceData(PayInformationActivity.g(PayInformationActivity.this), PayInformationActivity.e(PayInformationActivity.this).getHouse_code(), PayInformationActivity.e(PayInformationActivity.this).getHouse_id(), PayInformationActivity.e(PayInformationActivity.this).getHouse_type(), PayInformationActivity.h(PayInformationActivity.this), PayInformationActivity.i(PayInformationActivity.this), PayInformationActivity.j(PayInformationActivity.this));
            PayInformationActivity.this.showProgress("");
          }
          if ("0".equals(PayInformationActivity.h(PayInformationActivity.this))) {
            PayInformationActivity.a(PayInformationActivity.this, (SignedPayDataEntity)paramAnonymousMessage.getObject());
          }
          for (;;)
          {
            PayInformationActivity.this.setView(PayInformationActivity.k(PayInformationActivity.this));
            return;
            paramAnonymousMessage = (SignedOldPayDataEntity)paramAnonymousMessage.getObject();
            PayInformationActivity.a(PayInformationActivity.this, new SignedPayDataEntity(paramAnonymousMessage.getHousePrice(), paramAnonymousMessage.getPriceUnit(), paramAnonymousMessage.getPayment(), paramAnonymousMessage.getPaymentUnit(), paramAnonymousMessage.getDeposit(), paramAnonymousMessage.getCommission(), paramAnonymousMessage.getIsPreDeposit(), paramAnonymousMessage.getOldIsDeposit(), paramAnonymousMessage.getDiscountCommission(), paramAnonymousMessage.getFeeNote(), paramAnonymousMessage.getIsZWhite(), paramAnonymousMessage.getLoanPayInfo(), paramAnonymousMessage.getRenewContractCode(), paramAnonymousMessage.getPromptTags(), paramAnonymousMessage.getActivityPayModel(), paramAnonymousMessage.getRentDescribe(), paramAnonymousMessage.getRentPeriodDes(), paramAnonymousMessage.getActivityNote(), paramAnonymousMessage.getRentMoneyCount(), paramAnonymousMessage.getCountMoney(), paramAnonymousMessage.getCouponView(), paramAnonymousMessage.getIsShowCoupon()));
          }
        }
        PayInformationActivity.this.showToast(paramAnonymousMessage.getMessage());
        return;
      case 69664: 
        PayInformationActivity.this.dismissProgress();
        paramAnonymousMessage = (l)paramAnonymousMessage.obj;
        if (paramAnonymousMessage.getSuccess().booleanValue())
        {
          PayInformationActivity.a(PayInformationActivity.this, (List)paramAnonymousMessage.getObject());
          if (PayInformationActivity.f(PayInformationActivity.this).size() > 0)
          {
            PayInformationActivity.c(PayInformationActivity.this).setTextColor(Color.parseColor("#ffa000"));
            PayInformationActivity.c(PayInformationActivity.this).setText("请选择");
            paramAnonymousMessage = "";
            Iterator localIterator = PayInformationActivity.f(PayInformationActivity.this).iterator();
            if (localIterator.hasNext())
            {
              localSignedPayServiceDataEntity = (SignedPayServiceDataEntity)localIterator.next();
              if (!"1".equals(localSignedPayServiceDataEntity.getIs_default_check())) {
                break label1332;
              }
              if (ae.notNull(paramAnonymousMessage)) {
                paramAnonymousMessage = paramAnonymousMessage + "|" + localSignedPayServiceDataEntity.getActivityCode();
              }
            }
          }
        }
        break;
      }
      label1332:
      for (;;)
      {
        break;
        paramAnonymousMessage = localSignedPayServiceDataEntity.getActivityCode();
        continue;
        PayInformationActivity.this.a = paramAnonymousMessage;
        if (ae.notNull(paramAnonymousMessage)) {
          PayInformationActivity.this.setTotalPrice(paramAnonymousMessage, PayInformationActivity.this.c);
        }
        for (;;)
        {
          PayInformationActivity.b(PayInformationActivity.this, PayInformationActivity.f(PayInformationActivity.this));
          return;
          PayInformationActivity.c(PayInformationActivity.this).setTextColor(Color.parseColor("#999999"));
          PayInformationActivity.c(PayInformationActivity.this).setText("无优惠活动");
        }
        PayInformationActivity.this.showToast(paramAnonymousMessage.getMessage());
        return;
        PayInformationActivity.this.dismissProgress();
        paramAnonymousMessage = (l)paramAnonymousMessage.obj;
        if (paramAnonymousMessage.getSuccess().booleanValue())
        {
          PayInformationActivity.l(PayInformationActivity.this).setText(String.format("%.2f", new Object[] { Float.valueOf(Float.parseFloat(PayInformationActivity.l(PayInformationActivity.this).getText().toString()) - ((Float)paramAnonymousMessage.getObject()).floatValue() + PayInformationActivity.m(PayInformationActivity.this)) }));
          PayInformationActivity.a(PayInformationActivity.this, ((Float)paramAnonymousMessage.getObject()).floatValue());
          PayInformationActivity.n(PayInformationActivity.this).dismiss();
          return;
        }
        PayInformationActivity.o(PayInformationActivity.this).setVisibility(0);
        PayInformationActivity.p(PayInformationActivity.this).setText(paramAnonymousMessage.getMessage());
        return;
        PayInformationActivity.this.dismissProgress();
        paramAnonymousMessage = (l)paramAnonymousMessage.obj;
        if (paramAnonymousMessage.getSuccess().booleanValue())
        {
          if (PayInformationActivity.q(PayInformationActivity.this) != null) {
            PayInformationActivity.q(PayInformationActivity.this).dismiss();
          }
          PayInformationActivity.a(PayInformationActivity.this, (String)paramAnonymousMessage.getObject());
          if (1 == PayInformationActivity.k(PayInformationActivity.this).getIsZWhite())
          {
            paramAnonymousMessage = new Intent(PayInformationActivity.r(PayInformationActivity.this), LoanInfoActivity.class);
            paramAnonymousMessage.putExtra("contract_code", PayInformationActivity.j(PayInformationActivity.this));
            paramAnonymousMessage.putExtra("old_contract_code", PayInformationActivity.i(PayInformationActivity.this));
            paramAnonymousMessage.putExtra("detail", PayInformationActivity.e(PayInformationActivity.this));
            PayInformationActivity.this.startActivity(paramAnonymousMessage);
            return;
          }
          paramAnonymousMessage = new Intent(PayInformationActivity.r(PayInformationActivity.this), HouseBillInfoActivity.class);
          paramAnonymousMessage.putExtra("uniqueCode", PayInformationActivity.j(PayInformationActivity.this));
          paramAnonymousMessage.putExtra("period", "1");
          if (PayInformationActivity.i(PayInformationActivity.this) != null) {
            paramAnonymousMessage.putExtra("old_contract_code", PayInformationActivity.i(PayInformationActivity.this));
          }
          paramAnonymousMessage.putExtra("mContentText", "倒计时结束之前，您可以在“我的合同”里找到待支付合同进行支付。");
          paramAnonymousMessage.putExtra("payType", "fz");
          PayInformationActivity.this.startActivity(paramAnonymousMessage);
          return;
        }
        PayInformationActivity.this.showToast(paramAnonymousMessage.getMessage());
        return;
        paramAnonymousMessage = (l)paramAnonymousMessage.obj;
        if (paramAnonymousMessage.getSuccess().booleanValue())
        {
          paramAnonymousMessage = paramAnonymousMessage.getObject().toString();
          PayInformationActivity.b(PayInformationActivity.this, paramAnonymousMessage);
          return;
        }
        PayInformationActivity.this.showToast(paramAnonymousMessage.getMessage());
        PayInformationActivity.this.dismissProgress();
        return;
        PayInformationActivity.this.dismissProgress();
        paramAnonymousMessage = (l)paramAnonymousMessage.obj;
        if (paramAnonymousMessage.getSuccess().booleanValue())
        {
          PayInformationActivity.this.onSign();
          return;
        }
        g.textToast(PayInformationActivity.this, paramAnonymousMessage.getMessage(), 1);
        d.errorLog(PayInformationActivity.this, "验签失败,", "证书导入失败!!!验签失败," + paramAnonymousMessage.getMessage());
        return;
        PayInformationActivity.t(PayInformationActivity.this).setImageBitmap(PayInformationActivity.s(PayInformationActivity.this));
        PayInformationActivity.u(PayInformationActivity.this).setVisibility(8);
        return;
      }
    }
  };
  private LinearLayout as;
  private TextView at;
  String b = "";
  String c = "";
  String d = "";
  View.OnClickListener e = new View.OnClickListener()
  {
    @com.growingio.android.sdk.instrumentation.Instrumented
    public void onClick(View paramAnonymousView)
    {
      VdsAgent.onClick(this, paramAnonymousView);
      switch (paramAnonymousView.getId())
      {
      default: 
      case 2131697217: 
      case 2131697188: 
      case 2131697187: 
      case 2131690105: 
      case 2131697212: 
      case 2131697229: 
      case 2131697228: 
      case 2131697197: 
      case 2131697195: 
        do
        {
          do
          {
            return;
            paramAnonymousView = new Intent(PayInformationActivity.r(PayInformationActivity.this), SignerCouponActivity.class);
            paramAnonymousView.putExtra("contractCode", PayInformationActivity.j(PayInformationActivity.this));
            PayInformationActivity.this.startActivityForResult(paramAnonymousView, 99);
            return;
            if (PayInformationActivity.b(PayInformationActivity.this) != null) {
              PayInformationActivity.b(PayInformationActivity.this).dismiss();
            }
            PayInformationActivity.a(PayInformationActivity.this, true);
            PayInformationActivity.this.setTotalPrice(PayInformationActivity.a(PayInformationActivity.this).getActivity(), PayInformationActivity.this.c);
            return;
            if (PayInformationActivity.b(PayInformationActivity.this) != null) {
              PayInformationActivity.b(PayInformationActivity.this).dismiss();
            }
            PayInformationActivity.a(PayInformationActivity.this, true);
            return;
            PayInformationActivity.this.finish();
            return;
            if (PayInformationActivity.a(PayInformationActivity.this) != null)
            {
              if (PayInformationActivity.a(PayInformationActivity.this).getmList().size() > 0)
              {
                PayInformationActivity.v(PayInformationActivity.this);
                w.onEvent(PayInformationActivity.r(PayInformationActivity.this), "signup_money_activity");
                return;
              }
              g.textToast(PayInformationActivity.r(PayInformationActivity.this), "无优惠活动", 0);
              return;
            }
            g.textToast(PayInformationActivity.r(PayInformationActivity.this), "正在加载，请稍后", 0);
            return;
            PayInformationActivity.d(PayInformationActivity.this, VdsAgent.trackEditTextSilent(PayInformationActivity.w(PayInformationActivity.this)).toString());
            if (!ae.notNull(PayInformationActivity.x(PayInformationActivity.this))) {
              break;
            }
          } while (PayInformationActivity.e(PayInformationActivity.this) == null);
          d.getPayKims(PayInformationActivity.g(PayInformationActivity.this), PayInformationActivity.x(PayInformationActivity.this), PayInformationActivity.e(PayInformationActivity.this).getHouse_code(), PayInformationActivity.e(PayInformationActivity.this).getHouse_id(), PayInformationActivity.e(PayInformationActivity.this).getHouse_type(), PayInformationActivity.h(PayInformationActivity.this), PayInformationActivity.i(PayInformationActivity.this), PayInformationActivity.j(PayInformationActivity.this));
          return;
          g.textToast(PayInformationActivity.r(PayInformationActivity.this), "输入的代金券为空", 0);
          return;
          PayInformationActivity.n(PayInformationActivity.this).dismiss();
          return;
          if (PayInformationActivity.m(PayInformationActivity.this) == 0.0F) {
            PayInformationActivity.d(PayInformationActivity.this, "");
          }
          if (PayInformationActivity.i(PayInformationActivity.this) == null)
          {
            paramAnonymousView = new Intent(PayInformationActivity.r(PayInformationActivity.this), ConfirmContractActivity.class);
            paramAnonymousView.putExtra("detail", PayInformationActivity.e(PayInformationActivity.this));
            paramAnonymousView.putExtra("is_renew", PayInformationActivity.h(PayInformationActivity.this));
            paramAnonymousView.putExtra("mTotalPrice", PayInformationActivity.l(PayInformationActivity.this).getText().toString() + "");
            paramAnonymousView.putExtra("old_contract_code", PayInformationActivity.i(PayInformationActivity.this));
            paramAnonymousView.putExtra("mCouponCode", PayInformationActivity.this.c);
            paramAnonymousView.putExtra("mkims", PayInformationActivity.y(PayInformationActivity.this));
            paramAnonymousView.putExtra("voucher", PayInformationActivity.x(PayInformationActivity.this));
            paramAnonymousView.putExtra("activity", PayInformationActivity.a(PayInformationActivity.this).getActivity());
            paramAnonymousView.putExtra("contract_code", PayInformationActivity.j(PayInformationActivity.this));
            PayInformationActivity.this.startActivity(paramAnonymousView);
            w.onEvent(PayInformationActivity.r(PayInformationActivity.this), "signup_money_confirm");
            return;
          }
          PayInformationActivity.a(PayInformationActivity.this, PayInformationActivity.g(PayInformationActivity.this), PayInformationActivity.e(PayInformationActivity.this).getHouse_code(), PayInformationActivity.e(PayInformationActivity.this).getHouse_id(), PayInformationActivity.e(PayInformationActivity.this).getHouse_type());
          PayInformationActivity.this.showProgress("");
          return;
          PayInformationActivity.e(PayInformationActivity.this, VdsAgent.trackEditTextSilent(PayInformationActivity.z(PayInformationActivity.this)).toString());
          if ((PayInformationActivity.A(PayInformationActivity.this).length() == 0) || (PayInformationActivity.A(PayInformationActivity.this) == null))
          {
            g.textToast(PayInformationActivity.this, "验证码不能为空", 0);
            return;
          }
          PayInformationActivity.this.showProgress("");
        } while (PayInformationActivity.e(PayInformationActivity.this) == null);
        d.setPaycontract(PayInformationActivity.r(PayInformationActivity.this), PayInformationActivity.g(PayInformationActivity.this), PayInformationActivity.e(PayInformationActivity.this).getHouse_code(), PayInformationActivity.e(PayInformationActivity.this).getHouse_id(), PayInformationActivity.e(PayInformationActivity.this).getHouse_type(), PayInformationActivity.a(PayInformationActivity.this).getActivity(), PayInformationActivity.x(PayInformationActivity.this), PayInformationActivity.y(PayInformationActivity.this) + PayInformationActivity.m(PayInformationActivity.this), Float.parseFloat("" + PayInformationActivity.l(PayInformationActivity.this).getText().toString()), PayInformationActivity.h(PayInformationActivity.this), PayInformationActivity.A(PayInformationActivity.this), PayInformationActivity.B(PayInformationActivity.this), PayInformationActivity.i(PayInformationActivity.this), PayInformationActivity.this.c);
        return;
      }
      PayInformationActivity.q(PayInformationActivity.this).dismiss();
    }
  };
  private ImageView f;
  private TextView g;
  private TextView r;
  private TextView s;
  private TextView t;
  private TextView u;
  private ListViewForScrollView v;
  private Context w;
  private View x;
  private View y;
  private i z;
  
  private View a(a.a parama)
  {
    View localView = View.inflate(this, 2130905217, null);
    TextView localTextView1 = (TextView)localView.findViewById(2131697776);
    TextView localTextView2 = (TextView)localView.findViewById(2131697775);
    localTextView1.setText(parama.getActivityMoney());
    localTextView2.setText(parama.getActivityDescribe());
    return localView;
  }
  
  private void a()
  {
    this.aq = ((RelativeLayout)findViewById(2131697215));
    this.ap = ((TextView)findViewById(2131697217));
    this.ao = ((TextView)findViewById(2131697204));
    this.an = ((TextView)findViewById(2131697206));
    this.am = ((TextView)findViewById(2131697202));
    this.aj = ((LinearLayout)findViewById(2131697214));
    this.X = ((TextView)findViewById(2131697207));
    this.P = ((LinearLayout)findViewById(2131692469));
    this.V = ((TextView)findViewById(2131697219));
    this.U = ((TextView)findViewById(2131697222));
    this.ab = ((RelativeLayout)findViewById(2131697220));
    this.S = ((TextView)findViewById(2131697203));
    this.aa = ((RelativeLayout)findViewById(2131692414));
    this.Y = ((SimpleDraweeView)findViewById(2131697199));
    ((GenericDraweeHierarchy)this.Y.getHierarchy()).setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
    ((GenericDraweeHierarchy)this.Y.getHierarchy()).setPlaceholderImage(2130838353);
    this.Q = ((TextView)findViewById(2131697200));
    this.R = ((TextView)findViewById(2131697201));
    this.W = ((TextView)findViewById(2131692419));
    String str;
    if (this.O != null)
    {
      this.aa.setVisibility(0);
      this.Q.setText(this.O.getHouse_name());
      if (this.O.getIs_duanzu() == 1)
      {
        str = this.O.getHouse_price() + "元/天";
        this.R.setText(str);
        this.am.setVisibility(8);
        this.am.setText("(" + this.O.getHouse_price_desc() + ")");
        if (ae.notNull(this.O.getHouse_area())) {
          this.W.setText(this.O.getHouse_area() + "m²");
        }
        if ((this.O != null) && (this.O.getHouse_photos_small() != null) && (this.O.getHouse_photos_small().size() > 0)) {
          this.Y.setController(c.frescoController((String)this.O.getHouse_photos_small().get(0)));
        }
      }
    }
    for (;;)
    {
      this.H = ((TextView)findViewById(2131697223));
      this.G = ((TextView)findViewById(2131697210));
      this.F = ((TextView)findViewById(2131697208));
      this.E = ((TextView)findViewById(2131697205));
      this.f = ((ImageView)findViewById(2131690105));
      this.r = ((TextView)findViewById(2131689533));
      this.r.setText("款项详情");
      this.s = ((TextView)findViewById(2131697212));
      this.D = ((Button)findViewById(2131697197));
      b();
      a(new ArrayList());
      if (ae.notNull(this.Z))
      {
        this.S.setText("首次款项     (总额计算结果不包含上份合同押金)");
        this.D.setText("确认合同");
      }
      return;
      if (this.O.getIs_duanzu() != 0) {
        break;
      }
      str = this.O.getHouse_price() + "元/月";
      this.R.setText(str);
      break;
      this.aa.setVisibility(8);
    }
  }
  
  private void a(Handler paramHandler, String paramString1, String paramString2, String paramString3)
  {
    d.getRaSignInfo(this, paramHandler, paramString1, paramString2, paramString3, this.ac, this.Z);
  }
  
  private void a(List<SignedPayServiceDataEntity> paramList)
  {
    this.x = View.inflate(this.w, 2130905014, null);
    this.g = ((TextView)this.x.findViewById(2131697190));
    this.v = ((ListViewForScrollView)this.x.findViewById(2131697189));
    TextView localTextView1 = (TextView)this.x.findViewById(2131697187);
    TextView localTextView2 = (TextView)this.x.findViewById(2131697188);
    this.z = new i(this.w, paramList);
    this.v.setAdapter(this.z);
    this.z.setPrice(this);
    localTextView2.setOnClickListener(this.e);
    localTextView1.setOnClickListener(this.e);
  }
  
  private void b()
  {
    this.y = View.inflate(this.w, 2130905018, null);
    this.as = ((LinearLayout)this.y.findViewById(2131697226));
    this.at = ((TextView)this.y.findViewById(2131697227));
    this.t = ((TextView)this.y.findViewById(2131697228));
    this.u = ((TextView)this.y.findViewById(2131697229));
    this.B = ((EditText)this.y.findViewById(2131697225));
    this.A = new Dialog(this.w, 2131427781);
    this.A.setContentView(this.y);
    this.t.setOnClickListener(this.e);
    this.u.setOnClickListener(this.e);
  }
  
  private void d(String paramString)
  {
    if (ae.isNull(paramString)) {
      return;
    }
    View localView = View.inflate(this.w, 2130905135, null);
    ((TextView)localView.findViewById(2131692469)).setText(paramString);
    this.P.addView(localView);
  }
  
  private void e()
  {
    Object localObject;
    View localView;
    if (this.al)
    {
      if ((this.ai != null) && (this.g != null) && (ae.notNull(this.ai.getActivityNote()))) {
        this.g.setText(this.ai.getActivityNote());
      }
      this.ak = new PopupWindow(this.x, -1, -1, true);
      this.ak.setContentView(this.x);
      this.ak.setOutsideTouchable(false);
      this.ak.setFocusable(true);
      localObject = new ColorDrawable(-1342177280);
      this.ak.setBackgroundDrawable((Drawable)localObject);
      localObject = this.ak;
      localView = findViewById(2131697196);
      if (!(localObject instanceof PopupWindow)) {
        ((PopupWindow)localObject).showAtLocation(localView, 81, 0, 0);
      }
    }
    for (this.al = false;; this.al = true)
    {
      this.v.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        @com.growingio.android.sdk.instrumentation.Instrumented
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          if ("1".equals(((SignedPayServiceDataEntity)PayInformationActivity.a(PayInformationActivity.this).getmList().get(paramAnonymousInt)).getIs_default_check())) {
            ((SignedPayServiceDataEntity)PayInformationActivity.a(PayInformationActivity.this).getmList().get(paramAnonymousInt)).setIs_default_check("0");
          }
          for (;;)
          {
            PayInformationActivity.a(PayInformationActivity.this).notifyDataSetChanged();
            return;
            ((SignedPayServiceDataEntity)PayInformationActivity.a(PayInformationActivity.this).getmList().get(paramAnonymousInt)).setIs_default_check("1");
          }
        }
      });
      return;
      VdsAgent.showAtLocation((PopupWindow)localObject, localView, 81, 0, 0);
      break;
      this.ak.dismiss();
    }
  }
  
  private void e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      String[] arrayOfString;
      do
      {
        return;
        if (ApplicationEx.c.k == null) {
          ApplicationEx.c.k = ClientForAndroid.getInstance(this);
        }
        arrayOfString = ApplicationEx.c.k.FilterCert("", "", "", 0, 0);
      } while (arrayOfString.length <= 0);
      paramString = ApplicationEx.c.k.SignMessage(paramString, arrayOfString[0], "SHA1", 1);
      if (TextUtils.isEmpty(paramString))
      {
        d.errorLog(this, "签名失败", "失败原因是:" + ApplicationEx.c.k.GetLastErrInfo());
        return;
      }
    } while (this.O == null);
    d.signature(this, this.ar, this.O.getHouse_code(), this.O.getHouse_id(), this.O.getHouse_type(), paramString, this.ac, this.Z);
  }
  
  private void f()
  {
    this.f.setOnClickListener(this.e);
    this.s.setOnClickListener(this.e);
    this.D.setOnClickListener(this.e);
    this.ap.setOnClickListener(this.e);
  }
  
  public void checkActivity()
  {
    if (this.z != null)
    {
      Iterator localIterator = this.z.getmList().iterator();
      float f1 = 0.0F;
      if (localIterator.hasNext())
      {
        SignedPayServiceDataEntity localSignedPayServiceDataEntity = (SignedPayServiceDataEntity)localIterator.next();
        if (!"1".equals(localSignedPayServiceDataEntity.getIs_default_check())) {
          break label96;
        }
        float f2 = localSignedPayServiceDataEntity.getPrice().getPrivilege_price();
        float f3 = localSignedPayServiceDataEntity.getDeposit().getPrivilege_price();
        f1 = localSignedPayServiceDataEntity.getCommission().getPrivilege_price() + (f1 + f2 + f3);
      }
    }
    label96:
    for (;;)
    {
      break;
      return;
    }
  }
  
  public void getYanzhengmaBitmap()
  {
    new Thread(new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: new 38	java/util/ArrayList
        //   3: dup
        //   4: invokespecial 39	java/util/ArrayList:<init>	()V
        //   7: astore_2
        //   8: new 41	java/util/HashMap
        //   11: dup
        //   12: invokespecial 42	java/util/HashMap:<init>	()V
        //   15: pop
        //   16: aload_0
        //   17: getfield 26	com/ziroom/ziroomcustomer/signed/PayInformationActivity$3:a	Lcom/ziroom/ziroomcustomer/signed/PayInformationActivity;
        //   20: invokestatic 46	com/ziroom/ziroomcustomer/signed/PayInformationActivity:i	(Lcom/ziroom/ziroomcustomer/signed/PayInformationActivity;)Ljava/lang/String;
        //   23: invokestatic 52	com/ziroom/ziroomcustomer/e/g:buildCaptchaImage	(Ljava/lang/String;)Ljava/util/Map;
        //   26: astore 4
        //   28: new 54	java/lang/StringBuilder
        //   31: dup
        //   32: invokespecial 55	java/lang/StringBuilder:<init>	()V
        //   35: getstatic 61	com/ziroom/ziroomcustomer/e/q:s	Ljava/lang/String;
        //   38: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   41: getstatic 70	com/ziroom/ziroomcustomer/e/e$h:z	Ljava/lang/String;
        //   44: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   47: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   50: astore_3
        //   51: aload 4
        //   53: ifnull +8 -> 61
        //   56: aload 4
        //   58: invokestatic 78	com/ziroom/ziroomcustomer/e/g:appendCommenParams	(Ljava/util/Map;)V
        //   61: aload 4
        //   63: ifnull +96 -> 159
        //   66: aload 4
        //   68: invokeinterface 84 1 0
        //   73: ifne +86 -> 159
        //   76: aload 4
        //   78: invokeinterface 88 1 0
        //   83: invokeinterface 94 1 0
        //   88: astore 4
        //   90: aload 4
        //   92: invokeinterface 99 1 0
        //   97: ifeq +62 -> 159
        //   100: aload 4
        //   102: invokeinterface 103 1 0
        //   107: checkcast 105	java/util/Map$Entry
        //   110: astore 5
        //   112: aload 5
        //   114: invokeinterface 108 1 0
        //   119: ifnull -29 -> 90
        //   122: aload_2
        //   123: new 110	org/apache/http/message/BasicNameValuePair
        //   126: dup
        //   127: aload 5
        //   129: invokeinterface 113 1 0
        //   134: checkcast 115	java/lang/String
        //   137: aload 5
        //   139: invokeinterface 108 1 0
        //   144: invokevirtual 116	java/lang/Object:toString	()Ljava/lang/String;
        //   147: invokespecial 119	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
        //   150: invokeinterface 125 2 0
        //   155: pop
        //   156: goto -66 -> 90
        //   159: new 127	org/apache/http/client/methods/HttpPost
        //   162: dup
        //   163: aload_3
        //   164: invokespecial 130	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
        //   167: astore 4
        //   169: ldc -124
        //   171: aload_3
        //   172: invokestatic 137	com/ziroom/ziroomcustomer/util/u:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   175: new 139	org/apache/http/impl/client/DefaultHttpClient
        //   178: dup
        //   179: invokespecial 140	org/apache/http/impl/client/DefaultHttpClient:<init>	()V
        //   182: astore_3
        //   183: aload 4
        //   185: new 142	org/apache/http/client/entity/UrlEncodedFormEntity
        //   188: dup
        //   189: aload_2
        //   190: ldc -112
        //   192: invokespecial 147	org/apache/http/client/entity/UrlEncodedFormEntity:<init>	(Ljava/util/List;Ljava/lang/String;)V
        //   195: invokevirtual 151	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
        //   198: aload_3
        //   199: instanceof 153
        //   202: ifne +145 -> 347
        //   205: aload_3
        //   206: aload 4
        //   208: invokevirtual 157	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
        //   211: astore_2
        //   212: aload_2
        //   213: invokeinterface 163 1 0
        //   218: invokeinterface 169 1 0
        //   223: istore_1
        //   224: aload_0
        //   225: getfield 26	com/ziroom/ziroomcustomer/signed/PayInformationActivity$3:a	Lcom/ziroom/ziroomcustomer/signed/PayInformationActivity;
        //   228: invokevirtual 172	com/ziroom/ziroomcustomer/signed/PayInformationActivity:dismissProgress	()V
        //   231: iload_1
        //   232: sipush 200
        //   235: if_icmpne +125 -> 360
        //   238: aload_2
        //   239: invokeinterface 176 1 0
        //   244: invokeinterface 182 1 0
        //   249: astore_2
        //   250: aload_3
        //   251: invokevirtual 186	org/apache/http/impl/client/DefaultHttpClient:getCookieStore	()Lorg/apache/http/client/CookieStore;
        //   254: invokeinterface 192 1 0
        //   259: astore_3
        //   260: iconst_0
        //   261: istore_1
        //   262: iload_1
        //   263: aload_3
        //   264: invokeinterface 195 1 0
        //   269: if_icmpge +49 -> 318
        //   272: ldc -59
        //   274: aload_3
        //   275: iload_1
        //   276: invokeinterface 201 2 0
        //   281: checkcast 203	org/apache/http/cookie/Cookie
        //   284: invokeinterface 206 1 0
        //   289: invokevirtual 209	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   292: ifeq +147 -> 439
        //   295: aload_0
        //   296: getfield 26	com/ziroom/ziroomcustomer/signed/PayInformationActivity$3:a	Lcom/ziroom/ziroomcustomer/signed/PayInformationActivity;
        //   299: aload_3
        //   300: iload_1
        //   301: invokeinterface 201 2 0
        //   306: checkcast 203	org/apache/http/cookie/Cookie
        //   309: invokeinterface 211 1 0
        //   314: invokestatic 215	com/ziroom/ziroomcustomer/signed/PayInformationActivity:c	(Lcom/ziroom/ziroomcustomer/signed/PayInformationActivity;Ljava/lang/String;)Ljava/lang/String;
        //   317: pop
        //   318: aload_0
        //   319: getfield 26	com/ziroom/ziroomcustomer/signed/PayInformationActivity$3:a	Lcom/ziroom/ziroomcustomer/signed/PayInformationActivity;
        //   322: aload_2
        //   323: invokestatic 221	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
        //   326: invokestatic 224	com/ziroom/ziroomcustomer/signed/PayInformationActivity:a	(Lcom/ziroom/ziroomcustomer/signed/PayInformationActivity;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
        //   329: pop
        //   330: aload_2
        //   331: invokevirtual 229	java/io/InputStream:close	()V
        //   334: aload_0
        //   335: getfield 26	com/ziroom/ziroomcustomer/signed/PayInformationActivity$3:a	Lcom/ziroom/ziroomcustomer/signed/PayInformationActivity;
        //   338: invokestatic 233	com/ziroom/ziroomcustomer/signed/PayInformationActivity:g	(Lcom/ziroom/ziroomcustomer/signed/PayInformationActivity;)Landroid/os/Handler;
        //   341: iconst_5
        //   342: invokevirtual 239	android/os/Handler:sendEmptyMessage	(I)Z
        //   345: pop
        //   346: return
        //   347: aload_3
        //   348: checkcast 153	org/apache/http/client/HttpClient
        //   351: aload 4
        //   353: invokestatic 244	com/mato/sdk/instrumentation/ApacheHttpClientInstrumentation:execute	(Lorg/apache/http/client/HttpClient;Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
        //   356: astore_2
        //   357: goto -145 -> 212
        //   360: aload_0
        //   361: getfield 26	com/ziroom/ziroomcustomer/signed/PayInformationActivity$3:a	Lcom/ziroom/ziroomcustomer/signed/PayInformationActivity;
        //   364: new 13	com/ziroom/ziroomcustomer/signed/PayInformationActivity$3$1
        //   367: dup
        //   368: aload_0
        //   369: invokespecial 247	com/ziroom/ziroomcustomer/signed/PayInformationActivity$3$1:<init>	(Lcom/ziroom/ziroomcustomer/signed/PayInformationActivity$3;)V
        //   372: invokevirtual 251	com/ziroom/ziroomcustomer/signed/PayInformationActivity:runOnUiThread	(Ljava/lang/Runnable;)V
        //   375: return
        //   376: astore_2
        //   377: aload_0
        //   378: getfield 26	com/ziroom/ziroomcustomer/signed/PayInformationActivity$3:a	Lcom/ziroom/ziroomcustomer/signed/PayInformationActivity;
        //   381: new 15	com/ziroom/ziroomcustomer/signed/PayInformationActivity$3$2
        //   384: dup
        //   385: aload_0
        //   386: invokespecial 252	com/ziroom/ziroomcustomer/signed/PayInformationActivity$3$2:<init>	(Lcom/ziroom/ziroomcustomer/signed/PayInformationActivity$3;)V
        //   389: invokevirtual 251	com/ziroom/ziroomcustomer/signed/PayInformationActivity:runOnUiThread	(Ljava/lang/Runnable;)V
        //   392: aload_2
        //   393: invokevirtual 255	org/apache/http/client/ClientProtocolException:printStackTrace	()V
        //   396: return
        //   397: astore_2
        //   398: aload_0
        //   399: getfield 26	com/ziroom/ziroomcustomer/signed/PayInformationActivity$3:a	Lcom/ziroom/ziroomcustomer/signed/PayInformationActivity;
        //   402: new 19	com/ziroom/ziroomcustomer/signed/PayInformationActivity$3$4
        //   405: dup
        //   406: aload_0
        //   407: invokespecial 256	com/ziroom/ziroomcustomer/signed/PayInformationActivity$3$4:<init>	(Lcom/ziroom/ziroomcustomer/signed/PayInformationActivity$3;)V
        //   410: invokevirtual 251	com/ziroom/ziroomcustomer/signed/PayInformationActivity:runOnUiThread	(Ljava/lang/Runnable;)V
        //   413: aload_2
        //   414: invokevirtual 257	java/lang/Exception:printStackTrace	()V
        //   417: return
        //   418: astore_2
        //   419: aload_0
        //   420: getfield 26	com/ziroom/ziroomcustomer/signed/PayInformationActivity$3:a	Lcom/ziroom/ziroomcustomer/signed/PayInformationActivity;
        //   423: new 17	com/ziroom/ziroomcustomer/signed/PayInformationActivity$3$3
        //   426: dup
        //   427: aload_0
        //   428: invokespecial 258	com/ziroom/ziroomcustomer/signed/PayInformationActivity$3$3:<init>	(Lcom/ziroom/ziroomcustomer/signed/PayInformationActivity$3;)V
        //   431: invokevirtual 251	com/ziroom/ziroomcustomer/signed/PayInformationActivity:runOnUiThread	(Ljava/lang/Runnable;)V
        //   434: aload_2
        //   435: invokevirtual 259	java/io/IOException:printStackTrace	()V
        //   438: return
        //   439: iload_1
        //   440: iconst_1
        //   441: iadd
        //   442: istore_1
        //   443: goto -181 -> 262
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	446	0	this	3
        //   223	220	1	i	int
        //   7	350	2	localObject1	Object
        //   376	17	2	localClientProtocolException	org.apache.http.client.ClientProtocolException
        //   397	17	2	localException	Exception
        //   418	17	2	localIOException	java.io.IOException
        //   50	298	3	localObject2	Object
        //   26	326	4	localObject3	Object
        //   110	28	5	localEntry	java.util.Map.Entry
        // Exception table:
        //   from	to	target	type
        //   198	212	376	org/apache/http/client/ClientProtocolException
        //   212	231	376	org/apache/http/client/ClientProtocolException
        //   238	260	376	org/apache/http/client/ClientProtocolException
        //   262	318	376	org/apache/http/client/ClientProtocolException
        //   318	346	376	org/apache/http/client/ClientProtocolException
        //   347	357	376	org/apache/http/client/ClientProtocolException
        //   360	375	376	org/apache/http/client/ClientProtocolException
        //   159	198	397	java/lang/Exception
        //   198	212	397	java/lang/Exception
        //   212	231	397	java/lang/Exception
        //   238	260	397	java/lang/Exception
        //   262	318	397	java/lang/Exception
        //   318	346	397	java/lang/Exception
        //   347	357	397	java/lang/Exception
        //   360	375	397	java/lang/Exception
        //   377	396	397	java/lang/Exception
        //   419	438	397	java/lang/Exception
        //   198	212	418	java/io/IOException
        //   212	231	418	java/io/IOException
        //   238	260	418	java/io/IOException
        //   262	318	418	java/io/IOException
        //   318	346	418	java/io/IOException
        //   347	357	418	java/io/IOException
        //   360	375	418	java/io/IOException
      }
    }).start();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == 99) {
      if (!ae.isNull(paramIntent.getStringExtra("couponCode"))) {
        break label68;
      }
    }
    label68:
    for (String str = this.c;; str = paramIntent.getStringExtra("couponCode"))
    {
      this.b = str;
      if (ae.notNull(paramIntent.getStringExtra("couponCode")))
      {
        this.b = paramIntent.getStringExtra("couponCode");
        setTotalPrice(this.d, this.b);
      }
      return;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130905017);
    this.w = this;
    ApplicationEx.c.addActivity(this);
    this.ah = getIntent().getStringExtra("cityCode");
    this.M = getIntent().getStringExtra("contract_code");
    this.Z = getIntent().getStringExtra("old_contract_code");
    this.O = ((HouseDetail)getIntent().getSerializableExtra("detail"));
    if (this.Z != null) {
      this.ac = "1";
    }
    a();
    f();
    if (!ah.checkNet(getApplicationContext()))
    {
      g.textToast(this, "网络请求失败，请检查您的网络设置", 0);
      return;
    }
    if (this.O == null) {
      this.O = new HouseDetail();
    }
    d.getPayData(this.ar, this.O.getHouse_code(), this.O.getHouse_id(), this.O.getHouse_type(), this.ac, this.Z, this.M, "", "");
    showProgress("");
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    ApplicationEx.c.removeActivity(this);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    if ((this.ak != null) && (this.ak.isShowing()))
    {
      this.ak.dismiss();
      this.al = true;
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onSign()
  {
    Object localObject2 = LayoutInflater.from(this.w).inflate(2130905132, null);
    this.N = new Dialog(this.w, 2131427781);
    this.N.setContentView((View)localObject2);
    this.T = ((TextView)((View)localObject2).findViewById(2131697541));
    this.ad = ((ImageView)((View)localObject2).findViewById(2131697540));
    this.C = ((EditText)((View)localObject2).findViewById(2131694428));
    Object localObject1 = (TextView)((View)localObject2).findViewById(2131697195);
    localObject2 = (TextView)((View)localObject2).findViewById(2131697542);
    this.ad.setOnClickListener(new View.OnClickListener()
    {
      @com.growingio.android.sdk.instrumentation.Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        PayInformationActivity.a(PayInformationActivity.this, null);
        PayInformationActivity.this.showProgress("");
        PayInformationActivity.this.getYanzhengmaBitmap();
      }
    });
    ((TextView)localObject2).setOnClickListener(this.e);
    ((TextView)localObject1).setOnClickListener(this.e);
    this.af = null;
    localObject1 = this.N;
    if (!(localObject1 instanceof Dialog)) {
      ((Dialog)localObject1).show();
    }
    for (;;)
    {
      getYanzhengmaBitmap();
      return;
      VdsAgent.showDialog((Dialog)localObject1);
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    Drawable localDrawable = this.Y.getDrawable();
    if (localDrawable != null) {
      localDrawable.setCallback(null);
    }
    this.Y.setImageDrawable(null);
    this.Y.setBackgroundDrawable(null);
  }
  
  public void setTotalPrice(String paramString1, String paramString2)
  {
    showProgress("");
    d.getPayData(this.ar, this.O.getHouse_code(), this.O.getHouse_id(), this.O.getHouse_type(), this.ac, this.Z, this.M, paramString1, paramString2);
  }
  
  public void setView(SignedPayDataEntity paramSignedPayDataEntity)
  {
    this.ao.setText("租金" + paramSignedPayDataEntity.getRentDescribe());
    if (ae.notNull(paramSignedPayDataEntity.getRentPeriodDes()))
    {
      this.an.setText("x " + paramSignedPayDataEntity.getRentPeriodDes());
      this.E.setText("￥" + paramSignedPayDataEntity.getRentMoneyCount());
      this.F.setText("￥" + paramSignedPayDataEntity.getDeposit() + "");
      this.G.setText("￥" + paramSignedPayDataEntity.getCommission() + "");
      this.V.setText("￥" + paramSignedPayDataEntity.getDiscountCommission() + "");
      if ((ae.notNull(this.Z)) && (paramSignedPayDataEntity.getOldIsDeposit() == 1)) {
        break label327;
      }
    }
    Object localObject;
    for (;;)
    {
      this.aj.removeAllViews();
      if (paramSignedPayDataEntity.getActivityPayModel() == null) {
        break label488;
      }
      localObject = paramSignedPayDataEntity.getActivityPayModel();
      if ((((a)localObject).getActivityDetailList() == null) || (((a)localObject).getActivityDetailList().size() <= 0)) {
        break label340;
      }
      Iterator localIterator = ((a)localObject).getActivityDetailList().iterator();
      while (localIterator.hasNext())
      {
        a.a locala = (a.a)localIterator.next();
        this.aj.setVisibility(0);
        this.aj.addView(a(locala));
      }
      this.an.setVisibility(8);
      break;
      label327:
      this.X.setText("押金 (原合同押金转款)");
    }
    label340:
    this.s.setText("已选择" + ((a)localObject).getActivityCount() + "项");
    for (;;)
    {
      if (paramSignedPayDataEntity.getReserveDeposit() > 0.0F)
      {
        this.ab.setVisibility(0);
        this.U.setText("-" + paramSignedPayDataEntity.getReserveDeposit() + "");
      }
      this.H.setText(paramSignedPayDataEntity.getCountMoney());
      this.P.removeAllViews();
      if (paramSignedPayDataEntity.getPromptTags() == null) {
        break;
      }
      localObject = paramSignedPayDataEntity.getPromptTags().iterator();
      while (((Iterator)localObject).hasNext()) {
        d((String)((Iterator)localObject).next());
      }
      label488:
      this.s.setTextColor(Color.parseColor("#ffa000"));
      this.s.setText("请选择");
    }
    if (ae.notNull(paramSignedPayDataEntity.getCouponView())) {
      this.ap.setText(paramSignedPayDataEntity.getCouponView());
    }
    if ("1".equals(paramSignedPayDataEntity.getIsShowCoupon()))
    {
      this.aq.setVisibility(0);
      return;
    }
    this.aq.setVisibility(8);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/PayInformationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */