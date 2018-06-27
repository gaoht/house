package com.ziroom.ziroomcustomer.ziroomapartment.model.sign;

import java.io.Serializable;

public class ZryuOldContractInfo
  implements Serializable
{
  private String preContractCode;
  private String preContractID;
  private String text;
  
  public String getPreContractCode()
  {
    return this.preContractCode;
  }
  
  public String getPreContractID()
  {
    return this.preContractID;
  }
  
  public String getText()
  {
    return this.text;
  }
  
  public void setPreContractCode(String paramString)
  {
    this.preContractCode = paramString;
  }
  
  public void setPreContractID(String paramString)
  {
    this.preContractID = paramString;
  }
  
  public void setText(String paramString)
  {
    this.text = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/model/sign/ZryuOldContractInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */