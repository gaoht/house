package com.hyphenate.exceptions;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

public class EMExceptionUtils
{
  public static int fromExceptionToErrorCode(Exception paramException)
  {
    if ((paramException instanceof NoSuchAlgorithmException)) {}
    while (((paramException instanceof UnrecoverableKeyException)) || ((paramException instanceof KeyManagementException))) {
      return 503;
    }
    if (paramException.getMessage().contains("User removed")) {
      return 207;
    }
    if (paramException.getMessage().contains("conflict")) {
      return 206;
    }
    return 1;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/exceptions/EMExceptionUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */