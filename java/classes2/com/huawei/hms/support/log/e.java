package com.huawei.hms.support.log;

import android.annotation.SuppressLint;
import android.os.Process;
import android.util.Log;
import com.huawei.hms.support.log.a.a;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;

@SuppressLint({"SimpleDateFormat"})
public class e
{
  String a = null;
  String b = "HMS";
  LogLevel c = null;
  long d = 0L;
  long e = 0L;
  String f = null;
  String g;
  int h;
  int i;
  int j = 0;
  StringBuilder k = null;
  private SimpleDateFormat l = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
  
  protected e() {}
  
  protected e(String paramString, LogLevel paramLogLevel)
  {
    if (paramString != null) {
      this.b = paramString;
    }
    this.c = paramLogLevel;
  }
  
  private a a(a parama)
  {
    parama.a(this.l.format(Long.valueOf(this.d)));
    parama.a(Character.valueOf('[')).a(Integer.valueOf(this.h)).a(Character.valueOf(']'));
    if (this.a != null) {
      parama.a(Character.valueOf('[')).a(this.a).a(Character.valueOf(']'));
    }
    parama.a(Character.valueOf('[')).a(this.b).a(Character.valueOf(']'));
    parama.a(Character.valueOf('[')).a(this.c).a(Character.valueOf(']'));
    return parama;
  }
  
  public static String a(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.toString();
  }
  
  public static boolean a(e parame)
  {
    return (parame == null) || (parame.b());
  }
  
  private a b(a parama)
  {
    parama.a("[");
    parama.a(this.f).a(Character.valueOf('{')).a(Long.valueOf(this.e)).a(Character.valueOf('}'));
    parama.a("]");
    parama.a(Character.valueOf(' ')).a(this.k.toString());
    if (this.c.value() < LogLevel.OUT.value())
    {
      parama.a(Character.valueOf(' ')).a(Character.valueOf('('));
      parama.a(this.g).a(Character.valueOf(':')).a(Integer.valueOf(this.i));
      parama.a(Character.valueOf(')'));
    }
    return parama;
  }
  
  private <T> e b(T paramT)
  {
    this.k.append(paramT);
    return this;
  }
  
  protected e a()
  {
    this.d = System.currentTimeMillis();
    Object localObject = Thread.currentThread();
    this.e = ((Thread)localObject).getId();
    this.f = ((Thread)localObject).getName();
    this.h = Process.myPid();
    try
    {
      localObject = localObject.getStackTrace()[(this.j + 7)];
      this.g = ((StackTraceElement)localObject).getFileName();
      this.i = ((StackTraceElement)localObject).getLineNumber();
      this.k = new StringBuilder(32);
      return this;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("HMS", "create log error");
      }
    }
  }
  
  public <T> e a(T paramT)
  {
    b(paramT);
    return this;
  }
  
  public void a(f paramf)
  {
    if (this.k != null) {
      paramf.a(this);
    }
  }
  
  public e b(Throwable paramThrowable)
  {
    b(Character.valueOf('\n')).b(a(paramThrowable));
    return this;
  }
  
  public boolean b()
  {
    return this.k == null;
  }
  
  public e c()
  {
    return a(Character.valueOf('\n'));
  }
  
  public String d()
  {
    a locala = a.a();
    a(locala);
    return locala.c();
  }
  
  public String e()
  {
    a locala = a.a();
    b(locala);
    return locala.c();
  }
  
  public String toString()
  {
    a locala = a.a();
    a(locala);
    b(locala);
    return locala.c();
  }
  
  public static class a
  {
    e a;
    
    public a(String paramString, LogLevel paramLogLevel)
    {
      this.a = new e(paramString, paramLogLevel);
    }
    
    public a a(int paramInt)
    {
      this.a.j = paramInt;
      return this;
    }
    
    public a a(String paramString)
    {
      this.a.a = paramString;
      return this;
    }
    
    public e a()
    {
      return this.a.a();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/huawei/hms/support/log/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */