package com.hyphenate;

import com.hyphenate.chat.EMMessage;
import java.util.List;

public abstract interface EMMessageListener
{
  public abstract void onCmdMessageReceived(List<EMMessage> paramList);
  
  public abstract void onMessageChanged(EMMessage paramEMMessage, Object paramObject);
  
  public abstract void onMessageDelivered(List<EMMessage> paramList);
  
  public abstract void onMessageRead(List<EMMessage> paramList);
  
  public abstract void onMessageRecalled(List<EMMessage> paramList);
  
  public abstract void onMessageReceived(List<EMMessage> paramList);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/hyphenate/EMMessageListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */