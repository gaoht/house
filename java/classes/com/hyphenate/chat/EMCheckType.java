package com.hyphenate.chat;

import java.lang.annotation.Annotation;

public class EMCheckType
{
  public static final int ACCOUNT_VALIDATION = 0;
  public static final int DO_LOGIN = 3;
  public static final int DO_LOGOUT = 5;
  public static final int DO_MSG_SEND = 4;
  public static final int GET_DNS_LIST_FROM_SERVER = 1;
  public static final int GET_TOKEN_FROM_SERVER = 2;
  
  public static @interface CheckType {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/hyphenate/chat/EMCheckType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */