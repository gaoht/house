package com.ziroom.ziroomcustomer.minsu.chat;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;

public class MinsuGroupChatMembersActivity_ViewBinding<T extends MinsuGroupChatMembersActivity>
  implements Unbinder
{
  protected T a;
  
  public MinsuGroupChatMembersActivity_ViewBinding(T paramT, View paramView)
  {
    this.a = paramT;
    paramT.commonTitle = ((CommonTitle)Utils.findRequiredViewAsType(paramView, 2131691272, "field 'commonTitle'", CommonTitle.class));
    paramT.swipe_target = ((RecyclerView)Utils.findRequiredViewAsType(paramView, 2131689522, "field 'swipe_target'", RecyclerView.class));
    paramT.swipeToLoadLayout = ((SwipeToLoadLayout)Utils.findRequiredViewAsType(paramView, 2131691285, "field 'swipeToLoadLayout'", SwipeToLoadLayout.class));
  }
  
  public void unbind()
  {
    MinsuGroupChatMembersActivity localMinsuGroupChatMembersActivity = this.a;
    if (localMinsuGroupChatMembersActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMinsuGroupChatMembersActivity.commonTitle = null;
    localMinsuGroupChatMembersActivity.swipe_target = null;
    localMinsuGroupChatMembersActivity.swipeToLoadLayout = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/MinsuGroupChatMembersActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */