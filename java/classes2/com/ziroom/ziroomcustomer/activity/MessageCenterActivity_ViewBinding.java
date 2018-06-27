package com.ziroom.ziroomcustomer.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;

public class MessageCenterActivity_ViewBinding<T extends MessageCenterActivity>
  implements Unbinder
{
  protected T a;
  private View b;
  private View c;
  private View d;
  private View e;
  
  public MessageCenterActivity_ViewBinding(final T paramT, View paramView)
  {
    this.a = paramT;
    View localView = Utils.findRequiredView(paramView, 2131691167, "field 'rlChatLine' and method 'onClick'");
    paramT.rlChatLine = ((RelativeLayout)Utils.castView(localView, 2131691167, "field 'rlChatLine'", RelativeLayout.class));
    this.b = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691171, "field 'rlChatMisu' and method 'onClick'");
    paramT.rlChatMisu = ((RelativeLayout)Utils.castView(localView, 2131691171, "field 'rlChatMisu'", RelativeLayout.class));
    this.c = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    localView = Utils.findRequiredView(paramView, 2131691176, "field 'rlSysMess' and method 'onClick'");
    paramT.rlSysMess = ((RelativeLayout)Utils.castView(localView, 2131691176, "field 'rlSysMess'", RelativeLayout.class));
    this.d = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.ivSysMessNewSign = ((ImageView)Utils.findRequiredViewAsType(paramView, 2131691181, "field 'ivSysMessNewSign'", ImageView.class));
    paramT.tvChatZiru = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691168, "field 'tvChatZiru'", TextView.class));
    paramT.tvChatMinsu = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691173, "field 'tvChatMinsu'", TextView.class));
    paramT.tvChatSysMess = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691180, "field 'tvChatSysMess'", TextView.class));
    paramT.ziruServiceRedPointNum = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691169, "field 'ziruServiceRedPointNum'", TextView.class));
    paramT.minsuServiceRedPointNum = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691174, "field 'minsuServiceRedPointNum'", TextView.class));
    paramT.mBztb = ((BasicZiroomToolBar)Utils.findRequiredViewAsType(paramView, 2131689787, "field 'mBztb'", BasicZiroomToolBar.class));
    localView = Utils.findRequiredView(paramView, 2131691182, "field 'rl_mess_center_meeta_mess' and method 'onClick'");
    paramT.rl_mess_center_meeta_mess = ((RelativeLayout)Utils.castView(localView, 2131691182, "field 'rl_mess_center_meeta_mess'", RelativeLayout.class));
    this.e = localView;
    localView.setOnClickListener(new DebouncingOnClickListener()
    {
      public void doClick(View paramAnonymousView)
      {
        paramT.onClick(paramAnonymousView);
      }
    });
    paramT.tv_chat_meeta_mess = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691186, "field 'tv_chat_meeta_mess'", TextView.class));
    paramT.tv_meeta_mess_new_sign = ((TextView)Utils.findRequiredViewAsType(paramView, 2131691187, "field 'tv_meeta_mess_new_sign'", TextView.class));
  }
  
  public void unbind()
  {
    MessageCenterActivity localMessageCenterActivity = this.a;
    if (localMessageCenterActivity == null) {
      throw new IllegalStateException("Bindings already cleared.");
    }
    localMessageCenterActivity.rlChatLine = null;
    localMessageCenterActivity.rlChatMisu = null;
    localMessageCenterActivity.rlSysMess = null;
    localMessageCenterActivity.ivSysMessNewSign = null;
    localMessageCenterActivity.tvChatZiru = null;
    localMessageCenterActivity.tvChatMinsu = null;
    localMessageCenterActivity.tvChatSysMess = null;
    localMessageCenterActivity.ziruServiceRedPointNum = null;
    localMessageCenterActivity.minsuServiceRedPointNum = null;
    localMessageCenterActivity.mBztb = null;
    localMessageCenterActivity.rl_mess_center_meeta_mess = null;
    localMessageCenterActivity.tv_chat_meeta_mess = null;
    localMessageCenterActivity.tv_meeta_mess_new_sign = null;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/activity/MessageCenterActivity_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */