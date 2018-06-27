package cn.testin.analysis;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class fb
  extends FilterOutputStream
{
  private boolean a;
  private int b;
  private byte[] c;
  private int d;
  private int e;
  private boolean f;
  private byte[] g;
  private boolean h;
  private int i;
  private byte[] j;
  
  public fb(OutputStream paramOutputStream, int paramInt)
  {
    super(paramOutputStream);
    boolean bool1;
    if ((paramInt & 0x8) != 0)
    {
      bool1 = true;
      this.f = bool1;
      if ((paramInt & 0x1) == 0) {
        break label106;
      }
      bool1 = bool2;
      label34:
      this.a = bool1;
      if (!this.a) {
        break label112;
      }
    }
    label106:
    label112:
    for (int k = 3;; k = 4)
    {
      this.d = k;
      this.c = new byte[this.d];
      this.b = 0;
      this.e = 0;
      this.h = false;
      this.g = new byte[4];
      this.i = paramInt;
      this.j = fa.a(paramInt);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label34;
    }
  }
  
  public void a()
  {
    if (this.b > 0)
    {
      if (this.a)
      {
        this.out.write(fa.a(this.g, this.c, this.b, this.i));
        this.b = 0;
      }
    }
    else {
      return;
    }
    throw new IOException("Base64 input not properly padded.");
  }
  
  public void close()
  {
    a();
    super.close();
    this.c = null;
    this.out = null;
  }
  
  public void write(int paramInt)
  {
    if (this.h) {
      this.out.write(paramInt);
    }
    do
    {
      do
      {
        do
        {
          return;
          if (!this.a) {
            break;
          }
          arrayOfByte = this.c;
          k = this.b;
          this.b = (k + 1);
          arrayOfByte[k] = ((byte)paramInt);
        } while (this.b < this.d);
        this.out.write(fa.a(this.g, this.c, this.d, this.i));
        this.e += 4;
        if ((this.f) && (this.e >= 76))
        {
          this.out.write(10);
          this.e = 0;
        }
        this.b = 0;
        return;
        if (this.j[(paramInt & 0x7F)] <= -5) {
          break;
        }
        byte[] arrayOfByte = this.c;
        int k = this.b;
        this.b = (k + 1);
        arrayOfByte[k] = ((byte)paramInt);
      } while (this.b < this.d);
      paramInt = fa.a(this.c, 0, this.g, 0, this.i);
      this.out.write(this.g, 0, paramInt);
      this.b = 0;
      return;
    } while (this.j[(paramInt & 0x7F)] == -5);
    throw new IOException("Invalid character in Base64 data.");
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.h) {
      this.out.write(paramArrayOfByte, paramInt1, paramInt2);
    }
    for (;;)
    {
      return;
      int k = 0;
      while (k < paramInt2)
      {
        write(paramArrayOfByte[(paramInt1 + k)]);
        k += 1;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/fb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */