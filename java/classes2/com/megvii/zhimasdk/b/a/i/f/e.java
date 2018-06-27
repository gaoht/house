package com.megvii.zhimasdk.b.a.i.f;

import com.megvii.zhimasdk.b.a.ah;
import com.megvii.zhimasdk.b.a.j.f;
import com.megvii.zhimasdk.b.a.m;
import com.megvii.zhimasdk.b.a.o.d;
import com.megvii.zhimasdk.b.a.w;
import java.io.IOException;
import java.io.InputStream;

public class e
  extends InputStream
{
  private final f a;
  private final d b;
  private int c;
  private int d;
  private int e;
  private boolean f = false;
  private boolean g = false;
  private com.megvii.zhimasdk.b.a.e[] h = new com.megvii.zhimasdk.b.a.e[0];
  
  public e(f paramf)
  {
    this.a = ((f)com.megvii.zhimasdk.b.a.o.a.a(paramf, "Session input buffer"));
    this.e = 0;
    this.b = new d(16);
    this.c = 1;
  }
  
  private void a()
  {
    this.d = b();
    if (this.d < 0) {
      throw new w("Negative chunk size");
    }
    this.c = 2;
    this.e = 0;
    if (this.d == 0)
    {
      this.f = true;
      c();
    }
  }
  
  private int b()
  {
    switch (this.c)
    {
    case 2: 
    default: 
      throw new IllegalStateException("Inconsistent codec web_state");
    case 3: 
      this.b.a();
      if (this.a.a(this.b) != -1) {
        break;
      }
    }
    do
    {
      return 0;
      if (!this.b.d()) {
        throw new w("Unexpected content at the end of chunk");
      }
      this.c = 1;
      this.b.a();
    } while (this.a.a(this.b) == -1);
    int j = this.b.c(59);
    int i = j;
    if (j < 0) {
      i = this.b.c();
    }
    try
    {
      i = Integer.parseInt(this.b.b(0, i), 16);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw new w("Bad chunk header");
    }
  }
  
  private void c()
  {
    try
    {
      this.h = a.a(this.a, -1, -1, null);
      return;
    }
    catch (m localm)
    {
      w localw = new w("Invalid footer: " + localm.getMessage());
      localw.initCause(localm);
      throw localw;
    }
  }
  
  public int available()
  {
    if ((this.a instanceof com.megvii.zhimasdk.b.a.j.a)) {
      return Math.min(((com.megvii.zhimasdk.b.a.j.a)this.a).e(), this.d - this.e);
    }
    return 0;
  }
  
  public void close()
  {
    if (!this.g) {}
    try
    {
      if (!this.f)
      {
        byte[] arrayOfByte = new byte['ࠀ'];
        int i;
        do
        {
          i = read(arrayOfByte);
        } while (i >= 0);
      }
      return;
    }
    finally
    {
      this.f = true;
      this.g = true;
    }
  }
  
  public int read()
  {
    if (this.g) {
      throw new IOException("Attempted read from closed stream.");
    }
    if (this.f) {}
    do
    {
      return -1;
      if (this.c == 2) {
        break;
      }
      a();
    } while (this.f);
    int i = this.a.a();
    if (i != -1)
    {
      this.e += 1;
      if (this.e >= this.d) {
        this.c = 3;
      }
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.g) {
      throw new IOException("Attempted read from closed stream.");
    }
    if (this.f) {}
    do
    {
      return -1;
      if (this.c == 2) {
        break;
      }
      a();
    } while (this.f);
    paramInt1 = this.a.a(paramArrayOfByte, paramInt1, Math.min(paramInt2, this.d - this.e));
    if (paramInt1 != -1)
    {
      this.e += paramInt1;
      if (this.e >= this.d) {
        this.c = 3;
      }
      return paramInt1;
    }
    this.f = true;
    throw new ah("Truncated chunk ( expected size: " + this.d + "; actual size: " + this.e + ")");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/f/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */