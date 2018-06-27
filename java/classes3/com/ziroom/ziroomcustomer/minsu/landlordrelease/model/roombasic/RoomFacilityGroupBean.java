package com.ziroom.ziroomcustomer.minsu.landlordrelease.model.roombasic;

import java.io.Serializable;
import java.util.List;

public class RoomFacilityGroupBean
  implements Serializable
{
  private FacilitiesBean facilitiesList;
  private String name;
  
  public FacilitiesBean getFacilitiesList()
  {
    return this.facilitiesList;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setFacilitiesList(FacilitiesBean paramFacilitiesBean)
  {
    this.facilitiesList = paramFacilitiesBean;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public class FacilitiesBean
    implements Serializable
  {
    private boolean isEdit;
    private List<FacilitiesChildDataBean> list;
    
    public FacilitiesBean() {}
    
    public List<FacilitiesChildDataBean> getList()
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
    
    public void setList(List<FacilitiesChildDataBean> paramList)
    {
      this.list = paramList;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/roombasic/RoomFacilityGroupBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */