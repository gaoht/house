package com.ziroom.ziroomcustomer.my.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.alibaba.fastjson.e;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.b;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.account.AccountMainActivity;
import com.ziroom.ziroomcustomer.activity.EvaluateActivity;
import com.ziroom.ziroomcustomer.activity.EvaluateSignActivity;
import com.ziroom.ziroomcustomer.activity.HouseBillInfoActivity;
import com.ziroom.ziroomcustomer.activity.LeaseActivity;
import com.ziroom.ziroomcustomer.activity.NewLeaseInfoActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.contract.ContractDataActivity;
import com.ziroom.ziroomcustomer.e.c.k;
import com.ziroom.ziroomcustomer.e.e.e;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.home.MainFragmentActivity;
import com.ziroom.ziroomcustomer.living.LeaseAllBillActivity;
import com.ziroom.ziroomcustomer.model.HouseDetail;
import com.ziroom.ziroomcustomer.my.CreditWebActivity;
import com.ziroom.ziroomcustomer.my.MyStewardInfoActivity;
import com.ziroom.ziroomcustomer.my.model.MyZiroomContract;
import com.ziroom.ziroomcustomer.signed.EasilyPayLoanInfoActivity;
import com.ziroom.ziroomcustomer.signed.LoanInfoActivity;
import com.ziroom.ziroomcustomer.signed.NewZZItemsActivity;
import com.ziroom.ziroomcustomer.signed.WaitDeliveryActivity;
import com.ziroom.ziroomcustomer.signed.ZxingActivity;
import com.ziroom.ziroomcustomer.sublet.activity.SubletInitiatorDetailActivity;
import com.ziroom.ziroomcustomer.termination.ConfirmTerminationActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.util.w;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.json.JSONObject;

public class MyZiroomCardViewContract
  extends LinearLayout
  implements View.OnClickListener
{
  View a;
  TextView b;
  TextView c;
  ImageView d;
  TextView e;
  TextView f;
  TextView g;
  LinearLayout h;
  TextView i;
  TextView j;
  TextView k;
  String l = "";
  public boolean m = true;
  public PopupWindow n;
  private Context o;
  private float p;
  private MyZiroomContract q;
  private View.OnClickListener r = new View.OnClickListener()
  {
    @Instrumented
    public void onClick(View paramAnonymousView)
    {
      VdsAgent.onClick(this, paramAnonymousView);
      paramAnonymousView = new Intent(MyZiroomCardViewContract.a(MyZiroomCardViewContract.this), SubletInitiatorDetailActivity.class);
      paramAnonymousView.putExtra("contract_code", MyZiroomCardViewContract.b(MyZiroomCardViewContract.this).getContractCode());
      MyZiroomCardViewContract.a(MyZiroomCardViewContract.this).startActivity(paramAnonymousView);
    }
  };
  private View.OnClickListener s = new View.OnClickListener()
  {
    @Instrumented
    public void onClick(View paramAnonymousView)
    {
      VdsAgent.onClick(this, paramAnonymousView);
      ah.callPhone(MyZiroomCardViewContract.a(MyZiroomCardViewContract.this), MyZiroomCardViewContract.b(MyZiroomCardViewContract.this).reserveUserPhone);
    }
  };
  private View.OnClickListener t = new View.OnClickListener()
  {
    @Instrumented
    public void onClick(View paramAnonymousView)
    {
      VdsAgent.onClick(this, paramAnonymousView);
      paramAnonymousView = new Intent(MyZiroomCardViewContract.a(MyZiroomCardViewContract.this), AccountMainActivity.class);
      MyZiroomCardViewContract.a(MyZiroomCardViewContract.this).startActivity(paramAnonymousView);
    }
  };
  private String u;
  private String v;
  private Handler w = new Handler()
  {
    @SuppressLint({"InlinedApi"})
    public void handleMessage(Message paramAnonymousMessage)
    {
      Object localObject = (l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 69712: 
        ((BaseActivity)MyZiroomCardViewContract.a(MyZiroomCardViewContract.this)).dismissProgress();
        localObject = (l)paramAnonymousMessage.obj;
        if (((l)localObject).getSuccess().booleanValue()) {
          try
          {
            JSONObject localJSONObject = new JSONObject(((l)localObject).getObject().toString()).getJSONObject("data");
            String str = localJSONObject.optString("type");
            if (!TextUtils.isEmpty(str))
            {
              if (!"2".equals(String.valueOf(MyZiroomCardViewContract.b(MyZiroomCardViewContract.this).getEvaluateType()))) {
                break label199;
              }
              MyZiroomCardViewContract.a(MyZiroomCardViewContract.this, "fwgj");
              MyZiroomCardViewContract.b(MyZiroomCardViewContract.this, "XYPJ2");
            }
            for (;;)
            {
              MyZiroomCardViewContract.this.l = localJSONObject.optString("userAccount");
              if (!TextUtils.isEmpty(MyZiroomCardViewContract.this.l)) {
                break label340;
              }
              ((BaseActivity)MyZiroomCardViewContract.a(MyZiroomCardViewContract.this)).showToast("未找到当前管家信息,无法评价!");
              return;
              if (!"1".equals(String.valueOf(MyZiroomCardViewContract.b(MyZiroomCardViewContract.this).getEvaluateType()))) {
                break label296;
              }
              MyZiroomCardViewContract localMyZiroomCardViewContract = MyZiroomCardViewContract.this;
              if (!"网络管家".equals(str)) {
                break;
              }
              paramAnonymousMessage = "salesZO";
              MyZiroomCardViewContract.a(localMyZiroomCardViewContract, paramAnonymousMessage);
              if ("网络管家".equals(str)) {
                break label283;
              }
              MyZiroomCardViewContract.b(MyZiroomCardViewContract.this, "ZOASE2");
            }
          }
          catch (Exception paramAnonymousMessage)
          {
            for (;;)
            {
              paramAnonymousMessage.printStackTrace();
              continue;
              paramAnonymousMessage = "zo";
              continue;
              MyZiroomCardViewContract.b(MyZiroomCardViewContract.this, "SZOASE2");
              continue;
              if ("3".equals(String.valueOf(MyZiroomCardViewContract.b(MyZiroomCardViewContract.this).getEvaluateType())))
              {
                MyZiroomCardViewContract.a(MyZiroomCardViewContract.this, "fwgj");
                MyZiroomCardViewContract.b(MyZiroomCardViewContract.this, "JYPJ");
              }
            }
            ((BaseActivity)MyZiroomCardViewContract.a(MyZiroomCardViewContract.this)).showProgress("");
            com.ziroom.ziroomcustomer.e.d.checkHasEvaluate(MyZiroomCardViewContract.c(MyZiroomCardViewContract.this), MyZiroomCardViewContract.a(MyZiroomCardViewContract.this), ApplicationEx.c.getUserId((BaseActivity)MyZiroomCardViewContract.a(MyZiroomCardViewContract.this)), "ziroomer", MyZiroomCardViewContract.this.l, MyZiroomCardViewContract.d(MyZiroomCardViewContract.this), MyZiroomCardViewContract.e(MyZiroomCardViewContract.this), ((l)localObject).getCode());
            return;
          }
        }
        ((BaseActivity)MyZiroomCardViewContract.a(MyZiroomCardViewContract.this)).showToast(((l)localObject).getMessage());
        return;
      case 69713: 
        label199:
        label283:
        label296:
        label340:
        ((BaseActivity)MyZiroomCardViewContract.a(MyZiroomCardViewContract.this)).dismissProgress();
        paramAnonymousMessage = (l)paramAnonymousMessage.obj;
        if (paramAnonymousMessage.getSuccess().booleanValue())
        {
          ((BaseActivity)MyZiroomCardViewContract.a(MyZiroomCardViewContract.this)).showToast("您已经评价过了!");
          return;
        }
        if ("2".equals(MyZiroomCardViewContract.b(MyZiroomCardViewContract.this).getEvaluateType() + ""))
        {
          localObject = new Intent(MyZiroomCardViewContract.a(MyZiroomCardViewContract.this), EvaluateActivity.class);
          ((Intent)localObject).putExtra("old_contract_code", paramAnonymousMessage.getCode());
          ((Intent)localObject).putExtra("questionType", MyZiroomCardViewContract.e(MyZiroomCardViewContract.this));
          ((Intent)localObject).putExtra("uid", MyZiroomCardViewContract.this.l);
          ((Intent)localObject).putExtra("stewardType", MyZiroomCardViewContract.d(MyZiroomCardViewContract.this));
          ((Intent)localObject).putExtra("type", 0);
          MyZiroomCardViewContract.a(MyZiroomCardViewContract.this).startActivity((Intent)localObject);
          return;
        }
        if ("3".equals(MyZiroomCardViewContract.b(MyZiroomCardViewContract.this).getEvaluateType() + ""))
        {
          localObject = new Intent(MyZiroomCardViewContract.a(MyZiroomCardViewContract.this), EvaluateActivity.class);
          ((Intent)localObject).putExtra("contract_code", paramAnonymousMessage.getCode());
          ((Intent)localObject).putExtra("questionType", MyZiroomCardViewContract.e(MyZiroomCardViewContract.this));
          ((Intent)localObject).putExtra("uid", MyZiroomCardViewContract.this.l);
          ((Intent)localObject).putExtra("stewardType", MyZiroomCardViewContract.d(MyZiroomCardViewContract.this));
          ((Intent)localObject).putExtra("type", 2);
          MyZiroomCardViewContract.a(MyZiroomCardViewContract.this).startActivity((Intent)localObject);
          return;
        }
        localObject = new Intent(MyZiroomCardViewContract.a(MyZiroomCardViewContract.this), EvaluateSignActivity.class);
        ((Intent)localObject).putExtra("contractCode", paramAnonymousMessage.getCode());
        MyZiroomCardViewContract.a(MyZiroomCardViewContract.this).startActivity((Intent)localObject);
        return;
      }
      paramAnonymousMessage = (Map)((l)paramAnonymousMessage.obj).getObject();
      if ((paramAnonymousMessage == null) || (paramAnonymousMessage.get("house_type") == null))
      {
        ((BaseActivity)MyZiroomCardViewContract.a(MyZiroomCardViewContract.this)).showToast("house_type为空!");
        return;
      }
      paramAnonymousMessage = String.valueOf(paramAnonymousMessage.get("house_type"));
      if (("5".equals(paramAnonymousMessage)) || ("8".equals(paramAnonymousMessage))) {}
      for (paramAnonymousMessage = new Intent(MyZiroomCardViewContract.a(MyZiroomCardViewContract.this), NewZZItemsActivity.class);; paramAnonymousMessage = new Intent(MyZiroomCardViewContract.a(MyZiroomCardViewContract.this), MainFragmentActivity.class))
      {
        paramAnonymousMessage.putExtra("wuyesure", "wuyesure");
        paramAnonymousMessage.putExtra("contract_part_code", MyZiroomCardViewContract.b(MyZiroomCardViewContract.this).getContractCode());
        paramAnonymousMessage.putExtra("lease", "lease");
        MyZiroomCardViewContract.a(MyZiroomCardViewContract.this).startActivity(paramAnonymousMessage);
        return;
      }
    }
  };
  
  public MyZiroomCardViewContract(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MyZiroomCardViewContract(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MyZiroomCardViewContract(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.o = paramContext;
    this.p = this.o.getResources().getDisplayMetrics().density;
    a();
  }
  
  private void a()
  {
    setOrientation(1);
    inflate(this.o, 2130904394, this);
    setBackgroundColor(Color.parseColor("#ffffff"));
    this.a = findViewById(2131695422);
    this.b = ((TextView)findViewById(2131689541));
    this.c = ((TextView)findViewById(2131690326));
    this.d = ((ImageView)findViewById(2131690724));
    this.e = ((TextView)findViewById(2131695423));
    this.f = ((TextView)findViewById(2131695424));
    this.g = ((TextView)findViewById(2131695425));
    this.h = ((LinearLayout)findViewById(2131691838));
    this.i = ((TextView)findViewById(2131695426));
    this.j = ((TextView)findViewById(2131695427));
    this.k = ((TextView)findViewById(2131689835));
    this.a.setBackgroundColor(Color.parseColor("#FFAB6E"));
    this.b.setText("我的合同");
    this.i.setTextColor(this.o.getResources().getColor(2131624415));
    this.i.setBackgroundResource(2130837969);
    this.j.setTextColor(Color.parseColor("#E98A44"));
    this.j.setBackgroundResource(2130837972);
    this.i.setVisibility(8);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
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
  
  private void a(final MyZiroomContract paramMyZiroomContract)
  {
    View localView1 = View.inflate(this.o, 2130905076, null);
    TextView localTextView1 = (TextView)localView1.findViewById(2131697360);
    TextView localTextView2 = (TextView)localView1.findViewById(2131697359);
    TextView localTextView3 = (TextView)localView1.findViewById(2131697361);
    Object localObject;
    View localView2;
    if (this.m)
    {
      this.n = new PopupWindow(localView1, -1, -1, true);
      this.n.setContentView(localView1);
      this.n.setOutsideTouchable(false);
      this.n.setFocusable(true);
      localObject = new ColorDrawable(-1342177280);
      this.n.setBackgroundDrawable((Drawable)localObject);
      localObject = this.n;
      localView2 = ((MainActivity)this.o).findViewById(2131689801);
      if (!(localObject instanceof PopupWindow)) {
        ((PopupWindow)localObject).showAtLocation(localView2, 81, 0, 0);
      }
    }
    for (this.m = false;; this.m = true)
    {
      localTextView2.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          MyZiroomCardViewContract.a(MyZiroomCardViewContract.this, paramMyZiroomContract);
        }
      });
      localTextView1.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          MyZiroomCardViewContract.c(MyZiroomCardViewContract.this, paramMyZiroomContract);
        }
      });
      localTextView3.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          MyZiroomCardViewContract.this.n.dismiss();
          MyZiroomCardViewContract.this.m = true;
        }
      });
      localView1.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          MyZiroomCardViewContract.this.n.dismiss();
          MyZiroomCardViewContract.this.m = true;
        }
      });
      return;
      VdsAgent.showAtLocation((PopupWindow)localObject, localView2, 81, 0, 0);
      break;
      this.n.dismiss();
    }
  }
  
  private void a(String paramString)
  {
    String str = q.s + e.e.q;
    paramString = com.ziroom.ziroomcustomer.e.g.buildGetPhone(paramString);
    com.freelxl.baselibrary.f.d.e("url", str + paramString.toString());
    com.freelxl.baselibrary.d.a.isLog(true);
    com.freelxl.baselibrary.d.a.post(str).params(ah.ConvertObjMap2String(paramString)).tag(this).enqueue(new com.ziroom.commonlibrary.a.a(this.o, new com.freelxl.baselibrary.d.f.c())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        dismissProgress();
        u.e("LeaseHistoryLivingActivity", paramAnonymousThrowable.getMessage() + "");
      }
      
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        com.freelxl.baselibrary.f.d.e("jsonObject", paramAnonymouse.toJSONString());
        if ("success".equals(paramAnonymouse.get("status")))
        {
          paramAnonymouse = com.alibaba.fastjson.a.parseObject(paramAnonymouse.get("data") + "");
          if (paramAnonymouse == null) {
            break label106;
          }
          if (paramAnonymouse.get("phone") == null) {
            break label88;
          }
          ah.callPhone(MyZiroomCardViewContract.a(MyZiroomCardViewContract.this), paramAnonymouse.get("phone").toString());
        }
        for (;;)
        {
          dismissProgress();
          return;
          label88:
          ((BaseActivity)MyZiroomCardViewContract.a(MyZiroomCardViewContract.this)).showToast("获取管家手机号失败");
          continue;
          label106:
          ((BaseActivity)MyZiroomCardViewContract.a(MyZiroomCardViewContract.this)).showToast("获取管家手机号失败");
        }
      }
    });
  }
  
  private void b()
  {
    this.i.setVisibility(8);
    switch (this.q.getDataType())
    {
    default: 
      setVisibility(8);
      return;
    case 18: 
    case 19: 
    case 23: 
      this.j.setText("查看转租详情");
      this.j.setOnClickListener(this.r);
      return;
    case 20: 
    case 24: 
      this.i.setVisibility(0);
      this.j.setText("联系TA");
      this.j.setOnClickListener(this.s);
      this.i.setText("查看转租详情");
      this.i.setOnClickListener(this.r);
      return;
    case 21: 
      this.i.setVisibility(0);
      this.j.setText("去确认");
      this.j.setOnClickListener(this.r);
      this.i.setText("查看转租详情");
      this.i.setOnClickListener(this.r);
      return;
    case 22: 
      this.i.setVisibility(0);
      this.j.setText("去支付");
      this.j.setOnClickListener(this.r);
      this.i.setText("取消预订");
      this.i.setOnClickListener(this.r);
      return;
    case 25: 
      this.i.setVisibility(0);
      this.j.setText("联系TA");
      this.j.setOnClickListener(this.s);
      this.i.setText("确认取消");
      this.i.setOnClickListener(this.r);
      return;
    case 26: 
      this.i.setVisibility(0);
      this.j.setText("去提现");
      this.j.setOnClickListener(this.t);
      this.i.setText("查看转租详情");
      this.i.setOnClickListener(this.r);
      return;
    }
    i();
  }
  
  private void b(final MyZiroomContract paramMyZiroomContract)
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.d.newBuilder(this.o).setContent("线下打款需要联系管家确认打款账户。").setTitle("提示").setButtonText("知道了", "联系管家").setOnConfirmClickListener(new d.b()
    {
      public void onLeftClick(View paramAnonymousView) {}
      
      public void onRightClick(View paramAnonymousView)
      {
        MyZiroomCardViewContract.c(MyZiroomCardViewContract.this, paramMyZiroomContract.getContractCode());
      }
    }).show();
  }
  
  private void c()
  {
    try
    {
      Object localObject2 = new Date(Long.parseLong(this.q.getSignDate() + "000"));
      Object localObject1 = new SimpleDateFormat("yyyy-MM-dd");
      localObject2 = ((SimpleDateFormat)localObject1).format((Date)localObject2);
      localObject1 = ((SimpleDateFormat)localObject1).format(new Date(Long.parseLong(this.q.getStopDate() + "000")));
      this.f.setText((String)localObject2 + " 至 " + (String)localObject1);
      return;
    }
    catch (Exception localException)
    {
      setVisibility(8);
      localException.printStackTrace();
    }
  }
  
  private void c(MyZiroomContract paramMyZiroomContract)
  {
    if (this.q.getIsZWhite() == 1)
    {
      j.checkContractHasPay(this.o, this.q.getContractCode(), new com.ziroom.commonlibrary.a.a(this.o, new k(new com.ziroom.ziroomcustomer.e.c.a.b()))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
          com.freelxl.baselibrary.f.g.textToast(this.b, "获取支付状态失败！");
        }
        
        public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          if ((paramAnonymouse != null) && (paramAnonymouse.containsKey("hasPay")))
          {
            if (!paramAnonymouse.getBoolean("hasPay").booleanValue())
            {
              paramAnonymouse = ApplicationEx.c.getUser();
              if ((ApplicationEx.c.isLoginState()) && (paramAnonymouse != null))
              {
                paramAnonymouse = new Intent(MyZiroomCardViewContract.a(MyZiroomCardViewContract.this), LoanInfoActivity.class);
                paramAnonymouse.putExtra("detail", new HouseDetail("", MyZiroomCardViewContract.b(MyZiroomCardViewContract.this).getHouseCode() + "", MyZiroomCardViewContract.b(MyZiroomCardViewContract.this).getHouseId()));
                paramAnonymouse.putExtra("is_back_pre", true);
                paramAnonymouse.putExtra("contract_code", MyZiroomCardViewContract.b(MyZiroomCardViewContract.this).getContractCode());
                if (1 == MyZiroomCardViewContract.b(MyZiroomCardViewContract.this).getIsRenew()) {
                  paramAnonymouse.putExtra("old_contract_code", "old_contract_code");
                }
                MyZiroomCardViewContract.a(MyZiroomCardViewContract.this).startActivity(paramAnonymouse);
              }
              return;
            }
            paramAnonymouse = new Intent(MyZiroomCardViewContract.a(MyZiroomCardViewContract.this), HouseBillInfoActivity.class);
            paramAnonymouse.putExtra("uniqueCode", MyZiroomCardViewContract.b(MyZiroomCardViewContract.this).getContractCode());
            paramAnonymouse.putExtra("period", "1");
            paramAnonymouse.putExtra("payType", "fz");
            String str = MyZiroomCardViewContract.b(MyZiroomCardViewContract.this).getPropertyState();
            if ((str != null) && ("yqr".equals(str))) {
              paramAnonymouse.putExtra("wystate", "wystate");
            }
            if (1 == MyZiroomCardViewContract.b(MyZiroomCardViewContract.this).getIsRenew()) {
              paramAnonymouse.putExtra("old_contract_code", "old_contract_code");
            }
            MyZiroomCardViewContract.a(MyZiroomCardViewContract.this).startActivity(paramAnonymouse);
            return;
          }
          com.freelxl.baselibrary.f.g.textToast(this.b, "获取支付状态失败！");
        }
      });
      return;
    }
    paramMyZiroomContract = new Intent(this.o, HouseBillInfoActivity.class);
    paramMyZiroomContract.putExtra("uniqueCode", this.q.getContractCode());
    paramMyZiroomContract.putExtra("period", "1");
    paramMyZiroomContract.putExtra("payType", "fz");
    String str = this.q.getPropertyState();
    if ((str != null) && ("yqr".equals(str))) {
      paramMyZiroomContract.putExtra("wystate", "wystate");
    }
    if (1 == this.q.getIsRenew()) {
      paramMyZiroomContract.putExtra("old_contract_code", "old_contract_code");
    }
    this.o.startActivity(paramMyZiroomContract);
  }
  
  private void d()
  {
    this.g.setVisibility(0);
    this.i.setVisibility(8);
    SpannableString localSpannableString1;
    switch (this.q.getDataType())
    {
    default: 
      setVisibility(8);
      return;
    case 1: 
      try
      {
        if (ae.notNull(this.q.getMaxPayTime()))
        {
          Object localObject = new Date(Long.parseLong(this.q.getMaxPayTime() + "000"));
          localObject = new SimpleDateFormat("MM月dd日HH:mm").format((Date)localObject);
          SpannableString localSpannableString2 = new SpannableString("请在" + (String)localObject + "前完成支付");
          localSpannableString2.setSpan(new ForegroundColorSpan(Color.parseColor("#FFC743")), 2, ((String)localObject).length() + 2, 18);
          this.g.setText(localSpannableString2);
        }
        p();
        return;
      }
      catch (Exception localException)
      {
        setVisibility(8);
        localException.printStackTrace();
        return;
      }
    case 2: 
      this.g.setText("管家正在录入物业交割");
      q();
      return;
    case 3: 
      this.g.setText("等待管家录入物业交割");
      r();
      return;
    case 4: 
      this.g.setText("物业交割待确认");
      o();
      return;
    case 5: 
      this.g.setText("管家已经录入续约合同，去确认");
      n();
      return;
    case 6: 
      localSpannableString1 = new SpannableString("距办理退租日期还有" + this.q.getBackRentDays() + "天");
      localSpannableString1.setSpan(new ForegroundColorSpan(Color.parseColor("#FFC743")), 9, (this.q.getBackRentDays() + "").length() + 10, 18);
      this.g.setText(localSpannableString1);
      s();
      return;
    case 7: 
      this.g.setText("管家已经录入解约信息，去确认");
      m();
      return;
    case 8: 
      this.g.setText("转租审核中");
      l();
      return;
    case 9: 
      this.g.setText("转租审核驳回");
      l();
      return;
    case 10: 
      localSpannableString1 = new SpannableString("转租中，" + this.q.getSubletFailureDays() + "天后失效");
      localSpannableString1.setSpan(new ForegroundColorSpan(Color.parseColor("#FFC743")), 4, (this.q.getSubletFailureDays() + "").length() + 5, 18);
      this.g.setText(localSpannableString1);
      l();
      return;
    case 11: 
      localSpannableString1 = new SpannableString("您有" + this.q.getWaitingPayNum() + "个账单待支付");
      localSpannableString1.setSpan(new ForegroundColorSpan(Color.parseColor("#FFC743")), 2, (this.q.getWaitingPayNum() + "").length() + 3, 18);
      this.g.setText(localSpannableString1);
      k();
      return;
    case 12: 
      if (65 >= this.q.getExpirationDays())
      {
        localSpannableString1 = new SpannableString("距过期还有" + this.q.getExpirationDays() + "天，提前续约享优惠");
        localSpannableString1.setSpan(new ForegroundColorSpan(Color.parseColor("#FFC743")), 5, (this.q.getExpirationDays() + "").length() + 6, 18);
        this.g.setText(localSpannableString1);
      }
      for (;;)
      {
        j();
        return;
        this.g.setVisibility(8);
      }
    case 13: 
      this.g.setText("待评价");
      i();
      return;
    case 14: 
      this.g.setText("待评价");
      h();
      return;
    case 15: 
      this.g.setText("签约完成了，去评价一下管家和房源吧");
      g();
      return;
    case 16: 
      if (ae.notNull(this.q.getPayDate())) {
        this.f.setText("应还款日期 " + this.q.getPayDate());
      }
      if (ae.notNull(this.q.getPayMoney())) {
        this.g.setText("待还款金额 " + this.q.getPayMoney() + "元");
      }
      e();
      return;
    }
    if (ae.notNull(this.q.getEasyPayLoanMoney())) {
      this.f.setText("贷款总额 " + this.q.getEasyPayLoanMoney() + "元");
    }
    if (ae.notNull(this.q.getEasyPayMoney())) {
      this.g.setText("首次支付金额 " + this.q.getEasyPayMoney() + "元");
    }
    f();
  }
  
  private void e()
  {
    this.j.setText("去还款");
    this.j.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent(MyZiroomCardViewContract.a(MyZiroomCardViewContract.this), HouseBillInfoActivity.class);
        paramAnonymousView.putExtra("uniqueCode", MyZiroomCardViewContract.b(MyZiroomCardViewContract.this).getContractCode());
        paramAnonymousView.putExtra("period", MyZiroomCardViewContract.b(MyZiroomCardViewContract.this).getCnt() + "");
        paramAnonymousView.putExtra("payType", "zrfq");
        MyZiroomCardViewContract.a(MyZiroomCardViewContract.this).startActivity(paramAnonymousView);
      }
    });
  }
  
  private void f()
  {
    this.j.setText("去支付");
    this.j.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent(MyZiroomCardViewContract.a(MyZiroomCardViewContract.this), EasilyPayLoanInfoActivity.class);
        paramAnonymousView.putExtra("mContractCode", MyZiroomCardViewContract.b(MyZiroomCardViewContract.this).getContractCode());
        paramAnonymousView.putExtra("isBack", true);
        MyZiroomCardViewContract.a(MyZiroomCardViewContract.this).startActivity(paramAnonymousView);
      }
    });
  }
  
  private void g()
  {
    this.j.setText("去评价");
    this.j.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        com.ziroom.ziroomcustomer.e.d.getRentAgentCode(MyZiroomCardViewContract.c(MyZiroomCardViewContract.this), MyZiroomCardViewContract.a(MyZiroomCardViewContract.this), MyZiroomCardViewContract.b(MyZiroomCardViewContract.this).getContractCode());
      }
    });
  }
  
  private void h()
  {
    this.j.setText("去评价");
    this.j.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        com.ziroom.ziroomcustomer.e.d.getRentAgentCode(MyZiroomCardViewContract.c(MyZiroomCardViewContract.this), MyZiroomCardViewContract.a(MyZiroomCardViewContract.this), MyZiroomCardViewContract.b(MyZiroomCardViewContract.this).getContractCode());
      }
    });
  }
  
  private void i()
  {
    this.j.setText("去评价");
    this.j.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent(MyZiroomCardViewContract.a(MyZiroomCardViewContract.this), EvaluateSignActivity.class);
        paramAnonymousView.putExtra("sceneCode", 0);
        paramAnonymousView.putExtra("orderCode", MyZiroomCardViewContract.b(MyZiroomCardViewContract.this).getContractCode());
        paramAnonymousView.setFlags(268435456);
        MyZiroomCardViewContract.a(MyZiroomCardViewContract.this).startActivity(paramAnonymousView);
      }
    });
  }
  
  private void j()
  {
    this.j.setText("查看规则");
    this.j.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent(MyZiroomCardViewContract.a(MyZiroomCardViewContract.this), CreditWebActivity.class);
        paramAnonymousView.putExtra("url", "http://www.ziroom.com/zhuanti/2016/zzbcwa/leaseChange.html");
        paramAnonymousView.putExtra("title", "租约变更说明");
        MyZiroomCardViewContract.a(MyZiroomCardViewContract.this).startActivity(paramAnonymousView);
      }
    });
  }
  
  private void k()
  {
    this.j.setText("去支付");
    this.j.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent(MyZiroomCardViewContract.a(MyZiroomCardViewContract.this), LeaseAllBillActivity.class);
        paramAnonymousView.putExtra("sysContractId", MyZiroomCardViewContract.b(MyZiroomCardViewContract.this).getSysContractId());
        paramAnonymousView.putExtra("mContractCode", MyZiroomCardViewContract.b(MyZiroomCardViewContract.this).getContractCode());
        MyZiroomCardViewContract.a(MyZiroomCardViewContract.this).startActivity(paramAnonymousView);
      }
    });
  }
  
  private void l()
  {
    this.j.setText("查看转租详情");
    this.j.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent(MyZiroomCardViewContract.a(MyZiroomCardViewContract.this), SubletInitiatorDetailActivity.class);
        paramAnonymousView.putExtra("contract_code", MyZiroomCardViewContract.b(MyZiroomCardViewContract.this).getContractCode());
        MyZiroomCardViewContract.a(MyZiroomCardViewContract.this).startActivity(paramAnonymousView);
      }
    });
  }
  
  private void m()
  {
    this.j.setText("去确认");
    this.j.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent(MyZiroomCardViewContract.a(MyZiroomCardViewContract.this), ConfirmTerminationActivity.class);
        paramAnonymousView.putExtra("mode", "1");
        paramAnonymousView.putExtra("contractCode", MyZiroomCardViewContract.b(MyZiroomCardViewContract.this).getContractCode());
        MyZiroomCardViewContract.a(MyZiroomCardViewContract.this).startActivity(paramAnonymousView);
      }
    });
  }
  
  private void n()
  {
    this.j.setText("去确认");
    this.j.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent(MyZiroomCardViewContract.a(MyZiroomCardViewContract.this), ContractDataActivity.class);
        paramAnonymousView.putExtra("cityCode", com.ziroom.ziroomcustomer.base.b.d);
        paramAnonymousView.putExtra("old_contract_code", MyZiroomCardViewContract.b(MyZiroomCardViewContract.this).getContractCode());
        MyZiroomCardViewContract.a(MyZiroomCardViewContract.this).startActivity(paramAnonymousView);
        w.onEvent(MyZiroomCardViewContract.a(MyZiroomCardViewContract.this), "change_lease_renew");
      }
    });
  }
  
  private void o()
  {
    this.j.setText("去确认");
    this.j.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        j.getSundHandleList(MyZiroomCardViewContract.c(MyZiroomCardViewContract.this), MyZiroomCardViewContract.b(MyZiroomCardViewContract.this).getContractCode());
      }
    });
  }
  
  private void p()
  {
    this.j.setText("去支付");
    this.j.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if ("1".equals(MyZiroomCardViewContract.b(MyZiroomCardViewContract.this).getContractStrategy())) {
          MyZiroomCardViewContract.a(MyZiroomCardViewContract.this, MyZiroomCardViewContract.b(MyZiroomCardViewContract.this));
        }
        do
        {
          return;
          if (!"2".equals(MyZiroomCardViewContract.b(MyZiroomCardViewContract.this).getContractStrategy())) {
            break;
          }
          if ("0".equals(MyZiroomCardViewContract.b(MyZiroomCardViewContract.this).getPayFeeSource()))
          {
            MyZiroomCardViewContract.b(MyZiroomCardViewContract.this, MyZiroomCardViewContract.b(MyZiroomCardViewContract.this));
            return;
          }
          if ("1".equals(MyZiroomCardViewContract.b(MyZiroomCardViewContract.this).getPayFeeSource()))
          {
            MyZiroomCardViewContract.a(MyZiroomCardViewContract.this, MyZiroomCardViewContract.b(MyZiroomCardViewContract.this));
            return;
          }
        } while (!"2".equals(MyZiroomCardViewContract.b(MyZiroomCardViewContract.this).getPayFeeSource()));
        MyZiroomCardViewContract.c(MyZiroomCardViewContract.this, MyZiroomCardViewContract.b(MyZiroomCardViewContract.this));
        return;
        MyZiroomCardViewContract.a(MyZiroomCardViewContract.this, MyZiroomCardViewContract.b(MyZiroomCardViewContract.this));
      }
    });
  }
  
  private void q()
  {
    this.j.setText("查看");
    this.j.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent(MyZiroomCardViewContract.a(MyZiroomCardViewContract.this), ZxingActivity.class);
        paramAnonymousView.putExtra("contract_part_code", MyZiroomCardViewContract.b(MyZiroomCardViewContract.this).getContractCode());
        paramAnonymousView.putExtra("lease", "lease");
        paramAnonymousView.putExtra("isMyZiroom", "myziroom");
        MyZiroomCardViewContract.a(MyZiroomCardViewContract.this).startActivity(paramAnonymousView);
      }
    });
  }
  
  private void r()
  {
    this.j.setText("查看");
    this.j.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent(MyZiroomCardViewContract.a(MyZiroomCardViewContract.this), WaitDeliveryActivity.class);
        paramAnonymousView.putExtra("wuyewaitdone", "wuyewaitdone");
        paramAnonymousView.putExtra("contract_part_code", MyZiroomCardViewContract.b(MyZiroomCardViewContract.this).getContractCode());
        MyZiroomCardViewContract.a(MyZiroomCardViewContract.this).startActivity(paramAnonymousView);
      }
    });
  }
  
  private void s()
  {
    this.i.setVisibility(0);
    this.i.setText("联系管家");
    this.j.setText("查看解约申请");
    this.i.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent(MyZiroomCardViewContract.a(MyZiroomCardViewContract.this), MyStewardInfoActivity.class);
        paramAnonymousView.putExtra("contractCode", MyZiroomCardViewContract.b(MyZiroomCardViewContract.this).getContractCode());
        MyZiroomCardViewContract.a(MyZiroomCardViewContract.this).startActivity(paramAnonymousView);
      }
    });
    this.j.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent(MyZiroomCardViewContract.a(MyZiroomCardViewContract.this), ConfirmTerminationActivity.class);
        paramAnonymousView.putExtra("mode", "0");
        paramAnonymousView.putExtra("contractCode", MyZiroomCardViewContract.b(MyZiroomCardViewContract.this).getContractCode());
        MyZiroomCardViewContract.a(MyZiroomCardViewContract.this).startActivity(paramAnonymousView);
      }
    });
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (this.q == null) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690326: 
    case 2131690724: 
      paramView = new Intent(this.o, LeaseActivity.class);
      this.o.startActivity(paramView);
      return;
    }
    if ((this.q.getDataType() >= 18) && (this.q.getDataType() <= 26))
    {
      paramView = new Intent(this.o, SubletInitiatorDetailActivity.class);
      paramView.putExtra("contract_code", this.q.getContractCode());
      this.o.startActivity(paramView);
      return;
    }
    paramView = new Intent(this.o, NewLeaseInfoActivity.class);
    paramView.putExtra("contract_code", this.q.getContractCode());
    paramView.putExtra("sysContractId", this.q.getSysContractId());
    this.o.startActivity(paramView);
  }
  
  public void setContract(MyZiroomContract paramMyZiroomContract)
  {
    if (paramMyZiroomContract == null)
    {
      setVisibility(8);
      return;
    }
    setVisibility(0);
    this.q = paramMyZiroomContract;
    setCount(paramMyZiroomContract.getContractCount());
    if (TextUtils.isEmpty(this.q.getPromptTag())) {
      this.k.setVisibility(8);
    }
    while (this.q.getDataType() <= 17)
    {
      this.e.setText(paramMyZiroomContract.getAddress());
      c();
      d();
      return;
      this.k.setVisibility(0);
      this.k.setText(this.q.getPromptTag());
    }
    a(this.e, this.q.firstTitle);
    a(this.f, this.q.secondTitle);
    a(this.g, this.q.thirdTitle);
    b();
  }
  
  public void setCount(int paramInt)
  {
    if (paramInt > 1)
    {
      this.c.setVisibility(0);
      this.d.setVisibility(0);
      return;
    }
    this.c.setVisibility(8);
    this.d.setVisibility(8);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/widget/MyZiroomCardViewContract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */