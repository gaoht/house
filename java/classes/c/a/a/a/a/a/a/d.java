package c.a.a.a.a.a.a;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class d
  extends a
{
  private final File a;
  private final String b;
  private final String c;
  
  public d(File paramFile)
  {
    this(paramFile, "application/octet-stream");
  }
  
  public d(File paramFile, String paramString)
  {
    this(paramFile, paramString, null);
  }
  
  public d(File paramFile, String paramString1, String paramString2)
  {
    this(paramFile, null, paramString1, paramString2);
  }
  
  public d(File paramFile, String paramString1, String paramString2, String paramString3)
  {
    super(paramString2);
    if (paramFile == null) {
      throw new IllegalArgumentException("File may not be null");
    }
    this.a = paramFile;
    if (paramString1 != null) {}
    for (this.b = paramString1;; this.b = paramFile.getName())
    {
      this.c = paramString3;
      return;
    }
  }
  
  public String getCharset()
  {
    return this.c;
  }
  
  public long getContentLength()
  {
    return this.a.length();
  }
  
  public File getFile()
  {
    return this.a;
  }
  
  public String getFilename()
  {
    return this.b;
  }
  
  public InputStream getInputStream()
    throws IOException
  {
    return new FileInputStream(this.a);
  }
  
  public String getTransferEncoding()
  {
    return "binary";
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    if (paramOutputStream == null) {
      throw new IllegalArgumentException("Output stream may not be null");
    }
    FileInputStream localFileInputStream = new FileInputStream(this.a);
    try
    {
      byte[] arrayOfByte = new byte['က'];
      for (;;)
      {
        int i = localFileInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        paramOutputStream.write(arrayOfByte, 0, i);
      }
    }
    finally
    {
      localFileInputStream.close();
    }
    localFileInputStream.close();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/c/a/a/a/a/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */