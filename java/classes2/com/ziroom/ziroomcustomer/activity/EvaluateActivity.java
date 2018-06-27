package com.ziroom.ziroomcustomer.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.LayoutParams;
import android.widget.TextView;
import com.alibaba.fastjson.e;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.d;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.model.Children;
import com.ziroom.ziroomcustomer.model.Option;
import com.ziroom.ziroomcustomer.signed.HandleWaitToDoneActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import com.ziroom.ziroomcustomer.widget.EvaluteButton;
import com.ziroom.ziroomcustomer.widget.EvaluteButton.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class EvaluateActivity
  extends BaseActivity
{
  private ImageView A;
  private ImageView B;
  private ImageView C;
  private ImageView D;
  private ImageView E;
  private int F = 0;
  private List<Option> G;
  private String H = null;
  private String I = "101";
  private String J = "108";
  private final int K = 4;
  private final int L = 1;
  private final int M = 2;
  private String N;
  private String O;
  private TextView P;
  private TextView Q;
  private String R;
  private int S = 0;
  private String T = "ZOASE";
  private Handler U = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      EvaluateActivity.this.dismissProgress();
      switch (paramAnonymousMessage.what)
      {
      }
      do
      {
        for (;;)
        {
          return;
          paramAnonymousMessage = (l)paramAnonymousMessage.obj;
          if (!paramAnonymousMessage.getSuccess().booleanValue()) {
            break;
          }
          if (EvaluateActivity.a(EvaluateActivity.this) != null)
          {
            EvaluateActivity.this.showToast("评价成功!");
            paramAnonymousMessage = new Intent(EvaluateActivity.this, MainActivity.class);
            EvaluateActivity.this.startActivity(paramAnonymousMessage);
          }
          while (ae.notNull(EvaluateActivity.e(EvaluateActivity.this)))
          {
            paramAnonymousMessage = new Intent(EvaluateActivity.this.getApplicationContext(), HandleWaitToDoneActivity.class);
            paramAnonymousMessage.putExtra("pay_status", EvaluateActivity.f(EvaluateActivity.this));
            paramAnonymousMessage.putExtra("contract_part_code", EvaluateActivity.c(EvaluateActivity.this));
            EvaluateActivity.this.startActivity(paramAnonymousMessage);
            return;
            EvaluateActivity.this.showToast("评价成功!");
            if (EvaluateActivity.b(EvaluateActivity.this) == 2) {
              j.getTerminationEvaluate(EvaluateActivity.this, new com.ziroom.commonlibrary.a.a(EvaluateActivity.this, new com.freelxl.baselibrary.d.f.c())
              {
                public void onSuccess(int paramAnonymous2Int, e paramAnonymous2e)
                {
                  super.onSuccess(paramAnonymous2Int, paramAnonymous2e);
                  if ("success".equals(paramAnonymous2e.get("status") + ""))
                  {
                    paramAnonymous2e = paramAnonymous2e.getJSONObject("data");
                    if (paramAnonymous2e == null) {
                      break label187;
                    }
                    paramAnonymous2e = (String)paramAnonymous2e.get("url");
                    if ((ae.isNull(paramAnonymous2e)) || ("0".equals(paramAnonymous2e)))
                    {
                      paramAnonymous2e = new Intent(EvaluateActivity.this, MainActivity.class);
                      paramAnonymous2e.putExtra("MyZiroom", "MyZiroom");
                      EvaluateActivity.this.startActivity(paramAnonymous2e);
                      EvaluateActivity.this.finish();
                    }
                  }
                  else
                  {
                    return;
                  }
                  JsBridgeWebActivity.start(EvaluateActivity.this, paramAnonymous2e + "?orderCode=" + EvaluateActivity.c(EvaluateActivity.this) + "&gjAccout=" + EvaluateActivity.d(EvaluateActivity.this), true, 7);
                  return;
                  label187:
                  paramAnonymous2e = new Intent(EvaluateActivity.this, MainActivity.class);
                  paramAnonymous2e.putExtra("MyZiroom", "MyZiroom");
                  EvaluateActivity.this.startActivity(paramAnonymous2e);
                  EvaluateActivity.this.finish();
                }
              });
            }
          }
        }
        EvaluateActivity.this.showToast(paramAnonymousMessage.getMessage());
        return;
        paramAnonymousMessage = (l)paramAnonymousMessage.obj;
        if (!paramAnonymousMessage.getSuccess().booleanValue()) {
          break;
        }
        paramAnonymousMessage = (Map)paramAnonymousMessage.getObject();
        EvaluateActivity.g(EvaluateActivity.this).setText(paramAnonymousMessage.get("zoName").toString());
        EvaluateActivity.h(EvaluateActivity.this).setText(paramAnonymousMessage.get("zoIntroduce").toString());
        com.freelxl.baselibrary.f.c.frescoHierarchyController(EvaluateActivity.i(EvaluateActivity.this), ScalingUtils.ScaleType.CENTER_INSIDE, 2130839150);
        EvaluateActivity.i(EvaluateActivity.this).setController(com.freelxl.baselibrary.f.c.frescoController(paramAnonymousMessage.get("zoPhotoUrl").toString()));
        localObject = (com.alibaba.fastjson.b)paramAnonymousMessage.get("questions");
      } while ((localObject == null) || (((com.alibaba.fastjson.b)localObject).size() < 1));
      EvaluateActivity.a(EvaluateActivity.this, (String)paramAnonymousMessage.get("tokenId"));
      paramAnonymousMessage = ((com.alibaba.fastjson.b)localObject).getJSONObject(0).getJSONArray("children");
      EvaluateActivity.j(EvaluateActivity.this).addAll(com.alibaba.fastjson.a.parseArray(paramAnonymousMessage.toJSONString(), Children.class));
      Object localObject = EvaluateActivity.j(EvaluateActivity.this).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Children localChildren = (Children)((Iterator)localObject).next();
        if ((localChildren.getOptionType() == 4) || (localChildren.getOptionType() == 0) || (localChildren.getOptionType() == 2)) {
          ((Iterator)localObject).remove();
        }
        if ((localChildren.getOptionType() == 1) && (localChildren.getLabel().equals("几星"))) {
          ((Iterator)localObject).remove();
        }
      }
      EvaluateActivity.this.d.notifyDataSetChanged();
      int i = 0;
      label519:
      if (i < paramAnonymousMessage.size())
      {
        localObject = (Children)com.alibaba.fastjson.a.parseObject(paramAnonymousMessage.getString(i), Children.class);
        if ((1 != ((Children)localObject).getOptionType()) || (!((Children)localObject).getLabel().equals("几星"))) {
          break label592;
        }
        EvaluateActivity.a(EvaluateActivity.this, ((Children)localObject).getOptions());
        EvaluateActivity.b(EvaluateActivity.this, ((Children)localObject).getCode());
      }
      for (;;)
      {
        i += 1;
        break label519;
        break;
        label592:
        if (2 == ((Children)localObject).getOptionType()) {
          EvaluateActivity.c(EvaluateActivity.this, ((Children)localObject).getCode());
        }
      }
      EvaluateActivity.this.showToast(paramAnonymousMessage.getMessage());
    }
  };
  private List<Children> V = new ArrayList();
  private float W = 0.0F;
  View a;
  View b;
  TextView c;
  com.freelxl.baselibrary.a.a<Children> d;
  com.alibaba.fastjson.b e = new com.alibaba.fastjson.b();
  private String f;
  private String g;
  private String r;
  private SimpleDraweeView s;
  private TextView t;
  private TextView u;
  private EditText v;
  private Button w;
  private ImageView x;
  private ListView y;
  private EvaluteButton z;
  
  private void a()
  {
    if (!checkNet(getApplicationContext()))
    {
      g.textToast(this, "网络请求失败，请检查您的网络设置", 1);
      return;
    }
    Intent localIntent = getIntent();
    this.S = localIntent.getIntExtra("type", 0);
    this.f = localIntent.getStringExtra("uid");
    this.g = localIntent.getStringExtra("old_contract_code");
    this.R = localIntent.getStringExtra("lease");
    String str2 = localIntent.getStringExtra("questionType");
    this.T = localIntent.getStringExtra("stewardType");
    this.N = localIntent.getStringExtra("isComplete");
    this.O = localIntent.getStringExtra("pay_status");
    String str1 = "评价";
    if (this.S == 1)
    {
      d.getEvaluateProblems(this.U, this, this.f, this.T, "SZOABE");
      str1 = "约看评价";
    }
    do
    {
      for (;;)
      {
        this.Q.setText(str1);
        this.P.setText(str1);
        showProgressNoCancel("获取评价信息", 30000L);
        return;
        if (this.S != 2) {
          break;
        }
        str1 = "解约评价";
        this.r = localIntent.getStringExtra("contract_code");
        d.getEvaluateProblems(this.U, this, this.f, this.T, str2);
      }
    } while (this.S != 0);
    if (this.g != null)
    {
      this.r = this.g;
      str1 = "续约评价";
    }
    for (;;)
    {
      u.e("签约评价", "--stewardType---" + this.T);
      d.getEvaluateProblems(this.U, this, this.f, this.T, str2);
      break;
      this.r = localIntent.getStringExtra("contract_code");
      str1 = "签约评价";
      u.e("签约评价", "---" + this.r);
    }
  }
  
  private void b()
  {
    this.x = ((ImageView)findViewById(2131690563));
    this.Q = ((TextView)findViewById(2131690564));
    this.y = ((ListView)findViewById(2131690575));
    initheadview();
    initfootview();
    initAdapter();
    this.y.addHeaderView(this.a);
    this.y.addFooterView(this.b);
    this.y.setAdapter(this.d);
  }
  
  private void e()
  {
    this.w.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (EvaluateActivity.k(EvaluateActivity.this) == 0) {
          EvaluateActivity.this.showToast("请对管家进行评价之后再提交哦!");
        }
        do
        {
          return;
          paramAnonymousView = EvaluateActivity.l(EvaluateActivity.this);
        } while (paramAnonymousView == null);
        d.PutEvaluateContent(EvaluateActivity.m(EvaluateActivity.this), EvaluateActivity.this, EvaluateActivity.n(EvaluateActivity.this), paramAnonymousView);
        EvaluateActivity.this.showProgressNoCancel("管家评价信息采集", 30000L);
      }
    });
    ImageView localImageView1 = this.A;
    ImageView localImageView2 = this.B;
    ImageView localImageView3 = this.C;
    ImageView localImageView4 = this.D;
    ImageView localImageView5 = this.E;
    this.z.setOnSwitchStateListener(new EvaluteButton.a()
    {
      public void onSwitch(int paramAnonymousInt)
      {
        EvaluateActivity.a(EvaluateActivity.this, paramAnonymousInt);
        int i = 0;
        while (i < paramAnonymousInt)
        {
          this.a[i].setImageResource(2130839756);
          i += 1;
        }
        i = 4;
        while (i >= paramAnonymousInt)
        {
          this.a[i].setImageResource(2130839754);
          i -= 1;
        }
      }
    });
    this.x.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        EvaluateActivity.this.finish();
      }
    });
  }
  
  private String f()
  {
    if ((this.G == null) || (this.G.size() < 1)) {
      return null;
    }
    e locale1 = new e();
    locale1.put("requesterId", ApplicationEx.c.getUserId(this));
    locale1.put("requesterType", "ziroomer");
    if (!TextUtils.isEmpty(this.r)) {
      locale1.put("orderCode", this.r);
    }
    com.alibaba.fastjson.b localb;
    for (;;)
    {
      localb = new com.alibaba.fastjson.b();
      if (this.F >= 1) {
        break;
      }
      showToast("请为管家评价星级!");
      return null;
      if (!TextUtils.isEmpty(this.f)) {
        locale1.put("orderCode", this.f);
      }
    }
    e locale2 = new e();
    locale2.put("optionCode", ((Option)this.G.get(this.F - 1)).getCode());
    locale2.put("code", this.I);
    locale2.put("content", "");
    localb.add(locale2);
    locale2 = new e();
    locale2.put("optionCode", "");
    locale2.put("code", this.J);
    locale2.put("content", VdsAgent.trackEditTextSilent(this.v));
    localb.add(locale2);
    if (this.e.size() < this.V.size())
    {
      showToast("请回答完全部问题!");
      return null;
    }
    localb.addAll(this.e);
    locale1.put("questions", localb);
    return locale1.toJSONString();
  }
  
  public void initAdapter()
  {
    this.d = new com.freelxl.baselibrary.a.a(this, this.V, 2130904192)
    {
      public void convert(com.freelxl.baselibrary.a.b paramAnonymousb, Children paramAnonymousChildren) {}
      
      public void convert(com.freelxl.baselibrary.a.b paramAnonymousb, final Children paramAnonymousChildren, int paramAnonymousInt)
      {
        paramAnonymousb.setText(2131694978, paramAnonymousChildren.getLabel());
        paramAnonymousb = (RadioGroup)paramAnonymousb.getView(2131694979);
        paramAnonymousb.removeAllViews();
        if (paramAnonymousChildren.getOptions() != null)
        {
          paramAnonymousInt = 0;
          while (paramAnonymousInt < paramAnonymousChildren.getOptions().size())
          {
            if (paramAnonymousb.getChildCount() < paramAnonymousChildren.getOptions().size())
            {
              RadioButton localRadioButton = new RadioButton(EvaluateActivity.this.getApplicationContext());
              localRadioButton.setTag(paramAnonymousChildren.getOptions().get(paramAnonymousInt));
              localRadioButton.setText(((Option)paramAnonymousChildren.getOptions().get(paramAnonymousInt)).getDesc());
              localRadioButton.setButtonDrawable(17170445);
              localRadioButton.setBackgroundResource(2130839236);
              localRadioButton.setTextSize(13.0F);
              localRadioButton.setTextColor(EvaluateActivity.this.getResources().getColorStateList(2131624646));
              RadioGroup.LayoutParams localLayoutParams = new RadioGroup.LayoutParams(-2, -2);
              localLayoutParams.setMargins((int)(EvaluateActivity.p(EvaluateActivity.this) * 4.0F), 0, (int)(EvaluateActivity.p(EvaluateActivity.this) * 4.0F), 0);
              localRadioButton.setLayoutParams(localLayoutParams);
              localRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
              {
                @Instrumented
                public void onCheckedChanged(CompoundButton paramAnonymous2CompoundButton, boolean paramAnonymous2Boolean)
                {
                  VdsAgent.onCheckedChanged(this, paramAnonymous2CompoundButton, paramAnonymous2Boolean);
                  e locale;
                  int j;
                  int i;
                  if (paramAnonymous2Boolean)
                  {
                    locale = new e();
                    paramAnonymous2CompoundButton = (Option)paramAnonymous2CompoundButton.getTag();
                    locale.put("code", paramAnonymousChildren.getCode());
                    locale.put("optionCode", paramAnonymous2CompoundButton.getCode());
                    locale.put("content", paramAnonymous2CompoundButton.getDesc());
                    if (EvaluateActivity.this.e.size() == 0) {
                      EvaluateActivity.this.e.add(locale);
                    }
                    j = EvaluateActivity.this.e.size();
                    i = 0;
                  }
                  for (;;)
                  {
                    if (i < j)
                    {
                      if (EvaluateActivity.this.e.getJSONObject(i).getString("code").equals(paramAnonymousChildren.getCode())) {
                        EvaluateActivity.this.e.remove(i);
                      }
                    }
                    else
                    {
                      EvaluateActivity.this.e.add(locale);
                      return;
                    }
                    i += 1;
                  }
                }
              });
              paramAnonymousb.addView(localRadioButton);
              int i = 0;
              while (i < EvaluateActivity.this.e.size())
              {
                if ((EvaluateActivity.this.e.getJSONObject(i).getString("code").equals(paramAnonymousChildren.getCode())) && (EvaluateActivity.this.e.getJSONObject(i).getString("optionCode").equals(((Option)paramAnonymousChildren.getOptions().get(paramAnonymousInt)).getCode()))) {
                  paramAnonymousb.check(localRadioButton.getId());
                }
                i += 1;
              }
            }
            paramAnonymousInt += 1;
          }
        }
      }
    };
  }
  
  public void initfootview()
  {
    this.b = getLayoutInflater().inflate(2130903882, null);
    this.P = ((TextView)this.b.findViewById(2131693943));
    this.A = ((ImageView)this.b.findViewById(2131690054));
    this.B = ((ImageView)this.b.findViewById(2131690055));
    this.C = ((ImageView)this.b.findViewById(2131690056));
    this.D = ((ImageView)this.b.findViewById(2131690057));
    this.E = ((ImageView)this.b.findViewById(2131690058));
    this.z = ((EvaluteButton)this.b.findViewById(2131690568));
    this.w = ((Button)this.b.findViewById(2131689843));
    this.v = ((EditText)this.b.findViewById(2131690574));
    this.c = ((TextView)this.b.findViewById(2131693944));
    this.v.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if ((EvaluateActivity.o(EvaluateActivity.this).length() > 0) && (EvaluateActivity.o(EvaluateActivity.this).length() < 101))
        {
          EvaluateActivity.this.c.setText(EvaluateActivity.o(EvaluateActivity.this).length() + "/100");
          return;
        }
        EvaluateActivity.this.c.setText("0/100");
      }
    });
    this.v.setFilters(new InputFilter[] { new InputFilter.LengthFilter(100) });
  }
  
  public void initheadview()
  {
    this.a = getLayoutInflater().inflate(2130903883, null);
    this.s = ((SimpleDraweeView)this.a.findViewById(2131689744));
    this.u = ((TextView)this.a.findViewById(2131690567));
    this.t = ((TextView)this.a.findViewById(2131690566));
  }
  
  public boolean isHave(String paramString)
  {
    return false;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.W = getResources().getDisplayMetrics().density;
    setContentView(2130903171);
    b();
    e();
    a();
  }
  
  protected void onDestroy()
  {
    this.s.setImageBitmap(null);
    this.s = null;
    if (ae.notNull(this.R)) {
      ApplicationEx.c.finishAllActivity();
    }
    super.onDestroy();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/activity/EvaluateActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */