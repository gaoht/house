package com.ziroom.ziroomcustomer.ziroomapartment;

import android.content.Context;
import android.content.Intent;
import com.alibaba.fastjson.b;
import com.alibaba.fastjson.e;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.e.c.c;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.util.ad;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.ziroomapartment.activity.ZryuProjectDRevisionActivity;
import com.ziroom.ziroomcustomer.ziroomapartment.meetaapartdetail.MeeTaApartDetailActivity;

public class a
{
  public static void ToProjectInfo(Context paramContext, String paramString)
  {
    int j = 0;
    if (ae.isNull(paramString)) {
      return;
    }
    Object localObject = com.alibaba.fastjson.a.parseArray(ad.getProject(paramContext));
    if (localObject != null) {
      for (int i = 0;; i = k)
      {
        k = i;
        if (j >= ((b)localObject).size()) {
          break;
        }
        e locale = ((b)localObject).getJSONObject(j);
        k = i;
        if (locale != null)
        {
          k = i;
          if (paramString.equals(locale.getString("projectId")))
          {
            k = i;
            if ("1".equals(locale.getString("isNewDetail"))) {
              k = 1;
            }
          }
        }
        j += 1;
      }
    }
    int k = 0;
    if (k != 0)
    {
      localObject = new Intent(paramContext, MeeTaApartDetailActivity.class);
      ((Intent)localObject).putExtra("projectId", paramString);
      paramContext.startActivity((Intent)localObject);
      return;
    }
    localObject = new Intent(paramContext, ZryuProjectDRevisionActivity.class);
    ((Intent)localObject).putExtra("projectId", paramString);
    paramContext.startActivity((Intent)localObject);
  }
  
  public static void getProjectMap(Context paramContext)
  {
    j.getProjectMap(ApplicationEx.c, new a.1(ApplicationEx.c, new c(), paramContext));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */