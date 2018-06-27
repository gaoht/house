package com.b.c.m;

import com.b.a.d.f;
import com.b.b.b;
import com.b.b.m;
import com.b.b.n;
import com.b.c.c.g;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class e
  implements com.b.a.d.d
{
  public void extract(n paramn, int paramInt, com.b.c.d paramd)
  {
    int j = 0;
    d locald = new d();
    paramd.addDirectory(locald);
    String str;
    int k;
    int i;
    label88:
    byte[] arrayOfByte;
    do
    {
      if (j < paramInt) {
        try
        {
          str = paramn.getString(4);
          k = paramn.getUInt16();
          i = paramn.getUInt8();
          j = j + 4 + 2 + 1;
          if ((i >= 0) && (i + j <= paramInt)) {
            break label88;
          }
          throw new com.b.a.d("Invalid string length");
        }
        catch (Exception paramn)
        {
          locald.addError(paramn.getMessage());
        }
      }
      return;
      long l = i;
      paramn.skip(l);
      j += i;
      i = j;
      if (j % 2 != 0)
      {
        paramn.skip(1L);
        i = j + 1;
      }
      j = paramn.getInt32();
      arrayOfByte = paramn.getBytes(j);
      j = i + 4 + j;
      i = j;
      if (j % 2 != 0)
      {
        paramn.skip(1L);
        i = j + 1;
      }
      j = i;
    } while (!str.equals("8BIM"));
    if (k == 1028) {
      new com.b.c.h.c().extract(new m(arrayOfByte), paramd, arrayOfByte.length, locald);
    }
    for (;;)
    {
      j = i;
      if (k < 4000) {
        break;
      }
      j = i;
      if (k > 4999) {
        break;
      }
      d.e.put(Integer.valueOf(k), String.format("Plug-in %d Data", new Object[] { Integer.valueOf(k - 4000 + 1) }));
      j = i;
      break;
      if (k != 1039) {
        break label384;
      }
      new com.b.c.f.c().extract(new b(arrayOfByte), paramd, locald);
    }
    for (;;)
    {
      label320:
      new g().extract(new b(arrayOfByte), paramd, 0, locald);
      break;
      label384:
      do
      {
        if (k == 1060)
        {
          new com.b.c.q.c().extract(arrayOfByte, paramd, locald);
          break;
        }
        locald.setByteArray(k, arrayOfByte);
        break;
        if (k == 1058) {
          break label320;
        }
      } while (k != 1059);
    }
  }
  
  public Iterable<f> getSegmentTypes()
  {
    return Collections.singletonList(f.n);
  }
  
  public void readJpegSegments(Iterable<byte[]> paramIterable, com.b.c.d paramd, f paramf)
  {
    int i = "Photoshop 3.0".length();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      paramf = (byte[])paramIterable.next();
      if ((paramf.length >= i + 1) && ("Photoshop 3.0".equals(new String(paramf, 0, i)))) {
        extract(new m(paramf, i + 1), paramf.length - i - 1, paramd);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/m/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */