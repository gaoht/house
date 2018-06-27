package com.a.a.a;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class b
{
  private byte[] a;
  private int b;
  private String c = null;
  
  public b(int paramInt)
  {
    this.a = new byte[paramInt];
    this.b = 0;
  }
  
  public b(InputStream paramInputStream)
    throws IOException
  {
    this.b = 0;
    this.a = new byte['䀀'];
    for (;;)
    {
      int i = paramInputStream.read(this.a, this.b, 16384);
      if (i <= 0) {
        break;
      }
      this.b += i;
      if (i != 16384) {
        break;
      }
      a(this.b + 16384);
    }
  }
  
  public b(byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte;
    this.b = paramArrayOfByte.length;
  }
  
  public b(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt > paramArrayOfByte.length) {
      throw new ArrayIndexOutOfBoundsException("Valid length exceeds the buffer length.");
    }
    this.a = paramArrayOfByte;
    this.b = paramInt;
  }
  
  public b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 > paramArrayOfByte.length - paramInt1) {
      throw new ArrayIndexOutOfBoundsException("Valid length exceeds the buffer length.");
    }
    this.a = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, this.a, 0, paramInt2);
    this.b = paramInt2;
  }
  
  private void a(int paramInt)
  {
    if (paramInt > this.a.length)
    {
      byte[] arrayOfByte = this.a;
      this.a = new byte[arrayOfByte.length * 2];
      System.arraycopy(arrayOfByte, 0, this.a, 0, arrayOfByte.length);
    }
  }
  
  public void append(byte paramByte)
  {
    a(this.b + 1);
    byte[] arrayOfByte = this.a;
    int i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = paramByte;
  }
  
  public void append(b paramb)
  {
    append(paramb.a, 0, paramb.b);
  }
  
  public void append(byte[] paramArrayOfByte)
  {
    append(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void append(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    a(this.b + paramInt2);
    System.arraycopy(paramArrayOfByte, paramInt1, this.a, this.b, paramInt2);
    this.b += paramInt2;
  }
  
  public byte byteAt(int paramInt)
  {
    if (paramInt < this.b) {
      return this.a[paramInt];
    }
    throw new IndexOutOfBoundsException("The index exceeds the valid buffer area");
  }
  
  public int charAt(int paramInt)
  {
    if (paramInt < this.b) {
      return this.a[paramInt] & 0xFF;
    }
    throw new IndexOutOfBoundsException("The index exceeds the valid buffer area");
  }
  
  public InputStream getByteStream()
  {
    return new ByteArrayInputStream(this.a, 0, this.b);
  }
  
  public String getEncoding()
  {
    if (this.c == null)
    {
      if (this.b >= 2) {
        break label26;
      }
      this.c = "UTF-8";
    }
    for (;;)
    {
      return this.c;
      label26:
      if (this.a[0] == 0)
      {
        if ((this.b < 4) || (this.a[1] != 0)) {
          this.c = "UTF-16BE";
        } else if (((this.a[2] & 0xFF) == 254) && ((this.a[3] & 0xFF) == 255)) {
          this.c = "UTF-32BE";
        } else {
          this.c = "UTF-32";
        }
      }
      else if ((this.a[0] & 0xFF) < 128)
      {
        if (this.a[1] != 0) {
          this.c = "UTF-8";
        } else if ((this.b < 4) || (this.a[2] != 0)) {
          this.c = "UTF-16LE";
        } else {
          this.c = "UTF-32LE";
        }
      }
      else if ((this.a[0] & 0xFF) == 239) {
        this.c = "UTF-8";
      } else if ((this.a[0] & 0xFF) == 254) {
        this.c = "UTF-16";
      } else if ((this.b < 4) || (this.a[2] != 0)) {
        this.c = "UTF-16";
      } else {
        this.c = "UTF-32";
      }
    }
  }
  
  public int length()
  {
    return this.b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/a/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */