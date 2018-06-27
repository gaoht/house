package com.hyphenate.chat;

import com.hyphenate.chat.adapter.EMAGroup;
import com.hyphenate.chat.adapter.EMAGroupSetting;
import com.hyphenate.chat.adapter.EMAMucShareFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EMGroup
  extends EMBase<EMAGroup>
{
  private List<EMMucSharedFile> shareFileList;
  
  public EMGroup(EMAGroup paramEMAGroup)
  {
    this.emaObject = paramEMAGroup;
  }
  
  public List<String> getAdminList()
  {
    return ((EMAGroup)this.emaObject).getAdminList();
  }
  
  @Deprecated
  public int getAffiliationsCount()
  {
    return ((EMAGroup)this.emaObject).getMemberCount();
  }
  
  public String getAnnouncement()
  {
    return ((EMAGroup)this.emaObject).getAnnouncement();
  }
  
  public List<String> getBlackList()
  {
    return ((EMAGroup)this.emaObject).getGroupBans();
  }
  
  public String getDescription()
  {
    return ((EMAGroup)this.emaObject).getDescription();
  }
  
  public String getExtension()
  {
    EMAGroupSetting localEMAGroupSetting = ((EMAGroup)this.emaObject).groupSetting();
    if (localEMAGroupSetting == null) {
      return "";
    }
    return localEMAGroupSetting.extension();
  }
  
  public String getGroupId()
  {
    return ((EMAGroup)this.emaObject).groupId();
  }
  
  public String getGroupName()
  {
    return ((EMAGroup)this.emaObject).groupSubject();
  }
  
  public int getMaxUserCount()
  {
    EMAGroupSetting localEMAGroupSetting = ((EMAGroup)this.emaObject).groupSetting();
    if (localEMAGroupSetting == null) {
      return 0;
    }
    return localEMAGroupSetting.maxUserCount();
  }
  
  public int getMemberCount()
  {
    return ((EMAGroup)this.emaObject).getMemberCount();
  }
  
  public List<String> getMembers()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(((EMAGroup)this.emaObject).getMembers());
    return localArrayList;
  }
  
  public List<String> getMuteList()
  {
    return ((EMAGroup)this.emaObject).getGroupMuteList();
  }
  
  public String getOwner()
  {
    return ((EMAGroup)this.emaObject).getOwner();
  }
  
  public List<EMMucSharedFile> getShareFileList()
  {
    if (this.shareFileList == null) {
      this.shareFileList = new ArrayList();
    }
    for (;;)
    {
      Iterator localIterator = ((EMAGroup)this.emaObject).getShareFiles().iterator();
      while (localIterator.hasNext())
      {
        EMAMucShareFile localEMAMucShareFile = (EMAMucShareFile)localIterator.next();
        this.shareFileList.add(new EMMucSharedFile(localEMAMucShareFile));
      }
      this.shareFileList.clear();
    }
    return this.shareFileList;
  }
  
  public String groupSubject()
  {
    return ((EMAGroup)this.emaObject).groupSubject();
  }
  
  @Deprecated
  public boolean isAllowInvites()
  {
    return isMemberAllowToInvite();
  }
  
  public boolean isMemberAllowToInvite()
  {
    EMAGroupSetting localEMAGroupSetting = ((EMAGroup)this.emaObject).groupSetting();
    if (localEMAGroupSetting == null) {
      return true;
    }
    return localEMAGroupSetting.style() == 1;
  }
  
  public boolean isMemberOnly()
  {
    EMAGroupSetting localEMAGroupSetting = ((EMAGroup)this.emaObject).groupSetting();
    if (localEMAGroupSetting == null) {
      return true;
    }
    return (localEMAGroupSetting.style() == 0) || (localEMAGroupSetting.style() == 1) || (localEMAGroupSetting.style() == 2);
  }
  
  @Deprecated
  public boolean isMembersOnly()
  {
    return isMemberOnly();
  }
  
  public boolean isMsgBlocked()
  {
    return ((EMAGroup)this.emaObject).isMsgBlocked();
  }
  
  public boolean isPublic()
  {
    EMAGroupSetting localEMAGroupSetting = ((EMAGroup)this.emaObject).groupSetting();
    if (localEMAGroupSetting == null) {
      return true;
    }
    switch (localEMAGroupSetting.style())
    {
    default: 
      return true;
    }
    return false;
  }
  
  public String toString()
  {
    String str = getGroupName();
    if (str != null) {
      return str;
    }
    return getGroupId();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/hyphenate/chat/EMGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */