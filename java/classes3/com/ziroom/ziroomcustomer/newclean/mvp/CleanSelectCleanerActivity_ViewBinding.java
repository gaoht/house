package com.ziroom.ziroomcustomer.newclean.mvp;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.newrepair.utils.ListViewForScrollView;

public class CleanSelectCleanerActivity_ViewBinding<T extends CleanSelectCleanerActivity>
  implements Unbinder
{
  protected T a;
  
  public CleanSelectCleanerActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mLlHistory = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690323, "field 'mLlHistory'", LinearLayout.class));
    paramT.mLsvHistory = ((ListViewForScrollView)Utils.findRequiredViewAsType(paramView, 2131690324, "field 'mLsvHistory'", ListViewForScrollView.class));
    paramT.mLlMore = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690325, "field 'mLlMore'", LinearLayout.class));
    paramT.mTvMore = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690326, "field 'mTvMore'", TextView.class));
    paramT.mIvPull = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690327, "field 'mIvPull'", ImageView.class));
    paramT.mLlCommend = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690328, "field 'mLlCommend'", LinearLayout.class));
    paramT.mLsvCommend = ((ListViewForScrollView)Utils.findRequiredViewAsType(paramView, 2131690329, "field 'mLsvCommend'", ListViewForScrollView.class));
  }
  
  public void unbind()
  {
    CleanSelectCleanerActivity localCleanSelectCleanerActivity = this.a;
    if (localCleanSelectCleanerActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localCleanSelectCleanerActivity.mLlHistory = null;
    localCleanSelectCleanerActivity.mLsvHistory = null;
    localCleanSelectCleanerActivity.mLlMore = null;
    localCleanSelectCleanerActivity.mTvMore = null;
    localCleanSelectCleanerActivity.mIvPull = null;
    localCleanSelectCleanerActivity.mLlCommend = null;
    localCleanSelectCleanerActivity.mLsvCommend = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/mvp/CleanSelectCleanerActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */