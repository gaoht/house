package com.ziroom.ziroomcustomer.newServiceList.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.model.AddressMo;
import com.ziroom.ziroomcustomer.newServiceList.model.LabelMo;
import com.ziroom.ziroomcustomer.newServiceList.model.as;
import com.ziroom.ziroomcustomer.newServiceList.utils.i;
import com.ziroom.ziroomcustomer.newServiceList.view.FlowLayoutLimitLine;
import com.ziroom.ziroomcustomer.newServiceList.view.b;
import com.ziroom.ziroomcustomer.newServiceList.view.b.a;
import com.ziroom.ziroomcustomer.newclean.d.al;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;
import com.ziroom.ziroomcustomer.widget.LabeledEditText.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RepairReservationActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private LabeledEditText A;
  private LabeledEditText B;
  private LabeledEditText C;
  private LabeledEditText D;
  private int E = 0;
  private int F = 0;
  private String G;
  private String H;
  private List<String> I = new ArrayList();
  private List<LabelMo> J = new ArrayList();
  private List<as> K;
  private List<String> L = new ArrayList();
  private String M;
  private List<String> N = new ArrayList();
  private List<List<String>> O = new ArrayList();
  private String P;
  private String Q;
  private String R;
  private String S;
  private String T;
  private String U;
  private String V;
  private ArrayList<AddressMo> W;
  private boolean X = false;
  private AddressMo Y;
  private int Z = 0;
  private int a = 333;
  private String aa;
  private String ab;
  private String ac;
  private a ad;
  private a ae;
  private int b = 666;
  private int c = 999;
  private Context d;
  private Intent e;
  private boolean f = false;
  private ImageView g;
  private Button r;
  private SimpleDraweeView s;
  private TextView t;
  private TextView u;
  private View v;
  private RelativeLayout w;
  private FlowLayoutLimitLine x;
  private TextView y;
  private LabeledEditText z;
  
  private void a()
  {
    this.g.setOnClickListener(this);
    this.u.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.z.setOnClickListener(this);
    this.A.setOnClickListener(this);
    this.D.setOnClickListener(this);
  }
  
  private void b()
  {
    this.g = ((ImageView)findViewById(2131689492));
    this.r = ((Button)findViewById(2131692165));
    this.s = ((SimpleDraweeView)findViewById(2131692186));
    this.t = ((TextView)findViewById(2131692187));
    this.u = ((TextView)findViewById(2131691107));
    this.v = findViewById(2131692188);
    this.w = ((RelativeLayout)findViewById(2131690001));
    this.x = ((FlowLayoutLimitLine)findViewById(2131691005));
    this.y = ((TextView)findViewById(2131691243));
    this.z = ((LabeledEditText)findViewById(2131692192));
    this.A = ((LabeledEditText)findViewById(2131689981));
    this.B = ((LabeledEditText)findViewById(2131689982));
    this.ad = new a((EditText)this.B.getTextView(), this.d);
    this.B.addTextChangedListener(this.ad);
    this.C = ((LabeledEditText)findViewById(2131689983));
    this.ae = new a((EditText)this.C.getTextView(), this.d);
    this.C.addTextChangedListener(this.ae);
    this.D = ((LabeledEditText)findViewById(2131691805));
  }
  
  private void d(String paramString)
  {
    TextView localTextView = new TextView(this);
    localTextView.setText(paramString);
    localTextView.setTag(Boolean.valueOf(false));
    localTextView.setTextColor(getResources().getColor(2131624097));
    localTextView.setTextSize(10.0F);
    localTextView.setIncludeFontPadding(false);
    localTextView.setGravity(16);
    localTextView.setPadding(n.dip2px(this.d, 6.0F), 0, n.dip2px(this.d, 6.0F), 0);
    localTextView.setBackgroundResource(2130839367);
    paramString = new LinearLayout.LayoutParams(-2, n.dip2px(this.d, 20.0F));
    paramString.setMargins(0, 0, n.dip2px(this.d, 6.0F), n.dip2px(this.d, 6.0F));
    localTextView.setLayoutParams(paramString);
    this.x.addView(localTextView);
  }
  
  private void e()
  {
    Object localObject = ApplicationEx.c.getUser();
    if (localObject != null)
    {
      this.B.setText(((UserInfo)localObject).getUser_name());
      this.C.setText(((UserInfo)localObject).getLogin_name_mobile());
    }
    localObject = getIntent();
    this.ac = ((Intent)localObject).getStringExtra("orderName");
    this.t.setText(this.ac);
    this.s.setController(c.frescoController(((Intent)localObject).getStringExtra("reservationRes")));
    this.I = ((Intent)localObject).getStringArrayListExtra("tags");
    this.J = ((Intent)localObject).getParcelableArrayListExtra("tagLogicCodes");
    this.R = getIntent().getStringExtra("ServiceInfoId");
    this.S = getIntent().getStringExtra("ServiceInfoName");
    this.ab = ((Intent)localObject).getStringExtra("remark");
    this.T = ((Intent)localObject).getStringExtra("productCode");
    this.U = ((Intent)localObject).getStringExtra("categoryCode");
    this.aa = ((Intent)localObject).getStringExtra("priceUrl");
    f();
    if ((this.I != null) && (this.I.size() > 0)) {
      h();
    }
    while (TextUtils.isEmpty(this.ab))
    {
      this.y.setHint("您没有填写备注信息");
      return;
      this.x.setVisibility(8);
      localObject = (RelativeLayout.LayoutParams)this.y.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).removeRule(3);
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      this.y.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.y.setText(this.ab);
  }
  
  private void f()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("page", Integer.valueOf(1));
    localHashMap.put("pageSize", Integer.valueOf(1000));
    j.getServiceAddressList(this.d, localHashMap, new b());
  }
  
  private void g()
  {
    if ((!"".equals(this.z.getText())) && (!"".equals(this.A.getText())) && (!"".equals(this.B.getText())) && (!"".equals(this.C.getText())))
    {
      this.r.setBackgroundResource(2130839463);
      this.r.setClickable(true);
      return;
    }
    this.r.setBackgroundResource(2131624037);
    this.r.setClickable(false);
  }
  
  private void h()
  {
    Iterator localIterator = this.I.iterator();
    while (localIterator.hasNext()) {
      d((String)localIterator.next());
    }
  }
  
  private void i()
  {
    if (this.Z == 1)
    {
      this.e = new Intent(this.d, ModifyNewAddressActivity.class);
      this.e.putExtra("isAllCity", true);
      startActivityForResult(this.e, this.b);
      return;
    }
    if (this.Z == 2)
    {
      this.e = new Intent(this.d, RepairAddressActivity.class);
      this.e.putParcelableArrayListExtra("addressList", this.W);
      startActivityForResult(this.e, this.c);
      return;
    }
    f();
  }
  
  private void j()
  {
    if (!this.f)
    {
      this.e = new Intent(this.d, ServiceLoginActivity.class);
      startActivity(this.e);
      return;
    }
    this.e = new Intent(this.d, RepairCouponActivity.class);
    this.e.putExtra("categoryCode", this.U);
    this.e.putExtra("productCode", this.T);
    startActivityForResult(this.e, this.a);
  }
  
  private void k()
  {
    showProgress("");
    HashMap localHashMap = new HashMap();
    localHashMap.put("productCode", this.T);
    j.getServiceTimeList(this.d, localHashMap, new c());
  }
  
  private void l()
  {
    if ((this.N != null) && (this.O != null) && (this.N.size() > 0))
    {
      b localb = new b(this, new e(), this.N, this.O);
      localb.setCanceledOnTouchOutside(true);
      Window localWindow = localb.getWindow();
      localWindow.getDecorView().setPadding(0, 0, 0, 0);
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      localWindow.setAttributes(localLayoutParams);
      localWindow.getDecorView().setBackgroundColor(-1);
      localWindow.setGravity(80);
      localb.show();
      localb.getTv_choose().setText("预约时间");
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      View localView = getCurrentFocus();
      if (isShouldHideInput(localView, paramMotionEvent))
      {
        InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
        if (localInputMethodManager != null) {
          localInputMethodManager.hideSoftInputFromWindow(localView.getWindowToken(), 0);
        }
      }
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (getWindow().superDispatchTouchEvent(paramMotionEvent)) {
      return true;
    }
    return onTouchEvent(paramMotionEvent);
  }
  
  public boolean isShouldHideInput(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramView != null)
    {
      bool1 = bool2;
      if ((paramView instanceof EditText))
      {
        int[] arrayOfInt = new int[2];
        int[] tmp29_27 = arrayOfInt;
        tmp29_27[0] = 0;
        int[] tmp33_29 = tmp29_27;
        tmp33_29[1] = 0;
        tmp33_29;
        paramView.getLocationInWindow(arrayOfInt);
        int i = arrayOfInt[0];
        int j = arrayOfInt[1];
        int k = paramView.getHeight();
        int m = paramView.getWidth();
        if ((paramMotionEvent.getX() > i) && (paramMotionEvent.getX() < m + i) && (paramMotionEvent.getY() > j))
        {
          bool1 = bool2;
          if (paramMotionEvent.getY() < k + j) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    LabeledEditText localLabeledEditText;
    StringBuilder localStringBuilder;
    if ((paramInt1 == this.c) && (paramIntent.getParcelableExtra("address") != null))
    {
      this.Y = ((AddressMo)paramIntent.getParcelableExtra("address"));
      this.V = this.Y.getFid();
      localLabeledEditText = this.A;
      localStringBuilder = new StringBuilder().append(this.Y.getVillage());
      if (ae.notNull(this.Y.getDetAddress()))
      {
        str = this.Y.getDetAddress();
        localLabeledEditText.setText(str);
        this.A.getTextView().setEllipsize(TextUtils.TruncateAt.END);
        g();
      }
    }
    else if ((paramInt1 == this.b) && (paramInt2 == -1))
    {
      this.Y = ((AddressMo)paramIntent.getParcelableExtra("savaAddress"));
      this.Z = 2;
      this.V = this.Y.getFid();
      localLabeledEditText = this.A;
      localStringBuilder = new StringBuilder().append(this.Y.getVillage());
      if (!ae.notNull(this.Y.getDetAddress())) {
        break label345;
      }
    }
    label345:
    for (String str = this.Y.getDetAddress();; str = "")
    {
      localLabeledEditText.setText(str);
      this.A.getTextView().setEllipsize(TextUtils.TruncateAt.END);
      g();
      if ((paramInt1 == this.a) && (paramInt2 == -1))
      {
        paramIntent = (al)paramIntent.getSerializableExtra("couponItem");
        this.H = paramIntent.getPromoId();
        this.G = paramIntent.getPromoCode();
        this.F = ((int)paramIntent.getPromoPrice());
        this.D.setText("优惠" + this.F + "元");
      }
      return;
      str = "";
      break;
    }
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    this.f = ApplicationEx.c.isLoginState();
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      finish();
      return;
    case 2131691107: 
      if (!TextUtils.isEmpty(this.aa))
      {
        paramView = new Intent(this.d, RepairWebActivity.class);
        paramView.putExtra("url", this.aa);
        paramView.putExtra("title", "收费标准");
        startActivity(paramView);
        return;
      }
      g.textToast(this.d, "暂无价格提示");
      return;
    case 2131692165: 
      this.r.setClickable(false);
      if (!this.B.getText().matches("^(([一-龥]{1,10})|([a-zA-Z]{1,10}))$"))
      {
        g.textToast(this.d, "名称仅可填写中文或英文");
        this.r.setClickable(true);
        return;
      }
      paramView = this.C.getText();
      if ((TextUtils.isEmpty(paramView)) || (!ah.isMobile(paramView)))
      {
        g.textToast(this.d, "请填写正确的电话号码");
        this.r.setClickable(true);
        return;
      }
      if (!checkNet(this.d))
      {
        g.textToast(this.d, "提交失败，请检查网络后重试");
        return;
      }
      showProgress("");
      HashMap localHashMap = new HashMap();
      localHashMap.put("productCode", this.T);
      localHashMap.put("addressId", this.V);
      localHashMap.put("appointmentDate", this.M);
      localHashMap.put("appointmentTime", this.P);
      localHashMap.put("connectionPhone", paramView);
      localHashMap.put("connectionName", this.B.getText());
      localHashMap.put("userMessage", this.ab);
      localHashMap.put("promotionId", this.H);
      localHashMap.put("promotionCode", this.G);
      localHashMap.put("promotionPrice", Integer.valueOf(this.F));
      localHashMap.put("remarkTags", this.J);
      j.submitOrder(this.d, localHashMap, new d());
      return;
    case 2131692192: 
      if ((this.K == null) || (this.K.size() == 0))
      {
        if (!checkNet(this.d))
        {
          g.textToast(this.d, "请检查网络后重试");
          return;
        }
        k();
        return;
      }
      l();
      return;
    case 2131689981: 
      this.X = true;
      if (!this.f)
      {
        this.e = new Intent(this.d, ServiceLoginActivity.class);
        startActivity(this.e);
        return;
      }
      if (this.Z < 0)
      {
        if (!checkNet(this.d))
        {
          g.textToast(this.d, "请检查网络后重试");
          return;
        }
        showProgress("");
        f();
        return;
      }
      i();
      return;
    }
    j();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setSoftInputMode(35);
    setContentView(2130903452);
    this.d = this;
    showProgress("");
    b();
    a();
    e();
  }
  
  class a
    extends com.ziroom.ziroomcustomer.newServiceList.view.a
    implements LabeledEditText.a
  {
    public a(EditText paramEditText, Context paramContext)
    {
      super(paramContext);
    }
    
    public void afterTextChanged(Editable paramEditable)
    {
      super.afterTextChanged(paramEditable);
      RepairReservationActivity.f(RepairReservationActivity.this);
    }
  }
  
  class b
    implements i.a<String>
  {
    b() {}
    
    public void onParse(String paramString, k paramk)
    {
      paramString = com.alibaba.fastjson.a.parseObject(paramString);
      if ("0".equals((String)paramString.get("status")))
      {
        if (paramString.get("data") == null)
        {
          paramk.setSuccess(Boolean.valueOf(true));
          paramk.setObject(null);
          return;
        }
        paramString = com.alibaba.fastjson.a.parseArray(paramString.get("data").toString(), AddressMo.class);
        paramk.setSuccess(Boolean.valueOf(true));
        paramk.setObject(paramString);
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage((String)paramString.get("message"));
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        RepairReservationActivity.a(RepairReservationActivity.this, null);
        RepairReservationActivity.a(RepairReservationActivity.this, (ArrayList)paramk.getObject());
        if ((RepairReservationActivity.a(RepairReservationActivity.this) != null) && (RepairReservationActivity.a(RepairReservationActivity.this).size() > 0)) {
          RepairReservationActivity.a(RepairReservationActivity.this, 2);
        }
        for (;;)
        {
          RepairReservationActivity.this.dismissProgress();
          if (RepairReservationActivity.b(RepairReservationActivity.this)) {
            RepairReservationActivity.c(RepairReservationActivity.this);
          }
          RepairReservationActivity.a(RepairReservationActivity.this, false);
          return;
          RepairReservationActivity.a(RepairReservationActivity.this, 1);
        }
      }
      paramk = paramk.getMessage();
      if (paramk != null) {
        g.textToast(RepairReservationActivity.d(RepairReservationActivity.this), paramk);
      }
      for (;;)
      {
        RepairReservationActivity.e(RepairReservationActivity.this);
        RepairReservationActivity.this.dismissProgress();
        break;
        g.textToast(RepairReservationActivity.d(RepairReservationActivity.this), "服务器访问失败，请稍后再试");
      }
    }
  }
  
  class c
    implements i.a<String>
  {
    c() {}
    
    public void onParse(String paramString, k paramk)
    {
      paramString = com.alibaba.fastjson.a.parseObject(paramString);
      if ("0".equals((String)paramString.get("status")))
      {
        paramString = com.alibaba.fastjson.a.parseArray(paramString.get("data").toString(), as.class);
        paramk.setSuccess(Boolean.valueOf(true));
        paramk.setObject(paramString);
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage((String)paramString.get("message"));
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        RepairReservationActivity.a(RepairReservationActivity.this, null);
        RepairReservationActivity.l(RepairReservationActivity.this).clear();
        RepairReservationActivity.m(RepairReservationActivity.this).clear();
        RepairReservationActivity.n(RepairReservationActivity.this).clear();
        RepairReservationActivity.a(RepairReservationActivity.this, (List)paramk.getObject());
        if ((RepairReservationActivity.o(RepairReservationActivity.this) != null) && (RepairReservationActivity.o(RepairReservationActivity.this).size() > 0))
        {
          paramk = RepairReservationActivity.o(RepairReservationActivity.this).iterator();
          while (paramk.hasNext())
          {
            as localas = (as)paramk.next();
            RepairReservationActivity.l(RepairReservationActivity.this).add(localas.getAppointmentDate());
            RepairReservationActivity.m(RepairReservationActivity.this).add(i.getTimePick(localas.getAppointmentDateWeek(), localas.getAppointmentDate(), localas.getNowTime()));
            if ((localas.getTime() != null) && (localas.getTime().size() > 0))
            {
              RepairReservationActivity.n(RepairReservationActivity.this).add(localas.getTime());
            }
            else
            {
              RepairReservationActivity.a(RepairReservationActivity.this, null);
              g.textToast(RepairReservationActivity.d(RepairReservationActivity.this), "获取服务时间失败");
            }
          }
          RepairReservationActivity.p(RepairReservationActivity.this);
        }
        for (;;)
        {
          RepairReservationActivity.this.dismissProgress();
          return;
          g.textToast(RepairReservationActivity.d(RepairReservationActivity.this), "获取服务时间失败");
        }
      }
      paramk = paramk.getMessage();
      if (paramk != null) {
        g.textToast(RepairReservationActivity.d(RepairReservationActivity.this), paramk);
      }
      for (;;)
      {
        RepairReservationActivity.this.dismissProgress();
        return;
        g.textToast(RepairReservationActivity.d(RepairReservationActivity.this), "服务器访问失败，无法获取服务时间");
      }
    }
  }
  
  class d
    implements i.a<String>
  {
    d() {}
    
    public void onParse(String paramString, k paramk)
    {
      paramString = com.alibaba.fastjson.a.parseObject(paramString);
      if ("0".equals((String)paramString.get("status")))
      {
        paramk.setSuccess(Boolean.valueOf(true));
        paramk.setObject(null);
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage((String)paramString.get("message"));
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        g.textToast(RepairReservationActivity.d(RepairReservationActivity.this), "提交成功");
        paramk = new Intent(RepairReservationActivity.d(RepairReservationActivity.this), AppointmentSuccessActivity.class);
        paramk.putExtra("title", RepairReservationActivity.g(RepairReservationActivity.this));
        paramk.putExtra("time", RepairReservationActivity.h(RepairReservationActivity.this).getText());
        paramk.putExtra("address", RepairReservationActivity.i(RepairReservationActivity.this).getText());
        paramk.putExtra("name", RepairReservationActivity.j(RepairReservationActivity.this).getText());
        paramk.putExtra("phone", RepairReservationActivity.k(RepairReservationActivity.this).getText());
        RepairReservationActivity.this.setResult(-1, paramk);
        RepairReservationActivity.this.startActivity(paramk);
        RepairReservationActivity.this.dismissProgress();
        RepairReservationActivity.this.finish();
        return;
      }
      paramk = paramk.getMessage();
      if (paramk != null) {
        g.textToast(RepairReservationActivity.d(RepairReservationActivity.this), paramk);
      }
      for (;;)
      {
        RepairReservationActivity.this.dismissProgress();
        return;
        g.textToast(RepairReservationActivity.d(RepairReservationActivity.this), "修改地址失败，请重试");
      }
    }
  }
  
  public class e
    implements b.a
  {
    public e() {}
    
    public void showHour(String paramString, int paramInt)
    {
      RepairReservationActivity.a(RepairReservationActivity.this, (String)RepairReservationActivity.l(RepairReservationActivity.this).get(paramInt));
      RepairReservationActivity.b(RepairReservationActivity.this, "");
      RepairReservationActivity.c(RepairReservationActivity.this, paramString);
      RepairReservationActivity.h(RepairReservationActivity.this).setText(RepairReservationActivity.q(RepairReservationActivity.this) + "   " + RepairReservationActivity.r(RepairReservationActivity.this));
      RepairReservationActivity.f(RepairReservationActivity.this);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/activity/RepairReservationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */