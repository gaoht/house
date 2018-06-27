package com.ziroom.ziroomcoloreggs.eggs.a;

public class a
{
  private static String a(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramInt)
    {
      localStringBuffer.append("\t");
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String format(String paramString)
  {
    int j = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    if (j < paramString.length())
    {
      char c = paramString.charAt(j);
      if ((i > 0) && ('\n' == localStringBuffer.charAt(localStringBuffer.length() - 1))) {
        localStringBuffer.append(a(i));
      }
      switch (c)
      {
      default: 
        localStringBuffer.append(c);
      }
      for (;;)
      {
        j += 1;
        break;
        localStringBuffer.append(c + "\n");
        i += 1;
        continue;
        localStringBuffer.append(c + "\n");
        continue;
        localStringBuffer.append("\n");
        i -= 1;
        localStringBuffer.append(a(i));
        localStringBuffer.append(c);
      }
    }
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcoloreggs/eggs/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */