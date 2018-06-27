package com.ziroom.ziroomcustomer.home.bean;

import java.util.List;

public class ServiceYoupinBean
{
  private DpDianfanBean dp_dianfan;
  private LifeAfflatusBean life_afflatus;
  private List<SpecialGoodsBean> special_goods;
  private ZhenxuanBean zhenxuan;
  
  public DpDianfanBean getDp_dianfan()
  {
    return this.dp_dianfan;
  }
  
  public LifeAfflatusBean getLife_afflatus()
  {
    return this.life_afflatus;
  }
  
  public List<SpecialGoodsBean> getSpecial_goods()
  {
    return this.special_goods;
  }
  
  public ZhenxuanBean getZhenxuan()
  {
    return this.zhenxuan;
  }
  
  public void setDp_dianfan(DpDianfanBean paramDpDianfanBean)
  {
    this.dp_dianfan = paramDpDianfanBean;
  }
  
  public void setLife_afflatus(LifeAfflatusBean paramLifeAfflatusBean)
  {
    this.life_afflatus = paramLifeAfflatusBean;
  }
  
  public void setSpecial_goods(List<SpecialGoodsBean> paramList)
  {
    this.special_goods = paramList;
  }
  
  public void setZhenxuan(ZhenxuanBean paramZhenxuanBean)
  {
    this.zhenxuan = paramZhenxuanBean;
  }
  
  public String toString()
  {
    return "ServiceYoupinBean{zhenxuan=" + this.zhenxuan + ", dp_dianfan=" + this.dp_dianfan + ", life_afflatus=" + this.life_afflatus + ", special_goods=" + this.special_goods + '}';
  }
  
  public static class DpDianfanBean
  {
    private String goods_id;
    private String id;
    private String pro_id;
    private String product_line;
    private String special_img1;
    private String special_link;
    private String style;
    
    public String getGoods_id()
    {
      return this.goods_id;
    }
    
    public String getId()
    {
      return this.id;
    }
    
    public String getPro_id()
    {
      return this.pro_id;
    }
    
    public String getProduct_line()
    {
      return this.product_line;
    }
    
    public String getSpecial_img1()
    {
      return this.special_img1;
    }
    
    public String getSpecial_link()
    {
      return this.special_link;
    }
    
    public String getStyle()
    {
      return this.style;
    }
    
    public void setGoods_id(String paramString)
    {
      this.goods_id = paramString;
    }
    
    public void setId(String paramString)
    {
      this.id = paramString;
    }
    
    public void setPro_id(String paramString)
    {
      this.pro_id = paramString;
    }
    
    public void setProduct_line(String paramString)
    {
      this.product_line = paramString;
    }
    
    public void setSpecial_img1(String paramString)
    {
      this.special_img1 = paramString;
    }
    
    public void setSpecial_link(String paramString)
    {
      this.special_link = paramString;
    }
    
    public void setStyle(String paramString)
    {
      this.style = paramString;
    }
  }
  
  public static class LifeAfflatusBean
  {
    private String article_img;
    private String article_lable;
    private String article_link;
    private String id;
    private String main_title;
    private String summary;
    
    public String getArticle_img()
    {
      return this.article_img;
    }
    
    public String getArticle_lable()
    {
      return this.article_lable;
    }
    
    public String getArticle_link()
    {
      return this.article_link;
    }
    
    public String getId()
    {
      return this.id;
    }
    
    public String getMain_title()
    {
      return this.main_title;
    }
    
    public String getSummary()
    {
      return this.summary;
    }
    
    public void setArticle_img(String paramString)
    {
      this.article_img = paramString;
    }
    
    public void setArticle_lable(String paramString)
    {
      this.article_lable = paramString;
    }
    
    public void setArticle_link(String paramString)
    {
      this.article_link = paramString;
    }
    
    public void setId(String paramString)
    {
      this.id = paramString;
    }
    
    public void setMain_title(String paramString)
    {
      this.main_title = paramString;
    }
    
    public void setSummary(String paramString)
    {
      this.summary = paramString;
    }
  }
  
  public static class SpecialGoodsBean
  {
    private String goods_img;
    private String goods_price;
    private String id;
    private String name;
    
    public String getGoods_img()
    {
      return this.goods_img;
    }
    
    public String getGoods_price()
    {
      return this.goods_price;
    }
    
    public String getId()
    {
      return this.id;
    }
    
    public String getName()
    {
      return this.name;
    }
    
    public void setGoods_img(String paramString)
    {
      this.goods_img = paramString;
    }
    
    public void setGoods_price(String paramString)
    {
      this.goods_price = paramString;
    }
    
    public void setId(String paramString)
    {
      this.id = paramString;
    }
    
    public void setName(String paramString)
    {
      this.name = paramString;
    }
  }
  
  public static class ZhenxuanBean
  {
    private String article_img;
    private String article_lable;
    private String article_link;
    private String id;
    private String main_title;
    
    public String getArticle_img()
    {
      return this.article_img;
    }
    
    public String getArticle_lable()
    {
      return this.article_lable;
    }
    
    public String getArticle_link()
    {
      return this.article_link;
    }
    
    public String getId()
    {
      return this.id;
    }
    
    public String getMain_title()
    {
      return this.main_title;
    }
    
    public void setArticle_img(String paramString)
    {
      this.article_img = paramString;
    }
    
    public void setArticle_lable(String paramString)
    {
      this.article_lable = paramString;
    }
    
    public void setArticle_link(String paramString)
    {
      this.article_link = paramString;
    }
    
    public void setId(String paramString)
    {
      this.id = paramString;
    }
    
    public void setMain_title(String paramString)
    {
      this.main_title = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/bean/ServiceYoupinBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */