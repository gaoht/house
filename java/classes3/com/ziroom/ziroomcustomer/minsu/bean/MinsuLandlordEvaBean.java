package com.ziroom.ziroomcustomer.minsu.bean;

import java.util.List;

public class MinsuLandlordEvaBean
  extends MinsuBaseJson
{
  public DataBean data;
  
  public DataBean getData()
  {
    return this.data;
  }
  
  public String toString()
  {
    return "MinsuLandlordEvaBean{data=" + this.data + '}';
  }
  
  public static class DataBean
  {
    public List<EvaListBean> evaList;
    public int total;
    
    public List<EvaListBean> getEvaList()
    {
      return this.evaList;
    }
    
    public int getTotal()
    {
      return this.total;
    }
    
    public String toString()
    {
      return "DataBean{total=" + this.total + ", evaList=" + this.evaList + '}';
    }
    
    public static class EvaListBean
    {
      public String houseFid;
      public String houseName;
      public int isTop50Online;
      public LandlordEvaItemBean landlordEvaItem;
      public int rentWay;
      public TenantEvaItemBean tenantEvaItem;
      
      public String getHouseFid()
      {
        return this.houseFid;
      }
      
      public String getHouseName()
      {
        return this.houseName;
      }
      
      public LandlordEvaItemBean getLandlordEvaItem()
      {
        return this.landlordEvaItem;
      }
      
      public int getRentWay()
      {
        return this.rentWay;
      }
      
      public TenantEvaItemBean getTenantEvaItem()
      {
        return this.tenantEvaItem;
      }
      
      public String toString()
      {
        return "EvaListBean{houseFid='" + this.houseFid + '\'' + ", houseName='" + this.houseName + '\'' + ", rentWay=" + this.rentWay + ", landlordEvaItem=" + this.landlordEvaItem + ", tenantEvaItem=" + this.tenantEvaItem + '}';
      }
      
      public static class LandlordEvaItemBean
      {
        public String content;
        public String createTime;
        public String nickName;
        public String userHeadPic;
        
        public String getContent()
        {
          return this.content;
        }
        
        public String getCreateTime()
        {
          return this.createTime;
        }
        
        public String getNickName()
        {
          return this.nickName;
        }
        
        public String getUserHeadPic()
        {
          return this.userHeadPic;
        }
        
        public String toString()
        {
          return "LandlordEvaItemBean{userHeadPic='" + this.userHeadPic + '\'' + ", nickName='" + this.nickName + '\'' + ", createTime='" + this.createTime + '\'' + ", content='" + this.content + '\'' + '}';
        }
      }
      
      public static class TenantEvaItemBean
      {
        public String content;
        public String createTime;
        public String nickName;
        public String userHeadPic;
        
        public String getContent()
        {
          return this.content;
        }
        
        public String getCreateTime()
        {
          return this.createTime;
        }
        
        public String getNickName()
        {
          return this.nickName;
        }
        
        public String getUserHeadPic()
        {
          return this.userHeadPic;
        }
        
        public String toString()
        {
          return "TenantEvaItemBean{userHeadPic='" + this.userHeadPic + '\'' + ", nickName='" + this.nickName + '\'' + ", createTime='" + this.createTime + '\'' + ", content='" + this.content + '\'' + '}';
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuLandlordEvaBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */