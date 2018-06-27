package com.b.a;

import com.b.a.f.g;
import com.b.b.p;
import com.b.c.e;
import com.b.c.f;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class c
{
  private c()
    throws Exception
  {
    throw new Exception("Not intended for instantiation");
  }
  
  public static void main(String[] paramArrayOfString)
    throws e, IOException
  {
    ArrayList localArrayList = new ArrayList(Arrays.asList(paramArrayOfString));
    boolean bool1 = localArrayList.remove("-thumb");
    boolean bool2 = localArrayList.remove("-markdown");
    boolean bool3 = localArrayList.remove("-hex");
    Object localObject2;
    Object localObject3;
    Object localObject1;
    if (localArrayList.size() < 1)
    {
      localObject2 = c.class.getPackage().getImplementationVersion();
      System.out.println("metadata-extractor version " + (String)localObject2);
      System.out.println();
      localObject3 = System.out;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "a.b.c";
      }
      ((PrintStream)localObject3).println(String.format("Usage: java -jar metadata-extractor-%s.jar <filename> [<filename>] [-thumb] [-markdown] [-hex]", new Object[] { localObject1 }));
      System.exit(1);
    }
    Iterator localIterator1 = localArrayList.iterator();
    while (localIterator1.hasNext())
    {
      localObject2 = (String)localIterator1.next();
      long l1 = System.nanoTime();
      localObject3 = new File((String)localObject2);
      if ((!bool2) && (localArrayList.size() > 1)) {
        System.out.printf("\n***** PROCESSING: %s\n%n", new Object[] { localObject2 });
      }
      com.b.c.c.k localk;
      try
      {
        localObject1 = readMetadata((File)localObject3);
        long l2 = System.nanoTime();
        if (!bool2) {
          System.out.printf("Processed %.3f MB file in %.2f ms%n%n", new Object[] { Double.valueOf(((File)localObject3).length() / 1048576.0D), Double.valueOf((l2 - l1) / 1000000.0D) });
        }
        Object localObject4;
        if (bool2)
        {
          localObject4 = ((File)localObject3).getName();
          localObject5 = p.urlEncode((String)localObject2);
          localObject3 = (com.b.c.c.d)((com.b.c.d)localObject1).getFirstDirectoryOfType(com.b.c.c.d.class);
          if (localObject3 == null)
          {
            localObject2 = "";
            if (localObject3 != null) {
              break label670;
            }
            localObject3 = "";
            System.out.println();
            System.out.println("---");
            System.out.println();
            System.out.printf("# %s - %s%n", new Object[] { localObject2, localObject3 });
            System.out.println();
            System.out.printf("<a href=\"https://raw.githubusercontent.com/drewnoakes/metadata-extractor-images/master/%s\">%n", new Object[] { localObject5 });
            System.out.printf("<img src=\"https://raw.githubusercontent.com/drewnoakes/metadata-extractor-images/master/%s\" width=\"300\"/><br/>%n", new Object[] { localObject5 });
            System.out.println((String)localObject4);
            System.out.println("</a>");
            System.out.println();
            System.out.println("Directory | Tag Id | Tag Name | Extracted Value");
            System.out.println(":--------:|-------:|----------|----------------");
          }
        }
        else
        {
          localObject4 = ((com.b.c.d)localObject1).getDirectories().iterator();
          if (!((Iterator)localObject4).hasNext()) {
            break label820;
          }
          localObject5 = (com.b.c.b)((Iterator)localObject4).next();
          str1 = ((com.b.c.b)localObject5).getName();
          Iterator localIterator2 = ((com.b.c.b)localObject5).getTags().iterator();
          for (;;)
          {
            if (!localIterator2.hasNext()) {
              break label757;
            }
            localf = (f)localIterator2.next();
            str2 = localf.getTagName();
            localObject3 = localf.getDescription();
            localObject2 = localObject3;
            if (localObject3 != null)
            {
              localObject2 = localObject3;
              if (((String)localObject3).length() > 1024) {
                localObject2 = ((String)localObject3).substring(0, 1024) + "...";
              }
            }
            if (!bool2) {
              break;
            }
            System.out.printf("%s|0x%s|%s|%s%n", new Object[] { str1, Integer.toHexString(localf.getTagType()), str2, localObject2 });
          }
        }
      }
      catch (Exception localException)
      {
        Object localObject5;
        for (;;)
        {
          String str1;
          f localf;
          String str2;
          localException.printStackTrace(System.err);
          System.exit(1);
          localk = null;
          continue;
          localObject2 = ((com.b.c.c.d)localObject3).getString(271);
          continue;
          label670:
          localObject3 = ((com.b.c.c.d)localObject3).getString(272);
          continue;
          if (bool3) {
            System.out.printf("[%s - %s] %s = %s%n", new Object[] { str1, localf.getTagTypeHex(), str2, localObject2 });
          } else {
            System.out.printf("[%s] %s = %s%n", new Object[] { str1, str2, localObject2 });
          }
        }
        label757:
        localObject2 = ((com.b.c.b)localObject5).getErrors().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          System.err.println("ERROR: " + (String)localObject3);
        }
      }
      label820:
      if ((paramArrayOfString.length > 1) && (bool1))
      {
        localk = (com.b.c.c.k)localk.getFirstDirectoryOfType(com.b.c.c.k.class);
        if ((localk != null) && (localk.hasThumbnailData()))
        {
          System.out.println("Writing thumbnail...");
          localk.writeThumbnail(paramArrayOfString[0].trim() + ".thumb.jpg");
        }
        else
        {
          System.out.println("No thumbnail data exists in this image");
        }
      }
    }
  }
  
  public static com.b.c.d readMetadata(File paramFile)
    throws d, IOException
  {
    FileInputStream localFileInputStream = new FileInputStream(paramFile);
    try
    {
      com.b.c.d locald = readMetadata(localFileInputStream, paramFile.length());
      localFileInputStream.close();
      new com.b.c.d.c().read(paramFile, locald);
      return locald;
    }
    finally
    {
      localFileInputStream.close();
    }
  }
  
  public static com.b.c.d readMetadata(InputStream paramInputStream)
    throws d, IOException
  {
    return readMetadata(paramInputStream, -1L);
  }
  
  public static com.b.c.d readMetadata(InputStream paramInputStream, long paramLong)
    throws d, IOException
  {
    if ((paramInputStream instanceof BufferedInputStream)) {}
    a locala;
    for (paramInputStream = (BufferedInputStream)paramInputStream;; paramInputStream = new BufferedInputStream(paramInputStream))
    {
      locala = b.detectFileType(paramInputStream);
      if (locala != a.b) {
        break;
      }
      return com.b.a.d.a.readMetadata(paramInputStream);
    }
    if ((locala == a.c) || (locala == a.k) || (locala == a.m) || (locala == a.n) || (locala == a.o) || (locala == a.q)) {
      return com.b.a.j.c.readMetadata(new com.b.b.k(paramInputStream, 2048, paramLong));
    }
    if (locala == a.d) {
      return com.b.a.g.a.readMetadata(paramInputStream);
    }
    if (locala == a.e) {
      return g.readMetadata(paramInputStream);
    }
    if (locala == a.f) {
      return com.b.a.a.a.readMetadata(paramInputStream);
    }
    if (locala == a.g) {
      return com.b.a.b.a.readMetadata(paramInputStream);
    }
    if (locala == a.h) {
      return com.b.a.c.a.readMetadata(paramInputStream);
    }
    if (locala == a.i) {
      return com.b.a.e.a.readMetadata(paramInputStream);
    }
    if (locala == a.j) {
      return com.b.a.k.a.readMetadata(paramInputStream);
    }
    if (locala == a.p) {
      return com.b.a.h.a.readMetadata(paramInputStream);
    }
    throw new d("File format is not supported");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */