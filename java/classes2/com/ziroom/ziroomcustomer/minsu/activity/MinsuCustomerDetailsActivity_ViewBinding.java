package com.ziroom.ziroomcustomer.minsu.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;

public class MinsuCustomerDetailsActivity_ViewBinding<T extends MinsuCustomerDetailsActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  
  public MinsuCustomerDetailsActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.commonTitle = ((CommonTitle)Utils.findRequiredViewAsType(paramView, 2131691272, "field 'commonTitle'", CommonTitle.class));
    paramT.svContent = ((ObservableScrollView)Utils.findRequiredViewAsType(paramView, 2131690150, "field 'svContent'", ObservableScrollView.class));
    paramT.customerName = ((EditText)Utils.findRequiredViewAsType(paramView, 2131691280, "field 'customerName'", EditText.class));
    paramT.customerCerType = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691281, "field 'customerCerType'", TextView.class));
    paramT.customerCerValue = ((EditText)Utils.findRequiredViewAsType(paramView, 2131691282, "field 'customerCerValue'", EditText.class));
    paramT.customerPhoneValue = ((EditText)Utils.findRequiredViewAsType(paramView, 2131691283, "field 'customerPhoneValue'", EditText.class));
    View localView = Utils.findRequiredView(paramView, 2131691206, "field 'commit' and method 'onClick'");
    paramT.commit = ((TextView)Utils.castView(localView, 2131691206, "field 'commit'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.tvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'tvTitle'", TextView.class));
    paramView = Utils.findRequiredView(paramView, 2131691204, "method 'onClick'");
    this.c = paramView;
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
    MinsuCustomerDetailsActivity localMinsuCustomerDetailsActivity = this.a;
    if (localMinsuCustomerDetailsActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMinsuCustomerDetailsActivity.commonTitle = null;
    localMinsuCustomerDetailsActivity.svContent = null;
    localMinsuCustomerDetailsActivity.customerName = null;
    localMinsuCustomerDetailsActivity.customerCerType = null;
    localMinsuCustomerDetailsActivity.customerCerValue = null;
    localMinsuCustomerDetailsActivity.customerPhoneValue = null;
    localMinsuCustomerDetailsActivity.commit = null;
    localMinsuCustomerDetailsActivity.tvTitle = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuCustomerDetailsActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */