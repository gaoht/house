package com.b.a.h;

import com.b.a.d.b;
import com.b.c.d;
import java.io.IOException;
import java.io.InputStream;

public class a
{
  public static d readMetadata(InputStream paramInputStream)
    throws b, IOException
  {
    if (!paramInputStream.markSupported()) {
      throw new IOException("Stream must support mark/reset");
    }
    paramInputStream.mark(512);
    byte[] arrayOfByte = new byte['Ȁ'];
    int j = paramInputStream.read(arrayOfByte);
    if (j == -1) {
      throw new IOException("Stream is empty");
    }
    paramInputStream.reset();
    int i = 0;
    while (i < j - 2)
    {
      if ((arrayOfByte[i] == -1) && (arrayOfByte[(i + 1)] == -40) && (arrayOfByte[(i + 2)] == -1))
      {
        if (paramInputStream.skip(i) == i) {
          break;
        }
        throw new IOException("Skipping stream bytes failed");
      }
      i += 1;
    }
    return com.b.a.d.a.readMetadata(paramInputStream);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/a/h/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */