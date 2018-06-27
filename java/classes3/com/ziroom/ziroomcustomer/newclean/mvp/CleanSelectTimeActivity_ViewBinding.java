package com.ziroom.ziroomcustomer.newclean.mvp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ziroom.ziroomcustomer.newclean.cardpay.MyGridView;
import com.ziroom.ziroomcustomer.widget.HorizontalListView;

public class CleanSelectTimeActivity_ViewBinding<T extends CleanSelectTimeActivity>
  implements Unbinder
{
  protected T a;
  
  public CleanSelectTimeActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mIvBack = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131689492, "field 'mIvBack'", ImageView.class));
    paramT.mHlData = ((HorizontalListView)Utils.findRequiredViewAsType(paramView, 2131689972, "field 'mHlData'", HorizontalListView.class));
    paramT.mGvHome = ((MyGridView)Utils.findRequiredViewAsType(paramView, 2131689973, "field 'mGvHome'", MyGridView.class));
    paramT.mTvCommit = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689956, "field 'mTvCommit'", TextView.class));
  }
  
  public void unbind()
  {
    CleanSelectTimeActivity localCleanSelectTimeActivity = this.a;
    if (localCleanSelectTimeActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localCleanSelectTimeActivity.mIvBack = null;
    localCleanSelectTimeActivity.mHlData = null;
    localCleanSelectTimeActivity.mGvHome = null;
    localCleanSelectTimeActivity.mTvCommit = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/mvp/CleanSelectTimeActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */