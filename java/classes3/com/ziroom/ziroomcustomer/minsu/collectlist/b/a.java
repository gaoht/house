package com.ziroom.ziroomcustomer.minsu.collectlist.b;

import com.ziroom.ziroomcustomer.flux.c;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCollectListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseCancelCollectResultBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseCollectResultBean;

public class a
  extends c
{
  private MinsuCollectListBean b;
  private MinsuHouseCollectResultBean c;
  private MinsuHouseCancelCollectResultBean d;
  private String e;
  private String f;
  private String g;
  
  public a() {}
  
  public a(Object paramObject)
  {
    super(paramObject);
  }
  
  public String getCancelCollectResultMsg()
  {
    return this.g;
  }
  
  public MinsuCollectListBean getHouseCollectBean()
  {
    return this.b;
  }
  
  public String getHouseCollectBeanErrMsg()
  {
    return this.e;
  }
  
  public MinsuHouseCancelCollectResultBean getMinsuCancelCollectResultBean()
  {
    return this.d;
  }
  
  public String getMinsuCollectResultErrMsg()
  {
    return this.f;
  }
  
  public MinsuHouseCollectResultBean getMinsuHouseCollectResultBean()
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
      if (!str.equals("get_collect_list")) {
        break;
      }
      i = 0;
      break;
      if (!str.equals("collect_house")) {
        break;
      }
      i = 1;
      break;
      if (!str.equals("cancel_collect_house")) {
        break;
      }
      i = 2;
      break;
      if (!str.equals("get_collect_list_error")) {
        break;
      }
      i = 3;
      break;
      if (!str.equals("collect_house_error")) {
        break;
      }
      i = 4;
      break;
      if (!str.equals("cancel_collect_house_error")) {
        break;
      }
      i = 5;
      break;
      this.b = ((MinsuCollectListBean)parama.getData());
      continue;
      this.c = ((MinsuHouseCollectResultBean)parama.getData());
      continue;
      this.d = ((MinsuHouseCancelCollectResultBean)parama.getData());
      continue;
      this.e = ((String)parama.getData());
      continue;
      this.f = ((String)parama.getData());
      continue;
      this.g = ((String)parama.getData());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/collectlist/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */