package com.b.c.h;

import com.b.a.d.f;
import com.b.b.m;
import com.b.b.n;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;

public class c
  implements com.b.a.d.d
{
  private void a(n paramn, com.b.c.b paramb, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    paramInt1 = paramInt2 | paramInt1 << 8;
    if (paramInt3 == 0)
    {
      paramb.setString(paramInt1, "");
      return;
    }
    Object localObject2 = null;
    Object localObject1;
    switch (paramInt1)
    {
    default: 
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = paramb.getString(346);
        if (localObject1 != null) {
          localObject1 = paramn.getString(paramInt3, (String)localObject1);
        }
      }
      else
      {
        label125:
        if (!paramb.containsTag(paramInt1)) {
          break label324;
        }
        localObject2 = paramb.getStringArray(paramInt1);
        if (localObject2 != null) {
          break label301;
        }
        paramn = new String[1];
      }
      break;
    }
    for (;;)
    {
      paramn[(paramn.length - 1)] = localObject1;
      paramb.setStringArray(paramInt1, paramn);
      return;
      localObject1 = paramn.getBytes(paramInt3);
      localObject2 = d.convertISO2022CharsetToJavaCharset((byte[])localObject1);
      if (localObject2 == null)
      {
        localObject2 = new String((byte[])localObject1);
        break;
      }
      paramb.setString(paramInt1, (String)localObject2);
      return;
      if (paramInt3 < 2) {
        break;
      }
      paramInt2 = paramn.getUInt16();
      paramn.skip(paramInt3 - 2);
      paramb.setInt(paramInt1, paramInt2);
      return;
      paramb.setInt(paramInt1, paramn.getUInt8());
      paramn.skip(paramInt3 - 1);
      return;
      paramn = paramn.getBytes(paramInt3);
      localObject1 = d.a(paramn);
      if (localObject1 != null)
      {
        localObject1 = new String(paramn, (String)localObject1);
        break label125;
      }
      localObject1 = new String(paramn);
      break label125;
      label301:
      paramn = new String[localObject2.length + 1];
      System.arraycopy(localObject2, 0, paramn, 0, localObject2.length);
    }
    label324:
    paramb.setString(paramInt1, (String)localObject1);
  }
  
  public void extract(n paramn, com.b.c.d paramd, long paramLong)
  {
    extract(paramn, paramd, paramLong, null);
  }
  
  public void extract(n paramn, com.b.c.d paramd, long paramLong, com.b.c.b paramb)
  {
    b localb = new b();
    paramd.addDirectory(localb);
    if (paramb != null) {
      localb.setParent(paramb);
    }
    int i = 0;
    for (;;)
    {
      if (i < paramLong) {}
      int j;
      try
      {
        j = paramn.getUInt8();
        i += 1;
        if (j != 28)
        {
          if (i != paramLong) {
            localb.addError("Invalid IPTC tag marker at offset " + (i - 1) + ". Expected '0x1c' but got '0x" + Integer.toHexString(j) + "'.");
          }
          return;
        }
      }
      catch (IOException paramn)
      {
        localb.addError("Unable to read starting byte of IPTC tag");
        return;
      }
      if (i + 5 > paramLong)
      {
        localb.addError("Too few bytes remain for a valid IPTC tag");
        return;
      }
      int k;
      int m;
      try
      {
        j = paramn.getUInt8();
        k = paramn.getUInt8();
        m = paramn.getUInt16();
        i += 4;
        if (i + m > paramLong)
        {
          localb.addError("Data for tag extends beyond end of IPTC segment");
          return;
        }
      }
      catch (IOException paramn)
      {
        localb.addError("IPTC data segment ended mid-way through tag descriptor");
        return;
      }
      try
      {
        a(paramn, localb, j, k, m);
        i += m;
      }
      catch (IOException paramn)
      {
        localb.addError("Error processing IPTC tag");
      }
    }
  }
  
  public Iterable<f> getSegmentTypes()
  {
    return Collections.singletonList(f.n);
  }
  
  public void readJpegSegments(Iterable<byte[]> paramIterable, com.b.c.d paramd, f paramf)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      paramf = (byte[])paramIterable.next();
      if ((paramf.length != 0) && (paramf[0] == 28)) {
        extract(new m(paramf), paramd, paramf.length);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/h/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */