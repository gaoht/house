package com.f.a.a.a;

public final class e
{
  public static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.length() <= 0);
  }
  
  public static int b(String paramString)
  {
    int i = 0;
    if (paramString.length() > 0)
    {
      paramString = paramString.toCharArray();
      int j = 0;
      for (;;)
      {
        if (i >= paramString.length) {
          return j;
        }
        j = j * 31 + paramString[i];
        i += 1;
      }
    }
    return 0;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/f/a/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */