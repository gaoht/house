package com.xiaomi.channel.commonutils.string;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

public class d
{
  public static String a(int paramInt)
  {
    Random localRandom = new Random();
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramInt)
    {
      localStringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charAt(localRandom.nextInt("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".length())));
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String a(String paramString)
  {
    if (paramString != null) {}
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(c(paramString));
      localObject = String.format("%1$032X", new Object[] { new BigInteger(1, ((MessageDigest)localObject).digest()) });
      return (String)localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
    return "";
    return paramString;
  }
  
  public static String a(Collection<?> paramCollection, String paramString)
  {
    if (paramCollection == null) {
      return null;
    }
    return a(paramCollection.iterator(), paramString);
  }
  
  public static String a(Iterator<?> paramIterator, String paramString)
  {
    if (paramIterator == null) {
      return null;
    }
    if (!paramIterator.hasNext()) {
      return "";
    }
    Object localObject = paramIterator.next();
    if (!paramIterator.hasNext()) {
      return localObject.toString();
    }
    StringBuffer localStringBuffer = new StringBuffer(256);
    if (localObject != null) {
      localStringBuffer.append(localObject);
    }
    while (paramIterator.hasNext())
    {
      if (paramString != null) {
        localStringBuffer.append(paramString);
      }
      localObject = paramIterator.next();
      if (localObject != null) {
        localStringBuffer.append(localObject);
      }
    }
    return localStringBuffer.toString();
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    String str = "";
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = String.format("%1$032X", new Object[] { new BigInteger(1, localMessageDigest.digest()) });
      return paramArrayOfByte.toLowerCase();
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte = str;
      }
    }
  }
  
  public static String b(String paramString)
  {
    if (paramString != null) {}
    try
    {
      Object localObject = MessageDigest.getInstance("SHA1");
      ((MessageDigest)localObject).update(c(paramString));
      localObject = String.format("%1$032X", new Object[] { new BigInteger(1, ((MessageDigest)localObject).digest()) });
      return (String)localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
    return null;
    return paramString;
  }
  
  public static byte[] c(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("UTF-8");
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return paramString.getBytes();
  }
  
  public static boolean d(String paramString)
  {
    if (paramString != null)
    {
      int i = 0;
      while (i < paramString.length())
      {
        int j = paramString.charAt(i);
        if ((j < 0) || (j > 127)) {
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/channel/commonutils/string/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */