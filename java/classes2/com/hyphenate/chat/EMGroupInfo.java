package com.hyphenate.chat;

import java.io.Serializable;

public class EMGroupInfo
  implements Serializable
{
  private static final long serialVersionUID = -2004486389398310700L;
  private String groupId;
  private String groupName;
  
  public EMGroupInfo(String paramString1, String paramString2)
  {
    this.groupId = paramString1;
    this.groupName = paramString2;
  }
  
  public String getGroupId()
  {
    return this.groupId;
  }
  
  public String getGroupName()
  {
    return this.groupName;
  }
  
  public void setGroupId(String paramString)
  {
    this.groupId = paramString;
  }
  
  public void setGroupName(String paramString)
  {
    this.groupName = paramString;
  }
  
  public String toString()
  {
    return this.groupName;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/EMGroupInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */