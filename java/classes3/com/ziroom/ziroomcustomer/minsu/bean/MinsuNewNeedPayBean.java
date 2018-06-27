package com.ziroom.ziroomcustomer.minsu.bean;

import java.io.Serializable;
import java.util.List;

public class MinsuNewNeedPayBean
  extends MinsuBaseJson
{
  public DataBean data;
  
  public String toString()
  {
    return "MinsuNewNeedPayBean{data=" + this.data + '}';
  }
  
  public static class DataBean
  {
    public DetailFeeBean detailFee;
    public List<FeeItemListBean> feeItemList;
    public String feeUnit;
    public Integer totalFee;
    
    public String toString()
    {
      return "DataBean{totalFee=" + this.totalFee + ", feeUnit='" + this.feeUnit + '\'' + ", feeItemList=" + this.feeItemList + '}';
    }
    
    public static class DetailFeeBean
      implements Serializable
    {
      public List<FeeItemListBean> feeItemList;
      public String feeUnit;
      public int totalFee;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuNewNeedPayBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */