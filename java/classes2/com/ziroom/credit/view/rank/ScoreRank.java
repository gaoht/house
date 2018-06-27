package com.ziroom.credit.view.rank;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class ScoreRank
  extends RelativeLayout
{
  Context a = getContext();
  ScoreRankInSideView b;
  ScoreRankOutSideView c;
  
  public ScoreRank(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ScoreRank(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.b = new ScoreRankInSideView(this.a);
    this.b.setTag("ScoreRankInSideView");
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(13);
    this.b.setLayoutParams(localLayoutParams);
    this.c = new ScoreRankOutSideView(this.a);
    this.c.setTag("ScoreRankOutSideView");
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(13);
    this.c.setLayoutParams(localLayoutParams);
    addView(this.c);
    addView(this.b);
  }
  
  public static int px2dip(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat / paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/view/rank/ScoreRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */