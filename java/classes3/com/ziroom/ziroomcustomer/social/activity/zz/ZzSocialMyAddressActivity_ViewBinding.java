package com.ziroom.ziroomcustomer.social.activity.zz;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;

public class ZzSocialMyAddressActivity_ViewBinding<T extends ZzSocialMyAddressActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  
  public ZzSocialMyAddressActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131690078, "field 'btnBack' and method 'onViewClicked'");
    paramT.btnBack = ((ImageView)Utils.castView(localView, 2131690078, "field 'btnBack'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.rlTitle = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131689808, "field 'rlTitle'", RelativeLayout.class));
    paramT.tvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'tvTitle'", TextView.class));
    paramT.list = ((ListView)Utils.findRequiredViewAsType(paramView, 2131691217, "field 'list'", ListView.class));
    localView = Utils.findRequiredView(paramView, 2131690043, "field 'btn' and method 'onViewClicked'");
    paramT.btn = ((Button)Utils.castView(localView, 2131690043, "field 'btn'", Button.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.vLineBottom = Utils.findRequiredView(paramView, 2131691494, "field 'vLineBottom'");
    paramT.tvMessage = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689850, "field 'tvMessage'", TextView.class));
    paramT.svContent = ((ObservableScrollView)Utils.findRequiredViewAsType(paramView, 2131690150, "field 'svContent'", ObservableScrollView.class));
  }
  
  public void unbind()
  {
    ZzSocialMyAddressActivity localZzSocialMyAddressActivity = this.a;
    if (localZzSocialMyAddressActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localZzSocialMyAddressActivity.btnBack = null;
    localZzSocialMyAddressActivity.rlTitle = null;
    localZzSocialMyAddressActivity.tvTitle = null;
    localZzSocialMyAddressActivity.list = null;
    localZzSocialMyAddressActivity.btn = null;
    localZzSocialMyAddressActivity.vLineBottom = null;
    localZzSocialMyAddressActivity.tvMessage = null;
    localZzSocialMyAddressActivity.svContent = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/activity/zz/ZzSocialMyAddressActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */