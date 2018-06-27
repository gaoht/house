package com.megvii.zhimasdk.b.a.i.d;

import com.megvii.zhimasdk.b.a.f.n;
import java.util.Date;

public class d
  extends c
  implements n
{
  private String a;
  private int[] b;
  private boolean c;
  
  public d(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void a(int[] paramArrayOfInt)
  {
    this.b = paramArrayOfInt;
  }
  
  public boolean a(Date paramDate)
  {
    return (this.c) || (super.a(paramDate));
  }
  
  public void a_(String paramString)
  {
    this.a = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public Object clone()
  {
    d locald = (d)super.clone();
    if (this.b != null) {
      locald.b = ((int[])this.b.clone());
    }
    return locald;
  }
  
  public int[] f()
  {
    return this.b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/d/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */