package com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice;

import java.io.Serializable;

public class BedAllTypeListDataBean
  implements Serializable
{
  private int count;
  private String explain;
  private boolean isSelect;
  private String text;
  private String value;
  
  public BedAllTypeListDataBean cloneBean()
  {
    BedAllTypeListDataBean localBedAllTypeListDataBean = new BedAllTypeListDataBean();
    localBedAllTypeListDataBean.setText(getText());
    localBedAllTypeListDataBean.setValue(getValue());
    localBedAllTypeListDataBean.setSelect(isSelect());
    localBedAllTypeListDataBean.setExplain(getExplain());
    localBedAllTypeListDataBean.setCount(getCount());
    return localBedAllTypeListDataBean;
  }
  
  public int getCount()
  {
    return this.count;
  }
  
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
  
  public void setCount(int paramInt)
  {
    this.count = paramInt;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/houseprice/BedAllTypeListDataBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */