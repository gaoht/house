package com.b.c.k;

import com.b.a.d.f;
import java.util.Collections;
import java.util.Iterator;

public class c
  implements com.b.a.d.d
{
  public Iterable<f> getSegmentTypes()
  {
    return Collections.singletonList(f.H);
  }
  
  public void readJpegSegments(Iterable<byte[]> paramIterable, com.b.c.d paramd, f paramf)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      paramf = (byte[])paramIterable.next();
      b localb = new b();
      paramd.addDirectory(localb);
      localb.setString(0, new String(paramf));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/k/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */