package com.hyphenate.chat.adapter;

import java.util.List;

public abstract class EMAChatRoomManagerListener
  extends EMABase
  implements EMAChatRoomManagerListenerInterface
{
  public static final int BE_KICKED = 0;
  public static final int DESTROYED = 1;
  
  public EMAChatRoomManagerListener()
  {
    nativeInit();
  }
  
  public void finalize()
    throws Throwable
  {
    nativeFinalize();
    super.finalize();
  }
  
  native void nativeFinalize();
  
  native void nativeInit();
  
  public void onAddAdmin(EMAChatRoom paramEMAChatRoom, String paramString) {}
  
  public void onAddMuteList(EMAChatRoom paramEMAChatRoom, List<String> paramList, long paramLong) {}
  
  public void onAnnouncementChanged(EMAChatRoom paramEMAChatRoom, String paramString) {}
  
  public void onLeaveChatRoom(EMAChatRoom paramEMAChatRoom, int paramInt) {}
  
  public void onMemberJoinedChatRoom(EMAChatRoom paramEMAChatRoom, String paramString) {}
  
  public void onMemberLeftChatRoom(EMAChatRoom paramEMAChatRoom, String paramString) {}
  
  public void onOwnerChanged(EMAChatRoom paramEMAChatRoom, String paramString1, String paramString2) {}
  
  public void onRemoveAdmin(EMAChatRoom paramEMAChatRoom, String paramString) {}
  
  public void onRemoveMutes(EMAChatRoom paramEMAChatRoom, List<String> paramList) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/EMAChatRoomManagerListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */