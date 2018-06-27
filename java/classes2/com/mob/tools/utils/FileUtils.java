package com.mob.tools.utils;

import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;

public class FileUtils
{
  public static void closeIO(Closeable... paramVarArgs)
  {
    if (paramVarArgs == null) {
      return;
    }
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Closeable localCloseable = paramVarArgs[i];
      if (localCloseable != null) {}
      try
      {
        localCloseable.close();
        i += 1;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          MobLog.getInstance().d(localThrowable);
        }
      }
    }
  }
  
  public static boolean createFileByDeleteOldFile(File paramFile)
  {
    if (paramFile == null) {}
    while (((paramFile.exists()) && (!paramFile.delete())) || (!createOrExistsDir(paramFile.getParentFile()))) {
      return false;
    }
    try
    {
      boolean bool = paramFile.createNewFile();
      return bool;
    }
    catch (Throwable paramFile)
    {
      MobLog.getInstance().d(paramFile);
    }
    return false;
  }
  
  public static boolean createOrExistsDir(File paramFile)
  {
    if (paramFile != null) {
      if (paramFile.exists())
      {
        if (!paramFile.isDirectory()) {}
      }
      else {
        while (paramFile.mkdirs()) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean deleteAllInDir(File paramFile)
  {
    deleteFilesInDirWithFilter(paramFile, new FileFilter()
    {
      public boolean accept(File paramAnonymousFile)
      {
        return true;
      }
    });
  }
  
  public static boolean deleteAllInDir(String paramString)
  {
    return deleteAllInDir(getFileByPath(paramString));
  }
  
  public static boolean deleteDir(File paramFile)
  {
    if (paramFile == null) {}
    int i;
    File localFile;
    do
    {
      do
      {
        return false;
        if (!paramFile.exists()) {
          return true;
        }
      } while (!paramFile.isDirectory());
      File[] arrayOfFile = paramFile.listFiles();
      if ((arrayOfFile == null) || (arrayOfFile.length == 0)) {
        break label92;
      }
      int j = arrayOfFile.length;
      i = 0;
      if (i >= j) {
        break label92;
      }
      localFile = arrayOfFile[i];
      if (!localFile.isFile()) {
        break;
      }
    } while (!localFile.delete());
    while ((!localFile.isDirectory()) || (deleteDir(localFile)))
    {
      i += 1;
      break;
    }
    return false;
    label92:
    return paramFile.delete();
  }
  
  public static boolean deleteFile(File paramFile)
  {
    return (paramFile != null) && ((!paramFile.exists()) || ((paramFile.isFile()) && (paramFile.delete())));
  }
  
  public static boolean deleteFile(String paramString)
  {
    return deleteFile(getFileByPath(paramString));
  }
  
  public static boolean deleteFilesInDirWithFilter(File paramFile, FileFilter paramFileFilter)
  {
    if (paramFile == null) {}
    int i;
    File localFile;
    do
    {
      do
      {
        return false;
        if (!paramFile.exists()) {
          return true;
        }
      } while (!paramFile.isDirectory());
      paramFile = paramFile.listFiles();
      if ((paramFile == null) || (paramFile.length == 0)) {
        break label103;
      }
      int j = paramFile.length;
      i = 0;
      if (i >= j) {
        break label103;
      }
      localFile = paramFile[i];
      if (!paramFileFilter.accept(localFile)) {
        break;
      }
      if (!localFile.isFile()) {
        break label85;
      }
    } while (!localFile.delete());
    label85:
    while ((!localFile.isDirectory()) || (deleteDir(localFile)))
    {
      i += 1;
      break;
    }
    return false;
    label103:
    return true;
  }
  
  public static File getFileByPath(String paramString)
  {
    if (isSpace(paramString)) {
      return null;
    }
    return new File(paramString);
  }
  
  private static boolean isSpace(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return true;
      int j = paramString.length();
      int i = 0;
      while (i < j)
      {
        if (!Character.isWhitespace(paramString.charAt(i))) {
          return false;
        }
        i += 1;
      }
    }
  }
  
  public static boolean rename(File paramFile, String paramString)
  {
    boolean bool = true;
    if (paramFile == null) {}
    while ((!paramFile.exists()) || (isSpace(paramString))) {
      return false;
    }
    if (paramString.equals(paramFile.getName())) {
      return true;
    }
    paramString = new File(paramFile.getParent() + File.separator + paramString);
    if ((!paramString.exists()) && (paramFile.renameTo(paramString))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean rename(String paramString1, String paramString2)
  {
    return rename(getFileByPath(paramString1), paramString2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/tools/utils/FileUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */