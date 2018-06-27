package com.xiaomi.channel.commonutils.string;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class c
{
  private static String a(byte paramByte)
  {
    int i;
    StringBuilder localStringBuilder;
    if (paramByte < 0)
    {
      i = 128;
      paramByte = (paramByte & 0x7F) + i;
      localStringBuilder = new StringBuilder();
      if (paramByte >= 16) {
        break label56;
      }
    }
    label56:
    for (String str = "0";; str = "")
    {
      return str + Integer.toHexString(paramByte).toLowerCase();
      i = 0;
      break;
    }
  }
  
  public static String a(String paramString)
  {
    int i = 0;
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      StringBuffer localStringBuffer = new StringBuffer();
      localMessageDigest.update(paramString.getBytes(), 0, paramString.length());
      paramString = localMessageDigest.digest();
      while (i < paramString.length)
      {
        localStringBuffer.append(a(paramString[i]));
        i += 1;
      }
      return localStringBuffer.toString();
    }
    catch (NoSuchAlgorithmException paramString)
    {
      return null;
    }
  }
  
  public static String b(String paramString)
  {
    return a(paramString).subSequence(8, 24).toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/channel/commonutils/string/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */