package com.ziroom.ziroomcustomer.util.a;

public class a
{
  String a;
  private String b;
  private String c;
  private String d;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof a))
    {
      paramObject = (a)paramObject;
      if ((((a)paramObject).getUid() == null) || (getUid() == null) || (!((a)paramObject).getUid().equals(getUid())))
      {
        bool1 = bool2;
        if (((a)paramObject).getUid() == null)
        {
          bool1 = bool2;
          if (getUid() != null) {}
        }
      }
      else if ((((a)paramObject).getUsername() == null) || (getUsername() == null) || (!((a)paramObject).getUsername().equals(getUsername())))
      {
        bool1 = bool2;
        if (((a)paramObject).getUsername() == null)
        {
          bool1 = bool2;
          if (getUsername() != null) {}
        }
      }
      else if ((((a)paramObject).getCertType() != null) || (getCertType() != null))
      {
        bool1 = bool2;
        if (((a)paramObject).getCertType() != null)
        {
          bool1 = bool2;
          if (getCertType() != null)
          {
            bool1 = bool2;
            if (!((a)paramObject).getCertType().equals(getCertType())) {}
          }
        }
      }
      else if ((((a)paramObject).getCertNum() != null) || (getCertNum() != null))
      {
        bool1 = bool2;
        if (((a)paramObject).getCertNum() != null)
        {
          bool1 = bool2;
          if (getCertNum() != null)
          {
            bool1 = bool2;
            if (!((a)paramObject).getCertNum().equals(getCertNum())) {}
          }
        }
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String getCertNum()
  {
    return this.d;
  }
  
  public String getCertType()
  {
    return this.c;
  }
  
  public String getUid()
  {
    return this.a;
  }
  
  public String getUsername()
  {
    return this.b;
  }
  
  public void setCertNum(String paramString)
  {
    this.d = paramString;
  }
  
  public void setCertType(String paramString)
  {
    this.c = paramString;
  }
  
  public void setUid(String paramString)
  {
    this.a = paramString;
  }
  
  public void setUsername(String paramString)
  {
    this.b = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/util/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */