package com.ziroom.ziroomcustomer.minsu.landlordrelease.d;

import com.ziroom.ziroomcustomer.flux.c;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.CertificationBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.CustomerInfoBean;

public class b
  extends c
{
  private CertificationBean b;
  private String c;
  private CustomerInfoBean d;
  private String e;
  
  public b() {}
  
  public b(Object paramObject)
  {
    super(paramObject);
  }
  
  public CertificationBean getCertificationBean()
  {
    return this.b;
  }
  
  public String getCertificationErrorMsg()
  {
    return this.c;
  }
  
  public CustomerInfoBean getCustomerInfoBean()
  {
    return this.d;
  }
  
  public String getCustomerInfoErrorMsg()
  {
    return this.e;
  }
  
  public void onAction(com.ziroom.ziroomcustomer.flux.a parama)
  {
    String str = parama.getType();
    int i = -1;
    switch (str.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      a(new com.ziroom.ziroomcustomer.flux.a.a(parama.getType()));
      return;
      if (!str.equals("certification")) {
        break;
      }
      i = 0;
      break;
      if (!str.equals("certification_error")) {
        break;
      }
      i = 1;
      break;
      if (!str.equals("customerInfo")) {
        break;
      }
      i = 2;
      break;
      if (!str.equals("customerInfo_error")) {
        break;
      }
      i = 3;
      break;
      this.b = ((CertificationBean)parama.getData());
      continue;
      this.c = ((String)parama.getData());
      continue;
      this.d = ((CustomerInfoBean)parama.getData());
      continue;
      this.e = ((String)parama.getData());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */