package com.ziroom.ziroomcustomer.newServiceList.model;

public class v
{
  private String a;
  private boolean b;
  private String c;
  
  public v(String paramString1, boolean paramBoolean, String paramString2)
  {
    this.a = paramString1;
    this.b = paramBoolean;
    this.c = paramString2;
  }
  
  public String getTypeCode()
  {
    return this.c;
  }
  
  public String getTypeName()
  {
    return this.a;
  }
  
  public boolean isSelect()
  {
    return this.b;
  }
  
  public void setSelect(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setTypeCode(String paramString)
  {
    this.c = paramString;
  }
  
  public void setTypeName(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/model/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */