package com.ziroom.ziroomcustomer.minsu.landlord.c;

import com.ziroom.ziroomcustomer.flux.c;
import com.ziroom.ziroomcustomer.minsu.landlord.model.OrderDetailBean;
import com.ziroom.ziroomcustomer.minsu.landlord.model.RemarkItem;

public class a
  extends c
{
  private OrderDetailBean b;
  private RemarkItem c;
  private String d;
  
  public a(Object paramObject)
  {
    super(paramObject);
  }
  
  public OrderDetailBean getmOrderDetailBean()
  {
    return this.b;
  }
  
  public String getmRefuseReasonStr()
  {
    return this.d;
  }
  
  public RemarkItem getmRemarkItem()
  {
    return this.c;
  }
  
  public void onAction(com.ziroom.ziroomcustomer.flux.a parama)
  {
    String str = parama.getType();
    int i = -1;
    switch (str.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      a(new com.ziroom.ziroomcustomer.flux.a.a(parama.getType()));
      return;
      if (!str.equals("order_dtail")) {
        break;
      }
      i = 0;
      break;
      if (!str.equals("accept_order")) {
        break;
      }
      i = 1;
      break;
      if (!str.equals("confirm_other_money")) {
        break;
      }
      i = 2;
      break;
      if (!str.equals("refused_order")) {
        break;
      }
      i = 3;
      break;
      if (!str.equals("refuse_Reason")) {
        break;
      }
      i = 4;
      break;
      if (!str.equals("save_order_remark")) {
        break;
      }
      i = 5;
      break;
      if (!str.equals("del_order_remark")) {
        break;
      }
      i = 6;
      break;
      this.b = ((OrderDetailBean)parama.getData());
      continue;
      this.d = ((String)parama.getData());
      continue;
      this.c = ((RemarkItem)parama.getData());
    }
  }
  
  public void setmOrderDetailBean(OrderDetailBean paramOrderDetailBean)
  {
    this.b = paramOrderDetailBean;
  }
  
  public void setmRefuseReasonStr(String paramString)
  {
    this.d = paramString;
  }
  
  public void setmRemarkItem(RemarkItem paramRemarkItem)
  {
    this.c = paramRemarkItem;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlord/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */