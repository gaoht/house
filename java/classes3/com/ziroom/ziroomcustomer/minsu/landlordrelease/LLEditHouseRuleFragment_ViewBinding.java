package com.ziroom.ziroomcustomer.minsu.landlordrelease;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;

public class LLEditHouseRuleFragment_ViewBinding<T extends LLEditHouseRuleFragment>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public LLEditHouseRuleFragment_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.commonTitle = ((CommonTitle)Utils.findRequiredViewAsType(paramView, 2131691272, "field 'commonTitle'", CommonTitle.class));
    paramT.listview = ((ListViewForScrollView)Utils.findRequiredViewAsType(paramView, 2131690955, "field 'listview'", ListViewForScrollView.class));
    paramT.tvOtherRule = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694162, "field 'tvOtherRule'", TextView.class));
    View localView = Utils.findRequiredView(paramView, 2131694161, "field 'otherRuleArea' and method 'onViewClicked'");
    paramT.otherRuleArea = ((LinearLayout)Utils.castView(localView, 2131694161, "field 'otherRuleArea'", LinearLayout.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked();
      }
    });
    paramT.scrollview = ((ObservableScrollView)Utils.findRequiredViewAsType(paramView, 2131689506, "field 'scrollview'", ObservableScrollView.class));
  }
  
  public void unbind()
  {
    LLEditHouseRuleFragment localLLEditHouseRuleFragment = this.a;
    if (localLLEditHouseRuleFragment == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localLLEditHouseRuleFragment.commonTitle = null;
    localLLEditHouseRuleFragment.listview = null;
    localLLEditHouseRuleFragment.tvOtherRule = null;
    localLLEditHouseRuleFragment.otherRuleArea = null;
    localLLEditHouseRuleFragment.scrollview = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/LLEditHouseRuleFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */