package com.mato.sdk.f;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class c
  extends g
{
  private final Map<String, String> a = new HashMap();
  private String b;
  private String c;
  private InputStream d;
  private String e;
  
  public final void a(b paramb)
  {
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramb.a((String)localEntry.getKey(), null, (String)localEntry.getValue());
    }
    paramb.a(this.b, this.c, this.e, this.d);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    this.a.put(paramString1, paramString2);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, InputStream paramInputStream)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramInputStream;
    this.e = paramString3;
  }
  
  public final void a(Map<String, String> paramMap)
  {
    this.a.putAll(paramMap);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/f/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */