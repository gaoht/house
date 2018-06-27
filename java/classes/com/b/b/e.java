package com.b.b;

import java.io.PrintStream;
import java.io.PrintWriter;

public class e
  extends Exception
{
  private final Throwable a;
  
  public e(String paramString)
  {
    this(paramString, null);
  }
  
  public e(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.a = paramThrowable;
  }
  
  public e(Throwable paramThrowable)
  {
    this(null, paramThrowable);
  }
  
  public Throwable getInnerException()
  {
    return this.a;
  }
  
  public void printStackTrace()
  {
    super.printStackTrace();
    if (this.a != null)
    {
      System.err.println("--- inner exception ---");
      this.a.printStackTrace();
    }
  }
  
  public void printStackTrace(PrintStream paramPrintStream)
  {
    super.printStackTrace(paramPrintStream);
    if (this.a != null)
    {
      paramPrintStream.println("--- inner exception ---");
      this.a.printStackTrace(paramPrintStream);
    }
  }
  
  public void printStackTrace(PrintWriter paramPrintWriter)
  {
    super.printStackTrace(paramPrintWriter);
    if (this.a != null)
    {
      paramPrintWriter.println("--- inner exception ---");
      this.a.printStackTrace(paramPrintWriter);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    if (this.a != null)
    {
      localStringBuilder.append("\n");
      localStringBuilder.append("--- inner exception ---");
      localStringBuilder.append("\n");
      localStringBuilder.append(this.a.toString());
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */