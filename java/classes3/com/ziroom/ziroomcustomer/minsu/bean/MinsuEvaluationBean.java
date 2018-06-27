package com.ziroom.ziroomcustomer.minsu.bean;

import java.util.List;

public class MinsuEvaluationBean
  extends MinsuBaseJson
{
  public DataBean data;
  
  public static class DataBean
  {
    public List<EvaListBean> evaList;
    public StatsHouseEvaBean statsHouseEva;
    public String total;
    
    public static class EvaListBean
    {
      public String customerIcon;
      public String customerName;
      public String evalContent;
      public String evalDate;
      public String landlordEvalContent;
    }
    
    public static class StatsHouseEvaBean
    {
      public float costPerforAva;
      public float desMatchAva;
      public float houseCleanAva;
      public float realTotalAvgGrade;
      public float safeDegreeAva;
      public float totalAvgGrade;
      public float trafPosAva;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/bean/MinsuEvaluationBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */