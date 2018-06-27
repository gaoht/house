package com.ziroom.ziroomcustomer.my;

import android.view.View;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.webview.ScrollBridgeWebView;

public class OCContractItemFragment_ViewBinding<T extends OCContractItemFragment>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  
  public OCContractItemFragment_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.wvOcContractItems = ((ScrollBridgeWebView)Utils.findRequiredViewAsType(paramView, 2131693947, "field 'wvOcContractItems'", ScrollBridgeWebView.class));
    paramT.cbAgreeContractItems = ((CheckBox)Utils.findRequiredViewAsType(paramView, 2131692016, "field 'cbAgreeContractItems'", CheckBox.class));
    View localView = Utils.findRequiredView(paramView, 2131692017, "field 'tvAgreeContractItems' and method 'onViewClicked'");
    paramT.tvAgreeContractItems = ((TextView)Utils.castView(localView, 2131692017, "field 'tvAgreeContractItems'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.tvDescAgreeContractItems = ((TextView)Utils.findRequiredViewAsType(paramView, 2131693948, "field 'tvDescAgreeContractItems'", TextView.class));
    paramView = Utils.findRequiredView(paramView, 2131690620, "field 'stubError' and method 'onViewClicked'");
    paramT.stubError = ((ViewStub)Utils.castView(paramView, 2131690620, "field 'stubError'", ViewStub.class));
    this.c = paramView;
    paramView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
  }
  
  public void unbind()
  {
    OCContractItemFragment localOCContractItemFragment = this.a;
    if (localOCContractItemFragment == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localOCContractItemFragment.wvOcContractItems = null;
    localOCContractItemFragment.cbAgreeContractItems = null;
    localOCContractItemFragment.tvAgreeContractItems = null;
    localOCContractItemFragment.tvDescAgreeContractItems = null;
    localOCContractItemFragment.stubError = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/OCContractItemFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */