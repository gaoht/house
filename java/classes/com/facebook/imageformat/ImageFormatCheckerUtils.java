package com.facebook.imageformat;

import com.facebook.common.internal.Preconditions;
import java.io.UnsupportedEncodingException;

public class ImageFormatCheckerUtils
{
  public static byte[] asciiBytes(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    try
    {
      paramString = paramString.getBytes("ASCII");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("ASCII not found!", paramString);
    }
  }
  
  public static boolean startsWithPattern(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    Preconditions.checkNotNull(paramArrayOfByte1);
    Preconditions.checkNotNull(paramArrayOfByte2);
    if (paramArrayOfByte2.length > paramArrayOfByte1.length) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfByte2.length) {
        break label43;
      }
      if (paramArrayOfByte1[i] != paramArrayOfByte2[i]) {
        break;
      }
      i += 1;
    }
    label43:
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imageformat/ImageFormatCheckerUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */