package com.ziroom.credit.main;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlib.utils.f;
import com.ziroom.credit.R.drawable;
import com.ziroom.credit.R.id;
import com.ziroom.credit.R.layout;
import com.ziroom.credit.base.CreditBaseFragment;
import com.ziroom.credit.base.b;
import com.ziroom.credit.view.TextViewDrawable;
import com.ziroom.credit.view.rose.RoseMapView;
import com.ziroom.credit.view.rose.RoseMapView.a;
import com.ziroom.credit.view.rose.RoseMapView.b;
import java.util.List;

public class CreditScoreAnalysisTotalFragment
  extends CreditBaseFragment
  implements s.b
{
  TextViewDrawable d;
  TextViewDrawable e;
  TextViewDrawable f;
  TextViewDrawable g;
  private Context h;
  private RoseMapView i;
  private TextView j;
  private TextView k;
  private LinearLayout l;
  
  private void a(int paramInt)
  {
    this.d.setTextColor(Color.parseColor("#999999"));
    this.d.setTextSize(14.0F);
    this.e.setTextColor(Color.parseColor("#999999"));
    this.e.setTextSize(14.0F);
    this.f.setTextColor(Color.parseColor("#999999"));
    this.f.setTextSize(14.0F);
    this.g.setTextColor(Color.parseColor("#999999"));
    this.g.setTextSize(14.0F);
    Drawable localDrawable1 = getResources().getDrawable(R.drawable.credit_zrk_ic_cdt_id_n);
    Drawable localDrawable2 = getResources().getDrawable(R.drawable.credit_zrk_ic_cdt_history_n);
    Drawable localDrawable3 = getResources().getDrawable(R.drawable.credit_zrk_ic_cdt_rent_n);
    Drawable localDrawable4 = getResources().getDrawable(R.drawable.credit_zrk_ic_cdt_other_n);
    this.d.setCompoundDrawables(null, localDrawable1, null, null);
    this.e.setCompoundDrawables(null, localDrawable2, null, null);
    this.f.setCompoundDrawables(null, localDrawable3, null, null);
    this.g.setCompoundDrawables(null, localDrawable4, null, null);
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.j.setText("身份信息");
      this.k.setText("丰富的身份、学习和职业信息，是自如信用分的参考之一，提供真实有效的信息会提高你的得分。");
      this.d.setTextColor(Color.parseColor("#444444"));
      this.d.setTextSize(16.0F);
      localDrawable1 = getResources().getDrawable(R.drawable.credit_zrk_ic_cdt_id_hl);
      this.d.setCompoundDrawables(null, localDrawable1, null, null);
      return;
    case 1: 
      this.j.setText("履约历史");
      this.k.setText("我们会采集您在自如签约、还款和解约的历史，从而更公正客观地判断您的履约能力，保持良好的履约习惯，有助于你提高得分。");
      this.e.setTextColor(Color.parseColor("#444444"));
      this.e.setTextSize(16.0F);
      localDrawable1 = getResources().getDrawable(R.drawable.credit_zrk_ic_cdt_history_hl);
      this.e.setCompoundDrawables(null, localDrawable1, null, null);
      return;
    case 2: 
      this.j.setText("租住行为");
      this.k.setText("我们会采集你在自如租住期间，和室友、管家、保洁阿姨及维修师傅等相处过程中能够的行为数据。与室友和睦相处，遵守租住公约将有助于你提高得分。\n");
      this.f.setTextColor(Color.parseColor("#444444"));
      this.f.setTextSize(16.0F);
      localDrawable1 = getResources().getDrawable(R.drawable.credit_zrk_ic_cdt_rent_hl);
      this.f.setCompoundDrawables(null, localDrawable1, null, null);
      return;
    }
    this.j.setText("外部信用");
    this.k.setText("我们会考虑你在其他信用体系的信用表现，综合评估你的信用状况。");
    this.g.setTextColor(Color.parseColor("#444444"));
    this.g.setTextSize(16.0F);
    localDrawable1 = getResources().getDrawable(R.drawable.credit_zrk_ic_cdt_other_hl);
    this.g.setCompoundDrawables(null, localDrawable1, null, null);
  }
  
  protected b a()
  {
    return new t(this);
  }
  
  protected int b()
  {
    return R.layout.credit_activity_score_analysis;
  }
  
  protected void c()
  {
    this.i = ((RoseMapView)this.a.findViewById(R.id.credit_rmv));
    this.j = ((TextView)this.a.findViewById(R.id.credit_tv_title));
    this.k = ((TextView)this.a.findViewById(R.id.credit_tv_content));
    this.l = ((LinearLayout)this.a.findViewById(R.id.credit_ll_label));
    this.d = ((TextViewDrawable)this.a.findViewById(R.id.credit_tv_1));
    this.e = ((TextViewDrawable)this.a.findViewById(R.id.credit_tv_2));
    this.f = ((TextViewDrawable)this.a.findViewById(R.id.credit_tv_3));
    this.g = ((TextViewDrawable)this.a.findViewById(R.id.credit_tv_4));
    if (f.getScreenHeight() - f.dp2px(234.0F) > f.getScreenWidth() - f.dp2px(60.0F))
    {
      f.getScreenWidth();
      f.dp2px(60.0F);
    }
    a(0);
    initListenter();
  }
  
  public Context getViewContext()
  {
    return getContext();
  }
  
  public void initListenter()
  {
    this.i.setonClickListener(new RoseMapView.b()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        TextView localTextView = (TextView)paramAnonymousView;
        int i = CreditScoreAnalysisTotalFragment.a(CreditScoreAnalysisTotalFragment.this).indexOfChild(paramAnonymousView);
        CreditScoreAnalysisTotalFragment.a(CreditScoreAnalysisTotalFragment.this, i - 1);
      }
    });
    this.i.setRotateListener(new RoseMapView.a()
    {
      public void rotate(float paramAnonymousFloat)
      {
        int i = (int)(-paramAnonymousFloat + 180.0F + 360.0F) % 360 / 90;
        CreditScoreAnalysisTotalFragment.a(CreditScoreAnalysisTotalFragment.this, i);
      }
    });
  }
  
  public boolean isActive()
  {
    return isAdded();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.h = getActivity();
  }
  
  public void setPresenter(s.a parama)
  {
    this.c = parama;
  }
  
  public void setScores(List<Float> paramList)
  {
    this.d.setText("身份信息");
    this.e.setText("履约历史");
    this.f.setText("租住行为");
    this.g.setText("外部信用");
    this.i.setmData(paramList);
    this.i.setmRatio(0.95F);
    this.i.setVisibility(0);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/main/CreditScoreAnalysisTotalFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */