package com.ziroom.ziroomcustomer.pay.huifu.bean;

import java.util.List;

public class HuifuBankData
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
    private String bankCode;
    private String bankIconApp;
    private String bankIconPc;
    private String bankName;
    private long createTime;
    private String id;
    private int isDel;
    private long lastModifyTime;
    private int weight;
    
    public DataBean() {}
    
    public String getBankCode()
    {
      return this.bankCode;
    }
    
    public String getBankIconApp()
    {
      return this.bankIconApp;
    }
    
    public String getBankIconPc()
    {
      return this.bankIconPc;
    }
    
    public String getBankName()
    {
      return this.bankName;
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
    
    public int getWeight()
    {
      return this.weight;
    }
    
    public void setBankCode(String paramString)
    {
      this.bankCode = paramString;
    }
    
    public void setBankIconApp(String paramString)
    {
      this.bankIconApp = paramString;
    }
    
    public void setBankIconPc(String paramString)
    {
      this.bankIconPc = paramString;
    }
    
    public void setBankName(String paramString)
    {
      this.bankName = paramString;
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
    
    public void setWeight(int paramInt)
    {
      this.weight = paramInt;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/pay/huifu/bean/HuifuBankData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */