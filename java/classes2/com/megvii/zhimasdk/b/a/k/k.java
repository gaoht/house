package com.megvii.zhimasdk.b.a.k;

import com.megvii.zhimasdk.b.a.e;
import com.megvii.zhimasdk.b.a.h;
import com.megvii.zhimasdk.b.a.o.a;
import com.megvii.zhimasdk.b.a.o.b;
import java.util.List;
import java.util.NoSuchElementException;

public class k
  implements h
{
  protected final List<e> a;
  protected int b;
  protected int c;
  protected String d;
  
  public k(List<e> paramList, String paramString)
  {
    this.a = ((List)a.a(paramList, "Header list"));
    this.d = paramString;
    this.b = a(-1);
    this.c = -1;
  }
  
  protected int a(int paramInt)
  {
    if (paramInt < -1) {
      return -1;
    }
    int i = this.a.size();
    for (boolean bool = false; (!bool) && (paramInt < i - 1); bool = b(paramInt)) {
      paramInt += 1;
    }
    if (bool) {}
    for (;;)
    {
      return paramInt;
      paramInt = -1;
    }
  }
  
  public e a()
  {
    int i = this.b;
    if (i < 0) {
      throw new NoSuchElementException("Iteration already finished.");
    }
    this.c = i;
    this.b = a(i);
    return (e)this.a.get(i);
  }
  
  protected boolean b(int paramInt)
  {
    if (this.d == null) {
      return true;
    }
    String str = ((e)this.a.get(paramInt)).c();
    return this.d.equalsIgnoreCase(str);
  }
  
  public boolean hasNext()
  {
    return this.b >= 0;
  }
  
  public final Object next()
  {
    return a();
  }
  
  public void remove()
  {
    if (this.c >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      b.a(bool, "No header to remove");
      this.a.remove(this.c);
      this.c = -1;
      this.b -= 1;
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/k/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */