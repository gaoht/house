package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;
import java.util.ArrayList;

public class AssetOwner
  implements Serializable
{
  private String ch_name;
  private ArrayList<AssetContract> hire_contract_code_list;
  private String mobile;
  private String owner_id;
  private String peper_code;
  
  public String getCh_name()
  {
    return this.ch_name;
  }
  
  public ArrayList<AssetContract> getHire_contract_code_list()
  {
    return this.hire_contract_code_list;
  }
  
  public String getMobile()
  {
    return this.mobile;
  }
  
  public String getOwner_id()
  {
    return this.owner_id;
  }
  
  public String getPeper_code()
  {
    return this.peper_code;
  }
  
  public void setCh_name(String paramString)
  {
    this.ch_name = paramString;
  }
  
  public void setHire_contract_code_list(ArrayList<AssetContract> paramArrayList)
  {
    this.hire_contract_code_list = paramArrayList;
  }
  
  public void setMobile(String paramString)
  {
    this.mobile = paramString;
  }
  
  public void setOwner_id(String paramString)
  {
    this.owner_id = paramString;
  }
  
  public void setPeper_code(String paramString)
  {
    this.peper_code = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/AssetOwner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */