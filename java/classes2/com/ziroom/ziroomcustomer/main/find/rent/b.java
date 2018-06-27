package com.ziroom.ziroomcustomer.main.find.rent;

import com.ziroom.ziroomcustomer.model.rent.FilterCondition;
import com.ziroom.ziroomcustomer.model.rent.RentCheckInDateCondition;
import com.ziroom.ziroomcustomer.model.rent.RentConditionItem;
import com.ziroom.ziroomcustomer.model.rent.RentTypeConditionItem;
import java.lang.ref.WeakReference;
import java.util.List;

public class b
  implements a.a
{
  WeakReference<a.b> a;
  
  public b(a.b paramb)
  {
    this.a = new WeakReference(paramb);
    paramb = getView();
    if (paramb != null) {
      paramb.setPresenter(this);
    }
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
    return null;
  }
  
  public a.b getView()
  {
    if (this.a != null) {
      return (a.b)this.a.get();
    }
    return null;
  }
  
  public void start() {}
  
  public void updateAllCondition() {}
  
  public void updateFilterCondition() {}
  
  public void updateLocationCondition() {}
  
  public void updateOtherCondition() {}
  
  public void updateSortCondition(RentConditionItem paramRentConditionItem) {}
  
  public void updateTimeCondition(RentCheckInDateCondition paramRentCheckInDateCondition) {}
  
  public void updateTypeCondition(List<RentTypeConditionItem> paramList) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/main/find/rent/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */