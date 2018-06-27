package com.b.a.b;

import com.b.b.o;
import com.b.c.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class a
{
  public static d readMetadata(File paramFile)
    throws IOException
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
  {
    d locald = new d();
    new com.b.c.e.c().extract(new o(paramInputStream), locald);
    return locald;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/a/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */