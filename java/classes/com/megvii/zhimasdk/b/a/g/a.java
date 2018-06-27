package com.megvii.zhimasdk.b.a.g;

import com.megvii.zhimasdk.b.a.e;
import com.megvii.zhimasdk.b.a.k;
import com.megvii.zhimasdk.b.a.k.b;

public abstract class a
  implements k
{
  protected e a;
  protected e b;
  protected boolean c;
  
  public void a(e parame)
  {
    this.a = parame;
  }
  
  public void a(String paramString)
  {
    b localb = null;
    if (paramString != null) {
      localb = new b("Content-Type", paramString);
    }
    a(localb);
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void b(e parame)
  {
    this.b = parame;
  }
  
  @Deprecated
  public void c() {}
  
  public boolean e()
  {
    return this.c;
  }
  
  public e g()
  {
    return this.b;
  }
  
  public e h()
  {
    return this.a;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('[');
    if (this.a != null)
    {
      localStringBuilder.append("Content-Type: ");
      localStringBuilder.append(this.a.d());
      localStringBuilder.append(',');
    }
    if (this.b != null)
    {
      localStringBuilder.append("Content-Encoding: ");
      localStringBuilder.append(this.b.d());
      localStringBuilder.append(',');
    }
    long l = b();
    if (l >= 0L)
    {
      localStringBuilder.append("Content-Length: ");
      localStringBuilder.append(l);
      localStringBuilder.append(',');
    }
    localStringBuilder.append("Chunked: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/g/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */