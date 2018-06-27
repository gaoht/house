package com.ziroom.ziroomcustomer.activity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils.TruncateAt;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.alibaba.fastjson.b;
import com.alibaba.fastjson.e;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.flexbox.FlexboxLayout.LayoutParams;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.model.EvaluateOption;
import com.ziroom.ziroomcustomer.model.EvaluateSubOption;
import com.ziroom.ziroomcustomer.model.EvaluateWithStar;
import com.ziroom.ziroomcustomer.newServiceList.view.RatingStar;
import com.ziroom.ziroomcustomer.newServiceList.view.RatingStar.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EvaluateSignFragment
  extends BaseFragment
{
  private Context a;
  private TextView b;
  private RatingStar c;
  private FlexboxLayout d;
  private EditText e;
  private TextView f;
  private FrameLayout g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private List<EvaluateSubOption> m;
  private EvaluateWithStar n;
  private a o;
  private int p;
  
  private void a(List<EvaluateSubOption> paramList)
  {
    if (this.m != null) {
      this.m.clear();
    }
    this.d.removeAllViews();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        final EvaluateSubOption localEvaluateSubOption = (EvaluateSubOption)paramList.next();
        CheckBox localCheckBox = new CheckBox(this.a);
        localCheckBox.setTextSize(2, 12.0F);
        localCheckBox.setTextColor(this.k);
        localCheckBox.setGravity(17);
        localCheckBox.setButtonDrawable(null);
        localCheckBox.setBackgroundResource(2130839466);
        FlexboxLayout.LayoutParams localLayoutParams = new FlexboxLayout.LayoutParams(-2, -2);
        localLayoutParams.b = 0.0F;
        localCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
          @Instrumented
          public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
          {
            VdsAgent.onCheckedChanged(this, paramAnonymousCompoundButton, paramAnonymousBoolean);
            if (paramAnonymousBoolean)
            {
              paramAnonymousCompoundButton.setTextColor(EvaluateSignFragment.j(EvaluateSignFragment.this));
              EvaluateSignFragment.a(EvaluateSignFragment.this).add(localEvaluateSubOption);
              if (EvaluateSignFragment.this.getRate() >= 4) {
                break label147;
              }
              if (!EvaluateSignFragment.a(EvaluateSignFragment.this).isEmpty()) {
                break label121;
              }
              if (EvaluateSignFragment.f(EvaluateSignFragment.this) != null) {
                EvaluateSignFragment.f(EvaluateSignFragment.this).onEvaluateValidate(false, "请至少选择一个标签后方可提交哦～");
              }
            }
            label121:
            label147:
            while (EvaluateSignFragment.f(EvaluateSignFragment.this) == null)
            {
              do
              {
                return;
                paramAnonymousCompoundButton.setTextColor(EvaluateSignFragment.k(EvaluateSignFragment.this));
                EvaluateSignFragment.a(EvaluateSignFragment.this).remove(localEvaluateSubOption);
                break;
              } while (EvaluateSignFragment.f(EvaluateSignFragment.this) == null);
              EvaluateSignFragment.f(EvaluateSignFragment.this).onEvaluateValidate(true, "");
              return;
            }
            EvaluateSignFragment.f(EvaluateSignFragment.this).onEvaluateValidate(true, "");
          }
        });
        localLayoutParams.bottomMargin = this.i;
        localLayoutParams.rightMargin = this.i;
        localCheckBox.setLayoutParams(localLayoutParams);
        localCheckBox.setEllipsize(TextUtils.TruncateAt.END);
        localCheckBox.setSingleLine();
        localCheckBox.setText(localEvaluateSubOption.getDesc());
        localCheckBox.setPadding(this.i, this.j, this.i, this.j);
        localCheckBox.setTag(localEvaluateSubOption);
        this.d.addView(localCheckBox);
      }
    }
  }
  
  private void c()
  {
    String str = getArguments().getString("title");
    this.n = ((EvaluateWithStar)getArguments().getSerializable("evaluateWithStar"));
    this.b.setText(str + "");
    this.c.setOnStarScoreListener(new RatingStar.a()
    {
      public void starScore(int paramAnonymousInt)
      {
        EvaluateSignFragment.a(EvaluateSignFragment.this, paramAnonymousInt);
        int i;
        if (EvaluateSignFragment.a(EvaluateSignFragment.this) == null)
        {
          EvaluateSignFragment.a(EvaluateSignFragment.this, new ArrayList());
          Object localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, -EvaluateSignFragment.b(EvaluateSignFragment.this));
          ((TranslateAnimation)localObject).setInterpolator(new AccelerateDecelerateInterpolator());
          ((TranslateAnimation)localObject).setDuration(300L);
          ((TranslateAnimation)localObject).setFillAfter(true);
          EvaluateSignFragment.c(EvaluateSignFragment.this).startAnimation((Animation)localObject);
          i = EvaluateSignFragment.this.getRate();
          if ((EvaluateSignFragment.d(EvaluateSignFragment.this).getOptions() != null) && (i > 0) && (i <= EvaluateSignFragment.d(EvaluateSignFragment.this).getOptions().size()))
          {
            EvaluateSignFragment.b(EvaluateSignFragment.this, ((EvaluateOption)EvaluateSignFragment.d(EvaluateSignFragment.this).getOptions().get(i - 1)).getSubOptions());
            EvaluateSignFragment.e(EvaluateSignFragment.this).setVisibility(0);
            localObject = new AnimationSet(true);
            TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -0.5F, 1, 0.0F);
            localTranslateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
            localTranslateAnimation.setDuration(300L);
            localTranslateAnimation.setFillAfter(true);
            AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
            localAlphaAnimation.setDuration(300L);
            localAlphaAnimation.setFillAfter(true);
            ((AnimationSet)localObject).addAnimation(localTranslateAnimation);
            ((AnimationSet)localObject).addAnimation(localAlphaAnimation);
            EvaluateSignFragment.e(EvaluateSignFragment.this).startAnimation((Animation)localObject);
            ((AnimationSet)localObject).setAnimationListener(new Animation.AnimationListener()
            {
              public void onAnimationEnd(Animation paramAnonymous2Animation)
              {
                if (EvaluateSignFragment.f(EvaluateSignFragment.this) != null) {
                  EvaluateSignFragment.f(EvaluateSignFragment.this).onStarFocus();
                }
              }
              
              public void onAnimationRepeat(Animation paramAnonymous2Animation) {}
              
              public void onAnimationStart(Animation paramAnonymous2Animation) {}
            });
            EvaluateSignFragment.g(EvaluateSignFragment.this).startAnimation((Animation)localObject);
            label298:
            if (paramAnonymousInt < 4) {
              break label429;
            }
            if (EvaluateSignFragment.f(EvaluateSignFragment.this) != null) {
              EvaluateSignFragment.f(EvaluateSignFragment.this).onEvaluateValidate(true, "");
            }
          }
        }
        label429:
        label459:
        do
        {
          do
          {
            return;
            EvaluateSignFragment.b(EvaluateSignFragment.this, null);
            break;
            i = EvaluateSignFragment.this.getRate();
            if ((EvaluateSignFragment.d(EvaluateSignFragment.this).getOptions() != null) && (i > 0) && (i <= EvaluateSignFragment.d(EvaluateSignFragment.this).getOptions().size()))
            {
              EvaluateSignFragment.b(EvaluateSignFragment.this, ((EvaluateOption)EvaluateSignFragment.d(EvaluateSignFragment.this).getOptions().get(i - 1)).getSubOptions());
              break label298;
            }
            EvaluateSignFragment.b(EvaluateSignFragment.this, null);
            break label298;
            if (paramAnonymousInt != 0) {
              break label459;
            }
          } while (EvaluateSignFragment.f(EvaluateSignFragment.this) == null);
          EvaluateSignFragment.f(EvaluateSignFragment.this).onEvaluateValidate(false, "请先选择星级后方可提交哦～");
          return;
        } while (EvaluateSignFragment.f(EvaluateSignFragment.this) == null);
        EvaluateSignFragment.f(EvaluateSignFragment.this).onEvaluateValidate(false, "请至少选择一个标签后方可提交哦～");
      }
    });
    this.e.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (paramAnonymousEditable != null)
        {
          if (paramAnonymousEditable.length() > 140)
          {
            EvaluateSignFragment.h(EvaluateSignFragment.this).setText(paramAnonymousEditable.subSequence(0, 140));
            EvaluateSignFragment.h(EvaluateSignFragment.this).setSelection(140);
            EvaluateSignFragment.i(EvaluateSignFragment.this).setText("140/140");
          }
        }
        else {
          return;
        }
        EvaluateSignFragment.i(EvaluateSignFragment.this).setText(paramAnonymousEditable.length() + "/140");
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.d.setVisibility(8);
  }
  
  public static EvaluateSignFragment getInstance(EvaluateWithStar paramEvaluateWithStar)
  {
    EvaluateSignFragment localEvaluateSignFragment = new EvaluateSignFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("title", paramEvaluateWithStar.getTitle());
    localBundle.putSerializable("evaluateWithStar", paramEvaluateWithStar);
    localEvaluateSignFragment.setArguments(localBundle);
    return localEvaluateSignFragment;
  }
  
  public String getEvaluate()
  {
    return VdsAgent.trackEditTextSilent(this.e).toString();
  }
  
  public e getEvaluateSubmitContent()
  {
    e locale = new e();
    int i1 = getRate();
    if (this.n != null)
    {
      locale.put("collectId", this.n.getCollectId());
      if ((this.n.getOptions() != null) && (i1 > 0) && (i1 <= this.n.getOptions().size()))
      {
        locale.put("code", this.n.getStarCode());
        Object localObject = (EvaluateOption)this.n.getOptions().get(i1 - 1);
        locale.put("optionCode", ((EvaluateOption)localObject).getCode());
        locale.put("content", ((EvaluateOption)localObject).getDesc());
        locale.put("subQuestionsCode", ((EvaluateOption)localObject).getSubQuestionCode());
        if ((this.m != null) && (this.m.size() > 0))
        {
          localObject = new b();
          Iterator localIterator = this.m.iterator();
          while (localIterator.hasNext()) {
            ((b)localObject).add(((EvaluateSubOption)localIterator.next()).getSubOptionCode());
          }
          locale.put("subOptionCode", localObject);
        }
      }
      locale.put("suggestCode", this.n.getSuggestCode());
      locale.put("suggestContent", VdsAgent.trackEditTextSilent(this.e).toString());
    }
    return locale;
  }
  
  public int getRate()
  {
    return this.p;
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    this.a = paramContext;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130903906, paramViewGroup, false);
    this.i = ((int)(12.0F * getResources().getDisplayMetrics().density));
    this.h = ((int)(10.0F * getResources().getDisplayMetrics().density));
    this.j = ((int)(8.0F * getResources().getDisplayMetrics().density));
    this.k = Color.parseColor("#999999");
    this.l = Color.parseColor("#FFA000");
    this.b = ((TextView)paramLayoutInflater.findViewById(2131689541));
    this.c = ((RatingStar)paramLayoutInflater.findViewById(2131690595));
    this.e = ((EditText)paramLayoutInflater.findViewById(2131691275));
    this.g = ((FrameLayout)paramLayoutInflater.findViewById(2131690607));
    this.f = ((TextView)paramLayoutInflater.findViewById(2131690003));
    c();
    return paramLayoutInflater;
  }
  
  public void setListener(a parama)
  {
    this.o = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onEvaluateValidate(boolean paramBoolean, String paramString);
    
    public abstract void onStarFocus();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/activity/EvaluateSignFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */