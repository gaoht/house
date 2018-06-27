package com.ziroom.ziroomcustomer.newServiceList.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.l;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.model.bn;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newclean.activity.GeneralCleanQuestionnaireActivity;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHDicTag;
import com.ziroom.ziroomcustomer.newmovehouse.widget.FlowLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GeneralCleaningEvalActivity
  extends BaseActivity
{
  private Context a;
  private Unbinder b;
  @BindView(2131689816)
  Button btn_submit;
  private List<String> c = new ArrayList();
  private List<String> d = new ArrayList();
  private List<String> e = new ArrayList();
  @BindView(2131690075)
  EditText et_eval;
  private List<String> f = new ArrayList();
  @BindView(2131690332)
  FlowLayout fl_like;
  private String g = "";
  private float r = 0.0F;
  @BindView(2131690072)
  RatingBar rb_rating;
  private String s;
  @BindView(2131690070)
  SimpleDraweeView sdv_avatar;
  @BindView(2131690073)
  TextView tv_desc;
  @BindView(2131690076)
  TextView tv_eval_num;
  @BindView(2131690049)
  TextView tv_name;
  
  private void a()
  {
    this.s = getIntent().getStringExtra("orderId");
    e(getIntent().getStringExtra("cleanerId"));
    this.rb_rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener()
    {
      @Instrumented
      public void onRatingChanged(RatingBar paramAnonymousRatingBar, float paramAnonymousFloat, boolean paramAnonymousBoolean)
      {
        VdsAgent.onRatingChanged(this, paramAnonymousRatingBar, paramAnonymousFloat, paramAnonymousBoolean);
        if (paramAnonymousFloat > 2.9F) {
          GeneralCleaningEvalActivity.a(GeneralCleaningEvalActivity.this);
        }
        for (;;)
        {
          GeneralCleaningEvalActivity.a(GeneralCleaningEvalActivity.this, paramAnonymousFloat);
          GeneralCleaningEvalActivity.this.btn_submit.setEnabled(true);
          GeneralCleaningEvalActivity.this.tv_desc.setVisibility(0);
          GeneralCleaningEvalActivity.this.tv_desc.setText(j.getEvalDesc(paramAnonymousFloat));
          return;
          GeneralCleaningEvalActivity.b(GeneralCleaningEvalActivity.this);
        }
      }
    });
    this.et_eval.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        int i = 140;
        if (paramAnonymousEditable.length() > 140)
        {
          GeneralCleaningEvalActivity.this.et_eval.setText(paramAnonymousEditable.subSequence(0, 140).toString());
          GeneralCleaningEvalActivity.this.et_eval.setSelection(140);
        }
        TextView localTextView = GeneralCleaningEvalActivity.this.tv_eval_num;
        StringBuilder localStringBuilder = new StringBuilder();
        if (paramAnonymousEditable.length() > 140) {}
        for (;;)
        {
          localTextView.setText(i + "/140");
          return;
          i = paramAnonymousEditable.length();
        }
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
  }
  
  private void b()
  {
    this.g = "up";
    this.e.clear();
    this.f.clear();
    this.fl_like.removeAllViews();
    if ((this.c != null) && (this.c.size() > 0))
    {
      this.fl_like.setVisibility(0);
      setNeedFlikTag(this.c);
      return;
    }
    this.fl_like.setVisibility(8);
    d("GenCleanPositiveEvaluateEnum");
  }
  
  private void d(final String paramString)
  {
    com.ziroom.ziroomcustomer.e.n.getCommonDicTag(this.a, paramString, new com.freelxl.baselibrary.d.c.a(new l(MHDicTag.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, List<MHDicTag> paramAnonymousList)
      {
        MHDicTag localMHDicTag;
        if ((paramAnonymousList != null) && (paramAnonymousList.size() > 0))
        {
          if (!"GenCleanPositiveEvaluateEnum".equals(paramString)) {
            break label91;
          }
          GeneralCleaningEvalActivity.c(GeneralCleaningEvalActivity.this).clear();
          paramAnonymousList = paramAnonymousList.iterator();
          while (paramAnonymousList.hasNext())
          {
            localMHDicTag = (MHDicTag)paramAnonymousList.next();
            GeneralCleaningEvalActivity.c(GeneralCleaningEvalActivity.this).add(localMHDicTag.getTagValue());
          }
          GeneralCleaningEvalActivity.a(GeneralCleaningEvalActivity.this);
        }
        label91:
        while (!"GenCleanNegativeEvaluateEnum".equals(paramString)) {
          return;
        }
        GeneralCleaningEvalActivity.d(GeneralCleaningEvalActivity.this).clear();
        paramAnonymousList = paramAnonymousList.iterator();
        while (paramAnonymousList.hasNext())
        {
          localMHDicTag = (MHDicTag)paramAnonymousList.next();
          GeneralCleaningEvalActivity.d(GeneralCleaningEvalActivity.this).add(localMHDicTag.getTagValue());
        }
        GeneralCleaningEvalActivity.b(GeneralCleaningEvalActivity.this);
      }
    });
  }
  
  private void e()
  {
    this.g = "down";
    this.e.clear();
    this.f.clear();
    this.fl_like.removeAllViews();
    if ((this.d != null) && (this.d.size() > 0))
    {
      this.fl_like.setVisibility(0);
      setNeedFlikTag(this.d);
      return;
    }
    this.fl_like.setVisibility(8);
    d("GenCleanNegativeEvaluateEnum");
  }
  
  private void e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    com.ziroom.ziroomcustomer.e.n.getWeekCleanerInfo(this.a, paramString, new com.freelxl.baselibrary.d.c.a(new m(bn.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, bn paramAnonymousbn)
      {
        if (paramAnonymousbn != null)
        {
          GeneralCleaningEvalActivity.this.sdv_avatar.setController(c.frescoController(paramAnonymousbn.getHeadPic()));
          GeneralCleaningEvalActivity.this.tv_name.setText(paramAnonymousbn.getName());
        }
      }
    });
  }
  
  private void f()
  {
    String str1 = VdsAgent.trackEditTextSilent(this.et_eval).toString();
    Object localObject1 = ApplicationEx.c.getUser();
    if (localObject1 == null)
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this.a);
      return;
    }
    String str2 = ((UserInfo)localObject1).getUid();
    Object localObject3;
    if ((this.e != null) && (this.e.size() > 0))
    {
      localObject3 = this.e.iterator();
      localObject1 = "";
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = (String)((Iterator)localObject3).next();
        if (this.e.size() == 1) {}
        for (localObject1 = localObject2;; localObject1 = (String)localObject1 + ";" + (String)localObject2) {
          break;
        }
      }
    }
    for (Object localObject2 = localObject1;; localObject2 = "")
    {
      if ((this.f != null) && (this.f.size() > 0))
      {
        Iterator localIterator = this.f.iterator();
        localObject1 = "";
        if (localIterator.hasNext())
        {
          localObject3 = (String)localIterator.next();
          if (this.f.size() == 1) {}
          for (localObject1 = localObject3;; localObject1 = (String)localObject1 + ";" + (String)localObject3) {
            break;
          }
        }
      }
      for (;;)
      {
        com.ziroom.ziroomcustomer.e.n.saveGenerCleanerEval(this.a, str1, this.r, str2, this.s, (String)localObject2, (String)localObject1, "", null, new com.freelxl.baselibrary.d.c.a(new m(com.ziroom.ziroomcustomer.newServiceList.model.n.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
        {
          public void onFailure(Throwable paramAnonymousThrowable)
          {
            j.showFailureMessage(GeneralCleaningEvalActivity.e(GeneralCleaningEvalActivity.this), paramAnonymousThrowable);
          }
          
          public void onSuccess(int paramAnonymousInt, com.ziroom.ziroomcustomer.newServiceList.model.n paramAnonymousn)
          {
            GeneralCleaningEvalActivity.this.setResult(-1);
            if (paramAnonymousn != null)
            {
              if ("on".equals(paramAnonymousn.getInvestigationSwitch()))
              {
                paramAnonymousn = new Intent(GeneralCleaningEvalActivity.e(GeneralCleaningEvalActivity.this), GeneralCleanQuestionnaireActivity.class);
                paramAnonymousn.putExtra("orderCode", GeneralCleaningEvalActivity.f(GeneralCleaningEvalActivity.this));
                GeneralCleaningEvalActivity.this.startActivity(paramAnonymousn);
                GeneralCleaningEvalActivity.this.finish();
              }
            }
            else {
              return;
            }
            GeneralCleaningEvalActivity.this.finish();
          }
        });
        return;
        localObject1 = "";
      }
    }
  }
  
  private void f(String paramString)
  {
    if (TextUtils.isEmpty(this.g)) {}
    for (;;)
    {
      return;
      Iterator localIterator;
      if ("up".equals(this.g))
      {
        localIterator = this.e.iterator();
        while (localIterator.hasNext()) {
          if (paramString.equals((String)localIterator.next())) {
            localIterator.remove();
          }
        }
      }
      else if ("down".equals(this.g))
      {
        localIterator = this.f.iterator();
        while (localIterator.hasNext()) {
          if (paramString.equals((String)localIterator.next())) {
            localIterator.remove();
          }
        }
      }
    }
  }
  
  private void g(String paramString)
  {
    if (!TextUtils.isEmpty(this.g))
    {
      if (!"up".equals(this.g)) {
        break label34;
      }
      this.e.add(paramString);
    }
    label34:
    while (!"down".equals(this.g)) {
      return;
    }
    this.f.add(paramString);
  }
  
  @OnClick({2131689492, 2131689816})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (paramView != null) {}
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      finish();
      return;
    }
    f();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903185);
    this.a = this;
    this.b = ButterKnife.bind(this);
    a();
  }
  
  protected void onDestroy()
  {
    this.b.unbind();
    super.onDestroy();
  }
  
  public void setNeedFlikTag(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (String)paramList.next();
        Button localButton = new Button(this);
        localButton.setText((CharSequence)localObject);
        localButton.setTag(Boolean.valueOf(false));
        localButton.setTextColor(-6710887);
        localButton.setTextSize(12.0F);
        localButton.setPadding(com.ziroom.ziroomcustomer.util.n.dip2px(this.a, 8.0F), com.ziroom.ziroomcustomer.util.n.dip2px(this.a, 6.0F), com.ziroom.ziroomcustomer.util.n.dip2px(this.a, 8.0F), com.ziroom.ziroomcustomer.util.n.dip2px(this.a, 6.0F));
        localButton.setBackgroundResource(2130838210);
        localObject = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject).setMargins(0, com.ziroom.ziroomcustomer.util.n.dip2px(this.a, 12.0F), com.ziroom.ziroomcustomer.util.n.dip2px(this.a, 12.0F), 0);
        localButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localButton.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = (Button)paramAnonymousView;
            String str = paramAnonymousView.getText().toString();
            if (!((Boolean)paramAnonymousView.getTag()).booleanValue())
            {
              paramAnonymousView.setBackgroundResource(2130838211);
              paramAnonymousView.setTextColor(-1);
              paramAnonymousView.setTag(Boolean.valueOf(true));
              GeneralCleaningEvalActivity.a(GeneralCleaningEvalActivity.this, str);
              return;
            }
            paramAnonymousView.setBackgroundResource(2130838210);
            paramAnonymousView.setTextColor(-6710887);
            paramAnonymousView.setTag(Boolean.valueOf(false));
            GeneralCleaningEvalActivity.b(GeneralCleaningEvalActivity.this, str);
          }
        });
        this.fl_like.addView(localButton);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/activity/GeneralCleaningEvalActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */