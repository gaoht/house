package com.mato.sdk.proxy;

import java.util.Properties;

final class o
{
  private static final String a = "http.proxyHost";
  private static final String b = "http.proxyPort";
  private static final String c = "https.proxyHost";
  private static final String d = "https.proxyPort";
  private static String e;
  private static String f;
  private static String g;
  private static String h;
  
  public static void a()
  {
    d.2.a("http.proxyHost", d.2.f);
    d.2.a("http.proxyPort", d.2.g);
    d.2.a("https.proxyHost", d.2.h);
    d.2.a("https.proxyPort", d.2.i);
  }
  
  public static void a(String paramString, int paramInt)
  {
    d.2.f = System.getProperty("http.proxyHost");
    d.2.g = System.getProperty("http.proxyPort");
    d.2.h = System.getProperty("https.proxyHost");
    d.2.i = System.getProperty("https.proxyPort");
    System.setProperty("http.proxyHost", paramString);
    System.setProperty("http.proxyPort", paramInt);
    System.setProperty("https.proxyHost", paramString);
    System.setProperty("https.proxyPort", paramInt);
  }
  
  private static void a(String paramString1, String paramString2)
  {
    if (paramString2 == null)
    {
      System.getProperties().remove(paramString1);
      return;
    }
    System.setProperty(paramString1, paramString2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/proxy/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */