package com.hyphenate.chat;

import com.hyphenate.EMCallBack;
import com.hyphenate.EMChatRoomChangeListener;
import com.hyphenate.EMValueCallBack;
import com.hyphenate.chat.adapter.EMAChatRoom;
import com.hyphenate.chat.adapter.EMAChatRoomManager;
import com.hyphenate.chat.adapter.EMAChatRoomManagerListener;
import com.hyphenate.chat.adapter.EMAError;
import com.hyphenate.exceptions.HyphenateException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EMChatRoomManager
{
  EMAChatRoomManagerListener chatRoomListenerImpl = new EMChatRoomManager.6(this);
  private List<EMChatRoomChangeListener> chatRoomListeners = Collections.synchronizedList(new ArrayList());
  private List<EMChatRoom> chatRooms = Collections.synchronizedList(new ArrayList());
  EMAChatRoomManager emaObject;
  EMClient mClient;
  private ExecutorService threadPool = null;
  
  public EMChatRoomManager(EMClient paramEMClient, EMAChatRoomManager paramEMAChatRoomManager)
  {
    this.emaObject = paramEMAChatRoomManager;
    this.emaObject.addListener(this.chatRoomListenerImpl);
    this.mClient = paramEMClient;
    this.threadPool = Executors.newCachedThreadPool();
  }
  
  private void handleError(EMAError paramEMAError)
    throws HyphenateException
  {
    if (paramEMAError.errCode() != 0) {
      throw new HyphenateException(paramEMAError);
    }
  }
  
  public EMChatRoom addChatRoomAdmin(String paramString1, String paramString2)
    throws HyphenateException
  {
    EMAError localEMAError = new EMAError();
    paramString1 = this.emaObject.addChatroomAdmin(paramString1, paramString2, localEMAError);
    handleError(localEMAError);
    return new EMChatRoom(paramString1);
  }
  
  public void addChatRoomChangeListener(EMChatRoomChangeListener paramEMChatRoomChangeListener)
  {
    this.chatRoomListeners.add(paramEMChatRoomChangeListener);
  }
  
  public void asyncAddChatRoomAdmin(String paramString1, String paramString2, EMValueCallBack<EMChatRoom> paramEMValueCallBack)
  {
    EMClient.getInstance().execute(new EMChatRoomManager.15(this, paramEMValueCallBack, paramString1, paramString2));
  }
  
  public void asyncBlockChatroomMembers(String paramString, List<String> paramList, EMValueCallBack<EMChatRoom> paramEMValueCallBack)
  {
    EMClient.getInstance().execute(new EMChatRoomManager.19(this, paramEMValueCallBack, paramString, paramList));
  }
  
  public void asyncChangeChatRoomSubject(String paramString1, String paramString2, EMValueCallBack<EMChatRoom> paramEMValueCallBack)
  {
    EMClient.getInstance().execute(new EMChatRoomManager.9(this, paramEMValueCallBack, paramString1, paramString2));
  }
  
  public void asyncChangeChatroomDescription(String paramString1, String paramString2, EMValueCallBack<EMChatRoom> paramEMValueCallBack)
  {
    EMClient.getInstance().execute(new EMChatRoomManager.10(this, paramEMValueCallBack, paramString1, paramString2));
  }
  
  public void asyncChangeOwner(String paramString1, String paramString2, EMValueCallBack<EMChatRoom> paramEMValueCallBack)
    throws HyphenateException
  {
    EMClient.getInstance().execute(new EMChatRoomManager.14(this, paramEMValueCallBack, paramString1, paramString2));
  }
  
  public void asyncCreateChatRoom(String paramString1, String paramString2, String paramString3, int paramInt, List<String> paramList, EMValueCallBack<EMChatRoom> paramEMValueCallBack)
  {
    EMClient.getInstance().execute(new EMChatRoomManager.7(this, paramEMValueCallBack, paramString1, paramString2, paramString3, paramInt, paramList));
  }
  
  public void asyncDestroyChatRoom(String paramString, EMCallBack paramEMCallBack)
  {
    EMClient.getInstance().execute(new EMChatRoomManager.8(this, paramString, paramEMCallBack));
  }
  
  public void asyncFetchChatRoomAnnouncement(String paramString, EMValueCallBack<String> paramEMValueCallBack)
  {
    EMClient.getInstance().execute(new EMChatRoomManager.23(this, paramEMValueCallBack, paramString));
  }
  
  public void asyncFetchChatRoomBlackList(String paramString, int paramInt1, int paramInt2, EMValueCallBack<List<String>> paramEMValueCallBack)
  {
    EMClient.getInstance().execute(new EMChatRoomManager.21(this, paramEMValueCallBack, paramString, paramInt1, paramInt2));
  }
  
  public void asyncFetchChatRoomFromServer(String paramString, EMValueCallBack<EMChatRoom> paramEMValueCallBack)
  {
    EMClient.getInstance().execute(new EMChatRoomManager.5(this, paramString, paramEMValueCallBack));
  }
  
  public void asyncFetchChatRoomMembers(String paramString1, String paramString2, int paramInt, EMValueCallBack<EMCursorResult<String>> paramEMValueCallBack)
  {
    EMClient.getInstance().execute(new EMChatRoomManager.11(this, paramEMValueCallBack, paramString1, paramString2, paramInt));
  }
  
  public void asyncFetchChatRoomMuteList(String paramString, int paramInt1, int paramInt2, EMValueCallBack<Map<String, Long>> paramEMValueCallBack)
  {
    EMClient.getInstance().execute(new EMChatRoomManager.17(this, paramEMValueCallBack, paramString, paramInt1, paramInt2));
  }
  
  public void asyncFetchPublicChatRoomsFromServer(int paramInt1, int paramInt2, EMValueCallBack<EMPageResult<EMChatRoom>> paramEMValueCallBack)
  {
    EMClient.getInstance().execute(new EMChatRoomManager.4(this, paramInt1, paramInt2, paramEMValueCallBack));
  }
  
  public void asyncFetchPublicChatRoomsFromServer(int paramInt, String paramString, EMValueCallBack<EMCursorResult<EMChatRoom>> paramEMValueCallBack)
  {
    EMClient.getInstance().execute(new EMChatRoomManager.3(this, paramInt, paramString, paramEMValueCallBack));
  }
  
  public void asyncMuteChatRoomMembers(String paramString, List<String> paramList, long paramLong, EMValueCallBack<EMChatRoom> paramEMValueCallBack)
  {
    EMClient.getInstance().execute(new EMChatRoomManager.12(this, paramEMValueCallBack, paramString, paramList, paramLong));
  }
  
  public void asyncRemoveChatRoomAdmin(String paramString1, String paramString2, EMValueCallBack<EMChatRoom> paramEMValueCallBack)
  {
    EMClient.getInstance().execute(new EMChatRoomManager.16(this, paramEMValueCallBack, paramString1, paramString2));
  }
  
  public void asyncRemoveChatRoomMembers(String paramString, List<String> paramList, EMValueCallBack<EMChatRoom> paramEMValueCallBack)
  {
    EMClient.getInstance().execute(new EMChatRoomManager.18(this, paramEMValueCallBack, paramString, paramList));
  }
  
  public void asyncUnBlockChatRoomMembers(String paramString, List<String> paramList, EMValueCallBack<EMChatRoom> paramEMValueCallBack)
  {
    EMClient.getInstance().execute(new EMChatRoomManager.20(this, paramEMValueCallBack, paramString, paramList));
  }
  
  public void asyncUnMuteChatRoomMembers(String paramString, List<String> paramList, EMValueCallBack<EMChatRoom> paramEMValueCallBack)
  {
    EMClient.getInstance().execute(new EMChatRoomManager.13(this, paramEMValueCallBack, paramString, paramList));
  }
  
  public void asyncUpdateChatRoomAnnouncement(String paramString1, String paramString2, EMCallBack paramEMCallBack)
  {
    EMClient.getInstance().execute(new EMChatRoomManager.22(this, paramString1, paramString2, paramEMCallBack));
  }
  
  public EMChatRoom blockChatroomMembers(String paramString, List<String> paramList)
    throws HyphenateException
  {
    EMAError localEMAError = new EMAError();
    paramString = this.emaObject.blockChatroomMembers(paramString, paramList, localEMAError);
    handleError(localEMAError);
    return new EMChatRoom(paramString);
  }
  
  public EMChatRoom changeChatRoomSubject(String paramString1, String paramString2)
    throws HyphenateException
  {
    EMAError localEMAError = new EMAError();
    paramString1 = this.emaObject.changeChatroomSubject(paramString1, paramString2, localEMAError);
    handleError(localEMAError);
    return new EMChatRoom(paramString1);
  }
  
  public EMChatRoom changeChatroomDescription(String paramString1, String paramString2)
    throws HyphenateException
  {
    EMAError localEMAError = new EMAError();
    paramString1 = this.emaObject.changeChatroomDescription(paramString1, paramString2, localEMAError);
    handleError(localEMAError);
    return new EMChatRoom(paramString1);
  }
  
  public EMChatRoom changeOwner(String paramString1, String paramString2)
    throws HyphenateException
  {
    EMAError localEMAError = new EMAError();
    paramString1 = this.emaObject.transferChatroomOwner(paramString1, paramString2, localEMAError);
    handleError(localEMAError);
    return new EMChatRoom(paramString1);
  }
  
  public EMChatRoom createChatRoom(String paramString1, String paramString2, String paramString3, int paramInt, List<String> paramList)
    throws HyphenateException
  {
    EMAError localEMAError = new EMAError();
    paramString1 = this.emaObject.createChatRoom(paramString1, paramString2, paramString3, EMChatRoom.EMChatRoomStyle.EMChatRoomStylePublicOpenJoin.ordinal(), paramInt, paramList, localEMAError);
    handleError(localEMAError);
    return new EMChatRoom(paramString1);
  }
  
  public void destroyChatRoom(String paramString)
    throws HyphenateException
  {
    EMAError localEMAError = new EMAError();
    this.emaObject.destroyChatroom(paramString, localEMAError);
    handleError(localEMAError);
  }
  
  public String fetchChatRoomAnnouncement(String paramString)
    throws HyphenateException
  {
    EMAError localEMAError = new EMAError();
    paramString = this.emaObject.fetchChatRoomAnnouncement(paramString, localEMAError);
    handleError(localEMAError);
    return paramString;
  }
  
  public List<String> fetchChatRoomBlackList(String paramString, int paramInt1, int paramInt2)
    throws HyphenateException
  {
    EMAError localEMAError = new EMAError();
    paramString = this.emaObject.fetchChatRoomBlackList(paramString, paramInt1, paramInt2, localEMAError);
    handleError(localEMAError);
    return paramString;
  }
  
  public EMChatRoom fetchChatRoomFromServer(String paramString)
    throws HyphenateException
  {
    return fetchChatRoomFromServer(paramString, false);
  }
  
  public EMChatRoom fetchChatRoomFromServer(String paramString, boolean paramBoolean)
    throws HyphenateException
  {
    EMAError localEMAError = new EMAError();
    paramString = this.emaObject.fetchChatroomSpecification(paramString, localEMAError, paramBoolean);
    handleError(localEMAError);
    return new EMChatRoom(paramString);
  }
  
  public EMCursorResult<String> fetchChatRoomMembers(String paramString1, String paramString2, int paramInt)
    throws HyphenateException
  {
    EMAError localEMAError = new EMAError();
    paramString1 = this.emaObject.fetchChatroomMembers(paramString1, paramString2, paramInt, localEMAError);
    handleError(localEMAError);
    return paramString1;
  }
  
  public Map<String, Long> fetchChatRoomMuteList(String paramString, int paramInt1, int paramInt2)
    throws HyphenateException
  {
    EMAError localEMAError = new EMAError();
    paramString = this.emaObject.fetchChatRoomMuteList(paramString, paramInt1, paramInt2, localEMAError);
    handleError(localEMAError);
    return paramString;
  }
  
  public EMCursorResult<EMChatRoom> fetchPublicChatRoomsFromServer(int paramInt, String paramString)
    throws HyphenateException
  {
    Object localObject = new EMAError();
    paramString = this.emaObject.fetchChatroomsWithCursor(paramString, paramInt, (EMAError)localObject);
    handleError((EMAError)localObject);
    localObject = new EMCursorResult();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((List)paramString.getData()).iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(new EMChatRoom((EMAChatRoom)localIterator.next()));
    }
    ((EMCursorResult)localObject).setCursor(paramString.getCursor());
    ((EMCursorResult)localObject).setData(localArrayList);
    this.chatRooms.clear();
    this.chatRooms.addAll(localArrayList);
    return (EMCursorResult<EMChatRoom>)localObject;
  }
  
  public EMPageResult<EMChatRoom> fetchPublicChatRoomsFromServer(int paramInt1, int paramInt2)
    throws HyphenateException
  {
    Object localObject = new EMAError();
    EMPageResult localEMPageResult = this.emaObject.fetchChatroomsWithPage(paramInt1, paramInt2, (EMAError)localObject);
    handleError((EMAError)localObject);
    localObject = (List)localEMPageResult.getData();
    paramInt1 = localEMPageResult.getPageCount();
    localEMPageResult = new EMPageResult();
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(new EMChatRoom((EMAChatRoom)((Iterator)localObject).next()));
    }
    localEMPageResult.setPageCount(paramInt1);
    localEMPageResult.setData(localArrayList);
    this.chatRooms.clear();
    this.chatRooms.addAll(localArrayList);
    return localEMPageResult;
  }
  
  public List<EMChatRoom> getAllChatRooms()
  {
    return Collections.unmodifiableList(this.chatRooms);
  }
  
  public EMChatRoom getChatRoom(String paramString)
  {
    paramString = this.emaObject.getChatroom(paramString);
    if (paramString == null) {
      return null;
    }
    return new EMChatRoom(paramString);
  }
  
  public void joinChatRoom(String paramString, EMValueCallBack<EMChatRoom> paramEMValueCallBack)
  {
    this.threadPool.submit(new EMChatRoomManager.1(this, paramString, paramEMValueCallBack));
  }
  
  public void leaveChatRoom(String paramString)
  {
    Object localObject = getChatRoom(paramString);
    if (localObject == null) {}
    boolean bool;
    do
    {
      return;
      bool = EMClient.getInstance().getOptions().isChatroomOwnerLeaveAllowed();
      localObject = ((EMChatRoom)localObject).getOwner();
    } while ((!bool) && (((String)localObject).equals(EMSessionManager.getInstance().getLastLoginUser())));
    EMClient.getInstance().chatManager().deleteConversation(paramString, true);
    this.threadPool.submit(new EMChatRoomManager.2(this, paramString));
  }
  
  public EMChatRoom muteChatRoomMembers(String paramString, List<String> paramList, long paramLong)
    throws HyphenateException
  {
    EMAError localEMAError = new EMAError();
    paramString = this.emaObject.muteChatroomMembers(paramString, paramList, paramLong, localEMAError);
    handleError(localEMAError);
    return new EMChatRoom(paramString);
  }
  
  void onLogout()
  {
    this.chatRoomListeners.clear();
  }
  
  public EMChatRoom removeChatRoomAdmin(String paramString1, String paramString2)
    throws HyphenateException
  {
    EMAError localEMAError = new EMAError();
    paramString1 = this.emaObject.removeChatRoomAdmin(paramString1, paramString2, localEMAError);
    handleError(localEMAError);
    return new EMChatRoom(paramString1);
  }
  
  @Deprecated
  public void removeChatRoomChangeListener(EMChatRoomChangeListener paramEMChatRoomChangeListener)
  {
    removeChatRoomListener(paramEMChatRoomChangeListener);
  }
  
  public void removeChatRoomListener(EMChatRoomChangeListener paramEMChatRoomChangeListener)
  {
    this.chatRoomListeners.remove(paramEMChatRoomChangeListener);
  }
  
  public EMChatRoom removeChatRoomMembers(String paramString, List<String> paramList)
    throws HyphenateException
  {
    EMAError localEMAError = new EMAError();
    paramString = this.emaObject.removeChatRoomMembers(paramString, paramList, localEMAError);
    handleError(localEMAError);
    return new EMChatRoom(paramString);
  }
  
  public EMChatRoom unMuteChatRoomMembers(String paramString, List<String> paramList)
    throws HyphenateException
  {
    EMAError localEMAError = new EMAError();
    paramString = this.emaObject.unmuteChatRoomMembers(paramString, paramList, localEMAError);
    handleError(localEMAError);
    return new EMChatRoom(paramString);
  }
  
  public EMChatRoom unblockChatRoomMembers(String paramString, List<String> paramList)
    throws HyphenateException
  {
    EMAError localEMAError = new EMAError();
    paramString = this.emaObject.unblockChatRoomMembers(paramString, paramList, localEMAError);
    handleError(localEMAError);
    return new EMChatRoom(paramString);
  }
  
  public void updateChatRoomAnnouncement(String paramString1, String paramString2)
    throws HyphenateException
  {
    EMAError localEMAError = new EMAError();
    this.emaObject.updateChatRoomAnnouncement(paramString1, paramString2, localEMAError);
    handleError(localEMAError);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/hyphenate/chat/EMChatRoomManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */