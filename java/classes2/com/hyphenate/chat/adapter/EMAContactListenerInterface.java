package com.hyphenate.chat.adapter;

public abstract interface EMAContactListenerInterface
{
  public abstract void onContactAdded(String paramString);
  
  public abstract void onContactAgreed(String paramString);
  
  public abstract void onContactDeleted(String paramString);
  
  public abstract void onContactInvited(String paramString1, String paramString2);
  
  public abstract void onContactRefused(String paramString);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/EMAContactListenerInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */