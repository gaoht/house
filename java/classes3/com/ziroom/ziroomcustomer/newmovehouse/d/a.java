package com.ziroom.ziroomcustomer.newmovehouse.d;

import com.ziroom.ziroomcustomer.flux.c;
import com.ziroom.ziroomcustomer.newmovehouse.model.MovingEvalInfo;

public class a
  extends c
{
  private MovingEvalInfo b;
  
  public a(Object paramObject)
  {
    super(paramObject);
  }
  
  public MovingEvalInfo getMovingEvalInfo()
  {
    return this.b;
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
      if (!str.equals("service_mv_eval_init")) {
        break;
      }
      i = 0;
      break;
      if (!str.equals("service_mv_eval_submit")) {
        break;
      }
      i = 1;
      break;
      this.b = ((MovingEvalInfo)parama.getData());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */