package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;
import java.util.List;

public class AssetContractDetail
  implements Serializable
{
  private int config_decorate_count;
  private List<AssetTenant> customer_list;
  private int depth_clean_count;
  private String hire_commissioner_code;
  private String hire_commissioner_phone;
  private int maintenance_count;
  private int month_clean_count;
  private String ziru_commissioner_name;
  
  public int getConfig_decorate_count()
  {
    return this.config_decorate_count;
  }
  
  public List<AssetTenant> getCustomer_list()
  {
    return this.customer_list;
  }
  
  public int getDepth_clean_count()
  {
    return this.depth_clean_count;
  }
  
  public String getHire_commissioner_code()
  {
    return this.hire_commissioner_code;
  }
  
  public String getHire_commissioner_phone()
  {
    return this.hire_commissioner_phone;
  }
  
  public int getMaintenance_count()
  {
    return this.maintenance_count;
  }
  
  public int getMonth_clean_count()
  {
    return this.month_clean_count;
  }
  
  public String getZiru_commissioner_name()
  {
    return this.ziru_commissioner_name;
  }
  
  public void setConfig_decorate_count(int paramInt)
  {
    this.config_decorate_count = paramInt;
  }
  
  public void setCustomer_list(List<AssetTenant> paramList)
  {
    this.customer_list = paramList;
  }
  
  public void setDepth_clean_count(int paramInt)
  {
    this.depth_clean_count = paramInt;
  }
  
  public void setHire_commissioner_code(String paramString)
  {
    this.hire_commissioner_code = paramString;
  }
  
  public void setHire_commissioner_phone(String paramString)
  {
    this.hire_commissioner_phone = paramString;
  }
  
  public void setMaintenance_count(int paramInt)
  {
    this.maintenance_count = paramInt;
  }
  
  public void setMonth_clean_count(int paramInt)
  {
    this.month_clean_count = paramInt;
  }
  
  public void setZiru_commissioner_name(String paramString)
  {
    this.ziru_commissioner_name = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/AssetContractDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */