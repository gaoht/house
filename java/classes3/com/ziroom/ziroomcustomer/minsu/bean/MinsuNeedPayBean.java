package com.ziroom.ziroomcustomer.minsu.bean;

public class MinsuNeedPayBean
  extends MinsuBaseJson
{
  public DataBean data;
  
  public String toString()
  {
    return "MinsuNeedPayBean{status='" + this.status + '\'' + ", message='" + this.message + '\'' + ", data=" + this.data + '}';
  }
  
  public static class DataBean
  {
    public Integer cost;
    public Integer couponMoney;
    public Integer depositMoney;
    public Integer discountMoney;
    public Integer needPay;
    public Integer userCommission;
    
    public String toString()
    {
      return "DataBean{depositMoney=" + this.depositMoney + ", discountMoney=" + this.discountMoney + ", userCommission=" + this.userCommission + ", couponMoney=" + this.couponMoney + ", needPay=" + this.needPay + ", cost=" + this.cost + '}';
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuNeedPayBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */