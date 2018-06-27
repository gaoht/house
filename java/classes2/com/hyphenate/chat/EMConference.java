package com.hyphenate.chat;

public class EMConference
{
  private String conferenceId = "";
  private String extension = "";
  private String password = "";
  private String pubDesktopId = "";
  private String pubNormalId = "";
  
  public String getConferenceId()
  {
    return this.conferenceId;
  }
  
  public String getExtension()
  {
    return this.extension;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public String getPubStreamId(EMConferenceStream.StreamType paramStreamType)
  {
    if (paramStreamType == EMConferenceStream.StreamType.DESKTOP) {
      return this.pubDesktopId;
    }
    return this.pubNormalId;
  }
  
  public void reset()
  {
    this.conferenceId = "";
    this.password = "";
    this.extension = "";
  }
  
  public void setConferenceId(String paramString)
  {
    this.conferenceId = paramString;
  }
  
  public void setExtension(String paramString)
  {
    this.extension = paramString;
  }
  
  public void setPassword(String paramString)
  {
    this.password = paramString;
  }
  
  public void setPubStreamId(String paramString, EMConferenceStream.StreamType paramStreamType)
  {
    if (paramStreamType == EMConferenceStream.StreamType.NORMAL) {
      this.pubNormalId = paramString;
    }
    while (paramStreamType != EMConferenceStream.StreamType.DESKTOP) {
      return;
    }
    this.pubDesktopId = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/EMConference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */