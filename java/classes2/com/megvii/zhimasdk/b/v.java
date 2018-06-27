package com.megvii.zhimasdk.b;

class v
{
  public static <T> T a(T paramT, String paramString)
  {
    if (paramT == null) {
      throw new IllegalArgumentException(paramString + " should not be null!");
    }
    return paramT;
  }
  
  public static void a(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean) {
      throw new AssertionError(paramString);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */