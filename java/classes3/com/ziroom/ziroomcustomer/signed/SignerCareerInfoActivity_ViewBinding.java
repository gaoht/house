package com.ziroom.ziroomcustomer.signed;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;

public class SignerCareerInfoActivity_ViewBinding<T extends SignerCareerInfoActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  
  public SignerCareerInfoActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mBztb = ((BasicZiroomToolBar)Utils.findRequiredViewAsType(paramView, 2131689787, "field 'mBztb'", BasicZiroomToolBar.class));
    paramT.ivLogo = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131689859, "field 'ivLogo'", SimpleDraweeView.class));
    View localView = Utils.findRequiredView(paramView, 2131692452, "field 'tvRelated' and method 'onViewClicked'");
    paramT.tvRelated = ((TextView)Utils.castView(localView, 2131692452, "field 'tvRelated'", TextView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.tvDesc = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690073, "field 'tvDesc'", TextView.class));
  }
  
  public void unbind()
  {
    SignerCareerInfoActivity localSignerCareerInfoActivity = this.a;
    if (localSignerCareerInfoActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localSignerCareerInfoActivity.mBztb = null;
    localSignerCareerInfoActivity.ivLogo = null;
    localSignerCareerInfoActivity.tvRelated = null;
    localSignerCareerInfoActivity.tvDesc = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/SignerCareerInfoActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */