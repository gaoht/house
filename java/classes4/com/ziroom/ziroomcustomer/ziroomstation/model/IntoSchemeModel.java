package com.ziroom.ziroomcustomer.ziroomstation.model;

import com.freelxl.baselibrary.b.b;
import java.util.List;

public class IntoSchemeModel
  extends b
{
  public DataBean data;
  
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
    public String endDate;
    public List<HtListBean> htList;
    public String orderBid;
    public String startDate;
    
    public List<HtListBean> getHtList()
    {
      return this.htList;
    }
    
    public String getOrderBid()
    {
      return this.orderBid;
    }
    
    public void setHtList(List<HtListBean> paramList)
    {
      this.htList = paramList;
    }
    
    public void setOrderBid(String paramString)
    {
      this.orderBid = paramString;
    }
    
    public static class HtListBean
    {
      public int bedCount;
      public int depositAmount;
      public String htBid;
      public String htShowName;
      public List<List<ShemeListBean>> shemeList;
      
      public int getBedCount()
      {
        return this.bedCount;
      }
      
      public int getDepositAmount()
      {
        return this.depositAmount;
      }
      
      public String getHtBid()
      {
        return this.htBid;
      }
      
      public String getHtShowName()
      {
        return this.htShowName;
      }
      
      public List<List<ShemeListBean>> getShemeList()
      {
        return this.shemeList;
      }
      
      public void setBedCount(int paramInt)
      {
        this.bedCount = paramInt;
      }
      
      public void setDepositAmount(int paramInt)
      {
        this.depositAmount = paramInt;
      }
      
      public void setHtBid(String paramString)
      {
        this.htBid = paramString;
      }
      
      public void setHtShowName(String paramString)
      {
        this.htShowName = paramString;
      }
      
      public void setShemeList(List<List<ShemeListBean>> paramList)
      {
        this.shemeList = paramList;
      }
      
      public static class ShemeListBean
      {
        public List<BedListBean> bedList;
        public String roomBid;
        public String roomName;
        
        public List<BedListBean> getBedList()
        {
          return this.bedList;
        }
        
        public String getRoomBid()
        {
          return this.roomBid;
        }
        
        public String getRoomName()
        {
          return this.roomName;
        }
        
        public void setBedList(List<BedListBean> paramList)
        {
          this.bedList = paramList;
        }
        
        public void setRoomBid(String paramString)
        {
          this.roomBid = paramString;
        }
        
        public void setRoomName(String paramString)
        {
          this.roomName = paramString;
        }
        
        public static class BedListBean
        {
          public String bedBid;
          public String bedCode;
          public int isDefaultLabel;
          public int isUseAble;
          public String[] label;
          public String name;
          public String sex;
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/model/IntoSchemeModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */