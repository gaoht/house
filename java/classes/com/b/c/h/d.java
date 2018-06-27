package com.b.c.h;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public final class d
{
  static String a(byte[] paramArrayOfByte)
  {
    String[] arrayOfString = new String[3];
    arrayOfString[0] = "UTF-8";
    arrayOfString[1] = System.getProperty("file.encoding");
    arrayOfString[2] = "ISO-8859-1";
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      CharsetDecoder localCharsetDecoder = Charset.forName(str).newDecoder();
      try
      {
        localCharsetDecoder.decode(ByteBuffer.wrap(paramArrayOfByte));
        return str;
      }
      catch (CharacterCodingException localCharacterCodingException)
      {
        i += 1;
      }
    }
    return null;
  }
  
  public static String convertISO2022CharsetToJavaCharset(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte.length > 2) && (paramArrayOfByte[0] == 27) && (paramArrayOfByte[1] == 37) && (paramArrayOfByte[2] == 71)) {
      return "UTF-8";
    }
    if ((paramArrayOfByte.length > 3) && (paramArrayOfByte[0] == 27) && ((paramArrayOfByte[3] & 0xFF | (paramArrayOfByte[2] & 0xFF) << 8 | (paramArrayOfByte[1] & 0xFF) << 16) == 14844066) && (paramArrayOfByte[4] == 65)) {
      return "ISO-8859-1";
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/h/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */