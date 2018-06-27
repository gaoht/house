package cn.testin.analysis;

import java.util.List;

public final class gw
{
  private final byte[] a;
  private int b;
  private final String c;
  private final List<byte[]> d;
  private final String e;
  private Object f;
  private final int g;
  private final int h;
  
  public gw(byte[] paramArrayOfByte, String paramString1, List<byte[]> paramList, String paramString2, int paramInt1, int paramInt2)
  {
    this.a = paramArrayOfByte;
    if (paramArrayOfByte == null) {}
    for (int i = 0;; i = paramArrayOfByte.length * 8)
    {
      this.b = i;
      this.c = paramString1;
      this.d = paramList;
      this.e = paramString2;
      this.g = paramInt2;
      this.h = paramInt1;
      return;
    }
  }
  
  public void a(Object paramObject)
  {
    this.f = paramObject;
  }
  
  public byte[] a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public List<byte[]> c()
  {
    return this.d;
  }
  
  public String d()
  {
    return this.e;
  }
  
  public Object e()
  {
    return this.f;
  }
  
  public boolean f()
  {
    return (this.g >= 0) && (this.h >= 0);
  }
  
  public int g()
  {
    return this.g;
  }
  
  public int h()
  {
    return this.h;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/gw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */