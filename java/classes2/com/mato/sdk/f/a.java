package com.mato.sdk.f;

import android.text.TextUtils;
import com.mato.sdk.b.g;
import com.mato.sdk.g.i;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public final class a
{
  private static final String a = g.b("");
  private static final String b = "X-MAA-Host-IP";
  private final String c;
  private String d;
  
  public a(String paramString, String[] paramArrayOfString)
  {
    this.c = paramString;
    if (this.d == null)
    {
      int j = i.d().nextInt();
      int i = j;
      if (j < 0) {
        i = -j;
      }
      this.d = paramArrayOfString[(i % paramArrayOfString.length)];
    }
  }
  
  public static String a()
  {
    return "X-MAA-Host-IP";
  }
  
  private static String a(String[] paramArrayOfString)
  {
    int j = i.d().nextInt();
    int i = j;
    if (j < 0) {
      i = -j;
    }
    return paramArrayOfString[(i % paramArrayOfString.length)];
  }
  
  public final void a(Map<String, String> paramMap)
  {
    if (paramMap == null)
    {
      paramMap = this.c;
      return;
    }
    paramMap = paramMap.entrySet().iterator();
    Map.Entry localEntry;
    do
    {
      if (!paramMap.hasNext()) {
        break;
      }
      localEntry = (Map.Entry)paramMap.next();
    } while (!"X-MAA-Host-IP".equalsIgnoreCase((String)localEntry.getKey()));
    for (paramMap = (String)localEntry.getValue();; paramMap = null)
    {
      if (TextUtils.isEmpty(paramMap))
      {
        paramMap = this.c;
        return;
      }
      if (!paramMap.equals(this.d)) {
        this.d = paramMap;
      }
      paramMap = this.c;
      return;
    }
  }
  
  public final String b()
  {
    return this.d;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */