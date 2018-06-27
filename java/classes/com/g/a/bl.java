package com.g.a;

import java.io.File;
import java.util.Comparator;

class bl
  implements Comparator
{
  bl(bk parambk) {}
  
  public int a(File paramFile1, File paramFile2)
  {
    return paramFile1.getName().compareTo(paramFile2.getName());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */