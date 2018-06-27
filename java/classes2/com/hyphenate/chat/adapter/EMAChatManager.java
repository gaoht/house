package com.hyphenate.chat.adapter;

import com.hyphenate.chat.EMCursorResult;
import com.hyphenate.chat.adapter.message.EMAMessage;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EMAChatManager
  extends EMABase
{
  private Set<EMAChatManagerListener> listeners = new HashSet();
  
  protected EMAChatManager() {}
  
  protected EMAChatManager(EMAChatManager paramEMAChatManager)
  {
    nativeInit(paramEMAChatManager);
  }
  
  public void addListener(EMAChatManagerListener paramEMAChatManagerListener)
  {
    this.listeners.add(paramEMAChatManagerListener);
    nativeAddListener(paramEMAChatManagerListener);
  }
  
  public void clearListeners()
  {
    this.listeners.clear();
    nativeClearListeners();
  }
  
  public EMAConversation conversationWithType(String paramString, EMAConversation.EMAConversationType paramEMAConversationType, boolean paramBoolean)
  {
    return nativeConversationWithType(paramString, paramEMAConversationType.ordinal(), paramBoolean);
  }
  
  public void downloadMessageAttachments(EMAMessage paramEMAMessage)
  {
    nativeDownloadMessageAttachments(paramEMAMessage);
  }
  
  public void downloadMessageThumbnail(EMAMessage paramEMAMessage)
  {
    nativeDownloadMessageThumbnail(paramEMAMessage);
  }
  
  public EMCursorResult<EMAMessage> fetchHistoryMessages(String paramString1, int paramInt1, int paramInt2, String paramString2, EMAError paramEMAError)
  {
    return nativeFetchHistoryMessages(paramString1, paramInt1, paramInt2, paramString2, paramEMAError);
  }
  
  public List<EMAConversation> getConversations()
  {
    return nativeGetConversations();
  }
  
  public EMAEncryptProviderInterface getEncryptProvider(boolean paramBoolean)
  {
    return nativeGetEncryptProvider(paramBoolean);
  }
  
  public EMAMessage getMessage(String paramString)
  {
    return nativeGetMessage(paramString);
  }
  
  public List<EMAConversation> loadAllConversationsFromDB()
  {
    return nativeLoadAllConversationsFromDB();
  }
  
  native void nativeAddListener(EMAChatManagerListener paramEMAChatManagerListener);
  
  native void nativeClearListeners();
  
  native EMAConversation nativeConversationWithType(String paramString, int paramInt, boolean paramBoolean);
  
  native void nativeDownloadMessageAttachments(EMAMessage paramEMAMessage);
  
  native void nativeDownloadMessageThumbnail(EMAMessage paramEMAMessage);
  
  native EMCursorResult<EMAMessage> nativeFetchHistoryMessages(String paramString1, int paramInt1, int paramInt2, String paramString2, EMAError paramEMAError);
  
  native List<EMAConversation> nativeGetConversations();
  
  native EMAEncryptProviderInterface nativeGetEncryptProvider(boolean paramBoolean);
  
  native EMAMessage nativeGetMessage(String paramString);
  
  native void nativeInit(EMAChatManager paramEMAChatManager);
  
  native List<EMAConversation> nativeLoadAllConversationsFromDB();
  
  native void nativeRecallMessage(EMAMessage paramEMAMessage, EMAError paramEMAError);
  
  native void nativeRemoveConversation(String paramString, boolean paramBoolean);
  
  native void nativeRemoveListener(EMAChatManagerListener paramEMAChatManagerListener);
  
  native void nativeResendMessage(EMAMessage paramEMAMessage);
  
  native void nativeSendMessage(EMAMessage paramEMAMessage);
  
  native void nativeSendReadAckForMessage(EMAMessage paramEMAMessage);
  
  native void nativeSetEncryptProvider(EMAEncryptProviderInterface paramEMAEncryptProviderInterface);
  
  native boolean nativeUpdateParticipant(String paramString1, String paramString2);
  
  native void nativeUploadLog();
  
  public void recallMessage(EMAMessage paramEMAMessage, EMAError paramEMAError)
  {
    nativeRecallMessage(paramEMAMessage, paramEMAError);
  }
  
  public void removeConversation(String paramString, boolean paramBoolean)
  {
    nativeRemoveConversation(paramString, paramBoolean);
  }
  
  public void removeListener(EMAChatManagerListener paramEMAChatManagerListener)
  {
    this.listeners.remove(paramEMAChatManagerListener);
    nativeRemoveListener(paramEMAChatManagerListener);
  }
  
  public void resendMessage(EMAMessage paramEMAMessage)
  {
    nativeResendMessage(paramEMAMessage);
  }
  
  public void sendMessage(EMAMessage paramEMAMessage)
  {
    nativeSendMessage(paramEMAMessage);
  }
  
  public void sendReadAckForMessage(EMAMessage paramEMAMessage)
  {
    nativeSendReadAckForMessage(paramEMAMessage);
  }
  
  public void setEncryptProvider(EMAEncryptProviderInterface paramEMAEncryptProviderInterface)
  {
    nativeSetEncryptProvider(paramEMAEncryptProviderInterface);
  }
  
  public boolean updateParticipant(String paramString1, String paramString2)
  {
    return nativeUpdateParticipant(paramString1, paramString2);
  }
  
  public void uploadLog()
  {
    nativeUploadLog();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/EMAChatManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */