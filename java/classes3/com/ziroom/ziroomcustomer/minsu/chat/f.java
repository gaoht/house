package com.ziroom.ziroomcustomer.minsu.chat;

import android.widget.BaseAdapter;
import com.hyphenate.chat.EMMessage;

public abstract interface f
{
  public abstract MinsuChatRow getCustomChatRow(EMMessage paramEMMessage, int paramInt, BaseAdapter paramBaseAdapter);
  
  public abstract int getCustomChatRowType(EMMessage paramEMMessage);
  
  public abstract int getCustomChatRowTypeCount();
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */