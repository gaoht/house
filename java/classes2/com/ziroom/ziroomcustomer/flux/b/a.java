package com.ziroom.ziroomcustomer.flux.b;

import com.ziroom.ziroomcustomer.flux.c;

public class a
  extends c
{
  private String b;
  
  public a(Object paramObject)
  {
    super(paramObject);
  }
  
  public String getToastMsg()
  {
    return this.b;
  }
  
  public void onAction(com.ziroom.ziroomcustomer.flux.a parama)
  {
    String str = parama.getType();
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      case 0: 
      case 1: 
      case 2: 
      default: 
        return;
        if (str.equals("type_show_loading"))
        {
          i = 0;
          continue;
          if (str.equals("type_dismiss_loading"))
          {
            i = 1;
            continue;
            if (str.equals("type_login"))
            {
              i = 2;
              continue;
              if (str.equals("type_toast")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    this.b = ((String)parama.getData());
    emitStoreChange(new com.ziroom.ziroomcustomer.flux.a.a(parama.getType(), this.a));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/flux/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */