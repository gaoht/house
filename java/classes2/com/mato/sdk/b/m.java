package com.mato.sdk.b;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class m
{
  private static final Map<Integer, String> a = new ConcurrentHashMap();
  private static final List<Integer> b = new ArrayList();
  
  private static void a()
  {
    a.clear();
  }
  
  public static void a(int paramInt)
  {
    synchronized (b)
    {
      b.add(Integer.valueOf(paramInt));
      return;
    }
  }
  
  private static void a(String paramString, int paramInt)
  {
    a.put(Integer.valueOf(paramInt), paramString);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2)
  {
    paramString = paramString + ":" + paramInt1;
    a.put(Integer.valueOf(paramInt2), paramString);
  }
  
  public static void b(int paramInt)
  {
    synchronized (b)
    {
      if (b.contains(Integer.valueOf(paramInt))) {
        b.remove(Integer.valueOf(paramInt));
      }
      return;
    }
  }
  
  public static boolean c(int paramInt)
  {
    synchronized (b)
    {
      boolean bool = b.contains(Integer.valueOf(paramInt));
      return bool;
    }
  }
  
  public static void d(int paramInt)
  {
    if (a.containsKey(Integer.valueOf(paramInt))) {
      a.remove(Integer.valueOf(paramInt));
    }
  }
  
  public static String e(int paramInt)
  {
    String str2 = (String)a.get(Integer.valueOf(paramInt));
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/b/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */