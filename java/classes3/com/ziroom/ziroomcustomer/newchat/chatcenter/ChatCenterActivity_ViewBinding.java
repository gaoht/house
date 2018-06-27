package com.ziroom.ziroomcustomer.newchat.chatcenter;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;

public class ChatCenterActivity_ViewBinding<T extends ChatCenterActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  private View g;
  private View h;
  private View i;
  
  public ChatCenterActivity_ViewBinding(final T paramT, View paramView)
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
    localView = Utils.findRequiredView(paramView, 2131690148, "field 'tvToMumu' and method 'onViewClicked'");
    paramT.tvToMumu = ((TextView)Utils.castView(localView, 2131690148, "field 'tvToMumu'", TextView.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.ivChartIcon = ((SimpleDraweeView)Utils.findRequiredViewAsType(paramView, 2131690152, "field 'ivChartIcon'", SimpleDraweeView.class));
    paramT.tvChartContent = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690153, "field 'tvChartContent'", TextView.class));
    paramT.tvServiceTime1 = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690157, "field 'tvServiceTime1'", TextView.class));
    paramT.tvServiceContent1 = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690158, "field 'tvServiceContent1'", TextView.class));
    paramT.ivArraw1 = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690159, "field 'ivArraw1'", ImageView.class));
    localView = Utils.findRequiredView(paramView, 2131690156, "field 'llServiceMessage1' and method 'onViewClicked'");
    paramT.llServiceMessage1 = ((LinearLayout)Utils.castView(localView, 2131690156, "field 'llServiceMessage1'", LinearLayout.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.tvServiceTime2 = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690161, "field 'tvServiceTime2'", TextView.class));
    paramT.tvServiceContent2 = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690162, "field 'tvServiceContent2'", TextView.class));
    paramT.ivArraw2 = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131690163, "field 'ivArraw2'", ImageView.class));
    localView = Utils.findRequiredView(paramView, 2131690160, "field 'llServiceMessage2' and method 'onViewClicked'");
    paramT.llServiceMessage2 = ((LinearLayout)Utils.castView(localView, 2131690160, "field 'llServiceMessage2'", LinearLayout.class));
    this.f = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131690164, "field 'tvExchange' and method 'onViewClicked'");
    paramT.tvExchange = ((TextView)Utils.castView(localView, 2131690164, "field 'tvExchange'", TextView.class));
    this.g = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.llQuestion = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131689813, "field 'llQuestion'", LinearLayout.class));
    paramT.view = Utils.findRequiredView(paramView, 2131690147, "field 'view'");
    paramT.svContent = ((ObservableScrollView)Utils.findRequiredViewAsType(paramView, 2131690150, "field 'svContent'", ObservableScrollView.class));
    paramT.llServiceForm = ((LinearLayout)Utils.findRequiredViewAsType(paramView, 2131690155, "field 'llServiceForm'", LinearLayout.class));
    localView = Utils.findRequiredView(paramView, 2131690151, "field 'rlMumu' and method 'onViewClicked'");
    paramT.rlMumu = ((RelativeLayout)Utils.castView(localView, 2131690151, "field 'rlMumu'", RelativeLayout.class));
    this.h = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131689744, "field 'img' and method 'onViewClicked'");
    paramT.img = ((ImageView)Utils.castView(localView, 2131689744, "field 'img'", ImageView.class));
    this.i = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onViewClicked(paramAnonymousView);
      }
    });
    paramT.tvNoServiceTable = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690154, "field 'tvNoServiceTable'", TextView.class));
    paramT.tvNoServiceQuestion = ((TextView)Utils.findRequiredViewAsType(paramView, 2131690165, "field 'tvNoServiceQuestion'", TextView.class));
  }
  
  public void unbind()
  {
    ChatCenterActivity localChatCenterActivity = this.a;
    if (localChatCenterActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localChatCenterActivity.ivBack = null;
    localChatCenterActivity.myinfoChat = null;
    localChatCenterActivity.myinfoChatRedPoint = null;
    localChatCenterActivity.myinfoChatRedPointNum = null;
    localChatCenterActivity.tvToMumu = null;
    localChatCenterActivity.ivChartIcon = null;
    localChatCenterActivity.tvChartContent = null;
    localChatCenterActivity.tvServiceTime1 = null;
    localChatCenterActivity.tvServiceContent1 = null;
    localChatCenterActivity.ivArraw1 = null;
    localChatCenterActivity.llServiceMessage1 = null;
    localChatCenterActivity.tvServiceTime2 = null;
    localChatCenterActivity.tvServiceContent2 = null;
    localChatCenterActivity.ivArraw2 = null;
    localChatCenterActivity.llServiceMessage2 = null;
    localChatCenterActivity.tvExchange = null;
    localChatCenterActivity.llQuestion = null;
    localChatCenterActivity.view = null;
    localChatCenterActivity.svContent = null;
    localChatCenterActivity.llServiceForm = null;
    localChatCenterActivity.rlMumu = null;
    localChatCenterActivity.img = null;
    localChatCenterActivity.tvNoServiceTable = null;
    localChatCenterActivity.tvNoServiceQuestion = null;
    this.b.setOnClickListener(null);
    this.b = null;
    this.c.setOnClickListener(null);
    this.c = null;
    this.d.setOnClickListener(null);
    this.d = null;
    this.e.setOnClickListener(null);
    this.e = null;
    this.f.setOnClickListener(null);
    this.f = null;
    this.g.setOnClickListener(null);
    this.g = null;
    this.h.setOnClickListener(null);
    this.h = null;
    this.i.setOnClickListener(null);
    this.i = null;
    this.a = null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/chatcenter/ChatCenterActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */