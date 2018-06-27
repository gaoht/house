package com.b.c.p;

import com.b.a.i.a;
import com.b.b.j;
import com.b.c.c.g;
import com.b.c.d;
import java.io.IOException;

public class c
  implements a
{
  private final d a;
  
  public c(d paramd)
  {
    this.a = paramd;
  }
  
  public void processChunk(String paramString, byte[] paramArrayOfByte)
  {
    if (paramString.equals("EXIF")) {
      new g().extract(new com.b.b.b(paramArrayOfByte), this.a);
    }
    for (;;)
    {
      return;
      if (paramString.equals("ICCP"))
      {
        new com.b.c.f.c().extract(new com.b.b.b(paramArrayOfByte), this.a);
        return;
      }
      if (paramString.equals("XMP "))
      {
        new com.b.c.q.c().extract(paramArrayOfByte, this.a);
        return;
      }
      int i;
      int j;
      if ((paramString.equals("VP8X")) && (paramArrayOfByte.length == 10))
      {
        paramString = new com.b.b.b(paramArrayOfByte);
        paramString.setMotorolaByteOrder(false);
        try
        {
          boolean bool1 = paramString.getBit(1);
          boolean bool2 = paramString.getBit(4);
          i = paramString.getInt24(4);
          j = paramString.getInt24(7);
          paramString = new b();
          paramString.setInt(2, i + 1);
          paramString.setInt(1, j + 1);
          paramString.setBoolean(3, bool2);
          paramString.setBoolean(4, bool1);
          this.a.addDirectory(paramString);
          return;
        }
        catch (IOException paramString)
        {
          paramString.printStackTrace(System.err);
          return;
        }
      }
      if ((paramString.equals("VP8L")) && (paramArrayOfByte.length > 4))
      {
        paramString = new com.b.b.b(paramArrayOfByte);
        paramString.setMotorolaByteOrder(false);
        try
        {
          if (paramString.getInt8(0) != 47) {
            continue;
          }
          i = paramString.getUInt8(1);
          j = paramString.getUInt8(2);
          int k = paramString.getUInt8(3);
          int m = paramString.getUInt8(4);
          paramString = new b();
          paramString.setInt(2, (i | (j & 0x3F) << 8) + 1);
          paramString.setInt(1, ((m & 0xF) << 10 | k << 2 | (j & 0xC0) >> 6) + 1);
          this.a.addDirectory(paramString);
          return;
        }
        catch (IOException paramString)
        {
          paramString.printStackTrace(System.err);
          return;
        }
      }
      else if ((paramString.equals("VP8 ")) && (paramArrayOfByte.length > 9))
      {
        paramString = new com.b.b.b(paramArrayOfByte);
        paramString.setMotorolaByteOrder(false);
        try
        {
          if ((paramString.getUInt8(3) == 157) && (paramString.getUInt8(4) == 1) && (paramString.getUInt8(5) == 42))
          {
            i = paramString.getUInt16(6);
            j = paramString.getUInt16(8);
            paramString = new b();
            paramString.setInt(2, i);
            paramString.setInt(1, j);
            this.a.addDirectory(paramString);
            return;
          }
        }
        catch (IOException paramString)
        {
          paramString.printStackTrace(System.err);
        }
      }
    }
  }
  
  public boolean shouldAcceptChunk(String paramString)
  {
    return (paramString.equals("VP8X")) || (paramString.equals("VP8L")) || (paramString.equals("VP8 ")) || (paramString.equals("EXIF")) || (paramString.equals("ICCP")) || (paramString.equals("XMP "));
  }
  
  public boolean shouldAcceptRiffIdentifier(String paramString)
  {
    return paramString.equals("WEBP");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/p/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */