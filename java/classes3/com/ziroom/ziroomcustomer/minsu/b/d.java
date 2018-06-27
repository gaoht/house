package com.ziroom.ziroomcustomer.minsu.b;

import com.ziroom.commonlib.utils.h;

public class d
{
  public static String a = "https://contentful.ziroom.com/online/combine/a684eceee76fc522773286a895bc8436.json";
  public static String b = "https://contentful.ziroom.com/online/minsuapp/af4732711661056eadbf798ba191272a.json";
  public static String c = "https://interfaces.ziroom.com";
  public static String d = "https://passport.ziroom.com";
  public static String e = "https://bnbsearch.ziroom.com";
  public static String f = "https://bnbapi.ziroom.com";
  public static String g = "https://bnbm.ziroom.com";
  public static String h = "https://bnbim.ziroom.com";
  public static String i = "https://bnbstatics.ziroom.com";
  public static String j = "https://zhuanti.ziroom.com";
  public static String k = "http://bnb.api.ziroom.com";
  public static String l = "https://contentful.ziroom.com/online/minsuapp/c73dfe6c630edb4c1692db67c510f65c.json";
  
  static
  {
    updataWeb();
  }
  
  public static void updataWeb()
  {
    if (h.getsEnvironment() == 1)
    {
      c = "http://interfaces.t.ziroom.com";
      d = "http://passport.api.qa.ziroom.com";
      e = "http://bnb.search.d.ziroom.com";
      f = "https://dbnbapi.ziroom.com";
      g = "http://bnb.m.d.ziroom.com";
      h = "http://bnb.im.d.ziroom.com";
      i = "http://bnbstatics.d.ziroom.com";
      j = "https://www.ziroom.com";
      k = "http://bnb.api.d.ziroom.com";
    }
    do
    {
      return;
      if (h.getsEnvironment() == 2)
      {
        c = "https://tinterfaces.ziroom.com";
        d = "https://tpassport.ziroom.com";
        e = "https://tbnbsearch.ziroom.com";
        f = "https://tbnbapi.ziroom.com";
        g = "https://tbnbm.ziroom.com";
        h = "https://tbnbim.ziroom.com";
        i = "https://tbnbstatics.ziroom.com";
        j = "\thttps://twww.ziroom.com";
        k = "http://bnb.api.t.ziroom.com";
        return;
      }
    } while (h.getsEnvironment() != 3);
    c = "https://qinterfaces.ziroom.com";
    d = "https://qpassport.ziroom.com";
    e = "https://qbnbsearch.ziroom.com";
    f = "https://qbnbapi.ziroom.com";
    g = "https://qbnbm.ziroom.com";
    h = "https://qbnbim.ziroom.com";
    i = "https://qbnbstatics.ziroom.com";
    j = "https://qwww.ziroom.com";
    k = "http://bnb.api.q.ziroom.com";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */