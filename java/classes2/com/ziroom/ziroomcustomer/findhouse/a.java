package com.ziroom.ziroomcustomer.findhouse;

import java.util.Set;

public class a
{
  public static int getHouseClassify(Set<Integer> paramSet)
  {
    if ((paramSet == null) || (paramSet.size() < 1)) {}
    do
    {
      return 100;
      if ((paramSet.size() == 1) && (paramSet.contains(Integer.valueOf(1)))) {
        return 10;
      }
    } while (paramSet.contains(Integer.valueOf(1)));
    return 20;
  }
  
  public static String getHouseTypeText(Set<Integer> paramSet)
  {
    if ((paramSet == null) || (paramSet.size() < 1)) {
      return "合租/整租";
    }
    if ((paramSet.size() == 1) && (paramSet.contains(Integer.valueOf(1)))) {
      return "合租";
    }
    if (!paramSet.contains(Integer.valueOf(1))) {
      return "整租";
    }
    return "合租/整租";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */