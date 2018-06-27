package com.ziroom.ziroomcustomer.newclean.mvp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ziroom.commonlibrary.widget.convenientbanner.ConvenientBanner;

public class CleanPaySuccessActivity_ViewBinding<T extends CleanPaySuccessActivity>
  implements Unbinder
{
  protected T a;
  
  public CleanPaySuccessActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mTvCleanOrder = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690320, "field 'mTvCleanOrder'", TextView.class));
    paramT.mIvBack = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131689492, "field 'mIvBack'", ImageView.class));
    paramT.mCbBanner = ((ConvenientBanner)Utils.findRequiredViewAsType(paramView, 2131690321, "field 'mCbBanner'", ConvenientBanner.class));
  }
  
  public void unbind()
  {
    CleanPaySuccessActivity localCleanPaySuccessActivity = this.a;
    if (localCleanPaySuccessActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localCleanPaySuccessActivity.mTvCleanOrder = null;
    localCleanPaySuccessActivity.mIvBack = null;
    localCleanPaySuccessActivity.mCbBanner = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/mvp/CleanPaySuccessActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */