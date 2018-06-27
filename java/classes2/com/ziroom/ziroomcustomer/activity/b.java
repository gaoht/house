package com.ziroom.ziroomcustomer.activity;

import java.io.Serializable;

public class b
  implements Serializable
{
  private String a;
  private String b;
  private String c;
  
  public b(String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  public String getHire_commissioner_name()
  {
    return this.b;
  }
  
  public String getHire_commissioner_phone()
  {
    return this.c;
  }
  
  public String getHire_contract_code()
  {
    return this.a;
  }
  
  public void setHire_commissioner_name(String paramString)
  {
    this.b = paramString;
  }
  
  public void setHire_commissioner_phone(String paramString)
  {
    this.c = paramString;
  }
  
  public void setHire_contract_code(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/activity/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */