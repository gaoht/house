package com.ziroom.ziroomcustomer.repay;

import android.view.View;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.signed.widget.TextLineView;

public class RepayBillListActivity_ViewBinding<T extends RepayBillListActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  
  public RepayBillListActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.list_bill_repay_lv = ((ListView)Utils.findRequiredViewAsType(paramView, 2131692205, "field 'list_bill_repay_lv'", ListView.class));
    View localView = Utils.findRequiredView(paramView, 2131692203, "field 'repay_bill_tab_not_tl' and method 'onClick'");
    paramT.repay_bill_tab_not_tl = ((TextLineView)Utils.castView(localView, 2131692203, "field 'repay_bill_tab_not_tl'", TextLineView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131692204, "field 'repay_bill_tab_pay_tl' and method 'onClick'");
    paramT.repay_bill_tab_pay_tl = ((TextLineView)Utils.castView(localView, 2131692204, "field 'repay_bill_tab_pay_tl'", TextLineView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramView = Utils.findRequiredView(paramView, 2131690511, "method 'onClick'");
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
    RepayBillListActivity localRepayBillListActivity = this.a;
    if (localRepayBillListActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localRepayBillListActivity.list_bill_repay_lv = null;
    localRepayBillListActivity.repay_bill_tab_not_tl = null;
    localRepayBillListActivity.repay_bill_tab_pay_tl = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/repay/RepayBillListActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */