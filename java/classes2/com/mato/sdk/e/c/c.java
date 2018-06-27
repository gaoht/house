package com.mato.sdk.e.c;

import com.mato.sdk.d.h;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public final class c
{
  private static final String a = com.mato.sdk.b.g.b("");
  private final String b;
  private final d c;
  private final List<String> d;
  private final com.mato.sdk.proxy.g e;
  
  private c(String paramString, d paramd, List<String> paramList, com.mato.sdk.proxy.g paramg)
  {
    this.b = paramString;
    this.d = new LinkedList(paramList);
    this.c = paramd;
    this.e = paramg;
  }
  
  public static c a(String paramString, d paramd, com.mato.sdk.proxy.g paramg)
  {
    return new c(paramString, paramd, paramd.d(), paramg);
  }
  
  public static c a(String paramString1, String paramString2, d paramd, com.mato.sdk.proxy.g paramg)
  {
    try
    {
      paramString2 = h.a(new JSONArray(paramString2));
      return new c(paramString1, paramd, paramString2, paramg);
    }
    catch (JSONException paramString1) {}
    return null;
  }
  
  private d f()
  {
    return this.c;
  }
  
  private void g()
  {
    JSONArray localJSONArray = h.a(this.d);
    String str = this.b;
    localJSONArray.toString();
    this.e.d(this.b, localJSONArray.toString());
  }
  
  public final long a()
  {
    return this.c.c();
  }
  
  public final void a(String paramString)
  {
    if (this.d.contains(paramString))
    {
      this.d.remove(paramString);
      paramString = h.a(this.d);
      String str = this.b;
      paramString.toString();
      this.e.d(this.b, paramString.toString());
    }
  }
  
  public final int b()
  {
    return this.c.e();
  }
  
  public final long c()
  {
    return this.c.a();
  }
  
  public final long d()
  {
    return this.c.b();
  }
  
  public final List<String> e()
  {
    return this.d;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/e/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */