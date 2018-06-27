package c.a.a.a.a.a;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.util.ByteArrayBuffer;

public class c
{
  private static final ByteArrayBuffer a = a(e.a, ": ");
  private static final ByteArrayBuffer b = a(e.a, "\r\n");
  private static final ByteArrayBuffer c = a(e.a, "--");
  private final String d;
  private final Charset e;
  private final String f;
  private final List<a> g;
  private final d h;
  
  public c(String paramString1, String paramString2)
  {
    this(paramString1, null, paramString2);
  }
  
  public c(String paramString1, Charset paramCharset, String paramString2)
  {
    this(paramString1, paramCharset, paramString2, d.a);
  }
  
  public c(String paramString1, Charset paramCharset, String paramString2, d paramd)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("Multipart subtype may not be null");
    }
    if (paramString2 == null) {
      throw new IllegalArgumentException("Multipart boundary may not be null");
    }
    this.d = paramString1;
    if (paramCharset != null) {}
    for (;;)
    {
      this.e = paramCharset;
      this.f = paramString2;
      this.g = new ArrayList();
      this.h = paramd;
      return;
      paramCharset = e.a;
    }
  }
  
  private static ByteArrayBuffer a(Charset paramCharset, String paramString)
  {
    paramCharset = paramCharset.encode(CharBuffer.wrap(paramString));
    paramString = new ByteArrayBuffer(paramCharset.remaining());
    paramString.append(paramCharset.array(), paramCharset.position(), paramCharset.remaining());
    return paramString;
  }
  
  private void a(d paramd, OutputStream paramOutputStream, boolean paramBoolean)
    throws IOException
  {
    ByteArrayBuffer localByteArrayBuffer = a(this.e, getBoundary());
    Iterator localIterator = this.g.iterator();
    if (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      a(c, paramOutputStream);
      a(localByteArrayBuffer, paramOutputStream);
      a(b, paramOutputStream);
      Object localObject = locala.getHeader();
      switch (1.a[paramd.ordinal()])
      {
      }
      for (;;)
      {
        a(b, paramOutputStream);
        if (paramBoolean) {
          locala.getBody().writeTo(paramOutputStream);
        }
        a(b, paramOutputStream);
        break;
        localObject = ((b)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          a((f)((Iterator)localObject).next(), paramOutputStream);
        }
        a(locala.getHeader().getField("Content-Disposition"), this.e, paramOutputStream);
        if (locala.getBody().getFilename() != null) {
          a(locala.getHeader().getField("Content-Type"), this.e, paramOutputStream);
        }
      }
    }
    a(c, paramOutputStream);
    a(localByteArrayBuffer, paramOutputStream);
    a(c, paramOutputStream);
    a(b, paramOutputStream);
  }
  
  private static void a(f paramf, OutputStream paramOutputStream)
    throws IOException
  {
    a(paramf.getName(), paramOutputStream);
    a(a, paramOutputStream);
    a(paramf.getBody(), paramOutputStream);
    a(b, paramOutputStream);
  }
  
  private static void a(f paramf, Charset paramCharset, OutputStream paramOutputStream)
    throws IOException
  {
    a(paramf.getName(), paramCharset, paramOutputStream);
    a(a, paramOutputStream);
    a(paramf.getBody(), paramCharset, paramOutputStream);
    a(b, paramOutputStream);
  }
  
  private static void a(String paramString, OutputStream paramOutputStream)
    throws IOException
  {
    a(a(e.a, paramString), paramOutputStream);
  }
  
  private static void a(String paramString, Charset paramCharset, OutputStream paramOutputStream)
    throws IOException
  {
    a(a(paramCharset, paramString), paramOutputStream);
  }
  
  private static void a(ByteArrayBuffer paramByteArrayBuffer, OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(paramByteArrayBuffer.buffer(), 0, paramByteArrayBuffer.length());
  }
  
  public void addBodyPart(a parama)
  {
    if (parama == null) {
      return;
    }
    this.g.add(parama);
  }
  
  public List<a> getBodyParts()
  {
    return this.g;
  }
  
  public String getBoundary()
  {
    return this.f;
  }
  
  public Charset getCharset()
  {
    return this.e;
  }
  
  public d getMode()
  {
    return this.h;
  }
  
  public String getSubType()
  {
    return this.d;
  }
  
  public long getTotalLength()
  {
    Object localObject = this.g.iterator();
    long l1 = 0L;
    while (((Iterator)localObject).hasNext())
    {
      long l2 = ((a)((Iterator)localObject).next()).getBody().getContentLength();
      if (l2 >= 0L) {
        l1 = l2 + l1;
      } else {
        return -1L;
      }
    }
    localObject = new ByteArrayOutputStream();
    try
    {
      a(this.h, (OutputStream)localObject, false);
      int i = ((ByteArrayOutputStream)localObject).toByteArray().length;
      return i + l1;
    }
    catch (IOException localIOException) {}
    return -1L;
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    a(this.h, paramOutputStream, true);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/c/a/a/a/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */