package com.xiaomi.stats;

import com.xiaomi.push.thrift.a;
import com.xiaomi.smack.c;
import com.xiaomi.smack.l;
import java.net.UnknownHostException;

final class d
{
  static a a(Exception paramException)
  {
    e(paramException);
    Object localObject = paramException;
    if ((paramException instanceof l))
    {
      localObject = paramException;
      if (((l)paramException).a() != null) {
        localObject = ((l)paramException).a();
      }
    }
    a locala = new a();
    paramException = ((Throwable)localObject).getMessage();
    if (((Throwable)localObject).getCause() != null) {
      paramException = ((Throwable)localObject).getCause().getMessage();
    }
    paramException = localObject.getClass().getSimpleName() + ":" + paramException;
    int i = c.a((Throwable)localObject);
    if (i != 0) {
      locala.a = a.a(i + a.i.a());
    }
    if (locala.a == null) {
      locala.a = a.q;
    }
    if (locala.a == a.q) {
      locala.b = paramException;
    }
    return locala;
  }
  
  static a b(Exception paramException)
  {
    e(paramException);
    Object localObject = paramException;
    if ((paramException instanceof l))
    {
      localObject = paramException;
      if (((l)paramException).a() != null) {
        localObject = ((l)paramException).a();
      }
    }
    a locala = new a();
    paramException = ((Throwable)localObject).getMessage();
    if (((Throwable)localObject).getCause() != null) {
      paramException = ((Throwable)localObject).getCause().getMessage();
    }
    int i = c.a((Throwable)localObject);
    paramException = localObject.getClass().getSimpleName() + ":" + paramException;
    if (i != 0)
    {
      locala.a = a.a(i + a.s.a());
      if (locala.a == a.D)
      {
        localObject = ((Throwable)localObject).getCause();
        if ((localObject == null) || (!(localObject instanceof UnknownHostException))) {}
      }
    }
    for (locala.a = a.C;; locala.a = a.B)
    {
      if ((locala.a == a.A) || (locala.a == a.B) || (locala.a == a.D)) {
        locala.b = paramException;
      }
      return locala;
    }
  }
  
  static a c(Exception paramException)
  {
    e(paramException);
    Object localObject = paramException;
    if ((paramException instanceof l))
    {
      localObject = paramException;
      if (((l)paramException).a() != null) {
        localObject = ((l)paramException).a();
      }
    }
    a locala = new a();
    paramException = ((Throwable)localObject).getMessage();
    if (((Throwable)localObject).getCause() != null) {
      paramException = ((Throwable)localObject).getCause().getMessage();
    }
    int i = c.a((Throwable)localObject);
    localObject = localObject.getClass().getSimpleName() + ":" + paramException;
    switch (i)
    {
    default: 
      locala.a = a.M;
    }
    for (;;)
    {
      if ((locala.a == a.L) || (locala.a == a.M) || (locala.a == a.O)) {
        locala.b = ((String)localObject);
      }
      return locala;
      locala.a = a.I;
      continue;
      locala.a = a.J;
      continue;
      locala.a = a.K;
      continue;
      locala.a = a.L;
      continue;
      locala.a = a.O;
      if (paramException.startsWith("Terminal binding condition encountered: item-not-found")) {
        locala.a = a.N;
      }
    }
  }
  
  static a d(Exception paramException)
  {
    e(paramException);
    Object localObject = paramException;
    if ((paramException instanceof l))
    {
      localObject = paramException;
      if (((l)paramException).a() != null) {
        localObject = ((l)paramException).a();
      }
    }
    paramException = new a();
    String str = ((Throwable)localObject).getMessage();
    int i = c.a((Throwable)localObject);
    localObject = localObject.getClass().getSimpleName() + ":" + str;
    switch (i)
    {
    default: 
      paramException.a = a.Y;
    }
    for (;;)
    {
      if ((paramException.a == a.X) || (paramException.a == a.Y) || (paramException.a == a.aa)) {
        paramException.b = ((String)localObject);
      }
      return paramException;
      paramException.a = a.U;
      continue;
      paramException.a = a.V;
      continue;
      paramException.a = a.W;
      continue;
      paramException.a = a.X;
      continue;
      paramException.a = a.aa;
      if (str.startsWith("Terminal binding condition encountered: item-not-found")) {
        paramException.a = a.Z;
      }
    }
  }
  
  private static void e(Exception paramException)
  {
    if (paramException == null) {
      throw new NullPointerException();
    }
  }
  
  static class a
  {
    a a;
    String b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/stats/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */