package com.ziroom.ziroomcustomer.my.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;

public class MyRentEvaluateAdapter$viewHolder_ViewBinding<T extends MyRentEvaluateAdapter.viewHolder>
  implements Unbinder
{
  protected T a;
  
  public MyRentEvaluateAdapter$viewHolder_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.tv_title = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'tv_title'", TextView.class));
    paramT.ll_content = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131691838, "field 'll_content'", LinearLayout.class));
    paramT.siv_icon = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131691839, "field 'siv_icon'", SimpleDraweeView.class));
    paramT.tv_name = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690049, "field 'tv_name'", TextView.class));
    paramT.tv_btn = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691840, "field 'tv_btn'", TextView.class));
  }
  
  public void unbind()
  {
    MyRentEvaluateAdapter.viewHolder localviewHolder = this.a;
    if (localviewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localviewHolder.tv_title = null;
    localviewHolder.ll_content = null;
    localviewHolder.siv_icon = null;
    localviewHolder.tv_name = null;
    localviewHolder.tv_btn = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/adapter/MyRentEvaluateAdapter$viewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */