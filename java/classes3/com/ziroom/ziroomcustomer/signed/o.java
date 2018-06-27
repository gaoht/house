package com.ziroom.ziroomcustomer.signed;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.alibaba.fastjson.e;
import com.ziroom.commonlibrary.login.a.b;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.model.CertInfoEntity;
import com.ziroom.ziroomcustomer.model.CertInfoEntity.CreditsBean;
import com.ziroom.ziroomcustomer.model.HouseDetail;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.ziroomstation.utils.h;

public class o
{
  private static Context a;
  private static String b;
  private static f<e> g = new f(a, new com.ziroom.ziroomcustomer.e.c.o())
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      dismissProgress();
      super.onFailure(paramAnonymousThrowable);
    }
    
    public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
    {
      dismissProgress();
      paramAnonymouse = (CertInfoEntity)h.parseObject(paramAnonymouse.toJSONString(), CertInfoEntity.class);
      if ((paramAnonymouse != null) && (paramAnonymouse.credits != null) && (paramAnonymouse.credits.realNameStatus != 0)) {}
      switch (paramAnonymouse.credits.realNameStatus)
      {
      default: 
        return;
      case 2: 
        localIntent = new Intent(o.b(), CertificationInfoActivity.class);
        localIntent.putExtra("cert_info", paramAnonymouse);
        localIntent.putExtra("phone", o.a());
        localIntent.putExtra("signData", "signData");
        o.b().startActivity(localIntent);
        return;
      case 3: 
        localIntent = new Intent(o.b(), CertificationInfoActivity.class);
        localIntent.putExtra("cert_info", paramAnonymouse);
        localIntent.putExtra("phone", o.a());
        localIntent.putExtra("signData", "signData");
        o.b().startActivity(localIntent);
        return;
      case 4: 
        localIntent = new Intent(o.b(), CertificationInfoActivity.class);
        localIntent.putExtra("cert_info", paramAnonymouse);
        localIntent.putExtra("phone", o.a());
        localIntent.putExtra("signData", "signData");
        o.b().startActivity(localIntent);
        return;
      case 1: 
        if ("1".equals(paramAnonymouse.getCert_type()))
        {
          localIntent = new Intent(o.b(), CertInformationActivity.class);
          localIntent.putExtra("cert_info", paramAnonymouse);
          localIntent.putExtra("phone", o.a());
          localIntent.putExtra("signData", "signData");
          o.b().startActivity(localIntent);
          return;
        }
        localIntent = new Intent(o.b(), CertificationInfoActivity.class);
        localIntent.putExtra("cert_info", paramAnonymouse);
        localIntent.putExtra("phone", o.a());
        localIntent.putExtra("signData", "signData");
        o.b().startActivity(localIntent);
        return;
      }
      Intent localIntent = new Intent(o.b(), CertInformationActivity.class);
      localIntent.putExtra("cert_info", paramAnonymouse);
      localIntent.putExtra("phone", o.a());
      localIntent.putExtra("signData", "signData");
      o.b().startActivity(localIntent);
    }
  };
  private HouseDetail c;
  private int d;
  private f<e> e = new f(a, new com.ziroom.ziroomcustomer.e.c.o())
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      dismissProgress();
      super.onFailure(paramAnonymousThrowable);
    }
    
    public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
    {
      dismissProgress();
      paramAnonymouse = (CertInfoEntity)h.parseObject(paramAnonymouse.toJSONString(), CertInfoEntity.class);
      if ((paramAnonymouse != null) && (paramAnonymouse.credits != null) && (paramAnonymouse.credits.realNameStatus != 0)) {}
      switch (paramAnonymouse.credits.realNameStatus)
      {
      default: 
        return;
      case 2: 
        localIntent = new Intent(o.b(), CertificationInfoActivity.class);
        localIntent.putExtra("cert_info", paramAnonymouse);
        localIntent.putExtra("phone", o.a());
        localIntent.putExtra("type", o.c(o.this));
        o.b().startActivity(localIntent);
        return;
      case 3: 
        localIntent = new Intent(o.b(), CertificationInfoActivity.class);
        localIntent.putExtra("cert_info", paramAnonymouse);
        localIntent.putExtra("phone", o.a());
        localIntent.putExtra("type", o.c(o.this));
        o.b().startActivity(localIntent);
        return;
      case 4: 
        localIntent = new Intent(o.b(), SignedCertInfoConfirmActivity.class);
        localIntent.putExtra("cert_info", paramAnonymouse);
        localIntent.putExtra("phone", o.a());
        localIntent.putExtra("type", o.c(o.this));
        o.b().startActivity(localIntent);
        return;
      case 1: 
        if ("1".equals(paramAnonymouse.getCert_type()))
        {
          localIntent = new Intent(o.b(), CertInformationActivity.class);
          localIntent.putExtra("cert_info", paramAnonymouse);
          localIntent.putExtra("phone", o.a());
          localIntent.putExtra("type", o.c(o.this));
          o.b().startActivity(localIntent);
          return;
        }
        localIntent = new Intent(o.b(), CertificationInfoActivity.class);
        localIntent.putExtra("cert_info", paramAnonymouse);
        localIntent.putExtra("phone", o.a());
        localIntent.putExtra("type", o.c(o.this));
        o.b().startActivity(localIntent);
        return;
      }
      Intent localIntent = new Intent(o.b(), CertInformationActivity.class);
      localIntent.putExtra("cert_info", paramAnonymouse);
      localIntent.putExtra("phone", o.a());
      localIntent.putExtra("type", o.c(o.this));
      o.b().startActivity(localIntent);
    }
  };
  private f<e> f = new f(a, new com.ziroom.ziroomcustomer.e.c.o())
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      dismissProgress();
      super.onFailure(paramAnonymousThrowable);
    }
    
    public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
    {
      dismissProgress();
      paramAnonymouse = (CertInfoEntity)h.parseObject(paramAnonymouse.toJSONString(), CertInfoEntity.class);
      if ((paramAnonymouse != null) && (paramAnonymouse.credits != null) && (paramAnonymouse.credits.realNameStatus != 0)) {}
      switch (paramAnonymouse.credits.realNameStatus)
      {
      default: 
        return;
      case 2: 
        localIntent = new Intent(o.b(), CertificationInfoActivity.class);
        localIntent.putExtra("detail", o.d(o.this));
        localIntent.putExtra("phone", o.a());
        localIntent.putExtra("cert_info", paramAnonymouse);
        localIntent.putExtra("type", o.c(o.this));
        o.b().startActivity(localIntent);
        return;
      case 3: 
        localIntent = new Intent(o.b(), CertificationInfoActivity.class);
        localIntent.putExtra("detail", o.d(o.this));
        localIntent.putExtra("phone", o.a());
        localIntent.putExtra("cert_info", paramAnonymouse);
        localIntent.putExtra("type", o.c(o.this));
        o.b().startActivity(localIntent);
        return;
      case 4: 
        localIntent = new Intent(o.b(), SignedCertInfoConfirmActivity.class);
        localIntent.putExtra("detail", o.d(o.this));
        localIntent.putExtra("phone", o.a());
        localIntent.putExtra("cert_info", paramAnonymouse);
        localIntent.putExtra("type", o.c(o.this));
        o.b().startActivity(localIntent);
        return;
      case 1: 
        if ("1".equals(paramAnonymouse.getCert_type()))
        {
          localIntent = new Intent(o.b(), CertInformationActivity.class);
          localIntent.putExtra("detail", o.d(o.this));
          localIntent.putExtra("phone", o.a());
          localIntent.putExtra("cert_info", paramAnonymouse);
          localIntent.putExtra("type", o.c(o.this));
          o.b().startActivity(localIntent);
          return;
        }
        localIntent = new Intent(o.b(), CertificationInfoActivity.class);
        localIntent.putExtra("detail", o.d(o.this));
        localIntent.putExtra("phone", o.a());
        localIntent.putExtra("cert_info", paramAnonymouse);
        localIntent.putExtra("type", o.c(o.this));
        o.b().startActivity(localIntent);
        return;
      }
      Intent localIntent = new Intent(o.b(), CertInformationActivity.class);
      localIntent.putExtra("detail", o.d(o.this));
      localIntent.putExtra("phone", o.a());
      localIntent.putExtra("cert_info", paramAnonymouse);
      localIntent.putExtra("type", o.c(o.this));
      o.b().startActivity(localIntent);
    }
  };
  
  public o(Context paramContext)
  {
    a = paramContext;
  }
  
  public static void toCertificate(Context paramContext, Bundle paramBundle)
  {
    a = paramContext;
    com.ziroom.commonlibrary.login.a.getUserInfo(a, new a.b()
    {
      public void onUserInfo(e paramAnonymouse)
      {
        if (paramAnonymouse == null) {
          return;
        }
        o.a((String)paramAnonymouse.get("phone"));
        if (ae.notNull(o.a()))
        {
          j.getCertInfo(o.b(), com.ziroom.commonlibrary.login.a.getToken(o.b()), 0, o.c());
          return;
        }
        com.ziroom.commonlibrary.login.a.startBindPhoneActivity(o.b());
      }
    });
  }
  
  public void toDownloadCertificate(int paramInt)
  {
    this.d = paramInt;
    com.ziroom.commonlibrary.login.a.getUserInfo(a, new a.b()
    {
      public void onUserInfo(e paramAnonymouse)
      {
        if (paramAnonymouse == null) {
          return;
        }
        o.a((String)paramAnonymouse.get("phone"));
        if (ae.notNull(o.a()))
        {
          j.getCertInfo(o.b(), com.ziroom.commonlibrary.login.a.getToken(o.b()), 0, o.b(o.this));
          return;
        }
        com.ziroom.commonlibrary.login.a.startBindPhoneActivity(o.b());
      }
    });
  }
  
  public void toSign(HouseDetail paramHouseDetail, int paramInt)
  {
    this.c = paramHouseDetail;
    this.d = paramInt;
    com.ziroom.commonlibrary.login.a.getUserInfo(a, new a.b()
    {
      public void onUserInfo(e paramAnonymouse)
      {
        if (paramAnonymouse == null) {
          return;
        }
        o.a((String)paramAnonymouse.get("phone"));
        if (ae.notNull(o.a()))
        {
          j.getCertInfo(o.b(), com.ziroom.commonlibrary.login.a.getToken(o.b()), 0, o.a(o.this));
          return;
        }
        com.ziroom.commonlibrary.login.a.startBindPhoneActivity(o.b());
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */