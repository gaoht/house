package com.ziroom.ziroomcustomer.newmovehouse.d;

import com.alibaba.fastjson.e;
import com.ziroom.ziroomcustomer.flux.c;
import com.ziroom.ziroomcustomer.newmovehouse.model.MovingVanService;
import com.ziroom.ziroomcustomer.newmovehouse.model.MovingVanServiceCategory;
import com.ziroom.ziroomcustomer.newmovehouse.model.MovingVanServiceCategoryDetail;
import com.ziroom.ziroomcustomer.newmovehouse.model.MovingVanServiceItem;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b
  extends c
{
  private String b;
  private int[] c;
  private String d;
  private List<MovingVanServiceCategory> e;
  private List<MovingVanService> f;
  private long g;
  private List<MovingVanServiceCategoryDetail> h;
  private MovingVanService i;
  private List<MovingVanServiceItem> j;
  private int k;
  
  public b() {}
  
  public b(Object paramObject)
  {
    super(paramObject);
  }
  
  public List<MovingVanServiceCategoryDetail> getCategoryDetails()
  {
    return this.h;
  }
  
  public List<MovingVanServiceItem> getEstimateServiceItems()
  {
    return this.j;
  }
  
  public int getItemCount()
  {
    return this.k;
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
  
  public MovingVanService getService()
  {
    return this.i;
  }
  
  public List<MovingVanServiceCategory> getServiceCategories()
  {
    return this.e;
  }
  
  public int[] getServiceCategoryIndex()
  {
    return this.c;
  }
  
  public List<MovingVanService> getServices()
  {
    return this.f;
  }
  
  public String getToken()
  {
    return this.d;
  }
  
  public void onAction(com.ziroom.ziroomcustomer.flux.a parama)
  {
    Object localObject1 = parama.getType();
    int m = -1;
    switch (((String)localObject1).hashCode())
    {
    default: 
      switch (m)
      {
      }
      label95:
      break;
    }
    for (;;)
    {
      a(new com.ziroom.ziroomcustomer.flux.a.a(parama.getType()));
      return;
      if (!((String)localObject1).equals("service_mv_van_bulky_init")) {
        break;
      }
      m = 0;
      break;
      if (!((String)localObject1).equals("service_mv_van_bulky_update")) {
        break;
      }
      m = 1;
      break;
      if (!((String)localObject1).equals("service_mv_van_bulky_item_init")) {
        break;
      }
      m = 2;
      break;
      if (!((String)localObject1).equals("service_mv_van_bulky_item_update")) {
        break;
      }
      m = 3;
      break;
      if (!((String)localObject1).equals("service_mv_van_bulky_submit")) {
        break;
      }
      m = 4;
      break;
      localObject1 = (e)parama.getData();
      if (localObject1 != null)
      {
        Object localObject3 = (List)((e)localObject1).get("services");
        this.b = ((e)localObject1).getString("productCode");
        this.d = ((e)localObject1).getString("token");
        localObject1 = (List)((e)localObject1).get("servicesSelected");
        Object localObject2 = new ArrayList();
        Object localObject4;
        Object localObject5;
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject4 = ((List)localObject1).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (MovingVanService)((Iterator)localObject4).next();
            if ((((MovingVanService)localObject5).getChildrenItemlist() != null) && (((MovingVanService)localObject5).getChildrenItemlist().size() > 0))
            {
              localObject5 = ((MovingVanService)localObject5).getChildrenItemlist().iterator();
              while (((Iterator)localObject5).hasNext())
              {
                MovingVanServiceItem localMovingVanServiceItem = (MovingVanServiceItem)((Iterator)localObject5).next();
                if (localMovingVanServiceItem.getBuyNumber() > 0) {
                  ((List)localObject2).add(localMovingVanServiceItem);
                }
              }
            }
          }
        }
        if (localObject3 != null)
        {
          this.c = new int[((List)localObject3).size()];
          this.h = new ArrayList();
          this.f = new ArrayList();
          m = 0;
          if (m < ((List)localObject3).size())
          {
            localObject4 = (MovingVanServiceCategory)((List)localObject3).get(m);
            this.h.add(((MovingVanServiceCategory)localObject4).getItem());
            if (((MovingVanServiceCategory)localObject4).getChildrenItemlist() != null)
            {
              this.c[m] = ((MovingVanServiceCategory)localObject4).getChildrenItemlist().size();
              this.f.addAll(((MovingVanServiceCategory)localObject4).getChildrenItemlist());
            }
            for (;;)
            {
              m += 1;
              break;
              this.c[m] = 0;
            }
          }
          if ((localObject2 != null) && (((List)localObject2).size() > 0) && (this.f != null) && (this.f.size() > 0))
          {
            if (this.j == null) {
              this.j = new ArrayList();
            }
            this.g = 0L;
            localObject3 = this.f.iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = ((MovingVanService)((Iterator)localObject3).next()).getChildrenItemlist();
              if ((localObject4 != null) && (((List)localObject4).size() > 0))
              {
                localObject4 = ((List)localObject4).iterator();
                while (((Iterator)localObject4).hasNext())
                {
                  localObject5 = (MovingVanServiceItem)((Iterator)localObject4).next();
                  m = ((List)localObject2).indexOf(localObject5);
                  if (m >= 0)
                  {
                    ((MovingVanServiceItem)localObject5).setBuyNumber(((MovingVanServiceItem)((List)localObject2).get(m)).getBuyNumber());
                    this.j.add(localObject5);
                    this.g += ((MovingVanServiceItem)localObject5).getServicePrice() * ((MovingVanServiceItem)localObject5).getBuyNumber();
                  }
                }
              }
            }
          }
        }
        else
        {
          this.c = null;
          this.h = null;
          this.f = null;
        }
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          m = 0;
          int n;
          while (m < ((List)localObject1).size())
          {
            n = 0;
            while (n < this.f.size())
            {
              if ((((MovingVanService)((List)localObject1).get(m)).getItem().getLogicCode().equals(((MovingVanService)this.f.get(n)).getItem().getLogicCode())) && (((MovingVanService)((List)localObject1).get(m)).getItem().getBuyNumber() > 0)) {
                ((MovingVanService)this.f.get(n)).getItem().setBuyNumber(((MovingVanService)((List)localObject1).get(m)).getItem().getBuyNumber());
              }
              n += 1;
            }
            m += 1;
          }
          localObject2 = (e)parama.getData();
          if (localObject2 != null)
          {
            localObject1 = ((e)localObject2).getString("logicCode");
            int i1 = ((e)localObject2).getInteger("changeNum").intValue();
            this.g = 0L;
            this.j = new ArrayList();
            localObject2 = this.f.iterator();
            do
            {
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localObject3 = (MovingVanService)((Iterator)localObject2).next();
            } while ((((MovingVanService)localObject3).getChildrenItemlist() == null) || (((MovingVanService)localObject3).getChildrenItemlist().size() <= 0));
            localObject4 = ((MovingVanService)localObject3).getChildrenItemlist().iterator();
            label1010:
            if (((Iterator)localObject4).hasNext())
            {
              localObject5 = (MovingVanServiceItem)((Iterator)localObject4).next();
              if (((MovingVanServiceItem)localObject5).getLogicCode().equals(localObject1))
              {
                n = ((MovingVanServiceItem)localObject5).getBuyNumber() + i1;
                if (n >= 0) {
                  break label1129;
                }
                m = 0;
              }
            }
            for (;;)
            {
              ((MovingVanServiceItem)localObject5).setBuyNumber(m);
              ((MovingVanService)localObject3).getItem().setBuyNumber(((MovingVanService)localObject3).getItem().getBuyNumber() + i1);
              if (((MovingVanServiceItem)localObject5).getBuyNumber() <= 0) {
                break label1010;
              }
              this.j.add(localObject5);
              this.g += ((MovingVanServiceItem)localObject5).getServicePrice() * ((MovingVanServiceItem)localObject5).getBuyNumber();
              break label1010;
              break;
              label1129:
              m = n;
              if (n > 99) {
                m = 99;
              }
            }
            localObject1 = (String)parama.getData();
            this.i = null;
            if ((this.f != null) && (this.f.size() > 0))
            {
              localObject2 = this.f.iterator();
              if (((Iterator)localObject2).hasNext())
              {
                localObject3 = (MovingVanService)((Iterator)localObject2).next();
                if (!((MovingVanService)localObject3).getItem().getLogicCode().equals(localObject1)) {
                  break label95;
                }
                this.i = ((MovingVanService)localObject3);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */