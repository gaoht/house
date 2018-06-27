package com.hyphenate;

import java.util.List;

public abstract interface EMChatRoomChangeListener
{
  public abstract void onAdminAdded(String paramString1, String paramString2);
  
  public abstract void onAdminRemoved(String paramString1, String paramString2);
  
  public abstract void onAnnouncementChanged(String paramString1, String paramString2);
  
  public abstract void onChatRoomDestroyed(String paramString1, String paramString2);
  
  public abstract void onMemberExited(String paramString1, String paramString2, String paramString3);
  
  public abstract void onMemberJoined(String paramString1, String paramString2);
  
  public abstract void onMuteListAdded(String paramString, List<String> paramList, long paramLong);
  
  public abstract void onMuteListRemoved(String paramString, List<String> paramList);
  
  public abstract void onOwnerChanged(String paramString1, String paramString2, String paramString3);
  
  public abstract void onRemovedFromChatRoom(String paramString1, String paramString2, String paramString3);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/EMChatRoomChangeListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */