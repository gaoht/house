package com.ziroom.ziroomcustomer.my.model;

import java.util.List;

public class OIDetailPricesModel
{
  public List<GoodsListBean> goodsList;
  public String totalNum;
  
  public static class GoodDetailBean
  {
    public String title;
    public String value;
  }
  
  public static class GoodsListBean
  {
    public List<OIDetailPricesModel.GoodDetailBean> goodDetail;
    public String goodName;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/model/OIDetailPricesModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */