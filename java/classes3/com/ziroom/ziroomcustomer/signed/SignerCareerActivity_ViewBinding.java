package com.ziroom.ziroomcustomer.signed;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class SignerCareerActivity_ViewBinding<T extends SignerCareerActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public SignerCareerActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131690588, "field 'ivClose' and method 'onViewClicked'");
    paramT.ivClose = ((ImageView)Utils.castView(localView, 2131690588, "field 'ivClose'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked();
      }
    });
    paramT.lvInfos = ((ListView)Utils.findRequiredViewAsType(paramView, 2131692451, "field 'lvInfos'", ListView.class));
    paramT.tvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'tvTitle'", TextView.class));
    paramT.tvDesc = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690073, "field 'tvDesc'", TextView.class));
  }
  
  public void unbind()
  {
    SignerCareerActivity localSignerCareerActivity = this.a;
    if (localSignerCareerActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localSignerCareerActivity.ivClose = null;
    localSignerCareerActivity.lvInfos = null;
    localSignerCareerActivity.tvTitle = null;
    localSignerCareerActivity.tvDesc = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/SignerCareerActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */