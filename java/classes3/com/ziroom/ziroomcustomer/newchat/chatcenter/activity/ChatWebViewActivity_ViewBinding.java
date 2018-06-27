package com.ziroom.ziroomcustomer.newchat.chatcenter.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class ChatWebViewActivity_ViewBinding<T extends ChatWebViewActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  
  public ChatWebViewActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131689492, "field 'ivBack' and method 'onViewClicked'");
    paramT.ivBack = ((ImageView)Utils.castView(localView, 2131689492, "field 'ivBack'", ImageView.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690144, "field 'myinfoChat' and method 'onViewClicked'");
    paramT.myinfoChat = ((ImageView)Utils.castView(localView, 2131690144, "field 'myinfoChat'", ImageView.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.myinfoChatRedPoint = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690145, "field 'myinfoChatRedPoint'", ImageView.class));
    paramT.myinfoChatRedPointNum = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690146, "field 'myinfoChatRedPointNum'", TextView.class));
    paramT.rlTitle = ((RelativeLayout)Utils.findRequiredViewAsType(paramView, 2131689808, "field 'rlTitle'", RelativeLayout.class));
    paramT.myinfoTitleIcon = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690189, "field 'myinfoTitleIcon'", ImageView.class));
  }
  
  public void unbind()
  {
    ChatWebViewActivity localChatWebViewActivity = this.a;
    if (localChatWebViewActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localChatWebViewActivity.ivBack = null;
    localChatWebViewActivity.myinfoChat = null;
    localChatWebViewActivity.myinfoChatRedPoint = null;
    localChatWebViewActivity.myinfoChatRedPointNum = null;
    localChatWebViewActivity.rlTitle = null;
    localChatWebViewActivity.myinfoTitleIcon = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/chatcenter/activity/ChatWebViewActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */