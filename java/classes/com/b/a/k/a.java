package com.b.a.k;

import com.b.a.i.b;
import com.b.b.o;
import com.b.c.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class a
{
  public static d readMetadata(File paramFile)
    throws IOException, b
  {
    FileInputStream localFileInputStream = new FileInputStream(paramFile);
    try
    {
      d locald = readMetadata(localFileInputStream);
      localFileInputStream.close();
      new com.b.c.d.c().read(paramFile, locald);
      return locald;
    }
    finally
    {
      localFileInputStream.close();
    }
  }
  
  public static d readMetadata(InputStream paramInputStream)
    throws IOException, b
  {
    d locald = new d();
    new com.b.a.i.c().processRiff(new o(paramInputStream), new com.b.c.p.c(locald));
    return locald;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/a/k/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */