package com.megvii.zhimasdk.b;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class f
  extends FilterOutputStream
{
  private static final byte[] a = new byte[0];
  private final d.a b;
  private final int c;
  private byte[] d = null;
  private int e = 0;
  
  public f(OutputStream paramOutputStream, int paramInt)
  {
    this(paramOutputStream, paramInt, true);
  }
  
  public f(OutputStream paramOutputStream, int paramInt, boolean paramBoolean)
  {
    super(paramOutputStream);
    this.c = paramInt;
    if (paramBoolean)
    {
      this.b = new d.c(paramInt, null);
      return;
    }
    this.b = new d.b(paramInt, null);
  }
  
  private void a()
  {
    if (this.e > 0)
    {
      a(this.d, 0, this.e, false);
      this.e = 0;
    }
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.b.a = a(this.b.a, this.b.a(paramInt2));
    if (!this.b.a(paramArrayOfByte, paramInt1, paramInt2, paramBoolean)) {
      throw new e("bad base-64");
    }
    this.out.write(this.b.a, 0, this.b.b);
  }
  
  private byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte;
    if (paramArrayOfByte != null)
    {
      arrayOfByte = paramArrayOfByte;
      if (paramArrayOfByte.length >= paramInt) {}
    }
    else
    {
      arrayOfByte = new byte[paramInt];
    }
    return arrayOfByte;
  }
  
  public void close()
  {
    Object localObject1 = null;
    try
    {
      a();
      a(a, 0, 0, true);
      try
      {
        if ((this.c & 0x10) != 0) {
          break label45;
        }
        this.out.close();
        localObject2 = localObject1;
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          Object localObject2;
          if (localIOException1 == null) {
            IOException localIOException3 = localIOException1;
          }
        }
      }
      if (localObject2 != null) {
        throw ((Throwable)localObject2);
      }
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        continue;
        label45:
        this.out.flush();
      }
    }
  }
  
  public void write(int paramInt)
  {
    if (this.d == null) {
      this.d = new byte['Ѐ'];
    }
    if (this.e >= this.d.length)
    {
      a(this.d, 0, this.e, false);
      this.e = 0;
    }
    byte[] arrayOfByte = this.d;
    int i = this.e;
    this.e = (i + 1);
    arrayOfByte[i] = ((byte)paramInt);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 <= 0) {
      return;
    }
    a();
    a(paramArrayOfByte, paramInt1, paramInt2, false);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */