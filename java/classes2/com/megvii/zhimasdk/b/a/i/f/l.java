package com.megvii.zhimasdk.b.a.i.f;

import com.megvii.zhimasdk.b.a.j.f;
import java.io.InputStream;

public class l
  extends InputStream
{
  private final f a;
  private boolean b = false;
  
  public l(f paramf)
  {
    this.a = ((f)com.megvii.zhimasdk.b.a.o.a.a(paramf, "Session input buffer"));
  }
  
  public int available()
  {
    if ((this.a instanceof com.megvii.zhimasdk.b.a.j.a)) {
      return ((com.megvii.zhimasdk.b.a.j.a)this.a).e();
    }
    return 0;
  }
  
  public void close()
  {
    this.b = true;
  }
  
  public int read()
  {
    if (this.b) {
      return -1;
    }
    return this.a.a();
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.b) {
      return -1;
    }
    return this.a.a(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/f/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */