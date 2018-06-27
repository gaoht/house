package com.ziroom.ziroomcustomer.minsu.landlordrelease.model.aloneroominfo;

import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.AloneRoomBedTypeListDataBean;
import java.io.Serializable;
import java.util.List;

public class AloneRoomBedTypeListBean
  implements Serializable
{
  private String auditMsg;
  private boolean isEdit;
  private List<AloneRoomBedTypeListDataBean> list;
  
  public String getAuditMsg()
  {
    return this.auditMsg;
  }
  
  public List<AloneRoomBedTypeListDataBean> getList()
  {
    return this.list;
  }
  
  public boolean isEdit()
  {
    return this.isEdit;
  }
  
  public void setAuditMsg(String paramString)
  {
    this.auditMsg = paramString;
  }
  
  public void setEdit(boolean paramBoolean)
  {
    this.isEdit = paramBoolean;
  }
  
  public void setList(List<AloneRoomBedTypeListDataBean> paramList)
  {
    this.list = paramList;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/aloneroominfo/AloneRoomBedTypeListBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */