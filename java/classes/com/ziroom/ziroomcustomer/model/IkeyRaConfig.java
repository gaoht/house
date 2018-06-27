package com.ziroom.ziroomcustomer.model;

public class IkeyRaConfig
{
  private String License;
  private String accounthash;
  private String certRegBufType;
  private String strChangllege;
  private String strPasscode;
  private String website;
  
  public String getAccounthash()
  {
    return this.accounthash;
  }
  
  public String getCertRegBufType()
  {
    return this.certRegBufType;
  }
  
  public String getLicense()
  {
    return this.License;
  }
  
  public String getStrChangllege()
  {
    return this.strChangllege;
  }
  
  public String getStrPasscode()
  {
    return this.strPasscode;
  }
  
  public String getWebsite()
  {
    return this.website;
  }
  
  public void setAccounthash(String paramString)
  {
    this.accounthash = paramString;
  }
  
  public void setCertRegBufType(String paramString)
  {
    this.certRegBufType = paramString;
  }
  
  public void setLicense(String paramString)
  {
    this.License = paramString;
  }
  
  public void setStrChangllege(String paramString)
  {
    this.strChangllege = paramString;
  }
  
  public void setStrPasscode(String paramString)
  {
    this.strPasscode = paramString;
  }
  
  public void setWebsite(String paramString)
  {
    this.website = paramString;
  }
  
  public String toString()
  {
    return "IkeyRaConfig [License=" + this.License + ", website=" + this.website + ", accounthash=" + this.accounthash + ", strPasscode=" + this.strPasscode + ", strChangllege=" + this.strChangllege + ", certRegBufType=" + this.certRegBufType + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/model/IkeyRaConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */