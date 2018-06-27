package com.growingio.android.sdk.models;

import com.growingio.android.sdk.utils.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends g
{
  private static String c = "GIO.ActionEvent";
  public List<b> a = new ArrayList();
  public long b;
  private String d;
  private boolean g;
  
  private a(String paramString)
  {
    this.d = paramString;
  }
  
  public static a d()
  {
    a locala = new a("imp");
    locala.g = false;
    return locala;
  }
  
  public static a e()
  {
    a locala = new a("clck");
    locala.g = true;
    return locala;
  }
  
  public static a f()
  {
    a locala = new a("chng");
    locala.g = true;
    return locala;
  }
  
  public String a()
  {
    return this.d;
  }
  
  public String a_()
  {
    if (this.d.equals("clck")) {
      return "click";
    }
    return this.d;
  }
  
  public JSONObject c()
  {
    JSONObject localJSONObject = null;
    if (this.a.size() > 0)
    {
      localJSONObject = l();
      a(localJSONObject, true);
      try
      {
        JSONArray localJSONArray = new JSONArray();
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext())
        {
          localJSONArray.put(((b)localIterator.next()).a());
          continue;
          return localJSONObject;
        }
      }
      catch (JSONException localJSONException)
      {
        LogUtil.d(c, "generate common event property error", localJSONException);
      }
    }
    localJSONObject.put("t", this.d);
    localJSONObject.put("ptm", this.b);
    if ("clck".equals(this.d))
    {
      a(localJSONObject);
      b(localJSONObject);
    }
    localJSONObject.put("e", localJSONException);
    return localJSONObject;
  }
  
  public a g()
  {
    a locala = new a(this.d);
    locala.b = this.b;
    locala.g = this.g;
    locala.e = this.e;
    locala.f = this.f;
    return locala;
  }
  
  public boolean h()
  {
    return this.g;
  }
  
  public int i()
  {
    return this.a.size();
  }
  
  public String toString()
  {
    return this.d + " event with " + this.a.size() + " elements ActionEvent@" + hashCode();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/models/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */