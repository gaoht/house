package com.megvii.zhimasdk.b.a.o;

public class b
{
  public static void a(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      throw new IllegalStateException(paramString + " is null");
    }
  }
  
  public static void a(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(paramString);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/o/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */