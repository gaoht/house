package com.ziroom.datacenter.remote.f;

import com.ziroom.commonlib.utils.h;
import com.ziroom.commonlib.utils.l;

public class b
{
  public static String a = "https://interfaces.ziroom.com/";
  public static String b = "https://contentful.ziroom.com/online";
  public static String c = "https://interfaces.ziroom.com";
  public static String d = "https://passport.ziroom.com";
  public static String e = "https://bnbsearch.ziroom.com";
  public static String f = "https://bnbm.ziroom.com";
  public static String g = "https://bnbim.ziroom.com";
  public static String h = "https://bnbstatics.ziroom.com";
  public static String i = "https://zhuanti.ziroom.com";
  public static String j = "http://bnb.api.ziroom.com";
  public static String k = "https://qcrm.ziroom.com/crm/";
  public static String l = "https://ztoread.ziroom.com/";
  public static String m = "https://ucenter.ziroom.com/";
  public static String n = "https://ucenter.ziroom.com/";
  public static String o = "https://sm.ziroom.com/";
  public static String p = "https://passport.ziroom.com/";
  public static String q = "https://zmcapi.ziroom.com/";
  public static String r = "https://movessmsapis.ziroom.com/";
  public static String s = "http://smsapi.ziroom.com/API/";
  public static String t = "https://smsapis.ziroom.com/";
  public static String u = "https://fngateway.ziroom.com/";
  public static String v = "https://zrpaycentre.ziroom.com/";
  public static String w = "https://sm.ziroom.com/";
  public static String x = "https://mucenter.ziroom.com/";
  
  static
  {
    updateWeb();
  }
  
  public static void updateWeb()
  {
    if (1 == h.getsEnvironment())
    {
      c = "http://interfaces.t.ziroom.com";
      d = "http://passport.api.qa.ziroom.com";
      e = "http://bnb.search.d.ziroom.com";
      f = "http://bnb.m.d.ziroom.com";
      g = "http://bnb.im.d.ziroom.com";
      h = "http://bnbstatics.d.ziroom.com";
      i = "https://www.ziroom.com";
      j = "http://bnb.api.d.ziroom.com";
      a = "https://tinterfaces.ziroom.com/";
      k = "http://10.30.121.87:8087/";
      l = "http://toread.d.ziroom.com/";
      o = "https://dsm.ziroom.com/";
      p = "https://tpassport.ziroom.com/";
      q = "https://dzmcapi.ziroom.com/";
      r = "https://dmovessmsapis.ziroom.com/";
      t = "http://smsapi.d.ziroom.com/";
      s = t + "API/";
      n = "https://tucenter.ziroom.com/";
      u = "https://tfngateway.ziroom.com/";
      v = "http://tzrpaycentre.ziroom.com/";
      w = "http://s.m.d.ziroom.com/";
      x = "https://tmucenter.ziroom.com/";
    }
    for (;;)
    {
      l.d("tab", "WEB_ROOT" + a + "WEB_ROOT_CRM" + k + "WEB_GATEWAY_ROOT" + l + "SERVICE_REPAIR_ROOT" + o);
      return;
      if (2 == h.getsEnvironment())
      {
        c = "https://tinterfaces.ziroom.com";
        d = "https://tpassport.ziroom.com";
        e = "https://tbnbsearch.ziroom.com";
        f = "https://tbnbm.ziroom.com";
        g = "https://tbnbim.ziroom.com";
        h = "https://tbnbstatics.ziroom.com";
        i = "\thttps://twww.ziroom.com";
        j = "http://bnb.api.t.ziroom.com";
        a = "https://tinterfaces.ziroom.com/";
        k = "https://tcrm.ziroom.com/crm-reserve/";
        l = "https://ttoread.ziroom.com/";
        o = "https://tsm.ziroom.com/";
        p = "https://tpassport.ziroom.com/";
        q = "https://tzmcapi.ziroom.com/";
        r = "https://tmovessmsapis.ziroom.com/";
        t = "https://tsmsapis.ziroom.com/";
        s = t + "API/";
        n = "https://tucenter.ziroom.com/";
        u = "https://tfngateway.ziroom.com/";
        v = "https://tzrpaycentre.ziroom.com/";
        x = "https://tmucenter.ziroom.com/";
        w = "http://s.m.t.ziroom.com/";
      }
      else if (3 == h.getsEnvironment())
      {
        c = "https://qinterfaces.ziroom.com";
        d = "https://qpassport.ziroom.com";
        e = "https://qbnbsearch.ziroom.com";
        f = "https://qbnbm.ziroom.com";
        g = "https://qbnbim.ziroom.com";
        h = "https://qbnbstatics.ziroom.com";
        i = "https://qwww.ziroom.com";
        j = "http://bnb.api.q.ziroom.com";
        a = "https://qinterfaces.ziroom.com/";
        k = "https://qcrm.ziroom.com/crm/";
        l = "http://toread.q.ziroom.com/";
        o = "https://qsm.ziroom.com/";
        p = "https://qpassport.ziroom.com/";
        q = "https://qzmcapi.ziroom.com/";
        r = "https://qmovessmsapis.ziroom.com/";
        t = "https://qsmsapis.ziroom.com/";
        s = t + "API/";
        n = "https://qucenter.ziroom.com/";
        u = "https://qfngateway.ziroom.com/";
        v = "https://qzrpaycentre.ziroom.com/";
        w = "http://s.m.q.ziroom.com/";
        x = "https://qmucenter.ziroom.com/";
      }
      else
      {
        c = "https://interfaces.ziroom.com";
        d = "https://passport.ziroom.com";
        e = "https://bnbsearch.ziroom.com";
        f = "https://bnbm.ziroom.com";
        g = "https://bnbim.ziroom.com";
        h = "https://bnbstatics.ziroom.com";
        i = "https://zhuanti.ziroom.com";
        j = "http://bnb.api.ziroom.com";
        a = "https://interfaces.ziroom.com/";
        k = "https://crm.ziroom.com/crm/";
        l = "https://ztoread.ziroom.com/";
        o = "https://sm.ziroom.com/";
        p = "https://passport.ziroom.com/";
        q = "https://zmcapi.ziroom.com/";
        r = "https://movessmsapis.ziroom.com/";
        t = "https://smsapis.ziroom.com/";
        s = t + "API/";
        n = "https://ucenter.ziroom.com/";
        u = "https://fngateway.ziroom.com/";
        v = "https://zrpaycentre.ziroom.com/";
        w = "https://sm.ziroom.com/";
        x = "https://mucenter.ziroom.com/";
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/datacenter/remote/f/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */