package com.ziroom.ziroomcustomer.util;

import android.content.Context;
import android.content.Intent;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.c.q;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.model.CertInfoEntity;
import com.ziroom.ziroomcustomer.model.CertInfoEntity.CreditsBean;
import com.ziroom.ziroomcustomer.signed.CertInformationActivity;
import com.ziroom.ziroomcustomer.signed.CertificationInfoActivity;
import java.lang.ref.WeakReference;

public class d
{
  private WeakReference<Context> a;
  private a b;
  private Intent c;
  
  public d(Context paramContext)
  {
    this.a = new WeakReference(paramContext);
  }
  
  public d(Context paramContext, Intent paramIntent)
  {
    this.a = new WeakReference(paramContext);
    this.c = paramIntent;
  }
  
  public d(Context paramContext, a parama)
  {
    this.a = new WeakReference(paramContext);
    this.b = parama;
  }
  
  private void a(final String paramString)
  {
    Context localContext = (Context)this.a.get();
    if (localContext != null)
    {
      paramString = new f(localContext, new q(CertInfoEntity.class))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
          if (d.b(d.this) != null) {
            d.b(d.this).onAuthenticate(paramString, null);
          }
        }
        
        public void onSuccess(int paramAnonymousInt, CertInfoEntity paramAnonymousCertInfoEntity)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousCertInfoEntity);
          Context localContext = (Context)d.a(d.this).get();
          if (localContext != null)
          {
            if (d.b(d.this) == null) {
              break label52;
            }
            d.b(d.this).onAuthenticate(paramString, paramAnonymousCertInfoEntity);
          }
          label52:
          while ((paramAnonymousCertInfoEntity == null) || (paramAnonymousCertInfoEntity.credits == null) || (paramAnonymousCertInfoEntity.credits.realNameStatus == 0)) {
            return;
          }
          Intent localIntent = new Intent();
          localIntent.putExtra("fromUtil", true);
          if (d.c(d.this) != null) {
            localIntent.putExtra("successIntent", d.c(d.this));
          }
          switch (paramAnonymousCertInfoEntity.credits.realNameStatus)
          {
          default: 
            return;
          case 1: 
            if ("1".equals(paramAnonymousCertInfoEntity.getCert_type()))
            {
              localIntent.setClass(localContext, CertInformationActivity.class);
              localIntent.putExtra("cert_info", paramAnonymousCertInfoEntity);
              localIntent.putExtra("phone", paramString);
              localContext.startActivity(localIntent);
              return;
            }
            localIntent.setClass(localContext, CertificationInfoActivity.class);
            localIntent.putExtra("cert_info", paramAnonymousCertInfoEntity);
            localIntent.putExtra("phone", paramString);
            localContext.startActivity(localIntent);
            return;
          case 2: 
          case 3: 
            localIntent.setClass(localContext, CertificationInfoActivity.class);
            localIntent.putExtra("cert_info", paramAnonymousCertInfoEntity);
            localIntent.putExtra("phone", paramString);
            localContext.startActivity(localIntent);
            return;
          case 4: 
            if (d.c(d.this) == null)
            {
              localIntent.setClass(localContext, CertificationInfoActivity.class);
              localIntent.putExtra("cert_info", paramAnonymousCertInfoEntity);
              localIntent.putExtra("phone", paramString);
              localContext.startActivity(localIntent);
              return;
            }
            localContext.startActivity(d.c(d.this));
            return;
          }
          localIntent.setClass(localContext, CertInformationActivity.class);
          localIntent.putExtra("cert_info", paramAnonymousCertInfoEntity);
          localIntent.putExtra("phone", paramString);
          localContext.startActivity(localIntent);
        }
      };
      j.getCertInfo(localContext, com.ziroom.commonlibrary.login.a.getToken(localContext), 1, paramString);
    }
  }
  
  public void authenticate(String paramString)
  {
    if ((Context)this.a.get() != null) {
      a(paramString);
    }
  }
  
  public static abstract interface a
  {
    public abstract void onAuthenticate(String paramString, CertInfoEntity paramCertInfoEntity);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/util/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */