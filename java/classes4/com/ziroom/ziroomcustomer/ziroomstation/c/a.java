package com.ziroom.ziroomcustomer.ziroomstation.c;

import android.content.Context;
import android.text.TextUtils;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.ziroomstation.dialog.a.b;
import com.ziroom.ziroomcustomer.ziroomstation.model.DaysPrice;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationOrderCreateHouseEntity;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationOrderCreateUserEntity;
import com.ziroom.ziroomcustomer.ziroomstation.utils.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class a
{
  private List<String> a;
  private List<String> b;
  private List<StationOrderCreateHouseEntity> c;
  private List<StationOrderCreateUserEntity> d;
  private a e;
  private List<DaysPrice> f;
  private int g;
  private int h;
  private Context i;
  
  public a(Context paramContext, List<String> paramList, List<StationOrderCreateHouseEntity> paramList1, a parama, List<DaysPrice> paramList2)
  {
    this.i = paramContext;
    a(paramList, paramList1, paramList2);
    this.e = parama;
  }
  
  private void a(List<String> paramList, List<StationOrderCreateHouseEntity> paramList1, List<DaysPrice> paramList2)
  {
    this.a = new ArrayList();
    this.a.add("男");
    this.a.add("女");
    this.b = paramList;
    if ((this.b == null) || (this.b.size() == 0))
    {
      this.b = new ArrayList();
      this.b.add("身份证");
      this.b.add("护照");
    }
    this.f = paramList2;
    this.c = paramList1;
    this.d = new ArrayList();
  }
  
  public void addOtherUser()
  {
    int j = 0;
    while (j < this.c.size())
    {
      if (((StationOrderCreateHouseEntity)this.c.get(j)).getUsedSize() < ((StationOrderCreateHouseEntity)this.c.get(j)).getSize())
      {
        this.d.add(new StationOrderCreateUserEntity("", "", "", "", ((StationOrderCreateHouseEntity)this.c.get(j)).getName(), ((StationOrderCreateHouseEntity)this.c.get(j)).getHouseTypeId()));
        ((StationOrderCreateHouseEntity)this.c.get(j)).setUsedSize(((StationOrderCreateHouseEntity)this.c.get(j)).getUsedSize() + 1);
        return;
      }
      j += 1;
    }
    af.showToast(ApplicationEx.c, "增加入住人数后方可继续添加入住人信息");
  }
  
  public void addRefreshListener(a parama)
  {
    this.e = parama;
  }
  
  public boolean checkIdentityCard()
  {
    int j = 0;
    while (j < this.d.size())
    {
      if ((((StationOrderCreateUserEntity)this.d.get(j)).getCredentialsStyle().contains("身份")) && (!TextUtils.isEmpty(e.IDCardValidate(((StationOrderCreateUserEntity)this.d.get(j)).getCredentials()))))
      {
        af.showToast(this.i, "身份证号格式错误，请核实后重新填写");
        return false;
      }
      j += 1;
    }
    return true;
  }
  
  public void clearCouponPrice()
  {
    this.h = 0;
  }
  
  public int getCouponPrice()
  {
    return this.h;
  }
  
  public List<DaysPrice> getDaysPriceList()
  {
    return this.f;
  }
  
  public int getTotalPrice()
  {
    this.g = 0;
    int j = 0;
    while (j < this.c.size())
    {
      int k = this.g;
      this.g = (((StationOrderCreateHouseEntity)this.c.get(j)).getPrice() + k);
      j += 1;
    }
    return this.g;
  }
  
  public List<StationOrderCreateHouseEntity> getmHouseLt()
  {
    return this.c;
  }
  
  public a getmInterface()
  {
    return this.e;
  }
  
  public List<StationOrderCreateUserEntity> getmUserLt()
  {
    return this.d;
  }
  
  public void setCouponPrice(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void showPickerDialog(final int paramInt1, final int paramInt2, final boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    String str;
    switch (paramInt1)
    {
    default: 
      str = "选择器";
    }
    for (;;)
    {
      new com.ziroom.ziroomcustomer.ziroomstation.dialog.a(this.i, str, new a.b()
      {
        public void callBack(HashMap<Integer, String> paramAnonymousHashMap)
        {
          int j = 0;
          if ((paramAnonymousHashMap.size() < 1) || (TextUtils.isEmpty((CharSequence)paramAnonymousHashMap.get(Integer.valueOf(0))))) {
            return;
          }
          if (paramBoolean) {
            switch (paramInt1)
            {
            }
          }
          label536:
          for (;;)
          {
            a.c(a.this).refresh();
            return;
            ((StationOrderCreateUserEntity)a.a(a.this).get(paramInt2)).setSex((String)paramAnonymousHashMap.get(Integer.valueOf(0)));
            continue;
            ((StationOrderCreateUserEntity)a.a(a.this).get(paramInt2)).setCredentialsStyle((String)paramAnonymousHashMap.get(Integer.valueOf(0)));
            continue;
            paramAnonymousHashMap = (String)paramAnonymousHashMap.get(Integer.valueOf(0));
            if (!paramAnonymousHashMap.equals(((StationOrderCreateUserEntity)a.a(a.this).get(paramInt2)).getHouseType()))
            {
              int i = 0;
              for (;;)
              {
                if (i >= a.b(a.this).size()) {
                  break label536;
                }
                if (paramAnonymousHashMap.equals(((StationOrderCreateHouseEntity)a.b(a.this).get(i)).getName()))
                {
                  if (((StationOrderCreateHouseEntity)a.b(a.this).get(i)).getUsedSize() < ((StationOrderCreateHouseEntity)a.b(a.this).get(i)).getSize())
                  {
                    if (!TextUtils.isEmpty(((StationOrderCreateUserEntity)a.a(a.this).get(paramInt2)).getHouseType())) {}
                    for (;;)
                    {
                      if (j < a.b(a.this).size())
                      {
                        if (((StationOrderCreateUserEntity)a.a(a.this).get(paramInt2)).getHouseType().equals(((StationOrderCreateHouseEntity)a.b(a.this).get(j)).getName())) {
                          ((StationOrderCreateHouseEntity)a.b(a.this).get(j)).setUsedSize(((StationOrderCreateHouseEntity)a.b(a.this).get(j)).getUsedSize() - 1);
                        }
                      }
                      else
                      {
                        ((StationOrderCreateUserEntity)a.a(a.this).get(paramInt2)).setHouseType(paramAnonymousHashMap);
                        ((StationOrderCreateUserEntity)a.a(a.this).get(paramInt2)).setHouseTypeBid(((StationOrderCreateHouseEntity)a.b(a.this).get(i)).getHouseTypeId());
                        ((StationOrderCreateHouseEntity)a.b(a.this).get(i)).setUsedSize(((StationOrderCreateHouseEntity)a.b(a.this).get(i)).getUsedSize() + 1);
                        break;
                      }
                      j += 1;
                    }
                  }
                  af.showToast(ApplicationEx.c, "增加此房型入住人数后方可继续添加入住人信息");
                  break;
                }
                i += 1;
              }
            }
          }
        }
      }, new List[] { localArrayList }).show();
      return;
      str = "请选择性别";
      localArrayList.addAll(this.a);
      continue;
      str = "请选择证件类型";
      localArrayList.addAll(this.b);
      continue;
      int j = 0;
      while (j < this.c.size())
      {
        localArrayList.add(((StationOrderCreateHouseEntity)this.c.get(j)).getName());
        j += 1;
      }
      str = "请选择房型";
    }
  }
  
  public static abstract interface a
  {
    public abstract void refresh();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */