package com.ziroom.ziroomcustomer.minsu.e;

import android.util.Base64;
import com.ziroom.ziroomcustomer.util.ae;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;

public class e
{
  public static String appendSourceType(String paramString)
  {
    paramString = new StringBuilder(paramString);
    if (paramString.toString().contains("?")) {
      paramString.append("&");
    }
    for (;;)
    {
      paramString.append("sourceType").append("=").append("1");
      return paramString.toString();
      paramString.append("?");
    }
  }
  
  public static String bytes2Hex(byte[] paramArrayOfByte)
  {
    String str1 = "";
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str3 = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      String str2 = str1;
      if (str3.length() == 1) {
        str2 = str1 + "0";
      }
      str1 = str2 + str3;
      i += 1;
    }
    return str1;
  }
  
  public static String convertStr(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new String(paramString1.getBytes(), paramString2);
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public static String convertUrl(String paramString)
  {
    Object localObject1 = "";
    Object localObject2;
    if (paramString.contains("#"))
    {
      localObject2 = paramString.substring(paramString.indexOf("#"));
      localObject1 = new StringBuilder(paramString.substring(0, paramString.indexOf("#")));
      paramString = (String)localObject2;
    }
    for (;;)
    {
      Object localObject3 = d.getUid();
      String str1 = d.getToken();
      String str2 = System.currentTimeMillis() / 1000L + "";
      String str3 = createNoncestr(4);
      localObject2 = localObject3;
      if (ae.isNull((String)localObject3)) {
        localObject2 = "";
      }
      localObject3 = str1;
      if (ae.isNull(str1)) {
        localObject3 = "";
      }
      str1 = getSign(new String[] { localObject2, localObject3, "1", str2, str3 });
      if (((StringBuilder)localObject1).toString().contains("?")) {
        ((StringBuilder)localObject1).append("&");
      }
      try
      {
        for (;;)
        {
          localObject2 = new String(Base64.encode(((String)localObject2).getBytes(), 0), "utf-8");
          ((StringBuilder)localObject1).append("dWlk").append("=").append(((String)localObject2).replace("\n", ""));
          ((StringBuilder)localObject1).append("&");
          ((StringBuilder)localObject1).append("token").append("=").append((String)localObject3);
          ((StringBuilder)localObject1).append("&");
          ((StringBuilder)localObject1).append("sourceType").append("=").append("1");
          ((StringBuilder)localObject1).append("&").append("versionCode").append("=").append(100032);
          ((StringBuilder)localObject1).append("&");
          ((StringBuilder)localObject1).append("timestamp").append("=").append(str2);
          ((StringBuilder)localObject1).append("&");
          ((StringBuilder)localObject1).append("echostr").append("=").append(str3);
          ((StringBuilder)localObject1).append("&");
          ((StringBuilder)localObject1).append("signature").append("=").append(str1);
          return ((StringBuilder)localObject1).toString() + paramString;
          localObject2 = new StringBuilder(paramString);
          paramString = (String)localObject1;
          localObject1 = localObject2;
          break;
          ((StringBuilder)localObject1).append("?");
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          localUnsupportedEncodingException.printStackTrace();
        }
      }
    }
  }
  
  public static String convertUrl(String paramString1, String paramString2)
  {
    Object localObject1 = "";
    Object localObject2;
    if (paramString1.contains("#"))
    {
      localObject2 = paramString1.substring(paramString1.indexOf("#"));
      localObject1 = new StringBuilder(paramString1.substring(0, paramString1.indexOf("#")));
      paramString1 = (String)localObject2;
    }
    for (;;)
    {
      String str4 = d.getUid();
      localObject2 = d.getToken();
      String str1 = System.currentTimeMillis() / 1000L + "";
      String str2 = createNoncestr(4);
      String str3 = getSign(new String[] { str4, localObject2, "1", str1, str2 });
      if (((StringBuilder)localObject1).toString().contains("?")) {
        ((StringBuilder)localObject1).append("&");
      }
      try
      {
        for (;;)
        {
          str4 = new String(Base64.encode(str4.getBytes(), 0), "utf-8");
          ((StringBuilder)localObject1).append("dWlk").append("=").append(str4.replace("\n", ""));
          ((StringBuilder)localObject1).append("&");
          ((StringBuilder)localObject1).append("token").append("=").append((String)localObject2);
          ((StringBuilder)localObject1).append("&");
          ((StringBuilder)localObject1).append("sourceType").append("=").append("1");
          ((StringBuilder)localObject1).append("&").append("versionCode").append("=").append(100032);
          ((StringBuilder)localObject1).append("&").append("userUid").append("=").append(paramString2);
          ((StringBuilder)localObject1).append("&");
          ((StringBuilder)localObject1).append("timestamp").append("=").append(str1);
          ((StringBuilder)localObject1).append("&");
          ((StringBuilder)localObject1).append("echostr").append("=").append(str2);
          ((StringBuilder)localObject1).append("&");
          ((StringBuilder)localObject1).append("signature").append("=").append(str3);
          return ((StringBuilder)localObject1).toString() + paramString1;
          localObject2 = new StringBuilder(paramString1);
          paramString1 = (String)localObject1;
          localObject1 = localObject2;
          break;
          ((StringBuilder)localObject1).append("?");
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          localUnsupportedEncodingException.printStackTrace();
        }
      }
    }
  }
  
  public static String createNoncestr(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramInt)
    {
      localStringBuffer.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(new Random().nextInt("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".length() - 1)));
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String encrypt(String paramString)
  {
    paramString = paramString.getBytes();
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      localMessageDigest.update(paramString);
      paramString = bytes2Hex(localMessageDigest.digest());
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      System.out.println("Invalid algorithm.");
    }
    return null;
  }
  
  public static String getSign(String[] paramArrayOfString)
  {
    Arrays.sort(paramArrayOfString);
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      localStringBuffer.append(paramArrayOfString[i]);
      i += 1;
    }
    return encrypt(localStringBuffer.toString()).toUpperCase();
  }
  
  public static String getUUID()
  {
    return UUID.randomUUID().toString().replaceAll("-", "");
  }
  
  public static boolean isNullStr(String paramString)
  {
    return (paramString == null) || (paramString.trim().length() <= 0);
  }
  
  public static String killNull(Object paramObject)
  {
    if (paramObject == null) {
      return "";
    }
    return paramObject.toString().trim();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/e/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */