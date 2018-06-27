package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;
import java.util.List;

public class AssetContract
  implements Serializable
{
  private String account_bank;
  private String agent_date;
  private List<AssetBill> billing_information_list;
  private int bishu;
  private AssetContractDetail contract_detail;
  private String hire_contract_code;
  private int paybishu;
  private String payment_name;
  private String property_address;
  
  public String getAccount_bank()
  {
    return this.account_bank;
  }
  
  public String getAgent_date()
  {
    return this.agent_date;
  }
  
  public List<AssetBill> getBilling_information_list()
  {
    return this.billing_information_list;
  }
  
  public int getBishu()
  {
    return this.bishu;
  }
  
  public AssetContractDetail getContract_detail()
  {
    return this.contract_detail;
  }
  
  public String getHire_contract_code()
  {
    return this.hire_contract_code;
  }
  
  public int getPaybishu()
  {
    return this.paybishu;
  }
  
  public String getPayment_name()
  {
    return this.payment_name;
  }
  
  public String getProperty_address()
  {
    return this.property_address;
  }
  
  public void setAccount_bank(String paramString)
  {
    this.account_bank = paramString;
  }
  
  public void setAgent_date(String paramString)
  {
    this.agent_date = paramString;
  }
  
  public void setBilling_information_list(List<AssetBill> paramList)
  {
    this.billing_information_list = paramList;
  }
  
  public void setBishu(int paramInt)
  {
    this.bishu = paramInt;
  }
  
  public void setContract_detail(AssetContractDetail paramAssetContractDetail)
  {
    this.contract_detail = paramAssetContractDetail;
  }
  
  public void setHire_contract_code(String paramString)
  {
    this.hire_contract_code = paramString;
  }
  
  public void setPaybishu(int paramInt)
  {
    this.paybishu = paramInt;
  }
  
  public void setPayment_name(String paramString)
  {
    this.payment_name = paramString;
  }
  
  public void setProperty_address(String paramString)
  {
    this.property_address = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/AssetContract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */