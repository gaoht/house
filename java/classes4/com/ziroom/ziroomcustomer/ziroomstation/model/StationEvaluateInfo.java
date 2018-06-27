package com.ziroom.ziroomcustomer.ziroomstation.model;

import java.util.ArrayList;
import java.util.List;

public class StationEvaluateInfo
{
  public ChildrenLabel childrenLabels;
  public List<ChildrenStar> childrenStars = new ArrayList();
  public String questions_code;
  public String questions_label;
  public String tokenId;
  
  public static class ChildrenLabel
  {
    public String code;
    public String label;
    public List<Options> options = new ArrayList();
    
    public static class Options
    {
      public String code;
      public String desc;
      public boolean isSeclected = false;
    }
  }
  
  public static class ChildrenStar
  {
    public String code;
    public int countStar;
    public String label;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/model/StationEvaluateInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */