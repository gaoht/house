package com.ziroom.ziroomcustomer.minsu.landlordrelease.model.aloneroominfo;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public class AloneRoomBedTypeMsgListBean
  implements Serializable
{
  private int bedType;
  private List<String> bedfids;
  private int maxNum;
  private int num;
  
  public int getBedType()
  {
    return this.bedType;
  }
  
  public List<String> getBedfids()
  {
    return this.bedfids;
  }
  
  public int getMaxNum()
  {
    return this.maxNum;
  }
  
  public int getNum()
  {
    return this.num;
  }
  
  public void setBedType(int paramInt)
  {
    this.bedType = paramInt;
  }
  
  public void setBedfids(List<String> paramList)
  {
    this.bedfids = paramList;
  }
  
  public void setMaxNum(int paramInt)
  {
    this.maxNum = paramInt;
  }
  
  public void setNum(int paramInt)
  {
    this.num = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.bedType).append("_").append(this.num).append("_");
    Iterator localIterator = this.bedfids.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append((String)localIterator.next()).append("|");
    }
    localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/aloneroominfo/AloneRoomBedTypeMsgListBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */