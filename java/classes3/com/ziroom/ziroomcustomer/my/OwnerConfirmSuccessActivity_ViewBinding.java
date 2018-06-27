package com.ziroom.ziroomcustomer.my;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;

public class OwnerConfirmSuccessActivity_ViewBinding<T extends OwnerConfirmSuccessActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public OwnerConfirmSuccessActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.btnBack = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690078, "field 'btnBack'", ImageView.class));
    paramT.tvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'tvTitle'", TextView.class));
    paramT.tvResultTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691987, "field 'tvResultTitle'", TextView.class));
    paramT.tvResultDesc = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691988, "field 'tvResultDesc'", TextView.class));
    View localView = Utils.findRequiredView(paramView, 2131691989, "field 'btnBackOwnerZoon' and method 'onViewClicked'");
    paramT.btnBackOwnerZoon = ((TextView)Utils.castView(localView, 2131691989, "field 'btnBackOwnerZoon'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked();
      }
    });
    paramT.sdvResultIcon = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131691986, "field 'sdvResultIcon'", SimpleDraweeView.class));
  }
  
  public void unbind()
  {
    OwnerConfirmSuccessActivity localOwnerConfirmSuccessActivity = this.a;
    if (localOwnerConfirmSuccessActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localOwnerConfirmSuccessActivity.btnBack = null;
    localOwnerConfirmSuccessActivity.tvTitle = null;
    localOwnerConfirmSuccessActivity.tvResultTitle = null;
    localOwnerConfirmSuccessActivity.tvResultDesc = null;
    localOwnerConfirmSuccessActivity.btnBackOwnerZoon = null;
    localOwnerConfirmSuccessActivity.sdvResultIcon = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/OwnerConfirmSuccessActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */