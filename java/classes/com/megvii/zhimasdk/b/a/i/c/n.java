package com.megvii.zhimasdk.b.a.i.c;

import com.megvii.zhimasdk.b.a.c;
import com.megvii.zhimasdk.b.a.j.e;
import com.megvii.zhimasdk.b.a.j.g;
import com.megvii.zhimasdk.b.a.o.d;
import java.nio.charset.Charset;

@Deprecated
public class n
  implements g
{
  private final g a;
  private final r b;
  private final String c;
  
  public n(g paramg, r paramr, String paramString)
  {
    this.a = paramg;
    this.b = paramr;
    if (paramString != null) {}
    for (;;)
    {
      this.c = paramString;
      return;
      paramString = c.b.name();
    }
  }
  
  public void a()
  {
    this.a.a();
  }
  
  public void a(int paramInt)
  {
    this.a.a(paramInt);
    if (this.b.a()) {
      this.b.a(paramInt);
    }
  }
  
  public void a(d paramd)
  {
    this.a.a(paramd);
    if (this.b.a())
    {
      paramd = new String(paramd.b(), 0, paramd.c());
      paramd = paramd + "\r\n";
      this.b.a(paramd.getBytes(this.c));
    }
  }
  
  public void a(String paramString)
  {
    this.a.a(paramString);
    if (this.b.a())
    {
      paramString = paramString + "\r\n";
      this.b.a(paramString.getBytes(this.c));
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a.a(paramArrayOfByte, paramInt1, paramInt2);
    if (this.b.a()) {
      this.b.a(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  public e b()
  {
    return this.a.b();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/c/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */