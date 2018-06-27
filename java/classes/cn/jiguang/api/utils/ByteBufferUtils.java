package cn.jiguang.api.utils;

import cn.jiguang.api.JResponse;
import cn.jiguang.d.d;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

public class ByteBufferUtils
{
  public static final int ERROR_CODE = 10000;
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[5];
    Object localObject1 = ">F'01\tY50\001)K:9\000";
    int i = -1;
    int j = 0;
    Object localObject3 = arrayOfString;
    localObject1 = ((String)localObject1).toCharArray();
    int k = localObject1.length;
    int m;
    int n;
    int i1;
    label42:
    Object localObject2;
    int i2;
    label91:
    label113:
    Object localObject4;
    int i3;
    if (k <= 1)
    {
      m = 0;
      n = j;
      i1 = i;
      j = m;
      for (;;)
      {
        localObject2 = localObject1;
        i2 = localObject2[m];
        switch (j % 5)
        {
        default: 
          i = 115;
          localObject2[m] = ((char)(i ^ i2));
          j += 1;
          if (k != 0) {
            break label113;
          }
          m = k;
        }
      }
      i = k;
      localObject4 = localObject3;
      i3 = n;
      localObject2 = localObject1;
      i2 = i1;
    }
    for (;;)
    {
      i1 = i2;
      localObject1 = localObject2;
      n = i3;
      localObject3 = localObject4;
      k = i;
      m = j;
      if (i > j) {
        break label42;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i2)
      {
      default: 
        localObject4[i3] = localObject1;
        localObject1 = "\036F'01\tY50\001\\V u\035\tS?";
        j = 1;
        i = 0;
        break;
      case 0: 
        localObject4[i3] = localObject1;
        localObject1 = "\f^!&\026\\[2!\022\\Z!'\034\016\037 !\022\037T\007'\022\037Zi";
        j = 2;
        i = 1;
        break;
      case 1: 
        localObject4[i3] = localObject1;
        localObject1 = "\036F'01\tY50\001\\V=3\034F";
        j = 3;
        i = 2;
        break;
      case 2: 
        localObject4[i3] = localObject1;
        j = 4;
        localObject1 = "\000]*!\026\036J53\026\016\005";
        i = 3;
        break;
      case 3: 
        localObject4[i3] = localObject1;
        z = arrayOfString;
        return;
        i = 124;
        break label91;
        i = 63;
        break label91;
        i = 83;
        break label91;
        i = 85;
        break label91;
        m = 0;
        i2 = i;
        localObject2 = localObject1;
        i3 = j;
        localObject4 = localObject3;
        i = k;
        j = m;
      }
    }
  }
  
  private static String a(Throwable paramThrowable, JResponse paramJResponse, ByteBuffer paramByteBuffer)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2;
    if (paramJResponse != null)
    {
      localStringBuilder1.append(paramJResponse.toString());
      localStringBuilder2 = new StringBuilder(z[4]);
      if (paramByteBuffer != null) {
        break label146;
      }
      paramJResponse = z[1];
    }
    for (;;)
    {
      localStringBuilder1.append(paramJResponse);
      d.j(z[0], z[3] + localStringBuilder1.toString());
      try
      {
        paramJResponse = new StringWriter();
        paramThrowable.printStackTrace(new PrintWriter(paramJResponse));
        paramThrowable = paramJResponse.toString();
        d.j(z[0], z[2] + paramThrowable);
        return localStringBuilder1.toString();
        label146:
        paramJResponse = paramByteBuffer.toString();
      }
      catch (Exception paramThrowable)
      {
        for (;;) {}
      }
    }
  }
  
  public static Byte get(ByteBuffer paramByteBuffer, JResponse paramJResponse)
  {
    try
    {
      byte b = paramByteBuffer.get();
      return Byte.valueOf(b);
    }
    catch (BufferUnderflowException localBufferUnderflowException)
    {
      a(localBufferUnderflowException.fillInStackTrace(), paramJResponse, paramByteBuffer);
      if (paramJResponse != null) {
        paramJResponse.code = 10000;
      }
      return null;
    }
    catch (BufferOverflowException localBufferOverflowException)
    {
      for (;;)
      {
        a(localBufferOverflowException.fillInStackTrace(), paramJResponse, paramByteBuffer);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        a(localException.fillInStackTrace(), paramJResponse, paramByteBuffer);
      }
    }
  }
  
  public static ByteBuffer get(ByteBuffer paramByteBuffer, byte[] paramArrayOfByte, JResponse paramJResponse)
  {
    try
    {
      paramArrayOfByte = paramByteBuffer.get(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (BufferUnderflowException paramArrayOfByte)
    {
      a(paramArrayOfByte.fillInStackTrace(), paramJResponse, paramByteBuffer);
      if (paramJResponse != null) {
        paramJResponse.code = 10000;
      }
      return null;
    }
    catch (BufferOverflowException paramArrayOfByte)
    {
      for (;;)
      {
        a(paramArrayOfByte.fillInStackTrace(), paramJResponse, paramByteBuffer);
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        a(paramArrayOfByte.fillInStackTrace(), paramJResponse, paramByteBuffer);
      }
    }
  }
  
  public static int getInt(ByteBuffer paramByteBuffer, JResponse paramJResponse)
  {
    try
    {
      int i = paramByteBuffer.getInt();
      return i;
    }
    catch (BufferUnderflowException localBufferUnderflowException)
    {
      a(localBufferUnderflowException.fillInStackTrace(), paramJResponse, paramByteBuffer);
      if (paramJResponse != null) {
        paramJResponse.code = 10000;
      }
      return -1;
    }
    catch (BufferOverflowException localBufferOverflowException)
    {
      for (;;)
      {
        a(localBufferOverflowException.fillInStackTrace(), paramJResponse, paramByteBuffer);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        a(localException.fillInStackTrace(), paramJResponse, paramByteBuffer);
      }
    }
  }
  
  public static long getLong(ByteBuffer paramByteBuffer, JResponse paramJResponse)
  {
    try
    {
      long l = paramByteBuffer.getLong();
      return l;
    }
    catch (BufferUnderflowException localBufferUnderflowException)
    {
      a(localBufferUnderflowException.fillInStackTrace(), paramJResponse, paramByteBuffer);
      if (paramJResponse != null) {
        paramJResponse.code = 10000;
      }
      return 0L;
    }
    catch (BufferOverflowException localBufferOverflowException)
    {
      for (;;)
      {
        a(localBufferOverflowException.fillInStackTrace(), paramJResponse, paramByteBuffer);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        a(localException.fillInStackTrace(), paramJResponse, paramByteBuffer);
      }
    }
  }
  
  public static short getShort(ByteBuffer paramByteBuffer, JResponse paramJResponse)
  {
    try
    {
      short s = paramByteBuffer.getShort();
      return s;
    }
    catch (BufferUnderflowException localBufferUnderflowException)
    {
      a(localBufferUnderflowException.fillInStackTrace(), paramJResponse, paramByteBuffer);
      if (paramJResponse != null) {
        paramJResponse.code = 10000;
      }
      return -1;
    }
    catch (BufferOverflowException localBufferOverflowException)
    {
      for (;;)
      {
        a(localBufferOverflowException.fillInStackTrace(), paramJResponse, paramByteBuffer);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        a(localException.fillInStackTrace(), paramJResponse, paramByteBuffer);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/api/utils/ByteBufferUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */