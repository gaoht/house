package com.ziroom.credit.main;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.ziroom.credit.R.id;
import com.ziroom.credit.R.layout;
import com.ziroom.credit.base.CreditBaseFragment;
import com.ziroom.credit.base.b;
import com.ziroom.credit.view.CreditChartView;
import com.ziroom.datacenter.remote.responsebody.financial.b.u;
import java.util.List;

public class CreditScoreAnalysisBrokenLineFragment
  extends CreditBaseFragment
  implements o.b
{
  private CreditScoreAnalysisActivity d;
  private CreditChartView e;
  private TextView f;
  private TextView g;
  private boolean h = true;
  
  protected b a()
  {
    return new p(this);
  }
  
  protected int b()
  {
    return R.layout.credit_activity_score_analysis_chart_line;
  }
  
  protected void c()
  {
    this.e = ((CreditChartView)this.a.findViewById(R.id.credit_creditchart));
    this.f = ((TextView)this.a.findViewById(R.id.credit_tv_score_empty));
    this.g = ((TextView)this.a.findViewById(R.id.credit_tv_content));
  }
  
  public Context getViewContext()
  {
    return getContext();
  }
  
  public boolean isActive()
  {
    return isAdded();
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.d = ((CreditScoreAnalysisActivity)getActivity());
  }
  
  public void setIsGetSuccess(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.f.setVisibility(0);
      this.g.setText("数据积累中，下个月再来看看");
    }
  }
  
  public void setPresenter(o.a parama)
  {
    this.c = parama;
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if ((getUserVisibleHint()) && (this.h))
    {
      this.e.setRankData(this.e.getRankData(), true, this.e.isColor());
      this.h = false;
    }
    while ((this.e == null) || (this.e.getRankData() == null)) {
      return;
    }
    this.e.setRankData(this.e.getRankData(), false, this.e.isColor());
  }
  
  public void setcreditchart(List<u> paramList, boolean paramBoolean)
  {
    this.e.setRankData(paramList, false, paramBoolean);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/main/CreditScoreAnalysisBrokenLineFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */