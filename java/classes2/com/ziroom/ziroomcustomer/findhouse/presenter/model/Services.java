package com.ziroom.ziroomcustomer.findhouse.presenter.model;

import java.util.ArrayList;

public class Services
{
  private ArrayList<ServicesDetail> detail;
  private String title;
  
  public ArrayList<ServicesDetail> getDetail()
  {
    return this.detail;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public void setDetail(ArrayList<ServicesDetail> paramArrayList)
  {
    this.detail = paramArrayList;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public String toString()
  {
    return "Services [title=" + this.title + ", detail=" + this.detail + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/presenter/model/Services.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */