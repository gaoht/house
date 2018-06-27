package com.megvii.zhimasdk.b.a.n;

import com.megvii.zhimasdk.b.a.o.a;

@Deprecated
public final class c
  implements e
{
  private final e a;
  private final e b;
  
  public c(e parame1, e parame2)
  {
    this.a = ((e)a.a(parame1, "HTTP context"));
    this.b = parame2;
  }
  
  public Object a(String paramString)
  {
    Object localObject2 = this.a.a(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.b.a(paramString);
    }
    return localObject1;
  }
  
  public void a(String paramString, Object paramObject)
  {
    this.a.a(paramString, paramObject);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[local: ").append(this.a);
    localStringBuilder.append("defaults: ").append(this.b);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/n/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */