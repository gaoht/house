package com.ziroom.ziroomcustomer.pay.huifu.bean;

import java.util.List;

public class HuifuBankProvince
  extends HuifuBaseJson
{
  private List<DataBean> data;
  
  public List<DataBean> getData()
  {
    return this.data;
  }
  
  public void setData(List<DataBean> paramList)
  {
    this.data = paramList;
  }
  
  public class DataBean
  {
    private String cardProvCode;
    private String cardProvName;
    private long createTime;
    private String id;
    private int isDel;
    private long lastModifyTime;
    
    public DataBean() {}
    
    public String getCardProvCode()
    {
      return this.cardProvCode;
    }
    
    public String getCardProvName()
    {
      return this.cardProvName;
    }
    
    public long getCreateTime()
    {
      return this.createTime;
    }
    
    public String getId()
    {
      return this.id;
    }
    
    public int getIsDel()
    {
      return this.isDel;
    }
    
    public long getLastModifyTime()
    {
      return this.lastModifyTime;
    }
    
    public void setCardProvCode(String paramString)
    {
      this.cardProvCode = paramString;
    }
    
    public void setCardProvName(String paramString)
    {
      this.cardProvName = paramString;
    }
    
    public void setCreateTime(long paramLong)
    {
      this.createTime = paramLong;
    }
    
    public void setId(String paramString)
    {
      this.id = paramString;
    }
    
    public void setIsDel(int paramInt)
    {
      this.isDel = paramInt;
    }
    
    public void setLastModifyTime(long paramLong)
    {
      this.lastModifyTime = paramLong;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/pay/huifu/bean/HuifuBankProvince.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */