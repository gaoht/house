package com.b.a.g;

import com.b.b.o;
import com.b.c.d;
import com.b.c.d.c;
import com.b.c.m.h;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class a
{
  public static d readMetadata(File paramFile)
    throws IOException
  {
    d locald = new d();
    FileInputStream localFileInputStream = new FileInputStream(paramFile);
    try
    {
      new h().extract(new o(localFileInputStream), locald);
      localFileInputStream.close();
      new c().read(paramFile, locald);
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
    new h().extract(new o(paramInputStream), locald);
    return locald;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/a/g/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */