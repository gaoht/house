package com.ziroom.ziroomcustomer.newclean.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.newclean.cardpay.MyGridView;
import com.ziroom.ziroomcustomer.widget.HorizontalListView;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;

public class BedroomSelectTimeActivity_ViewBinding<T extends BedroomSelectTimeActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  
  public BedroomSelectTimeActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131689957, "field 'mLetLength' and method 'onClick'");
    paramT.mLetLength = ((LabeledEditText)Utils.castView(localView, 2131689957, "field 'mLetLength'", LabeledEditText.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.mLlBill = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131689958, "field 'mLlBill'", LinearLayout.class));
    paramT.mLetBill = ((LabeledEditText)Utils.findRequiredViewAsType(paramView, 2131689959, "field 'mLetBill'", LabeledEditText.class));
    paramT.mTvBillTip = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689960, "field 'mTvBillTip'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131689961, "field 'mIvSwitch' and method 'onClick'");
    paramT.mIvSwitch = ((ImageView)Utils.castView(localView, 2131689961, "field 'mIvSwitch'", ImageView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.mZiHlData = ((HorizontalListView)Utils.findRequiredViewAsType(paramView, 2131689972, "field 'mZiHlData'", HorizontalListView.class));
    paramT.myGvHome = ((MyGridView)Utils.findRequiredViewAsType(paramView, 2131689973, "field 'myGvHome'", MyGridView.class));
    paramT.mLlJudgeTip = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131689963, "field 'mLlJudgeTip'", LinearLayout.class));
    paramT.mLineJudge = Utils.findRequiredView(paramView, 2131689962, "field 'mLineJudge'");
    paramT.mTvPublicTip = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689964, "field 'mTvPublicTip'", TextView.class));
    paramT.mLlWeekTime = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131689966, "field 'mLlWeekTime'", LinearLayout.class));
    paramT.mTvWeekTime = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689967, "field 'mTvWeekTime'", TextView.class));
    paramT.mLlBedroomTime = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131689968, "field 'mLlBedroomTime'", LinearLayout.class));
    paramT.mTvBedroomTime = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689969, "field 'mTvBedroomTime'", TextView.class));
    paramT.mTvBedTip = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689970, "field 'mTvBedTip'", TextView.class));
    paramT.mVTip = Utils.findRequiredView(paramView, 2131689971, "field 'mVTip'");
    paramT.mVPoint = Utils.findRequiredView(paramView, 2131689974, "field 'mVPoint'");
    paramT.mPublicTip = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131689965, "field 'mPublicTip'", LinearLayout.class));
    localView = Utils.findRequiredView(paramView, 2131689492, "method 'onClick'");
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131689956, "method 'onClick'");
    this.e = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
  }
  
  public void unbind()
  {
    BedroomSelectTimeActivity localBedroomSelectTimeActivity = this.a;
    if (localBedroomSelectTimeActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localBedroomSelectTimeActivity.mLetLength = null;
    localBedroomSelectTimeActivity.mLlBill = null;
    localBedroomSelectTimeActivity.mLetBill = null;
    localBedroomSelectTimeActivity.mTvBillTip = null;
    localBedroomSelectTimeActivity.mIvSwitch = null;
    localBedroomSelectTimeActivity.mZiHlData = null;
    localBedroomSelectTimeActivity.myGvHome = null;
    localBedroomSelectTimeActivity.mLlJudgeTip = null;
    localBedroomSelectTimeActivity.mLineJudge = null;
    localBedroomSelectTimeActivity.mTvPublicTip = null;
    localBedroomSelectTimeActivity.mLlWeekTime = null;
    localBedroomSelectTimeActivity.mTvWeekTime = null;
    localBedroomSelectTimeActivity.mLlBedroomTime = null;
    localBedroomSelectTimeActivity.mTvBedroomTime = null;
    localBedroomSelectTimeActivity.mTvBedTip = null;
    localBedroomSelectTimeActivity.mVTip = null;
    localBedroomSelectTimeActivity.mVPoint = null;
    localBedroomSelectTimeActivity.mPublicTip = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.e.setOnClickListener(null);
    this.e = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/activity/BedroomSelectTimeActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */