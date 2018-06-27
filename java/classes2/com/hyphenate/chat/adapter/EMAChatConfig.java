package com.hyphenate.chat.adapter;

import com.hyphenate.chat.adapter.message.EMAMessage;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class EMAChatConfig
  extends EMABase
{
  public static void logD(String paramString1, String paramString2)
  {
    nativeLogD(paramString1, paramString2);
  }
  
  public static void logE(String paramString1, String paramString2)
  {
    nativeLogE(paramString1, paramString2);
  }
  
  public static void logI(String paramString1, String paramString2)
  {
    nativeLogI(paramString1, paramString2);
  }
  
  public static void logV(String paramString1, String paramString2)
  {
    nativeLogV(paramString1, paramString2);
  }
  
  public static void logW(String paramString1, String paramString2)
  {
    nativeLogW(paramString1, paramString2);
  }
  
  static native void nativeLogD(String paramString1, String paramString2);
  
  static native void nativeLogE(String paramString1, String paramString2);
  
  static native void nativeLogI(String paramString1, String paramString2);
  
  static native void nativeLogV(String paramString1, String paramString2);
  
  static native void nativeLogW(String paramString1, String paramString2);
  
  public void enableDnsConfig(boolean paramBoolean)
  {
    nativeenableDnsConfig(paramBoolean);
  }
  
  public void finalize()
    throws Throwable
  {
    nativeFinalize();
    super.finalize();
  }
  
  public String getAccessToken()
  {
    return getAccessToken(false);
  }
  
  public String getAccessToken(boolean paramBoolean)
  {
    return nativegetAccessToken(paramBoolean);
  }
  
  public String getAppKey()
  {
    return nativegetAppKey();
  }
  
  public boolean getAutoAccept()
  {
    return nativegetAutoAccept();
  }
  
  public boolean getAutoAcceptGroupInvitation()
  {
    return nativegetAutoAcceptGroupInvitation();
  }
  
  public boolean getAutoConversationLoaded()
  {
    return nativegetAutoConversationLoaded();
  }
  
  public boolean getAutoLogin()
  {
    return nativegetAutoLogin();
  }
  
  public boolean getAutodownloadThumbnail()
  {
    return nativeGetAutodownloadThumbnail();
  }
  
  public String getBaseUrl()
  {
    return nativegetBaseUrl();
  }
  
  public boolean getCallSendPushNotificaitonIfOffline(EMACallManager paramEMACallManager)
  {
    return nativeGetCallSendPushNotificaitonIfOffline(paramEMACallManager);
  }
  
  public String getChatAddress()
  {
    return nativegetChatAddress();
  }
  
  public String getChatDomain()
  {
    return nativegetChatDomain();
  }
  
  public boolean getDeleteMessageAsExitGroup()
  {
    return nativegetDeleteMessageAsExitGroup();
  }
  
  public String getDnsUrl()
  {
    return nativeGetDnsUrl();
  }
  
  public String getDownloadPath()
  {
    return nativegetDownloadPath();
  }
  
  public boolean getEnableConsoleLog()
  {
    return nativegetEnableConsoleLog();
  }
  
  public String getGaoDeDiscoverKey()
  {
    return nativeGetGaoDeDiscoverKey();
  }
  
  public String getGaoDeLocationKey()
  {
    return nativeGetGaoDeLocationKey();
  }
  
  public String getGroupDomain()
  {
    return nativegetGroupDomain();
  }
  
  public boolean getIsChatroomOwnerLeaveAllowed()
  {
    return nativegetIsChatroomOwnerLeaveAllowed();
  }
  
  public boolean getIsSandboxMode()
  {
    return nativegetIsSandboxMode();
  }
  
  public EMAHeartBeatCustomizedParams getMobileHeartBeatCustomizedParams()
  {
    AtomicInteger localAtomicInteger1 = new AtomicInteger();
    AtomicInteger localAtomicInteger2 = new AtomicInteger();
    AtomicInteger localAtomicInteger3 = new AtomicInteger();
    nativeGetMobileHeartBeatCustomizedParams(localAtomicInteger1, localAtomicInteger2, localAtomicInteger3);
    EMAHeartBeatCustomizedParams localEMAHeartBeatCustomizedParams = new EMAHeartBeatCustomizedParams();
    localEMAHeartBeatCustomizedParams.minInterval = localAtomicInteger1.get();
    localEMAHeartBeatCustomizedParams.maxInterval = localAtomicInteger2.get();
    localEMAHeartBeatCustomizedParams.defaultInterval = localAtomicInteger3.get();
    return localEMAHeartBeatCustomizedParams;
  }
  
  public String getNextAvailableBaseUrl()
  {
    return nativegetNextAvailableBaseUrl();
  }
  
  public boolean getRequireDeliveryAck()
  {
    return nativegetRequireDeliveryAck();
  }
  
  public boolean getRequireReadAck()
  {
    return nativegetRequireReadAck();
  }
  
  public String getResourcePath()
  {
    return nativegetResourcePath();
  }
  
  public String getRestServer()
  {
    return nativegetRestServer();
  }
  
  public boolean getSortMessageByServerTime()
  {
    return nativeGetSortMessageByServerTime();
  }
  
  public long getTokenSaveTime()
  {
    return nativegetTokenSaveTime();
  }
  
  public boolean getTransferAttachments()
  {
    return nativeGetTransferAttachments();
  }
  
  public boolean getUseAws()
  {
    return nativeGetUseAws();
  }
  
  public boolean getUsingHttpsOnly()
  {
    return nativeGetUsingHttpsOnly();
  }
  
  public boolean getUsingSQLCipher()
  {
    return nativeGetUsingSQLCipher();
  }
  
  public EMAHeartBeatCustomizedParams getWifiHeartBeatCustomizedParams()
  {
    AtomicInteger localAtomicInteger1 = new AtomicInteger();
    AtomicInteger localAtomicInteger2 = new AtomicInteger();
    AtomicInteger localAtomicInteger3 = new AtomicInteger();
    nativeGetWifiHeartBeatCustomizedParams(localAtomicInteger1, localAtomicInteger2, localAtomicInteger3);
    EMAHeartBeatCustomizedParams localEMAHeartBeatCustomizedParams = new EMAHeartBeatCustomizedParams();
    localEMAHeartBeatCustomizedParams.minInterval = localAtomicInteger1.get();
    localEMAHeartBeatCustomizedParams.maxInterval = localAtomicInteger2.get();
    localEMAHeartBeatCustomizedParams.defaultInterval = localAtomicInteger3.get();
    return localEMAHeartBeatCustomizedParams;
  }
  
  public String getWorkPath()
  {
    return nativegetWorkPath();
  }
  
  public boolean hasHeartBeatCustomizedParams()
  {
    return nativeHasHeartBeatCustomizedParams();
  }
  
  public void importBlackList(List<String> paramList)
  {
    nativeImportBlackList(paramList);
  }
  
  public void importChatRoom(String paramString1, String paramString2, String paramString3, String paramString4, List<String> paramList, int paramInt)
  {
    nativeImportChatRoom(paramString1, paramString2, paramString3, paramString4, paramList, paramInt);
  }
  
  public void importContacts(List<String> paramList)
  {
    nativeImportContacts(paramList);
  }
  
  public void importConversation(String paramString1, int paramInt, String paramString2)
  {
    nativeImportConversation(paramString1, paramInt, paramString2);
  }
  
  public void importGroup(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, List<String> paramList, boolean paramBoolean, int paramInt2)
  {
    nativeImportGroup(paramString1, paramInt1, paramString2, paramString3, paramString4, paramList, paramBoolean, paramInt2);
  }
  
  public void importMessages(List<EMAMessage> paramList)
  {
    nativeImportMessages(paramList);
  }
  
  public void init(String paramString1, String paramString2, String paramString3)
  {
    nativeInit(paramString1, paramString2, paramString3);
  }
  
  public boolean isEnableDnsConfig()
  {
    return nativeisEnableDnsConfig();
  }
  
  public boolean isGcmEnabled()
  {
    return nativeIsGcmEnabled();
  }
  
  native void nativeFinalize();
  
  native boolean nativeGetAutodownloadThumbnail();
  
  native boolean nativeGetCallSendPushNotificaitonIfOffline(EMACallManager paramEMACallManager);
  
  native String nativeGetDnsUrl();
  
  native String nativeGetGaoDeDiscoverKey();
  
  native String nativeGetGaoDeLocationKey();
  
  native void nativeGetMobileHeartBeatCustomizedParams(AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2, AtomicInteger paramAtomicInteger3);
  
  native boolean nativeGetSortMessageByServerTime();
  
  native boolean nativeGetTransferAttachments();
  
  native boolean nativeGetUseAws();
  
  native boolean nativeGetUsingHttpsOnly();
  
  native boolean nativeGetUsingSQLCipher();
  
  native void nativeGetWifiHeartBeatCustomizedParams(AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2, AtomicInteger paramAtomicInteger3);
  
  native boolean nativeHasHeartBeatCustomizedParams();
  
  native void nativeImportBlackList(List<String> paramList);
  
  native void nativeImportChatRoom(String paramString1, String paramString2, String paramString3, String paramString4, List<String> paramList, int paramInt);
  
  native void nativeImportContacts(List<String> paramList);
  
  native void nativeImportConversation(String paramString1, int paramInt, String paramString2);
  
  native void nativeImportGroup(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, List<String> paramList, boolean paramBoolean, int paramInt2);
  
  native void nativeImportMessages(List<EMAMessage> paramList);
  
  native void nativeInit(String paramString1, String paramString2, String paramString3);
  
  native boolean nativeIsGcmEnabled();
  
  native boolean nativeOpenDatabase(String paramString);
  
  native void nativeReloadAll();
  
  native void nativeSetAutodownloadThumbnail(boolean paramBoolean);
  
  native void nativeSetCallSendPushNotificationIfOffline(EMACallManager paramEMACallManager, boolean paramBoolean);
  
  native void nativeSetCallbackNet(EMANetCallback paramEMANetCallback);
  
  native void nativeSetDebugMode(boolean paramBoolean);
  
  native void nativeSetDnsUrl(String paramString);
  
  native void nativeSetSDKVersion(String paramString);
  
  native void nativeSetSortMessageByServerTime(boolean paramBoolean);
  
  native void nativeSetTransferAttachments(boolean paramBoolean);
  
  native void nativeSetUseAws(boolean paramBoolean);
  
  native void nativeSetUseHttps(boolean paramBoolean);
  
  native void nativeSetUsingHttpsOnly(boolean paramBoolean);
  
  native void nativeUpdateConversationUnreadCount(String paramString, int paramInt);
  
  native void nativeUploadLog(EMACallback paramEMACallback);
  
  native void nativeenableDnsConfig(boolean paramBoolean);
  
  native String nativegetAccessToken(boolean paramBoolean);
  
  native String nativegetAppKey();
  
  native boolean nativegetAutoAccept();
  
  native boolean nativegetAutoAcceptGroupInvitation();
  
  native boolean nativegetAutoConversationLoaded();
  
  native boolean nativegetAutoLogin();
  
  native String nativegetBaseUrl();
  
  native String nativegetChatAddress();
  
  native String nativegetChatDomain();
  
  native boolean nativegetDeleteMessageAsExitGroup();
  
  native String nativegetDownloadPath();
  
  native boolean nativegetEnableConsoleLog();
  
  native String nativegetGroupDomain();
  
  native boolean nativegetIsChatroomOwnerLeaveAllowed();
  
  native boolean nativegetIsSandboxMode();
  
  native String nativegetNextAvailableBaseUrl();
  
  native boolean nativegetRequireDeliveryAck();
  
  native boolean nativegetRequireReadAck();
  
  native String nativegetResourcePath();
  
  native String nativegetRestServer();
  
  native long nativegetTokenSaveTime();
  
  native String nativegetWorkPath();
  
  native boolean nativeisEnableDnsConfig();
  
  native void nativeretrieveDNSConfig();
  
  native void nativesetAppKey(String paramString);
  
  native void nativesetAutoAccept(boolean paramBoolean);
  
  native void nativesetAutoAcceptGroupInvitation(boolean paramBoolean);
  
  native void nativesetAutoConversationLoaded(boolean paramBoolean);
  
  native void nativesetAutoLogin(boolean paramBoolean);
  
  native void nativesetChatDomain(String paramString);
  
  native void nativesetChatPort(int paramInt);
  
  native void nativesetChatServer(String paramString);
  
  native void nativesetDeleteMessageAsExitGroup(boolean paramBoolean);
  
  native void nativesetDeviceName(String paramString);
  
  native void nativesetDeviceUuid(String paramString);
  
  native void nativesetDownloadPath(String paramString);
  
  native void nativesetEnableConsoleLog(boolean paramBoolean);
  
  native void nativesetGroupDomain(String paramString);
  
  native void nativesetIsChatroomOwnerLeaveAllowed(boolean paramBoolean);
  
  native void nativesetIsSandboxMode(boolean paramBoolean);
  
  native void nativesetLogPath(String paramString);
  
  native void nativesetRequireDeliveryAck(boolean paramBoolean);
  
  native void nativesetRequireReadAck(boolean paramBoolean);
  
  native void nativesetRestServer(String paramString);
  
  native boolean nativeuseHttps();
  
  public boolean openDatabase(String paramString)
  {
    return nativeOpenDatabase(paramString);
  }
  
  public void reloadAll()
  {
    nativeReloadAll();
  }
  
  public void retrieveDNSConfig()
  {
    nativeretrieveDNSConfig();
  }
  
  public void setAppKey(String paramString)
  {
    nativesetAppKey(paramString);
  }
  
  public void setAutoAccept(boolean paramBoolean)
  {
    nativesetAutoAccept(paramBoolean);
  }
  
  public void setAutoAcceptGroupInvitation(boolean paramBoolean)
  {
    nativesetAutoAcceptGroupInvitation(paramBoolean);
  }
  
  public void setAutoConversationLoaded(boolean paramBoolean)
  {
    nativesetAutoConversationLoaded(paramBoolean);
  }
  
  public void setAutoLogin(boolean paramBoolean)
  {
    nativesetAutoLogin(paramBoolean);
  }
  
  public void setAutodownloadThumbnail(boolean paramBoolean)
  {
    nativeSetAutodownloadThumbnail(paramBoolean);
  }
  
  public void setCallSendPushNotificaitonIfOffline(EMACallManager paramEMACallManager, boolean paramBoolean)
  {
    nativeSetCallSendPushNotificationIfOffline(paramEMACallManager, paramBoolean);
  }
  
  public void setChatDomain(String paramString)
  {
    nativesetChatDomain(paramString);
  }
  
  public void setChatPort(int paramInt)
  {
    nativesetChatPort(paramInt);
  }
  
  public void setChatServer(String paramString)
  {
    nativesetChatServer(paramString);
  }
  
  public void setDebugMode(boolean paramBoolean)
  {
    nativeSetDebugMode(paramBoolean);
  }
  
  public void setDeleteMessageAsExitGroup(boolean paramBoolean)
  {
    nativesetDeleteMessageAsExitGroup(paramBoolean);
  }
  
  public void setDeviceName(String paramString)
  {
    nativesetDeviceName(paramString);
  }
  
  public void setDeviceUuid(String paramString)
  {
    nativesetDeviceUuid(paramString);
  }
  
  public void setDnsUrl(String paramString)
  {
    nativeSetDnsUrl(paramString);
  }
  
  public void setDownloadPath(String paramString)
  {
    nativesetDownloadPath(paramString);
  }
  
  public void setEnableConsoleLog(boolean paramBoolean)
  {
    nativesetEnableConsoleLog(paramBoolean);
  }
  
  public void setGroupDomain(String paramString)
  {
    nativesetGroupDomain(paramString);
  }
  
  public void setIsChatroomOwnerLeaveAllowed(boolean paramBoolean)
  {
    nativesetIsChatroomOwnerLeaveAllowed(paramBoolean);
  }
  
  public void setIsSandboxMode(boolean paramBoolean)
  {
    nativesetIsSandboxMode(paramBoolean);
  }
  
  public void setLogPath(String paramString)
  {
    nativesetLogPath(paramString);
  }
  
  public void setNetCallback(EMANetCallback paramEMANetCallback)
  {
    nativeSetCallbackNet(paramEMANetCallback);
  }
  
  public void setRequireDeliveryAck(boolean paramBoolean)
  {
    nativesetRequireDeliveryAck(paramBoolean);
  }
  
  public void setRequireReadAck(boolean paramBoolean)
  {
    nativesetRequireReadAck(paramBoolean);
  }
  
  public void setRestServer(String paramString)
  {
    nativesetRestServer(paramString);
  }
  
  public void setSDKVersion(String paramString)
  {
    nativeSetSDKVersion(paramString);
  }
  
  public void setSortMessageByServerTime(boolean paramBoolean)
  {
    nativeSetSortMessageByServerTime(paramBoolean);
  }
  
  public void setTransferAttachments(boolean paramBoolean)
  {
    nativeSetTransferAttachments(paramBoolean);
  }
  
  public void setUseAws(boolean paramBoolean)
  {
    nativeSetUseAws(paramBoolean);
  }
  
  public void setUseHttps(boolean paramBoolean)
  {
    nativeSetUseHttps(paramBoolean);
  }
  
  public void setUsingHttpsOnly(boolean paramBoolean)
  {
    nativeSetUsingHttpsOnly(paramBoolean);
  }
  
  public void updateConversationUnreadCount(String paramString, int paramInt)
  {
    nativeUpdateConversationUnreadCount(paramString, paramInt);
  }
  
  public void uploadLog(EMACallback paramEMACallback)
  {
    nativeUploadLog(paramEMACallback);
  }
  
  public boolean useHttps()
  {
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/EMAChatConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */