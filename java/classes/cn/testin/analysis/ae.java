package cn.testin.analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ae
  extends ag
  implements af
{
  private String e;
  
  public ae(ad paramad, String paramString)
  {
    super(paramString, null, null);
    this.d = this;
  }
  
  private String a(List<h> paramList)
  {
    JSONObject localJSONObject = new ai().a();
    long l = System.currentTimeMillis() / 1000L;
    String str = as.a(a.e + l);
    try
    {
      localJSONObject.put("stime", String.valueOf(l));
      localJSONObject.put("sign", str.substring(0, 6));
      localJSONObject.put("debug", a.i);
      paramList = b(paramList);
      if (paramList == null) {
        return null;
      }
      localJSONObject.put("records", paramList);
      return localJSONObject.toString();
    }
    catch (JSONException paramList)
    {
      ar.a(paramList);
    }
    return null;
  }
  
  private JSONArray b(List<h> paramList)
  {
    Object localObject1 = new HashMap();
    paramList = paramList.iterator();
    Object localObject2;
    Object localObject3;
    Object localObject4;
    while (paramList.hasNext())
    {
      localObject2 = (h)paramList.next();
      localObject3 = ((h)localObject2).c + "," + ((h)localObject2).d;
      if (((Map)localObject1).containsKey(localObject3))
      {
        ((List)((Map)localObject1).get(localObject3)).add(localObject2);
      }
      else
      {
        localObject4 = new ArrayList();
        ((List)localObject4).add(localObject2);
        ((Map)localObject1).put(localObject3, localObject4);
      }
    }
    paramList = new JSONArray();
    localObject1 = ((Map)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      try
      {
        localObject4 = (List)((Map.Entry)localObject2).getValue();
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("expId", ((h)((List)localObject4).get(0)).c);
        ((JSONObject)localObject2).put("componentsKey", ((h)((List)localObject4).get(0)).d);
        localObject3 = new JSONArray();
        localObject4 = ((List)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          h localh = (h)((Iterator)localObject4).next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("name", localh.b);
          localJSONObject.put("count", localh.e);
          localJSONObject.put("time", localh.f);
          ((JSONArray)localObject3).put(localJSONObject);
        }
      }
      catch (JSONException localJSONException)
      {
        ar.a(localJSONException);
      }
      localJSONException.put("metrics", localObject3);
      paramList.put(localJSONException);
    }
    return paramList;
  }
  
  public void a(int paramInt, String paramString)
  {
    au.a("up", false);
  }
  
  public void a(String paramString)
  {
    ad.a(this.a).a(this.e);
  }
  
  public String[] a()
  {
    Object localObject2 = ad.a(this.a).b();
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      Object localObject1 = new ArrayList();
      int i = 0;
      while (i < ((List)localObject2).size())
      {
        h localh1 = (h)((List)localObject2).get(i);
        int j = 0;
        int k = 0;
        while (j < ((ArrayList)localObject1).size())
        {
          h localh2 = (h)((ArrayList)localObject1).get(j);
          if (localh2.a(localh1))
          {
            localh2.e = av.a(localh2.e, localh1.e);
            k = 1;
          }
          j += 1;
        }
        if (k == 0) {
          ((ArrayList)localObject1).add(localh1);
        }
        i += 1;
      }
      localObject2 = ((h)((List)localObject2).get(((List)localObject2).size() - 1)).a;
      localObject1 = a((List)localObject1);
      if (localObject1 != null) {
        return new String[] { localObject2, localObject1 };
      }
    }
    return null;
  }
  
  public void run()
  {
    try
    {
      String[] arrayOfString = a();
      if ((arrayOfString != null) && (arrayOfString.length == 2))
      {
        this.e = arrayOfString[0];
        this.c = arrayOfString[1];
        b();
        return;
      }
      a(-1, "无可上传埋点");
      return;
    }
    catch (Exception localException)
    {
      ad.a(this.a).a();
      a(-1, "上传失败");
      ar.b(localException);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */