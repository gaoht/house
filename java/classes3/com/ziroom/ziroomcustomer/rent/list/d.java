package com.ziroom.ziroomcustomer.rent.list;

import android.content.Context;
import com.freelxl.baselibrary.d.f.a;
import com.ziroom.ziroomcustomer.e.a.e;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.c.q;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.findhouse.model.HouseListItem;
import com.ziroom.ziroomcustomer.model.rent.FilterCondition;
import com.ziroom.ziroomcustomer.model.rent.RentCheckInDateCondition;
import com.ziroom.ziroomcustomer.model.rent.RentCondition;
import com.ziroom.ziroomcustomer.model.rent.RentConditionItem;
import com.ziroom.ziroomcustomer.model.rent.RentTypeConditionItem;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class d
  implements c.a
{
  WeakReference<c.b> a;
  private RentCondition b;
  private FilterCondition c;
  private String d = "合租/整租";
  private String e = "位置";
  private String f = "入住日期";
  private String g = "筛选";
  private Map<String, String> h = new HashMap();
  private int i = 1;
  private final int j = 10;
  
  public d(c.b paramb)
  {
    this.a = new WeakReference(paramb);
    if (getView() != null) {
      getView().setPresenter(this);
    }
  }
  
  private void a()
  {
    if (this.c != null)
    {
      c.b localb = getView();
      if ((localb != null) && (localb.isActive())) {
        localb.showTypePanel(this.c.getType(), this.c.getType_extra());
      }
    }
  }
  
  private void b()
  {
    if ((getView() != null) && (getView().isActive()))
    {
      Context localContext = getView().getViewContext();
      j.getMapHouseList(localContext, this.h, new e(localContext, new q(HouseListItem.class))
      {
        public void onSuccess(int paramAnonymousInt, HouseListItem paramAnonymousHouseListItem)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousHouseListItem);
          c.b localb = d.this.getView();
          if ((localb != null) && (localb.isActive()))
          {
            if (d.c(d.this) == 1) {
              localb.showList(paramAnonymousHouseListItem);
            }
          }
          else {
            return;
          }
          localb.showAddList(paramAnonymousHouseListItem);
        }
      });
    }
  }
  
  private Map<String, String> c()
  {
    if (this.c == null) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    Object localObject1;
    StringBuilder localStringBuilder;
    Object localObject2;
    if ((this.c.getLeasetype() != null) && (this.c.getLeasetype().size() > 0))
    {
      localObject1 = this.c.getLeasetype();
      localStringBuilder = new StringBuilder();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (RentConditionItem)((Iterator)localObject1).next();
        if (((RentConditionItem)localObject2).isCheck()) {
          localStringBuilder.append(((RentConditionItem)localObject2).getValue() + ",");
        }
      }
      if (localStringBuilder.length() > 0) {
        localHashMap.put("leasetype", localStringBuilder.deleteCharAt(localStringBuilder.length() - 1).toString());
      }
    }
    if ((this.c.getType() != null) && (this.c.getType().size() > 0))
    {
      localObject1 = this.c.getType();
      localStringBuilder = new StringBuilder();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (RentTypeConditionItem)((Iterator)localObject1).next();
        if (((RentTypeConditionItem)localObject2).isCheck()) {
          localStringBuilder.append(((RentTypeConditionItem)localObject2).getValue() + ",");
        }
      }
      if (localStringBuilder.length() > 0) {
        localHashMap.put("type", localStringBuilder.deleteCharAt(localStringBuilder.length() - 1).toString());
      }
    }
    if ((this.c.getSort() != null) && (this.c.getSort().size() > 0))
    {
      localObject1 = this.c.getSort();
      localStringBuilder = new StringBuilder();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (RentConditionItem)((Iterator)localObject1).next();
        if (((RentConditionItem)localObject2).isCheck()) {
          localStringBuilder.append(((RentConditionItem)localObject2).getValue() + ",");
        }
      }
      if (localStringBuilder.length() > 0) {
        localHashMap.put("sort", localStringBuilder.deleteCharAt(localStringBuilder.length() - 1).toString());
      }
    }
    if ((this.c.getTag() != null) && (this.c.getTag().size() > 0))
    {
      localObject1 = this.c.getTag();
      localStringBuilder = new StringBuilder();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (RentConditionItem)((Iterator)localObject1).next();
        if (((RentConditionItem)localObject2).isCheck()) {
          localStringBuilder.append(((RentConditionItem)localObject2).getValue() + ",");
        }
      }
      if (localStringBuilder.length() > 0) {
        localHashMap.put("tag", localStringBuilder.deleteCharAt(localStringBuilder.length() - 1).toString());
      }
    }
    if ((this.c.getAround() != null) && (this.c.getAround().size() > 0))
    {
      localObject1 = this.c.getAround();
      localStringBuilder = new StringBuilder();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (RentConditionItem)((Iterator)localObject1).next();
        if (((RentConditionItem)localObject2).isCheck()) {
          localStringBuilder.append(((RentConditionItem)localObject2).getValue() + ",");
        }
      }
      if (localStringBuilder.length() > 0) {
        localHashMap.put("around", localStringBuilder.deleteCharAt(localStringBuilder.length() - 1).toString());
      }
    }
    localHashMap.put("page", this.i + "");
    localHashMap.put("size", "10");
    this.h = localHashMap;
    return localHashMap;
  }
  
  public void detachView()
  {
    if (this.a != null)
    {
      this.a.clear();
      this.a = null;
    }
  }
  
  public FilterCondition getAllCondition()
  {
    return this.c;
  }
  
  public void getMore()
  {
    if (this.h != null)
    {
      Map localMap = this.h;
      StringBuilder localStringBuilder = new StringBuilder();
      int k = this.i + 1;
      this.i = k;
      localMap.put("page", k + "");
      b();
    }
  }
  
  public c.b getView()
  {
    if (this.a != null) {
      return (c.b)this.a.get();
    }
    return null;
  }
  
  public void initCondition(RentCondition paramRentCondition)
  {
    if (paramRentCondition != null) {
      this.b = paramRentCondition;
    }
    paramRentCondition = new ArrayList();
    paramRentCondition.add(this.d);
    paramRentCondition.add(this.e);
    paramRentCondition.add(this.f);
    paramRentCondition.add(this.g);
    List localList = Arrays.asList(new Boolean[] { Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false) });
    c.b localb = getView();
    if (localb != null)
    {
      getView().showSearchBar(paramRentCondition, localList);
      j.getRoomFilter(localb.getViewContext(), new e(localb.getViewContext(), new q(FilterCondition.class))
      {
        public void onSuccess(int paramAnonymousInt, FilterCondition paramAnonymousFilterCondition)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousFilterCondition);
          c.b localb = d.this.getView();
          if ((localb != null) && (localb.isActive()))
          {
            if (paramAnonymousFilterCondition != null) {
              d.a(d.this, paramAnonymousFilterCondition);
            }
            d.a(d.this);
          }
        }
      });
    }
  }
  
  public void popFilterCondition() {}
  
  public void popLocationCondition() {}
  
  public void popTimeCondition() {}
  
  public void popTypeCondition()
  {
    if (this.c == null)
    {
      c.b localb = getView();
      if ((localb != null) && (localb.isActive())) {
        j.getRoomFilter(localb.getViewContext(), new f(localb.getViewContext(), new q(FilterCondition.class))
        {
          public void onSuccess(int paramAnonymousInt, FilterCondition paramAnonymousFilterCondition)
          {
            super.onSuccess(paramAnonymousInt, paramAnonymousFilterCondition);
            c.b localb = d.this.getView();
            if ((localb != null) && (localb.isActive()) && (paramAnonymousFilterCondition != null))
            {
              d.a(d.this, paramAnonymousFilterCondition);
              d.b(d.this);
            }
          }
        });
      }
      return;
    }
    a();
  }
  
  public void start()
  {
    if ((getView() == null) || (this.c == null)) {
      initCondition(null);
    }
  }
  
  public void updateAllCondition() {}
  
  public void updateFilterCondition() {}
  
  public void updateLocationCondition() {}
  
  public void updateOtherCondition() {}
  
  public void updateSortCondition(RentConditionItem paramRentConditionItem) {}
  
  public void updateTimeCondition(RentCheckInDateCondition paramRentCheckInDateCondition) {}
  
  public void updateTypeCondition(List<RentTypeConditionItem> paramList)
  {
    if (this.c != null) {
      this.c.setType(paramList);
    }
    this.i = 1;
    c();
    b();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/rent/list/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */