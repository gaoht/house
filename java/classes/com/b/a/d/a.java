package com.b.a.d;

import com.b.b.o;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class a
{
  public static final Iterable<d> a = Arrays.asList(new d[] { new com.b.c.k.g(), new com.b.c.k.c(), new com.b.c.i.c(), new com.b.c.j.c(), new com.b.c.c.g(), new com.b.c.q.c(), new com.b.c.f.c(), new com.b.c.m.e(), new com.b.c.m.b(), new com.b.c.h.c(), new com.b.c.a.c() });
  
  public static void process(com.b.c.d paramd, InputStream paramInputStream)
    throws b, IOException
  {
    process(paramd, paramInputStream, null);
  }
  
  public static void process(com.b.c.d paramd, InputStream paramInputStream, Iterable<d> paramIterable)
    throws b, IOException
  {
    Object localObject = paramIterable;
    if (paramIterable == null) {
      localObject = a;
    }
    paramIterable = new HashSet();
    Iterator localIterator1 = ((Iterable)localObject).iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((d)localIterator1.next()).getSegmentTypes().iterator();
      while (localIterator2.hasNext()) {
        paramIterable.add((f)localIterator2.next());
      }
    }
    processJpegSegmentData(paramd, (Iterable)localObject, e.readSegments(new o(paramInputStream), paramIterable));
  }
  
  public static void processJpegSegmentData(com.b.c.d paramd, Iterable<d> paramIterable, c paramc)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      d locald = (d)paramIterable.next();
      Iterator localIterator = locald.getSegmentTypes().iterator();
      while (localIterator.hasNext())
      {
        f localf = (f)localIterator.next();
        locald.readJpegSegments(paramc.getSegments(localf), paramd, localf);
      }
    }
  }
  
  public static com.b.c.d readMetadata(File paramFile)
    throws b, IOException
  {
    return readMetadata(paramFile, null);
  }
  
  public static com.b.c.d readMetadata(File paramFile, Iterable<d> paramIterable)
    throws b, IOException
  {
    FileInputStream localFileInputStream = new FileInputStream(paramFile);
    try
    {
      paramIterable = readMetadata(localFileInputStream, paramIterable);
      localFileInputStream.close();
      new com.b.c.d.c().read(paramFile, paramIterable);
      return paramIterable;
    }
    finally
    {
      localFileInputStream.close();
    }
  }
  
  public static com.b.c.d readMetadata(InputStream paramInputStream)
    throws b, IOException
  {
    return readMetadata(paramInputStream, null);
  }
  
  public static com.b.c.d readMetadata(InputStream paramInputStream, Iterable<d> paramIterable)
    throws b, IOException
  {
    com.b.c.d locald = new com.b.c.d();
    process(locald, paramInputStream, paramIterable);
    return locald;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/a/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */