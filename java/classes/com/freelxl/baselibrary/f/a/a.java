package com.freelxl.baselibrary.f.a;

import com.freelxl.baselibrary.f.f;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class a
  implements d
{
  public String decrypt(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      if (f.isNull(paramString1)) {
        return null;
      }
      paramString2 = new IvParameterSpec(paramString2.getBytes());
      paramString3 = new DESKeySpec(paramString3.getBytes());
      paramString3 = SecretKeyFactory.getInstance("DES").generateSecret(paramString3);
      Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      localCipher.init(2, paramString3, paramString2);
      paramString1 = new String(localCipher.doFinal(b.hexStr2ByteArr(paramString1)), "utf-8");
      return paramString1;
    }
    catch (Exception paramString1)
    {
      com.freelxl.baselibrary.f.d.e("DESEncrypt", "ENCRYPT ERROR:" + paramString1);
    }
    return null;
  }
  
  public String encrypt(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      if (f.isNull(paramString1)) {
        return null;
      }
      paramString2 = new IvParameterSpec(paramString2.getBytes());
      paramString3 = new DESKeySpec(paramString3.getBytes());
      paramString3 = SecretKeyFactory.getInstance("DES").generateSecret(paramString3);
      Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      localCipher.init(1, paramString3, paramString2);
      paramString1 = b.byteArr2HexStr(localCipher.doFinal(paramString1.getBytes("utf-8")));
      return paramString1;
    }
    catch (Exception paramString1)
    {
      com.freelxl.baselibrary.f.d.e("DESEncrypt", "ENCRYPT ERROR:" + paramString1);
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/f/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */