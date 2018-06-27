package com.megvii.zhimasdk.b.a.i.b;

import com.megvii.zhimasdk.b.a.l.e;

@Deprecated
public class g
  extends com.megvii.zhimasdk.b.a.l.a
{
  protected final e a;
  protected final e b;
  protected final e c;
  protected final e d;
  
  public g(e parame1, e parame2, e parame3, e parame4)
  {
    this.a = parame1;
    this.b = parame2;
    this.c = parame3;
    this.d = parame4;
  }
  
  public e a(String paramString, Object paramObject)
  {
    throw new UnsupportedOperationException("Setting parameters in a stack is not supported.");
  }
  
  public Object a(String paramString)
  {
    com.megvii.zhimasdk.b.a.o.a.a(paramString, "Parameter name");
    Object localObject2 = null;
    if (this.d != null) {
      localObject2 = this.d.a(paramString);
    }
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (this.c != null) {
        localObject1 = this.c.a(paramString);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (this.b != null) {
        localObject2 = this.b.a(paramString);
      }
    }
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (this.a != null) {
        localObject1 = this.a.a(paramString);
      }
    }
    return localObject1;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */