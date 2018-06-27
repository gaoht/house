package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.webview.ScrollBridgeWebView;

public class ZryuTextWebActivity_ViewBinding<T extends ZryuTextWebActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public ZryuTextWebActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131689781, "field 'iv_hw_back' and method 'onClick'");
    paramT.iv_hw_back = ((ImageView)Utils.castView(localView, 2131689781, "field 'iv_hw_back'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.webview = ((ScrollBridgeWebView)Utils.findRequiredViewAsType(paramView, 2131689545, "field 'webview'", ScrollBridgeWebView.class));
  }
  
  public void unbind()
  {
    ZryuTextWebActivity localZryuTextWebActivity = this.a;
    if (localZryuTextWebActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localZryuTextWebActivity.iv_hw_back = null;
    localZryuTextWebActivity.webview = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuTextWebActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */