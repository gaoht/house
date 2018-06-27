package com.b.c.c;

import com.b.a.d.f;
import com.b.a.j.e;
import com.b.b.j;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;

public class g
  implements com.b.a.d.d
{
  private boolean b = true;
  
  static
  {
    if (!g.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public void extract(j paramj, com.b.c.d paramd)
  {
    extract(paramj, paramd, 0);
  }
  
  public void extract(j paramj, com.b.c.d paramd, int paramInt)
  {
    extract(paramj, paramd, paramInt, null);
  }
  
  public void extract(j paramj, com.b.c.d paramd, int paramInt, com.b.c.b paramb)
  {
    try
    {
      new e().processTiff(paramj, new l(paramd, this.b, paramb), paramInt);
      return;
    }
    catch (com.b.a.j.d paramj)
    {
      paramj.printStackTrace(System.err);
      return;
    }
    catch (IOException paramj)
    {
      paramj.printStackTrace(System.err);
    }
  }
  
  public Iterable<f> getSegmentTypes()
  {
    return Collections.singletonList(f.b);
  }
  
  public boolean isStoreThumbnailBytes()
  {
    return this.b;
  }
  
  public void readJpegSegments(Iterable<byte[]> paramIterable, com.b.c.d paramd, f paramf)
  {
    if ((!a) && (paramf != f.b)) {
      throw new AssertionError();
    }
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      paramf = (byte[])paramIterable.next();
      if ((paramf.length >= "Exif\000\000".length()) && (new String(paramf, 0, "Exif\000\000".length()).equals("Exif\000\000"))) {
        extract(new com.b.b.b(paramf), paramd, "Exif\000\000".length());
      }
    }
  }
  
  public void setStoreThumbnailBytes(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/c/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */