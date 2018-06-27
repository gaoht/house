package com.b.a.f;

import com.b.b.k;
import com.b.b.m;
import com.b.b.n;
import com.b.b.o;
import com.b.b.p;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.zip.InflaterInputStream;

public class g
{
  private static Set<d> a;
  
  static
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add(d.a);
    localHashSet.add(d.b);
    localHashSet.add(d.l);
    localHashSet.add(d.e);
    localHashSet.add(d.i);
    localHashSet.add(d.f);
    localHashSet.add(d.g);
    localHashSet.add(d.j);
    localHashSet.add(d.q);
    localHashSet.add(d.p);
    localHashSet.add(d.o);
    localHashSet.add(d.m);
    localHashSet.add(d.h);
    a = Collections.unmodifiableSet(localHashSet);
  }
  
  private static void a(com.b.c.d paramd, b paramb)
    throws h, IOException
  {
    Object localObject2 = paramb.getType();
    Object localObject1 = paramb.getBytes();
    if (((d)localObject2).equals(d.a))
    {
      paramb = new f((byte[])localObject1);
      localObject1 = new com.b.c.n.c(d.a);
      ((com.b.c.n.c)localObject1).setInt(1, paramb.getImageWidth());
      ((com.b.c.n.c)localObject1).setInt(2, paramb.getImageHeight());
      ((com.b.c.n.c)localObject1).setInt(3, paramb.getBitsPerSample());
      ((com.b.c.n.c)localObject1).setInt(4, paramb.getColorType().getNumericValue());
      ((com.b.c.n.c)localObject1).setInt(5, paramb.getCompressionType());
      ((com.b.c.n.c)localObject1).setInt(6, paramb.getFilterMethod());
      ((com.b.c.n.c)localObject1).setInt(7, paramb.getInterlaceMethod());
      paramd.addDirectory((com.b.c.b)localObject1);
    }
    label919:
    label971:
    do
    {
      int i;
      int j;
      int k;
      for (;;)
      {
        return;
        if (((d)localObject2).equals(d.b))
        {
          paramb = new com.b.c.n.c(d.b);
          paramb.setInt(8, localObject1.length / 3);
          paramd.addDirectory(paramb);
          return;
        }
        if (((d)localObject2).equals(d.l))
        {
          paramb = new com.b.c.n.c(d.l);
          paramb.setInt(9, 1);
          paramd.addDirectory(paramb);
          return;
        }
        if (((d)localObject2).equals(d.i))
        {
          i = localObject1[0];
          paramb = new com.b.c.n.c(d.i);
          paramb.setInt(10, i);
          paramd.addDirectory(paramb);
          return;
        }
        if (((d)localObject2).equals(d.e))
        {
          paramb = new a((byte[])localObject1);
          localObject1 = new com.b.c.n.a();
          ((com.b.c.n.a)localObject1).setInt(1, paramb.getWhitePointX());
          ((com.b.c.n.a)localObject1).setInt(2, paramb.getWhitePointY());
          ((com.b.c.n.a)localObject1).setInt(3, paramb.getRedX());
          ((com.b.c.n.a)localObject1).setInt(4, paramb.getRedY());
          ((com.b.c.n.a)localObject1).setInt(5, paramb.getGreenX());
          ((com.b.c.n.a)localObject1).setInt(6, paramb.getGreenY());
          ((com.b.c.n.a)localObject1).setInt(7, paramb.getBlueX());
          ((com.b.c.n.a)localObject1).setInt(8, paramb.getBlueY());
          paramd.addDirectory((com.b.c.b)localObject1);
          return;
        }
        if (((d)localObject2).equals(d.f))
        {
          i = com.b.b.c.toInt32BigEndian((byte[])localObject1);
          new m((byte[])localObject1).getInt32();
          paramb = new com.b.c.n.c(d.f);
          paramb.setDouble(11, i / 100000.0D);
          paramd.addDirectory(paramb);
          return;
        }
        if (((d)localObject2).equals(d.g))
        {
          localObject2 = new m((byte[])localObject1);
          localObject3 = ((n)localObject2).getNullTerminatedString(79);
          paramb = new com.b.c.n.c(d.g);
          paramb.setString(12, (String)localObject3);
          if (((n)localObject2).getInt8() == 0)
          {
            localObject1 = new InflaterInputStream(new ByteArrayInputStream(((n)localObject2).getBytes(localObject1.length - ((String)localObject3).length() - 2)));
            new com.b.c.f.c().extract(new k((InputStream)localObject1), paramd, paramb);
            ((InflaterInputStream)localObject1).close();
          }
          for (;;)
          {
            paramd.addDirectory(paramb);
            return;
            paramb.addError("Invalid compression method value");
          }
        }
        if (((d)localObject2).equals(d.j))
        {
          paramb = new com.b.c.n.c(d.j);
          paramb.setByteArray(15, (byte[])localObject1);
          paramd.addDirectory(paramb);
          return;
        }
        if (((d)localObject2).equals(d.q))
        {
          localObject2 = new m((byte[])localObject1);
          paramb = ((n)localObject2).getNullTerminatedString(79);
          localObject2 = ((n)localObject2).getNullTerminatedString(localObject1.length - paramb.length() - 1);
          localObject1 = new ArrayList();
          ((List)localObject1).add(new com.b.b.h(paramb, (String)localObject2));
          paramb = new com.b.c.n.c(d.p);
          paramb.setObject(13, localObject1);
          paramd.addDirectory(paramb);
          return;
        }
        if (!((d)localObject2).equals(d.p)) {
          break label971;
        }
        Object localObject3 = new m((byte[])localObject1);
        localObject2 = ((n)localObject3).getNullTerminatedString(79);
        i = ((n)localObject3).getInt8();
        j = ((n)localObject3).getInt8();
        paramb = ((n)localObject3).getNullTerminatedString(localObject1.length);
        String str = ((n)localObject3).getNullTerminatedString(localObject1.length);
        k = localObject1.length - ((String)localObject2).length() - 1 - 1 - 1 - paramb.length() - 1 - str.length() - 1;
        paramb = null;
        if (i == 0) {
          paramb = ((n)localObject3).getNullTerminatedString(k);
        }
        while (paramb != null)
        {
          if (!((String)localObject2).equals("XML:com.adobe.xmp")) {
            break label919;
          }
          new com.b.c.q.c().extract(paramb, paramd);
          return;
          if (i == 1)
          {
            if (j == 0)
            {
              paramb = p.fromStream(new InflaterInputStream(new ByteArrayInputStream((byte[])localObject1, localObject1.length - k, k)));
            }
            else
            {
              localObject1 = new com.b.c.n.c(d.p);
              ((com.b.c.n.c)localObject1).addError("Invalid compression method value");
              paramd.addDirectory((com.b.c.b)localObject1);
            }
          }
          else
          {
            localObject1 = new com.b.c.n.c(d.p);
            ((com.b.c.n.c)localObject1).addError("Invalid compression flag value");
            paramd.addDirectory((com.b.c.b)localObject1);
          }
        }
      }
      localObject1 = new ArrayList();
      ((List)localObject1).add(new com.b.b.h((String)localObject2, paramb));
      paramb = new com.b.c.n.c(d.p);
      paramb.setObject(13, localObject1);
      paramd.addDirectory(paramb);
      return;
      if (((d)localObject2).equals(d.o))
      {
        paramb = new m((byte[])localObject1);
        i = paramb.getUInt16();
        j = paramb.getUInt8();
        k = paramb.getUInt8();
        int m = paramb.getUInt8();
        int n = paramb.getUInt8();
        int i1 = paramb.getUInt8();
        paramb = new com.b.c.n.c(d.o);
        if ((com.b.b.f.isValidDate(i, j - 1, k)) && (com.b.b.f.isValidTime(m, n, i1))) {
          paramb.setString(14, String.format("%04d:%02d:%02d %02d:%02d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1) }));
        }
        for (;;)
        {
          paramd.addDirectory(paramb);
          return;
          paramb.addError(String.format("PNG tIME data describes an invalid date/time: year=%d month=%d day=%d hour=%d minute=%d second=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1) }));
        }
      }
      if (((d)localObject2).equals(d.m))
      {
        paramb = new m((byte[])localObject1);
        i = paramb.getInt32();
        j = paramb.getInt32();
        k = paramb.getInt8();
        paramb = new com.b.c.n.c(d.m);
        paramb.setInt(16, i);
        paramb.setInt(17, j);
        paramb.setInt(18, k);
        paramd.addDirectory(paramb);
        return;
      }
    } while (!((d)localObject2).equals(d.h));
    paramb = new com.b.c.n.c(d.h);
    paramb.setByteArray(19, (byte[])localObject1);
    paramd.addDirectory(paramb);
  }
  
  public static com.b.c.d readMetadata(File paramFile)
    throws h, IOException
  {
    FileInputStream localFileInputStream = new FileInputStream(paramFile);
    try
    {
      com.b.c.d locald = readMetadata(localFileInputStream);
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
    throws h, IOException
  {
    Object localObject = new c().extract(new o(paramInputStream), a);
    paramInputStream = new com.b.c.d();
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      b localb = (b)((Iterator)localObject).next();
      try
      {
        a(paramInputStream, localb);
      }
      catch (Exception localException)
      {
        localException.printStackTrace(System.err);
      }
    }
    return paramInputStream;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/a/f/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */