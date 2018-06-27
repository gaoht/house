package com.ziroom.ziroomcustomer.payment.c;

import com.ziroom.commonlib.utils.h;

public class a
{
  public static String a = "https://zrpaycentre.ziroom.com/";
  public static String b = "https://fngateway.ziroom.com/";
  
  static
  {
    updataWeb();
  }
  
  public static void updataWeb()
  {
    if (h.getsEnvironment() == 1)
    {
      a = "http://tzrpaycentre.ziroom.com/";
      b = "https://tfngateway.ziroom.com/";
    }
    do
    {
      return;
      if (h.getsEnvironment() == 3)
      {
        a = "https://qzrpaycentre.ziroom.com/";
        b = "https://qfngateway.ziroom.com/";
        return;
      }
      if (h.getsEnvironment() == 4)
      {
        a = "https://zrpaycentre.ziroom.com/";
        b = "https://fngateway.ziroom.com/";
        return;
      }
    } while (h.getsEnvironment() != 2);
    a = "https://tzrpaycentre.ziroom.com/";
    b = "https://tfngateway.ziroom.com/";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/payment/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */