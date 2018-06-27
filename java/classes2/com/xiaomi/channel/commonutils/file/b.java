package com.xiaomi.channel.commonutils.file;

import java.io.File;
import java.io.FileFilter;

final class b
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return paramFile.isDirectory();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/channel/commonutils/file/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */