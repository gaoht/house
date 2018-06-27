package com.ziroom.ziroomcustomer.minsu.landlordrelease.model;

import java.util.ArrayList;
import java.util.HashMap;

public class LLCalendarEditData
{
  private HashMap<String, LLCalendarDayInfoBean> selectData;
  private ArrayList<String> selectDatesStr;
  
  public LLCalendarEditData(ArrayList<String> paramArrayList, HashMap<String, LLCalendarDayInfoBean> paramHashMap)
  {
    this.selectDatesStr = paramArrayList;
    this.selectData = paramHashMap;
  }
  
  public HashMap<String, LLCalendarDayInfoBean> getSelectData()
  {
    return this.selectData;
  }
  
  public ArrayList<String> getSelectDatesStr()
  {
    return this.selectDatesStr;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/LLCalendarEditData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */