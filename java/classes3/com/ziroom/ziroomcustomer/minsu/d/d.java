package com.ziroom.ziroomcustomer.minsu.d;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import cn.jpush.android.api.JPushInterface;
import com.alibaba.fastjson.a;
import com.ziroom.commonlibrary.c.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuEvaluetionActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuSignedActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuWebActivity;
import com.ziroom.ziroomcustomer.minsu.dialog.h;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.landlord.activity.LandlordOrderDetailActivity;
import com.ziroom.ziroomcustomer.minsu.landlord.activity.MinsuLandLordMainNewActivity;
import com.ziroom.ziroomcustomer.util.ae;

public class d
{
  private static Object b = new Object();
  private static d c;
  private Context a;
  
  private d(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private boolean a(String paramString)
  {
    return "6".equals(paramString);
  }
  
  private boolean b(String paramString)
  {
    return "1".equals(paramString);
  }
  
  private boolean c(String paramString)
  {
    return "2".equals(paramString);
  }
  
  private boolean d(String paramString)
  {
    return "7".equals(paramString);
  }
  
  private boolean e(String paramString)
  {
    return "8".equals(paramString);
  }
  
  private boolean f(String paramString)
  {
    return "9".equals(paramString);
  }
  
  public static d getInstance(Context paramContext)
  {
    if (c == null) {}
    synchronized (b)
    {
      c = new d(paramContext);
      return c;
    }
  }
  
  public void Messagedeal(Bundle paramBundle)
  {
    paramBundle = a.parseObject(paramBundle.getString(JPushInterface.EXTRA_EXTRA));
    if ((paramBundle != null) && (a(paramBundle.getString("msg_sub_type"))) && (MinsuLandLordMainNewActivity.a != null)) {
      MinsuLandLordMainNewActivity.a.UpLoadData();
    }
  }
  
  public void clickEvent(String paramString)
  {
    com.alibaba.fastjson.e locale;
    String str2;
    String str1;
    if (ae.notNull(paramString))
    {
      locale = a.parseObject(paramString);
      if (locale != null)
      {
        str2 = locale.getString("msg_sub_type");
        str1 = null;
        if (!b(str2)) {
          break label179;
        }
        if (!ae.notNull(locale.getString("orderSn"))) {
          break label112;
        }
        paramString = new Intent(this.a, LandlordOrderDetailActivity.class);
        paramString.putExtra("orderSn", locale.get("orderSn") + "");
      }
    }
    for (;;)
    {
      if (paramString != null)
      {
        paramString.addFlags(268435456);
        this.a.startActivity(paramString);
      }
      return;
      label112:
      paramString = new Intent(this.a, MinsuWebActivity.class);
      paramString.putExtra("url", com.ziroom.ziroomcustomer.minsu.e.e.convertUrl(locale.get("url") + ""));
      paramString.putExtra("isLoadTitle", false);
      paramString.putExtra("isLoadUrl", true);
      continue;
      label179:
      if (c(str2))
      {
        paramString = locale.getString("orderSn");
        str1 = locale.getString("msg_tag_type");
        if ((ae.notNull(paramString)) && ("2".equals(str1)))
        {
          paramString = new Intent(this.a, LandlordOrderDetailActivity.class);
          paramString.putExtra("orderSn", locale.get("orderSn") + "");
        }
        else
        {
          paramString = new Intent(this.a, MinsuSignedActivity.class);
          paramString.putExtra("orderSn", locale.get("orderSn") + "");
        }
      }
      else if (d(str2))
      {
        paramString = new Intent(this.a, MinsuEvaluetionActivity.class);
        paramString.putExtra("orderSn", locale.get("orderSn") + "");
        paramString.putExtra("userType", h.valueOf(Integer.parseInt(locale.get("userType") + "")));
      }
      else if (a(str2))
      {
        k.goLLHouseList(this.a);
        paramString = str1;
      }
      else if (e(str2))
      {
        k.toCouponListActivity(ApplicationEx.c);
        paramString = str1;
      }
      else
      {
        paramString = str1;
        if (f(str2))
        {
          k.toReleaseManager(ApplicationEx.c, locale.getString("houseBaseFid"), locale.getString("roomFid"), Integer.parseInt(locale.getString("rentWay")), 0);
          paramString = str1;
        }
      }
    }
  }
  
  public void deal(Bundle paramBundle)
  {
    clickEvent(paramBundle.getString(JPushInterface.EXTRA_EXTRA));
  }
  
  public void link(b paramb)
  {
    clickEvent(paramb.f);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/d/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */