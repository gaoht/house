package com.b.c.f;

import com.b.b.j;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;

public class c
  implements com.b.a.d.d
{
  private void a(com.b.c.b paramb, int paramInt, j paramj)
    throws IOException
  {
    int i = paramj.getInt32(paramInt);
    if (i != 0) {
      paramb.setString(paramInt, getStringFromInt32(i));
    }
  }
  
  private void a(b paramb, int paramInt, j paramj)
    throws IOException
  {
    int i = paramj.getUInt16(paramInt);
    int j = paramj.getUInt16(paramInt + 2);
    int k = paramj.getUInt16(paramInt + 4);
    int m = paramj.getUInt16(paramInt + 6);
    int n = paramj.getUInt16(paramInt + 8);
    int i1 = paramj.getUInt16(paramInt + 10);
    if ((com.b.b.f.isValidDate(i, j - 1, k)) && (com.b.b.f.isValidTime(m, n, i1)))
    {
      paramb.setString(paramInt, String.format("%04d:%02d:%02d %02d:%02d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1) }));
      return;
    }
    paramb.addError(String.format("ICC data describes an invalid date/time: year=%d month=%d day=%d hour=%d minute=%d second=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1) }));
  }
  
  private void b(com.b.c.b paramb, int paramInt, j paramj)
    throws IOException
  {
    int i = paramj.getInt32(paramInt);
    if (i != 0) {
      paramb.setInt(paramInt, i);
    }
  }
  
  private void c(com.b.c.b paramb, int paramInt, j paramj)
    throws IOException
  {
    long l = paramj.getInt64(paramInt);
    if (l != 0L) {
      paramb.setLong(paramInt, l);
    }
  }
  
  public static String getStringFromInt32(int paramInt)
  {
    return new String(new byte[] { (byte)((0xFF000000 & paramInt) >> 24), (byte)((0xFF0000 & paramInt) >> 16), (byte)((0xFF00 & paramInt) >> 8), (byte)(paramInt & 0xFF) });
  }
  
  public void extract(j paramj, com.b.c.d paramd)
  {
    extract(paramj, paramd, null);
  }
  
  public void extract(j paramj, com.b.c.d paramd, com.b.c.b paramb)
  {
    int i = 0;
    b localb = new b();
    if (paramb != null) {
      localb.setParent(paramb);
    }
    try
    {
      localb.setInt(0, paramj.getInt32(0));
      a(localb, 4, paramj);
      b(localb, 8, paramj);
      a(localb, 12, paramj);
      a(localb, 16, paramj);
      a(localb, 20, paramj);
      a(localb, 24, paramj);
      a(localb, 36, paramj);
      a(localb, 40, paramj);
      b(localb, 44, paramj);
      a(localb, 48, paramj);
      int j = paramj.getInt32(52);
      if (j != 0)
      {
        if (j > 538976288) {
          break label284;
        }
        localb.setInt(52, j);
      }
      for (;;)
      {
        b(localb, 64, paramj);
        c(localb, 56, paramj);
        localb.setObject(68, new float[] { paramj.getS15Fixed16(68), paramj.getS15Fixed16(72), paramj.getS15Fixed16(76) });
        j = paramj.getInt32(128);
        localb.setInt(128, j);
        while (i < j)
        {
          int k = i * 12 + 132;
          localb.setByteArray(paramj.getInt32(k), paramj.getBytes(paramj.getInt32(k + 4), paramj.getInt32(k + 8)));
          i += 1;
        }
        label284:
        localb.setString(52, getStringFromInt32(j));
      }
      return;
    }
    catch (IOException paramj)
    {
      localb.addError("Exception reading ICC profile: " + paramj.getMessage());
      paramd.addDirectory(localb);
    }
  }
  
  public Iterable<com.b.a.d.f> getSegmentTypes()
  {
    return Collections.singletonList(com.b.a.d.f.c);
  }
  
  public void readJpegSegments(Iterable<byte[]> paramIterable, com.b.c.d paramd, com.b.a.d.f paramf)
  {
    int i = "ICC_PROFILE".length();
    Iterator localIterator = paramIterable.iterator();
    paramIterable = null;
    while (localIterator.hasNext())
    {
      byte[] arrayOfByte = (byte[])localIterator.next();
      if ((arrayOfByte.length >= i) && ("ICC_PROFILE".equalsIgnoreCase(new String(arrayOfByte, 0, i))))
      {
        if (paramIterable == null)
        {
          paramIterable = new byte[arrayOfByte.length - 14];
          System.arraycopy(arrayOfByte, 14, paramIterable, 0, arrayOfByte.length - 14);
        }
        for (;;)
        {
          break;
          paramf = new byte[paramIterable.length + arrayOfByte.length - 14];
          System.arraycopy(paramIterable, 0, paramf, 0, paramIterable.length);
          System.arraycopy(arrayOfByte, 14, paramf, paramIterable.length, arrayOfByte.length - 14);
          paramIterable = paramf;
        }
      }
    }
    if (paramIterable != null) {
      extract(new com.b.b.b(paramIterable), paramd);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/f/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */