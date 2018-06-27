package com.hyphenate.chat.adapter;

import java.util.List;

public abstract interface EMAChatRoomManagerListenerInterface
{
  public abstract void onAddAdmin(EMAChatRoom paramEMAChatRoom, String paramString);
  
  public abstract void onAddMuteList(EMAChatRoom paramEMAChatRoom, List<String> paramList, long paramLong);
  
  public abstract void onAnnouncementChanged(EMAChatRoom paramEMAChatRoom, String paramString);
  
  public abstract void onLeaveChatRoom(EMAChatRoom paramEMAChatRoom, int paramInt);
  
  public abstract void onMemberJoinedChatRoom(EMAChatRoom paramEMAChatRoom, String paramString);
  
  public abstract void onMemberLeftChatRoom(EMAChatRoom paramEMAChatRoom, String paramString);
  
  public abstract void onOwnerChanged(EMAChatRoom paramEMAChatRoom, String paramString1, String paramString2);
  
  public abstract void onRemoveAdmin(EMAChatRoom paramEMAChatRoom, String paramString);
  
  public abstract void onRemoveMutes(EMAChatRoom paramEMAChatRoom, List<String> paramList);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/EMAChatRoomManagerListenerInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */