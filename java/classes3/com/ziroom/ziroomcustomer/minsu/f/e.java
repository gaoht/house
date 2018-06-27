package com.ziroom.ziroomcustomer.minsu.f;

import com.ziroom.ziroomcustomer.minsu.bean.MinsuSearchHistoryBean;
import java.util.Comparator;

class e
  implements Comparator
{
  public int compare(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (MinsuSearchHistoryBean)paramObject1;
    paramObject2 = (MinsuSearchHistoryBean)paramObject2;
    if (paramObject2 == null) {
      return 1;
    }
    return (int)(((MinsuSearchHistoryBean)paramObject2).updateTime - ((MinsuSearchHistoryBean)paramObject1).updateTime);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/f/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */