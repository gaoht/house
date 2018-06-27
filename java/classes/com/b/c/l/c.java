package com.b.c.l;

import com.b.b.n;

public class c
{
  public void extract(n paramn, com.b.c.d paramd)
  {
    paramn.setMotorolaByteOrder(false);
    b localb = new b();
    paramd.addDirectory(localb);
    int i;
    do
    {
      try
      {
        if (paramn.getInt8() != 10) {
          throw new com.b.a.d("Invalid PCX identifier byte");
        }
      }
      catch (Exception paramn)
      {
        localb.addError("Exception reading PCX file metadata: " + paramn.getMessage());
        return;
      }
      localb.setInt(1, paramn.getInt8());
      if (paramn.getInt8() != 1) {
        throw new com.b.a.d("Invalid PCX encoding byte");
      }
      localb.setInt(2, paramn.getUInt8());
      localb.setInt(3, paramn.getUInt16());
      localb.setInt(4, paramn.getUInt16());
      localb.setInt(5, paramn.getUInt16());
      localb.setInt(6, paramn.getUInt16());
      localb.setInt(7, paramn.getUInt16());
      localb.setInt(8, paramn.getUInt16());
      localb.setByteArray(9, paramn.getBytes(48));
      paramn.skip(1L);
      localb.setInt(10, paramn.getUInt8());
      localb.setInt(11, paramn.getUInt16());
      i = paramn.getUInt16();
      if (i != 0) {
        localb.setInt(12, i);
      }
      i = paramn.getUInt16();
      if (i != 0) {
        localb.setInt(13, i);
      }
      i = paramn.getUInt16();
    } while (i == 0);
    localb.setInt(14, i);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/l/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */