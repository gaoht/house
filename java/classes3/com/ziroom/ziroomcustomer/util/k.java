package com.ziroom.ziroomcustomer.util;

import java.security.Key;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class k
{
  public static String decrypt(String paramString)
  {
    try
    {
      IvParameterSpec localIvParameterSpec = new IvParameterSpec("EbpU4WtY".getBytes());
      Object localObject = new DESKeySpec("vpRZ1kmU".getBytes());
      localObject = SecretKeyFactory.getInstance("DES").generateSecret((KeySpec)localObject);
      Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      localCipher.init(2, (Key)localObject, localIvParameterSpec);
      paramString = new String(localCipher.doFinal(l.hexStr2ByteArr(paramString)), "utf-8");
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String encrypt(String paramString)
  {
    try
    {
      IvParameterSpec localIvParameterSpec = new IvParameterSpec("EbpU4WtY".getBytes());
      Object localObject = new DESKeySpec("vpRZ1kmU".getBytes());
      localObject = SecretKeyFactory.getInstance("DES").generateSecret((KeySpec)localObject);
      Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      localCipher.init(1, (Key)localObject, localIvParameterSpec);
      paramString = l.byteArr2HexStr(localCipher.doFinal(paramString.getBytes("utf-8")));
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/util/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */