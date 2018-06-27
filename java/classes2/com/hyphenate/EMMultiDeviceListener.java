package com.hyphenate;

import java.util.List;

public abstract interface EMMultiDeviceListener
{
  public static final int CONTACT_ACCEPT = 3;
  public static final int CONTACT_ALLOW = 6;
  public static final int CONTACT_BAN = 5;
  public static final int CONTACT_DECLINE = 4;
  public static final int CONTACT_REMOVE = 2;
  public static final int GROUP_ADD_ADMIN = 26;
  public static final int GROUP_ADD_MUTE = 28;
  public static final int GROUP_ALLOW = 22;
  public static final int GROUP_APPLY = 14;
  public static final int GROUP_APPLY_ACCEPT = 15;
  public static final int GROUP_APPLY_DECLINE = 16;
  public static final int GROUP_ASSIGN_OWNER = 25;
  public static final int GROUP_BAN = 21;
  public static final int GROUP_BLOCK = 23;
  public static final int GROUP_CREATE = 10;
  public static final int GROUP_DESTROY = 11;
  public static final int GROUP_INVITE = 17;
  public static final int GROUP_INVITE_ACCEPT = 18;
  public static final int GROUP_INVITE_DECLINE = 19;
  public static final int GROUP_JOIN = 12;
  public static final int GROUP_KICK = 20;
  public static final int GROUP_LEAVE = 13;
  public static final int GROUP_REMOVE_ADMIN = 27;
  public static final int GROUP_REMOVE_MUTE = 29;
  public static final int GROUP_UNBLOCK = 24;
  
  public abstract void onContactEvent(int paramInt, String paramString1, String paramString2);
  
  public abstract void onGroupEvent(int paramInt, String paramString, List<String> paramList);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/EMMultiDeviceListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */