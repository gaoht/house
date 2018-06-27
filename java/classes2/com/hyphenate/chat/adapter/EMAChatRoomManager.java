package com.hyphenate.chat.adapter;

import com.hyphenate.chat.EMCursorResult;
import com.hyphenate.chat.EMPageResult;
import java.util.List;
import java.util.Map;

public class EMAChatRoomManager
  extends EMABase
{
  public EMAChatRoom addChatroomAdmin(String paramString1, String paramString2, EMAError paramEMAError)
  {
    return nativeAddChatroomAdmin(paramString1, paramString2, paramEMAError);
  }
  
  public void addListener(EMAChatRoomManagerListener paramEMAChatRoomManagerListener)
  {
    nativeAddListener(paramEMAChatRoomManagerListener);
  }
  
  public EMAChatRoom blockChatroomMembers(String paramString, List<String> paramList, EMAError paramEMAError)
  {
    return nativeBlockChatroomMembers(paramString, paramList, paramEMAError);
  }
  
  public EMAChatRoom changeChatroomDescription(String paramString1, String paramString2, EMAError paramEMAError)
  {
    return nativeChangeChatroomDescription(paramString1, paramString2, paramEMAError);
  }
  
  public EMAChatRoom changeChatroomSubject(String paramString1, String paramString2, EMAError paramEMAError)
  {
    return nativeChangeChatroomSubject(paramString1, paramString2, paramEMAError);
  }
  
  public void clearListeners()
  {
    nativeClearListeners();
  }
  
  public EMAChatRoom createChatRoom(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, List<String> paramList, EMAError paramEMAError)
  {
    return nativeCreateChatRoom(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramList, paramEMAError);
  }
  
  public void destroyChatroom(String paramString, EMAError paramEMAError)
  {
    nativeDestroyChatroom(paramString, paramEMAError);
  }
  
  public List<EMAChatRoom> fetchAllChatrooms(EMAError paramEMAError)
  {
    return nativeFetchAllChatrooms(paramEMAError);
  }
  
  public String fetchChatRoomAnnouncement(String paramString, EMAError paramEMAError)
  {
    return nativeFetchChatroomAnnouncement(paramString, paramEMAError);
  }
  
  public List<String> fetchChatRoomBlackList(String paramString, int paramInt1, int paramInt2, EMAError paramEMAError)
  {
    return nativeFetchChatRoomBlackList(paramString, paramInt1, paramInt2, paramEMAError);
  }
  
  public Map<String, Long> fetchChatRoomMuteList(String paramString, int paramInt1, int paramInt2, EMAError paramEMAError)
  {
    return nativeFetchChatroomMutes(paramString, paramInt1, paramInt2, paramEMAError);
  }
  
  public EMCursorResult<String> fetchChatroomMembers(String paramString1, String paramString2, int paramInt, EMAError paramEMAError)
  {
    return nativeFetchChatroomMembers(paramString1, paramString2, paramInt, paramEMAError);
  }
  
  public EMAChatRoom fetchChatroomSpecification(String paramString, EMAError paramEMAError, boolean paramBoolean)
  {
    return nativeFetchChatroomSpecification(paramString, paramEMAError, paramBoolean);
  }
  
  public EMCursorResult<EMAChatRoom> fetchChatroomsWithCursor(String paramString, int paramInt, EMAError paramEMAError)
  {
    return nativeFetchChatroomsWithCursor(paramString, paramInt, paramEMAError);
  }
  
  public EMPageResult<EMAChatRoom> fetchChatroomsWithPage(int paramInt1, int paramInt2, EMAError paramEMAError)
  {
    return nativefetchChatroomsWithPage(paramInt1, paramInt2, paramEMAError);
  }
  
  public EMAChatRoom getChatroom(String paramString)
  {
    return nativeGetChatroom(paramString);
  }
  
  public EMAChatRoom joinChatRoom(String paramString, EMAError paramEMAError)
  {
    return nativeJoinChatRoom(paramString, paramEMAError);
  }
  
  public void leaveChatRoom(String paramString, EMAError paramEMAError)
  {
    nativeLeaveChatRoom(paramString, paramEMAError);
  }
  
  public EMAChatRoom muteChatroomMembers(String paramString, List<String> paramList, long paramLong, EMAError paramEMAError)
  {
    return nativeMuteChatroomMembers(paramString, paramList, paramLong, paramEMAError);
  }
  
  native EMAChatRoom nativeAddChatroomAdmin(String paramString1, String paramString2, EMAError paramEMAError);
  
  native void nativeAddListener(EMAChatRoomManagerListener paramEMAChatRoomManagerListener);
  
  native EMAChatRoom nativeBlockChatroomMembers(String paramString, List<String> paramList, EMAError paramEMAError);
  
  native EMAChatRoom nativeChangeChatroomDescription(String paramString1, String paramString2, EMAError paramEMAError);
  
  native EMAChatRoom nativeChangeChatroomSubject(String paramString1, String paramString2, EMAError paramEMAError);
  
  native void nativeClearListeners();
  
  native EMAChatRoom nativeCreateChatRoom(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, List<String> paramList, EMAError paramEMAError);
  
  native void nativeDestroyChatroom(String paramString, EMAError paramEMAError);
  
  native List<EMAChatRoom> nativeFetchAllChatrooms(EMAError paramEMAError);
  
  native List<String> nativeFetchChatRoomBlackList(String paramString, int paramInt1, int paramInt2, EMAError paramEMAError);
  
  native String nativeFetchChatroomAnnouncement(String paramString, EMAError paramEMAError);
  
  native EMCursorResult<String> nativeFetchChatroomMembers(String paramString1, String paramString2, int paramInt, EMAError paramEMAError);
  
  native Map<String, Long> nativeFetchChatroomMutes(String paramString, int paramInt1, int paramInt2, EMAError paramEMAError);
  
  native EMAChatRoom nativeFetchChatroomSpecification(String paramString, EMAError paramEMAError, boolean paramBoolean);
  
  native EMCursorResult<EMAChatRoom> nativeFetchChatroomsWithCursor(String paramString, int paramInt, EMAError paramEMAError);
  
  native EMAChatRoom nativeGetChatroom(String paramString);
  
  native EMAChatRoom nativeJoinChatRoom(String paramString, EMAError paramEMAError);
  
  native void nativeLeaveChatRoom(String paramString, EMAError paramEMAError);
  
  native EMAChatRoom nativeMuteChatroomMembers(String paramString, List<String> paramList, long paramLong, EMAError paramEMAError);
  
  native EMAChatRoom nativeRemoveChatRoomMembers(String paramString, List<String> paramList, EMAError paramEMAError);
  
  native EMAChatRoom nativeRemoveChatroomAdmin(String paramString1, String paramString2, EMAError paramEMAError);
  
  native void nativeRemoveListener(EMAChatRoomManagerListener paramEMAChatRoomManagerListener);
  
  native EMAChatRoom nativeTransferChatroomOwner(String paramString1, String paramString2, EMAError paramEMAError);
  
  native EMAChatRoom nativeUnblockChatroomMembers(String paramString, List<String> paramList, EMAError paramEMAError);
  
  native EMAChatRoom nativeUnmuteChatroomMembers(String paramString, List<String> paramList, EMAError paramEMAError);
  
  native void nativeUpdateChatroomAnnouncement(String paramString1, String paramString2, EMAError paramEMAError);
  
  native EMPageResult<EMAChatRoom> nativefetchChatroomsWithPage(int paramInt1, int paramInt2, EMAError paramEMAError);
  
  public EMAChatRoom removeChatRoomAdmin(String paramString1, String paramString2, EMAError paramEMAError)
  {
    return nativeRemoveChatroomAdmin(paramString1, paramString2, paramEMAError);
  }
  
  public EMAChatRoom removeChatRoomMembers(String paramString, List<String> paramList, EMAError paramEMAError)
  {
    return nativeRemoveChatRoomMembers(paramString, paramList, paramEMAError);
  }
  
  public void removeListener(EMAChatRoomManagerListener paramEMAChatRoomManagerListener)
  {
    nativeRemoveListener(paramEMAChatRoomManagerListener);
  }
  
  public EMAChatRoom transferChatroomOwner(String paramString1, String paramString2, EMAError paramEMAError)
  {
    return nativeTransferChatroomOwner(paramString1, paramString2, paramEMAError);
  }
  
  public EMAChatRoom unblockChatRoomMembers(String paramString, List<String> paramList, EMAError paramEMAError)
  {
    return nativeUnblockChatroomMembers(paramString, paramList, paramEMAError);
  }
  
  public EMAChatRoom unmuteChatRoomMembers(String paramString, List<String> paramList, EMAError paramEMAError)
  {
    return nativeUnmuteChatroomMembers(paramString, paramList, paramEMAError);
  }
  
  public void updateChatRoomAnnouncement(String paramString1, String paramString2, EMAError paramEMAError)
  {
    nativeUpdateChatroomAnnouncement(paramString1, paramString2, paramEMAError);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/EMAChatRoomManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */