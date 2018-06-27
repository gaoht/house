package com.hyphenate;

import com.hyphenate.chat.EMMucSharedFile;
import java.util.List;

public abstract interface EMGroupChangeListener
{
  public abstract void onAdminAdded(String paramString1, String paramString2);
  
  public abstract void onAdminRemoved(String paramString1, String paramString2);
  
  public abstract void onAnnouncementChanged(String paramString1, String paramString2);
  
  public abstract void onAutoAcceptInvitationFromGroup(String paramString1, String paramString2, String paramString3);
  
  public abstract void onGroupDestroyed(String paramString1, String paramString2);
  
  public abstract void onInvitationAccepted(String paramString1, String paramString2, String paramString3);
  
  public abstract void onInvitationDeclined(String paramString1, String paramString2, String paramString3);
  
  public abstract void onInvitationReceived(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void onMemberExited(String paramString1, String paramString2);
  
  public abstract void onMemberJoined(String paramString1, String paramString2);
  
  public abstract void onMuteListAdded(String paramString, List<String> paramList, long paramLong);
  
  public abstract void onMuteListRemoved(String paramString, List<String> paramList);
  
  public abstract void onOwnerChanged(String paramString1, String paramString2, String paramString3);
  
  public abstract void onRequestToJoinAccepted(String paramString1, String paramString2, String paramString3);
  
  public abstract void onRequestToJoinDeclined(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void onRequestToJoinReceived(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void onSharedFileAdded(String paramString, EMMucSharedFile paramEMMucSharedFile);
  
  public abstract void onSharedFileDeleted(String paramString1, String paramString2);
  
  public abstract void onUserRemoved(String paramString1, String paramString2);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/hyphenate/EMGroupChangeListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */