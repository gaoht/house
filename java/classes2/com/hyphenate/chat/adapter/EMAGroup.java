package com.hyphenate.chat.adapter;

import java.util.List;

public class EMAGroup
  extends EMABase
{
  public static final int EMGroupLeaveReason_BE_KICKED = 0;
  public static final int EMGroupLeaveReason_DESTROYED = 1;
  
  public EMAGroup()
  {
    nativeInit();
  }
  
  public EMAGroup(EMAGroup paramEMAGroup)
  {
    nativeInit(paramEMAGroup);
  }
  
  public void addMember(String paramString)
  {
    nativeaddMember(paramString);
  }
  
  public void finalize()
    throws Throwable
  {
    nativeFinalize();
    super.finalize();
  }
  
  public List<String> getAdminList()
  {
    return nativeGetAdminList();
  }
  
  public String getAnnouncement()
  {
    return nativeGetAnnouncement();
  }
  
  public String getDescription()
  {
    return nativeGroupDescription();
  }
  
  public List<String> getGroupBans()
  {
    return nativeGetGroupBans();
  }
  
  public List<String> getGroupMuteList()
  {
    return nativeGetGroupMuteList();
  }
  
  public int getMemberCount()
  {
    return nativeGroupMembersCount();
  }
  
  public List<String> getMembers()
  {
    return nativeGroupMembers();
  }
  
  public String getOwner()
  {
    return nativeGroupOwner();
  }
  
  public List<EMAMucShareFile> getShareFiles()
  {
    return nativeGetShareFiles();
  }
  
  public List<String> groupBlockList()
  {
    return nativeGroupBlockList();
  }
  
  public String groupId()
  {
    return nativeGroupId();
  }
  
  public EMAGroupSetting groupSetting()
  {
    return nativeGroupSetting();
  }
  
  public String groupSubject()
  {
    return nativegroupSubject();
  }
  
  public boolean isMsgBlocked()
  {
    return nativeIsMessageBlocked();
  }
  
  public boolean isPushEnabled()
  {
    return nativeIsPushEnabled();
  }
  
  native void nativeFinalize();
  
  native List<String> nativeGetAdminList();
  
  native String nativeGetAnnouncement();
  
  native List<String> nativeGetGroupBans();
  
  native List<String> nativeGetGroupMuteList();
  
  native List<EMAMucShareFile> nativeGetShareFiles();
  
  native List<String> nativeGroupBlockList();
  
  native String nativeGroupDescription();
  
  native String nativeGroupId();
  
  native List<String> nativeGroupMembers();
  
  native int nativeGroupMembersCount();
  
  native String nativeGroupOwner();
  
  native EMAGroupSetting nativeGroupSetting();
  
  native void nativeInit();
  
  native void nativeInit(EMAGroup paramEMAGroup);
  
  native boolean nativeIsMessageBlocked();
  
  native boolean nativeIsPushEnabled();
  
  native void nativeaddMember(String paramString);
  
  native String nativegroupSubject();
  
  native void nativesetAffiliationsCount(int paramInt);
  
  native void nativesetDescription(String paramString);
  
  native void nativesetGroupName(String paramString);
  
  native void nativesetMsgBlocked(boolean paramBoolean);
  
  native void nativesetOwner(String paramString);
  
  public void setAffiliationsCount(int paramInt)
  {
    nativesetAffiliationsCount(paramInt);
  }
  
  public void setDescription(String paramString)
  {
    nativesetDescription(paramString);
  }
  
  public void setGroupName(String paramString)
  {
    nativesetGroupName(paramString);
  }
  
  public void setMsgBlocked(boolean paramBoolean)
  {
    nativesetMsgBlocked(paramBoolean);
  }
  
  public void setOwner(String paramString)
  {
    nativesetOwner(paramString);
  }
  
  public static enum EMGroupLeaveReason
  {
    BE_KICKED,  DESTROYED;
    
    private EMGroupLeaveReason() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/EMAGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */