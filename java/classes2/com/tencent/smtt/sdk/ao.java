package com.tencent.smtt.sdk;

import java.io.File;
import java.io.FileFilter;

class ao
  implements FileFilter
{
  ao(am paramam) {}
  
  public boolean accept(File paramFile)
  {
    return paramFile.getName().endsWith("tbs.conf");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/sdk/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */