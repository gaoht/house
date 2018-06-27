package com.g.a;

import java.util.HashMap;
import java.util.Map;

public class ar
{
  private static volatile ar a = null;
  
  static
  {
    try
    {
      ad.a().register(a());
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static ar a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ar();
      }
      return a;
    }
    finally {}
  }
  
  public final void onTDEBEventIAP(db.a parama)
  {
    if (parama != null) {
      try
      {
        if (parama.a != null)
        {
          if (Integer.parseInt(String.valueOf(parama.a.get("apiType"))) != 8) {
            return;
          }
          be localbe = new be();
          Object localObject = parama.a.get("data");
          a locala = (a)parama.a.get("service");
          localbe.b = String.valueOf(parama.a.get("domain"));
          localbe.c = String.valueOf(parama.a.get("action"));
          if ((localObject != null) && ((localObject instanceof Map))) {
            localbe.d = ((Map)localObject);
          }
          localbe.a = locala;
          ad.a().post(localbe);
          if (((parama.a.get("action") != null) && ((parama.a.get("action").equals("addItem")) || (parama.a.get("action").equals("recharge")) || (parama.a.get("action").equals("currencyPurchase")) || (parama.a.get("action").equals("placeOrder")) || (parama.a.get("action").equals("deeplink")) || (parama.a.get("action").equals("viewItem")) || (parama.a.get("action").equals("viewItems")))) || (parama.a.get("action").equals("reward")) || (parama.a.get("action").equals("onRechargeSucc")) || (parama.a.get("action").equals("virtualCurrentyPurchase")) || (parama.a.get("action").equals("itemUsedFor")))
          {
            parama = new bd();
            parama.a = locala;
            parama.b = bd.a.a;
            ad.a().post(parama);
            return;
          }
        }
      }
      catch (Throwable parama) {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */