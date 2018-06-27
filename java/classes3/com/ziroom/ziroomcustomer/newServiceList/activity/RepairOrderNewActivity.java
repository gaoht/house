package com.ziroom.ziroomcustomer.newServiceList.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.newServiceList.a.i;
import com.ziroom.ziroomcustomer.newServiceList.model.LabelMo;
import com.ziroom.ziroomcustomer.newServiceList.model.an;
import com.ziroom.ziroomcustomer.newServiceList.view.FlowLayoutLimitLine;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import com.ziroom.ziroomcustomer.widget.HomeZiroGridView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RepairOrderNewActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private int A;
  private HomeZiroGridView B;
  private View C;
  private LinearLayout D;
  private int E;
  private FlowLayoutLimitLine F;
  private RelativeLayout.LayoutParams G;
  private ArrayList<String> H = new ArrayList();
  private ArrayList<String> I = new ArrayList();
  private List<LabelMo> J;
  private ArrayList<LabelMo> K = new ArrayList();
  private int L = -1;
  private i M;
  private List<an> N;
  private String O;
  private String P;
  private c Q;
  private int a = 888;
  private Context b;
  private ImageView c;
  private TextView d;
  private ScrollView e;
  private RelativeLayout f;
  private LinearLayout g;
  private EditText r;
  private TextView s;
  private TextView t;
  private TextView u;
  private RelativeLayout v;
  private TextView w;
  private ImageView x;
  private Button y;
  private RelativeLayout z;
  
  private long a(CharSequence paramCharSequence)
  {
    double d1 = 0.0D;
    int i = 0;
    if (i < paramCharSequence.length())
    {
      int j = paramCharSequence.charAt(i);
      if ((j > 0) && (j < 127)) {}
      for (d1 += 0.5D;; d1 += 1.0D)
      {
        i += 1;
        break;
      }
    }
    return Math.round(d1);
  }
  
  private void a()
  {
    this.c.setOnClickListener(this);
    this.x.setOnClickListener(this);
    this.y.setOnClickListener(this);
  }
  
  private void b()
  {
    this.c = ((ImageView)findViewById(2131689492));
    this.d = ((TextView)findViewById(2131689541));
    this.e = ((ScrollView)findViewById(2131692166));
    this.f = ((RelativeLayout)findViewById(2131692167));
    this.g = ((LinearLayout)findViewById(2131692182));
    this.B = ((HomeZiroGridView)findViewById(2131692170));
    this.C = findViewById(2131692171);
    this.D = ((LinearLayout)findViewById(2131691538));
    this.F = ((FlowLayoutLimitLine)findViewById(2131691005));
    this.r = ((EditText)findViewById(2131690002));
    this.Q = new c(this.r, this.b);
    this.r.addTextChangedListener(this.Q);
    this.s = ((TextView)findViewById(2131692177));
    this.t = ((TextView)findViewById(2131692179));
    this.u = ((TextView)findViewById(2131692181));
    this.v = ((RelativeLayout)findViewById(2131691806));
    this.z = ((RelativeLayout)findViewById(2131692168));
    this.w = ((TextView)findViewById(2131689912));
    this.x = ((ImageView)findViewById(2131692164));
    this.y = ((Button)findViewById(2131692165));
  }
  
  private void b(int paramInt)
  {
    Object localObject = (an)this.N.get(paramInt);
    this.J = ((an)localObject).getTags();
    if ((this.J != null) && (this.J.size() > 0))
    {
      this.F.setVisibility(0);
      localObject = ((an)localObject).getTags().iterator();
    }
    while (((Iterator)localObject).hasNext())
    {
      e(((LabelMo)((Iterator)localObject).next()).getTagName());
      continue;
      this.F.setVisibility(8);
    }
  }
  
  private void d(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("categoryCode", paramString);
    j.getServiceData(this.b, localHashMap, new b());
  }
  
  private void e()
  {
    this.O = getIntent().getStringExtra("serviceInfoId");
    this.P = getIntent().getStringExtra("serviceInfoName");
    this.d.setText(this.P + "");
    if (("10101014".equals(this.O)) || ("10101016".equals(this.O)))
    {
      this.s.setText("常规可选上门时间：9：00 - 20：00 \n当天18点之前下单会为您安排在第二天；\n当天18点之后下单会为您安排在第三天；\n自如工匠会与您协商确认具体上门时间。");
      this.t.setText("用户预约服务后，自如工匠联系用户确认信息以便更好的为用户服务；自如工匠上门后现场服务流程为：检测-与用户确认价格-自如工匠清洗服务-用户检查服务结果并线上支付-自如工匠清理服务垃圾后离开");
    }
    for (;;)
    {
      this.u.setText("服务范围支持：六环内所有城区及昌平区，顺义区");
      if (checkNet(this.b)) {
        break;
      }
      g.textToast(this.b, "请检查网络连接");
      this.g.setVisibility(0);
      showEmpty(this.g, "请检查网络连接");
      return;
      this.s.setText("常规可选上门时间：9：00 - 20：00 至少提前两个小时预约\n18点后，最早可预约第二天9点\n19点后，最早可预约第二天10点\n20点后，最早可预约第二天11点\n如指定其他时间上门，需要加收上门费用");
      this.t.setText("用户预约服务后，自如工匠联系用户确认报修信息以便更好的为用户服务；自如工匠上门后现场服务流程为：检测-与用户确认价格-自如工匠维修-用户检查服务结果并线上支付-自如工匠清理服务垃圾后离开");
    }
    d(this.O);
  }
  
  private void e(String paramString)
  {
    TextView localTextView = new TextView(this);
    localTextView.setText(paramString);
    localTextView.setTag(Boolean.valueOf(false));
    localTextView.setTextColor(getResources().getColor(2131624097));
    localTextView.setTextSize(12.0F);
    localTextView.setIncludeFontPadding(false);
    localTextView.setGravity(16);
    localTextView.setPadding(n.dip2px(this.b, 6.0F), 0, n.dip2px(this.b, 6.0F), 0);
    localTextView.setBackgroundResource(2130839367);
    paramString = new LinearLayout.LayoutParams(-2, n.dip2px(this.b, 26.0F));
    paramString.setMargins(0, n.dip2px(this.b, 6.0F), n.dip2px(this.b, 6.0F), 0);
    localTextView.setLayoutParams(paramString);
    localTextView.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = (TextView)paramAnonymousView;
        String str = paramAnonymousView.getText().toString();
        if (!((Boolean)paramAnonymousView.getTag()).booleanValue())
        {
          paramAnonymousView.setBackgroundResource(2130839373);
          paramAnonymousView.setTextColor(RepairOrderNewActivity.this.getResources().getColor(2131624583));
          paramAnonymousView.setTag(Boolean.valueOf(true));
          RepairOrderNewActivity.a(RepairOrderNewActivity.this, str);
          return;
        }
        paramAnonymousView.setBackgroundResource(2130839367);
        paramAnonymousView.setTextColor(RepairOrderNewActivity.this.getResources().getColor(2131624097));
        paramAnonymousView.setTag(Boolean.valueOf(false));
        RepairOrderNewActivity.b(RepairOrderNewActivity.this, str);
      }
    });
    this.F.addView(localTextView);
  }
  
  private void f()
  {
    this.G = ((RelativeLayout.LayoutParams)this.D.getLayoutParams());
    this.G.addRule(8, 2131692168);
    this.z.post(new Runnable()
    {
      public void run()
      {
        RepairOrderNewActivity.d(RepairOrderNewActivity.this, RepairOrderNewActivity.u(RepairOrderNewActivity.this).getMeasuredHeight());
      }
    });
  }
  
  private void f(String paramString)
  {
    this.H.add(paramString);
    Iterator localIterator = this.J.iterator();
    while (localIterator.hasNext())
    {
      LabelMo localLabelMo = (LabelMo)localIterator.next();
      if (paramString.equals(localLabelMo.getTagName()))
      {
        this.K.add(localLabelMo);
        this.I.add(localLabelMo.getLogicCode());
      }
    }
  }
  
  private void g()
  {
    ValueAnimator localValueAnimator = ObjectAnimator.ofInt(new int[] { this.A - this.E, this.A });
    localValueAnimator.setTarget(this.D);
    localValueAnimator.setDuration(500L);
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        RepairOrderNewActivity.i(RepairOrderNewActivity.this).setVisibility(0);
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        RepairOrderNewActivity.j(RepairOrderNewActivity.this).setMargins(0, i, 0, 0);
        RepairOrderNewActivity.i(RepairOrderNewActivity.this).setLayoutParams(RepairOrderNewActivity.j(RepairOrderNewActivity.this));
      }
    });
    localValueAnimator.start();
  }
  
  private void g(String paramString)
  {
    this.H.remove(paramString);
    Iterator localIterator = this.J.iterator();
    while (localIterator.hasNext())
    {
      LabelMo localLabelMo = (LabelMo)localIterator.next();
      if (paramString.equals(localLabelMo.getTagName()))
      {
        this.K.remove(localLabelMo);
        this.I.remove(localLabelMo.getLogicCode());
      }
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
    if ((paramInt1 == this.a) && (paramInt2 == -1)) {
      finish();
    }
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    int i = 0;
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      finish();
      return;
      paramView = (String)this.x.getTag();
      if (!TextUtils.isEmpty(paramView))
      {
        JsBridgeWebActivity.start(this.b, "收费标准", paramView, false, "", "", false);
        return;
      }
      g.textToast(this.b, "暂无价格提示");
      return;
    } while (("10101014".equals(this.O)) && (this.L == -1));
    paramView = new Intent(this.b, RepairReservationActivity.class);
    Object localObject = this.M;
    if (this.L == -1) {}
    for (;;)
    {
      localObject = ((i)localObject).getRepairItem(i);
      paramView.putExtra("productCode", ((an)localObject).getLogicCode());
      paramView.putExtra("priceUrl", ((an)localObject).getPriceUrl());
      paramView.putExtra("categoryCode", ((an)localObject).getCategoryCode());
      paramView.putExtra("orderName", this.P + "-" + ((an)localObject).getProductName());
      paramView.putExtra("remark", VdsAgent.trackEditTextSilent(this.r).toString());
      paramView.putExtra("reservationRes", ((an)localObject).getSmallImgUrl());
      paramView.putStringArrayListExtra("tags", this.H);
      paramView.putParcelableArrayListExtra("tagLogicCodes", this.K);
      startActivityForResult(paramView, this.a);
      return;
      i = this.L;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setSoftInputMode(35);
    setContentView(2130903449);
    this.b = this;
    showProgress("");
    b();
    a();
    e();
  }
  
  class a
    implements AdapterView.OnItemClickListener
  {
    a() {}
    
    @Instrumented
    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      VdsAgent.onItemClick(this, paramAdapterView, paramView, paramInt, paramLong);
      if (RepairOrderNewActivity.a(RepairOrderNewActivity.this) == null) {}
      do
      {
        return;
        paramAdapterView = (an)RepairOrderNewActivity.a(RepairOrderNewActivity.this).get(paramInt);
        if (RepairOrderNewActivity.b(RepairOrderNewActivity.this) == -1)
        {
          RepairOrderNewActivity.a(RepairOrderNewActivity.this, paramInt);
          RepairOrderNewActivity.c(RepairOrderNewActivity.this).setItemSelected(paramInt);
          RepairOrderNewActivity.b(RepairOrderNewActivity.this, paramInt);
          RepairOrderNewActivity.d(RepairOrderNewActivity.this).setVisibility(0);
          RepairOrderNewActivity.e(RepairOrderNewActivity.this).setVisibility(0);
          RepairOrderNewActivity.f(RepairOrderNewActivity.this).setBackgroundResource(2130839463);
          RepairOrderNewActivity.f(RepairOrderNewActivity.this).setClickable(true);
          paramView = new SpannableString(paramAdapterView.getProductPrice() + "元起");
          paramView.setSpan(new ForegroundColorSpan(RepairOrderNewActivity.this.getResources().getColor(2131624529)), 0, paramAdapterView.getProductPrice().toString().length(), 33);
          RepairOrderNewActivity.g(RepairOrderNewActivity.this).setText(paramView);
          RepairOrderNewActivity.h(RepairOrderNewActivity.this).setTag(paramAdapterView.getPriceUrl());
          RepairOrderNewActivity.i(RepairOrderNewActivity.this).post(new Runnable()
          {
            public void run()
            {
              RepairOrderNewActivity.c(RepairOrderNewActivity.this, RepairOrderNewActivity.i(RepairOrderNewActivity.this).getMeasuredHeight());
              RepairOrderNewActivity.j(RepairOrderNewActivity.this).removeRule(8);
              RepairOrderNewActivity.k(RepairOrderNewActivity.this);
            }
          });
          return;
        }
      } while (RepairOrderNewActivity.b(RepairOrderNewActivity.this) == paramInt);
      RepairOrderNewActivity.a(RepairOrderNewActivity.this, paramInt);
      RepairOrderNewActivity.c(RepairOrderNewActivity.this).setItemSelected(paramInt);
      RepairOrderNewActivity.l(RepairOrderNewActivity.this).removeAllViews();
      RepairOrderNewActivity.m(RepairOrderNewActivity.this).clear();
      RepairOrderNewActivity.n(RepairOrderNewActivity.this).clear();
      RepairOrderNewActivity.o(RepairOrderNewActivity.this).clear();
      RepairOrderNewActivity.b(RepairOrderNewActivity.this, paramInt);
      paramView = new SpannableString(paramAdapterView.getProductPrice() + "元起");
      paramView.setSpan(new ForegroundColorSpan(RepairOrderNewActivity.this.getResources().getColor(2131624529)), 0, paramAdapterView.getProductPrice().toString().length(), 33);
      RepairOrderNewActivity.g(RepairOrderNewActivity.this).setText(paramView);
      RepairOrderNewActivity.h(RepairOrderNewActivity.this).setTag(paramAdapterView.getPriceUrl());
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
        paramString = com.alibaba.fastjson.a.parseArray(paramString.get("data").toString(), an.class);
        paramk.setSuccess(Boolean.valueOf(true));
        paramk.setObject(paramString);
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage((String)paramString.get("message"));
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue()) {
        try
        {
          RepairOrderNewActivity.a(RepairOrderNewActivity.this, (List)paramk.getObject());
          if ((RepairOrderNewActivity.a(RepairOrderNewActivity.this) != null) && (RepairOrderNewActivity.a(RepairOrderNewActivity.this).size() > 0))
          {
            RepairOrderNewActivity.a(RepairOrderNewActivity.this, new i(RepairOrderNewActivity.p(RepairOrderNewActivity.this), RepairOrderNewActivity.a(RepairOrderNewActivity.this)));
            RepairOrderNewActivity.q(RepairOrderNewActivity.this).setAdapter(RepairOrderNewActivity.c(RepairOrderNewActivity.this));
            if ("10101014".equals(RepairOrderNewActivity.r(RepairOrderNewActivity.this)))
            {
              paramk = (an)RepairOrderNewActivity.a(RepairOrderNewActivity.this).get(0);
              RepairOrderNewActivity.a(RepairOrderNewActivity.this, (RelativeLayout.LayoutParams)RepairOrderNewActivity.i(RepairOrderNewActivity.this).getLayoutParams());
              RepairOrderNewActivity.j(RepairOrderNewActivity.this).addRule(3, 2131692168);
              RepairOrderNewActivity.b(RepairOrderNewActivity.this, 0);
              RepairOrderNewActivity.d(RepairOrderNewActivity.this).setVisibility(0);
              RepairOrderNewActivity.e(RepairOrderNewActivity.this).setVisibility(0);
              RepairOrderNewActivity.f(RepairOrderNewActivity.this).setBackgroundResource(2130839463);
              RepairOrderNewActivity.f(RepairOrderNewActivity.this).setClickable(true);
              SpannableString localSpannableString = new SpannableString(paramk.getProductPrice() + "元起");
              localSpannableString.setSpan(new ForegroundColorSpan(RepairOrderNewActivity.this.getResources().getColor(2131624529)), 0, paramk.getProductPrice().toString().length(), 33);
              RepairOrderNewActivity.g(RepairOrderNewActivity.this).setText(localSpannableString);
              RepairOrderNewActivity.h(RepairOrderNewActivity.this).setTag(paramk.getPriceUrl());
              RepairOrderNewActivity.this.dismissProgress();
              return;
            }
          }
        }
        catch (ClassCastException paramk)
        {
          for (;;)
          {
            paramk.printStackTrace();
            continue;
            RepairOrderNewActivity.q(RepairOrderNewActivity.this).setOnItemClickListener(new RepairOrderNewActivity.a(RepairOrderNewActivity.this));
            RepairOrderNewActivity.s(RepairOrderNewActivity.this);
          }
          RepairOrderNewActivity.t(RepairOrderNewActivity.this).setVisibility(0);
          RepairOrderNewActivity.this.showEmpty(RepairOrderNewActivity.t(RepairOrderNewActivity.this), "数据异常，请重试");
          g.textToast(RepairOrderNewActivity.p(RepairOrderNewActivity.this), "获取数据失败，请重试");
          RepairOrderNewActivity.s(RepairOrderNewActivity.this);
          RepairOrderNewActivity.this.dismissProgress();
          return;
        }
      }
      RepairOrderNewActivity.t(RepairOrderNewActivity.this).setVisibility(0);
      RepairOrderNewActivity.this.showEmpty(RepairOrderNewActivity.t(RepairOrderNewActivity.this), "服务器访问失败，请稍后再试");
      paramk = paramk.getMessage();
      RepairOrderNewActivity.s(RepairOrderNewActivity.this);
      if (paramk != null) {
        g.textToast(RepairOrderNewActivity.p(RepairOrderNewActivity.this), paramk);
      }
      for (;;)
      {
        RepairOrderNewActivity.this.dismissProgress();
        return;
        g.textToast(RepairOrderNewActivity.p(RepairOrderNewActivity.this), "服务器访问失败，无法获取数据");
      }
    }
  }
  
  class c
    extends com.ziroom.ziroomcustomer.newServiceList.view.a
  {
    private int b;
    private int c;
    
    public c(EditText paramEditText, Context paramContext)
    {
      super(paramContext);
    }
    
    public void afterTextChanged(Editable paramEditable)
    {
      super.afterTextChanged(paramEditable);
      this.b = RepairOrderNewActivity.v(RepairOrderNewActivity.this).getSelectionStart();
      this.c = RepairOrderNewActivity.v(RepairOrderNewActivity.this).getSelectionEnd();
      RepairOrderNewActivity.v(RepairOrderNewActivity.this).removeTextChangedListener(RepairOrderNewActivity.w(RepairOrderNewActivity.this));
      while (RepairOrderNewActivity.a(RepairOrderNewActivity.this, paramEditable.toString()) > 100L)
      {
        paramEditable.delete(this.b - 1, this.c);
        this.b -= 1;
        this.c -= 1;
      }
      RepairOrderNewActivity.v(RepairOrderNewActivity.this).setSelection(this.b);
      RepairOrderNewActivity.v(RepairOrderNewActivity.this).addTextChangedListener(RepairOrderNewActivity.w(RepairOrderNewActivity.this));
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      super.beforeTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    }
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/activity/RepairOrderNewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */