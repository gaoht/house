package com.ziroom.ziroomcustomer.util;

import javax.crypto.Cipher;

public class l
{
  private Cipher a = null;
  private Cipher b = null;
  
  public l()
    throws Exception
  {}
  
  public static String byteArr2HexStr(byte[] paramArrayOfByte)
    throws Exception
  {
    int k = paramArrayOfByte.length;
    StringBuffer localStringBuffer = new StringBuffer(k * 2);
    int i = 0;
    while (i < k)
    {
      int j = paramArrayOfByte[i];
      while (j < 0) {
        j += 256;
      }
      if (j < 16) {
        localStringBuffer.append("0");
      }
      localStringBuffer.append(Integer.toString(j, 16));
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static byte[] hexStr2ByteArr(String paramString)
    throws Exception
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
    throws Exception
  {
    return new String(decrypt(hexStr2ByteArr(paramString)));
  }
  
  public byte[] decrypt(byte[] paramArrayOfByte)
    throws Exception
  {
    return this.b.doFinal(paramArrayOfByte);
  }
  
  public String encrypt(String paramString)
    throws Exception
  {
    return byteArr2HexStr(encrypt(paramString.getBytes()));
  }
  
  public byte[] encrypt(byte[] paramArrayOfByte)
    throws Exception
  {
    return this.a.doFinal(paramArrayOfByte);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/util/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */