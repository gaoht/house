package com.ziroom.ziroomcustomer.newmovehouse.d;

import com.ziroom.ziroomcustomer.newmovehouse.model.MovingVanCancle;
import com.ziroom.ziroomcustomer.newmovehouse.model.ServiceDicItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c
  extends com.ziroom.ziroomcustomer.flux.c
{
  private String b;
  private List<MovingVanCancle> c;
  private int d = -1;
  private boolean e;
  private String f;
  
  public c() {}
  
  public c(Object paramObject)
  {
    super(paramObject);
  }
  
  public String getCancalTag()
  {
    return this.f;
  }
  
  public List<MovingVanCancle> getCancleList()
  {
    return this.c;
  }
  
  public int getSelectPosition()
  {
    return this.d;
  }
  
  public boolean isOtherReason()
  {
    return this.e;
  }
  
  public void onAction(com.ziroom.ziroomcustomer.flux.a parama)
  {
    Object localObject = parama.getType();
    int i = -1;
    switch (((String)localObject).hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      this.b = parama.getType();
      a(new com.ziroom.ziroomcustomer.flux.a.a(this.b));
      return;
      if (!((String)localObject).equals("service_mv_van_cancle_reason")) {
        break;
      }
      i = 0;
      break;
      if (!((String)localObject).equals("service_mv_van_canale_updae")) {
        break;
      }
      i = 1;
      break;
      if (!((String)localObject).equals("submit_mv_van_canale_reason")) {
        break;
      }
      i = 2;
      break;
      localObject = (List)parama.getData();
      this.c = new ArrayList();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ServiceDicItem localServiceDicItem = (ServiceDicItem)((Iterator)localObject).next();
          MovingVanCancle localMovingVanCancle = new MovingVanCancle();
          localMovingVanCancle.setReason(localServiceDicItem.getDictionaryValue());
          localMovingVanCancle.setIsSelect(false);
          this.c.add(localMovingVanCancle);
        }
        this.d = ((Integer)parama.getData()).intValue();
        if ((this.c != null) && (this.d < this.c.size()))
        {
          localObject = this.c.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((MovingVanCancle)((Iterator)localObject).next()).setIsSelect(false);
          }
          this.f = ((MovingVanCancle)this.c.get(this.d)).getReason();
          ((MovingVanCancle)this.c.get(this.d)).setIsSelect(true);
          this.e = "其他原因".equals(((MovingVanCancle)this.c.get(this.d)).getReason());
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */