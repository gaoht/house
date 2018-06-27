package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;

public class SignedInfo
  implements Serializable
{
  private int cert_id;
  private int cert_is_lock;
  private String cert_num;
  private int cert_type;
  private CreditsEntity credits;
  private int gender;
  private String phone;
  private String real_name;
  private String user_cert1;
  private String user_cert2;
  private String user_cert3;
  private int user_is_lock;
  
  public SignedInfo() {}
  
  public SignedInfo(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt3, int paramInt4, CreditsEntity paramCreditsEntity)
  {
    this.real_name = paramString1;
    this.gender = paramInt1;
    this.phone = paramString2;
    this.cert_type = paramInt2;
    this.cert_num = paramString3;
    this.user_cert1 = paramString4;
    this.user_cert2 = paramString5;
    this.user_cert3 = paramString6;
    this.user_is_lock = paramInt3;
    this.cert_is_lock = paramInt4;
    this.credits = paramCreditsEntity;
  }
  
  public int getCert_id()
  {
    return this.cert_id;
  }
  
  public int getCert_is_lock()
  {
    return this.cert_is_lock;
  }
  
  public String getCert_num()
  {
    return this.cert_num;
  }
  
  public int getCert_type()
  {
    return this.cert_type;
  }
  
  public CreditsEntity getCredits()
  {
    return this.credits;
  }
  
  public int getGender()
  {
    return this.gender;
  }
  
  public String getPhone()
  {
    return this.phone;
  }
  
  public String getReal_name()
  {
    return this.real_name;
  }
  
  public String getUser_cert1()
  {
    return this.user_cert1;
  }
  
  public String getUser_cert2()
  {
    return this.user_cert2;
  }
  
  public String getUser_cert3()
  {
    return this.user_cert3;
  }
  
  public int getUser_is_lock()
  {
    return this.user_is_lock;
  }
  
  public void setCert_id(int paramInt)
  {
    this.cert_id = paramInt;
  }
  
  public void setCert_is_lock(int paramInt)
  {
    this.cert_is_lock = paramInt;
  }
  
  public void setCert_num(String paramString)
  {
    this.cert_num = paramString;
  }
  
  public void setCert_type(int paramInt)
  {
    this.cert_type = paramInt;
  }
  
  public void setCredits(CreditsEntity paramCreditsEntity)
  {
    this.credits = paramCreditsEntity;
  }
  
  public void setGender(int paramInt)
  {
    this.gender = paramInt;
  }
  
  public void setPhone(String paramString)
  {
    this.phone = paramString;
  }
  
  public void setReal_name(String paramString)
  {
    this.real_name = paramString;
  }
  
  public void setUser_cert1(String paramString)
  {
    this.user_cert1 = paramString;
  }
  
  public void setUser_cert2(String paramString)
  {
    this.user_cert2 = paramString;
  }
  
  public void setUser_cert3(String paramString)
  {
    this.user_cert3 = paramString;
  }
  
  public void setUser_is_lock(int paramInt)
  {
    this.user_is_lock = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/SignedInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */