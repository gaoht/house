package com.ziroom.ziroomcustomer.minsu.bean;

public class MinsuFindBookerContactsBean
  extends MinsuBaseJson
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
  
  public String toString()
  {
    return "MinsuFindBookerContactsBean{data=" + this.data + '}';
  }
  
  public static class DataBean
  {
    public BookerDetailBean bookerDetail;
    public Integer isNeedReplenish;
    public String tips;
    
    public BookerDetailBean getBookerDetail()
    {
      return this.bookerDetail;
    }
    
    public Integer getIsNeedReplenish()
    {
      return this.isNeedReplenish;
    }
    
    public String getTips()
    {
      return this.tips;
    }
    
    public void setBookerDetail(BookerDetailBean paramBookerDetailBean)
    {
      this.bookerDetail = paramBookerDetailBean;
    }
    
    public void setIsNeedReplenish(Integer paramInteger)
    {
      this.isNeedReplenish = paramInteger;
    }
    
    public void setTips(String paramString)
    {
      this.tips = paramString;
    }
    
    public String toString()
    {
      return "DataBean{isNeedReplenish=" + this.isNeedReplenish + ", bookerDetail=" + this.bookerDetail + '}';
    }
    
    public static class BookerDetailBean
    {
      public Integer cardType;
      public String cardValue;
      public String conName;
      public String conTel;
      public String fid;
      public String userUid;
      
      public Integer getCardType()
      {
        return this.cardType;
      }
      
      public String getCardValue()
      {
        return this.cardValue;
      }
      
      public String getConName()
      {
        return this.conName;
      }
      
      public String getConTel()
      {
        return this.conTel;
      }
      
      public String getFid()
      {
        return this.fid;
      }
      
      public String getUserUid()
      {
        return this.userUid;
      }
      
      public void setCardType(Integer paramInteger)
      {
        this.cardType = paramInteger;
      }
      
      public void setCardValue(String paramString)
      {
        this.cardValue = paramString;
      }
      
      public void setConName(String paramString)
      {
        this.conName = paramString;
      }
      
      public void setConTel(String paramString)
      {
        this.conTel = paramString;
      }
      
      public void setFid(String paramString)
      {
        this.fid = paramString;
      }
      
      public void setUserUid(String paramString)
      {
        this.userUid = paramString;
      }
      
      public String toString()
      {
        return "BookerDetailBean{fid='" + this.fid + '\'' + ", userUid='" + this.userUid + '\'' + ", conName='" + this.conName + '\'' + ", cardType=" + this.cardType + ", cardValue='" + this.cardValue + '\'' + ", conTel='" + this.conTel + '\'' + '}';
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuFindBookerContactsBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */