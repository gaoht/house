package com.megvii.zhimasdk.b.a.n;

import com.megvii.zhimasdk.b.a.o.a;
import com.megvii.zhimasdk.b.a.q;
import com.megvii.zhimasdk.b.a.r;

public class m
  implements r
{
  private final String a;
  
  public m()
  {
    this(null);
  }
  
  public m(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(q paramq, e parame)
  {
    a.a(paramq, "HTTP request");
    if (!paramq.a("User-Agent"))
    {
      parame = null;
      Object localObject = paramq.g();
      if (localObject != null) {
        parame = (String)((com.megvii.zhimasdk.b.a.l.e)localObject).a("http.useragent");
      }
      localObject = parame;
      if (parame == null) {
        localObject = this.a;
      }
      if (localObject != null) {
        paramq.a("User-Agent", (String)localObject);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/n/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */