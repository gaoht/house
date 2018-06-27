package com.unionpay.sdk;

import java.util.HashMap;

class ae
  extends bh
{
  private static volatile ae a = null;
  
  static
  {
    try
    {
      ar.a().register(a());
      return;
    }
    catch (Throwable localThrowable)
    {
      k.a(localThrowable);
    }
  }
  
  public static ae a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ae();
      }
      return a;
    }
    finally {}
  }
  
  public final void onTDEBEventError(ag.a parama)
  {
    if ((parama == null) || (parama.a == null)) {}
    for (;;)
    {
      return;
      if (Integer.parseInt(String.valueOf(parama.a.get("apiType"))) == 5)
      {
        parama.a.put("controller", a());
        parama = parama.a;
        try
        {
          if (parama.containsKey("throwable")) {
            if (parama.containsKey("occurTime"))
            {
              ag.a((Throwable)parama.get("throwable"), String.valueOf(parama.get("occurTime")));
              return;
            }
          }
        }
        catch (Throwable parama)
        {
          k.a(parama);
          return;
        }
      }
    }
    ag.a((Throwable)parama.get("throwable"), "");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/sdk/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */