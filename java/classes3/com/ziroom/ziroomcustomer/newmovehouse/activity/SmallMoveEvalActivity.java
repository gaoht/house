package com.ziroom.ziroomcustomer.newmovehouse.activity;

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
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.l;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHDicTag;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHOrderDetail;
import com.ziroom.ziroomcustomer.newmovehouse.widget.FlowLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SmallMoveEvalActivity
  extends BaseActivity
{
  private Context a;
  private Unbinder b;
  @BindView(2131689816)
  Button btn_submit;
  private List<String> c = new ArrayList();
  private List<String> d = new ArrayList();
  private List<MHDicTag> e = new ArrayList();
  @BindView(2131690075)
  EditText et_eval;
  private List<MHDicTag> f = new ArrayList();
  @BindView(2131690332)
  FlowLayout fl_like;
  private List<MHDicTag> g = new ArrayList();
  private List<MHDicTag> r = new ArrayList();
  @BindView(2131690072)
  RatingBar rb_rating;
  private String s = "";
  @BindView(2131690070)
  SimpleDraweeView sdv_avatar;
  private float t = 0.0F;
  @BindView(2131690073)
  TextView tv_desc;
  @BindView(2131690076)
  TextView tv_eval_num;
  @BindView(2131690049)
  TextView tv_name;
  @BindView(2131690071)
  TextView tv_subtitle;
  private String u;
  
  private void a()
  {
    this.u = getIntent().getExtras().getString("workOrderId");
    this.tv_subtitle.setText("为搬家师傅打分");
    e(this.u);
    this.rb_rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener()
    {
      @Instrumented
      public void onRatingChanged(RatingBar paramAnonymousRatingBar, float paramAnonymousFloat, boolean paramAnonymousBoolean)
      {
        VdsAgent.onRatingChanged(this, paramAnonymousRatingBar, paramAnonymousFloat, paramAnonymousBoolean);
        if (paramAnonymousFloat > 2.9F) {
          SmallMoveEvalActivity.a(SmallMoveEvalActivity.this);
        }
        for (;;)
        {
          SmallMoveEvalActivity.a(SmallMoveEvalActivity.this, paramAnonymousFloat);
          SmallMoveEvalActivity.this.btn_submit.setEnabled(true);
          SmallMoveEvalActivity.this.tv_desc.setVisibility(0);
          SmallMoveEvalActivity.this.tv_desc.setText(j.getEvalDesc(paramAnonymousFloat));
          return;
          SmallMoveEvalActivity.b(SmallMoveEvalActivity.this);
        }
      }
    });
    this.et_eval.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        int i = 140;
        int j = paramAnonymousEditable.length();
        if (j > 140)
        {
          SmallMoveEvalActivity.this.et_eval.setText(paramAnonymousEditable.subSequence(0, 140).toString());
          SmallMoveEvalActivity.this.et_eval.setSelection(140);
        }
        paramAnonymousEditable = SmallMoveEvalActivity.this.tv_eval_num;
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
    });
  }
  
  private void b()
  {
    this.s = "up";
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
    d("MovePositiveEvaluateEnum");
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
          if (!"MovePositiveEvaluateEnum".equals(paramString)) {
            break label100;
          }
          SmallMoveEvalActivity.a(SmallMoveEvalActivity.this, paramAnonymousList);
          SmallMoveEvalActivity.c(SmallMoveEvalActivity.this).clear();
          paramAnonymousList = paramAnonymousList.iterator();
          while (paramAnonymousList.hasNext())
          {
            localMHDicTag = (MHDicTag)paramAnonymousList.next();
            SmallMoveEvalActivity.c(SmallMoveEvalActivity.this).add(localMHDicTag.getTagValue());
          }
          SmallMoveEvalActivity.a(SmallMoveEvalActivity.this);
        }
        label100:
        while (!"MoveNegativeEvaluateEnum".equals(paramString)) {
          return;
        }
        SmallMoveEvalActivity.b(SmallMoveEvalActivity.this, paramAnonymousList);
        SmallMoveEvalActivity.d(SmallMoveEvalActivity.this).clear();
        paramAnonymousList = paramAnonymousList.iterator();
        while (paramAnonymousList.hasNext())
        {
          localMHDicTag = (MHDicTag)paramAnonymousList.next();
          SmallMoveEvalActivity.d(SmallMoveEvalActivity.this).add(localMHDicTag.getTagValue());
        }
        SmallMoveEvalActivity.b(SmallMoveEvalActivity.this);
      }
    });
  }
  
  private void e()
  {
    this.s = "down";
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
    d("MoveNegativeEvaluateEnum");
  }
  
  private void e(String paramString)
  {
    com.ziroom.ziroomcustomer.e.n.getSmallMoveDetail(this.a, paramString, new com.freelxl.baselibrary.d.c.a(new m(MHOrderDetail.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, MHOrderDetail paramAnonymousMHOrderDetail)
      {
        if (paramAnonymousMHOrderDetail != null)
        {
          SmallMoveEvalActivity.this.sdv_avatar.setController(c.frescoController(paramAnonymousMHOrderDetail.getHeadPhonePath()));
          SmallMoveEvalActivity.this.tv_name.setText(paramAnonymousMHOrderDetail.getEmpName());
        }
      }
    });
  }
  
  private void f()
  {
    String str = VdsAgent.trackEditTextSilent(this.et_eval).toString();
    if (this.t == 0.0F)
    {
      g.textToast(this.a, "请选择星星");
      return;
    }
    Object localObject1 = ApplicationEx.c.getUser();
    if (localObject1 == null)
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this.a);
      return;
    }
    localObject1 = ((UserInfo)localObject1).getUid();
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    MHDicTag localMHDicTag;
    if ((this.e != null) && (this.e.size() > 0))
    {
      localObject2 = this.e.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localMHDicTag = (MHDicTag)((Iterator)localObject2).next();
        localHashMap1.put(localMHDicTag.getTagKey(), localMHDicTag.getTagValue());
      }
    }
    if ((this.f != null) && (this.f.size() > 0))
    {
      localObject2 = this.f.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localMHDicTag = (MHDicTag)((Iterator)localObject2).next();
        localHashMap2.put(localMHDicTag.getTagKey(), localMHDicTag.getTagValue());
      }
    }
    Object localObject2 = (int)this.t + "";
    com.ziroom.ziroomcustomer.e.n.saveSmallMoveEval(this.a, (String)localObject1, this.u, (String)localObject2, str, localHashMap1, localHashMap2, new com.freelxl.baselibrary.d.c.a(new m(com.ziroom.ziroomcustomer.newServiceList.model.n.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        j.showFailureMessage(SmallMoveEvalActivity.e(SmallMoveEvalActivity.this), paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.ziroomcustomer.newServiceList.model.n paramAnonymousn)
      {
        SmallMoveEvalActivity.this.setResult(-1, SmallMoveEvalActivity.this.getIntent());
        SmallMoveEvalActivity.this.finish();
      }
    });
  }
  
  private void f(String paramString)
  {
    if (TextUtils.isEmpty(this.s)) {}
    for (;;)
    {
      return;
      Iterator localIterator;
      if ("up".equals(this.s)) {
        localIterator = this.e.iterator();
      }
      while (localIterator.hasNext()) {
        if (paramString.equals((MHDicTag)localIterator.next()))
        {
          localIterator.remove();
          continue;
          if ("down".equals(this.s)) {
            localIterator = this.f.iterator();
          } else {
            localIterator = null;
          }
        }
      }
    }
  }
  
  private void g(String paramString)
  {
    if (!TextUtils.isEmpty(this.s))
    {
      Iterator localIterator;
      MHDicTag localMHDicTag;
      if ("up".equals(this.s))
      {
        localIterator = this.g.iterator();
        while (localIterator.hasNext())
        {
          localMHDicTag = (MHDicTag)localIterator.next();
          if (paramString.equals(localMHDicTag.getTagValue())) {
            this.e.add(localMHDicTag);
          }
        }
      }
      if ("down".equals(this.s))
      {
        localIterator = this.r.iterator();
        while (localIterator.hasNext())
        {
          localMHDicTag = (MHDicTag)localIterator.next();
          if (paramString.equals(localMHDicTag.getTagValue())) {
            this.f.add(localMHDicTag);
          }
        }
      }
    }
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
              SmallMoveEvalActivity.a(SmallMoveEvalActivity.this, str);
              return;
            }
            paramAnonymousView.setBackgroundResource(2130838210);
            paramAnonymousView.setTextColor(-6710887);
            paramAnonymousView.setTag(Boolean.valueOf(false));
            SmallMoveEvalActivity.b(SmallMoveEvalActivity.this, str);
          }
        });
        this.fl_like.addView(localButton);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/activity/SmallMoveEvalActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */