package com.megvii.zhimasdk.b.a.n;

import com.megvii.zhimasdk.b.a.ab;
import com.megvii.zhimasdk.b.a.ac;
import com.megvii.zhimasdk.b.a.ae;
import com.megvii.zhimasdk.b.a.af;
import com.megvii.zhimasdk.b.a.i;
import com.megvii.zhimasdk.b.a.l;
import com.megvii.zhimasdk.b.a.m;
import com.megvii.zhimasdk.b.a.o.a;
import com.megvii.zhimasdk.b.a.q;
import com.megvii.zhimasdk.b.a.s;
import com.megvii.zhimasdk.b.a.v;
import java.io.IOException;

public class h
{
  private final int a;
  
  public h()
  {
    this(3000);
  }
  
  public h(int paramInt)
  {
    this.a = a.a(paramInt, "Wait for continue time");
  }
  
  private static void a(i parami)
  {
    try
    {
      parami.close();
      return;
    }
    catch (IOException parami) {}
  }
  
  public s a(q paramq, i parami, e parame)
  {
    a.a(paramq, "HTTP request");
    a.a(parami, "Client connection");
    a.a(parame, "HTTP context");
    try
    {
      s locals2 = b(paramq, parami, parame);
      s locals1 = locals2;
      if (locals2 == null) {
        locals1 = c(paramq, parami, parame);
      }
      return locals1;
    }
    catch (IOException paramq)
    {
      a(parami);
      throw paramq;
    }
    catch (m paramq)
    {
      a(parami);
      throw paramq;
    }
    catch (RuntimeException paramq)
    {
      a(parami);
      throw paramq;
    }
  }
  
  public void a(q paramq, g paramg, e parame)
  {
    a.a(paramq, "HTTP request");
    a.a(paramg, "HTTP processor");
    a.a(parame, "HTTP context");
    parame.a("http.request", paramq);
    paramg.a(paramq, parame);
  }
  
  public void a(s params, g paramg, e parame)
  {
    a.a(params, "HTTP response");
    a.a(paramg, "HTTP processor");
    a.a(parame, "HTTP context");
    parame.a("http.response", params);
    paramg.a(params, parame);
  }
  
  protected boolean a(q paramq, s params)
  {
    if ("HEAD".equalsIgnoreCase(paramq.h().a())) {}
    int i;
    do
    {
      return false;
      i = params.a().b();
    } while ((i < 200) || (i == 204) || (i == 304) || (i == 205));
    return true;
  }
  
  protected s b(q paramq, i parami, e parame)
  {
    a.a(paramq, "HTTP request");
    a.a(parami, "Client connection");
    a.a(parame, "HTTP context");
    parame.a("http.connection", parami);
    parame.a("http.request_sent", Boolean.FALSE);
    parami.a(paramq);
    Object localObject1;
    int i;
    if ((paramq instanceof l))
    {
      localObject1 = paramq.h().b();
      if ((((l)paramq).b()) && (!((ac)localObject1).c(v.b)))
      {
        parami.b();
        if (parami.a(this.a))
        {
          localObject1 = parami.a();
          if (a(paramq, (s)localObject1)) {
            parami.a((s)localObject1);
          }
          i = ((s)localObject1).a().b();
          if (i < 200)
          {
            if (i != 100) {
              throw new ab("Unexpected response: " + ((s)localObject1).a());
            }
            localObject1 = null;
            i = 1;
            localObject2 = localObject1;
            if (i != 0) {
              parami.a((l)paramq);
            }
          }
        }
      }
    }
    for (Object localObject2 = localObject1;; localObject2 = null)
    {
      parami.b();
      parame.a("http.request_sent", Boolean.TRUE);
      return (s)localObject2;
      i = 0;
      break;
      localObject1 = null;
      i = 1;
      break;
    }
  }
  
  protected s c(q paramq, i parami, e parame)
  {
    a.a(paramq, "HTTP request");
    a.a(parami, "Client connection");
    a.a(parame, "HTTP context");
    parame = null;
    for (int i = 0; (parame == null) || (i < 200); i = parame.a().b())
    {
      parame = parami.a();
      if (a(paramq, parame)) {
        parami.a(parame);
      }
    }
    return parame;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/n/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */