package com.alibaba.fastjson;

public enum l
{
  private l() {}
  
  public String translate(String paramString)
  {
    int j = 0;
    int i = 0;
    switch (1.a[ordinal()])
    {
    }
    do
    {
      do
      {
        return paramString;
        StringBuilder localStringBuilder = new StringBuilder();
        char c1;
        if (i < paramString.length())
        {
          c1 = paramString.charAt(i);
          if ((c1 >= 'A') && (c1 <= 'Z'))
          {
            c1 = (char)(c1 + ' ');
            if (i > 0) {
              localStringBuilder.append('_');
            }
            localStringBuilder.append(c1);
          }
          for (;;)
          {
            i += 1;
            break;
            localStringBuilder.append(c1);
          }
        }
        return localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        i = j;
        if (i < paramString.length())
        {
          c1 = paramString.charAt(i);
          if ((c1 >= 'A') && (c1 <= 'Z'))
          {
            c1 = (char)(c1 + ' ');
            if (i > 0) {
              localStringBuilder.append('-');
            }
            localStringBuilder.append(c1);
          }
          for (;;)
          {
            i += 1;
            break;
            localStringBuilder.append(c1);
          }
        }
        return localStringBuilder.toString();
        i = paramString.charAt(0);
      } while ((i < 97) || (i > 122));
      paramString = paramString.toCharArray();
      paramString[0] = ((char)(paramString[0] - ' '));
      return new String(paramString);
      i = paramString.charAt(0);
    } while ((i < 65) || (i > 90));
    paramString = paramString.toCharArray();
    paramString[0] = ((char)(paramString[0] + ' '));
    return new String(paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */