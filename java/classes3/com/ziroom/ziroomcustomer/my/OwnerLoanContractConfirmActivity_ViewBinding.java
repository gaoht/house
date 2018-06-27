package com.ziroom.ziroomcustomer.my;

import android.view.View;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;

public class OwnerLoanContractConfirmActivity_ViewBinding<T extends OwnerLoanContractConfirmActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  
  public OwnerLoanContractConfirmActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131689492, "field 'iv_back' and method 'onClick'");
    paramT.iv_back = ((ImageView)Utils.castView(localView, 2131689492, "field 'iv_back'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.mListView = ((ListViewForScrollView)Utils.findRequiredViewAsType(paramView, 2131692015, "field 'mListView'", ListViewForScrollView.class));
    paramT.mVsError = ((ViewStub)Utils.findRequiredViewAsType(paramView, 2131690620, "field 'mVsError'", ViewStub.class));
    localView = Utils.findRequiredView(paramView, 2131691990, "field 'tv_contact_keeper' and method 'onClick'");
    paramT.tv_contact_keeper = ((TextView)Utils.castView(localView, 2131691990, "field 'tv_contact_keeper'", TextView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.cb_agree_contract_items = ((CheckBox)Utils.findRequiredViewAsType(paramView, 2131692016, "field 'cb_agree_contract_items'", CheckBox.class));
    paramT.tv_agree_contract_items = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692017, "field 'tv_agree_contract_items'", TextView.class));
    paramView = Utils.findRequiredView(paramView, 2131691101, "method 'onClick'");
    this.d = paramView;
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
    OwnerLoanContractConfirmActivity localOwnerLoanContractConfirmActivity = this.a;
    if (localOwnerLoanContractConfirmActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localOwnerLoanContractConfirmActivity.iv_back = null;
    localOwnerLoanContractConfirmActivity.mListView = null;
    localOwnerLoanContractConfirmActivity.mVsError = null;
    localOwnerLoanContractConfirmActivity.tv_contact_keeper = null;
    localOwnerLoanContractConfirmActivity.cb_agree_contract_items = null;
    localOwnerLoanContractConfirmActivity.tv_agree_contract_items = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/OwnerLoanContractConfirmActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */