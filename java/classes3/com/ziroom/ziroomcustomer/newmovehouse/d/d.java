package com.ziroom.ziroomcustomer.newmovehouse.d;

import com.alibaba.fastjson.e;
import com.ziroom.ziroomcustomer.flux.c;
import com.ziroom.ziroomcustomer.newmovehouse.model.MovingVanGoods;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class d
  extends c
{
  private String b;
  private String c;
  private List<MovingVanGoods> d;
  private List<MovingVanGoods> e;
  private boolean f = false;
  private long g;
  
  public d() {}
  
  public d(Object paramObject)
  {
    super(paramObject);
  }
  
  public List<MovingVanGoods> getGoodsList()
  {
    return this.d;
  }
  
  public List<MovingVanGoods> getGoodsSelectedList()
  {
    return this.e;
  }
  
  public String getPriceText()
  {
    NumberFormat localNumberFormat = NumberFormat.getNumberInstance();
    localNumberFormat.setMaximumFractionDigits(2);
    localNumberFormat.setMinimumFractionDigits(2);
    return "¥ " + localNumberFormat.format(this.g / 100.0D);
  }
  
  public String getProductCode()
  {
    return this.b;
  }
  
  public String getToken()
  {
    return this.c;
  }
  
  public boolean isHasSelectGoods()
  {
    return this.f;
  }
  
  public void onAction(com.ziroom.ziroomcustomer.flux.a parama)
  {
    Object localObject1 = parama.getType();
    int i = -1;
    switch (((String)localObject1).hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    MovingVanGoods localMovingVanGoods;
    do
    {
      do
      {
        do
        {
          a(new com.ziroom.ziroomcustomer.flux.a.a(parama.getType()));
          return;
          if (!((String)localObject1).equals("service_mv_van_goods_init")) {
            break;
          }
          i = 0;
          break;
          if (!((String)localObject1).equals("service_mv_van_goods_update")) {
            break;
          }
          i = 1;
          break;
          if (!((String)localObject1).equals("service_mv_van_goods_submit")) {
            break;
          }
          i = 2;
          break;
          localObject1 = (e)parama.getData();
        } while (localObject1 == null);
        this.b = ((e)localObject1).getString("productCode");
        this.c = ((e)localObject1).getString("token");
        this.d = ((List)((e)localObject1).get("goods"));
        localObject1 = (List)((e)localObject1).get("goodsSelected");
      } while ((this.d == null) || (this.d.size() <= 0) || (localObject1 == null) || (((List)localObject1).size() <= 0));
      this.e = new ArrayList();
      localObject2 = this.d.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localMovingVanGoods = (MovingVanGoods)((Iterator)localObject2).next();
        i = ((List)localObject1).indexOf(localMovingVanGoods);
        if (i >= 0)
        {
          this.f = true;
          localMovingVanGoods.buyNumber = ((MovingVanGoods)((List)localObject1).get(i)).buyNumber;
          this.e.add(localMovingVanGoods);
          this.g += localMovingVanGoods.materielUnitPrice * localMovingVanGoods.buyNumber;
        }
      }
      localObject2 = (e)parama.getData();
    } while (localObject2 == null);
    localObject1 = ((e)localObject2).getString("logicCode");
    this.f = false;
    this.g = 0L;
    i = ((e)localObject2).getInteger("changeNum").intValue();
    this.e = new ArrayList();
    Object localObject2 = this.d.iterator();
    label394:
    label503:
    label521:
    for (;;)
    {
      if (((Iterator)localObject2).hasNext())
      {
        localMovingVanGoods = (MovingVanGoods)((Iterator)localObject2).next();
        if (localMovingVanGoods.logicCode.equals(localObject1))
        {
          localMovingVanGoods.buyNumber += i;
          if (localMovingVanGoods.buyNumber >= 0) {
            break label503;
          }
          localMovingVanGoods.buyNumber = 0;
        }
      }
      for (;;)
      {
        if (localMovingVanGoods.buyNumber <= 0) {
          break label521;
        }
        this.f = true;
        this.e.add(localMovingVanGoods);
        this.g += localMovingVanGoods.materielUnitPrice * localMovingVanGoods.buyNumber;
        break label394;
        break;
        if (localMovingVanGoods.buyNumber > 99) {
          localMovingVanGoods.buyNumber = 99;
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/d/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */