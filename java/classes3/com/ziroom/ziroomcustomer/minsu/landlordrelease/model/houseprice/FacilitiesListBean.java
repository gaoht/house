package com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice;

import java.io.Serializable;
import java.util.List;

public class FacilitiesListBean
  implements Serializable
{
  private boolean isEdit;
  private List<FacilitiesListDataBean> list;
  
  public List<FacilitiesListDataBean> getList()
  {
    return this.list;
  }
  
  public boolean isEdit()
  {
    return this.isEdit;
  }
  
  public void setEdit(boolean paramBoolean)
  {
    this.isEdit = paramBoolean;
  }
  
  public void setList(List<FacilitiesListDataBean> paramList)
  {
    this.list = paramList;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/houseprice/FacilitiesListBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */