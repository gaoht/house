package com.b.c.g;

import com.b.b.n;
import com.b.c.d;
import java.io.IOException;

public class c
{
  static
  {
    if (!c.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public void extract(n paramn, d paramd)
  {
    paramn.setMotorolaByteOrder(false);
    int j;
    b localb;
    try
    {
      if (paramn.getUInt16() != 0)
      {
        paramn = new b();
        paramn.addError("Invalid header bytes");
        paramd.addDirectory(paramn);
        return;
      }
      j = paramn.getUInt16();
      if ((j != 1) && (j != 2))
      {
        paramn = new b();
        paramn.addError("Invalid type " + j + " -- expecting 1 or 2");
        paramd.addDirectory(paramn);
        return;
      }
    }
    catch (IOException paramn)
    {
      localb = new b();
      localb.addError("Exception reading ICO file metadata: " + paramn.getMessage());
      paramd.addDirectory(localb);
      return;
    }
    int k = paramn.getUInt16();
    if (k == 0)
    {
      paramn = new b();
      paramn.addError("Image count cannot be zero");
      paramd.addDirectory(paramn);
      return;
    }
    int i = 0;
    if (i < k)
    {
      localb = new b();
      for (;;)
      {
        try
        {
          localb.setInt(1, j);
          localb.setInt(2, paramn.getUInt8());
          localb.setInt(3, paramn.getUInt8());
          localb.setInt(4, paramn.getUInt8());
          paramn.getUInt8();
          if (j != 1) {
            continue;
          }
          localb.setInt(5, paramn.getUInt16());
          localb.setInt(7, paramn.getUInt16());
          localb.setLong(9, paramn.getUInt32());
          localb.setLong(10, paramn.getUInt32());
        }
        catch (IOException localIOException)
        {
          if ((a) || (localb != null)) {
            continue;
          }
          throw new AssertionError();
          localb.addError("Exception reading ICO file metadata: " + localIOException.getMessage());
          continue;
        }
        paramd.addDirectory(localb);
        i += 1;
        break;
        localb.setInt(6, paramn.getUInt16());
        localb.setInt(8, paramn.getUInt16());
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/g/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */