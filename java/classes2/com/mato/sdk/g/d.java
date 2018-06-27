package com.mato.sdk.g;

import android.text.TextUtils;
import com.mato.sdk.c.d.e;
import com.mato.sdk.d.j.a;
import com.mato.sdk.d.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
{
  private static String a = ",";
  
  private d()
  {
    throw new AssertionError();
  }
  
  private static <V> int a(List<V> paramList1, List<V> paramList2)
  {
    if ((paramList1 == null) || (j.a.a(paramList2))) {
      return 0;
    }
    int i = paramList1.size();
    paramList2 = paramList2.iterator();
    while (paramList2.hasNext())
    {
      Object localObject = paramList2.next();
      if (!paramList1.contains(localObject)) {
        paramList1.add(localObject);
      }
    }
    return paramList1.size() - i;
  }
  
  private static String a(List<String> paramList, char paramChar)
  {
    return j.a.a(paramList, new String(new char[] { paramChar }));
  }
  
  public static String a(List<String> paramList, String paramString)
  {
    if (paramList == null) {
      return "";
    }
    return TextUtils.join(paramString, paramList);
  }
  
  private static <V> boolean a(ArrayList<V> paramArrayList1, ArrayList<V> paramArrayList2)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramArrayList1 == null)
    {
      bool1 = bool2;
      if (paramArrayList2 == null) {
        bool1 = true;
      }
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramArrayList2 == null);
      bool1 = bool2;
    } while (paramArrayList1.size() != paramArrayList2.size());
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayList1.size()) {
        break label75;
      }
      bool1 = bool2;
      if (!k.a(paramArrayList1.get(i), paramArrayList2.get(i))) {
        break;
      }
      i += 1;
    }
    label75:
    return true;
  }
  
  public static <V> boolean a(List<V> paramList)
  {
    return (paramList == null) || (paramList.size() == 0);
  }
  
  private static <V> boolean a(List<V> paramList, V paramV)
  {
    if ((paramList != null) && (!paramList.contains(paramV))) {
      return paramList.add(paramV);
    }
    return false;
  }
  
  private static <V> int b(List<V> paramList)
  {
    if (paramList == null) {
      return 0;
    }
    return paramList.size();
  }
  
  private static <V> boolean b(List<V> paramList, V paramV)
  {
    if ((paramList != null) && (paramV != null)) {
      return paramList.add(paramV);
    }
    return false;
  }
  
  private static <V> V c(List<V> paramList, V paramV)
  {
    if (paramList == null) {
      return null;
    }
    return (V)e.a(paramList.toArray(), paramV, null, true);
  }
  
  private static String c(List<String> paramList)
  {
    return j.a.a(paramList, ",");
  }
  
  private static <V> int d(List<V> paramList)
  {
    if (j.a.a(paramList)) {
      return 0;
    }
    int n = paramList.size();
    int k = paramList.size();
    int j = 0;
    while (j < k)
    {
      int m;
      for (int i = j + 1; i < k; i = m + 1)
      {
        m = i;
        if (paramList.get(j).equals(paramList.get(i)))
        {
          paramList.remove(i);
          k = paramList.size();
          m = i - 1;
        }
      }
      j += 1;
    }
    return n - paramList.size();
  }
  
  private static <V> V d(List<V> paramList, V paramV)
  {
    if (paramList == null) {
      return null;
    }
    return (V)e.b(paramList.toArray(), paramV, null, true);
  }
  
  private static <V> List<V> e(List<V> paramList)
  {
    if (j.a.a(paramList)) {
      return paramList;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      localArrayList.add(paramList.get(i));
      i -= 1;
    }
    return localArrayList;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/g/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */