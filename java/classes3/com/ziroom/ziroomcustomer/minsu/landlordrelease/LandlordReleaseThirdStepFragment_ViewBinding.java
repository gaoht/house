package com.ziroom.ziroomcustomer.minsu.landlordrelease;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.view.ReleaseUsageAndTipsView;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;

public class LandlordReleaseThirdStepFragment_ViewBinding<T extends LandlordReleaseThirdStepFragment>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  
  public LandlordReleaseThirdStepFragment_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.tvTitle1 = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691330, "field 'tvTitle1'", TextView.class));
    paramT.tvDesc1 = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694676, "field 'tvDesc1'", TextView.class));
    paramT.checkbox1 = ((CheckBox)Utils.findRequiredViewAsType(paramView, 2131694677, "field 'checkbox1'", CheckBox.class));
    paramT.item1 = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131694675, "field 'item1'", RelativeLayout.class));
    paramT.tvTitle2 = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691333, "field 'tvTitle2'", TextView.class));
    paramT.tvDesc2 = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694679, "field 'tvDesc2'", TextView.class));
    paramT.checkbox2 = ((CheckBox)Utils.findRequiredViewAsType(paramView, 2131694680, "field 'checkbox2'", CheckBox.class));
    paramT.item2 = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131694678, "field 'item2'", RelativeLayout.class));
    paramT.houseRuleArea = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131694222, "field 'houseRuleArea'", LinearLayout.class));
    paramT.ivHouseRuleArrow = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131694223, "field 'ivHouseRuleArrow'", ImageView.class));
    View localView = Utils.findRequiredView(paramView, 2131694219, "field 'rlHouseRule' and method 'onViewClicked'");
    paramT.rlHouseRule = ((RelativeLayout)Utils.castView(localView, 2131694219, "field 'rlHouseRule'", RelativeLayout.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.etDeposit = ((EditText)Utils.findRequiredViewAsType(paramView, 2131694225, "field 'etDeposit'", EditText.class));
    paramT.tvCancelPolicyTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694226, "field 'tvCancelPolicyTitle'", TextView.class));
    paramT.tvCancelTitleHint = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694227, "field 'tvCancelTitleHint'", TextView.class));
    paramT.lvCancelPolicy = ((ListViewForScrollView)Utils.findRequiredViewAsType(paramView, 2131694228, "field 'lvCancelPolicy'", ListViewForScrollView.class));
    paramT.lvLongPolicy = ((ListViewForScrollView)Utils.findRequiredViewAsType(paramView, 2131694229, "field 'lvLongPolicy'", ListViewForScrollView.class));
    localView = Utils.findRequiredView(paramView, 2131694230, "field 'next' and method 'onViewClicked'");
    paramT.next = ((Button)Utils.castView(localView, 2131694230, "field 'next'", Button.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.scrollview = ((ObservableScrollView)Utils.findRequiredViewAsType(paramView, 2131689506, "field 'scrollview'", ObservableScrollView.class));
    paramT.commonTitle = ((CommonTitle)Utils.findRequiredViewAsType(paramView, 2131691272, "field 'commonTitle'", CommonTitle.class));
    paramT.step3_title = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694217, "field 'step3_title'", TextView.class));
    paramT.ruatv_bottom = ((ReleaseUsageAndTipsView)Utils.findRequiredViewAsType(paramView, 2131689893, "field 'ruatv_bottom'", ReleaseUsageAndTipsView.class));
    paramT.tv_title_rule_review = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694221, "field 'tv_title_rule_review'", TextView.class));
  }
  
  public void unbind()
  {
    LandlordReleaseThirdStepFragment localLandlordReleaseThirdStepFragment = this.a;
    if (localLandlordReleaseThirdStepFragment == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localLandlordReleaseThirdStepFragment.tvTitle1 = null;
    localLandlordReleaseThirdStepFragment.tvDesc1 = null;
    localLandlordReleaseThirdStepFragment.checkbox1 = null;
    localLandlordReleaseThirdStepFragment.item1 = null;
    localLandlordReleaseThirdStepFragment.tvTitle2 = null;
    localLandlordReleaseThirdStepFragment.tvDesc2 = null;
    localLandlordReleaseThirdStepFragment.checkbox2 = null;
    localLandlordReleaseThirdStepFragment.item2 = null;
    localLandlordReleaseThirdStepFragment.houseRuleArea = null;
    localLandlordReleaseThirdStepFragment.ivHouseRuleArrow = null;
    localLandlordReleaseThirdStepFragment.rlHouseRule = null;
    localLandlordReleaseThirdStepFragment.etDeposit = null;
    localLandlordReleaseThirdStepFragment.tvCancelPolicyTitle = null;
    localLandlordReleaseThirdStepFragment.tvCancelTitleHint = null;
    localLandlordReleaseThirdStepFragment.lvCancelPolicy = null;
    localLandlordReleaseThirdStepFragment.lvLongPolicy = null;
    localLandlordReleaseThirdStepFragment.next = null;
    localLandlordReleaseThirdStepFragment.scrollview = null;
    localLandlordReleaseThirdStepFragment.commonTitle = null;
    localLandlordReleaseThirdStepFragment.step3_title = null;
    localLandlordReleaseThirdStepFragment.ruatv_bottom = null;
    localLandlordReleaseThirdStepFragment.tv_title_rule_review = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/LandlordReleaseThirdStepFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */