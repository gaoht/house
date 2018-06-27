package com.ziroom.ziroomcustomer.minsu.webchecklist.d;

import com.ziroom.ziroomcustomer.flux.c;

public class a
  extends c
{
  private com.ziroom.ziroomcustomer.minsu.webchecklist.c.a b;
  private String c;
  
  public a() {}
  
  public a(Object paramObject)
  {
    super(paramObject);
  }
  
  public com.ziroom.ziroomcustomer.minsu.webchecklist.c.a getCheckListBean()
  {
    return this.b;
  }
  
  public String getErrorMsg()
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
      if (!str.equals("checklist_getdata")) {
        break;
      }
      i = 0;
      break;
      if (!str.equals("checklist_getdata_error")) {
        break;
      }
      i = 1;
      break;
      setCheckListBean((com.ziroom.ziroomcustomer.minsu.webchecklist.c.a)parama.getData());
      continue;
      setErrorMsg((String)parama.getData());
    }
  }
  
  public void setCheckListBean(com.ziroom.ziroomcustomer.minsu.webchecklist.c.a parama)
  {
    this.b = parama;
  }
  
  public void setErrorMsg(String paramString)
  {
    this.c = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/webchecklist/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */