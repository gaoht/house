package com.ziroom.commonlib.utils;

import android.annotation.SuppressLint;

@SuppressLint({"InlinedApi"})
public final class o
{
  private static final String[] a = { "android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR" };
  private static final String[] b = { "android.permission.CAMERA" };
  private static final String[] c = { "android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS", "android.permission.GET_ACCOUNTS" };
  private static final String[] d = { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" };
  private static final String[] e = { "android.permission.RECORD_AUDIO" };
  private static final String[] f = { "android.permission.READ_PHONE_STATE", "android.permission.READ_PHONE_NUMBERS", "android.permission.CALL_PHONE", "android.permission.ANSWER_PHONE_CALLS", "android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG", "com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission.USE_SIP", "android.permission.PROCESS_OUTGOING_CALLS" };
  private static final String[] g = { "android.permission.BODY_SENSORS" };
  private static final String[] h = { "android.permission.SEND_SMS", "android.permission.RECEIVE_SMS", "android.permission.READ_SMS", "android.permission.RECEIVE_WAP_PUSH", "android.permission.RECEIVE_MMS" };
  private static final String[] i = { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" };
  
  public static String[] getPermissions(String paramString)
  {
    int j = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (j)
      {
      default: 
        return new String[] { paramString };
        if (paramString.equals("android.permission-group.CALENDAR"))
        {
          j = 0;
          continue;
          if (paramString.equals("android.permission-group.CAMERA"))
          {
            j = 1;
            continue;
            if (paramString.equals("android.permission-group.CONTACTS"))
            {
              j = 2;
              continue;
              if (paramString.equals("android.permission-group.LOCATION"))
              {
                j = 3;
                continue;
                if (paramString.equals("android.permission-group.MICROPHONE"))
                {
                  j = 4;
                  continue;
                  if (paramString.equals("android.permission-group.PHONE"))
                  {
                    j = 5;
                    continue;
                    if (paramString.equals("android.permission-group.SENSORS"))
                    {
                      j = 6;
                      continue;
                      if (paramString.equals("android.permission-group.SMS"))
                      {
                        j = 7;
                        continue;
                        if (paramString.equals("android.permission-group.STORAGE")) {
                          j = 8;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    return a;
    return b;
    return c;
    return d;
    return e;
    return f;
    return g;
    return h;
    return i;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlib/utils/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */