package com.ziroom.ziroomcustomer.findhouse.presenter.model;

import java.util.ArrayList;

public class Features
{
  private ArrayList<FeatureDetail> detail;
  private String title;
  
  public ArrayList<FeatureDetail> getDetail()
  {
    return this.detail;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public void setDetail(ArrayList<FeatureDetail> paramArrayList)
  {
    this.detail = paramArrayList;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public String toString()
  {
    return "Features [title=" + this.title + ", detail=" + this.detail + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/presenter/model/Features.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */