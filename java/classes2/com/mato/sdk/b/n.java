package com.mato.sdk.b;

import android.util.Log;
import java.util.Properties;

public final class n
{
  private static final String a = g.b("");
  private static final String b = "http.proxyHost";
  private static final String c = "http.proxyPort";
  private static final String d = "https.proxyHost";
  private static final String e = "https.proxyPort";
  private static String f;
  private static String g;
  private static String h;
  private static String i;
  private static boolean j = false;
  
  public static void a()
  {
    if (!j) {
      return;
    }
    Log.i(a, "Reset system http proxy");
    a("http.proxyHost", f);
    a("http.proxyPort", g);
    a("https.proxyHost", h);
    a("https.proxyPort", i);
    j = false;
  }
  
  public static void a(String paramString, int paramInt)
  {
    if (j) {
      return;
    }
    Log.i(a, "Set system http proxy");
    f = System.getProperty("http.proxyHost");
    g = System.getProperty("http.proxyPort");
    h = System.getProperty("https.proxyHost");
    i = System.getProperty("https.proxyPort");
    System.setProperty("http.proxyHost", paramString);
    System.setProperty("http.proxyPort", paramInt);
    System.setProperty("https.proxyHost", paramString);
    System.setProperty("https.proxyPort", paramInt);
    j = true;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/b/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */