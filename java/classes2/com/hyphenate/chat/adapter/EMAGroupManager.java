package com.hyphenate.chat.adapter;

import com.hyphenate.chat.EMCursorResult;
import com.hyphenate.chat.EMGroupInfo;
import java.util.List;
import java.util.Map;

public class EMAGroupManager
  extends EMABase
{
  public EMAGroupManager() {}
  
  public EMAGroupManager(EMAGroupManager paramEMAGroupManager)
  {
    nativeInit(paramEMAGroupManager);
  }
  
  public EMAGroup acceptInvitationFromGroup(String paramString1, String paramString2, EMAError paramEMAError)
  {
    return nativeacceptInvitationFromGroup(paramString1, paramString2, paramEMAError);
  }
  
  public void acceptJoinGroupApplication(String paramString1, String paramString2, EMAError paramEMAError)
  {
    nativeAcceptJoinGroupApplication(paramString1, paramString2, paramEMAError);
  }
  
  public EMAGroup addGroupAdmin(String paramString1, String paramString2, EMAError paramEMAError)
  {
    return nativeAddGroupAdmin(paramString1, paramString2, paramEMAError);
  }
  
  public EMAGroup addGroupMembers(String paramString1, List<String> paramList, String paramString2, EMAError paramEMAError)
  {
    return nativeAddGroupMembers(paramString1, paramList, paramString2, paramEMAError);
  }
  
  public void addListener(EMAGroupManagerListener paramEMAGroupManagerListener)
  {
    nativeAddListener(paramEMAGroupManagerListener);
  }
  
  public List<EMAGroup> allMyGroups(EMAError paramEMAError)
  {
    return nativeAllMyGroups(paramEMAError);
  }
  
  public EMAGroup applyJoinPublicGroup(String paramString1, String paramString2, String paramString3, EMAError paramEMAError)
  {
    return nativeApplyJoinPublicGroup(paramString1, paramString2, paramString3, paramEMAError);
  }
  
  public EMAGroup blockGroupMembers(String paramString1, List<String> paramList, EMAError paramEMAError, String paramString2)
  {
    return nativeBlockGroupMembers(paramString1, paramList, paramEMAError, paramString2);
  }
  
  public EMAGroup blockGroupMessage(String paramString, EMAError paramEMAError)
  {
    return nativeBlockGroupMessage(paramString, paramEMAError);
  }
  
  public EMAGroup changeGroupDescription(String paramString1, String paramString2, EMAError paramEMAError)
  {
    return nativeChangeGroupDescription(paramString1, paramString2, paramEMAError);
  }
  
  public EMAGroup changeGroupSubject(String paramString1, String paramString2, EMAError paramEMAError)
  {
    return nativeChangeGroupSubject(paramString1, paramString2, paramEMAError);
  }
  
  public void clearListeners()
  {
    nativeClearListeners();
  }
  
  public EMAGroup createGroup(String paramString1, String paramString2, String paramString3, EMAGroupSetting paramEMAGroupSetting, List<String> paramList, boolean paramBoolean, EMAError paramEMAError)
  {
    return nativeCreateGroup(paramString1, paramString2, paramString3, paramEMAGroupSetting, paramList, paramBoolean, paramEMAError);
  }
  
  public void declineInvitationFromGroup(String paramString1, String paramString2, String paramString3, EMAError paramEMAError)
  {
    nativedeclineInvitationFromGroup(paramString1, paramString2, paramString3, paramEMAError);
  }
  
  public void declineJoinGroupApplication(String paramString1, String paramString2, String paramString3, EMAError paramEMAError)
  {
    nativeDeclineJoinGroupApplication(paramString1, paramString2, paramString3, paramEMAError);
  }
  
  public void deleteGroupShareFile(String paramString1, String paramString2, EMAError paramEMAError)
  {
    nativeDeleteGroupShareFile(paramString1, paramString2, paramEMAError);
  }
  
  public void destroyGroup(String paramString, EMAError paramEMAError)
  {
    nativeDestroyGroup(paramString, paramEMAError);
  }
  
  public void downloadGroupShareFile(String paramString1, String paramString2, String paramString3, EMACallback paramEMACallback, EMAError paramEMAError)
  {
    nativeDownloadGroupShareFile(paramString1, paramString2, paramString3, paramEMACallback, paramEMAError);
  }
  
  public List<EMAGroup> fetchAllMyGroups(EMAError paramEMAError)
  {
    return nativeFetchAllMyGroups(paramEMAError);
  }
  
  public List<EMAGroup> fetchAllMyGroupsWithPage(int paramInt1, int paramInt2, EMAError paramEMAError)
  {
    return nativeFetchAllMyGroupsWithPage(paramInt1, paramInt2, paramEMAError);
  }
  
  public String fetchGroupAnnouncement(String paramString, EMAError paramEMAError)
  {
    return nativeFetchGroupAnnouncement(paramString, paramEMAError);
  }
  
  public List<String> fetchGroupBlackList(String paramString, int paramInt1, int paramInt2, EMAError paramEMAError)
  {
    return nativeFetchGroupBlackList(paramString, paramInt1, paramInt2, paramEMAError);
  }
  
  public EMCursorResult<String> fetchGroupMembers(String paramString1, String paramString2, int paramInt, EMAError paramEMAError)
  {
    return nativeFetchGroupMembers(paramString1, paramString2, paramInt, paramEMAError);
  }
  
  public Map<String, Long> fetchGroupMutes(String paramString, int paramInt1, int paramInt2, EMAError paramEMAError)
  {
    return nativeFetchGroupMutes(paramString, paramInt1, paramInt2, paramEMAError);
  }
  
  public List<EMAMucShareFile> fetchGroupShareFiles(String paramString, int paramInt1, int paramInt2, EMAError paramEMAError)
  {
    return nativeFetchGroupShareFiles(paramString, paramInt1, paramInt2, paramEMAError);
  }
  
  public EMAGroup fetchGroupSpecification(String paramString, EMAError paramEMAError, boolean paramBoolean)
  {
    return nativeFetchGroupSpecification(paramString, paramEMAError, paramBoolean);
  }
  
  public EMCursorResult<EMGroupInfo> fetchPublicGroupsWithCursor(String paramString, int paramInt, EMAError paramEMAError)
  {
    return nativeFetchPublicGroupsWithCursor(paramString, paramInt, paramEMAError);
  }
  
  public EMAGroup joinPublicGroup(String paramString, EMAError paramEMAError)
  {
    return nativeJoinPublicGroup(paramString, paramEMAError);
  }
  
  public void leaveGroup(String paramString, EMAError paramEMAError)
  {
    nativeLeaveGroup(paramString, paramEMAError);
  }
  
  public void loadAllMyGroupsFromDB()
  {
    nativeLoadAllMyGroupsFromDB();
  }
  
  public EMAGroup muteGroupMembers(String paramString, List<String> paramList, long paramLong, EMAError paramEMAError)
  {
    return nativeMuteGroupMembers(paramString, paramList, paramLong, paramEMAError);
  }
  
  native void nativeAcceptJoinGroupApplication(String paramString1, String paramString2, EMAError paramEMAError);
  
  native EMAGroup nativeAddGroupAdmin(String paramString1, String paramString2, EMAError paramEMAError);
  
  native EMAGroup nativeAddGroupMembers(String paramString1, List<String> paramList, String paramString2, EMAError paramEMAError);
  
  native void nativeAddListener(EMAGroupManagerListener paramEMAGroupManagerListener);
  
  native List<EMAGroup> nativeAllMyGroups(EMAError paramEMAError);
  
  native EMAGroup nativeApplyJoinPublicGroup(String paramString1, String paramString2, String paramString3, EMAError paramEMAError);
  
  native EMAGroup nativeBlockGroupMembers(String paramString1, List<String> paramList, EMAError paramEMAError, String paramString2);
  
  native EMAGroup nativeBlockGroupMessage(String paramString, EMAError paramEMAError);
  
  native EMAGroup nativeChangeGroupDescription(String paramString1, String paramString2, EMAError paramEMAError);
  
  native EMAGroup nativeChangeGroupSubject(String paramString1, String paramString2, EMAError paramEMAError);
  
  native void nativeClearListeners();
  
  native EMAGroup nativeCreateGroup(String paramString1, String paramString2, String paramString3, EMAGroupSetting paramEMAGroupSetting, List<String> paramList, boolean paramBoolean, EMAError paramEMAError);
  
  native void nativeDeclineJoinGroupApplication(String paramString1, String paramString2, String paramString3, EMAError paramEMAError);
  
  native void nativeDeleteGroupShareFile(String paramString1, String paramString2, EMAError paramEMAError);
  
  native void nativeDestroyGroup(String paramString, EMAError paramEMAError);
  
  native void nativeDownloadGroupShareFile(String paramString1, String paramString2, String paramString3, EMACallback paramEMACallback, EMAError paramEMAError);
  
  native List<EMAGroup> nativeFetchAllMyGroups(EMAError paramEMAError);
  
  native List<EMAGroup> nativeFetchAllMyGroupsWithPage(int paramInt1, int paramInt2, EMAError paramEMAError);
  
  native String nativeFetchGroupAnnouncement(String paramString, EMAError paramEMAError);
  
  native List<String> nativeFetchGroupBlackList(String paramString, int paramInt1, int paramInt2, EMAError paramEMAError);
  
  native EMCursorResult<String> nativeFetchGroupMembers(String paramString1, String paramString2, int paramInt, EMAError paramEMAError);
  
  native Map<String, Long> nativeFetchGroupMutes(String paramString, int paramInt1, int paramInt2, EMAError paramEMAError);
  
  native List<EMAMucShareFile> nativeFetchGroupShareFiles(String paramString, int paramInt1, int paramInt2, EMAError paramEMAError);
  
  native EMAGroup nativeFetchGroupSpecification(String paramString, EMAError paramEMAError, boolean paramBoolean);
  
  native EMCursorResult<EMGroupInfo> nativeFetchPublicGroupsWithCursor(String paramString, int paramInt, EMAError paramEMAError);
  
  native void nativeInit(EMAGroupManager paramEMAGroupManager);
  
  native EMAGroup nativeJoinPublicGroup(String paramString, EMAError paramEMAError);
  
  native void nativeLeaveGroup(String paramString, EMAError paramEMAError);
  
  native void nativeLoadAllMyGroupsFromDB();
  
  native EMAGroup nativeMuteGroupMembers(String paramString, List<String> paramList, long paramLong, EMAError paramEMAError);
  
  native EMAGroup nativeRemoveGroupAdmin(String paramString1, String paramString2, EMAError paramEMAError);
  
  native EMAGroup nativeRemoveGroupMembers(String paramString, List<String> paramList, EMAError paramEMAError);
  
  native void nativeRemoveListener(EMAGroupManagerListener paramEMAGroupManagerListener);
  
  native EMAGroup nativeSearchPublicGroup(String paramString, EMAError paramEMAError);
  
  native EMAGroup nativeTransferGroupOwner(String paramString1, String paramString2, EMAError paramEMAError);
  
  native EMAGroup nativeUnMuteGroupMembers(String paramString, List<String> paramList, EMAError paramEMAError);
  
  native EMAGroup nativeUnblockGroupMembers(String paramString, List<String> paramList, EMAError paramEMAError);
  
  native EMAGroup nativeUnblockGroupMessage(String paramString, EMAError paramEMAError);
  
  native void nativeUpdateGroupAnnouncement(String paramString1, String paramString2, EMAError paramEMAError);
  
  native EMAGroup nativeUpdateGroupExtension(String paramString1, String paramString2, EMAError paramEMAError);
  
  native EMAMucShareFile nativeUploadGroupShareFile(String paramString1, String paramString2, EMACallback paramEMACallback, EMAError paramEMAError);
  
  native EMAGroup nativeacceptInvitationFromGroup(String paramString1, String paramString2, EMAError paramEMAError);
  
  native void nativedeclineInvitationFromGroup(String paramString1, String paramString2, String paramString3, EMAError paramEMAError);
  
  public EMAGroup removeGroupAdmin(String paramString1, String paramString2, EMAError paramEMAError)
  {
    return nativeRemoveGroupAdmin(paramString1, paramString2, paramEMAError);
  }
  
  public EMAGroup removeGroupMembers(String paramString, List<String> paramList, EMAError paramEMAError)
  {
    return nativeRemoveGroupMembers(paramString, paramList, paramEMAError);
  }
  
  public void removeListener(EMAGroupManagerListener paramEMAGroupManagerListener)
  {
    nativeRemoveListener(paramEMAGroupManagerListener);
  }
  
  public EMAGroup searchPublicGroup(String paramString, EMAError paramEMAError)
  {
    return nativeSearchPublicGroup(paramString, paramEMAError);
  }
  
  public EMAGroup transferGroupOwner(String paramString1, String paramString2, EMAError paramEMAError)
  {
    return nativeTransferGroupOwner(paramString1, paramString2, paramEMAError);
  }
  
  public EMAGroup unMuteGroupMembers(String paramString, List<String> paramList, EMAError paramEMAError)
  {
    return nativeUnMuteGroupMembers(paramString, paramList, paramEMAError);
  }
  
  public EMAGroup unblockGroupMembers(String paramString, List<String> paramList, EMAError paramEMAError)
  {
    return nativeUnblockGroupMembers(paramString, paramList, paramEMAError);
  }
  
  public EMAGroup unblockGroupMessage(String paramString, EMAError paramEMAError)
  {
    return nativeUnblockGroupMessage(paramString, paramEMAError);
  }
  
  public void updateGroupAnnouncement(String paramString1, String paramString2, EMAError paramEMAError)
  {
    nativeUpdateGroupAnnouncement(paramString1, paramString2, paramEMAError);
  }
  
  public EMAGroup updateGroupExtension(String paramString1, String paramString2, EMAError paramEMAError)
  {
    return nativeUpdateGroupExtension(paramString1, paramString2, paramEMAError);
  }
  
  public EMAMucShareFile uploadGroupShareFile(String paramString1, String paramString2, EMACallback paramEMACallback, EMAError paramEMAError)
  {
    return nativeUploadGroupShareFile(paramString1, paramString2, paramEMACallback, paramEMAError);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/EMAGroupManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */