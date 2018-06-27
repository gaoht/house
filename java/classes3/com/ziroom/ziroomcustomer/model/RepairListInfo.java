package com.ziroom.ziroomcustomer.model;

import java.io.Serializable;
import java.util.List;

public class RepairListInfo
  implements Serializable
{
  private List<RepairInfo> list;
  private int rows;
  
  public List<RepairInfo> getList()
  {
    return this.list;
  }
  
  public int getRows()
  {
    return this.rows;
  }
  
  public void setList(List<RepairInfo> paramList)
  {
    this.list = paramList;
  }
  
  public void setRows(int paramInt)
  {
    this.rows = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/model/RepairListInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */