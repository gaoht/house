package com.baidu.platform.comapi.map;

import android.os.Handler;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.MessageCenter;
import com.baidu.mapapi.common.EnvironmentUtilities;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.platform.comjni.map.basemap.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class t
{
  private static final String a = t.class.getSimpleName();
  private static t c;
  private a b;
  private y d;
  private Handler e;
  
  public static t a()
  {
    if (c == null)
    {
      c = new t();
      c.g();
    }
    return c;
  }
  
  private void g()
  {
    h();
    this.d = new y();
    this.e = new u(this);
    MessageCenter.registMessage(65289, this.e);
  }
  
  private void h()
  {
    EnvironmentUtilities.initAppDirectory(BMapManager.getContext());
    this.b = new a();
    this.b.a();
    String str5 = SysOSUtil.getModuleFileName();
    String str4 = EnvironmentUtilities.getAppSDCardPath();
    String str3 = EnvironmentUtilities.getAppCachePath();
    String str2 = EnvironmentUtilities.getAppSecondCachePath();
    int i = EnvironmentUtilities.getMapTmpStgMax();
    int j = EnvironmentUtilities.getDomTmpStgMax();
    int k = EnvironmentUtilities.getItsTmpStgMax();
    if (SysOSUtil.getDensityDpi() >= 180) {}
    for (String str1 = "/h/";; str1 = "/l/")
    {
      String str6 = str5 + "/cfg";
      String str8 = str4 + "/vmp";
      str4 = str6 + str1;
      str5 = str6 + "/a/";
      str6 = str6 + "/idrres/";
      String str7 = str8 + str1;
      str1 = str8 + str1;
      str3 = str3 + "/tmp/";
      str2 = str2 + "/tmp/";
      this.b.a(str4, str7, str3, str2, str1, str5, null, str6, SysOSUtil.getScreenSizeX(), SysOSUtil.getScreenSizeY(), SysOSUtil.getDensityDpi(), i, j, k, 0);
      this.b.f();
      return;
    }
  }
  
  public ArrayList<s> a(String paramString)
  {
    if ((paramString.equals("")) || (this.b == null)) {}
    for (;;)
    {
      return null;
      Object localObject1 = this.b.a(paramString);
      if ((localObject1 == null) || (((String)localObject1).equals(""))) {
        continue;
      }
      paramString = new ArrayList();
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        if ((localObject1 == null) || (((JSONObject)localObject1).length() == 0)) {
          continue;
        }
        localObject1 = ((JSONObject)localObject1).optJSONArray("dataset");
        if (localObject1 == null) {
          continue;
        }
        int i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          s locals1 = new s();
          Object localObject2 = ((JSONArray)localObject1).getJSONObject(i);
          locals1.a = ((JSONObject)localObject2).optInt("id");
          locals1.b = ((JSONObject)localObject2).optString("name");
          locals1.c = ((JSONObject)localObject2).optInt("mapsize");
          locals1.d = ((JSONObject)localObject2).optInt("cty");
          if (((JSONObject)localObject2).has("child"))
          {
            localObject2 = ((JSONObject)localObject2).optJSONArray("child");
            ArrayList localArrayList = new ArrayList();
            int j = 0;
            while (j < ((JSONArray)localObject2).length())
            {
              s locals2 = new s();
              JSONObject localJSONObject = ((JSONArray)localObject2).optJSONObject(j);
              locals2.a = localJSONObject.optInt("id");
              locals2.b = localJSONObject.optString("name");
              locals2.c = localJSONObject.optInt("mapsize");
              locals2.d = localJSONObject.optInt("cty");
              localArrayList.add(locals2);
              j += 1;
            }
            locals1.a(localArrayList);
          }
          paramString.add(locals1);
          i += 1;
        }
        return paramString;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
    }
  }
  
  public void a(x paramx)
  {
    if (this.d != null) {
      this.d.a(paramx);
    }
  }
  
  public boolean a(int paramInt)
  {
    if ((this.b == null) || (paramInt < 0)) {
      return false;
    }
    return this.b.b(paramInt);
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.b == null) {
      return false;
    }
    return this.b.a(paramBoolean1, paramBoolean2);
  }
  
  public void b()
  {
    MessageCenter.unregistMessage(65289, this.e);
    this.b.b();
    c = null;
  }
  
  public void b(x paramx)
  {
    if (this.d != null) {
      this.d.b(paramx);
    }
  }
  
  public boolean b(int paramInt)
  {
    if ((this.b == null) || (paramInt < 0)) {
      return false;
    }
    return this.b.a(paramInt, false, 0);
  }
  
  public ArrayList<s> c()
  {
    if (this.b == null) {
      return null;
    }
    Object localObject1 = this.b.o();
    ArrayList localArrayList1 = new ArrayList();
    try
    {
      localObject1 = new JSONObject((String)localObject1).optJSONArray("dataset");
      int i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        s locals1 = new s();
        Object localObject2 = ((JSONArray)localObject1).optJSONObject(i);
        locals1.a = ((JSONObject)localObject2).optInt("id");
        locals1.b = ((JSONObject)localObject2).optString("name");
        locals1.c = ((JSONObject)localObject2).optInt("mapsize");
        locals1.d = ((JSONObject)localObject2).optInt("cty");
        if (((JSONObject)localObject2).has("child"))
        {
          localObject2 = ((JSONObject)localObject2).optJSONArray("child");
          ArrayList localArrayList2 = new ArrayList();
          int j = 0;
          while (j < ((JSONArray)localObject2).length())
          {
            s locals2 = new s();
            JSONObject localJSONObject = ((JSONArray)localObject2).optJSONObject(j);
            locals2.a = localJSONObject.optInt("id");
            locals2.b = localJSONObject.optString("name");
            locals2.c = localJSONObject.optInt("mapsize");
            locals2.d = localJSONObject.optInt("cty");
            localArrayList2.add(locals2);
            j += 1;
          }
          locals1.a(localArrayList2);
        }
        localArrayList1.add(locals1);
        i += 1;
      }
      return localJSONException;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      return null;
    }
  }
  
  public boolean c(int paramInt)
  {
    if ((this.b == null) || (paramInt < 0)) {
      return false;
    }
    return this.b.b(paramInt, false, 0);
  }
  
  public ArrayList<s> d()
  {
    if (this.b == null) {
      return null;
    }
    Object localObject1 = this.b.a("");
    ArrayList localArrayList1 = new ArrayList();
    try
    {
      localObject1 = new JSONObject((String)localObject1).optJSONArray("dataset");
      int i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        s locals1 = new s();
        Object localObject2 = ((JSONArray)localObject1).optJSONObject(i);
        locals1.a = ((JSONObject)localObject2).optInt("id");
        locals1.b = ((JSONObject)localObject2).optString("name");
        locals1.c = ((JSONObject)localObject2).optInt("mapsize");
        locals1.d = ((JSONObject)localObject2).optInt("cty");
        if (((JSONObject)localObject2).has("child"))
        {
          localObject2 = ((JSONObject)localObject2).optJSONArray("child");
          ArrayList localArrayList2 = new ArrayList();
          int j = 0;
          while (j < ((JSONArray)localObject2).length())
          {
            s locals2 = new s();
            JSONObject localJSONObject = ((JSONArray)localObject2).optJSONObject(j);
            locals2.a = localJSONObject.optInt("id");
            locals2.b = localJSONObject.optString("name");
            locals2.c = localJSONObject.optInt("mapsize");
            locals2.d = localJSONObject.optInt("cty");
            localArrayList2.add(locals2);
            j += 1;
          }
          locals1.a(localArrayList2);
        }
        localArrayList1.add(locals1);
        i += 1;
      }
      return localArrayList1;
    }
    catch (Exception localException)
    {
      return null;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
  
  public boolean d(int paramInt)
  {
    if (this.b == null) {
      return false;
    }
    return this.b.b(0, true, paramInt);
  }
  
  public ArrayList<w> e()
  {
    int i = 0;
    if (this.b == null) {}
    Object localObject;
    do
    {
      return null;
      localObject = this.b.n();
    } while ((localObject == null) || (((String)localObject).equals("")));
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject);
        if (((JSONObject)localObject).length() == 0) {
          break;
        }
        localObject = ((JSONObject)localObject).optJSONArray("dataset");
        if (i >= ((JSONArray)localObject).length()) {
          return localArrayList;
        }
        w localw = new w();
        v localv = new v();
        JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i);
        localv.a = localJSONObject.optInt("id");
        localv.b = localJSONObject.optString("name");
        localv.c = localJSONObject.optString("pinyin");
        localv.h = localJSONObject.optInt("mapoldsize");
        localv.i = localJSONObject.optInt("ratio");
        localv.l = localJSONObject.optInt("status");
        localv.g = new GeoPoint(localJSONObject.optInt("y"), localJSONObject.optInt("x"));
        if (localJSONObject.optInt("up") == 1)
        {
          localv.j = true;
          localv.e = localJSONObject.optInt("lev");
          if (localv.j)
          {
            localv.k = localJSONObject.optInt("mapsize");
            localw.a(localv);
            localArrayList.add(localw);
            i += 1;
          }
        }
        else
        {
          localv.j = false;
          continue;
        }
        localv.k = 0;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return null;
      }
    }
    return localException;
  }
  
  public boolean e(int paramInt)
  {
    if ((this.b == null) || (paramInt < 0)) {
      return false;
    }
    return this.b.b(paramInt, false);
  }
  
  public boolean f(int paramInt)
  {
    if ((this.b == null) || (paramInt < 0)) {
      return false;
    }
    return this.b.a(paramInt, false);
  }
  
  public w g(int paramInt)
  {
    if ((this.b == null) || (paramInt < 0)) {}
    Object localObject;
    do
    {
      return null;
      localObject = this.b.c(paramInt);
    } while ((localObject == null) || (((String)localObject).equals("")));
    w localw = new w();
    v localv = new v();
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject);
        if (((JSONObject)localObject).length() == 0) {
          break;
        }
        localv.a = ((JSONObject)localObject).optInt("id");
        localv.b = ((JSONObject)localObject).optString("name");
        localv.c = ((JSONObject)localObject).optString("pinyin");
        localv.d = ((JSONObject)localObject).optString("headchar");
        localv.h = ((JSONObject)localObject).optInt("mapoldsize");
        localv.i = ((JSONObject)localObject).optInt("ratio");
        localv.l = ((JSONObject)localObject).optInt("status");
        localv.g = new GeoPoint(((JSONObject)localObject).optInt("y"), ((JSONObject)localObject).optInt("x"));
        if (((JSONObject)localObject).optInt("up") == 1)
        {
          localv.j = true;
          localv.e = ((JSONObject)localObject).optInt("lev");
          if (localv.j)
          {
            localv.k = ((JSONObject)localObject).optInt("mapsize");
            localv.f = ((JSONObject)localObject).optInt("ver");
            localw.a(localv);
            return localw;
          }
        }
        else
        {
          localv.j = false;
          continue;
        }
        localv.k = 0;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return null;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/platform/comapi/map/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */