package com.ziroom.credit.main;

import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.ImageView;
import com.ziroom.credit.R.drawable;
import com.ziroom.credit.R.id;
import com.ziroom.credit.R.layout;
import com.ziroom.credit.a.d;
import com.ziroom.credit.base.CreditBaseActivity;
import com.ziroom.credit.base.b;

public class CreditScoreAnalysisActivity
  extends CreditBaseActivity
{
  View d;
  private boolean e = true;
  private ViewPager f;
  private ImageView g;
  private ImageView h;
  private ImageView i;
  
  protected b b()
  {
    return null;
  }
  
  protected int c()
  {
    return R.layout.credit_activity_ziroom_scoreanalysis;
  }
  
  protected void d()
  {
    this.g = ((ImageView)findViewById(R.id.credit_analysis_ivone));
    this.h = ((ImageView)findViewById(R.id.credit_analysis_ivtwo));
    this.i = ((ImageView)findViewById(R.id.credit_analysis_ivthree));
    this.f = ((ViewPager)findViewById(R.id.credit_analysis_vp));
    this.d = findViewById(R.id.credit_bottom_line);
    this.d.setVisibility(8);
    this.g.setImageResource(R.drawable.credit_bg_credit_score_analysis_indicator_selected);
    this.h.setImageResource(R.drawable.credit_bg_credit_score_analysis_indicator_nomal);
    this.i.setImageResource(R.drawable.credit_bg_credit_score_analysis_indicator_nomal);
    this.f.setCurrentItem(0);
    this.f.setOffscreenPageLimit(3);
    setTitleText("自如分解读");
    this.f.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public void onPageScrollStateChanged(int paramAnonymousInt) {}
      
      public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
      
      public void onPageSelected(int paramAnonymousInt)
      {
        switch (paramAnonymousInt)
        {
        default: 
          return;
        case 0: 
          CreditScoreAnalysisActivity.a(CreditScoreAnalysisActivity.this).setImageResource(R.drawable.credit_bg_credit_score_analysis_indicator_selected);
          CreditScoreAnalysisActivity.b(CreditScoreAnalysisActivity.this).setImageResource(R.drawable.credit_bg_credit_score_analysis_indicator_nomal);
          CreditScoreAnalysisActivity.c(CreditScoreAnalysisActivity.this).setImageResource(R.drawable.credit_bg_credit_score_analysis_indicator_nomal);
          return;
        case 1: 
          CreditScoreAnalysisActivity.a(CreditScoreAnalysisActivity.this).setImageResource(R.drawable.credit_bg_credit_score_analysis_indicator_nomal);
          CreditScoreAnalysisActivity.b(CreditScoreAnalysisActivity.this).setImageResource(R.drawable.credit_bg_credit_score_analysis_indicator_selected);
          CreditScoreAnalysisActivity.c(CreditScoreAnalysisActivity.this).setImageResource(R.drawable.credit_bg_credit_score_analysis_indicator_nomal);
          return;
        }
        CreditScoreAnalysisActivity.a(CreditScoreAnalysisActivity.this).setImageResource(R.drawable.credit_bg_credit_score_analysis_indicator_nomal);
        CreditScoreAnalysisActivity.b(CreditScoreAnalysisActivity.this).setImageResource(R.drawable.credit_bg_credit_score_analysis_indicator_nomal);
        CreditScoreAnalysisActivity.c(CreditScoreAnalysisActivity.this).setImageResource(R.drawable.credit_bg_credit_score_analysis_indicator_selected);
      }
    });
  }
  
  protected void initData()
  {
    d locald = new d(getSupportFragmentManager());
    this.f.setAdapter(locald);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/main/CreditScoreAnalysisActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */