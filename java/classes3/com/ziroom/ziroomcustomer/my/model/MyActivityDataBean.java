package com.ziroom.ziroomcustomer.my.model;

import java.util.List;

public class MyActivityDataBean
{
  private RecommendActivitiesModel activity;
  private List<AdModel> ad;
  private HaiyanActivityModel user_tags;
  private RecommendActivitiesModel z_space;
  private RecommendActivitiesModel zhaozhao;
  
  public RecommendActivitiesModel getActivity()
  {
    return this.activity;
  }
  
  public List<AdModel> getAd()
  {
    return this.ad;
  }
  
  public HaiyanActivityModel getUser_tags()
  {
    return this.user_tags;
  }
  
  public RecommendActivitiesModel getZ_space()
  {
    return this.z_space;
  }
  
  public RecommendActivitiesModel getZhaozhao()
  {
    return this.zhaozhao;
  }
  
  public void setActivity(RecommendActivitiesModel paramRecommendActivitiesModel)
  {
    this.activity = paramRecommendActivitiesModel;
  }
  
  public void setAd(List<AdModel> paramList)
  {
    this.ad = paramList;
  }
  
  public void setUser_tags(HaiyanActivityModel paramHaiyanActivityModel)
  {
    this.user_tags = paramHaiyanActivityModel;
  }
  
  public void setZ_space(RecommendActivitiesModel paramRecommendActivitiesModel)
  {
    this.z_space = paramRecommendActivitiesModel;
  }
  
  public void setZhaozhao(RecommendActivitiesModel paramRecommendActivitiesModel)
  {
    this.zhaozhao = paramRecommendActivitiesModel;
  }
  
  public String toString()
  {
    return "MyActivityDataBean{activity=" + this.activity + ", zhaozhao=" + this.zhaozhao + '}';
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/model/MyActivityDataBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */