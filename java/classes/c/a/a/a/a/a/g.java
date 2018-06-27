package c.a.a.a.a.a;

import c.a.a.a.a.a.a.b;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

public class g
  implements HttpEntity
{
  private static final char[] MULTIPART_CHARS = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
  private Header contentType;
  private volatile boolean dirty;
  private long length;
  private c multipart;
  
  public g()
  {
    this(d.a, null, null);
  }
  
  public g(d paramd)
  {
    this(paramd, null, null);
  }
  
  public g(d paramd, String paramString, Charset paramCharset)
  {
    String str = paramString;
    if (paramString == null) {
      str = generateBoundary();
    }
    paramString = paramd;
    if (paramd == null) {
      paramString = d.a;
    }
    this.multipart = new c("form-data", paramCharset, str, paramString);
    this.contentType = new BasicHeader("Content-Type", generateContentType(str, paramCharset));
    this.dirty = true;
  }
  
  public static String generateBoundary()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Random localRandom = new Random();
    int j = localRandom.nextInt(11);
    int i = 0;
    while (i < j + 30)
    {
      localStringBuilder.append(MULTIPART_CHARS[localRandom.nextInt(MULTIPART_CHARS.length)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public void addPart(a parama)
  {
    this.multipart.addBodyPart(parama);
    this.dirty = true;
  }
  
  public void addPart(String paramString, b paramb)
  {
    addPart(new a(paramString, paramb));
  }
  
  public void consumeContent()
    throws IOException, UnsupportedOperationException
  {
    if (isStreaming()) {
      throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
    }
  }
  
  protected String generateContentType(String paramString, Charset paramCharset)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("multipart/form-data; boundary=");
    localStringBuilder.append(paramString);
    if (paramCharset != null)
    {
      localStringBuilder.append("; charset=");
      localStringBuilder.append(paramCharset.name());
    }
    return localStringBuilder.toString();
  }
  
  public InputStream getContent()
    throws IOException, UnsupportedOperationException
  {
    throw new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
  }
  
  public Header getContentEncoding()
  {
    return null;
  }
  
  public long getContentLength()
  {
    if (this.dirty)
    {
      this.length = this.multipart.getTotalLength();
      this.dirty = false;
    }
    return this.length;
  }
  
  public Header getContentType()
  {
    return this.contentType;
  }
  
  public boolean isChunked()
  {
    return !isRepeatable();
  }
  
  public boolean isRepeatable()
  {
    Iterator localIterator = this.multipart.getBodyParts().iterator();
    while (localIterator.hasNext()) {
      if (((a)localIterator.next()).getBody().getContentLength() < 0L) {
        return false;
      }
    }
    return true;
  }
  
  public boolean isStreaming()
  {
    return !isRepeatable();
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    this.multipart.writeTo(paramOutputStream);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/c/a/a/a/a/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */