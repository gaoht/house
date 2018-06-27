package com.huawei.hms.support.api.push.a.a.a;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public abstract class a
{
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    try
    {
      byte[] arrayOfByte = a();
      if (arrayOfByte.length == 0) {
        return "";
      }
      SecretKeySpec localSecretKeySpec = new SecretKeySpec(arrayOfByte, "AES");
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      SecureRandom localSecureRandom = new SecureRandom();
      arrayOfByte = new byte[16];
      localSecureRandom.nextBytes(arrayOfByte);
      localCipher.init(1, localSecretKeySpec, new IvParameterSpec(arrayOfByte));
      paramString = localCipher.doFinal(paramString.getBytes("UTF-8"));
      paramString = a(com.huawei.hms.support.api.push.a.a.a.a(arrayOfByte), com.huawei.hms.support.api.push.a.a.a.a(paramString));
      return paramString;
    }
    catch (IllegalArgumentException paramString)
    {
      if (com.huawei.hms.support.api.push.a.b.e()) {
        com.huawei.hms.support.api.push.a.b.d("AES128_CBC", "IllegalArgumentException aes cbc encrypter data error" + paramString.getMessage());
      }
      return null;
    }
    catch (InvalidKeyException paramString)
    {
      for (;;)
      {
        if (com.huawei.hms.support.api.push.a.b.e()) {
          com.huawei.hms.support.api.push.a.b.d("AES128_CBC", "InvalidKeyException aes cbc encrypter data error" + paramString.getMessage());
        }
      }
    }
    catch (InvalidAlgorithmParameterException paramString)
    {
      for (;;)
      {
        if (com.huawei.hms.support.api.push.a.b.e()) {
          com.huawei.hms.support.api.push.a.b.d("AES128_CBC", "InvalidAlgorithmParameterException aes cbc encrypter data error" + paramString.getMessage());
        }
      }
    }
    catch (IllegalBlockSizeException paramString)
    {
      for (;;)
      {
        if (com.huawei.hms.support.api.push.a.b.e()) {
          com.huawei.hms.support.api.push.a.b.d("AES128_CBC", "IllegalBlockSizeException aes cbc encrypter data error" + paramString.getMessage());
        }
      }
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        if (com.huawei.hms.support.api.push.a.b.e()) {
          com.huawei.hms.support.api.push.a.b.d("AES128_CBC", "UnsupportedEncodingException aes cbc encrypter data error" + paramString.getMessage());
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        if (com.huawei.hms.support.api.push.a.b.e()) {
          com.huawei.hms.support.api.push.a.b.d("AES128_CBC", "aes cbc encrypter data error" + paramString.getMessage());
        }
      }
    }
  }
  
  private static String a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return "";
    }
    try
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(paramString2.substring(0, 6));
      localStringBuffer.append(paramString1.substring(0, 6));
      localStringBuffer.append(paramString2.substring(6, 10));
      localStringBuffer.append(paramString1.substring(6, 16));
      localStringBuffer.append(paramString2.substring(10, 16));
      localStringBuffer.append(paramString1.substring(16));
      localStringBuffer.append(paramString2.substring(16));
      paramString1 = localStringBuffer.toString();
      return paramString1;
    }
    catch (Exception paramString1)
    {
      if (com.huawei.hms.support.api.push.a.b.e()) {
        com.huawei.hms.support.api.push.a.b.d("AES128_CBC", paramString1.getMessage());
      }
    }
    return "";
  }
  
  private static byte[] a()
  {
    byte[] arrayOfByte1 = com.huawei.hms.support.api.push.a.a.a.b(com.huawei.hms.support.api.push.a.a.b.a());
    byte[] arrayOfByte2 = com.huawei.hms.support.api.push.a.a.a.b(b.a());
    byte[] arrayOfByte3 = com.huawei.hms.support.api.push.a.a.a.b("2A57086C86EF54970C1E6EB37BFC72B1");
    return a(a(a(arrayOfByte1, arrayOfByte2), arrayOfByte3));
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
  {
    int i = 0;
    byte[] arrayOfByte;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      arrayOfByte = new byte[0];
      return arrayOfByte;
    }
    for (;;)
    {
      arrayOfByte = paramArrayOfByte;
      if (i >= paramArrayOfByte.length) {
        break;
      }
      paramArrayOfByte[i] = ((byte)(paramArrayOfByte[i] >> 2));
      i += 1;
    }
  }
  
  private static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = 0;
    Object localObject;
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null) || (paramArrayOfByte1.length == 0) || (paramArrayOfByte2.length == 0))
    {
      localObject = new byte[0];
      return (byte[])localObject;
    }
    int j = paramArrayOfByte1.length;
    if (j != paramArrayOfByte2.length) {
      return new byte[0];
    }
    byte[] arrayOfByte = new byte[j];
    for (;;)
    {
      localObject = arrayOfByte;
      if (i >= j) {
        break;
      }
      arrayOfByte[i] = ((byte)(paramArrayOfByte1[i] ^ paramArrayOfByte2[i]));
      i += 1;
    }
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    try
    {
      Object localObject = a();
      if (localObject.length == 0) {
        return "";
      }
      localObject = new SecretKeySpec((byte[])localObject, "AES");
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      String str = c(paramString);
      paramString = d(paramString);
      if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramString)))
      {
        if (com.huawei.hms.support.api.push.a.b.c()) {
          com.huawei.hms.support.api.push.a.b.b("AES128_CBC", "ivParameter or encrypedWord is null");
        }
      }
      else
      {
        localCipher.init(2, (Key)localObject, new IvParameterSpec(com.huawei.hms.support.api.push.a.a.a.b(str)));
        paramString = new String(localCipher.doFinal(com.huawei.hms.support.api.push.a.a.a.b(paramString)), "UTF-8");
        return paramString;
      }
    }
    catch (IllegalArgumentException paramString)
    {
      if (com.huawei.hms.support.api.push.a.b.e()) {
        com.huawei.hms.support.api.push.a.b.a("AES128_CBC", "aes cbc decrypter data error", paramString);
      }
      return "";
    }
    catch (InvalidKeyException paramString)
    {
      for (;;)
      {
        if (com.huawei.hms.support.api.push.a.b.e()) {
          com.huawei.hms.support.api.push.a.b.a("AES128_CBC", "aes cbc decrypter data error", paramString);
        }
      }
    }
    catch (InvalidAlgorithmParameterException paramString)
    {
      for (;;)
      {
        if (com.huawei.hms.support.api.push.a.b.e()) {
          com.huawei.hms.support.api.push.a.b.a("AES128_CBC", "aes cbc decrypter data error", paramString);
        }
      }
    }
    catch (IllegalBlockSizeException paramString)
    {
      for (;;)
      {
        if (com.huawei.hms.support.api.push.a.b.e()) {
          com.huawei.hms.support.api.push.a.b.a("AES128_CBC", "aes cbc decrypter data error", paramString);
        }
      }
    }
    catch (BadPaddingException paramString)
    {
      for (;;)
      {
        if (com.huawei.hms.support.api.push.a.b.e()) {
          com.huawei.hms.support.api.push.a.b.a("AES128_CBC", "aes cbc decrypter data error", paramString);
        }
      }
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        if (com.huawei.hms.support.api.push.a.b.e()) {
          com.huawei.hms.support.api.push.a.b.a("AES128_CBC", "aes cbc decrypter data error", paramString);
        }
      }
    }
    catch (NoSuchAlgorithmException paramString)
    {
      for (;;)
      {
        if (com.huawei.hms.support.api.push.a.b.e()) {
          com.huawei.hms.support.api.push.a.b.a("AES128_CBC", "aes cbc decrypter data error", paramString);
        }
      }
    }
    catch (NoSuchPaddingException paramString)
    {
      for (;;)
      {
        if (com.huawei.hms.support.api.push.a.b.e()) {
          com.huawei.hms.support.api.push.a.b.a("AES128_CBC", "aes cbc decrypter data error", paramString);
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        if (com.huawei.hms.support.api.push.a.b.e()) {
          com.huawei.hms.support.api.push.a.b.a("AES128_CBC", "aes cbc encrypter data error", paramString);
        }
      }
    }
    return "";
  }
  
  private static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    try
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(paramString.substring(6, 12));
      localStringBuffer.append(paramString.substring(16, 26));
      localStringBuffer.append(paramString.substring(32, 48));
      paramString = localStringBuffer.toString();
      return paramString;
    }
    catch (Exception paramString)
    {
      if (com.huawei.hms.support.api.push.a.b.e()) {
        com.huawei.hms.support.api.push.a.b.d("AES128_CBC", "get iv error:" + paramString.getMessage());
      }
    }
    return "";
  }
  
  private static String d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    try
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(paramString.substring(0, 6));
      localStringBuffer.append(paramString.substring(12, 16));
      localStringBuffer.append(paramString.substring(26, 32));
      localStringBuffer.append(paramString.substring(48));
      paramString = localStringBuffer.toString();
      return paramString;
    }
    catch (Exception paramString)
    {
      if (com.huawei.hms.support.api.push.a.b.e()) {
        com.huawei.hms.support.api.push.a.b.d("AES128_CBC", "get encrypt word error:" + paramString.getMessage());
      }
    }
    return "";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/huawei/hms/support/api/push/a/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */