package com.ziroom.ziroomcustomer.minsu.view;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class MinsuEvaItemView_ViewBinding<T extends MinsuEvaItemView>
  implements Unbinder
{
  protected T a;
  
  public MinsuEvaItemView_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.txtUserName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694592, "field 'txtUserName'", TextView.class));
    paramT.txtUserTime = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694593, "field 'txtUserTime'", TextView.class));
    paramT.tvContent = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690084, "field 'tvContent'", TextView.class));
    paramT.llScore = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690594, "field 'llScore'", LinearLayout.class));
    paramT.txtReplyName = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694595, "field 'txtReplyName'", TextView.class));
    paramT.txtReplyTime = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694596, "field 'txtReplyTime'", TextView.class));
    paramT.txtReplyContent = ((TextView)Utils.findRequiredViewAsType(paramView, 2131694597, "field 'txtReplyContent'", TextView.class));
    paramT.rlReply = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131694594, "field 'rlReply'", RelativeLayout.class));
  }
  
  public void unbind()
  {
    MinsuEvaItemView localMinsuEvaItemView = this.a;
    if (localMinsuEvaItemView == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMinsuEvaItemView.txtUserName = null;
    localMinsuEvaItemView.txtUserTime = null;
    localMinsuEvaItemView.tvContent = null;
    localMinsuEvaItemView.llScore = null;
    localMinsuEvaItemView.txtReplyName = null;
    localMinsuEvaItemView.txtReplyTime = null;
    localMinsuEvaItemView.txtReplyContent = null;
    localMinsuEvaItemView.rlReply = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/MinsuEvaItemView_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */