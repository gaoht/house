package com.megvii.zhimasdk.b;

import android.text.TextUtils;
import com.megvii.zhimasdk.b.a.e;
import com.megvii.zhimasdk.b.a.k;
import com.megvii.zhimasdk.b.a.k.b;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

class t
  implements k
{
  private static final byte[] a = "\r\n".getBytes();
  private static final byte[] b = "Content-Transfer-Encoding: binary\r\n".getBytes();
  private static final char[] c = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
  private final String d;
  private final byte[] e;
  private final byte[] f;
  private final List<a> g = new ArrayList();
  private final ByteArrayOutputStream h = new ByteArrayOutputStream();
  private final r i;
  private boolean j;
  private long k;
  private long l;
  
  public t(r paramr)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Random localRandom = new Random();
    int m = 0;
    while (m < 30)
    {
      localStringBuilder.append(c[localRandom.nextInt(c.length)]);
      m += 1;
    }
    this.d = localStringBuilder.toString();
    this.e = ("--" + this.d + "\r\n").getBytes();
    this.f = ("--" + this.d + "--" + "\r\n").getBytes();
    this.i = paramr;
  }
  
  private String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "application/octet-stream";
    }
    return str;
  }
  
  private void a(long paramLong)
  {
    this.k += paramLong;
    this.i.b(this.k, this.l);
  }
  
  private byte[] a(String paramString1, String paramString2)
  {
    return ("Content-Disposition: form-data; name=\"" + paramString1 + "\"" + "; filename=\"" + paramString2 + "\"" + "\r\n").getBytes();
  }
  
  private byte[] b(String paramString)
  {
    return ("Content-Type: " + a(paramString) + "\r\n").getBytes();
  }
  
  private byte[] c(String paramString)
  {
    return ("Content-Disposition: form-data; name=\"" + paramString + "\"" + "\r\n").getBytes();
  }
  
  public InputStream a()
  {
    throw new UnsupportedOperationException("getContent() is not supported. Use writeTo() instead.");
  }
  
  public void a(OutputStream paramOutputStream)
  {
    this.k = 0L;
    this.l = ((int)b());
    this.h.writeTo(paramOutputStream);
    a(this.h.size());
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a(paramOutputStream);
    }
    paramOutputStream.write(this.f);
    a(this.f.length);
  }
  
  public void a(String paramString1, File paramFile, String paramString2, String paramString3)
  {
    this.g.add(new a(paramString1, paramFile, a(paramString2), paramString3));
  }
  
  public void a(String paramString1, String paramString2, InputStream paramInputStream, String paramString3)
  {
    this.h.write(this.e);
    this.h.write(a(paramString1, paramString2));
    this.h.write(b(paramString3));
    this.h.write(b);
    this.h.write(a);
    paramString1 = new byte['က'];
    for (;;)
    {
      int m = paramInputStream.read(paramString1);
      if (m == -1) {
        break;
      }
      this.h.write(paramString1, 0, m);
    }
    this.h.write(a);
    this.h.flush();
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      this.h.write(this.e);
      this.h.write(c(paramString1));
      this.h.write(b(paramString3));
      this.h.write(a);
      this.h.write(paramString2.getBytes());
      this.h.write(a);
      return;
    }
    catch (IOException paramString1)
    {
      a.a.b("SimpleMultipartEntity", "addPart ByteArrayOutputStream exception", paramString1);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public long b()
  {
    long l1 = this.h.size();
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext())
    {
      long l2 = ((a)localIterator.next()).a();
      if (l2 < 0L) {
        return -1L;
      }
      l1 = l2 + l1;
    }
    return this.f.length + l1;
  }
  
  public void b(String paramString1, String paramString2, String paramString3)
  {
    String str = paramString3;
    if (paramString3 == null) {
      str = "UTF-8";
    }
    a(paramString1, paramString2, "text/plain; charset=" + str);
  }
  
  public void c()
  {
    if (f()) {
      throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
    }
  }
  
  public boolean d()
  {
    return this.j;
  }
  
  public boolean e()
  {
    return false;
  }
  
  public boolean f()
  {
    return false;
  }
  
  public e g()
  {
    return null;
  }
  
  public e h()
  {
    return new b("Content-Type", "multipart/form-data; boundary=" + this.d);
  }
  
  private class a
  {
    public final File a;
    public final byte[] b;
    
    public a(String paramString1, File paramFile, String paramString2, String paramString3)
    {
      this$1 = paramString3;
      if (TextUtils.isEmpty(paramString3)) {
        this$1 = paramFile.getName();
      }
      this.b = a(paramString1, t.this, paramString2);
      this.a = paramFile;
    }
    
    private byte[] a(String paramString1, String paramString2, String paramString3)
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      try
      {
        localByteArrayOutputStream.write(t.a(t.this));
        localByteArrayOutputStream.write(t.a(t.this, paramString1, paramString2));
        localByteArrayOutputStream.write(t.a(t.this, paramString3));
        localByteArrayOutputStream.write(t.i());
        localByteArrayOutputStream.write(t.j());
        return localByteArrayOutputStream.toByteArray();
      }
      catch (IOException paramString1)
      {
        for (;;)
        {
          a.a.b("SimpleMultipartEntity", "createHeader ByteArrayOutputStream exception", paramString1);
        }
      }
    }
    
    public long a()
    {
      return this.a.length() + t.j().length + this.b.length;
    }
    
    public void a(OutputStream paramOutputStream)
    {
      paramOutputStream.write(this.b);
      t.a(t.this, this.b.length);
      FileInputStream localFileInputStream = new FileInputStream(this.a);
      byte[] arrayOfByte = new byte['က'];
      for (;;)
      {
        int i = localFileInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        paramOutputStream.write(arrayOfByte, 0, i);
        t.a(t.this, i);
      }
      paramOutputStream.write(t.j());
      t.a(t.this, t.j().length);
      paramOutputStream.flush();
      a.a(localFileInputStream);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */