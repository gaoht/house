package com.megvii.zhimasdk.b.a.k;

import com.megvii.zhimasdk.b.a.ac;
import com.megvii.zhimasdk.b.a.ae;
import com.megvii.zhimasdk.b.a.o.a;
import com.megvii.zhimasdk.b.a.o.d;
import java.io.Serializable;

public class m
  implements ae, Serializable, Cloneable
{
  private final ac a;
  private final String b;
  private final String c;
  
  public m(String paramString1, String paramString2, ac paramac)
  {
    this.b = ((String)a.a(paramString1, "Method"));
    this.c = ((String)a.a(paramString2, "URI"));
    this.a = ((ac)a.a(paramac, "Version"));
  }
  
  public String a()
  {
    return this.b;
  }
  
  public ac b()
  {
    return this.a;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public Object clone()
  {
    return super.clone();
  }
  
  public String toString()
  {
    return i.b.a(null, this).toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/k/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */