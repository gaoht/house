package com.ziroom.ziroomcustomer.adapter;

import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.newServiceList.view.RatingStar;
import com.ziroom.ziroomcustomer.signed.EvaluateLineBreakView;

public class MyEvaluateAdapter$viewHolder_ViewBinding<T extends MyEvaluateAdapter.viewHolder>
  implements Unbinder
{
  protected T a;
  
  public MyEvaluateAdapter$viewHolder_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.siv_icon = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131691839, "field 'siv_icon'", SimpleDraweeView.class));
    paramT.siv_room_icon = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131694027, "field 'siv_room_icon'", SimpleDraweeView.class));
    paramT.tv_title_top = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694028, "field 'tv_title_top'", TextView.class));
    paramT.tv_content_top = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694029, "field 'tv_content_top'", TextView.class));
    paramT.tv_title = ((TextView)Utils.findRequiredViewAsType(paramView, 2131689541, "field 'tv_title'", TextView.class));
    paramT.rs_star = ((RatingStar)Utils.findRequiredViewAsType(paramView, 2131690595, "field 'rs_star'", RatingStar.class));
    paramT.pay_terms_tags = ((EvaluateLineBreakView)Utils.findRequiredViewAsType(paramView, 2131694030, "field 'pay_terms_tags'", EvaluateLineBreakView.class));
    paramT.fl = ((FrameLayout)Utils.findRequiredViewAsType(paramView, 2131690607, "field 'fl'", FrameLayout.class));
    paramT.et = ((EditText)Utils.findRequiredViewAsType(paramView, 2131691275, "field 'et'", EditText.class));
  }
  
  public void unbind()
  {
    MyEvaluateAdapter.viewHolder localviewHolder = this.a;
    if (localviewHolder == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localviewHolder.siv_icon = null;
    localviewHolder.siv_room_icon = null;
    localviewHolder.tv_title_top = null;
    localviewHolder.tv_content_top = null;
    localviewHolder.tv_title = null;
    localviewHolder.rs_star = null;
    localviewHolder.pay_terms_tags = null;
    localviewHolder.fl = null;
    localviewHolder.et = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/adapter/MyEvaluateAdapter$viewHolder_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */