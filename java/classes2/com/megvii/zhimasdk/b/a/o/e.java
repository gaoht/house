package com.megvii.zhimasdk.b.a.o;

import com.megvii.zhimasdk.b.a.c;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public final class e
{
  public static String a(byte[] paramArrayOfByte)
  {
    a.a(paramArrayOfByte, "Input");
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    a.a(paramArrayOfByte, "Input");
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, paramInt1, paramInt2, c.b.name());
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      throw new Error("ASCII not supported");
    }
  }
  
  public static byte[] a(String paramString)
  {
    a.a(paramString, "Input");
    try
    {
      paramString = paramString.getBytes(c.b.name());
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new Error("ASCII not supported");
    }
  }
  
  public static byte[] a(String paramString1, String paramString2)
  {
    a.a(paramString1, "Input");
    a.a(paramString2, "Charset");
    try
    {
      paramString2 = paramString1.getBytes(paramString2);
      return paramString2;
    }
    catch (UnsupportedEncodingException paramString2) {}
    return paramString1.getBytes();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/o/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */