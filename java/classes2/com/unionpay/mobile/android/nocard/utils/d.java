package com.unionpay.mobile.android.nocard.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.unionpay.mobile.android.callback.UPAndroidCallback;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.plugin.BaseActivity;
import com.unionpay.mobile.android.plugin.c;
import com.unionpay.mobile.android.utils.j;

public final class d
{
  private static UPAndroidCallback a = null;
  
  public static void a(Context paramContext, b paramb)
  {
    j.b("uppay", "exit() +++");
    j.a("uppay", "reqId=" + paramb.I.a);
    BaseActivity localBaseActivity = (BaseActivity)paramContext;
    if (paramb.I.f.length() > 0)
    {
      j.a("uppay", "result=" + paramb.I.f);
      switch (paramb.I.a)
      {
      }
    }
    for (;;)
    {
      if ((paramb.V != null) && (paramb.V.length() > 0) && (paramb.W != null) && (paramb.W.length() > 0))
      {
        boolean bool = paramb.U;
        localObject1 = paramb.V;
        paramb = paramb.W;
        if (bool) {
          new Thread(new e((String)localObject1, paramb, paramContext)).start();
        }
      }
      localBaseActivity.c();
      localBaseActivity.finish();
      j.b("uppay", "exit() +++");
      return;
      j.b("uppay", " notifyBrowserResult() +++ ");
      Object localObject3 = null;
      Object localObject1 = paramb.I.f;
      label279:
      Object localObject2;
      if (((String)localObject1).equalsIgnoreCase("fail"))
      {
        localObject1 = "1";
        localObject2 = localObject3;
        switch (paramb.I.a)
        {
        default: 
          localObject2 = localObject3;
        case 2: 
        case 3: 
          label324:
          localObject1 = paramb.r + (String)localObject1;
          j.a("uppay", "result URL= " + (String)localObject1);
          if (1000 == paramb.I.a)
          {
            localObject1 = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject1));
            ((Intent)localObject1).addCategory("android.intent.category.BROWSABLE");
            localBaseActivity.startActivity((Intent)localObject1);
          }
          break;
        }
      }
      for (;;)
      {
        j.b("uppay", " notifyBrowserResult() --- ");
        break;
        if (((String)localObject1).equalsIgnoreCase("cancel"))
        {
          localObject1 = "-1";
          break label279;
        }
        localObject1 = "0";
        break label279;
        localObject2 = new Intent("com.UCMobile.PluginApp.ActivityState");
        ((Intent)localObject2).putExtra("ActivityState", "inactive");
        ((Intent)localObject2).addCategory("android.intent.category.DEFAULT");
        localBaseActivity.sendBroadcast((Intent)localObject2);
        localObject2 = new Intent("com.unionpay.uppay.resultURL");
        j.b("uppay", " uc browser ");
        break label324;
        localObject2 = new Intent(paramb.I.b);
        j.b("uppay", " other browser ");
        j.a("uppay", " result Action=" + paramb.I.b);
        break label324;
        ((Intent)localObject2).putExtra("ResultURL", (String)localObject1);
        j.a("browser", ((Intent)localObject2).toURI());
        localBaseActivity.sendBroadcast((Intent)localObject2);
      }
      j.b("uppay", "notifyAppResult() +++");
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("pay_result", paramb.I.f);
      ((Intent)localObject1).putExtra("result_data", paramb.bi);
      if ((paramb.V != null) && (paramb.V.length() > 0) && (paramb.W != null) && (paramb.W.length() > 0) && (!paramb.U))
      {
        ((Intent)localObject1).putExtra("notify_url", paramb.V);
        ((Intent)localObject1).putExtra("notify_msg", paramb.W);
      }
      if (paramb.n != null)
      {
        ((Intent)localObject1).putExtra("qn", paramb.n);
        ((Intent)localObject1).putExtra("sid", paramb.k);
        ((Intent)localObject1).putExtra("secret", paramb.l);
      }
      if (a != null) {
        a.UPAndroidOK(paramb.I.f, paramb.n, paramb.k, paramb.l);
      }
      ((BaseActivity)localBaseActivity).setResult(-1, (Intent)localObject1);
      j.b("uppay", "notifyAppResult() ---");
      continue;
      j.b("uppay", "notifyTencentJarResult() +++");
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("pay_result", paramb.I.f);
      ((Intent)localObject1).putExtra("tencentWID", paramb.I.h);
      ((Intent)localObject1).putExtra("tencentUID", paramb.I.g);
      ((Intent)localObject1).putExtra("bankInfo", paramb.I.j);
      ((Intent)localObject1).putExtra("cardType", paramb.I.k);
      ((Intent)localObject1).putExtra("cardNo", paramb.I.i);
      localBaseActivity.setResult(-1, (Intent)localObject1);
      j.b("uppay", "notifyTencentJarResult() ---");
    }
  }
  
  public static void a(UPAndroidCallback paramUPAndroidCallback)
  {
    a = paramUPAndroidCallback;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/nocard/utils/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */