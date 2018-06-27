package com.mato.sdk.d;

import android.text.TextUtils;
import android.util.Base64;
import com.mato.sdk.c.d.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class j
  extends c
{
  private static int a = 0;
  private static int b = 1;
  private static int c = 2;
  private static int d = 3;
  private static final String e = "domain";
  private static final String f = "prefix";
  private static final String g = "billingType";
  private static final String h = "regexList";
  private static final String i = "backupIP";
  private String j = "";
  private String k = "";
  private int l = 0;
  private List<a> m = new ArrayList();
  private String n = "";
  
  private void a(List<a> paramList)
  {
    this.m = paramList;
  }
  
  public static j b(JSONObject paramJSONObject)
  {
    j localj = new j();
    localj.a(paramJSONObject);
    return localj;
  }
  
  private void c(JSONArray paramJSONArray)
  {
    int i2 = paramJSONArray.length();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject = paramJSONArray.optJSONObject(i1);
      localObject = new a(c.a((JSONObject)localObject, "regular", true), ((JSONObject)localObject).optInt("port", 0), ((JSONObject)localObject).optInt("protocol", 0), ((JSONObject)localObject).optInt("matchType", 2));
      this.m.add(localObject);
      i1 += 1;
    }
  }
  
  public final String a()
  {
    return this.j;
  }
  
  public final boolean a(JSONObject paramJSONObject)
  {
    this.j = paramJSONObject.optString("domain", this.j);
    this.k = paramJSONObject.optString("prefix", this.k);
    this.l = paramJSONObject.optInt("billingType", this.l);
    this.n = paramJSONObject.optString("backupIP", this.n);
    paramJSONObject = paramJSONObject.optJSONArray("regexList");
    if (paramJSONObject != null)
    {
      int i2 = paramJSONObject.length();
      int i1 = 0;
      while (i1 < i2)
      {
        Object localObject = paramJSONObject.optJSONObject(i1);
        localObject = new a(c.a((JSONObject)localObject, "regular", true), ((JSONObject)localObject).optInt("port", 0), ((JSONObject)localObject).optInt("protocol", 0), ((JSONObject)localObject).optInt("matchType", 2));
        this.m.add(localObject);
        i1 += 1;
      }
    }
    return true;
  }
  
  public final String b()
  {
    return this.n;
  }
  
  public final String c()
  {
    return this.k;
  }
  
  public final int d()
  {
    return this.l;
  }
  
  public final List<a> e()
  {
    return this.m;
  }
  
  public final JSONObject w()
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("domain", this.j);
    localJSONObject1.put("prefix", this.k);
    localJSONObject1.put("billingType", this.l);
    localJSONObject1.put("backupIP", this.n);
    JSONArray localJSONArray = new JSONArray();
    List localList = this.m;
    int i2 = localList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      a locala = (a)localList.get(i1);
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("port", locala.d());
      localJSONObject2.put("protocol", locala.e());
      localJSONObject2.put("regular", Base64.encode(locala.c().getBytes(), 0));
      localJSONArray.put(localJSONObject2);
      i1 += 1;
    }
    localJSONObject1.put("regexList", localJSONArray);
    return localJSONObject1;
  }
  
  public static class a
  {
    private static final String a = "port";
    private static final String b = "regular";
    private static final String c = "protocol";
    private static final String d = "matchType";
    private static int e = 0;
    private static int f = 1;
    private static int g = 2;
    private static int h = 3;
    private static int i = 4;
    private static int j = 5;
    private static int k = 6;
    private static int l = 7;
    private static int m = 8;
    private static int n = 9;
    private static int o = 10;
    private static int p = 11;
    private static String u = ",";
    private final String q;
    private final int r;
    private int s;
    private final int t;
    
    private a()
    {
      throw new AssertionError();
    }
    
    public a(String paramString, int paramInt1, int paramInt2, int paramInt3)
    {
      this.s = 0;
      this.q = paramString;
      this.r = paramInt1;
      this.s = paramInt2;
      this.t = paramInt3;
    }
    
    private static <V> int a(List<V> paramList1, List<V> paramList2)
    {
      if ((paramList1 == null) || (a(paramList2))) {
        return 0;
      }
      int i1 = paramList1.size();
      paramList2 = paramList2.iterator();
      while (paramList2.hasNext())
      {
        Object localObject = paramList2.next();
        if (!paramList1.contains(localObject)) {
          paramList1.add(localObject);
        }
      }
      return paramList1.size() - i1;
    }
    
    public static a a(JSONObject paramJSONObject)
    {
      return new a(c.a(paramJSONObject, "regular", true), paramJSONObject.optInt("port", 0), paramJSONObject.optInt("protocol", 0), paramJSONObject.optInt("matchType", 2));
    }
    
    private static String a(List<String> paramList, char paramChar)
    {
      return a(paramList, new String(new char[] { paramChar }));
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
      int i1 = 0;
      for (;;)
      {
        if (i1 >= paramArrayList1.size()) {
          break label75;
        }
        bool1 = bool2;
        if (!k.a(paramArrayList1.get(i1), paramArrayList2.get(i1))) {
          break;
        }
        i1 += 1;
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
      return a(paramList, ",");
    }
    
    private static <V> int d(List<V> paramList)
    {
      if (a(paramList)) {
        return 0;
      }
      int i5 = paramList.size();
      int i3 = paramList.size();
      int i2 = 0;
      while (i2 < i3)
      {
        int i4;
        for (int i1 = i2 + 1; i1 < i3; i1 = i4 + 1)
        {
          i4 = i1;
          if (paramList.get(i2).equals(paramList.get(i1)))
          {
            paramList.remove(i1);
            i3 = paramList.size();
            i4 = i1 - 1;
          }
        }
        i2 += 1;
      }
      return i5 - paramList.size();
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
      if (a(paramList)) {
        return paramList;
      }
      ArrayList localArrayList = new ArrayList(paramList.size());
      int i1 = paramList.size() - 1;
      while (i1 >= 0)
      {
        localArrayList.add(paramList.get(i1));
        i1 -= 1;
      }
      return localArrayList;
    }
    
    public final boolean a()
    {
      return this.s == 10;
    }
    
    public final int b()
    {
      return this.t;
    }
    
    public final String c()
    {
      return this.q;
    }
    
    public final int d()
    {
      return this.r;
    }
    
    public final int e()
    {
      return this.s;
    }
    
    public final JSONObject f()
      throws JSONException
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("port", this.r);
      localJSONObject.put("protocol", this.s);
      localJSONObject.put("regular", Base64.encode(this.q.getBytes(), 0));
      return localJSONObject;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/d/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */