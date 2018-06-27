package com.ziroom.ziroomcustomer.minsu.bean;

public class MsHistorySBean
  implements Comparable<MsHistorySBean>
{
  public String fid;
  public int rentWay;
  public long updateTime;
  
  public int compareTo(MsHistorySBean paramMsHistorySBean)
  {
    return (int)(paramMsHistorySBean.updateTime - this.updateTime);
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
      paramObject = (MsHistorySBean)paramObject;
      bool1 = bool2;
    } while (this.rentWay != ((MsHistorySBean)paramObject).rentWay);
    return this.fid.equals(((MsHistorySBean)paramObject).fid);
  }
  
  public int hashCode()
  {
    return this.fid.hashCode() * 31 + this.rentWay;
  }
  
  public MsHouseHistoryBean toMsHouseHistoryBean()
  {
    MsHouseHistoryBean localMsHouseHistoryBean = new MsHouseHistoryBean();
    localMsHouseHistoryBean.fid = this.fid;
    localMsHouseHistoryBean.rentWay = this.rentWay;
    localMsHouseHistoryBean.updateTime = this.updateTime;
    return localMsHouseHistoryBean;
  }
  
  public String toString()
  {
    return "MsHouseHistoryBean{updateTime=" + this.updateTime + ", fid='" + this.fid + '\'' + ", rentWay=" + this.rentWay + '}';
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MsHistorySBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */