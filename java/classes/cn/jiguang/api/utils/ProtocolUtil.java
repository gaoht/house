package cn.jiguang.api.utils;

import cn.jiguang.api.JResponse;
import cn.jiguang.d.d;
import cn.jiguang.f.h;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class ProtocolUtil
{
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[6];
    int j = 0;
    Object localObject2 = "b\f\026.\016U\035A\007z\024K1#.\\)\006<<\\\031S?(K\004\001t";
    int i = -1;
    Object localObject1 = arrayOfString;
    char[] arrayOfChar = ((String)localObject2).toCharArray();
    int k = arrayOfChar.length;
    int i1 = 0;
    int m = 0;
    int i3 = i;
    localObject2 = arrayOfChar;
    int i4 = j;
    Object localObject3 = localObject1;
    int n = k;
    Object localObject4;
    int i2;
    if (k <= 1)
    {
      localObject4 = localObject1;
      localObject1 = arrayOfChar;
      i2 = i;
      label68:
      n = m;
      label71:
      localObject2 = localObject1;
      i1 = localObject2[m];
      switch (n % 5)
      {
      default: 
        i = 90;
      }
    }
    for (;;)
    {
      localObject2[m] = ((char)(i ^ i1));
      n += 1;
      if (k == 0)
      {
        m = k;
        break label71;
      }
      i1 = n;
      n = k;
      localObject3 = localObject4;
      i4 = j;
      localObject2 = localObject1;
      i3 = i2;
      i2 = i3;
      localObject1 = localObject2;
      j = i4;
      localObject4 = localObject3;
      k = n;
      m = i1;
      if (n > i1) {
        break label68;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i3)
      {
      default: 
        localObject3[i4] = localObject1;
        j = 1;
        localObject2 = "i\031\034.5Z\004\037\017.P\007";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "l?5wb";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "b\f\026.\030@\037\026)\031V\005\000/7\\\017.zw\031)\n.?{\036\025<?KK\026((V\031]";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "b\f\026.\030@\037\026)\007\031FS\030#M\0161/<_\016\001z?K\031\034(t";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "X\t";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        return;
        i = 57;
        continue;
        i = 107;
        continue;
        i = 115;
        continue;
        i = 90;
      }
    }
  }
  
  public static void fillIntData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    System.arraycopy(int2ByteArray(paramInt1), 0, paramArrayOfByte, paramInt2, 4);
  }
  
  public static void fillStringData(byte[] paramArrayOfByte, String paramString, int paramInt)
  {
    paramString = paramString.getBytes();
    System.arraycopy(paramString, 0, paramArrayOfByte, paramInt, paramString.length);
  }
  
  public static byte[] fixedStringToBytes(String paramString, int paramInt)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      return new byte[] { 0, 0, 0, 0 };
    }
    byte[] arrayOfByte;
    try
    {
      paramString = paramString.getBytes(z[2]);
      if (paramString == null) {
        return new byte[] { 0, 0, 0, 0 };
      }
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        paramString = null;
      }
      arrayOfByte = getDefaultByte(paramInt);
      if (paramString.length <= paramInt) {}
    }
    for (;;)
    {
      System.arraycopy(paramString, 0, arrayOfByte, 0, paramInt);
      return arrayOfByte;
      paramInt = paramString.length;
    }
  }
  
  public static byte[] getBytes(ByteBuffer paramByteBuffer)
  {
    try
    {
      byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
      paramByteBuffer.asReadOnlyBuffer().flip();
      paramByteBuffer.get(arrayOfByte);
      return arrayOfByte;
    }
    catch (NegativeArraySizeException paramByteBuffer)
    {
      d.g(z[1], z[4]);
      return null;
    }
    catch (Exception paramByteBuffer) {}
    return null;
  }
  
  public static byte[] getBytesConsumed(ByteBuffer paramByteBuffer)
  {
    try
    {
      byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
      paramByteBuffer.get(arrayOfByte);
      return arrayOfByte;
    }
    catch (NegativeArraySizeException paramByteBuffer)
    {
      d.g(z[1], z[3]);
      return null;
    }
    catch (Exception paramByteBuffer) {}
    return null;
  }
  
  public static byte[] getDefaultByte(int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfByte[0] = 0;
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static String getString(ByteBuffer paramByteBuffer, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    paramByteBuffer.get(arrayOfByte);
    try
    {
      paramByteBuffer = new String(arrayOfByte, z[2]);
      return paramByteBuffer;
    }
    catch (UnsupportedEncodingException paramByteBuffer) {}
    return null;
  }
  
  public static String getTlv2(ByteBuffer paramByteBuffer)
  {
    try
    {
      byte[] arrayOfByte = new byte[paramByteBuffer.getShort()];
      paramByteBuffer.get(arrayOfByte);
      paramByteBuffer = new String(arrayOfByte, z[2]);
      return paramByteBuffer;
    }
    catch (Exception paramByteBuffer)
    {
      return null;
    }
    catch (UnsupportedEncodingException paramByteBuffer)
    {
      for (;;) {}
    }
  }
  
  public static String getTlv2(ByteBuffer paramByteBuffer, JResponse paramJResponse)
  {
    int i = ByteBufferUtils.getShort(paramByteBuffer, paramJResponse);
    if (i < 0)
    {
      d.g(z[1], z[0]);
      return null;
    }
    byte[] arrayOfByte = new byte[i];
    ByteBufferUtils.get(paramByteBuffer, arrayOfByte, paramJResponse);
    try
    {
      paramByteBuffer = new String(arrayOfByte, z[2]);
      return paramByteBuffer;
    }
    catch (UnsupportedEncodingException paramByteBuffer) {}
    return null;
  }
  
  public static byte[] int2ByteArray(int paramInt)
  {
    return new byte[] { (byte)(paramInt >>> 24), (byte)(paramInt >>> 16), (byte)(paramInt >>> 8), (byte)paramInt };
  }
  
  public static byte[] long2ByteArray(long paramLong)
  {
    return new byte[] { (byte)(int)(paramLong >>> 56), (byte)(int)(paramLong >>> 48), (byte)(int)(paramLong >>> 40), (byte)(int)(paramLong >>> 32), (byte)(int)(paramLong >>> 24), (byte)(int)(paramLong >>> 16), (byte)(int)(paramLong >>> 8), (byte)(int)paramLong };
  }
  
  public static void main(String[] paramArrayOfString)
  {
    paramArrayOfString = fixedStringToBytes(z[5], 4);
    System.out.println(h.a(paramArrayOfString));
  }
  
  public static byte[] short2ByteArray(short paramShort)
  {
    return new byte[] { (byte)(paramShort >>> 8), (byte)paramShort };
  }
  
  public static byte[] tlv2ToByteArray(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      return new byte[] { 0, 0 };
    }
    try
    {
      paramString = paramString.getBytes(z[2]);
      if (paramString == null) {
        return new byte[] { 0, 0 };
      }
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        paramString = null;
      }
      short s = (short)paramString.length;
      byte[] arrayOfByte = new byte[s + 2];
      System.arraycopy(short2ByteArray(s), 0, arrayOfByte, 0, 2);
      System.arraycopy(paramString, 0, arrayOfByte, 2, s);
      return arrayOfByte;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/api/utils/ProtocolUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */