package com.freelxl.baselibrary.f.a;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;

public class b
{
  private Cipher a = null;
  private Cipher b = null;
  
  public static String byteArr2HexStr(byte[] paramArrayOfByte)
  {
    int k = paramArrayOfByte.length;
    StringBuilder localStringBuilder = new StringBuilder(k * 2);
    int i = 0;
    while (i < k)
    {
      int j = paramArrayOfByte[i];
      while (j < 0) {
        j += 256;
      }
      if (j < 16) {
        localStringBuilder.append("0");
      }
      localStringBuilder.append(Integer.toString(j, 16));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static byte[] hexStr2ByteArr(String paramString)
  {
    paramString = paramString.getBytes();
    int j = paramString.length;
    byte[] arrayOfByte = new byte[j / 2];
    int i = 0;
    while (i < j)
    {
      String str = new String(paramString, i, 2);
      arrayOfByte[(i / 2)] = ((byte)Integer.parseInt(str, 16));
      i += 2;
    }
    return arrayOfByte;
  }
  
  public String decrypt(String paramString)
    throws IllegalBlockSizeException, BadPaddingException
  {
    return new String(decrypt(hexStr2ByteArr(paramString)));
  }
  
  public byte[] decrypt(byte[] paramArrayOfByte)
    throws IllegalBlockSizeException, BadPaddingException
  {
    return this.b.doFinal(paramArrayOfByte);
  }
  
  public String encrypt(String paramString)
    throws IllegalBlockSizeException, BadPaddingException
  {
    return byteArr2HexStr(encrypt(paramString.getBytes()));
  }
  
  public byte[] encrypt(byte[] paramArrayOfByte)
    throws IllegalBlockSizeException, BadPaddingException
  {
    return this.a.doFinal(paramArrayOfByte);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/f/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */