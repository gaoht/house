package com.ziroom.ziroomcustomer.my;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.fastjson.a;
import com.alibaba.fastjson.b;
import com.alibaba.fastjson.e;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.d;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.model.Children;
import com.ziroom.ziroomcustomer.model.Option;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.widget.EvaluteButton;
import com.ziroom.ziroomcustomer.widget.EvaluteButton.a;
import java.util.List;
import java.util.Map;

public class MyAppointEvaluateActivity
  extends BaseActivity
{
  private ImageView A;
  private ImageView B;
  private ImageView C;
  private int D = 0;
  private List<Option> E;
  private List<Option> F;
  private List<Option> G;
  private List<Option> H;
  private List<Option> I;
  private List<Option> J;
  private String K = null;
  private String L = "113";
  private String M = "112";
  private String N = "111";
  private String O = "109";
  private String P = "110";
  private String Q = "101";
  private String R = "108";
  private final int S = 4;
  private final int T = 1;
  private final int U = 2;
  private String V;
  private int W;
  private String X;
  private String Y;
  private String Z;
  private String a;
  private String aa = "salesZO";
  private Handler ab = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      int i = 0;
      super.handleMessage(paramAnonymousMessage);
      MyAppointEvaluateActivity.this.dismissProgress();
      Object localObject = (l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      }
      for (;;)
      {
        return;
        if (((l)localObject).getSuccess().booleanValue())
        {
          MyAppointEvaluateActivity.this.showToast("评价成功，感谢您的评价！");
          MyAppointEvaluateActivity.this.finish();
          return;
        }
        MyAppointEvaluateActivity.this.showToast(((l)localObject).getMessage());
        return;
        paramAnonymousMessage = (l)paramAnonymousMessage.obj;
        if (paramAnonymousMessage.getSuccess().booleanValue())
        {
          paramAnonymousMessage = (Map)paramAnonymousMessage.getObject();
          MyAppointEvaluateActivity.a(MyAppointEvaluateActivity.this).setText(paramAnonymousMessage.get("zoName").toString());
          MyAppointEvaluateActivity.b(MyAppointEvaluateActivity.this).setText(paramAnonymousMessage.get("zoIntroduce").toString());
          MyAppointEvaluateActivity.c(MyAppointEvaluateActivity.this).setController(c.frescoController(paramAnonymousMessage.get("zoPhotoUrl").toString()));
          localObject = (b)paramAnonymousMessage.get("questions");
          MyAppointEvaluateActivity.a(MyAppointEvaluateActivity.this, (String)paramAnonymousMessage.get("tokenId"));
          if ((localObject == null) || (((b)localObject).size() <= 0)) {
            break label552;
          }
          paramAnonymousMessage = ((b)localObject).getJSONObject(0).getJSONArray("children");
        }
        while ((paramAnonymousMessage != null) && (i < paramAnonymousMessage.size()))
        {
          localObject = (Children)a.parseObject(paramAnonymousMessage.getString(i), Children.class);
          if ((4 == ((Children)localObject).getOptionType()) && (((Children)localObject).getLabel().contains("五星")))
          {
            MyAppointEvaluateActivity.a(MyAppointEvaluateActivity.this, ((Children)localObject).getOptions());
            MyAppointEvaluateActivity.b(MyAppointEvaluateActivity.this, ((Children)localObject).getCode());
          }
          for (;;)
          {
            i += 1;
            break;
            if ((4 == ((Children)localObject).getOptionType()) && (((Children)localObject).getLabel().contains("二星")))
            {
              MyAppointEvaluateActivity.b(MyAppointEvaluateActivity.this, ((Children)localObject).getOptions());
              MyAppointEvaluateActivity.c(MyAppointEvaluateActivity.this, ((Children)localObject).getCode());
            }
            else if ((4 == ((Children)localObject).getOptionType()) && (((Children)localObject).getLabel().contains("三星")))
            {
              MyAppointEvaluateActivity.c(MyAppointEvaluateActivity.this, ((Children)localObject).getOptions());
              MyAppointEvaluateActivity.d(MyAppointEvaluateActivity.this, ((Children)localObject).getCode());
            }
            else if (1 == ((Children)localObject).getOptionType())
            {
              MyAppointEvaluateActivity.d(MyAppointEvaluateActivity.this, ((Children)localObject).getOptions());
              MyAppointEvaluateActivity.e(MyAppointEvaluateActivity.this, ((Children)localObject).getCode());
            }
            else if (((Children)localObject).getLabel().contains("四星"))
            {
              MyAppointEvaluateActivity.e(MyAppointEvaluateActivity.this, ((Children)localObject).getOptions());
              MyAppointEvaluateActivity.f(MyAppointEvaluateActivity.this, ((Children)localObject).getCode());
            }
            else if (((Children)localObject).getLabel().contains("一星"))
            {
              MyAppointEvaluateActivity.f(MyAppointEvaluateActivity.this, ((Children)localObject).getOptions());
              MyAppointEvaluateActivity.g(MyAppointEvaluateActivity.this, ((Children)localObject).getCode());
            }
            else if (2 == ((Children)localObject).getOptionType())
            {
              MyAppointEvaluateActivity.h(MyAppointEvaluateActivity.this, ((Children)localObject).getCode());
            }
          }
          MyAppointEvaluateActivity.this.showToast(paramAnonymousMessage.getMessage());
          return;
          label552:
          paramAnonymousMessage = null;
        }
      }
    }
  };
  private String b;
  private SimpleDraweeView c;
  private TextView d;
  private TextView e;
  private EditText f;
  private LinearLayout g;
  private CheckBox r;
  private CheckBox s;
  private CheckBox t;
  private CheckBox u;
  private Button v;
  private ImageView w;
  private EvaluteButton x;
  private ImageView y;
  private ImageView z;
  
  private void a()
  {
    Intent localIntent = getIntent();
    this.V = localIntent.getStringExtra("orderCode");
    this.W = localIntent.getIntExtra("isComplete", 0);
    this.X = localIntent.getStringExtra("stewardName");
    this.Y = localIntent.getStringExtra("stewardId");
    if (!checkNet(getApplicationContext()))
    {
      g.textToast(this, "网络请求失败，请检查您的网络设置", 1);
      return;
    }
    d.getEvaluateProblems(this.ab, this, this.Y, this.aa, "SZOABE");
    showProgress("");
  }
  
  private void b()
  {
    this.c = ((SimpleDraweeView)findViewById(2131689744));
    ((GenericDraweeHierarchy)this.c.getHierarchy()).setPlaceholderImage(2130837940);
    this.e = ((TextView)findViewById(2131690567));
    this.d = ((TextView)findViewById(2131690566));
    this.w = ((ImageView)findViewById(2131690563));
    this.v = ((Button)findViewById(2131689843));
    this.g = ((LinearLayout)findViewById(2131690569));
    this.r = ((CheckBox)findViewById(2131690570));
    this.s = ((CheckBox)findViewById(2131690571));
    this.t = ((CheckBox)findViewById(2131690572));
    this.u = ((CheckBox)findViewById(2131690573));
    this.f = ((EditText)findViewById(2131690574));
    this.y = ((ImageView)findViewById(2131690054));
    this.z = ((ImageView)findViewById(2131690055));
    this.A = ((ImageView)findViewById(2131690056));
    this.B = ((ImageView)findViewById(2131690057));
    this.C = ((ImageView)findViewById(2131690058));
    this.x = ((EvaluteButton)findViewById(2131690568));
    this.f.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (MyAppointEvaluateActivity.d(MyAppointEvaluateActivity.this).length() > 0)
        {
          MyAppointEvaluateActivity.d(MyAppointEvaluateActivity.this).setGravity(19);
          MyAppointEvaluateActivity.d(MyAppointEvaluateActivity.this).setCursorVisible(true);
          return;
        }
        MyAppointEvaluateActivity.d(MyAppointEvaluateActivity.this).setGravity(17);
        MyAppointEvaluateActivity.d(MyAppointEvaluateActivity.this).setCursorVisible(false);
      }
    });
  }
  
  private void b(int paramInt)
  {
    List localList;
    switch (paramInt)
    {
    default: 
      localList = null;
    }
    while ((localList != null) && (localList.size() > 3))
    {
      int[] arrayOfInt = ah.randomArray(0, localList.size() - 1, 4);
      paramInt = arrayOfInt[0];
      this.r.setText(((Option)localList.get(paramInt)).getDesc());
      this.r.setTag(((Option)localList.get(paramInt)).getCode());
      paramInt = arrayOfInt[1];
      this.s.setText(((Option)localList.get(paramInt)).getDesc());
      this.s.setTag(((Option)localList.get(paramInt)).getCode());
      paramInt = arrayOfInt[2];
      this.t.setText(((Option)localList.get(paramInt)).getDesc());
      this.t.setTag(((Option)localList.get(paramInt)).getCode());
      paramInt = arrayOfInt[3];
      this.u.setText(((Option)localList.get(paramInt)).getDesc());
      this.u.setTag(((Option)localList.get(paramInt)).getCode());
      return;
      localList = this.E;
      continue;
      localList = this.F;
      continue;
      localList = this.G;
      continue;
      localList = this.H;
      continue;
      localList = this.I;
    }
    this.g.setVisibility(8);
  }
  
  private String c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return this.L;
    case 2: 
      return this.M;
    case 3: 
      return this.N;
    case 4: 
      return this.O;
    }
    return this.P;
  }
  
  private void e()
  {
    this.v.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (MyAppointEvaluateActivity.e(MyAppointEvaluateActivity.this) == 0) {
          MyAppointEvaluateActivity.this.showToast("请对管家进行评价之后再提交哦!");
        }
        do
        {
          return;
          paramAnonymousView = MyAppointEvaluateActivity.f(MyAppointEvaluateActivity.this);
        } while (paramAnonymousView == null);
        MyAppointEvaluateActivity.this.showProgress("");
        MyAppointEvaluateActivity.i(MyAppointEvaluateActivity.this, ApplicationEx.c.getUserId(MyAppointEvaluateActivity.this));
        d.evaluateAppointment(MyAppointEvaluateActivity.g(MyAppointEvaluateActivity.this), MyAppointEvaluateActivity.h(MyAppointEvaluateActivity.this), MyAppointEvaluateActivity.i(MyAppointEvaluateActivity.this), MyAppointEvaluateActivity.j(MyAppointEvaluateActivity.this), MyAppointEvaluateActivity.e(MyAppointEvaluateActivity.this), VdsAgent.trackEditTextSilent(MyAppointEvaluateActivity.d(MyAppointEvaluateActivity.this)).toString(), MyAppointEvaluateActivity.k(MyAppointEvaluateActivity.this), paramAnonymousView);
      }
    });
    ImageView localImageView1 = this.y;
    ImageView localImageView2 = this.z;
    ImageView localImageView3 = this.A;
    ImageView localImageView4 = this.B;
    ImageView localImageView5 = this.C;
    this.x.setOnSwitchStateListener(new EvaluteButton.a()
    {
      public void onSwitch(int paramAnonymousInt)
      {
        MyAppointEvaluateActivity.a(MyAppointEvaluateActivity.this, paramAnonymousInt);
        int i = 0;
        while (i < paramAnonymousInt)
        {
          this.a[i].setImageResource(2130839755);
          i += 1;
        }
        i = 4;
        while (i >= paramAnonymousInt)
        {
          this.a[i].setImageResource(2130839753);
          i -= 1;
        }
        MyAppointEvaluateActivity.l(MyAppointEvaluateActivity.this).setVisibility(0);
        MyAppointEvaluateActivity.b(MyAppointEvaluateActivity.this, paramAnonymousInt);
      }
    });
    this.w.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MyAppointEvaluateActivity.this.finish();
      }
    });
  }
  
  private String f()
  {
    if ((this.J == null) || (this.J.size() < 1)) {
      return null;
    }
    e locale1 = new e();
    locale1.put("requesterId", ApplicationEx.c.getUserId(this));
    locale1.put("requesterType", "ziroomer");
    if (!TextUtils.isEmpty(this.b)) {
      locale1.put("orderCode", this.b);
    }
    b localb;
    for (;;)
    {
      localb = new b();
      Object localObject = new e();
      ((e)localObject).put("optionCode", ((Option)this.J.get(this.D - 1)).getCode());
      ((e)localObject).put("code", this.Q);
      ((e)localObject).put("content", "");
      localb.add(localObject);
      localObject = new e();
      ((e)localObject).put("optionCode", "");
      ((e)localObject).put("code", this.R);
      ((e)localObject).put("content", VdsAgent.trackEditTextSilent(this.f).toString());
      localb.add(localObject);
      int i = 0;
      while (i < this.g.getChildCount())
      {
        localObject = this.g.getChildAt(i);
        if (((localObject instanceof CheckBox)) && (((CheckBox)localObject).isChecked()))
        {
          e locale2 = new e();
          locale2.put("optionCode", ((View)localObject).getTag());
          locale2.put("code", c(this.D));
          locale2.put("content", "");
          localb.add(locale2);
        }
        i += 1;
      }
      if (!TextUtils.isEmpty(this.a)) {
        locale1.put("orderCode", this.a);
      }
    }
    locale1.put("questions", localb);
    return locale1.toJSONString();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903170);
    b();
    e();
    a();
  }
  
  protected void onDestroy()
  {
    this.c.setImageBitmap(null);
    this.c = null;
    super.onDestroy();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/MyAppointEvaluateActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */