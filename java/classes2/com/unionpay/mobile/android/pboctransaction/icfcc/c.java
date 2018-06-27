package com.unionpay.mobile.android.pboctransaction.icfcc;

import com.unionpay.mobile.android.pboctransaction.e;

public final class c
{
  public static String a(String paramString1, String paramString2)
  {
    int k = 1;
    if (paramString1 == null) {
      return null;
    }
    paramString1 = e.a(paramString1);
    int i = 0;
    if (i < paramString1.length) {
      if ((byte)(paramString1[i] & 0x1F) != 31) {
        break label484;
      }
    }
    label474:
    label484:
    for (int j = 2;; j = 1)
    {
      byte[] arrayOfByte = new byte[j];
      System.arraycopy(paramString1, i, arrayOfByte, 0, j);
      int m;
      if (e.a(arrayOfByte, j).compareToIgnoreCase(paramString2) == 0)
      {
        m = j + i;
        if ((byte)(paramString1[m] & 0x80) != Byte.MIN_VALUE)
        {
          i = paramString1[m] & 0xFF;
          j = k;
        }
      }
      for (;;)
      {
        paramString2 = new byte[i];
        System.arraycopy(paramString1, m + j, paramString2, 0, i);
        return e.a(paramString2, i);
        j = (paramString1[m] & 0x7F) + 1;
        if (j == 2)
        {
          i = paramString1[(m + 1)] & 0xFF;
        }
        else if (j == 3)
        {
          i = (paramString1[(m + 1)] & 0xFF) << 8 | paramString1[(m + 2)] & 0xFF;
        }
        else if (j == 4)
        {
          i = (paramString1[(m + 1)] & 0xFF) << 16 | (paramString1[(m + 2)] & 0xFF) << 8 | paramString1[(m + 3)] & 0xFF;
          continue;
          if ((paramString1[i] & 0x20) == 32)
          {
            j += i;
            if ((j >= paramString1.length) || ((byte)(paramString1[j] & 0x80) != Byte.MIN_VALUE)) {
              break label474;
            }
          }
          for (i = (paramString1[j] & 0x7F) + 1;; i = 1)
          {
            i += j;
            break;
            m = i + j;
            if ((m < paramString1.length) && ((byte)(paramString1[m] & 0x80) == 0))
            {
              i = paramString1[m] & 0xFF;
              j = 1;
              i = i + j + m;
              break;
            }
            if (m < paramString1.length) {}
            for (j = (paramString1[m] & 0x7F) + 1;; j = 0)
            {
              if ((j == 2) && (m + 1 < paramString1.length))
              {
                i = paramString1[(m + 1)] & 0xFF;
                break;
              }
              if ((j == 3) && (m + 2 < paramString1.length))
              {
                i = (paramString1[(m + 1)] & 0xFF) << 8 | paramString1[(m + 2)] & 0xFF;
                break;
              }
              if ((j == 4) && (m + 2 < paramString1.length))
              {
                i = (paramString1[(m + 1)] & 0xFF) << 16 | (paramString1[(m + 2)] & 0xFF) << 8 | paramString1[(m + 3)] & 0xFF;
                break;
                return null;
              }
              i = 0;
              break;
            }
          }
        }
        else
        {
          i = 0;
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pboctransaction/icfcc/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */