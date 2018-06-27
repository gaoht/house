package com.ziroom.ziroomcustomer.minsu.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class MsHouseHistoryBean
  implements Comparable<MsHouseHistoryBean>
{
  public String fid;
  public int rentWay;
  @JSONField(serialize=false)
  public long updateTime;
  
  public int compareTo(MsHouseHistoryBean paramMsHouseHistoryBean)
  {
    return (int)(paramMsHouseHistoryBean.updateTime - this.updateTime);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (paramObject == null);
        bool1 = bool2;
      } while (getClass() != paramObject.getClass());
      paramObject = (MsHouseHistoryBean)paramObject;
      bool1 = bool2;
    } while (this.rentWay != ((MsHouseHistoryBean)paramObject).rentWay);
    return this.fid.equals(((MsHouseHistoryBean)paramObject).fid);
  }
  
  public int hashCode()
  {
    return this.fid.hashCode() * 31 + this.rentWay;
  }
  
  public String toString()
  {
    return "MsHouseHistoryBean{updateTime=" + this.updateTime + ", fid='" + this.fid + '\'' + ", rentWay=" + this.rentWay + '}';
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MsHouseHistoryBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */