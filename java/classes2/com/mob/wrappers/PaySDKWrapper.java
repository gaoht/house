package com.mob.wrappers;

import com.mob.paysdk.AliPayAPI;
import com.mob.paysdk.MobPayAPI;
import com.mob.paysdk.OnPayListener;
import com.mob.paysdk.Order;
import com.mob.paysdk.PayOrder;
import com.mob.paysdk.PayResult;
import com.mob.paysdk.PaySDK;
import com.mob.paysdk.TicketOrder;
import com.mob.paysdk.WXPayAPI;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.ReflectHelper;

public class PaySDKWrapper
  implements PublicMemberKeeper
{
  private static int state;
  
  private static boolean isAvailable()
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        int i = state;
        if (i == 0) {}
        try
        {
          ReflectHelper.importClass("com.mob.paysdk.PaySDK");
          state = 1;
          i = state;
          if (i == 1) {
            return bool;
          }
        }
        catch (Throwable localThrowable)
        {
          state = -1;
          continue;
        }
        bool = false;
      }
      finally {}
    }
  }
  
  public static int pay(final Order paramOrder, final int paramInt, PayCallback paramPayCallback)
    throws PaySDKWrapper.LinkagePaySDKError, PaySDKWrapper.UnknowOrder, PaySDKWrapper.UnsupportedPayPlatform
  {
    if (!isAvailable()) {
      throw new LinkagePaySDKError();
    }
    Object localObject;
    if ((paramOrder instanceof PayOrder))
    {
      localObject = ((PayOrder)paramOrder).order;
      if (50 != paramInt) {
        break label86;
      }
    }
    for (Class localClass = AliPayAPI.class;; localClass = WXPayAPI.class)
    {
      PaySDK.createMobPayAPI(localClass).pay((Order)localObject, new OnPayListener()
      {
        public void onPayEnd(PayResult paramAnonymousPayResult, Object paramAnonymousObject, MobPayAPI paramAnonymousMobPayAPI)
        {
          if (this.val$callback != null) {
            this.val$callback.onPayEnd(paramOrder, paramInt, paramAnonymousPayResult.ordinal());
          }
        }
        
        public boolean onWillPay(String paramAnonymousString, Object paramAnonymousObject, MobPayAPI paramAnonymousMobPayAPI)
        {
          return this.val$callback.onWillPay(paramOrder, paramInt, paramAnonymousString);
        }
      });
      return 0;
      if ((paramOrder instanceof TicketOrder))
      {
        localObject = ((TicketOrder)paramOrder).order;
        break;
      }
      throw new UnknowOrder();
      label86:
      if (22 != paramInt) {
        break label99;
      }
    }
    label99:
    throw new UnsupportedPayPlatform();
  }
  
  public static class LinkagePaySDKError
    extends Error
  {}
  
  public static abstract class Order {}
  
  public static abstract interface PayCallback
  {
    public abstract void onPayEnd(PaySDKWrapper.Order paramOrder, int paramInt1, int paramInt2);
    
    public abstract boolean onWillPay(PaySDKWrapper.Order paramOrder, int paramInt, String paramString);
  }
  
  public static class PayOrder
    extends PaySDKWrapper.Order
    implements PublicMemberKeeper
  {
    private PayOrder order;
    
    public PayOrder()
    {
      if (PaySDKWrapper.access$200()) {
        this.order = new PayOrder();
      }
    }
    
    public int getAmount()
    {
      if (PaySDKWrapper.access$200()) {
        return this.order.getAmount();
      }
      return 0;
    }
    
    public String getBody()
    {
      if (PaySDKWrapper.access$200()) {
        return this.order.getBody();
      }
      return "";
    }
    
    public String getDescription()
    {
      if (PaySDKWrapper.access$200()) {
        return this.order.getDescription();
      }
      return "";
    }
    
    public String getMetadata()
    {
      if (PaySDKWrapper.access$200()) {
        return this.order.getMetadata();
      }
      return "";
    }
    
    public String getOrderNo()
    {
      if (PaySDKWrapper.access$200()) {
        return this.order.getOrderNo();
      }
      return "";
    }
    
    public String getSubject()
    {
      if (PaySDKWrapper.access$200()) {
        return this.order.getSubject();
      }
      return "";
    }
    
    public String getTicketId()
    {
      if (PaySDKWrapper.access$200()) {
        return this.order.getTicketId();
      }
      return "";
    }
    
    public void setAmount(int paramInt)
    {
      if (PaySDKWrapper.access$200()) {
        this.order.setAmount(paramInt);
      }
    }
    
    public void setBody(String paramString)
    {
      if (PaySDKWrapper.access$200()) {
        this.order.setBody(paramString);
      }
    }
    
    public void setDescription(String paramString)
    {
      if (PaySDKWrapper.access$200()) {
        this.order.setDescription(paramString);
      }
    }
    
    public void setMetadata(String paramString)
    {
      if (PaySDKWrapper.access$200()) {
        this.order.setMetadata(paramString);
      }
    }
    
    public void setOrderNo(String paramString)
    {
      if (PaySDKWrapper.access$200()) {
        this.order.setOrderNo(paramString);
      }
    }
    
    public void setSubject(String paramString)
    {
      if (PaySDKWrapper.access$200()) {
        this.order.setSubject(paramString);
      }
    }
  }
  
  public static class TicketOrder
    extends PaySDKWrapper.Order
    implements PublicMemberKeeper
  {
    private TicketOrder order;
    
    public TicketOrder()
    {
      if (PaySDKWrapper.access$200()) {
        this.order = new TicketOrder();
      }
    }
    
    public String getTicketId()
    {
      if (PaySDKWrapper.access$200()) {
        return this.order.getTicketId();
      }
      return "";
    }
    
    public void setTicketId(String paramString)
    {
      if (PaySDKWrapper.access$200()) {
        this.order.setTicketId(paramString);
      }
    }
  }
  
  public static class UnknowOrder
    extends Exception
  {}
  
  public static class UnsupportedPayPlatform
    extends Exception
  {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/wrappers/PaySDKWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */