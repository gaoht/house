package com.b.a.a;

import com.b.b.o;
import com.b.c.b.c;
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
    FileInputStream localFileInputStream;
    try
    {
      localFileInputStream = new FileInputStream(paramFile);
      if (localFileInputStream == null) {
        break label35;
      }
    }
    finally
    {
      try
      {
        paramFile = readMetadata(localFileInputStream);
        if (localFileInputStream != null) {
          localFileInputStream.close();
        }
        return paramFile;
      }
      finally {}
      paramFile = finally;
      localFileInputStream = null;
    }
    localFileInputStream.close();
    label35:
    throw paramFile;
  }
  
  public static d readMetadata(InputStream paramInputStream)
  {
    d locald = new d();
    new c().extract(new o(paramInputStream), locald);
    return locald;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */