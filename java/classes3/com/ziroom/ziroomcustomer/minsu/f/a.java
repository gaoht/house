package com.ziroom.ziroomcustomer.minsu.f;

import android.content.Intent;
import android.net.Uri;
import com.freelxl.baselibrary.f.f;
import com.ziroom.ziroomcustomer.WelcomeActivity;
import com.ziroom.ziroomcustomer.minsu.dialog.h;
import com.ziroom.ziroomcustomer.util.ae;

public class a
{
  private static void a(WelcomeActivity paramWelcomeActivity, String paramString, Uri paramUri)
  {
    int k = 1;
    boolean bool = true;
    int j = -1;
    int i;
    switch (paramString.hashCode())
    {
    default: 
      i = -1;
      switch (i)
      {
      default: 
        label58:
        paramWelcomeActivity.toNextPage(false, -1, -1);
      }
      break;
    }
    for (;;)
    {
      paramWelcomeActivity.finish();
      return;
      if (!paramString.equals("main")) {
        break;
      }
      i = 0;
      break label58;
      if (!paramString.equals("evaluate")) {
        break;
      }
      i = 1;
      break label58;
      if (!paramString.equals("im")) {
        break;
      }
      i = 2;
      break label58;
      if (!paramString.equals("houseDetail")) {
        break;
      }
      i = 3;
      break label58;
      paramString = paramUri.getQueryParameter("isMinsu");
      String str = paramUri.getQueryParameter("userType");
      paramUri = paramUri.getQueryParameter("tabType");
      if ((!ae.isNull(paramString)) && (Boolean.parseBoolean(paramString)))
      {
        label192:
        if (!ae.isNull(str)) {
          break label227;
        }
        i = -1;
        label202:
        if (!ae.isNull(paramUri)) {
          break label236;
        }
      }
      for (;;)
      {
        paramWelcomeActivity.toNextPage(bool, i, j);
        break;
        bool = false;
        break label192;
        label227:
        i = Integer.parseInt(str);
        break label202;
        label236:
        j = Integer.parseInt(paramUri);
      }
      k.toEvaActivity(paramWelcomeActivity, paramUri.getQueryParameter("orderSn"), h.valueOf(Integer.parseInt(paramUri.getQueryParameter("userType"))));
      continue;
      paramString = paramUri.getQueryParameter("toChatUsername");
      i = k;
      if (Integer.parseInt(paramUri.getQueryParameter("msgSenderType")) == 1) {
        i = 2;
      }
      k.toChatActivity(paramWelcomeActivity, paramString, i);
      continue;
      k.toHouseDetail(paramWelcomeActivity, paramUri.getQueryParameter("fid"), paramUri.getQueryParameter("rentWay"), "1".equals(paramUri.getQueryParameter("isTop50Online")));
    }
  }
  
  public static boolean onRoute(WelcomeActivity paramWelcomeActivity, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      String str = paramIntent.getAction();
      paramIntent = paramIntent.getData();
      if (("android.intent.action.VIEW".equals(str)) && (paramIntent != null))
      {
        str = paramIntent.getQueryParameter("page");
        if (f.notNull(str))
        {
          a(paramWelcomeActivity, str, paramIntent);
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */