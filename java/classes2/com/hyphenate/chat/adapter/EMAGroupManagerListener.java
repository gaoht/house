package com.hyphenate.chat.adapter;

import java.util.List;

public abstract class EMAGroupManagerListener
  extends EMABase
  implements EMAGroupManagerListenerInterface
{
  public EMAGroupManagerListener()
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
  
  public void onAddAdminFromGroup(EMAGroup paramEMAGroup, String paramString) {}
  
  public void onAddMutesFromGroup(EMAGroup paramEMAGroup, List<String> paramList, long paramLong) {}
  
  public void onAnnouncementChanged(EMAGroup paramEMAGroup, String paramString) {}
  
  public void onAssignOwnerFromGroup(EMAGroup paramEMAGroup, String paramString1, String paramString2) {}
  
  public void onAutoAcceptInvitationFromGroup(EMAGroup paramEMAGroup, String paramString1, String paramString2) {}
  
  public void onDeleteShareFileFromGroup(EMAGroup paramEMAGroup, String paramString) {}
  
  public void onLeaveGroup(EMAGroup paramEMAGroup, int paramInt) {}
  
  public void onMemberExited(EMAGroup paramEMAGroup, String paramString) {}
  
  public void onMemberJoined(EMAGroup paramEMAGroup, String paramString) {}
  
  public void onReceiveAcceptionFromGroup(EMAGroup paramEMAGroup) {}
  
  public void onReceiveInviteAcceptionFromGroup(EMAGroup paramEMAGroup, String paramString) {}
  
  public void onReceiveInviteDeclineFromGroup(EMAGroup paramEMAGroup, String paramString1, String paramString2) {}
  
  public void onReceiveInviteFromGroup(String paramString1, String paramString2, String paramString3) {}
  
  public void onReceiveJoinGroupApplication(EMAGroup paramEMAGroup, String paramString1, String paramString2) {}
  
  public void onReceiveRejectionFromGroup(String paramString1, String paramString2) {}
  
  public void onRemoveAdminFromGroup(EMAGroup paramEMAGroup, String paramString) {}
  
  public void onRemoveMutesFromGroup(EMAGroup paramEMAGroup, List<String> paramList) {}
  
  public void onUpdateMyGroupList(List<EMAGroup> paramList) {}
  
  public void onUploadShareFileFromGroup(EMAGroup paramEMAGroup, EMAMucShareFile paramEMAMucShareFile) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/EMAGroupManagerListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */