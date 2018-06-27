package com.ziroom.ziroomcustomer.minsu.tenant.b;

import com.ziroom.ziroomcustomer.flux.c;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseBean;

public class a
  extends c
{
  private MinsuHouseBean b;
  private String c;
  
  public a() {}
  
  public a(Object paramObject)
  {
    super(paramObject);
  }
  
  public MinsuHouseBean getLandlordHouseBean()
  {
    return this.b;
  }
  
  public String getLandlordHouseErrMsg()
  {
    return this.c;
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
      if (!str.equals("landlord_house")) {
        break;
      }
      i = 0;
      break;
      if (!str.equals("landlord_house_error")) {
        break;
      }
      i = 1;
      break;
      this.b = ((MinsuHouseBean)parama.getData());
      continue;
      this.c = ((String)parama.getData());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/tenant/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */