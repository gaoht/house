package com.growingio.android.sdk.models;

import com.growingio.android.sdk.utils.LogUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  private static String a = "GIO.HeatMapData";
  private String b;
  private String c;
  private String d;
  private a[] e;
  
  public c(JSONObject paramJSONObject)
  {
    try
    {
      this.b = paramJSONObject.getString("x");
      this.c = paramJSONObject.getString("h");
      this.d = paramJSONObject.getString("v");
      this.e = a.a(paramJSONObject.getJSONArray("items"));
      return;
    }
    catch (JSONException paramJSONObject)
    {
      LogUtil.e(a, "HeatMapData DataBean解析异常" + paramJSONObject);
    }
  }
  
  public static c[] a(JSONArray paramJSONArray)
  {
    int j = paramJSONArray.length();
    c[] arrayOfc = new c[j];
    int i = 0;
    for (;;)
    {
      if (i < j) {
        try
        {
          arrayOfc[i] = new c(paramJSONArray.getJSONObject(i));
          i += 1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
      }
    }
    return arrayOfc;
  }
  
  public String a()
  {
    return this.b;
  }
  
  public String b()
  {
    return this.d;
  }
  
  public a[] c()
  {
    return this.e;
  }
  
  public static class a
  {
    private int a;
    private int b;
    private double c;
    
    public a(JSONObject paramJSONObject)
    {
      try
      {
        this.a = paramJSONObject.getInt("idx");
        this.b = paramJSONObject.getInt("cnt");
        this.c = paramJSONObject.getDouble("percent");
        return;
      }
      catch (JSONException paramJSONObject)
      {
        LogUtil.e(c.d(), "HeatMapData ItemsBean" + paramJSONObject);
      }
    }
    
    public static a[] a(JSONArray paramJSONArray)
    {
      int j = paramJSONArray.length();
      a[] arrayOfa = new a[j];
      int i = 0;
      for (;;)
      {
        if (i < j) {
          try
          {
            arrayOfa[i] = new a(paramJSONArray.getJSONObject(i));
            i += 1;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        }
      }
      return arrayOfa;
    }
    
    public int a()
    {
      return this.a;
    }
    
    public int b()
    {
      return this.b;
    }
    
    public double c()
    {
      return this.c;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/models/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */