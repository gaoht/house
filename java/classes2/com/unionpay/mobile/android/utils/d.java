package com.unionpay.mobile.android.utils;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class d
{
  private static byte[] a(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws GeneralSecurityException
  {
    if ((paramArrayOfByte1 == null) || ((paramArrayOfByte1.length != 8) && (paramArrayOfByte1.length != 16) && (paramArrayOfByte1.length != 24))) {
      throw new IllegalArgumentException();
    }
    if (paramArrayOfByte2 == null) {
      throw new IllegalArgumentException();
    }
    Cipher localCipher = Cipher.getInstance("DESede/ECB/NoPadding");
    byte[] arrayOfByte = new byte[24];
    if (paramArrayOfByte1.length == 8)
    {
      System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, 8);
      System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 8, 8);
      System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 16, 8);
      paramArrayOfByte1 = paramArrayOfByte2;
      if (paramArrayOfByte2.length % 8 != 0)
      {
        paramArrayOfByte1 = new byte[(paramArrayOfByte2.length / 8 + 1) * 8];
        System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, 0, paramArrayOfByte2.length);
        Arrays.fill(paramArrayOfByte1, paramArrayOfByte2.length, paramArrayOfByte1.length, (byte)0);
      }
      if (paramInt == 0) {
        break label209;
      }
    }
    label209:
    for (paramInt = 1;; paramInt = 2)
    {
      localCipher.init(paramInt, new SecretKeySpec(arrayOfByte, "DESede"));
      return localCipher.doFinal(paramArrayOfByte1);
      if (paramArrayOfByte1.length == 16)
      {
        System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, 16);
        System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 16, 8);
        break;
      }
      System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, 24);
      break;
    }
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws GeneralSecurityException
  {
    return a(1, paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws GeneralSecurityException
  {
    return a(0, paramArrayOfByte1, paramArrayOfByte2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/utils/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */