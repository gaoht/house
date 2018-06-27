package com.ziroom.ziroomcustomer.newclean.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class AcarusKillingProjectActivity_ViewBinding<T extends AcarusKillingProjectActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  
  public AcarusKillingProjectActivity_ViewBinding(final T paramT, View paramView)
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
    paramT.tv_tip = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689837, "field 'tv_tip'", TextView.class));
    paramT.lv_project = ((ListView)Utils.findRequiredViewAsType(paramView, 2131689844, "field 'lv_project'", ListView.class));
    localView = Utils.findRequiredView(paramView, 2131689839, "field 'll_show_money' and method 'onClick'");
    paramT.ll_show_money = ((LinearLayout)Utils.castView(localView, 2131689839, "field 'll_show_money'", LinearLayout.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.tv_all_price = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689841, "field 'tv_all_price'", TextView.class));
    paramT.iv_all_price = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131689842, "field 'iv_all_price'", ImageView.class));
    localView = Utils.findRequiredView(paramView, 2131689843, "field 'btn_commit' and method 'onClick'");
    paramT.btn_commit = ((Button)Utils.castView(localView, 2131689843, "field 'btn_commit'", Button.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.tv_unit = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689840, "field 'tv_unit'", TextView.class));
  }
  
  public void unbind()
  {
    AcarusKillingProjectActivity localAcarusKillingProjectActivity = this.a;
    if (localAcarusKillingProjectActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localAcarusKillingProjectActivity.iv_back = null;
    localAcarusKillingProjectActivity.tv_tip = null;
    localAcarusKillingProjectActivity.lv_project = null;
    localAcarusKillingProjectActivity.ll_show_money = null;
    localAcarusKillingProjectActivity.tv_all_price = null;
    localAcarusKillingProjectActivity.iv_all_price = null;
    localAcarusKillingProjectActivity.btn_commit = null;
    localAcarusKillingProjectActivity.tv_unit = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/activity/AcarusKillingProjectActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */