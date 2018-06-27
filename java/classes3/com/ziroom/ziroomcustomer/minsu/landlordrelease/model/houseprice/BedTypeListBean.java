package com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice;

import java.io.Serializable;
import java.util.List;

public class BedTypeListBean
  implements Serializable
{
  private boolean isEdit;
  private List<BedAllTypeListDataBean> list;
  
  public List<BedAllTypeListDataBean> getList()
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
  
  public void setList(List<BedAllTypeListDataBean> paramList)
  {
    this.list = paramList;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/houseprice/BedTypeListBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */