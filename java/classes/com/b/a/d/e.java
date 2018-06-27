package com.b.a.d;

import com.b.b.n;
import com.b.b.o;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class e
{
  static
  {
    if (!e.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  private e()
    throws Exception
  {
    throw new Exception("Not intended for instantiation.");
  }
  
  public static c readSegments(n paramn, Iterable<f> paramIterable)
    throws b, IOException
  {
    if ((!a) && (!paramn.isMotorolaByteOrder())) {
      throw new AssertionError();
    }
    int k = paramn.getUInt16();
    if (k != 65496) {
      throw new b("JPEG data is expected to begin with 0xFFD8 (ÿØ) not 0x" + Integer.toHexString(k));
    }
    HashSet localHashSet = null;
    if (paramIterable != null)
    {
      localHashSet = new HashSet();
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        localHashSet.add(Byte.valueOf(((f)paramIterable.next()).J));
      }
    }
    paramIterable = new c();
    do
    {
      for (;;)
      {
        k = paramn.getInt8();
        int j;
        for (int i = paramn.getInt8(); (k != -1) || (i == -1) || (i == 0); i = j)
        {
          j = paramn.getInt8();
          k = i;
        }
        if (i == -38) {
          return paramIterable;
        }
        if (i == -39) {
          return paramIterable;
        }
        k = paramn.getUInt16() - 2;
        if (k < 0) {
          throw new b("JPEG segment size would be less than zero");
        }
        if ((localHashSet != null) && (!localHashSet.contains(Byte.valueOf(i)))) {
          break;
        }
        byte[] arrayOfByte = paramn.getBytes(k);
        if ((!a) && (k != arrayOfByte.length)) {
          throw new AssertionError();
        }
        paramIterable.addSegment(i, arrayOfByte);
      }
    } while (paramn.trySkip(k));
    return paramIterable;
  }
  
  public static c readSegments(File paramFile, Iterable<f> paramIterable)
    throws b, IOException
  {
    try
    {
      localFileInputStream = new FileInputStream(paramFile);
      if (paramIterable == null) {
        break label43;
      }
    }
    finally
    {
      try
      {
        paramFile = readSegments(new o(localFileInputStream), paramIterable);
        if (localFileInputStream != null) {
          localFileInputStream.close();
        }
        return paramFile;
      }
      finally
      {
        FileInputStream localFileInputStream;
        paramIterable = localFileInputStream;
      }
      paramFile = finally;
      paramIterable = null;
    }
    paramIterable.close();
    label43:
    throw paramFile;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/a/d/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */