package com.baidu.trace.c;

import android.text.TextUtils;

public final class d
{
  static
  {
    "0123456789abcdef".getBytes();
  }
  
  public static short a(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte == null) || (2 > paramArrayOfByte.length)) {
      return 0;
    }
    return (short)(paramArrayOfByte[0] << 8 | paramArrayOfByte[1] & 0xFF);
  }
  
  public static byte[] a(String paramString)
  {
    if (paramString == null) {
      return new byte[0];
    }
    return paramString.getBytes();
  }
  
  public static byte[] b(String paramString)
  {
    int i = 6;
    byte[] arrayOfByte = new byte[6];
    if (TextUtils.isEmpty(paramString)) {
      return arrayOfByte;
    }
    for (;;)
    {
      try
      {
        paramString = paramString.split(":");
        if (6 <= paramString.length)
        {
          break label67;
          if (j < i)
          {
            arrayOfByte[j] = ((byte)Integer.parseInt(paramString[j], 16));
            j += 1;
            continue;
          }
        }
        else
        {
          i = paramString.length;
        }
      }
      catch (Exception paramString) {}
      return arrayOfByte;
      label67:
      int j = 0;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */