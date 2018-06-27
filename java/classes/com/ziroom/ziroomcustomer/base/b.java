package com.ziroom.ziroomcustomer.base;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.alibaba.fastjson.e;
import com.ziroom.ziroomcustomer.base.a.a;
import com.ziroom.ziroomcustomer.base.a.c;
import com.ziroom.ziroomcustomer.e.c.d;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.util.ae;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class b
{
  public static boolean a;
  public static boolean b;
  public static String c = "北京";
  public static String d = "110000";
  private static com.ziroom.ziroomcustomer.base.a.b e = new a();
  private static com.ziroom.ziroomcustomer.base.a.b f = new c();
  private static com.ziroom.ziroomcustomer.base.a.b g = e;
  private static com.ziroom.ziroomcustomer.base.a.b h = null;
  private static List<com.ziroom.ziroomcustomer.base.a.b> i = new ArrayList();
  private static List<com.ziroom.ziroomcustomer.base.a.b> j = new ArrayList();
  
  static
  {
    initCityList();
    j.add(e);
    j.add(f);
  }
  
  private static void a(com.ziroom.ziroomcustomer.base.a.b paramb)
  {
    if (paramb != null)
    {
      g = paramb;
      SharedPreferences.Editor localEditor = ApplicationEx.c.getSharedPreferences("citylocation", 0).edit();
      localEditor.putString("current_city_code", paramb.getCode());
      localEditor.apply();
    }
  }
  
  private static void a(String paramString)
  {
    com.ziroom.ziroomcustomer.base.a.b localb = b(paramString);
    paramString = localb;
    if (localb == null) {
      paramString = e;
    }
    a(paramString);
    c = paramString.getName();
    d = paramString.getCode();
  }
  
  private static com.ziroom.ziroomcustomer.base.a.b b(String paramString)
  {
    Iterator localIterator = i.iterator();
    while (localIterator.hasNext())
    {
      com.ziroom.ziroomcustomer.base.a.b localb = (com.ziroom.ziroomcustomer.base.a.b)localIterator.next();
      if (paramString.equals(localb.getCode())) {
        return localb;
      }
    }
    return null;
  }
  
  public static void changeCity(String paramString)
  {
    if (ae.notNull(paramString))
    {
      com.ziroom.ziroomcustomer.findhouse.HouseListActivity.b = "";
      com.ziroom.ziroomcustomer.findhouse.HouseListActivity.a = "";
      com.ziroom.ziroomcustomer.findhouse.HouseListActivity.c = new HashSet();
      a(paramString);
      paramString = new Intent();
      paramString.setAction("select_city");
      ApplicationEx.c.sendBroadcast(paramString);
      LocalBroadcastManager.getInstance(ApplicationEx.c).sendBroadcast(paramString);
    }
  }
  
  public static void changeZryuCity(com.ziroom.ziroomcustomer.base.a.b paramb)
  {
    h = paramb;
  }
  
  public static void changeZryuCity(String paramString)
  {
    paramString = b(paramString);
    if (paramString != null) {
      changeZryuCity(paramString);
    }
  }
  
  public static com.ziroom.ziroomcustomer.base.a.b getCityByName(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = i.iterator();
    while (localIterator.hasNext())
    {
      com.ziroom.ziroomcustomer.base.a.b localb = (com.ziroom.ziroomcustomer.base.a.b)localIterator.next();
      if (localb.getName().equals(paramString)) {
        return localb;
      }
    }
    return null;
  }
  
  public static String getCityCodeFromSP()
  {
    return ApplicationEx.c.getSharedPreferences("citylocation", 0).getString("current_city_code", "");
  }
  
  public static List<com.ziroom.ziroomcustomer.base.a.b> getCityList()
  {
    return i;
  }
  
  public static com.ziroom.ziroomcustomer.base.a.b getCurrentCity()
  {
    return g;
  }
  
  public static List<com.ziroom.ziroomcustomer.base.a.b> getZryuCityList()
  {
    return j;
  }
  
  public static com.ziroom.ziroomcustomer.base.a.b getZryuCurrentCity()
  {
    return h;
  }
  
  public static void initCity()
  {
    String str = getCityCodeFromSP();
    if (!TextUtils.isEmpty(str))
    {
      g = b(str);
      a(str);
    }
  }
  
  public static void initCityList()
  {
    initCityListFromServer();
    Object localObject = ApplicationEx.c.getSharedPreferences("citylocation", 0).getString("city_list", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = e.parseObject((String)localObject);
      if (localObject != null)
      {
        localObject = ((e)localObject).getJSONArray("citys");
        if (localObject != null) {
          i = ((com.alibaba.fastjson.b)localObject).toJavaList(com.ziroom.ziroomcustomer.base.a.b.class);
        }
      }
      b = true;
      return;
    }
    i = new ArrayList();
    i.add(e);
    b = false;
  }
  
  public static void initCityListFromServer()
  {
    j.getCityList(ApplicationEx.c, new b.1(ApplicationEx.c, new d()));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/base/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */