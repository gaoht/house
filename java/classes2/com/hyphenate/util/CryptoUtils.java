package com.hyphenate.util;

import android.util.Base64;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class CryptoUtils
{
  public static final int ALGORIGHM_AES = 1;
  public static final int ALGORIGHM_DES = 0;
  static final String HEXES = "0123456789ABCDEF";
  Cipher cipher = null;
  Cipher decipher = null;
  String key = "TongliforniaJohnson";
  byte[] keyBytes = { 74, 111, 104, 110, 115, 111, 110, 77, 97, 74, 105, 70, 97, 110, 103, 74, 101, 114, 118, 105, 115, 76, 105, 117, 76, 105, 117, 83, 104, 97, 111, 90 };
  
  public static byte[] fromHexString(String paramString)
  {
    int j = paramString.length();
    byte[] arrayOfByte = new byte[j / 2];
    int i = 0;
    while (i < j)
    {
      arrayOfByte[(i / 2)] = ((byte)((Character.digit(paramString.charAt(i), 16) << 4) + Character.digit(paramString.charAt(i + 1), 16)));
      i += 2;
    }
    return arrayOfByte;
  }
  
  public static String getHex(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfByte[i];
      localStringBuilder.append("0123456789ABCDEF".charAt((k & 0xF0) >> 4)).append("0123456789ABCDEF".charAt(k & 0xF));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public byte[] decrypt(byte[] paramArrayOfByte)
    throws Exception
  {
    return this.decipher.doFinal(paramArrayOfByte);
  }
  
  public String decryptBase64String(String paramString)
    throws Exception
  {
    return new String(decrypt(Base64.decode(paramString, 0)), "UTF-8");
  }
  
  public byte[] encrypt(String paramString)
    throws Exception
  {
    paramString = paramString.getBytes("UTF-8");
    return this.cipher.doFinal(paramString);
  }
  
  public byte[] encrypt(byte[] paramArrayOfByte)
    throws Exception
  {
    return this.cipher.doFinal(paramArrayOfByte);
  }
  
  public String encryptBase64String(String paramString)
    throws Exception
  {
    return new String(Base64.encode(encrypt(paramString), 0));
  }
  
  public void init(int paramInt)
  {
    if (paramInt == 0)
    {
      initDES();
      return;
    }
    initAES();
  }
  
  public void initAES()
  {
    try
    {
      this.cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
      SecretKeySpec localSecretKeySpec = new SecretKeySpec(this.keyBytes, "AES");
      this.cipher.init(1, localSecretKeySpec);
      this.decipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
      this.decipher.init(2, localSecretKeySpec);
      EMLog.d("encrypt", "initital for AES");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void initDES()
  {
    try
    {
      this.keyBytes = Arrays.copyOf(MessageDigest.getInstance("md5").digest(this.key.getBytes("utf-8")), 24);
      int j = 16;
      int i = 0;
      while (i < 8)
      {
        this.keyBytes[j] = this.keyBytes[i];
        j += 1;
        i += 1;
      }
      SecretKeySpec localSecretKeySpec = new SecretKeySpec(this.keyBytes, "DESede");
      IvParameterSpec localIvParameterSpec = new IvParameterSpec(new byte[8]);
      this.cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
      this.cipher.init(1, localSecretKeySpec, localIvParameterSpec);
      this.decipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
      this.decipher.init(2, localSecretKeySpec, localIvParameterSpec);
      EMLog.d("encrypt", "initital for DES");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/util/CryptoUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */