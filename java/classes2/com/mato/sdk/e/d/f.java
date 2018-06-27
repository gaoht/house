package com.mato.sdk.e.d;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class f
{
  public boolean a = true;
  public int b = -1;
  private final String c;
  private a d;
  
  f(String paramString)
  {
    this.c = paramString;
  }
  
  private String c()
  {
    return this.c;
  }
  
  private a d()
  {
    return this.d;
  }
  
  public final void a()
  {
    if (this.d == null)
    {
      this.d = new a(this.a);
      this.d.a = 700;
    }
    while (this.a) {
      return;
    }
    this.d.a = this.b;
  }
  
  public final void a(String paramString)
  {
    this.d = new a(this.a, paramString);
  }
  
  public final String b()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("taskId", this.c);
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(this.d.toString());
      ((JSONObject)localObject).put("testLog", localJSONArray);
      localObject = ((JSONObject)localObject).toString();
      return (String)localObject;
    }
    catch (JSONException localJSONException) {}
    return "";
  }
  
  static final class a
  {
    private static final int b = 0;
    private static final int c = 2;
    private static final int d = 3;
    private static final int e = 4;
    private static final int f = 5;
    private static final int g = 6;
    private static final int h = 7;
    private static final int i = 8;
    private static final int j = 9;
    private static final int k = 10;
    private static final int l = 13;
    private static final int m = 14;
    private static final int n = 15;
    private static final int o = 18;
    private static final int p = 19;
    private static final int q = 21;
    private static final int r = 24;
    private static final int s = 26;
    private static final int t = 27;
    private static final int u = 31;
    private static final int v = 32;
    private static final int w = 33;
    private static final int x = 34;
    private String A = "";
    private String B = "";
    private int C = -1;
    private int D = -1;
    private int E = -1;
    private int F = -1;
    private int G = -1;
    private int H = -1;
    private int I = -1;
    private int J = -1;
    private String K = "";
    private String L = "";
    private String M = "";
    private String N = "";
    private String O = "";
    private int P = -1;
    private String Q = "";
    private String R = "";
    private String S = "";
    private int T = -1;
    private boolean U;
    public int a = -1;
    private long y = -1L;
    private String z = "";
    
    public a(boolean paramBoolean)
    {
      this.U = paramBoolean;
    }
    
    public a(boolean paramBoolean, String paramString)
    {
      this.U = paramBoolean;
      paramString = paramString.split("\t");
      if ((paramString == null) || (paramString.length < 24)) {
        return;
      }
      this.y = ((Double.valueOf(paramString[0]).doubleValue() * 1000.0D));
      this.z = a(paramString[2]);
      this.A = a(paramString[3]);
      this.B = a(paramString[4]);
      this.a = Integer.valueOf(paramString[5]).intValue();
      this.C = Integer.valueOf(paramString[6]).intValue();
      this.D = Integer.valueOf(paramString[7]).intValue();
      this.T = Integer.valueOf(paramString[34]).intValue();
      this.E = Integer.valueOf(paramString[8]).intValue();
      this.F = Integer.valueOf(paramString[9]).intValue();
      this.G = Integer.valueOf(paramString[10]).intValue();
      this.H = Integer.valueOf(paramString[13]).intValue();
      this.I = Integer.valueOf(paramString[14]).intValue();
      this.J = Integer.valueOf(paramString[15]).intValue();
      this.K = a(paramString[18]);
      this.L = a(paramString[19]);
      this.M = a(paramString[21]);
      this.N = a(paramString[24]);
      this.O = a(paramString[26]);
      this.P = Integer.valueOf(paramString[27]).intValue();
      this.Q = a(paramString[31]);
      this.R = a(paramString[32]);
      this.S = a(paramString[33]);
    }
    
    private static String a(String paramString)
    {
      String str = paramString;
      if (paramString.startsWith("\""))
      {
        str = paramString;
        if (paramString.endsWith("\""))
        {
          int i1 = "\"".length();
          str = paramString.substring(i1, paramString.length() - i1);
        }
      }
      return str;
    }
    
    private static int b(String paramString)
    {
      return Integer.valueOf(paramString).intValue();
    }
    
    public final String toString()
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(this.y).append("\t").append(this.z).append("\t").append(this.A).append("\t").append(this.B).append("\t").append(this.a).append("\t").append(this.C).append("\t").append(this.D).append("\t").append(this.T).append("\t").append(this.E).append("\t").append(this.F).append("\t").append(this.G).append("\t").append(this.H).append("\t").append(this.I).append("\t").append(this.J).append("\t").append(this.K).append("\t").append(this.L).append("\t").append(this.M).append("\t").append(this.N).append("\t").append(this.O).append("\t").append(this.P).append("\t").append(this.Q).append("\t").append(this.R).append("\t").append(this.S).append("\t").append(this.U);
      return localStringBuffer.toString();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/e/d/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */