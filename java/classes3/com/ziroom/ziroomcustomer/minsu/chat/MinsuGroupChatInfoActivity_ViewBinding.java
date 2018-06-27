package com.ziroom.ziroomcustomer.minsu.chat;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;

public class MinsuGroupChatInfoActivity_ViewBinding<T extends MinsuGroupChatInfoActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  
  public MinsuGroupChatInfoActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    paramT.commonTitle = ((CommonTitle)Utils.findRequiredViewAsType(paramView, 2131691272, "field 'commonTitle'", CommonTitle.class));
    paramT.rv_member = ((RecyclerView)Utils.findRequiredViewAsType(paramView, 2131691300, "field 'rv_member'", RecyclerView.class));
    View localView = Utils.findRequiredView(paramView, 2131691301, "field 'll_more_member' and method 'onClick'");
    paramT.ll_more_member = ((LinearLayout)Utils.castView(localView, 2131691301, "field 'll_more_member'", LinearLayout.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.tv_group_name = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690741, "field 'tv_group_name'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131691303, "field 'll_my_nickname' and method 'onClick'");
    paramT.ll_my_nickname = ((LinearLayout)Utils.castView(localView, 2131691303, "field 'll_my_nickname'", LinearLayout.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.tv_nickname = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691304, "field 'tv_nickname'", TextView.class));
    localView = Utils.findRequiredView(paramView, 2131691305, "field 'rl_my_portrait' and method 'onClick'");
    paramT.rl_my_portrait = ((RelativeLayout)Utils.castView(localView, 2131691305, "field 'rl_my_portrait'", RelativeLayout.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.sdv_portrait = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131691306, "field 'sdv_portrait'", SimpleDraweeView.class));
    localView = Utils.findRequiredView(paramView, 2131691307, "field 'tv_exit_group_chat' and method 'onClick'");
    paramT.tv_exit_group_chat = ((TextView)Utils.castView(localView, 2131691307, "field 'tv_exit_group_chat'", TextView.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.cb_notication = ((CheckBox)Utils.findRequiredViewAsType(paramView, 2131691302, "field 'cb_notication'", CheckBox.class));
  }
  
  public void unbind()
  {
    MinsuGroupChatInfoActivity localMinsuGroupChatInfoActivity = this.a;
    if (localMinsuGroupChatInfoActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMinsuGroupChatInfoActivity.commonTitle = null;
    localMinsuGroupChatInfoActivity.rv_member = null;
    localMinsuGroupChatInfoActivity.ll_more_member = null;
    localMinsuGroupChatInfoActivity.tv_group_name = null;
    localMinsuGroupChatInfoActivity.ll_my_nickname = null;
    localMinsuGroupChatInfoActivity.tv_nickname = null;
    localMinsuGroupChatInfoActivity.rl_my_portrait = null;
    localMinsuGroupChatInfoActivity.sdv_portrait = null;
    localMinsuGroupChatInfoActivity.tv_exit_group_chat = null;
    localMinsuGroupChatInfoActivity.cb_notication = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.e.setOnClickListener(null);
    this.e = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/MinsuGroupChatInfoActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */