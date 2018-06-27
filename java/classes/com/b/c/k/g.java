package com.b.c.k;

import com.b.b.m;
import com.b.b.n;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

public class g
  implements com.b.a.d.d
{
  public void extract(byte[] paramArrayOfByte, com.b.c.d paramd, com.b.a.d.f paramf)
  {
    int i = 0;
    f localf = new f();
    paramd.addDirectory(localf);
    localf.setInt(-3, paramf.J - com.b.a.d.f.t.J);
    paramArrayOfByte = new m(paramArrayOfByte);
    try
    {
      localf.setInt(0, paramArrayOfByte.getUInt8());
      localf.setInt(1, paramArrayOfByte.getUInt16());
      localf.setInt(3, paramArrayOfByte.getUInt16());
      int j = paramArrayOfByte.getUInt8();
      localf.setInt(5, j);
      while (i < j)
      {
        localf.setObject(i + 6, new d(paramArrayOfByte.getUInt8(), paramArrayOfByte.getUInt8(), paramArrayOfByte.getUInt8()));
        i += 1;
      }
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      localf.addError(paramArrayOfByte.getMessage());
    }
  }
  
  public Iterable<com.b.a.d.f> getSegmentTypes()
  {
    return Arrays.asList(new com.b.a.d.f[] { com.b.a.d.f.t, com.b.a.d.f.u, com.b.a.d.f.v, com.b.a.d.f.w, com.b.a.d.f.x, com.b.a.d.f.y, com.b.a.d.f.z, com.b.a.d.f.A, com.b.a.d.f.B, com.b.a.d.f.C, com.b.a.d.f.D, com.b.a.d.f.E, com.b.a.d.f.F, com.b.a.d.f.G });
  }
  
  public void readJpegSegments(Iterable<byte[]> paramIterable, com.b.c.d paramd, com.b.a.d.f paramf)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      extract((byte[])paramIterable.next(), paramd, paramf);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/k/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */