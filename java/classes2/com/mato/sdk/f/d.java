package com.mato.sdk.f;

import java.util.Collections;
import java.util.Map;

public final class d
{
  public final int a;
  public final String b;
  public final Map<String, String> c;
  
  public d(int paramInt, String paramString, Map<String, String> paramMap)
  {
    this.a = paramInt;
    this.b = paramString;
    this.c = paramMap;
  }
  
  private d(String paramString)
  {
    this(200, paramString, Collections.emptyMap());
  }
  
  private d(String paramString, Map<String, String> paramMap)
  {
    this(200, paramString, paramMap);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/f/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */