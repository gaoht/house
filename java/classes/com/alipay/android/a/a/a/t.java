package com.alipay.android.a.a.a;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

public final class t
  extends c
{
  private q g;
  
  public t(q paramq, Method paramMethod, int paramInt, String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    super(paramMethod, paramInt, paramString, paramArrayOfByte, "application/x-www-form-urlencoded", paramBoolean);
    this.g = paramq;
  }
  
  public final Object a()
  {
    Object localObject1 = new z(this.g.a());
    ((z)localObject1).b = this.b;
    ((z)localObject1).c = this.e;
    ((z)localObject1).e = this.f;
    ((z)localObject1).a("id", String.valueOf(this.d));
    ((z)localObject1).a("operationType", this.c);
    ((z)localObject1).a("gzip", String.valueOf(this.g.e()));
    ((z)localObject1).a(new BasicHeader("uuid", UUID.randomUUID().toString()));
    Object localObject2 = this.g.c().b;
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((z)localObject1).a((Header)((Iterator)localObject2).next());
      }
    }
    new StringBuilder("threadid = ").append(Thread.currentThread().getId()).append("; ").append(((z)localObject1).toString());
    try
    {
      localObject1 = (af)this.g.b().a((ae)localObject1).get();
      if (localObject1 == null) {
        throw new b(Integer.valueOf(9), "response is null");
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new b(Integer.valueOf(13), "", localInterruptedException);
      byte[] arrayOfByte = localInterruptedException.a();
      return arrayOfByte;
    }
    catch (ExecutionException localExecutionException)
    {
      localObject2 = localExecutionException.getCause();
      a locala;
      if ((localObject2 != null) && ((localObject2 instanceof a)))
      {
        locala = (a)localObject2;
        int i = locala.getCode();
        switch (i)
        {
        }
        for (;;)
        {
          throw new b(Integer.valueOf(i), locala.getMsg());
          i = 4;
          continue;
          i = 7;
          continue;
          i = 8;
          continue;
          i = 6;
          continue;
          i = 5;
          continue;
          i = 3;
          continue;
          i = 2;
          continue;
          i = 16;
          continue;
          i = 15;
        }
      }
      throw new b(Integer.valueOf(9), "", locala);
    }
    catch (CancellationException localCancellationException)
    {
      throw new b(Integer.valueOf(13), "", localCancellationException);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alipay/android/a/a/a/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */