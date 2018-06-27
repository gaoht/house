package com.facebook.imageutils;

import android.util.Pair;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;

public class WebpUtil
{
  private static final String VP8L_HEADER = "VP8L";
  private static final String VP8X_HEADER = "VP8X";
  private static final String VP8_HEADER = "VP8 ";
  
  private static boolean compare(byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte.length != paramString.length()) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfByte.length) {
        break label37;
      }
      if (paramString.charAt(i) != paramArrayOfByte[i]) {
        break;
      }
      i += 1;
    }
    label37:
    return true;
  }
  
  public static int get2BytesAsInt(InputStream paramInputStream)
    throws IOException
  {
    return (byte)paramInputStream.read() & 0xFF | (byte)paramInputStream.read() << 8 & 0xFF00;
  }
  
  private static byte getByte(InputStream paramInputStream)
    throws IOException
  {
    return (byte)(paramInputStream.read() & 0xFF);
  }
  
  private static String getHeader(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append((char)paramArrayOfByte[i]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private static int getInt(InputStream paramInputStream)
    throws IOException
  {
    return (byte)paramInputStream.read() & 0xFF | (byte)paramInputStream.read() << 8 & 0xFF00 | (byte)paramInputStream.read() << 16 & 0xFF0000 | (byte)paramInputStream.read() << 24 & 0xFF000000;
  }
  
  private static short getShort(InputStream paramInputStream)
    throws IOException
  {
    return (short)(paramInputStream.read() & 0xFF);
  }
  
  @Nullable
  public static Pair<Integer, Integer> getSize(InputStream paramInputStream)
  {
    Object localObject4 = null;
    Object localObject1 = new byte[4];
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              for (;;)
              {
                try
                {
                  paramInputStream.read((byte[])localObject1);
                  bool = compare((byte[])localObject1, "RIFF");
                  if (bool) {
                    continue;
                  }
                  localObject1 = localObject4;
                }
                catch (IOException localIOException)
                {
                  boolean bool;
                  localIOException.printStackTrace();
                  Object localObject2 = localObject4;
                  if (paramInputStream == null) {
                    continue;
                  }
                  try
                  {
                    paramInputStream.close();
                    return null;
                  }
                  catch (IOException paramInputStream)
                  {
                    paramInputStream.printStackTrace();
                    return null;
                  }
                }
                finally
                {
                  if (paramInputStream == null) {
                    break label253;
                  }
                }
                try
                {
                  paramInputStream.close();
                  localObject1 = localObject4;
                  return (Pair<Integer, Integer>)localObject1;
                }
                catch (IOException paramInputStream)
                {
                  paramInputStream.printStackTrace();
                  return null;
                }
              }
              getInt(paramInputStream);
              paramInputStream.read((byte[])localObject1);
              bool = compare((byte[])localObject1, "WEBP");
              if (bool) {
                break;
              }
              localObject1 = localObject4;
            } while (paramInputStream == null);
            try
            {
              paramInputStream.close();
              return null;
            }
            catch (IOException paramInputStream)
            {
              paramInputStream.printStackTrace();
              return null;
            }
            paramInputStream.read((byte[])localObject1);
            localObject1 = getHeader((byte[])localObject1);
            if (!"VP8 ".equals(localObject1)) {
              break;
            }
            localObject1 = getVP8Dimension(paramInputStream);
            localObject4 = localObject1;
            localObject1 = localObject4;
          } while (paramInputStream == null);
          try
          {
            paramInputStream.close();
            return (Pair<Integer, Integer>)localObject4;
          }
          catch (IOException paramInputStream)
          {
            paramInputStream.printStackTrace();
            return (Pair<Integer, Integer>)localObject4;
          }
          if (!"VP8L".equals(localObject1)) {
            break;
          }
          localObject1 = getVP8LDimension(paramInputStream);
          localObject4 = localObject1;
          localObject1 = localObject4;
        } while (paramInputStream == null);
        try
        {
          paramInputStream.close();
          return (Pair<Integer, Integer>)localObject4;
        }
        catch (IOException paramInputStream)
        {
          paramInputStream.printStackTrace();
          return (Pair<Integer, Integer>)localObject4;
        }
        if (!"VP8X".equals(localObject1)) {
          break;
        }
        localObject1 = getVP8XDimension(paramInputStream);
        localObject4 = localObject1;
        localObject1 = localObject4;
      } while (paramInputStream == null);
      try
      {
        paramInputStream.close();
        return (Pair<Integer, Integer>)localObject4;
      }
      catch (IOException paramInputStream)
      {
        paramInputStream.printStackTrace();
        return (Pair<Integer, Integer>)localObject4;
      }
      localObject1 = localObject4;
    } while (paramInputStream == null);
    try
    {
      paramInputStream.close();
      return null;
    }
    catch (IOException paramInputStream)
    {
      paramInputStream.printStackTrace();
      return null;
    }
    try
    {
      paramInputStream.close();
      label253:
      throw ((Throwable)localObject3);
    }
    catch (IOException paramInputStream)
    {
      for (;;)
      {
        paramInputStream.printStackTrace();
      }
    }
  }
  
  private static Pair<Integer, Integer> getVP8Dimension(InputStream paramInputStream)
    throws IOException
  {
    paramInputStream.skip(7L);
    int i = getShort(paramInputStream);
    int j = getShort(paramInputStream);
    int k = getShort(paramInputStream);
    if ((i != 157) || (j != 1) || (k != 42)) {
      return null;
    }
    return new Pair(Integer.valueOf(get2BytesAsInt(paramInputStream)), Integer.valueOf(get2BytesAsInt(paramInputStream)));
  }
  
  private static Pair<Integer, Integer> getVP8LDimension(InputStream paramInputStream)
    throws IOException
  {
    getInt(paramInputStream);
    if (getByte(paramInputStream) != 47) {
      return null;
    }
    int i = (byte)paramInputStream.read();
    int j = (byte)paramInputStream.read() & 0xFF;
    int k = (byte)paramInputStream.read();
    return new Pair(Integer.valueOf((i & 0xFF | (j & 0x3F) << 8) + 1), Integer.valueOf((((byte)paramInputStream.read() & 0xFF & 0xF) << 10 | (k & 0xFF) << 2 | (j & 0xC0) >> 6) + 1));
  }
  
  private static Pair<Integer, Integer> getVP8XDimension(InputStream paramInputStream)
    throws IOException
  {
    paramInputStream.skip(8L);
    return new Pair(Integer.valueOf(read3Bytes(paramInputStream) + 1), Integer.valueOf(read3Bytes(paramInputStream) + 1));
  }
  
  private static boolean isBitOne(byte paramByte, int paramInt)
  {
    return (paramByte >> paramInt % 8 & 0x1) == 1;
  }
  
  private static int read3Bytes(InputStream paramInputStream)
    throws IOException
  {
    return getByte(paramInputStream) & 0xFF | getByte(paramInputStream) << 8 & 0xFF00 | getByte(paramInputStream) << 16 & 0xFF0000;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imageutils/WebpUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */