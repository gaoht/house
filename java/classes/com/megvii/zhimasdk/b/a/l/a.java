package com.megvii.zhimasdk.b.a.l;

@Deprecated
public abstract class a
  implements e
{
  public int a(String paramString, int paramInt)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return paramInt;
    }
    return ((Integer)paramString).intValue();
  }
  
  public long a(String paramString, long paramLong)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return paramLong;
    }
    return ((Long)paramString).longValue();
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return paramBoolean;
    }
    return ((Boolean)paramString).booleanValue();
  }
  
  public e b(String paramString, int paramInt)
  {
    a(paramString, Integer.valueOf(paramInt));
    return this;
  }
  
  public e b(String paramString, long paramLong)
  {
    a(paramString, Long.valueOf(paramLong));
    return this;
  }
  
  public e b(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Boolean localBoolean = Boolean.TRUE;; localBoolean = Boolean.FALSE)
    {
      a(paramString, localBoolean);
      return this;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/megvii/zhimasdk/b/a/l/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */