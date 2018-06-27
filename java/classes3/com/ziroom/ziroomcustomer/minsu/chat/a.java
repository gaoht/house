package com.ziroom.ziroomcustomer.minsu.chat;

import android.view.View;
import com.hyphenate.chat.EMMessage;

public abstract interface a
{
  public abstract void onAvatarClick(String paramString);
  
  public abstract void onEnterToChatDetails();
  
  public abstract boolean onExtendMenuItemClick(int paramInt, View paramView);
  
  public abstract boolean onMessageBubbleClick(EMMessage paramEMMessage);
  
  public abstract void onMessageBubbleLongClick(EMMessage paramEMMessage);
  
  public abstract f onSetCustomChatRowProvider();
  
  public abstract void onSetMessageAttributes(EMMessage paramEMMessage);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */