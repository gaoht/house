package com.ziroom.ziroomcustomer.minsu.bean;

import java.io.Serializable;
import java.util.List;

public class MinsuHouseCollectBean
  extends MinsuBaseJson
{
  public DataBean data;
  
  public static class DataBean
  {
    public List<RowsBean> rows;
    public int total;
    
    public static class RowsBean
    {
      public Integer evaluateCount;
      public String fid;
      public String houseName;
      public Integer houseStatus;
      public int isTop50Online;
      public List<LabelInfo> labelInfoList;
      public String landlordUid;
      public String landlordUrl;
      public Integer personCount;
      public String picUrl;
      public Integer price;
      public Float realEvaluateScore;
      public Integer rentWay;
      public String rentWayName;
      
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
            return bool1;
            bool1 = bool2;
          } while (!(paramObject instanceof RowsBean));
          paramObject = (RowsBean)paramObject;
          bool1 = bool2;
        } while (this.rentWay != ((RowsBean)paramObject).rentWay);
        return this.fid.equals(((RowsBean)paramObject).fid);
      }
      
      public int hashCode()
      {
        return this.fid.hashCode() * 31 + this.rentWay.intValue();
      }
      
      public class LabelInfo
        implements Serializable
      {
        public String code;
        public String iconUrl;
        public int index;
        public String name;
        
        public LabelInfo() {}
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuHouseCollectBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */