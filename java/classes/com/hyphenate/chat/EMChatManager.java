package com.hyphenate.chat;

import android.util.Log;
import com.hyphenate.EMCallBack;
import com.hyphenate.EMConversationListener;
import com.hyphenate.EMMessageListener;
import com.hyphenate.EMValueCallBack;
import com.hyphenate.chat.adapter.EMAChatManager;
import com.hyphenate.chat.adapter.EMAChatManagerListener;
import com.hyphenate.chat.adapter.EMAConversation;
import com.hyphenate.chat.adapter.EMAConversation.EMAConversationType;
import com.hyphenate.chat.adapter.EMAError;
import com.hyphenate.chat.adapter.message.EMAMessage;
import com.hyphenate.chat.core.EMAdvanceDebugManager.Type;
import com.hyphenate.chat.core.EMChatConfigPrivate;
import com.hyphenate.cloud.EMHttpClient;
import com.hyphenate.exceptions.HyphenateException;
import com.hyphenate.util.EMLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class EMChatManager
{
  private static final String INTERNAL_ACTION_PREFIX = "em_";
  private static final String TAG = "EMChatManager";
  Map<String, EMConversation.MessageCache> caches = new Hashtable();
  EMAChatManagerListener chatManagerListenerImpl = new EMChatManager.1(this);
  private List<EMConversationListener> conversationListeners = Collections.synchronizedList(new ArrayList());
  EMAChatManager emaObject;
  EMClient mClient;
  private List<EMMessageListener> messageListeners = Collections.synchronizedList(new ArrayList());
  
  protected EMChatManager() {}
  
  protected EMChatManager(EMClient paramEMClient, EMAChatManager paramEMAChatManager)
  {
    this.mClient = paramEMClient;
    this.emaObject = paramEMAChatManager;
    this.emaObject.addListener(this.chatManagerListenerImpl);
  }
  
  private void handleError(EMAError paramEMAError)
    throws HyphenateException
  {
    if (paramEMAError.errCode() != 0) {
      throw new HyphenateException(paramEMAError);
    }
  }
  
  private boolean isAdvanceDebugMessage(String paramString)
  {
    if (paramString.startsWith("em_")) {
      try
      {
        EMAdvanceDebugManager.Type.valueOf(paramString);
        return true;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    return false;
  }
  
  private void setMessageSendCallback(EMMessage paramEMMessage, EMConversation paramEMConversation, String paramString1, String paramString2)
  {
    if (paramEMMessage == null) {
      return;
    }
    paramEMMessage.setInnerCallback(new EMChatManager.3(this, paramEMConversation, paramString1, paramEMMessage, paramString2));
  }
  
  public void ackMessageRead(String paramString1, String paramString2)
    throws HyphenateException
  {
    if (!EMClient.getInstance().getChatConfigPrivate().b().getRequireAck())
    {
      EMLog.d("EMChatManager", "chat option reqire ack set to false. skip send out ask msg read");
      return;
    }
    EMAMessage localEMAMessage = this.emaObject.getMessage(paramString2);
    if (localEMAMessage != null)
    {
      this.emaObject.sendReadAckForMessage(localEMAMessage);
      return;
    }
    localEMAMessage = EMAMessage.createReceiveMessage("", EMMessage.self(), null, EMMessage.ChatType.Chat.ordinal());
    localEMAMessage.setMsgId(paramString2);
    localEMAMessage.setFrom(paramString1);
    this.emaObject.sendReadAckForMessage(localEMAMessage);
  }
  
  public void addConversationListener(EMConversationListener paramEMConversationListener)
  {
    if (!this.conversationListeners.contains(paramEMConversationListener)) {
      this.conversationListeners.add(paramEMConversationListener);
    }
  }
  
  public void addMessageListener(EMMessageListener paramEMMessageListener)
  {
    if (paramEMMessageListener == null) {}
    while (this.messageListeners.contains(paramEMMessageListener)) {
      return;
    }
    this.messageListeners.add(paramEMMessageListener);
  }
  
  public void asyncFetchHistoryMessage(String paramString1, EMConversation.EMConversationType paramEMConversationType, int paramInt, String paramString2, EMValueCallBack<EMCursorResult<EMMessage>> paramEMValueCallBack)
  {
    EMClient.getInstance().execute(new EMChatManager.6(this, paramEMValueCallBack, paramString1, paramEMConversationType, paramInt, paramString2));
  }
  
  public void aysncRecallMessage(EMMessage paramEMMessage, EMCallBack paramEMCallBack)
  {
    EMClient.getInstance().execute(new EMChatManager.4(this, paramEMMessage, paramEMCallBack));
  }
  
  public boolean deleteConversation(String paramString, boolean paramBoolean)
  {
    EMConversation localEMConversation = getConversation(paramString);
    if (localEMConversation == null) {
      return false;
    }
    if (!paramBoolean) {
      localEMConversation.clear();
    }
    for (;;)
    {
      this.emaObject.removeConversation(paramString, paramBoolean);
      return true;
      localEMConversation.clearAllMessages();
    }
  }
  
  public void downloadAttachment(EMMessage paramEMMessage)
  {
    if (paramEMMessage == null) {
      return;
    }
    paramEMMessage.makeCallbackStrong();
    this.emaObject.downloadMessageAttachments((EMAMessage)paramEMMessage.emaObject);
  }
  
  @Deprecated
  public void downloadFile(String paramString1, String paramString2, Map<String, String> paramMap, EMCallBack paramEMCallBack)
  {
    EMHttpClient.getInstance().downloadFile(paramString1, paramString2, paramMap, new EMChatManager.5(this, paramEMCallBack));
  }
  
  public void downloadThumbnail(EMMessage paramEMMessage)
  {
    paramEMMessage.makeCallbackStrong();
    this.emaObject.downloadMessageThumbnail((EMAMessage)paramEMMessage.emaObject);
  }
  
  public EMCursorResult<EMMessage> fetchHistoryMessages(String paramString1, EMConversation.EMConversationType paramEMConversationType, int paramInt, String paramString2)
    throws HyphenateException
  {
    EMAError localEMAError = new EMAError();
    paramString1 = this.emaObject.fetchHistoryMessages(paramString1, paramEMConversationType.ordinal(), paramInt, paramString2, localEMAError);
    handleError(localEMAError);
    paramEMConversationType = new EMCursorResult();
    paramEMConversationType.setCursor(paramString1.getCursor());
    paramString2 = new ArrayList();
    paramString1 = ((List)paramString1.getData()).iterator();
    while (paramString1.hasNext()) {
      paramString2.add(new EMMessage((EMAMessage)paramString1.next()));
    }
    paramEMConversationType.setData(paramString2);
    return paramEMConversationType;
  }
  
  public Map<String, EMConversation> getAllConversations()
  {
    Object localObject = this.emaObject.getConversations();
    Hashtable localHashtable = new Hashtable();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      EMAConversation localEMAConversation = (EMAConversation)((Iterator)localObject).next();
      localHashtable.put(localEMAConversation.conversationId(), new EMConversation(localEMAConversation));
    }
    return localHashtable;
  }
  
  public EMConversation getConversation(String paramString)
  {
    Object localObject2 = this.emaObject.conversationWithType(paramString, EMAConversation.EMAConversationType.CHAT, false);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.emaObject.conversationWithType(paramString, EMAConversation.EMAConversationType.GROUPCHAT, false);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.emaObject.conversationWithType(paramString, EMAConversation.EMAConversationType.CHATROOM, false);
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.emaObject.conversationWithType(paramString, EMAConversation.EMAConversationType.DISCUSSIONGROUP, false);
    }
    if (localObject1 == null) {}
    for (paramString = this.emaObject.conversationWithType(paramString, EMAConversation.EMAConversationType.HELPDESK, false);; paramString = (String)localObject1)
    {
      if (paramString == null) {
        return null;
      }
      return new EMConversation(paramString);
    }
  }
  
  public EMConversation getConversation(String paramString, EMConversation.EMConversationType paramEMConversationType)
  {
    return getConversation(paramString, paramEMConversationType, false);
  }
  
  public EMConversation getConversation(String paramString, EMConversation.EMConversationType paramEMConversationType, boolean paramBoolean)
  {
    EMAConversation.EMAConversationType localEMAConversationType = EMAConversation.EMAConversationType.CHAT;
    if (paramEMConversationType == EMConversation.EMConversationType.Chat) {
      localEMAConversationType = EMAConversation.EMAConversationType.CHAT;
    }
    for (;;)
    {
      paramString = this.emaObject.conversationWithType(paramString, localEMAConversationType, paramBoolean);
      if (paramString != null) {
        break;
      }
      return null;
      if (paramEMConversationType == EMConversation.EMConversationType.GroupChat) {
        localEMAConversationType = EMAConversation.EMAConversationType.GROUPCHAT;
      } else if (paramEMConversationType == EMConversation.EMConversationType.ChatRoom) {
        localEMAConversationType = EMAConversation.EMAConversationType.CHATROOM;
      } else if (paramEMConversationType == EMConversation.EMConversationType.DiscussionGroup) {
        localEMAConversationType = EMAConversation.EMAConversationType.DISCUSSIONGROUP;
      } else if (paramEMConversationType == EMConversation.EMConversationType.HelpDesk) {
        localEMAConversationType = EMAConversation.EMAConversationType.HELPDESK;
      }
    }
    Log.d("EMChatManager", "convID:" + paramString.conversationId());
    return new EMConversation(paramString);
  }
  
  public List<EMConversation> getConversationsByType(EMConversation.EMConversationType paramEMConversationType)
  {
    Object localObject = this.emaObject.getConversations();
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      EMAConversation localEMAConversation = (EMAConversation)((Iterator)localObject).next();
      if (paramEMConversationType.ordinal() == localEMAConversation._getType().ordinal()) {
        localArrayList.add(new EMConversation(localEMAConversation));
      }
    }
    return localArrayList;
  }
  
  public EMMessage getMessage(String paramString)
  {
    synchronized (this.caches)
    {
      Iterator localIterator = this.caches.values().iterator();
      while (localIterator.hasNext())
      {
        EMMessage localEMMessage = ((EMConversation.MessageCache)localIterator.next()).getMessage(paramString);
        if (localEMMessage != null) {
          return localEMMessage;
        }
      }
      paramString = this.emaObject.getMessage(paramString);
      if (paramString == null) {
        return null;
      }
    }
    return new EMMessage(paramString);
  }
  
  public int getUnreadMessageCount()
  {
    Iterator localIterator = this.emaObject.getConversations().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      EMAConversation localEMAConversation = (EMAConversation)localIterator.next();
      if (localEMAConversation._getType() == EMAConversation.EMAConversationType.CHATROOM) {
        break label56;
      }
      i = localEMAConversation.unreadMessagesCount() + i;
    }
    label56:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  @Deprecated
  public int getUnreadMsgsCount()
  {
    return getUnreadMessageCount();
  }
  
  public void importMessages(List<EMMessage> paramList)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(((EMMessage)paramList.next()).emaObject);
      }
      EMClient.getInstance().getChatConfigPrivate().c(localArrayList);
    }
    finally {}
  }
  
  public void loadAllConversations()
  {
    this.emaObject.loadAllConversationsFromDB();
  }
  
  void loadAllConversationsFromDB()
  {
    try
    {
      this.emaObject.loadAllConversationsFromDB();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void markAllConversationsAsRead()
  {
    Iterator localIterator = this.emaObject.loadAllConversationsFromDB().iterator();
    while (localIterator.hasNext()) {
      ((EMAConversation)localIterator.next()).markAllMessagesAsRead(true);
    }
  }
  
  void onLogout()
  {
    this.caches.clear();
  }
  
  public void recallMessage(EMMessage paramEMMessage)
    throws HyphenateException
  {
    EMAError localEMAError = new EMAError();
    this.emaObject.recallMessage((EMAMessage)paramEMMessage.emaObject, localEMAError);
    handleError(localEMAError);
    getConversation(paramEMMessage.getTo()).getCache().removeMessage(paramEMMessage.getMsgId());
  }
  
  public void removeConversationListener(EMConversationListener paramEMConversationListener)
  {
    if (paramEMConversationListener == null) {
      return;
    }
    this.conversationListeners.remove(paramEMConversationListener);
  }
  
  public void removeMessageListener(EMMessageListener paramEMMessageListener)
  {
    if (paramEMMessageListener == null) {
      return;
    }
    this.messageListeners.remove(paramEMMessageListener);
  }
  
  public void saveMessage(EMMessage paramEMMessage)
  {
    Object localObject = paramEMMessage.getChatType();
    EMConversation.EMConversationType localEMConversationType = EMConversation.EMConversationType.Chat;
    switch (EMChatManager.7.$SwitchMap$com$hyphenate$chat$EMMessage$ChatType[localObject.ordinal()])
    {
    }
    for (;;)
    {
      String str = paramEMMessage.getTo();
      localObject = str;
      if (localEMConversationType == EMConversation.EMConversationType.Chat)
      {
        localObject = str;
        if (paramEMMessage.direct() == EMMessage.Direct.RECEIVE) {
          localObject = paramEMMessage.getFrom();
        }
      }
      if (paramEMMessage.getType() != EMMessage.Type.CMD) {
        break;
      }
      return;
      localEMConversationType = EMConversation.EMConversationType.Chat;
      continue;
      localEMConversationType = EMConversation.EMConversationType.GroupChat;
      continue;
      localEMConversationType = EMConversation.EMConversationType.ChatRoom;
    }
    getConversation((String)localObject, localEMConversationType, true).insertMessage(paramEMMessage);
  }
  
  public void sendMessage(EMMessage paramEMMessage)
  {
    int i = 1;
    paramEMMessage.makeCallbackStrong();
    boolean bool;
    EMConversation localEMConversation;
    if (paramEMMessage.getType() != EMMessage.Type.CMD)
    {
      bool = true;
      localEMConversation = getConversation(paramEMMessage.conversationId(), EMConversation.msgType2ConversationType(paramEMMessage.getTo(), paramEMMessage.getChatType()), bool);
      if (localEMConversation != null) {
        if (localEMConversation.getCache().getMessage(paramEMMessage.getMsgId()) == null) {
          break label148;
        }
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        long l2 = System.currentTimeMillis();
        EMMessage localEMMessage = localEMConversation.getLastMessage();
        long l1 = l2;
        if (localEMMessage != null)
        {
          l1 = l2;
          if (l2 < localEMMessage.getMsgTime()) {
            l1 = localEMMessage.getMsgTime();
          }
        }
        paramEMMessage.setMsgTime(l1 + 1L);
        localEMConversation.getCache().addMessage(paramEMMessage);
      }
      this.mClient.executeOnSendQueue(new EMChatManager.2(this, paramEMMessage, localEMConversation));
      return;
      bool = false;
      break;
      label148:
      i = 0;
    }
  }
  
  @Deprecated
  public void setMessageListened(EMMessage paramEMMessage)
  {
    setVoiceMessageListened(paramEMMessage);
  }
  
  public void setVoiceMessageListened(EMMessage paramEMMessage)
  {
    paramEMMessage.setListened(true);
    updateMessage(paramEMMessage);
  }
  
  public boolean updateMessage(EMMessage paramEMMessage)
  {
    if (paramEMMessage.direct() == EMMessage.Direct.RECEIVE) {}
    for (String str = paramEMMessage.getFrom(); paramEMMessage.getType() == EMMessage.Type.CMD; str = paramEMMessage.getTo()) {
      return false;
    }
    return getConversation(paramEMMessage.conversationId(), EMConversation.msgType2ConversationType(str, paramEMMessage.getChatType()), true).updateMessage(paramEMMessage);
  }
  
  public boolean updateParticipant(String paramString1, String paramString2)
  {
    return this.emaObject.updateParticipant(paramString1, paramString2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/hyphenate/chat/EMChatManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */