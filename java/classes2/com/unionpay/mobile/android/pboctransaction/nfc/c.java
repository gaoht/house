package com.unionpay.mobile.android.pboctransaction.nfc;

public final class c
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  public static String a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    char[] arrayOfChar = new char[paramInt * 2];
    int j = 0;
    while (i < paramInt + 0)
    {
      int k = paramArrayOfByte[i];
      int m = j + 1;
      arrayOfChar[j] = a[(k >> 4 & 0xF)];
      j = m + 1;
      arrayOfChar[m] = a[(k & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pboctransaction/nfc/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */