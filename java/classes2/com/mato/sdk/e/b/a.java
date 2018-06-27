package com.mato.sdk.e.b;

import android.content.Context;
import com.mato.sdk.d.h;
import com.mato.sdk.proxy.Proxy.NetDiagnosisListener;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class a
{
  private final Context a;
  private final Proxy.NetDiagnosisListener b;
  private final h c;
  private final c d;
  
  public a() {}
  
  public a(Context paramContext, Proxy.NetDiagnosisListener paramNetDiagnosisListener, h paramh)
  {
    this.a = paramContext;
    this.b = paramNetDiagnosisListener;
    this.c = paramh;
    this.d = c.a(paramContext, 0);
  }
  
  private static String a(List<String> paramList, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localStringBuilder.append((String)paramList.next()).append(paramString);
    }
    return localStringBuilder.toString();
  }
  
  private static String a(Map<String, String> paramMap, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localStringBuilder.append((String)localEntry.getKey()).append(":").append((String)localEntry.getValue()).append(paramString);
    }
    return localStringBuilder.toString();
  }
  
  private void a(g paramg)
  {
    if (paramg != null)
    {
      if (paramg.a(this.d.b)) {
        new l(paramg.c).a(this.d.b, this.d.c, this.d.d);
      }
      if (this.b != null) {
        this.b.onCompleted(this.d.b);
      }
    }
  }
  
  private void a(String paramString)
  {
    new l(paramString).a(this.d.b, this.d.c, this.d.d);
  }
  
  private static String b(List<Integer> paramList, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localStringBuilder.append((Integer)paramList.next()).append(paramString);
    }
    return localStringBuilder.toString();
  }
  
  private static String b(Map<String, List<String>> paramMap, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localStringBuilder.append((String)localEntry.getKey()).append(":").append((String)((List)localEntry.getValue()).get(0)).append(paramString);
    }
    return localStringBuilder.toString();
  }
  
  public final void a()
  {
    new e(this.a, new i()
    {
      public final void a(g paramAnonymousg) {}
      
      public final void b(g paramAnonymousg) {}
      
      public final void c(g paramAnonymousg)
      {
        a.a(a.this, paramAnonymousg);
      }
      
      public final void d(g paramAnonymousg) {}
    }, this.c, this.d).start();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/e/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */