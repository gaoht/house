package com.baidu.trace;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class s
{
  private SharedPreferences a;
  private Map<String, String> b;
  private Set<String> c;
  
  public s(Context paramContext)
  {
    this.a = PreferenceManager.getDefaultSharedPreferences(paramContext);
    this.b = new HashMap();
    this.c = new HashSet();
  }
  
  public final String a(String paramString)
  {
    if (!this.b.containsKey(paramString)) {
      this.b.put(paramString, this.a.getString(paramString, null));
    }
    return (String)this.b.get(paramString);
  }
  
  public final void a()
  {
    SharedPreferences.Editor localEditor = this.a.edit();
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((String)this.b.get(str) == null) {
        localEditor.remove(str);
      } else {
        localEditor.putString(str, (String)this.b.get(str));
      }
    }
    localEditor.apply();
    this.c.clear();
  }
  
  public final void a(String paramString1, String paramString2)
  {
    this.b.put(paramString1, paramString2);
    if (!this.c.contains(paramString1)) {
      this.c.add(paramString1);
    }
  }
  
  protected final void b()
  {
    if (this.b != null)
    {
      this.b.clear();
      this.b = null;
    }
    if (this.c != null)
    {
      this.c.clear();
      this.c = null;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */