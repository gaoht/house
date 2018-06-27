package com.ziroom.ziroomcustomer.newmovehouse.model;

import java.io.Serializable;

public class MHSuccessHint
  implements Serializable
{
  private String fdetailDocument;
  private String fpicpath;
  private String fversion;
  
  public String getFdetailDocument()
  {
    return this.fdetailDocument;
  }
  
  public String getFpicpath()
  {
    return this.fpicpath;
  }
  
  public String getFversion()
  {
    return this.fversion;
  }
  
  public void setFdetailDocument(String paramString)
  {
    this.fdetailDocument = paramString;
  }
  
  public void setFpicpath(String paramString)
  {
    this.fpicpath = paramString;
  }
  
  public void setFversion(String paramString)
  {
    this.fversion = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/model/MHSuccessHint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */