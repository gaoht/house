package com.ziroom.ziroomcustomer.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class FiveYearWebViewActivity_ViewBinding<T extends FiveYearWebViewActivity>
  implements Unbinder
{
  protected T a;
  
  public FiveYearWebViewActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mIvBack = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131689781, "field 'mIvBack'", ImageView.class));
    paramT.mTvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689782, "field 'mTvTitle'", TextView.class));
  }
  
  public void unbind()
  {
    FiveYearWebViewActivity localFiveYearWebViewActivity = this.a;
    if (localFiveYearWebViewActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localFiveYearWebViewActivity.mIvBack = null;
    localFiveYearWebViewActivity.mTvTitle = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/activity/FiveYearWebViewActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */