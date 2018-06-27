package com.ziroom.ziroomcustomer.newmovehouse.d;

import android.text.TextUtils;
import com.ziroom.ziroomcustomer.flux.c;
import com.ziroom.ziroomcustomer.newclean.d.ba;
import com.ziroom.ziroomcustomer.newmovehouse.model.Address;
import com.ziroom.ziroomcustomer.newmovehouse.model.EstimateItem;
import com.ziroom.ziroomcustomer.newmovehouse.model.MovingVanGoods;
import com.ziroom.ziroomcustomer.newmovehouse.model.MovingVanGoodsNum;
import com.ziroom.ziroomcustomer.newmovehouse.model.MovingVanService;
import com.ziroom.ziroomcustomer.newmovehouse.model.MovingVanServiceItem;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class e
  extends c
{
  private List<MovingVanService> A;
  private Address B;
  private Address C;
  private String D;
  private String b;
  private String c;
  private String d;
  private long e;
  private long f;
  private boolean g;
  private Address h;
  private Address i;
  private Address j;
  private Address k;
  private List<MovingVanServiceItem> l;
  private String m;
  private List<MovingVanGoods> n;
  private String o;
  private float p;
  private String q;
  private String r;
  private String s;
  private String t;
  private com.alibaba.fastjson.e u;
  private List<EstimateItem> v;
  private String w;
  private ba x;
  private com.alibaba.fastjson.e y;
  private MovingVanGoodsNum z;
  
  public e() {}
  
  public e(Object paramObject)
  {
    super(paramObject);
  }
  
  public com.alibaba.fastjson.e getAddFloors()
  {
    return this.y;
  }
  
  public long getAppointmentDate()
  {
    return this.e;
  }
  
  public long getAppointmentTime()
  {
    return this.f;
  }
  
  public String getBulkyText()
  {
    return this.m;
  }
  
  public String getCouponsText()
  {
    if (this.p > 0.0F) {
      return "优惠" + (int)this.p + "元";
    }
    return "";
  }
  
  public String getDateTimeText()
  {
    if (TextUtils.isEmpty(this.D))
    {
      if ((this.e > 0L) && (this.f > 0L)) {
        return new SimpleDateFormat("MM月dd日（E） HH:mm").format(new Date(this.f));
      }
    }
    else if ((this.e > 0L) && (this.f > 0L))
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MM月dd日（E）");
      return localSimpleDateFormat.format(new Date(this.f)) + " " + this.D;
    }
    return "";
  }
  
  public com.alibaba.fastjson.e getEstimateCost()
  {
    return this.u;
  }
  
  public List<EstimateItem> getEstimateList()
  {
    if (this.u != null)
    {
      NumberFormat localNumberFormat = NumberFormat.getNumberInstance();
      localNumberFormat.setMaximumFractionDigits(2);
      localNumberFormat.setMinimumFractionDigits(2);
      this.v = new ArrayList();
      if (this.u.getLong("defaultAmount").longValue() > 0L) {
        this.v.add(new EstimateItem("基础价格（含" + this.u.getInteger("defaultDistance") + "公里）", localNumberFormat.format(this.u.getLong("defaultAmount").longValue() / 100.0D) + "元"));
      }
      if (this.u.getLong("overstepDistanceAmount").longValue() > 0L) {
        this.v.add(new EstimateItem("超出里程费（" + this.u.getInteger("overstepDistance") + "公里）", localNumberFormat.format(this.u.getLong("overstepDistanceAmount").longValue() / 100.0D) + "元"));
      }
      if ((this.u.getInteger("nightServiceAmount") != null) && (this.u.getInteger("nightServiceAmount").intValue() > 0)) {
        this.v.add(new EstimateItem("夜间服务费", localNumberFormat.format(this.u.getInteger("nightServiceAmount").intValue() / 100.0D) + "元"));
      }
      if (this.u.getLong("moveOutFloorsAmount").longValue() > 0L) {
        this.v.add(new EstimateItem("搬出楼层费", localNumberFormat.format(this.u.getLong("moveOutFloorsAmount").longValue() / 100.0D) + "元"));
      }
      if (this.u.getLong("moveInFloorsAmount").longValue() > 0L) {
        this.v.add(new EstimateItem("搬入楼层费", localNumberFormat.format(this.u.getLong("moveInFloorsAmount").longValue() / 100.0D) + "元"));
      }
      if (this.u.getLong("outPlaneDistanceAmount").longValue() > 0L) {
        this.v.add(new EstimateItem("搬出平面距离搬运费", localNumberFormat.format(this.u.getLong("outPlaneDistanceAmount").longValue() / 100.0D) + "元"));
      }
      if (this.u.getLong("inPlaneDistanceAmount").longValue() > 0L) {
        this.v.add(new EstimateItem("搬入平面距离搬运费", localNumberFormat.format(this.u.getLong("inPlaneDistanceAmount").longValue() / 100.0D) + "元"));
      }
      if (this.u.getLong("serviceItemAmount").longValue() > 0L) {
        this.v.add(new EstimateItem("服务项总费用", localNumberFormat.format(this.u.getLong("serviceItemAmount").longValue() / 100.0D) + "元"));
      }
      if (this.u.getLong("materialsAmount").longValue() > 0L) {
        this.v.add(new EstimateItem("物品总费用", localNumberFormat.format(this.u.getLong("materialsAmount").longValue() / 100.0D) + "元"));
      }
      if (this.u.getLong("couponAmount").longValue() > 0L) {
        this.v.add(new EstimateItem("优惠券总金额", "-" + localNumberFormat.format(this.u.getLong("couponAmount").longValue() / 100.0D) + "元"));
      }
    }
    return this.v;
  }
  
  public List<MovingVanGoods> getGoods()
  {
    return this.n;
  }
  
  public String getGoodsText()
  {
    return this.o;
  }
  
  public Address getInAddress()
  {
    return this.i;
  }
  
  public Address getInAddressContract()
  {
    return this.k;
  }
  
  public Address getInKeepAddress()
  {
    return this.C;
  }
  
  public ba getModeCoupon()
  {
    return this.x;
  }
  
  public MovingVanGoodsNum getMovingVanGoodsNum()
  {
    return this.z;
  }
  
  public String getMvStartTime()
  {
    if ((this.e > 0L) && (this.f > 0L)) {
      return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date(this.f));
    }
    return "";
  }
  
  public String getMvToken()
  {
    return this.d;
  }
  
  public String getOrderCode()
  {
    return this.w;
  }
  
  public Address getOutAddress()
  {
    return this.h;
  }
  
  public Address getOutAddressContract()
  {
    return this.j;
  }
  
  public Address getOutKeepAddress()
  {
    return this.B;
  }
  
  public String getPhone()
  {
    return this.t;
  }
  
  public String getProductCategoryCode()
  {
    return this.c;
  }
  
  public String getProductCode()
  {
    return this.b;
  }
  
  public String getRequirement()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(this.q)) {
      localStringBuilder.append(this.q.replace(",", " "));
    }
    if (!TextUtils.isEmpty(this.s))
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(this.s);
    }
    return localStringBuilder.toString();
  }
  
  public String getRequirementMsg()
  {
    return this.s;
  }
  
  public String getRequirementTag()
  {
    return this.q;
  }
  
  public com.alibaba.fastjson.e getRequirementTags()
  {
    com.alibaba.fastjson.e locale1 = new com.alibaba.fastjson.e();
    if ((!TextUtils.isEmpty(this.q)) && (!TextUtils.isEmpty(this.r)))
    {
      String[] arrayOfString1 = this.q.split(",");
      String[] arrayOfString2 = this.r.split(",");
      if (arrayOfString1.length != arrayOfString2.length) {
        return null;
      }
      com.alibaba.fastjson.e locale2 = new com.alibaba.fastjson.e();
      int i1 = 0;
      while (i1 < arrayOfString1.length)
      {
        locale2.put(arrayOfString2[i1], arrayOfString1[i1]);
        i1 += 1;
      }
      locale1.put("specialNeedTag", locale2);
    }
    locale1.put("userMessage", this.s);
    return locale1;
  }
  
  public List<MovingVanServiceItem> getServices()
  {
    return this.l;
  }
  
  public String getTotalPriceText()
  {
    return "¥ " + getTotalPriceTextWithoutIcon();
  }
  
  public String getTotalPriceTextWithoutIcon()
  {
    NumberFormat localNumberFormat = NumberFormat.getNumberInstance();
    localNumberFormat.setMaximumFractionDigits(2);
    localNumberFormat.setMinimumFractionDigits(2);
    if ((this.u != null) && (this.u.containsKey("actualAllAmount"))) {
      return localNumberFormat.format(this.u.getLong("actualAllAmount").longValue() / 100.0D);
    }
    return localNumberFormat.format(0L);
  }
  
  public List<MovingVanService> getVanServices()
  {
    return this.A;
  }
  
  public boolean isCanSubmit()
  {
    return (this.e > 0L) && (this.f > 0L) && (this.g);
  }
  
  public boolean isHasUpdateAddToServer()
  {
    return this.g;
  }
  
  public void onAction(com.ziroom.ziroomcustomer.flux.a parama)
  {
    Object localObject1 = parama.getType();
    int i1 = -1;
    switch (((String)localObject1).hashCode())
    {
    default: 
      switch (i1)
      {
      }
      break;
    }
    for (;;)
    {
      a(new com.ziroom.ziroomcustomer.flux.a.a(parama.getType()));
      return;
      if (!((String)localObject1).equals("service_mv_van_init")) {
        break;
      }
      i1 = 0;
      break;
      if (!((String)localObject1).equals("service_mv_van_update_time")) {
        break;
      }
      i1 = 1;
      break;
      if (!((String)localObject1).equals("service_mv_van_update_add")) {
        break;
      }
      i1 = 2;
      break;
      if (!((String)localObject1).equals("service_mv_van_update_out_add")) {
        break;
      }
      i1 = 3;
      break;
      if (!((String)localObject1).equals("service_mv_van_update_in_add")) {
        break;
      }
      i1 = 4;
      break;
      if (!((String)localObject1).equals("service_mv_van_update_service")) {
        break;
      }
      i1 = 5;
      break;
      if (!((String)localObject1).equals("service_mv_van_update_goods")) {
        break;
      }
      i1 = 6;
      break;
      if (!((String)localObject1).equals("service_mv_van_update_coupons")) {
        break;
      }
      i1 = 7;
      break;
      if (!((String)localObject1).equals("service_mv_van_update_requirement")) {
        break;
      }
      i1 = 8;
      break;
      if (!((String)localObject1).equals("service_mv_van_update_phone")) {
        break;
      }
      i1 = 9;
      break;
      if (!((String)localObject1).equals("service_mv_van_get_estimate_cost")) {
        break;
      }
      i1 = 10;
      break;
      if (!((String)localObject1).equals("service_mv_van_submit")) {
        break;
      }
      i1 = 11;
      break;
      if (!((String)localObject1).equals("service_mv_van_get_mode_coupon")) {
        break;
      }
      i1 = 12;
      break;
      if (!((String)localObject1).equals("service_mv_van_update_address_floor")) {
        break;
      }
      i1 = 13;
      break;
      if (!((String)localObject1).equals("service_mv_van_get_goods_num")) {
        break;
      }
      i1 = 14;
      break;
      localObject1 = (com.alibaba.fastjson.e)parama.getData();
      if (localObject1 != null)
      {
        this.b = ((com.alibaba.fastjson.e)localObject1).getString("productCode");
        this.d = ((com.alibaba.fastjson.e)localObject1).getString("mvToken");
        this.c = ((com.alibaba.fastjson.e)localObject1).getString("productCategoryCode");
        this.j = ((Address)((com.alibaba.fastjson.e)localObject1).get("outAddress"));
        this.k = ((Address)((com.alibaba.fastjson.e)localObject1).get("inAddress"));
        this.B = ((Address)((com.alibaba.fastjson.e)localObject1).get("outKeepAddress"));
        this.C = ((Address)((com.alibaba.fastjson.e)localObject1).get("inKeepAddress"));
        continue;
        localObject1 = (com.alibaba.fastjson.e)parama.getData();
        this.e = ((com.alibaba.fastjson.e)localObject1).getLong("date").longValue();
        this.f = ((com.alibaba.fastjson.e)localObject1).getLong("time").longValue();
        this.D = ((com.alibaba.fastjson.e)localObject1).getString("showTime");
        continue;
        this.g = true;
        continue;
        this.g = false;
        this.h = ((Address)parama.getData());
        continue;
        this.g = false;
        this.i = ((Address)parama.getData());
        continue;
        this.A = ((List)parama.getData());
        localObject1 = new ArrayList();
        Object localObject2;
        Object localObject3;
        if ((this.A != null) && (this.A.size() > 0))
        {
          localObject2 = this.A.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (MovingVanService)((Iterator)localObject2).next();
            if ((((MovingVanService)localObject3).getChildrenItemlist() != null) && (((MovingVanService)localObject3).getChildrenItemlist().size() > 0))
            {
              localObject3 = ((MovingVanService)localObject3).getChildrenItemlist().iterator();
              while (((Iterator)localObject3).hasNext())
              {
                MovingVanServiceItem localMovingVanServiceItem = (MovingVanServiceItem)((Iterator)localObject3).next();
                if (localMovingVanServiceItem.getBuyNumber() > 0) {
                  ((List)localObject1).add(localMovingVanServiceItem);
                }
              }
            }
          }
        }
        if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
        {
          localObject2 = new StringBuilder();
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (MovingVanServiceItem)((Iterator)localObject1).next();
            if (((MovingVanServiceItem)localObject3).buyNumber > 0)
            {
              ((StringBuilder)localObject2).append("、");
              ((StringBuilder)localObject2).append(((MovingVanServiceItem)localObject3).getServiceName());
            }
          }
          if (((StringBuilder)localObject2).length() > 1) {
            this.m = ((StringBuilder)localObject2).substring(1);
          } else {
            this.m = "";
          }
        }
        else
        {
          this.m = "";
          continue;
          this.n = ((List)parama.getData());
          if ((this.n != null) && (!this.n.isEmpty()))
          {
            localObject1 = new StringBuilder();
            localObject2 = this.n.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (MovingVanGoods)((Iterator)localObject2).next();
              if (((MovingVanGoods)localObject3).buyNumber > 0)
              {
                ((StringBuilder)localObject1).append("、");
                ((StringBuilder)localObject1).append(((MovingVanGoods)localObject3).materielName);
                ((StringBuilder)localObject1).append("x");
                ((StringBuilder)localObject1).append(((MovingVanGoods)localObject3).buyNumber);
              }
            }
            if (((StringBuilder)localObject1).length() > 1) {
              this.o = ((StringBuilder)localObject1).substring(1);
            } else {
              this.o = "";
            }
          }
          else
          {
            this.o = "";
            continue;
            if (parama.getData() != null)
            {
              this.p = ((Float)parama.getData()).floatValue();
            }
            else
            {
              this.p = 0.0F;
              continue;
              localObject1 = (com.alibaba.fastjson.e)parama.getData();
              this.q = ((com.alibaba.fastjson.e)localObject1).getString("tag");
              this.r = ((com.alibaba.fastjson.e)localObject1).getString("tagIds");
              this.s = ((com.alibaba.fastjson.e)localObject1).getString("msg");
              continue;
              this.t = ((String)parama.getData());
              continue;
              this.u = ((com.alibaba.fastjson.e)parama.getData());
              continue;
              this.w = ((String)parama.getData());
              continue;
              this.x = ((ba)parama.getData());
              continue;
              this.y = ((com.alibaba.fastjson.e)parama.getData());
              i1 = this.y.getInteger("isStart").intValue();
              if (i1 == 1)
              {
                this.h = ((Address)this.y.get("address"));
              }
              else if (i1 == 2)
              {
                this.i = ((Address)this.y.get("address"));
                continue;
                this.z = ((MovingVanGoodsNum)parama.getData());
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/d/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */