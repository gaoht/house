package com.b.a.f;

import com.b.b.n;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class c
{
  private static final byte[] a = { -119, 80, 78, 71, 13, 10, 26, 10 };
  
  public Iterable<b> extract(n paramn, Set<d> paramSet)
    throws h, IOException
  {
    paramn.setMotorolaByteOrder(true);
    if (!Arrays.equals(a, paramn.getBytes(a.length))) {
      throw new h("PNG signature mismatch");
    }
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    int i = 0;
    int j = 0;
    if (i == 0)
    {
      int m = paramn.getInt32();
      d locald = new d(paramn.getBytes(4));
      if ((paramSet == null) || (paramSet.contains(locald))) {}
      byte[] arrayOfByte;
      for (int k = 1;; k = 0)
      {
        arrayOfByte = paramn.getBytes(m);
        paramn.skip(4L);
        if ((k == 0) || (!localHashSet.contains(locald)) || (locald.areMultipleAllowed())) {
          break;
        }
        throw new h(String.format("Observed multiple instances of PNG chunk '%s', for which multiples are not allowed", new Object[] { locald }));
      }
      if (locald.equals(d.a)) {
        m = 1;
      }
      do
      {
        if (locald.equals(d.d)) {
          i = 1;
        }
        if (k != 0) {
          localArrayList.add(new b(locald, arrayOfByte));
        }
        localHashSet.add(locald);
        j = m;
        break;
        m = j;
      } while (j != 0);
      throw new h(String.format("First chunk should be '%s', but '%s' was observed", new Object[] { d.a, locald }));
    }
    return localArrayList;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/a/f/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */