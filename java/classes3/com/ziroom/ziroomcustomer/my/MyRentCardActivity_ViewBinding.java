package com.ziroom.ziroomcustomer.my;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;

public class MyRentCardActivity_ViewBinding<T extends MyRentCardActivity>
  implements Unbinder
{
  protected T a;
  
  public MyRentCardActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mBztb = ((BasicZiroomToolBar)Utils.findRequiredViewAsType(paramView, 2131689787, "field 'mBztb'", BasicZiroomToolBar.class));
    paramT.mLv = ((ListView)Utils.findRequiredViewAsType(paramView, 2131689817, "field 'mLv'", ListView.class));
    paramT.mFlEmpty = ((FrameLayout)Utils.findRequiredViewAsType(paramView, 2131691788, "field 'mFlEmpty'", FrameLayout.class));
    paramT.mTvEmpty = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691829, "field 'mTvEmpty'", TextView.class));
  }
  
  public void unbind()
  {
    MyRentCardActivity localMyRentCardActivity = this.a;
    if (localMyRentCardActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMyRentCardActivity.mBztb = null;
    localMyRentCardActivity.mLv = null;
    localMyRentCardActivity.mFlEmpty = null;
    localMyRentCardActivity.mTvEmpty = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/MyRentCardActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */