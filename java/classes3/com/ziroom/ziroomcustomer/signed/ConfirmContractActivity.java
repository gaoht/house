package com.ziroom.ziroomcustomer.signed;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.fastjson.a;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.itrus.raapi.implement.ClientForAndroid;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.b;
import com.ziroom.ziroomcustomer.activity.HouseBillInfoActivity;
import com.ziroom.ziroomcustomer.activity.NewLeaseInfoActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.e.m;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.model.HouseDetail;
import com.ziroom.ziroomcustomer.my.CreditWebActivity;
import com.ziroom.ziroomcustomer.reserve.c;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.util.w;
import java.util.Map;

public class ConfirmContractActivity
  extends BaseActivity
{
  private String A;
  private String B;
  private String C = "0";
  private float D = 0.0F;
  private float E = 0.0F;
  private String F;
  private String G;
  private String H;
  private String I = "0";
  private String J;
  private Button K;
  private String L;
  private ImageView M;
  private String N;
  private LinearLayout O;
  private TextView P;
  private TextView Q;
  private c R;
  private String S;
  private d T;
  private String U = "";
  private String V;
  private int W;
  private Handler X = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 69697: 
        paramAnonymousMessage = (l)paramAnonymousMessage.obj;
        if (paramAnonymousMessage.getSuccess().booleanValue())
        {
          ConfirmContractActivity.a(ConfirmContractActivity.this, paramAnonymousMessage.getObject().toString());
          ConfirmContractActivity.b(ConfirmContractActivity.this, ConfirmContractActivity.g(ConfirmContractActivity.this));
          return;
        }
        ConfirmContractActivity.this.showToast(paramAnonymousMessage.getMessage());
        ConfirmContractActivity.this.dismissProgress();
        return;
      case 69698: 
        ConfirmContractActivity.this.dismissProgress();
        paramAnonymousMessage = (l)paramAnonymousMessage.obj;
        if (paramAnonymousMessage.getSuccess().booleanValue())
        {
          ConfirmContractActivity.this.onSign();
          return;
        }
        com.freelxl.baselibrary.f.g.textToast(ConfirmContractActivity.this, "无纸化验签失败," + paramAnonymousMessage.getMessage() + "请稍后重试!!!", 1);
        com.ziroom.ziroomcustomer.e.d.errorLog(ConfirmContractActivity.this, "验签失败,", "证书导入失败!!!验签失败," + paramAnonymousMessage.getMessage());
        return;
      case 69667: 
        ConfirmContractActivity.this.dismissProgress();
        paramAnonymousMessage = (l)paramAnonymousMessage.obj;
        if (paramAnonymousMessage.getSuccess().booleanValue())
        {
          if (ConfirmContractActivity.h(ConfirmContractActivity.this) != null) {
            ConfirmContractActivity.h(ConfirmContractActivity.this).dismiss();
          }
          if ("2".equals(ConfirmContractActivity.i(ConfirmContractActivity.this).getContractStrategy()))
          {
            paramAnonymousMessage = new Intent(ConfirmContractActivity.c(ConfirmContractActivity.this), NewLeaseInfoActivity.class);
            paramAnonymousMessage.putExtra("contract_code", ConfirmContractActivity.f(ConfirmContractActivity.this));
            paramAnonymousMessage.putExtra("className", "ConfirmContractActivity");
            ConfirmContractActivity.this.startActivity(paramAnonymousMessage);
            ConfirmContractActivity.this.finish();
            return;
          }
          if ("1".equals(ConfirmContractActivity.i(ConfirmContractActivity.this).getIsZWhite()))
          {
            paramAnonymousMessage = new Intent(ConfirmContractActivity.c(ConfirmContractActivity.this), LoanInfoActivity.class);
            paramAnonymousMessage.putExtra("contract_code", ConfirmContractActivity.f(ConfirmContractActivity.this));
            paramAnonymousMessage.putExtra("old_contract_code", ConfirmContractActivity.j(ConfirmContractActivity.this));
            paramAnonymousMessage.putExtra("detail", ConfirmContractActivity.k(ConfirmContractActivity.this));
            ConfirmContractActivity.this.startActivity(paramAnonymousMessage);
            return;
          }
          paramAnonymousMessage = new Intent(ConfirmContractActivity.c(ConfirmContractActivity.this), HouseBillInfoActivity.class);
          paramAnonymousMessage.putExtra("uniqueCode", ConfirmContractActivity.f(ConfirmContractActivity.this));
          paramAnonymousMessage.putExtra("period", "1");
          paramAnonymousMessage.putExtra("payType", "fz");
          if (ConfirmContractActivity.j(ConfirmContractActivity.this) != null) {
            paramAnonymousMessage.putExtra("old_contract_code", ConfirmContractActivity.j(ConfirmContractActivity.this));
          }
          paramAnonymousMessage.putExtra("mContentText", "倒计时结束之前，您可以在“我的合同”里找到待支付合同进行支付。");
          ConfirmContractActivity.this.startActivityAndFinish(paramAnonymousMessage);
          return;
        }
        ConfirmContractActivity.this.showToast(paramAnonymousMessage.getMessage());
        return;
      case 5: 
        ConfirmContractActivity.m(ConfirmContractActivity.this).setImageBitmap(ConfirmContractActivity.l(ConfirmContractActivity.this));
        ConfirmContractActivity.n(ConfirmContractActivity.this).setVisibility(8);
        return;
      }
      ConfirmContractActivity.this.dismissProgress();
      paramAnonymousMessage = (l)paramAnonymousMessage.obj;
      if (paramAnonymousMessage.getSuccess().booleanValue())
      {
        ConfirmContractActivity.a(ConfirmContractActivity.this, (d)paramAnonymousMessage.getObject());
        ConfirmContractActivity.b(ConfirmContractActivity.this, ConfirmContractActivity.i(ConfirmContractActivity.this));
        return;
      }
      ConfirmContractActivity.this.showToast(paramAnonymousMessage.getMessage());
    }
  };
  private View Y;
  private TextView Z;
  View.OnClickListener a = new View.OnClickListener()
  {
    @com.growingio.android.sdk.instrumentation.Instrumented
    public void onClick(View paramAnonymousView)
    {
      float f = 0.0F;
      VdsAgent.onClick(this, paramAnonymousView);
      switch (paramAnonymousView.getId())
      {
      default: 
      case 2131690105: 
      case 2131692413: 
      case 2131697195: 
      case 2131697542: 
      case 2131693302: 
        do
        {
          return;
          ConfirmContractActivity.this.finish();
          return;
          ConfirmContractActivity.this.finish();
          return;
          ConfirmContractActivity.h(ConfirmContractActivity.this).dismiss();
          ConfirmContractActivity.c(ConfirmContractActivity.this, VdsAgent.trackEditTextSilent(ConfirmContractActivity.p(ConfirmContractActivity.this)).toString());
          if ((ConfirmContractActivity.q(ConfirmContractActivity.this).length() == 0) || (ConfirmContractActivity.q(ConfirmContractActivity.this) == null))
          {
            com.freelxl.baselibrary.f.g.textToast(ConfirmContractActivity.this, "验证码不能为空", 0);
            return;
          }
          ConfirmContractActivity.this.showProgress("");
          if (ConfirmContractActivity.r(ConfirmContractActivity.this) != 2)
          {
            if (ConfirmContractActivity.k(ConfirmContractActivity.this) != null)
            {
              if (ae.notNull(ConfirmContractActivity.s(ConfirmContractActivity.this))) {
                f = Float.parseFloat(ConfirmContractActivity.s(ConfirmContractActivity.this));
              }
              com.ziroom.ziroomcustomer.e.d.setPaycontract(ConfirmContractActivity.c(ConfirmContractActivity.this), ConfirmContractActivity.t(ConfirmContractActivity.this), ConfirmContractActivity.k(ConfirmContractActivity.this).getHouse_code(), ConfirmContractActivity.k(ConfirmContractActivity.this).getHouse_id(), ConfirmContractActivity.k(ConfirmContractActivity.this).getHouse_type(), ConfirmContractActivity.u(ConfirmContractActivity.this), ConfirmContractActivity.f(ConfirmContractActivity.this), ConfirmContractActivity.v(ConfirmContractActivity.this) + ConfirmContractActivity.w(ConfirmContractActivity.this), f, ConfirmContractActivity.x(ConfirmContractActivity.this), ConfirmContractActivity.q(ConfirmContractActivity.this), ConfirmContractActivity.y(ConfirmContractActivity.this), ConfirmContractActivity.j(ConfirmContractActivity.this), ConfirmContractActivity.z(ConfirmContractActivity.this));
            }
            w.onEvent(ConfirmContractActivity.c(ConfirmContractActivity.this), "signup_confirmation_confirm");
            return;
          }
          ConfirmContractActivity.d(ConfirmContractActivity.this, q.s + e.m.f);
          paramAnonymousView = com.ziroom.ziroomcustomer.e.g.buildSetreserveData(ConfirmContractActivity.d(ConfirmContractActivity.this), ConfirmContractActivity.e(ConfirmContractActivity.this).getUserPhone(), ConfirmContractActivity.e(ConfirmContractActivity.this).getUserName(), ConfirmContractActivity.e(ConfirmContractActivity.this).getCertType(), ConfirmContractActivity.e(ConfirmContractActivity.this).getCertNum(), ConfirmContractActivity.q(ConfirmContractActivity.this));
          j.setReservationOrderText(ConfirmContractActivity.c(ConfirmContractActivity.this), new ConfirmContractActivity.a(ConfirmContractActivity.this), paramAnonymousView, false, ConfirmContractActivity.b(ConfirmContractActivity.this));
          return;
          ConfirmContractActivity.h(ConfirmContractActivity.this).dismiss();
          return;
          if (ConfirmContractActivity.r(ConfirmContractActivity.this) == 2) {
            break;
          }
          if (ConfirmContractActivity.w(ConfirmContractActivity.this) == 0.0F) {
            ConfirmContractActivity.e(ConfirmContractActivity.this, "");
          }
        } while (ConfirmContractActivity.i(ConfirmContractActivity.this) == null);
        if ("2".equals(ConfirmContractActivity.i(ConfirmContractActivity.this).getContractStrategy()))
        {
          com.ziroom.commonlibrary.widget.unifiedziroom.d.newBuilder(ConfirmContractActivity.this).setContent("您确认签订此合同么？").setTitle("确认合同").setButtonText("取消", "确定").setOnConfirmClickListener(new d.b()
          {
            public void onLeftClick(View paramAnonymous2View) {}
            
            public void onRightClick(View paramAnonymous2View)
            {
              ConfirmContractActivity.this.showProgress("");
              ConfirmContractActivity.this.onSign();
            }
          }).show();
          return;
        }
        com.ziroom.commonlibrary.widget.unifiedziroom.d.newBuilder(ConfirmContractActivity.this).setContent("您确认签订此合同么？").setTitle("确认合同").setButtonText("取消", "确定").setOnConfirmClickListener(new d.b()
        {
          public void onLeftClick(View paramAnonymous2View) {}
          
          public void onRightClick(View paramAnonymous2View)
          {
            ConfirmContractActivity.this.showProgress("");
            ConfirmContractActivity.a(ConfirmContractActivity.this, ConfirmContractActivity.t(ConfirmContractActivity.this), ConfirmContractActivity.k(ConfirmContractActivity.this).getHouse_code(), ConfirmContractActivity.k(ConfirmContractActivity.this).getHouse_id(), ConfirmContractActivity.k(ConfirmContractActivity.this).getHouse_type());
          }
        }).show();
        return;
        ConfirmContractActivity.this.onSign();
        ConfirmContractActivity.this.showProgress("");
        return;
      }
      ConfirmContractActivity.o(ConfirmContractActivity.this).dismiss();
      paramAnonymousView = new Intent(ConfirmContractActivity.this, CreditWebActivity.class);
      paramAnonymousView.putExtra("title", "使用规则");
      paramAnonymousView.putExtra("url", "http://www.ziroom.com/zhuanti/2016/qfgz/index.html");
      ConfirmContractActivity.this.startActivity(paramAnonymousView);
    }
  };
  private TextView aa;
  private TextView ab;
  private TextView ac;
  private Dialog ad;
  private String ae;
  private HouseDetail b;
  private Context c;
  private Dialog d;
  private ImageView e;
  private EditText f;
  private TextView g;
  private TextView r;
  private TextView s;
  private TextView t;
  private TextView u;
  private TextView v;
  private TextView w;
  private TextView x;
  private TextView y;
  private Bitmap z;
  
  private void a()
  {
    this.K.setOnClickListener(this.a);
    this.M.setOnClickListener(this.a);
  }
  
  private void a(Handler paramHandler, String paramString1, String paramString2, String paramString3)
  {
    com.ziroom.ziroomcustomer.e.d.getRaSignInfo(this, paramHandler, paramString1, paramString2, paramString3, this.I, this.F);
  }
  
  private void a(d paramd)
  {
    if (paramd == null) {
      return;
    }
    this.x.setText(paramd.getCustomerTip() + "");
    this.y.setText(paramd.getCertTip() + "");
    this.r.setText(paramd.getCustomerName());
    this.t.setText(paramd.getAddress());
    String str = "";
    if ("1".equals(paramd.getIsBlank())) {
      str = "自如白条";
    }
    for (;;)
    {
      this.v.setText(str);
      this.u.setText(paramd.getCertNumber());
      this.s.setText(paramd.getSignDate() + "到" + paramd.getStopDate());
      return;
      if ("1".equals(paramd.getIsZWhite())) {
        str = "自如分期";
      } else if ("1".equals(paramd.getPaymentType())) {
        str = "月付";
      } else if ("3".equals(paramd.getPaymentType())) {
        str = "季付";
      } else if ("6".equals(paramd.getPaymentType())) {
        str = "半年付";
      } else if ("12".equals(paramd.getPaymentType())) {
        str = "年付";
      } else if ("99".equals(paramd.getPaymentType())) {
        str = "一次性付清";
      }
    }
  }
  
  private void b()
  {
    this.x = ((TextView)findViewById(2131693291));
    this.y = ((TextView)findViewById(2131693293));
    this.Q = ((TextView)findViewById(2131689533));
    this.P = ((TextView)findViewById(2131693301));
    this.w = ((TextView)findViewById(2131693299));
    this.O = ((LinearLayout)findViewById(2131693297));
    this.M = ((ImageView)findViewById(2131690105));
    this.r = ((TextView)findViewById(2131693292));
    this.t = ((TextView)findViewById(2131693296));
    this.u = ((TextView)findViewById(2131693294));
    this.s = ((TextView)findViewById(2131693298));
    this.v = ((TextView)findViewById(2131693300));
    this.K = ((Button)findViewById(2131693302));
  }
  
  private void d(String paramString)
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
        com.ziroom.ziroomcustomer.e.d.errorLog(this, "签名失败", "失败原因是:" + ApplicationEx.c.k.GetLastErrInfo());
        return;
      }
      u.d("ikey", "签名成功签名后字符为:" + paramString);
    } while (this.b == null);
    com.ziroom.ziroomcustomer.e.d.signature(this, this.X, this.b.getHouse_code(), this.b.getHouse_id(), this.b.getHouse_type(), paramString, this.I, this.F);
  }
  
  private void e()
  {
    Intent localIntent = getIntent();
    this.V = localIntent.getStringExtra("mCouponCode");
    this.W = getIntent().getIntExtra("type", 0);
    this.N = localIntent.getStringExtra("reservationCode");
    this.b = ((HouseDetail)localIntent.getSerializableExtra("detail"));
    this.I = localIntent.getStringExtra("is_renew");
    this.H = localIntent.getStringExtra("mTotalPrice");
    this.F = localIntent.getStringExtra("old_contract_code");
    this.E = localIntent.getFloatExtra("mkims", 0.0F);
    this.C = localIntent.getStringExtra("voucher");
    this.B = localIntent.getStringExtra("activity");
    this.J = localIntent.getStringExtra("contract_code");
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
        //   7: astore 4
        //   9: new 41	java/util/HashMap
        //   12: dup
        //   13: invokespecial 42	java/util/HashMap:<init>	()V
        //   16: pop
        //   17: aload_0
        //   18: getfield 26	com/ziroom/ziroomcustomer/signed/ConfirmContractActivity$5:a	Lcom/ziroom/ziroomcustomer/signed/ConfirmContractActivity;
        //   21: invokestatic 46	com/ziroom/ziroomcustomer/signed/ConfirmContractActivity:r	(Lcom/ziroom/ziroomcustomer/signed/ConfirmContractActivity;)I
        //   24: iconst_2
        //   25: if_icmpeq +141 -> 166
        //   28: aload_0
        //   29: getfield 26	com/ziroom/ziroomcustomer/signed/ConfirmContractActivity$5:a	Lcom/ziroom/ziroomcustomer/signed/ConfirmContractActivity;
        //   32: invokestatic 50	com/ziroom/ziroomcustomer/signed/ConfirmContractActivity:f	(Lcom/ziroom/ziroomcustomer/signed/ConfirmContractActivity;)Ljava/lang/String;
        //   35: invokestatic 56	com/ziroom/ziroomcustomer/e/g:buildCaptchaImage	(Ljava/lang/String;)Ljava/util/Map;
        //   38: astore_3
        //   39: new 58	java/lang/StringBuilder
        //   42: dup
        //   43: invokespecial 59	java/lang/StringBuilder:<init>	()V
        //   46: getstatic 65	com/ziroom/ziroomcustomer/e/q:s	Ljava/lang/String;
        //   49: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   52: getstatic 74	com/ziroom/ziroomcustomer/e/e$h:z	Ljava/lang/String;
        //   55: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   58: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   61: astore_2
        //   62: aload_3
        //   63: ifnull +7 -> 70
        //   66: aload_3
        //   67: invokestatic 82	com/ziroom/ziroomcustomer/e/g:appendCommenParams	(Ljava/util/Map;)V
        //   70: aload_3
        //   71: ifnull +166 -> 237
        //   74: aload_3
        //   75: invokeinterface 88 1 0
        //   80: ifne +157 -> 237
        //   83: aload_3
        //   84: invokeinterface 92 1 0
        //   89: invokeinterface 98 1 0
        //   94: astore 5
        //   96: aload 5
        //   98: invokeinterface 103 1 0
        //   103: ifeq +134 -> 237
        //   106: aload 5
        //   108: invokeinterface 107 1 0
        //   113: checkcast 109	java/util/Map$Entry
        //   116: astore 6
        //   118: aload 6
        //   120: invokeinterface 112 1 0
        //   125: ifnull -29 -> 96
        //   128: aload 4
        //   130: new 114	org/apache/http/message/BasicNameValuePair
        //   133: dup
        //   134: aload 6
        //   136: invokeinterface 117 1 0
        //   141: checkcast 119	java/lang/String
        //   144: aload 6
        //   146: invokeinterface 112 1 0
        //   151: invokevirtual 120	java/lang/Object:toString	()Ljava/lang/String;
        //   154: invokespecial 123	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
        //   157: invokeinterface 129 2 0
        //   162: pop
        //   163: goto -67 -> 96
        //   166: aload_0
        //   167: getfield 26	com/ziroom/ziroomcustomer/signed/ConfirmContractActivity$5:a	Lcom/ziroom/ziroomcustomer/signed/ConfirmContractActivity;
        //   170: invokestatic 133	com/ziroom/ziroomcustomer/signed/ConfirmContractActivity:e	(Lcom/ziroom/ziroomcustomer/signed/ConfirmContractActivity;)Lcom/ziroom/ziroomcustomer/reserve/c;
        //   173: ifnonnull +4 -> 177
        //   176: return
        //   177: aload_0
        //   178: getfield 26	com/ziroom/ziroomcustomer/signed/ConfirmContractActivity$5:a	Lcom/ziroom/ziroomcustomer/signed/ConfirmContractActivity;
        //   181: invokestatic 133	com/ziroom/ziroomcustomer/signed/ConfirmContractActivity:e	(Lcom/ziroom/ziroomcustomer/signed/ConfirmContractActivity;)Lcom/ziroom/ziroomcustomer/reserve/c;
        //   184: invokevirtual 138	com/ziroom/ziroomcustomer/reserve/c:getHouseCode	()Ljava/lang/String;
        //   187: aload_0
        //   188: getfield 26	com/ziroom/ziroomcustomer/signed/ConfirmContractActivity$5:a	Lcom/ziroom/ziroomcustomer/signed/ConfirmContractActivity;
        //   191: invokestatic 133	com/ziroom/ziroomcustomer/signed/ConfirmContractActivity:e	(Lcom/ziroom/ziroomcustomer/signed/ConfirmContractActivity;)Lcom/ziroom/ziroomcustomer/reserve/c;
        //   194: invokevirtual 141	com/ziroom/ziroomcustomer/reserve/c:getHouseType	()Ljava/lang/String;
        //   197: aload_0
        //   198: getfield 26	com/ziroom/ziroomcustomer/signed/ConfirmContractActivity$5:a	Lcom/ziroom/ziroomcustomer/signed/ConfirmContractActivity;
        //   201: invokestatic 133	com/ziroom/ziroomcustomer/signed/ConfirmContractActivity:e	(Lcom/ziroom/ziroomcustomer/signed/ConfirmContractActivity;)Lcom/ziroom/ziroomcustomer/reserve/c;
        //   204: invokevirtual 144	com/ziroom/ziroomcustomer/reserve/c:getHouseId	()Ljava/lang/String;
        //   207: invokestatic 148	com/ziroom/ziroomcustomer/e/g:buildReserveImage	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
        //   210: astore_3
        //   211: new 58	java/lang/StringBuilder
        //   214: dup
        //   215: invokespecial 59	java/lang/StringBuilder:<init>	()V
        //   218: getstatic 65	com/ziroom/ziroomcustomer/e/q:s	Ljava/lang/String;
        //   221: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   224: getstatic 152	com/ziroom/ziroomcustomer/e/e$m:e	Ljava/lang/String;
        //   227: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   230: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   233: astore_2
        //   234: goto -172 -> 62
        //   237: new 154	org/apache/http/client/methods/HttpPost
        //   240: dup
        //   241: aload_2
        //   242: invokespecial 157	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
        //   245: astore 5
        //   247: ldc -97
        //   249: new 58	java/lang/StringBuilder
        //   252: dup
        //   253: invokespecial 59	java/lang/StringBuilder:<init>	()V
        //   256: aload_2
        //   257: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   260: aload_3
        //   261: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   264: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   267: invokestatic 166	com/ziroom/ziroomcustomer/util/u:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   270: new 168	org/apache/http/impl/client/DefaultHttpClient
        //   273: dup
        //   274: invokespecial 169	org/apache/http/impl/client/DefaultHttpClient:<init>	()V
        //   277: astore_3
        //   278: aload 5
        //   280: new 171	org/apache/http/client/entity/UrlEncodedFormEntity
        //   283: dup
        //   284: aload 4
        //   286: ldc -83
        //   288: invokespecial 176	org/apache/http/client/entity/UrlEncodedFormEntity:<init>	(Ljava/util/List;Ljava/lang/String;)V
        //   291: invokevirtual 180	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
        //   294: aload_3
        //   295: instanceof 182
        //   298: ifne +187 -> 485
        //   301: aload_3
        //   302: aload 5
        //   304: invokevirtual 186	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
        //   307: astore_2
        //   308: aload_2
        //   309: invokeinterface 192 1 0
        //   314: invokeinterface 198 1 0
        //   319: istore_1
        //   320: aload_0
        //   321: getfield 26	com/ziroom/ziroomcustomer/signed/ConfirmContractActivity$5:a	Lcom/ziroom/ziroomcustomer/signed/ConfirmContractActivity;
        //   324: invokevirtual 201	com/ziroom/ziroomcustomer/signed/ConfirmContractActivity:dismissProgress	()V
        //   327: iload_1
        //   328: sipush 200
        //   331: if_icmpne +167 -> 498
        //   334: aload_2
        //   335: invokeinterface 205 1 0
        //   340: invokeinterface 211 1 0
        //   345: astore_2
        //   346: aload_3
        //   347: invokevirtual 215	org/apache/http/impl/client/DefaultHttpClient:getCookieStore	()Lorg/apache/http/client/CookieStore;
        //   350: invokeinterface 221 1 0
        //   355: astore_3
        //   356: iconst_0
        //   357: istore_1
        //   358: iload_1
        //   359: aload_3
        //   360: invokeinterface 224 1 0
        //   365: if_icmpge +49 -> 414
        //   368: ldc -30
        //   370: aload_3
        //   371: iload_1
        //   372: invokeinterface 230 2 0
        //   377: checkcast 232	org/apache/http/cookie/Cookie
        //   380: invokeinterface 235 1 0
        //   385: invokevirtual 238	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   388: ifeq +147 -> 535
        //   391: aload_0
        //   392: getfield 26	com/ziroom/ziroomcustomer/signed/ConfirmContractActivity$5:a	Lcom/ziroom/ziroomcustomer/signed/ConfirmContractActivity;
        //   395: aload_3
        //   396: iload_1
        //   397: invokeinterface 230 2 0
        //   402: checkcast 232	org/apache/http/cookie/Cookie
        //   405: invokeinterface 240 1 0
        //   410: invokestatic 243	com/ziroom/ziroomcustomer/signed/ConfirmContractActivity:f	(Lcom/ziroom/ziroomcustomer/signed/ConfirmContractActivity;Ljava/lang/String;)Ljava/lang/String;
        //   413: pop
        //   414: aload_0
        //   415: getfield 26	com/ziroom/ziroomcustomer/signed/ConfirmContractActivity$5:a	Lcom/ziroom/ziroomcustomer/signed/ConfirmContractActivity;
        //   418: aload_2
        //   419: invokestatic 249	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
        //   422: invokestatic 252	com/ziroom/ziroomcustomer/signed/ConfirmContractActivity:a	(Lcom/ziroom/ziroomcustomer/signed/ConfirmContractActivity;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
        //   425: pop
        //   426: aload_2
        //   427: invokevirtual 257	java/io/InputStream:close	()V
        //   430: aload_0
        //   431: getfield 26	com/ziroom/ziroomcustomer/signed/ConfirmContractActivity$5:a	Lcom/ziroom/ziroomcustomer/signed/ConfirmContractActivity;
        //   434: invokestatic 261	com/ziroom/ziroomcustomer/signed/ConfirmContractActivity:t	(Lcom/ziroom/ziroomcustomer/signed/ConfirmContractActivity;)Landroid/os/Handler;
        //   437: iconst_5
        //   438: invokevirtual 267	android/os/Handler:sendEmptyMessage	(I)Z
        //   441: pop
        //   442: return
        //   443: astore_2
        //   444: aload_0
        //   445: getfield 26	com/ziroom/ziroomcustomer/signed/ConfirmContractActivity$5:a	Lcom/ziroom/ziroomcustomer/signed/ConfirmContractActivity;
        //   448: new 15	com/ziroom/ziroomcustomer/signed/ConfirmContractActivity$5$2
        //   451: dup
        //   452: aload_0
        //   453: invokespecial 270	com/ziroom/ziroomcustomer/signed/ConfirmContractActivity$5$2:<init>	(Lcom/ziroom/ziroomcustomer/signed/ConfirmContractActivity$5;)V
        //   456: invokevirtual 274	com/ziroom/ziroomcustomer/signed/ConfirmContractActivity:runOnUiThread	(Ljava/lang/Runnable;)V
        //   459: aload_2
        //   460: invokevirtual 277	org/apache/http/client/ClientProtocolException:printStackTrace	()V
        //   463: return
        //   464: astore_2
        //   465: aload_0
        //   466: getfield 26	com/ziroom/ziroomcustomer/signed/ConfirmContractActivity$5:a	Lcom/ziroom/ziroomcustomer/signed/ConfirmContractActivity;
        //   469: new 19	com/ziroom/ziroomcustomer/signed/ConfirmContractActivity$5$4
        //   472: dup
        //   473: aload_0
        //   474: invokespecial 278	com/ziroom/ziroomcustomer/signed/ConfirmContractActivity$5$4:<init>	(Lcom/ziroom/ziroomcustomer/signed/ConfirmContractActivity$5;)V
        //   477: invokevirtual 274	com/ziroom/ziroomcustomer/signed/ConfirmContractActivity:runOnUiThread	(Ljava/lang/Runnable;)V
        //   480: aload_2
        //   481: invokevirtual 279	java/lang/Exception:printStackTrace	()V
        //   484: return
        //   485: aload_3
        //   486: checkcast 182	org/apache/http/client/HttpClient
        //   489: aload 5
        //   491: invokestatic 284	com/mato/sdk/instrumentation/ApacheHttpClientInstrumentation:execute	(Lorg/apache/http/client/HttpClient;Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
        //   494: astore_2
        //   495: goto -187 -> 308
        //   498: aload_0
        //   499: getfield 26	com/ziroom/ziroomcustomer/signed/ConfirmContractActivity$5:a	Lcom/ziroom/ziroomcustomer/signed/ConfirmContractActivity;
        //   502: new 13	com/ziroom/ziroomcustomer/signed/ConfirmContractActivity$5$1
        //   505: dup
        //   506: aload_0
        //   507: invokespecial 285	com/ziroom/ziroomcustomer/signed/ConfirmContractActivity$5$1:<init>	(Lcom/ziroom/ziroomcustomer/signed/ConfirmContractActivity$5;)V
        //   510: invokevirtual 274	com/ziroom/ziroomcustomer/signed/ConfirmContractActivity:runOnUiThread	(Ljava/lang/Runnable;)V
        //   513: return
        //   514: astore_2
        //   515: aload_0
        //   516: getfield 26	com/ziroom/ziroomcustomer/signed/ConfirmContractActivity$5:a	Lcom/ziroom/ziroomcustomer/signed/ConfirmContractActivity;
        //   519: new 17	com/ziroom/ziroomcustomer/signed/ConfirmContractActivity$5$3
        //   522: dup
        //   523: aload_0
        //   524: invokespecial 286	com/ziroom/ziroomcustomer/signed/ConfirmContractActivity$5$3:<init>	(Lcom/ziroom/ziroomcustomer/signed/ConfirmContractActivity$5;)V
        //   527: invokevirtual 274	com/ziroom/ziroomcustomer/signed/ConfirmContractActivity:runOnUiThread	(Ljava/lang/Runnable;)V
        //   530: aload_2
        //   531: invokevirtual 287	java/io/IOException:printStackTrace	()V
        //   534: return
        //   535: iload_1
        //   536: iconst_1
        //   537: iadd
        //   538: istore_1
        //   539: goto -181 -> 358
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	542	0	this	5
        //   319	220	1	i	int
        //   61	366	2	localObject1	Object
        //   443	17	2	localClientProtocolException	org.apache.http.client.ClientProtocolException
        //   464	17	2	localException	Exception
        //   494	1	2	localHttpResponse	org.apache.http.HttpResponse
        //   514	17	2	localIOException	java.io.IOException
        //   38	448	3	localObject2	Object
        //   7	278	4	localArrayList	java.util.ArrayList
        //   94	396	5	localObject3	Object
        //   116	29	6	localEntry	java.util.Map.Entry
        // Exception table:
        //   from	to	target	type
        //   294	308	443	org/apache/http/client/ClientProtocolException
        //   308	327	443	org/apache/http/client/ClientProtocolException
        //   334	356	443	org/apache/http/client/ClientProtocolException
        //   358	414	443	org/apache/http/client/ClientProtocolException
        //   414	442	443	org/apache/http/client/ClientProtocolException
        //   485	495	443	org/apache/http/client/ClientProtocolException
        //   498	513	443	org/apache/http/client/ClientProtocolException
        //   237	294	464	java/lang/Exception
        //   294	308	464	java/lang/Exception
        //   308	327	464	java/lang/Exception
        //   334	356	464	java/lang/Exception
        //   358	414	464	java/lang/Exception
        //   414	442	464	java/lang/Exception
        //   444	463	464	java/lang/Exception
        //   485	495	464	java/lang/Exception
        //   498	513	464	java/lang/Exception
        //   515	534	464	java/lang/Exception
        //   294	308	514	java/io/IOException
        //   308	327	514	java/io/IOException
        //   334	356	514	java/io/IOException
        //   358	414	514	java/io/IOException
        //   414	442	514	java/io/IOException
        //   485	495	514	java/io/IOException
        //   498	513	514	java/io/IOException
      }
    }).start();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903692);
    this.c = this;
    ApplicationEx.c.addActivity(this);
    e();
    b();
    a();
    if (this.W == 2)
    {
      findViewById(2131689578).setVisibility(8);
      this.Q.setText("确认预订");
      this.O.setVisibility(8);
      this.w.setText("预计可入住日期");
      this.ae = (q.s + e.m.d);
      paramBundle = com.ziroom.ziroomcustomer.e.g.buildGetreserveData(this.N);
      j.getReservationOrderText(this.c, new a(), paramBundle, false, this.ae);
      return;
    }
    this.P.setVisibility(0);
    com.ziroom.ziroomcustomer.e.d.getContractSummary(this.X, this.b.getHouse_id(), this.b.getHouse_code(), this.b.getHouse_type(), this.J, this.H + "", this.B);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    ApplicationEx.c.removeActivity(this);
  }
  
  public void onSign()
  {
    if (isFinishing()) {
      return;
    }
    Object localObject2 = LayoutInflater.from(this.c).inflate(2130905132, null);
    this.d = new Dialog(this.c, 2131427781);
    this.d.setContentView((View)localObject2);
    this.g = ((TextView)((View)localObject2).findViewById(2131697541));
    this.e = ((ImageView)((View)localObject2).findViewById(2131697540));
    this.f = ((EditText)((View)localObject2).findViewById(2131694428));
    Object localObject1 = (TextView)((View)localObject2).findViewById(2131697195);
    localObject2 = (TextView)((View)localObject2).findViewById(2131697542);
    this.e.setOnClickListener(new View.OnClickListener()
    {
      @com.growingio.android.sdk.instrumentation.Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ConfirmContractActivity.a(ConfirmContractActivity.this, null);
        ConfirmContractActivity.this.showProgress("");
        ConfirmContractActivity.this.getYanzhengmaBitmap();
      }
    });
    ((TextView)localObject2).setOnClickListener(this.a);
    ((TextView)localObject1).setOnClickListener(this.a);
    this.z = null;
    localObject1 = this.d;
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
  
  public e parseGetRaSignInfo(String paramString)
  {
    if (paramString == null) {
      try
      {
        throw new Exception();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        showToast("网络数据请求失败!");
        u.e("parseGetRaSignInfo", paramString.getMessage());
        return null;
      }
    }
    paramString = (e)a.parseObject(paramString, e.class);
    return paramString;
  }
  
  public void setOrderData(c paramc)
  {
    this.r.setText(paramc.getUserName());
    this.u.setText(paramc.getCertNum());
    this.t.setText(paramc.getHouseAddress());
    this.v.setText(paramc.getCanSigndate());
    this.P.setText(paramc.getDescr().replaceAll("\\n", ""));
    this.P.setVisibility(0);
  }
  
  public void showDialog(String paramString)
  {
    this.Y = View.inflate(this.c, 2130905178, null);
    this.Z = ((TextView)this.Y.findViewById(2131697639));
    this.aa = ((TextView)this.Y.findViewById(2131697638));
    this.ac = ((TextView)this.Y.findViewById(2131697637));
    this.ab = ((TextView)this.Y.findViewById(2131697634));
    this.Z.setOnClickListener(this.a);
    this.ab.setText("提示");
    this.Z.setText("查看使用规则");
    this.aa.setVisibility(8);
    this.ac.setText(paramString);
    if (this.ad == null)
    {
      this.ad = new Dialog(this.c, 2131427781);
      this.ad.setContentView(this.Y);
      this.ad.setCanceledOnTouchOutside(false);
      this.ad.setCancelable(false);
      paramString = this.ad;
      if ((paramString instanceof Dialog)) {
        break label219;
      }
      paramString.show();
    }
    for (;;)
    {
      ApplicationEx.g = 2;
      this.ad.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          ConfirmContractActivity.a(ConfirmContractActivity.this, null);
          ConfirmContractActivity.o(ConfirmContractActivity.this).dismiss();
          ConfirmContractActivity.a(ConfirmContractActivity.this, null);
        }
      });
      return;
      label219:
      VdsAgent.showDialog((Dialog)paramString);
    }
  }
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, k paramk)
    {
      paramString = a.parseObject(paramString);
      if (((String)paramString.get("status")).equals("success"))
      {
        if (ConfirmContractActivity.a(ConfirmContractActivity.this).equals(paramk.getUrl()))
        {
          ConfirmContractActivity.a(ConfirmContractActivity.this, (c)a.parseObject(paramString.get("data").toString(), c.class));
          paramk.setSuccess(Boolean.valueOf(true));
          paramk.setObject(ConfirmContractActivity.e(ConfirmContractActivity.this));
        }
        while (!ConfirmContractActivity.b(ConfirmContractActivity.this).equals(paramk.getUrl())) {
          return;
        }
        paramk.setSuccess(Boolean.valueOf(true));
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage((String)paramString.get("error_message"));
      paramk.setCode(paramString.get("error_code").toString());
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue()) {
        if (ConfirmContractActivity.a(ConfirmContractActivity.this).equals(paramk.getUrl()))
        {
          paramk = (c)paramk.getObject();
          ConfirmContractActivity.this.setOrderData(paramk);
        }
      }
      for (;;)
      {
        ConfirmContractActivity.this.dismissProgress();
        return;
        if (ConfirmContractActivity.b(ConfirmContractActivity.this).equals(paramk.getUrl()))
        {
          paramk = new Intent(ConfirmContractActivity.c(ConfirmContractActivity.this), HouseBillInfoActivity.class);
          paramk.putExtra("uniqueCode", ConfirmContractActivity.d(ConfirmContractActivity.this));
          paramk.putExtra("period", "");
          paramk.putExtra("payType", "pzyd");
          paramk.putExtra("mContentText", "倒计时结束之前，您可以在“我的订单”里找到待支付的长租预订单进行支付。");
          ConfirmContractActivity.this.startActivityAndFinish(paramk);
          continue;
          if (("608002".equals(paramk.getCode())) && (ae.notNull(paramk.getMessage()))) {
            ConfirmContractActivity.this.showDialog(paramk.getMessage());
          } else {
            ConfirmContractActivity.this.showToast(paramk.getMessage());
          }
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/ConfirmContractActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */