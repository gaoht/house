package com.hyphenate.chat.adapter;

import java.util.List;

public abstract interface EMAGroupManagerListenerInterface
{
  public abstract void onAddAdminFromGroup(EMAGroup paramEMAGroup, String paramString);
  
  public abstract void onAddMutesFromGroup(EMAGroup paramEMAGroup, List<String> paramList, long paramLong);
  
  public abstract void onAnnouncementChanged(EMAGroup paramEMAGroup, String paramString);
  
  public abstract void onAssignOwnerFromGroup(EMAGroup paramEMAGroup, String paramString1, String paramString2);
  
  public abstract void onAutoAcceptInvitationFromGroup(EMAGroup paramEMAGroup, String paramString1, String paramString2);
  
  public abstract void onDeleteShareFileFromGroup(EMAGroup paramEMAGroup, String paramString);
  
  public abstract void onLeaveGroup(EMAGroup paramEMAGroup, int paramInt);
  
  public abstract void onMemberExited(EMAGroup paramEMAGroup, String paramString);
  
  public abstract void onMemberJoined(EMAGroup paramEMAGroup, String paramString);
  
  public abstract void onReceiveAcceptionFromGroup(EMAGroup paramEMAGroup);
  
  public abstract void onReceiveInviteAcceptionFromGroup(EMAGroup paramEMAGroup, String paramString);
  
  public abstract void onReceiveInviteDeclineFromGroup(EMAGroup paramEMAGroup, String paramString1, String paramString2);
  
  public abstract void onReceiveInviteFromGroup(String paramString1, String paramString2, String paramString3);
  
  public abstract void onReceiveJoinGroupApplication(EMAGroup paramEMAGroup, String paramString1, String paramString2);
  
  public abstract void onReceiveRejectionFromGroup(String paramString1, String paramString2);
  
  public abstract void onRemoveAdminFromGroup(EMAGroup paramEMAGroup, String paramString);
  
  public abstract void onRemoveMutesFromGroup(EMAGroup paramEMAGroup, List<String> paramList);
  
  public abstract void onUpdateMyGroupList(List<EMAGroup> paramList);
  
  public abstract void onUploadShareFileFromGroup(EMAGroup paramEMAGroup, EMAMucShareFile paramEMAMucShareFile);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/EMAGroupManagerListenerInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */