package com.megvii.zhimasdk.b.a.k;

import com.megvii.zhimasdk.b.a.aa;
import com.megvii.zhimasdk.b.a.ag;
import com.megvii.zhimasdk.b.a.e;
import com.megvii.zhimasdk.b.a.h;
import com.megvii.zhimasdk.b.a.o.a;
import java.util.NoSuchElementException;

public class o
  implements ag
{
  protected final h a;
  protected String b;
  protected String c;
  protected int d;
  
  public o(h paramh)
  {
    this.a = ((h)a.a(paramh, "Header iterator"));
    this.d = a(-1);
  }
  
  protected int a(int paramInt)
  {
    if (paramInt < 0)
    {
      if (!this.a.hasNext()) {
        return -1;
      }
      this.b = this.a.a().d();
    }
    for (paramInt = 0;; paramInt = c(paramInt))
    {
      paramInt = b(paramInt);
      if (paramInt >= 0) {
        break;
      }
      this.c = null;
      return -1;
    }
    int i = d(paramInt);
    this.c = a(this.b, paramInt, i);
    return i;
  }
  
  public String a()
  {
    if (this.c == null) {
      throw new NoSuchElementException("Iteration already finished.");
    }
    String str = this.c;
    this.d = a(this.d);
    return str;
  }
  
  protected String a(String paramString, int paramInt1, int paramInt2)
  {
    return paramString.substring(paramInt1, paramInt2);
  }
  
  protected boolean a(char paramChar)
  {
    return paramChar == ',';
  }
  
  protected int b(int paramInt)
  {
    int i = a.b(paramInt, "Search position");
    paramInt = 0;
    if ((paramInt == 0) && (this.b != null))
    {
      int j = this.b.length();
      while ((paramInt == 0) && (i < j))
      {
        char c1 = this.b.charAt(i);
        if ((a(c1)) || (b(c1))) {
          i += 1;
        } else if (c(this.b.charAt(i))) {
          paramInt = 1;
        } else {
          throw new aa("Invalid character before token (pos " + i + "): " + this.b);
        }
      }
      j = i;
      if (paramInt == 0)
      {
        if (!this.a.hasNext()) {
          break label176;
        }
        this.b = this.a.a().d();
      }
      for (j = 0;; j = i)
      {
        i = j;
        break;
        label176:
        this.b = null;
      }
    }
    if (paramInt != 0) {
      return i;
    }
    return -1;
  }
  
  protected boolean b(char paramChar)
  {
    return (paramChar == '\t') || (Character.isSpaceChar(paramChar));
  }
  
  protected int c(int paramInt)
  {
    paramInt = a.b(paramInt, "Search position");
    int i = 0;
    int j = this.b.length();
    while ((i == 0) && (paramInt < j))
    {
      char c1 = this.b.charAt(paramInt);
      if (a(c1))
      {
        i = 1;
      }
      else if (b(c1))
      {
        paramInt += 1;
      }
      else
      {
        if (c(c1)) {
          throw new aa("Tokens without separator (pos " + paramInt + "): " + this.b);
        }
        throw new aa("Invalid character after token (pos " + paramInt + "): " + this.b);
      }
    }
    return paramInt;
  }
  
  protected boolean c(char paramChar)
  {
    if (Character.isLetterOrDigit(paramChar)) {}
    do
    {
      return true;
      if (Character.isISOControl(paramChar)) {
        return false;
      }
    } while (!d(paramChar));
    return false;
  }
  
  protected int d(int paramInt)
  {
    a.b(paramInt, "Search position");
    int i = this.b.length();
    paramInt += 1;
    while ((paramInt < i) && (c(this.b.charAt(paramInt)))) {
      paramInt += 1;
    }
    return paramInt;
  }
  
  protected boolean d(char paramChar)
  {
    return " ,;=()<>@:\\\"/[]?{}\t".indexOf(paramChar) >= 0;
  }
  
  public boolean hasNext()
  {
    return this.c != null;
  }
  
  public final Object next()
  {
    return a();
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException("Removing tokens is not supported.");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/k/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */