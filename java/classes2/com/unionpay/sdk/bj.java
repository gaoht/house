package com.unionpay.sdk;

import android.util.Base64;
import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

final class bj
{
  private static final byte[] a = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  
  static String a(String paramString)
  {
    try
    {
      SecretKeySpec localSecretKeySpec = c(d.a(d.c));
      byte[] arrayOfByte = a;
      paramString = paramString.getBytes("UTF-8");
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
      localCipher.init(1, localSecretKeySpec, new IvParameterSpec(arrayOfByte));
      paramString = Base64.encodeToString(localCipher.doFinal(paramString), 2);
      return paramString;
    }
    catch (Throwable paramString)
    {
      boolean bool = ag.a;
    }
    return null;
  }
  
  static String b(String paramString)
  {
    try
    {
      Object localObject = o.a();
      if (localObject == null) {}
      for (localObject = c(d.a(d.c));; localObject = new SecretKeySpec(Base64.decode((String)localObject, 2), "AES"))
      {
        paramString = Base64.decode(paramString, 2);
        byte[] arrayOfByte = a;
        Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        localCipher.init(2, (Key)localObject, new IvParameterSpec(arrayOfByte));
        return new String(localCipher.doFinal(paramString), "UTF-8");
      }
      return null;
    }
    catch (Throwable paramString)
    {
      if (ag.a) {
        paramString.printStackTrace();
      }
    }
  }
  
  private static SecretKeySpec c(String paramString)
  {
    Object localObject = o.a();
    if (localObject != null) {
      return new SecretKeySpec(Base64.decode((String)localObject, 2), "AES");
    }
    localObject = MessageDigest.getInstance("SHA-256");
    paramString = paramString.getBytes("UTF-8");
    ((MessageDigest)localObject).update(paramString, 0, paramString.length);
    paramString = ((MessageDigest)localObject).digest();
    localObject = Base64.encodeToString(paramString, 2);
    if (d.c != null) {
      l.a(d.c, "UPpref_longtime", "UPaes_key", (String)localObject);
    }
    return new SecretKeySpec(paramString, "AES");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */