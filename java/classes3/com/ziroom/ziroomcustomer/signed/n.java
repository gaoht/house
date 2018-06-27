package com.ziroom.ziroomcustomer.signed;

import com.ziroom.ziroomcustomer.model.CreditsEntity;
import java.io.Serializable;

public class n
  implements Serializable
{
  private String a;
  private String b;
  private int c;
  private String d;
  private int e;
  private CreditsEntity f;
  
  public CreditsEntity getCredits()
  {
    return this.f;
  }
  
  public int getEducation()
  {
    return this.e;
  }
  
  public int getEducation_type()
  {
    return this.c;
  }
  
  public String getEnrollment_year()
  {
    return this.b;
  }
  
  public String getGraduation_year()
  {
    return this.a;
  }
  
  public String getSchool()
  {
    return this.d;
  }
  
  public void setCredits(CreditsEntity paramCreditsEntity)
  {
    this.f = paramCreditsEntity;
  }
  
  public void setEducation(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setEducation_type(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setEnrollment_year(String paramString)
  {
    this.b = paramString;
  }
  
  public void setGraduation_year(String paramString)
  {
    this.a = paramString;
  }
  
  public void setSchool(String paramString)
  {
    this.d = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */