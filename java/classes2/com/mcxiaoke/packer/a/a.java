package com.mcxiaoke.packer.a;

import com.mcxiaoke.packer.b.a.g;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class a
{
  static String a(File paramFile, String paramString, int paramInt)
    throws IOException
  {
    paramFile = readValues(paramFile, paramInt);
    if ((paramFile == null) || (paramFile.isEmpty())) {
      return null;
    }
    return (String)paramFile.get(paramString);
  }
  
  static ByteBuffer a(byte[] paramArrayOfByte)
    throws UnsupportedEncodingException
  {
    byte[] arrayOfByte = "Packer Ng Sig V2".getBytes("UTF-8");
    int i = arrayOfByte.length;
    int j = paramArrayOfByte.length;
    ByteBuffer localByteBuffer = ByteBuffer.allocate((i + 4) * 2 + j);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.put(arrayOfByte);
    localByteBuffer.putInt(j);
    localByteBuffer.put(paramArrayOfByte);
    localByteBuffer.putInt(j);
    localByteBuffer.flip();
    return localByteBuffer;
  }
  
  static void a(File paramFile, String paramString1, String paramString2, int paramInt)
    throws IOException
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString1, paramString2);
    writeValues(paramFile, localHashMap, paramInt);
  }
  
  static void a(File paramFile, byte[] paramArrayOfByte, int paramInt)
    throws IOException
  {
    g.writeBlock(paramFile, paramInt, a(paramArrayOfByte));
  }
  
  static byte[] a(File paramFile, int paramInt)
    throws IOException
  {
    paramFile = g.readBlock(paramFile, paramInt);
    if (paramFile == null) {}
    byte[] arrayOfByte1;
    do
    {
      do
      {
        byte[] arrayOfByte2;
        do
        {
          return null;
          arrayOfByte1 = "Packer Ng Sig V2".getBytes("UTF-8");
          arrayOfByte2 = new byte[arrayOfByte1.length];
          paramFile.get(arrayOfByte2);
        } while (!Arrays.equals(arrayOfByte1, arrayOfByte2));
        paramInt = paramFile.getInt();
      } while (paramInt <= 0);
      arrayOfByte1 = new byte[paramInt];
      paramFile.get(arrayOfByte1);
    } while (paramFile.getInt() != paramInt);
    return arrayOfByte1;
  }
  
  public static Map<String, String> mapFromString(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      paramString = null;
      return paramString;
    }
    HashMap localHashMap = new HashMap();
    String[] arrayOfString = paramString.split("∙");
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      paramString = localHashMap;
      if (i >= j) {
        break;
      }
      paramString = arrayOfString[i].split("∘");
      if (paramString.length == 2) {
        localHashMap.put(paramString[0], paramString[1]);
      }
      i += 1;
    }
  }
  
  public static String mapToString(Map<String, String> paramMap)
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localStringBuilder.append((String)localEntry.getKey()).append("∘").append((String)localEntry.getValue()).append("∙");
    }
    return localStringBuilder.toString();
  }
  
  public static byte[] readBytes(File paramFile, int paramInt)
    throws IOException
  {
    return a(paramFile, paramInt);
  }
  
  public static String readChannel(File paramFile)
    throws IOException
  {
    return a(paramFile, "CHANNEL", 2054712097);
  }
  
  public static String readString(File paramFile, int paramInt)
    throws IOException
  {
    paramFile = readBytes(paramFile, paramInt);
    if ((paramFile == null) || (paramFile.length == 0)) {
      return null;
    }
    return new String(paramFile, "UTF-8");
  }
  
  public static Map<String, String> readValues(File paramFile, int paramInt)
    throws IOException
  {
    return mapFromString(readString(paramFile, paramInt));
  }
  
  public static void writeBytes(File paramFile, byte[] paramArrayOfByte, int paramInt)
    throws IOException
  {
    a(paramFile, paramArrayOfByte, paramInt);
  }
  
  public static void writeChannel(File paramFile, String paramString)
    throws IOException
  {
    a(paramFile, "CHANNEL", paramString, 2054712097);
  }
  
  public static void writeString(File paramFile, String paramString, int paramInt)
    throws IOException
  {
    writeBytes(paramFile, paramString.getBytes("UTF-8"), paramInt);
  }
  
  public static void writeValues(File paramFile, Map<String, String> paramMap, int paramInt)
    throws IOException
  {
    if ((paramMap == null) || (paramMap.isEmpty())) {
      return;
    }
    HashMap localHashMap = new HashMap();
    Map localMap = readValues(paramFile, paramInt);
    if (localMap != null) {
      localHashMap.putAll(localMap);
    }
    localHashMap.putAll(paramMap);
    writeString(paramFile, mapToString(localHashMap), paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mcxiaoke/packer/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */