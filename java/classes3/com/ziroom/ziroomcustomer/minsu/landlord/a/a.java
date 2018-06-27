package com.ziroom.ziroomcustomer.minsu.landlord.a;

import android.app.Activity;
import android.content.Context;
import com.ziroom.ziroomcustomer.minsu.f.s;
import com.ziroom.ziroomcustomer.minsu.landlord.d.d;
import com.ziroom.ziroomcustomer.minsu.landlord.model.OrderDetailBean;
import com.ziroom.ziroomcustomer.minsu.landlord.model.RemarkItem;

public class a
{
  com.ziroom.ziroomcustomer.flux.b a;
  
  public a(com.ziroom.ziroomcustomer.flux.b paramb)
  {
    this.a = paramb;
  }
  
  public void delOrderRemark(final Object paramObject, Activity paramActivity, String paramString1, String paramString2)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.delOrderRemark(paramActivity, paramString1, paramString2, new s(paramActivity, new d(Object.class))
    {
      public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousObject);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("del_order_remark", paramAnonymousObject), paramObject);
      }
    });
  }
  
  public void getLandlordOrderDetail(final Object paramObject, Activity paramActivity, String paramString)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getLandlordOrderDetail(paramActivity, paramString, new s(paramActivity, new d(OrderDetailBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, OrderDetailBean paramAnonymousOrderDetailBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousOrderDetailBean);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("order_dtail", paramAnonymousOrderDetailBean), paramObject);
      }
    });
  }
  
  public void getLandlordRefuseReason(final Object paramObject, Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.getLandlordRefuseReason(paramActivity, paramString1, paramString2, paramString3, new s(paramActivity, new d(String.class))
    {
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("refuse_Reason", paramAnonymousString), paramObject);
      }
    });
  }
  
  public void saveOrderRemark(final Object paramObject, Activity paramActivity, String paramString1, final String paramString2)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.saveOrderRemark(paramActivity, paramString1, paramString2, new com.ziroom.ziroomcustomer.minsu.landlord.d.a(paramActivity, new com.ziroom.ziroomcustomer.minsu.landlord.d.b(RemarkItem.class))
    {
      public void onSuccess(int paramAnonymousInt, RemarkItem paramAnonymousRemarkItem)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousRemarkItem);
        paramAnonymousRemarkItem.setContent(paramString2);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("save_order_remark", paramAnonymousRemarkItem), paramObject);
      }
    });
  }
  
  public void setConfirmOtherMoney(final Object paramObject, Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.setConfirmOtherMoney(paramActivity, paramString1, paramString2, paramString3, new s(paramActivity, new d(Object.class))
    {
      public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousObject);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("confirm_other_money", paramAnonymousObject), paramObject);
      }
    });
  }
  
  public void setLandlordAcceptOrder(final Object paramObject, Activity paramActivity, String paramString)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.setLandlordAcceptOrder(paramActivity, paramString, new s(paramActivity, new d(Object.class))
    {
      public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousObject);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("accept_order", paramAnonymousObject), paramObject);
      }
    });
  }
  
  public void setLandlordRefuseOrder(final Object paramObject, Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.setLandlordRefuseOrder(paramActivity, paramString1, paramString2, paramString3, new s(paramActivity, new d(Object.class))
    {
      public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousObject);
        a.this.a.dispatchWithTarget(new com.ziroom.ziroomcustomer.flux.a("refused_order", paramAnonymousObject), paramObject);
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlord/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */