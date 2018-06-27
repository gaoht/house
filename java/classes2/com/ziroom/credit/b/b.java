package com.ziroom.credit.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.freelxl.baselibrary.f.d;
import com.freelxl.baselibrary.f.g;
import com.ziroom.commonlib.utils.r;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.datacenter.remote.responsebody.financial.b.m;
import com.ziroom.datacenter.remote.responsebody.financial.b.o;
import com.ziroom.router.activityrouter.Routers;
import java.net.URLEncoder;

public class b
{
  private static com.h.a a;
  private static Activity b;
  private static String c;
  private static String d;
  private static String e;
  private static String f;
  private static String g;
  private static String h;
  private static int i;
  private static int j;
  private static int k;
  private static int l = 0;
  private static String m;
  
  private static void b(Activity paramActivity, int paramInt, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.ziroom.ziroomcustomer.zmcertresult");
    localIntent.putExtra("code", paramInt);
    localIntent.putExtra("message", paramString);
    paramActivity.sendBroadcast(localIntent);
  }
  
  private static void c(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      return;
    }
    com.ziroom.datacenter.remote.e.c.callbacktExceptionCreditResult(b, paramString, new com.ziroom.datacenter.remote.b.a()
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public boolean onHandleMessage(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        if (paramAnonymousThrowable == null) {}
        while (!(paramAnonymousThrowable instanceof com.ziroom.commonlib.ziroomhttp.d.a)) {
          return false;
        }
        if ("10060".equals(((com.ziroom.commonlib.ziroomhttp.d.a)paramAnonymousThrowable).getCode()))
        {
          b.b();
          return true;
        }
        b.a(b.a(), 1, "认证失败");
        return false;
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.b.c paramAnonymousc)
      {
        if (paramAnonymousc == null) {}
        while (!paramAnonymousc.isSuccess()) {
          return;
        }
        d.d("yangxj======", "异常上传成功");
        g.textToast(b.a(), paramAnonymousc.getError_message());
        b.a(b.a(), 1, "认证失败");
      }
    });
  }
  
  public static void getUserCreditStatus(Context paramContext, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    b = (Activity)paramContext;
    a = com.h.a.getInstance();
    a.setZMCertificationListener(new com.h.b()
    {
      public void onFinish(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, int paramAnonymousInt)
      {
        if (paramAnonymousBoolean1) {
          return;
        }
        if (paramAnonymousBoolean2)
        {
          b.d();
          return;
        }
        b.a(paramAnonymousInt + "");
      }
    });
    c = paramBundle.getString("userName");
    i = paramBundle.getInt("certType");
    h = paramBundle.getString("certNum");
    k = paramBundle.getInt("userSex");
    d = paramBundle.getString("userPhone");
    e = paramBundle.getString("cerPositiveUrl");
    f = paramBundle.getString("certReverseUrl");
    g = paramBundle.getString("certHandhelUrl");
    j = paramBundle.getInt("source");
    if (paramBundle.getInt("isEnterprise") == 0) {}
    for (int n = 1;; n = 0)
    {
      d.e("yangxj", "芝麻认证------");
      l = 0;
      if (n != 0) {
        break;
      }
      l();
      return;
    }
    com.ziroom.datacenter.remote.e.c.getUserBaseInfo(b, new com.ziroom.datacenter.remote.b.a()
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public boolean onHandleMessage(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        return false;
      }
      
      public void onSuccess(int paramAnonymousInt, m paramAnonymousm)
      {
        if (paramAnonymousm == null) {
          return;
        }
        if (paramAnonymousm.getAuthStatus() == 1)
        {
          b.c();
          return;
        }
        Routers.openForResult(b.a(), "ziroomCustomer://zrCreditModule/impowerView?CreditStatic=1", 256);
      }
    });
  }
  
  private static void i()
  {
    com.ziroom.datacenter.remote.e.c.getUserBaseInfo(b, new com.ziroom.datacenter.remote.b.a()
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        b.a(b.a(), 1, "认证失败");
      }
      
      public boolean onHandleMessage(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        return false;
      }
      
      public void onSuccess(int paramAnonymousInt, m paramAnonymousm)
      {
        if (paramAnonymousm == null) {
          return;
        }
        if (paramAnonymousm.getRealNameStatus() == 4)
        {
          b.a(b.a(), 0, "认证成功");
          return;
        }
        b.a(b.a(), 1, "认证失败");
      }
    });
  }
  
  private static void j()
  {
    com.ziroom.datacenter.remote.e.c.callbacktUserNameCreditResult(b, m, new com.ziroom.datacenter.remote.b.a()
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public boolean onHandleMessage(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        return false;
      }
      
      public void onSuccess(int paramAnonymousInt, com.ziroom.datacenter.remote.responsebody.financial.b.c paramAnonymousc)
      {
        b.a(b.a(), 0, "认证成功");
      }
    });
  }
  
  private static void k()
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(b).setTitle("提示").setBtnConfirmText("开始短信认证").setContent("人脸认证失败，建议您进行短信认证").setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          b.a(4);
          b.c();
          return;
        }
        b.a(b.a(), -1, "取消认证");
      }
    }).build().show();
  }
  
  private static void l()
  {
    com.ziroom.datacenter.remote.e.c.getUserNameCreditInfo(b, new com.ziroom.datacenter.remote.d.a.c.f(c, i, h, d, e, f, g, j, l, k), new com.ziroom.datacenter.remote.b.a()
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public boolean onHandleMessage(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        if (paramAnonymousThrowable == null) {}
        while ((!(paramAnonymousThrowable instanceof com.ziroom.commonlib.ziroomhttp.d.a)) || (!"10037".equals(((com.ziroom.commonlib.ziroomhttp.d.a)paramAnonymousThrowable).getCode()))) {
          return false;
        }
        b.a(b.a(), 0, "认证成功");
        return true;
      }
      
      public void onSuccess(int paramAnonymousInt, o paramAnonymouso)
      {
        if (paramAnonymouso == null) {}
        while (b.e() != 1) {
          return;
        }
        b.b(paramAnonymouso.getToken());
        final String str = paramAnonymouso.getMerchantId();
        if (b.f() == 0)
        {
          b.a().runOnUiThread(new Runnable()
          {
            public void run()
            {
              b.h().startCertification(b.a(), b.g(), str, null);
            }
          });
          return;
        }
        if (com.freelxl.baselibrary.f.f.isNull(paramAnonymouso.getUrl()))
        {
          g.textToast(b.a(), "获取芝麻信用短信认证地址失败");
          return;
        }
        paramAnonymouso = b.toURLencoded(paramAnonymouso.getUrl());
        Routers.openForResult(b.a(), "ziroomCustomer://zrCreditModule/zmAuthorizationView?ZiMaUrl=" + paramAnonymouso, 272);
      }
    });
  }
  
  public static void onActivityResult(Context paramContext, Bundle paramBundle)
  {
    if (b != paramContext) {}
    int n;
    int i1;
    do
    {
      return;
      n = paramBundle.getInt("requestCode");
      i1 = paramBundle.getInt("resultCode");
      if (n == 256)
      {
        if (i1 == -1)
        {
          l();
          return;
        }
        b(b, -1, "取消认证");
        return;
      }
    } while ((n != 272) || (i1 != 272));
    i();
  }
  
  public static String toURLencoded(String paramString)
  {
    if (r.isNull(paramString)) {
      return "";
    }
    try
    {
      paramString = URLEncoder.encode(new String(paramString.getBytes(), "UTF-8"), "UTF-8");
      return paramString;
    }
    catch (Exception paramString) {}
    return "";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */