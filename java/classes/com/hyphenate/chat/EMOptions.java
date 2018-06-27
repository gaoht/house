package com.hyphenate.chat;

import com.hyphenate.chat.core.EMChatConfigPrivate;
import com.hyphenate.chat.core.EMChatConfigPrivate.a;

public class EMOptions
{
  private boolean acceptInvitationAlways = true;
  private String appkey = "";
  private boolean autoAcceptGroupInvitation = true;
  private EMChatConfigPrivate config = null;
  private boolean deleteMessagesAsExitGroup = true;
  private String dnsUrl = "";
  private boolean enableAutoLogin = true;
  private boolean enableDNSConfig = true;
  private String fcmNumber = null;
  private String gcmNumber = null;
  private int imPort;
  private String imServer;
  private boolean isAutodownload = true;
  private boolean isChatroomOwnerLeaveAllowed = true;
  private EMChatConfigPrivate.a mipushConfig = null;
  private boolean requireDeliveryAck = false;
  private boolean requireReadAck = true;
  private String restServer;
  private boolean serverTransfer = true;
  private boolean sortMessageByServerTime = true;
  private boolean useEncryption = false;
  private boolean useFCM = false;
  private boolean useHttps = false;
  private boolean usingHttpsOnly = false;
  
  public void allowChatroomOwnerLeave(boolean paramBoolean)
  {
    if (this.config == null)
    {
      this.isChatroomOwnerLeaveAllowed = paramBoolean;
      return;
    }
    this.config.i(paramBoolean);
  }
  
  public void enableDNSConfig(boolean paramBoolean)
  {
    this.enableDNSConfig = paramBoolean;
    if (this.config == null) {
      return;
    }
    this.config.a(paramBoolean);
  }
  
  public boolean getAcceptInvitationAlways()
  {
    if (this.config == null) {
      return this.acceptInvitationAlways;
    }
    return this.config.r();
  }
  
  public String getAccessToken()
  {
    return this.config.n();
  }
  
  public String getAccessToken(boolean paramBoolean)
  {
    return this.config.b(paramBoolean);
  }
  
  public String getAppKey()
  {
    if (this.config == null) {
      return this.appkey;
    }
    return this.config.l();
  }
  
  public boolean getAutoLogin()
  {
    return this.enableAutoLogin;
  }
  
  public boolean getAutoTransferMessageAttachments()
  {
    if (this.config == null) {
      return this.serverTransfer;
    }
    return this.config.D();
  }
  
  public boolean getAutodownloadThumbnail()
  {
    if (this.config == null) {
      return this.isAutodownload;
    }
    return this.config.E();
  }
  
  public String getDnsUrl()
  {
    if (this.config != null) {
      return this.config.G();
    }
    return this.dnsUrl;
  }
  
  public boolean getEnableDNSConfig()
  {
    return this.enableDNSConfig;
  }
  
  public String getFCMNumber()
  {
    if (this.config == null) {
      return this.fcmNumber;
    }
    return this.config.w();
  }
  
  public String getGCMNumber()
  {
    if (this.config == null) {
      return this.gcmNumber;
    }
    return this.config.v();
  }
  
  public int getImPort()
  {
    return this.imPort;
  }
  
  public String getImServer()
  {
    return this.imServer;
  }
  
  public EMChatConfigPrivate.a getMipushConfig()
  {
    if (this.config == null) {
      return this.mipushConfig;
    }
    return this.config.x();
  }
  
  public boolean getRequireAck()
  {
    if (this.config == null) {
      return this.requireReadAck;
    }
    return this.config.q();
  }
  
  public boolean getRequireDeliveryAck()
  {
    if (this.config == null) {
      return this.requireDeliveryAck;
    }
    return this.config.p();
  }
  
  public String getRestServer()
  {
    return this.restServer;
  }
  
  public boolean getUsingHttpsOnly()
  {
    if (this.config != null) {
      return this.config.C();
    }
    return this.usingHttpsOnly;
  }
  
  public String getVersion()
  {
    return this.config.e();
  }
  
  public boolean isAutoAcceptGroupInvitation()
  {
    if (this.config == null) {
      return this.autoAcceptGroupInvitation;
    }
    return this.config.t();
  }
  
  public boolean isChatroomOwnerLeaveAllowed()
  {
    if (this.config == null) {
      return this.isChatroomOwnerLeaveAllowed;
    }
    return this.config.u();
  }
  
  public boolean isDeleteMessagesAsExitGroup()
  {
    if (this.config == null) {
      return this.deleteMessagesAsExitGroup;
    }
    return this.config.s();
  }
  
  public boolean isSortMessageByServerTime()
  {
    if (this.config == null) {
      return this.sortMessageByServerTime;
    }
    return this.config.z();
  }
  
  public boolean isUseFCM()
  {
    return this.useFCM;
  }
  
  public void setAcceptInvitationAlways(boolean paramBoolean)
  {
    if (this.config == null)
    {
      this.acceptInvitationAlways = paramBoolean;
      return;
    }
    this.config.f(paramBoolean);
  }
  
  public void setAppKey(String paramString)
  {
    this.appkey = paramString;
    updatePath(paramString);
  }
  
  public void setAutoAcceptGroupInvitation(boolean paramBoolean)
  {
    if (this.config == null)
    {
      this.autoAcceptGroupInvitation = paramBoolean;
      return;
    }
    this.config.h(paramBoolean);
  }
  
  public void setAutoDownloadThumbnail(boolean paramBoolean)
  {
    if (this.config == null)
    {
      this.isAutodownload = paramBoolean;
      return;
    }
    this.config.n(paramBoolean);
  }
  
  public void setAutoLogin(boolean paramBoolean)
  {
    this.enableAutoLogin = paramBoolean;
  }
  
  public void setAutoTransferMessageAttachments(boolean paramBoolean)
  {
    if (this.config == null)
    {
      this.serverTransfer = paramBoolean;
      return;
    }
    this.config.m(paramBoolean);
  }
  
  void setConfig(EMChatConfigPrivate paramEMChatConfigPrivate)
  {
    this.config = paramEMChatConfigPrivate;
  }
  
  public void setDeleteMessagesAsExitGroup(boolean paramBoolean)
  {
    if (this.config == null)
    {
      this.deleteMessagesAsExitGroup = paramBoolean;
      return;
    }
    this.config.g(paramBoolean);
  }
  
  public void setDnsUrl(String paramString)
  {
    this.dnsUrl = paramString;
    if (this.config == null) {
      return;
    }
    this.config.i(paramString);
  }
  
  public void setFCMNumber(String paramString)
  {
    this.gcmNumber = null;
    this.fcmNumber = paramString;
    if (this.config == null) {
      return;
    }
    this.config.e(this.gcmNumber);
    this.config.f(paramString);
  }
  
  @Deprecated
  public void setGCMNumber(String paramString)
  {
    this.fcmNumber = null;
    this.gcmNumber = paramString;
    if (this.config == null) {
      return;
    }
    this.config.f(this.fcmNumber);
    this.config.e(paramString);
  }
  
  public void setIMServer(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return;
      this.imServer = paramString;
    } while (this.config == null);
    this.config.c(paramString);
  }
  
  public void setImPort(int paramInt)
  {
    this.imPort = paramInt;
    if (this.config == null) {
      return;
    }
    this.config.a(paramInt);
  }
  
  public void setMipushConfig(String paramString1, String paramString2)
  {
    if (this.config == null)
    {
      this.mipushConfig = new EMChatConfigPrivate.a(paramString1, paramString2);
      return;
    }
    this.config.a(new EMChatConfigPrivate.a(paramString1, paramString2));
  }
  
  public void setRequireAck(boolean paramBoolean)
  {
    this.requireReadAck = paramBoolean;
    if (this.config == null) {
      return;
    }
    this.config.e(paramBoolean);
  }
  
  public void setRequireDeliveryAck(boolean paramBoolean)
  {
    this.requireDeliveryAck = paramBoolean;
    if (this.config == null) {
      return;
    }
    this.config.d(paramBoolean);
  }
  
  public void setRestServer(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return;
      this.restServer = paramString;
    } while (this.config == null);
    this.config.d(paramString);
  }
  
  public void setSortMessageByServerTime(boolean paramBoolean)
  {
    if (this.config == null)
    {
      this.sortMessageByServerTime = paramBoolean;
      return;
    }
    this.config.j(paramBoolean);
  }
  
  public void setUseFCM(boolean paramBoolean)
  {
    this.useFCM = paramBoolean;
  }
  
  @Deprecated
  public void setUseHttps(boolean paramBoolean)
  {
    this.useHttps = paramBoolean;
    if (this.config == null) {
      return;
    }
    this.config.k(paramBoolean);
  }
  
  public void setUsingHttpsOnly(boolean paramBoolean)
  {
    this.usingHttpsOnly = paramBoolean;
    if (this.config == null) {
      return;
    }
    this.config.l(paramBoolean);
  }
  
  void updatePath(String paramString)
  {
    if (this.config != null) {
      this.config.a(paramString);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/hyphenate/chat/EMOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */