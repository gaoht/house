package com.hyphenate.chat.adapter;

import com.hyphenate.chat.adapter.message.EMAMessage;
import java.util.List;

public abstract class EMAChatManagerListener
  extends EMABase
  implements EMAChatManagerListenerInterface
{
  public EMAChatManagerListener()
  {
    nativeInit();
  }
  
  public void finalize()
    throws Throwable
  {
    nativeFinalize();
    super.finalize();
  }
  
  native void nativeFinalize();
  
  native void nativeInit();
  
  public void onMessageAttachmentsStatusChanged(EMAMessage paramEMAMessage, EMAError paramEMAError) {}
  
  public void onMessageStatusChanged(EMAMessage paramEMAMessage, EMAError paramEMAError) {}
  
  public void onReceiveCmdMessages(List<EMAMessage> paramList) {}
  
  public void onReceiveHasDeliveredAcks(List<EMAMessage> paramList) {}
  
  public void onReceiveHasReadAcks(List<EMAMessage> paramList) {}
  
  public void onReceiveMessages(List<EMAMessage> paramList) {}
  
  public void onReceiveRecallMessages(List<EMAMessage> paramList) {}
  
  public void onUpdateConversationList(List<EMAConversation> paramList) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/EMAChatManagerListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */