package com.facebook.common.file;

import java.io.File;

public class FileTree
{
  public static boolean deleteContents(File paramFile)
  {
    paramFile = paramFile.listFiles();
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramFile != null)
    {
      int j = paramFile.length;
      int i = 0;
      for (;;)
      {
        bool2 = bool1;
        if (i >= j) {
          break;
        }
        bool2 = deleteRecursively(paramFile[i]);
        i += 1;
        bool1 = bool2 & bool1;
      }
    }
    return bool2;
  }
  
  public static boolean deleteRecursively(File paramFile)
  {
    if (paramFile.isDirectory()) {
      deleteContents(paramFile);
    }
    return paramFile.delete();
  }
  
  public static void walkFileTree(File paramFile, FileTreeVisitor paramFileTreeVisitor)
  {
    paramFileTreeVisitor.preVisitDirectory(paramFile);
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      int i = 0;
      if (i < j)
      {
        File localFile = arrayOfFile[i];
        if (localFile.isDirectory()) {
          walkFileTree(localFile, paramFileTreeVisitor);
        }
        for (;;)
        {
          i += 1;
          break;
          paramFileTreeVisitor.visitFile(localFile);
        }
      }
    }
    paramFileTreeVisitor.postVisitDirectory(paramFile);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/common/file/FileTree.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */