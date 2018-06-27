package com.ziroom.ziroomcustomer.minsu.chat.d;

public enum b
{
  private String e;
  
  private b(String paramString)
  {
    this.e = paramString;
  }
  
  public static b getType(String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return null;
        if (paramString.equals("txt"))
        {
          i = 0;
          continue;
          if (paramString.equals("img"))
          {
            i = 1;
            continue;
            if (paramString.equals("loc"))
            {
              i = 2;
              continue;
              if (paramString.equals("audio")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    return a;
    return b;
    return c;
    return d;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */