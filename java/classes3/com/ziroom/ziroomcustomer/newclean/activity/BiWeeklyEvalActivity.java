package com.ziroom.ziroomcustomer.newclean.activity;

import am.widget.wraplayout.WrapLayout;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import com.alibaba.fastjson.b;
import com.alibaba.fastjson.e;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.k;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.newclean.d.af;
import java.util.Iterator;

public class BiWeeklyEvalActivity
  extends BaseActivity
{
  private boolean A = false;
  private float B;
  private String C;
  private boolean D;
  private TextWatcher E = new TextWatcher()
  {
    public void afterTextChanged(Editable paramAnonymousEditable)
    {
      int i = 140;
      int j = paramAnonymousEditable.length();
      if (j > 140)
      {
        BiWeeklyEvalActivity.n(BiWeeklyEvalActivity.this).setText(paramAnonymousEditable.subSequence(0, 140).toString());
        BiWeeklyEvalActivity.n(BiWeeklyEvalActivity.this).setSelection(140);
      }
      paramAnonymousEditable = BiWeeklyEvalActivity.o(BiWeeklyEvalActivity.this);
      StringBuilder localStringBuilder = new StringBuilder();
      if (j > 140) {}
      for (;;)
      {
        paramAnonymousEditable.setText(i + "/140");
        return;
        i = j;
      }
    }
    
    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
  };
  private SimpleDraweeView a;
  private TextView b;
  private TextView c;
  private RatingBar d;
  private TextView e;
  private WrapLayout f;
  private EditText g;
  private TextView r;
  private Button s;
  private String t;
  private String u;
  private String v;
  private String w;
  private String x;
  private b y;
  private b z;
  
  private void a()
  {
    b();
    this.a = ((SimpleDraweeView)findViewById(2131690070));
    this.b = ((TextView)findViewById(2131690049));
    this.c = ((TextView)findViewById(2131690071));
    this.d = ((RatingBar)findViewById(2131690072));
    this.e = ((TextView)findViewById(2131690073));
    this.f = ((WrapLayout)findViewById(2131690074));
    this.g = ((EditText)findViewById(2131690075));
    this.r = ((TextView)findViewById(2131690076));
    this.s = ((Button)findViewById(2131689816));
    this.g.addTextChangedListener(this.E);
    this.B = getResources().getDisplayMetrics().density;
  }
  
  private void b()
  {
    ((ImageView)findViewById(2131691493)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        BiWeeklyEvalActivity.this.setResult(0);
        BiWeeklyEvalActivity.this.finish();
      }
    });
    findViewById(2131696484).setVisibility(8);
    ((ImageView)findViewById(2131696483)).setVisibility(8);
    ((TextView)findViewById(2131689541)).setText("服务评价");
  }
  
  private View d(String paramString)
  {
    CheckBox localCheckBox = new CheckBox(this);
    localCheckBox.setText(paramString);
    localCheckBox.setTextSize(1, 12.0F);
    localCheckBox.setGravity(17);
    localCheckBox.setButtonDrawable(null);
    localCheckBox.setBackgroundResource(2130839467);
    localCheckBox.setTextColor(getResources().getColorStateList(2131624636));
    localCheckBox.setPadding((int)(this.B * 8.0F), 0, (int)(this.B * 8.0F), 0);
    localCheckBox.setLayoutParams(new LinearLayout.LayoutParams(-2, (int)(24.0F * this.B)));
    return localCheckBox;
  }
  
  private void e()
  {
    Intent localIntent = getIntent();
    this.D = getIntent().getBooleanExtra("isFormDetail", false);
    this.C = localIntent.getStringExtra("cleanerId");
    this.t = localIntent.getStringExtra("uid");
    this.u = localIntent.getStringExtra("billId");
    this.v = localIntent.getStringExtra("evalId");
    if (TextUtils.isEmpty(this.v)) {
      this.d.setVisibility(0);
    }
    for (;;)
    {
      n.getBiweeklyCleanerInfo(this, this.C, new com.ziroom.ziroomcustomer.e.a.a(this, new m(af.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
      {
        public void onSuccess(int paramAnonymousInt, af paramAnonymousaf)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousaf);
          if (paramAnonymousaf != null)
          {
            BiWeeklyEvalActivity.a(BiWeeklyEvalActivity.this).setController(c.frescoController(paramAnonymousaf.getHeadPic()));
            BiWeeklyEvalActivity.b(BiWeeklyEvalActivity.this).setText(paramAnonymousaf.getName());
            if (!TextUtils.isEmpty(BiWeeklyEvalActivity.c(BiWeeklyEvalActivity.this))) {
              BiWeeklyEvalActivity.d(BiWeeklyEvalActivity.this).setEnabled(true);
            }
            BiWeeklyEvalActivity.a(BiWeeklyEvalActivity.this, paramAnonymousaf.getHeadPic());
            BiWeeklyEvalActivity.b(BiWeeklyEvalActivity.this, paramAnonymousaf.getName());
          }
        }
      });
      n.getDicTag(this, "CleanPositiveEvaluateEnum", new com.ziroom.ziroomcustomer.e.a.a(this, new com.ziroom.ziroomcustomer.e.c.j(new com.ziroom.ziroomcustomer.e.c.a.a()))
      {
        public void onSuccess(int paramAnonymousInt, b paramAnonymousb)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousb);
          if ((paramAnonymousb != null) && (paramAnonymousb.size() > 0)) {
            BiWeeklyEvalActivity.a(BiWeeklyEvalActivity.this, paramAnonymousb);
          }
        }
      });
      n.getDicTag(this, "CleanNegativeEvaluateEnum", new com.ziroom.ziroomcustomer.e.a.a(this, new com.ziroom.ziroomcustomer.e.c.j(new com.ziroom.ziroomcustomer.e.c.a.a()))
      {
        public void onSuccess(int paramAnonymousInt, b paramAnonymousb)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousb);
          if ((paramAnonymousb != null) && (paramAnonymousb.size() > 0)) {
            BiWeeklyEvalActivity.b(BiWeeklyEvalActivity.this, paramAnonymousb);
          }
        }
      });
      this.d.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener()
      {
        @Instrumented
        public void onRatingChanged(RatingBar paramAnonymousRatingBar, float paramAnonymousFloat, boolean paramAnonymousBoolean)
        {
          VdsAgent.onRatingChanged(this, paramAnonymousRatingBar, paramAnonymousFloat, paramAnonymousBoolean);
          BiWeeklyEvalActivity.d(BiWeeklyEvalActivity.this).setEnabled(true);
          if (paramAnonymousFloat > 2.9F) {
            if (!BiWeeklyEvalActivity.e(BiWeeklyEvalActivity.this))
            {
              BiWeeklyEvalActivity.a(BiWeeklyEvalActivity.this, true);
              BiWeeklyEvalActivity.f(BiWeeklyEvalActivity.this);
            }
          }
          do
          {
            for (;;)
            {
              BiWeeklyEvalActivity.h(BiWeeklyEvalActivity.this).setVisibility(0);
              if (paramAnonymousFloat <= 4.0F) {
                break;
              }
              BiWeeklyEvalActivity.h(BiWeeklyEvalActivity.this).setText("特别满意");
              return;
              if (BiWeeklyEvalActivity.e(BiWeeklyEvalActivity.this))
              {
                BiWeeklyEvalActivity.a(BiWeeklyEvalActivity.this, false);
                BiWeeklyEvalActivity.g(BiWeeklyEvalActivity.this);
              }
            }
            if (paramAnonymousFloat > 3.0F)
            {
              BiWeeklyEvalActivity.h(BiWeeklyEvalActivity.this).setText("满意");
              return;
            }
            if (paramAnonymousFloat > 2.0F)
            {
              BiWeeklyEvalActivity.h(BiWeeklyEvalActivity.this).setText("一般");
              return;
            }
            if (paramAnonymousFloat > 1.0F)
            {
              BiWeeklyEvalActivity.h(BiWeeklyEvalActivity.this).setText("不满意");
              return;
            }
          } while (paramAnonymousFloat <= 0.0F);
          BiWeeklyEvalActivity.h(BiWeeklyEvalActivity.this).setText("特别不满意");
        }
      });
      return;
      this.c.setText("为保洁员评价");
    }
  }
  
  private void f()
  {
    this.f.setVisibility(0);
    this.f.removeAllViews();
    if ((this.y != null) && (this.y.size() > 0))
    {
      Iterator localIterator = this.y.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        this.f.addView(d(((e)localObject).getString("tagValue")));
      }
    }
  }
  
  private void g()
  {
    this.f.setVisibility(0);
    this.f.removeAllViews();
    if ((this.z != null) && (this.z.size() > 0))
    {
      Iterator localIterator = this.z.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        this.f.addView(d(((e)localObject).getString("tagValue")));
      }
    }
  }
  
  private String h()
  {
    if ((this.f.getVisibility() == 0) && (this.f.getChildCount() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder("");
      int i = 0;
      while (i < this.f.getChildCount())
      {
        CheckBox localCheckBox = (CheckBox)this.f.getChildAt(i);
        if (localCheckBox.isChecked()) {
          localStringBuilder.append(";" + localCheckBox.getText());
        }
        i += 1;
      }
      if (localStringBuilder.length() > 1) {
        return localStringBuilder.substring(1);
      }
    }
    return "";
  }
  
  private void i()
  {
    String str1 = VdsAgent.trackEditTextSilent(this.g).toString();
    if (TextUtils.isEmpty(this.v))
    {
      str2 = h();
      int i = (int)this.d.getRating();
      n.postBiweeklyCleanEval(this, this.u, str1, i, str2, this.t, new com.ziroom.ziroomcustomer.e.a.a(this, new k(new com.ziroom.ziroomcustomer.e.c.a.a()))
      {
        public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymouse);
          BiWeeklyEvalActivity.this.setResult(-1);
          if ((paramAnonymouse != null) && (paramAnonymouse.containsKey("investigationSwitch")) && ("on".equals(paramAnonymouse.getString("investigationSwitch"))))
          {
            paramAnonymouse = new Intent(BiWeeklyEvalActivity.this, BiWeeklyQuestionnaireActivity.class);
            paramAnonymouse.putExtras(BiWeeklyEvalActivity.this.getIntent().getExtras());
            paramAnonymouse.putExtra("avatar", BiWeeklyEvalActivity.i(BiWeeklyEvalActivity.this));
            paramAnonymouse.putExtra("cleanerName", BiWeeklyEvalActivity.j(BiWeeklyEvalActivity.this));
            paramAnonymouse.putExtra("cleanerId", BiWeeklyEvalActivity.k(BiWeeklyEvalActivity.this));
            paramAnonymouse.putExtra("isFormDetail", BiWeeklyEvalActivity.l(BiWeeklyEvalActivity.this));
            BiWeeklyEvalActivity.this.startActivityAndFinish(paramAnonymouse);
            return;
          }
          if (BiWeeklyEvalActivity.l(BiWeeklyEvalActivity.this))
          {
            BiWeeklyEvalActivity.this.finish();
            return;
          }
          BiWeeklyEvalActivity.this.finish();
          BiWeeklyEvalActivity.m(BiWeeklyEvalActivity.this);
        }
      });
      return;
    }
    String str2 = getIntent().getStringExtra("name");
    n.postBiweeklyCleanAdditionalEval(this, this.u, this.v, str2, str1, this.t, new com.ziroom.ziroomcustomer.e.a.a(this, new m(String.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        BiWeeklyEvalActivity.this.setResult(-1);
        if (BiWeeklyEvalActivity.l(BiWeeklyEvalActivity.this))
        {
          BiWeeklyEvalActivity.this.finish();
          return;
        }
        BiWeeklyEvalActivity.this.finish();
        BiWeeklyEvalActivity.m(BiWeeklyEvalActivity.this);
      }
    });
  }
  
  private void j()
  {
    if (ApplicationEx.c.getUser() == null) {
      return;
    }
    com.ziroom.ziroomcustomer.newServiceList.utils.j.createShareOrder(this, this.u, "", "2c9094833db58ad9013db58dfe070002", this.C);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903117);
    a();
    e();
  }
  
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    i();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/activity/BiWeeklyEvalActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */