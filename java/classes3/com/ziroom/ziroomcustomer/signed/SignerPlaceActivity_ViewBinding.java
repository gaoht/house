package com.ziroom.ziroomcustomer.signed;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class SignerPlaceActivity_ViewBinding<T extends SignerPlaceActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  
  public SignerPlaceActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.edt_search = ((EditText)Utils.findRequiredViewAsType(paramView, 2131689934, "field 'edt_search'", EditText.class));
    paramT.signerPlace_lv = ((ListView)Utils.findRequiredViewAsType(paramView, 2131692478, "field 'signerPlace_lv'", ListView.class));
    View localView = Utils.findRequiredView(paramView, 2131692476, "field 'signerPlace_ll_search' and method 'onClick'");
    paramT.signerPlace_ll_search = ((LinearLayout)Utils.castView(localView, 2131692476, "field 'signerPlace_ll_search'", LinearLayout.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.signerPlace_tv_name = ((TextView)Utils.findRequiredViewAsType(paramView, 2131692477, "field 'signerPlace_tv_name'", TextView.class));
    paramView = Utils.findRequiredView(paramView, 2131692475, "method 'onClick'");
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
    SignerPlaceActivity localSignerPlaceActivity = this.a;
    if (localSignerPlaceActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localSignerPlaceActivity.edt_search = null;
    localSignerPlaceActivity.signerPlace_lv = null;
    localSignerPlaceActivity.signerPlace_ll_search = null;
    localSignerPlaceActivity.signerPlace_tv_name = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/SignerPlaceActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */