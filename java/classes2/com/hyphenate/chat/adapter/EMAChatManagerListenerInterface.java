package com.hyphenate.chat.adapter;

import com.hyphenate.chat.adapter.message.EMAMessage;
import java.util.List;

public abstract interface EMAChatManagerListenerInterface
{
  public abstract void onMessageAttachmentsStatusChanged(EMAMessage paramEMAMessage, EMAError paramEMAError);
  
  public abstract void onMessageStatusChanged(EMAMessage paramEMAMessage, EMAError paramEMAError);
  
  public abstract void onReceiveCmdMessages(List<EMAMessage> paramList);
  
  public abstract void onReceiveHasDeliveredAcks(List<EMAMessage> paramList);
  
  public abstract void onReceiveHasReadAcks(List<EMAMessage> paramList);
  
  public abstract void onReceiveMessages(List<EMAMessage> paramList);
  
  public abstract void onReceiveRecallMessages(List<EMAMessage> paramList);
  
  public abstract void onUpdateConversationList(List<EMAConversation> paramList);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/EMAChatManagerListenerInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */