package com.b.c.d;

import com.b.c.d;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class c
{
  public void read(File paramFile, d paramd)
    throws IOException
  {
    if (!paramFile.isFile()) {
      throw new IOException("File object must reference a file");
    }
    if (!paramFile.exists()) {
      throw new IOException("File does not exist");
    }
    if (!paramFile.canRead()) {
      throw new IOException("File is not readable");
    }
    b localb = new b();
    localb.setString(1, paramFile.getName());
    localb.setLong(2, paramFile.length());
    localb.setDate(3, new Date(paramFile.lastModified()));
    paramd.addDirectory(localb);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */