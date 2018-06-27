package com.ziroom.ziroomcustomer.rent.list;

import com.ziroom.ziroomcustomer.model.rent.FilterCondition;
import com.ziroom.ziroomcustomer.model.rent.RentCheckInDateCondition;
import com.ziroom.ziroomcustomer.model.rent.RentConditionItem;
import com.ziroom.ziroomcustomer.model.rent.RentTypeConditionItem;
import java.util.List;

public abstract interface a
{
  public abstract FilterCondition getAllCondition();
  
  public abstract void updateAllCondition();
  
  public abstract void updateFilterCondition();
  
  public abstract void updateLocationCondition();
  
  public abstract void updateOtherCondition();
  
  public abstract void updateSortCondition(RentConditionItem paramRentConditionItem);
  
  public abstract void updateTimeCondition(RentCheckInDateCondition paramRentCheckInDateCondition);
  
  public abstract void updateTypeCondition(List<RentTypeConditionItem> paramList);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/rent/list/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */