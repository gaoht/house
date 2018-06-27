package com.b.c.m;

import com.b.a.d.f;
import com.b.b.m;
import com.b.b.n;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;

public class b
  implements com.b.a.d.d
{
  public void extract(n paramn, com.b.c.d paramd)
  {
    a locala = new a();
    paramd.addDirectory(locala);
    for (;;)
    {
      int i;
      int j;
      try
      {
        i = paramn.getUInt16();
        if (i == 0) {
          return;
        }
        j = paramn.getUInt16();
        switch (i)
        {
        case 1: 
          locala.setByteArray(i, paramn.getBytes(j));
          continue;
          if (j == 4) {
            break label100;
          }
        }
      }
      catch (IOException paramn)
      {
        locala.addError(paramn.getMessage());
        return;
      }
      locala.addError("Unexpected length for the quality tag");
      return;
      label100:
      locala.setInt(i, paramn.getInt32());
      continue;
      paramn.skip(4L);
      locala.setString(i, paramn.getString(j - 4, "UTF-16BE"));
    }
  }
  
  public Iterable<f> getSegmentTypes()
  {
    return Collections.singletonList(f.m);
  }
  
  public void readJpegSegments(Iterable<byte[]> paramIterable, com.b.c.d paramd, f paramf)
  {
    int i = "Ducky".length();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      paramf = (byte[])paramIterable.next();
      if ((paramf.length >= i) && ("Ducky".equals(new String(paramf, 0, i)))) {
        extract(new m(paramf, i), paramd);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/m/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */