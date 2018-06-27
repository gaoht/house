package com.pgyersdk.i;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class j
{
  private static final char[] a = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
  private boolean b = false;
  private boolean c = false;
  private ByteArrayOutputStream d = new ByteArrayOutputStream();
  private String e;
  
  public j()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Random localRandom = new Random();
    while (i < 30)
    {
      localStringBuffer.append(a[localRandom.nextInt(a.length)]);
      i += 1;
    }
    this.e = localStringBuffer.toString();
  }
  
  public String a()
  {
    return this.e;
  }
  
  public void a(String paramString1, String paramString2)
  {
    b();
    this.d.write(("Content-Disposition: form-data; name=\"" + paramString1 + "\"\r\n").getBytes());
    this.d.write("Content-Type: text/plain; charset=UTF-8\r\n".getBytes());
    this.d.write("Content-Transfer-Encoding: 8bit\r\n\r\n".getBytes());
    this.d.write(paramString2.getBytes());
    this.d.write(("\r\n--" + this.e + "\r\n").getBytes());
  }
  
  public void a(String paramString1, String paramString2, InputStream paramInputStream, String paramString3, boolean paramBoolean)
  {
    b();
    try
    {
      paramString3 = "Content-Type: " + paramString3 + "\r\n";
      this.d.write(("Content-Disposition: form-data; name=\"" + paramString1 + "\"; filename=\"" + paramString2 + "\"\r\n").getBytes());
      this.d.write(paramString3.getBytes());
      this.d.write("Content-Transfer-Encoding: binary\r\n\r\n".getBytes());
      paramString1 = new byte['က'];
      for (;;)
      {
        int i = paramInputStream.read(paramString1);
        if (i == -1) {
          break;
        }
        this.d.write(paramString1, 0, i);
      }
      try
      {
        paramInputStream.close();
        throw paramString1;
        this.d.flush();
        if (paramBoolean) {
          c();
        }
        for (;;)
        {
          try
          {
            paramInputStream.close();
            return;
          }
          catch (IOException paramString1)
          {
            paramString1.printStackTrace();
            return;
          }
          this.d.write(("\r\n--" + this.e + "\r\n").getBytes());
        }
      }
      catch (IOException paramString2)
      {
        for (;;)
        {
          paramString2.printStackTrace();
        }
      }
    }
    finally {}
  }
  
  public void a(String paramString1, String paramString2, InputStream paramInputStream, boolean paramBoolean)
  {
    a(paramString1, paramString2, paramInputStream, "application/octet-stream", paramBoolean);
  }
  
  public void b()
  {
    if (!this.c) {
      this.d.write(("--" + this.e + "\r\n").getBytes());
    }
    this.c = true;
  }
  
  public void c()
  {
    if (this.b) {
      return;
    }
    try
    {
      this.d.write(("\r\n--" + this.e + "--\r\n").getBytes());
      this.b = true;
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  public long d()
  {
    c();
    return this.d.toByteArray().length;
  }
  
  public ByteArrayOutputStream e()
  {
    c();
    return this.d;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/i/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */