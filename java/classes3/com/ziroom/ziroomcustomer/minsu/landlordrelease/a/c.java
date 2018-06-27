package com.ziroom.ziroomcustomer.minsu.landlordrelease.a;

import android.app.Activity;
import android.content.Context;
import com.ziroom.ziroomcustomer.flux.b;
import com.ziroom.ziroomcustomer.minsu.f.r;
import com.ziroom.ziroomcustomer.minsu.f.s;
import com.ziroom.ziroomcustomer.minsu.f.t;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.CertificationBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.CustomerInfoBean;

public class c
{
  private static c b;
  final b a;
  
  private c(b paramb)
  {
    this.a = paramb;
  }
  
  public static c getInstance(b paramb)
  {
    if (b == null) {
      b = new c(paramb);
    }
    return b;
  }
  
  public void getCertification(final Activity paramActivity)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getCertification(paramActivity, new t(paramActivity, new r(CertificationBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        c.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("certification_error", paramAnonymousThrowable.getMessage()), paramActivity);
      }
      
      public void onSuccess(int paramAnonymousInt, CertificationBean paramAnonymousCertificationBean)
      {
        c.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("certification", paramAnonymousCertificationBean), paramActivity);
      }
    });
  }
  
  public void getCustomerInfo(final Activity paramActivity)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getCustomerInfo(paramActivity, new t(paramActivity, new r(CustomerInfoBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        c.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("customerInfo_error", paramAnonymousThrowable.getMessage()), paramActivity);
      }
      
      public void onSuccess(int paramAnonymousInt, CustomerInfoBean paramAnonymousCustomerInfoBean)
      {
        c.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("customerInfo", paramAnonymousCustomerInfoBean), paramActivity);
      }
    });
  }
  
  public void saveCustomerInfo(final Activity paramActivity, String paramString1, String paramString2)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.saveCustomerInfo(paramActivity, paramString1, paramString2, new s(paramActivity, new r(CustomerInfoBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        c.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("saveCustomerInfo_error", paramAnonymousThrowable.getMessage()), paramActivity);
      }
      
      public void onSuccess(int paramAnonymousInt, CustomerInfoBean paramAnonymousCustomerInfoBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousCustomerInfoBean);
        c.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("saveCustomerInfo", paramAnonymousCustomerInfoBean), paramActivity);
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */