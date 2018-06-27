package com.ziroom.ziroomcustomer.bestgoods;

import android.text.TextUtils;
import com.ziroom.ziroomcustomer.base.a.b;
import com.ziroom.ziroomcustomer.base.a.c;
import com.ziroom.ziroomcustomer.base.a.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
{
  public static String a = "北京";
  public static String b = "110000";
  public static String[] c = { "朝阳区", "海淀区", "丰台区", "西城区", "昌平区", "东城区", "通州区", "大兴区", "顺义区", "石景山区" };
  private static b d = new com.ziroom.ziroomcustomer.base.a.a();
  private static b e = new c();
  private static b f = new d();
  private static b g = d;
  private static List<b> h = new ArrayList();
  
  static
  {
    h.add(d);
    h.add(e);
    h.add(f);
  }
  
  public static b getCityByName(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = h.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.getName().equals(paramString)) {
        return localb;
      }
    }
    return null;
  }
  
  public static List<b> getCityList()
  {
    return h;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */