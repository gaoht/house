package com.ziroom.ziroomcustomer.ziroomapartment.model;

import com.freelxl.baselibrary.b.b;
import java.util.List;

public class ZryuFirstProjectListModel
  extends b
{
  public List<DataBean> data;
  
  public List<DataBean> getData()
  {
    return this.data;
  }
  
  public void setData(List<DataBean> paramList)
  {
    this.data = paramList;
  }
  
  public static class DataBean
  {
    public String projAddr;
    public String projId;
    public String projImgUrl;
    public String projMinPrice;
    public String projName;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/ZryuFirstProjectListModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */