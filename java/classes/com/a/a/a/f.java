package com.a.a.a;

import java.io.UnsupportedEncodingException;

public class f
{
  private static byte[] a(byte paramByte)
  {
    int i = paramByte & 0xFF;
    if (i >= 128)
    {
      if ((i == 129) || (i == 141) || (i == 143) || (i == 144) || (i == 157)) {}
      try
      {
        return new byte[] { 32 };
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
      byte[] arrayOfByte = new String(new byte[] { paramByte }, "cp1252").getBytes("UTF-8");
      return arrayOfByte;
    }
    return new byte[] { paramByte };
  }
  
  public static b convert(b paramb)
  {
    int n = 0;
    b localb = paramb;
    byte[] arrayOfByte;
    int k;
    int j;
    int m;
    int i;
    int i1;
    if ("UTF-8".equals(paramb.getEncoding()))
    {
      arrayOfByte = new byte[8];
      localb = new b(paramb.length() * 4 / 3);
      k = 0;
      j = 0;
      m = 0;
      i = 0;
      if (k < paramb.length())
      {
        i1 = paramb.charAt(k);
        switch (j)
        {
        default: 
          if (i1 < 127) {
            localb.append((byte)i1);
          }
          break;
        }
      }
    }
    for (;;)
    {
      k += 1;
      break;
      if (i1 >= 192)
      {
        m = -1;
        j = i1;
        while ((m < 8) && ((j & 0x80) == 128))
        {
          m += 1;
          j <<= 1;
        }
        arrayOfByte[i] = ((byte)i1);
        i += 1;
        j = 11;
      }
      else
      {
        localb.append(a((byte)i1));
        continue;
        int i2;
        if ((m > 0) && ((i1 & 0xC0) == 128))
        {
          i2 = i + 1;
          arrayOfByte[i] = ((byte)i1);
          m -= 1;
          if (m == 0)
          {
            localb.append(arrayOfByte, 0, i2);
            j = 0;
            i = 0;
          }
        }
        else
        {
          localb.append(a(arrayOfByte[0]));
          k -= i;
          j = 0;
          i = 0;
          continue;
          if (j == 11)
          {
            j = n;
            while (j < i)
            {
              localb.append(a(arrayOfByte[j]));
              j += 1;
            }
          }
          return localb;
        }
        i = i2;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/a/a/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */