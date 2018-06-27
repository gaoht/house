package com.ziroom.ziroomcustomer.my;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.activity.ListViewForScrollView;

public class OwnerContractDetailActivity_ViewBinding<T extends OwnerContractDetailActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  
  public OwnerContractDetailActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131689492, "field 'ivBack', method 'onViewClick', and method 'onViewClicked'");
    paramT.ivBack = ((ImageView)Utils.castView(localView, 2131689492, "field 'ivBack'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691990, "field 'tvContactKeeper' and method 'onViewClicked'");
    paramT.tvContactKeeper = ((TextView)Utils.castView(localView, 2131691990, "field 'tvContactKeeper'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.llContentContainer = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690608, "field 'llContentContainer'", LinearLayout.class));
    paramT.owner_contract_detail_list = ((ListViewForScrollView)Utils.findRequiredViewAsType(paramView, 2131691999, "field 'owner_contract_detail_list'", ListViewForScrollView.class));
    paramView = Utils.findRequiredView(paramView, 2131692000, "field 'owner_contract_detail_html' and method 'onViewClick'");
    paramT.owner_contract_detail_html = ((LinearLayout)Utils.castView(paramView, 2131692000, "field 'owner_contract_detail_html'", LinearLayout.class));
    this.d = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClick(paramAnonymousView);
      }
    });
  }
  
  public void unbind()
  {
    OwnerContractDetailActivity localOwnerContractDetailActivity = this.a;
    if (localOwnerContractDetailActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localOwnerContractDetailActivity.ivBack = null;
    localOwnerContractDetailActivity.tvContactKeeper = null;
    localOwnerContractDetailActivity.llContentContainer = null;
    localOwnerContractDetailActivity.owner_contract_detail_list = null;
    localOwnerContractDetailActivity.owner_contract_detail_html = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/OwnerContractDetailActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */