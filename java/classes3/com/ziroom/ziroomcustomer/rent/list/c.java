package com.ziroom.ziroomcustomer.rent.list;

import com.ziroom.ziroomcustomer.b;
import com.ziroom.ziroomcustomer.findhouse.model.HouseListItem;
import com.ziroom.ziroomcustomer.model.rent.RentCheckInDateCondition;
import com.ziroom.ziroomcustomer.model.rent.RentCondition;
import com.ziroom.ziroomcustomer.model.rent.RentConditionItem;
import com.ziroom.ziroomcustomer.model.rent.RentTypeConditionItem;
import com.ziroom.ziroomcustomer.model.rent.RentTypeExtraConditionItem;
import java.util.List;

public abstract interface c
{
  public static abstract interface a
    extends com.ziroom.ziroomcustomer.a<c.b>, a
  {
    public abstract void getMore();
    
    public abstract void initCondition(RentCondition paramRentCondition);
    
    public abstract void popFilterCondition();
    
    public abstract void popLocationCondition();
    
    public abstract void popTimeCondition();
    
    public abstract void popTypeCondition();
  }
  
  public static abstract interface b
    extends b<c.a>
  {
    public abstract void showAddList(HouseListItem paramHouseListItem);
    
    public abstract void showFilterPanel(int paramInt, RentConditionItem paramRentConditionItem1, RentConditionItem paramRentConditionItem2, RentConditionItem paramRentConditionItem3, RentConditionItem paramRentConditionItem4, RentConditionItem paramRentConditionItem5, RentConditionItem paramRentConditionItem6, RentConditionItem paramRentConditionItem7);
    
    public abstract void showList(HouseListItem paramHouseListItem);
    
    public abstract void showLocationPanel();
    
    public abstract void showSearchBar(List<String> paramList, List<Boolean> paramList1);
    
    public abstract void showSortPanel(RentConditionItem paramRentConditionItem);
    
    public abstract void showTimePanel(RentCheckInDateCondition paramRentCheckInDateCondition);
    
    public abstract void showTypePanel(List<RentTypeConditionItem> paramList, List<RentTypeExtraConditionItem> paramList1);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/rent/list/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */