package com.unionpay.utils;

import java.util.Locale;

public class h
{
  private static h g = null;
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  
  public static h a()
  {
    if (g == null) {
      if (!Locale.getDefault().toString().startsWith("zh")) {
        break label34;
      }
    }
    label34:
    for (g = new i();; g = new j()) {
      return g;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/utils/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */