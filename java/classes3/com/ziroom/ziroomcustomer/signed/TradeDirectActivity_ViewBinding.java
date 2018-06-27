package com.ziroom.ziroomcustomer.signed;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class TradeDirectActivity_ViewBinding<T extends TradeDirectActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  
  public TradeDirectActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.tv_title = ((TextView)Utils.findRequiredViewAsType(paramView, 2131695949, "field 'tv_title'", TextView.class));
    View localView = Utils.findRequiredView(paramView, 2131695950, "field 'tv_rightButton' and method 'onClick'");
    paramT.tv_rightButton = ((TextView)Utils.castView(localView, 2131695950, "field 'tv_rightButton'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.lv_trade = ((ListView)Utils.findRequiredViewAsType(paramView, 2131692609, "field 'lv_trade'", ListView.class));
    paramT.lv_direct = ((ListView)Utils.findRequiredViewAsType(paramView, 2131692610, "field 'lv_direct'", ListView.class));
    paramView = Utils.findRequiredView(paramView, 2131695948, "method 'onClick'");
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
    TradeDirectActivity localTradeDirectActivity = this.a;
    if (localTradeDirectActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localTradeDirectActivity.tv_title = null;
    localTradeDirectActivity.tv_rightButton = null;
    localTradeDirectActivity.lv_trade = null;
    localTradeDirectActivity.lv_direct = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/TradeDirectActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */