package com.b.c.e;

import com.b.b.n;
import com.b.c.d;
import java.io.IOException;

public class c
{
  public void extract(n paramn, d paramd)
  {
    boolean bool2 = true;
    b localb = new b();
    paramd.addDirectory(localb);
    paramn.setMotorolaByteOrder(false);
    try
    {
      if (!paramn.getString(3).equals("GIF"))
      {
        localb.addError("Invalid GIF file signature");
        return;
      }
      paramd = paramn.getString(3);
      if ((!paramd.equals("87a")) && (!paramd.equals("89a")))
      {
        localb.addError("Unexpected GIF version");
        return;
      }
    }
    catch (IOException paramn)
    {
      localb.addError("Unable to read BMP header");
      return;
    }
    localb.setString(1, paramd);
    localb.setInt(2, paramn.getUInt16());
    localb.setInt(3, paramn.getUInt16());
    int i = paramn.getUInt8();
    localb.setInt(4, 1 << (i & 0x7) + 1);
    if (paramd.equals("89a"))
    {
      if ((i & 0x8) != 0)
      {
        bool1 = true;
        localb.setBoolean(5, bool1);
      }
    }
    else
    {
      localb.setInt(6, ((i & 0x70) >> 4) + 1);
      if ((i & 0xF) == 0) {
        break label238;
      }
    }
    label238:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localb.setBoolean(7, bool1);
      localb.setInt(8, paramn.getUInt8());
      i = paramn.getUInt8();
      if (i == 0) {
        return;
      }
      localb.setFloat(9, (float)((i + 15.0D) / 64.0D));
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/e/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */