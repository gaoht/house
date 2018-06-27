package com.pgyersdk.c;

import java.io.File;
import java.io.FilenameFilter;

final class f
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.endsWith(".stacktrace");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/c/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */