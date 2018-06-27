package com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice;

import java.io.Serializable;
import java.util.List;

public class WeekendListBean
  implements Serializable
{
  private String auditMsg;
  private boolean isEdit;
  private List<WeekendLisDataBean> list;
  
  public String getAuditMsg()
  {
    return this.auditMsg;
  }
  
  public List<WeekendLisDataBean> getList()
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
  
  public void setList(List<WeekendLisDataBean> paramList)
  {
    this.list = paramList;
  }
  
  public static class WeekendLisDataBean
    implements Serializable
  {
    private String explain;
    private boolean isSelect;
    private String text;
    private String value;
    
    public String getExplain()
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
    
    public void setExplain(String paramString)
    {
      this.explain = paramString;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/houseprice/WeekendListBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */