package com.a.a.a;

import java.io.IOException;
import java.io.PushbackReader;
import java.io.Reader;

public class d
  extends PushbackReader
{
  private int a = 0;
  private int b = 0;
  private int c = 0;
  
  public d(Reader paramReader)
  {
    super(paramReader, 8);
  }
  
  private char a(char paramChar)
  {
    switch (this.a)
    {
    default: 
    case 0: 
      do
      {
        return paramChar;
      } while (paramChar != '&');
      this.a = 1;
      return paramChar;
    case 1: 
      if (paramChar == '#')
      {
        this.a = 2;
        return paramChar;
      }
      this.a = 5;
      return paramChar;
    case 2: 
      if (paramChar == 'x')
      {
        this.b = 0;
        this.c = 0;
        this.a = 3;
        return paramChar;
      }
      if (('0' <= paramChar) && (paramChar <= '9'))
      {
        this.b = Character.digit(paramChar, 10);
        this.c = 1;
        this.a = 4;
        return paramChar;
      }
      this.a = 5;
      return paramChar;
    case 4: 
      if (('0' <= paramChar) && (paramChar <= '9'))
      {
        this.b = (this.b * 10 + Character.digit(paramChar, 10));
        this.c += 1;
        if (this.c <= 5)
        {
          this.a = 4;
          return paramChar;
        }
        this.a = 5;
        return paramChar;
      }
      if ((paramChar == ';') && (k.a((char)this.b)))
      {
        this.a = 0;
        return (char)this.b;
      }
      this.a = 5;
      return paramChar;
    case 3: 
      if ((('0' <= paramChar) && (paramChar <= '9')) || (('a' <= paramChar) && (paramChar <= 'f')) || (('A' <= paramChar) && (paramChar <= 'F')))
      {
        this.b = (this.b * 16 + Character.digit(paramChar, 16));
        this.c += 1;
        if (this.c <= 4)
        {
          this.a = 3;
          return paramChar;
        }
        this.a = 5;
        return paramChar;
      }
      if ((paramChar == ';') && (k.a((char)this.b)))
      {
        this.a = 0;
        return (char)this.b;
      }
      this.a = 5;
      return paramChar;
    }
    this.a = 0;
    return paramChar;
  }
  
  public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    char[] arrayOfChar = new char[8];
    int k = 1;
    int i = 0;
    int j = 0;
    while ((k != 0) && (i < paramInt2))
    {
      if (super.read(arrayOfChar, j, 1) == 1)
      {
        k = 1;
        label42:
        if (k == 0) {
          break label142;
        }
        char c2 = a(arrayOfChar[j]);
        if (this.a != 0) {
          break label108;
        }
        char c1 = c2;
        if (k.a(c2)) {
          c1 = ' ';
        }
        paramArrayOfChar[paramInt1] = c1;
        j = 0;
        paramInt1 += 1;
        i += 1;
      }
      for (;;)
      {
        break;
        k = 0;
        break label42;
        label108:
        if (this.a == 5)
        {
          unread(arrayOfChar, 0, j + 1);
          j = 0;
        }
        else
        {
          j += 1;
        }
      }
      label142:
      if (j > 0)
      {
        unread(arrayOfChar, 0, j);
        this.a = 5;
        k = 1;
        j = 0;
      }
    }
    if ((i > 0) || (k != 0)) {
      return i;
    }
    return -1;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/a/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */