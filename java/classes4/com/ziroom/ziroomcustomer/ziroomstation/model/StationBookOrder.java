package com.ziroom.ziroomcustomer.ziroomstation.model;

import com.ziroom.ziroomcustomer.ziroomstation.b.a;
import java.io.Serializable;

public class StationBookOrder
  extends a
  implements Serializable
{
  private DataBean data;
  
  public DataBean getData()
  {
    return this.data;
  }
  
  public void setData(DataBean paramDataBean)
  {
    this.data = paramDataBean;
  }
  
  public static class DataBean
  {
    private String checkInRules;
    private String checkInTitle;
    private TipsMapBean tipsMap;
    
    public String getCheckInRules()
    {
      return this.checkInRules;
    }
    
    public String getCheckInTitle()
    {
      return this.checkInTitle;
    }
    
    public TipsMapBean getTipsMap()
    {
      return this.tipsMap;
    }
    
    public void setCheckInRules(String paramString)
    {
      this.checkInRules = paramString;
    }
    
    public void setCheckInTitle(String paramString)
    {
      this.checkInTitle = paramString;
    }
    
    public void setTipsMap(TipsMapBean paramTipsMapBean)
    {
      this.tipsMap = paramTipsMapBean;
    }
    
    public static class TipsMapBean
    {
      private BOOKORDERCANCLEORDERTIPBean BOOK_ORDER_CANCLE_ORDER_TIP;
      
      public BOOKORDERCANCLEORDERTIPBean getBOOK_ORDER_CANCLE_ORDER_TIP()
      {
        return this.BOOK_ORDER_CANCLE_ORDER_TIP;
      }
      
      public void setBOOK_ORDER_CANCLE_ORDER_TIP(BOOKORDERCANCLEORDERTIPBean paramBOOKORDERCANCLEORDERTIPBean)
      {
        this.BOOK_ORDER_CANCLE_ORDER_TIP = paramBOOKORDERCANCLEORDERTIPBean;
      }
      
      public static class BOOKORDERCANCLEORDERTIPBean
      {
        private int isClick;
        private String val;
        
        public int getIsClick()
        {
          return this.isClick;
        }
        
        public String getVal()
        {
          return this.val;
        }
        
        public void setIsClick(int paramInt)
        {
          this.isClick = paramInt;
        }
        
        public void setVal(String paramString)
        {
          this.val = paramString;
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/model/StationBookOrder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */