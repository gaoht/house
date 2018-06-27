package com.ziroom.credit.main;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import com.ziroom.credit.R.id;
import com.ziroom.credit.R.layout;
import com.ziroom.credit.base.CreditBaseFragment;
import com.ziroom.credit.base.b;
import com.ziroom.credit.view.rank.ScoreRankTextView;

public class CreditScoreAnalysisRankFragment
  extends CreditBaseFragment
  implements q.b
{
  private CreditScoreAnalysisActivity d;
  private TextView e;
  private ScoreRankTextView f;
  private ValueAnimator g;
  private TextView h;
  private TextView i;
  private TextView j;
  private boolean k = true;
  
  protected b a()
  {
    return new r(this);
  }
  
  protected int b()
  {
    return R.layout.credit_activity_score_analysis_rank;
  }
  
  protected void c()
  {
    this.f = ((ScoreRankTextView)this.a.findViewById(R.id.credit_tv_credit_score));
    this.e = ((TextView)this.a.findViewById(R.id.credit_tv_credit_score_explain));
    this.h = ((TextView)this.a.findViewById(R.id.credit_tv_rank_explain));
    this.i = ((TextView)this.a.findViewById(R.id.credit_tv_rank_empty));
    this.j = ((TextView)this.a.findViewById(R.id.credit_tv_score_percent));
  }
  
  public Context getViewContext()
  {
    return getContext();
  }
  
  public boolean isActive()
  {
    return isAdded();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.d = ((CreditScoreAnalysisActivity)getActivity());
  }
  
  public void setCreditRankExplain(SpannableStringBuilder paramSpannableStringBuilder)
  {
    this.h.setText(paramSpannableStringBuilder);
  }
  
  public void setCreditScoreRankPercent(int paramInt)
  {
    this.f.setText(paramInt + "");
    this.f.setVisibility(0);
    this.e.setVisibility(0);
    this.j.setVisibility(0);
  }
  
  public void setCreditScoreRankStr(String paramString) {}
  
  public void setIsGetData(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.f.setVisibility(8);
      this.e.setVisibility(8);
      this.j.setVisibility(8);
      this.i.setVisibility(0);
      this.i.setText("暂无排名信息");
      this.h.setText("数据积累中，下个月再来看看");
    }
  }
  
  public void setPresenter(q.a parama)
  {
    this.c = parama;
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if ((getUserVisibleHint()) && (this.k) && (this.f.getVisibility() == 0))
    {
      this.k = false;
      final int m = Integer.valueOf(this.f.getText().toString()).intValue();
      this.g = ValueAnimator.ofInt(new int[] { 1, m });
      this.g.setDuration(850L);
      this.g.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          CreditScoreAnalysisRankFragment.a(CreditScoreAnalysisRankFragment.this).setText(paramAnonymousValueAnimator.getAnimatedValue() + "");
          if (((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue() == m) {
            CreditScoreAnalysisRankFragment.b(CreditScoreAnalysisRankFragment.this).setText("已超越" + paramAnonymousValueAnimator.getAnimatedValue() + "%自如客");
          }
        }
      });
      this.g.start();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/main/CreditScoreAnalysisRankFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */