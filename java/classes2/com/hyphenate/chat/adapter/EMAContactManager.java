package com.hyphenate.chat.adapter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EMAContactManager
  extends EMABase
{
  private Set<EMAContactListener> listeners = new HashSet();
  
  public EMAContactManager() {}
  
  public EMAContactManager(EMAContactManager paramEMAContactManager)
  {
    nativeInit(paramEMAContactManager);
  }
  
  public void acceptInvitation(String paramString, EMAError paramEMAError)
  {
    nativeAcceptInvitation(paramString, paramEMAError);
  }
  
  public void addToBlackList(String paramString, boolean paramBoolean, EMAError paramEMAError)
  {
    nativeAddToBlackList(paramString, paramBoolean, paramEMAError);
  }
  
  public void declineInvitation(String paramString, EMAError paramEMAError)
  {
    nativeDeclineInvitation(paramString, paramEMAError);
  }
  
  public void deleteContact(String paramString, EMAError paramEMAError, boolean paramBoolean)
  {
    nativeDeleteContact(paramString, paramEMAError, paramBoolean);
  }
  
  public List<String> getBlackListFromDB(EMAError paramEMAError)
  {
    return nativeGetBlackListFromDB(paramEMAError);
  }
  
  public List<String> getBlackListFromServer(EMAError paramEMAError)
  {
    return nativeGetBlackListFromServer(paramEMAError);
  }
  
  public List<String> getContactsFromDB(EMAError paramEMAError)
  {
    return nativeGetContactsFromDB(paramEMAError);
  }
  
  public List<String> getContactsFromServer(EMAError paramEMAError)
  {
    return nativeGetContactsFromServer(paramEMAError);
  }
  
  public List<String> getSelfIdsOnOtherPlatform(EMAError paramEMAError)
  {
    return nativeGetSelfIdsOnOtherPlatform(paramEMAError);
  }
  
  public void inviteContact(String paramString1, String paramString2, EMAError paramEMAError)
  {
    nativeInviteContact(paramString1, paramString2, paramEMAError);
  }
  
  native void nativeAcceptInvitation(String paramString, EMAError paramEMAError);
  
  native void nativeAddToBlackList(String paramString, boolean paramBoolean, EMAError paramEMAError);
  
  native void nativeDeclineInvitation(String paramString, EMAError paramEMAError);
  
  native void nativeDeleteContact(String paramString, EMAError paramEMAError, boolean paramBoolean);
  
  native List<String> nativeGetBlackListFromDB(EMAError paramEMAError);
  
  native List<String> nativeGetBlackListFromServer(EMAError paramEMAError);
  
  native List<String> nativeGetContactsFromDB(EMAError paramEMAError);
  
  native List<String> nativeGetContactsFromServer(EMAError paramEMAError);
  
  native List<String> nativeGetSelfIdsOnOtherPlatform(EMAError paramEMAError);
  
  native void nativeInit(EMAContactManager paramEMAContactManager);
  
  native void nativeInviteContact(String paramString1, String paramString2, EMAError paramEMAError);
  
  native void nativeRegisterContactListener(EMAContactListener paramEMAContactListener);
  
  native void nativeRemoveContactListener(EMAContactListener paramEMAContactListener);
  
  native void nativeRemoveFromBlackList(String paramString, EMAError paramEMAError);
  
  native void nativeSaveBlackList(List<String> paramList, EMAError paramEMAError);
  
  native void nativeSetSupportRosterVersion(boolean paramBoolean);
  
  public void registerContactListener(EMAContactListener paramEMAContactListener)
  {
    this.listeners.add(paramEMAContactListener);
    nativeRegisterContactListener(paramEMAContactListener);
  }
  
  public void removeContactListener(EMAContactListener paramEMAContactListener)
  {
    this.listeners.remove(paramEMAContactListener);
    nativeRemoveContactListener(paramEMAContactListener);
  }
  
  public void removeFromBlackList(String paramString, EMAError paramEMAError)
  {
    nativeRemoveFromBlackList(paramString, paramEMAError);
  }
  
  public void saveBlackList(List<String> paramList, EMAError paramEMAError)
  {
    nativeSaveBlackList(paramList, paramEMAError);
  }
  
  public void setSupportRosterVersion(boolean paramBoolean)
  {
    nativeSetSupportRosterVersion(paramBoolean);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/EMAContactManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */