package com.b.c.b;

import com.b.b.n;
import com.b.c.d;
import java.io.IOException;

public class c
{
  public void extract(n paramn, d paramd)
  {
    b localb = new b();
    paramd.addDirectory(localb);
    paramn.setMotorolaByteOrder(false);
    int i;
    try
    {
      if (paramn.getUInt16() != 19778)
      {
        localb.addError("Invalid BMP magic number");
        return;
      }
      paramn.skip(12L);
      i = paramn.getInt32();
      localb.setInt(-1, i);
      if (i == 40)
      {
        localb.setInt(2, paramn.getInt32());
        localb.setInt(1, paramn.getInt32());
        localb.setInt(3, paramn.getInt16());
        localb.setInt(4, paramn.getInt16());
        localb.setInt(5, paramn.getInt32());
        paramn.skip(4L);
        localb.setInt(6, paramn.getInt32());
        localb.setInt(7, paramn.getInt32());
        localb.setInt(8, paramn.getInt32());
        localb.setInt(9, paramn.getInt32());
        return;
      }
    }
    catch (IOException paramn)
    {
      localb.addError("Unable to read BMP header");
      return;
    }
    if (i == 12)
    {
      localb.setInt(2, paramn.getInt16());
      localb.setInt(1, paramn.getInt16());
      localb.setInt(3, paramn.getInt16());
      localb.setInt(4, paramn.getInt16());
      return;
    }
    localb.addError("Unexpected DIB header size: " + i);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */