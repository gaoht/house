package com.b.c.a;

import com.b.a.d.f;
import com.b.b.m;
import com.b.b.n;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;

public class c
  implements com.b.a.d.d
{
  public void extract(n paramn, com.b.c.d paramd)
  {
    b localb = new b();
    paramd.addDirectory(localb);
    try
    {
      paramn.setMotorolaByteOrder(false);
      if (!paramn.getString("Adobe".length()).equals("Adobe"))
      {
        localb.addError("Invalid Adobe JPEG data header.");
        return;
      }
      localb.setInt(0, paramn.getUInt16());
      localb.setInt(1, paramn.getUInt16());
      localb.setInt(2, paramn.getUInt16());
      localb.setInt(3, paramn.getInt8());
      return;
    }
    catch (IOException paramn)
    {
      localb.addError("IO exception processing data: " + paramn.getMessage());
    }
  }
  
  public Iterable<f> getSegmentTypes()
  {
    return Collections.singletonList(f.o);
  }
  
  public void readJpegSegments(Iterable<byte[]> paramIterable, com.b.c.d paramd, f paramf)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      paramf = (byte[])paramIterable.next();
      if ((paramf.length == 12) && ("Adobe".equalsIgnoreCase(new String(paramf, 0, "Adobe".length())))) {
        extract(new m(paramf), paramd);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */