package com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice;

import java.io.Serializable;
import java.util.List;

public class CheckInLimitBean
  implements Serializable
{
  private boolean isEdit;
  private List<CheckInLimitDataBean> list;
  
  public List<CheckInLimitDataBean> getList()
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
  
  public void setList(List<CheckInLimitDataBean> paramList)
  {
    this.list = paramList;
  }
  
  public class CheckInLimitDataBean
    implements Serializable
  {
    private String explain;
    private boolean isSelect;
    private String text;
    private int value;
    
    public CheckInLimitDataBean() {}
    
    public String getExplain()
    {
      return this.explain;
    }
    
    public String getText()
    {
      return this.text;
    }
    
    public int getValue()
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
    
    public void setValue(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/houseprice/CheckInLimitBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */