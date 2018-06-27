package com.ziroom.ziroomcustomer.minsu.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.freelxl.baselibrary.f.f;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuEvaItemBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuEvaItemBean.ScoreBean;
import com.ziroom.ziroomcustomer.minsu.f.c;
import java.util.Iterator;
import java.util.List;

public class MinsuEvaItemView
  extends LinearLayout
{
  private LayoutInflater a;
  @BindView(2131690594)
  LinearLayout llScore;
  @BindView(2131694594)
  RelativeLayout rlReply;
  @BindView(2131690084)
  TextView tvContent;
  @BindView(2131694597)
  TextView txtReplyContent;
  @BindView(2131694595)
  TextView txtReplyName;
  @BindView(2131694596)
  TextView txtReplyTime;
  @BindView(2131694592)
  TextView txtUserName;
  @BindView(2131694593)
  TextView txtUserTime;
  
  public MinsuEvaItemView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public MinsuEvaItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public MinsuEvaItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a = LayoutInflater.from(paramContext);
    ButterKnife.bind(View.inflate(paramContext, 2130904057, this));
  }
  
  private void a(MinsuEvaItemBean paramMinsuEvaItemBean)
  {
    if (c.isNullList(paramMinsuEvaItemBean.scoreList)) {}
    for (;;)
    {
      return;
      this.llScore.removeAllViews();
      paramMinsuEvaItemBean = paramMinsuEvaItemBean.scoreList.iterator();
      while (paramMinsuEvaItemBean.hasNext())
      {
        MinsuEvaItemBean.ScoreBean localScoreBean = (MinsuEvaItemBean.ScoreBean)paramMinsuEvaItemBean.next();
        View localView = this.a.inflate(2130904058, null);
        TextView localTextView = (TextView)localView.findViewById(2131689541);
        FiveEvaluteButton localFiveEvaluteButton = (FiveEvaluteButton)localView.findViewById(2131694580);
        localTextView.setText(localScoreBean.name);
        localFiveEvaluteButton.setEveTextStatus(FiveEvaluteButton.a.c);
        localFiveEvaluteButton.setPadding(new int[] { 1, 0, 1, 0 });
        localFiveEvaluteButton.setSwitch(false);
        localFiveEvaluteButton.setScore(localScoreBean.score);
        this.llScore.addView(localView);
      }
    }
  }
  
  private void a(String paramString)
  {
    this.tvContent.setText(paramString);
  }
  
  public void init(MinsuEvaItemBean paramMinsuEvaItemBean)
  {
    if (paramMinsuEvaItemBean == null) {
      return;
    }
    this.txtUserName.setText(paramMinsuEvaItemBean.userName);
    this.txtUserTime.setText(paramMinsuEvaItemBean.userTime);
    a(paramMinsuEvaItemBean.userContent);
    RelativeLayout localRelativeLayout = this.rlReply;
    if (f.isNull(paramMinsuEvaItemBean.replyContent)) {}
    for (int i = 8;; i = 0)
    {
      localRelativeLayout.setVisibility(i);
      this.txtReplyTime.setText(paramMinsuEvaItemBean.replyTime);
      this.txtReplyContent.setText(paramMinsuEvaItemBean.replyContent);
      this.txtReplyName.setText(paramMinsuEvaItemBean.replyName);
      a(paramMinsuEvaItemBean);
      return;
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/MinsuEvaItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */