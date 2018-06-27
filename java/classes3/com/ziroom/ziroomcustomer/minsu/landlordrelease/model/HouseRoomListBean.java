package com.ziroom.ziroomcustomer.minsu.landlordrelease.model;

public class HouseRoomListBean
{
  private boolean isEdit;
  public String status;
  private String text;
  private String value;
  
  public String getText()
  {
    return this.text;
  }
  
  public String getValue()
  {
    return this.value;
  }
  
  public boolean isIsEdit()
  {
    return this.isEdit;
  }
  
  public void setIsEdit(boolean paramBoolean)
  {
    this.isEdit = paramBoolean;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/HouseRoomListBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */