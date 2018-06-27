package com.ziroom.ziroomcustomer.signed;

import com.ziroom.ziroomcustomer.model.CreditsEntity;
import java.io.Serializable;

public class g
  implements Serializable
{
  private int a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private CreditsEntity j;
  
  public g() {}
  
  public g(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, CreditsEntity paramCreditsEntity)
  {
    this.a = paramInt;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramString4;
    this.f = paramString5;
    this.g = paramString6;
    this.h = paramString7;
    this.i = paramString8;
    this.j = paramCreditsEntity;
  }
  
  public int getCert_id()
  {
    return this.a;
  }
  
  public String getCertifier_name()
  {
    return this.e;
  }
  
  public String getCertifier_phone()
  {
    return this.f;
  }
  
  public CreditsEntity getCredits()
  {
    return this.j;
  }
  
  public String getSocial_proof()
  {
    return this.b;
  }
  
  public String getUrgency_name()
  {
    return this.g;
  }
  
  public String getUrgency_phone()
  {
    return this.h;
  }
  
  public String getUrgency_relation()
  {
    return this.i;
  }
  
  public String getWork_address()
  {
    return this.d;
  }
  
  public String getWork_name()
  {
    return this.c;
  }
  
  public void setCert_id(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setCertifier_name(String paramString)
  {
    this.e = paramString;
  }
  
  public void setCertifier_phone(String paramString)
  {
    this.f = paramString;
  }
  
  public void setCredits(CreditsEntity paramCreditsEntity)
  {
    this.j = paramCreditsEntity;
  }
  
  public void setSocial_proof(String paramString)
  {
    this.b = paramString;
  }
  
  public void setUrgency_name(String paramString)
  {
    this.g = paramString;
  }
  
  public void setUrgency_phone(String paramString)
  {
    this.h = paramString;
  }
  
  public void setUrgency_relation(String paramString)
  {
    this.i = paramString;
  }
  
  public void setWork_address(String paramString)
  {
    this.d = paramString;
  }
  
  public void setWork_name(String paramString)
  {
    this.c = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */