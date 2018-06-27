package com.hyphenate.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtils
{
  private static final int BUFF_SIZE = 1048576;
  
  public static void zip(File paramFile1, File paramFile2)
    throws IOException
  {
    if (!paramFile1.exists()) {
      return;
    }
    paramFile2 = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(paramFile2), 1048576));
    zipFiles(paramFile1, paramFile2, "");
    paramFile2.flush();
    paramFile2.close();
  }
  
  static void zipFile(File paramFile, ZipOutputStream paramZipOutputStream, String paramString)
    throws IOException
  {
    byte[] arrayOfByte = new byte[1048576];
    BufferedInputStream localBufferedInputStream = new BufferedInputStream(new FileInputStream(paramFile), 1048576);
    if ("".equals(paramString)) {
      paramFile.getName();
    }
    for (;;)
    {
      paramZipOutputStream.putNextEntry(new ZipEntry(paramString));
      for (;;)
      {
        int i = localBufferedInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        paramZipOutputStream.write(arrayOfByte, 0, i);
      }
      new StringBuilder().append(paramString).append("\\").append(paramFile.getName()).toString();
    }
    localBufferedInputStream.close();
    paramZipOutputStream.flush();
    paramZipOutputStream.closeEntry();
  }
  
  static void zipFiles(File paramFile, ZipOutputStream paramZipOutputStream, String paramString)
    throws IOException
  {
    if (!paramFile.exists()) {}
    for (;;)
    {
      return;
      if (!paramFile.isDirectory()) {
        break;
      }
      paramFile = paramFile.listFiles();
      if (paramFile != null)
      {
        int j = paramFile.length;
        int i = 0;
        while (i < j)
        {
          File localFile = paramFile[i];
          zipFiles(localFile, paramZipOutputStream, paramString + "\\" + localFile.getName());
          i += 1;
        }
      }
    }
    zipFile(paramFile, paramZipOutputStream, paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/util/ZipUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */