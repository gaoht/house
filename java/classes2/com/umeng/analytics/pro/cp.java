package com.umeng.analytics.pro;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

public class cp
{
  private final ByteArrayOutputStream a = new ByteArrayOutputStream();
  private final dr b = new dr(this.a);
  private df c;
  
  public cp()
  {
    this(new cz.a());
  }
  
  public cp(dh paramdh)
  {
    this.c = paramdh.a(this.b);
  }
  
  public String a(cg paramcg, String paramString)
    throws cm
  {
    try
    {
      paramcg = new String(a(paramcg), paramString);
      return paramcg;
    }
    catch (UnsupportedEncodingException paramcg)
    {
      throw new cm("JVM DOES NOT SUPPORT ENCODING: " + paramString);
    }
  }
  
  public byte[] a(cg paramcg)
    throws cm
  {
    this.a.reset();
    paramcg.b(this.c);
    return this.a.toByteArray();
  }
  
  public String b(cg paramcg)
    throws cm
  {
    return new String(a(paramcg));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/cp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */