package com.hyphenate.chat.adapter;

import android.util.Base64;
import com.hyphenate.util.EMLog;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.X509EncodedKeySpec;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class EMAREncryptUtils
{
  public static final String TAG = "EMAREncryptUtils";
  Cipher cipher;
  Cipher decipher;
  
  public static byte[] b64Decode(String paramString)
  {
    return Base64.decode(paramString, 0);
  }
  
  public static String b64Encode(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte.length;
    if (paramInt == B64_ENCODE_FLAG.ONESDK_B64_NO_WRAP.ordinal()) {}
    for (paramInt = 2;; paramInt = 0) {
      return Base64.encodeToString(paramArrayOfByte, 0, i, paramInt);
    }
  }
  
  public static byte[] encryptByRSAPublicKey(String paramString, byte[] paramArrayOfByte, AtomicBoolean paramAtomicBoolean)
  {
    paramString = Base64.decode(paramString.replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", "").replace("\n", "").getBytes(), 2);
    try
    {
      paramString = new X509EncodedKeySpec(paramString);
      paramString = KeyFactory.getInstance("RSA").generatePublic(paramString);
      EMLog.d("EMAREncryptUtils", "publicKey.getFormat:" + paramString.getFormat());
      Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      localCipher.init(1, paramString);
      paramString = localCipher.doFinal(paramArrayOfByte);
      paramAtomicBoolean.set(true);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      EMLog.d("EMAREncryptUtils", paramString.getStackTrace().toString());
    }
    return null;
  }
  
  public static byte[] generateAESKey()
  {
    try
    {
      Object localObject = KeyGenerator.getInstance("AES");
      ((KeyGenerator)localObject).init(128);
      localObject = ((KeyGenerator)localObject).generateKey().getEncoded();
      return (byte[])localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      localNoSuchAlgorithmException.printStackTrace();
    }
    return null;
  }
  
  public static String messageDigest(int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject = null;
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localObject = localMessageDigest;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    paramArrayOfByte = ((MessageDigest)localObject).digest(paramArrayOfByte);
    localObject = new StringBuffer();
    paramInt = 0;
    while (paramInt < paramArrayOfByte.length)
    {
      int i = paramArrayOfByte[paramInt] & 0xFF;
      if (i < 16) {
        ((StringBuffer)localObject).append("0");
      }
      ((StringBuffer)localObject).append(Integer.toHexString(i));
      paramInt += 1;
    }
    return ((StringBuffer)localObject).toString();
  }
  
  public String aesDecrypt(String paramString)
  {
    try
    {
      paramString = b64Decode(paramString);
      paramString = new String(this.decipher.doFinal(paramString));
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      EMLog.d("EMAREncryptUtils", paramString.getStackTrace().toString());
    }
    return null;
  }
  
  public byte[] aesDecryptInner(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = this.decipher.doFinal(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      EMLog.d("EMAREncryptUtils", paramArrayOfByte.getStackTrace().toString());
    }
    return null;
  }
  
  public String aesEncrypt(String paramString, int paramInt)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      paramString = b64Encode(this.cipher.doFinal(paramString), paramInt);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      EMLog.d("EMAREncryptUtils", paramString.getStackTrace().toString());
    }
    return null;
  }
  
  public byte[] aesEncryptInner(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = this.cipher.doFinal(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      EMLog.d("EMAREncryptUtils", paramArrayOfByte.getStackTrace().toString());
    }
    return null;
  }
  
  public void initAES(byte[] paramArrayOfByte)
  {
    initAEScbc(paramArrayOfByte);
  }
  
  public void initAEScbc(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new SecretKeySpec(paramArrayOfByte, "AES");
      IvParameterSpec localIvParameterSpec1 = new IvParameterSpec("0000000000000000".getBytes());
      IvParameterSpec localIvParameterSpec2 = new IvParameterSpec("0000000000000000".getBytes());
      this.cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      this.cipher.init(1, paramArrayOfByte, localIvParameterSpec1);
      this.decipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      this.decipher.init(2, paramArrayOfByte, localIvParameterSpec2);
      EMLog.d("encrypt", "init for AES cbc");
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      EMLog.d("EMAREncryptUtils", paramArrayOfByte.getStackTrace().toString());
    }
  }
  
  public void initAESecb(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new SecretKeySpec(paramArrayOfByte, "AES");
      this.cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
      this.cipher.init(1, paramArrayOfByte);
      this.decipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
      this.decipher.init(2, paramArrayOfByte);
      EMLog.d("encrypt", "init for AES ecb");
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      EMLog.d("EMAREncryptUtils", paramArrayOfByte.getStackTrace().toString());
    }
  }
  
  public void unInitAES() {}
  
  static enum B64_ENCODE_FLAG
  {
    ONESDK_B64_DEFAULT,  ONESDK_B64_NO_WRAP;
    
    private B64_ENCODE_FLAG() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/adapter/EMAREncryptUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */