package com.ziroom.ziroomcustomer.newServiceList.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class JsVideoWebViewActivity_ViewBinding<T extends JsVideoWebViewActivity>
  implements Unbinder
{
  protected T a;
  
  public JsVideoWebViewActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.mIvBack = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131689781, "field 'mIvBack'", ImageView.class));
    paramT.mTvTitle = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689782, "field 'mTvTitle'", TextView.class));
  }
  
  public void unbind()
  {
    JsVideoWebViewActivity localJsVideoWebViewActivity = this.a;
    if (localJsVideoWebViewActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localJsVideoWebViewActivity.mIvBack = null;
    localJsVideoWebViewActivity.mTvTitle = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/activity/JsVideoWebViewActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */