package com.ziroom.ziroomcustomer.newclean.e;

import com.ziroom.ziroomcustomer.base.b;
import com.ziroom.ziroomcustomer.newclean.d.al;
import com.ziroom.ziroomcustomer.newclean.d.ap;
import com.ziroom.ziroomcustomer.newclean.d.ba;
import java.util.Iterator;
import java.util.List;

public class a
  extends com.ziroom.ziroomcustomer.flux.c
{
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private int i;
  private List<com.ziroom.ziroomcustomer.newclean.d.e> j;
  private String k;
  private String l;
  private ap m;
  
  public a() {}
  
  public a(Object paramObject)
  {
    super(paramObject);
  }
  
  public String getAddress()
  {
    return this.d;
  }
  
  public String getAddressId()
  {
    return this.b;
  }
  
  public List<com.ziroom.ziroomcustomer.newclean.d.e> getBedroomAddressList()
  {
    return this.j;
  }
  
  public String getCityCode()
  {
    return this.l;
  }
  
  public ap getCreateOrderMo()
  {
    return this.m;
  }
  
  public String getHouseCode()
  {
    return this.k;
  }
  
  public String getLinkPhone()
  {
    return this.c;
  }
  
  public String getPromoCodeId()
  {
    return this.g;
  }
  
  public String getPromoContent()
  {
    return this.h;
  }
  
  public int getPromoPrice()
  {
    return this.i;
  }
  
  public String getRemark()
  {
    return this.f;
  }
  
  public String getShowremark()
  {
    return this.e;
  }
  
  public void onAction(com.ziroom.ziroomcustomer.flux.a parama)
  {
    int i1 = 0;
    Object localObject = parama.getType();
    switch (((String)localObject).hashCode())
    {
    default: 
      label72:
      n = -1;
    }
    for (;;)
    {
      switch (n)
      {
      default: 
        a(new com.ziroom.ziroomcustomer.flux.a.a(parama.getType()));
        return;
        if (!((String)localObject).equals("clean_get_bedroom_address")) {
          break label72;
        }
        n = 0;
        continue;
        if (!((String)localObject).equals("clean_set_address_info")) {
          break label72;
        }
        n = 1;
        continue;
        if (!((String)localObject).equals("clean_set_special_info")) {
          break label72;
        }
        n = 2;
        continue;
        if (!((String)localObject).equals("clean_set_coupon_info")) {
          break label72;
        }
        n = 3;
        continue;
        if (!((String)localObject).equals("clean_create_order")) {
          break label72;
        }
        n = 4;
        continue;
        if (!((String)localObject).equals("clean_recommond_coupon")) {
          break label72;
        }
        n = 5;
      }
    }
    this.j = ((List)parama.getData());
    localObject = this.j.iterator();
    int n = i1;
    label242:
    com.ziroom.ziroomcustomer.newclean.d.e locale;
    if (((Iterator)localObject).hasNext())
    {
      locale = (com.ziroom.ziroomcustomer.newclean.d.e)((Iterator)localObject).next();
      if (!b.d.equals(locale.getCityCode())) {
        break label817;
      }
      n = 1;
    }
    label817:
    for (;;)
    {
      break label242;
      if (n != 0)
      {
        localObject = this.j.iterator();
        while (((Iterator)localObject).hasNext())
        {
          locale = (com.ziroom.ziroomcustomer.newclean.d.e)((Iterator)localObject).next();
          if (locale.getIsSuggest() == 1)
          {
            this.b = locale.getAddressId();
            this.c = locale.getLinkPhone();
            this.d = (locale.getVillage() + locale.getDetAddress());
            this.k = locale.getHouseCode();
            this.l = locale.getCityCode();
          }
        }
      }
      this.b = "";
      this.c = "";
      this.d = "";
      this.k = "";
      this.l = "";
      break;
      localObject = (com.ziroom.ziroomcustomer.newclean.d.c)parama.getData();
      n = ((com.ziroom.ziroomcustomer.newclean.d.c)localObject).getResultCode();
      if (n == 0)
      {
        this.b = "";
        this.c = "";
        this.d = "";
        this.k = "";
        this.l = "";
        break;
      }
      if (n != -1) {
        break;
      }
      if (((com.ziroom.ziroomcustomer.newclean.d.c)localObject).isHaveData())
      {
        this.b = ((com.ziroom.ziroomcustomer.newclean.d.c)localObject).getAddressId();
        this.c = ((com.ziroom.ziroomcustomer.newclean.d.c)localObject).getLinkPhone();
        this.d = (((com.ziroom.ziroomcustomer.newclean.d.c)localObject).getVillage() + ((com.ziroom.ziroomcustomer.newclean.d.c)localObject).getDetAddress());
        this.k = ((com.ziroom.ziroomcustomer.newclean.d.c)localObject).getHouseCode();
        this.l = ((com.ziroom.ziroomcustomer.newclean.d.c)localObject).getCityCode();
        break;
      }
      this.b = "";
      this.c = "";
      this.d = "";
      this.k = "";
      this.l = "";
      break;
      localObject = (com.alibaba.fastjson.e)parama.getData();
      if (localObject == null) {
        break;
      }
      this.e = ((com.alibaba.fastjson.e)localObject).getString("showremark");
      this.f = ((com.alibaba.fastjson.e)localObject).getString("remark");
      break;
      localObject = (al)parama.getData();
      n = ((al)localObject).getResultCode();
      if (n == -1)
      {
        this.g = ((al)localObject).getPromoId();
        this.h = ("优惠" + (int)((al)localObject).getPromoPrice() + "元");
        this.i = ((int)((al)localObject).getPromoPrice());
        break;
      }
      if (n != 1111) {
        break;
      }
      this.g = "";
      this.h = "";
      this.i = 0;
      break;
      this.m = ((ap)parama.getData());
      break;
      localObject = (ba)parama.getData();
      this.g = ((ba)localObject).getPromoId();
      this.h = ("优惠" + (int)((ba)localObject).getPromoPrice() + "元");
      this.i = ((int)((ba)localObject).getPromoPrice());
      break;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */