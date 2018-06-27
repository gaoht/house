package com.megvii.zhimasdk.b.a.o;

public final class h
{
  public static boolean a(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {}
    while (paramCharSequence.length() == 0) {
      return true;
    }
    return false;
  }
  
  public static boolean b(CharSequence paramCharSequence)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramCharSequence == null)
    {
      bool1 = true;
      return bool1;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramCharSequence.length()) {
        break label44;
      }
      bool1 = bool2;
      if (!Character.isWhitespace(paramCharSequence.charAt(i))) {
        break;
      }
      i += 1;
    }
    label44:
    return true;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/o/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */