package com.hyphenate.util;

import android.content.Context;
import java.text.DecimalFormat;

public class TextFormater
{
  private static final int GB_SP_DIFF = 160;
  private static final char[] firstLetter = { 97, 98, 99, 100, 101, 102, 103, 104, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 119, 120, 121, 122 };
  private static final int[] secPosvalueList = { 1601, 1637, 1833, 2078, 2274, 2302, 2433, 2594, 2787, 3106, 3212, 3472, 3635, 3722, 3730, 3858, 4027, 4086, 4390, 4558, 4684, 4925, 5249, 5600 };
  
  private static char convert(byte[] paramArrayOfByte)
  {
    int j = 0;
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      paramArrayOfByte[i] = ((byte)(paramArrayOfByte[i] - 160));
      i += 1;
    }
    int k = paramArrayOfByte[0] * 100 + paramArrayOfByte[1];
    i = j;
    while (i < 23)
    {
      if ((k >= secPosvalueList[i]) && (k < secPosvalueList[(i + 1)])) {
        return firstLetter[i];
      }
      i += 1;
    }
    return '-';
  }
  
  public static String formatStr(Context paramContext, int paramInt, String paramString)
  {
    return String.format(paramContext.getText(paramInt).toString(), new Object[] { paramString });
  }
  
  public static String getDataSize(long paramLong)
  {
    DecimalFormat localDecimalFormat = new DecimalFormat("###.00");
    if (paramLong < 0L) {
      return "error";
    }
    if (paramLong < 1024L) {
      return paramLong + "bytes";
    }
    if (paramLong < 1048576L) {
      return localDecimalFormat.format((float)paramLong / 1024.0F) + "KB";
    }
    if (paramLong < 1073741824L) {
      return localDecimalFormat.format((float)paramLong / 1024.0F / 1024.0F) + "MB";
    }
    return localDecimalFormat.format((float)paramLong / 1024.0F / 1024.0F / 1024.0F) + "GB";
  }
  
  public static String getFirstLetter(String paramString)
  {
    paramString = paramString.toLowerCase();
    StringBuilder localStringBuilder = new StringBuilder();
    int j = 0;
    if (j < paramString.length())
    {
      int i = paramString.charAt(j);
      char[] arrayOfChar = new char[1];
      arrayOfChar[0] = i;
      byte[] arrayOfByte = new String(arrayOfChar).getBytes();
      if ((arrayOfByte[0] < 128) && (arrayOfByte[0] > 0)) {
        localStringBuilder.append(arrayOfChar);
      }
      for (;;)
      {
        j += 1;
        break;
        localStringBuilder.append(convert(arrayOfByte));
      }
    }
    return localStringBuilder.toString().substring(0, 1);
  }
  
  public static String getKBDataSize(long paramLong)
  {
    DecimalFormat localDecimalFormat = new DecimalFormat("###.00");
    if (paramLong < 1024L) {
      return paramLong + "KB";
    }
    if (paramLong < 1048576L) {
      return localDecimalFormat.format((float)paramLong / 1024.0F) + "MB";
    }
    if (paramLong < 1073741824L) {
      return localDecimalFormat.format((float)paramLong / 1024.0F / 1024.0F) + "GB";
    }
    return "error";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/util/TextFormater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */