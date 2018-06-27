package com.megvii.zhimasdk.b.a.e;

import com.megvii.zhimasdk.b.a.n;
import com.megvii.zhimasdk.b.a.o.a;
import java.net.InetAddress;
import java.net.InetSocketAddress;

@Deprecated
public class m
  extends InetSocketAddress
{
  private final n a;
  
  public m(n paramn, InetAddress paramInetAddress, int paramInt)
  {
    super(paramInetAddress, paramInt);
    a.a(paramn, "HTTP host");
    this.a = paramn;
  }
  
  public n a()
  {
    return this.a;
  }
  
  public String toString()
  {
    return this.a.a() + ":" + getPort();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/e/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */