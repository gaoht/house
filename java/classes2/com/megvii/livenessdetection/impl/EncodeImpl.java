package com.megvii.livenessdetection.impl;

import android.util.Base64;

public class EncodeImpl
{
  public static byte[] a(byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    return a(paramArrayOfByte, paramBoolean1, paramBoolean2, paramInt, null);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    byte[] arrayOfByte;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      arrayOfByte = null;
    }
    do
    {
      return arrayOfByte;
      if ((paramBoolean1) || (paramBoolean2)) {
        break;
      }
      arrayOfByte = paramArrayOfByte;
    } while (paramString == null);
    if (paramInt < 0) {
      return null;
    }
    paramArrayOfByte = nativeEncode(paramArrayOfByte, paramBoolean1, paramBoolean2, paramInt, paramString);
    if (paramArrayOfByte == null) {
      return null;
    }
    return Base64.decode(paramArrayOfByte, 0);
  }
  
  private static native String nativeEncode(byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/livenessdetection/impl/EncodeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */