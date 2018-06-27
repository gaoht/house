package com.xiaomi.smack;

import com.xiaomi.smack.packet.g;
import com.xiaomi.smack.packet.h;
import java.io.PrintStream;
import java.io.PrintWriter;

public class l
  extends Exception
{
  private g a = null;
  private h b = null;
  private Throwable c = null;
  
  public l() {}
  
  public l(g paramg)
  {
    this.a = paramg;
  }
  
  public l(String paramString)
  {
    super(paramString);
  }
  
  public l(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.c = paramThrowable;
  }
  
  public l(Throwable paramThrowable)
  {
    this.c = paramThrowable;
  }
  
  public Throwable a()
  {
    return this.c;
  }
  
  public String getMessage()
  {
    String str2 = super.getMessage();
    String str1;
    if ((str2 == null) && (this.b != null)) {
      str1 = this.b.toString();
    }
    do
    {
      do
      {
        return str1;
        str1 = str2;
      } while (str2 != null);
      str1 = str2;
    } while (this.a == null);
    return this.a.toString();
  }
  
  public void printStackTrace()
  {
    printStackTrace(System.err);
  }
  
  public void printStackTrace(PrintStream paramPrintStream)
  {
    super.printStackTrace(paramPrintStream);
    if (this.c != null)
    {
      paramPrintStream.println("Nested Exception: ");
      this.c.printStackTrace(paramPrintStream);
    }
  }
  
  public void printStackTrace(PrintWriter paramPrintWriter)
  {
    super.printStackTrace(paramPrintWriter);
    if (this.c != null)
    {
      paramPrintWriter.println("Nested Exception: ");
      this.c.printStackTrace(paramPrintWriter);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = super.getMessage();
    if (str != null) {
      localStringBuilder.append(str).append(": ");
    }
    if (this.b != null) {
      localStringBuilder.append(this.b);
    }
    if (this.a != null) {
      localStringBuilder.append(this.a);
    }
    if (this.c != null) {
      localStringBuilder.append("\n  -- caused by: ").append(this.c);
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/smack/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */