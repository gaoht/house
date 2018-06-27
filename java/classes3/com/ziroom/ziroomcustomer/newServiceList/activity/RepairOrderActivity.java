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
import com.ziroom.ziroomcustomer.newServiceList.a.h;
import com.ziroom.ziroomcustomer.newServiceList.model.LabelMo;
import com.ziroom.ziroomcustomer.newServiceList.model.an;
import com.ziroom.ziroomcustomer.newServiceList.view.FlowLayoutLimitLine;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.widget.HomeZiroGridView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RepairOrderActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private int A;
  private HomeZiroGridView B;
  private h C;
  private View D;
  private LinearLayout E;
  private int F;
  private FlowLayoutLimitLine G;
  private RelativeLayout.LayoutParams H;
  private ArrayList<String> I = new ArrayList();
  private ArrayList<String> J = new ArrayList();
  private List<LabelMo> K;
  private ArrayList<LabelMo> L = new ArrayList();
  private int M = -1;
  private int N = -1;
  private c O;
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
  
  private void a(List<an> paramList)
  {
    int j = this.C.getCount();
    int i = 0;
    while (i < j)
    {
      an localan1 = this.C.getRepairItem(i);
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        an localan2 = (an)localIterator.next();
        if (localan1.getLogicCode().equals(localan2.getLogicCode()))
        {
          localan1.setProductName(localan2.getProductName());
          localan1.setName(localan2.getProductName());
          localan1.setCategoryCode(localan2.getCategoryCode());
          localan1.setPriceUrl(localan2.getPriceUrl());
          localan1.setProductPrice(localan2.getProductPrice());
          localan1.setTags(localan2.getTags());
          localan1.setOffImgUrl(localan2.getOffImgUrl());
          localan1.setOnImgUrl(localan2.getOnImgUrl());
          localan1.setCityCode(localan2.getCityCode());
          paramList.remove(localan2);
          this.C.setRepairItem(i, localan1);
        }
      }
      i += 1;
    }
  }
  
  private void b()
  {
    this.c = ((ImageView)findViewById(2131689492));
    this.d = ((TextView)findViewById(2131689541));
    this.e = ((ScrollView)findViewById(2131692166));
    this.f = ((RelativeLayout)findViewById(2131692167));
    this.g = ((LinearLayout)findViewById(2131692182));
    this.B = ((HomeZiroGridView)findViewById(2131692170));
    this.D = findViewById(2131692171);
    this.E = ((LinearLayout)findViewById(2131691538));
    this.G = ((FlowLayoutLimitLine)findViewById(2131691005));
    this.r = ((EditText)findViewById(2131690002));
    this.O = new c(this.r, this.b);
    this.r.addTextChangedListener(this.O);
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
    Object localObject = this.C.getRepairItem(paramInt);
    this.K = ((an)localObject).getTags();
    if ((this.K != null) && (this.K.size() > 0))
    {
      this.G.setVisibility(0);
      localObject = ((an)localObject).getTags().iterator();
    }
    while (((Iterator)localObject).hasNext())
    {
      e(((LabelMo)((Iterator)localObject).next()).getTagName());
      continue;
      this.G.setVisibility(8);
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
    this.N = getIntent().getIntExtra("type", 1);
    this.d.setText(g());
    this.C = new h(this.b, this.N);
    this.B.setAdapter(this.C);
    String str = "";
    switch (this.N)
    {
    default: 
      if (this.N == 3)
      {
        this.s.setText("常规可选上门时间：9：00 - 20：00 \n当天18点之前下单会为您安排在第二天；\n当天18点之后下单会为您安排在第三天；\n自如工匠会与您协商确认具体上门时间。");
        this.t.setText("用户预约服务后，自如工匠联系用户确认信息以便更好的为用户服务；自如工匠上门后现场服务流程为：检测-与用户确认价格-自如工匠清洗服务-用户检查服务结果并线上支付-自如工匠清理服务垃圾后离开");
      }
      break;
    }
    for (;;)
    {
      this.u.setText("服务范围支持：六环内所有城区及昌平区，顺义区");
      if (checkNet(this.b)) {
        break label225;
      }
      g.textToast(this.b, "请检查网络连接");
      this.g.setVisibility(0);
      showEmpty(this.g, "请检查网络连接");
      return;
      str = "10101012";
      break;
      str = "10101010";
      break;
      str = "10101011";
      break;
      str = "10101014";
      break;
      this.s.setText("常规可选上门时间：9：00 - 20：00 至少提前两个小时预约\n18点后，最早可预约第二天9点\n19点后，最早可预约第二天10点\n20点后，最早可预约第二天11点\n如指定其他时间上门，需要加收上门费用");
      this.t.setText("用户预约服务后，自如工匠联系用户确认报修信息以便更好的为用户服务；自如工匠上门后现场服务流程为：检测-与用户确认价格-自如工匠维修-用户检查服务结果并线上支付-自如工匠清理服务垃圾后离开");
    }
    label225:
    d(str);
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
          paramAnonymousView.setTextColor(RepairOrderActivity.this.getResources().getColor(2131624583));
          paramAnonymousView.setTag(Boolean.valueOf(true));
          RepairOrderActivity.a(RepairOrderActivity.this, str);
          return;
        }
        paramAnonymousView.setBackgroundResource(2130839367);
        paramAnonymousView.setTextColor(RepairOrderActivity.this.getResources().getColor(2131624097));
        paramAnonymousView.setTag(Boolean.valueOf(false));
        RepairOrderActivity.b(RepairOrderActivity.this, str);
      }
    });
    this.G.addView(localTextView);
  }
  
  private void f()
  {
    this.H = ((RelativeLayout.LayoutParams)this.E.getLayoutParams());
    this.H.addRule(8, 2131692168);
    this.z.post(new Runnable()
    {
      public void run()
      {
        RepairOrderActivity.d(RepairOrderActivity.this, RepairOrderActivity.t(RepairOrderActivity.this).getMeasuredHeight());
      }
    });
  }
  
  private void f(String paramString)
  {
    this.I.add(paramString);
    Iterator localIterator = this.K.iterator();
    while (localIterator.hasNext())
    {
      LabelMo localLabelMo = (LabelMo)localIterator.next();
      if (paramString.equals(localLabelMo.getTagName()))
      {
        this.L.add(localLabelMo);
        this.J.add(localLabelMo.getLogicCode());
      }
    }
  }
  
  private String g()
  {
    switch (this.N)
    {
    default: 
      return "";
    case 0: 
      return "水路管件";
    case 1: 
      return "灯具电路";
    case 2: 
      return "开锁换锁";
    }
    return "空调清洗";
  }
  
  private void g(String paramString)
  {
    this.I.remove(paramString);
    Iterator localIterator = this.K.iterator();
    while (localIterator.hasNext())
    {
      LabelMo localLabelMo = (LabelMo)localIterator.next();
      if (paramString.equals(localLabelMo.getTagName()))
      {
        this.L.remove(localLabelMo);
        this.J.remove(localLabelMo.getLogicCode());
      }
    }
  }
  
  private void h()
  {
    ValueAnimator localValueAnimator = ObjectAnimator.ofInt(new int[] { this.A - this.F, this.A });
    localValueAnimator.setTarget(this.E);
    localValueAnimator.setDuration(500L);
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        RepairOrderActivity.h(RepairOrderActivity.this).setVisibility(0);
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        RepairOrderActivity.i(RepairOrderActivity.this).setMargins(0, i, 0, 0);
        RepairOrderActivity.h(RepairOrderActivity.this).setLayoutParams(RepairOrderActivity.i(RepairOrderActivity.this));
      }
    });
    localValueAnimator.start();
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
        localObject = new Intent(this.b, RepairWebActivity.class);
        ((Intent)localObject).putExtra("title", "收费标准");
        ((Intent)localObject).putExtra("url", paramView);
        startActivity((Intent)localObject);
        return;
      }
      g.textToast(this.b, "暂无价格提示");
      return;
    } while ((this.N != 3) && (this.M == -1));
    paramView = new Intent(this.b, RepairReservationActivity.class);
    Object localObject = this.C;
    if (this.M == -1) {}
    for (int i = 0;; i = this.M)
    {
      localObject = ((h)localObject).getRepairItem(i);
      paramView.putExtra("productCode", ((an)localObject).getLogicCode());
      paramView.putExtra("priceUrl", ((an)localObject).getPriceUrl());
      paramView.putExtra("categoryCode", ((an)localObject).getCategoryCode());
      paramView.putExtra("orderName", g() + "-" + ((an)localObject).getName());
      paramView.putExtra("remark", VdsAgent.trackEditTextSilent(this.r).toString());
      paramView.putExtra("reservationRes", ((an)localObject).getReservationRes());
      paramView.putStringArrayListExtra("tags", this.I);
      paramView.putParcelableArrayListExtra("tagLogicCodes", this.L);
      startActivityForResult(paramView, this.a);
      return;
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
      paramAdapterView = RepairOrderActivity.a(RepairOrderActivity.this).getRepairItem(paramInt);
      if (RepairOrderActivity.b(RepairOrderActivity.this) == -1)
      {
        RepairOrderActivity.a(RepairOrderActivity.this, paramInt);
        RepairOrderActivity.a(RepairOrderActivity.this).setItemSelected(paramInt);
        RepairOrderActivity.b(RepairOrderActivity.this, paramInt);
        RepairOrderActivity.c(RepairOrderActivity.this).setVisibility(0);
        RepairOrderActivity.d(RepairOrderActivity.this).setVisibility(0);
        RepairOrderActivity.e(RepairOrderActivity.this).setBackgroundResource(2130839463);
        RepairOrderActivity.e(RepairOrderActivity.this).setClickable(true);
        paramView = new SpannableString(paramAdapterView.getProductPrice() + "元起");
        paramView.setSpan(new ForegroundColorSpan(RepairOrderActivity.this.getResources().getColor(2131624529)), 0, paramAdapterView.getProductPrice().toString().length(), 33);
        RepairOrderActivity.f(RepairOrderActivity.this).setText(paramView);
        RepairOrderActivity.g(RepairOrderActivity.this).setTag(paramAdapterView.getPriceUrl());
        RepairOrderActivity.h(RepairOrderActivity.this).post(new Runnable()
        {
          public void run()
          {
            RepairOrderActivity.c(RepairOrderActivity.this, RepairOrderActivity.h(RepairOrderActivity.this).getMeasuredHeight());
            RepairOrderActivity.i(RepairOrderActivity.this).removeRule(8);
            RepairOrderActivity.j(RepairOrderActivity.this);
          }
        });
      }
      while (RepairOrderActivity.b(RepairOrderActivity.this) == paramInt) {
        return;
      }
      RepairOrderActivity.a(RepairOrderActivity.this, paramInt);
      RepairOrderActivity.a(RepairOrderActivity.this).setItemSelected(paramInt);
      RepairOrderActivity.k(RepairOrderActivity.this).removeAllViews();
      RepairOrderActivity.l(RepairOrderActivity.this).clear();
      RepairOrderActivity.m(RepairOrderActivity.this).clear();
      RepairOrderActivity.n(RepairOrderActivity.this).clear();
      RepairOrderActivity.b(RepairOrderActivity.this, paramInt);
      paramView = new SpannableString(paramAdapterView.getProductPrice() + "元起");
      paramView.setSpan(new ForegroundColorSpan(RepairOrderActivity.this.getResources().getColor(2131624529)), 0, paramAdapterView.getProductPrice().toString().length(), 33);
      RepairOrderActivity.f(RepairOrderActivity.this).setText(paramView);
      RepairOrderActivity.g(RepairOrderActivity.this).setTag(paramAdapterView.getPriceUrl());
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
          paramk = (List)paramk.getObject();
          if ((paramk != null) && (paramk.size() > 0))
          {
            RepairOrderActivity.a(RepairOrderActivity.this, paramk);
            RepairOrderActivity.a(RepairOrderActivity.this).notifyDataSetChanged();
            if (RepairOrderActivity.o(RepairOrderActivity.this) == 3)
            {
              paramk = RepairOrderActivity.a(RepairOrderActivity.this).getRepairItem(0);
              RepairOrderActivity.a(RepairOrderActivity.this, (RelativeLayout.LayoutParams)RepairOrderActivity.h(RepairOrderActivity.this).getLayoutParams());
              RepairOrderActivity.i(RepairOrderActivity.this).addRule(3, 2131692168);
              RepairOrderActivity.b(RepairOrderActivity.this, 0);
              RepairOrderActivity.c(RepairOrderActivity.this).setVisibility(0);
              RepairOrderActivity.d(RepairOrderActivity.this).setVisibility(0);
              RepairOrderActivity.e(RepairOrderActivity.this).setBackgroundResource(2130839463);
              RepairOrderActivity.e(RepairOrderActivity.this).setClickable(true);
              SpannableString localSpannableString = new SpannableString(paramk.getProductPrice() + "元起");
              localSpannableString.setSpan(new ForegroundColorSpan(RepairOrderActivity.this.getResources().getColor(2131624529)), 0, paramk.getProductPrice().toString().length(), 33);
              RepairOrderActivity.f(RepairOrderActivity.this).setText(localSpannableString);
              RepairOrderActivity.g(RepairOrderActivity.this).setTag(paramk.getPriceUrl());
              RepairOrderActivity.this.dismissProgress();
              return;
            }
          }
        }
        catch (ClassCastException paramk)
        {
          for (;;)
          {
            paramk.printStackTrace();
            paramk = null;
            continue;
            RepairOrderActivity.p(RepairOrderActivity.this).setOnItemClickListener(new RepairOrderActivity.a(RepairOrderActivity.this));
            RepairOrderActivity.q(RepairOrderActivity.this);
          }
          RepairOrderActivity.r(RepairOrderActivity.this).setVisibility(0);
          RepairOrderActivity.this.showEmpty(RepairOrderActivity.r(RepairOrderActivity.this), "数据异常，请重试");
          g.textToast(RepairOrderActivity.s(RepairOrderActivity.this), "获取数据失败，请重试");
          RepairOrderActivity.q(RepairOrderActivity.this);
          RepairOrderActivity.this.dismissProgress();
          return;
        }
      }
      RepairOrderActivity.r(RepairOrderActivity.this).setVisibility(0);
      RepairOrderActivity.this.showEmpty(RepairOrderActivity.r(RepairOrderActivity.this), "服务器访问失败，请稍后再试");
      paramk = paramk.getMessage();
      RepairOrderActivity.q(RepairOrderActivity.this);
      if (paramk != null) {
        g.textToast(RepairOrderActivity.s(RepairOrderActivity.this), paramk);
      }
      for (;;)
      {
        RepairOrderActivity.this.dismissProgress();
        return;
        g.textToast(RepairOrderActivity.s(RepairOrderActivity.this), "服务器访问失败，无法获取数据");
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
      this.b = RepairOrderActivity.u(RepairOrderActivity.this).getSelectionStart();
      this.c = RepairOrderActivity.u(RepairOrderActivity.this).getSelectionEnd();
      RepairOrderActivity.u(RepairOrderActivity.this).removeTextChangedListener(RepairOrderActivity.v(RepairOrderActivity.this));
      while (RepairOrderActivity.a(RepairOrderActivity.this, paramEditable.toString()) > 100L)
      {
        paramEditable.delete(this.b - 1, this.c);
        this.b -= 1;
        this.c -= 1;
      }
      RepairOrderActivity.u(RepairOrderActivity.this).setSelection(this.b);
      RepairOrderActivity.u(RepairOrderActivity.this).addTextChangedListener(RepairOrderActivity.v(RepairOrderActivity.this));
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/activity/RepairOrderActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */