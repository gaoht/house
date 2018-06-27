package com.ziroom.ziroomcustomer.my;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class OwnerContrastListActivity_ViewBinding<T extends OwnerContrastListActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  
  public OwnerContrastListActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.stubNotOwner = ((ViewStub)Utils.findRequiredViewAsType(paramView, 2131692002, "field 'stubNotOwner'", ViewStub.class));
    View localView = Utils.findRequiredView(paramView, 2131689492, "field 'ivBack' and method 'onViewClicked'");
    paramT.ivBack = ((ImageView)Utils.castView(localView, 2131689492, "field 'ivBack'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.lvOwnerContractList = ((ListView)Utils.findRequiredViewAsType(paramView, 2131692001, "field 'lvOwnerContractList'", ListView.class));
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
    OwnerContrastListActivity localOwnerContrastListActivity = this.a;
    if (localOwnerContrastListActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localOwnerContrastListActivity.stubNotOwner = null;
    localOwnerContrastListActivity.ivBack = null;
    localOwnerContrastListActivity.lvOwnerContractList = null;
    localOwnerContrastListActivity.stubError = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/OwnerContrastListActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */