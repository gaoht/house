package com.b.a.j;

import com.b.b.i;
import com.b.b.j;
import com.b.b.k;
import com.b.c.c.l;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

public class c
{
  public static com.b.c.d readMetadata(j paramj)
    throws IOException, d
  {
    com.b.c.d locald = new com.b.c.d();
    l locall = new l(locald, false, null);
    new e().processTiff(paramj, locall, 0);
    return locald;
  }
  
  public static com.b.c.d readMetadata(File paramFile)
    throws IOException, d
  {
    com.b.c.d locald = new com.b.c.d();
    RandomAccessFile localRandomAccessFile = new RandomAccessFile(paramFile, "r");
    try
    {
      l locall = new l(locald, false, null);
      new e().processTiff(new i(localRandomAccessFile), locall, 0);
      localRandomAccessFile.close();
      new com.b.c.d.c().read(paramFile, locald);
      return locald;
    }
    finally
    {
      localRandomAccessFile.close();
    }
  }
  
  public static com.b.c.d readMetadata(InputStream paramInputStream)
    throws IOException, d
  {
    return readMetadata(new k(paramInputStream));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/a/j/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */