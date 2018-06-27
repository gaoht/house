package com.ziroom.ziroomcustomer.minsu.landlordrelease.model.aloneroominfo;

import java.io.Serializable;
import java.util.List;

public class AloneRoomIsToiletListBean
  implements Serializable
{
  private String auditMsg;
  private boolean isEdit;
  private List<AloneRoomIsToiletListDataBean> list;
  
  public String getAuditMsg()
  {
    return this.auditMsg;
  }
  
  public List<AloneRoomIsToiletListDataBean> getList()
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
  
  public void setList(List<AloneRoomIsToiletListDataBean> paramList)
  {
    this.list = paramList;
  }
  
  public class AloneRoomIsToiletListDataBean
    implements Serializable
  {
    private Object explain;
    private boolean isSelect;
    private String text;
    private String value;
    
    public AloneRoomIsToiletListDataBean() {}
    
    public Object getExplain()
    {
      return this.explain;
    }
    
    public String getText()
    {
      return this.text;
    }
    
    public String getValue()
    {
      return this.value;
    }
    
    public boolean isSelect()
    {
      return this.isSelect;
    }
    
    public void setExplain(Object paramObject)
    {
      this.explain = paramObject;
    }
    
    public void setSelect(boolean paramBoolean)
    {
      this.isSelect = paramBoolean;
    }
    
    public void setText(String paramString)
    {
      this.text = paramString;
    }
    
    public void setValue(String paramString)
    {
      this.value = paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/aloneroominfo/AloneRoomIsToiletListBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */